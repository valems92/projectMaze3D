package io;

import java.io.IOException;
import java.io.InputStream;

public class MyDecompressorInputStream extends InputStream {
	private InputStream in;
	private final int SIZE = 9;

	public MyDecompressorInputStream(InputStream in) {
		super();
		this.in = in;
	}

	@Override
	public int read(byte[] b) throws IOException {
		in.read(b);
		int i, indexforcontinue = SIZE, count = 0;
		byte bytetowrite = 0;
		byte[] decompressB = new byte[b.length];

		for (i = 0; i < SIZE; i++) {
			decompressB[i] = b[i];
		}

		for (i = SIZE; i < b.length; i = i + 2) {
			count = b[i];

			if (count != 0 && (i + 1) < b.length) {
				bytetowrite = b[i + 1];
				for (int j = 0; j < count; j++) {
					decompressB[indexforcontinue] = bytetowrite;
					indexforcontinue++;
				}
			} else {
				for (int k = 0; k < b.length; k++) {
					b[k] = decompressB[k];
				}
				return 0;
			}
		}
		for (int k = 0; k < b.length; k++) {
			b[k] = (b[k] != 0) ? decompressB[k] : 0;
		}
		return 0;
	}

	@Override
	public int read() throws IOException {
		return 0;
	}

}
