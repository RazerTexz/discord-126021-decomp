package p007b.p109f.p115d.p122g;

import androidx.annotation.VisibleForTesting;
import com.facebook.common.memory.PooledByteBuffer;
import java.io.InputStream;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.f.d.g.h */
/* JADX INFO: compiled from: PooledByteBufferInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class C1701h extends InputStream {

    /* JADX INFO: renamed from: j */
    @VisibleForTesting
    public final PooledByteBuffer f3114j;

    /* JADX INFO: renamed from: k */
    @VisibleForTesting
    public int f3115k;

    /* JADX INFO: renamed from: l */
    @VisibleForTesting
    public int f3116l;

    public C1701h(PooledByteBuffer pooledByteBuffer) {
        C1460d.m527i(Boolean.valueOf(!pooledByteBuffer.isClosed()));
        this.f3114j = pooledByteBuffer;
        this.f3115k = 0;
        this.f3116l = 0;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f3114j.size() - this.f3115k;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f3116l = this.f3115k;
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
        PooledByteBuffer pooledByteBuffer = this.f3114j;
        int i = this.f3115k;
        this.f3115k = i + 1;
        return pooledByteBuffer.mo1395h(i) & 255;
    }

    @Override // java.io.InputStream
    public void reset() {
        this.f3115k = this.f3116l;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        C1460d.m527i(Boolean.valueOf(j >= 0));
        int iMin = Math.min((int) j, available());
        this.f3115k += iMin;
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
            this.f3114j.mo1396i(this.f3115k, bArr, i, iMin);
            this.f3115k += iMin;
            return iMin;
        }
        StringBuilder sbM833U = C1643a.m833U("length=");
        sbM833U.append(bArr.length);
        sbM833U.append("; regionStart=");
        sbM833U.append(i);
        sbM833U.append("; regionLength=");
        sbM833U.append(i2);
        throw new ArrayIndexOutOfBoundsException(sbM833U.toString());
    }
}
