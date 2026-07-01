package b.i.c.l;

/* JADX INFO: compiled from: ComponentRuntime.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class h implements b.i.c.t.a {
    public final k a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f1664b;

    public h(k kVar, d dVar) {
        this.a = kVar;
        this.f1664b = dVar;
    }

    @Override // b.i.c.t.a
    public Object get() {
        k kVar = this.a;
        d dVar = this.f1664b;
        int i = k.a;
        return dVar.e.a(new s(dVar, kVar));
    }
}
