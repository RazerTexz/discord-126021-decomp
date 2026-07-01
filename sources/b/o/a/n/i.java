package b.o.a.n;

import android.graphics.PointF;
import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.i.a.f.n.c0;
import b.o.a.l$a;
import b.o.a.w.a$c;
import com.google.android.gms.tasks.Task;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i implements a$c, b.o.a.v.d$a {
    public static final b.o.a.b j = new b.o.a.b(i.class.getSimpleName());
    public b.o.a.r.g k;
    public final i$g m;
    public final b.o.a.n.v.f n = new b.o.a.n.v.f(new i$c(this));

    @VisibleForTesting
    public Handler l = new Handler(Looper.getMainLooper());

    public i(@NonNull i$g i_g) {
        this.m = i_g;
        W(false);
    }

    public static void b(i iVar, Throwable th, boolean z2) {
        Objects.requireNonNull(iVar);
        if (z2) {
            j.a(3, "EXCEPTION:", "Handler thread is gone. Replacing.");
            iVar.W(false);
        }
        j.a(3, "EXCEPTION:", "Scheduling on the crash handler...");
        iVar.l.post(new j(iVar, th));
    }

    public abstract float A();

    public abstract void A0(int i);

    public abstract boolean B();

    public abstract void B0(@NonNull b.o.a.m.l lVar);

    @Nullable
    public abstract b.o.a.x.b C(@NonNull b.o.a.n.t.b bVar);

    public abstract void C0(int i);

    public abstract int D();

    public abstract void D0(long j2);

    public abstract int E();

    public abstract void E0(@NonNull b.o.a.x.c cVar);

    @Nullable
    public abstract b.o.a.x.b F(@NonNull b.o.a.n.t.b bVar);

    public abstract void F0(@NonNull b.o.a.m.m mVar);

    public abstract int G();

    public abstract void G0(float f, @Nullable PointF[] pointFArr, boolean z2);

    @NonNull
    public abstract b.o.a.m.l H();

    @NonNull
    public Task<Void> H0() {
        j.a(1, "START:", "scheduled. State:", this.n.f);
        Task<Void> taskQ = this.n.f(b.o.a.n.v.e.OFF, b.o.a.n.v.e.ENGINE, true, new l(this)).q(new k(this));
        J0();
        K0();
        return taskQ;
    }

    public abstract int I();

    public abstract void I0(@Nullable b.o.a.q.a aVar, @NonNull b.o.a.t.b bVar, @NonNull PointF pointF);

    public abstract long J();

    @NonNull
    public final Task<Void> J0() {
        return this.n.f(b.o.a.n.v.e.ENGINE, b.o.a.n.v.e.BIND, true, new i$e(this));
    }

    @Nullable
    public abstract b.o.a.x.b K(@NonNull b.o.a.n.t.b bVar);

    @NonNull
    public final Task<Void> K0() {
        return this.n.f(b.o.a.n.v.e.BIND, b.o.a.n.v.e.PREVIEW, true, new i$a(this));
    }

    @NonNull
    public abstract b.o.a.x.c L();

    @NonNull
    public Task<Void> L0(boolean z2) {
        j.a(1, "STOP:", "scheduled. State:", this.n.f);
        N0(z2);
        M0(z2);
        Task taskF = this.n.f(b.o.a.n.v.e.ENGINE, b.o.a.n.v.e.OFF, !z2, new n(this));
        m mVar = new m(this);
        c0 c0Var = (c0) taskF;
        Objects.requireNonNull(c0Var);
        c0Var.g(b.i.a.f.n.g.a, mVar);
        return c0Var;
    }

    @NonNull
    public abstract b.o.a.m.m M();

    @NonNull
    public final Task<Void> M0(boolean z2) {
        return this.n.f(b.o.a.n.v.e.BIND, b.o.a.n.v.e.ENGINE, !z2, new i$f(this));
    }

    public abstract float N();

    @NonNull
    public final Task<Void> N0(boolean z2) {
        return this.n.f(b.o.a.n.v.e.PREVIEW, b.o.a.n.v.e.BIND, !z2, new i$b(this));
    }

    public final boolean O() {
        boolean z2;
        b.o.a.n.v.f fVar = this.n;
        synchronized (fVar.e) {
            for (b.o.a.n.v.a$c<?> a_c : fVar.c) {
                if (a_c.a.contains(" >> ") || a_c.a.contains(" << ")) {
                    if (!a_c.f1942b.a.o()) {
                        z2 = true;
                    }
                }
            }
            z2 = false;
        }
        return z2;
    }

    public abstract void O0(@NonNull l$a l_a);

    @NonNull
    public abstract Task<Void> P();

    public abstract void P0(@NonNull l$a l_a);

    @NonNull
    public abstract Task<b.o.a.c> Q();

    @NonNull
    public abstract Task<Void> R();

    @NonNull
    public abstract Task<Void> S();

    @NonNull
    public abstract Task<Void> T();

    @NonNull
    public abstract Task<Void> U();

    public final void V() {
        j.a(1, "onSurfaceAvailable:", "Size is", z().l());
        J0();
        K0();
    }

    public final void W(boolean z2) {
        b.o.a.r.g gVar = this.k;
        if (gVar != null) {
            HandlerThread handlerThread = gVar.e;
            if (handlerThread.isAlive()) {
                handlerThread.interrupt();
                handlerThread.quit();
            }
            b.o.a.r.g.f1952b.remove(gVar.d);
        }
        b.o.a.r.g gVarB = b.o.a.r.g.b("CameraViewEngine");
        this.k = gVarB;
        gVarB.e.setUncaughtExceptionHandler(new i$h(this, null));
        if (z2) {
            b.o.a.n.v.f fVar = this.n;
            synchronized (fVar.e) {
                HashSet hashSet = new HashSet();
                Iterator<b.o.a.n.v.a$c<?>> it = fVar.c.iterator();
                while (it.hasNext()) {
                    hashSet.add(it.next().a);
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    fVar.e((String) it2.next(), 0);
                }
            }
        }
    }

    public void X() {
        j.a(1, "RESTART:", "scheduled. State:", this.n.f);
        L0(false);
        H0();
    }

    @NonNull
    public Task<Void> Y() {
        j.a(1, "RESTART BIND:", "scheduled. State:", this.n.f);
        N0(false);
        M0(false);
        J0();
        return K0();
    }

    public abstract void Z(@NonNull b.o.a.m.a aVar);

    public abstract void a0(int i);

    public abstract void b0(@NonNull b.o.a.m.b bVar);

    public abstract boolean c(@NonNull b.o.a.m.e eVar);

    public abstract void c0(long j2);

    public final void d(boolean z2, int i) {
        b.o.a.b bVar = j;
        bVar.a(1, "DESTROY:", "state:", this.n.f, "thread:", Thread.currentThread(), "depth:", Integer.valueOf(i), "unrecoverably:", Boolean.valueOf(z2));
        if (z2) {
            this.k.e.setUncaughtExceptionHandler(new i$i(null));
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        L0(true).c(this.k.g, new i$d(this, countDownLatch));
        try {
            if (!countDownLatch.await(6L, TimeUnit.SECONDS)) {
                bVar.a(3, "DESTROY: Could not destroy synchronously after 6 seconds.", "Current thread:", Thread.currentThread(), "Handler thread:", this.k.e);
                int i2 = i + 1;
                if (i2 < 2) {
                    W(true);
                    bVar.a(3, "DESTROY: Trying again on thread:", this.k.e);
                    d(z2, i2);
                } else {
                    bVar.a(2, "DESTROY: Giving up because DESTROY_RETRIES was reached.");
                }
            }
        } catch (InterruptedException unused) {
        }
    }

    public abstract void d0(float f, @NonNull float[] fArr, @Nullable PointF[] pointFArr, boolean z2);

    @NonNull
    public abstract b.o.a.n.t.a e();

    public abstract void e0(@NonNull b.o.a.m.e eVar);

    @NonNull
    public abstract b.o.a.m.a f();

    public abstract void f0(@NonNull b.o.a.m.f fVar);

    public abstract int g();

    public abstract void g0(int i);

    @NonNull
    public abstract b.o.a.m.b h();

    public abstract void h0(int i);

    public abstract long i();

    public abstract void i0(int i);

    @Nullable
    public abstract b.o.a.c j();

    public abstract void j0(int i);

    public abstract float k();

    public abstract void k0(boolean z2);

    @NonNull
    public abstract b.o.a.m.e l();

    public abstract void l0(@NonNull b.o.a.m.h hVar);

    @NonNull
    public abstract b.o.a.m.f m();

    public abstract void m0(@Nullable Location location);

    public abstract int n();

    public abstract void n0(@NonNull b.o.a.m.i iVar);

    public abstract int o();

    public abstract void o0(@Nullable b.o.a.u.a aVar);

    public abstract int p();

    public abstract void p0(@NonNull b.o.a.m.j jVar);

    public abstract int q();

    public abstract void q0(boolean z2);

    @NonNull
    public abstract b.o.a.m.h r();

    public abstract void r0(@NonNull b.o.a.x.c cVar);

    @Nullable
    public abstract Location s();

    public abstract void s0(boolean z2);

    @NonNull
    public abstract b.o.a.m.i t();

    public abstract void t0(boolean z2);

    @NonNull
    public abstract b.o.a.m.j u();

    public abstract void u0(@NonNull b.o.a.w.a aVar);

    public abstract boolean v();

    public abstract void v0(float f);

    @Nullable
    public abstract b.o.a.x.b w(@NonNull b.o.a.n.t.b bVar);

    public abstract void w0(boolean z2);

    @NonNull
    public abstract b.o.a.x.c x();

    public abstract void x0(@Nullable b.o.a.x.c cVar);

    public abstract boolean y();

    public abstract void y0(int i);

    @Nullable
    public abstract b.o.a.w.a z();

    public abstract void z0(int i);
}
