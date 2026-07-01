package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.c.f1;

/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 {
    public static final v lexicalCastFrom(d0.e0.p.d.m0.n.c0 c0Var, String str) {
        Object doubleOrNull;
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.z.d.m.checkNotNullParameter(str, "value");
        d0.e0.p.d.m0.c.h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof d0.e0.p.d.m0.c.e) {
            d0.e0.p.d.m0.c.e eVar = (d0.e0.p.d.m0.c.e) declarationDescriptor;
            if (eVar.getKind() == d0.e0.p.d.m0.c.f.ENUM_CLASS) {
                d0.e0.p.d.m0.k.a0.i unsubstitutedInnerClassesScope = eVar.getUnsubstitutedInnerClassesScope();
                d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(str);
                d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "identifier(value)");
                d0.e0.p.d.m0.c.h contributedClassifier = unsubstitutedInnerClassesScope.getContributedClassifier(eVarIdentifier, d0.e0.p.d.m0.d.b.d.FROM_BACKEND);
                if (!(contributedClassifier instanceof d0.e0.p.d.m0.c.e)) {
                    return null;
                }
                d0.e0.p.d.m0.c.e eVar2 = (d0.e0.p.d.m0.c.e) contributedClassifier;
                if (eVar2.getKind() == d0.e0.p.d.m0.c.f.ENUM_ENTRY) {
                    return new o(eVar2);
                }
                return null;
            }
        }
        d0.e0.p.d.m0.n.c0 c0VarMakeNotNullable = d0.e0.p.d.m0.n.o1.a.makeNotNullable(c0Var);
        d0.e0.p.d.m0.p.f fVarExtractRadix = d0.e0.p.d.m0.p.g.extractRadix(str);
        String strComponent1 = fVarExtractRadix.component1();
        int iComponent2 = fVarExtractRadix.component2();
        try {
            if (d0.e0.p.d.m0.b.h.isBoolean(c0VarMakeNotNullable)) {
                doubleOrNull = Boolean.valueOf(Boolean.parseBoolean(str));
            } else if (d0.e0.p.d.m0.b.h.isChar(c0VarMakeNotNullable)) {
                doubleOrNull = d0.g0.y.singleOrNull(str);
            } else if (d0.e0.p.d.m0.b.h.isByte(c0VarMakeNotNullable)) {
                doubleOrNull = d0.g0.s.toByteOrNull(strComponent1, iComponent2);
            } else if (d0.e0.p.d.m0.b.h.isShort(c0VarMakeNotNullable)) {
                doubleOrNull = d0.g0.s.toShortOrNull(strComponent1, iComponent2);
            } else if (d0.e0.p.d.m0.b.h.isInt(c0VarMakeNotNullable)) {
                doubleOrNull = d0.g0.s.toIntOrNull(strComponent1, iComponent2);
            } else if (d0.e0.p.d.m0.b.h.isLong(c0VarMakeNotNullable)) {
                doubleOrNull = d0.g0.s.toLongOrNull(strComponent1, iComponent2);
            } else if (d0.e0.p.d.m0.b.h.isFloat(c0VarMakeNotNullable)) {
                doubleOrNull = d0.g0.r.toFloatOrNull(str);
            } else if (d0.e0.p.d.m0.b.h.isDouble(c0VarMakeNotNullable)) {
                doubleOrNull = d0.g0.r.toDoubleOrNull(str);
            } else {
                doubleOrNull = d0.e0.p.d.m0.b.h.isString(c0VarMakeNotNullable) ? null : null;
            }
        } catch (IllegalArgumentException unused) {
        }
        if (doubleOrNull != null) {
            return new l(doubleOrNull);
        }
        return null;
    }

    public static final d0.e0.p.d.m0.c.u toDescriptorVisibility(f1 f1Var) {
        d0.z.d.m.checkNotNullParameter(f1Var, "<this>");
        d0.e0.p.d.m0.c.u descriptorVisibility = w.toDescriptorVisibility(f1Var);
        d0.z.d.m.checkNotNullExpressionValue(descriptorVisibility, "toDescriptorVisibility(this)");
        return descriptorVisibility;
    }
}
