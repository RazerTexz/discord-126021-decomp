package b.g.a.c.c0;

import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.c0.AnnotationCollector;
import b.g.a.c.i0.ClassUtil;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/* JADX INFO: renamed from: b.g.a.c.c0.u, reason: use source file name */
/* JADX INFO: compiled from: CollectorBase.java */
/* JADX INFO: loaded from: classes3.dex */
public class CollectorBase {
    public static final AnnotationMap[] a = new AnnotationMap[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Annotation[] f694b = new Annotation[0];
    public final AnnotationIntrospector c;

    public CollectorBase(AnnotationIntrospector annotationIntrospector) {
        this.c = annotationIntrospector;
    }

    public static AnnotationMap[] a(int i) {
        if (i == 0) {
            return a;
        }
        AnnotationMap[] annotationMapArr = new AnnotationMap[i];
        for (int i2 = 0; i2 < i; i2++) {
            annotationMapArr[i2] = new AnnotationMap();
        }
        return annotationMapArr;
    }

    public final AnnotationCollector b(AnnotationCollector annotationCollector, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            annotationCollector = annotationCollector.a(annotation);
            if (this.c.b0(annotation)) {
                annotationCollector = e(annotationCollector, annotation);
            }
        }
        return annotationCollector;
    }

    public final AnnotationCollector c(Annotation[] annotationArr) {
        AnnotationCollector annotationCollectorA = AnnotationCollector.a.c;
        for (Annotation annotation : annotationArr) {
            annotationCollectorA = annotationCollectorA.a(annotation);
            if (this.c.b0(annotation)) {
                annotationCollectorA = e(annotationCollectorA, annotation);
            }
        }
        return annotationCollectorA;
    }

    public final AnnotationCollector d(AnnotationCollector annotationCollector, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            if (!annotationCollector.d(annotation)) {
                annotationCollector = annotationCollector.a(annotation);
                if (this.c.b0(annotation)) {
                    for (Annotation annotation2 : ClassUtil.i(annotation.annotationType())) {
                        if (!((annotation2 instanceof Target) || (annotation2 instanceof Retention)) && !annotationCollector.d(annotation2)) {
                            annotationCollector = annotationCollector.a(annotation2);
                            if (this.c.b0(annotation2)) {
                                annotationCollector = e(annotationCollector, annotation2);
                            }
                        }
                    }
                }
            }
        }
        return annotationCollector;
    }

    public final AnnotationCollector e(AnnotationCollector annotationCollector, Annotation annotation) {
        for (Annotation annotation2 : ClassUtil.i(annotation.annotationType())) {
            if (!((annotation2 instanceof Target) || (annotation2 instanceof Retention))) {
                if (!this.c.b0(annotation2)) {
                    annotationCollector = annotationCollector.a(annotation2);
                } else if (!annotationCollector.d(annotation2)) {
                    annotationCollector = e(annotationCollector.a(annotation2), annotation2);
                }
            }
        }
        return annotationCollector;
    }
}
