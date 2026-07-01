package d0.e0.p.d.m0.l.b;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.f.z.BinaryVersion;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.e0.p.d.m0.f.z.TypeTable;
import d0.e0.p.d.m0.f.z.VersionRequirement2;
import d0.e0.p.d.m0.f.z.versionSpecificBehavior;
import d0.e0.p.d.m0.l.b.e0.DeserializedContainerSource2;
import d0.e0.p.d.m0.m.StorageManager;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.l, reason: use source file name */
/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class context6 {
    public final context5 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NameResolver f3505b;
    public final DeclarationDescriptor c;
    public final TypeTable d;
    public final VersionRequirement2 e;
    public final BinaryVersion f;
    public final DeserializedContainerSource2 g;
    public final TypeDeserializer h;
    public final MemberDeserializer i;

    public context6(context5 context5Var, NameResolver nameResolver, DeclarationDescriptor declarationDescriptor, TypeTable typeTable, VersionRequirement2 versionRequirement2, BinaryVersion binaryVersion, DeserializedContainerSource2 deserializedContainerSource2, TypeDeserializer typeDeserializer, List<d0.e0.p.d.m0.f.s> list) {
        String presentableString;
        Intrinsics3.checkNotNullParameter(context5Var, "components");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics3.checkNotNullParameter(versionRequirement2, "versionRequirementTable");
        Intrinsics3.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics3.checkNotNullParameter(list, "typeParameters");
        this.a = context5Var;
        this.f3505b = nameResolver;
        this.c = declarationDescriptor;
        this.d = typeTable;
        this.e = versionRequirement2;
        this.f = binaryVersion;
        this.g = deserializedContainerSource2;
        StringBuilder sbU = outline.U("Deserializer for \"");
        sbU.append(declarationDescriptor.getName());
        sbU.append('\"');
        this.h = new TypeDeserializer(this, typeDeserializer, list, sbU.toString(), (deserializedContainerSource2 == null || (presentableString = deserializedContainerSource2.getPresentableString()) == null) ? "[container not found]" : presentableString, false, 32, null);
        this.i = new MemberDeserializer(this);
    }

    public static /* synthetic */ context6 childContext$default(context6 context6Var, DeclarationDescriptor declarationDescriptor, List list, NameResolver nameResolver, TypeTable typeTable, VersionRequirement2 versionRequirement2, BinaryVersion binaryVersion, int i, Object obj) {
        if ((i & 4) != 0) {
            nameResolver = context6Var.f3505b;
        }
        NameResolver nameResolver2 = nameResolver;
        if ((i & 8) != 0) {
            typeTable = context6Var.d;
        }
        TypeTable typeTable2 = typeTable;
        if ((i & 16) != 0) {
            versionRequirement2 = context6Var.e;
        }
        VersionRequirement2 versionRequirement3 = versionRequirement2;
        if ((i & 32) != 0) {
            binaryVersion = context6Var.f;
        }
        return context6Var.childContext(declarationDescriptor, list, nameResolver2, typeTable2, versionRequirement3, binaryVersion);
    }

    public final context6 childContext(DeclarationDescriptor declarationDescriptor, List<d0.e0.p.d.m0.f.s> list, NameResolver nameResolver, TypeTable typeTable, VersionRequirement2 versionRequirement2, BinaryVersion binaryVersion) {
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "descriptor");
        Intrinsics3.checkNotNullParameter(list, "typeParameterProtos");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        VersionRequirement2 versionRequirement3 = versionRequirement2;
        Intrinsics3.checkNotNullParameter(versionRequirement3, "versionRequirementTable");
        Intrinsics3.checkNotNullParameter(binaryVersion, "metadataVersion");
        context5 context5Var = this.a;
        if (!versionSpecificBehavior.isVersionRequirementTableWrittenCorrectly(binaryVersion)) {
            versionRequirement3 = this.e;
        }
        return new context6(context5Var, nameResolver, declarationDescriptor, typeTable, versionRequirement3, binaryVersion, this.g, this.h, list);
    }

    public final context5 getComponents() {
        return this.a;
    }

    public final DeserializedContainerSource2 getContainerSource() {
        return this.g;
    }

    public final DeclarationDescriptor getContainingDeclaration() {
        return this.c;
    }

    public final MemberDeserializer getMemberDeserializer() {
        return this.i;
    }

    public final NameResolver getNameResolver() {
        return this.f3505b;
    }

    public final StorageManager getStorageManager() {
        return this.a.getStorageManager();
    }

    public final TypeDeserializer getTypeDeserializer() {
        return this.h;
    }

    public final TypeTable getTypeTable() {
        return this.d;
    }

    public final VersionRequirement2 getVersionRequirementTable() {
        return this.e;
    }
}
