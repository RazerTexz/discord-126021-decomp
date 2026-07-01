package d0.e0.p.d.m0.k.y;

import d0.e0.p.d.m0.c.e;
import d0.e0.p.d.m0.c.h;
import d0.e0.p.d.m0.e.a.g0.g;
import d0.e0.p.d.m0.e.a.g0.g$a;
import d0.e0.p.d.m0.e.a.i0.f;
import d0.e0.p.d.m0.e.a.k0.c0;
import d0.e0.p.d.m0.k.a0.i;
import d0.t.u;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: JavaDescriptorResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public final f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f3478b;

    public b(f fVar, g gVar) {
        m.checkNotNullParameter(fVar, "packageFragmentProvider");
        m.checkNotNullParameter(gVar, "javaResolverCache");
        this.a = fVar;
        this.f3478b = gVar;
    }

    public final f getPackageFragmentProvider() {
        return this.a;
    }

    public final e resolveClass(d0.e0.p.d.m0.e.a.k0.g gVar) {
        m.checkNotNullParameter(gVar, "javaClass");
        d0.e0.p.d.m0.g.b fqName = gVar.getFqName();
        if (fqName != null && gVar.getLightClassOriginKind() == c0.SOURCE) {
            return ((g$a) this.f3478b).getClassResolvedFromSource(fqName);
        }
        d0.e0.p.d.m0.e.a.k0.g outerClass = gVar.getOuterClass();
        if (outerClass != null) {
            e eVarResolveClass = resolveClass(outerClass);
            i unsubstitutedInnerClassesScope = eVarResolveClass == null ? null : eVarResolveClass.getUnsubstitutedInnerClassesScope();
            h contributedClassifier = unsubstitutedInnerClassesScope == null ? null : unsubstitutedInnerClassesScope.getContributedClassifier(gVar.getName(), d0.e0.p.d.m0.d.b.d.FROM_JAVA_LOADER);
            if (contributedClassifier instanceof e) {
                return (e) contributedClassifier;
            }
            return null;
        }
        if (fqName == null) {
            return null;
        }
        f fVar = this.a;
        d0.e0.p.d.m0.g.b bVarParent = fqName.parent();
        m.checkNotNullExpressionValue(bVarParent, "fqName.parent()");
        d0.e0.p.d.m0.e.a.i0.l.i iVar = (d0.e0.p.d.m0.e.a.i0.l.i) u.firstOrNull((List) fVar.getPackageFragments(bVarParent));
        if (iVar == null) {
            return null;
        }
        return iVar.findClassifierByJavaClass$descriptors_jvm(gVar);
    }
}
