package p615g0;

import java.io.IOException;
import java.io.OutputStream;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: g0.p */
/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12399p implements InterfaceC12405v {

    /* JADX INFO: renamed from: j */
    public final OutputStream f26109j;

    /* JADX INFO: renamed from: k */
    public final C12408y f26110k;

    public C12399p(OutputStream outputStream, C12408y c12408y) {
        C12238m.checkParameterIsNotNull(outputStream, "out");
        C12238m.checkParameterIsNotNull(c12408y, "timeout");
        this.f26109j = outputStream;
        this.f26110k = c12408y;
    }

    @Override // p615g0.InterfaceC12405v, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f26109j.close();
    }

    @Override // p615g0.InterfaceC12405v, java.io.Flushable
    public void flush() throws IOException {
        this.f26109j.flush();
    }

    @Override // p615g0.InterfaceC12405v
    public C12408y timeout() {
        return this.f26110k;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("sink(");
        sbM833U.append(this.f26109j);
        sbM833U.append(')');
        return sbM833U.toString();
    }

    @Override // p615g0.InterfaceC12405v
    public void write(C12388e c12388e, long j) throws IOException {
        C12238m.checkParameterIsNotNull(c12388e, "source");
        C3404f.m4192B(c12388e.f26080k, 0L, j);
        while (j > 0) {
            this.f26110k.mo10483f();
            C12402s c12402s = c12388e.f26079j;
            if (c12402s == null) {
                C12238m.throwNpe();
            }
            int iMin = (int) Math.min(j, c12402s.f26120c - c12402s.f26119b);
            this.f26109j.write(c12402s.f26118a, c12402s.f26119b, iMin);
            int i = c12402s.f26119b + iMin;
            c12402s.f26119b = i;
            long j2 = iMin;
            j -= j2;
            c12388e.f26080k -= j2;
            if (i == c12402s.f26120c) {
                c12388e.f26079j = c12402s.m10494a();
                C12403t.m10498a(c12402s);
            }
        }
    }
}
