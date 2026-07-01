package b.f.j.l;

import android.util.Log;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.l.i, reason: use source file name */
/* JADX INFO: compiled from: BufferMemoryChunk.java */
/* JADX INFO: loaded from: classes3.dex */
public class BufferMemoryChunk implements MemoryChunk, Closeable {
    public ByteBuffer j;
    public final int k;
    public final long l = System.identityHashCode(this);

    public BufferMemoryChunk(int i) {
        this.j = ByteBuffer.allocateDirect(i);
        this.k = i;
    }

    @Override // b.f.j.l.MemoryChunk
    public void a(int i, MemoryChunk memoryChunk, int i2, int i3) {
        Objects.requireNonNull(memoryChunk);
        if (memoryChunk.getUniqueId() == this.l) {
            StringBuilder sbU = outline.U("Copying from BufferMemoryChunk ");
            sbU.append(Long.toHexString(this.l));
            sbU.append(" to BufferMemoryChunk ");
            sbU.append(Long.toHexString(memoryChunk.getUniqueId()));
            sbU.append(" which are the same ");
            Log.w("BufferMemoryChunk", sbU.toString());
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
        AnimatableValueParser.B(!isClosed());
        Objects.requireNonNull(this.j);
        iD = AnimatableValueParser.d(i, i3, this.k);
        AnimatableValueParser.p(i, bArr.length, i2, iD, this.k);
        this.j.position(i);
        this.j.put(bArr, i2, iD);
        return iD;
    }

    public final void c(int i, MemoryChunk memoryChunk, int i2, int i3) {
        if (!(memoryChunk instanceof BufferMemoryChunk)) {
            throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
        }
        AnimatableValueParser.B(!isClosed());
        AnimatableValueParser.B(!memoryChunk.isClosed());
        Objects.requireNonNull(this.j);
        AnimatableValueParser.p(i, memoryChunk.getSize(), i2, i3, this.k);
        this.j.position(i);
        ByteBuffer byteBuffer = memoryChunk.getByteBuffer();
        Objects.requireNonNull(byteBuffer);
        byteBuffer.position(i2);
        byte[] bArr = new byte[i3];
        this.j.get(bArr, 0, i3);
        byteBuffer.put(bArr, 0, i3);
    }

    @Override // b.f.j.l.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.j = null;
    }

    @Override // b.f.j.l.MemoryChunk
    public synchronized ByteBuffer getByteBuffer() {
        return this.j;
    }

    @Override // b.f.j.l.MemoryChunk
    public int getSize() {
        return this.k;
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
        if (i >= this.k) {
            z2 = false;
        }
        AnimatableValueParser.i(Boolean.valueOf(z2));
        Objects.requireNonNull(this.j);
        return this.j.get(i);
    }

    @Override // b.f.j.l.MemoryChunk
    public synchronized int i(int i, byte[] bArr, int i2, int i3) {
        int iD;
        Objects.requireNonNull(bArr);
        AnimatableValueParser.B(!isClosed());
        Objects.requireNonNull(this.j);
        iD = AnimatableValueParser.d(i, i3, this.k);
        AnimatableValueParser.p(i, bArr.length, i2, iD, this.k);
        this.j.position(i);
        this.j.get(bArr, i2, iD);
        return iD;
    }

    @Override // b.f.j.l.MemoryChunk
    public synchronized boolean isClosed() {
        return this.j == null;
    }

    @Override // b.f.j.l.MemoryChunk
    public long k() {
        throw new UnsupportedOperationException("Cannot get the pointer of a BufferMemoryChunk");
    }
}
