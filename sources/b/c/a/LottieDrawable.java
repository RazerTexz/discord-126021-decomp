package b.c.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.c.a.a0.LayerParser;
import b.c.a.a0.i0.JsonReader2;
import b.c.a.b0.LogcatLogger2;
import b.c.a.b0.Logger2;
import b.c.a.b0.LottieValueAnimator;
import b.c.a.b0.MiscUtils;
import b.c.a.c0.LottieValueCallback;
import b.c.a.x.FontAssetManager;
import b.c.a.x.ImageAssetManager;
import b.c.a.y.KeyPath;
import b.c.a.y.KeyPathElement;
import b.c.a.y.Marker2;
import b.c.a.y.k.AnimatableTransform;
import b.c.a.y.m.CompositionLayer;
import b.c.a.y.m.Layer2;
import b.d.b.a.outline;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.c.a.j, reason: use source file name */
/* JADX INFO: compiled from: LottieDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {
    public boolean A;
    public boolean B;
    public boolean C;
    public final Matrix j = new Matrix();
    public LottieComposition k;
    public final LottieValueAnimator l;
    public float m;
    public boolean n;
    public boolean o;
    public final ArrayList<o> p;
    public final ValueAnimator.AnimatorUpdateListener q;

    @Nullable
    public ImageView.ScaleType r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public ImageAssetManager f352s;

    @Nullable
    public String t;

    @Nullable
    public ImageAssetDelegate u;

    @Nullable
    public FontAssetManager v;
    public boolean w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public CompositionLayer f353x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f354y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f355z;

    /* JADX INFO: renamed from: b.c.a.j$a */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class a implements o {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // b.c.a.LottieDrawable.o
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.q(this.a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$b */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class b implements o {
        public final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f357b;

        public b(int i, int i2) {
            this.a = i;
            this.f357b = i2;
        }

        @Override // b.c.a.LottieDrawable.o
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.p(this.a, this.f357b);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$c */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class c implements o {
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        @Override // b.c.a.LottieDrawable.o
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.l(this.a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$d */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class d implements o {
        public final /* synthetic */ float a;

        public d(float f) {
            this.a = f;
        }

        @Override // b.c.a.LottieDrawable.o
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.u(this.a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$e */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class e implements o {
        public final /* synthetic */ KeyPath a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f360b;
        public final /* synthetic */ LottieValueCallback c;

        public e(KeyPath keyPath, Object obj, LottieValueCallback lottieValueCallback) {
            this.a = keyPath;
            this.f360b = obj;
            this.c = lottieValueCallback;
        }

        @Override // b.c.a.LottieDrawable.o
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.a(this.a, this.f360b, this.c);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$f */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            LottieDrawable lottieDrawable = LottieDrawable.this;
            CompositionLayer compositionLayer = lottieDrawable.f353x;
            if (compositionLayer != null) {
                compositionLayer.o(lottieDrawable.l.h());
            }
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$g */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class g implements o {
        public g() {
        }

        @Override // b.c.a.LottieDrawable.o
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.j();
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$h */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class h implements o {
        public h() {
        }

        @Override // b.c.a.LottieDrawable.o
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.k();
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$i */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class i implements o {
        public final /* synthetic */ int a;

        public i(int i) {
            this.a = i;
        }

        @Override // b.c.a.LottieDrawable.o
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.r(this.a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$j */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class j implements o {
        public final /* synthetic */ float a;

        public j(float f) {
            this.a = f;
        }

        @Override // b.c.a.LottieDrawable.o
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.t(this.a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$k */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class k implements o {
        public final /* synthetic */ int a;

        public k(int i) {
            this.a = i;
        }

        @Override // b.c.a.LottieDrawable.o
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.m(this.a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$l */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class l implements o {
        public final /* synthetic */ float a;

        public l(float f) {
            this.a = f;
        }

        @Override // b.c.a.LottieDrawable.o
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.o(this.a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$m */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class m implements o {
        public final /* synthetic */ String a;

        public m(String str) {
            this.a = str;
        }

        @Override // b.c.a.LottieDrawable.o
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.s(this.a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$n */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class n implements o {
        public final /* synthetic */ String a;

        public n(String str) {
            this.a = str;
        }

        @Override // b.c.a.LottieDrawable.o
        public void a(LottieComposition lottieComposition) {
            LottieDrawable.this.n(this.a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$o */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public interface o {
        void a(LottieComposition lottieComposition);
    }

    public LottieDrawable() {
        LottieValueAnimator lottieValueAnimator = new LottieValueAnimator();
        this.l = lottieValueAnimator;
        this.m = 1.0f;
        this.n = true;
        this.o = false;
        new HashSet();
        this.p = new ArrayList<>();
        f fVar = new f();
        this.q = fVar;
        this.f354y = 255;
        this.B = true;
        this.C = false;
        lottieValueAnimator.j.add(fVar);
    }

    public <T> void a(KeyPath keyPath, T t, LottieValueCallback<T> lottieValueCallback) {
        List listEmptyList;
        CompositionLayer compositionLayer = this.f353x;
        if (compositionLayer == null) {
            this.p.add(new e(keyPath, t, lottieValueCallback));
            return;
        }
        boolean zIsEmpty = true;
        if (keyPath == KeyPath.a) {
            compositionLayer.g(t, lottieValueCallback);
        } else {
            KeyPathElement keyPathElement = keyPath.c;
            if (keyPathElement != null) {
                keyPathElement.g(t, lottieValueCallback);
            } else {
                if (compositionLayer == null) {
                    Logger2.b("Cannot resolve KeyPath. Composition is not set yet.");
                    listEmptyList = Collections.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList();
                    this.f353x.c(keyPath, 0, arrayList, new KeyPath(new String[0]));
                    listEmptyList = arrayList;
                }
                for (int i2 = 0; i2 < listEmptyList.size(); i2++) {
                    ((KeyPath) listEmptyList.get(i2)).c.g(t, lottieValueCallback);
                }
                zIsEmpty = true ^ listEmptyList.isEmpty();
            }
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (t == LottieProperty.A) {
                u(g());
            }
        }
    }

    public final void b() {
        LottieComposition lottieComposition = this.k;
        JsonReader2.a aVar = LayerParser.a;
        Rect rect = lottieComposition.j;
        Layer2 layer2 = new Layer2(Collections.emptyList(), lottieComposition, "__container", -1L, Layer2.a.PRE_COMP, -1L, null, Collections.emptyList(), new AnimatableTransform(null, null, null, null, null, null, null, null, null), 0, 0, 0, 0.0f, 0.0f, rect.width(), rect.height(), null, null, Collections.emptyList(), 1, null, false);
        LottieComposition lottieComposition2 = this.k;
        this.f353x = new CompositionLayer(this, layer2, lottieComposition2.i, lottieComposition2);
    }

    public void c() {
        LottieValueAnimator lottieValueAnimator = this.l;
        if (lottieValueAnimator.t) {
            lottieValueAnimator.cancel();
        }
        this.k = null;
        this.f353x = null;
        this.f352s = null;
        LottieValueAnimator lottieValueAnimator2 = this.l;
        lottieValueAnimator2.f344s = null;
        lottieValueAnimator2.q = -2.1474836E9f;
        lottieValueAnimator2.r = 2.1474836E9f;
        invalidateSelf();
    }

    public final void d(@NonNull Canvas canvas) {
        float f2;
        float f3;
        int iSave = -1;
        if (ImageView.ScaleType.FIT_XY != this.r) {
            if (this.f353x == null) {
                return;
            }
            float f4 = this.m;
            float fMin = Math.min(canvas.getWidth() / this.k.j.width(), canvas.getHeight() / this.k.j.height());
            if (f4 > fMin) {
                f2 = this.m / fMin;
            } else {
                fMin = f4;
                f2 = 1.0f;
            }
            if (f2 > 1.0f) {
                iSave = canvas.save();
                float fWidth = this.k.j.width() / 2.0f;
                float fHeight = this.k.j.height() / 2.0f;
                float f5 = fWidth * fMin;
                float f6 = fHeight * fMin;
                float f7 = this.m;
                canvas.translate((fWidth * f7) - f5, (f7 * fHeight) - f6);
                canvas.scale(f2, f2, f5, f6);
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
                f3 = 1.0f / fMin2;
                fWidth2 /= f3;
                fHeight2 /= f3;
            } else {
                f3 = 1.0f;
            }
            if (f3 > 1.0f) {
                iSave = canvas.save();
                float fWidth3 = bounds.width() / 2.0f;
                float fHeight3 = bounds.height() / 2.0f;
                float f8 = fWidth3 * fMin2;
                float f9 = fMin2 * fHeight3;
                canvas.translate(fWidth3 - f8, fHeight3 - f9);
                canvas.scale(f3, f3, f8, f9);
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
                Objects.requireNonNull((LogcatLogger2) Logger2.a);
            }
        } else {
            d(canvas);
        }
        L.a("Drawable#draw");
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
        LottieComposition lottieComposition = this.k;
        if (lottieComposition == null) {
            return -1;
        }
        return (int) (lottieComposition.j.height() * this.m);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        LottieComposition lottieComposition = this.k;
        if (lottieComposition == null) {
            return -1;
        }
        return (int) (lottieComposition.j.width() * this.m);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int h() {
        return this.l.getRepeatCount();
    }

    public boolean i() {
        LottieValueAnimator lottieValueAnimator = this.l;
        if (lottieValueAnimator == null) {
            return false;
        }
        return lottieValueAnimator.t;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
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
        Drawable.Callback callback = getCallback();
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
            this.p.add(new g());
            return;
        }
        if (this.n || h() == 0) {
            LottieValueAnimator lottieValueAnimator = this.l;
            lottieValueAnimator.t = true;
            boolean zK = lottieValueAnimator.k();
            for (Animator.AnimatorListener animatorListener : lottieValueAnimator.k) {
                if (Build.VERSION.SDK_INT >= 26) {
                    animatorListener.onAnimationStart(lottieValueAnimator, zK);
                } else {
                    animatorListener.onAnimationStart(lottieValueAnimator);
                }
            }
            lottieValueAnimator.n((int) (lottieValueAnimator.k() ? lottieValueAnimator.i() : lottieValueAnimator.j()));
            lottieValueAnimator.n = 0L;
            lottieValueAnimator.p = 0;
            lottieValueAnimator.l();
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
            this.p.add(new h());
            return;
        }
        if (this.n || h() == 0) {
            LottieValueAnimator lottieValueAnimator = this.l;
            lottieValueAnimator.t = true;
            lottieValueAnimator.l();
            lottieValueAnimator.n = 0L;
            if (lottieValueAnimator.k() && lottieValueAnimator.o == lottieValueAnimator.j()) {
                lottieValueAnimator.o = lottieValueAnimator.i();
            } else if (!lottieValueAnimator.k() && lottieValueAnimator.o == lottieValueAnimator.i()) {
                lottieValueAnimator.o = lottieValueAnimator.j();
            }
        }
        if (this.n) {
            return;
        }
        l((int) (this.l.l < 0.0f ? f() : e()));
        this.l.g();
    }

    public void l(int i2) {
        if (this.k == null) {
            this.p.add(new c(i2));
        } else {
            this.l.n(i2);
        }
    }

    public void m(int i2) {
        if (this.k == null) {
            this.p.add(new k(i2));
            return;
        }
        LottieValueAnimator lottieValueAnimator = this.l;
        lottieValueAnimator.o(lottieValueAnimator.q, i2 + 0.99f);
    }

    public void n(String str) {
        LottieComposition lottieComposition = this.k;
        if (lottieComposition == null) {
            this.p.add(new n(str));
            return;
        }
        Marker2 marker2D = lottieComposition.d(str);
        if (marker2D == null) {
            throw new IllegalArgumentException(outline.y("Cannot find marker with name ", str, "."));
        }
        m((int) (marker2D.f410b + marker2D.c));
    }

    public void o(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        LottieComposition lottieComposition = this.k;
        if (lottieComposition == null) {
            this.p.add(new l(f2));
        } else {
            m((int) MiscUtils.e(lottieComposition.k, lottieComposition.l, f2));
        }
    }

    public void p(int i2, int i3) {
        if (this.k == null) {
            this.p.add(new b(i2, i3));
        } else {
            this.l.o(i2, i3 + 0.99f);
        }
    }

    public void q(String str) {
        LottieComposition lottieComposition = this.k;
        if (lottieComposition == null) {
            this.p.add(new a(str));
            return;
        }
        Marker2 marker2D = lottieComposition.d(str);
        if (marker2D == null) {
            throw new IllegalArgumentException(outline.y("Cannot find marker with name ", str, "."));
        }
        int i2 = (int) marker2D.f410b;
        p(i2, ((int) marker2D.c) + i2);
    }

    public void r(int i2) {
        if (this.k == null) {
            this.p.add(new i(i2));
        } else {
            LottieValueAnimator lottieValueAnimator = this.l;
            lottieValueAnimator.o(i2, (int) lottieValueAnimator.r);
        }
    }

    public void s(String str) {
        LottieComposition lottieComposition = this.k;
        if (lottieComposition == null) {
            this.p.add(new m(str));
            return;
        }
        Marker2 marker2D = lottieComposition.d(str);
        if (marker2D == null) {
            throw new IllegalArgumentException(outline.y("Cannot find marker with name ", str, "."));
        }
        r((int) marker2D.f410b);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.f354y = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Logger2.b("Use addColorFilter instead.");
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

    public void t(float f2) {
        LottieComposition lottieComposition = this.k;
        if (lottieComposition == null) {
            this.p.add(new j(f2));
        } else {
            r((int) MiscUtils.e(lottieComposition.k, lottieComposition.l, f2));
        }
    }

    public void u(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        LottieComposition lottieComposition = this.k;
        if (lottieComposition == null) {
            this.p.add(new d(f2));
        } else {
            this.l.n(MiscUtils.e(lottieComposition.k, lottieComposition.l, f2));
            L.a("Drawable#setProgress");
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public final void v() {
        LottieComposition lottieComposition = this.k;
        if (lottieComposition == null) {
            return;
        }
        float f2 = this.m;
        setBounds(0, 0, (int) (lottieComposition.j.width() * f2), (int) (this.k.j.height() * f2));
    }
}
