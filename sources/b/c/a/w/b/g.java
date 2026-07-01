package b.c.a.w.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: FillContent.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements e, b.c.a.w.c.a$b, k {
    public final Path a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f380b;
    public final b.c.a.y.m.b c;
    public final String d;
    public final boolean e;
    public final List<m> f;
    public final b.c.a.w.c.a<Integer, Integer> g;
    public final b.c.a.w.c.a<Integer, Integer> h;

    @Nullable
    public b.c.a.w.c.a<ColorFilter, ColorFilter> i;
    public final b.c.a.j j;

    public g(b.c.a.j jVar, b.c.a.y.m.b bVar, b.c.a.y.l.l lVar) {
        Path path = new Path();
        this.a = path;
        this.f380b = new b.c.a.w.a(1);
        this.f = new ArrayList();
        this.c = bVar;
        this.d = lVar.c;
        this.e = lVar.f;
        this.j = jVar;
        if (lVar.d == null || lVar.e == null) {
            this.g = null;
            this.h = null;
            return;
        }
        path.setFillType(lVar.f425b);
        b.c.a.w.c.a<Integer, Integer> aVarA = lVar.d.a();
        this.g = aVarA;
        aVarA.a.add(this);
        bVar.e(aVarA);
        b.c.a.w.c.a<Integer, Integer> aVarA2 = lVar.e.a();
        this.h = aVarA2;
        aVarA2.a.add(this);
        bVar.e(aVarA2);
    }

    @Override // b.c.a.w.c.a$b
    public void a() {
        this.j.invalidateSelf();
    }

    @Override // b.c.a.w.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i = 0; i < list2.size(); i++) {
            c cVar = list2.get(i);
            if (cVar instanceof m) {
                this.f.add((m) cVar);
            }
        }
    }

    @Override // b.c.a.y.g
    public void c(b.c.a.y.f fVar, int i, List<b.c.a.y.f> list, b.c.a.y.f fVar2) {
        b.c.a.b0.f.f(fVar, i, list, fVar2, this);
    }

    @Override // b.c.a.w.b.e
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        this.a.reset();
        for (int i = 0; i < this.f.size(); i++) {
            this.a.addPath(this.f.get(i).getPath(), matrix);
        }
        this.a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // b.c.a.w.b.e
    public void f(Canvas canvas, Matrix matrix, int i) {
        if (this.e) {
            return;
        }
        Paint paint = this.f380b;
        b.c.a.w.c.b bVar = (b.c.a.w.c.b) this.g;
        paint.setColor(bVar.j(bVar.a(), bVar.c()));
        this.f380b.setAlpha(b.c.a.b0.f.c((int) ((((i / 255.0f) * this.h.e().intValue()) / 100.0f) * 255.0f), 0, 255));
        b.c.a.w.c.a<ColorFilter, ColorFilter> aVar = this.i;
        if (aVar != null) {
            this.f380b.setColorFilter(aVar.e());
        }
        this.a.reset();
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            this.a.addPath(this.f.get(i2).getPath(), matrix);
        }
        canvas.drawPath(this.a, this.f380b);
        b.c.a.c.a("FillContent#draw");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.y.g
    public <T> void g(T t, @Nullable b.c.a.c0.c<T> cVar) {
        if (t == b.c.a.o.a) {
            b.c.a.w.c.a<Integer, Integer> aVar = this.g;
            b.c.a.c0.c<Integer> cVar2 = aVar.e;
            aVar.e = cVar;
            return;
        }
        if (t == b.c.a.o.d) {
            b.c.a.w.c.a<Integer, Integer> aVar2 = this.h;
            b.c.a.c0.c<Integer> cVar3 = aVar2.e;
            aVar2.e = cVar;
        } else if (t == b.c.a.o.C) {
            b.c.a.w.c.a<ColorFilter, ColorFilter> aVar3 = this.i;
            if (aVar3 != null) {
                this.c.u.remove(aVar3);
            }
            if (cVar == 0) {
                this.i = null;
                return;
            }
            b.c.a.w.c.p pVar = new b.c.a.w.c.p(cVar, null);
            this.i = pVar;
            pVar.a.add(this);
            this.c.e(this.i);
        }
    }

    @Override // b.c.a.w.b.c
    public String getName() {
        return this.d;
    }
}
