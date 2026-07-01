package d0.e0.p.d.m0.c.k1.a;

import d0.e0.p.d.m0.b.q.JvmBuiltIns;
import d0.e0.p.d.m0.b.q.JvmBuiltInsPackageFragmentProvider;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.NotFoundClasses;
import d0.e0.p.d.m0.c.PackageFragmentProvider3;
import d0.e0.p.d.m0.c.i1.CompositePackageFragmentProvider;
import d0.e0.p.d.m0.c.i1.ModuleDescriptorImpl3;
import d0.e0.p.d.m0.e.a.g0.JavaResolverCache;
import d0.e0.p.d.m0.e.a.i0.LazyJavaPackageFragmentProvider;
import d0.e0.p.d.m0.e.a.i0.ModuleClassResolver2;
import d0.e0.p.d.m0.e.b.DeserializationComponentsForJava;
import d0.e0.p.d.m0.e.b.DeserializedDescriptorResolver;
import d0.e0.p.d.m0.e.b.PackagePartProvider;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.y.JavaDescriptorResolver;
import d0.e0.p.d.m0.k.z.SamConversionResolverImpl;
import d0.e0.p.d.m0.l.b.DeserializationConfiguration;
import d0.e0.p.d.m0.l.b.context5;
import d0.e0.p.d.m0.m.LockBasedStorageManager;
import d0.e0.p.d.m0.n.l1.NewKotlinTypeChecker;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.k, reason: use source file name */
/* JADX INFO: compiled from: RuntimeModuleData.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RuntimeModuleData {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final context5 f3287b;
    public final PackagePartScopeCache c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.k$a */
    /* JADX INFO: compiled from: RuntimeModuleData.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final RuntimeModuleData create(ClassLoader classLoader) {
            Intrinsics3.checkNotNullParameter(classLoader, "classLoader");
            LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("RuntimeModuleData");
            JvmBuiltIns jvmBuiltIns = new JvmBuiltIns(lockBasedStorageManager, JvmBuiltIns.a.FROM_DEPENDENCIES);
            Name nameSpecial = Name.special("<runtime module for " + classLoader + '>');
            Intrinsics3.checkNotNullExpressionValue(nameSpecial, "special(\"<runtime module for $classLoader>\")");
            ModuleDescriptorImpl3 moduleDescriptorImpl3 = new ModuleDescriptorImpl3(nameSpecial, lockBasedStorageManager, jvmBuiltIns, null, null, null, 56, null);
            jvmBuiltIns.setBuiltInsModule(moduleDescriptorImpl3);
            jvmBuiltIns.initialize(moduleDescriptorImpl3, true);
            ReflectKotlinClassFinder reflectKotlinClassFinder = new ReflectKotlinClassFinder(classLoader);
            DeserializedDescriptorResolver deserializedDescriptorResolver = new DeserializedDescriptorResolver();
            ModuleClassResolver2 moduleClassResolver2 = new ModuleClassResolver2();
            NotFoundClasses notFoundClasses = new NotFoundClasses(lockBasedStorageManager, moduleDescriptorImpl3);
            LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProviderMakeLazyJavaPackageFragmentFromClassLoaderProvider = RuntimeModuleData2.makeLazyJavaPackageFragmentFromClassLoaderProvider(classLoader, moduleDescriptorImpl3, lockBasedStorageManager, notFoundClasses, reflectKotlinClassFinder, deserializedDescriptorResolver, moduleClassResolver2, (128 & 128) != 0 ? PackagePartProvider.a.a : null);
            DeserializationComponentsForJava deserializationComponentsForJavaMakeDeserializationComponentsForJava = RuntimeModuleData2.makeDeserializationComponentsForJava(moduleDescriptorImpl3, lockBasedStorageManager, notFoundClasses, lazyJavaPackageFragmentProviderMakeLazyJavaPackageFragmentFromClassLoaderProvider, reflectKotlinClassFinder, deserializedDescriptorResolver);
            deserializedDescriptorResolver.setComponents(deserializationComponentsForJavaMakeDeserializationComponentsForJava);
            JavaResolverCache javaResolverCache = JavaResolverCache.a;
            Intrinsics3.checkNotNullExpressionValue(javaResolverCache, "EMPTY");
            JavaDescriptorResolver javaDescriptorResolver = new JavaDescriptorResolver(lazyJavaPackageFragmentProviderMakeLazyJavaPackageFragmentFromClassLoaderProvider, javaResolverCache);
            moduleClassResolver2.setResolver(javaDescriptorResolver);
            ClassLoader classLoader2 = Unit.class.getClassLoader();
            Intrinsics3.checkNotNullExpressionValue(classLoader2, "stdlibClassLoader");
            JvmBuiltInsPackageFragmentProvider jvmBuiltInsPackageFragmentProvider = new JvmBuiltInsPackageFragmentProvider(lockBasedStorageManager, new ReflectKotlinClassFinder(classLoader2), moduleDescriptorImpl3, notFoundClasses, jvmBuiltIns.getCustomizer(), jvmBuiltIns.getCustomizer(), DeserializationConfiguration.a.a, NewKotlinTypeChecker.f3529b.getDefault(), new SamConversionResolverImpl(lockBasedStorageManager, Collections2.emptyList()));
            moduleDescriptorImpl3.setDependencies(moduleDescriptorImpl3);
            moduleDescriptorImpl3.initialize(new CompositePackageFragmentProvider(Collections2.listOf((Object[]) new PackageFragmentProvider3[]{javaDescriptorResolver.getPackageFragmentProvider(), jvmBuiltInsPackageFragmentProvider})));
            return new RuntimeModuleData(deserializationComponentsForJavaMakeDeserializationComponentsForJava.getComponents(), new PackagePartScopeCache(deserializedDescriptorResolver, reflectKotlinClassFinder), null);
        }
    }

    public RuntimeModuleData(context5 context5Var, PackagePartScopeCache packagePartScopeCache, DefaultConstructorMarker defaultConstructorMarker) {
        this.f3287b = context5Var;
        this.c = packagePartScopeCache;
    }

    public final context5 getDeserialization() {
        return this.f3287b;
    }

    public final ModuleDescriptor2 getModule() {
        return this.f3287b.getModuleDescriptor();
    }

    public final PackagePartScopeCache getPackagePartScopeCache() {
        return this.c;
    }
}
