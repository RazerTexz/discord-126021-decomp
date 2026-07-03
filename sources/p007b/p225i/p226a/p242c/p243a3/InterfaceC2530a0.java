package p007b.p225i.p226a.p242c.p243a3;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.io.IOException;
import p007b.p225i.p226a.p242c.AbstractC2832o2;
import p007b.p225i.p226a.p242c.C2831o1;
import p007b.p225i.p226a.p242c.p257e3.C2713o;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2680a0;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s;

/* JADX INFO: renamed from: b.i.a.c.a3.a0 */
/* JADX INFO: compiled from: MediaSource.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC2530a0 {

    /* JADX INFO: renamed from: b.i.a.c.a3.a0$a */
    /* JADX INFO: compiled from: MediaSource.java */
    public static final class a extends C2571y {
        public a(Object obj) {
            super(obj);
        }

        /* JADX INFO: renamed from: b */
        public a m2460b(Object obj) {
            return new a(this.f5732a.equals(obj) ? this : new C2571y(obj, this.f5733b, this.f5734c, this.f5735d, this.f5736e));
        }

        public a(Object obj, long j, int i) {
            super(obj, j, i);
        }

        public a(Object obj, int i, int i2, long j) {
            super(obj, i, i2, j);
        }

        public a(C2571y c2571y) {
            super(c2571y);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.a0$b */
    /* JADX INFO: compiled from: MediaSource.java */
    public interface b {
        /* JADX INFO: renamed from: a */
        void mo2445a(InterfaceC2530a0 interfaceC2530a0, AbstractC2832o2 abstractC2832o2);
    }

    /* JADX INFO: renamed from: a */
    void mo2446a(b bVar);

    /* JADX INFO: renamed from: b */
    void mo2447b(Handler handler, InterfaceC2532b0 interfaceC2532b0);

    /* JADX INFO: renamed from: c */
    void mo2448c(InterfaceC2532b0 interfaceC2532b0);

    /* JADX INFO: renamed from: d */
    void mo2449d(b bVar);

    /* JADX INFO: renamed from: e */
    C2831o1 mo2450e();

    /* JADX INFO: renamed from: f */
    void mo2451f(Handler handler, InterfaceC2988s interfaceC2988s);

    /* JADX INFO: renamed from: g */
    void mo2452g(InterfaceC2988s interfaceC2988s);

    /* JADX INFO: renamed from: h */
    void mo2453h() throws IOException;

    /* JADX INFO: renamed from: i */
    boolean mo2454i();

    /* JADX INFO: renamed from: j */
    void mo2455j(InterfaceC2570x interfaceC2570x);

    @Nullable
    /* JADX INFO: renamed from: k */
    AbstractC2832o2 mo2456k();

    /* JADX INFO: renamed from: l */
    void mo2457l(b bVar, @Nullable InterfaceC2680a0 interfaceC2680a0);

    /* JADX INFO: renamed from: m */
    void mo2458m(b bVar);

    /* JADX INFO: renamed from: n */
    InterfaceC2570x mo2459n(a aVar, C2713o c2713o, long j);
}
