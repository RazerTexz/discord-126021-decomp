package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.c.f1;
import d0.e0.p.d.m0.e.a.k0.a0;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: ReflectJavaMember.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r extends n implements f, t, d0.e0.p.d.m0.e.a.k0.q {
    public final List<a0> a(Type[] typeArr, Annotation[][] annotationArr, boolean z2) {
        String str;
        d0.z.d.m.checkNotNullParameter(typeArr, "parameterTypes");
        d0.z.d.m.checkNotNullParameter(annotationArr, "parameterAnnotations");
        ArrayList arrayList = new ArrayList(typeArr.length);
        List<String> listLoadParameterNames = a.a.loadParameterNames(getMember());
        Integer numValueOf = listLoadParameterNames == null ? null : Integer.valueOf(listLoadParameterNames.size());
        int iIntValue = numValueOf == null ? 0 : numValueOf.intValue() - typeArr.length;
        int length = typeArr.length - 1;
        if (length >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                w wVarCreate = w.a.create(typeArr[i]);
                if (listLoadParameterNames == null) {
                    str = null;
                } else {
                    str = (String) d0.t.u.getOrNull(listLoadParameterNames, i + iIntValue);
                    if (str == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("No parameter with index ");
                        sb.append(i);
                        sb.append('+');
                        sb.append(iIntValue);
                        sb.append(" (name=");
                        sb.append(getName());
                        sb.append(" type=");
                        sb.append(wVarCreate);
                        sb.append(") in ");
                        throw new IllegalStateException(b.d.b.a.a.L(sb, listLoadParameterNames, "@ReflectJavaMember").toString());
                    }
                }
                arrayList.add(new y(wVarCreate, annotationArr[i], str, z2 && i == d0.t.k.getLastIndex(typeArr)));
                if (i2 <= length) {
                    i = i2;
                }
            }
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && d0.z.d.m.areEqual(getMember(), ((r) obj).getMember());
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public c findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        return f$a.findAnnotation(this, bVar);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.q
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.e.a.k0.g getContainingClass() {
        return getContainingClass();
    }

    @Override // d0.e0.p.d.m0.c.k1.b.f
    public AnnotatedElement getElement() {
        return (AnnotatedElement) getMember();
    }

    public abstract Member getMember();

    @Override // d0.e0.p.d.m0.c.k1.b.t
    public int getModifiers() {
        return getMember().getModifiers();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.t
    public d0.e0.p.d.m0.g.e getName() {
        String name = getMember().getName();
        d0.e0.p.d.m0.g.e eVarIdentifier = name == null ? null : d0.e0.p.d.m0.g.e.identifier(name);
        if (eVarIdentifier != null) {
            return eVarIdentifier;
        }
        d0.e0.p.d.m0.g.e eVar = d0.e0.p.d.m0.g.g.a;
        d0.z.d.m.checkNotNullExpressionValue(eVar, "NO_NAME_PROVIDED");
        return eVar;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.s
    public f1 getVisibility() {
        return t$a.getVisibility(this);
    }

    public int hashCode() {
        return getMember().hashCode();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.s
    public boolean isAbstract() {
        return t$a.isAbstract(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public boolean isDeprecatedInJavaDoc() {
        return f$a.isDeprecatedInJavaDoc(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.s
    public boolean isFinal() {
        return t$a.isFinal(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.s
    public boolean isStatic() {
        return t$a.isStatic(this);
    }

    public String toString() {
        return getClass().getName() + ": " + getMember();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.e.a.k0.a findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        return findAnnotation(bVar);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public List<c> getAnnotations() {
        return f$a.getAnnotations(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.q
    public j getContainingClass() {
        Class<?> declaringClass = getMember().getDeclaringClass();
        d0.z.d.m.checkNotNullExpressionValue(declaringClass, "member.declaringClass");
        return new j(declaringClass);
    }
}
