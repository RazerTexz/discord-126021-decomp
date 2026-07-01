package d0.e0.p.d.m0.c;

import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.f0._Sequences2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g0, reason: use source file name */
/* JADX INFO: compiled from: PackageFragmentProviderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PackageFragmentProviderImpl implements PackageFragmentProvider3 {
    public final Collection<PackageFragmentDescriptor> a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g0$a */
    /* JADX INFO: compiled from: PackageFragmentProviderImpl.kt */
    public static final class a extends Lambda implements Function1<PackageFragmentDescriptor, FqName> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final FqName invoke(PackageFragmentDescriptor packageFragmentDescriptor) {
            Intrinsics3.checkNotNullParameter(packageFragmentDescriptor, "it");
            return packageFragmentDescriptor.getFqName();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.g0$b */
    /* JADX INFO: compiled from: PackageFragmentProviderImpl.kt */
    public static final class b extends Lambda implements Function1<FqName, Boolean> {
        public final /* synthetic */ FqName $fqName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FqName fqName) {
            super(1);
            this.$fqName = fqName;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FqName fqName) {
            return Boolean.valueOf(invoke2(fqName));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FqName fqName) {
            Intrinsics3.checkNotNullParameter(fqName, "it");
            return !fqName.isRoot() && Intrinsics3.areEqual(fqName.parent(), this.$fqName);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PackageFragmentProviderImpl(Collection<? extends PackageFragmentDescriptor> collection) {
        Intrinsics3.checkNotNullParameter(collection, "packageFragments");
        this.a = collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.e0.p.d.m0.c.PackageFragmentProvider3
    public void collectPackageFragments(FqName fqName, Collection<PackageFragmentDescriptor> collection) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(collection, "packageFragments");
        for (Object obj : this.a) {
            if (Intrinsics3.areEqual(((PackageFragmentDescriptor) obj).getFqName(), fqName)) {
                collection.add(obj);
            }
        }
    }

    @Override // d0.e0.p.d.m0.c.PackageFragmentProvider
    public List<PackageFragmentDescriptor> getPackageFragments(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Collection<PackageFragmentDescriptor> collection = this.a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (Intrinsics3.areEqual(((PackageFragmentDescriptor) obj).getFqName(), fqName)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.c.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        return _Sequences2.toList(_Sequences2.filter(_Sequences2.map(_Collections.asSequence(this.a), a.j), new b(fqName)));
    }
}
