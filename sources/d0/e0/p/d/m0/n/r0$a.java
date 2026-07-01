package d0.e0.p.d.m0.n;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TypeAliasExpansion.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r0$a {
    public r0$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final r0 create(r0 r0Var, d0.e0.p.d.m0.c.y0 y0Var, List<? extends w0> list) {
        d0.z.d.m.checkNotNullParameter(y0Var, "typeAliasDescriptor");
        d0.z.d.m.checkNotNullParameter(list, "arguments");
        List<d0.e0.p.d.m0.c.z0> parameters = y0Var.getTypeConstructor().getParameters();
        d0.z.d.m.checkNotNullExpressionValue(parameters, "typeAliasDescriptor.typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(parameters, 10));
        Iterator<T> it = parameters.iterator();
        while (it.hasNext()) {
            arrayList.add(((d0.e0.p.d.m0.c.z0) it.next()).getOriginal());
        }
        return new r0(r0Var, y0Var, list, d0.t.h0.toMap(d0.t.u.zip(arrayList, list)), null);
    }
}
