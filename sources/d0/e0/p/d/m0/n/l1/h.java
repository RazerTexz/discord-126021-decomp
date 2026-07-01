package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.c.b0;
import d0.e0.p.d.m0.n.c0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: KotlinTypeRefiner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final b0<o<g>> a = new b0<>("KotlinTypeRefiner");

    public static final b0<o<g>> getREFINER_CAPABILITY() {
        return a;
    }

    public static final List<c0> refineTypes(g gVar, Iterable<? extends c0> iterable) {
        d0.z.d.m.checkNotNullParameter(gVar, "<this>");
        d0.z.d.m.checkNotNullParameter(iterable, "types");
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(iterable, 10));
        Iterator<? extends c0> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(gVar.refineType(it.next()));
        }
        return arrayList;
    }
}
