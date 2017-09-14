package com.paremal.sheebu.spring;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.paremal.sheebu.Employee;

public class ReadAndCopyV2 {
	

	public static void main(String[] args) {
		ApplicationContext context = 
	             new ClassPathXmlApplicationContext("ApplicationContext.xml");
	    long t = System.nanoTime();
		MainAppBean appBean= context.getBean("main", MainAppBean.class);
		appBean.createThreadsAndStartEachOneNdJoinThem();
		appBean.MergeFilesAndCloseStream();
		System.out.println("filcopying completed ");
		System.out.println("reading and writting" +((System.nanoTime()-t)/1000000));
		Employee employee1 = context.getBean("em1", Employee.class);
		Employee employee2 = context.getBean("em2", Employee.class);
		System.out.println(employee1.getName()+", "+employee1.getAddress().getHousename()+ " : " +employee2.getName()+", "+ employee2.getAddress().getHousename());
	}
}
