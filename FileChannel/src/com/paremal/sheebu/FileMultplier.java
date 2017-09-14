package com.paremal.sheebu;

import java.io.File;

public class FileMultplier {
	File file;
	int no;

	public FileMultplier(File file, int no) {
		super();
		this.file = file;
		this.no = no;
	}

	void multiply() {
		File[] files = new File[no];
		for (int i = 0; i < no; i++) {
			files[i] = file;

		}
		FileUtility.mergeFiles(files, new File("inputMillion.txt"));
	}
	public static void main(String[] args) {
		long t= System.nanoTime();
		FileMultplier fileMultplier= new FileMultplier(new File("input10000.txt"), 100);
		fileMultplier.multiply();
		System.out.println(System.nanoTime()-t);
	}

}
