package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.annotation.Annotation;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11565a0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.y */
/* JADX INFO: compiled from: ReflectJavaValueParameter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11446y extends AbstractC11435n implements InterfaceC11565a0 {

    /* JADX INFO: renamed from: a */
    public final AbstractC11444w f23067a;

    /* JADX INFO: renamed from: b */
    public final Annotation[] f23068b;

    /* JADX INFO: renamed from: c */
    public final String f23069c;

    /* JADX INFO: renamed from: d */
    public final boolean f23070d;

    public C11446y(AbstractC11444w abstractC11444w, Annotation[] annotationArr, String str, boolean z2) {
        C12238m.checkNotNullParameter(abstractC11444w, "type");
        C12238m.checkNotNullParameter(annotationArr, "reflectAnnotations");
        this.f23067a = abstractC11444w;
        this.f23068b = annotationArr;
        this.f23069c = str;
        this.f23070d = z2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11565a0
    public C11716e getName() {
        String str = this.f23069c;
        if (str == null) {
            return null;
        }
        return C11716e.guessByFirstCharacter(str);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11565a0
    public boolean isVararg() {
        return this.f23070d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(C11446y.class.getName());
        sb.append(": ");
        sb.append(isVararg() ? "vararg " : "");
        sb.append(getName());
        sb.append(": ");
        sb.append(getType());
        return sb.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public C11424c findAnnotation(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        return C11428g.findAnnotation(this.f23068b, c11713b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public List<C11424c> getAnnotations() {
        return C11428g.getAnnotations(this.f23068b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11565a0
    public AbstractC11444w getType() {
        return this.f23067a;
    }
}
