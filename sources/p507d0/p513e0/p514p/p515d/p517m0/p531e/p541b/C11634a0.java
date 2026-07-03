package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.EnumC11289i;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.C11303c;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.C11616v;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11714c;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.C11839c;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.EnumC11840d;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11917d1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11983l;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.a0 */
/* JADX INFO: compiled from: typeSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11634a0 {
    public static final <T> T boxTypeIfNeeded(InterfaceC11651l<T> interfaceC11651l, T t, boolean z2) {
        C12238m.checkNotNullParameter(interfaceC11651l, "<this>");
        C12238m.checkNotNullParameter(t, "possiblyPrimitiveType");
        return z2 ? interfaceC11651l.boxType(t) : t;
    }

    public static final <T> T mapBuiltInType(InterfaceC11917d1 interfaceC11917d1, InterfaceC11979h interfaceC11979h, InterfaceC11651l<T> interfaceC11651l, C11665z c11665z) {
        C12238m.checkNotNullParameter(interfaceC11917d1, "<this>");
        C12238m.checkNotNullParameter(interfaceC11979h, "type");
        C12238m.checkNotNullParameter(interfaceC11651l, "typeFactory");
        C12238m.checkNotNullParameter(c11665z, "mode");
        InterfaceC11983l interfaceC11983lTypeConstructor = interfaceC11917d1.typeConstructor(interfaceC11979h);
        if (!interfaceC11917d1.isClassTypeConstructor(interfaceC11983lTypeConstructor)) {
            return null;
        }
        EnumC11289i primitiveType = interfaceC11917d1.getPrimitiveType(interfaceC11983lTypeConstructor);
        boolean z2 = true;
        if (primitiveType != null) {
            T tCreatePrimitiveType = interfaceC11651l.createPrimitiveType(primitiveType);
            if (!interfaceC11917d1.isNullableType(interfaceC11979h) && !C11616v.hasEnhancedNullability(interfaceC11917d1, interfaceC11979h)) {
                z2 = false;
            }
            return (T) boxTypeIfNeeded(interfaceC11651l, tCreatePrimitiveType, z2);
        }
        EnumC11289i primitiveArrayType = interfaceC11917d1.getPrimitiveArrayType(interfaceC11983lTypeConstructor);
        if (primitiveArrayType != null) {
            return interfaceC11651l.createFromString(C12238m.stringPlus("[", EnumC11840d.get(primitiveArrayType).getDesc()));
        }
        if (interfaceC11917d1.isUnderKotlinPackage(interfaceC11983lTypeConstructor)) {
            C11714c classFqNameUnsafe = interfaceC11917d1.getClassFqNameUnsafe(interfaceC11983lTypeConstructor);
            C11712a c11712aMapKotlinToJava = classFqNameUnsafe == null ? null : C11303c.f22614a.mapKotlinToJava(classFqNameUnsafe);
            if (c11712aMapKotlinToJava != null) {
                if (!c11665z.getKotlinCollectionsToJavaCollections()) {
                    List<C11303c.a> mutabilityMappings = C11303c.f22614a.getMutabilityMappings();
                    if (!(mutabilityMappings instanceof Collection) || !mutabilityMappings.isEmpty()) {
                        Iterator<T> it = mutabilityMappings.iterator();
                        do {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                        } while (!C12238m.areEqual(((C11303c.a) it.next()).getJavaClass(), c11712aMapKotlinToJava));
                    } else {
                        z2 = false;
                        break;
                    }
                    if (z2) {
                        return null;
                    }
                }
                String internalName = C11839c.byClassId(c11712aMapKotlinToJava).getInternalName();
                C12238m.checkNotNullExpressionValue(internalName, "byClassId(classId).internalName");
                return interfaceC11651l.createObjectType2(internalName);
            }
        }
        return null;
    }
}
