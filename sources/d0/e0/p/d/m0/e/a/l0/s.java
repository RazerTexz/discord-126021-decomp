package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c0;

/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s {
    public final c0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.e.a.u f3353b;
    public final z0 c;
    public final boolean d;

    public s(c0 c0Var, d0.e0.p.d.m0.e.a.u uVar, z0 z0Var, boolean z2) {
        d0.z.d.m.checkNotNullParameter(c0Var, "type");
        this.a = c0Var;
        this.f3353b = uVar;
        this.c = z0Var;
        this.d = z2;
    }

    public final c0 component1() {
        return this.a;
    }

    public final d0.e0.p.d.m0.e.a.u component2() {
        return this.f3353b;
    }

    public final z0 component3() {
        return this.c;
    }

    public final boolean component4() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return d0.z.d.m.areEqual(this.a, sVar.a) && d0.z.d.m.areEqual(this.f3353b, sVar.f3353b) && d0.z.d.m.areEqual(this.c, sVar.c) && this.d == sVar.d;
    }

    public final c0 getType() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        d0.e0.p.d.m0.e.a.u uVar = this.f3353b;
        int iHashCode2 = (iHashCode + (uVar == null ? 0 : uVar.hashCode())) * 31;
        z0 z0Var = this.c;
        int iHashCode3 = (iHashCode2 + (z0Var != null ? z0Var.hashCode() : 0)) * 31;
        boolean z2 = this.d;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("TypeAndDefaultQualifiers(type=");
        sbU.append(this.a);
        sbU.append(", defaultQualifiers=");
        sbU.append(this.f3353b);
        sbU.append(", typeParameterForArgument=");
        sbU.append(this.c);
        sbU.append(", isFromStarProjection=");
        sbU.append(this.d);
        sbU.append(')');
        return sbU.toString();
    }
}
