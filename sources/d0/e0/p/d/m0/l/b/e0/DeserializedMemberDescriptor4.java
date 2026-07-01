package d0.e0.p.d.m0.l.b.e0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.FieldDescriptor;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.PropertySetterDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.PropertyDescriptorImpl;
import d0.e0.p.d.m0.c.i1.PropertyGetterDescriptorImpl;
import d0.e0.p.d.m0.f.z.Flags2;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.e0.p.d.m0.f.z.TypeTable;
import d0.e0.p.d.m0.f.z.VersionRequirement;
import d0.e0.p.d.m0.f.z.VersionRequirement2;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor;
import d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.j, reason: use source file name */
/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DeserializedMemberDescriptor4 extends PropertyDescriptorImpl implements DeserializedMemberDescriptor {
    public final d0.e0.p.d.m0.f.n J;
    public final NameResolver K;
    public final TypeTable L;
    public final VersionRequirement2 M;
    public final DeserializedContainerSource2 N;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberDescriptor4(DeclarationDescriptor declarationDescriptor, PropertyDescriptor propertyDescriptor, Annotations4 annotations4, Modality modality, DescriptorVisibility2 descriptorVisibility2, boolean z2, Name name, CallableMemberDescriptor.a aVar, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, d0.e0.p.d.m0.f.n nVar, NameResolver nameResolver, TypeTable typeTable, VersionRequirement2 versionRequirement2, DeserializedContainerSource2 deserializedContainerSource2) {
        super(declarationDescriptor, propertyDescriptor, annotations4, modality, descriptorVisibility2, z2, name, aVar, SourceElement.a, z3, z4, z7, false, z5, z6);
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(modality, "modality");
        Intrinsics3.checkNotNullParameter(descriptorVisibility2, "visibility");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        Intrinsics3.checkNotNullParameter(nVar, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics3.checkNotNullParameter(versionRequirement2, "versionRequirementTable");
        this.J = nVar;
        this.K = nameResolver;
        this.L = typeTable;
        this.M = versionRequirement2;
        this.N = deserializedContainerSource2;
    }

    @Override // d0.e0.p.d.m0.c.i1.PropertyDescriptorImpl
    public PropertyDescriptorImpl b(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility2 descriptorVisibility2, PropertyDescriptor propertyDescriptor, CallableMemberDescriptor.a aVar, Name name, SourceElement sourceElement) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics3.checkNotNullParameter(modality, "newModality");
        Intrinsics3.checkNotNullParameter(descriptorVisibility2, "newVisibility");
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        Intrinsics3.checkNotNullParameter(name, "newName");
        Intrinsics3.checkNotNullParameter(sourceElement, "source");
        return new DeserializedMemberDescriptor4(declarationDescriptor, propertyDescriptor, getAnnotations(), modality, descriptorVisibility2, isVar(), name, aVar, isLateInit(), isConst(), isExternal(), isDelegated(), isExpect(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public DeserializedContainerSource2 getContainerSource() {
        return this.N;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public NameResolver getNameResolver() {
        return this.K;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public TypeTable getTypeTable() {
        return this.L;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public VersionRequirement2 getVersionRequirementTable() {
        return this.M;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public List<VersionRequirement> getVersionRequirements() {
        return DeserializedMemberDescriptor.a.getVersionRequirements(this);
    }

    public final void initialize(PropertyGetterDescriptorImpl propertyGetterDescriptorImpl, PropertySetterDescriptor propertySetterDescriptor, FieldDescriptor fieldDescriptor, FieldDescriptor fieldDescriptor2, DeserializedMemberDescriptor3.a aVar) {
        Intrinsics3.checkNotNullParameter(aVar, "isExperimentalCoroutineInReleaseEnvironment");
        super.initialize(propertyGetterDescriptorImpl, propertySetterDescriptor, fieldDescriptor, fieldDescriptor2);
    }

    @Override // d0.e0.p.d.m0.c.i1.PropertyDescriptorImpl, d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isExternal() {
        Boolean bool = Flags2.C.get(getProto().getFlags());
        Intrinsics3.checkNotNullExpressionValue(bool, "IS_EXTERNAL_PROPERTY.get(proto.flags)");
        return bool.booleanValue();
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public d0.e0.p.d.m0.f.n getProto() {
        return this.J;
    }
}
