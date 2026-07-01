package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.c.PackageFragmentProvider;
import d0.e0.p.d.m0.c.PackageFragmentProvider2;
import d0.e0.p.d.m0.c.PackageFragmentProvider3;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.j, reason: use source file name */
/* JADX INFO: compiled from: CompositePackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CompositePackageFragmentProvider implements PackageFragmentProvider3 {
    public final List<PackageFragmentProvider> a;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositePackageFragmentProvider(List<? extends PackageFragmentProvider> list) {
        Intrinsics3.checkNotNullParameter(list, "providers");
        this.a = list;
        list.size();
        _Collections.toSet(list).size();
    }

    @Override // d0.e0.p.d.m0.c.PackageFragmentProvider3
    public void collectPackageFragments(FqName fqName, Collection<PackageFragmentDescriptor> collection) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(collection, "packageFragments");
        Iterator<PackageFragmentProvider> it = this.a.iterator();
        while (it.hasNext()) {
            PackageFragmentProvider2.collectPackageFragmentsOptimizedIfPossible(it.next(), fqName, collection);
        }
    }

    @Override // d0.e0.p.d.m0.c.PackageFragmentProvider
    public List<PackageFragmentDescriptor> getPackageFragments(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        Iterator<PackageFragmentProvider> it = this.a.iterator();
        while (it.hasNext()) {
            PackageFragmentProvider2.collectPackageFragmentsOptimizedIfPossible(it.next(), fqName, arrayList);
        }
        return _Collections.toList(arrayList);
    }

    @Override // d0.e0.p.d.m0.c.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        HashSet hashSet = new HashSet();
        Iterator<PackageFragmentProvider> it = this.a.iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().getSubPackagesOf(fqName, function1));
        }
        return hashSet;
    }
}
