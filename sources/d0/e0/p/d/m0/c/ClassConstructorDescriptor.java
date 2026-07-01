package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.n.TypeSubstitutor2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.d, reason: use source file name */
/* JADX INFO: compiled from: ClassConstructorDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ClassConstructorDescriptor extends ConstructorDescriptor {
    @Override // d0.e0.p.d.m0.c.FunctionDescriptor, d0.e0.p.d.m0.c.CallableMemberDescriptor, d0.e0.p.d.m0.c.CallableDescriptor, d0.e0.p.d.m0.c.DeclarationDescriptor
    ClassConstructorDescriptor getOriginal();

    @Override // d0.e0.p.d.m0.c.ConstructorDescriptor, d0.e0.p.d.m0.c.FunctionDescriptor, d0.e0.p.d.m0.c.Substitutable
    ClassConstructorDescriptor substitute(TypeSubstitutor2 typeSubstitutor2);
}
