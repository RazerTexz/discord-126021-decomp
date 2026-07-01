package d0.e0.p.d.m0.b;

import d0.t.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: CompanionObjectMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final c a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<d0.e0.p.d.m0.g.a> f3210b;

    static {
        Set<i> set = i.j;
        k kVar = k.a;
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(k.getPrimitiveFqName((i) it.next()));
        }
        d0.e0.p.d.m0.g.b safe = k$a.g.toSafe();
        d0.z.d.m.checkNotNullExpressionValue(safe, "string.toSafe()");
        List listPlus = u.plus((Collection<? extends d0.e0.p.d.m0.g.b>) arrayList, safe);
        d0.e0.p.d.m0.g.b safe2 = k$a.i.toSafe();
        d0.z.d.m.checkNotNullExpressionValue(safe2, "_boolean.toSafe()");
        List listPlus2 = u.plus((Collection<? extends d0.e0.p.d.m0.g.b>) listPlus, safe2);
        d0.e0.p.d.m0.g.b safe3 = k$a.r.toSafe();
        d0.z.d.m.checkNotNullExpressionValue(safe3, "_enum.toSafe()");
        List listPlus3 = u.plus((Collection<? extends d0.e0.p.d.m0.g.b>) listPlus2, safe3);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it2 = listPlus3.iterator();
        while (it2.hasNext()) {
            linkedHashSet.add(d0.e0.p.d.m0.g.a.topLevel((d0.e0.p.d.m0.g.b) it2.next()));
        }
        f3210b = linkedHashSet;
    }

    public final Set<d0.e0.p.d.m0.g.a> allClassesWithIntrinsicCompanions() {
        return f3210b;
    }

    public final Set<d0.e0.p.d.m0.g.a> getClassIds() {
        return f3210b;
    }
}
