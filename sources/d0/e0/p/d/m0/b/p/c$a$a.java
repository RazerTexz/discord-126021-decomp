package d0.e0.p.d.m0.b.p;

import d0.z.d.m;

/* JADX INFO: compiled from: FunctionClassKind.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a$a {
    public final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3235b;

    public c$a$a(c cVar, int i) {
        m.checkNotNullParameter(cVar, "kind");
        this.a = cVar;
        this.f3235b = i;
    }

    public final c component1() {
        return this.a;
    }

    public final int component2() {
        return this.f3235b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c$a$a)) {
            return false;
        }
        c$a$a c_a_a = (c$a$a) obj;
        return this.a == c_a_a.a && this.f3235b == c_a_a.f3235b;
    }

    public final c getKind() {
        return this.a;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.f3235b;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("KindWithArity(kind=");
        sbU.append(this.a);
        sbU.append(", arity=");
        return b.d.b.a.a.A(sbU, this.f3235b, ')');
    }
}
