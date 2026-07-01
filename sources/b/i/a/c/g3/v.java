package b.i.a.c.g3;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;

/* JADX INFO: compiled from: VideoFrameReleaseHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v {
    public final p a = new p();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final v$b f993b;

    @Nullable
    public final v$e c;
    public boolean d;

    @Nullable
    public Surface e;
    public float f;
    public float g;
    public float h;
    public float i;
    public int j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;

    /* JADX WARN: Code duplicated, block: B:14:0x003b  */
    public v(@Nullable Context context) {
        v$b v_d;
        DisplayManager displayManager;
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            v_d = (e0.a < 17 || (displayManager = (DisplayManager) applicationContext.getSystemService("display")) == null) ? null : new v$d(displayManager);
            if (v_d == null) {
                WindowManager windowManager = (WindowManager) applicationContext.getSystemService("window");
                if (windowManager != null) {
                    v_d = new v$c(windowManager);
                } else {
                    v_d = null;
                }
            }
        } else {
            v_d = null;
        }
        this.f993b = v_d;
        this.c = v_d != null ? v$e.j : null;
        this.k = -9223372036854775807L;
        this.l = -9223372036854775807L;
        this.f = -1.0f;
        this.i = 1.0f;
        this.j = 0;
    }

    public final void a() {
        Surface surface;
        if (e0.a < 30 || (surface = this.e) == null || this.j == Integer.MIN_VALUE || this.h == 0.0f) {
            return;
        }
        this.h = 0.0f;
        v$a.a(surface, 0.0f);
    }

    public final void b() {
        this.m = 0L;
        this.p = -1L;
        this.n = -1L;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0086  */
    public final void c() {
        float f;
        boolean z2;
        if (e0.a < 30 || this.e == null) {
            return;
        }
        if (this.a.a()) {
            p pVar = this.a;
            if (pVar.a()) {
                p$a p_a = pVar.a;
                long j = p_a.e;
                f = (float) (1.0E9d / (j != 0 ? p_a.f / j : 0L));
            } else {
                f = -1.0f;
            }
        } else {
            f = this.f;
        }
        float f2 = this.g;
        if (f == f2) {
            return;
        }
        boolean z3 = true;
        if (f != -1.0f && f2 != -1.0f) {
            if (this.a.a()) {
                p pVar2 = this.a;
                if ((pVar2.a() ? pVar2.a.f : -9223372036854775807L) >= 5000000000L) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (Math.abs(f - this.g) < (z2 ? 0.02f : 1.0f)) {
                z3 = false;
            }
        } else if (f == -1.0f && this.a.e < 30) {
            z3 = false;
        }
        if (z3) {
            this.g = f;
            d(false);
        }
    }

    public final void d(boolean z2) {
        Surface surface;
        if (e0.a < 30 || (surface = this.e) == null || this.j == Integer.MIN_VALUE) {
            return;
        }
        float f = 0.0f;
        if (this.d) {
            float f2 = this.g;
            if (f2 != -1.0f) {
                f = this.i * f2;
            }
        }
        if (z2 || this.h != f) {
            this.h = f;
            v$a.a(surface, f);
        }
    }
}
