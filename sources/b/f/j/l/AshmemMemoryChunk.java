package b.f.j.l;

import android.annotation.TargetApi;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.util.Log;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.l.a, reason: use source file name */
/* JADX INFO: compiled from: AshmemMemoryChunk.java */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(27)
public class AshmemMemoryChunk implements MemoryChunk, Closeable {
    public SharedMemory j;
    public ByteBuffer k;
    public final long l;

    public AshmemMemoryChunk(int i) {
        AnimatableValueParser.i(Boolean.valueOf(i > 0));
        try {
            SharedMemory sharedMemoryCreate = SharedMemory.create("AshmemMemoryChunk", i);
            this.j = sharedMemoryCreate;
            this.k = sharedMemoryCreate.mapReadWrite();
            this.l = System.identityHashCode(this);
        } catch (ErrnoException e) {
            throw new RuntimeException("Fail to create AshmemMemory", e);
        }
    }

    @Override // b.f.j.l.MemoryChunk
    public void a(int i, MemoryChunk memoryChunk, int i2, int i3) {
        Objects.requireNonNull(memoryChunk);
        if (memoryChunk.getUniqueId() == this.l) {
            StringBuilder sbU = outline.U("Copying from AshmemMemoryChunk ");
            sbU.append(Long.toHexString(this.l));
            sbU.append(" to AshmemMemoryChunk ");
            sbU.append(Long.toHexString(memoryChunk.getUniqueId()));
            sbU.append(" which are the same ");
            Log.w("AshmemMemoryChunk", sbU.toString());
            AnimatableValueParser.i(Boolean.FALSE);
        }
        if (memoryChunk.getUniqueId() < this.l) {
            synchronized (memoryChunk) {
                synchronized (this) {
                    c(i, memoryChunk, i2, i3);
                }
            }
        } else {
            synchronized (this) {
                synchronized (memoryChunk) {
                    c(i, memoryChunk, i2, i3);
                }
            }
        }
    }

    @Override // b.f.j.l.MemoryChunk
    public synchronized int b(int i, byte[] bArr, int i2, int i3) {
        int iD;
        Objects.requireNonNull(this.k);
        iD = AnimatableValueParser.d(i, i3, getSize());
        AnimatableValueParser.p(i, bArr.length, i2, iD, getSize());
        this.k.position(i);
        this.k.put(bArr, i2, iD);
        return iD;
    }

    public final void c(int i, MemoryChunk memoryChunk, int i2, int i3) {
        if (!(memoryChunk instanceof AshmemMemoryChunk)) {
            throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
        }
        AnimatableValueParser.B(!isClosed());
        AnimatableValueParser.B(!memoryChunk.isClosed());
        Objects.requireNonNull(this.k);
        Objects.requireNonNull(memoryChunk.getByteBuffer());
        AnimatableValueParser.p(i, memoryChunk.getSize(), i2, i3, getSize());
        this.k.position(i);
        memoryChunk.getByteBuffer().position(i2);
        byte[] bArr = new byte[i3];
        this.k.get(bArr, 0, i3);
        memoryChunk.getByteBuffer().put(bArr, 0, i3);
    }

    @Override // b.f.j.l.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
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

    @Override // b.f.j.l.MemoryChunk
    public ByteBuffer getByteBuffer() {
        return this.k;
    }

    @Override // b.f.j.l.MemoryChunk
    public int getSize() {
        Objects.requireNonNull(this.j);
        return this.j.getSize();
    }

    @Override // b.f.j.l.MemoryChunk
    public long getUniqueId() {
        return this.l;
    }

    @Override // b.f.j.l.MemoryChunk
    public synchronized byte h(int i) {
        boolean z2 = true;
        AnimatableValueParser.B(!isClosed());
        AnimatableValueParser.i(Boolean.valueOf(i >= 0));
        if (i >= getSize()) {
            z2 = false;
        }
        AnimatableValueParser.i(Boolean.valueOf(z2));
        Objects.requireNonNull(this.k);
        return this.k.get(i);
    }

    @Override // b.f.j.l.MemoryChunk
    public synchronized int i(int i, byte[] bArr, int i2, int i3) {
        int iD;
        Objects.requireNonNull(bArr);
        Objects.requireNonNull(this.k);
        iD = AnimatableValueParser.d(i, i3, getSize());
        AnimatableValueParser.p(i, bArr.length, i2, iD, getSize());
        this.k.position(i);
        this.k.get(bArr, i2, iD);
        return iD;
    }

    @Override // b.f.j.l.MemoryChunk
    public synchronized boolean isClosed() {
        return this.k == null || this.j == null;
    }

    @Override // b.f.j.l.MemoryChunk
    public long k() {
        throw new UnsupportedOperationException("Cannot get the pointer of an  AshmemMemoryChunk");
    }
}
