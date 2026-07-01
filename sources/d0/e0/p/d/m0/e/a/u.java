package d0.e0.p.d.m0.e.a;

import java.util.Collection;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AnnotationQualifiersFqNames.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u {
    public final d0.e0.p.d.m0.e.a.l0.i a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Collection<a> f3358b;
    public final boolean c;

    /* JADX WARN: Multi-variable type inference failed */
    public u(d0.e0.p.d.m0.e.a.l0.i iVar, Collection<? extends a> collection, boolean z2) {
        d0.z.d.m.checkNotNullParameter(iVar, "nullabilityQualifier");
        d0.z.d.m.checkNotNullParameter(collection, "qualifierApplicabilityTypes");
        this.a = iVar;
        this.f3358b = collection;
        this.c = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ u copy$default(u uVar, d0.e0.p.d.m0.e.a.l0.i iVar, Collection collection, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            iVar = uVar.a;
        }
        if ((i & 2) != 0) {
            collection = uVar.f3358b;
        }
        if ((i & 4) != 0) {
            z2 = uVar.c;
        }
        return uVar.copy(iVar, collection, z2);
    }

    public final u copy(d0.e0.p.d.m0.e.a.l0.i iVar, Collection<? extends a> collection, boolean z2) {
        d0.z.d.m.checkNotNullParameter(iVar, "nullabilityQualifier");
        d0.z.d.m.checkNotNullParameter(collection, "qualifierApplicabilityTypes");
        return new u(iVar, collection, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return d0.z.d.m.areEqual(this.a, uVar.a) && d0.z.d.m.areEqual(this.f3358b, uVar.f3358b) && this.c == uVar.c;
    }

    public final boolean getAffectsTypeParameterBasedTypes() {
        return this.c;
    }

    public final boolean getMakesTypeParameterNotNull() {
        return this.a.getQualifier() == d0.e0.p.d.m0.e.a.l0.h.NOT_NULL && this.c;
    }

    public final d0.e0.p.d.m0.e.a.l0.i getNullabilityQualifier() {
        return this.a;
    }

    public final Collection<a> getQualifierApplicabilityTypes() {
        return this.f3358b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public int hashCode() {
        int iHashCode = (this.f3358b.hashCode() + (this.a.hashCode() * 31)) * 31;
        boolean z2 = this.c;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        return iHashCode + r0;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("JavaDefaultQualifiers(nullabilityQualifier=");
        sbU.append(this.a);
        sbU.append(", qualifierApplicabilityTypes=");
        sbU.append(this.f3358b);
        sbU.append(", affectsTypeParameterBasedTypes=");
        sbU.append(this.c);
        sbU.append(')');
        return sbU.toString();
    }

    public /* synthetic */ u(d0.e0.p.d.m0.e.a.l0.i iVar, Collection collection, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iVar, collection, (i & 4) != 0 ? iVar.getQualifier() == d0.e0.p.d.m0.e.a.l0.h.NOT_NULL : z2);
    }
}
