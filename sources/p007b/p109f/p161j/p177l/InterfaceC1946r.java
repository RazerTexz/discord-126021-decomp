package p007b.p109f.p161j.p177l;

import java.nio.ByteBuffer;

/* JADX INFO: renamed from: b.f.j.l.r */
/* JADX INFO: compiled from: MemoryChunk.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC1946r {
    /* JADX INFO: renamed from: a */
    void mo1365a(int i, InterfaceC1946r interfaceC1946r, int i2, int i3);

    /* JADX INFO: renamed from: b */
    int mo1366b(int i, byte[] bArr, int i2, int i3);

    void close();

    ByteBuffer getByteBuffer();

    int getSize();

    long getUniqueId();

    /* JADX INFO: renamed from: h */
    byte mo1368h(int i);

    /* JADX INFO: renamed from: i */
    int mo1369i(int i, byte[] bArr, int i2, int i3);

    boolean isClosed();

    /* JADX INFO: renamed from: k */
    long mo1370k() throws UnsupportedOperationException;
}
