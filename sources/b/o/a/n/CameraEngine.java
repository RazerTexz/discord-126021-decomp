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
import b.o.a.CameraLogger;
import b.o.a.CameraOptions;
import b.o.a.PictureResult;
import b.o.a.m.Audio;
import b.o.a.m.AudioCodec;
import b.o.a.m.Facing;
import b.o.a.m.Flash;
import b.o.a.m.Hdr;
import b.o.a.m.Mode3;
import b.o.a.m.PictureFormat;
import b.o.a.m.VideoCodec;
import b.o.a.m.WhiteBalance;
import b.o.a.n.t.Angles;
import b.o.a.n.t.Reference2;
import b.o.a.n.v.CameraOrchestrator;
import b.o.a.n.v.CameraState2;
import b.o.a.n.v.CameraStateOrchestrator;
import b.o.a.q.Gesture;
import b.o.a.r.WorkerHandler;
import b.o.a.t.MeteringRegions;
import b.o.a.u.Overlay;
import b.o.a.v.PictureRecorder;
import b.o.a.w.CameraPreview;
import b.o.a.x.Size3;
import b.o.a.x.SizeSelector;
import com.google.android.gms.tasks.Task;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: b.o.a.n.i, reason: use source file name */
/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CameraEngine implements CameraPreview.c, PictureRecorder.a {
    public static final CameraLogger j = new CameraLogger(CameraEngine.class.getSimpleName());
    public WorkerHandler k;
    public final g m;
    public final CameraStateOrchestrator n = new CameraStateOrchestrator(new c());

    @VisibleForTesting
    public Handler l = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b.o.a.n.i$a */
    /* JADX INFO: compiled from: CameraEngine.java */
    public class a implements Callable<Task<Void>> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            return CameraEngine.this.R();
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.i$b */
    /* JADX INFO: compiled from: CameraEngine.java */
    public class b implements Callable<Task<Void>> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            return CameraEngine.this.U();
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.i$c */
    /* JADX INFO: compiled from: CameraEngine.java */
    public class c implements CameraOrchestrator.b {
        public c() {
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.i$d */
    /* JADX INFO: compiled from: CameraEngine.java */
    public class d implements b.i.a.f.n.c<Void> {
        public final /* synthetic */ CountDownLatch a;

        public d(CameraEngine cameraEngine, CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        @Override // b.i.a.f.n.c
        public void onComplete(@NonNull Task<Void> task) {
            this.a.countDown();
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.i$e */
    /* JADX INFO: compiled from: CameraEngine.java */
    public class e implements Callable<Task<Void>> {
        public e() {
        }

        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            if (CameraEngine.this.z() != null && CameraEngine.this.z().m()) {
                return CameraEngine.this.P();
            }
            c0 c0Var = new c0();
            c0Var.u();
            return c0Var;
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.i$f */
    /* JADX INFO: compiled from: CameraEngine.java */
    public class f implements Callable<Task<Void>> {
        public f() {
        }

        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            return CameraEngine.this.S();
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.i$g */
    /* JADX INFO: compiled from: CameraEngine.java */
    public interface g {
    }

    /* JADX INFO: renamed from: b.o.a.n.i$h */
    /* JADX INFO: compiled from: CameraEngine.java */
    public class h implements Thread.UncaughtExceptionHandler {
        public h(c cVar) {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
            CameraEngine.b(CameraEngine.this, th, true);
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.i$i */
    /* JADX INFO: compiled from: CameraEngine.java */
    public static class i implements Thread.UncaughtExceptionHandler {
        public i(c cVar) {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
            CameraEngine.j.a(2, "EXCEPTION:", "In the NoOpExceptionHandler, probably while destroying.", "Thread:", thread, "Error:", th);
        }
    }

    public CameraEngine(@NonNull g gVar) {
        this.m = gVar;
        W(false);
    }

    public static void b(CameraEngine cameraEngine, Throwable th, boolean z2) {
        Objects.requireNonNull(cameraEngine);
        if (z2) {
            j.a(3, "EXCEPTION:", "Handler thread is gone. Replacing.");
            cameraEngine.W(false);
        }
        j.a(3, "EXCEPTION:", "Scheduling on the crash handler...");
        cameraEngine.l.post(new CameraEngine2(cameraEngine, th));
    }

    public abstract float A();

    public abstract void A0(int i2);

    public abstract boolean B();

    public abstract void B0(@NonNull VideoCodec videoCodec);

    @Nullable
    public abstract Size3 C(@NonNull Reference2 reference2);

    public abstract void C0(int i2);

    public abstract int D();

    public abstract void D0(long j2);

    public abstract int E();

    public abstract void E0(@NonNull SizeSelector sizeSelector);

    @Nullable
    public abstract Size3 F(@NonNull Reference2 reference2);

    public abstract void F0(@NonNull WhiteBalance whiteBalance);

    public abstract int G();

    public abstract void G0(float f2, @Nullable PointF[] pointFArr, boolean z2);

    @NonNull
    public abstract VideoCodec H();

    @NonNull
    public Task<Void> H0() {
        j.a(1, "START:", "scheduled. State:", this.n.f);
        Task<Void> taskQ = this.n.f(CameraState2.OFF, CameraState2.ENGINE, true, new CameraEngine4(this)).q(new CameraEngine3(this));
        J0();
        K0();
        return taskQ;
    }

    public abstract int I();

    public abstract void I0(@Nullable Gesture gesture, @NonNull MeteringRegions meteringRegions, @NonNull PointF pointF);

    public abstract long J();

    @NonNull
    public final Task<Void> J0() {
        return this.n.f(CameraState2.ENGINE, CameraState2.BIND, true, new e());
    }

    @Nullable
    public abstract Size3 K(@NonNull Reference2 reference2);

    @NonNull
    public final Task<Void> K0() {
        return this.n.f(CameraState2.BIND, CameraState2.PREVIEW, true, new a());
    }

    @NonNull
    public abstract SizeSelector L();

    @NonNull
    public Task<Void> L0(boolean z2) {
        j.a(1, "STOP:", "scheduled. State:", this.n.f);
        N0(z2);
        M0(z2);
        Task taskF = this.n.f(CameraState2.ENGINE, CameraState2.OFF, !z2, new CameraEngine6(this));
        CameraEngine5 cameraEngine5 = new CameraEngine5(this);
        c0 c0Var = (c0) taskF;
        Objects.requireNonNull(c0Var);
        c0Var.g(b.i.a.f.n.g.a, cameraEngine5);
        return c0Var;
    }

    @NonNull
    public abstract WhiteBalance M();

    @NonNull
    public final Task<Void> M0(boolean z2) {
        return this.n.f(CameraState2.BIND, CameraState2.ENGINE, !z2, new f());
    }

    public abstract float N();

    @NonNull
    public final Task<Void> N0(boolean z2) {
        return this.n.f(CameraState2.PREVIEW, CameraState2.BIND, !z2, new b());
    }

    public final boolean O() {
        boolean z2;
        CameraStateOrchestrator cameraStateOrchestrator = this.n;
        synchronized (cameraStateOrchestrator.e) {
            for (CameraOrchestrator.c<?> cVar : cameraStateOrchestrator.c) {
                if (cVar.a.contains(" >> ") || cVar.a.contains(" << ")) {
                    if (!cVar.f1942b.a.o()) {
                        z2 = true;
                    }
                }
            }
            z2 = false;
        }
        return z2;
    }

    public abstract void O0(@NonNull PictureResult.a aVar);

    @NonNull
    public abstract Task<Void> P();

    public abstract void P0(@NonNull PictureResult.a aVar);

    @NonNull
    public abstract Task<CameraOptions> Q();

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
        WorkerHandler workerHandler = this.k;
        if (workerHandler != null) {
            HandlerThread handlerThread = workerHandler.e;
            if (handlerThread.isAlive()) {
                handlerThread.interrupt();
                handlerThread.quit();
            }
            WorkerHandler.f1952b.remove(workerHandler.d);
        }
        WorkerHandler workerHandlerB = WorkerHandler.b("CameraViewEngine");
        this.k = workerHandlerB;
        workerHandlerB.e.setUncaughtExceptionHandler(new h(null));
        if (z2) {
            CameraStateOrchestrator cameraStateOrchestrator = this.n;
            synchronized (cameraStateOrchestrator.e) {
                HashSet hashSet = new HashSet();
                Iterator<CameraOrchestrator.c<?>> it = cameraStateOrchestrator.c.iterator();
                while (it.hasNext()) {
                    hashSet.add(it.next().a);
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    cameraStateOrchestrator.e((String) it2.next(), 0);
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

    public abstract void Z(@NonNull Audio audio);

    public abstract void a0(int i2);

    public abstract void b0(@NonNull AudioCodec audioCodec);

    public abstract boolean c(@NonNull Facing facing);

    public abstract void c0(long j2);

    public final void d(boolean z2, int i2) {
        CameraLogger cameraLogger = j;
        cameraLogger.a(1, "DESTROY:", "state:", this.n.f, "thread:", Thread.currentThread(), "depth:", Integer.valueOf(i2), "unrecoverably:", Boolean.valueOf(z2));
        if (z2) {
            this.k.e.setUncaughtExceptionHandler(new i(null));
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        L0(true).c(this.k.g, new d(this, countDownLatch));
        try {
            if (!countDownLatch.await(6L, TimeUnit.SECONDS)) {
                cameraLogger.a(3, "DESTROY: Could not destroy synchronously after 6 seconds.", "Current thread:", Thread.currentThread(), "Handler thread:", this.k.e);
                int i3 = i2 + 1;
                if (i3 < 2) {
                    W(true);
                    cameraLogger.a(3, "DESTROY: Trying again on thread:", this.k.e);
                    d(z2, i3);
                } else {
                    cameraLogger.a(2, "DESTROY: Giving up because DESTROY_RETRIES was reached.");
                }
            }
        } catch (InterruptedException unused) {
        }
    }

    public abstract void d0(float f2, @NonNull float[] fArr, @Nullable PointF[] pointFArr, boolean z2);

    @NonNull
    public abstract Angles e();

    public abstract void e0(@NonNull Facing facing);

    @NonNull
    public abstract Audio f();

    public abstract void f0(@NonNull Flash flash);

    public abstract int g();

    public abstract void g0(int i2);

    @NonNull
    public abstract AudioCodec h();

    public abstract void h0(int i2);

    public abstract long i();

    public abstract void i0(int i2);

    @Nullable
    public abstract CameraOptions j();

    public abstract void j0(int i2);

    public abstract float k();

    public abstract void k0(boolean z2);

    @NonNull
    public abstract Facing l();

    public abstract void l0(@NonNull Hdr hdr);

    @NonNull
    public abstract Flash m();

    public abstract void m0(@Nullable Location location);

    public abstract int n();

    public abstract void n0(@NonNull Mode3 mode3);

    public abstract int o();

    public abstract void o0(@Nullable Overlay overlay);

    public abstract int p();

    public abstract void p0(@NonNull PictureFormat pictureFormat);

    public abstract int q();

    public abstract void q0(boolean z2);

    @NonNull
    public abstract Hdr r();

    public abstract void r0(@NonNull SizeSelector sizeSelector);

    @Nullable
    public abstract Location s();

    public abstract void s0(boolean z2);

    @NonNull
    public abstract Mode3 t();

    public abstract void t0(boolean z2);

    @NonNull
    public abstract PictureFormat u();

    public abstract void u0(@NonNull CameraPreview cameraPreview);

    public abstract boolean v();

    public abstract void v0(float f2);

    @Nullable
    public abstract Size3 w(@NonNull Reference2 reference2);

    public abstract void w0(boolean z2);

    @NonNull
    public abstract SizeSelector x();

    public abstract void x0(@Nullable SizeSelector sizeSelector);

    public abstract boolean y();

    public abstract void y0(int i2);

    @Nullable
    public abstract CameraPreview z();

    public abstract void z0(int i2);
}
