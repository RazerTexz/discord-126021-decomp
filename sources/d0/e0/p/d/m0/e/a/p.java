package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.k.f$a;
import d0.e0.p.d.m0.k.f$b;
import d0.e0.p.d.m0.k.k$d;
import d0.e0.p.d.m0.k.k$d$a;
import java.util.Iterator;
import java.util.List;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: ErasedOverridabilityCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p implements d0.e0.p.d.m0.k.f {
    @Override // d0.e0.p.d.m0.k.f
    public f$a getContract() {
        return f$a.SUCCESS_ONLY;
    }

    @Override // d0.e0.p.d.m0.k.f
    public f$b isOverridable(d0.e0.p.d.m0.c.a aVar, d0.e0.p.d.m0.c.a aVar2, d0.e0.p.d.m0.c.e eVar) {
        boolean z2;
        d0.e0.p.d.m0.c.a aVarSubstitute;
        f$b f_b = f$b.UNKNOWN;
        d0.z.d.m.checkNotNullParameter(aVar, "superDescriptor");
        d0.z.d.m.checkNotNullParameter(aVar2, "subDescriptor");
        if (!(aVar2 instanceof d0.e0.p.d.m0.e.a.h0.f)) {
            return f_b;
        }
        d0.e0.p.d.m0.e.a.h0.f fVar = (d0.e0.p.d.m0.e.a.h0.f) aVar2;
        List<z0> typeParameters = fVar.getTypeParameters();
        d0.z.d.m.checkNotNullExpressionValue(typeParameters, "subDescriptor.typeParameters");
        if (!typeParameters.isEmpty()) {
            return f_b;
        }
        k$d basicOverridabilityProblem = d0.e0.p.d.m0.k.k.getBasicOverridabilityProblem(aVar, aVar2);
        if ((basicOverridabilityProblem == null ? null : basicOverridabilityProblem.getResult()) != null) {
            return f_b;
        }
        List<c1> valueParameters = fVar.getValueParameters();
        d0.z.d.m.checkNotNullExpressionValue(valueParameters, "subDescriptor.valueParameters");
        Sequence map = d0.f0.q.map(d0.t.u.asSequence(valueParameters), p$b.j);
        d0.e0.p.d.m0.n.c0 returnType = fVar.getReturnType();
        d0.z.d.m.checkNotNull(returnType);
        Sequence sequencePlus = d0.f0.q.plus((Sequence<? extends d0.e0.p.d.m0.n.c0>) map, returnType);
        q0 extensionReceiverParameter = fVar.getExtensionReceiverParameter();
        Iterator it = d0.f0.q.plus(sequencePlus, (Iterable) d0.t.n.listOfNotNull(extensionReceiverParameter != null ? extensionReceiverParameter.getType() : null)).iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            d0.e0.p.d.m0.n.c0 c0Var = (d0.e0.p.d.m0.n.c0) it.next();
            if ((c0Var.getArguments().isEmpty() ^ true) && !(c0Var.unwrap() instanceof d0.e0.p.d.m0.e.a.i0.m.g)) {
                z2 = true;
                break;
            }
        }
        if (z2 || (aVarSubstitute = aVar.substitute(d0.e0.p.d.m0.e.a.i0.m.f.f3341b.buildSubstitutor())) == null) {
            return f_b;
        }
        if (aVarSubstitute instanceof t0) {
            t0 t0Var = (t0) aVarSubstitute;
            List<z0> typeParameters2 = t0Var.getTypeParameters();
            d0.z.d.m.checkNotNullExpressionValue(typeParameters2, "erasedSuper.typeParameters");
            if (!typeParameters2.isEmpty()) {
                aVarSubstitute = (t0) t0Var.newCopyBuilder().setTypeParameters(d0.t.n.emptyList()).build();
                d0.z.d.m.checkNotNull(aVarSubstitute);
            }
        }
        k$d$a result = d0.e0.p.d.m0.k.k.f3468b.isOverridableByWithoutExternalConditions(aVarSubstitute, aVar2, false).getResult();
        d0.z.d.m.checkNotNullExpressionValue(result, "DEFAULT.isOverridableByWithoutExternalConditions(erasedSuper, subDescriptor, false).result");
        return p$a.a[result.ordinal()] == 1 ? f$b.OVERRIDABLE : f_b;
    }
}
