package b.c.a.w.c;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;

/* JADX INFO: compiled from: TransformKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class o {
    public final Matrix a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f396b;
    public final Matrix c;
    public final Matrix d;
    public final float[] e;

    @NonNull
    public a<PointF, PointF> f;

    @NonNull
    public a<?, PointF> g;

    @NonNull
    public a<b.c.a.c0.d, b.c.a.c0.d> h;

    @NonNull
    public a<Float, Float> i;

    @NonNull
    public a<Integer, Integer> j;

    @Nullable
    public c k;

    @Nullable
    public c l;

    @Nullable
    public a<?, Float> m;

    @Nullable
    public a<?, Float> n;

    public o(b.c.a.y.k.l lVar) {
        b.c.a.y.k.e eVar = lVar.a;
        this.f = eVar == null ? null : eVar.a();
        b.c.a.y.k.m<PointF, PointF> mVar = lVar.f414b;
        this.g = mVar == null ? null : mVar.a();
        b.c.a.y.k.g gVar = lVar.c;
        this.h = gVar == null ? null : gVar.a();
        b.c.a.y.k.b bVar = lVar.d;
        this.i = bVar == null ? null : bVar.a();
        b.c.a.y.k.b bVar2 = lVar.f;
        c cVar = bVar2 == null ? null : (c) bVar2.a();
        this.k = cVar;
        if (cVar != null) {
            this.f396b = new Matrix();
            this.c = new Matrix();
            this.d = new Matrix();
            this.e = new float[9];
        } else {
            this.f396b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }
        b.c.a.y.k.b bVar3 = lVar.g;
        this.l = bVar3 == null ? null : (c) bVar3.a();
        b.c.a.y.k.d dVar = lVar.e;
        if (dVar != null) {
            this.j = dVar.a();
        }
        b.c.a.y.k.b bVar4 = lVar.h;
        if (bVar4 != null) {
            this.m = bVar4.a();
        } else {
            this.m = null;
        }
        b.c.a.y.k.b bVar5 = lVar.i;
        if (bVar5 != null) {
            this.n = bVar5.a();
        } else {
            this.n = null;
        }
    }

    public void a(b.c.a.y.m.b bVar) {
        bVar.e(this.j);
        bVar.e(this.m);
        bVar.e(this.n);
        bVar.e(this.f);
        bVar.e(this.g);
        bVar.e(this.h);
        bVar.e(this.i);
        bVar.e(this.k);
        bVar.e(this.l);
    }

    public void b(a$b a_b) {
        a<Integer, Integer> aVar = this.j;
        if (aVar != null) {
            aVar.a.add(a_b);
        }
        a<?, Float> aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.a.add(a_b);
        }
        a<?, Float> aVar3 = this.n;
        if (aVar3 != null) {
            aVar3.a.add(a_b);
        }
        a<PointF, PointF> aVar4 = this.f;
        if (aVar4 != null) {
            aVar4.a.add(a_b);
        }
        a<?, PointF> aVar5 = this.g;
        if (aVar5 != null) {
            aVar5.a.add(a_b);
        }
        a<b.c.a.c0.d, b.c.a.c0.d> aVar6 = this.h;
        if (aVar6 != null) {
            aVar6.a.add(a_b);
        }
        a<Float, Float> aVar7 = this.i;
        if (aVar7 != null) {
            aVar7.a.add(a_b);
        }
        c cVar = this.k;
        if (cVar != null) {
            cVar.a.add(a_b);
        }
        c cVar2 = this.l;
        if (cVar2 != null) {
            cVar2.a.add(a_b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> boolean c(T t, @Nullable b.c.a.c0.c<T> cVar) {
        c cVar2;
        c cVar3;
        a<?, Float> aVar;
        a<?, Float> aVar2;
        if (t == b.c.a.o.e) {
            a<PointF, PointF> aVar3 = this.f;
            if (aVar3 == null) {
                this.f = new p(cVar, new PointF());
                return true;
            }
            b.c.a.c0.c<PointF> cVar4 = aVar3.e;
            aVar3.e = cVar;
            return true;
        }
        if (t == b.c.a.o.f) {
            a<?, PointF> aVar4 = this.g;
            if (aVar4 == null) {
                this.g = new p(cVar, new PointF());
                return true;
            }
            b.c.a.c0.c<PointF> cVar5 = aVar4.e;
            aVar4.e = cVar;
            return true;
        }
        if (t == b.c.a.o.k) {
            a<b.c.a.c0.d, b.c.a.c0.d> aVar5 = this.h;
            if (aVar5 == null) {
                this.h = new p(cVar, new b.c.a.c0.d());
                return true;
            }
            b.c.a.c0.c<b.c.a.c0.d> cVar6 = aVar5.e;
            aVar5.e = cVar;
            return true;
        }
        if (t == b.c.a.o.l) {
            a<Float, Float> aVar6 = this.i;
            if (aVar6 == null) {
                this.i = new p(cVar, Float.valueOf(0.0f));
                return true;
            }
            b.c.a.c0.c<Float> cVar7 = aVar6.e;
            aVar6.e = cVar;
            return true;
        }
        if (t == b.c.a.o.c) {
            a<Integer, Integer> aVar7 = this.j;
            if (aVar7 == null) {
                this.j = new p(cVar, 100);
                return true;
            }
            b.c.a.c0.c<Integer> cVar8 = aVar7.e;
            aVar7.e = cVar;
            return true;
        }
        if (t == b.c.a.o.f371y && (aVar2 = this.m) != null) {
            if (aVar2 == null) {
                this.m = new p(cVar, 100);
                return true;
            }
            b.c.a.c0.c<Float> cVar9 = aVar2.e;
            aVar2.e = cVar;
            return true;
        }
        if (t == b.c.a.o.f372z && (aVar = this.n) != null) {
            if (aVar == null) {
                this.n = new p(cVar, 100);
                return true;
            }
            b.c.a.c0.c<Float> cVar10 = aVar.e;
            aVar.e = cVar;
            return true;
        }
        if (t == b.c.a.o.m && (cVar3 = this.k) != null) {
            if (cVar3 == null) {
                this.k = new c(Collections.singletonList(new b.c.a.c0.a(Float.valueOf(0.0f))));
            }
            c cVar11 = this.k;
            Object obj = cVar11.e;
            cVar11.e = cVar;
            return true;
        }
        if (t != b.c.a.o.n || (cVar2 = this.l) == null) {
            return false;
        }
        if (cVar2 == null) {
            this.l = new c(Collections.singletonList(new b.c.a.c0.a(Float.valueOf(0.0f))));
        }
        c cVar12 = this.l;
        Object obj2 = cVar12.e;
        cVar12.e = cVar;
        return true;
    }

    public final void d() {
        for (int i = 0; i < 9; i++) {
            this.e[i] = 0.0f;
        }
    }

    public Matrix e() {
        this.a.reset();
        a<?, PointF> aVar = this.g;
        if (aVar != null) {
            PointF pointFE = aVar.e();
            float f = pointFE.x;
            if (f != 0.0f || pointFE.y != 0.0f) {
                this.a.preTranslate(f, pointFE.y);
            }
        }
        a<Float, Float> aVar2 = this.i;
        if (aVar2 != null) {
            float fFloatValue = aVar2 instanceof p ? aVar2.e().floatValue() : ((c) aVar2).j();
            if (fFloatValue != 0.0f) {
                this.a.preRotate(fFloatValue);
            }
        }
        if (this.k != null) {
            c cVar = this.l;
            float fCos = cVar == null ? 0.0f : (float) Math.cos(Math.toRadians((-cVar.j()) + 90.0f));
            c cVar2 = this.l;
            float fSin = cVar2 == null ? 1.0f : (float) Math.sin(Math.toRadians((-cVar2.j()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(this.k.j()));
            d();
            float[] fArr = this.e;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f2 = -fSin;
            fArr[3] = f2;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.f396b.setValues(fArr);
            d();
            float[] fArr2 = this.e;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.c.setValues(fArr2);
            d();
            float[] fArr3 = this.e;
            fArr3[0] = fCos;
            fArr3[1] = f2;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.d.setValues(fArr3);
            this.c.preConcat(this.f396b);
            this.d.preConcat(this.c);
            this.a.preConcat(this.d);
        }
        a<b.c.a.c0.d, b.c.a.c0.d> aVar3 = this.h;
        if (aVar3 != null) {
            b.c.a.c0.d dVarE = aVar3.e();
            float f3 = dVarE.a;
            if (f3 != 1.0f || dVarE.f350b != 1.0f) {
                this.a.preScale(f3, dVarE.f350b);
            }
        }
        a<PointF, PointF> aVar4 = this.f;
        if (aVar4 != null) {
            PointF pointFE2 = aVar4.e();
            float f4 = pointFE2.x;
            if (f4 != 0.0f || pointFE2.y != 0.0f) {
                this.a.preTranslate(-f4, -pointFE2.y);
            }
        }
        return this.a;
    }

    public Matrix f(float f) {
        a<?, PointF> aVar = this.g;
        PointF pointFE = aVar == null ? null : aVar.e();
        a<b.c.a.c0.d, b.c.a.c0.d> aVar2 = this.h;
        b.c.a.c0.d dVarE = aVar2 == null ? null : aVar2.e();
        this.a.reset();
        if (pointFE != null) {
            this.a.preTranslate(pointFE.x * f, pointFE.y * f);
        }
        if (dVarE != null) {
            double d = f;
            this.a.preScale((float) Math.pow(dVarE.a, d), (float) Math.pow(dVarE.f350b, d));
        }
        a<Float, Float> aVar3 = this.i;
        if (aVar3 != null) {
            float fFloatValue = aVar3.e().floatValue();
            a<PointF, PointF> aVar4 = this.f;
            PointF pointFE2 = aVar4 != null ? aVar4.e() : null;
            this.a.preRotate(fFloatValue * f, pointFE2 == null ? 0.0f : pointFE2.x, pointFE2 != null ? pointFE2.y : 0.0f);
        }
        return this.a;
    }
}
