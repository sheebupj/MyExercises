
package com.paremal.sheebu.spring;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.paremal.sheebu.FileUtility;

public class FileMergeUtilityImpl implements FileMergeUtility   {
	
	private static final Logger LOG = LoggerFactory
			.getLogger(FileMergeUtilityImpl.class);
//merge files to mergeFile
	private long position=0;
	/* (non-Javadoc)
	 * @see com.paremal.sheebu.spring.FileMergeUtility#mergeFiles(java.io.File[], java.io.File)
	 */
	@Override
	public  void mergeFiles(File[] files, File mergedFile) {
		
		FileWriter fstream = null;
		BufferedWriter out = null;
		try {
			fstream = new FileWriter(mergedFile, true);
			 out = new BufferedWriter(fstream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		long t=System.nanoTime();
		for (File f : files) {
		//	LOG.info("merging: " + f.getName());
			FileInputStream fis;
			try {
				fis = new FileInputStream(f);
				BufferedReader in = new BufferedReader(new InputStreamReader(fis));
 
				String aLine;
				while ((aLine = in.readLine()) != null) {
					out.write(aLine);
					out.newLine();
				}
 
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//IOUtils.closeSilently(out);
		}
		LOG.info("files merged to " +mergedFile.toString());
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		LOG.info(Long.toString(System.nanoTime()-t));
 
	}
	/* (non-Javadoc)
	 * @see com.paremal.sheebu.spring.FileMergeUtility#mergeFiles1(java.io.File[], java.io.File)
	 */
	@Override
	public  void mergeFiles1(File[] files, File mergedFile) {
		
		RandomAccessFile writer = null;
		RandomAccessFile out = null;
		FileChannel writeChannel =null;
		try {
			out = new RandomAccessFile(mergedFile, "rw");
			writeChannel =out.getChannel();
		//	 out = new BufferedWriter(writer);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		long t=System.nanoTime();
		for (File f : files) {
			LOG.info("merging: " + f.getName());
			RandomAccessFile fis;
			try {
				fis = new RandomAccessFile(f,"r");
				//BufferedReader in = new BufferedReader(new InputStreamReader(fis));
				FileChannel readChannel =fis.getChannel();
				readChannel.transferTo(position, fis.length(), writeChannel);
				position += fis.length();
 				readChannel.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//IOUtils.closeSilently(out);
		}
		LOG.info("files merged to " +mergedFile.toString());
		try {
			writeChannel.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		LOG.info(Long.toString((System.nanoTime()-t)));
 
	}

}
