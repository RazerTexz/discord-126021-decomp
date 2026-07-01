package d0.e0.p.d.m0.l.b.e0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.FunctionDescriptor;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.ValueParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl;
import d0.e0.p.d.m0.c.i1.SimpleFunctionDescriptorImpl;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.e0.p.d.m0.f.z.TypeTable;
import d0.e0.p.d.m0.f.z.VersionRequirement;
import d0.e0.p.d.m0.f.z.VersionRequirement2;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor;
import d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3;
import d0.e0.p.d.m0.n.KotlinType;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.k, reason: use source file name */
/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DeserializedMemberDescriptor5 extends SimpleFunctionDescriptorImpl implements DeserializedMemberDescriptor {
    public final d0.e0.p.d.m0.f.i M;
    public final NameResolver N;
    public final TypeTable O;
    public final VersionRequirement2 P;
    public final DeserializedContainerSource2 Q;
    public DeserializedMemberDescriptor3.a R;

    public /* synthetic */ DeserializedMemberDescriptor5(DeclarationDescriptor declarationDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor, Annotations4 annotations4, Name name, CallableMemberDescriptor.a aVar, d0.e0.p.d.m0.f.i iVar, NameResolver nameResolver, TypeTable typeTable, VersionRequirement2 versionRequirement2, DeserializedContainerSource2 deserializedContainerSource2, SourceElement sourceElement, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(declarationDescriptor, simpleFunctionDescriptor, annotations4, name, aVar, iVar, nameResolver, typeTable, versionRequirement2, deserializedContainerSource2, (i & 1024) != 0 ? null : sourceElement);
    }

    @Override // d0.e0.p.d.m0.c.i1.SimpleFunctionDescriptorImpl, d0.e0.p.d.m0.c.i1.FunctionDescriptorImpl
    public FunctionDescriptorImpl b(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.a aVar, Name name, Annotations4 annotations4, SourceElement sourceElement) {
        Name name2;
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(sourceElement, "source");
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) functionDescriptor;
        if (name == null) {
            Name name3 = getName();
            Intrinsics3.checkNotNullExpressionValue(name3, ModelAuditLogEntry.CHANGE_KEY_NAME);
            name2 = name3;
        } else {
            name2 = name;
        }
        DeserializedMemberDescriptor5 deserializedMemberDescriptor5 = new DeserializedMemberDescriptor5(declarationDescriptor, simpleFunctionDescriptor, annotations4, name2, aVar, getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource(), sourceElement);
        deserializedMemberDescriptor5.setHasStableParameterNames(hasStableParameterNames());
        deserializedMemberDescriptor5.R = getCoroutinesExperimentalCompatibilityMode();
        return deserializedMemberDescriptor5;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public DeserializedContainerSource2 getContainerSource() {
        return this.Q;
    }

    public DeserializedMemberDescriptor3.a getCoroutinesExperimentalCompatibilityMode() {
        return this.R;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public NameResolver getNameResolver() {
        return this.N;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public TypeTable getTypeTable() {
        return this.O;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public VersionRequirement2 getVersionRequirementTable() {
        return this.P;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public List<VersionRequirement> getVersionRequirements() {
        return DeserializedMemberDescriptor.a.getVersionRequirements(this);
    }

    public final SimpleFunctionDescriptorImpl initialize(ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2, List<? extends TypeParameterDescriptor> list, List<? extends ValueParameterDescriptor> list2, KotlinType kotlinType, Modality modality, DescriptorVisibility2 descriptorVisibility2, Map<? extends CallableDescriptor.a<?>, ?> map, DeserializedMemberDescriptor3.a aVar) {
        Intrinsics3.checkNotNullParameter(list, "typeParameters");
        Intrinsics3.checkNotNullParameter(list2, "unsubstitutedValueParameters");
        Intrinsics3.checkNotNullParameter(descriptorVisibility2, "visibility");
        Intrinsics3.checkNotNullParameter(map, "userDataMap");
        Intrinsics3.checkNotNullParameter(aVar, "isExperimentalCoroutineInReleaseEnvironment");
        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImplInitialize = super.initialize(receiverParameterDescriptor, receiverParameterDescriptor2, list, list2, kotlinType, modality, descriptorVisibility2, map);
        Intrinsics3.checkNotNullExpressionValue(simpleFunctionDescriptorImplInitialize, "super.initialize(\n            extensionReceiverParameter,\n            dispatchReceiverParameter,\n            typeParameters,\n            unsubstitutedValueParameters,\n            unsubstitutedReturnType,\n            modality,\n            visibility,\n            userDataMap\n        )");
        this.R = aVar;
        return simpleFunctionDescriptorImplInitialize;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberDescriptor5(DeclarationDescriptor declarationDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor, Annotations4 annotations4, Name name, CallableMemberDescriptor.a aVar, d0.e0.p.d.m0.f.i iVar, NameResolver nameResolver, TypeTable typeTable, VersionRequirement2 versionRequirement2, DeserializedContainerSource2 deserializedContainerSource2, SourceElement sourceElement) {
        super(declarationDescriptor, simpleFunctionDescriptor, annotations4, name, aVar, sourceElement == null ? SourceElement.a : sourceElement);
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        Intrinsics3.checkNotNullParameter(iVar, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics3.checkNotNullParameter(versionRequirement2, "versionRequirementTable");
        this.M = iVar;
        this.N = nameResolver;
        this.O = typeTable;
        this.P = versionRequirement2;
        this.Q = deserializedContainerSource2;
        this.R = DeserializedMemberDescriptor3.a.COMPATIBLE;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public d0.e0.p.d.m0.f.i getProto() {
        return this.M;
    }
}
