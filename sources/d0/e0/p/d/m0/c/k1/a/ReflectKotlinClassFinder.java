package d0.e0.p.d.m0.c.k1.a;

import d0.e0.p.d.m0.b.StandardNames;
import d0.e0.p.d.m0.e.b.KotlinClassFinder;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.l.b.d0.BuiltInSerializerProtocol;
import d0.e0.p.d.m0.l.b.d0.BuiltInsResourceLoader;
import d0.z.d.Intrinsics3;
import java.io.InputStream;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.g, reason: use source file name */
/* JADX INFO: compiled from: ReflectKotlinClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectKotlinClassFinder implements KotlinClassFinder {
    public final ClassLoader a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BuiltInsResourceLoader f3285b;

    public ReflectKotlinClassFinder(ClassLoader classLoader) {
        Intrinsics3.checkNotNullParameter(classLoader, "classLoader");
        this.a = classLoader;
        this.f3285b = new BuiltInsResourceLoader();
    }

    public final KotlinClassFinder.a a(String str) {
        ReflectKotlinClass2 reflectKotlinClass2Create;
        Class<?> clsTryLoadClass = ReflectJavaClassFinder2.tryLoadClass(this.a, str);
        if (clsTryLoadClass == null || (reflectKotlinClass2Create = ReflectKotlinClass2.a.create(clsTryLoadClass)) == null) {
            return null;
        }
        return new KotlinClassFinder.a.b(reflectKotlinClass2Create, null, 2, null);
    }

    @Override // d0.e0.p.d.m0.l.b.KotlinMetadataFinder
    public InputStream findBuiltInsData(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "packageFqName");
        if (fqName.startsWith(StandardNames.k)) {
            return this.f3285b.loadResource(BuiltInSerializerProtocol.m.getBuiltInsFilePath(fqName));
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.e.b.KotlinClassFinder
    public KotlinClassFinder.a findKotlinClassOrContent(ClassId classId) {
        Intrinsics3.checkNotNullParameter(classId, "classId");
        return a(ReflectKotlinClassFinder2.access$toRuntimeFqName(classId));
    }

    @Override // d0.e0.p.d.m0.e.b.KotlinClassFinder
    public KotlinClassFinder.a findKotlinClassOrContent(d0.e0.p.d.m0.e.a.k0.g gVar) {
        Intrinsics3.checkNotNullParameter(gVar, "javaClass");
        FqName fqName = gVar.getFqName();
        String strAsString = fqName == null ? null : fqName.asString();
        if (strAsString == null) {
            return null;
        }
        return a(strAsString);
    }
}
