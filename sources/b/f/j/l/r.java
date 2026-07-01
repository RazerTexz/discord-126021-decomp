package b.f.j.l;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: MemoryChunk.java */
/* JADX INFO: loaded from: classes3.dex */
public interface r {
    void a(int i, r rVar, int i2, int i3);

    int b(int i, byte[] bArr, int i2, int i3);

    void close();

    ByteBuffer getByteBuffer();

    int getSize();

    long getUniqueId();

    byte h(int i);

    int i(int i, byte[] bArr, int i2, int i3);

    boolean isClosed();

    long k() throws UnsupportedOperationException;
}
