package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.c1;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.i1;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.v0;
import d0.e0.p.d.m0.n.w0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {
    /* JADX WARN: Code duplicated, block: B:20:0x0057  */
    public static final j0 captureFromArguments(j0 j0Var, d0.e0.p.d.m0.n.n1.b bVar) {
        ArrayList arrayList;
        d0.z.d.m.checkNotNullParameter(j0Var, "type");
        d0.z.d.m.checkNotNullParameter(bVar, "status");
        j1 j1Var = j1.INVARIANT;
        if (j0Var.getArguments().size() != j0Var.getConstructor().getParameters().size()) {
            arrayList = null;
        } else {
            List<w0> arguments = j0Var.getArguments();
            boolean z2 = true;
            int i = 0;
            if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
                Iterator<T> it = arguments.iterator();
                while (it.hasNext()) {
                    if (!(((w0) it.next()).getProjectionKind() == j1Var)) {
                        z2 = false;
                        break;
                    }
                }
            }
            if (z2) {
                arrayList = null;
            } else {
                List<z0> parameters = j0Var.getConstructor().getParameters();
                d0.z.d.m.checkNotNullExpressionValue(parameters, "type.constructor.parameters");
                List<Pair> listZip = d0.t.u.zip(arguments, parameters);
                ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(listZip, 10));
                for (Pair pair : listZip) {
                    w0 w0VarAsTypeProjection = (w0) pair.component1();
                    z0 z0Var = (z0) pair.component2();
                    if (w0VarAsTypeProjection.getProjectionKind() != j1Var) {
                        i1 i1VarUnwrap = (w0VarAsTypeProjection.isStarProjection() || w0VarAsTypeProjection.getProjectionKind() != j1.IN_VARIANCE) ? null : w0VarAsTypeProjection.getType().unwrap();
                        d0.z.d.m.checkNotNullExpressionValue(z0Var, "parameter");
                        w0VarAsTypeProjection = d0.e0.p.d.m0.n.o1.a.asTypeProjection(new i(bVar, i1VarUnwrap, w0VarAsTypeProjection, z0Var));
                    }
                    arrayList2.add(w0VarAsTypeProjection);
                }
                c1 c1VarBuildSubstitutor = v0.f3542b.create(j0Var.getConstructor(), arrayList2).buildSubstitutor();
                int size = arguments.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i2 = i + 1;
                        w0 w0Var = arguments.get(i);
                        w0 w0Var2 = (w0) arrayList2.get(i);
                        if (w0Var.getProjectionKind() != j1Var) {
                            List<c0> upperBounds = j0Var.getConstructor().getParameters().get(i).getUpperBounds();
                            ArrayList arrayListA0 = b.d.b.a.a.a0(upperBounds, "type.constructor.parameters[index].upperBounds");
                            Iterator<T> it2 = upperBounds.iterator();
                            while (it2.hasNext()) {
                                arrayListA0.add(l.f3529b.getDefault().transformToNewType(c1VarBuildSubstitutor.safeSubstitute((c0) it2.next(), j1Var).unwrap()));
                            }
                            if (!w0Var.isStarProjection() && w0Var.getProjectionKind() == j1.OUT_VARIANCE) {
                                arrayListA0.add(l.f3529b.getDefault().transformToNewType(w0Var.getType().unwrap()));
                            }
                            ((i) w0Var2.getType()).getConstructor().initializeSupertypes(arrayListA0);
                        }
                        if (i2 > size) {
                            break;
                        }
                        i = i2;
                    }
                }
                arrayList = arrayList2;
            }
        }
        if (arrayList == null) {
            return null;
        }
        d0 d0Var = d0.a;
        return d0.simpleType$default(j0Var.getAnnotations(), j0Var.getConstructor(), arrayList, j0Var.isMarkedNullable(), null, 16, null);
    }
}
