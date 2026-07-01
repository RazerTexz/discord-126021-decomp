package d0.e0.p.d.m0.c.k1.b;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.k1.b.ReflectJavaAnnotationOwner;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.x, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaTypeParameter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaTypeParameter extends ReflectJavaElement implements ReflectJavaAnnotationOwner, d0.e0.p.d.m0.e.a.k0.y {
    public final TypeVariable<?> a;

    public ReflectJavaTypeParameter(TypeVariable<?> typeVariable) {
        Intrinsics3.checkNotNullParameter(typeVariable, "typeVariable");
        this.a = typeVariable;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaTypeParameter) && Intrinsics3.areEqual(this.a, ((ReflectJavaTypeParameter) obj).a);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public ReflectJavaAnnotation findAnnotation(FqName fqName) {
        return ReflectJavaAnnotationOwner.a.findAnnotation(this, fqName);
    }

    @Override // d0.e0.p.d.m0.c.k1.b.ReflectJavaAnnotationOwner
    public AnnotatedElement getElement() {
        TypeVariable<?> typeVariable = this.a;
        if (typeVariable instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable;
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.t
    public Name getName() {
        Name nameIdentifier = Name.identifier(this.a.getName());
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(typeVariable.name)");
        return nameIdentifier;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.a.isDeprecatedInJavaDoc(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        outline.k0(ReflectJavaTypeParameter.class, sb, ": ");
        sb.append(this.a);
        return sb.toString();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner.a.getAnnotations(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.y
    public List<ReflectJavaClassifierType> getUpperBounds() {
        Type[] bounds = this.a.getBounds();
        Intrinsics3.checkNotNullExpressionValue(bounds, "typeVariable.bounds");
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type type : bounds) {
            arrayList.add(new ReflectJavaClassifierType(type));
        }
        ReflectJavaClassifierType reflectJavaClassifierType = (ReflectJavaClassifierType) _Collections.singleOrNull((List) arrayList);
        return Intrinsics3.areEqual(reflectJavaClassifierType == null ? null : reflectJavaClassifierType.getReflectType(), Object.class) ? Collections2.emptyList() : arrayList;
    }
}
