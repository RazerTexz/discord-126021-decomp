package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.C11779c;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.InterfaceC11780d;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.r */
/* JADX INFO: compiled from: LazyClassReceiverParameterDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11392r extends AbstractC11365c {

    /* JADX INFO: renamed from: m */
    public final InterfaceC11330e f22973m;

    /* JADX INFO: renamed from: n */
    public final C11779c f22974n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11392r(InterfaceC11330e interfaceC11330e) {
        super(InterfaceC11344g.f22735f.getEMPTY());
        if (interfaceC11330e == null) {
            m9427a(0);
            throw null;
        }
        this.f22973m = interfaceC11330e;
        this.f22974n = new C11779c(interfaceC11330e, null);
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9427a(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i == 1) {
            objArr[1] = "getValue";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i != 1 && i != 2) {
            if (i != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11450m getContainingDeclaration() {
        InterfaceC11330e interfaceC11330e = this.f22973m;
        if (interfaceC11330e != null) {
            return interfaceC11330e;
        }
        m9427a(2);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0
    public InterfaceC11780d getValue() {
        C11779c c11779c = this.f22974n;
        if (c11779c != null) {
            return c11779c;
        }
        m9427a(1);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11381k
    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("class ");
        sbM833U.append(this.f22973m.getName());
        sbM833U.append("::this");
        return sbM833U.toString();
    }
}
