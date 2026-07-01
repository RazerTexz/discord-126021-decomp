package b.i.a.c.e3.b0;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.Util2;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* JADX INFO: renamed from: b.i.a.c.e3.b0.p, reason: use source file name */
/* JADX INFO: compiled from: ReusableBufferedOutputStream.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ReusableBufferedOutputStream extends BufferedOutputStream {
    public boolean j;

    public ReusableBufferedOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public void a(OutputStream outputStream) {
        AnimatableValueParser.D(this.j);
        ((BufferedOutputStream) this).out = outputStream;
        ((BufferedOutputStream) this).count = 0;
        this.j = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        this.j = true;
        flush();
        th = null;
        try {
            ((BufferedOutputStream) this).out.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        if (th == null) {
            return;
        }
        int i = Util2.a;
        throw th;
    }

    public ReusableBufferedOutputStream(OutputStream outputStream, int i) {
        super(outputStream, i);
    }
}
