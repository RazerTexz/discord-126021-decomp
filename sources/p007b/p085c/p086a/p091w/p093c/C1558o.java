package p007b.p085c.p086a.p091w.p093c;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import p007b.p085c.p086a.InterfaceC1516o;
import p007b.p085c.p086a.p090c0.C1501a;
import p007b.p085c.p086a.p090c0.C1503c;
import p007b.p085c.p086a.p090c0.C1504d;
import p007b.p085c.p086a.p091w.p093c.AbstractC1544a;
import p007b.p085c.p086a.p095y.p096k.C1573b;
import p007b.p085c.p086a.p095y.p096k.C1575d;
import p007b.p085c.p086a.p095y.p096k.C1576e;
import p007b.p085c.p086a.p095y.p096k.C1578g;
import p007b.p085c.p086a.p095y.p096k.C1583l;
import p007b.p085c.p086a.p095y.p096k.InterfaceC1584m;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;

/* JADX INFO: renamed from: b.c.a.w.c.o */
/* JADX INFO: compiled from: TransformKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class C1558o {

    /* JADX INFO: renamed from: a */
    public final Matrix f2627a = new Matrix();

    /* JADX INFO: renamed from: b */
    public final Matrix f2628b;

    /* JADX INFO: renamed from: c */
    public final Matrix f2629c;

    /* JADX INFO: renamed from: d */
    public final Matrix f2630d;

    /* JADX INFO: renamed from: e */
    public final float[] f2631e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public AbstractC1544a<PointF, PointF> f2632f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public AbstractC1544a<?, PointF> f2633g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public AbstractC1544a<C1504d, C1504d> f2634h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public AbstractC1544a<Float, Float> f2635i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public AbstractC1544a<Integer, Integer> f2636j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public C1546c f2637k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public C1546c f2638l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public AbstractC1544a<?, Float> f2639m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public AbstractC1544a<?, Float> f2640n;

    public C1558o(C1583l c1583l) {
        C1576e c1576e = c1583l.f2729a;
        this.f2632f = c1576e == null ? null : c1576e.mo773a();
        InterfaceC1584m<PointF, PointF> interfaceC1584m = c1583l.f2730b;
        this.f2633g = interfaceC1584m == null ? null : interfaceC1584m.mo773a();
        C1578g c1578g = c1583l.f2731c;
        this.f2634h = c1578g == null ? null : c1578g.mo773a();
        C1573b c1573b = c1583l.f2732d;
        this.f2635i = c1573b == null ? null : c1573b.mo773a();
        C1573b c1573b2 = c1583l.f2734f;
        C1546c c1546c = c1573b2 == null ? null : (C1546c) c1573b2.mo773a();
        this.f2637k = c1546c;
        if (c1546c != null) {
            this.f2628b = new Matrix();
            this.f2629c = new Matrix();
            this.f2630d = new Matrix();
            this.f2631e = new float[9];
        } else {
            this.f2628b = null;
            this.f2629c = null;
            this.f2630d = null;
            this.f2631e = null;
        }
        C1573b c1573b3 = c1583l.f2735g;
        this.f2638l = c1573b3 == null ? null : (C1546c) c1573b3.mo773a();
        C1575d c1575d = c1583l.f2733e;
        if (c1575d != null) {
            this.f2636j = c1575d.mo773a();
        }
        C1573b c1573b4 = c1583l.f2736h;
        if (c1573b4 != null) {
            this.f2639m = c1573b4.mo773a();
        } else {
            this.f2639m = null;
        }
        C1573b c1573b5 = c1583l.f2737i;
        if (c1573b5 != null) {
            this.f2640n = c1573b5.mo773a();
        } else {
            this.f2640n = null;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m743a(AbstractC1603b abstractC1603b) {
        abstractC1603b.m777e(this.f2636j);
        abstractC1603b.m777e(this.f2639m);
        abstractC1603b.m777e(this.f2640n);
        abstractC1603b.m777e(this.f2632f);
        abstractC1603b.m777e(this.f2633g);
        abstractC1603b.m777e(this.f2634h);
        abstractC1603b.m777e(this.f2635i);
        abstractC1603b.m777e(this.f2637k);
        abstractC1603b.m777e(this.f2638l);
    }

    /* JADX INFO: renamed from: b */
    public void m744b(AbstractC1544a.b bVar) {
        AbstractC1544a<Integer, Integer> abstractC1544a = this.f2636j;
        if (abstractC1544a != null) {
            abstractC1544a.f2596a.add(bVar);
        }
        AbstractC1544a<?, Float> abstractC1544a2 = this.f2639m;
        if (abstractC1544a2 != null) {
            abstractC1544a2.f2596a.add(bVar);
        }
        AbstractC1544a<?, Float> abstractC1544a3 = this.f2640n;
        if (abstractC1544a3 != null) {
            abstractC1544a3.f2596a.add(bVar);
        }
        AbstractC1544a<PointF, PointF> abstractC1544a4 = this.f2632f;
        if (abstractC1544a4 != null) {
            abstractC1544a4.f2596a.add(bVar);
        }
        AbstractC1544a<?, PointF> abstractC1544a5 = this.f2633g;
        if (abstractC1544a5 != null) {
            abstractC1544a5.f2596a.add(bVar);
        }
        AbstractC1544a<C1504d, C1504d> abstractC1544a6 = this.f2634h;
        if (abstractC1544a6 != null) {
            abstractC1544a6.f2596a.add(bVar);
        }
        AbstractC1544a<Float, Float> abstractC1544a7 = this.f2635i;
        if (abstractC1544a7 != null) {
            abstractC1544a7.f2596a.add(bVar);
        }
        C1546c c1546c = this.f2637k;
        if (c1546c != null) {
            c1546c.f2596a.add(bVar);
        }
        C1546c c1546c2 = this.f2638l;
        if (c1546c2 != null) {
            c1546c2.f2596a.add(bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: c */
    public <T> boolean m745c(T t, @Nullable C1503c<T> c1503c) {
        C1546c c1546c;
        C1546c c1546c2;
        AbstractC1544a<?, Float> abstractC1544a;
        AbstractC1544a<?, Float> abstractC1544a2;
        if (t == InterfaceC1516o.f2427e) {
            AbstractC1544a<PointF, PointF> abstractC1544a3 = this.f2632f;
            if (abstractC1544a3 == null) {
                this.f2632f = new C1559p(c1503c, new PointF());
                return true;
            }
            C1503c<PointF> c1503c2 = abstractC1544a3.f2600e;
            abstractC1544a3.f2600e = c1503c;
            return true;
        }
        if (t == InterfaceC1516o.f2428f) {
            AbstractC1544a<?, PointF> abstractC1544a4 = this.f2633g;
            if (abstractC1544a4 == null) {
                this.f2633g = new C1559p(c1503c, new PointF());
                return true;
            }
            C1503c<PointF> c1503c3 = abstractC1544a4.f2600e;
            abstractC1544a4.f2600e = c1503c;
            return true;
        }
        if (t == InterfaceC1516o.f2433k) {
            AbstractC1544a<C1504d, C1504d> abstractC1544a5 = this.f2634h;
            if (abstractC1544a5 == null) {
                this.f2634h = new C1559p(c1503c, new C1504d());
                return true;
            }
            C1503c<C1504d> c1503c4 = abstractC1544a5.f2600e;
            abstractC1544a5.f2600e = c1503c;
            return true;
        }
        if (t == InterfaceC1516o.f2434l) {
            AbstractC1544a<Float, Float> abstractC1544a6 = this.f2635i;
            if (abstractC1544a6 == null) {
                this.f2635i = new C1559p(c1503c, Float.valueOf(0.0f));
                return true;
            }
            C1503c<Float> c1503c5 = abstractC1544a6.f2600e;
            abstractC1544a6.f2600e = c1503c;
            return true;
        }
        if (t == InterfaceC1516o.f2425c) {
            AbstractC1544a<Integer, Integer> abstractC1544a7 = this.f2636j;
            if (abstractC1544a7 == null) {
                this.f2636j = new C1559p(c1503c, 100);
                return true;
            }
            C1503c<Integer> c1503c6 = abstractC1544a7.f2600e;
            abstractC1544a7.f2600e = c1503c;
            return true;
        }
        if (t == InterfaceC1516o.f2447y && (abstractC1544a2 = this.f2639m) != null) {
            if (abstractC1544a2 == null) {
                this.f2639m = new C1559p(c1503c, 100);
                return true;
            }
            C1503c<Float> c1503c7 = abstractC1544a2.f2600e;
            abstractC1544a2.f2600e = c1503c;
            return true;
        }
        if (t == InterfaceC1516o.f2448z && (abstractC1544a = this.f2640n) != null) {
            if (abstractC1544a == null) {
                this.f2640n = new C1559p(c1503c, 100);
                return true;
            }
            C1503c<Float> c1503c8 = abstractC1544a.f2600e;
            abstractC1544a.f2600e = c1503c;
            return true;
        }
        if (t == InterfaceC1516o.f2435m && (c1546c2 = this.f2637k) != null) {
            if (c1546c2 == null) {
                this.f2637k = new C1546c(Collections.singletonList(new C1501a(Float.valueOf(0.0f))));
            }
            C1546c c1546c3 = this.f2637k;
            Object obj = c1546c3.f2600e;
            c1546c3.f2600e = c1503c;
            return true;
        }
        if (t != InterfaceC1516o.f2436n || (c1546c = this.f2638l) == null) {
            return false;
        }
        if (c1546c == null) {
            this.f2638l = new C1546c(Collections.singletonList(new C1501a(Float.valueOf(0.0f))));
        }
        C1546c c1546c4 = this.f2638l;
        Object obj2 = c1546c4.f2600e;
        c1546c4.f2600e = c1503c;
        return true;
    }

    /* JADX INFO: renamed from: d */
    public final void m746d() {
        for (int i = 0; i < 9; i++) {
            this.f2631e[i] = 0.0f;
        }
    }

    /* JADX INFO: renamed from: e */
    public Matrix m747e() {
        this.f2627a.reset();
        AbstractC1544a<?, PointF> abstractC1544a = this.f2633g;
        if (abstractC1544a != null) {
            PointF pointFMo727e = abstractC1544a.mo727e();
            float f = pointFMo727e.x;
            if (f != 0.0f || pointFMo727e.y != 0.0f) {
                this.f2627a.preTranslate(f, pointFMo727e.y);
            }
        }
        AbstractC1544a<Float, Float> abstractC1544a2 = this.f2635i;
        if (abstractC1544a2 != null) {
            float fFloatValue = abstractC1544a2 instanceof C1559p ? abstractC1544a2.mo727e().floatValue() : ((C1546c) abstractC1544a2).m739j();
            if (fFloatValue != 0.0f) {
                this.f2627a.preRotate(fFloatValue);
            }
        }
        if (this.f2637k != null) {
            C1546c c1546c = this.f2638l;
            float fCos = c1546c == null ? 0.0f : (float) Math.cos(Math.toRadians((-c1546c.m739j()) + 90.0f));
            C1546c c1546c2 = this.f2638l;
            float fSin = c1546c2 == null ? 1.0f : (float) Math.sin(Math.toRadians((-c1546c2.m739j()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(this.f2637k.m739j()));
            m746d();
            float[] fArr = this.f2631e;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f2 = -fSin;
            fArr[3] = f2;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.f2628b.setValues(fArr);
            m746d();
            float[] fArr2 = this.f2631e;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f2629c.setValues(fArr2);
            m746d();
            float[] fArr3 = this.f2631e;
            fArr3[0] = fCos;
            fArr3[1] = f2;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.f2630d.setValues(fArr3);
            this.f2629c.preConcat(this.f2628b);
            this.f2630d.preConcat(this.f2629c);
            this.f2627a.preConcat(this.f2630d);
        }
        AbstractC1544a<C1504d, C1504d> abstractC1544a3 = this.f2634h;
        if (abstractC1544a3 != null) {
            C1504d c1504dMo727e = abstractC1544a3.mo727e();
            float f3 = c1504dMo727e.f2334a;
            if (f3 != 1.0f || c1504dMo727e.f2335b != 1.0f) {
                this.f2627a.preScale(f3, c1504dMo727e.f2335b);
            }
        }
        AbstractC1544a<PointF, PointF> abstractC1544a4 = this.f2632f;
        if (abstractC1544a4 != null) {
            PointF pointFMo727e2 = abstractC1544a4.mo727e();
            float f4 = pointFMo727e2.x;
            if (f4 != 0.0f || pointFMo727e2.y != 0.0f) {
                this.f2627a.preTranslate(-f4, -pointFMo727e2.y);
            }
        }
        return this.f2627a;
    }

    /* JADX INFO: renamed from: f */
    public Matrix m748f(float f) {
        AbstractC1544a<?, PointF> abstractC1544a = this.f2633g;
        PointF pointFMo727e = abstractC1544a == null ? null : abstractC1544a.mo727e();
        AbstractC1544a<C1504d, C1504d> abstractC1544a2 = this.f2634h;
        C1504d c1504dMo727e = abstractC1544a2 == null ? null : abstractC1544a2.mo727e();
        this.f2627a.reset();
        if (pointFMo727e != null) {
            this.f2627a.preTranslate(pointFMo727e.x * f, pointFMo727e.y * f);
        }
        if (c1504dMo727e != null) {
            double d = f;
            this.f2627a.preScale((float) Math.pow(c1504dMo727e.f2334a, d), (float) Math.pow(c1504dMo727e.f2335b, d));
        }
        AbstractC1544a<Float, Float> abstractC1544a3 = this.f2635i;
        if (abstractC1544a3 != null) {
            float fFloatValue = abstractC1544a3.mo727e().floatValue();
            AbstractC1544a<PointF, PointF> abstractC1544a4 = this.f2632f;
            PointF pointFMo727e2 = abstractC1544a4 != null ? abstractC1544a4.mo727e() : null;
            this.f2627a.preRotate(fFloatValue * f, pointFMo727e2 == null ? 0.0f : pointFMo727e2.x, pointFMo727e2 != null ? pointFMo727e2.y : 0.0f);
        }
        return this.f2627a;
    }
}
