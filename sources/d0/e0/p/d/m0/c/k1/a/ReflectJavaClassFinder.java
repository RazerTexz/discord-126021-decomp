package d0.e0.p.d.m0.c.k1.a;

import d0.e0.p.d.m0.c.k1.b.ReflectJavaClass;
import d0.e0.p.d.m0.c.k1.b.ReflectJavaPackage;
import d0.e0.p.d.m0.e.a.JavaClassFinder;
import d0.e0.p.d.m0.e.a.k0.u;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import java.util.Set;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.d, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaClassFinder implements JavaClassFinder {
    public final ClassLoader a;

    public ReflectJavaClassFinder(ClassLoader classLoader) {
        Intrinsics3.checkNotNullParameter(classLoader, "classLoader");
        this.a = classLoader;
    }

    @Override // d0.e0.p.d.m0.e.a.JavaClassFinder
    public d0.e0.p.d.m0.e.a.k0.g findClass(JavaClassFinder.a aVar) {
        Intrinsics3.checkNotNullParameter(aVar, "request");
        ClassId classId = aVar.getClassId();
        FqName packageFqName = classId.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
        String strAsString = classId.getRelativeClassName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "classId.relativeClassName.asString()");
        String strReplace$default = StringsJVM.replace$default(strAsString, '.', '$', false, 4, (Object) null);
        if (!packageFqName.isRoot()) {
            strReplace$default = packageFqName.asString() + '.' + strReplace$default;
        }
        Class<?> clsTryLoadClass = ReflectJavaClassFinder2.tryLoadClass(this.a, strReplace$default);
        if (clsTryLoadClass != null) {
            return new ReflectJavaClass(clsTryLoadClass);
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.e.a.JavaClassFinder
    public u findPackage(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        return new ReflectJavaPackage(fqName);
    }

    @Override // d0.e0.p.d.m0.e.a.JavaClassFinder
    public Set<String> knownClassNamesInPackage(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "packageFqName");
        return null;
    }
}
