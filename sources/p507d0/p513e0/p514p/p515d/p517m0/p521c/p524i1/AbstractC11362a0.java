package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.a0 */
/* JADX INFO: compiled from: PackageFragmentDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11362a0 extends AbstractC11383l implements InterfaceC11331e0 {

    /* JADX INFO: renamed from: n */
    public final C11713b f22809n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC11362a0(InterfaceC11325c0 interfaceC11325c0, C11713b c11713b) {
        super(interfaceC11325c0, InterfaceC11344g.f22735f.getEMPTY(), c11713b.shortNameOrSpecial(), InterfaceC11467u0.f23099a);
        C12238m.checkNotNullParameter(interfaceC11325c0, "module");
        C12238m.checkNotNullParameter(c11713b, "fqName");
        this.f22809n = c11713b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public <R, D> R accept(InterfaceC11454o<R, D> interfaceC11454o, D d) {
        C12238m.checkNotNullParameter(interfaceC11454o, "visitor");
        return interfaceC11454o.visitPackageFragmentDescriptor(this, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0
    public final C11713b getFqName() {
        return this.f22809n;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11383l, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11456p
    public InterfaceC11467u0 getSource() {
        InterfaceC11467u0 interfaceC11467u0 = InterfaceC11467u0.f23099a;
        C12238m.checkNotNullExpressionValue(interfaceC11467u0, "NO_SOURCE");
        return interfaceC11467u0;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11381k
    public String toString() {
        return C12238m.stringPlus("package ", this.f22809n);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11383l, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
    public InterfaceC11325c0 getContainingDeclaration() {
        return (InterfaceC11325c0) super.getContainingDeclaration();
    }
}
