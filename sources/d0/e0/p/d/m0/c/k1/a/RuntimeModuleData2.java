package d0.e0.p.d.m0.c.k1.a;

import d0.e0.p.d.m0.b.ReflectionTypes;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.NotFoundClasses;
import d0.e0.p.d.m0.c.SupertypeLoopChecker;
import d0.e0.p.d.m0.d.b.LookupTracker;
import d0.e0.p.d.m0.e.a.AnnotationTypeQualifierResolver;
import d0.e0.p.d.m0.e.a.JavaClassesTracker;
import d0.e0.p.d.m0.e.a.g0.JavaPropertyInitializerEvaluator;
import d0.e0.p.d.m0.e.a.g0.JavaResolverCache;
import d0.e0.p.d.m0.e.a.g0.SignaturePropagator;
import d0.e0.p.d.m0.e.a.i0.LazyJavaPackageFragmentProvider;
import d0.e0.p.d.m0.e.a.i0.ModuleClassResolver;
import d0.e0.p.d.m0.e.a.i0.context2;
import d0.e0.p.d.m0.e.a.i0.context3;
import d0.e0.p.d.m0.e.a.l0.signatureEnhancement;
import d0.e0.p.d.m0.e.a.l0.typeEnhancement4;
import d0.e0.p.d.m0.e.b.BinaryClassAnnotationAndConstantLoaderImpl;
import d0.e0.p.d.m0.e.b.DeserializationComponentsForJava;
import d0.e0.p.d.m0.e.b.DeserializedDescriptorResolver;
import d0.e0.p.d.m0.e.b.JavaClassDataFinder;
import d0.e0.p.d.m0.e.b.KotlinClassFinder;
import d0.e0.p.d.m0.e.b.PackagePartProvider;
import d0.e0.p.d.m0.k.z.SamConversionResolverImpl;
import d0.e0.p.d.m0.l.b.ContractDeserializer;
import d0.e0.p.d.m0.l.b.DeserializationConfiguration;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.n.l1.NewKotlinTypeChecker;
import d0.e0.p.d.m0.p.JavaTypeEnhancementState;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.l, reason: use source file name */
/* JADX INFO: compiled from: RuntimeModuleData.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RuntimeModuleData2 {
    public static final DeserializationComponentsForJava makeDeserializationComponentsForJava(ModuleDescriptor2 moduleDescriptor2, StorageManager storageManager, NotFoundClasses notFoundClasses, LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics3.checkNotNullParameter(lazyJavaPackageFragmentProvider, "lazyJavaPackageFragmentProvider");
        Intrinsics3.checkNotNullParameter(kotlinClassFinder, "reflectKotlinClassFinder");
        Intrinsics3.checkNotNullParameter(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        return new DeserializationComponentsForJava(storageManager, moduleDescriptor2, DeserializationConfiguration.a.a, new JavaClassDataFinder(kotlinClassFinder, deserializedDescriptorResolver), new BinaryClassAnnotationAndConstantLoaderImpl(moduleDescriptor2, notFoundClasses, storageManager, kotlinClassFinder), lazyJavaPackageFragmentProvider, notFoundClasses, RuntimeErrorReporter.f3286b, LookupTracker.a.a, ContractDeserializer.a.getDEFAULT(), NewKotlinTypeChecker.f3529b.getDefault());
    }

    public static final LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentFromClassLoaderProvider(ClassLoader classLoader, ModuleDescriptor2 moduleDescriptor2, StorageManager storageManager, NotFoundClasses notFoundClasses, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider) {
        Intrinsics3.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics3.checkNotNullParameter(kotlinClassFinder, "reflectKotlinClassFinder");
        Intrinsics3.checkNotNullParameter(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        Intrinsics3.checkNotNullParameter(moduleClassResolver, "singleModuleClassResolver");
        Intrinsics3.checkNotNullParameter(packagePartProvider, "packagePartProvider");
        JavaTypeEnhancementState javaTypeEnhancementState = JavaTypeEnhancementState.f3563b;
        AnnotationTypeQualifierResolver annotationTypeQualifierResolver = new AnnotationTypeQualifierResolver(storageManager, javaTypeEnhancementState);
        ReflectJavaClassFinder reflectJavaClassFinder = new ReflectJavaClassFinder(classLoader);
        SignaturePropagator signaturePropagator = SignaturePropagator.a;
        Intrinsics3.checkNotNullExpressionValue(signaturePropagator, "DO_NOTHING");
        RuntimeErrorReporter runtimeErrorReporter = RuntimeErrorReporter.f3286b;
        JavaResolverCache javaResolverCache = JavaResolverCache.a;
        Intrinsics3.checkNotNullExpressionValue(javaResolverCache, "EMPTY");
        JavaPropertyInitializerEvaluator.a aVar = JavaPropertyInitializerEvaluator.a.a;
        SamConversionResolverImpl samConversionResolverImpl = new SamConversionResolverImpl(storageManager, Collections2.emptyList());
        RuntimeSourceElementFactory runtimeSourceElementFactory = RuntimeSourceElementFactory.a;
        SupertypeLoopChecker.a aVar2 = SupertypeLoopChecker.a.a;
        LookupTracker.a aVar3 = LookupTracker.a.a;
        ReflectionTypes reflectionTypes = new ReflectionTypes(moduleDescriptor2, notFoundClasses);
        context3.a aVar4 = context3.a.a;
        return new LazyJavaPackageFragmentProvider(new context2(storageManager, reflectJavaClassFinder, kotlinClassFinder, deserializedDescriptorResolver, signaturePropagator, runtimeErrorReporter, javaResolverCache, aVar, samConversionResolverImpl, runtimeSourceElementFactory, moduleClassResolver, packagePartProvider, aVar2, aVar3, moduleDescriptor2, reflectionTypes, annotationTypeQualifierResolver, new signatureEnhancement(annotationTypeQualifierResolver, javaTypeEnhancementState, new typeEnhancement4(aVar4)), JavaClassesTracker.a.a, aVar4, NewKotlinTypeChecker.f3529b.getDefault(), javaTypeEnhancementState));
    }
}
