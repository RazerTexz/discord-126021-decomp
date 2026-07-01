package b.f.j.p;

import com.facebook.common.references.CloseableReference;
import java.util.Objects;

/* JADX INFO: compiled from: DecodeProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class n$b extends n$c {
    public final b.f.j.h.e i;
    public final b.f.j.h.d j;
    public int k;

    public n$b(n nVar, l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var, b.f.j.h.e eVar, b.f.j.h.d dVar, boolean z2, int i) {
        super(nVar, lVar, x0Var, z2, i);
        this.i = eVar;
        Objects.requireNonNull(dVar);
        this.j = dVar;
        this.k = 0;
    }

    @Override // b.f.j.p.n$c
    public int o(b.f.j.j.e eVar) {
        return this.i.f;
    }

    @Override // b.f.j.p.n$c
    public b.f.j.j.i p() {
        return this.j.a(this.i.e);
    }

    @Override // b.f.j.p.n$c
    public synchronized boolean w(b.f.j.j.e eVar, int i) {
        boolean zF = this.g.f(eVar, i);
        if ((b.f(i) || b.m(i, 8)) && !b.m(i, 4) && b.f.j.j.e.u(eVar)) {
            eVar.x();
            if (eVar.l == b.f.i.b.a) {
                if (!this.i.b(eVar)) {
                    return false;
                }
                int i2 = this.i.e;
                int i3 = this.k;
                if (i2 <= i3) {
                    return false;
                }
                if (i2 < this.j.b(i3) && !this.i.g) {
                    return false;
                }
                this.k = i2;
            }
        }
        return zF;
    }
}
