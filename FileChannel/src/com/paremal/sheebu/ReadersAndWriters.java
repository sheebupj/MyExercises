package com.paremal.sheebu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public interface ReadersAndWriters {

	File[] getFiles();

	void setFiles(File[] files);

	BufferedWriter[] getBufferedWriter();

	BufferedReader[] getReader();

	long[][] getFileDivisionNumbers();

	void getFilePartPositionsAndCreateReaderAndWriter() throws IOException;

	void closeStreams();

}