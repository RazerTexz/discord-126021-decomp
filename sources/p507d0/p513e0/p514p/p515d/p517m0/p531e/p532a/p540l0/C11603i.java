package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.i */
/* JADX INFO: compiled from: NullabilityQualifierWithMigrationStatus.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11603i {

    /* JADX INFO: renamed from: a */
    public final EnumC11602h f23464a;

    /* JADX INFO: renamed from: b */
    public final boolean f23465b;

    public C11603i(EnumC11602h enumC11602h, boolean z2) {
        C12238m.checkNotNullParameter(enumC11602h, "qualifier");
        this.f23464a = enumC11602h;
        this.f23465b = z2;
    }

    public static /* synthetic */ C11603i copy$default(C11603i c11603i, EnumC11602h enumC11602h, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            enumC11602h = c11603i.f23464a;
        }
        if ((i & 2) != 0) {
            z2 = c11603i.f23465b;
        }
        return c11603i.copy(enumC11602h, z2);
    }

    public final C11603i copy(EnumC11602h enumC11602h, boolean z2) {
        C12238m.checkNotNullParameter(enumC11602h, "qualifier");
        return new C11603i(enumC11602h, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11603i)) {
            return false;
        }
        C11603i c11603i = (C11603i) obj;
        return this.f23464a == c11603i.f23464a && this.f23465b == c11603i.f23465b;
    }

    public final EnumC11602h getQualifier() {
        return this.f23464a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iHashCode = this.f23464a.hashCode() * 31;
        boolean z2 = this.f23465b;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isForWarningOnly() {
        return this.f23465b;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("NullabilityQualifierWithMigrationStatus(qualifier=");
        sbM833U.append(this.f23464a);
        sbM833U.append(", isForWarningOnly=");
        sbM833U.append(this.f23465b);
        sbM833U.append(')');
        return sbM833U.toString();
    }

    public /* synthetic */ C11603i(EnumC11602h enumC11602h, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(enumC11602h, (i & 2) != 0 ? false : z2);
    }
}
