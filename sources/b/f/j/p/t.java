package b.f.j.p;

import com.facebook.imagepipeline.request.ImageRequest$c;

/* JADX INFO: compiled from: DiskCacheWriteProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class t implements w0<b.f.j.j.e> {
    public final b.f.j.c.f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.f.j.c.f f638b;
    public final b.f.j.c.i c;
    public final w0<b.f.j.j.e> d;

    public t(b.f.j.c.f fVar, b.f.j.c.f fVar2, b.f.j.c.i iVar, w0<b.f.j.j.e> w0Var) {
        this.a = fVar;
        this.f638b = fVar2;
        this.c = iVar;
        this.d = w0Var;
    }

    @Override // b.f.j.p.w0
    public void b(l<b.f.j.j.e> lVar, x0 x0Var) {
        if (x0Var.q().g() >= ImageRequest$c.DISK_CACHE.g()) {
            x0Var.i("disk", "nil-result_write");
            lVar.b(null, 1);
        } else {
            if (x0Var.e().b(32)) {
                lVar = new t$b(lVar, x0Var, this.a, this.f638b, this.c, null);
            }
            this.d.b(lVar, x0Var);
        }
    }
}
