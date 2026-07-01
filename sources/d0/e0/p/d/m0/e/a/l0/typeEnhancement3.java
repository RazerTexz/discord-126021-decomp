package d0.e0.p.d.m0.e.a.l0;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.c, reason: use source file name */
/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class typeEnhancement3<T> {
    public final T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Annotations4 f3342b;

    public typeEnhancement3(T t, Annotations4 annotations4) {
        this.a = t;
        this.f3342b = annotations4;
    }

    public final T component1() {
        return this.a;
    }

    public final Annotations4 component2() {
        return this.f3342b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof typeEnhancement3)) {
            return false;
        }
        typeEnhancement3 typeenhancement3 = (typeEnhancement3) obj;
        return Intrinsics3.areEqual(this.a, typeenhancement3.a) && Intrinsics3.areEqual(this.f3342b, typeenhancement3.f3342b);
    }

    public int hashCode() {
        T t = this.a;
        int iHashCode = (t == null ? 0 : t.hashCode()) * 31;
        Annotations4 annotations4 = this.f3342b;
        return iHashCode + (annotations4 != null ? annotations4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("EnhancementResult(result=");
        sbU.append(this.a);
        sbU.append(", enhancementAnnotations=");
        sbU.append(this.f3342b);
        sbU.append(')');
        return sbU.toString();
    }
}
