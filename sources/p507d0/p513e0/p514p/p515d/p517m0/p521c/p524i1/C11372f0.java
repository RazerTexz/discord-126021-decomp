package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.InterfaceC11780d;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.f0 */
/* JADX INFO: compiled from: ReceiverParameterDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11372f0 extends AbstractC11365c {

    /* JADX INFO: renamed from: m */
    public final InterfaceC11450m f22871m;

    /* JADX INFO: renamed from: n */
    public final InterfaceC11780d f22872n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11372f0(InterfaceC11450m interfaceC11450m, InterfaceC11780d interfaceC11780d, InterfaceC11344g interfaceC11344g) {
        super(interfaceC11344g);
        if (interfaceC11450m == null) {
            m9406a(0);
            throw null;
        }
        if (interfaceC11780d == null) {
            m9406a(1);
            throw null;
        }
        if (interfaceC11344g == null) {
            m9406a(2);
            throw null;
        }
        this.f22871m = interfaceC11450m;
        this.f22872n = interfaceC11780d;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9406a(int i) {
        String str = (i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 4) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "value";
        } else if (i == 2) {
            objArr[0] = "annotations";
        } else if (i == 3 || i == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else if (i != 5) {
            objArr[0] = "containingDeclaration";
        } else {
            objArr[0] = "newOwner";
        }
        if (i == 3) {
            objArr[1] = "getValue";
        } else if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i != 3 && i != 4) {
            if (i != 5) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 3 && i != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11450m getContainingDeclaration() {
        InterfaceC11450m interfaceC11450m = this.f22871m;
        if (interfaceC11450m != null) {
            return interfaceC11450m;
        }
        m9406a(4);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0
    public InterfaceC11780d getValue() {
        InterfaceC11780d interfaceC11780d = this.f22872n;
        if (interfaceC11780d != null) {
            return interfaceC11780d;
        }
        m9406a(3);
        throw null;
    }
}
