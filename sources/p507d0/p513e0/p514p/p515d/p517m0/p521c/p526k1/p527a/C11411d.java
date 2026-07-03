package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.C11431j;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.C11442u;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.InterfaceC11625s;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11588u;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.d */
/* JADX INFO: compiled from: ReflectJavaClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11411d implements InterfaceC11625s {

    /* JADX INFO: renamed from: a */
    public final ClassLoader f23014a;

    public C11411d(ClassLoader classLoader) {
        C12238m.checkNotNullParameter(classLoader, "classLoader");
        this.f23014a = classLoader;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.InterfaceC11625s
    public InterfaceC11574g findClass(InterfaceC11625s.a aVar) {
        C12238m.checkNotNullParameter(aVar, "request");
        C11712a classId = aVar.getClassId();
        C11713b packageFqName = classId.getPackageFqName();
        C12238m.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
        String strAsString = classId.getRelativeClassName().asString();
        C12238m.checkNotNullExpressionValue(strAsString, "classId.relativeClassName.asString()");
        String strReplace$default = C12103t.replace$default(strAsString, '.', '$', false, 4, (Object) null);
        if (!packageFqName.isRoot()) {
            strReplace$default = packageFqName.asString() + '.' + strReplace$default;
        }
        Class<?> clsTryLoadClass = C11412e.tryLoadClass(this.f23014a, strReplace$default);
        if (clsTryLoadClass != null) {
            return new C11431j(clsTryLoadClass);
        }
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.InterfaceC11625s
    public InterfaceC11588u findPackage(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        return new C11442u(c11713b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.InterfaceC11625s
    public Set<String> knownClassNamesInPackage(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "packageFqName");
        return null;
    }
}
