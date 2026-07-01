package d0.e0.p.d.m0.e.a;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.t0;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: specialBuiltinMembers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends e0 {
    public static final g m = new g();

    public final List<d0.e0.p.d.m0.g.e> getBuiltinFunctionNamesByJvmName(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        List<d0.e0.p.d.m0.g.e> list = e0.a.getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP().get(eVar);
        return list == null ? d0.t.n.emptyList() : list;
    }

    public final d0.e0.p.d.m0.g.e getJvmName(t0 t0Var) {
        d0.z.d.m.checkNotNullParameter(t0Var, "functionDescriptor");
        Map<String, d0.e0.p.d.m0.g.e> signature_to_jvm_representation_name = e0.a.getSIGNATURE_TO_JVM_REPRESENTATION_NAME();
        String strComputeJvmSignature = d0.e0.p.d.m0.e.b.u.computeJvmSignature(t0Var);
        if (strComputeJvmSignature == null) {
            return null;
        }
        return signature_to_jvm_representation_name.get(strComputeJvmSignature);
    }

    public final boolean getSameAsRenamedInJvmBuiltin(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "<this>");
        return e0.a.getORIGINAL_SHORT_NAMES().contains(eVar);
    }

    public final boolean isBuiltinFunctionWithDifferentNameInJvm(t0 t0Var) {
        d0.z.d.m.checkNotNullParameter(t0Var, "functionDescriptor");
        return d0.e0.p.d.m0.b.h.isBuiltIn(t0Var) && d0.e0.p.d.m0.k.x.a.firstOverridden$default(t0Var, false, new g$a(t0Var), 1, null) != null;
    }

    public final boolean isRemoveAtByIndex(t0 t0Var) {
        d0.z.d.m.checkNotNullParameter(t0Var, "<this>");
        return d0.z.d.m.areEqual(t0Var.getName().asString(), "removeAt") && d0.z.d.m.areEqual(d0.e0.p.d.m0.e.b.u.computeJvmSignature(t0Var), e0.a.getREMOVE_AT_NAME_AND_SIGNATURE().getSignature());
    }
}
