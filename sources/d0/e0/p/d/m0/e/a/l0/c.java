package d0.e0.p.d.m0.e.a.l0;

/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c<T> {
    public final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.c.g1.g f3342b;

    public c(T t, d0.e0.p.d.m0.c.g1.g gVar) {
        this.a = t;
        this.f3342b = gVar;
    }

    public final T component1() {
        return this.a;
    }

    public final d0.e0.p.d.m0.c.g1.g component2() {
        return this.f3342b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return d0.z.d.m.areEqual(this.a, cVar.a) && d0.z.d.m.areEqual(this.f3342b, cVar.f3342b);
    }

    public int hashCode() {
        T t = this.a;
        int iHashCode = (t == null ? 0 : t.hashCode()) * 31;
        d0.e0.p.d.m0.c.g1.g gVar = this.f3342b;
        return iHashCode + (gVar != null ? gVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("EnhancementResult(result=");
        sbU.append(this.a);
        sbU.append(", enhancementAnnotations=");
        sbU.append(this.f3342b);
        sbU.append(')');
        return sbU.toString();
    }
}
