package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11329d1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11402j0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11448l;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11455o0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11457p0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11475y0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.m */
/* JADX INFO: compiled from: DeclarationDescriptorVisitorEmptyBodies.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11385m<R, D> implements InterfaceC11454o<R, D> {
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
    public R visitClassDescriptor(InterfaceC11330e interfaceC11330e, D d) {
        return visitDeclarationDescriptor(interfaceC11330e, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
    public R visitConstructorDescriptor(InterfaceC11448l interfaceC11448l, D d) {
        return visitFunctionDescriptor(interfaceC11448l, d);
    }

    public R visitDeclarationDescriptor(InterfaceC11450m interfaceC11450m, D d) {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
    public R visitFunctionDescriptor(InterfaceC11472x interfaceC11472x, D d) {
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
    public R visitModuleDeclaration(InterfaceC11325c0 interfaceC11325c0, D d) {
        return visitDeclarationDescriptor(interfaceC11325c0, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
    public R visitPackageFragmentDescriptor(InterfaceC11331e0 interfaceC11331e0, D d) {
        return visitDeclarationDescriptor(interfaceC11331e0, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
    public R visitPackageViewDescriptor(InterfaceC11402j0 interfaceC11402j0, D d) {
        return visitDeclarationDescriptor(interfaceC11402j0, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
    public R visitPropertyGetterDescriptor(InterfaceC11455o0 interfaceC11455o0, D d) {
        return visitFunctionDescriptor(interfaceC11455o0, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
    public R visitPropertySetterDescriptor(InterfaceC11457p0 interfaceC11457p0, D d) {
        return visitFunctionDescriptor(interfaceC11457p0, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
    public R visitReceiverParameterDescriptor(InterfaceC11459q0 interfaceC11459q0, D d) {
        return visitDeclarationDescriptor(interfaceC11459q0, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
    public R visitTypeAliasDescriptor(InterfaceC11475y0 interfaceC11475y0, D d) {
        return visitDeclarationDescriptor(interfaceC11475y0, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
    public R visitTypeParameterDescriptor(InterfaceC11477z0 interfaceC11477z0, D d) {
        return visitDeclarationDescriptor(interfaceC11477z0, d);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
    public R visitValueParameterDescriptor(InterfaceC11326c1 interfaceC11326c1, D d) {
        return visitVariableDescriptor(interfaceC11326c1, d);
    }

    public R visitVariableDescriptor(InterfaceC11329d1 interfaceC11329d1, D d) {
        return visitDeclarationDescriptor(interfaceC11329d1, d);
    }
}
