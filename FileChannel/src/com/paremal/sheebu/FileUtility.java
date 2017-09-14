
package com.paremal.sheebu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class FileUtility {
	
//	private static final Logger LOG = LoggerFactory
//			.getLogger(FileUtility.class);
//merge files to mergeFile
	public static void mergeFiles(File[] files, File mergedFile) {
		
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
	//	LOG.info("files merged to " +mergedFile.toString());
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(System.nanoTime()-t);
 
	}

}
