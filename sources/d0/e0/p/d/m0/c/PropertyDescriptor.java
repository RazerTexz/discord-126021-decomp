package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.n.TypeSubstitutor2;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.n0, reason: use source file name */
/* JADX INFO: compiled from: PropertyDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public interface PropertyDescriptor extends CallableMemberDescriptor, VariableDescriptor {
    List<PropertyAccessorDescriptor> getAccessors();

    FieldDescriptor getBackingField();

    FieldDescriptor getDelegateField();

    PropertyGetterDescriptor getGetter();

    @Override // d0.e0.p.d.m0.c.CallableMemberDescriptor, d0.e0.p.d.m0.c.CallableDescriptor, d0.e0.p.d.m0.c.DeclarationDescriptor
    PropertyDescriptor getOriginal();

    @Override // d0.e0.p.d.m0.c.CallableMemberDescriptor, d0.e0.p.d.m0.c.CallableDescriptor
    Collection<? extends PropertyDescriptor> getOverriddenDescriptors();

    PropertySetterDescriptor getSetter();

    boolean isDelegated();

    @Override // d0.e0.p.d.m0.c.Substitutable
    PropertyDescriptor substitute(TypeSubstitutor2 typeSubstitutor2);
}
