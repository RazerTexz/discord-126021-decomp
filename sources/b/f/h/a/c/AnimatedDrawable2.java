package b.f.h.a.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import b.f.d.e.FLog;
import b.f.f.a.DrawableWithCaches;
import b.f.g.e.DrawableProperties;
import b.f.h.a.a.AnimationBackend;
import b.f.h.a.e.DropFramesFrameScheduler;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.h.a.c.a, reason: use source file name */
/* JADX INFO: compiled from: AnimatedDrawable2.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimatedDrawable2 extends Drawable implements Animatable, DrawableWithCaches {
    public static final Class<?> j = AnimatedDrawable2.class;
    public static final BaseAnimationListener k = new BaseAnimationListener();
    public AnimationBackend l;
    public DropFramesFrameScheduler m;
    public volatile boolean n;
    public long o;
    public long p;
    public long q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f532s;
    public long t;
    public int u;
    public long v;
    public int w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public volatile BaseAnimationListener f533x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public DrawableProperties f534y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Runnable f535z;

    /* JADX INFO: renamed from: b.f.h.a.c.a$a */
    /* JADX INFO: compiled from: AnimatedDrawable2.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AnimatedDrawable2 animatedDrawable2 = AnimatedDrawable2.this;
            animatedDrawable2.unscheduleSelf(animatedDrawable2.f535z);
            AnimatedDrawable2.this.invalidateSelf();
        }
    }

    public AnimatedDrawable2() {
        this(null);
    }

    @Override // b.f.f.a.DrawableWithCaches
    public void a() {
        AnimationBackend animationBackend = this.l;
        if (animationBackend != null) {
            animationBackend.clear();
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00ae  */
    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        long j2;
        if (this.l == null || this.m == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        long jMax = this.n ? (jUptimeMillis - this.o) + 0 : Math.max(this.p, 0L);
        DropFramesFrameScheduler dropFramesFrameScheduler = this.m;
        long jB = dropFramesFrameScheduler.b();
        int iA = jB == 0 ? dropFramesFrameScheduler.a(0L) : ((dropFramesFrameScheduler.a.b() == 0) || jMax / jB < ((long) dropFramesFrameScheduler.a.b())) ? dropFramesFrameScheduler.a(jMax % jB) : -1;
        if (iA == -1) {
            iA = this.l.a() - 1;
            Objects.requireNonNull(this.f533x);
            this.n = false;
        } else if (iA == 0 && this.r != -1 && jUptimeMillis >= this.q) {
            Objects.requireNonNull(this.f533x);
        }
        boolean zJ = this.l.j(this, canvas, iA);
        if (zJ) {
            Objects.requireNonNull(this.f533x);
            this.r = iA;
        }
        if (!zJ) {
            this.w++;
            FLog.h(2);
        }
        long jUptimeMillis2 = SystemClock.uptimeMillis();
        if (this.n) {
            DropFramesFrameScheduler dropFramesFrameScheduler2 = this.m;
            long j3 = jUptimeMillis2 - this.o;
            long jB2 = dropFramesFrameScheduler2.b();
            if (jB2 == 0) {
                j2 = -1;
            } else if ((dropFramesFrameScheduler2.a.b() == 0) || j3 / dropFramesFrameScheduler2.b() < dropFramesFrameScheduler2.a.b()) {
                long j4 = j3 % jB2;
                int iA2 = dropFramesFrameScheduler2.a.a();
                long jE = 0;
                for (int i = 0; i < iA2 && jE <= j4; i++) {
                    jE += (long) dropFramesFrameScheduler2.a.e(i);
                }
                j2 = (jE - j4) + j3;
            } else {
                j2 = -1;
            }
            if (j2 != -1) {
                long j5 = this.o + j2 + this.v;
                this.q = j5;
                scheduleSelf(this.f535z, j5);
            } else {
                Objects.requireNonNull(this.f533x);
                this.n = false;
            }
        }
        this.p = jMax;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        AnimationBackend animationBackend = this.l;
        return animationBackend == null ? super.getIntrinsicHeight() : animationBackend.g();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        AnimationBackend animationBackend = this.l;
        return animationBackend == null ? super.getIntrinsicWidth() : animationBackend.i();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        AnimationBackend animationBackend = this.l;
        if (animationBackend != null) {
            animationBackend.h(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        if (this.n) {
            return false;
        }
        long j2 = i;
        if (this.p == j2) {
            return false;
        }
        this.p = j2;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f534y == null) {
            this.f534y = new DrawableProperties();
        }
        this.f534y.a = i;
        AnimationBackend animationBackend = this.l;
        if (animationBackend != null) {
            animationBackend.f(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f534y == null) {
            this.f534y = new DrawableProperties();
        }
        DrawableProperties drawableProperties = this.f534y;
        drawableProperties.c = colorFilter;
        drawableProperties.f506b = colorFilter != null;
        AnimationBackend animationBackend = this.l;
        if (animationBackend != null) {
            animationBackend.d(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        AnimationBackend animationBackend;
        if (this.n || (animationBackend = this.l) == null || animationBackend.a() <= 1) {
            return;
        }
        this.n = true;
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j2 = jUptimeMillis - this.f532s;
        this.o = j2;
        this.q = j2;
        this.p = jUptimeMillis - this.t;
        this.r = this.u;
        invalidateSelf();
        Objects.requireNonNull(this.f533x);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.n) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            this.f532s = jUptimeMillis - this.o;
            this.t = jUptimeMillis - this.p;
            this.u = this.r;
            this.n = false;
            this.o = 0L;
            this.q = 0L;
            this.p = -1L;
            this.r = -1;
            unscheduleSelf(this.f535z);
            Objects.requireNonNull(this.f533x);
        }
    }

    public AnimatedDrawable2(AnimationBackend animationBackend) {
        this.v = 8L;
        this.f533x = k;
        this.f535z = new a();
        this.l = animationBackend;
        this.m = animationBackend == null ? null : new DropFramesFrameScheduler(animationBackend);
    }
}
