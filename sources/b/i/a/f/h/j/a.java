package b.i.a.f.h.j;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends e {
    public final r l;

    public a(g gVar, i iVar) {
        super(gVar);
        this.l = new r(gVar, iVar);
    }

    @Override // b.i.a.f.h.j.e
    public final void L() {
        this.l.J();
    }

    public final void O() {
        b.i.a.f.b.f.b();
        r rVar = this.l;
        Objects.requireNonNull(rVar);
        b.i.a.f.b.f.b();
        Objects.requireNonNull((b.i.a.f.e.o.c) rVar.j.d);
        rVar.u = System.currentTimeMillis();
    }
}
