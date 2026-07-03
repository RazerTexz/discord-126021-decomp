package p007b.p109f.p148h.p149a.p155c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Objects;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p130f.p131a.InterfaceC1729a;
import p007b.p109f.p132g.p142e.C1768e;
import p007b.p109f.p148h.p149a.p150a.InterfaceC1801a;
import p007b.p109f.p148h.p149a.p157e.C1825a;

/* JADX INFO: renamed from: b.f.h.a.c.a */
/* JADX INFO: compiled from: AnimatedDrawable2.java */
/* JADX INFO: loaded from: classes.dex */
public class C1818a extends Drawable implements Animatable, InterfaceC1729a {

    /* JADX INFO: renamed from: j */
    public static final Class<?> f3532j = C1818a.class;

    /* JADX INFO: renamed from: k */
    public static final C1819b f3533k = new C1819b();

    /* JADX INFO: renamed from: l */
    public InterfaceC1801a f3534l;

    /* JADX INFO: renamed from: m */
    public C1825a f3535m;

    /* JADX INFO: renamed from: n */
    public volatile boolean f3536n;

    /* JADX INFO: renamed from: o */
    public long f3537o;

    /* JADX INFO: renamed from: p */
    public long f3538p;

    /* JADX INFO: renamed from: q */
    public long f3539q;

    /* JADX INFO: renamed from: r */
    public int f3540r;

    /* JADX INFO: renamed from: s */
    public long f3541s;

    /* JADX INFO: renamed from: t */
    public long f3542t;

    /* JADX INFO: renamed from: u */
    public int f3543u;

    /* JADX INFO: renamed from: v */
    public long f3544v;

    /* JADX INFO: renamed from: w */
    public int f3545w;

    /* JADX INFO: renamed from: x */
    public volatile C1819b f3546x;

    /* JADX INFO: renamed from: y */
    public C1768e f3547y;

    /* JADX INFO: renamed from: z */
    public final Runnable f3548z;

    /* JADX INFO: renamed from: b.f.h.a.c.a$a */
    /* JADX INFO: compiled from: AnimatedDrawable2.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C1818a c1818a = C1818a.this;
            c1818a.unscheduleSelf(c1818a.f3548z);
            C1818a.this.invalidateSelf();
        }
    }

    public C1818a() {
        this(null);
    }

    @Override // p007b.p109f.p130f.p131a.InterfaceC1729a
    /* JADX INFO: renamed from: a */
    public void mo1034a() {
        InterfaceC1801a interfaceC1801a = this.f3534l;
        if (interfaceC1801a != null) {
            interfaceC1801a.clear();
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00ae  */
    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        long j;
        if (this.f3534l == null || this.f3535m == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        long jMax = this.f3536n ? (jUptimeMillis - this.f3537o) + 0 : Math.max(this.f3538p, 0L);
        C1825a c1825a = this.f3535m;
        long jM1167b = c1825a.m1167b();
        int iM1166a = jM1167b == 0 ? c1825a.m1166a(0L) : ((c1825a.f3561a.mo1143b() == 0) || jMax / jM1167b < ((long) c1825a.f3561a.mo1143b())) ? c1825a.m1166a(jMax % jM1167b) : -1;
        if (iM1166a == -1) {
            iM1166a = this.f3534l.mo1142a() - 1;
            Objects.requireNonNull(this.f3546x);
            this.f3536n = false;
        } else if (iM1166a == 0 && this.f3540r != -1 && jUptimeMillis >= this.f3539q) {
            Objects.requireNonNull(this.f3546x);
        }
        boolean zMo1141j = this.f3534l.mo1141j(this, canvas, iM1166a);
        if (zMo1141j) {
            Objects.requireNonNull(this.f3546x);
            this.f3540r = iM1166a;
        }
        if (!zMo1141j) {
            this.f3545w++;
            C1691a.m980h(2);
        }
        long jUptimeMillis2 = SystemClock.uptimeMillis();
        if (this.f3536n) {
            C1825a c1825a2 = this.f3535m;
            long j2 = jUptimeMillis2 - this.f3537o;
            long jM1167b2 = c1825a2.m1167b();
            if (jM1167b2 == 0) {
                j = -1;
            } else if ((c1825a2.f3561a.mo1143b() == 0) || j2 / c1825a2.m1167b() < c1825a2.f3561a.mo1143b()) {
                long j3 = j2 % jM1167b2;
                int iMo1142a = c1825a2.f3561a.mo1142a();
                long jMo1144e = 0;
                for (int i = 0; i < iMo1142a && jMo1144e <= j3; i++) {
                    jMo1144e += (long) c1825a2.f3561a.mo1144e(i);
                }
                j = (jMo1144e - j3) + j2;
            } else {
                j = -1;
            }
            if (j != -1) {
                long j4 = this.f3537o + j + this.f3544v;
                this.f3539q = j4;
                scheduleSelf(this.f3548z, j4);
            } else {
                Objects.requireNonNull(this.f3546x);
                this.f3536n = false;
            }
        }
        this.f3538p = jMax;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterfaceC1801a interfaceC1801a = this.f3534l;
        return interfaceC1801a == null ? super.getIntrinsicHeight() : interfaceC1801a.mo1138g();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterfaceC1801a interfaceC1801a = this.f3534l;
        return interfaceC1801a == null ? super.getIntrinsicWidth() : interfaceC1801a.mo1140i();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f3536n;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        InterfaceC1801a interfaceC1801a = this.f3534l;
        if (interfaceC1801a != null) {
            interfaceC1801a.mo1139h(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        if (this.f3536n) {
            return false;
        }
        long j = i;
        if (this.f3538p == j) {
            return false;
        }
        this.f3538p = j;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f3547y == null) {
            this.f3547y = new C1768e();
        }
        this.f3547y.f3339a = i;
        InterfaceC1801a interfaceC1801a = this.f3534l;
        if (interfaceC1801a != null) {
            interfaceC1801a.mo1137f(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f3547y == null) {
            this.f3547y = new C1768e();
        }
        C1768e c1768e = this.f3547y;
        c1768e.f3341c = colorFilter;
        c1768e.f3340b = colorFilter != null;
        InterfaceC1801a interfaceC1801a = this.f3534l;
        if (interfaceC1801a != null) {
            interfaceC1801a.mo1136d(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        InterfaceC1801a interfaceC1801a;
        if (this.f3536n || (interfaceC1801a = this.f3534l) == null || interfaceC1801a.mo1142a() <= 1) {
            return;
        }
        this.f3536n = true;
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = jUptimeMillis - this.f3541s;
        this.f3537o = j;
        this.f3539q = j;
        this.f3538p = jUptimeMillis - this.f3542t;
        this.f3540r = this.f3543u;
        invalidateSelf();
        Objects.requireNonNull(this.f3546x);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f3536n) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            this.f3541s = jUptimeMillis - this.f3537o;
            this.f3542t = jUptimeMillis - this.f3538p;
            this.f3543u = this.f3540r;
            this.f3536n = false;
            this.f3537o = 0L;
            this.f3539q = 0L;
            this.f3538p = -1L;
            this.f3540r = -1;
            unscheduleSelf(this.f3548z);
            Objects.requireNonNull(this.f3546x);
        }
    }

    public C1818a(InterfaceC1801a interfaceC1801a) {
        this.f3544v = 8L;
        this.f3546x = f3533k;
        this.f3548z = new a();
        this.f3534l = interfaceC1801a;
        this.f3535m = interfaceC1801a == null ? null : new C1825a(interfaceC1801a);
    }
}
