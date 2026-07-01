package d0.e0.p.d.m0.e.a.l0;

import com.adjust.sdk.Constants;
import d0.e0.p.d.m0.e.a.a0;
import d0.e0.p.d.m0.n.d1;
import d0.t.o0;
import java.util.Set;

/* JADX INFO: compiled from: typeEnchancementUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v {
    public static final e createJavaTypeQualifiers(h hVar, f fVar, boolean z2, boolean z3) {
        return (z3 && hVar == h.NOT_NULL) ? new e(hVar, fVar, true, z2) : new e(hVar, fVar, false, z2);
    }

    public static final boolean hasEnhancedNullability(d1 d1Var, d0.e0.p.d.m0.n.n1.h hVar) {
        d0.z.d.m.checkNotNullParameter(d1Var, "<this>");
        d0.z.d.m.checkNotNullParameter(hVar, "type");
        d0.e0.p.d.m0.g.b bVar = a0.o;
        d0.z.d.m.checkNotNullExpressionValue(bVar, "ENHANCED_NULLABILITY_ANNOTATION");
        return d1Var.hasAnnotation(hVar, bVar);
    }

    public static final <T> T select(Set<? extends T> set, T t, T t2, T t3, boolean z2) {
        Set<? extends T> set2;
        T t4;
        d0.z.d.m.checkNotNullParameter(set, "<this>");
        d0.z.d.m.checkNotNullParameter(t, Constants.LOW);
        d0.z.d.m.checkNotNullParameter(t2, Constants.HIGH);
        if (!z2) {
            if (t3 != null && (set2 = d0.t.u.toSet(o0.plus(set, t3))) != null) {
                set = set2;
            }
            return (T) d0.t.u.singleOrNull(set);
        }
        if (set.contains(t)) {
            t4 = t;
        } else {
            t4 = set.contains(t2) ? t2 : null;
        }
        if (d0.z.d.m.areEqual(t4, t) && d0.z.d.m.areEqual(t3, t2)) {
            return null;
        }
        return t3 == null ? t4 : t3;
    }

    public static final h select(Set<? extends h> set, h hVar, boolean z2) {
        d0.z.d.m.checkNotNullParameter(set, "<this>");
        h hVar2 = h.FORCE_FLEXIBILITY;
        return hVar == hVar2 ? hVar2 : (h) select(set, h.NOT_NULL, h.NULLABLE, hVar, z2);
    }
}
