package com.paremal.sheebu.spring;

import java.io.File;
import java.io.RandomAccessFile;

import com.paremal.sheebu.ReadingThread;

public class MainAppBeanImpl implements MainAppBean {

	private RandomAccessFile[] writers;
	private RandomAccessFile[] readers;
	private Thread[] threads;
	private long[][] ls;
	private ReadersAndWrites1 readersAndWrites1;
	private FileMergeUtility fileMergeUtility;
	int noOfThread;
	
	
	public MainAppBeanImpl(ReadersAndWrites1 readersAndWrites1) {
		super();
		readersAndWrites1.initSreamsAndSetValuesForDivNumbers();
		this.readersAndWrites1=readersAndWrites1;
		writers=readersAndWrites1.getWriters();
		readers=readersAndWrites1.getReaders();
		ls=readersAndWrites1.getFileDivisionNumbers();
		noOfThread=readersAndWrites1.getNoOfthreads();
		threads=new Thread[noOfThread];
	}

	
	
	/* (non-Javadoc)
	 * @see com.paremal.sheebu.spring.MainAppBean#getFileMergeUtility()
	 */
	@Override
	public FileMergeUtility getFileMergeUtility() {
		return fileMergeUtility;
	}



	/* (non-Javadoc)
	 * @see com.paremal.sheebu.spring.MainAppBean#setFileMergeUtility(com.paremal.sheebu.spring.FileMergeUtility)
	 */
	@Override
	public void setFileMergeUtility(FileMergeUtility fileMergeUtility) {
		this.fileMergeUtility = fileMergeUtility;
	}



	/* (non-Javadoc)
	 * @see com.paremal.sheebu.spring.MainAppBean#getReadersAndWrites1()
	 */
	@Override
	public ReadersAndWrites1 getReadersAndWrites1() {
		return readersAndWrites1;
	}


	/* (non-Javadoc)
	 * @see com.paremal.sheebu.spring.MainAppBean#setReadersAndWrites1(com.paremal.sheebu.spring.ReadersAndWrites1)
	 */
	@Override
	public void setReadersAndWrites1(ReadersAndWrites1 readersAndWrites1) {
		this.readersAndWrites1 = readersAndWrites1;
	}


	/* (non-Javadoc)
	 * @see com.paremal.sheebu.spring.MainAppBean#createThreadsAndStartEachOneNdJoinThem()
	 */
	@Override
	public void createThreadsAndStartEachOneNdJoinThem(){
		
		for(int i=0;i<noOfThread;i++){
			Runnable runnable=new ReadingThread(readers[i], writers[i],ls[i][0],ls[i][1],Integer.toString(i)+ "thread");
			Thread thread =new Thread(runnable);
			threads[i] = new Thread(thread);
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
	}
	/* (non-Javadoc)
	 * @see com.paremal.sheebu.spring.MainAppBean#MergeFilesAndCloseStream()
	 */
	@Override
	public void MergeFilesAndCloseStream(){
		fileMergeUtility.mergeFiles1(readersAndWrites1.getFiles(), new File("result.txt"));
		readersAndWrites1.closeStreams();
	}
}
