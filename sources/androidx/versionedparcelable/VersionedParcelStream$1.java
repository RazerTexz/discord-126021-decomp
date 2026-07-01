package androidx.versionedparcelable;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class VersionedParcelStream$1 extends FilterInputStream {
    public final /* synthetic */ VersionedParcelStream this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VersionedParcelStream$1(VersionedParcelStream versionedParcelStream, InputStream inputStream) {
        super(inputStream);
        this.this$0 = versionedParcelStream;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        VersionedParcelStream versionedParcelStream = this.this$0;
        int i = versionedParcelStream.mFieldSize;
        if (i != -1 && versionedParcelStream.mCount >= i) {
            throw new IOException();
        }
        int i2 = super.read();
        this.this$0.mCount++;
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        VersionedParcelStream versionedParcelStream = this.this$0;
        int i = versionedParcelStream.mFieldSize;
        if (i != -1 && versionedParcelStream.mCount >= i) {
            throw new IOException();
        }
        long jSkip = super.skip(j);
        if (jSkip > 0) {
            this.this$0.mCount += (int) jSkip;
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        VersionedParcelStream versionedParcelStream = this.this$0;
        int i3 = versionedParcelStream.mFieldSize;
        if (i3 != -1 && versionedParcelStream.mCount >= i3) {
            throw new IOException();
        }
        int i4 = super.read(bArr, i, i2);
        if (i4 > 0) {
            this.this$0.mCount += i4;
        }
        return i4;
    }
}
