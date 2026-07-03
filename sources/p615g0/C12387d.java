package p615g0;

import java.io.IOException;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: g0.d */
/* JADX INFO: compiled from: AsyncTimeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12387d implements InterfaceC12407x {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C12385b f26077j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ InterfaceC12407x f26078k;

    public C12387d(C12385b c12385b, InterfaceC12407x interfaceC12407x) {
        this.f26077j = c12385b;
        this.f26078k = interfaceC12407x;
    }

    @Override // p615g0.InterfaceC12407x, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        C12385b c12385b = this.f26077j;
        c12385b.m10424i();
        try {
            try {
                this.f26078k.close();
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

    @Override // p615g0.InterfaceC12407x
    /* JADX INFO: renamed from: i0 */
    public long mo10176i0(C12388e c12388e, long j) throws IOException {
        C12238m.checkParameterIsNotNull(c12388e, "sink");
        C12385b c12385b = this.f26077j;
        c12385b.m10424i();
        try {
            try {
                long jMo10176i0 = this.f26078k.mo10176i0(c12388e, j);
                if (c12385b.m10425j()) {
                    throw c12385b.mo10296k(null);
                }
                return jMo10176i0;
            } catch (IOException e) {
                if (c12385b.m10425j()) {
                    throw c12385b.mo10296k(e);
                }
                throw e;
            }
        } catch (Throwable th) {
            c12385b.m10425j();
            throw th;
        }
    }

    @Override // p615g0.InterfaceC12407x
    public C12408y timeout() {
        return this.f26077j;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("AsyncTimeout.source(");
        sbM833U.append(this.f26078k);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}
