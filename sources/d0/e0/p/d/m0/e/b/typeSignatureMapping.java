package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.b.PrimitiveType;
import d0.e0.p.d.m0.b.q.JavaToKotlinClassMap;
import d0.e0.p.d.m0.e.a.l0.typeEnchancementUtils;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqNameUnsafe;
import d0.e0.p.d.m0.k.y.JvmClassName;
import d0.e0.p.d.m0.k.y.JvmPrimitiveType;
import d0.e0.p.d.m0.n.TypeSystemCommonBackendContext;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.a0, reason: use source file name */
/* JADX INFO: compiled from: typeSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class typeSignatureMapping {
    public static final <T> T boxTypeIfNeeded(typeSignatureMapping3<T> typesignaturemapping3, T t, boolean z2) {
        Intrinsics3.checkNotNullParameter(typesignaturemapping3, "<this>");
        Intrinsics3.checkNotNullParameter(t, "possiblyPrimitiveType");
        return z2 ? typesignaturemapping3.boxType(t) : t;
    }

    public static final <T> T mapBuiltInType(TypeSystemCommonBackendContext typeSystemCommonBackendContext, d0.e0.p.d.m0.n.n1.h hVar, typeSignatureMapping3<T> typesignaturemapping3, TypeMappingMode typeMappingMode) {
        Intrinsics3.checkNotNullParameter(typeSystemCommonBackendContext, "<this>");
        Intrinsics3.checkNotNullParameter(hVar, "type");
        Intrinsics3.checkNotNullParameter(typesignaturemapping3, "typeFactory");
        Intrinsics3.checkNotNullParameter(typeMappingMode, "mode");
        d0.e0.p.d.m0.n.n1.l lVarTypeConstructor = typeSystemCommonBackendContext.typeConstructor(hVar);
        if (!typeSystemCommonBackendContext.isClassTypeConstructor(lVarTypeConstructor)) {
            return null;
        }
        PrimitiveType primitiveType = typeSystemCommonBackendContext.getPrimitiveType(lVarTypeConstructor);
        boolean z2 = true;
        if (primitiveType != null) {
            T tCreatePrimitiveType = typesignaturemapping3.createPrimitiveType(primitiveType);
            if (!typeSystemCommonBackendContext.isNullableType(hVar) && !typeEnchancementUtils.hasEnhancedNullability(typeSystemCommonBackendContext, hVar)) {
                z2 = false;
            }
            return (T) boxTypeIfNeeded(typesignaturemapping3, tCreatePrimitiveType, z2);
        }
        PrimitiveType primitiveArrayType = typeSystemCommonBackendContext.getPrimitiveArrayType(lVarTypeConstructor);
        if (primitiveArrayType != null) {
            return typesignaturemapping3.createFromString(Intrinsics3.stringPlus("[", JvmPrimitiveType.get(primitiveArrayType).getDesc()));
        }
        if (typeSystemCommonBackendContext.isUnderKotlinPackage(lVarTypeConstructor)) {
            FqNameUnsafe classFqNameUnsafe = typeSystemCommonBackendContext.getClassFqNameUnsafe(lVarTypeConstructor);
            ClassId classIdMapKotlinToJava = classFqNameUnsafe == null ? null : JavaToKotlinClassMap.a.mapKotlinToJava(classFqNameUnsafe);
            if (classIdMapKotlinToJava != null) {
                if (!typeMappingMode.getKotlinCollectionsToJavaCollections()) {
                    List<JavaToKotlinClassMap.a> mutabilityMappings = JavaToKotlinClassMap.a.getMutabilityMappings();
                    if (!(mutabilityMappings instanceof Collection) || !mutabilityMappings.isEmpty()) {
                        Iterator<T> it = mutabilityMappings.iterator();
                        do {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                        } while (!Intrinsics3.areEqual(((JavaToKotlinClassMap.a) it.next()).getJavaClass(), classIdMapKotlinToJava));
                    } else {
                        z2 = false;
                        break;
                    }
                    if (z2) {
                        return null;
                    }
                }
                String internalName = JvmClassName.byClassId(classIdMapKotlinToJava).getInternalName();
                Intrinsics3.checkNotNullExpressionValue(internalName, "byClassId(classId).internalName");
                return typesignaturemapping3.createObjectType2(internalName);
            }
        }
        return null;
    }
}
