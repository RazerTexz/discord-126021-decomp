package p007b.p085c.p086a;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1484s;
import p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c;
import p007b.p085c.p086a.p089b0.C1494b;
import p007b.p085c.p086a.p089b0.C1495c;
import p007b.p085c.p086a.p089b0.C1498f;
import p007b.p085c.p086a.p089b0.ChoreographerFrameCallbackC1496d;
import p007b.p085c.p086a.p090c0.C1503c;
import p007b.p085c.p086a.p094x.C1560a;
import p007b.p085c.p086a.p094x.C1561b;
import p007b.p085c.p086a.p095y.C1567f;
import p007b.p085c.p086a.p095y.C1570i;
import p007b.p085c.p086a.p095y.InterfaceC1568g;
import p007b.p085c.p086a.p095y.p096k.C1583l;
import p007b.p085c.p086a.p095y.p098m.C1604c;
import p007b.p085c.p086a.p095y.p098m.C1606e;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.j */
/* JADX INFO: compiled from: LottieDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class C1511j extends Drawable implements Drawable.Callback, Animatable {

    /* JADX INFO: renamed from: A */
    public boolean f2366A;

    /* JADX INFO: renamed from: B */
    public boolean f2367B;

    /* JADX INFO: renamed from: C */
    public boolean f2368C;

    /* JADX INFO: renamed from: j */
    public final Matrix f2369j = new Matrix();

    /* JADX INFO: renamed from: k */
    public C1505d f2370k;

    /* JADX INFO: renamed from: l */
    public final ChoreographerFrameCallbackC1496d f2371l;

    /* JADX INFO: renamed from: m */
    public float f2372m;

    /* JADX INFO: renamed from: n */
    public boolean f2373n;

    /* JADX INFO: renamed from: o */
    public boolean f2374o;

    /* JADX INFO: renamed from: p */
    public final ArrayList<o> f2375p;

    /* JADX INFO: renamed from: q */
    public final ValueAnimator.AnimatorUpdateListener f2376q;

    /* JADX INFO: renamed from: r */
    @Nullable
    public ImageView.ScaleType f2377r;

    /* JADX INFO: renamed from: s */
    @Nullable
    public C1561b f2378s;

    /* JADX INFO: renamed from: t */
    @Nullable
    public String f2379t;

    /* JADX INFO: renamed from: u */
    @Nullable
    public InterfaceC1492b f2380u;

    /* JADX INFO: renamed from: v */
    @Nullable
    public C1560a f2381v;

    /* JADX INFO: renamed from: w */
    public boolean f2382w;

    /* JADX INFO: renamed from: x */
    @Nullable
    public C1604c f2383x;

    /* JADX INFO: renamed from: y */
    public int f2384y;

    /* JADX INFO: renamed from: z */
    public boolean f2385z;

    /* JADX INFO: renamed from: b.c.a.j$a */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class a implements o {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ String f2386a;

        public a(String str) {
            this.f2386a = str;
        }

        @Override // p007b.p085c.p086a.C1511j.o
        /* JADX INFO: renamed from: a */
        public void mo703a(C1505d c1505d) {
            C1511j.this.m697q(this.f2386a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$b */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class b implements o {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ int f2388a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ int f2389b;

        public b(int i, int i2) {
            this.f2388a = i;
            this.f2389b = i2;
        }

        @Override // p007b.p085c.p086a.C1511j.o
        /* JADX INFO: renamed from: a */
        public void mo703a(C1505d c1505d) {
            C1511j.this.m696p(this.f2388a, this.f2389b);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$c */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class c implements o {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ int f2391a;

        public c(int i) {
            this.f2391a = i;
        }

        @Override // p007b.p085c.p086a.C1511j.o
        /* JADX INFO: renamed from: a */
        public void mo703a(C1505d c1505d) {
            C1511j.this.m692l(this.f2391a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$d */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class d implements o {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ float f2393a;

        public d(float f) {
            this.f2393a = f;
        }

        @Override // p007b.p085c.p086a.C1511j.o
        /* JADX INFO: renamed from: a */
        public void mo703a(C1505d c1505d) {
            C1511j.this.m701u(this.f2393a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$e */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class e implements o {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ C1567f f2395a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ Object f2396b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ C1503c f2397c;

        public e(C1567f c1567f, Object obj, C1503c c1503c) {
            this.f2395a = c1567f;
            this.f2396b = obj;
            this.f2397c = c1503c;
        }

        @Override // p007b.p085c.p086a.C1511j.o
        /* JADX INFO: renamed from: a */
        public void mo703a(C1505d c1505d) {
            C1511j.this.m681a(this.f2395a, this.f2396b, this.f2397c);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$f */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            C1511j c1511j = C1511j.this;
            C1604c c1604c = c1511j.f2383x;
            if (c1604c != null) {
                c1604c.mo785o(c1511j.f2371l.m643h());
            }
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$g */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class g implements o {
        public g() {
        }

        @Override // p007b.p085c.p086a.C1511j.o
        /* JADX INFO: renamed from: a */
        public void mo703a(C1505d c1505d) {
            C1511j.this.m690j();
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$h */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class h implements o {
        public h() {
        }

        @Override // p007b.p085c.p086a.C1511j.o
        /* JADX INFO: renamed from: a */
        public void mo703a(C1505d c1505d) {
            C1511j.this.m691k();
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$i */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class i implements o {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ int f2402a;

        public i(int i) {
            this.f2402a = i;
        }

        @Override // p007b.p085c.p086a.C1511j.o
        /* JADX INFO: renamed from: a */
        public void mo703a(C1505d c1505d) {
            C1511j.this.m698r(this.f2402a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$j */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class j implements o {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ float f2404a;

        public j(float f) {
            this.f2404a = f;
        }

        @Override // p007b.p085c.p086a.C1511j.o
        /* JADX INFO: renamed from: a */
        public void mo703a(C1505d c1505d) {
            C1511j.this.m700t(this.f2404a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$k */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class k implements o {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ int f2406a;

        public k(int i) {
            this.f2406a = i;
        }

        @Override // p007b.p085c.p086a.C1511j.o
        /* JADX INFO: renamed from: a */
        public void mo703a(C1505d c1505d) {
            C1511j.this.m693m(this.f2406a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$l */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class l implements o {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ float f2408a;

        public l(float f) {
            this.f2408a = f;
        }

        @Override // p007b.p085c.p086a.C1511j.o
        /* JADX INFO: renamed from: a */
        public void mo703a(C1505d c1505d) {
            C1511j.this.m695o(this.f2408a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$m */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class m implements o {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ String f2410a;

        public m(String str) {
            this.f2410a = str;
        }

        @Override // p007b.p085c.p086a.C1511j.o
        /* JADX INFO: renamed from: a */
        public void mo703a(C1505d c1505d) {
            C1511j.this.m699s(this.f2410a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$n */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public class n implements o {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ String f2412a;

        public n(String str) {
            this.f2412a = str;
        }

        @Override // p007b.p085c.p086a.C1511j.o
        /* JADX INFO: renamed from: a */
        public void mo703a(C1505d c1505d) {
            C1511j.this.m694n(this.f2412a);
        }
    }

    /* JADX INFO: renamed from: b.c.a.j$o */
    /* JADX INFO: compiled from: LottieDrawable.java */
    public interface o {
        /* JADX INFO: renamed from: a */
        void mo703a(C1505d c1505d);
    }

    public C1511j() {
        ChoreographerFrameCallbackC1496d choreographerFrameCallbackC1496d = new ChoreographerFrameCallbackC1496d();
        this.f2371l = choreographerFrameCallbackC1496d;
        this.f2372m = 1.0f;
        this.f2373n = true;
        this.f2374o = false;
        new HashSet();
        this.f2375p = new ArrayList<>();
        f fVar = new f();
        this.f2376q = fVar;
        this.f2384y = 255;
        this.f2367B = true;
        this.f2368C = false;
        choreographerFrameCallbackC1496d.f2293j.add(fVar);
    }

    /* JADX INFO: renamed from: a */
    public <T> void m681a(C1567f c1567f, T t, C1503c<T> c1503c) {
        List listEmptyList;
        C1604c c1604c = this.f2383x;
        if (c1604c == null) {
            this.f2375p.add(new e(c1567f, t, c1503c));
            return;
        }
        boolean zIsEmpty = true;
        if (c1567f == C1567f.f2712a) {
            c1604c.mo714g(t, c1503c);
        } else {
            InterfaceC1568g interfaceC1568g = c1567f.f2714c;
            if (interfaceC1568g != null) {
                interfaceC1568g.mo714g(t, c1503c);
            } else {
                if (c1604c == null) {
                    C1495c.m640b("Cannot resolve KeyPath. Composition is not set yet.");
                    listEmptyList = Collections.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList();
                    this.f2383x.mo711c(c1567f, 0, arrayList, new C1567f(new String[0]));
                    listEmptyList = arrayList;
                }
                for (int i2 = 0; i2 < listEmptyList.size(); i2++) {
                    ((C1567f) listEmptyList.get(i2)).f2714c.mo714g(t, c1503c);
                }
                zIsEmpty = true ^ listEmptyList.isEmpty();
            }
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (t == InterfaceC1516o.f2419A) {
                m701u(m687g());
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m682b() {
        C1505d c1505d = this.f2370k;
        AbstractC1473c.a aVar = C1484s.f2280a;
        Rect rect = c1505d.f2345j;
        C1606e c1606e = new C1606e(Collections.emptyList(), c1505d, "__container", -1L, C1606e.a.PRE_COMP, -1L, null, Collections.emptyList(), new C1583l(null, null, null, null, null, null, null, null, null), 0, 0, 0, 0.0f, 0.0f, rect.width(), rect.height(), null, null, Collections.emptyList(), 1, null, false);
        C1505d c1505d2 = this.f2370k;
        this.f2383x = new C1604c(this, c1606e, c1505d2.f2344i, c1505d2);
    }

    /* JADX INFO: renamed from: c */
    public void m683c() {
        ChoreographerFrameCallbackC1496d choreographerFrameCallbackC1496d = this.f2371l;
        if (choreographerFrameCallbackC1496d.f2305t) {
            choreographerFrameCallbackC1496d.cancel();
        }
        this.f2370k = null;
        this.f2383x = null;
        this.f2378s = null;
        ChoreographerFrameCallbackC1496d choreographerFrameCallbackC1496d2 = this.f2371l;
        choreographerFrameCallbackC1496d2.f2304s = null;
        choreographerFrameCallbackC1496d2.f2302q = -2.1474836E9f;
        choreographerFrameCallbackC1496d2.f2303r = 2.1474836E9f;
        invalidateSelf();
    }

    /* JADX INFO: renamed from: d */
    public final void m684d(@NonNull Canvas canvas) {
        float f2;
        float f3;
        int iSave = -1;
        if (ImageView.ScaleType.FIT_XY != this.f2377r) {
            if (this.f2383x == null) {
                return;
            }
            float f4 = this.f2372m;
            float fMin = Math.min(canvas.getWidth() / this.f2370k.f2345j.width(), canvas.getHeight() / this.f2370k.f2345j.height());
            if (f4 > fMin) {
                f2 = this.f2372m / fMin;
            } else {
                fMin = f4;
                f2 = 1.0f;
            }
            if (f2 > 1.0f) {
                iSave = canvas.save();
                float fWidth = this.f2370k.f2345j.width() / 2.0f;
                float fHeight = this.f2370k.f2345j.height() / 2.0f;
                float f5 = fWidth * fMin;
                float f6 = fHeight * fMin;
                float f7 = this.f2372m;
                canvas.translate((fWidth * f7) - f5, (f7 * fHeight) - f6);
                canvas.scale(f2, f2, f5, f6);
            }
            this.f2369j.reset();
            this.f2369j.preScale(fMin, fMin);
            this.f2383x.mo713f(canvas, this.f2369j, this.f2384y);
            if (iSave > 0) {
                canvas.restoreToCount(iSave);
                return;
            }
            return;
        }
        if (this.f2383x == null) {
            return;
        }
        Rect bounds = getBounds();
        float fWidth2 = bounds.width() / this.f2370k.f2345j.width();
        float fHeight2 = bounds.height() / this.f2370k.f2345j.height();
        if (this.f2367B) {
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
        this.f2369j.reset();
        this.f2369j.preScale(fWidth2, fHeight2);
        this.f2383x.mo713f(canvas, this.f2369j, this.f2384y);
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.f2368C = false;
        if (this.f2374o) {
            try {
                m684d(canvas);
            } catch (Throwable unused) {
                Objects.requireNonNull((C1494b) C1495c.f2296a);
            }
        } else {
            m684d(canvas);
        }
        C1500c.m663a("Drawable#draw");
    }

    /* JADX INFO: renamed from: e */
    public float m685e() {
        return this.f2371l.m644i();
    }

    /* JADX INFO: renamed from: f */
    public float m686f() {
        return this.f2371l.m645j();
    }

    @FloatRange(from = 0.0d, m75to = 1.0d)
    /* JADX INFO: renamed from: g */
    public float m687g() {
        return this.f2371l.m643h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f2384y;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        C1505d c1505d = this.f2370k;
        if (c1505d == null) {
            return -1;
        }
        return (int) (c1505d.f2345j.height() * this.f2372m);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        C1505d c1505d = this.f2370k;
        if (c1505d == null) {
            return -1;
        }
        return (int) (c1505d.f2345j.width() * this.f2372m);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: renamed from: h */
    public int m688h() {
        return this.f2371l.getRepeatCount();
    }

    /* JADX INFO: renamed from: i */
    public boolean m689i() {
        ChoreographerFrameCallbackC1496d choreographerFrameCallbackC1496d = this.f2371l;
        if (choreographerFrameCallbackC1496d == null) {
            return false;
        }
        return choreographerFrameCallbackC1496d.f2305t;
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
        if (this.f2368C) {
            return;
        }
        this.f2368C = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return m689i();
    }

    @MainThread
    /* JADX INFO: renamed from: j */
    public void m690j() {
        if (this.f2383x == null) {
            this.f2375p.add(new g());
            return;
        }
        if (this.f2373n || m688h() == 0) {
            ChoreographerFrameCallbackC1496d choreographerFrameCallbackC1496d = this.f2371l;
            choreographerFrameCallbackC1496d.f2305t = true;
            boolean zM646k = choreographerFrameCallbackC1496d.m646k();
            for (Animator.AnimatorListener animatorListener : choreographerFrameCallbackC1496d.f2294k) {
                if (Build.VERSION.SDK_INT >= 26) {
                    animatorListener.onAnimationStart(choreographerFrameCallbackC1496d, zM646k);
                } else {
                    animatorListener.onAnimationStart(choreographerFrameCallbackC1496d);
                }
            }
            choreographerFrameCallbackC1496d.m649n((int) (choreographerFrameCallbackC1496d.m646k() ? choreographerFrameCallbackC1496d.m644i() : choreographerFrameCallbackC1496d.m645j()));
            choreographerFrameCallbackC1496d.f2299n = 0L;
            choreographerFrameCallbackC1496d.f2301p = 0;
            choreographerFrameCallbackC1496d.m647l();
        }
        if (this.f2373n) {
            return;
        }
        m692l((int) (this.f2371l.f2297l < 0.0f ? m686f() : m685e()));
        this.f2371l.m642g();
    }

    @MainThread
    /* JADX INFO: renamed from: k */
    public void m691k() {
        if (this.f2383x == null) {
            this.f2375p.add(new h());
            return;
        }
        if (this.f2373n || m688h() == 0) {
            ChoreographerFrameCallbackC1496d choreographerFrameCallbackC1496d = this.f2371l;
            choreographerFrameCallbackC1496d.f2305t = true;
            choreographerFrameCallbackC1496d.m647l();
            choreographerFrameCallbackC1496d.f2299n = 0L;
            if (choreographerFrameCallbackC1496d.m646k() && choreographerFrameCallbackC1496d.f2300o == choreographerFrameCallbackC1496d.m645j()) {
                choreographerFrameCallbackC1496d.f2300o = choreographerFrameCallbackC1496d.m644i();
            } else if (!choreographerFrameCallbackC1496d.m646k() && choreographerFrameCallbackC1496d.f2300o == choreographerFrameCallbackC1496d.m644i()) {
                choreographerFrameCallbackC1496d.f2300o = choreographerFrameCallbackC1496d.m645j();
            }
        }
        if (this.f2373n) {
            return;
        }
        m692l((int) (this.f2371l.f2297l < 0.0f ? m686f() : m685e()));
        this.f2371l.m642g();
    }

    /* JADX INFO: renamed from: l */
    public void m692l(int i2) {
        if (this.f2370k == null) {
            this.f2375p.add(new c(i2));
        } else {
            this.f2371l.m649n(i2);
        }
    }

    /* JADX INFO: renamed from: m */
    public void m693m(int i2) {
        if (this.f2370k == null) {
            this.f2375p.add(new k(i2));
            return;
        }
        ChoreographerFrameCallbackC1496d choreographerFrameCallbackC1496d = this.f2371l;
        choreographerFrameCallbackC1496d.m650o(choreographerFrameCallbackC1496d.f2302q, i2 + 0.99f);
    }

    /* JADX INFO: renamed from: n */
    public void m694n(String str) {
        C1505d c1505d = this.f2370k;
        if (c1505d == null) {
            this.f2375p.add(new n(str));
            return;
        }
        C1570i c1570iM672d = c1505d.m672d(str);
        if (c1570iM672d == null) {
            throw new IllegalArgumentException(C1643a.m886y("Cannot find marker with name ", str, "."));
        }
        m693m((int) (c1570iM672d.f2718b + c1570iM672d.f2719c));
    }

    /* JADX INFO: renamed from: o */
    public void m695o(@FloatRange(from = 0.0d, m75to = 1.0d) float f2) {
        C1505d c1505d = this.f2370k;
        if (c1505d == null) {
            this.f2375p.add(new l(f2));
        } else {
            m693m((int) C1498f.m655e(c1505d.f2346k, c1505d.f2347l, f2));
        }
    }

    /* JADX INFO: renamed from: p */
    public void m696p(int i2, int i3) {
        if (this.f2370k == null) {
            this.f2375p.add(new b(i2, i3));
        } else {
            this.f2371l.m650o(i2, i3 + 0.99f);
        }
    }

    /* JADX INFO: renamed from: q */
    public void m697q(String str) {
        C1505d c1505d = this.f2370k;
        if (c1505d == null) {
            this.f2375p.add(new a(str));
            return;
        }
        C1570i c1570iM672d = c1505d.m672d(str);
        if (c1570iM672d == null) {
            throw new IllegalArgumentException(C1643a.m886y("Cannot find marker with name ", str, "."));
        }
        int i2 = (int) c1570iM672d.f2718b;
        m696p(i2, ((int) c1570iM672d.f2719c) + i2);
    }

    /* JADX INFO: renamed from: r */
    public void m698r(int i2) {
        if (this.f2370k == null) {
            this.f2375p.add(new i(i2));
        } else {
            ChoreographerFrameCallbackC1496d choreographerFrameCallbackC1496d = this.f2371l;
            choreographerFrameCallbackC1496d.m650o(i2, (int) choreographerFrameCallbackC1496d.f2303r);
        }
    }

    /* JADX INFO: renamed from: s */
    public void m699s(String str) {
        C1505d c1505d = this.f2370k;
        if (c1505d == null) {
            this.f2375p.add(new m(str));
            return;
        }
        C1570i c1570iM672d = c1505d.m672d(str);
        if (c1570iM672d == null) {
            throw new IllegalArgumentException(C1643a.m886y("Cannot find marker with name ", str, "."));
        }
        m698r((int) c1570iM672d.f2718b);
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
    public void setAlpha(@IntRange(from = 0, m76to = 255) int i2) {
        this.f2384y = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        C1495c.m640b("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        m690j();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        this.f2375p.clear();
        this.f2371l.m642g();
    }

    /* JADX INFO: renamed from: t */
    public void m700t(float f2) {
        C1505d c1505d = this.f2370k;
        if (c1505d == null) {
            this.f2375p.add(new j(f2));
        } else {
            m698r((int) C1498f.m655e(c1505d.f2346k, c1505d.f2347l, f2));
        }
    }

    /* JADX INFO: renamed from: u */
    public void m701u(@FloatRange(from = 0.0d, m75to = 1.0d) float f2) {
        C1505d c1505d = this.f2370k;
        if (c1505d == null) {
            this.f2375p.add(new d(f2));
        } else {
            this.f2371l.m649n(C1498f.m655e(c1505d.f2346k, c1505d.f2347l, f2));
            C1500c.m663a("Drawable#setProgress");
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

    /* JADX INFO: renamed from: v */
    public final void m702v() {
        C1505d c1505d = this.f2370k;
        if (c1505d == null) {
            return;
        }
        float f2 = this.f2372m;
        setBounds(0, 0, (int) (c1505d.f2345j.width() * f2), (int) (this.f2370k.f2345j.height() * f2));
    }
}
