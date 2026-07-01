package b.f.j.p;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: DiskCacheReadProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class q implements z.c<b.f.j.j.e, Void> {
    public final /* synthetic */ z0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x0 f634b;
    public final /* synthetic */ l c;
    public final /* synthetic */ s d;

    public q(s sVar, z0 z0Var, x0 x0Var, l lVar) {
        this.d = sVar;
        this.a = z0Var;
        this.f634b = x0Var;
        this.c = lVar;
    }

    @Override // z.c
    public Void a(z.g<b.f.j.j.e> gVar) throws Exception {
        boolean z2;
        b.f.j.j.e eVar;
        synchronized (gVar.g) {
            z2 = gVar.i;
        }
        if (z2 || (gVar.e() && (gVar.d() instanceof CancellationException))) {
            this.a.d(this.f634b, "DiskCacheProducer", null);
            this.c.d();
        } else if (gVar.e()) {
            this.a.k(this.f634b, "DiskCacheProducer", gVar.d(), null);
            this.d.d.b(this.c, this.f634b);
        } else {
            synchronized (gVar.g) {
                eVar = gVar.j;
            }
            b.f.j.j.e eVar2 = eVar;
            if (eVar2 != null) {
                z0 z0Var = this.a;
                x0 x0Var = this.f634b;
                z0Var.j(x0Var, "DiskCacheProducer", s.c(z0Var, x0Var, true, eVar2.n()));
                this.a.c(this.f634b, "DiskCacheProducer", true);
                this.f634b.n("disk");
                this.c.a(1.0f);
                this.c.b(eVar2, 1);
                eVar2.close();
            } else {
                z0 z0Var2 = this.a;
                x0 x0Var2 = this.f634b;
                z0Var2.j(x0Var2, "DiskCacheProducer", s.c(z0Var2, x0Var2, false, 0));
                this.d.d.b(this.c, this.f634b);
            }
        }
        return null;
    }
}
