package d0.e0.p.d.m0.e.a.l0;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.i, reason: use source file name */
/* JADX INFO: compiled from: NullabilityQualifierWithMigrationStatus.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NullabilityQualifierWithMigrationStatus {
    public final typeQualifiers3 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3345b;

    public NullabilityQualifierWithMigrationStatus(typeQualifiers3 typequalifiers3, boolean z2) {
        Intrinsics3.checkNotNullParameter(typequalifiers3, "qualifier");
        this.a = typequalifiers3;
        this.f3345b = z2;
    }

    public static /* synthetic */ NullabilityQualifierWithMigrationStatus copy$default(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, typeQualifiers3 typequalifiers3, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            typequalifiers3 = nullabilityQualifierWithMigrationStatus.a;
        }
        if ((i & 2) != 0) {
            z2 = nullabilityQualifierWithMigrationStatus.f3345b;
        }
        return nullabilityQualifierWithMigrationStatus.copy(typequalifiers3, z2);
    }

    public final NullabilityQualifierWithMigrationStatus copy(typeQualifiers3 typequalifiers3, boolean z2) {
        Intrinsics3.checkNotNullParameter(typequalifiers3, "qualifier");
        return new NullabilityQualifierWithMigrationStatus(typequalifiers3, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NullabilityQualifierWithMigrationStatus)) {
            return false;
        }
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = (NullabilityQualifierWithMigrationStatus) obj;
        return this.a == nullabilityQualifierWithMigrationStatus.a && this.f3345b == nullabilityQualifierWithMigrationStatus.f3345b;
    }

    public final typeQualifiers3 getQualifier() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        boolean z2 = this.f3345b;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isForWarningOnly() {
        return this.f3345b;
    }

    public String toString() {
        StringBuilder sbU = outline.U("NullabilityQualifierWithMigrationStatus(qualifier=");
        sbU.append(this.a);
        sbU.append(", isForWarningOnly=");
        sbU.append(this.f3345b);
        sbU.append(')');
        return sbU.toString();
    }

    public /* synthetic */ NullabilityQualifierWithMigrationStatus(typeQualifiers3 typequalifiers3, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typequalifiers3, (i & 2) != 0 ? false : z2);
    }
}
