package com.paremal.sheebu.spring;

import java.io.IOException;

public interface FileDivisionNumbersCalc {

	String getFileName();

	void setFileName(String fileName);

	int getNoOfThead();

	void setNoOfThead(int noOfThead);

	long[][] getDivisionNumbers() throws IOException;

}