package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.TypeSubstitution5;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.e, reason: use source file name */
/* JADX INFO: compiled from: ClassDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ClassDescriptor extends ClassOrPackageFragmentDescriptor, ClassifierDescriptorWithTypeParameters {
    ClassDescriptor getCompanionObjectDescriptor();

    Collection<ClassConstructorDescriptor> getConstructors();

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorNonRoot, d0.e0.p.d.m0.c.DeclarationDescriptor
    DeclarationDescriptor getContainingDeclaration();

    List<TypeParameterDescriptor> getDeclaredTypeParameters();

    @Override // d0.e0.p.d.m0.c.ClassifierDescriptor
    KotlinType4 getDefaultType();

    ClassKind getKind();

    MemberScope3 getMemberScope(TypeSubstitution5 typeSubstitution5);

    Modality getModality();

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    ClassDescriptor getOriginal();

    Collection<ClassDescriptor> getSealedSubclasses();

    MemberScope3 getStaticScope();

    ReceiverParameterDescriptor getThisAsReceiverParameter();

    MemberScope3 getUnsubstitutedInnerClassesScope();

    MemberScope3 getUnsubstitutedMemberScope();

    ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor();

    DescriptorVisibility2 getVisibility();

    boolean isCompanionObject();

    boolean isData();

    boolean isFun();

    boolean isInline();

    boolean isValue();
}
