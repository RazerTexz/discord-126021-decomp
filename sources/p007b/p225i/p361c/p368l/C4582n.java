package p007b.p225i.p361c.p368l;

/* JADX INFO: renamed from: b.i.c.l.n */
/* JADX INFO: compiled from: CycleDetector.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4582n {

    /* JADX INFO: renamed from: a */
    public final Class<?> f12199a;

    /* JADX INFO: renamed from: b */
    public final boolean f12200b;

    public C4582n(Class cls, boolean z2, C4580l c4580l) {
        this.f12199a = cls;
        this.f12200b = z2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C4582n)) {
            return false;
        }
        C4582n c4582n = (C4582n) obj;
        return c4582n.f12199a.equals(this.f12199a) && c4582n.f12200b == this.f12200b;
    }

    public int hashCode() {
        return ((this.f12199a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f12200b).hashCode();
    }
}
