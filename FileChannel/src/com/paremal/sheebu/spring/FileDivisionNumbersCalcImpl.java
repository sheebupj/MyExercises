
package com.paremal.sheebu.spring;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileDivisionNumbersCalcImpl implements FileDivisionNumbersCalc {
	private static char NEWLINE = System.getProperty("line.separator")
			.charAt(0);
//	private static final Logger LOG = LoggerFactory
//			.getLogger(CEPRecordComparator.class);
	private FileChannel fileChannel;
	private File file;
	private FileInputStream fileInputStream;
	private BufferedInputStream bufferedInputStream;
	private String fileName;
	private int noOfThead;
	

	

	/* (non-Javadoc)
	 * @see com.paremal.sheebu.FileDivisionInter#getFileName()
	 */
	@Override
	public String getFileName() {
		return fileName;
	}

	/* (non-Javadoc)
	 * @see com.paremal.sheebu.FileDivisionInter#setFileName(java.lang.String)
	 */
	@Override
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/* (non-Javadoc)
	 * @see com.paremal.sheebu.FileDivisionInter#getNoOfThead()
	 */
	@Override
	public int getNoOfThead() {
		return noOfThead;
	}

	/* (non-Javadoc)
	 * @see com.paremal.sheebu.FileDivisionInter#setNoOfThead(int)
	 */
	@Override
	public void setNoOfThead(int noOfThead) {
		this.noOfThead = noOfThead;
	}

	/* (non-Javadoc)
	 * @see com.paremal.sheebu.FileDivisionInter#getDivisionNumbers()
	 */
	@Override
	public  long[][] getDivisionNumbers()
			throws IOException {
		long[][] startStop = new long[noOfThead][2];
		file = new File(fileName);

		long position = 0;
		startStop[0][0] = 0;
		startStop[startStop.length - 1][1] = file.length();
	//	LOG.info("file length....................................................."
		//				+ file.length());
		long fileDivision = (file.length() / noOfThead);// ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
		for (int i = 0; i < noOfThead - 1; i++) {
			position += fileDivision;
			startStop[i][1] = getNextNewLine(position);

		}
		for (int i = 1; i < noOfThead; i++) {

			startStop[i][0] = startStop[i - 1][1] + 1;

		}
		// fileChannel.close();
		IOUtils.closeSilently(fileInputStream);
		for (int i = 0; i < noOfThead; i++) {
//			LOG.info("...................................#################"
//							+ startStop[i][0] + " : " + startStop[i][1]);
		}
		System.out.println("file division number completed");
		return startStop;
	}

	private  long getNextNewLine(long position) throws IOException {
		//* fileInputStream = new FileInputStream(file); 
		RandomAccessFile accessFile = new RandomAccessFile(file,"rw");
		fileChannel = accessFile.getChannel();
		//*bufferedInputStream = new BufferedInputStream(fileInputStream);
		// ByteBuffer buffer=ByteBuffer.allocate(256);
		fileChannel.position(position);
		long i = 0;
		char c = (char) accessFile.read();
		while (c != NEWLINE) {
			c = (char) accessFile.read();
			i++;
		}
		//*bufferedInputStream.close();
		fileChannel.close();
		//*fileInputStream.close();
		accessFile.close();
	
		return position + i + 1;
	}

	private long getNextNewLine(String fileName, long position)
			throws IOException {
		File file = new File(fileName);
		FileInputStream fileInputStream = new FileInputStream(file);
		FileChannel fileChannel = fileInputStream.getChannel();
		BufferedInputStream bufferedInputStream = new BufferedInputStream(
				fileInputStream);
		ByteBuffer buffer = ByteBuffer.allocate(256);
		fileChannel.position(position);
		int i = 0;
		char c = (char) bufferedInputStream.read();
		while (c != NEWLINE) {
			c = (char) bufferedInputStream.read();
			i++;
		}
		bufferedInputStream.close();
		fileChannel.close();
		fileInputStream.close();

		return position + i + 1;
	}

}
