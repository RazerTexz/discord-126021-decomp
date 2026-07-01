package b.c.a.w.b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: EllipseContent.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements m, b.c.a.w.c.a$b, k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f379b;
    public final b.c.a.j c;
    public final b.c.a.w.c.a<?, PointF> d;
    public final b.c.a.w.c.a<?, PointF> e;
    public final b.c.a.y.l.a f;
    public boolean h;
    public final Path a = new Path();
    public b g = new b();

    public f(b.c.a.j jVar, b.c.a.y.m.b bVar, b.c.a.y.l.a aVar) {
        this.f379b = aVar.a;
        this.c = jVar;
        b.c.a.w.c.a<PointF, PointF> aVarA = aVar.c.a();
        this.d = aVarA;
        b.c.a.w.c.a<PointF, PointF> aVarA2 = aVar.f415b.a();
        this.e = aVarA2;
        this.f = aVar;
        bVar.e(aVarA);
        bVar.e(aVarA2);
        aVarA.a.add(this);
        aVarA2.a.add(this);
    }

    @Override // b.c.a.w.c.a$b
    public void a() {
        this.h = false;
        this.c.invalidateSelf();
    }

    @Override // b.c.a.w.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i = 0; i < list.size(); i++) {
            c cVar = list.get(i);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.c == 1) {
                    this.g.a.add(sVar);
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
        if (t == b.c.a.o.g) {
            b.c.a.w.c.a<?, PointF> aVar = this.d;
            b.c.a.c0.c<PointF> cVar2 = aVar.e;
            aVar.e = cVar;
        } else if (t == b.c.a.o.j) {
            b.c.a.w.c.a<?, PointF> aVar2 = this.e;
            b.c.a.c0.c<PointF> cVar3 = aVar2.e;
            aVar2.e = cVar;
        }
    }

    @Override // b.c.a.w.b.c
    public String getName() {
        return this.f379b;
    }

    @Override // b.c.a.w.b.m
    public Path getPath() {
        if (this.h) {
            return this.a;
        }
        this.a.reset();
        if (this.f.e) {
            this.h = true;
            return this.a;
        }
        PointF pointFE = this.d.e();
        float f = pointFE.x / 2.0f;
        float f2 = pointFE.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.a.reset();
        if (this.f.d) {
            float f5 = -f2;
            this.a.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.a.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.a.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.a.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.a.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.a.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.a.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.a.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.a.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.a.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointFE2 = this.e.e();
        this.a.offset(pointFE2.x, pointFE2.y);
        this.a.close();
        this.g.a(this.a);
        this.h = true;
        return this.a;
    }
}
