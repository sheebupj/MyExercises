package com.paremal.sheebu.spring;

public interface MainAppBean {

	FileMergeUtility getFileMergeUtility();

	void setFileMergeUtility(FileMergeUtility fileMergeUtility);

	ReadersAndWrites1 getReadersAndWrites1();

	void setReadersAndWrites1(ReadersAndWrites1 readersAndWrites1);

	void createThreadsAndStartEachOneNdJoinThem();

	void MergeFilesAndCloseStream();

}