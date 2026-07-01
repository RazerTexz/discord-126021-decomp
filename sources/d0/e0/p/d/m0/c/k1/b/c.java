package d0.e0.p.d.m0.c.k1.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: ReflectJavaAnnotation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends n implements d0.e0.p.d.m0.e.a.k0.a {
    public final Annotation a;

    public c(Annotation annotation) {
        d0.z.d.m.checkNotNullParameter(annotation, "annotation");
        this.a = annotation;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && d0.z.d.m.areEqual(this.a, ((c) obj).a);
    }

    public final Annotation getAnnotation() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.a
    public Collection<d0.e0.p.d.m0.e.a.k0.b> getArguments() throws IllegalAccessException, InvocationTargetException {
        Method[] declaredMethods = d0.z.a.getJavaClass(d0.z.a.getAnnotationClass(this.a)).getDeclaredMethods();
        d0.z.d.m.checkNotNullExpressionValue(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            d$a d_a = d.a;
            Object objInvoke = method.invoke(getAnnotation(), new Object[0]);
            d0.z.d.m.checkNotNullExpressionValue(objInvoke, "method.invoke(annotation)");
            arrayList.add(d_a.create(objInvoke, d0.e0.p.d.m0.g.e.identifier(method.getName())));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.a
    public d0.e0.p.d.m0.g.a getClassId() {
        return b.getClassId(d0.z.a.getJavaClass(d0.z.a.getAnnotationClass(this.a)));
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.a
    public boolean isFreshlySupportedTypeUseAnnotation() {
        return d0.e0.p.d.m0.e.a.k0.a$a.isFreshlySupportedTypeUseAnnotation(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.a
    public boolean isIdeExternalAnnotation() {
        return d0.e0.p.d.m0.e.a.k0.a$a.isIdeExternalAnnotation(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.a
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.e.a.k0.g resolve() {
        return resolve();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        b.d.b.a.a.k0(c.class, sb, ": ");
        sb.append(this.a);
        return sb.toString();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.a
    public j resolve() {
        return new j(d0.z.a.getJavaClass(d0.z.a.getAnnotationClass(this.a)));
    }
}
