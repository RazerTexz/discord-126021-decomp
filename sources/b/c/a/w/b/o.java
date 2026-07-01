package b.c.a.w.b;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: RectangleContent.java */
/* JADX INFO: loaded from: classes.dex */
public class o implements b.c.a.w.c.a$b, k, m {
    public final String c;
    public final boolean d;
    public final b.c.a.j e;
    public final b.c.a.w.c.a<?, PointF> f;
    public final b.c.a.w.c.a<?, PointF> g;
    public final b.c.a.w.c.a<?, Float> h;
    public boolean j;
    public final Path a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f387b = new RectF();
    public b i = new b();

    public o(b.c.a.j jVar, b.c.a.y.m.b bVar, b.c.a.y.l.i iVar) {
        this.c = iVar.a;
        this.d = iVar.e;
        this.e = jVar;
        b.c.a.w.c.a<PointF, PointF> aVarA = iVar.f422b.a();
        this.f = aVarA;
        b.c.a.w.c.a<PointF, PointF> aVarA2 = iVar.c.a();
        this.g = aVarA2;
        b.c.a.w.c.a<Float, Float> aVarA3 = iVar.d.a();
        this.h = aVarA3;
        bVar.e(aVarA);
        bVar.e(aVarA2);
        bVar.e(aVarA3);
        aVarA.a.add(this);
        aVarA2.a.add(this);
        aVarA3.a.add(this);
    }

    @Override // b.c.a.w.c.a$b
    public void a() {
        this.j = false;
        this.e.invalidateSelf();
    }

    @Override // b.c.a.w.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = list.get(i);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.c == 1) {
                    this.i.a.add(sVar);
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
        if (t == b.c.a.o.h) {
            b.c.a.w.c.a<?, PointF> aVar = this.g;
            b.c.a.c0.c<PointF> cVar2 = aVar.e;
            aVar.e = cVar;
        } else if (t == b.c.a.o.j) {
            b.c.a.w.c.a<?, PointF> aVar2 = this.f;
            b.c.a.c0.c<PointF> cVar3 = aVar2.e;
            aVar2.e = cVar;
        } else if (t == b.c.a.o.i) {
            b.c.a.w.c.a<?, Float> aVar3 = this.h;
            b.c.a.c0.c<Float> cVar4 = aVar3.e;
            aVar3.e = cVar;
        }
    }

    @Override // b.c.a.w.b.c
    public String getName() {
        return this.c;
    }

    @Override // b.c.a.w.b.m
    public Path getPath() {
        if (this.j) {
            return this.a;
        }
        this.a.reset();
        if (this.d) {
            this.j = true;
            return this.a;
        }
        PointF pointFE = this.g.e();
        float f = pointFE.x / 2.0f;
        float f2 = pointFE.y / 2.0f;
        b.c.a.w.c.a<?, Float> aVar = this.h;
        float fJ = aVar == null ? 0.0f : ((b.c.a.w.c.c) aVar).j();
        float fMin = Math.min(f, f2);
        if (fJ > fMin) {
            fJ = fMin;
        }
        PointF pointFE2 = this.f.e();
        this.a.moveTo(pointFE2.x + f, (pointFE2.y - f2) + fJ);
        this.a.lineTo(pointFE2.x + f, (pointFE2.y + f2) - fJ);
        if (fJ > 0.0f) {
            RectF rectF = this.f387b;
            float f3 = pointFE2.x;
            float f4 = fJ * 2.0f;
            float f5 = pointFE2.y;
            rectF.set((f3 + f) - f4, (f5 + f2) - f4, f3 + f, f5 + f2);
            this.a.arcTo(this.f387b, 0.0f, 90.0f, false);
        }
        this.a.lineTo((pointFE2.x - f) + fJ, pointFE2.y + f2);
        if (fJ > 0.0f) {
            RectF rectF2 = this.f387b;
            float f6 = pointFE2.x;
            float f7 = pointFE2.y;
            float f8 = fJ * 2.0f;
            rectF2.set(f6 - f, (f7 + f2) - f8, (f6 - f) + f8, f7 + f2);
            this.a.arcTo(this.f387b, 90.0f, 90.0f, false);
        }
        this.a.lineTo(pointFE2.x - f, (pointFE2.y - f2) + fJ);
        if (fJ > 0.0f) {
            RectF rectF3 = this.f387b;
            float f9 = pointFE2.x;
            float f10 = pointFE2.y;
            float f11 = fJ * 2.0f;
            rectF3.set(f9 - f, f10 - f2, (f9 - f) + f11, (f10 - f2) + f11);
            this.a.arcTo(this.f387b, 180.0f, 90.0f, false);
        }
        this.a.lineTo((pointFE2.x + f) - fJ, pointFE2.y - f2);
        if (fJ > 0.0f) {
            RectF rectF4 = this.f387b;
            float f12 = pointFE2.x;
            float f13 = fJ * 2.0f;
            float f14 = pointFE2.y;
            rectF4.set((f12 + f) - f13, f14 - f2, f12 + f, (f14 - f2) + f13);
            this.a.arcTo(this.f387b, 270.0f, 90.0f, false);
        }
        this.a.close();
        this.i.a(this.a);
        this.j = true;
        return this.a;
    }
}
