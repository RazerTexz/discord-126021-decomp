package b.i.c.l;

/* JADX INFO: renamed from: b.i.c.l.n, reason: use source file name */
/* JADX INFO: compiled from: CycleDetector.java */
/* JADX INFO: loaded from: classes3.dex */
public class CycleDetector3 {
    public final Class<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1667b;

    public CycleDetector3(Class cls, boolean z2, CycleDetector cycleDetector) {
        this.a = cls;
        this.f1667b = z2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CycleDetector3)) {
            return false;
        }
        CycleDetector3 cycleDetector3 = (CycleDetector3) obj;
        return cycleDetector3.a.equals(this.a) && cycleDetector3.f1667b == this.f1667b;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f1667b).hashCode();
    }
}
