package p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.EnumC11482d;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.InterfaceC11504g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.C11528f;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.C11542i;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.EnumC11569c0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.y.b */
/* JADX INFO: compiled from: JavaDescriptorResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11838b {

    /* JADX INFO: renamed from: a */
    public final C11528f f24461a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC11504g f24462b;

    public C11838b(C11528f c11528f, InterfaceC11504g interfaceC11504g) {
        C12238m.checkNotNullParameter(c11528f, "packageFragmentProvider");
        C12238m.checkNotNullParameter(interfaceC11504g, "javaResolverCache");
        this.f24461a = c11528f;
        this.f24462b = interfaceC11504g;
    }

    public final C11528f getPackageFragmentProvider() {
        return this.f24461a;
    }

    public final InterfaceC11330e resolveClass(InterfaceC11574g interfaceC11574g) {
        C12238m.checkNotNullParameter(interfaceC11574g, "javaClass");
        C11713b fqName = interfaceC11574g.getFqName();
        if (fqName != null && interfaceC11574g.getLightClassOriginKind() == EnumC11569c0.SOURCE) {
            return ((InterfaceC11504g.a) this.f24462b).getClassResolvedFromSource(fqName);
        }
        InterfaceC11574g outerClass = interfaceC11574g.getOuterClass();
        if (outerClass != null) {
            InterfaceC11330e interfaceC11330eResolveClass = resolveClass(outerClass);
            InterfaceC11770i unsubstitutedInnerClassesScope = interfaceC11330eResolveClass == null ? null : interfaceC11330eResolveClass.getUnsubstitutedInnerClassesScope();
            InterfaceC11352h contributedClassifier = unsubstitutedInnerClassesScope == null ? null : unsubstitutedInnerClassesScope.getContributedClassifier(interfaceC11574g.getName(), EnumC11482d.FROM_JAVA_LOADER);
            if (contributedClassifier instanceof InterfaceC11330e) {
                return (InterfaceC11330e) contributedClassifier;
            }
            return null;
        }
        if (fqName == null) {
            return null;
        }
        C11528f c11528f = this.f24461a;
        C11713b c11713bParent = fqName.parent();
        C12238m.checkNotNullExpressionValue(c11713bParent, "fqName.parent()");
        C11542i c11542i = (C11542i) C12163u.firstOrNull((List) c11528f.getPackageFragments(c11713bParent));
        if (c11542i == null) {
            return null;
        }
        return c11542i.findClassifierByJavaClass$descriptors_jvm(interfaceC11574g);
    }
}
