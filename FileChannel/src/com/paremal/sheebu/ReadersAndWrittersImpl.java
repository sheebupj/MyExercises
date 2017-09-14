package com.paremal.sheebu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;

import com.paremal.sheebu.spring.FileDivisionNumbersCalc;
import com.paremal.sheebu.spring.FileDivisionNumbersCalcImpl;
import com.paremal.sheebu.spring.IOUtils;
public class ReadersAndWrittersImpl implements ReadersAndWriters {

	private BufferedReader[] reader;
	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWriters#getFiles()
	 */
	@Override
	public File[] getFiles() {
		return files;
	}

	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWriters#setFiles(java.io.File[])
	 */
	@Override
	public void setFiles(File[] files) {
		this.files = files;
	}
	private BufferedWriter[] bufferedWriter;
	private FileOutputStream[] outputStream;
	private FileChannel[] channels;
	private FileChannel[] writeChannels;
	private FileInputStream[] fileInputStream;
	private File[] files;
	private long fileDivisionNumbers[][];
	private int noOfthreads;
	private String fileName;
	private String folderName;
	private FileDivisionNumbersCalc fileDivisionNumbersObj;	

	public ReadersAndWrittersImpl(int noOfthreads, String fileName, String foldeName) {
		super();
		this.noOfthreads = noOfthreads;
		this.fileName = fileName;
		this.folderName = foldeName;
		this.files = new File[noOfthreads];
		for(int i=0;i<noOfthreads;i++){
			files[i] = new File( String.valueOf(i) + "temp.txt");	
		}
	}

	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWriters#getBufferedWriter()
	 */
	@Override
	public BufferedWriter[] getBufferedWriter() {
		return bufferedWriter;
	}

	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWriters#getReader()
	 */
	@Override
	public BufferedReader[] getReader() {
		return reader;
	}

	

	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWriters#getFileDivisionNumbers()
	 */
	@Override
	public long[][] getFileDivisionNumbers() {
		return fileDivisionNumbers;
	}

	private void inItStrams() throws IOException {
		fileDivisionNumbers = fileDivisionNumbersObj.getDivisionNumbers();
		reader = new BufferedReader[noOfthreads];
		bufferedWriter = new BufferedWriter[noOfthreads];
		outputStream = new FileOutputStream[noOfthreads];
		channels = new FileChannel[noOfthreads];
		writeChannels = new FileChannel[noOfthreads];
		fileInputStream = new FileInputStream[noOfthreads];
		

	}

	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWriters#getFilePartPositionsAndCreateReaderAndWriter()
	 */
	@Override
	public void getFilePartPositionsAndCreateReaderAndWriter()
			throws IOException {
		inItStrams();
		for (int i = 0; i < noOfthreads; i++) {
			fileInputStream[i] = new FileInputStream(fileName);
			channels[i] = fileInputStream[i].getChannel();
			channels[i].position(fileDivisionNumbers[i][0]);
			reader[i] = new BufferedReader(new InputStreamReader(
					fileInputStream[i]));
			
			outputStream[i] = new FileOutputStream(files[i], false);
			writeChannels[i] = outputStream[i].getChannel();
			//writeChannels[i].position();
			bufferedWriter[i] = new BufferedWriter(new OutputStreamWriter(
					outputStream[i]));
		}

	}
	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWriters#closeStreams()
	 */
	@Override
	public void closeStreams(){
		for(int i=0;i<noOfthreads;i++){
			IOUtils.closeSilently(reader[i]);
			IOUtils.closeSilently(bufferedWriter[i]);
			IOUtils.closeSilently(channels[i]);
			//IOUtils.closeSilently(writeCha0nnels[i]);
			IOUtils.closeSilently(outputStream[i]);
			IOUtils.closeSilently(fileInputStream[i] );
			}
		
	}

}
