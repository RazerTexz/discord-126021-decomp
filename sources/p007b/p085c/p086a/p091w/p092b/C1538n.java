package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.util.List;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.InterfaceC1516o;
import p007b.p085c.p086a.p089b0.C1498f;
import p007b.p085c.p086a.p090c0.C1503c;
import p007b.p085c.p086a.p091w.p093c.AbstractC1544a;
import p007b.p085c.p086a.p095y.C1567f;
import p007b.p085c.p086a.p095y.p097l.C1593h;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.w.b.n */
/* JADX INFO: compiled from: PolystarContent.java */
/* JADX INFO: loaded from: classes.dex */
public class C1538n implements InterfaceC1537m, AbstractC1544a.b, InterfaceC1535k {

    /* JADX INFO: renamed from: b */
    public final String f2546b;

    /* JADX INFO: renamed from: c */
    public final C1511j f2547c;

    /* JADX INFO: renamed from: d */
    public final C1593h.a f2548d;

    /* JADX INFO: renamed from: e */
    public final boolean f2549e;

    /* JADX INFO: renamed from: f */
    public final AbstractC1544a<?, Float> f2550f;

    /* JADX INFO: renamed from: g */
    public final AbstractC1544a<?, PointF> f2551g;

    /* JADX INFO: renamed from: h */
    public final AbstractC1544a<?, Float> f2552h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public final AbstractC1544a<?, Float> f2553i;

    /* JADX INFO: renamed from: j */
    public final AbstractC1544a<?, Float> f2554j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public final AbstractC1544a<?, Float> f2555k;

    /* JADX INFO: renamed from: l */
    public final AbstractC1544a<?, Float> f2556l;

    /* JADX INFO: renamed from: n */
    public boolean f2558n;

    /* JADX INFO: renamed from: a */
    public final Path f2545a = new Path();

    /* JADX INFO: renamed from: m */
    public C1526b f2557m = new C1526b();

