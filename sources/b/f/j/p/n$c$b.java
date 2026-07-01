package b.f.j.p;

/* JADX INFO: compiled from: DecodeProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class n$c$b extends e {
    public final /* synthetic */ boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n$c f628b;

    public n$c$b(n$c n_c, n nVar, boolean z2) {
        this.f628b = n_c;
        this.a = z2;
    }

    @Override // b.f.j.p.y0
    public void a() {
        if (this.a) {
            n$c n_c = this.f628b;
            n_c.u(true);
            n_c.f632b.d();
        }
    }

    @Override // b.f.j.p.e, b.f.j.p.y0
    public void b() {
        if (this.f628b.c.p()) {
            this.f628b.g.d();
        }
    }
}
