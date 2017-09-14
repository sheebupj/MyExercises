
package com.paremal.sheebu;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class ReadWrite {
	
	public static String readLine(FileChannel filechannel) throws IOException{
		//ByteBuffer buf = ByteBuffer.allocate(256);
		ByteBuffer buf= filechannel.map(MapMode.READ_ONLY, 1, 256);
		StringBuilder line=new StringBuilder();
		int isRead =1;
		char ch=' ';
		while( isRead!=-1){
			buf.flip();
			while(buf.hasRemaining()&& ch!='\n' ){
				line.append((char)buf.get());
			}
		}
		return new String(line);
	}

}
