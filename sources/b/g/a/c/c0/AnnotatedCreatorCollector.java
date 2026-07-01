package b.g.a.c.c0;

import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.c0.AnnotationCollector;
import b.g.a.c.i0.ClassUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: renamed from: b.g.a.c.c0.f, reason: use source file name */
/* JADX INFO: compiled from: AnnotatedCreatorCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotatedCreatorCollector extends CollectorBase {
    public final TypeResolutionContext d;
    public final boolean e;
    public AnnotatedConstructor f;

    public AnnotatedCreatorCollector(AnnotationIntrospector annotationIntrospector, TypeResolutionContext typeResolutionContext, boolean z2) {
        super(annotationIntrospector);
        this.d = typeResolutionContext;
        this.e = z2;
    }

    public static boolean f(Method method) {
        return Modifier.isStatic(method.getModifiers()) && !method.isSynthetic();
    }

    public final AnnotationMap g(ClassUtil.a aVar, ClassUtil.a aVar2) {
        if (!this.e) {
            return new AnnotationMap();
        }
        Annotation[] declaredAnnotations = aVar.f727b;
        if (declaredAnnotations == null) {
            declaredAnnotations = aVar.a.getDeclaredAnnotations();
            aVar.f727b = declaredAnnotations;
        }
        AnnotationCollector annotationCollectorC = c(declaredAnnotations);
        if (aVar2 != null) {
            Annotation[] declaredAnnotations2 = aVar2.f727b;
            if (declaredAnnotations2 == null) {
                declaredAnnotations2 = aVar2.a.getDeclaredAnnotations();
                aVar2.f727b = declaredAnnotations2;
            }
            annotationCollectorC = b(annotationCollectorC, declaredAnnotations2);
        }
        return annotationCollectorC.b();
    }

    public final AnnotationMap h(AnnotatedElement annotatedElement, AnnotatedElement annotatedElement2) {
        AnnotationCollector annotationCollectorC = c(annotatedElement.getDeclaredAnnotations());
        if (annotatedElement2 != null) {
            annotationCollectorC = b(annotationCollectorC, annotatedElement2.getDeclaredAnnotations());
        }
        return annotationCollectorC.b();
    }

    public final AnnotationMap[] i(Annotation[][] annotationArr, Annotation[][] annotationArr2) {
        if (!this.e) {
            return CollectorBase.a;
        }
        int length = annotationArr.length;
        AnnotationMap[] annotationMapArr = new AnnotationMap[length];
        for (int i = 0; i < length; i++) {
            AnnotationCollector annotationCollectorB = b(AnnotationCollector.a.c, annotationArr[i]);
            if (annotationArr2 != null) {
                annotationCollectorB = b(annotationCollectorB, annotationArr2[i]);
            }
            annotationMapArr[i] = annotationCollectorB.b();
        }
        return annotationMapArr;
    }

    public AnnotatedMethod j(Method method, TypeResolutionContext typeResolutionContext, Method method2) {
        int length = method.getParameterTypes().length;
        if (this.c == null) {
            return new AnnotatedMethod(typeResolutionContext, method, new AnnotationMap(), CollectorBase.a(length));
        }
        if (length == 0) {
            return new AnnotatedMethod(typeResolutionContext, method, h(method, method2), CollectorBase.a);
        }
        return new AnnotatedMethod(typeResolutionContext, method, h(method, method2), i(method.getParameterAnnotations(), method2 == null ? null : method2.getParameterAnnotations()));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007d  */
    public AnnotatedConstructor k(ClassUtil.a aVar, ClassUtil.a aVar2) {
        Annotation[][] annotationArr;
        AnnotationMap[] annotationMapArrI;
        int iA = aVar.a();
        if (this.c == null) {
            return new AnnotatedConstructor(this.d, aVar.a, new AnnotationMap(), CollectorBase.a(iA));
        }
        if (iA == 0) {
            return new AnnotatedConstructor(this.d, aVar.a, g(aVar, aVar2), CollectorBase.a);
        }
        Annotation[][] parameterAnnotations = aVar.c;
        if (parameterAnnotations == null) {
            parameterAnnotations = aVar.a.getParameterAnnotations();
            aVar.c = parameterAnnotations;
        }
        Annotation[][] annotationArr2 = null;
        annotationMapArrI = null;
        AnnotationMap[] annotationMapArrI2 = null;
        if (iA != parameterAnnotations.length) {
            Class<?> declaringClass = aVar.a.getDeclaringClass();
            if (ClassUtil.q(declaringClass) && iA == parameterAnnotations.length + 2) {
                annotationArr = new Annotation[parameterAnnotations.length + 2][];
                System.arraycopy(parameterAnnotations, 0, annotationArr, 2, parameterAnnotations.length);
                annotationMapArrI = i(annotationArr, null);
            } else {
                if (declaringClass.isMemberClass() && iA == parameterAnnotations.length + 1) {
                    annotationArr = new Annotation[parameterAnnotations.length + 1][];
                    System.arraycopy(parameterAnnotations, 0, annotationArr, 1, parameterAnnotations.length);
                    annotationArr[0] = CollectorBase.f694b;
                    annotationMapArrI = i(annotationArr, null);
                }
                if (annotationMapArrI2 == null) {
                    throw new IllegalStateException(String.format("Internal error: constructor for %s has mismatch: %d parameters; %d sets of annotations", aVar.a.getDeclaringClass().getName(), Integer.valueOf(iA), Integer.valueOf(parameterAnnotations.length)));
                }
            }
            annotationMapArrI2 = annotationMapArrI;
            parameterAnnotations = annotationArr;
            if (annotationMapArrI2 == null) {
                throw new IllegalStateException(String.format("Internal error: constructor for %s has mismatch: %d parameters; %d sets of annotations", aVar.a.getDeclaringClass().getName(), Integer.valueOf(iA), Integer.valueOf(parameterAnnotations.length)));
            }
        } else {
            if (aVar2 != null) {
                Annotation[][] parameterAnnotations2 = aVar2.c;
                if (parameterAnnotations2 == null) {
                    parameterAnnotations2 = aVar2.a.getParameterAnnotations();
                    aVar2.c = parameterAnnotations2;
                }
                annotationArr2 = parameterAnnotations2;
            }
            annotationMapArrI2 = i(parameterAnnotations, annotationArr2);
        }
        return new AnnotatedConstructor(this.d, aVar.a, g(aVar, aVar2), annotationMapArrI2);
    }
}
