package d0.e0.p.d.m0.c.k1.b;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: ReflectJavaTypeParameter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x extends n implements f, d0.e0.p.d.m0.e.a.k0.y {
    public final TypeVariable<?> a;

    public x(TypeVariable<?> typeVariable) {
        d0.z.d.m.checkNotNullParameter(typeVariable, "typeVariable");
        this.a = typeVariable;
    }

    public boolean equals(Object obj) {
        return (obj instanceof x) && d0.z.d.m.areEqual(this.a, ((x) obj).a);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public c findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        return f$a.findAnnotation(this, bVar);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // d0.e0.p.d.m0.c.k1.b.f
    public AnnotatedElement getElement() {
        TypeVariable<?> typeVariable = this.a;
        if (typeVariable instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable;
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.t
    public d0.e0.p.d.m0.g.e getName() {
        d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(this.a.getName());
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "identifier(typeVariable.name)");
        return eVarIdentifier;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.y
    public /* bridge */ /* synthetic */ Collection getUpperBounds() {
        return getUpperBounds();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public boolean isDeprecatedInJavaDoc() {
        return f$a.isDeprecatedInJavaDoc(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        b.d.b.a.a.k0(x.class, sb, ": ");
        sb.append(this.a);
        return sb.toString();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.e.a.k0.a findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        return findAnnotation(bVar);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public List<c> getAnnotations() {
        return f$a.getAnnotations(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.y
    public List<l> getUpperBounds() {
        Type[] bounds = this.a.getBounds();
        d0.z.d.m.checkNotNullExpressionValue(bounds, "typeVariable.bounds");
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type type : bounds) {
            arrayList.add(new l(type));
        }
        l lVar = (l) d0.t.u.singleOrNull((List) arrayList);
        return d0.z.d.m.areEqual(lVar == null ? null : lVar.getReflectType(), Object.class) ? d0.t.n.emptyList() : arrayList;
    }
}
