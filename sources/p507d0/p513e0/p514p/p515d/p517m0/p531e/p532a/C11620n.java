package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11283c;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11284d;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11468v;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11787e;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.n */
/* JADX INFO: compiled from: DescriptorsJvmAbiUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11620n {
    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9517a(int i) {
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

    public static boolean hasJvmFieldAnnotation(InterfaceC11321b interfaceC11321b) {
        InterfaceC11468v backingField;
        if (interfaceC11321b == null) {
            m9517a(3);
            throw null;
        }
        if ((interfaceC11321b instanceof InterfaceC11453n0) && (backingField = ((InterfaceC11453n0) interfaceC11321b).getBackingField()) != null && backingField.getAnnotations().hasAnnotation(C11632z.f23532b)) {
            return true;
        }
        return interfaceC11321b.getAnnotations().hasAnnotation(C11632z.f23532b);
    }

    public static boolean isClassCompanionObjectWithBackingFieldsInOuter(InterfaceC11450m interfaceC11450m) {
        if (interfaceC11450m != null) {
            return C11787e.isCompanionObject(interfaceC11450m) && C11787e.isClassOrEnumClass(interfaceC11450m.getContainingDeclaration()) && !isMappedIntrinsicCompanionObject((InterfaceC11330e) interfaceC11450m);
        }
        m9517a(1);
        throw null;
    }

    public static boolean isMappedIntrinsicCompanionObject(InterfaceC11330e interfaceC11330e) {
        if (interfaceC11330e != null) {
            return C11284d.isMappedIntrinsicCompanionObject(C11283c.f22455a, interfaceC11330e);
        }
        m9517a(2);
        throw null;
    }

    public static boolean isPropertyWithBackingFieldInOuterClass(InterfaceC11453n0 interfaceC11453n0) {
        if (interfaceC11453n0 == null) {
            m9517a(0);
            throw null;
        }
        if (interfaceC11453n0.getKind() == InterfaceC11321b.a.FAKE_OVERRIDE) {
            return false;
        }
        if (isClassCompanionObjectWithBackingFieldsInOuter(interfaceC11453n0.getContainingDeclaration())) {
            return true;
        }
        return C11787e.isCompanionObject(interfaceC11453n0.getContainingDeclaration()) && hasJvmFieldAnnotation(interfaceC11453n0);
    }
}
