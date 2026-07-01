package b.f.j.p;

import com.facebook.common.references.CloseableReference;

/* JADX INFO: compiled from: DecodeProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class n$a extends n$c {
    public n$a(n nVar, l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var, boolean z2, int i) {
        super(nVar, lVar, x0Var, z2, i);
    }

    @Override // b.f.j.p.n$c
    public int o(b.f.j.j.e eVar) {
        return eVar.n();
    }

    @Override // b.f.j.p.n$c
    public b.f.j.j.i p() {
        return new b.f.j.j.h(0, false, false);
    }

    @Override // b.f.j.p.n$c
    public synchronized boolean w(b.f.j.j.e eVar, int i) {
        if (b.f(i)) {
            return false;
        }
        return this.g.f(eVar, i);
    }
}
