package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.n.d1;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: typeSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 {
    public static final <T> T boxTypeIfNeeded(l<T> lVar, T t, boolean z2) {
        d0.z.d.m.checkNotNullParameter(lVar, "<this>");
        d0.z.d.m.checkNotNullParameter(t, "possiblyPrimitiveType");
        return z2 ? lVar.boxType(t) : t;
    }

    public static final <T> T mapBuiltInType(d1 d1Var, d0.e0.p.d.m0.n.n1.h hVar, l<T> lVar, z zVar) {
        d0.z.d.m.checkNotNullParameter(d1Var, "<this>");
        d0.z.d.m.checkNotNullParameter(hVar, "type");
        d0.z.d.m.checkNotNullParameter(lVar, "typeFactory");
        d0.z.d.m.checkNotNullParameter(zVar, "mode");
        d0.e0.p.d.m0.n.n1.l lVarTypeConstructor = d1Var.typeConstructor(hVar);
        if (!d1Var.isClassTypeConstructor(lVarTypeConstructor)) {
            return null;
        }
        d0.e0.p.d.m0.b.i primitiveType = d1Var.getPrimitiveType(lVarTypeConstructor);
        boolean z2 = true;
        if (primitiveType != null) {
            T tCreatePrimitiveType = lVar.createPrimitiveType(primitiveType);
            if (!d1Var.isNullableType(hVar) && !d0.e0.p.d.m0.e.a.l0.v.hasEnhancedNullability(d1Var, hVar)) {
                z2 = false;
            }
            return (T) boxTypeIfNeeded(lVar, tCreatePrimitiveType, z2);
        }
        d0.e0.p.d.m0.b.i primitiveArrayType = d1Var.getPrimitiveArrayType(lVarTypeConstructor);
        if (primitiveArrayType != null) {
            return lVar.createFromString(d0.z.d.m.stringPlus("[", d0.e0.p.d.m0.k.y.d.get(primitiveArrayType).getDesc()));
        }
        if (d1Var.isUnderKotlinPackage(lVarTypeConstructor)) {
            d0.e0.p.d.m0.g.c classFqNameUnsafe = d1Var.getClassFqNameUnsafe(lVarTypeConstructor);
            d0.e0.p.d.m0.g.a aVarMapKotlinToJava = classFqNameUnsafe == null ? null : d0.e0.p.d.m0.b.q.c.a.mapKotlinToJava(classFqNameUnsafe);
            if (aVarMapKotlinToJava != null) {
                if (!zVar.getKotlinCollectionsToJavaCollections()) {
                    List<d0.e0.p.d.m0.b.q.c$a> mutabilityMappings = d0.e0.p.d.m0.b.q.c.a.getMutabilityMappings();
                    if (!(mutabilityMappings instanceof Collection) || !mutabilityMappings.isEmpty()) {
                        Iterator<T> it = mutabilityMappings.iterator();
                        do {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                        } while (!d0.z.d.m.areEqual(((d0.e0.p.d.m0.b.q.c$a) it.next()).getJavaClass(), aVarMapKotlinToJava));
                    } else {
                        z2 = false;
                        break;
                    }
                    if (z2) {
                        return null;
                    }
                }
                String internalName = d0.e0.p.d.m0.k.y.c.byClassId(aVarMapKotlinToJava).getInternalName();
                d0.z.d.m.checkNotNullExpressionValue(internalName, "byClassId(classId).internalName");
                return lVar.createObjectType(internalName);
            }
        }
        return null;
    }
}
