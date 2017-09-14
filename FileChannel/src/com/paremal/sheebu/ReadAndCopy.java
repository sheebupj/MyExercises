package com.paremal.sheebu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.paremal.sheebu.spring.FileMergeUtilityImpl;
import com.paremal.sheebu.spring.ReadersAndWrites1;
import com.paremal.sheebu.spring.ReadersAndWrittersImpl1;

public class ReadAndCopy {

	public static void main(String[] args) {
		long t = System.nanoTime();
		final int noOfThread =16;
		ReadersAndWrites1 readersAndWritters = new ReadersAndWrittersImpl1(noOfThread, "inputMillion.txt", ".");
		try {
			readersAndWritters.getFilePartPositionsAndCreateReadersAndWriters();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RandomAccessFile[] readers =readersAndWritters.getReaders();
		RandomAccessFile[] writers = readersAndWritters.getWriters();
		Thread[] threads= new Thread[noOfThread];
		long[][] ls=readersAndWritters.getFileDivisionNumbers();
		
		for(int i=0;i<noOfThread;i++){
			threads[i] = new Thread(new ReadingThread(readers[i], writers[i],ls[i][0],ls[i][1],Integer.toString(i)+ "thread"));
			threads[i].start();
		}
		
		for(int i=0;i<noOfThread;i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("filcopying completed and filemerging started");
		//file merge utility refactored to instance class
		//FileMergeUtilityImpl.mergeFiles1(readersAndWritters.getFiles(), new File("result.txt"));
		readersAndWritters.closeStreams();
		System.out.println("reading and writting" +(System.nanoTime()-t));
	}
	

}
