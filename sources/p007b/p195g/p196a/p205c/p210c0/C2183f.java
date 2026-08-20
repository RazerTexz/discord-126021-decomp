package p007b.p195g.p196a.p205c.p210c0;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.p219i0.C2342d;

/* JADX INFO: renamed from: b.g.a.c.c0.f */
/* JADX INFO: compiled from: AnnotatedCreatorCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2183f extends C2200u {

    /* JADX INFO: renamed from: d */
    public final InterfaceC2182e0 f4705d;

    /* JADX INFO: renamed from: e */
    public final boolean f4706e;

    /* JADX INFO: renamed from: f */
    public C2181e f4707f;

    public C2183f(AbstractC2165b abstractC2165b, InterfaceC2182e0 interfaceC2182e0, boolean z2) {
        super(abstractC2165b);
        this.f4705d = interfaceC2182e0;
        this.f4706e = z2;
    }

    /* JADX INFO: renamed from: f */
    public static boolean m1892f(Method method) {
        return Modifier.isStatic(method.getModifiers()) && !method.isSynthetic();
    }

    /* JADX INFO: renamed from: g */
    public final C2195p m1893g(C2342d.a aVar, C2342d.a aVar2) {
        if (!this.f4706e) {
            return new C2195p();
        }
        Annotation[] declaredAnnotations = aVar.f4948b;
        if (declaredAnnotations == null) {
            declaredAnnotations = aVar.f4947a.getDeclaredAnnotations();
            aVar.f4948b = declaredAnnotations;
        }
        AbstractC2194o abstractC2194oM1925c = m1925c(declaredAnnotations);
        if (aVar2 != null) {
            Annotation[] declaredAnnotations2 = aVar2.f4948b;
            if (declaredAnnotations2 == null) {
                declaredAnnotations2 = aVar2.f4947a.getDeclaredAnnotations();
                aVar2.f4948b = declaredAnnotations2;
            }
            abstractC2194oM1925c = m1924b(abstractC2194oM1925c, declaredAnnotations2);
        }
        return abstractC2194oM1925c.mo1912b();
    }

    /* JADX INFO: renamed from: h */
    public final C2195p m1894h(AnnotatedElement annotatedElement, AnnotatedElement annotatedElement2) {
        AbstractC2194o abstractC2194oM1925c = m1925c(annotatedElement.getDeclaredAnnotations());
        if (annotatedElement2 != null) {
            abstractC2194oM1925c = m1924b(abstractC2194oM1925c, annotatedElement2.getDeclaredAnnotations());
        }
        return abstractC2194oM1925c.mo1912b();
    }

    /* JADX INFO: renamed from: i */
    public final C2195p[] m1895i(Annotation[][] annotationArr, Annotation[][] annotationArr2) {
        if (!this.f4706e) {
            return C2200u.f4748a;
        }
        int length = annotationArr.length;
        C2195p[] c2195pArr = new C2195p[length];
        for (int i = 0; i < length; i++) {
            AbstractC2194o abstractC2194oM1924b = m1924b(AbstractC2194o.a.f4727c, annotationArr[i]);
            if (annotationArr2 != null) {
                abstractC2194oM1924b = m1924b(abstractC2194oM1924b, annotationArr2[i]);
            }
            c2195pArr[i] = abstractC2194oM1924b.mo1912b();
        }
        return c2195pArr;
    }

    /* JADX INFO: renamed from: j */
    public C2189j m1896j(Method method, InterfaceC2182e0 interfaceC2182e0, Method method2) {
        int length = method.getParameterTypes().length;
        if (this.f4750c == null) {
            return new C2189j(interfaceC2182e0, method, new C2195p(), C2200u.m1923a(length));
        }
        if (length == 0) {
            return new C2189j(interfaceC2182e0, method, m1894h(method, method2), C2200u.f4748a);
        }
        return new C2189j(interfaceC2182e0, method, m1894h(method, method2), m1895i(method.getParameterAnnotations(), method2 == null ? null : method2.getParameterAnnotations()));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007d  */
    /* JADX INFO: renamed from: k */
    public C2181e m1897k(C2342d.a aVar, C2342d.a aVar2) {
        Annotation[][] annotationArr;
        C2195p[] c2195pArrM1895i;
        int iM2195a = aVar.m2195a();
        if (this.f4750c == null) {
            return new C2181e(this.f4705d, aVar.f4947a, new C2195p(), C2200u.m1923a(iM2195a));
        }
        if (iM2195a == 0) {
            return new C2181e(this.f4705d, aVar.f4947a, m1893g(aVar, aVar2), C2200u.f4748a);
        }
        Annotation[][] parameterAnnotations = aVar.f4949c;
        if (parameterAnnotations == null) {
            parameterAnnotations = aVar.f4947a.getParameterAnnotations();
            aVar.f4949c = parameterAnnotations;
        }
        Annotation[][] annotationArr2 = null;
        c2195pArrM1895i = null;
        C2195p[] c2195pArrM1895i2 = null;
        if (iM2195a != parameterAnnotations.length) {
            Class<?> declaringClass = aVar.f4947a.getDeclaringClass();
            if (C2342d.m2185q(declaringClass) && iM2195a == parameterAnnotations.length + 2) {
                annotationArr = new Annotation[parameterAnnotations.length + 2][];
                System.arraycopy(parameterAnnotations, 0, annotationArr, 2, parameterAnnotations.length);
                c2195pArrM1895i = m1895i(annotationArr, null);
            } else {
                if (declaringClass.isMemberClass() && iM2195a == parameterAnnotations.length + 1) {
                    annotationArr = new Annotation[parameterAnnotations.length + 1][];
                    System.arraycopy(parameterAnnotations, 0, annotationArr, 1, parameterAnnotations.length);
                    annotationArr[0] = C2200u.f4749b;
                    c2195pArrM1895i = m1895i(annotationArr, null);
                }
                if (c2195pArrM1895i2 == null) {
                    throw new IllegalStateException(String.format("Internal error: constructor for %s has mismatch: %d parameters; %d sets of annotations", aVar.f4947a.getDeclaringClass().getName(), Integer.valueOf(iM2195a), Integer.valueOf(parameterAnnotations.length)));
                }
            }
            c2195pArrM1895i2 = c2195pArrM1895i;
            parameterAnnotations = annotationArr;
            if (c2195pArrM1895i2 == null) {
                throw new IllegalStateException(String.format("Internal error: constructor for %s has mismatch: %d parameters; %d sets of annotations", aVar.f4947a.getDeclaringClass().getName(), Integer.valueOf(iM2195a), Integer.valueOf(parameterAnnotations.length)));
            }
        } else {
            if (aVar2 != null) {
                Annotation[][] parameterAnnotations2 = aVar2.f4949c;
                if (parameterAnnotations2 == null) {
                    parameterAnnotations2 = aVar2.f4947a.getParameterAnnotations();
                    aVar2.f4949c = parameterAnnotations2;
                }
                annotationArr2 = parameterAnnotations2;
            }
            c2195pArrM1895i2 = m1895i(parameterAnnotations, annotationArr2);
        }
        return new C2181e(this.f4705d, aVar.f4947a, m1893g(aVar, aVar2), c2195pArrM1895i2);
    }
}