    public C1538n(C1511j c1511j, AbstractC1603b abstractC1603b, C1593h c1593h) {
        this.f2547c = c1511j;
        this.f2546b = c1593h.f2780a;
        C1593h.a aVar = c1593h.f2781b;
        this.f2548d = aVar;
        this.f2549e = c1593h.f2789j;
        AbstractC1544a<Float, Float> abstractC1544aMo773a = c1593h.f2782c.mo773a();
        this.f2550f = abstractC1544aMo773a;
        AbstractC1544a<PointF, PointF> abstractC1544aMo773a2 = c1593h.f2783d.mo773a();
        this.f2551g = abstractC1544aMo773a2;
        AbstractC1544a<Float, Float> abstractC1544aMo773a3 = c1593h.f2784e.mo773a();
        this.f2552h = abstractC1544aMo773a3;
        AbstractC1544a<Float, Float> abstractC1544aMo773a4 = c1593h.f2786g.mo773a();
        this.f2554j = abstractC1544aMo773a4;
        AbstractC1544a<Float, Float> abstractC1544aMo773a5 = c1593h.f2788i.mo773a();
        this.f2556l = abstractC1544aMo773a5;
        C1593h.a aVar2 = C1593h.a.STAR;
        if (aVar == aVar2) {
            this.f2553i = c1593h.f2785f.mo773a();
            this.f2555k = c1593h.f2787h.mo773a();
        } else {
            this.f2553i = null;
            this.f2555k = null;
        }
        abstractC1603b.m777e(abstractC1544aMo773a);
        abstractC1603b.m777e(abstractC1544aMo773a2);
        abstractC1603b.m777e(abstractC1544aMo773a3);
        abstractC1603b.m777e(abstractC1544aMo773a4);
        abstractC1603b.m777e(abstractC1544aMo773a5);
        if (aVar == aVar2) {
            abstractC1603b.m777e(this.f2553i);
            abstractC1603b.m777e(this.f2555k);
        }
        abstractC1544aMo773a.f2596a.add(this);
        abstractC1544aMo773a2.f2596a.add(this);
        abstractC1544aMo773a3.f2596a.add(this);
        abstractC1544aMo773a4.f2596a.add(this);
        abstractC1544aMo773a5.f2596a.add(this);
        if (aVar == aVar2) {
            this.f2553i.f2596a.add(this);
            this.f2555k.f2596a.add(this);
        }
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.b
    /* JADX INFO: renamed from: a */
    public void mo709a() {
        this.f2558n = false;
        this.f2547c.invalidateSelf();
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    /* JADX INFO: renamed from: b */
    public void mo710b(List<InterfaceC1527c> list, List<InterfaceC1527c> list2) {
        for (int i = 0; i < list.size(); i++) {
            InterfaceC1527c interfaceC1527c = list.get(i);
            if (interfaceC1527c instanceof C1543s) {
                C1543s c1543s = (C1543s) interfaceC1527c;
                if (c1543s.f2592c == 1) {
                    this.f2557m.f2481a.add(c1543s);
                    c1543s.f2591b.add(this);
                }
            }
        }
    }

    @Override // p007b.p085c.p086a.p095y.InterfaceC1568g
    /* JADX INFO: renamed from: c */
    public void mo711c(C1567f c1567f, int i, List<C1567f> list, C1567f c1567f2) {
        C1498f.m656f(c1567f, i, list, c1567f2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p095y.InterfaceC1568g
    /* JADX INFO: renamed from: g */
    public <T> void mo714g(T t, @Nullable C1503c<T> c1503c) {
        AbstractC1544a<?, Float> abstractC1544a;
        AbstractC1544a<?, Float> abstractC1544a2;
        if (t == InterfaceC1516o.f2441s) {
            AbstractC1544a<?, Float> abstractC1544a3 = this.f2550f;
            C1503c<Float> c1503c2 = abstractC1544a3.f2600e;
            abstractC1544a3.f2600e = c1503c;
            return;
        }
        if (t == InterfaceC1516o.f2442t) {
            AbstractC1544a<?, Float> abstractC1544a4 = this.f2552h;
            C1503c<Float> c1503c3 = abstractC1544a4.f2600e;
            abstractC1544a4.f2600e = c1503c;
            return;
        }
        if (t == InterfaceC1516o.f2432j) {
            AbstractC1544a<?, PointF> abstractC1544a5 = this.f2551g;
            C1503c<PointF> c1503c4 = abstractC1544a5.f2600e;
            abstractC1544a5.f2600e = c1503c;
            return;
        }
        if (t == InterfaceC1516o.f2443u && (abstractC1544a2 = this.f2553i) != null) {
            C1503c<Float> c1503c5 = abstractC1544a2.f2600e;
            abstractC1544a2.f2600e = c1503c;
            return;
        }
        if (t == InterfaceC1516o.f2444v) {
            AbstractC1544a<?, Float> abstractC1544a6 = this.f2554j;
            C1503c<Float> c1503c6 = abstractC1544a6.f2600e;
            abstractC1544a6.f2600e = c1503c;
        } else if (t == InterfaceC1516o.f2445w && (abstractC1544a = this.f2555k) != null) {
            C1503c<Float> c1503c7 = abstractC1544a.f2600e;
            abstractC1544a.f2600e = c1503c;
        } else if (t == InterfaceC1516o.f2446x) {
            AbstractC1544a<?, Float> abstractC1544a7 = this.f2556l;
            C1503c<Float> c1503c8 = abstractC1544a7.f2600e;
            abstractC1544a7.f2600e = c1503c;
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    public String getName() {
        return this.f2546b;
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1537m
    public Path getPath() {
        float fSin;
        double d;
        float fCos;
        float fM839a;
        float f;
        float f2;
        if (this.f2558n) {
            return this.f2545a;
        }
        this.f2545a.reset();
        if (this.f2549e) {
            this.f2558n = true;
            return this.f2545a;
        }
        int iOrdinal = this.f2548d.ordinal();
        if (iOrdinal == 0) {
            float fFloatValue = this.f2550f.mo727e().floatValue();
            AbstractC1544a<?, Float> abstractC1544a = this.f2552h;
            double radians = Math.toRadians((abstractC1544a != null ? abstractC1544a.mo727e().floatValue() : 0.0d) - 90.0d);
            double d2 = fFloatValue;
            float f3 = (float) (6.283185307179586d / d2);
            float f4 = f3 / 2.0f;
            float f5 = fFloatValue - ((int) fFloatValue);
            if (f5 != 0.0f) {
                radians += (double) ((1.0f - f5) * f4);
            }
            float fFloatValue2 = this.f2554j.mo727e().floatValue();
            float fFloatValue3 = this.f2553i.mo727e().floatValue();
            AbstractC1544a<?, Float> abstractC1544a2 = this.f2555k;
            float fFloatValue4 = abstractC1544a2 != null ? abstractC1544a2.mo727e().floatValue() / 100.0f : 0.0f;
            AbstractC1544a<?, Float> abstractC1544a3 = this.f2556l;
            float fFloatValue5 = abstractC1544a3 != null ? abstractC1544a3.mo727e().floatValue() / 100.0f : 0.0f;
            if (f5 != 0.0f) {
                fM839a = C1643a.m839a(fFloatValue2, fFloatValue3, f5, fFloatValue3);
                double d3 = fM839a;
                fCos = (float) (Math.cos(radians) * d3);
                fSin = (float) (d3 * Math.sin(radians));
                this.f2545a.moveTo(fCos, fSin);
                d = radians + ((double) ((f3 * f5) / 2.0f));
            } else {
                double d4 = fFloatValue2;
                float fCos2 = (float) (Math.cos(radians) * d4);
                fSin = (float) (Math.sin(radians) * d4);
                this.f2545a.moveTo(fCos2, fSin);
                d = radians + ((double) f4);
                fCos = fCos2;
                fM839a = 0.0f;
            }
            double dCeil = Math.ceil(d2) * 2.0d;
            int i = 0;
            boolean z2 = false;
            while (true) {
                double d5 = i;
                if (d5 >= dCeil) {
                    break;
                }
                float f6 = z2 ? fFloatValue2 : fFloatValue3;
                float f7 = (fM839a == 0.0f || d5 != dCeil - 2.0d) ? f4 : (f3 * f5) / 2.0f;
                if (fM839a == 0.0f || d5 != dCeil - 1.0d) {
                    fM839a = f6;
                }
                double d6 = fM839a;
                float fCos3 = (float) (Math.cos(d) * d6);
                float fSin2 = (float) (d6 * Math.sin(d));
                if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                    this.f2545a.lineTo(fCos3, fSin2);
                    f = fSin2;
                    f2 = fFloatValue5;
                } else {
                    float f8 = fSin;
                    double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                    float fCos4 = (float) Math.cos(dAtan2);
                    float fSin3 = (float) Math.sin(dAtan2);
                    f = fSin2;
                    f2 = fFloatValue5;
                    double dAtan3 = (float) (Math.atan2(fSin2, fCos3) - 1.5707963267948966d);
                    float fCos5 = (float) Math.cos(dAtan3);
                    float fSin4 = (float) Math.sin(dAtan3);
                    float f9 = z2 ? fFloatValue4 : f2;
                    float f10 = z2 ? f2 : fFloatValue4;
                    float f11 = (z2 ? fFloatValue3 : fFloatValue2) * f9 * 0.47829f;
                    float f12 = fCos4 * f11;
                    float f13 = f11 * fSin3;
                    float f14 = (z2 ? fFloatValue2 : fFloatValue3) * f10 * 0.47829f;
                    float f15 = fCos5 * f14;
                    float f16 = f14 * fSin4;
                    if (f5 != 0.0f) {
                        if (i == 0) {
                            f12 *= f5;
                            f13 *= f5;
                        } else if (d5 == dCeil - 1.0d) {
                            f15 *= f5;
                            f16 *= f5;
                        }
                    }
                    this.f2545a.cubicTo(fCos - f12, f8 - f13, fCos3 + f15, f + f16, fCos3, f);
                }
                d += (double) f7;
                z2 = !z2;
                i++;
                fCos = fCos3;
                fM839a = fM839a;
                f3 = f3;
                fSin = f;
                fFloatValue5 = f2;
            }
            PointF pointFMo727e = this.f2551g.mo727e();
            this.f2545a.offset(pointFMo727e.x, pointFMo727e.y);
            this.f2545a.close();
        } else if (iOrdinal == 1) {
            int iFloor = (int) Math.floor(this.f2550f.mo727e().floatValue());
            AbstractC1544a<?, Float> abstractC1544a4 = this.f2552h;
            double radians2 = Math.toRadians((abstractC1544a4 != null ? abstractC1544a4.mo727e().floatValue() : 0.0d) - 90.0d);
            double d7 = iFloor;
            float fFloatValue6 = this.f2556l.mo727e().floatValue() / 100.0f;
            float fFloatValue7 = this.f2554j.mo727e().floatValue();
            double d8 = fFloatValue7;
            float fCos6 = (float) (Math.cos(radians2) * d8);
            float fSin5 = (float) (Math.sin(radians2) * d8);
            this.f2545a.moveTo(fCos6, fSin5);
            double d9 = (float) (6.283185307179586d / d7);
            double d10 = radians2 + d9;
            double dCeil2 = Math.ceil(d7);
            int i2 = 0;
            while (i2 < dCeil2) {
                float fCos7 = (float) (Math.cos(d10) * d8);
                double d11 = dCeil2;
                float fSin6 = (float) (Math.sin(d10) * d8);
                if (fFloatValue6 != 0.0f) {
                    double dAtan4 = (float) (Math.atan2(fSin5, fCos6) - 1.5707963267948966d);
                    float fCos8 = (float) Math.cos(dAtan4);
                    float fSin7 = (float) Math.sin(dAtan4);
                    double dAtan5 = (float) (Math.atan2(fSin6, fCos7) - 1.5707963267948966d);
                    float f17 = fFloatValue7 * fFloatValue6 * 0.25f;
                    this.f2545a.cubicTo(fCos6 - (fCos8 * f17), fSin5 - (fSin7 * f17), fCos7 + (((float) Math.cos(dAtan5)) * f17), fSin6 + (f17 * ((float) Math.sin(dAtan5))), fCos7, fSin6);
                } else {
                    this.f2545a.lineTo(fCos7, fSin6);
                }
                d10 += d9;
                i2++;
                fSin5 = fSin6;
                fCos6 = fCos7;
                dCeil2 = d11;
                d8 = d8;
                d9 = d9;
            }
            PointF pointFMo727e2 = this.f2551g.mo727e();
            this.f2545a.offset(pointFMo727e2.x, pointFMo727e2.y);
            this.f2545a.close();
        }
        this.f2545a.close();
        this.f2557m.m715a(this.f2545a);
        this.f2558n = true;
        return this.f2545a;
    }
}
