package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11588u;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.u */
/* JADX INFO: compiled from: ReflectJavaPackage.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11442u extends AbstractC11435n implements InterfaceC11588u {

    /* JADX INFO: renamed from: a */
    public final C11713b f23062a;

    public C11442u(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        this.f23062a = c11713b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C11442u) && C12238m.areEqual(getFqName(), ((C11442u) obj).getFqName());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public InterfaceC11564a findAnnotation(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11588u
    public Collection<InterfaceC11574g> getClasses(Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(function1, "nameFilter");
        return C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11588u
    public C11713b getFqName() {
        return this.f23062a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11588u
    public Collection<InterfaceC11588u> getSubPackages() {
        return C12147n.emptyList();
    }

    public int hashCode() {
        return getFqName().hashCode();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public String toString() {
        return C11442u.class.getName() + ": " + getFqName();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public List<InterfaceC11564a> getAnnotations() {
        return C12147n.emptyList();
    }
}
