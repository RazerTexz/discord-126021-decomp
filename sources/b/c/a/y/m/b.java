package b.c.a.y.m;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build$VERSION;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import b.c.a.j;
import b.c.a.s;
import b.c.a.s$a;
import b.c.a.w.c.a$b;
import b.c.a.w.c.o;
import b.c.a.y.k.l;
import b.c.a.y.l.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: BaseLayer.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements b.c.a.w.b.e, a$b, b.c.a.y.g {
    public final Path a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f430b = new Matrix();
    public final Paint c = new b.c.a.w.a(1);
    public final Paint d = new b.c.a.w.a(1, PorterDuff$Mode.DST_IN);
    public final Paint e = new b.c.a.w.a(1, PorterDuff$Mode.DST_OUT);
    public final Paint f;
    public final Paint g;
    public final RectF h;
    public final RectF i;
    public final RectF j;
    public final RectF k;
    public final String l;
    public final Matrix m;
    public final j n;
    public final e o;

    @Nullable
    public b.c.a.w.c.g p;

    @Nullable
    public b.c.a.w.c.c q;

    @Nullable
    public b r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public b f431s;
    public List<b> t;
    public final List<b.c.a.w.c.a<?, ?>> u;
    public final o v;
    public boolean w;

    public b(j jVar, e eVar) {
        b.c.a.w.a aVar = new b.c.a.w.a(1);
        this.f = aVar;
        this.g = new b.c.a.w.a(PorterDuff$Mode.CLEAR);
        this.h = new RectF();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new RectF();
        this.m = new Matrix();
        this.u = new ArrayList();
        this.w = true;
        this.n = jVar;
        this.o = eVar;
        this.l = b.d.b.a.a.J(new StringBuilder(), eVar.c, "#draw");
        if (eVar.u == 3) {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff$Mode.DST_OUT));
        } else {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff$Mode.DST_IN));
        }
        l lVar = eVar.i;
        Objects.requireNonNull(lVar);
        o oVar = new o(lVar);
        this.v = oVar;
        oVar.b(this);
        List<b.c.a.y.l.f> list = eVar.h;
        if (list != null && !list.isEmpty()) {
            b.c.a.w.c.g gVar = new b.c.a.w.c.g(eVar.h);
            this.p = gVar;
            Iterator<b.c.a.w.c.a<k, Path>> it = gVar.a.iterator();
            while (it.hasNext()) {
                it.next().a.add(this);
            }
            for (b.c.a.w.c.a<Integer, Integer> aVar2 : this.p.f395b) {
                e(aVar2);
                aVar2.a.add(this);
            }
        }
        if (this.o.t.isEmpty()) {
            p(true);
            return;
        }
        b.c.a.w.c.c cVar = new b.c.a.w.c.c(this.o.t);
        this.q = cVar;
        cVar.f392b = true;
        cVar.a.add(new a(this));
        p(this.q.e().floatValue() == 1.0f);
        e(this.q);
    }

    @Override // b.c.a.w.c.a$b
    public void a() {
        this.n.invalidateSelf();
    }

    @Override // b.c.a.w.b.c
    public void b(List<b.c.a.w.b.c> list, List<b.c.a.w.b.c> list2) {
    }

    @Override // b.c.a.y.g
    public void c(b.c.a.y.f fVar, int i, List<b.c.a.y.f> list, b.c.a.y.f fVar2) {
        if (fVar.e(this.o.c, i)) {
            if (!"__container".equals(this.o.c)) {
                fVar2 = fVar2.a(this.o.c);
                if (fVar.c(this.o.c, i)) {
                    list.add(fVar2.g(this));
                }
            }
            if (fVar.f(this.o.c, i)) {
                n(fVar, fVar.d(this.o.c, i) + i, list, fVar2);
            }
        }
    }

    @Override // b.c.a.w.b.e
    @CallSuper
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        this.h.set(0.0f, 0.0f, 0.0f, 0.0f);
        h();
        this.m.set(matrix);
        if (z2) {
            List<b> list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.m.preConcat(this.t.get(size).v.e());
                }
            } else {
                b bVar = this.f431s;
                if (bVar != null) {
                    this.m.preConcat(bVar.v.e());
                }
            }
        }
        this.m.preConcat(this.v.e());
    }

    public void e(@Nullable b.c.a.w.c.a<?, ?> aVar) {
        if (aVar == null) {
            return;
        }
        this.u.add(aVar);
    }

    /* JADX WARN: Code duplicated, block: B:115:0x017c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x011e  */
    /* JADX WARN: Code duplicated, block: B:45:0x012c  */
    /* JADX WARN: Code duplicated, block: B:46:0x0134  */
    @Override // b.c.a.w.b.e
    public void f(Canvas canvas, Matrix matrix, int i) {
        boolean z2;
        String str = this.l;
        if (!this.w || this.o.v) {
            b.c.a.c.a(str);
            return;
        }
        h();
        this.f430b.reset();
        this.f430b.set(matrix);
        int i2 = 1;
        for (int size = this.t.size() - 1; size >= 0; size--) {
            this.f430b.preConcat(this.t.get(size).v.e());
        }
        b.c.a.c.a("Layer#parentMatrix");
        b.c.a.w.c.a<Integer, Integer> aVar = this.v.j;
        int iIntValue = (int) ((((i / 255.0f) * (aVar == null ? 100 : aVar.e().intValue())) / 100.0f) * 255.0f);
        float f = 0.0f;
        if (!l() && !k()) {
            this.f430b.preConcat(this.v.e());
            j(canvas, this.f430b, iIntValue);
            b.c.a.c.a("Layer#drawLayer");
            b.c.a.c.a(this.l);
            m(0.0f);
            return;
        }
        boolean z3 = false;
        d(this.h, this.f430b, false);
        RectF rectF = this.h;
        int i3 = 3;
        if (l() && this.o.u != 3) {
            this.j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.r.d(this.j, matrix, true);
            if (!rectF.intersect(this.j)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
        this.f430b.preConcat(this.v.e());
        RectF rectF2 = this.h;
        Matrix matrix2 = this.f430b;
        this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i4 = 2;
        if (k()) {
            int size2 = this.p.c.size();
            int i5 = 0;
            while (true) {
                if (i5 < size2) {
                    b.c.a.y.l.f fVar = this.p.c.get(i5);
                    this.a.set(this.p.a.get(i5).e());
                    this.a.transform(matrix2);
                    int iH = b.c.a.y.b.h(fVar.a);
                    if (iH == 0) {
                        if (fVar.d) {
                        }
                        this.a.computeBounds(this.k, z3);
                        if (i5 == 0) {
                            this.i.set(this.k);
                        } else {
                            RectF rectF3 = this.i;
                            rectF3.set(Math.min(rectF3.left, this.k.left), Math.min(this.i.top, this.k.top), Math.max(this.i.right, this.k.right), Math.max(this.i.bottom, this.k.bottom));
                        }
                        i5++;
                        z3 = false;
                        i3 = 3;
                        i4 = 2;
                    } else if (iH != 1) {
                        if (iH != i4) {
                            if (iH == i3) {
                            }
                            this.a.computeBounds(this.k, z3);
                            if (i5 == 0) {
                                this.i.set(this.k);
                            } else {
                                RectF rectF4 = this.i;
                                rectF4.set(Math.min(rectF4.left, this.k.left), Math.min(this.i.top, this.k.top), Math.max(this.i.right, this.k.right), Math.max(this.i.bottom, this.k.bottom));
                            }
                            i5++;
                            z3 = false;
                            i3 = 3;
                            i4 = 2;
                        } else {
                            if (fVar.d) {
                            }
                            this.a.computeBounds(this.k, z3);
                            if (i5 == 0) {
                                this.i.set(this.k);
                            } else {
                                RectF rectF5 = this.i;
                                rectF5.set(Math.min(rectF5.left, this.k.left), Math.min(this.i.top, this.k.top), Math.max(this.i.right, this.k.right), Math.max(this.i.bottom, this.k.bottom));
                            }
                            i5++;
                            z3 = false;
                            i3 = 3;
                            i4 = 2;
                        }
                    }
                } else if (!rectF2.intersect(this.i)) {
                    f = 0.0f;
                    rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
                    break;
                }
                f = 0.0f;
                break;
            }
        }
        if (!this.h.intersect(f, f, canvas.getWidth(), canvas.getHeight())) {
            this.h.set(f, f, f, f);
        }
        b.c.a.c.a("Layer#computeBounds");
        if (!this.h.isEmpty()) {
            this.c.setAlpha(255);
            b.c.a.b0.g.f(canvas, this.h, this.c, 31);
            b.c.a.c.a("Layer#saveLayer");
            i(canvas);
            j(canvas, this.f430b, iIntValue);
            b.c.a.c.a("Layer#drawLayer");
            if (k()) {
                Matrix matrix3 = this.f430b;
                b.c.a.b0.g.f(canvas, this.h, this.d, 19);
                if (Build$VERSION.SDK_INT < 28) {
                    i(canvas);
                }
                b.c.a.c.a("Layer#saveLayer");
                int i6 = 0;
                while (i6 < this.p.c.size()) {
                    b.c.a.y.l.f fVar2 = this.p.c.get(i6);
                    b.c.a.w.c.a<k, Path> aVar2 = this.p.a.get(i6);
                    b.c.a.w.c.a<Integer, Integer> aVar3 = this.p.f395b.get(i6);
                    int iH2 = b.c.a.y.b.h(fVar2.a);
                    if (iH2 != 0) {
                        if (iH2 == i2) {
                            if (i6 == 0) {
                                this.c.setColor(ViewCompat.MEASURED_STATE_MASK);
                                this.c.setAlpha(255);
                                canvas.drawRect(this.h, this.c);
                            }
                            if (fVar2.d) {
                                b.c.a.b0.g.f(canvas, this.h, this.e, 31);
                                canvas.drawRect(this.h, this.c);
                                this.e.setAlpha((int) (aVar3.e().intValue() * 2.55f));
                                this.a.set(aVar2.e());
                                this.a.transform(matrix3);
                                canvas.drawPath(this.a, this.e);
                                canvas.restore();
                            } else {
                                this.a.set(aVar2.e());
                                this.a.transform(matrix3);
                                canvas.drawPath(this.a, this.e);
                            }
                        } else if (iH2 != 2) {
                            if (iH2 == 3) {
                                if (this.p.a.isEmpty()) {
                                    z2 = false;
                                    break;
                                }
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= this.p.c.size()) {
                                        z2 = true;
                                        break;
                                    } else {
                                        if (this.p.c.get(i7).a != 4) {
                                            z2 = false;
                                            break;
                                        }
                                        i7++;
                                    }
                                }
                                if (z2) {
                                    this.c.setAlpha(255);
                                    canvas.drawRect(this.h, this.c);
                                }
                            }
                        } else if (fVar2.d) {
                            b.c.a.b0.g.f(canvas, this.h, this.d, 31);
                            canvas.drawRect(this.h, this.c);
                            this.e.setAlpha((int) (aVar3.e().intValue() * 2.55f));
                            this.a.set(aVar2.e());
                            this.a.transform(matrix3);
                            canvas.drawPath(this.a, this.e);
                            canvas.restore();
                        } else {
                            b.c.a.b0.g.f(canvas, this.h, this.d, 31);
                            this.a.set(aVar2.e());
                            this.a.transform(matrix3);
                            this.c.setAlpha((int) (aVar3.e().intValue() * 2.55f));
                            canvas.drawPath(this.a, this.c);
                            canvas.restore();
                        }
                    } else if (fVar2.d) {
                        b.c.a.b0.g.f(canvas, this.h, this.c, 31);
                        canvas.drawRect(this.h, this.c);
                        this.a.set(aVar2.e());
                        this.a.transform(matrix3);
                        this.c.setAlpha((int) (aVar3.e().intValue() * 2.55f));
                        canvas.drawPath(this.a, this.e);
                        canvas.restore();
                    } else {
                        this.a.set(aVar2.e());
                        this.a.transform(matrix3);
                        this.c.setAlpha((int) (aVar3.e().intValue() * 2.55f));
                        canvas.drawPath(this.a, this.c);
                    }
                    i6++;
                    i2 = 1;
                }
                canvas.restore();
                b.c.a.c.a("Layer#restoreLayer");
            }
            if (l()) {
                b.c.a.b0.g.f(canvas, this.h, this.f, 19);
                b.c.a.c.a("Layer#saveLayer");
                i(canvas);
                this.r.f(canvas, matrix, iIntValue);
                canvas.restore();
                b.c.a.c.a("Layer#restoreLayer");
                b.c.a.c.a("Layer#drawMatte");
            }
            canvas.restore();
            b.c.a.c.a("Layer#restoreLayer");
        }
        b.c.a.c.a(this.l);
        m(0.0f);
    }

    @Override // b.c.a.y.g
    @CallSuper
    public <T> void g(T t, @Nullable b.c.a.c0.c<T> cVar) {
        this.v.c(t, cVar);
    }

    @Override // b.c.a.w.b.c
    public String getName() {
        return this.o.c;
    }

    public final void h() {
        if (this.t != null) {
            return;
        }
        if (this.f431s == null) {
            this.t = Collections.emptyList();
            return;
        }
        this.t = new ArrayList();
        for (b bVar = this.f431s; bVar != null; bVar = bVar.f431s) {
            this.t.add(bVar);
        }
    }

    public final void i(Canvas canvas) {
        RectF rectF = this.h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.g);
        b.c.a.c.a("Layer#clearLayer");
    }

    public abstract void j(Canvas canvas, Matrix matrix, int i);

    public boolean k() {
        b.c.a.w.c.g gVar = this.p;
        return (gVar == null || gVar.a.isEmpty()) ? false : true;
    }

    public boolean l() {
        return this.r != null;
    }

    public final void m(float f) {
        s sVar = this.n.k.a;
        String str = this.o.c;
        if (sVar.a) {
            b.c.a.b0.e eVar = sVar.c.get(str);
            if (eVar == null) {
                eVar = new b.c.a.b0.e();
                sVar.c.put(str, eVar);
            }
            float f2 = eVar.a + f;
            eVar.a = f2;
            int i = eVar.f345b + 1;
            eVar.f345b = i;
            if (i == Integer.MAX_VALUE) {
                eVar.a = f2 / 2.0f;
                eVar.f345b = i / 2;
            }
            if (str.equals("__container")) {
                Iterator<s$a> it = sVar.f375b.iterator();
                while (it.hasNext()) {
                    it.next().a(f);
                }
            }
        }
    }

    public void n(b.c.a.y.f fVar, int i, List<b.c.a.y.f> list, b.c.a.y.f fVar2) {
    }

    public void o(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        o oVar = this.v;
        b.c.a.w.c.a<Integer, Integer> aVar = oVar.j;
        if (aVar != null) {
            aVar.h(f);
        }
        b.c.a.w.c.a<?, Float> aVar2 = oVar.m;
        if (aVar2 != null) {
            aVar2.h(f);
        }
        b.c.a.w.c.a<?, Float> aVar3 = oVar.n;
        if (aVar3 != null) {
            aVar3.h(f);
        }
        b.c.a.w.c.a<PointF, PointF> aVar4 = oVar.f;
        if (aVar4 != null) {
            aVar4.h(f);
        }
        b.c.a.w.c.a<?, PointF> aVar5 = oVar.g;
        if (aVar5 != null) {
            aVar5.h(f);
        }
        b.c.a.w.c.a<b.c.a.c0.d, b.c.a.c0.d> aVar6 = oVar.h;
        if (aVar6 != null) {
            aVar6.h(f);
        }
        b.c.a.w.c.a<Float, Float> aVar7 = oVar.i;
        if (aVar7 != null) {
            aVar7.h(f);
        }
        b.c.a.w.c.c cVar = oVar.k;
        if (cVar != null) {
            cVar.h(f);
        }
        b.c.a.w.c.c cVar2 = oVar.l;
        if (cVar2 != null) {
            cVar2.h(f);
        }
        if (this.p != null) {
            for (int i = 0; i < this.p.a.size(); i++) {
                this.p.a.get(i).h(f);
            }
        }
        float f2 = this.o.m;
        if (f2 != 0.0f) {
            f /= f2;
        }
        b.c.a.w.c.c cVar3 = this.q;
        if (cVar3 != null) {
            cVar3.h(f / f2);
        }
        b bVar = this.r;
        if (bVar != null) {
            bVar.o(bVar.o.m * f);
        }
        for (int i2 = 0; i2 < this.u.size(); i2++) {
            this.u.get(i2).h(f);
        }
    }

    public final void p(boolean z2) {
        if (z2 != this.w) {
            this.w = z2;
            this.n.invalidateSelf();
        }
    }
}
