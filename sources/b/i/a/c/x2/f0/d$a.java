package b.i.a.c.x2.f0;

import b.i.a.c.x2.t;
import b.i.a.c.x2.t$a;
import b.i.a.c.x2.u;

/* JADX INFO: compiled from: StartOffsetExtractorOutput.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$a implements t {
    public final /* synthetic */ t a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f1181b;

    public d$a(d dVar, t tVar) {
        this.f1181b = dVar;
        this.a = tVar;
    }

    @Override // b.i.a.c.x2.t
    public boolean c() {
        return this.a.c();
    }

    @Override // b.i.a.c.x2.t
    public t$a h(long j) {
        t$a t_aH = this.a.h(j);
        u uVar = t_aH.a;
        long j2 = uVar.f1298b;
        long j3 = uVar.c;
        long j4 = this.f1181b.j;
        u uVar2 = new u(j2, j3 + j4);
        u uVar3 = t_aH.f1296b;
        return new t$a(uVar2, new u(uVar3.f1298b, uVar3.c + j4));
    }

    @Override // b.i.a.c.x2.t
    public long i() {
        return this.a.i();
    }
}
