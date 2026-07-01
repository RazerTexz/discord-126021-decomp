package b.i.a.f.h.j;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements Runnable {
    public final /* synthetic */ k0 j;
    public final /* synthetic */ l k;

    public m(l lVar, k0 k0Var) {
        this.k = lVar;
        this.j = k0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.k.l.R()) {
            return;
        }
        this.k.l.a(3, "Connected to service after a timeout", null, null, null);
        j jVar = this.k.l;
        k0 k0Var = this.j;
        Objects.requireNonNull(jVar);
        b.i.a.f.b.f.b();
        jVar.m = k0Var;
        jVar.T();
        a aVarS = jVar.s();
        Objects.requireNonNull(aVarS);
        b.i.a.f.b.f.b();
        aVarS.l.O();
    }
}
