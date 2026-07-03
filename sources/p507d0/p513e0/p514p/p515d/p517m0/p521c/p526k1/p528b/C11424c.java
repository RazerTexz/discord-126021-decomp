package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.AbstractC11425d;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11566b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p592z.C12209a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.c */
/* JADX INFO: compiled from: ReflectJavaAnnotation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11424c extends AbstractC11435n implements InterfaceC11564a {

    /* JADX INFO: renamed from: a */
    public final Annotation f23038a;

    public C11424c(Annotation annotation) {
        C12238m.checkNotNullParameter(annotation, "annotation");
        this.f23038a = annotation;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C11424c) && C12238m.areEqual(this.f23038a, ((C11424c) obj).f23038a);
    }

    public final Annotation getAnnotation() {
        return this.f23038a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a
    public Collection<InterfaceC11566b> getArguments() throws IllegalAccessException, InvocationTargetException {
        Method[] declaredMethods = C12209a.getJavaClass(C12209a.getAnnotationClass(this.f23038a)).getDeclaredMethods();
        C12238m.checkNotNullExpressionValue(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            AbstractC11425d.a aVar = AbstractC11425d.f23039a;
            Object objInvoke = method.invoke(getAnnotation(), new Object[0]);
            C12238m.checkNotNullExpressionValue(objInvoke, "method.invoke(annotation)");
            arrayList.add(aVar.create(objInvoke, C11716e.identifier(method.getName())));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a
    public C11712a getClassId() {
        return C11423b.getClassId(C12209a.getJavaClass(C12209a.getAnnotationClass(this.f23038a)));
    }

    public int hashCode() {
        return this.f23038a.hashCode();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a
    public boolean isFreshlySupportedTypeUseAnnotation() {
        return InterfaceC11564a.a.isFreshlySupportedTypeUseAnnotation(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a
    public boolean isIdeExternalAnnotation() {
        return InterfaceC11564a.a.isIdeExternalAnnotation(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        C1643a.m860k0(C11424c.class, sb, ": ");
        sb.append(this.f23038a);
        return sb.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a
    public C11431j resolve() {
        return new C11431j(C12209a.getJavaClass(C12209a.getAnnotationClass(this.f23038a)));
    }
}
