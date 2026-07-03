package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.HashSet;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11980i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11983l;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11984m;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.u */
/* JADX INFO: compiled from: expandedTypeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12007u {
    /* JADX INFO: renamed from: a */
    public static final InterfaceC11979h m10038a(InterfaceC11917d1 interfaceC11917d1, InterfaceC11979h interfaceC11979h, HashSet<InterfaceC11983l> hashSet) {
        InterfaceC11979h interfaceC11979hM10038a;
        InterfaceC11983l interfaceC11983lTypeConstructor = interfaceC11917d1.typeConstructor(interfaceC11979h);
        if (!hashSet.add(interfaceC11983lTypeConstructor)) {
            return null;
        }
        InterfaceC11984m typeParameterClassifier = interfaceC11917d1.getTypeParameterClassifier(interfaceC11983lTypeConstructor);
        if (typeParameterClassifier != null) {
            interfaceC11979hM10038a = m10038a(interfaceC11917d1, interfaceC11917d1.getRepresentativeUpperBound(typeParameterClassifier), hashSet);
            if (interfaceC11979hM10038a == null) {
                return null;
            }
            if (!interfaceC11917d1.isNullableType(interfaceC11979hM10038a) && interfaceC11917d1.isMarkedNullable(interfaceC11979h)) {
                return interfaceC11917d1.makeNullable(interfaceC11979hM10038a);
            }
        } else {
            if (!interfaceC11917d1.isInlineClass(interfaceC11983lTypeConstructor)) {
                return interfaceC11979h;
            }
            InterfaceC11979h substitutedUnderlyingType = interfaceC11917d1.getSubstitutedUnderlyingType(interfaceC11979h);
            if (substitutedUnderlyingType == null || (interfaceC11979hM10038a = m10038a(interfaceC11917d1, substitutedUnderlyingType, hashSet)) == null) {
                return null;
            }
            if (interfaceC11917d1.isNullableType(interfaceC11979h)) {
                if (interfaceC11917d1.isNullableType(interfaceC11979hM10038a)) {
                    return interfaceC11979h;
                }
                return ((interfaceC11979hM10038a instanceof InterfaceC11980i) && interfaceC11917d1.isPrimitiveType((InterfaceC11980i) interfaceC11979hM10038a)) ? interfaceC11979h : interfaceC11917d1.makeNullable(interfaceC11979hM10038a);
            }
        }
        return interfaceC11979hM10038a;
    }

    public static final InterfaceC11979h computeExpandedTypeForInlineClass(InterfaceC11917d1 interfaceC11917d1, InterfaceC11979h interfaceC11979h) {
        C12238m.checkNotNullParameter(interfaceC11917d1, "<this>");
        C12238m.checkNotNullParameter(interfaceC11979h, "inlineClassType");
        return m10038a(interfaceC11917d1, interfaceC11979h, new HashSet());
    }
}
