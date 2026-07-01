package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.e.a.k0.a0;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.z.d.Intrinsics3;
import java.lang.annotation.Annotation;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.y, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaValueParameter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaValueParameter extends ReflectJavaElement implements a0 {
    public final ReflectJavaType a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Annotation[] f3296b;
    public final String c;
    public final boolean d;

    public ReflectJavaValueParameter(ReflectJavaType reflectJavaType, Annotation[] annotationArr, String str, boolean z2) {
        Intrinsics3.checkNotNullParameter(reflectJavaType, "type");
        Intrinsics3.checkNotNullParameter(annotationArr, "reflectAnnotations");
        this.a = reflectJavaType;
        this.f3296b = annotationArr;
        this.c = str;
        this.d = z2;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.a0
    public Name getName() {
        String str = this.c;
        if (str == null) {
            return null;
        }
        return Name.guessByFirstCharacter(str);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.a0
    public boolean isVararg() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ReflectJavaValueParameter.class.getName());
        sb.append(": ");
        sb.append(isVararg() ? "vararg " : "");
        sb.append(getName());
        sb.append(": ");
        sb.append(getType());
        return sb.toString();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public ReflectJavaAnnotation findAnnotation(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        return ReflectJavaAnnotationOwner2.findAnnotation(this.f3296b, fqName);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner2.getAnnotations(this.f3296b);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.a0
    public ReflectJavaType getType() {
        return this.a;
    }
}
