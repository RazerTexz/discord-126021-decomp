package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import b.f.g.e.f;
import b.f.g.e.g;
import b.f.g.e.h;
import b.f.g.e.j;
import b.f.g.e.m;
import b.f.g.e.p;
import b.f.g.e.z;
import b.f.g.f.b;
import b.f.g.f.c;
import b.f.g.f.d;
import b.f.g.h.a;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class GenericDraweeHierarchy implements a {
    public final Drawable a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f2890b;
    public c c;
    public final b d;
    public final f e;
    public final g f;

    public GenericDraweeHierarchy(b.f.g.f.a aVar) {
        int i;
        ColorDrawable colorDrawable = new ColorDrawable(0);
        this.a = colorDrawable;
        b.f.j.r.b.b();
        this.f2890b = aVar.c;
        this.c = aVar.r;
        g gVar = new g(colorDrawable);
        this.f = gVar;
        List<Drawable> list = aVar.p;
        int size = list != null ? list.size() : 1;
        int i2 = (size == 0 ? 1 : size) + (aVar.q != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[i2 + 6];
        drawableArr[0] = g(aVar.o, null);
        drawableArr[1] = g(aVar.f, aVar.g);
        ScalingUtils$ScaleType scalingUtils$ScaleType = aVar.n;
        gVar.setColorFilter(null);
        drawableArr[2] = d.e(gVar, scalingUtils$ScaleType, null);
        drawableArr[3] = g(aVar.l, aVar.m);
        drawableArr[4] = g(aVar.h, aVar.i);
        drawableArr[5] = g(aVar.j, aVar.k);
        if (i2 > 0) {
            List<Drawable> list2 = aVar.p;
            if (list2 != null) {
                Iterator<Drawable> it = list2.iterator();
                i = 0;
                while (it.hasNext()) {
                    drawableArr[i + 6] = g(it.next(), null);
                    i++;
                }
            } else {
                i = 1;
            }
            Drawable drawable = aVar.q;
            if (drawable != null) {
                drawableArr[i + 6] = g(drawable, null);
            }
        }
        f fVar = new f(drawableArr, false, 2);
        this.e = fVar;
        fVar.w = aVar.d;
        if (fVar.v == 1) {
            fVar.v = 0;
        }
        b bVar = new b(d.d(fVar, this.c));
        this.d = bVar;
        bVar.mutate();
        m();
        b.f.j.r.b.b();
    }

    @Override // b.f.g.h.a
    public void a(Drawable drawable) {
        b bVar = this.d;
        bVar.n = drawable;
        bVar.invalidateSelf();
    }

    @Override // b.f.g.h.a
    public void b(Throwable th) {
        this.e.e();
        i();
        if (this.e.a(4) != null) {
            h(4);
        } else {
            h(1);
        }
        this.e.f();
    }

    @Override // b.f.g.h.a
    public void c(Throwable th) {
        this.e.e();
        i();
        if (this.e.a(5) != null) {
            h(5);
        } else {
            h(1);
        }
        this.e.f();
    }

    @Override // b.f.g.h.a
    public void d(float f, boolean z2) {
        if (this.e.a(3) == null) {
            return;
        }
        this.e.e();
        r(f);
        if (z2) {
            this.e.g();
        }
        this.e.f();
    }

    @Override // com.facebook.drawee.interfaces.DraweeHierarchy
    public Drawable e() {
        return this.d;
    }

    @Override // b.f.g.h.a
    public void f(Drawable drawable, float f, boolean z2) {
        Drawable drawableC = d.c(drawable, this.c, this.f2890b);
        drawableC.mutate();
        this.f.o(drawableC);
        this.e.e();
        i();
        h(2);
        r(f);
        if (z2) {
            this.e.g();
        }
        this.e.f();
    }

    public final Drawable g(Drawable drawable, ScalingUtils$ScaleType scalingUtils$ScaleType) {
        return d.e(d.c(drawable, this.c, this.f2890b), scalingUtils$ScaleType, null);
    }

    @Override // com.facebook.drawee.interfaces.DraweeHierarchy
    public Rect getBounds() {
        return this.d.getBounds();
    }

    public final void h(int i) {
        if (i >= 0) {
            f fVar = this.e;
            fVar.v = 0;
            fVar.B[i] = true;
            fVar.invalidateSelf();
        }
    }

    public final void i() {
        j(1);
        j(2);
        j(3);
        j(4);
        j(5);
    }

    public final void j(int i) {
        if (i >= 0) {
            f fVar = this.e;
            fVar.v = 0;
            fVar.B[i] = false;
            fVar.invalidateSelf();
        }
    }

    public final b.f.g.e.d k(int i) {
        f fVar = this.e;
        Objects.requireNonNull(fVar);
        b.c.a.a0.d.i(Boolean.valueOf(i >= 0));
        b.c.a.a0.d.i(Boolean.valueOf(i < fVar.m.length));
        b.f.g.e.d[] dVarArr = fVar.m;
        if (dVarArr[i] == null) {
            dVarArr[i] = new b.f.g.e.a(fVar, i);
        }
        b.f.g.e.d dVar = dVarArr[i];
        if (dVar.l() instanceof h) {
            dVar = (h) dVar.l();
        }
        return dVar.l() instanceof p ? (p) dVar.l() : dVar;
    }

    public final p l(int i) {
        b.f.g.e.d dVarK = k(i);
        if (dVarK instanceof p) {
            return (p) dVarK;
        }
        ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
        Drawable drawableE = d.e(dVarK.g(d.a), z.l, null);
        dVarK.g(drawableE);
        b.c.a.a0.d.y(drawableE, "Parent has no child drawable!");
        return (p) drawableE;
    }

    public final void m() {
        f fVar = this.e;
        if (fVar != null) {
            fVar.e();
            f fVar2 = this.e;
            fVar2.v = 0;
            Arrays.fill(fVar2.B, true);
            fVar2.invalidateSelf();
            i();
            h(1);
            this.e.g();
            this.e.f();
        }
    }

    public void n(ScalingUtils$ScaleType scalingUtils$ScaleType) {
        Objects.requireNonNull(scalingUtils$ScaleType);
        l(2).r(scalingUtils$ScaleType);
    }

    public final void o(int i, Drawable drawable) {
        if (drawable == null) {
            this.e.c(i, null);
        } else {
            k(i).g(d.c(drawable, this.c, this.f2890b));
        }
    }

    public void p(int i) {
        o(1, this.f2890b.getDrawable(i));
    }

    public void q(Drawable drawable, ScalingUtils$ScaleType scalingUtils$ScaleType) {
        o(1, drawable);
        l(1).r(scalingUtils$ScaleType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r(float f) {
        Drawable drawableA = this.e.a(3);
        if (drawableA == 0) {
            return;
        }
        if (f >= 0.999f) {
            if (drawableA instanceof Animatable) {
                ((Animatable) drawableA).stop();
            }
            j(3);
        } else {
            if (drawableA instanceof Animatable) {
                ((Animatable) drawableA).start();
            }
            h(3);
        }
        drawableA.setLevel(Math.round(f * 10000.0f));
    }

    @Override // b.f.g.h.a
    public void reset() {
        this.f.o(this.a);
        m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void s(c cVar) {
        this.c = cVar;
        b bVar = this.d;
        Drawable drawable = d.a;
        Drawable drawable2 = bVar.k;
        if (cVar == null || cVar.a != 1) {
            if (drawable2 instanceof m) {
                Drawable drawable3 = d.a;
                bVar.o(((m) drawable2).o(drawable3));
                drawable3.setCallback(null);
            }
        } else if (drawable2 instanceof m) {
            m mVar = (m) drawable2;
            d.b(mVar, cVar);
            mVar.f514x = cVar.d;
            mVar.invalidateSelf();
        } else {
            bVar.o(d.d(bVar.o(d.a), cVar));
        }
        for (int i = 0; i < this.e.l.length; i++) {
            b.f.g.e.d dVarK = k(i);
            c cVar2 = this.c;
            Resources resources = this.f2890b;
            while (true) {
                Object objL = dVarK.l();
                if (objL == dVarK || !(objL instanceof b.f.g.e.d)) {
                    break;
                } else {
                    dVarK = (b.f.g.e.d) objL;
                }
            }
            Drawable drawableL = dVarK.l();
            if (cVar2 == null || cVar2.a != 2) {
                if (drawableL instanceof j) {
                    j jVar = (j) drawableL;
                    jVar.c(false);
                    jVar.j(0.0f);
                    jVar.a(0, 0.0f);
                    jVar.i(0.0f);
                    jVar.f(false);
                    jVar.e(false);
                }
            } else if (drawableL instanceof j) {
                d.b((j) drawableL, cVar2);
            } else if (drawableL != 0) {
                dVarK.g(d.a);
                dVarK.g(d.a(drawableL, cVar2, resources));
            }
        }
    }
}
