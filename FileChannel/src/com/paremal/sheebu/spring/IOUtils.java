
package com.paremal.sheebu.spring;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.channels.FileChannel;


/**
 * This class Unconditionally close a stream
 * 
 * 
 * 
 */

public final class IOUtils {

	private IOUtils() {

	}

	public static void closeSilently(OutputStream os) {
		try {
			if (os != null) {
				os.close();
			}
		} catch (IOException ioe) {
			// ignore
		}

	}

	public static void closeSilently(InputStream in) {
		try {
			if (in != null) {
				in.close();
			}
		} catch (IOException ioe) {
			// ignore
		}

	}

	public static void closeSilently(Writer wr) {
		try {
			if (wr != null) {
				wr.close();
			}
		} catch (IOException ioe) {
			// ignore
		}
	}

		public static void closeSilently(FileChannel fileChannel) {
			try {
				if (fileChannel != null) {
					fileChannel.close();
				}
			} catch (IOException ioe) {
				// ignore
			}

	}

	public static void closeSilently(Reader rd) {
		try {
			if (rd != null) {
				rd.close();
			}
		} catch (IOException ioe) {
			// ignore
		}
	}

}
