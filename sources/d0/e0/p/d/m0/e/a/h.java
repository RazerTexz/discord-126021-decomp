package d0.e0.p.d.m0.e.a;

import java.util.Objects;

/* JADX INFO: compiled from: specialBuiltinMembers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends e0 {
    public static final h m = new h();

    public static final boolean access$getHasErasedValueParametersInJava(h hVar, d0.e0.p.d.m0.c.b bVar) {
        Objects.requireNonNull(hVar);
        return d0.t.u.contains(e0.a.getERASED_VALUE_PARAMETERS_SIGNATURES(), d0.e0.p.d.m0.e.b.u.computeJvmSignature(bVar));
    }

    public static final d0.e0.p.d.m0.c.x getOverriddenBuiltinFunctionWithErasedValueParametersInJava(d0.e0.p.d.m0.c.x xVar) {
        d0.z.d.m.checkNotNullParameter(xVar, "functionDescriptor");
        h hVar = m;
        d0.e0.p.d.m0.g.e name = xVar.getName();
        d0.z.d.m.checkNotNullExpressionValue(name, "functionDescriptor.name");
        if (hVar.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return (d0.e0.p.d.m0.c.x) d0.e0.p.d.m0.k.x.a.firstOverridden$default(xVar, false, new h$a(hVar), 1, null);
        }
        return null;
    }

    public static final e0$b getSpecialSignatureInfo(d0.e0.p.d.m0.c.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "<this>");
        e0$a e0_a = e0.a;
        if (!e0_a.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains(bVar.getName())) {
            return null;
        }
        d0.e0.p.d.m0.c.b bVarFirstOverridden$default = d0.e0.p.d.m0.k.x.a.firstOverridden$default(bVar, false, new h$b(m), 1, null);
        String strComputeJvmSignature = bVarFirstOverridden$default == null ? null : d0.e0.p.d.m0.e.b.u.computeJvmSignature(bVarFirstOverridden$default);
        if (strComputeJvmSignature == null) {
            return null;
        }
        return e0_a.getSpecialSignatureInfo(strComputeJvmSignature);
    }

    public final boolean getSameAsBuiltinMethodWithErasedValueParameters(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "<this>");
        return e0.a.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains(eVar);
    }
}
