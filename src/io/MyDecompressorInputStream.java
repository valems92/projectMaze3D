package io;

import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {

	private InputStream in;
	private final int SIZE=9;
	
	public MyDecompressorInputStream(InputStream in) {
		super();
		this.in = in;
	}


	@Override
	public int read(byte[] b) throws IOException {
		in.read(b);
		
		byte[] decompressB=new byte[b.length];
		for(int i=0;i<SIZE;i++){ //as is
			decompressB[i]=b[i];
		}
		int indexforcontinue=SIZE;
		int count=0;
		byte bytetowrite=0;
		for(int i=SIZE;i<b.length;i=i+2){
			count=b[i];
			
				if(count!=0 && (i+1)<b.length)
				{
					//System.out.println(bytetowrite);
					bytetowrite=b[i+1];
					//System.out.println(i+1);
					for(int j=0;j<count;j++){
						decompressB[indexforcontinue]=bytetowrite;
						indexforcontinue++;
					}
				}
					
				else
				{
					for(int k=0;k<b.length;k++){
						b[k]=decompressB[k];
					}
					return 0;
				}
		}
		for(int k=0;k<b.length;k++){
			if(b[k]!=0){
			b[k]=decompressB[k];
			}
			else{
				b[k]=0;
			}
		}
		return 0;
	}



	@Override
	public int read() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	
}

