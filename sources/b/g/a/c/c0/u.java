package b.g.a.c.c0;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: CollectorBase.java */
/* JADX INFO: loaded from: classes3.dex */
public class u {
    public static final p[] a = new p[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Annotation[] f694b = new Annotation[0];
    public final b.g.a.c.b c;

    public u(b.g.a.c.b bVar) {
        this.c = bVar;
    }

    public static p[] a(int i) {
        if (i == 0) {
            return a;
        }
        p[] pVarArr = new p[i];
        for (int i2 = 0; i2 < i; i2++) {
            pVarArr[i2] = new p();
        }
        return pVarArr;
    }

    public final o b(o oVar, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            oVar = oVar.a(annotation);
            if (this.c.b0(annotation)) {
                oVar = e(oVar, annotation);
            }
        }
        return oVar;
    }

    public final o c(Annotation[] annotationArr) {
        o oVarA = o$a.c;
        for (Annotation annotation : annotationArr) {
            oVarA = oVarA.a(annotation);
            if (this.c.b0(annotation)) {
                oVarA = e(oVarA, annotation);
            }
        }
        return oVarA;
    }

    public final o d(o oVar, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            if (!oVar.d(annotation)) {
                oVar = oVar.a(annotation);
                if (this.c.b0(annotation)) {
                    for (Annotation annotation2 : b.g.a.c.i0.d.i(annotation.annotationType())) {
                        if (!((annotation2 instanceof Target) || (annotation2 instanceof Retention)) && !oVar.d(annotation2)) {
                            oVar = oVar.a(annotation2);
                            if (this.c.b0(annotation2)) {
                                oVar = e(oVar, annotation2);
                            }
                        }
                    }
                }
            }
        }
        return oVar;
    }

    public final o e(o oVar, Annotation annotation) {
        for (Annotation annotation2 : b.g.a.c.i0.d.i(annotation.annotationType())) {
            if (!((annotation2 instanceof Target) || (annotation2 instanceof Retention))) {
                if (!this.c.b0(annotation2)) {
                    oVar = oVar.a(annotation2);
                } else if (!oVar.d(annotation2)) {
                    oVar = e(oVar.a(annotation2), annotation2);
                }
            }
        }
        return oVar;
    }
}
