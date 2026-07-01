package f0.e0.i;

import d0.g0.t;
import d0.z.d.m;
import f0.e0.c;
import f0.p;
import f0.w;
import f0.x;
import g0.e;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import okhttp3.Headers;

/* JADX INFO: compiled from: Http1ExchangeCodec.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$c extends b$a {
    public long m;
    public boolean n;
    public final w o;
    public final /* synthetic */ b p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b$c(b bVar, w wVar) {
        super(bVar);
        m.checkParameterIsNotNull(wVar, "url");
        this.p = bVar;
        this.o = wVar;
        this.m = -1L;
        this.n = true;
    }

    @Override // g0.x, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.k) {
            return;
        }
        if (this.n && !c.i(this, 100, TimeUnit.MILLISECONDS)) {
            this.p.e.l();
            a();
        }
        this.k = true;
    }

    @Override // f0.e0.i.b$a, g0.x
    public long i0(e eVar, long j) throws IOException {
        m.checkParameterIsNotNull(eVar, "sink");
        boolean z2 = true;
        if (!(j >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.t("byteCount < 0: ", j).toString());
        }
        if (!(!this.k)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!this.n) {
            return -1L;
        }
        long j2 = this.m;
        if (j2 == 0 || j2 == -1) {
            if (j2 != -1) {
                this.p.f.Y();
            }
            try {
                this.m = this.p.f.s0();
                String strY = this.p.f.Y();
                if (strY == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String string = d0.g0.w.trim(strY).toString();
                if (this.m >= 0) {
                    if (string.length() <= 0) {
                        z2 = false;
                    }
                    if (!z2 || t.startsWith$default(string, ";", false, 2, null)) {
                        if (this.m == 0) {
                            this.n = false;
                            b bVar = this.p;
                            bVar.c = bVar.f3632b.a();
                            x xVar = this.p.d;
                            if (xVar == null) {
                                m.throwNpe();
                            }
                            p pVar = xVar.v;
                            w wVar = this.o;
                            Headers headers = this.p.c;
                            if (headers == null) {
                                m.throwNpe();
                            }
                            f0.e0.h.e.d(pVar, wVar, headers);
                            a();
                        }
                        if (!this.n) {
                            return -1L;
                        }
                    }
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.m + string + '\"');
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }
        long jI0 = super.i0(eVar, Math.min(j, this.m));
        if (jI0 != -1) {
            this.m -= jI0;
            return jI0;
        }
        this.p.e.l();
        ProtocolException protocolException = new ProtocolException("unexpected end of stream");
        a();
        throw protocolException;
    }
}
