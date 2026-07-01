package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.n.KotlinType;
import java.util.Collection;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.c1, reason: use source file name */
/* JADX INFO: compiled from: ValueParameterDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ValueParameterDescriptor extends ParameterDescriptor, VariableDescriptor {
    ValueParameterDescriptor copy(CallableDescriptor callableDescriptor, Name name, int i);

    boolean declaresDefaultValue();

    @Override // d0.e0.p.d.m0.c.ValueDescriptor2, d0.e0.p.d.m0.c.DeclarationDescriptorNonRoot, d0.e0.p.d.m0.c.DeclarationDescriptor
    CallableDescriptor getContainingDeclaration();

    int getIndex();

    @Override // d0.e0.p.d.m0.c.CallableDescriptor, d0.e0.p.d.m0.c.DeclarationDescriptor
    ValueParameterDescriptor getOriginal();

    @Override // d0.e0.p.d.m0.c.CallableDescriptor
    Collection<ValueParameterDescriptor> getOverriddenDescriptors();

    KotlinType getVarargElementType();

    boolean isCrossinline();

    boolean isNoinline();
}
