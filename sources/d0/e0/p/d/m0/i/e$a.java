package d0.e0.p.d.m0.i;

/* JADX INFO: compiled from: ExtensionRegistryLite.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e$a {
    public final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3428b;

    public e$a(Object obj, int i) {
        this.a = obj;
        this.f3428b = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e$a)) {
            return false;
        }
        e$a e_a = (e$a) obj;
        return this.a == e_a.a && this.f3428b == e_a.f3428b;
    }

    public int hashCode() {
        return (System.identityHashCode(this.a) * 65535) + this.f3428b;
    }
}
