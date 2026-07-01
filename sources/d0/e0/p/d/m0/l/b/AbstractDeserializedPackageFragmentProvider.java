package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.b.q.JvmBuiltInsPackageFragmentProvider;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.PackageFragmentDescriptor;
import d0.e0.p.d.m0.c.PackageFragmentProvider3;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.l.b.d0.BuiltInsPackageFragmentImpl;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.m.storage4;
import d0.e0.p.d.m0.p.collections;
import d0.t.Collections2;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.a, reason: use source file name */
/* JADX INFO: compiled from: AbstractDeserializedPackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractDeserializedPackageFragmentProvider implements PackageFragmentProvider3 {
    public final StorageManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KotlinMetadataFinder f3481b;
    public final ModuleDescriptor2 c;
    public context5 d;
    public final storage4<FqName, PackageFragmentDescriptor> e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.a$a */
    /* JADX INFO: compiled from: AbstractDeserializedPackageFragmentProvider.kt */
    public static final class a extends Lambda implements Function1<FqName, PackageFragmentDescriptor> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final PackageFragmentDescriptor invoke(FqName fqName) {
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            JvmBuiltInsPackageFragmentProvider jvmBuiltInsPackageFragmentProvider = (JvmBuiltInsPackageFragmentProvider) AbstractDeserializedPackageFragmentProvider.this;
            Objects.requireNonNull(jvmBuiltInsPackageFragmentProvider);
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            InputStream inputStreamFindBuiltInsData = jvmBuiltInsPackageFragmentProvider.f3481b.findBuiltInsData(fqName);
            BuiltInsPackageFragmentImpl builtInsPackageFragmentImplCreate = inputStreamFindBuiltInsData == null ? null : BuiltInsPackageFragmentImpl.v.create(fqName, jvmBuiltInsPackageFragmentProvider.a, jvmBuiltInsPackageFragmentProvider.c, inputStreamFindBuiltInsData, false);
            if (builtInsPackageFragmentImplCreate == null) {
                return null;
            }
            context5 context5Var = AbstractDeserializedPackageFragmentProvider.this.d;
            if (context5Var != null) {
                builtInsPackageFragmentImplCreate.initialize(context5Var);
                return builtInsPackageFragmentImplCreate;
            }
            Intrinsics3.throwUninitializedPropertyAccessException("components");
            throw null;
        }
    }

    public AbstractDeserializedPackageFragmentProvider(StorageManager storageManager, KotlinMetadataFinder kotlinMetadataFinder, ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(kotlinMetadataFinder, "finder");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        this.a = storageManager;
        this.f3481b = kotlinMetadataFinder;
        this.c = moduleDescriptor2;
        this.e = storageManager.createMemoizedFunctionWithNullableValues(new a());
    }

    @Override // d0.e0.p.d.m0.c.PackageFragmentProvider3
    public void collectPackageFragments(FqName fqName, Collection<PackageFragmentDescriptor> collection) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(collection, "packageFragments");
        collections.addIfNotNull(collection, this.e.invoke(fqName));
    }

    @Override // d0.e0.p.d.m0.c.PackageFragmentProvider
    public List<PackageFragmentDescriptor> getPackageFragments(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        return Collections2.listOfNotNull(this.e.invoke(fqName));
    }

    @Override // d0.e0.p.d.m0.c.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        return Sets5.emptySet();
    }
}
