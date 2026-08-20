package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11592y;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.x */
/* JADX INFO: compiled from: ReflectJavaTypeParameter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11445x extends AbstractC11435n implements InterfaceC11427f, InterfaceC11592y {

    /* JADX INFO: renamed from: a */
    public final TypeVariable<?> f23066a;

    public C11445x(TypeVariable<?> typeVariable) {
        C12238m.checkNotNullParameter(typeVariable, "typeVariable");
        this.f23066a = typeVariable;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C11445x) && C12238m.areEqual(this.f23066a, ((C11445x) obj).f23066a);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public C11424c findAnnotation(C11713b c11713b) {
        return InterfaceC11427f.a.findAnnotation(this, c11713b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.InterfaceC11427f
    public AnnotatedElement getElement() {
        TypeVariable<?> typeVariable = this.f23066a;
        if (typeVariable instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable;
        }
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11587t
    public C11716e getName() {
        C11716e c11716eIdentifier = C11716e.identifier(this.f23066a.getName());
        C12238m.checkNotNullExpressionValue(c11716eIdentifier, "identifier(typeVariable.name)");
        return c11716eIdentifier;
    }

    public int hashCode() {
        return this.f23066a.hashCode();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public boolean isDeprecatedInJavaDoc() {
        return InterfaceC11427f.a.isDeprecatedInJavaDoc(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        C1643a.m860k0(C11445x.class, sb, ": ");
        sb.append(this.f23066a);
        return sb.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public List<C11424c> getAnnotations() {
        return InterfaceC11427f.a.getAnnotations(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11592y
    public List<C11433l> getUpperBounds() {
        Type[] bounds = this.f23066a.getBounds();
        C12238m.checkNotNullExpressionValue(bounds, "typeVariable.bounds");
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type type : bounds) {
            arrayList.add(new C11433l(type));
        }
        C11433l c11433l = (C11433l) C12163u.singleOrNull((List) arrayList);
        return C12238m.areEqual(c11433l == null ? null : c11433l.getReflectType(), Object.class) ? C12147n.emptyList() : arrayList;
    }
}
