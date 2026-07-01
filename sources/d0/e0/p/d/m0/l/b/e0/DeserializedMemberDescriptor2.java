package d0.e0.p.d.m0.l.b.e0;

import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ConstructorDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.ClassConstructorDescriptorImpl;
import d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.e0.p.d.m0.f.z.TypeTable;
import d0.e0.p.d.m0.f.z.VersionRequirement;
import d0.e0.p.d.m0.f.z.VersionRequirement2;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor;
import d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.c, reason: use source file name */
/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DeserializedMemberDescriptor2 extends ClassConstructorDescriptorImpl implements DeserializedMemberDescriptor {
    public final d0.e0.p.d.m0.f.d O;
    public final NameResolver P;
    public final TypeTable Q;
    public final VersionRequirement2 R;
    public final DeserializedContainerSource2 S;
    public DeserializedMemberDescriptor3.a T;

    public /* synthetic */ DeserializedMemberDescriptor2(ClassDescriptor classDescriptor, ConstructorDescriptor constructorDescriptor, Annotations4 annotations4, boolean z2, CallableMemberDescriptor.a aVar, d0.e0.p.d.m0.f.d dVar, NameResolver nameResolver, TypeTable typeTable, VersionRequirement2 versionRequirement2, DeserializedContainerSource2 deserializedContainerSource2, SourceElement sourceElement, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(classDescriptor, constructorDescriptor, annotations4, z2, aVar, dVar, nameResolver, typeTable, versionRequirement2, deserializedContainerSource2, (i & 1024) != 0 ? null : sourceElement);
    }

    @Override // d0.e0.p.d.m0.c.i1.ClassConstructorDescriptorImpl, d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl
    public /* bridge */ /* synthetic */ FunctionDescriptorImpl b(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.a aVar, Name name, Annotations4 annotations4, SourceElement sourceElement) {
        return f(declarationDescriptor, functionDescriptor, aVar, annotations4, sourceElement);
    }

    @Override // d0.e0.p.d.m0.c.i1.ClassConstructorDescriptorImpl
    /* JADX INFO: renamed from: e */
    public /* bridge */ /* synthetic */ ClassConstructorDescriptorImpl b(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.a aVar, Name name, Annotations4 annotations4, SourceElement sourceElement) {
        return f(declarationDescriptor, functionDescriptor, aVar, annotations4, sourceElement);
    }

    public DeserializedMemberDescriptor2 f(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.a aVar, Annotations4 annotations4, SourceElement sourceElement) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(sourceElement, "source");
        DeserializedMemberDescriptor2 deserializedMemberDescriptor2 = new DeserializedMemberDescriptor2((ClassDescriptor) declarationDescriptor, (ConstructorDescriptor) functionDescriptor, annotations4, this.N, aVar, getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource(), sourceElement);
        deserializedMemberDescriptor2.setHasStableParameterNames(hasStableParameterNames());
        deserializedMemberDescriptor2.setCoroutinesExperimentalCompatibilityMode$deserialization(getCoroutinesExperimentalCompatibilityMode());
        return deserializedMemberDescriptor2;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public DeserializedContainerSource2 getContainerSource() {
        return this.S;
    }

    public DeserializedMemberDescriptor3.a getCoroutinesExperimentalCompatibilityMode() {
        return this.T;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public NameResolver getNameResolver() {
        return this.P;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public TypeTable getTypeTable() {
        return this.Q;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public VersionRequirement2 getVersionRequirementTable() {
        return this.R;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public List<VersionRequirement> getVersionRequirements() {
        return DeserializedMemberDescriptor.a.getVersionRequirements(this);
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.FunctionDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.FunctionDescriptor
    public boolean isSuspend() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl, d0.e0.p.d.m0.c.FunctionDescriptor
    public boolean isTailrec() {
        return false;
    }

    public void setCoroutinesExperimentalCompatibilityMode$deserialization(DeserializedMemberDescriptor3.a aVar) {
        Intrinsics3.checkNotNullParameter(aVar, "<set-?>");
        this.T = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberDescriptor2(ClassDescriptor classDescriptor, ConstructorDescriptor constructorDescriptor, Annotations4 annotations4, boolean z2, CallableMemberDescriptor.a aVar, d0.e0.p.d.m0.f.d dVar, NameResolver nameResolver, TypeTable typeTable, VersionRequirement2 versionRequirement2, DeserializedContainerSource2 deserializedContainerSource2, SourceElement sourceElement) {
        super(classDescriptor, constructorDescriptor, annotations4, z2, aVar, sourceElement == null ? SourceElement.a : sourceElement);
        Intrinsics3.checkNotNullParameter(classDescriptor, "containingDeclaration");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        Intrinsics3.checkNotNullParameter(dVar, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics3.checkNotNullParameter(versionRequirement2, "versionRequirementTable");
        this.O = dVar;
        this.P = nameResolver;
        this.Q = typeTable;
        this.R = versionRequirement2;
        this.S = deserializedContainerSource2;
        this.T = DeserializedMemberDescriptor3.a.COMPATIBLE;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public d0.e0.p.d.m0.f.d getProto() {
        return this.O;
    }
}
