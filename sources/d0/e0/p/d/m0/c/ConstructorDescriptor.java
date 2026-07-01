package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeSubstitutor2;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.l, reason: use source file name */
/* JADX INFO: compiled from: ConstructorDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ConstructorDescriptor extends FunctionDescriptor {
    ClassDescriptor getConstructedClass();

    @Override // d0.e0.p.d.m0.c.FunctionDescriptor, d0.e0.p.d.m0.c.DeclarationDescriptorNonRoot, d0.e0.p.d.m0.c.DeclarationDescriptor
    ClassifierDescriptorWithTypeParameters getContainingDeclaration();

    @Override // d0.e0.p.d.m0.c.CallableDescriptor
    KotlinType getReturnType();

    @Override // d0.e0.p.d.m0.c.CallableDescriptor
    List<TypeParameterDescriptor> getTypeParameters();

    boolean isPrimary();

    @Override // d0.e0.p.d.m0.c.FunctionDescriptor, d0.e0.p.d.m0.c.Substitutable
    ConstructorDescriptor substitute(TypeSubstitutor2 typeSubstitutor2);
}
