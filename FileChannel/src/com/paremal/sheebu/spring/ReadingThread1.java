package com.paremal.sheebu.spring;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class ReadingThread1 implements Runnable  {
	BufferedReader reader;
	BufferedWriter writer;
	String str;
	long start;
	long end;
	String name;
	long length= end-start;
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(this.name + "starting");
		
		try {
			while(start<end ){
		
				str = reader.readLine();
				writer.write(str);
				start=start+str.length() +2;
				writer.newLine();
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(this.name + "completed");
		IOUtils.closeSilently(writer);
		IOUtils.closeSilently(reader);
		
		
	}


	public ReadingThread1(BufferedReader reader, BufferedWriter writer, long start, long end, String str) {
		super();
		this.reader = reader;
		this.writer = writer;
		this.start = start;
		this.end = end;
		this.name= str;
	}
	


	

}
