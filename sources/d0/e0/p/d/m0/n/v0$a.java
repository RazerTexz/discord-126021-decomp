package d0.e0.p.d.m0.n;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v0$a {
    public v0$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static /* synthetic */ v0 createByConstructorsMap$default(v0$a v0_a, Map map, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        return v0_a.createByConstructorsMap(map, z2);
    }

    public final z0 create(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "kotlinType");
        return create(c0Var.getConstructor(), c0Var.getArguments());
    }

    public final v0 createByConstructorsMap(Map<u0, ? extends w0> map) {
        d0.z.d.m.checkNotNullParameter(map, "map");
        return createByConstructorsMap$default(this, map, false, 2, null);
    }

    public final v0 createByConstructorsMap(Map<u0, ? extends w0> map, boolean z2) {
        d0.z.d.m.checkNotNullParameter(map, "map");
        return new v0$a$a(map, z2);
    }

    public final z0 create(u0 u0Var, List<? extends w0> list) {
        d0.z.d.m.checkNotNullParameter(u0Var, "typeConstructor");
        d0.z.d.m.checkNotNullParameter(list, "arguments");
        List<d0.e0.p.d.m0.c.z0> parameters = u0Var.getParameters();
        d0.z.d.m.checkNotNullExpressionValue(parameters, "typeConstructor.parameters");
        d0.e0.p.d.m0.c.z0 z0Var = (d0.e0.p.d.m0.c.z0) d0.t.u.lastOrNull((List) parameters);
        if (!d0.z.d.m.areEqual(z0Var == null ? null : Boolean.valueOf(z0Var.isCapturedFromOuterDeclaration()), Boolean.TRUE)) {
            return new z(parameters, list);
        }
        List<d0.e0.p.d.m0.c.z0> parameters2 = u0Var.getParameters();
        d0.z.d.m.checkNotNullExpressionValue(parameters2, "typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(parameters2, 10));
        Iterator<T> it = parameters2.iterator();
        while (it.hasNext()) {
            arrayList.add(((d0.e0.p.d.m0.c.z0) it.next()).getTypeConstructor());
        }
        return createByConstructorsMap$default(this, d0.t.h0.toMap(d0.t.u.zip(arrayList, list)), false, 2, null);
    }
}
