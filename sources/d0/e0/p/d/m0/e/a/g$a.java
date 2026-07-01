package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.c.t0;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: specialBuiltinMembers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g$a extends d0.z.d.o implements Function1<d0.e0.p.d.m0.c.b, Boolean> {
    public final /* synthetic */ t0 $functionDescriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g$a(t0 t0Var) {
        super(1);
        this.$functionDescriptor = t0Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.c.b bVar) {
        return Boolean.valueOf(invoke2(bVar));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(d0.e0.p.d.m0.c.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "it");
        Map<String, d0.e0.p.d.m0.g.e> signature_to_jvm_representation_name = e0.a.getSIGNATURE_TO_JVM_REPRESENTATION_NAME();
        String strComputeJvmSignature = d0.e0.p.d.m0.e.b.u.computeJvmSignature(this.$functionDescriptor);
        Objects.requireNonNull(signature_to_jvm_representation_name, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return signature_to_jvm_representation_name.containsKey(strComputeJvmSignature);
    }
}
