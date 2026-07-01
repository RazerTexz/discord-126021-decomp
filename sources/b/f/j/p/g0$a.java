package b.f.j.p;

import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: compiled from: LocalFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class g0$a extends e1<b.f.j.j.e> {
    public final /* synthetic */ ImageRequest o;
    public final /* synthetic */ z0 p;
    public final /* synthetic */ x0 q;
    public final /* synthetic */ g0 r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0$a(g0 g0Var, l lVar, z0 z0Var, x0 x0Var, String str, ImageRequest imageRequest, z0 z0Var2, x0 x0Var2) {
        super(lVar, z0Var, x0Var, str);
        this.r = g0Var;
        this.o = imageRequest;
        this.p = z0Var2;
        this.q = x0Var2;
    }

    @Override // b.f.j.p.e1
    public void b(b.f.j.j.e eVar) {
        b.f.j.j.e eVar2 = eVar;
        if (eVar2 != null) {
            eVar2.close();
        }
    }

    @Override // b.f.j.p.e1
    public b.f.j.j.e d() throws Exception {
        b.f.j.j.e eVarD = this.r.d(this.o);
        if (eVarD == null) {
            this.p.c(this.q, this.r.e(), false);
            this.q.n("local");
            return null;
        }
        eVarD.q();
        this.p.c(this.q, this.r.e(), true);
        this.q.n("local");
        return eVarD;
    }
}
