package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ConstructorDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptorVisitor;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.c.PackageViewDescriptor;
import d0.e0.p.d.m0.c.PropertyGetterDescriptor;
import d0.e0.p.d.m0.c.PropertySetterDescriptor;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.TypeAliasDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.VariableDescriptor;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.m, reason: use source file name */
/* JADX INFO: compiled from: DeclarationDescriptorVisitorEmptyBodies.java */
/* JADX INFO: loaded from: classes3.dex */
public class DeclarationDescriptorVisitorEmptyBodies<R, D> implements DeclarationDescriptorVisitor<R, D> {
    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
    public R visitClassDescriptor(ClassDescriptor classDescriptor, D d) {
        return visitDeclarationDescriptor(classDescriptor, d);
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
    public R visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, D d) {
        return visitFunctionDescriptor(constructorDescriptor, d);
    }

    public R visitDeclarationDescriptor(DeclarationDescriptor declarationDescriptor, D d) {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
    public R visitFunctionDescriptor(FunctionDescriptor functionDescriptor, D d) {
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
    public R visitModuleDeclaration(ModuleDescriptor2 moduleDescriptor2, D d) {
        return visitDeclarationDescriptor(moduleDescriptor2, d);
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
    public R visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, D d) {
        return visitDeclarationDescriptor(packageFragmentDescriptor, d);
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
    public R visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, D d) {
        return visitDeclarationDescriptor(packageViewDescriptor, d);
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
    public R visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, D d) {
        return visitFunctionDescriptor(propertyGetterDescriptor, d);
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
    public R visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, D d) {
        return visitFunctionDescriptor(propertySetterDescriptor, d);
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
    public R visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, D d) {
        return visitDeclarationDescriptor(receiverParameterDescriptor, d);
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
    public R visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, D d) {
        return visitDeclarationDescriptor(typeAliasDescriptor, d);
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
    public R visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, D d) {
        return visitDeclarationDescriptor(typeParameterDescriptor, d);
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorVisitor
    public R visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, D d) {
        return visitVariableDescriptor(valueParameterDescriptor, d);
    }

    public R visitVariableDescriptor(VariableDescriptor variableDescriptor, D d) {
        return visitDeclarationDescriptor(variableDescriptor, d);
    }
}
