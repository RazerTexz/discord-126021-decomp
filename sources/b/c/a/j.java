package b.c.a;

import android.animation.Animator$AnimatorListener;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$Callback;
import android.os.Build$VERSION;
import android.widget.ImageView$ScaleType;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.c.a.a0.i0.c$a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: LottieDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends Drawable implements Drawable$Callback, Animatable {
    public boolean A;
    public boolean B;
    public boolean C;
    public final Matrix j = new Matrix();
    public d k;
    public final b.c.a.b0.d l;
    public float m;
    public boolean n;
    public boolean o;
    public final ArrayList<j$o> p;
    public final ValueAnimator$AnimatorUpdateListener q;

    @Nullable
    public ImageView$ScaleType r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public b.c.a.x.b f352s;

    @Nullable
    public String t;

    @Nullable
    public b u;

    @Nullable
    public b.c.a.x.a v;
    public boolean w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public b.c.a.y.m.c f353x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f354y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f355z;

    public j() {
        b.c.a.b0.d dVar = new b.c.a.b0.d();
        this.l = dVar;
        this.m = 1.0f;
        this.n = true;
        this.o = false;
        new HashSet();
        this.p = new ArrayList<>();
        j$f j_f = new j$f(this);
        this.q = j_f;
        this.f354y = 255;
        this.B = true;
        this.C = false;
        dVar.j.add(j_f);
    }

    public <T> void a(b.c.a.y.f fVar, T t, b.c.a.c0.c<T> cVar) {
        List listEmptyList;
        b.c.a.y.m.c cVar2 = this.f353x;
        if (cVar2 == null) {
            this.p.add(new j$e(this, fVar, t, cVar));
            return;
        }
        boolean zIsEmpty = true;
        if (fVar == b.c.a.y.f.a) {
            cVar2.g(t, cVar);
        } else {
            b.c.a.y.g gVar = fVar.c;
            if (gVar != null) {
                gVar.g(t, cVar);
            } else {
                if (cVar2 == null) {
                    b.c.a.b0.c.b("Cannot resolve KeyPath. Composition is not set yet.");
                    listEmptyList = Collections.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList();
                    this.f353x.c(fVar, 0, arrayList, new b.c.a.y.f(new String[0]));
                    listEmptyList = arrayList;
                }
                for (int i = 0; i < listEmptyList.size(); i++) {
                    ((b.c.a.y.f) listEmptyList.get(i)).c.g(t, cVar);
                }
                zIsEmpty = true ^ listEmptyList.isEmpty();
            }
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (t == o.A) {
                u(g());
            }
        }
    }

    public final void b() {
        d dVar = this.k;
        c$a c_a = b.c.a.a0.s.a;
        Rect rect = dVar.j;
        b.c.a.y.m.e eVar = new b.c.a.y.m.e(Collections.emptyList(), dVar, "__container", -1L, b.c.a.y.m.e$a.PRE_COMP, -1L, null, Collections.emptyList(), new b.c.a.y.k.l(null, null, null, null, null, null, null, null, null), 0, 0, 0, 0.0f, 0.0f, rect.width(), rect.height(), null, null, Collections.emptyList(), 1, null, false);
        d dVar2 = this.k;
        this.f353x = new b.c.a.y.m.c(this, eVar, dVar2.i, dVar2);
    }

    public void c() {
        b.c.a.b0.d dVar = this.l;
        if (dVar.t) {
            dVar.cancel();
        }
        this.k = null;
        this.f353x = null;
        this.f352s = null;
        b.c.a.b0.d dVar2 = this.l;
        dVar2.f344s = null;
        dVar2.q = -2.1474836E9f;
        dVar2.r = 2.1474836E9f;
        invalidateSelf();
    }

    public final void d(@NonNull Canvas canvas) {
        float f;
        float f2;
        int iSave = -1;
        if (ImageView$ScaleType.FIT_XY != this.r) {
            if (this.f353x == null) {
                return;
            }
            float f3 = this.m;
            float fMin = Math.min(canvas.getWidth() / this.k.j.width(), canvas.getHeight() / this.k.j.height());
            if (f3 > fMin) {
                f = this.m / fMin;
            } else {
                fMin = f3;
                f = 1.0f;
            }
            if (f > 1.0f) {
                iSave = canvas.save();
                float fWidth = this.k.j.width() / 2.0f;
                float fHeight = this.k.j.height() / 2.0f;
                float f4 = fWidth * fMin;
                float f5 = fHeight * fMin;
                float f6 = this.m;
                canvas.translate((fWidth * f6) - f4, (f6 * fHeight) - f5);
                canvas.scale(f, f, f4, f5);
            }
            this.j.reset();
            this.j.preScale(fMin, fMin);
            this.f353x.f(canvas, this.j, this.f354y);
            if (iSave > 0) {
                canvas.restoreToCount(iSave);
                return;
            }
            return;
        }
        if (this.f353x == null) {
            return;
        }
        Rect bounds = getBounds();
        float fWidth2 = bounds.width() / this.k.j.width();
        float fHeight2 = bounds.height() / this.k.j.height();
        if (this.B) {
            float fMin2 = Math.min(fWidth2, fHeight2);
            if (fMin2 < 1.0f) {
                f2 = 1.0f / fMin2;
                fWidth2 /= f2;
                fHeight2 /= f2;
            } else {
                f2 = 1.0f;
            }
            if (f2 > 1.0f) {
                iSave = canvas.save();
                float fWidth3 = bounds.width() / 2.0f;
                float fHeight3 = bounds.height() / 2.0f;
                float f7 = fWidth3 * fMin2;
                float f8 = fMin2 * fHeight3;
                canvas.translate(fWidth3 - f7, fHeight3 - f8);
                canvas.scale(f2, f2, f7, f8);
            }
        }
        this.j.reset();
        this.j.preScale(fWidth2, fHeight2);
        this.f353x.f(canvas, this.j, this.f354y);
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.C = false;
        if (this.o) {
            try {
                d(canvas);
            } catch (Throwable unused) {
                Objects.requireNonNull((b.c.a.b0.b) b.c.a.b0.c.a);
            }
        } else {
            d(canvas);
        }
        c.a("Drawable#draw");
    }

    public float e() {
        return this.l.i();
    }

    public float f() {
        return this.l.j();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float g() {
        return this.l.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f354y;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        d dVar = this.k;
        if (dVar == null) {
            return -1;
        }
        return (int) (dVar.j.height() * this.m);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        d dVar = this.k;
        if (dVar == null) {
            return -1;
        }
        return (int) (dVar.j.width() * this.m);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int h() {
        return this.l.getRepeatCount();
    }

    public boolean i() {
        b.c.a.b0.d dVar = this.l;
        if (dVar == null) {
            return false;
        }
        return dVar.t;
    }

    @Override // android.graphics.drawable.Drawable$Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable$Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.C) {
            return;
        }
        this.C = true;
        Drawable$Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return i();
    }

    @MainThread
    public void j() {
        if (this.f353x == null) {
            this.p.add(new j$g(this));
            return;
        }
        if (this.n || h() == 0) {
            b.c.a.b0.d dVar = this.l;
            dVar.t = true;
            boolean zK = dVar.k();
            for (Animator$AnimatorListener animator$AnimatorListener : dVar.k) {
                if (Build$VERSION.SDK_INT >= 26) {
                    animator$AnimatorListener.onAnimationStart(dVar, zK);
                } else {
                    animator$AnimatorListener.onAnimationStart(dVar);
                }
            }
            dVar.n((int) (dVar.k() ? dVar.i() : dVar.j()));
            dVar.n = 0L;
            dVar.p = 0;
            dVar.l();
        }
        if (this.n) {
            return;
        }
        l((int) (this.l.l < 0.0f ? f() : e()));
        this.l.g();
    }

    @MainThread
    public void k() {
        if (this.f353x == null) {
            this.p.add(new j$h(this));
            return;
        }
        if (this.n || h() == 0) {
            b.c.a.b0.d dVar = this.l;
            dVar.t = true;
            dVar.l();
            dVar.n = 0L;
            if (dVar.k() && dVar.o == dVar.j()) {
                dVar.o = dVar.i();
            } else if (!dVar.k() && dVar.o == dVar.i()) {
                dVar.o = dVar.j();
            }
        }
        if (this.n) {
            return;
        }
        l((int) (this.l.l < 0.0f ? f() : e()));
        this.l.g();
    }

    public void l(int i) {
        if (this.k == null) {
            this.p.add(new j$c(this, i));
        } else {
            this.l.n(i);
        }
    }

    public void m(int i) {
        if (this.k == null) {
            this.p.add(new j$k(this, i));
            return;
        }
        b.c.a.b0.d dVar = this.l;
        dVar.o(dVar.q, i + 0.99f);
    }

    public void n(String str) {
        d dVar = this.k;
        if (dVar == null) {
            this.p.add(new j$n(this, str));
            return;
        }
        b.c.a.y.i iVarD = dVar.d(str);
        if (iVarD == null) {
            throw new IllegalArgumentException(b.d.b.a.a.y("Cannot find marker with name ", str, "."));
        }
        m((int) (iVarD.f410b + iVarD.c));
    }

    public void o(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        d dVar = this.k;
        if (dVar == null) {
            this.p.add(new j$l(this, f));
        } else {
            m((int) b.c.a.b0.f.e(dVar.k, dVar.l, f));
        }
    }

    public void p(int i, int i2) {
        if (this.k == null) {
            this.p.add(new j$b(this, i, i2));
        } else {
            this.l.o(i, i2 + 0.99f);
        }
    }

    public void q(String str) {
        d dVar = this.k;
        if (dVar == null) {
            this.p.add(new j$a(this, str));
            return;
        }
        b.c.a.y.i iVarD = dVar.d(str);
        if (iVarD == null) {
            throw new IllegalArgumentException(b.d.b.a.a.y("Cannot find marker with name ", str, "."));
        }
        int i = (int) iVarD.f410b;
        p(i, ((int) iVarD.c) + i);
    }

    public void r(int i) {
        if (this.k == null) {
            this.p.add(new j$i(this, i));
        } else {
            b.c.a.b0.d dVar = this.l;
            dVar.o(i, (int) dVar.r);
        }
    }

    public void s(String str) {
        d dVar = this.k;
        if (dVar == null) {
            this.p.add(new j$m(this, str));
            return;
        }
        b.c.a.y.i iVarD = dVar.d(str);
        if (iVarD == null) {
            throw new IllegalArgumentException(b.d.b.a.a.y("Cannot find marker with name ", str, "."));
        }
        r((int) iVarD.f410b);
    }

    @Override // android.graphics.drawable.Drawable$Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable$Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.f354y = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        b.c.a.b0.c.b("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        j();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        this.p.clear();
        this.l.g();
    }

    public void t(float f) {
        d dVar = this.k;
        if (dVar == null) {
            this.p.add(new j$j(this, f));
        } else {
            r((int) b.c.a.b0.f.e(dVar.k, dVar.l, f));
        }
    }

    public void u(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        d dVar = this.k;
        if (dVar == null) {
            this.p.add(new j$d(this, f));
        } else {
            this.l.n(b.c.a.b0.f.e(dVar.k, dVar.l, f));
            c.a("Drawable#setProgress");
        }
    }

    @Override // android.graphics.drawable.Drawable$Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable$Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public final void v() {
        d dVar = this.k;
        if (dVar == null) {
            return;
        }
        float f = this.m;
        setBounds(0, 0, (int) (dVar.j.width() * f), (int) (this.k.j.height() * f));
    }
}
