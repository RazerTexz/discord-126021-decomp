package p007b.p225i.p226a.p242c.p266w2;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.w2.s */
/* JADX INFO: compiled from: DrmSessionEventListener.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC2988s {
    /* JADX INFO: renamed from: J */
    void mo2567J(int i, @Nullable InterfaceC2530a0.a aVar);

    /* JADX INFO: renamed from: S */
    void mo2568S(int i, @Nullable InterfaceC2530a0.a aVar);

    /* JADX INFO: renamed from: c0 */
    void mo2571c0(int i, @Nullable InterfaceC2530a0.a aVar, int i2);

    /* JADX INFO: renamed from: d0 */
    void mo2572d0(int i, @Nullable InterfaceC2530a0.a aVar);

    /* JADX INFO: renamed from: i0 */
    void mo2573i0(int i, @Nullable InterfaceC2530a0.a aVar);

    /* JADX INFO: renamed from: u */
    void mo2574u(int i, @Nullable InterfaceC2530a0.a aVar, Exception exc);

    /* JADX INFO: renamed from: b.i.a.c.w2.s$a */
    /* JADX INFO: compiled from: DrmSessionEventListener.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        public final int f8012a;

        /* JADX INFO: renamed from: b */
        @Nullable
        public final InterfaceC2530a0.a f8013b;

        /* JADX INFO: renamed from: c */
        public final CopyOnWriteArrayList<C13226a> f8014c;

        /* JADX INFO: renamed from: b.i.a.c.w2.s$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DrmSessionEventListener.java */
        public static final class C13226a {

            /* JADX INFO: renamed from: a */
            public Handler f8015a;

            /* JADX INFO: renamed from: b */
            public InterfaceC2988s f8016b;

            public C13226a(Handler handler, InterfaceC2988s interfaceC2988s) {
                this.f8015a = handler;
                this.f8016b = interfaceC2988s;
            }
        }

        public a() {
            this.f8014c = new CopyOnWriteArrayList<>();
            this.f8012a = 0;
            this.f8013b = null;
        }

        /* JADX INFO: renamed from: a */
        public void m3587a() {
            for (C13226a c13226a : this.f8014c) {
                final InterfaceC2988s interfaceC2988s = c13226a.f8016b;
                C2738e0.m2984E(c13226a.f8015a, new Runnable() { // from class: b.i.a.c.w2.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        InterfaceC2988s.a aVar = this.f7993j;
                        interfaceC2988s.mo2568S(aVar.f8012a, aVar.f8013b);
                    }
                });
            }
        }

        /* JADX INFO: renamed from: b */
        public void m3588b() {
            for (C13226a c13226a : this.f8014c) {
                final InterfaceC2988s interfaceC2988s = c13226a.f8016b;
                C2738e0.m2984E(c13226a.f8015a, new Runnable() { // from class: b.i.a.c.w2.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        InterfaceC2988s.a aVar = this.f7991j;
                        interfaceC2988s.mo2567J(aVar.f8012a, aVar.f8013b);
                    }
                });
            }
        }

        /* JADX INFO: renamed from: c */
        public void m3589c() {
            for (C13226a c13226a : this.f8014c) {
                final InterfaceC2988s interfaceC2988s = c13226a.f8016b;
                C2738e0.m2984E(c13226a.f8015a, new Runnable() { // from class: b.i.a.c.w2.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        InterfaceC2988s.a aVar = this.f7995j;
                        interfaceC2988s.mo2573i0(aVar.f8012a, aVar.f8013b);
                    }
                });
            }
        }

        /* JADX INFO: renamed from: d */
        public void m3590d(final int i) {
            for (C13226a c13226a : this.f8014c) {
                final InterfaceC2988s interfaceC2988s = c13226a.f8016b;
                C2738e0.m2984E(c13226a.f8015a, new Runnable() { // from class: b.i.a.c.w2.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        InterfaceC2988s.a aVar = this.f8000j;
                        InterfaceC2988s interfaceC2988s2 = interfaceC2988s;
                        int i2 = i;
                        Objects.requireNonNull(aVar);
                        Objects.requireNonNull(interfaceC2988s2);
                        interfaceC2988s2.mo2571c0(aVar.f8012a, aVar.f8013b, i2);
                    }
                });
            }
        }

        /* JADX INFO: renamed from: e */
        public void m3591e(final Exception exc) {
            for (C13226a c13226a : this.f8014c) {
                final InterfaceC2988s interfaceC2988s = c13226a.f8016b;
                C2738e0.m2984E(c13226a.f8015a, new Runnable() { // from class: b.i.a.c.w2.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        InterfaceC2988s.a aVar = this.f7997j;
                        interfaceC2988s.mo2574u(aVar.f8012a, aVar.f8013b, exc);
                    }
                });
            }
        }

        /* JADX INFO: renamed from: f */
        public void m3592f() {
            for (C13226a c13226a : this.f8014c) {
                final InterfaceC2988s interfaceC2988s = c13226a.f8016b;
                C2738e0.m2984E(c13226a.f8015a, new Runnable() { // from class: b.i.a.c.w2.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        InterfaceC2988s.a aVar = this.f7989j;
                        interfaceC2988s.mo2572d0(aVar.f8012a, aVar.f8013b);
                    }
                });
            }
        }

        @CheckResult
        /* JADX INFO: renamed from: g */
        public a m3593g(int i, @Nullable InterfaceC2530a0.a aVar) {
            return new a(this.f8014c, i, aVar);
        }

        public a(CopyOnWriteArrayList<C13226a> copyOnWriteArrayList, int i, @Nullable InterfaceC2530a0.a aVar) {
            this.f8014c = copyOnWriteArrayList;
            this.f8012a = i;
            this.f8013b = aVar;
        }
    }
}
