package p615g0;

import java.io.IOException;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: g0.c */
/* JADX INFO: compiled from: AsyncTimeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12386c implements InterfaceC12405v {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C12385b f26075j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ InterfaceC12405v f26076k;

    public C12386c(C12385b c12385b, InterfaceC12405v interfaceC12405v) {
        this.f26075j = c12385b;
        this.f26076k = interfaceC12405v;
    }

    @Override // p615g0.InterfaceC12405v, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        C12385b c12385b = this.f26075j;
        c12385b.m10424i();
        try {
            try {
                this.f26076k.close();
                if (c12385b.m10425j()) {
                    throw c12385b.mo10296k(null);
                }
            } catch (IOException e) {
                if (!c12385b.m10425j()) {
                    throw e;
                }
                throw c12385b.mo10296k(e);
            }
        } catch (Throwable th) {
            c12385b.m10425j();
            throw th;
        }
    }

    @Override // p615g0.InterfaceC12405v, java.io.Flushable
    public void flush() throws IOException {
        C12385b c12385b = this.f26075j;
        c12385b.m10424i();
        try {
            try {
                this.f26076k.flush();
                if (c12385b.m10425j()) {
                    throw c12385b.mo10296k(null);
                }
            } catch (IOException e) {
                if (!c12385b.m10425j()) {
                    throw e;
                }
                throw c12385b.mo10296k(e);
            }
        } catch (Throwable th) {
            c12385b.m10425j();
            throw th;
        }
    }

    @Override // p615g0.InterfaceC12405v
    public C12408y timeout() {
        return this.f26075j;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("AsyncTimeout.sink(");
        sbM833U.append(this.f26076k);
        sbM833U.append(')');
        return sbM833U.toString();
    }

    @Override // p615g0.InterfaceC12405v
    public void write(C12388e c12388e, long j) throws IOException {
        C12238m.checkParameterIsNotNull(c12388e, "source");
        C3404f.m4192B(c12388e.f26080k, 0L, j);
        while (true) {
            long j2 = 0;
            if (j <= 0) {
                return;
            }
            C12402s c12402s = c12388e.f26079j;
            if (c12402s == null) {
                C12238m.throwNpe();
            }
            while (j2 < 65536) {
                j2 += (long) (c12402s.f26120c - c12402s.f26119b);
                if (j2 >= j) {
                    j2 = j;
                    break;
                } else {
                    c12402s = c12402s.f26123f;
                    if (c12402s == null) {
                        C12238m.throwNpe();
                    }
                }
            }
            C12385b c12385b = this.f26075j;
            c12385b.m10424i();
            try {
                try {
                    this.f26076k.write(c12388e, j2);
                    if (c12385b.m10425j()) {
                        throw c12385b.mo10296k(null);
                    }
                    j -= j2;
                } catch (IOException e) {
                    if (!c12385b.m10425j()) {
                        throw e;
                    }
                    throw c12385b.mo10296k(e);
                }
            } catch (Throwable th) {
                c12385b.m10425j();
                throw th;
            }
        }
    }
}
