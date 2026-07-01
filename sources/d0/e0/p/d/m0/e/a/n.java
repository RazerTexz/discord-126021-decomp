package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.c.b$a;
import d0.e0.p.d.m0.c.n0;

/* JADX INFO: compiled from: DescriptorsJvmAbiUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i == 1 || i == 2) {
            objArr[0] = "companionObject";
        } else if (i != 3) {
            objArr[0] = "propertyDescriptor";
        } else {
            objArr[0] = "memberDescriptor";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        if (i == 1) {
            objArr[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
        } else if (i == 2) {
            objArr[2] = "isMappedIntrinsicCompanionObject";
        } else if (i != 3) {
            objArr[2] = "isPropertyWithBackingFieldInOuterClass";
        } else {
            objArr[2] = "hasJvmFieldAnnotation";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static boolean hasJvmFieldAnnotation(d0.e0.p.d.m0.c.b bVar) {
        d0.e0.p.d.m0.c.v backingField;
        if (bVar == null) {
            a(3);
            throw null;
        }
        if ((bVar instanceof n0) && (backingField = ((n0) bVar).getBackingField()) != null && backingField.getAnnotations().hasAnnotation(z.f3360b)) {
            return true;
        }
        return bVar.getAnnotations().hasAnnotation(z.f3360b);
    }

    public static boolean isClassCompanionObjectWithBackingFieldsInOuter(d0.e0.p.d.m0.c.m mVar) {
        if (mVar != null) {
            return d0.e0.p.d.m0.k.e.isCompanionObject(mVar) && d0.e0.p.d.m0.k.e.isClassOrEnumClass(mVar.getContainingDeclaration()) && !isMappedIntrinsicCompanionObject((d0.e0.p.d.m0.c.e) mVar);
        }
        a(1);
        throw null;
    }

    public static boolean isMappedIntrinsicCompanionObject(d0.e0.p.d.m0.c.e eVar) {
        if (eVar != null) {
            return d0.e0.p.d.m0.b.d.isMappedIntrinsicCompanionObject(d0.e0.p.d.m0.b.c.a, eVar);
        }
        a(2);
        throw null;
    }

    public static boolean isPropertyWithBackingFieldInOuterClass(n0 n0Var) {
        if (n0Var == null) {
            a(0);
            throw null;
        }
        if (n0Var.getKind() == b$a.FAKE_OVERRIDE) {
            return false;
        }
        if (isClassCompanionObjectWithBackingFieldsInOuter(n0Var.getContainingDeclaration())) {
            return true;
        }
        return d0.e0.p.d.m0.k.e.isCompanionObject(n0Var.getContainingDeclaration()) && hasJvmFieldAnnotation(n0Var);
    }
}
