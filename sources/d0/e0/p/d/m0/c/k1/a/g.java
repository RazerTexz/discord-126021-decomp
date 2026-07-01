package d0.e0.p.d.m0.c.k1.a;

import d0.e0.p.d.m0.e.b.n$a;
import d0.e0.p.d.m0.e.b.n$a$b;
import java.io.InputStream;

/* JADX INFO: compiled from: ReflectKotlinClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements d0.e0.p.d.m0.e.b.n {
    public final ClassLoader a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.l.b.d0.d f3285b;

    public g(ClassLoader classLoader) {
        d0.z.d.m.checkNotNullParameter(classLoader, "classLoader");
        this.a = classLoader;
        this.f3285b = new d0.e0.p.d.m0.l.b.d0.d();
    }

    public final n$a a(String str) {
        f fVarCreate;
        Class<?> clsTryLoadClass = e.tryLoadClass(this.a, str);
        if (clsTryLoadClass == null || (fVarCreate = f.a.create(clsTryLoadClass)) == null) {
            return null;
        }
        return new n$a$b(fVarCreate, null, 2, null);
    }

    @Override // d0.e0.p.d.m0.l.b.s
    public InputStream findBuiltInsData(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "packageFqName");
        if (bVar.startsWith(d0.e0.p.d.m0.b.k.k)) {
            return this.f3285b.loadResource(d0.e0.p.d.m0.l.b.d0.a.m.getBuiltInsFilePath(bVar));
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.e.b.n
    public n$a findKotlinClassOrContent(d0.e0.p.d.m0.g.a aVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        return a(h.access$toRuntimeFqName(aVar));
    }

    @Override // d0.e0.p.d.m0.e.b.n
    public n$a findKotlinClassOrContent(d0.e0.p.d.m0.e.a.k0.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "javaClass");
        d0.e0.p.d.m0.g.b fqName = gVar.getFqName();
        String strAsString = fqName == null ? null : fqName.asString();
        if (strAsString == null) {
            return null;
        }
        return a(strAsString);
    }
}
