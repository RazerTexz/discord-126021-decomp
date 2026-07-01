package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.n.c0;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r$b$a extends r$b {
    public final c0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r$b$a(c0 c0Var) {
        super(null);
        d0.z.d.m.checkNotNullParameter(c0Var, "type");
        this.a = c0Var;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r$b$a) && d0.z.d.m.areEqual(this.a, ((r$b$a) obj).a);
    }

    public final c0 getType() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("LocalClass(type=");
        sbU.append(this.a);
        sbU.append(')');
        return sbU.toString();
    }
}
