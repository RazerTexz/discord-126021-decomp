package b.c.a.w.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: StrokeContent.java */
/* JADX INFO: loaded from: classes.dex */
public class r extends a {
    public final b.c.a.y.m.b o;
    public final String p;
    public final boolean q;
    public final b.c.a.w.c.a<Integer, Integer> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public b.c.a.w.c.a<ColorFilter, ColorFilter> f390s;

    public r(b.c.a.j jVar, b.c.a.y.m.b bVar, b.c.a.y.l.o oVar) {
        super(jVar, bVar, b.c.a.y.b.k(oVar.g), b.c.a.y.b.l(oVar.h), oVar.i, oVar.e, oVar.f, oVar.c, oVar.f428b);
        this.o = bVar;
        this.p = oVar.a;
        this.q = oVar.j;
        b.c.a.w.c.a<Integer, Integer> aVarA = oVar.d.a();
        this.r = aVarA;
        aVarA.a.add(this);
        bVar.e(aVarA);
    }

    @Override // b.c.a.w.b.a, b.c.a.w.b.e
    public void f(Canvas canvas, Matrix matrix, int i) {
        if (this.q) {
            return;
        }
        Paint paint = this.i;
        b.c.a.w.c.b bVar = (b.c.a.w.c.b) this.r;
        paint.setColor(bVar.j(bVar.a(), bVar.c()));
        b.c.a.w.c.a<ColorFilter, ColorFilter> aVar = this.f390s;
        if (aVar != null) {
            this.i.setColorFilter(aVar.e());
        }
        super.f(canvas, matrix, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.w.b.a, b.c.a.y.g
    public <T> void g(T t, @Nullable b.c.a.c0.c<T> cVar) {
        super.g(t, cVar);
        if (t == b.c.a.o.f368b) {
            b.c.a.w.c.a<Integer, Integer> aVar = this.r;
            b.c.a.c0.c<Integer> cVar2 = aVar.e;
            aVar.e = cVar;
        } else if (t == b.c.a.o.C) {
            b.c.a.w.c.a<ColorFilter, ColorFilter> aVar2 = this.f390s;
            if (aVar2 != null) {
                this.o.u.remove(aVar2);
            }
            if (cVar == 0) {
                this.f390s = null;
                return;
            }
            b.c.a.w.c.p pVar = new b.c.a.w.c.p(cVar, null);
            this.f390s = pVar;
            pVar.a.add(this);
            this.o.e(this.r);
        }
    }

    @Override // b.c.a.w.b.c
    public String getName() {
        return this.p;
    }
}
