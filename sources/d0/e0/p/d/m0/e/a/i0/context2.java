package d0.e0.p.d.m0.e.a.i0;

import d0.e0.p.d.m0.b.ReflectionTypes;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.SupertypeLoopChecker;
import d0.e0.p.d.m0.d.b.LookupTracker;
import d0.e0.p.d.m0.e.a.AnnotationTypeQualifierResolver;
import d0.e0.p.d.m0.e.a.JavaClassFinder;
import d0.e0.p.d.m0.e.a.JavaClassesTracker;
import d0.e0.p.d.m0.e.a.g0.JavaPropertyInitializerEvaluator;
import d0.e0.p.d.m0.e.a.g0.JavaResolverCache;
import d0.e0.p.d.m0.e.a.g0.SignaturePropagator;
import d0.e0.p.d.m0.e.a.j0.JavaSourceElementFactory2;
import d0.e0.p.d.m0.e.a.l0.signatureEnhancement;
import d0.e0.p.d.m0.e.b.DeserializedDescriptorResolver;
import d0.e0.p.d.m0.e.b.KotlinClassFinder;
import d0.e0.p.d.m0.e.b.PackagePartProvider;
import d0.e0.p.d.m0.k.z.SamConversionResolver;
import d0.e0.p.d.m0.l.b.ErrorReporter;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.n.l1.NewKotlinTypeChecker;
import d0.e0.p.d.m0.p.JavaTypeEnhancementState;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.b, reason: use source file name */
/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class context2 {
    public final StorageManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JavaClassFinder f3320b;
    public final KotlinClassFinder c;
    public final DeserializedDescriptorResolver d;
    public final SignaturePropagator e;
    public final ErrorReporter f;
    public final JavaResolverCache g;
    public final JavaPropertyInitializerEvaluator h;
    public final SamConversionResolver i;
    public final JavaSourceElementFactory2 j;
    public final ModuleClassResolver k;
    public final PackagePartProvider l;
    public final SupertypeLoopChecker m;
    public final LookupTracker n;
    public final ModuleDescriptor2 o;
    public final ReflectionTypes p;
    public final AnnotationTypeQualifierResolver q;
    public final signatureEnhancement r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final JavaClassesTracker f3321s;
    public final context3 t;
    public final NewKotlinTypeChecker u;
    public final JavaTypeEnhancementState v;

    public context2(StorageManager storageManager, JavaClassFinder javaClassFinder, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, SignaturePropagator signaturePropagator, ErrorReporter errorReporter, JavaResolverCache javaResolverCache, JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator, SamConversionResolver samConversionResolver, JavaSourceElementFactory2 javaSourceElementFactory2, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider, SupertypeLoopChecker supertypeLoopChecker, LookupTracker lookupTracker, ModuleDescriptor2 moduleDescriptor2, ReflectionTypes reflectionTypes, AnnotationTypeQualifierResolver annotationTypeQualifierResolver, signatureEnhancement signatureenhancement, JavaClassesTracker javaClassesTracker, context3 context3Var, NewKotlinTypeChecker newKotlinTypeChecker, JavaTypeEnhancementState javaTypeEnhancementState) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(javaClassFinder, "finder");
        Intrinsics3.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        Intrinsics3.checkNotNullParameter(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        Intrinsics3.checkNotNullParameter(signaturePropagator, "signaturePropagator");
        Intrinsics3.checkNotNullParameter(errorReporter, "errorReporter");
        Intrinsics3.checkNotNullParameter(javaResolverCache, "javaResolverCache");
        Intrinsics3.checkNotNullParameter(javaPropertyInitializerEvaluator, "javaPropertyInitializerEvaluator");
        Intrinsics3.checkNotNullParameter(samConversionResolver, "samConversionResolver");
        Intrinsics3.checkNotNullParameter(javaSourceElementFactory2, "sourceElementFactory");
        Intrinsics3.checkNotNullParameter(moduleClassResolver, "moduleClassResolver");
        Intrinsics3.checkNotNullParameter(packagePartProvider, "packagePartProvider");
        Intrinsics3.checkNotNullParameter(supertypeLoopChecker, "supertypeLoopChecker");
        Intrinsics3.checkNotNullParameter(lookupTracker, "lookupTracker");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        Intrinsics3.checkNotNullParameter(reflectionTypes, "reflectionTypes");
        Intrinsics3.checkNotNullParameter(annotationTypeQualifierResolver, "annotationTypeQualifierResolver");
        Intrinsics3.checkNotNullParameter(signatureenhancement, "signatureEnhancement");
        Intrinsics3.checkNotNullParameter(javaClassesTracker, "javaClassesTracker");
        Intrinsics3.checkNotNullParameter(context3Var, "settings");
        Intrinsics3.checkNotNullParameter(newKotlinTypeChecker, "kotlinTypeChecker");
        Intrinsics3.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.a = storageManager;
        this.f3320b = javaClassFinder;
        this.c = kotlinClassFinder;
        this.d = deserializedDescriptorResolver;
        this.e = signaturePropagator;
        this.f = errorReporter;
        this.g = javaResolverCache;
        this.h = javaPropertyInitializerEvaluator;
        this.i = samConversionResolver;
        this.j = javaSourceElementFactory2;
        this.k = moduleClassResolver;
        this.l = packagePartProvider;
        this.m = supertypeLoopChecker;
        this.n = lookupTracker;
        this.o = moduleDescriptor2;
        this.p = reflectionTypes;
        this.q = annotationTypeQualifierResolver;
        this.r = signatureenhancement;
        this.f3321s = javaClassesTracker;
        this.t = context3Var;
        this.u = newKotlinTypeChecker;
        this.v = javaTypeEnhancementState;
    }

    public final AnnotationTypeQualifierResolver getAnnotationTypeQualifierResolver() {
        return this.q;
    }

    public final DeserializedDescriptorResolver getDeserializedDescriptorResolver() {
        return this.d;
    }

    public final ErrorReporter getErrorReporter() {
        return this.f;
    }

    public final JavaClassFinder getFinder() {
        return this.f3320b;
    }

    public final JavaClassesTracker getJavaClassesTracker() {
        return this.f3321s;
    }

    public final JavaPropertyInitializerEvaluator getJavaPropertyInitializerEvaluator() {
        return this.h;
    }

    public final JavaResolverCache getJavaResolverCache() {
        return this.g;
    }

    public final JavaTypeEnhancementState getJavaTypeEnhancementState() {
        return this.v;
    }

    public final KotlinClassFinder getKotlinClassFinder() {
        return this.c;
    }

    public final NewKotlinTypeChecker getKotlinTypeChecker() {
        return this.u;
    }

    public final LookupTracker getLookupTracker() {
        return this.n;
    }

    public final ModuleDescriptor2 getModule() {
        return this.o;
    }

    public final ModuleClassResolver getModuleClassResolver() {
        return this.k;
    }

    public final PackagePartProvider getPackagePartProvider() {
        return this.l;
    }

    public final ReflectionTypes getReflectionTypes() {
        return this.p;
    }

    public final context3 getSettings() {
        return this.t;
    }

    public final signatureEnhancement getSignatureEnhancement() {
        return this.r;
    }

    public final SignaturePropagator getSignaturePropagator() {
        return this.e;
    }

    public final JavaSourceElementFactory2 getSourceElementFactory() {
        return this.j;
    }

    public final StorageManager getStorageManager() {
        return this.a;
    }

    public final SupertypeLoopChecker getSupertypeLoopChecker() {
        return this.m;
    }

    public final context2 replace(JavaResolverCache javaResolverCache) {
        Intrinsics3.checkNotNullParameter(javaResolverCache, "javaResolverCache");
        return new context2(this.a, this.f3320b, this.c, this.d, this.e, this.f, javaResolverCache, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.f3321s, this.t, this.u, this.v);
    }
}
