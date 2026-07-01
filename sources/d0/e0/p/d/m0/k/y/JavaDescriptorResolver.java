package d0.e0.p.d.m0.k.y;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.d.b.LookupLocation3;
import d0.e0.p.d.m0.e.a.g0.JavaResolverCache;
import d0.e0.p.d.m0.e.a.i0.LazyJavaPackageFragmentProvider;
import d0.e0.p.d.m0.e.a.i0.l.LazyJavaPackageFragment;
import d0.e0.p.d.m0.e.a.k0.c0;
import d0.e0.p.d.m0.e.a.k0.g;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.y.b, reason: use source file name */
/* JADX INFO: compiled from: JavaDescriptorResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaDescriptorResolver {
    public final LazyJavaPackageFragmentProvider a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JavaResolverCache f3478b;

    public JavaDescriptorResolver(LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, JavaResolverCache javaResolverCache) {
        Intrinsics3.checkNotNullParameter(lazyJavaPackageFragmentProvider, "packageFragmentProvider");
        Intrinsics3.checkNotNullParameter(javaResolverCache, "javaResolverCache");
        this.a = lazyJavaPackageFragmentProvider;
        this.f3478b = javaResolverCache;
    }

    public final LazyJavaPackageFragmentProvider getPackageFragmentProvider() {
        return this.a;
    }

    public final ClassDescriptor resolveClass(g gVar) {
        Intrinsics3.checkNotNullParameter(gVar, "javaClass");
        FqName fqName = gVar.getFqName();
        if (fqName != null && gVar.getLightClassOriginKind() == c0.SOURCE) {
            return ((JavaResolverCache.a) this.f3478b).getClassResolvedFromSource(fqName);
        }
        g outerClass = gVar.getOuterClass();
        if (outerClass != null) {
            ClassDescriptor classDescriptorResolveClass = resolveClass(outerClass);
            MemberScope3 unsubstitutedInnerClassesScope = classDescriptorResolveClass == null ? null : classDescriptorResolveClass.getUnsubstitutedInnerClassesScope();
            ClassifierDescriptor contributedClassifier = unsubstitutedInnerClassesScope == null ? null : unsubstitutedInnerClassesScope.getContributedClassifier(gVar.getName(), LookupLocation3.FROM_JAVA_LOADER);
            if (contributedClassifier instanceof ClassDescriptor) {
                return (ClassDescriptor) contributedClassifier;
            }
            return null;
        }
        if (fqName == null) {
            return null;
        }
        LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider = this.a;
        FqName fqNameParent = fqName.parent();
        Intrinsics3.checkNotNullExpressionValue(fqNameParent, "fqName.parent()");
        LazyJavaPackageFragment lazyJavaPackageFragment = (LazyJavaPackageFragment) _Collections.firstOrNull((List) lazyJavaPackageFragmentProvider.getPackageFragments(fqNameParent));
        if (lazyJavaPackageFragment == null) {
            return null;
        }
        return lazyJavaPackageFragment.findClassifierByJavaClass$descriptors_jvm(gVar);
    }
}
