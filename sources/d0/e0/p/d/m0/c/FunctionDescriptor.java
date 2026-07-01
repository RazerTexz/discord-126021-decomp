package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeSubstitution5;
import d0.e0.p.d.m0.n.TypeSubstitutor2;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.x, reason: use source file name */
/* JADX INFO: compiled from: FunctionDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface FunctionDescriptor extends CallableMemberDescriptor {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.x$a */
    /* JADX INFO: compiled from: FunctionDescriptor.java */
    public interface a<D extends FunctionDescriptor> {
        D build();

        a<D> setAdditionalAnnotations(Annotations4 annotations4);

        a<D> setCopyOverrides(boolean z2);

        a<D> setDispatchReceiverParameter(ReceiverParameterDescriptor receiverParameterDescriptor);

        a<D> setDropOriginalInContainingParts();

        a<D> setExtensionReceiverParameter(ReceiverParameterDescriptor receiverParameterDescriptor);

        a<D> setHiddenForResolutionEverywhereBesideSupercalls();

        a<D> setHiddenToOvercomeSignatureClash();

        a<D> setKind(CallableMemberDescriptor.a aVar);

        a<D> setModality(Modality modality);

        a<D> setName(Name name);

        a<D> setOriginal(CallableMemberDescriptor callableMemberDescriptor);

        a<D> setOwner(DeclarationDescriptor declarationDescriptor);

        a<D> setPreserveSourceElement();

        a<D> setReturnType(KotlinType kotlinType);

        a<D> setSignatureChange();

        a<D> setSubstitution(TypeSubstitution5 typeSubstitution5);

        a<D> setTypeParameters(List<TypeParameterDescriptor> list);

        a<D> setValueParameters(List<ValueParameterDescriptor> list);

        a<D> setVisibility(DescriptorVisibility2 descriptorVisibility2);
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptorNonRoot, d0.e0.p.d.m0.c.DeclarationDescriptor
    DeclarationDescriptor getContainingDeclaration();

    FunctionDescriptor getInitialSignatureDescriptor();

    @Override // d0.e0.p.d.m0.c.CallableMemberDescriptor, d0.e0.p.d.m0.c.CallableDescriptor, d0.e0.p.d.m0.c.DeclarationDescriptor
    FunctionDescriptor getOriginal();

    @Override // d0.e0.p.d.m0.c.CallableMemberDescriptor, d0.e0.p.d.m0.c.CallableDescriptor
    Collection<? extends FunctionDescriptor> getOverriddenDescriptors();

    boolean isHiddenForResolutionEverywhereBesideSupercalls();

    boolean isHiddenToOvercomeSignatureClash();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();

    boolean isTailrec();

    a<? extends FunctionDescriptor> newCopyBuilder();

    FunctionDescriptor substitute(TypeSubstitutor2 typeSubstitutor2);
}
