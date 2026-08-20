package p007b.p195g.p196a.p205c.p210c0;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import p007b.p195g.p196a.p205c.AbstractC2165b;
import p007b.p195g.p196a.p205c.p219i0.C2342d;

/* JADX INFO: renamed from: b.g.a.c.c0.u */
/* JADX INFO: compiled from: CollectorBase.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2200u {

    /* JADX INFO: renamed from: a */
    public static final C2195p[] f4748a = new C2195p[0];

    /* JADX INFO: renamed from: b */
    public static final Annotation[] f4749b = new Annotation[0];

    /* JADX INFO: renamed from: c */
    public final AbstractC2165b f4750c;

    public C2200u(AbstractC2165b abstractC2165b) {
        this.f4750c = abstractC2165b;
    }

    /* JADX INFO: renamed from: a */
    public static C2195p[] m1923a(int i) {
        if (i == 0) {
            return f4748a;
        }
        C2195p[] c2195pArr = new C2195p[i];
        for (int i2 = 0; i2 < i; i2++) {
            c2195pArr[i2] = new C2195p();
        }
        return c2195pArr;
    }

    /* JADX INFO: renamed from: b */
    public final AbstractC2194o m1924b(AbstractC2194o abstractC2194o, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            abstractC2194o = abstractC2194o.mo1911a(annotation);
            if (this.f4750c.mo1774b0(annotation)) {
                abstractC2194o = m1927e(abstractC2194o, annotation);
            }
        }
        return abstractC2194o;
    }

    /* JADX INFO: renamed from: c */
    public final AbstractC2194o m1925c(Annotation[] annotationArr) {
        AbstractC2194o abstractC2194oMo1911a = AbstractC2194o.a.f4727c;
        for (Annotation annotation : annotationArr) {
            abstractC2194oMo1911a = abstractC2194oMo1911a.mo1911a(annotation);
            if (this.f4750c.mo1774b0(annotation)) {
                abstractC2194oMo1911a = m1927e(abstractC2194oMo1911a, annotation);
            }
        }
        return abstractC2194oMo1911a;
    }

    /* JADX INFO: renamed from: d */
    public final AbstractC2194o m1926d(AbstractC2194o abstractC2194o, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            if (!abstractC2194o.mo1914d(annotation)) {
                abstractC2194o = abstractC2194o.mo1911a(annotation);
                if (this.f4750c.mo1774b0(annotation)) {
                    for (Annotation annotation2 : C2342d.m2177i(annotation.annotationType())) {
                        if (!((annotation2 instanceof Target) || (annotation2 instanceof Retention)) && !abstractC2194o.mo1914d(annotation2)) {
                            abstractC2194o = abstractC2194o.mo1911a(annotation2);
                            if (this.f4750c.mo1774b0(annotation2)) {
                                abstractC2194o = m1927e(abstractC2194o, annotation2);
                            }
                        }
                    }
                }
            }
        }
        return abstractC2194o;
    }

    /* JADX INFO: renamed from: e */
    public final AbstractC2194o m1927e(AbstractC2194o abstractC2194o, Annotation annotation) {
        for (Annotation annotation2 : C2342d.m2177i(annotation.annotationType())) {
            if (!((annotation2 instanceof Target) || (annotation2 instanceof Retention))) {
                if (!this.f4750c.mo1774b0(annotation2)) {
                    abstractC2194o = abstractC2194o.mo1911a(annotation2);
                } else if (!abstractC2194o.mo1914d(annotation2)) {
                    abstractC2194o = m1927e(abstractC2194o.mo1911a(annotation2), annotation2);
                }
            }
        }
        return abstractC2194o;
    }
}
