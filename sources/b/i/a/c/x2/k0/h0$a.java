package b.i.a.c.x2.k0;

/* JADX INFO: compiled from: TsExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public class h0$a implements c0 {
    public final b.i.a.c.f3.w a = new b.i.a.c.f3.w(new byte[4]);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h0 f1254b;

    public h0$a(h0 h0Var) {
        this.f1254b = h0Var;
    }

    @Override // b.i.a.c.x2.k0.c0
    public void a(b.i.a.c.f3.d0 d0Var, b.i.a.c.x2.j jVar, i0$d i0_d) {
    }

    @Override // b.i.a.c.x2.k0.c0
    public void b(b.i.a.c.f3.x xVar) {
        if (xVar.t() == 0 && (xVar.t() & 128) != 0) {
            xVar.F(6);
            int iA = xVar.a() / 4;
            for (int i = 0; i < iA; i++) {
                xVar.d(this.a, 4);
                int iG = this.a.g(16);
                this.a.m(3);
                if (iG == 0) {
                    this.a.m(13);
                } else {
                    int iG2 = this.a.g(13);
                    if (this.f1254b.g.get(iG2) == null) {
                        h0 h0Var = this.f1254b;
                        h0Var.g.put(iG2, new d0(new h0$b(h0Var, iG2)));
                        this.f1254b.m++;
                    }
                }
            }
            h0 h0Var2 = this.f1254b;
            if (h0Var2.a != 2) {
                h0Var2.g.remove(0);
            }
        }
    }
}
