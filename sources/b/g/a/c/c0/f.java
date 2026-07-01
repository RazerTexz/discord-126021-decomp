package b.g.a.c.c0;

import b.g.a.c.i0.d$a;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: compiled from: AnnotatedCreatorCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends u {
    public final e0 d;
    public final boolean e;
    public e f;

    public f(b.g.a.c.b bVar, e0 e0Var, boolean z2) {
        super(bVar);
        this.d = e0Var;
        this.e = z2;
    }

    public static boolean f(Method method) {
        return Modifier.isStatic(method.getModifiers()) && !method.isSynthetic();
    }

    public final p g(d$a d_a, d$a d_a2) {
        if (!this.e) {
            return new p();
        }
        Annotation[] declaredAnnotations = d_a.f727b;
        if (declaredAnnotations == null) {
            declaredAnnotations = d_a.a.getDeclaredAnnotations();
            d_a.f727b = declaredAnnotations;
        }
        o oVarC = c(declaredAnnotations);
        if (d_a2 != null) {
            Annotation[] declaredAnnotations2 = d_a2.f727b;
            if (declaredAnnotations2 == null) {
                declaredAnnotations2 = d_a2.a.getDeclaredAnnotations();
                d_a2.f727b = declaredAnnotations2;
            }
            oVarC = b(oVarC, declaredAnnotations2);
        }
        return oVarC.b();
    }

    public final p h(AnnotatedElement annotatedElement, AnnotatedElement annotatedElement2) {
        o oVarC = c(annotatedElement.getDeclaredAnnotations());
        if (annotatedElement2 != null) {
            oVarC = b(oVarC, annotatedElement2.getDeclaredAnnotations());
        }
        return oVarC.b();
    }

    public final p[] i(Annotation[][] annotationArr, Annotation[][] annotationArr2) {
        if (!this.e) {
            return u.a;
        }
        int length = annotationArr.length;
        p[] pVarArr = new p[length];
        for (int i = 0; i < length; i++) {
            o oVarB = b(o$a.c, annotationArr[i]);
            if (annotationArr2 != null) {
                oVarB = b(oVarB, annotationArr2[i]);
            }
            pVarArr[i] = oVarB.b();
        }
        return pVarArr;
    }

    public j j(Method method, e0 e0Var, Method method2) {
        int length = method.getParameterTypes().length;
        if (this.c == null) {
            return new j(e0Var, method, new p(), u.a(length));
        }
        if (length == 0) {
            return new j(e0Var, method, h(method, method2), u.a);
        }
        return new j(e0Var, method, h(method, method2), i(method.getParameterAnnotations(), method2 == null ? null : method2.getParameterAnnotations()));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007d  */
    public e k(d$a d_a, d$a d_a2) {
        Annotation[][] annotationArr;
        p[] pVarArrI;
        int iA = d_a.a();
        if (this.c == null) {
            return new e(this.d, d_a.a, new p(), u.a(iA));
        }
        if (iA == 0) {
            return new e(this.d, d_a.a, g(d_a, d_a2), u.a);
        }
        Annotation[][] parameterAnnotations = d_a.c;
        if (parameterAnnotations == null) {
            parameterAnnotations = d_a.a.getParameterAnnotations();
            d_a.c = parameterAnnotations;
        }
        Annotation[][] annotationArr2 = null;
        pVarArrI = null;
        p[] pVarArrI2 = null;
        if (iA != parameterAnnotations.length) {
            Class<?> declaringClass = d_a.a.getDeclaringClass();
            if (b.g.a.c.i0.d.q(declaringClass) && iA == parameterAnnotations.length + 2) {
                annotationArr = new Annotation[parameterAnnotations.length + 2][];
                System.arraycopy(parameterAnnotations, 0, annotationArr, 2, parameterAnnotations.length);
                pVarArrI = i(annotationArr, null);
            } else {
                if (declaringClass.isMemberClass() && iA == parameterAnnotations.length + 1) {
                    annotationArr = new Annotation[parameterAnnotations.length + 1][];
                    System.arraycopy(parameterAnnotations, 0, annotationArr, 1, parameterAnnotations.length);
                    annotationArr[0] = u.f694b;
                    pVarArrI = i(annotationArr, null);
                }
                if (pVarArrI2 == null) {
                    throw new IllegalStateException(String.format("Internal error: constructor for %s has mismatch: %d parameters; %d sets of annotations", d_a.a.getDeclaringClass().getName(), Integer.valueOf(iA), Integer.valueOf(parameterAnnotations.length)));
                }
            }
            pVarArrI2 = pVarArrI;
            parameterAnnotations = annotationArr;
            if (pVarArrI2 == null) {
                throw new IllegalStateException(String.format("Internal error: constructor for %s has mismatch: %d parameters; %d sets of annotations", d_a.a.getDeclaringClass().getName(), Integer.valueOf(iA), Integer.valueOf(parameterAnnotations.length)));
            }
        } else {
            if (d_a2 != null) {
                Annotation[][] parameterAnnotations2 = d_a2.c;
                if (parameterAnnotations2 == null) {
                    parameterAnnotations2 = d_a2.a.getParameterAnnotations();
                    d_a2.c = parameterAnnotations2;
                }
                annotationArr2 = parameterAnnotations2;
            }
            pVarArrI2 = i(parameterAnnotations, annotationArr2);
        }
        return new e(this.d, d_a.a, g(d_a, d_a2), pVarArrI2);
    }
}
