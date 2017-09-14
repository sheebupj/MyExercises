package com.paremal.sheebu.spring;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public interface ReadersAndWrites1 {

	RandomAccessFile[] getWriters();

	void setWriters(RandomAccessFile[] writers);

	RandomAccessFile[] getReaders();

	void setReaders(RandomAccessFile[] readers);

	File[] getFiles();

	void setFiles(File[] files);

	long[][] getFileDivisionNumbers();

	void setFileDivisionNumbers(long[][] fileDivisionNumbers);

	int getNoOfthreads();

	void setNoOfthreads(int noOfthreads);

	String getFileName();

	void setFileName(String fileName);

	String getFolderName();

	void setFolderName(String folderName);

	void getFilePartPositionsAndCreateReadersAndWriters() throws IOException;
	public void initSreamsAndSetValuesForDivNumbers();

	void closeStreams();
	public Thread[] getThreads();

}