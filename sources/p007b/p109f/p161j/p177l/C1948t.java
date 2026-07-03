package p007b.p109f.p161j.p177l;

import androidx.annotation.VisibleForTesting;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.nio.ByteBuffer;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.f.j.l.t */
/* JADX INFO: compiled from: MemoryPooledByteBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1948t implements PooledByteBuffer {

    /* JADX INFO: renamed from: j */
    public final int f3953j;

    /* JADX INFO: renamed from: k */
    @VisibleForTesting
    public CloseableReference<InterfaceC1946r> f3954k;

    public C1948t(CloseableReference<InterfaceC1946r> closeableReference, int i) {
        C1460d.m527i(Boolean.valueOf(i >= 0 && i <= closeableReference.m8642u().getSize()));
        this.f3954k = closeableReference.clone();
        this.f3953j = i;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m1394a() {
        try {
            synchronized (this) {
            }
        } catch (Throwable th) {
            throw th;
        }
        if (!CloseableReference.m8640y(this.f3954k)) {
            throw new PooledByteBuffer.ClosedException();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        CloseableReference<InterfaceC1946r> closeableReference = this.f3954k;
        Class<CloseableReference> cls = CloseableReference.f19438j;
        if (closeableReference != null) {
            closeableReference.close();
        }
        this.f3954k = null;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized ByteBuffer getByteBuffer() {
        return this.f3954k.m8642u().getByteBuffer();
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    /* JADX INFO: renamed from: h */
    public synchronized byte mo1395h(int i) {
        m1394a();
        boolean z2 = true;
        C1460d.m527i(Boolean.valueOf(i >= 0));
        if (i >= this.f3953j) {
            z2 = false;
        }
        C1460d.m527i(Boolean.valueOf(z2));
        return this.f3954k.m8642u().mo1368h(i);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    /* JADX INFO: renamed from: i */
    public synchronized int mo1396i(int i, byte[] bArr, int i2, int i3) {
        m1394a();
        C1460d.m527i(Boolean.valueOf(i + i3 <= this.f3953j));
        return this.f3954k.m8642u().mo1369i(i, bArr, i2, i3);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized boolean isClosed() {
        return !CloseableReference.m8640y(this.f3954k);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    /* JADX INFO: renamed from: k */
    public synchronized long mo1397k() throws UnsupportedOperationException {
        m1394a();
        return this.f3954k.m8642u().mo1370k();
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int size() {
        m1394a();
        return this.f3953j;
    }
}
