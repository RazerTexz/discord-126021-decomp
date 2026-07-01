package d0.e0.p.d.m0.e.a.i0.l;

import d0.t.g0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$f extends d0.z.d.o implements Function0<Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.e.a.k0.n>> {
    public final /* synthetic */ h this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$f(h hVar) {
        super(0);
        this.this$0 = hVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.e.a.k0.n> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.e.a.k0.n> invoke2() {
        Collection<d0.e0.p.d.m0.e.a.k0.n> fields = h.access$getJClass$p(this.this$0).getFields();
        ArrayList arrayList = new ArrayList();
        for (Object obj : fields) {
            if (((d0.e0.p.d.m0.e.a.k0.n) obj).isEnumEntry()) {
                arrayList.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(d0.d0.f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj2 : arrayList) {
            linkedHashMap.put(((d0.e0.p.d.m0.e.a.k0.n) obj2).getName(), obj2);
        }
        return linkedHashMap;
    }
}
