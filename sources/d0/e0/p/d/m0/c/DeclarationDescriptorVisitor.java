package d0.e0.p.d.m0.c;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.o, reason: use source file name */
/* JADX INFO: compiled from: DeclarationDescriptorVisitor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface DeclarationDescriptorVisitor<R, D> {
    R visitClassDescriptor(ClassDescriptor classDescriptor, D d);

    R visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, D d);

    R visitFunctionDescriptor(FunctionDescriptor functionDescriptor, D d);

    R visitModuleDeclaration(ModuleDescriptor2 moduleDescriptor2, D d);

    R visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, D d);

    R visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, D d);

    R visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, D d);

    R visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, D d);

    R visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, D d);

    R visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, D d);

    R visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, D d);

    R visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, D d);

    R visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, D d);
}
