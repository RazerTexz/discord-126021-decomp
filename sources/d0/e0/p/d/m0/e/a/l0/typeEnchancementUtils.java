package d0.e0.p.d.m0.e.a.l0;

import com.adjust.sdk.Constants;
import d0.e0.p.d.m0.e.a.JvmAnnotationNames;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.n.TypeSystemCommonBackendContext;
import d0.t._Collections;
import d0.t._Sets;
import d0.z.d.Intrinsics3;
import java.util.Set;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.v, reason: use source file name */
/* JADX INFO: compiled from: typeEnchancementUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class typeEnchancementUtils {
    public static final typeQualifiers createJavaTypeQualifiers(typeQualifiers3 typequalifiers3, typeQualifiers2 typequalifiers2, boolean z2, boolean z3) {
        return (z3 && typequalifiers3 == typeQualifiers3.NOT_NULL) ? new typeQualifiers(typequalifiers3, typequalifiers2, true, z2) : new typeQualifiers(typequalifiers3, typequalifiers2, false, z2);
    }

    public static final boolean hasEnhancedNullability(TypeSystemCommonBackendContext typeSystemCommonBackendContext, d0.e0.p.d.m0.n.n1.h hVar) {
        Intrinsics3.checkNotNullParameter(typeSystemCommonBackendContext, "<this>");
        Intrinsics3.checkNotNullParameter(hVar, "type");
        FqName fqName = JvmAnnotationNames.o;
        Intrinsics3.checkNotNullExpressionValue(fqName, "ENHANCED_NULLABILITY_ANNOTATION");
        return typeSystemCommonBackendContext.hasAnnotation(hVar, fqName);
    }

    public static final <T> T select(Set<? extends T> set, T t, T t2, T t3, boolean z2) {
        Set<? extends T> set2;
        T t4;
        Intrinsics3.checkNotNullParameter(set, "<this>");
        Intrinsics3.checkNotNullParameter(t, Constants.LOW);
        Intrinsics3.checkNotNullParameter(t2, Constants.HIGH);
        if (!z2) {
            if (t3 != null && (set2 = _Collections.toSet(_Sets.plus(set, t3))) != null) {
                set = set2;
            }
            return (T) _Collections.singleOrNull(set);
        }
        if (set.contains(t)) {
            t4 = t;
        } else {
            t4 = set.contains(t2) ? t2 : null;
        }
        if (Intrinsics3.areEqual(t4, t) && Intrinsics3.areEqual(t3, t2)) {
            return null;
        }
        return t3 == null ? t4 : t3;
    }

    public static final typeQualifiers3 select(Set<? extends typeQualifiers3> set, typeQualifiers3 typequalifiers3, boolean z2) {
        Intrinsics3.checkNotNullParameter(set, "<this>");
        typeQualifiers3 typequalifiers4 = typeQualifiers3.FORCE_FLEXIBILITY;
        return typequalifiers3 == typequalifiers4 ? typequalifiers4 : (typeQualifiers3) select(set, typeQualifiers3.NOT_NULL, typeQualifiers3.NULLABLE, typequalifiers3, z2);
    }
}
