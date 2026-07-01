package androidx.exifinterface.media;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class ExifInterface$SeekableByteOrderedDataInputStream extends ExifInterface$ByteOrderedDataInputStream {
    public ExifInterface$SeekableByteOrderedDataInputStream(byte[] bArr) throws IOException {
        super(bArr);
        this.mDataInputStream.mark(Integer.MAX_VALUE);
    }

    public void seek(long j) throws IOException {
        int i = this.mPosition;
        if (i > j) {
            this.mPosition = 0;
            this.mDataInputStream.reset();
        } else {
            j -= (long) i;
        }
        skipFully((int) j);
    }

    public ExifInterface$SeekableByteOrderedDataInputStream(InputStream inputStream) throws IOException {
        super(inputStream);
        if (inputStream.markSupported()) {
            this.mDataInputStream.mark(Integer.MAX_VALUE);
            return;
        }
        throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
    }
}
