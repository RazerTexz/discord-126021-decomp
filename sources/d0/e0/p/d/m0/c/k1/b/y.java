package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.e.a.k0.a0;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: ReflectJavaValueParameter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y extends n implements a0 {
    public final w a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Annotation[] f3296b;
    public final String c;
    public final boolean d;

    public y(w wVar, Annotation[] annotationArr, String str, boolean z2) {
        d0.z.d.m.checkNotNullParameter(wVar, "type");
        d0.z.d.m.checkNotNullParameter(annotationArr, "reflectAnnotations");
        this.a = wVar;
        this.f3296b = annotationArr;
        this.c = str;
        this.d = z2;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.e.a.k0.a findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        return findAnnotation(bVar);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.a0
    public d0.e0.p.d.m0.g.e getName() {
        String str = this.c;
        if (str == null) {
            return null;
        }
        return d0.e0.p.d.m0.g.e.guessByFirstCharacter(str);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.a0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.e.a.k0.x getType() {
        return getType();
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
        sb.append(y.class.getName());
        sb.append(": ");
        sb.append(isVararg() ? "vararg " : "");
        sb.append(getName());
        sb.append(": ");
        sb.append(getType());
        return sb.toString();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public c findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        return g.findAnnotation(this.f3296b, bVar);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public List<c> getAnnotations() {
        return g.getAnnotations(this.f3296b);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.a0
    public w getType() {
        return this.a;
    }
}
