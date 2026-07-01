package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.d1;
import d0.e0.p.d.m0.c.o0;
import d0.e0.p.d.m0.c.p0;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.y0;
import d0.e0.p.d.m0.c.z0;

/* JADX INFO: compiled from: DeclarationDescriptorVisitorEmptyBodies.java */
/* JADX INFO: loaded from: classes3.dex */
public class m<R, D> implements d0.e0.p.d.m0.c.o<R, D> {
    @Override // d0.e0.p.d.m0.c.o
    public R visitClassDescriptor(d0.e0.p.d.m0.c.e eVar, D d) {
        return visitDeclarationDescriptor(eVar, d);
    }

    @Override // d0.e0.p.d.m0.c.o
    public R visitConstructorDescriptor(d0.e0.p.d.m0.c.l lVar, D d) {
        return visitFunctionDescriptor(lVar, d);
    }

    public R visitDeclarationDescriptor(d0.e0.p.d.m0.c.m mVar, D d) {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.o
    public R visitFunctionDescriptor(d0.e0.p.d.m0.c.x xVar, D d) {
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.o
    public R visitModuleDeclaration(d0.e0.p.d.m0.c.c0 c0Var, D d) {
        return visitDeclarationDescriptor(c0Var, d);
    }

    @Override // d0.e0.p.d.m0.c.o
    public R visitPackageFragmentDescriptor(d0.e0.p.d.m0.c.e0 e0Var, D d) {
        return visitDeclarationDescriptor(e0Var, d);
    }

    @Override // d0.e0.p.d.m0.c.o
    public R visitPackageViewDescriptor(d0.e0.p.d.m0.c.j0 j0Var, D d) {
        return visitDeclarationDescriptor(j0Var, d);
    }

    @Override // d0.e0.p.d.m0.c.o
    public R visitPropertyGetterDescriptor(o0 o0Var, D d) {
        return visitFunctionDescriptor(o0Var, d);
    }

    @Override // d0.e0.p.d.m0.c.o
    public R visitPropertySetterDescriptor(p0 p0Var, D d) {
        return visitFunctionDescriptor(p0Var, d);
    }

    @Override // d0.e0.p.d.m0.c.o
    public R visitReceiverParameterDescriptor(q0 q0Var, D d) {
        return visitDeclarationDescriptor(q0Var, d);
    }

    @Override // d0.e0.p.d.m0.c.o
    public R visitTypeAliasDescriptor(y0 y0Var, D d) {
        return visitDeclarationDescriptor(y0Var, d);
    }

    @Override // d0.e0.p.d.m0.c.o
    public R visitTypeParameterDescriptor(z0 z0Var, D d) {
        return visitDeclarationDescriptor(z0Var, d);
    }

    @Override // d0.e0.p.d.m0.c.o
    public R visitValueParameterDescriptor(c1 c1Var, D d) {
        return visitVariableDescriptor(c1Var, d);
    }

    public R visitVariableDescriptor(d1 d1Var, D d) {
        return visitDeclarationDescriptor(d1Var, d);
    }
}
