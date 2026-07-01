package d0.e0.p.d.m0.c.k1.b;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ReflectJavaPackage.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends n implements d0.e0.p.d.m0.e.a.k0.u {
    public final d0.e0.p.d.m0.g.b a;

    public u(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        this.a = bVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof u) && d0.z.d.m.areEqual(getFqName(), ((u) obj).getFqName());
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public d0.e0.p.d.m0.e.a.k0.a findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        return null;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.u
    public Collection<d0.e0.p.d.m0.e.a.k0.g> getClasses(Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        return d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.u
    public d0.e0.p.d.m0.g.b getFqName() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.u
    public Collection<d0.e0.p.d.m0.e.a.k0.u> getSubPackages() {
        return d0.t.n.emptyList();
    }

    public int hashCode() {
        return getFqName().hashCode();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public String toString() {
        return u.class.getName() + ": " + getFqName();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public List<d0.e0.p.d.m0.e.a.k0.a> getAnnotations() {
        return d0.t.n.emptyList();
    }
}
