package d0.e0.p.d.m0.k.x;

import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.p.b$c;
import d0.t.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: DescriptorUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a implements b$c<c1> {
    public static final a$a a = new a$a();

    @Override // d0.e0.p.d.m0.p.b$c
    public /* bridge */ /* synthetic */ Iterable<? extends c1> getNeighbors(c1 c1Var) {
        return getNeighbors2(c1Var);
    }

    /* JADX INFO: renamed from: getNeighbors, reason: avoid collision after fix types in other method */
    public final Iterable<c1> getNeighbors2(c1 c1Var) {
        Collection<c1> overriddenDescriptors = c1Var.getOverriddenDescriptors();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(overriddenDescriptors, 10));
        Iterator<T> it = overriddenDescriptors.iterator();
        while (it.hasNext()) {
            arrayList.add(((c1) it.next()).getOriginal());
        }
        return arrayList;
    }
}
