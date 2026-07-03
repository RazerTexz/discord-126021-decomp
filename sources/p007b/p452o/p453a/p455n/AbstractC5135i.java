package p007b.p452o.p453a.p455n;

import android.graphics.PointF;
import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p007b.p225i.p226a.p288f.p340n.C4358c0;
import p007b.p225i.p226a.p288f.p340n.C4363g;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4357c;
import p007b.p452o.p453a.AbstractC5104c;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.C5113l;
import p007b.p452o.p453a.p454m.EnumC5114a;
import p007b.p452o.p453a.p454m.EnumC5115b;
import p007b.p452o.p453a.p454m.EnumC5118e;
import p007b.p452o.p453a.p454m.EnumC5119f;
import p007b.p452o.p453a.p454m.EnumC5121h;
import p007b.p452o.p453a.p454m.EnumC5122i;
import p007b.p452o.p453a.p454m.EnumC5123j;
import p007b.p452o.p453a.p454m.EnumC5125l;
import p007b.p452o.p453a.p454m.EnumC5126m;
import p007b.p452o.p453a.p455n.p461t.C5170a;
import p007b.p452o.p453a.p455n.p461t.EnumC5171b;
import p007b.p452o.p453a.p455n.p463v.C5174a;
import p007b.p452o.p453a.p455n.p463v.C5179f;
import p007b.p452o.p453a.p455n.p463v.EnumC5178e;
import p007b.p452o.p453a.p466q.EnumC5193a;
import p007b.p452o.p453a.p467r.C5206g;
import p007b.p452o.p453a.p469t.C5211b;
import p007b.p452o.p453a.p470u.InterfaceC5213a;
import p007b.p452o.p453a.p471v.AbstractC5219d;
import p007b.p452o.p453a.p472w.AbstractC5225a;
import p007b.p452o.p453a.p473x.C5236b;
import p007b.p452o.p453a.p473x.InterfaceC5237c;

