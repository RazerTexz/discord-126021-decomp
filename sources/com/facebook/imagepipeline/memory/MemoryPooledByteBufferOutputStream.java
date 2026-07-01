package com.facebook.imagepipeline.memory;

import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.f.d.g.PooledByteBufferOutputStream;
import b.f.j.l.MemoryChunk;
import b.f.j.l.MemoryChunkPool;
import b.f.j.l.MemoryPooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class MemoryPooledByteBufferOutputStream extends PooledByteBufferOutputStream {
    public final MemoryChunkPool j;
    public CloseableReference<MemoryChunk> k;
    public int l;

    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }

    public MemoryPooledByteBufferOutputStream(MemoryChunkPool memoryChunkPool, int i) {
        AnimatableValueParser.i(Boolean.valueOf(i > 0));
        Objects.requireNonNull(memoryChunkPool);
        this.j = memoryChunkPool;
        this.l = 0;
        this.k = CloseableReference.D(memoryChunkPool.get(i), memoryChunkPool);
    }

    public final void a() {
        if (!CloseableReference.y(this.k)) {
            throw new InvalidStreamException();
        }
    }

    public MemoryPooledByteBuffer b() {
        a();
        CloseableReference<MemoryChunk> closeableReference = this.k;
        Objects.requireNonNull(closeableReference);
        return new MemoryPooledByteBuffer(closeableReference, this.l);
    }

    @Override // b.f.d.g.PooledByteBufferOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        CloseableReference<MemoryChunk> closeableReference = this.k;
        Class<CloseableReference> cls = CloseableReference.j;
        if (closeableReference != null) {
            closeableReference.close();
        }
        this.k = null;
        this.l = -1;
        super.close();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws Throwable {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            StringBuilder sbU = outline.U("length=");
            sbU.append(bArr.length);
            sbU.append("; regionStart=");
            sbU.append(i);
            sbU.append("; regionLength=");
            sbU.append(i2);
            throw new ArrayIndexOutOfBoundsException(sbU.toString());
        }
        a();
        int i3 = this.l + i2;
        a();
        Objects.requireNonNull(this.k);
        if (i3 > this.k.u().getSize()) {
            MemoryChunk memoryChunk = this.j.get(i3);
            Objects.requireNonNull(this.k);
            this.k.u().a(0, memoryChunk, 0, this.l);
            this.k.close();
            this.k = CloseableReference.D(memoryChunk, this.j);
        }
        CloseableReference<MemoryChunk> closeableReference = this.k;
        Objects.requireNonNull(closeableReference);
        closeableReference.u().b(this.l, bArr, i, i2);
        this.l += i2;
    }
}
