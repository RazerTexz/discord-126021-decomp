package b.f.j.l;

import android.util.Log;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: BufferMemoryChunk.java */
/* JADX INFO: loaded from: classes3.dex */
public class i implements r, Closeable {
    public ByteBuffer j;
    public final int k;
    public final long l = System.identityHashCode(this);

    public i(int i) {
        this.j = ByteBuffer.allocateDirect(i);
        this.k = i;
    }

    @Override // b.f.j.l.r
    public void a(int i, r rVar, int i2, int i3) {
        Objects.requireNonNull(rVar);
        if (rVar.getUniqueId() == this.l) {
            StringBuilder sbU = b.d.b.a.a.U("Copying from BufferMemoryChunk ");
            sbU.append(Long.toHexString(this.l));
            sbU.append(" to BufferMemoryChunk ");
            sbU.append(Long.toHexString(rVar.getUniqueId()));
            sbU.append(" which are the same ");
            Log.w("BufferMemoryChunk", sbU.toString());
            b.c.a.a0.d.i(Boolean.FALSE);
        }
        if (rVar.getUniqueId() < this.l) {
            synchronized (rVar) {
                synchronized (this) {
                    c(i, rVar, i2, i3);
                }
            }
        } else {
            synchronized (this) {
                synchronized (rVar) {
                    c(i, rVar, i2, i3);
                }
            }
        }
    }

    @Override // b.f.j.l.r
    public synchronized int b(int i, byte[] bArr, int i2, int i3) {
        int iD;
        b.c.a.a0.d.B(!isClosed());
        Objects.requireNonNull(this.j);
        iD = b.c.a.a0.d.d(i, i3, this.k);
        b.c.a.a0.d.p(i, bArr.length, i2, iD, this.k);
        this.j.position(i);
        this.j.put(bArr, i2, iD);
        return iD;
    }

    public final void c(int i, r rVar, int i2, int i3) {
        if (!(rVar instanceof i)) {
            throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
        }
        b.c.a.a0.d.B(!isClosed());
        b.c.a.a0.d.B(!rVar.isClosed());
        Objects.requireNonNull(this.j);
        b.c.a.a0.d.p(i, rVar.getSize(), i2, i3, this.k);
        this.j.position(i);
        ByteBuffer byteBuffer = rVar.getByteBuffer();
        Objects.requireNonNull(byteBuffer);
        byteBuffer.position(i2);
        byte[] bArr = new byte[i3];
        this.j.get(bArr, 0, i3);
        byteBuffer.put(bArr, 0, i3);
    }

    @Override // b.f.j.l.r, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.j = null;
    }

    @Override // b.f.j.l.r
    public synchronized ByteBuffer getByteBuffer() {
        return this.j;
    }

    @Override // b.f.j.l.r
    public int getSize() {
        return this.k;
    }

    @Override // b.f.j.l.r
    public long getUniqueId() {
        return this.l;
    }

    @Override // b.f.j.l.r
    public synchronized byte h(int i) {
        boolean z2 = true;
        b.c.a.a0.d.B(!isClosed());
        b.c.a.a0.d.i(Boolean.valueOf(i >= 0));
        if (i >= this.k) {
            z2 = false;
        }
        b.c.a.a0.d.i(Boolean.valueOf(z2));
        Objects.requireNonNull(this.j);
        return this.j.get(i);
    }

    @Override // b.f.j.l.r
    public synchronized int i(int i, byte[] bArr, int i2, int i3) {
        int iD;
        Objects.requireNonNull(bArr);
        b.c.a.a0.d.B(!isClosed());
        Objects.requireNonNull(this.j);
        iD = b.c.a.a0.d.d(i, i3, this.k);
        b.c.a.a0.d.p(i, bArr.length, i2, iD, this.k);
        this.j.position(i);
        this.j.get(bArr, i2, iD);
        return iD;
    }

    @Override // b.f.j.l.r
    public synchronized boolean isClosed() {
        return this.j == null;
    }

    @Override // b.f.j.l.r
    public long k() {
        throw new UnsupportedOperationException("Cannot get the pointer of a BufferMemoryChunk");
    }
}