/* JADX INFO: renamed from: b.o.a.n.i */
/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC5135i implements AbstractC5225a.c, AbstractC5219d.a {

    /* JADX INFO: renamed from: j */
    public static final C5103b f13918j = new C5103b(AbstractC5135i.class.getSimpleName());

    /* JADX INFO: renamed from: k */
    public C5206g f13919k;

    /* JADX INFO: renamed from: m */
    public final g f13921m;

    /* JADX INFO: renamed from: n */
    public final C5179f f13922n = new C5179f(new c());

    /* JADX INFO: renamed from: l */
    @VisibleForTesting
    public Handler f13920l = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b.o.a.n.i$a */
    /* JADX INFO: compiled from: CameraEngine.java */
    public class a implements Callable<Task<Void>> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            return AbstractC5135i.this.mo7195R();
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.i$b */
    /* JADX INFO: compiled from: CameraEngine.java */
    public class b implements Callable<Task<Void>> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            return AbstractC5135i.this.mo7199U();
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.i$c */
    /* JADX INFO: compiled from: CameraEngine.java */
    public class c implements C5174a.b {
        public c() {
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.i$d */
    /* JADX INFO: compiled from: CameraEngine.java */
    public class d implements InterfaceC4357c<Void> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ CountDownLatch f13926a;

        public d(AbstractC5135i abstractC5135i, CountDownLatch countDownLatch) {
            this.f13926a = countDownLatch;
        }

        @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4357c
        public void onComplete(@NonNull Task<Void> task) {
            this.f13926a.countDown();
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.i$e */
    /* JADX INFO: compiled from: CameraEngine.java */
    public class e implements Callable<Task<Void>> {
        public e() {
        }

        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            if (AbstractC5135i.this.mo7315z() != null && AbstractC5135i.this.mo7315z().m7433m()) {
                return AbstractC5135i.this.mo7193P();
            }
            C4358c0 c4358c0 = new C4358c0();
            c4358c0.m6026u();
            return c4358c0;
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.i$f */
    /* JADX INFO: compiled from: CameraEngine.java */
    public class f implements Callable<Task<Void>> {
        public f() {
        }

        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            return AbstractC5135i.this.mo7196S();
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
            AbstractC5135i.m7317b(AbstractC5135i.this, th, true);
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.i$i */
    /* JADX INFO: compiled from: CameraEngine.java */
    public static class i implements Thread.UncaughtExceptionHandler {
        public i(c cVar) {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
            AbstractC5135i.f13918j.m7159a(2, "EXCEPTION:", "In the NoOpExceptionHandler, probably while destroying.", "Thread:", thread, "Error:", th);
        }
    }

    public AbstractC5135i(@NonNull g gVar) {
        this.f13921m = gVar;
        m7326W(false);
    }

    /* JADX INFO: renamed from: b */
    public static void m7317b(AbstractC5135i abstractC5135i, Throwable th, boolean z2) {
        Objects.requireNonNull(abstractC5135i);
        if (z2) {
            f13918j.m7159a(3, "EXCEPTION:", "Handler thread is gone. Replacing.");
            abstractC5135i.m7326W(false);
        }
        f13918j.m7159a(3, "EXCEPTION:", "Scheduling on the crash handler...");
        abstractC5135i.f13920l.post(new RunnableC5136j(abstractC5135i, th));
    }

    /* JADX INFO: renamed from: A */
    public abstract float mo7250A();

    /* JADX INFO: renamed from: A0 */
    public abstract void mo7251A0(int i2);

    /* JADX INFO: renamed from: B */
    public abstract boolean mo7252B();

    /* JADX INFO: renamed from: B0 */
    public abstract void mo7253B0(@NonNull EnumC5125l enumC5125l);

    @Nullable
    /* JADX INFO: renamed from: C */
    public abstract C5236b mo7254C(@NonNull EnumC5171b enumC5171b);

    /* JADX INFO: renamed from: C0 */
    public abstract void mo7255C0(int i2);

    /* JADX INFO: renamed from: D */
    public abstract int mo7256D();

    /* JADX INFO: renamed from: D0 */
    public abstract void mo7257D0(long j);

    /* JADX INFO: renamed from: E */
    public abstract int mo7258E();

    /* JADX INFO: renamed from: E0 */
    public abstract void mo7259E0(@NonNull InterfaceC5237c interfaceC5237c);

    @Nullable
    /* JADX INFO: renamed from: F */
    public abstract C5236b mo7260F(@NonNull EnumC5171b enumC5171b);

    /* JADX INFO: renamed from: F0 */
    public abstract void mo7190F0(@NonNull EnumC5126m enumC5126m);

    /* JADX INFO: renamed from: G */
    public abstract int mo7261G();

    /* JADX INFO: renamed from: G0 */
    public abstract void mo7191G0(float f2, @Nullable PointF[] pointFArr, boolean z2);

    @NonNull
    /* JADX INFO: renamed from: H */
    public abstract EnumC5125l mo7262H();

    @NonNull
    /* JADX INFO: renamed from: H0 */
    public Task<Void> m7318H0() {
        f13918j.m7159a(1, "START:", "scheduled. State:", this.f13922n.f14028f);
        Task<Void> taskMo6022q = this.f13922n.m7368f(EnumC5178e.OFF, EnumC5178e.ENGINE, true, new CallableC5138l(this)).mo6022q(new C5137k(this));
        m7319J0();
        m7320K0();
        return taskMo6022q;
    }

    /* JADX INFO: renamed from: I */
    public abstract int mo7263I();

    /* JADX INFO: renamed from: I0 */
    public abstract void mo7192I0(@Nullable EnumC5193a enumC5193a, @NonNull C5211b c5211b, @NonNull PointF pointF);

    /* JADX INFO: renamed from: J */
    public abstract long mo7264J();

    @NonNull
    /* JADX INFO: renamed from: J0 */
    public final Task<Void> m7319J0() {
        return this.f13922n.m7368f(EnumC5178e.ENGINE, EnumC5178e.BIND, true, new e());
    }

    @Nullable
    /* JADX INFO: renamed from: K */
    public abstract C5236b mo7265K(@NonNull EnumC5171b enumC5171b);

    @NonNull
    /* JADX INFO: renamed from: K0 */
    public final Task<Void> m7320K0() {
        return this.f13922n.m7368f(EnumC5178e.BIND, EnumC5178e.PREVIEW, true, new a());
    }

    @NonNull
    /* JADX INFO: renamed from: L */
    public abstract InterfaceC5237c mo7266L();

    @NonNull
    /* JADX INFO: renamed from: L0 */
    public Task<Void> m7321L0(boolean z2) {
        f13918j.m7159a(1, "STOP:", "scheduled. State:", this.f13922n.f14028f);
        m7323N0(z2);
        m7322M0(z2);
        Task taskM7368f = this.f13922n.m7368f(EnumC5178e.ENGINE, EnumC5178e.OFF, !z2, new CallableC5140n(this));
        C5139m c5139m = new C5139m(this);
        C4358c0 c4358c0 = (C4358c0) taskM7368f;
        Objects.requireNonNull(c4358c0);
        c4358c0.mo6012g(C4363g.f11479a, c5139m);
        return c4358c0;
    }

    @NonNull
    /* JADX INFO: renamed from: M */
    public abstract EnumC5126m mo7267M();

    @NonNull
    /* JADX INFO: renamed from: M0 */
    public final Task<Void> m7322M0(boolean z2) {
        return this.f13922n.m7368f(EnumC5178e.BIND, EnumC5178e.ENGINE, !z2, new f());
    }

    /* JADX INFO: renamed from: N */
    public abstract float mo7268N();

    @NonNull
    /* JADX INFO: renamed from: N0 */
    public final Task<Void> m7323N0(boolean z2) {
        return this.f13922n.m7368f(EnumC5178e.PREVIEW, EnumC5178e.BIND, !z2, new b());
    }

    /* JADX INFO: renamed from: O */
    public final boolean m7324O() {
        boolean z2;
        C5179f c5179f = this.f13922n;
        synchronized (c5179f.f14009e) {
            for (C5174a.c<?> cVar : c5179f.f14007c) {
                if (cVar.f14011a.contains(" >> ") || cVar.f14011a.contains(" << ")) {
                    if (!cVar.f14012b.f20845a.mo6020o()) {
                        z2 = true;
                    }
                }
            }
            z2 = false;
        }
        return z2;
    }

    /* JADX INFO: renamed from: O0 */
    public abstract void mo7269O0(@NonNull C5113l.a aVar);

    @NonNull
    /* JADX INFO: renamed from: P */
    public abstract Task<Void> mo7193P();

    /* JADX INFO: renamed from: P0 */
    public abstract void mo7270P0(@NonNull C5113l.a aVar);

    @NonNull
    /* JADX INFO: renamed from: Q */
    public abstract Task<AbstractC5104c> mo7194Q();

    @NonNull
    /* JADX INFO: renamed from: R */
    public abstract Task<Void> mo7195R();

    @NonNull
    /* JADX INFO: renamed from: S */
    public abstract Task<Void> mo7196S();

    @NonNull
    /* JADX INFO: renamed from: T */
    public abstract Task<Void> mo7197T();

    @NonNull
    /* JADX INFO: renamed from: U */
    public abstract Task<Void> mo7199U();

    /* JADX INFO: renamed from: V */
    public final void m7325V() {
        f13918j.m7159a(1, "onSurfaceAvailable:", "Size is", mo7315z().m7432l());
        m7319J0();
        m7320K0();
    }

    /* JADX INFO: renamed from: W */
    public final void m7326W(boolean z2) {
        C5206g c5206g = this.f13919k;
        if (c5206g != null) {
            HandlerThread handlerThread = c5206g.f14131e;
            if (handlerThread.isAlive()) {
                handlerThread.interrupt();
                handlerThread.quit();
            }
            C5206g.f14128b.remove(c5206g.f14130d);
        }
        C5206g c5206gM7403b = C5206g.m7403b("CameraViewEngine");
        this.f13919k = c5206gM7403b;
        c5206gM7403b.f14131e.setUncaughtExceptionHandler(new h(null));
        if (z2) {
            C5179f c5179f = this.f13922n;
            synchronized (c5179f.f14009e) {
                HashSet hashSet = new HashSet();
                Iterator<C5174a.c<?>> it = c5179f.f14007c.iterator();
                while (it.hasNext()) {
                    hashSet.add(it.next().f14011a);
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    c5179f.m7366e((String) it2.next(), 0);
                }
            }
        }
    }

    /* JADX INFO: renamed from: X */
    public void m7327X() {
        f13918j.m7159a(1, "RESTART:", "scheduled. State:", this.f13922n.f14028f);
        m7321L0(false);
        m7318H0();
    }

    @NonNull
    /* JADX INFO: renamed from: Y */
    public Task<Void> m7328Y() {
        f13918j.m7159a(1, "RESTART BIND:", "scheduled. State:", this.f13922n.f14028f);
        m7323N0(false);
        m7322M0(false);
        m7319J0();
        return m7320K0();
    }

    /* JADX INFO: renamed from: Z */
    public abstract void mo7276Z(@NonNull EnumC5114a enumC5114a);

    /* JADX INFO: renamed from: a0 */
    public abstract void mo7277a0(int i2);

    /* JADX INFO: renamed from: b0 */
    public abstract void mo7279b0(@NonNull EnumC5115b enumC5115b);

    /* JADX INFO: renamed from: c */
    public abstract boolean mo7205c(@NonNull EnumC5118e enumC5118e);

    /* JADX INFO: renamed from: c0 */
    public abstract void mo7280c0(long j);

    /* JADX INFO: renamed from: d */
    public final void m7329d(boolean z2, int i2) {
        C5103b c5103b = f13918j;
        c5103b.m7159a(1, "DESTROY:", "state:", this.f13922n.f14028f, "thread:", Thread.currentThread(), "depth:", Integer.valueOf(i2), "unrecoverably:", Boolean.valueOf(z2));
        if (z2) {
            this.f13919k.f14131e.setUncaughtExceptionHandler(new i(null));
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        m7321L0(true).mo6008c(this.f13919k.f14133g, new d(this, countDownLatch));
        try {
            if (!countDownLatch.await(6L, TimeUnit.SECONDS)) {
                c5103b.m7159a(3, "DESTROY: Could not destroy synchronously after 6 seconds.", "Current thread:", Thread.currentThread(), "Handler thread:", this.f13919k.f14131e);
                int i3 = i2 + 1;
                if (i3 < 2) {
                    m7326W(true);
                    c5103b.m7159a(3, "DESTROY: Trying again on thread:", this.f13919k.f14131e);
                    m7329d(z2, i3);
                } else {
                    c5103b.m7159a(2, "DESTROY: Giving up because DESTROY_RETRIES was reached.");
                }
            }
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: renamed from: d0 */
    public abstract void mo7207d0(float f2, @NonNull float[] fArr, @Nullable PointF[] pointFArr, boolean z2);

    @NonNull
    /* JADX INFO: renamed from: e */
    public abstract C5170a mo7281e();

    /* JADX INFO: renamed from: e0 */
    public abstract void mo7282e0(@NonNull EnumC5118e enumC5118e);

    @NonNull
    /* JADX INFO: renamed from: f */
    public abstract EnumC5114a mo7283f();

    /* JADX INFO: renamed from: f0 */
    public abstract void mo7210f0(@NonNull EnumC5119f enumC5119f);

    /* JADX INFO: renamed from: g */
    public abstract int mo7284g();

    /* JADX INFO: renamed from: g0 */
    public abstract void mo7212g0(int i2);

    @NonNull
    /* JADX INFO: renamed from: h */
    public abstract EnumC5115b mo7285h();

    /* JADX INFO: renamed from: h0 */
    public abstract void mo7286h0(int i2);

    /* JADX INFO: renamed from: i */
    public abstract long mo7287i();

    /* JADX INFO: renamed from: i0 */
    public abstract void mo7288i0(int i2);

    @Nullable
    /* JADX INFO: renamed from: j */
    public abstract AbstractC5104c mo7289j();

    /* JADX INFO: renamed from: j0 */
    public abstract void mo7290j0(int i2);

    /* JADX INFO: renamed from: k */
    public abstract float mo7291k();

    /* JADX INFO: renamed from: k0 */
    public abstract void mo7217k0(boolean z2);

    @NonNull
    /* JADX INFO: renamed from: l */
    public abstract EnumC5118e mo7292l();

    /* JADX INFO: renamed from: l0 */
    public abstract void mo7219l0(@NonNull EnumC5121h enumC5121h);

    @NonNull
    /* JADX INFO: renamed from: m */
    public abstract EnumC5119f mo7293m();

    /* JADX INFO: renamed from: m0 */
    public abstract void mo7221m0(@Nullable Location location);

    /* JADX INFO: renamed from: n */
    public abstract int mo7294n();

    /* JADX INFO: renamed from: n0 */
    public abstract void mo7295n0(@NonNull EnumC5122i enumC5122i);

    /* JADX INFO: renamed from: o */
    public abstract int mo7296o();

    /* JADX INFO: renamed from: o0 */
    public abstract void mo7297o0(@Nullable InterfaceC5213a interfaceC5213a);

    /* JADX INFO: renamed from: p */
    public abstract int mo7298p();

    /* JADX INFO: renamed from: p0 */
    public abstract void mo7223p0(@NonNull EnumC5123j enumC5123j);

    /* JADX INFO: renamed from: q */
    public abstract int mo7299q();

    /* JADX INFO: renamed from: q0 */
    public abstract void mo7300q0(boolean z2);

    @NonNull
    /* JADX INFO: renamed from: r */
    public abstract EnumC5121h mo7301r();

    /* JADX INFO: renamed from: r0 */
    public abstract void mo7302r0(@NonNull InterfaceC5237c interfaceC5237c);

    @Nullable
    /* JADX INFO: renamed from: s */
    public abstract Location mo7303s();

    /* JADX INFO: renamed from: s0 */
    public abstract void mo7304s0(boolean z2);

    @NonNull
    /* JADX INFO: renamed from: t */
    public abstract EnumC5122i mo7305t();

    /* JADX INFO: renamed from: t0 */
    public abstract void mo7224t0(boolean z2);

    @NonNull
    /* JADX INFO: renamed from: u */
    public abstract EnumC5123j mo7306u();

    /* JADX INFO: renamed from: u0 */
    public abstract void mo7307u0(@NonNull AbstractC5225a abstractC5225a);

    /* JADX INFO: renamed from: v */
    public abstract boolean mo7308v();

    /* JADX INFO: renamed from: v0 */
    public abstract void mo7225v0(float f2);

    @Nullable
    /* JADX INFO: renamed from: w */
    public abstract C5236b mo7309w(@NonNull EnumC5171b enumC5171b);

    /* JADX INFO: renamed from: w0 */
    public abstract void mo7310w0(boolean z2);

    @NonNull
    /* JADX INFO: renamed from: x */
    public abstract InterfaceC5237c mo7311x();

    /* JADX INFO: renamed from: x0 */
    public abstract void mo7312x0(@Nullable InterfaceC5237c interfaceC5237c);

    /* JADX INFO: renamed from: y */
    public abstract boolean mo7313y();

    /* JADX INFO: renamed from: y0 */
    public abstract void mo7314y0(int i2);

    @Nullable
    /* JADX INFO: renamed from: z */
    public abstract AbstractC5225a mo7315z();

    /* JADX INFO: renamed from: z0 */
    public abstract void mo7316z0(int i2);
}
