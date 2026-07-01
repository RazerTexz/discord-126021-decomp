package d0.e0.p.d.m0.b.p;

import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.g1.g;
import d0.e0.p.d.m0.c.i1.g0;
import d0.e0.p.d.m0.c.i1.q;
import d0.e0.p.d.m0.c.i1.q$c;
import d0.e0.p.d.m0.c.m;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.o.j;
import d0.t.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FunctionInvokeDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends g0 {
    public static final e$a M = new e$a(null);

    public e(m mVar, e eVar, d0.e0.p.d.m0.c.b$a b_a, boolean z2) {
        super(mVar, eVar, g.f.getEMPTY(), j.g, b_a, u0.a);
        setOperator(true);
        setSuspend(z2);
        setHasStableParameterNames(false);
    }

    public /* synthetic */ e(m mVar, e eVar, d0.e0.p.d.m0.c.b$a b_a, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(mVar, eVar, b_a, z2);
    }

    @Override // d0.e0.p.d.m0.c.i1.g0, d0.e0.p.d.m0.c.i1.q
    public q b(m mVar, x xVar, d0.e0.p.d.m0.c.b$a b_a, d0.e0.p.d.m0.g.e eVar, g gVar, u0 u0Var) {
        d0.z.d.m.checkNotNullParameter(mVar, "newOwner");
        d0.z.d.m.checkNotNullParameter(b_a, "kind");
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        d0.z.d.m.checkNotNullParameter(u0Var, "source");
        return new e(mVar, (e) xVar, b_a, isSuspend());
    }

    @Override // d0.e0.p.d.m0.c.i1.q
    public x c(q$c q_c) {
        boolean z2;
        d0.e0.p.d.m0.g.e eVar;
        d0.z.d.m.checkNotNullParameter(q_c, "configuration");
        e eVar2 = (e) super.c(q_c);
        if (eVar2 == null) {
            return null;
        }
        List<c1> valueParameters = eVar2.getValueParameters();
        d0.z.d.m.checkNotNullExpressionValue(valueParameters, "substituted.valueParameters");
        boolean z3 = true;
        if (!(valueParameters instanceof Collection) || !valueParameters.isEmpty()) {
            Iterator<T> it = valueParameters.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = true;
                    break;
                }
                c0 type = ((c1) it.next()).getType();
                d0.z.d.m.checkNotNullExpressionValue(type, "it.type");
                if (d0.e0.p.d.m0.b.g.extractParameterNameFromFunctionTypeArgument(type) != null) {
                    z2 = false;
                    break;
                }
            }
        } else {
            z2 = true;
            break;
        }
        if (z2) {
            return eVar2;
        }
        List<c1> valueParameters2 = eVar2.getValueParameters();
        d0.z.d.m.checkNotNullExpressionValue(valueParameters2, "substituted.valueParameters");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(valueParameters2, 10));
        Iterator<T> it2 = valueParameters2.iterator();
        while (it2.hasNext()) {
            c0 type2 = ((c1) it2.next()).getType();
            d0.z.d.m.checkNotNullExpressionValue(type2, "it.type");
            arrayList.add(d0.e0.p.d.m0.b.g.extractParameterNameFromFunctionTypeArgument(type2));
        }
        int size = eVar2.getValueParameters().size() - arrayList.size();
        List<c1> valueParameters3 = eVar2.getValueParameters();
        d0.z.d.m.checkNotNullExpressionValue(valueParameters3, "valueParameters");
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(valueParameters3, 10));
        for (c1 c1Var : valueParameters3) {
            d0.e0.p.d.m0.g.e name = c1Var.getName();
            d0.z.d.m.checkNotNullExpressionValue(name, "it.name");
            int index = c1Var.getIndex();
            int i = index - size;
            if (i >= 0 && (eVar = (d0.e0.p.d.m0.g.e) arrayList.get(i)) != null) {
                name = eVar;
            }
            arrayList2.add(c1Var.copy(eVar2, name, index));
        }
        q$c q_cD = eVar2.d(d0.e0.p.d.m0.n.c1.a);
        if (arrayList.isEmpty()) {
            z3 = false;
        } else {
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                if (((d0.e0.p.d.m0.g.e) it3.next()) == null) {
                }
            }
            z3 = false;
        }
        q$c original = q_cD.setHasSynthesizedParameterNames(z3).setValueParameters((List<c1>) arrayList2).setOriginal((d0.e0.p.d.m0.c.b) eVar2.getOriginal());
        d0.z.d.m.checkNotNullExpressionValue(original, "newCopyBuilder(TypeSubstitutor.EMPTY)\n                .setHasSynthesizedParameterNames(parameterNames.any { it == null })\n                .setValueParameters(newValueParameters)\n                .setOriginal(original)");
        x xVarC = super.c(original);
        d0.z.d.m.checkNotNull(xVarC);
        return xVarC;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.y
    public boolean isExternal() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x
    public boolean isInline() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x
    public boolean isTailrec() {
        return false;
    }
}
