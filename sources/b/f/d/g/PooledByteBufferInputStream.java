package b.f.d.g;

import androidx.annotation.VisibleForTesting;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.facebook.common.memory.PooledByteBuffer;
import java.io.InputStream;

/* JADX INFO: renamed from: b.f.d.g.h, reason: use source file name */
/* JADX INFO: compiled from: PooledByteBufferInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class PooledByteBufferInputStream extends InputStream {

    @VisibleForTesting
    public final PooledByteBuffer j;

    @VisibleForTesting
    public int k;

    @VisibleForTesting
    public int l;

    public PooledByteBufferInputStream(PooledByteBuffer pooledByteBuffer) {
        AnimatableValueParser.i(Boolean.valueOf(!pooledByteBuffer.isClosed()));
        this.j = pooledByteBuffer;
        this.k = 0;
        this.l = 0;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.j.size() - this.k;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.l = this.k;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (available() <= 0) {
            return -1;
        }
        PooledByteBuffer pooledByteBuffer = this.j;
        int i = this.k;
        this.k = i + 1;
        return pooledByteBuffer.h(i) & 255;
    }

    @Override // java.io.InputStream
    public void reset() {
        this.k = this.l;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        AnimatableValueParser.i(Boolean.valueOf(j >= 0));
        int iMin = Math.min((int) j, available());
        this.k += iMin;
        return iMin;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (i >= 0 && i2 >= 0 && i + i2 <= bArr.length) {
            int iAvailable = available();
            if (iAvailable <= 0) {
                return -1;
            }
            if (i2 <= 0) {
                return 0;
            }
            int iMin = Math.min(iAvailable, i2);
            this.j.i(this.k, bArr, i, iMin);
            this.k += iMin;
            return iMin;
        }
        StringBuilder sbU = outline.U("length=");
        sbU.append(bArr.length);
        sbU.append("; regionStart=");
        sbU.append(i);
        sbU.append("; regionLength=");
        sbU.append(i2);
        throw new ArrayIndexOutOfBoundsException(sbU.toString());
    }
}
