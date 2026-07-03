package p615g0;

import java.io.OutputStream;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: g0.f */
/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12389f extends OutputStream {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C12388e f26089j;

    public C12389f(C12388e c12388e) {
        this.f26089j = c12388e;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    public String toString() {
        return this.f26089j + ".outputStream()";
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.f26089j.m10444T(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        C12238m.checkParameterIsNotNull(bArr, "data");
        this.f26089j.m10443S(bArr, i, i2);
    }
}
