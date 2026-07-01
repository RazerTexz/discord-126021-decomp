package d0.e0.p.d.m0.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: PackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h0 {
    public static final void collectPackageFragmentsOptimizedIfPossible(f0 f0Var, d0.e0.p.d.m0.g.b bVar, Collection<e0> collection) {
        d0.z.d.m.checkNotNullParameter(f0Var, "<this>");
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.z.d.m.checkNotNullParameter(collection, "packageFragments");
        if (f0Var instanceof i0) {
            ((i0) f0Var).collectPackageFragments(bVar, collection);
        } else {
            collection.addAll(f0Var.getPackageFragments(bVar));
        }
    }

    public static final List<e0> packageFragments(f0 f0Var, d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(f0Var, "<this>");
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        ArrayList arrayList = new ArrayList();
        collectPackageFragmentsOptimizedIfPossible(f0Var, bVar, arrayList);
        return arrayList;
    }
}
