package b.f.j.l;

import androidx.annotation.VisibleForTesting;
import b.c.a.a0.AnimatableValueParser;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: b.f.j.l.t, reason: use source file name */
/* JADX INFO: compiled from: MemoryPooledByteBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public class MemoryPooledByteBuffer implements PooledByteBuffer {
    public final int j;

    @VisibleForTesting
    public CloseableReference<MemoryChunk> k;

    public MemoryPooledByteBuffer(CloseableReference<MemoryChunk> closeableReference, int i) {
        AnimatableValueParser.i(Boolean.valueOf(i >= 0 && i <= closeableReference.u().getSize()));
        this.k = closeableReference.clone();
        this.j = i;
    }

    public synchronized void a() {
        try {
            synchronized (this) {
            }
        } catch (Throwable th) {
            throw th;
        }
        if (!CloseableReference.y(this.k)) {
            throw new PooledByteBuffer.ClosedException();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        CloseableReference<MemoryChunk> closeableReference = this.k;
        Class<CloseableReference> cls = CloseableReference.j;
        if (closeableReference != null) {
            closeableReference.close();
        }
        this.k = null;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized ByteBuffer getByteBuffer() {
        return this.k.u().getByteBuffer();
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized byte h(int i) {
        a();
        boolean z2 = true;
        AnimatableValueParser.i(Boolean.valueOf(i >= 0));
        if (i >= this.j) {
            z2 = false;
        }
        AnimatableValueParser.i(Boolean.valueOf(z2));
        return this.k.u().h(i);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int i(int i, byte[] bArr, int i2, int i3) {
        a();
        AnimatableValueParser.i(Boolean.valueOf(i + i3 <= this.j));
        return this.k.u().i(i, bArr, i2, i3);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized boolean isClosed() {
        return !CloseableReference.y(this.k);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized long k() throws UnsupportedOperationException {
        a();
        return this.k.u().k();
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int size() {
        a();
        return this.j;
    }
}
