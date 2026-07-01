package f0.e0.i;

import d0.z.d.m;
import g0.e;
import g0.k;
import g0.x;
import g0.y;
import java.io.IOException;

/* JADX INFO: compiled from: Http1ExchangeCodec.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b$a implements x {
    public final k j;
    public boolean k;
    public final /* synthetic */ b l;

    public b$a(b bVar) {
        this.l = bVar;
        this.j = new k(bVar.f.timeout());
    }

    public final void a() {
        b bVar = this.l;
        int i = bVar.a;
        if (i == 6) {
            return;
        }
        if (i == 5) {
            b.i(bVar, this.j);
            this.l.a = 6;
        } else {
            StringBuilder sbU = b.d.b.a.a.U("state: ");
            sbU.append(this.l.a);
            throw new IllegalStateException(sbU.toString());
        }
    }

    @Override // g0.x
    public long i0(e eVar, long j) {
        m.checkParameterIsNotNull(eVar, "sink");
        try {
            return this.l.f.i0(eVar, j);
        } catch (IOException e) {
            this.l.e.l();
            a();
            throw e;
        }
    }

    @Override // g0.x
    public y timeout() {
        return this.j;
    }
}
