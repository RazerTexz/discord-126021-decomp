package p007b.p225i.p226a.p242c.p243a3;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.a3.b0 */
/* JADX INFO: compiled from: MediaSourceEventListener.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC2532b0 {
    /* JADX INFO: renamed from: X */
    void mo2461X(int i, @Nullable InterfaceC2530a0.a aVar, C2566t c2566t, C2569w c2569w);

    /* JADX INFO: renamed from: g0 */
    void mo2462g0(int i, @Nullable InterfaceC2530a0.a aVar, C2566t c2566t, C2569w c2569w, IOException iOException, boolean z2);

    /* JADX INFO: renamed from: o */
    void mo2463o(int i, @Nullable InterfaceC2530a0.a aVar, C2569w c2569w);

    /* JADX INFO: renamed from: q */
    void mo2464q(int i, @Nullable InterfaceC2530a0.a aVar, C2566t c2566t, C2569w c2569w);

    /* JADX INFO: renamed from: x */
    void mo2465x(int i, @Nullable InterfaceC2530a0.a aVar, C2566t c2566t, C2569w c2569w);

    /* JADX INFO: renamed from: b.i.a.c.a3.b0$a */
    /* JADX INFO: compiled from: MediaSourceEventListener.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        public final int f5481a;

        /* JADX INFO: renamed from: b */
        @Nullable
        public final InterfaceC2530a0.a f5482b;

        /* JADX INFO: renamed from: c */
        public final CopyOnWriteArrayList<C13222a> f5483c;

        /* JADX INFO: renamed from: d */
        public final long f5484d;

        /* JADX INFO: renamed from: b.i.a.c.a3.b0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MediaSourceEventListener.java */
        public static final class C13222a {

            /* JADX INFO: renamed from: a */
            public Handler f5485a;

            /* JADX INFO: renamed from: b */
            public InterfaceC2532b0 f5486b;

            public C13222a(Handler handler, InterfaceC2532b0 interfaceC2532b0) {
                this.f5485a = handler;
                this.f5486b = interfaceC2532b0;
            }
        }

        public a() {
            this.f5483c = new CopyOnWriteArrayList<>();
            this.f5481a = 0;
            this.f5482b = null;
            this.f5484d = 0L;
        }

        /* JADX INFO: renamed from: a */
        public final long m2466a(long j) {
            long jM2992M = C2738e0.m2992M(j);
            if (jM2992M == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f5484d + jM2992M;
        }

        /* JADX INFO: renamed from: b */
        public void m2467b(final C2569w c2569w) {
            for (C13222a c13222a : this.f5483c) {
                final InterfaceC2532b0 interfaceC2532b0 = c13222a.f5486b;
                C2738e0.m2984E(c13222a.f5485a, new Runnable() { // from class: b.i.a.c.a3.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        InterfaceC2532b0.a aVar = this.f5491j;
                        interfaceC2532b0.mo2463o(aVar.f5481a, aVar.f5482b, c2569w);
                    }
                });
            }
        }

        /* JADX INFO: renamed from: c */
        public void m2468c(final C2566t c2566t, final C2569w c2569w) {
            for (C13222a c13222a : this.f5483c) {
                final InterfaceC2532b0 interfaceC2532b0 = c13222a.f5486b;
                C2738e0.m2984E(c13222a.f5485a, new Runnable() { // from class: b.i.a.c.a3.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        InterfaceC2532b0.a aVar = this.f5561j;
                        interfaceC2532b0.mo2464q(aVar.f5481a, aVar.f5482b, c2566t, c2569w);
                    }
                });
            }
        }

        /* JADX INFO: renamed from: d */
        public void m2469d(final C2566t c2566t, final C2569w c2569w) {
            for (C13222a c13222a : this.f5483c) {
                final InterfaceC2532b0 interfaceC2532b0 = c13222a.f5486b;
                C2738e0.m2984E(c13222a.f5485a, new Runnable() { // from class: b.i.a.c.a3.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        InterfaceC2532b0.a aVar = this.f5487j;
                        interfaceC2532b0.mo2461X(aVar.f5481a, aVar.f5482b, c2566t, c2569w);
                    }
                });
            }
        }

        /* JADX INFO: renamed from: e */
        public void m2470e(final C2566t c2566t, final C2569w c2569w, final IOException iOException, final boolean z2) {
            for (C13222a c13222a : this.f5483c) {
                final InterfaceC2532b0 interfaceC2532b0 = c13222a.f5486b;
                C2738e0.m2984E(c13222a.f5485a, new Runnable() { // from class: b.i.a.c.a3.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        InterfaceC2532b0.a aVar = this.f5475j;
                        interfaceC2532b0.mo2462g0(aVar.f5481a, aVar.f5482b, c2566t, c2569w, iOException, z2);
                    }
                });
            }
        }

        /* JADX INFO: renamed from: f */
        public void m2471f(final C2566t c2566t, final C2569w c2569w) {
            for (C13222a c13222a : this.f5483c) {
                final InterfaceC2532b0 interfaceC2532b0 = c13222a.f5486b;
                C2738e0.m2984E(c13222a.f5485a, new Runnable() { // from class: b.i.a.c.a3.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        InterfaceC2532b0.a aVar = this.f5494j;
                        interfaceC2532b0.mo2465x(aVar.f5481a, aVar.f5482b, c2566t, c2569w);
                    }
                });
            }
        }

        @CheckResult
        /* JADX INFO: renamed from: g */
        public a m2472g(int i, @Nullable InterfaceC2530a0.a aVar, long j) {
            return new a(this.f5483c, i, aVar, j);
        }

        public a(CopyOnWriteArrayList<C13222a> copyOnWriteArrayList, int i, @Nullable InterfaceC2530a0.a aVar, long j) {
            this.f5483c = copyOnWriteArrayList;
            this.f5481a = i;
            this.f5482b = aVar;
            this.f5484d = j;
        }
    }
}
