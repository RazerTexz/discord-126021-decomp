package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import java.util.Collection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.C11603i;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.EnumC11602h;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.u */
/* JADX INFO: compiled from: AnnotationQualifiersFqNames.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11627u {

    /* JADX INFO: renamed from: a */
    public final C11603i f23522a;

    /* JADX INFO: renamed from: b */
    public final Collection<EnumC11485a> f23523b;

    /* JADX INFO: renamed from: c */
    public final boolean f23524c;

    /* JADX WARN: Multi-variable type inference failed */
    public C11627u(C11603i c11603i, Collection<? extends EnumC11485a> collection, boolean z2) {
        C12238m.checkNotNullParameter(c11603i, "nullabilityQualifier");
        C12238m.checkNotNullParameter(collection, "qualifierApplicabilityTypes");
        this.f23522a = c11603i;
        this.f23523b = collection;
        this.f23524c = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ C11627u copy$default(C11627u c11627u, C11603i c11603i, Collection collection, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            c11603i = c11627u.f23522a;
        }
        if ((i & 2) != 0) {
            collection = c11627u.f23523b;
        }
        if ((i & 4) != 0) {
            z2 = c11627u.f23524c;
        }
        return c11627u.copy(c11603i, collection, z2);
    }

    public final C11627u copy(C11603i c11603i, Collection<? extends EnumC11485a> collection, boolean z2) {
        C12238m.checkNotNullParameter(c11603i, "nullabilityQualifier");
        C12238m.checkNotNullParameter(collection, "qualifierApplicabilityTypes");
        return new C11627u(c11603i, collection, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11627u)) {
            return false;
        }
        C11627u c11627u = (C11627u) obj;
        return C12238m.areEqual(this.f23522a, c11627u.f23522a) && C12238m.areEqual(this.f23523b, c11627u.f23523b) && this.f23524c == c11627u.f23524c;
    }

    public final boolean getAffectsTypeParameterBasedTypes() {
        return this.f23524c;
    }

    public final boolean getMakesTypeParameterNotNull() {
        return this.f23522a.getQualifier() == EnumC11602h.NOT_NULL && this.f23524c;
    }

    public final C11603i getNullabilityQualifier() {
        return this.f23522a;
    }

    public final Collection<EnumC11485a> getQualifierApplicabilityTypes() {
        return this.f23523b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public int hashCode() {
        int iHashCode = (this.f23523b.hashCode() + (this.f23522a.hashCode() * 31)) * 31;
        boolean z2 = this.f23524c;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        return iHashCode + r0;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("JavaDefaultQualifiers(nullabilityQualifier=");
        sbM833U.append(this.f23522a);
        sbM833U.append(", qualifierApplicabilityTypes=");
        sbM833U.append(this.f23523b);
        sbM833U.append(", affectsTypeParameterBasedTypes=");
        sbM833U.append(this.f23524c);
        sbM833U.append(')');
        return sbM833U.toString();
    }

    public /* synthetic */ C11627u(C11603i c11603i, Collection collection, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(c11603i, collection, (i & 4) != 0 ? c11603i.getQualifier() == EnumC11602h.NOT_NULL : z2);
    }
}
