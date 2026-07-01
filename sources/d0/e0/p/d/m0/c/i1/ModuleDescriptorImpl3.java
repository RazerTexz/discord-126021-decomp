package d0.e0.p.d.m0.c.i1;

import b.d.b.a.outline;
import d0.LazyJVM;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptorVisitor;
import d0.e0.p.d.m0.c.ModuleCapability;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.PackageFragmentProvider;
import d0.e0.p.d.m0.c.PackageViewDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.h.TargetPlatform;
import d0.e0.p.d.m0.m.LockBasedStorageManager;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.m.storage3;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner2;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner3;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.t._Arrays;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleException;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.y, reason: use source file name */
/* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ModuleDescriptorImpl3 extends DeclarationDescriptorImpl implements ModuleDescriptor2 {
    public final StorageManager l;
    public final KotlinBuiltIns m;
    public final Map<ModuleCapability<?>, Object> n;
    public ModuleDescriptorImpl o;
    public PackageFragmentProvider p;
    public boolean q;
    public final storage3<FqName, PackageViewDescriptor> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f3278s;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.y$a */
    /* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
    public static final class a extends Lambda implements Function0<CompositePackageFragmentProvider> {
        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CompositePackageFragmentProvider invoke() {
            ModuleDescriptorImpl moduleDescriptorImpl = ModuleDescriptorImpl3.this.o;
            ModuleDescriptorImpl3 moduleDescriptorImpl3 = ModuleDescriptorImpl3.this;
            if (moduleDescriptorImpl == null) {
                StringBuilder sbU = outline.U("Dependencies of module ");
                sbU.append(moduleDescriptorImpl3.b());
                sbU.append(" were not set before querying module content");
                throw new AssertionError(sbU.toString());
            }
            List<ModuleDescriptorImpl3> allDependencies = moduleDescriptorImpl.getAllDependencies();
            allDependencies.contains(ModuleDescriptorImpl3.this);
            Iterator<T> it = allDependencies.iterator();
            while (it.hasNext()) {
                ModuleDescriptorImpl3.access$isInitialized((ModuleDescriptorImpl3) it.next());
            }
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(allDependencies, 10));
            Iterator<T> it2 = allDependencies.iterator();
            while (it2.hasNext()) {
                PackageFragmentProvider packageFragmentProvider = ((ModuleDescriptorImpl3) it2.next()).p;
                Intrinsics3.checkNotNull(packageFragmentProvider);
                arrayList.add(packageFragmentProvider);
            }
            return new CompositePackageFragmentProvider(arrayList);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.y$b */
    /* JADX INFO: compiled from: ModuleDescriptorImpl.kt */
    public static final class b extends Lambda implements Function1<FqName, PackageViewDescriptor> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final PackageViewDescriptor invoke(FqName fqName) {
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            ModuleDescriptorImpl3 moduleDescriptorImpl3 = ModuleDescriptorImpl3.this;
            return new LazyPackageViewDescriptorImpl(moduleDescriptorImpl3, fqName, moduleDescriptorImpl3.l);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModuleDescriptorImpl3(Name name, StorageManager storageManager, KotlinBuiltIns kotlinBuiltIns, TargetPlatform targetPlatform) {
        this(name, storageManager, kotlinBuiltIns, targetPlatform, null, null, 48, null);
        Intrinsics3.checkNotNullParameter(name, "moduleName");
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "builtIns");
    }

    public /* synthetic */ ModuleDescriptorImpl3(Name name, StorageManager storageManager, KotlinBuiltIns kotlinBuiltIns, TargetPlatform targetPlatform, Map map, Name name2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(name, storageManager, kotlinBuiltIns, (i & 8) != 0 ? null : targetPlatform, (i & 16) != 0 ? Maps6.emptyMap() : map, (i & 32) != 0 ? null : name2);
    }

    public static final boolean access$isInitialized(ModuleDescriptorImpl3 moduleDescriptorImpl3) {
        return moduleDescriptorImpl3.p != null;
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return (R) ModuleDescriptor2.a.accept(this, declarationDescriptorVisitor, d);
    }

    public void assertValid() {
        if (!isValid()) {
            throw new InvalidModuleException(Intrinsics3.stringPlus("Accessing invalid module descriptor ", this));
        }
    }

    public final String b() {
        String string = getName().toString();
        Intrinsics3.checkNotNullExpressionValue(string, "name.toString()");
        return string;
    }

    @Override // d0.e0.p.d.m0.c.ModuleDescriptor2
    public KotlinBuiltIns getBuiltIns() {
        return this.m;
    }

    @Override // d0.e0.p.d.m0.c.ModuleDescriptor2
    public <T> T getCapability(ModuleCapability<T> moduleCapability) {
        Intrinsics3.checkNotNullParameter(moduleCapability, "capability");
        return (T) this.n.get(moduleCapability);
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        return ModuleDescriptor2.a.getContainingDeclaration(this);
    }

    @Override // d0.e0.p.d.m0.c.ModuleDescriptor2
    public List<ModuleDescriptor2> getExpectedByModules() {
        ModuleDescriptorImpl moduleDescriptorImpl = this.o;
        if (moduleDescriptorImpl != null) {
            return moduleDescriptorImpl.getDirectExpectedByDependencies();
        }
        StringBuilder sbU = outline.U("Dependencies of module ");
        sbU.append(b());
        sbU.append(" were not set");
        throw new AssertionError(sbU.toString());
    }

    @Override // d0.e0.p.d.m0.c.ModuleDescriptor2
    public PackageViewDescriptor getPackage(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        assertValid();
        return (PackageViewDescriptor) ((LockBasedStorageManager.m) this.r).invoke(fqName);
    }

    public final PackageFragmentProvider getPackageFragmentProvider() {
        assertValid();
        return (CompositePackageFragmentProvider) this.f3278s.getValue();
    }

    @Override // d0.e0.p.d.m0.c.ModuleDescriptor2
    public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        assertValid();
        return getPackageFragmentProvider().getSubPackagesOf(fqName, function1);
    }

    public final void initialize(PackageFragmentProvider packageFragmentProvider) {
        Intrinsics3.checkNotNullParameter(packageFragmentProvider, "providerForModuleContent");
        this.p = packageFragmentProvider;
    }

    public boolean isValid() {
        return this.q;
    }

    public final void setDependencies(ModuleDescriptorImpl moduleDescriptorImpl) {
        Intrinsics3.checkNotNullParameter(moduleDescriptorImpl, "dependencies");
        ModuleDescriptorImpl moduleDescriptorImpl2 = this.o;
        this.o = moduleDescriptorImpl;
    }

    @Override // d0.e0.p.d.m0.c.ModuleDescriptor2
    public boolean shouldSeeInternalsOf(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "targetModule");
        if (Intrinsics3.areEqual(this, moduleDescriptor2)) {
            return true;
        }
        ModuleDescriptorImpl moduleDescriptorImpl = this.o;
        Intrinsics3.checkNotNull(moduleDescriptorImpl);
        return _Collections.contains(moduleDescriptorImpl.getModulesWhoseInternalsAreVisible(), moduleDescriptor2) || getExpectedByModules().contains(moduleDescriptor2) || moduleDescriptor2.getExpectedByModules().contains(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModuleDescriptorImpl3(Name name, StorageManager storageManager, KotlinBuiltIns kotlinBuiltIns, TargetPlatform targetPlatform, Map<ModuleCapability<?>, ? extends Object> map, Name name2) {
        super(Annotations4.f.getEMPTY(), name);
        Intrinsics3.checkNotNullParameter(name, "moduleName");
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        Intrinsics3.checkNotNullParameter(map, "capabilities");
        this.l = storageManager;
        this.m = kotlinBuiltIns;
        if (name.isSpecial()) {
            Map<ModuleCapability<?>, Object> mutableMap = Maps6.toMutableMap(map);
            this.n = mutableMap;
            mutableMap.put(KotlinTypeRefiner2.getREFINER_CAPABILITY(), new KotlinTypeRefiner3(null));
            this.q = true;
            this.r = storageManager.createMemoizedFunction(new b());
            this.f3278s = LazyJVM.lazy(new a());
            return;
        }
        throw new IllegalArgumentException(Intrinsics3.stringPlus("Module name must be special: ", name));
    }

    public final void setDependencies(ModuleDescriptorImpl3... moduleDescriptorImpl3Arr) {
        Intrinsics3.checkNotNullParameter(moduleDescriptorImpl3Arr, "descriptors");
        setDependencies(_Arrays.toList(moduleDescriptorImpl3Arr));
    }

    public final void setDependencies(List<ModuleDescriptorImpl3> list) {
        Intrinsics3.checkNotNullParameter(list, "descriptors");
        setDependencies(list, Sets5.emptySet());
    }

    public final void setDependencies(List<ModuleDescriptorImpl3> list, Set<ModuleDescriptorImpl3> set) {
        Intrinsics3.checkNotNullParameter(list, "descriptors");
        Intrinsics3.checkNotNullParameter(set, "friends");
        setDependencies(new ModuleDescriptorImpl2(list, set, Collections2.emptyList(), Sets5.emptySet()));
    }
}
