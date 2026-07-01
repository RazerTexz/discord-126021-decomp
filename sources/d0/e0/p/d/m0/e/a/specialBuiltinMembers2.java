package d0.e0.p.d.m0.e.a;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.e.b.methodSignatureMapping3;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g, reason: use source file name */
/* JADX INFO: compiled from: specialBuiltinMembers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class specialBuiltinMembers2 extends SpecialGenericSignatures {
    public static final specialBuiltinMembers2 m = new specialBuiltinMembers2();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g$a */
    /* JADX INFO: compiled from: specialBuiltinMembers.kt */
    public static final class a extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
        public final /* synthetic */ SimpleFunctionDescriptor $functionDescriptor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SimpleFunctionDescriptor simpleFunctionDescriptor) {
            super(1);
            this.$functionDescriptor = simpleFunctionDescriptor;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return Boolean.valueOf(invoke2(callableMemberDescriptor));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(CallableMemberDescriptor callableMemberDescriptor) {
            Intrinsics3.checkNotNullParameter(callableMemberDescriptor, "it");
            Map<String, Name> signature_to_jvm_representation_name = SpecialGenericSignatures.a.getSIGNATURE_TO_JVM_REPRESENTATION_NAME();
            String strComputeJvmSignature = methodSignatureMapping3.computeJvmSignature(this.$functionDescriptor);
            Objects.requireNonNull(signature_to_jvm_representation_name, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            return signature_to_jvm_representation_name.containsKey(strComputeJvmSignature);
        }
    }

    public final List<Name> getBuiltinFunctionNamesByJvmName(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        List<Name> list = SpecialGenericSignatures.a.getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP().get(name);
        return list == null ? Collections2.emptyList() : list;
    }

    public final Name getJvmName(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics3.checkNotNullParameter(simpleFunctionDescriptor, "functionDescriptor");
        Map<String, Name> signature_to_jvm_representation_name = SpecialGenericSignatures.a.getSIGNATURE_TO_JVM_REPRESENTATION_NAME();
        String strComputeJvmSignature = methodSignatureMapping3.computeJvmSignature(simpleFunctionDescriptor);
        if (strComputeJvmSignature == null) {
            return null;
        }
        return signature_to_jvm_representation_name.get(strComputeJvmSignature);
    }

    public final boolean getSameAsRenamedInJvmBuiltin(Name name) {
        Intrinsics3.checkNotNullParameter(name, "<this>");
        return SpecialGenericSignatures.a.getORIGINAL_SHORT_NAMES().contains(name);
    }

    public final boolean isBuiltinFunctionWithDifferentNameInJvm(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics3.checkNotNullParameter(simpleFunctionDescriptor, "functionDescriptor");
        return KotlinBuiltIns.isBuiltIn(simpleFunctionDescriptor) && DescriptorUtils2.firstOverridden$default(simpleFunctionDescriptor, false, new a(simpleFunctionDescriptor), 1, null) != null;
    }

    public final boolean isRemoveAtByIndex(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics3.checkNotNullParameter(simpleFunctionDescriptor, "<this>");
        return Intrinsics3.areEqual(simpleFunctionDescriptor.getName().asString(), "removeAt") && Intrinsics3.areEqual(methodSignatureMapping3.computeJvmSignature(simpleFunctionDescriptor), SpecialGenericSignatures.a.getREMOVE_AT_NAME_AND_SIGNATURE().getSignature());
    }
}
