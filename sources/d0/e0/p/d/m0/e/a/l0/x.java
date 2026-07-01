package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.e.a.a0;
import d0.e0.p.d.m0.n.c0;
import java.util.List;

/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x {
    public static final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f3354b;

    static {
        d0.e0.p.d.m0.g.b bVar = a0.o;
        d0.z.d.m.checkNotNullExpressionValue(bVar, "ENHANCED_NULLABILITY_ANNOTATION");
        a = new b(bVar);
        d0.e0.p.d.m0.g.b bVar2 = a0.p;
        d0.z.d.m.checkNotNullExpressionValue(bVar2, "ENHANCED_MUTABILITY_ANNOTATION");
        f3354b = new b(bVar2);
    }

    public static final <T> c<T> a(T t) {
        return new c<>(t, null);
    }

    public static final d0.e0.p.d.m0.c.g1.g access$compositeAnnotationsOrSingle(List list) {
        int size = list.size();
        if (size != 0) {
            return size != 1 ? new d0.e0.p.d.m0.c.g1.k((List<? extends d0.e0.p.d.m0.c.g1.g>) d0.t.u.toList(list)) : (d0.e0.p.d.m0.c.g1.g) d0.t.u.single(list);
        }
        throw new IllegalStateException("At least one Annotations object expected".toString());
    }

    public static final c access$enhanceMutability(d0.e0.p.d.m0.c.h hVar, e eVar, t tVar) {
        c cVar;
        if (u.shouldEnhance(tVar) && (hVar instanceof d0.e0.p.d.m0.c.e)) {
            d0.e0.p.d.m0.b.q.d dVar = d0.e0.p.d.m0.b.q.d.a;
            f mutability = eVar.getMutability();
            int i = mutability == null ? -1 : x$a.a[mutability.ordinal()];
            if (i == 1) {
                if (tVar == t.FLEXIBLE_LOWER) {
                    d0.e0.p.d.m0.c.e eVar2 = (d0.e0.p.d.m0.c.e) hVar;
                    if (dVar.isMutable(eVar2)) {
                        cVar = new c(dVar.convertMutableToReadOnly(eVar2), f3354b);
                        return cVar;
                    }
                }
                return a(hVar);
            }
            if (i == 2 && tVar == t.FLEXIBLE_UPPER) {
                d0.e0.p.d.m0.c.e eVar3 = (d0.e0.p.d.m0.c.e) hVar;
                if (dVar.isReadOnly(eVar3)) {
                    cVar = new c(dVar.convertReadOnlyToMutable(eVar3), f3354b);
                    return cVar;
                }
            }
            return a(hVar);
        }
        return a(hVar);
    }

    public static final c access$getEnhancedNullability(c0 c0Var, e eVar, t tVar) {
        c cVar;
        if (!u.shouldEnhance(tVar)) {
            return a(Boolean.valueOf(c0Var.isMarkedNullable()));
        }
        h nullability = eVar.getNullability();
        int i = nullability == null ? -1 : x$a.f3355b[nullability.ordinal()];
        if (i == 1) {
            cVar = new c(Boolean.TRUE, a);
        } else {
            if (i != 2) {
                return a(Boolean.valueOf(c0Var.isMarkedNullable()));
            }
            cVar = new c(Boolean.FALSE, a);
        }
        return cVar;
    }

    public static final boolean hasEnhancedNullability(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        return v.hasEnhancedNullability(d0.e0.p.d.m0.n.l1.p.a, c0Var);
    }
}
