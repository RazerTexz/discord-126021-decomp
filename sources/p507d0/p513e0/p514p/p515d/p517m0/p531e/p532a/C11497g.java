package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.C11660u;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g */
/* JADX INFO: compiled from: specialBuiltinMembers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11497g extends C11494e0 {

    /* JADX INFO: renamed from: m */
    public static final C11497g f23218m = new C11497g();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g$a */
    /* JADX INFO: compiled from: specialBuiltinMembers.kt */
    public static final class a extends AbstractC12240o implements Function1<InterfaceC11321b, Boolean> {
        public final /* synthetic */ InterfaceC11465t0 $functionDescriptor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC11465t0 interfaceC11465t0) {
            super(1);
            this.$functionDescriptor = interfaceC11465t0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(InterfaceC11321b interfaceC11321b) {
            return Boolean.valueOf(invoke2(interfaceC11321b));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(InterfaceC11321b interfaceC11321b) {
            C12238m.checkNotNullParameter(interfaceC11321b, "it");
            Map<String, C11716e> signature_to_jvm_representation_name = C11494e0.f23195a.getSIGNATURE_TO_JVM_REPRESENTATION_NAME();
            String strComputeJvmSignature = C11660u.computeJvmSignature(this.$functionDescriptor);
            Objects.requireNonNull(signature_to_jvm_representation_name, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            return signature_to_jvm_representation_name.containsKey(strComputeJvmSignature);
        }
    }

    public final List<C11716e> getBuiltinFunctionNamesByJvmName(C11716e c11716e) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        List<C11716e> list = C11494e0.f23195a.getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP().get(c11716e);
        return list == null ? C12147n.emptyList() : list;
    }

    public final C11716e getJvmName(InterfaceC11465t0 interfaceC11465t0) {
        C12238m.checkNotNullParameter(interfaceC11465t0, "functionDescriptor");
        Map<String, C11716e> signature_to_jvm_representation_name = C11494e0.f23195a.getSIGNATURE_TO_JVM_REPRESENTATION_NAME();
        String strComputeJvmSignature = C11660u.computeJvmSignature(interfaceC11465t0);
        if (strComputeJvmSignature == null) {
            return null;
        }
        return signature_to_jvm_representation_name.get(strComputeJvmSignature);
    }

    public final boolean getSameAsRenamedInJvmBuiltin(C11716e c11716e) {
        C12238m.checkNotNullParameter(c11716e, "<this>");
        return C11494e0.f23195a.getORIGINAL_SHORT_NAMES().contains(c11716e);
    }

    public final boolean isBuiltinFunctionWithDifferentNameInJvm(InterfaceC11465t0 interfaceC11465t0) {
        C12238m.checkNotNullParameter(interfaceC11465t0, "functionDescriptor");
        return AbstractC11288h.isBuiltIn(interfaceC11465t0) && C11836a.firstOverridden$default(interfaceC11465t0, false, new a(interfaceC11465t0), 1, null) != null;
    }

    public final boolean isRemoveAtByIndex(InterfaceC11465t0 interfaceC11465t0) {
        C12238m.checkNotNullParameter(interfaceC11465t0, "<this>");
        return C12238m.areEqual(interfaceC11465t0.getName().asString(), "removeAt") && C12238m.areEqual(C11660u.computeJvmSignature(interfaceC11465t0), C11494e0.f23195a.getREMOVE_AT_NAME_AND_SIGNATURE().getSignature());
    }
}
