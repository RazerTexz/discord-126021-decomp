package b.f.j.l;

import android.annotation.TargetApi;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.util.Log;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: AshmemMemoryChunk.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(27)
public class a implements r, Closeable {
    public SharedMemory j;
    public ByteBuffer k;
    public final long l;

    public a(int i) {
        b.c.a.a0.d.i(Boolean.valueOf(i > 0));
        try {
            SharedMemory sharedMemoryCreate = SharedMemory.create("AshmemMemoryChunk", i);
            this.j = sharedMemoryCreate;
            this.k = sharedMemoryCreate.mapReadWrite();
            this.l = System.identityHashCode(this);
        } catch (ErrnoException e) {
            throw new RuntimeException("Fail to create AshmemMemory", e);
        }
    }

    @Override // b.f.j.l.r
    public void a(int i, r rVar, int i2, int i3) {
        Objects.requireNonNull(rVar);
        if (rVar.getUniqueId() == this.l) {
            StringBuilder sbU = b.d.b.a.a.U("Copying from AshmemMemoryChunk ");
            sbU.append(Long.toHexString(this.l));
            sbU.append(" to AshmemMemoryChunk ");
            sbU.append(Long.toHexString(rVar.getUniqueId()));
            sbU.append(" which are the same ");
            Log.w("AshmemMemoryChunk", sbU.toString());
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
        Objects.requireNonNull(this.k);
        iD = b.c.a.a0.d.d(i, i3, getSize());
        b.c.a.a0.d.p(i, bArr.length, i2, iD, getSize());
        this.k.position(i);
        this.k.put(bArr, i2, iD);
        return iD;
    }

    public final void c(int i, r rVar, int i2, int i3) {
        if (!(rVar instanceof a)) {
            throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
        }
        b.c.a.a0.d.B(!isClosed());
        b.c.a.a0.d.B(!rVar.isClosed());
        Objects.requireNonNull(this.k);
        Objects.requireNonNull(rVar.getByteBuffer());
        b.c.a.a0.d.p(i, rVar.getSize(), i2, i3, getSize());
        this.k.position(i);
        rVar.getByteBuffer().position(i2);
        byte[] bArr = new byte[i3];
        this.k.get(bArr, 0, i3);
        rVar.getByteBuffer().put(bArr, 0, i3);
    }

    @Override // b.f.j.l.r, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!isClosed()) {
            SharedMemory sharedMemory = this.j;
            if (sharedMemory != null) {
                sharedMemory.close();
            }
            ByteBuffer byteBuffer = this.k;
            if (byteBuffer != null) {
                SharedMemory.unmap(byteBuffer);
            }
            this.k = null;
            this.j = null;
        }
    }

    @Override // b.f.j.l.r
    public ByteBuffer getByteBuffer() {
        return this.k;
    }

    @Override // b.f.j.l.r
    public int getSize() {
        Objects.requireNonNull(this.j);
        return this.j.getSize();
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
        if (i >= getSize()) {
            z2 = false;
        }
        b.c.a.a0.d.i(Boolean.valueOf(z2));
        Objects.requireNonNull(this.k);
        return this.k.get(i);
    }

    @Override // b.f.j.l.r
    public synchronized int i(int i, byte[] bArr, int i2, int i3) {
        int iD;
        Objects.requireNonNull(bArr);
        Objects.requireNonNull(this.k);
        iD = b.c.a.a0.d.d(i, i3, getSize());
        b.c.a.a0.d.p(i, bArr.length, i2, iD, getSize());
        this.k.position(i);
        this.k.get(bArr, i2, iD);
        return iD;
    }

    @Override // b.f.j.l.r
    public synchronized boolean isClosed() {
        return this.k == null || this.j == null;
    }

    @Override // b.f.j.l.r
    public long k() {
        throw new UnsupportedOperationException("Cannot get the pointer of an  AshmemMemoryChunk");
    }
}
