package b.i.a.f.h.j;

import android.os.RemoteException;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends e {
    public final l l;
    public k0 m;
    public final a0 n;
    public final y0 o;

    public j(g gVar) {
        super(gVar);
        this.o = new y0(gVar.d);
        this.l = new l(this);
        this.n = new k(this, gVar);
    }

    @Override // b.i.a.f.h.j.e
    public final void L() {
    }

    public final void O() {
        b.i.a.f.b.f.b();
        N();
        try {
            b.i.a.f.e.n.a.b().c(this.j.f1417b, this.l);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        if (this.m != null) {
            this.m = null;
            a aVarS = s();
            aVarS.N();
            b.i.a.f.b.f.b();
            r rVar = aVarS.l;
            b.i.a.f.b.f.b();
            rVar.N();
            rVar.C("Service disconnected");
        }
    }

    public final boolean R() {
        b.i.a.f.b.f.b();
        N();
        return this.m != null;
    }

    public final boolean S(j0 j0Var) {
        Objects.requireNonNull(j0Var, "null reference");
        b.i.a.f.b.f.b();
        N();
        k0 k0Var = this.m;
        if (k0Var == null) {
            return false;
        }
        try {
            k0Var.g0(j0Var.a, j0Var.d, j0Var.f ? z.d() : z.e(), Collections.emptyList());
            T();
            return true;
        } catch (RemoteException unused) {
            C("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    public final void T() {
        this.o.a();
        this.n.e(e0.f1413x.a.longValue());
    }
}
