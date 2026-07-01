package d0.e0.p.d.m0.c.k1.b;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.k1.b.ReflectJavaAnnotationArguments;
import d0.e0.p.d.m0.e.a.k0.a;
import d0.e0.p.d.m0.e.a.k0.annotationArguments;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.Name;
import d0.z.JvmClassMapping;
import d0.z.d.Intrinsics3;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.c, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaAnnotation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaAnnotation extends ReflectJavaElement implements d0.e0.p.d.m0.e.a.k0.a {
    public final Annotation a;

    public ReflectJavaAnnotation(Annotation annotation) {
        Intrinsics3.checkNotNullParameter(annotation, "annotation");
        this.a = annotation;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaAnnotation) && Intrinsics3.areEqual(this.a, ((ReflectJavaAnnotation) obj).a);
    }

    public final Annotation getAnnotation() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.a
    public Collection<annotationArguments> getArguments() throws IllegalAccessException, InvocationTargetException {
        Method[] declaredMethods = JvmClassMapping.getJavaClass(JvmClassMapping.getAnnotationClass(this.a)).getDeclaredMethods();
        Intrinsics3.checkNotNullExpressionValue(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            ReflectJavaAnnotationArguments.a aVar = ReflectJavaAnnotationArguments.a;
            Object objInvoke = method.invoke(getAnnotation(), new Object[0]);
            Intrinsics3.checkNotNullExpressionValue(objInvoke, "method.invoke(annotation)");
            arrayList.add(aVar.create(objInvoke, Name.identifier(method.getName())));
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.a
    public ClassId getClassId() {
        return reflectClassUtil.getClassId(JvmClassMapping.getJavaClass(JvmClassMapping.getAnnotationClass(this.a)));
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.a
    public boolean isFreshlySupportedTypeUseAnnotation() {
        return a.C0385a.isFreshlySupportedTypeUseAnnotation(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.a
    public boolean isIdeExternalAnnotation() {
        return a.C0385a.isIdeExternalAnnotation(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        outline.k0(ReflectJavaAnnotation.class, sb, ": ");
        sb.append(this.a);
        return sb.toString();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.a
    public ReflectJavaClass resolve() {
        return new ReflectJavaClass(JvmClassMapping.getJavaClass(JvmClassMapping.getAnnotationClass(this.a)));
    }
}
