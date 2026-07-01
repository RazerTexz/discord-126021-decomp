package b.i.a.c.x2;

import b.i.a.c.e3.DataReader;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.a.c.x2.i, reason: use source file name */
/* JADX INFO: compiled from: ExtractorInput.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ExtractorInput extends DataReader {
    long b();

    boolean c(byte[] bArr, int i, int i2, boolean z2) throws IOException;

    boolean e(byte[] bArr, int i, int i2, boolean z2) throws IOException;

    long f();

    void g(int i) throws IOException;

    long getPosition();

    int h(int i) throws IOException;

    int i(byte[] bArr, int i, int i2) throws IOException;

    void k();

    void l(int i) throws IOException;

    boolean m(int i, boolean z2) throws IOException;

    void o(byte[] bArr, int i, int i2) throws IOException;

    @Override // b.i.a.c.e3.DataReader
    int read(byte[] bArr, int i, int i2) throws IOException;

    void readFully(byte[] bArr, int i, int i2) throws IOException;
}
