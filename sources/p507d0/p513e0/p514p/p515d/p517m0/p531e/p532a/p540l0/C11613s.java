package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.C11627u;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.s */
/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11613s {

    /* JADX INFO: renamed from: a */
    public final AbstractC11913c0 f23499a;

    /* JADX INFO: renamed from: b */
    public final C11627u f23500b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC11477z0 f23501c;

    /* JADX INFO: renamed from: d */
    public final boolean f23502d;

    public C11613s(AbstractC11913c0 abstractC11913c0, C11627u c11627u, InterfaceC11477z0 interfaceC11477z0, boolean z2) {
        C12238m.checkNotNullParameter(abstractC11913c0, "type");
        this.f23499a = abstractC11913c0;
        this.f23500b = c11627u;
        this.f23501c = interfaceC11477z0;
        this.f23502d = z2;
    }

    public final AbstractC11913c0 component1() {
        return this.f23499a;
    }

    public final C11627u component2() {
        return this.f23500b;
    }

    public final InterfaceC11477z0 component3() {
        return this.f23501c;
    }

    public final boolean component4() {
        return this.f23502d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11613s)) {
            return false;
        }
        C11613s c11613s = (C11613s) obj;
        return C12238m.areEqual(this.f23499a, c11613s.f23499a) && C12238m.areEqual(this.f23500b, c11613s.f23500b) && C12238m.areEqual(this.f23501c, c11613s.f23501c) && this.f23502d == c11613s.f23502d;
    }

    public final AbstractC11913c0 getType() {
        return this.f23499a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public int hashCode() {
        int iHashCode = this.f23499a.hashCode() * 31;
        C11627u c11627u = this.f23500b;
        int iHashCode2 = (iHashCode + (c11627u == null ? 0 : c11627u.hashCode())) * 31;
        InterfaceC11477z0 interfaceC11477z0 = this.f23501c;
        int iHashCode3 = (iHashCode2 + (interfaceC11477z0 != null ? interfaceC11477z0.hashCode() : 0)) * 31;
        boolean z2 = this.f23502d;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TypeAndDefaultQualifiers(type=");
        sbM833U.append(this.f23499a);
        sbM833U.append(", defaultQualifiers=");
        sbM833U.append(this.f23500b);
        sbM833U.append(", typeParameterForArgument=");
        sbM833U.append(this.f23501c);
        sbM833U.append(", isFromStarProjection=");
        sbM833U.append(this.f23502d);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}
