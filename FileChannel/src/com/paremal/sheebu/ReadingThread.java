package com.paremal.sheebu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadingThread implements Runnable  {
	RandomAccessFile reader;
	RandomAccessFile writer;
	String str;
	long start;
	long end;
	String name;
	long length= end-start;
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(this.name + "starting");
		int i=0;
		boolean t=false;
		try {
			while((str = reader.readLine())!=null){
				i++;
				//str = reader.readLine();
				writer.writeBytes(str);
				start=start+str.length() +2;
				writer.writeChar('\n');
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.name + "completed");
		try {
			writer.close();
			reader.close();;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	public ReadingThread(RandomAccessFile reader, RandomAccessFile writer, long start, long end, String str) {
		super();
		this.reader = reader;
		this.writer = writer;
		this.start = start;
		this.end = end;
		this.name= str;
	}
	


	

}
