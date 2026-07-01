package g0;

import d0.z.d.Intrinsics3;
import java.io.OutputStream;

/* JADX INFO: renamed from: g0.f, reason: use source file name */
/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Buffer4 extends OutputStream {
    public final /* synthetic */ Buffer3 j;

    public Buffer4(Buffer3 buffer3) {
        this.j = buffer3;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    public String toString() {
        return this.j + ".outputStream()";
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.j.T(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        Intrinsics3.checkParameterIsNotNull(bArr, "data");
        this.j.S(bArr, i, i2);
    }
}
