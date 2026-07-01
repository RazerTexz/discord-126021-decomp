package b.f.h.a.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import b.f.g.e.e;
import java.util.Objects;

/* JADX INFO: compiled from: AnimatedDrawable2.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends Drawable implements Animatable, b.f.f.a.a {
    public static final Class<?> j = a.class;
    public static final b k = new b();
    public b.f.h.a.a.a l;
    public b.f.h.a.e.a m;
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
    public volatile b f533x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public e f534y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Runnable f535z;

    public a() {
        this(null);
    }

    @Override // b.f.f.a.a
    public void a() {
        b.f.h.a.a.a aVar = this.l;
        if (aVar != null) {
            aVar.clear();
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
        b.f.h.a.e.a aVar = this.m;
        long jB = aVar.b();
        int iA = jB == 0 ? aVar.a(0L) : ((aVar.a.b() == 0) || jMax / jB < ((long) aVar.a.b())) ? aVar.a(jMax % jB) : -1;
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
            b.f.d.e.a.h(2);
        }
        long jUptimeMillis2 = SystemClock.uptimeMillis();
        if (this.n) {
            b.f.h.a.e.a aVar2 = this.m;
            long j3 = jUptimeMillis2 - this.o;
            long jB2 = aVar2.b();
            if (jB2 == 0) {
                j2 = -1;
            } else if ((aVar2.a.b() == 0) || j3 / aVar2.b() < aVar2.a.b()) {
                long j4 = j3 % jB2;
                int iA2 = aVar2.a.a();
                long jE = 0;
                for (int i = 0; i < iA2 && jE <= j4; i++) {
                    jE += (long) aVar2.a.e(i);
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
        b.f.h.a.a.a aVar = this.l;
        return aVar == null ? super.getIntrinsicHeight() : aVar.g();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        b.f.h.a.a.a aVar = this.l;
        return aVar == null ? super.getIntrinsicWidth() : aVar.i();
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
        b.f.h.a.a.a aVar = this.l;
        if (aVar != null) {
            aVar.h(rect);
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
            this.f534y = new e();
        }
        this.f534y.a = i;
        b.f.h.a.a.a aVar = this.l;
        if (aVar != null) {
            aVar.f(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f534y == null) {
            this.f534y = new e();
        }
        e eVar = this.f534y;
        eVar.c = colorFilter;
        eVar.f506b = colorFilter != null;
        b.f.h.a.a.a aVar = this.l;
        if (aVar != null) {
            aVar.d(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        b.f.h.a.a.a aVar;
        if (this.n || (aVar = this.l) == null || aVar.a() <= 1) {
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

    public a(b.f.h.a.a.a aVar) {
        this.v = 8L;
        this.f533x = k;
        this.f535z = new a$a(this);
        this.l = aVar;
        this.m = aVar == null ? null : new b.f.h.a.e.a(aVar);
    }
}
