package d0.e0.p.d.m0.e.a.i0;

import d0.Lazy4;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.c.PackageFragmentProvider3;
import d0.e0.p.d.m0.e.a.i0.l.LazyJavaPackageFragment;
import d0.e0.p.d.m0.e.a.i0.resolvers2;
import d0.e0.p.d.m0.e.a.k0.u;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.m.LockBasedStorageManager;
import d0.e0.p.d.m0.m.storage;
import d0.e0.p.d.m0.p.collections;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.f, reason: use source file name */
/* JADX INFO: compiled from: LazyJavaPackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaPackageFragmentProvider implements PackageFragmentProvider3 {
    public final context4 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final storage<FqName, LazyJavaPackageFragment> f3322b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.f$a */
    /* JADX INFO: compiled from: LazyJavaPackageFragmentProvider.kt */
    public static final class a extends Lambda implements Function0<LazyJavaPackageFragment> {
        public final /* synthetic */ u $jPackage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u uVar) {
            super(0);
            this.$jPackage = uVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LazyJavaPackageFragment invoke() {
            return new LazyJavaPackageFragment(LazyJavaPackageFragmentProvider.this.a, this.$jPackage);
        }
    }

    public LazyJavaPackageFragmentProvider(context2 context2Var) {
        Intrinsics3.checkNotNullParameter(context2Var, "components");
        context4 context4Var = new context4(context2Var, resolvers2.a.a, Lazy4.lazyOf(null));
        this.a = context4Var;
        this.f3322b = context4Var.getStorageManager().createCacheWithNotNullValues();
    }

    public final LazyJavaPackageFragment a(FqName fqName) {
        u uVarFindPackage = this.a.getComponents().getFinder().findPackage(fqName);
        if (uVarFindPackage == null) {
            return null;
        }
        return (LazyJavaPackageFragment) ((LockBasedStorageManager.d) this.f3322b).computeIfAbsent(fqName, new a(uVarFindPackage));
    }

    @Override // d0.e0.p.d.m0.c.PackageFragmentProvider3
    public void collectPackageFragments(FqName fqName, Collection<PackageFragmentDescriptor> collection) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(collection, "packageFragments");
        collections.addIfNotNull(collection, a(fqName));
    }

    @Override // d0.e0.p.d.m0.c.PackageFragmentProvider
    public List<LazyJavaPackageFragment> getPackageFragments(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        return Collections2.listOfNotNull(a(fqName));
    }

    @Override // d0.e0.p.d.m0.c.PackageFragmentProvider
    public /* bridge */ /* synthetic */ Collection getSubPackagesOf(FqName fqName, Function1 function1) {
        return getSubPackagesOf(fqName, (Function1<? super Name, Boolean>) function1);
    }

    @Override // d0.e0.p.d.m0.c.PackageFragmentProvider
    public List<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        LazyJavaPackageFragment lazyJavaPackageFragmentA = a(fqName);
        List<FqName> subPackageFqNames$descriptors_jvm = lazyJavaPackageFragmentA == null ? null : lazyJavaPackageFragmentA.getSubPackageFqNames$descriptors_jvm();
        return subPackageFqNames$descriptors_jvm != null ? subPackageFqNames$descriptors_jvm : Collections2.emptyList();
    }
}
