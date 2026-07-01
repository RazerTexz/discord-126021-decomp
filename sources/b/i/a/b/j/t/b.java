package b.i.a.b.j.t;

import b.i.a.b.j.i;
import b.i.a.b.j.u.a$a;

/* JADX INFO: compiled from: DefaultScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements a$a {
    public final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f780b;
    public final b.i.a.b.j.f c;

    public b(c cVar, i iVar, b.i.a.b.j.f fVar) {
        this.a = cVar;
        this.f780b = iVar;
        this.c = fVar;
    }

    @Override // b.i.a.b.j.u.a$a
    public Object execute() {
        c cVar = this.a;
        i iVar = this.f780b;
        cVar.e.a0(iVar, this.c);
        cVar.f781b.a(iVar, 1);
        return null;
    }
}
