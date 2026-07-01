package b.i.a.c.e3;

import java.io.IOException;

/* JADX INFO: renamed from: b.i.a.c.e3.j, reason: use source file name */
/* JADX INFO: compiled from: DataSink.java */
/* JADX INFO: loaded from: classes3.dex */
public interface DataSink {
    void a(DataSpec dataSpec) throws IOException;

    void close() throws IOException;

    void write(byte[] bArr, int i, int i2) throws IOException;
}
