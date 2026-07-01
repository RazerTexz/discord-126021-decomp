package d0.e0.p.d.m0.e.a;

import b.d.b.a.outline;
import d0.e0.p.d.m0.e.a.l0.NullabilityQualifierWithMigrationStatus;
import d0.e0.p.d.m0.e.a.l0.typeQualifiers3;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.u, reason: use source file name */
/* JADX INFO: compiled from: AnnotationQualifiersFqNames.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationQualifiersFqNames2 {
    public final NullabilityQualifierWithMigrationStatus a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Collection<AnnotationQualifierApplicabilityType> f3358b;
    public final boolean c;

    /* JADX WARN: Multi-variable type inference failed */
    public AnnotationQualifiersFqNames2(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection<? extends AnnotationQualifierApplicabilityType> collection, boolean z2) {
        Intrinsics3.checkNotNullParameter(nullabilityQualifierWithMigrationStatus, "nullabilityQualifier");
        Intrinsics3.checkNotNullParameter(collection, "qualifierApplicabilityTypes");
        this.a = nullabilityQualifierWithMigrationStatus;
        this.f3358b = collection;
        this.c = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnnotationQualifiersFqNames2 copy$default(AnnotationQualifiersFqNames2 annotationQualifiersFqNames2, NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection collection, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            nullabilityQualifierWithMigrationStatus = annotationQualifiersFqNames2.a;
        }
        if ((i & 2) != 0) {
            collection = annotationQualifiersFqNames2.f3358b;
        }
        if ((i & 4) != 0) {
            z2 = annotationQualifiersFqNames2.c;
        }
        return annotationQualifiersFqNames2.copy(nullabilityQualifierWithMigrationStatus, collection, z2);
    }

    public final AnnotationQualifiersFqNames2 copy(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection<? extends AnnotationQualifierApplicabilityType> collection, boolean z2) {
        Intrinsics3.checkNotNullParameter(nullabilityQualifierWithMigrationStatus, "nullabilityQualifier");
        Intrinsics3.checkNotNullParameter(collection, "qualifierApplicabilityTypes");
        return new AnnotationQualifiersFqNames2(nullabilityQualifierWithMigrationStatus, collection, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnnotationQualifiersFqNames2)) {
            return false;
        }
        AnnotationQualifiersFqNames2 annotationQualifiersFqNames2 = (AnnotationQualifiersFqNames2) obj;
        return Intrinsics3.areEqual(this.a, annotationQualifiersFqNames2.a) && Intrinsics3.areEqual(this.f3358b, annotationQualifiersFqNames2.f3358b) && this.c == annotationQualifiersFqNames2.c;
    }

    public final boolean getAffectsTypeParameterBasedTypes() {
        return this.c;
    }

    public final boolean getMakesTypeParameterNotNull() {
        return this.a.getQualifier() == typeQualifiers3.NOT_NULL && this.c;
    }

    public final NullabilityQualifierWithMigrationStatus getNullabilityQualifier() {
        return this.a;
    }

    public final Collection<AnnotationQualifierApplicabilityType> getQualifierApplicabilityTypes() {
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
        StringBuilder sbU = outline.U("JavaDefaultQualifiers(nullabilityQualifier=");
        sbU.append(this.a);
        sbU.append(", qualifierApplicabilityTypes=");
        sbU.append(this.f3358b);
        sbU.append(", affectsTypeParameterBasedTypes=");
        sbU.append(this.c);
        sbU.append(')');
        return sbU.toString();
    }

    public /* synthetic */ AnnotationQualifiersFqNames2(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection collection, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nullabilityQualifierWithMigrationStatus, collection, (i & 4) != 0 ? nullabilityQualifierWithMigrationStatus.getQualifier() == typeQualifiers3.NOT_NULL : z2);
    }
}
