package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.u0;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: IntegerLiteralTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n$a {
    public n$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v14, types: [d0.e0.p.d.m0.n.j0] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [d0.e0.p.d.m0.n.c0, d0.e0.p.d.m0.n.j0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v1 */
    public final j0 findIntersectionType(Collection<? extends j0> collection) {
        d0.z.d.m.checkNotNullParameter(collection, "types");
        if (collection.isEmpty()) {
            return null;
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        ?? next = it.next();
        while (it.hasNext()) {
            j0 j0Var = (j0) it.next();
            next = (j0) next;
            if (next != 0 && j0Var != null) {
                u0 constructor = next.getConstructor();
                u0 constructor2 = j0Var.getConstructor();
                boolean z2 = constructor instanceof n;
                if (z2 && (constructor2 instanceof n)) {
                    n nVar = (n) constructor;
                    n nVar2 = new n(n.access$getValue$p(nVar), n.access$getModule$p(nVar), d0.t.u.union(nVar.getPossibleTypes(), ((n) constructor2).getPossibleTypes()), null);
                    d0 d0Var = d0.a;
                    next = d0.integerLiteralType(d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), nVar2, false);
                } else if (z2) {
                    if (((n) constructor).getPossibleTypes().contains(j0Var)) {
                        next = j0Var;
                    }
                } else if (!(constructor2 instanceof n) || !((n) constructor2).getPossibleTypes().contains(next)) {
                }
            }
            next = 0;
        }
        return (j0) next;
    }
}
