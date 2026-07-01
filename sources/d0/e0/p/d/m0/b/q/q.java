package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.v0;
import d0.e0.p.d.m0.n.v0$a;
import d0.t.h0;
import d0.t.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: mappingUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q {
    public static final v0 createMappedTypeParametersSubstitution(d0.e0.p.d.m0.c.e eVar, d0.e0.p.d.m0.c.e eVar2) {
        d0.z.d.m.checkNotNullParameter(eVar, "from");
        d0.z.d.m.checkNotNullParameter(eVar2, "to");
        eVar.getDeclaredTypeParameters().size();
        eVar2.getDeclaredTypeParameters().size();
        v0$a v0_a = v0.f3542b;
        List<z0> declaredTypeParameters = eVar.getDeclaredTypeParameters();
        d0.z.d.m.checkNotNullExpressionValue(declaredTypeParameters, "from.declaredTypeParameters");
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(declaredTypeParameters, 10));
        Iterator<T> it = declaredTypeParameters.iterator();
        while (it.hasNext()) {
            arrayList.add(((z0) it.next()).getTypeConstructor());
        }
        List<z0> declaredTypeParameters2 = eVar2.getDeclaredTypeParameters();
        d0.z.d.m.checkNotNullExpressionValue(declaredTypeParameters2, "to.declaredTypeParameters");
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(declaredTypeParameters2, 10));
        Iterator<T> it2 = declaredTypeParameters2.iterator();
        while (it2.hasNext()) {
            j0 defaultType = ((z0) it2.next()).getDefaultType();
            d0.z.d.m.checkNotNullExpressionValue(defaultType, "it.defaultType");
            arrayList2.add(d0.e0.p.d.m0.n.o1.a.asTypeProjection(defaultType));
        }
        return v0$a.createByConstructorsMap$default(v0_a, h0.toMap(u.zip(arrayList, arrayList2)), false, 2, null);
    }
}
