package demo.filehandling.additionaltechniques;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class NewIO {

	public static void main(String[] args) {
		demoChannelsAndBuffers("Macbeth.txt", "Macbethcopy.txt");
		demoMappedByteBuffer("Macbethcopy.txt");
	}
	
	public static void demoChannelsAndBuffers(String infilename, String outfilename) {
		
		try {
	        FileInputStream fis = new FileInputStream(infilename);
	        FileChannel inchannel= fis.getChannel();

	        FileOutputStream fos = new FileOutputStream(outfilename);
	        FileChannel outchannel= fos.getChannel();
			
	        // You create a buffer either by calling allocate() or wrap().
	        ByteBuffer buf = ByteBuffer.allocate(512);
			
			while (inchannel.read(buf) >= 0) {
				
				// Prepare buffer for writing.
				buf.flip();
				
				outchannel.write(buf);
				
				// Prepare buffer for reading on next iteration.
				buf.clear();
			}
			
			System.out.println("Finished file copy.");
			
		} catch (IOException ex) {
			System.out.println("IOException: " + ex.getMessage());
		}
	}


	public static void demoMappedByteBuffer(String infilename) {
		
		try {
	        // Create a channel to read from a file.
			FileInputStream fis = new FileInputStream(infilename);
	        FileChannel inchannel = fis.getChannel();

	        // Create a MappedByteBuffer to map the entire file into memory.
	        long len = new File(infilename).length();
	        MappedByteBuffer buf = inchannel.map(FileChannel.MapMode.READ_ONLY, 
	        		                             0,
	        		                             len);

	        // Visit every byte in the file
	        for (int i = 0; i < len; i++) {
	        	byte b = buf.get(i);
	        	System.out.printf("%c", (char)b);
	        }	
			
		} catch (IOException ex) {
			System.out.println("IOException: " + ex.getMessage());
		}
	}
}
