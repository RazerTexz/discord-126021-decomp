package d0.e0.p.d.m0.l.b.e0;

import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.MemberDescriptor;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.e0.p.d.m0.f.z.TypeTable;
import d0.e0.p.d.m0.f.z.VersionRequirement;
import d0.e0.p.d.m0.f.z.VersionRequirement2;
import d0.e0.p.d.m0.i.MessageLite;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.g, reason: use source file name */
/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface DeserializedMemberDescriptor3 extends DeclarationDescriptor, MemberDescriptor {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.g$a */
    /* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
    public enum a {
        COMPATIBLE,
        NEEDS_WRAPPER,
        INCOMPATIBLE;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            a[] aVarArr = new a[aVarArrValuesCustom.length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, aVarArrValuesCustom.length);
            return aVarArr;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.g$b */
    /* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
    public static final class b {
        public static List<VersionRequirement> getVersionRequirements(DeserializedMemberDescriptor3 deserializedMemberDescriptor3) {
            Intrinsics3.checkNotNullParameter(deserializedMemberDescriptor3, "this");
            return VersionRequirement.a.create(deserializedMemberDescriptor3.getProto(), deserializedMemberDescriptor3.getNameResolver(), deserializedMemberDescriptor3.getVersionRequirementTable());
        }
    }

    DeserializedContainerSource2 getContainerSource();

    NameResolver getNameResolver();

    MessageLite getProto();

    TypeTable getTypeTable();

    VersionRequirement2 getVersionRequirementTable();

    List<VersionRequirement> getVersionRequirements();
}
