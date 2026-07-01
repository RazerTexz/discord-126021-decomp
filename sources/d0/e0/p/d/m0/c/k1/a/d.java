package d0.e0.p.d.m0.c.k1.a;

import d0.e0.p.d.m0.e.a.k0.u;
import d0.e0.p.d.m0.e.a.s;
import d0.e0.p.d.m0.e.a.s$a;
import d0.g0.t;
import java.util.Set;

/* JADX INFO: compiled from: ReflectJavaClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements s {
    public final ClassLoader a;

    public d(ClassLoader classLoader) {
        d0.z.d.m.checkNotNullParameter(classLoader, "classLoader");
        this.a = classLoader;
    }

    @Override // d0.e0.p.d.m0.e.a.s
    public d0.e0.p.d.m0.e.a.k0.g findClass(s$a s_a) {
        d0.z.d.m.checkNotNullParameter(s_a, "request");
        d0.e0.p.d.m0.g.a classId = s_a.getClassId();
        d0.e0.p.d.m0.g.b packageFqName = classId.getPackageFqName();
        d0.z.d.m.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
        String strAsString = classId.getRelativeClassName().asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "classId.relativeClassName.asString()");
        String strReplace$default = t.replace$default(strAsString, '.', '$', false, 4, (Object) null);
        if (!packageFqName.isRoot()) {
            strReplace$default = packageFqName.asString() + '.' + strReplace$default;
        }
        Class<?> clsTryLoadClass = e.tryLoadClass(this.a, strReplace$default);
        if (clsTryLoadClass != null) {
            return new d0.e0.p.d.m0.c.k1.b.j(clsTryLoadClass);
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.e.a.s
    public u findPackage(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        return new d0.e0.p.d.m0.c.k1.b.u(bVar);
    }

    @Override // d0.e0.p.d.m0.e.a.s
    public Set<String> knownClassNamesInPackage(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "packageFqName");
        return null;
    }
}
