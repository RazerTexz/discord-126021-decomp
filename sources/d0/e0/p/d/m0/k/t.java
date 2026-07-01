package d0.e0.p.d.m0.k;

import java.util.Collection;

/* JADX INFO: compiled from: VisibilityUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t {
    public static final d0.e0.p.d.m0.c.b findMemberWithMaxVisibility(Collection<? extends d0.e0.p.d.m0.c.b> collection) {
        Integer numCompare;
        d0.z.d.m.checkNotNullParameter(collection, "descriptors");
        collection.isEmpty();
        d0.e0.p.d.m0.c.b bVar = null;
        for (d0.e0.p.d.m0.c.b bVar2 : collection) {
            if (bVar == null || ((numCompare = d0.e0.p.d.m0.c.t.compare(bVar.getVisibility(), bVar2.getVisibility())) != null && numCompare.intValue() < 0)) {
                bVar = bVar2;
            }
        }
        d0.z.d.m.checkNotNull(bVar);
        return bVar;
    }
}
