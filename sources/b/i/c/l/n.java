package b.i.c.l;

/* JADX INFO: compiled from: CycleDetector.java */
/* JADX INFO: loaded from: classes3.dex */
public class n {
    public final Class<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1667b;

    public n(Class cls, boolean z2, l lVar) {
        this.a = cls;
        this.f1667b = z2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return nVar.a.equals(this.a) && nVar.f1667b == this.f1667b;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f1667b).hashCode();
    }
}
