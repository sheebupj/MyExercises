

package com.paremal.sheebu.spring;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
public class ReadersAndWrittersImpl1 implements ReadersAndWrites1  {

	
	private RandomAccessFile[] writers;
	private RandomAccessFile[] readers;
	private File[] files;
	private long fileDivisionNumbers[][];
	private int noOfthreads;
	private String fileName;
	private String folderName;
	private Thread[] threads;
	private FileDivisionNumbersCalc fileDivisionNumbersObj;	
	

	public FileDivisionNumbersCalc getFileDivisionNumbersObj() {
		return fileDivisionNumbersObj;
	}


	public void setFileDivisionNumbersObj(FileDivisionNumbersCalc fileDivisionNumbersObj) {
		this.fileDivisionNumbersObj = fileDivisionNumbersObj;
	}


	public Thread[] getThreads() {
		return threads;
	}


	public void setThreads(Thread[] threads) {
		this.threads = threads;
	}


	public ReadersAndWrittersImpl1(int noOfthreads, String fileName, String foldeName) {
		super();
		this.noOfthreads = noOfthreads;
		this.fileName = fileName;
		this.folderName = foldeName;
		this.files = new File[noOfthreads];
		this.threads= new Thread[noOfthreads];
		for(int i=0;i<noOfthreads;i++){
			files[i] = new File( String.valueOf(i) + "temp.txt");	
		}
		
	}
	public void initSreamsAndSetValuesForDivNumbers(){
		fileDivisionNumbersObj.setFileName(fileName);
		fileDivisionNumbersObj.setNoOfThead(noOfthreads);
		try {
			inItStrams();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWrites1#getWriters()
	 */
	@Override
	public RandomAccessFile[] getWriters() {
		return writers;
	}


	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWrites1#setWriters(java.io.RandomAccessFile[])
	 */
	@Override
	public void setWriters(RandomAccessFile[] writers) {
		this.writers = writers;
	}


	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWrites1#getReaders()
	 */
	@Override
	public RandomAccessFile[] getReaders() {
		return readers;
	}


	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWrites1#setReaders(java.io.RandomAccessFile[])
	 */
	@Override
	public void setReaders(RandomAccessFile[] readers) {
		this.readers = readers;
	}


	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWrites1#getFiles()
	 */
	@Override
	public File[] getFiles() {
		return files;
	}


	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWrites1#setFiles(java.io.File[])
	 */
	@Override
	public void setFiles(File[] files) {
		this.files = files;
	}


	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWrites1#getFileDivisionNumbers()
	 */
	@Override
	public long[][] getFileDivisionNumbers() {
		return fileDivisionNumbers;
	}


	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWrites1#setFileDivisionNumbers(long[][])
	 */
	@Override
	public void setFileDivisionNumbers(long[][] fileDivisionNumbers) {
		this.fileDivisionNumbers = fileDivisionNumbers;
	}


	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWrites1#getNoOfthreads()
	 */
	@Override
	public int getNoOfthreads() {
		return noOfthreads;
	}


	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWrites1#setNoOfthreads(int)
	 */
	@Override
	public void setNoOfthreads(int noOfthreads) {
		this.noOfthreads = noOfthreads;
	}


	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWrites1#getFileName()
	 */
	@Override
	public String getFileName() {
		return fileName;
	}


	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWrites1#setFileName(java.lang.String)
	 */
	@Override
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWrites1#getFolderName()
	 */
	@Override
	public String getFolderName() {
		return folderName;
	}


	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWrites1#setFolderName(java.lang.String)
	 */
	@Override
	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}


	private void inItStrams() throws IOException {
		fileDivisionNumbers = fileDivisionNumbersObj.getDivisionNumbers();
		readers = new RandomAccessFile[noOfthreads];
		writers = new RandomAccessFile[noOfthreads];
		for (int i = 0; i < noOfthreads; i++) {
			readers[i] = new RandomAccessFile(fileName,"r");
			
			writers[i] = new RandomAccessFile(files[i],"rw");
			readers[i].seek(fileDivisionNumbers[i][0]);
		}
		
		
		

	}

	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWrites1#getFilePartPositionsAndCreateReadersAndWriters()
	 */
	@Override
	public void getFilePartPositionsAndCreateReadersAndWriters()
			throws IOException {
		//not using in spring version
		inItStrams();
		for (int i = 0; i < noOfthreads; i++) {
			readers[i] = new RandomAccessFile(fileName,"r");
			
			writers[i] = new RandomAccessFile(files[i],"rw");
			readers[i].seek(fileDivisionNumbers[i][0]);
			//long length=fileDivisionNumbers[i][1]-fileDivisionNumbers[i][0];
			//readers[i].setLength(length);
			
			
		}

	}
	/* (non-Javadoc)
	 * @see com.paremal.sheebu.ReadersAndWrites1#closeStreams()
	 */
	@Override
	public void closeStreams(){
		for(int i=0;i<noOfthreads;i++){
			try {
				readers[i].close();
				writers[i].close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			}
		
	}

}
