package b.i.c.m.d.q.d;

/* JADX INFO: compiled from: CompositeCreateReportSpiCall.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements b {
    public final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f1744b;

    public a(c cVar, d dVar) {
        this.a = cVar;
        this.f1744b = dVar;
    }

    @Override // b.i.c.m.d.q.d.b
    public boolean a(b.i.c.m.d.q.c.a aVar, boolean z2) {
        int iH = b.c.a.y.b.h(aVar.c.d());
        if (iH == 0) {
            this.a.a(aVar, z2);
            return true;
        }
        if (iH != 1) {
            return false;
        }
        this.f1744b.a(aVar, z2);
        return true;
    }
}
