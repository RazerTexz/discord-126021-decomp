package d0.e0.p.d.m0.e.a.i0.m;

import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.e.a.g0.k;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: JavaTypeResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public final k a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f3339b;
    public final boolean c;
    public final z0 d;

    public a(k kVar, b bVar, boolean z2, z0 z0Var) {
        m.checkNotNullParameter(kVar, "howThisTypeIsUsed");
        m.checkNotNullParameter(bVar, "flexibility");
        this.a = kVar;
        this.f3339b = bVar;
        this.c = z2;
        this.d = z0Var;
    }

    public static /* synthetic */ a copy$default(a aVar, k kVar, b bVar, boolean z2, z0 z0Var, int i, Object obj) {
        if ((i & 1) != 0) {
            kVar = aVar.a;
        }
        if ((i & 2) != 0) {
            bVar = aVar.f3339b;
        }
        if ((i & 4) != 0) {
            z2 = aVar.c;
        }
        if ((i & 8) != 0) {
            z0Var = aVar.d;
        }
        return aVar.copy(kVar, bVar, z2, z0Var);
    }

    public final a copy(k kVar, b bVar, boolean z2, z0 z0Var) {
        m.checkNotNullParameter(kVar, "howThisTypeIsUsed");
        m.checkNotNullParameter(bVar, "flexibility");
        return new a(kVar, bVar, z2, z0Var);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && this.f3339b == aVar.f3339b && this.c == aVar.c && m.areEqual(this.d, aVar.d);
    }

    public final b getFlexibility() {
        return this.f3339b;
    }

    public final k getHowThisTypeIsUsed() {
        return this.a;
    }

    public final z0 getUpperBoundOfTypeParameter() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public int hashCode() {
        int iHashCode = (this.f3339b.hashCode() + (this.a.hashCode() * 31)) * 31;
        boolean z2 = this.c;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iHashCode + r0) * 31;
        z0 z0Var = this.d;
        return i + (z0Var == null ? 0 : z0Var.hashCode());
    }

    public final boolean isForAnnotationParameter() {
        return this.c;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("JavaTypeAttributes(howThisTypeIsUsed=");
        sbU.append(this.a);
        sbU.append(", flexibility=");
        sbU.append(this.f3339b);
        sbU.append(", isForAnnotationParameter=");
        sbU.append(this.c);
        sbU.append(", upperBoundOfTypeParameter=");
        sbU.append(this.d);
        sbU.append(')');
        return sbU.toString();
    }

    public final a withFlexibility(b bVar) {
        m.checkNotNullParameter(bVar, "flexibility");
        return copy$default(this, null, bVar, false, null, 13, null);
    }

    public /* synthetic */ a(k kVar, b bVar, boolean z2, z0 z0Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kVar, (i & 2) != 0 ? b.INFLEXIBLE : bVar, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : z0Var);
    }
}
