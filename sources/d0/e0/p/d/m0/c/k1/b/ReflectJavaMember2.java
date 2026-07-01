package d0.e0.p.d.m0.c.k1.b;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.Visibility2;
import d0.e0.p.d.m0.c.k1.b.ReflectJavaAnnotationOwner;
import d0.e0.p.d.m0.c.k1.b.ReflectJavaModifierListOwner;
import d0.e0.p.d.m0.e.a.k0.a0;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.g.SpecialNames;
import d0.t._Arrays;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.r, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaMember.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ReflectJavaMember2 extends ReflectJavaElement implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, d0.e0.p.d.m0.e.a.k0.q {
    public final List<a0> a(Type[] typeArr, Annotation[][] annotationArr, boolean z2) throws IllegalAccessException, InvocationTargetException {
        String str;
        Intrinsics3.checkNotNullParameter(typeArr, "parameterTypes");
        Intrinsics3.checkNotNullParameter(annotationArr, "parameterAnnotations");
        ArrayList arrayList = new ArrayList(typeArr.length);
        List<String> listLoadParameterNames = ReflectJavaMember.a.loadParameterNames(getMember());
        Integer numValueOf = listLoadParameterNames == null ? null : Integer.valueOf(listLoadParameterNames.size());
        int iIntValue = numValueOf == null ? 0 : numValueOf.intValue() - typeArr.length;
        int length = typeArr.length - 1;
        if (length >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                ReflectJavaType reflectJavaTypeCreate = ReflectJavaType.a.create(typeArr[i]);
                if (listLoadParameterNames == null) {
                    str = null;
                } else {
                    str = (String) _Collections.getOrNull(listLoadParameterNames, i + iIntValue);
                    if (str == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("No parameter with index ");
                        sb.append(i);
                        sb.append('+');
                        sb.append(iIntValue);
                        sb.append(" (name=");
                        sb.append(getName());
                        sb.append(" type=");
                        sb.append(reflectJavaTypeCreate);
                        sb.append(") in ");
                        throw new IllegalStateException(outline.L(sb, listLoadParameterNames, "@ReflectJavaMember").toString());
                    }
                }
                arrayList.add(new ReflectJavaValueParameter(reflectJavaTypeCreate, annotationArr[i], str, z2 && i == _Arrays.getLastIndex(typeArr)));
                if (i2 <= length) {
                    i = i2;
                }
            }
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaMember2) && Intrinsics3.areEqual(getMember(), ((ReflectJavaMember2) obj).getMember());
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public ReflectJavaAnnotation findAnnotation(FqName fqName) {
        return ReflectJavaAnnotationOwner.a.findAnnotation(this, fqName);
    }

    @Override // d0.e0.p.d.m0.c.k1.b.ReflectJavaAnnotationOwner
    public AnnotatedElement getElement() {
        return (AnnotatedElement) getMember();
    }

    public abstract Member getMember();

    @Override // d0.e0.p.d.m0.c.k1.b.ReflectJavaModifierListOwner
    public int getModifiers() {
        return getMember().getModifiers();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.t
    public Name getName() {
        String name = getMember().getName();
        Name nameIdentifier = name == null ? null : Name.identifier(name);
        if (nameIdentifier != null) {
            return nameIdentifier;
        }
        Name name2 = SpecialNames.a;
        Intrinsics3.checkNotNullExpressionValue(name2, "NO_NAME_PROVIDED");
        return name2;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.s
    public Visibility2 getVisibility() {
        return ReflectJavaModifierListOwner.a.getVisibility(this);
    }

    public int hashCode() {
        return getMember().hashCode();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.s
    public boolean isAbstract() {
        return ReflectJavaModifierListOwner.a.isAbstract(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.a.isDeprecatedInJavaDoc(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.s
    public boolean isFinal() {
        return ReflectJavaModifierListOwner.a.isFinal(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.s
    public boolean isStatic() {
        return ReflectJavaModifierListOwner.a.isStatic(this);
    }

    public String toString() {
        return getClass().getName() + ": " + getMember();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner.a.getAnnotations(this);
    }

    @Override // d0.e0.p.d.m0.e.a.k0.q
    public ReflectJavaClass getContainingClass() {
        Class<?> declaringClass = getMember().getDeclaringClass();
        Intrinsics3.checkNotNullExpressionValue(declaringClass, "member.declaringClass");
        return new ReflectJavaClass(declaringClass);
    }
}
