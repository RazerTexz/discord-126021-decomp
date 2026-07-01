package b.c.a.w.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import b.c.a.y.l.h$a;
import java.util.List;

/* JADX INFO: compiled from: PolystarContent.java */
/* JADX INFO: loaded from: classes.dex */
public class n implements m, b.c.a.w.c.a$b, k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f386b;
    public final b.c.a.j c;
    public final h$a d;
    public final boolean e;
    public final b.c.a.w.c.a<?, Float> f;
    public final b.c.a.w.c.a<?, PointF> g;
    public final b.c.a.w.c.a<?, Float> h;

    @Nullable
    public final b.c.a.w.c.a<?, Float> i;
    public final b.c.a.w.c.a<?, Float> j;

    @Nullable
    public final b.c.a.w.c.a<?, Float> k;
    public final b.c.a.w.c.a<?, Float> l;
    public boolean n;
    public final Path a = new Path();
    public b m = new b();

    public n(b.c.a.j jVar, b.c.a.y.m.b bVar, b.c.a.y.l.h hVar) {
        this.c = jVar;
        this.f386b = hVar.a;
        h$a h_a = hVar.f421b;
        this.d = h_a;
        this.e = hVar.j;
        b.c.a.w.c.a<Float, Float> aVarA = hVar.c.a();
        this.f = aVarA;
        b.c.a.w.c.a<PointF, PointF> aVarA2 = hVar.d.a();
        this.g = aVarA2;
        b.c.a.w.c.a<Float, Float> aVarA3 = hVar.e.a();
        this.h = aVarA3;
        b.c.a.w.c.a<Float, Float> aVarA4 = hVar.g.a();
        this.j = aVarA4;
        b.c.a.w.c.a<Float, Float> aVarA5 = hVar.i.a();
        this.l = aVarA5;
        h$a h_a2 = h$a.STAR;
        if (h_a == h_a2) {
            this.i = hVar.f.a();
            this.k = hVar.h.a();
        } else {
            this.i = null;
            this.k = null;
        }
        bVar.e(aVarA);
        bVar.e(aVarA2);
        bVar.e(aVarA3);
        bVar.e(aVarA4);
        bVar.e(aVarA5);
        if (h_a == h_a2) {
            bVar.e(this.i);
            bVar.e(this.k);
        }
        aVarA.a.add(this);
        aVarA2.a.add(this);
        aVarA3.a.add(this);
        aVarA4.a.add(this);
        aVarA5.a.add(this);
        if (h_a == h_a2) {
            this.i.a.add(this);
            this.k.a.add(this);
        }
    }

    @Override // b.c.a.w.c.a$b
    public void a() {
        this.n = false;
        this.c.invalidateSelf();
    }

    @Override // b.c.a.w.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = list.get(i);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.c == 1) {
                    this.m.a.add(sVar);
                    sVar.f391b.add(this);
                }
            }
        }
    }

    @Override // b.c.a.y.g
    public void c(b.c.a.y.f fVar, int i, List<b.c.a.y.f> list, b.c.a.y.f fVar2) {
        b.c.a.b0.f.f(fVar, i, list, fVar2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.y.g
    public <T> void g(T t, @Nullable b.c.a.c0.c<T> cVar) {
        b.c.a.w.c.a<?, Float> aVar;
        b.c.a.w.c.a<?, Float> aVar2;
        if (t == b.c.a.o.f369s) {
            b.c.a.w.c.a<?, Float> aVar3 = this.f;
            b.c.a.c0.c<Float> cVar2 = aVar3.e;
            aVar3.e = cVar;
            return;
        }
        if (t == b.c.a.o.t) {
            b.c.a.w.c.a<?, Float> aVar4 = this.h;
            b.c.a.c0.c<Float> cVar3 = aVar4.e;
            aVar4.e = cVar;
            return;
        }
        if (t == b.c.a.o.j) {
            b.c.a.w.c.a<?, PointF> aVar5 = this.g;
            b.c.a.c0.c<PointF> cVar4 = aVar5.e;
            aVar5.e = cVar;
            return;
        }
        if (t == b.c.a.o.u && (aVar2 = this.i) != null) {
            b.c.a.c0.c<Float> cVar5 = aVar2.e;
            aVar2.e = cVar;
            return;
        }
        if (t == b.c.a.o.v) {
            b.c.a.w.c.a<?, Float> aVar6 = this.j;
            b.c.a.c0.c<Float> cVar6 = aVar6.e;
            aVar6.e = cVar;
        } else if (t == b.c.a.o.w && (aVar = this.k) != null) {
            b.c.a.c0.c<Float> cVar7 = aVar.e;
            aVar.e = cVar;
        } else if (t == b.c.a.o.f370x) {
            b.c.a.w.c.a<?, Float> aVar7 = this.l;
            b.c.a.c0.c<Float> cVar8 = aVar7.e;
            aVar7.e = cVar;
        }
    }

    @Override // b.c.a.w.b.c
    public String getName() {
        return this.f386b;
    }

    @Override // b.c.a.w.b.m
    public Path getPath() {
        float fSin;
        double d;
        float fCos;
        float fA;
        float f;
        float f2;
        if (this.n) {
            return this.a;
        }
        this.a.reset();
        if (this.e) {
            this.n = true;
            return this.a;
        }
        int iOrdinal = this.d.ordinal();
        if (iOrdinal == 0) {
            float fFloatValue = this.f.e().floatValue();
            b.c.a.w.c.a<?, Float> aVar = this.h;
            double radians = Math.toRadians((aVar != null ? aVar.e().floatValue() : 0.0d) - 90.0d);
            double d2 = fFloatValue;
            float f3 = (float) (6.283185307179586d / d2);
            float f4 = f3 / 2.0f;
            float f5 = fFloatValue - ((int) fFloatValue);
            if (f5 != 0.0f) {
                radians += (double) ((1.0f - f5) * f4);
            }
            float fFloatValue2 = this.j.e().floatValue();
            float fFloatValue3 = this.i.e().floatValue();
            b.c.a.w.c.a<?, Float> aVar2 = this.k;
            float fFloatValue4 = aVar2 != null ? aVar2.e().floatValue() / 100.0f : 0.0f;
            b.c.a.w.c.a<?, Float> aVar3 = this.l;
            float fFloatValue5 = aVar3 != null ? aVar3.e().floatValue() / 100.0f : 0.0f;
            if (f5 != 0.0f) {
                fA = b.d.b.a.a.a(fFloatValue2, fFloatValue3, f5, fFloatValue3);
                double d3 = fA;
                fCos = (float) (Math.cos(radians) * d3);
                fSin = (float) (d3 * Math.sin(radians));
                this.a.moveTo(fCos, fSin);
                d = radians + ((double) ((f3 * f5) / 2.0f));
            } else {
                double d4 = fFloatValue2;
                float fCos2 = (float) (Math.cos(radians) * d4);
                fSin = (float) (Math.sin(radians) * d4);
                this.a.moveTo(fCos2, fSin);
                d = radians + ((double) f4);
                fCos = fCos2;
                fA = 0.0f;
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
                float f7 = (fA == 0.0f || d5 != dCeil - 2.0d) ? f4 : (f3 * f5) / 2.0f;
                if (fA == 0.0f || d5 != dCeil - 1.0d) {
                    fA = f6;
                }
                double d6 = fA;
                float fCos3 = (float) (Math.cos(d) * d6);
                float fSin2 = (float) (d6 * Math.sin(d));
                if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                    this.a.lineTo(fCos3, fSin2);
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
                    this.a.cubicTo(fCos - f12, f8 - f13, fCos3 + f15, f + f16, fCos3, f);
                }
                d += (double) f7;
                z2 = !z2;
                i++;
                fCos = fCos3;
                fA = fA;
                f3 = f3;
                fSin = f;
                fFloatValue5 = f2;
            }
            PointF pointFE = this.g.e();
            this.a.offset(pointFE.x, pointFE.y);
            this.a.close();
        } else if (iOrdinal == 1) {
            int iFloor = (int) Math.floor(this.f.e().floatValue());
            b.c.a.w.c.a<?, Float> aVar4 = this.h;
            double radians2 = Math.toRadians((aVar4 != null ? aVar4.e().floatValue() : 0.0d) - 90.0d);
            double d7 = iFloor;
            float fFloatValue6 = this.l.e().floatValue() / 100.0f;
            float fFloatValue7 = this.j.e().floatValue();
            double d8 = fFloatValue7;
            float fCos6 = (float) (Math.cos(radians2) * d8);
            float fSin5 = (float) (Math.sin(radians2) * d8);
            this.a.moveTo(fCos6, fSin5);
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
                    this.a.cubicTo(fCos6 - (fCos8 * f17), fSin5 - (fSin7 * f17), fCos7 + (((float) Math.cos(dAtan5)) * f17), fSin6 + (f17 * ((float) Math.sin(dAtan5))), fCos7, fSin6);
                } else {
                    this.a.lineTo(fCos7, fSin6);
                }
                d10 += d9;
                i2++;
                fSin5 = fSin6;
                fCos6 = fCos7;
                dCeil2 = d11;
                d8 = d8;
                d9 = d9;
            }
            PointF pointFE2 = this.g.e();
            this.a.offset(pointFE2.x, pointFE2.y);
            this.a.close();
        }
        this.a.close();
        this.m.a(this.a);
        this.n = true;
        return this.a;
    }
}
