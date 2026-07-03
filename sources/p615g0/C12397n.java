package p615g0;

import java.io.IOException;
import java.io.InputStream;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: g0.n */
/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12397n implements InterfaceC12407x {

    /* JADX INFO: renamed from: j */
    public final InputStream f26104j;

    /* JADX INFO: renamed from: k */
    public final C12408y f26105k;

    public C12397n(InputStream inputStream, C12408y c12408y) {
        C12238m.checkParameterIsNotNull(inputStream, "input");
        C12238m.checkParameterIsNotNull(c12408y, "timeout");
        this.f26104j = inputStream;
        this.f26105k = c12408y;
    }

    @Override // p615g0.InterfaceC12407x, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f26104j.close();
    }

    @Override // p615g0.InterfaceC12407x
    /* JADX INFO: renamed from: i0 */
    public long mo10176i0(C12388e c12388e, long j) {
        C12238m.checkParameterIsNotNull(c12388e, "sink");
        if (j == 0) {
            return 0L;
        }
        if (!(j >= 0)) {
            throw new IllegalArgumentException(C1643a.m877t("byteCount < 0: ", j).toString());
        }
        try {
            this.f26105k.mo10483f();
            C12402s c12402sM10438N = c12388e.m10438N(1);
            int i = this.f26104j.read(c12402sM10438N.f26118a, c12402sM10438N.f26120c, (int) Math.min(j, 8192 - c12402sM10438N.f26120c));
            if (i != -1) {
                c12402sM10438N.f26120c += i;
                long j2 = i;
                c12388e.f26080k += j2;
                return j2;
            }
            if (c12402sM10438N.f26119b != c12402sM10438N.f26120c) {
                return -1L;
            }
            c12388e.f26079j = c12402sM10438N.m10494a();
            C12403t.m10498a(c12402sM10438N);
            return -1L;
        } catch (AssertionError e) {
            if (C3404f.m4367z0(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    @Override // p615g0.InterfaceC12407x
    public C12408y timeout() {
        return this.f26105k;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("source(");
        sbM833U.append(this.f26104j);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}
