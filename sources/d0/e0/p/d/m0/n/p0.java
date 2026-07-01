package d0.e0.p.d.m0.n;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: StarProjectionImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p0 {
    public static final c0 starProjectionType(d0.e0.p.d.m0.c.z0 z0Var) {
        d0.z.d.m.checkNotNullParameter(z0Var, "<this>");
        List<d0.e0.p.d.m0.c.z0> parameters = ((d0.e0.p.d.m0.c.i) z0Var.getContainingDeclaration()).getTypeConstructor().getParameters();
        d0.z.d.m.checkNotNullExpressionValue(parameters, "classDescriptor.typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(parameters, 10));
        Iterator<T> it = parameters.iterator();
        while (it.hasNext()) {
            arrayList.add(((d0.e0.p.d.m0.c.z0) it.next()).getTypeConstructor());
        }
        c1 c1VarCreate = c1.create(new p0$a(arrayList));
        List<c0> upperBounds = z0Var.getUpperBounds();
        d0.z.d.m.checkNotNullExpressionValue(upperBounds, "this.upperBounds");
        c0 c0VarSubstitute = c1VarCreate.substitute((c0) d0.t.u.first((List) upperBounds), j1.OUT_VARIANCE);
        if (c0VarSubstitute != null) {
            return c0VarSubstitute;
        }
        j0 defaultBound = d0.e0.p.d.m0.k.x.a.getBuiltIns(z0Var).getDefaultBound();
        d0.z.d.m.checkNotNullExpressionValue(defaultBound, "builtIns.defaultBound");
        return defaultBound;
    }
}
