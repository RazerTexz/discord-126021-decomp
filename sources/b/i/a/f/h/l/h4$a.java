package b.i.a.f.h.l;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class h4$a {
    public final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1447b;

    public h4$a(Object obj, int i) {
        this.a = obj;
        this.f1447b = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof h4$a)) {
            return false;
        }
        h4$a h4_a = (h4$a) obj;
        return this.a == h4_a.a && this.f1447b == h4_a.f1447b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.a) * 65535) + this.f1447b;
    }
}
