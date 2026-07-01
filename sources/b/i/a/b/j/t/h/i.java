package b.i.a.b.j.t.h;

import b.i.a.b.j.q.g$a;
import b.i.a.b.j.u.a$a;

/* JADX INFO: compiled from: Uploader.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i implements a$a {
    public final l a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.b.j.q.g f789b;
    public final Iterable c;
    public final b.i.a.b.j.i d;
    public final int e;

    public i(l lVar, b.i.a.b.j.q.g gVar, Iterable iterable, b.i.a.b.j.i iVar, int i) {
        this.a = lVar;
        this.f789b = gVar;
        this.c = iterable;
        this.d = iVar;
        this.e = i;
    }

    @Override // b.i.a.b.j.u.a$a
    public Object execute() {
        l lVar = this.a;
        b.i.a.b.j.q.g gVar = this.f789b;
        Iterable<b.i.a.b.j.t.i.h> iterable = this.c;
        b.i.a.b.j.i iVar = this.d;
        int i = this.e;
        if (gVar.c() == g$a.TRANSIENT_ERROR) {
            lVar.c.n0(iterable);
            lVar.d.a(iVar, i + 1);
            return null;
        }
        lVar.c.m(iterable);
        if (gVar.c() == g$a.OK) {
            lVar.c.v(iVar, gVar.b() + lVar.g.a());
        }
        if (!lVar.c.l0(iVar)) {
            return null;
        }
        lVar.d.a(iVar, 1);
        return null;
    }
}
