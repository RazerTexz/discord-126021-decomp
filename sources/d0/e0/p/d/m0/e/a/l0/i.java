package d0.e0.p.d.m0.e.a.l0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NullabilityQualifierWithMigrationStatus.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public final h a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3345b;

    public i(h hVar, boolean z2) {
        d0.z.d.m.checkNotNullParameter(hVar, "qualifier");
        this.a = hVar;
        this.f3345b = z2;
    }

    public static /* synthetic */ i copy$default(i iVar, h hVar, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            hVar = iVar.a;
        }
        if ((i & 2) != 0) {
            z2 = iVar.f3345b;
        }
        return iVar.copy(hVar, z2);
    }

    public final i copy(h hVar, boolean z2) {
        d0.z.d.m.checkNotNullParameter(hVar, "qualifier");
        return new i(hVar, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.a == iVar.a && this.f3345b == iVar.f3345b;
    }

    public final h getQualifier() {
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
        StringBuilder sbU = b.d.b.a.a.U("NullabilityQualifierWithMigrationStatus(qualifier=");
        sbU.append(this.a);
        sbU.append(", isForWarningOnly=");
        sbU.append(this.f3345b);
        sbU.append(')');
        return sbU.toString();
    }

    public /* synthetic */ i(h hVar, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(hVar, (i & 2) != 0 ? false : z2);
    }
}
