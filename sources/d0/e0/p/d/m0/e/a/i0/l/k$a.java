package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c0;
import java.util.List;

/* JADX INFO: compiled from: LazyJavaScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k$a {
    public final c0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f3336b;
    public final List<c1> c;
    public final List<z0> d;
    public final boolean e;
    public final List<String> f;

    /* JADX WARN: Multi-variable type inference failed */
    public k$a(c0 c0Var, c0 c0Var2, List<? extends c1> list, List<? extends z0> list2, boolean z2, List<String> list3) {
        d0.z.d.m.checkNotNullParameter(c0Var, "returnType");
        d0.z.d.m.checkNotNullParameter(list, "valueParameters");
        d0.z.d.m.checkNotNullParameter(list2, "typeParameters");
        d0.z.d.m.checkNotNullParameter(list3, "errors");
        this.a = c0Var;
        this.f3336b = c0Var2;
        this.c = list;
        this.d = list2;
        this.e = z2;
        this.f = list3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k$a)) {
            return false;
        }
        k$a k_a = (k$a) obj;
        return d0.z.d.m.areEqual(this.a, k_a.a) && d0.z.d.m.areEqual(this.f3336b, k_a.f3336b) && d0.z.d.m.areEqual(this.c, k_a.c) && d0.z.d.m.areEqual(this.d, k_a.d) && this.e == k_a.e && d0.z.d.m.areEqual(this.f, k_a.f);
    }

    public final List<String> getErrors() {
        return this.f;
    }

    public final boolean getHasStableParameterNames() {
        return this.e;
    }

    public final c0 getReceiverType() {
        return this.f3336b;
    }

    public final c0 getReturnType() {
        return this.a;
    }

    public final List<z0> getTypeParameters() {
        return this.d;
    }

    public final List<c1> getValueParameters() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        c0 c0Var = this.f3336b;
        int iHashCode2 = (this.d.hashCode() + ((this.c.hashCode() + ((iHashCode + (c0Var == null ? 0 : c0Var.hashCode())) * 31)) * 31)) * 31;
        boolean z2 = this.e;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return this.f.hashCode() + ((iHashCode2 + r1) * 31);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("MethodSignatureData(returnType=");
        sbU.append(this.a);
        sbU.append(", receiverType=");
        sbU.append(this.f3336b);
        sbU.append(", valueParameters=");
        sbU.append(this.c);
        sbU.append(", typeParameters=");
        sbU.append(this.d);
        sbU.append(", hasStableParameterNames=");
        sbU.append(this.e);
        sbU.append(", errors=");
        sbU.append(this.f);
        sbU.append(')');
        return sbU.toString();
    }
}
