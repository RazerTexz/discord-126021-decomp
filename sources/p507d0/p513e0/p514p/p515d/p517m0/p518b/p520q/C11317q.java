package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12010v0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.q */
/* JADX INFO: compiled from: mappingUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11317q {
    public static final AbstractC12010v0 createMappedTypeParametersSubstitution(InterfaceC11330e interfaceC11330e, InterfaceC11330e interfaceC11330e2) {
        C12238m.checkNotNullParameter(interfaceC11330e, "from");
        C12238m.checkNotNullParameter(interfaceC11330e2, "to");
        interfaceC11330e.getDeclaredTypeParameters().size();
        interfaceC11330e2.getDeclaredTypeParameters().size();
        AbstractC12010v0.a aVar = AbstractC12010v0.f24889b;
        List<InterfaceC11477z0> declaredTypeParameters = interfaceC11330e.getDeclaredTypeParameters();
        C12238m.checkNotNullExpressionValue(declaredTypeParameters, "from.declaredTypeParameters");
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(declaredTypeParameters, 10));
        Iterator<T> it = declaredTypeParameters.iterator();
        while (it.hasNext()) {
            arrayList.add(((InterfaceC11477z0) it.next()).getTypeConstructor());
        }
        List<InterfaceC11477z0> declaredTypeParameters2 = interfaceC11330e2.getDeclaredTypeParameters();
        C12238m.checkNotNullExpressionValue(declaredTypeParameters2, "to.declaredTypeParameters");
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(declaredTypeParameters2, 10));
        Iterator<T> it2 = declaredTypeParameters2.iterator();
        while (it2.hasNext()) {
            AbstractC11934j0 defaultType = ((InterfaceC11477z0) it2.next()).getDefaultType();
            C12238m.checkNotNullExpressionValue(defaultType, "it.defaultType");
            arrayList2.add(C11992a.asTypeProjection(defaultType));
        }
        return AbstractC12010v0.a.createByConstructorsMap$default(aVar, C12136h0.toMap(C12163u.zip(arrayList, arrayList2)), false, 2, null);
    }
}
