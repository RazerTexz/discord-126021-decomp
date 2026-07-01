package d0.e0.p.d.m0.n;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c0 implements d0.e0.p.d.m0.c.g1.a, d0.e0.p.d.m0.n.n1.h {
    public int j;

    public c0() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return isMarkedNullable() == c0Var.isMarkedNullable() && d0.e0.p.d.m0.n.l1.q.a.strictEqualTypes(unwrap(), c0Var.unwrap());
    }

    public abstract List<w0> getArguments();

    public abstract u0 getConstructor();

    public abstract d0.e0.p.d.m0.k.a0.i getMemberScope();

    public final int hashCode() {
        int iHashCode;
        int i = this.j;
        if (i != 0) {
            return i;
        }
        if (e0.isError(this)) {
            iHashCode = super.hashCode();
        } else {
            iHashCode = (isMarkedNullable() ? 1 : 0) + ((getArguments().hashCode() + (getConstructor().hashCode() * 31)) * 31);
        }
        this.j = iHashCode;
        return iHashCode;
    }

    public abstract boolean isMarkedNullable();

    public abstract c0 refine(d0.e0.p.d.m0.n.l1.g gVar);

    public abstract i1 unwrap();

    public c0(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
