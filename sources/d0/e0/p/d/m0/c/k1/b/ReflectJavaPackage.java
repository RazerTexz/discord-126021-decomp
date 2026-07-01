package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.u, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaPackage.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaPackage extends ReflectJavaElement implements d0.e0.p.d.m0.e.a.k0.u {
    public final FqName a;

    public ReflectJavaPackage(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        this.a = fqName;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaPackage) && Intrinsics3.areEqual(getFqName(), ((ReflectJavaPackage) obj).getFqName());
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public d0.e0.p.d.m0.e.a.k0.a findAnnotation(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        return null;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.u
    public Collection<d0.e0.p.d.m0.e.a.k0.g> getClasses(Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        return Collections2.emptyList();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.u
    public FqName getFqName() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.u
    public Collection<d0.e0.p.d.m0.e.a.k0.u> getSubPackages() {
        return Collections2.emptyList();
    }

    public int hashCode() {
        return getFqName().hashCode();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public String toString() {
        return ReflectJavaPackage.class.getName() + ": " + getFqName();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public List<d0.e0.p.d.m0.e.a.k0.a> getAnnotations() {
        return Collections2.emptyList();
    }
}
