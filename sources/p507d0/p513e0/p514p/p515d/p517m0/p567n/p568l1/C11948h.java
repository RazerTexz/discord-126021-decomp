package p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11322b0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.h */
/* JADX INFO: compiled from: KotlinTypeRefiner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11948h {

    /* JADX INFO: renamed from: a */
    public static final C11322b0<C11955o<AbstractC11947g>> f24808a = new C11322b0<>("KotlinTypeRefiner");

    public static final C11322b0<C11955o<AbstractC11947g>> getREFINER_CAPABILITY() {
        return f24808a;
    }

    public static final List<AbstractC11913c0> refineTypes(AbstractC11947g abstractC11947g, Iterable<? extends AbstractC11913c0> iterable) {
        C12238m.checkNotNullParameter(abstractC11947g, "<this>");
        C12238m.checkNotNullParameter(iterable, "types");
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(iterable, 10));
        Iterator<? extends AbstractC11913c0> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(abstractC11947g.refineType(it.next()));
        }
        return arrayList;
    }
}
