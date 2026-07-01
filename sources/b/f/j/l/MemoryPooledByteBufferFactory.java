package b.f.j.l;

import b.f.d.d.Throwables;
import b.f.d.g.PooledByteBufferFactory;
import b.f.d.g.PooledByteBufferOutputStream;
import b.f.d.g.PooledByteStreams;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: b.f.j.l.u, reason: use source file name */
/* JADX INFO: compiled from: MemoryPooledByteBufferFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class MemoryPooledByteBufferFactory implements PooledByteBufferFactory {
    public final PooledByteStreams a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MemoryChunkPool f599b;

    public MemoryPooledByteBufferFactory(MemoryChunkPool memoryChunkPool, PooledByteStreams pooledByteStreams) {
        this.f599b = memoryChunkPool;
        this.a = pooledByteStreams;
    }

    @Override // b.f.d.g.PooledByteBufferFactory
    public PooledByteBufferOutputStream a() {
        MemoryChunkPool memoryChunkPool = this.f599b;
        return new MemoryPooledByteBufferOutputStream(memoryChunkPool, memoryChunkPool.k[0]);
    }

    @Override // b.f.d.g.PooledByteBufferFactory
    public PooledByteBuffer b(byte[] bArr) throws Throwable {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.f599b, bArr.length);
        try {
            try {
                memoryPooledByteBufferOutputStream.write(bArr, 0, bArr.length);
                MemoryPooledByteBuffer memoryPooledByteBufferB = memoryPooledByteBufferOutputStream.b();
                memoryPooledByteBufferOutputStream.close();
                return memoryPooledByteBufferB;
            } catch (IOException e) {
                Throwables.a(e);
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            memoryPooledByteBufferOutputStream.close();
            throw th;
        }
    }

    @Override // b.f.d.g.PooledByteBufferFactory
    public PooledByteBuffer c(InputStream inputStream) throws Throwable {
        MemoryChunkPool memoryChunkPool = this.f599b;
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(memoryChunkPool, memoryChunkPool.k[0]);
        try {
            this.a.a(inputStream, memoryPooledByteBufferOutputStream);
            return memoryPooledByteBufferOutputStream.b();
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // b.f.d.g.PooledByteBufferFactory
    public PooledByteBuffer d(InputStream inputStream, int i) throws Throwable {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.f599b, i);
        try {
            this.a.a(inputStream, memoryPooledByteBufferOutputStream);
            return memoryPooledByteBufferOutputStream.b();
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // b.f.d.g.PooledByteBufferFactory
    public PooledByteBufferOutputStream e(int i) {
        return new MemoryPooledByteBufferOutputStream(this.f599b, i);
    }
}
