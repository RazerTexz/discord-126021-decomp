package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11335f1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.InterfaceC11427f;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.InterfaceC11441t;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11565a0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11584q;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11718g;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.r */
/* JADX INFO: compiled from: ReflectJavaMember.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11439r extends AbstractC11435n implements InterfaceC11427f, InterfaceC11441t, InterfaceC11584q {
    /* JADX INFO: renamed from: a */
    public final List<InterfaceC11565a0> m9436a(Type[] typeArr, Annotation[][] annotationArr, boolean z2) throws IllegalAccessException, InvocationTargetException {
        String str;
        C12238m.checkNotNullParameter(typeArr, "parameterTypes");
        C12238m.checkNotNullParameter(annotationArr, "parameterAnnotations");
        ArrayList arrayList = new ArrayList(typeArr.length);
        List<String> listLoadParameterNames = C11422a.f23028a.loadParameterNames(getMember());
        Integer numValueOf = listLoadParameterNames == null ? null : Integer.valueOf(listLoadParameterNames.size());
        int iIntValue = numValueOf == null ? 0 : numValueOf.intValue() - typeArr.length;
        int length = typeArr.length - 1;
        if (length >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                AbstractC11444w abstractC11444wCreate = AbstractC11444w.f23065a.create(typeArr[i]);
                if (listLoadParameterNames == null) {
                    str = null;
                } else {
                    str = (String) C12163u.getOrNull(listLoadParameterNames, i + iIntValue);
                    if (str == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("No parameter with index ");
                        sb.append(i);
                        sb.append('+');
                        sb.append(iIntValue);
                        sb.append(" (name=");
                        sb.append(getName());
                        sb.append(" type=");
                        sb.append(abstractC11444wCreate);
                        sb.append(") in ");
                        throw new IllegalStateException(C1643a.m824L(sb, listLoadParameterNames, "@ReflectJavaMember").toString());
                    }
                }
                arrayList.add(new C11446y(abstractC11444wCreate, annotationArr[i], str, z2 && i == C12141k.getLastIndex(typeArr)));
                if (i2 <= length) {
                    i = i2;
                }
            }
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof AbstractC11439r) && C12238m.areEqual(getMember(), ((AbstractC11439r) obj).getMember());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public C11424c findAnnotation(C11713b c11713b) {
        return InterfaceC11427f.a.findAnnotation(this, c11713b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.InterfaceC11427f
    public AnnotatedElement getElement() {
        return (AnnotatedElement) getMember();
    }

    public abstract Member getMember();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.InterfaceC11441t
    public int getModifiers() {
        return getMember().getModifiers();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11587t
    public C11716e getName() {
        String name = getMember().getName();
        C11716e c11716eIdentifier = name == null ? null : C11716e.identifier(name);
        if (c11716eIdentifier != null) {
            return c11716eIdentifier;
        }
        C11716e c11716e = C11718g.f24092a;
        C12238m.checkNotNullExpressionValue(c11716e, "NO_NAME_PROVIDED");
        return c11716e;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11586s
    public AbstractC11335f1 getVisibility() {
        return InterfaceC11441t.a.getVisibility(this);
    }

    public int hashCode() {
        return getMember().hashCode();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11586s
    public boolean isAbstract() {
        return InterfaceC11441t.a.isAbstract(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public boolean isDeprecatedInJavaDoc() {
        return InterfaceC11427f.a.isDeprecatedInJavaDoc(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11586s
    public boolean isFinal() {
        return InterfaceC11441t.a.isFinal(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11586s
    public boolean isStatic() {
        return InterfaceC11441t.a.isStatic(this);
    }

    public String toString() {
        return getClass().getName() + ": " + getMember();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public List<C11424c> getAnnotations() {
        return InterfaceC11427f.a.getAnnotations(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11584q
    public C11431j getContainingClass() {
        Class<?> declaringClass = getMember().getDeclaringClass();
        C12238m.checkNotNullExpressionValue(declaringClass, "member.declaringClass");
        return new C11431j(declaringClass);
    }
}
