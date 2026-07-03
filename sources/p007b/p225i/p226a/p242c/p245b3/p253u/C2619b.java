package p007b.p225i.p226a.p242c.p245b3.p253u;

import java.util.Collections;
import java.util.List;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p245b3.C2578b;
import p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g;

/* JADX INFO: renamed from: b.i.a.c.b3.u.b */
/* JADX INFO: compiled from: Tx3gSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2619b implements InterfaceC2583g {

    /* JADX INFO: renamed from: j */
    public static final C2619b f6104j = new C2619b();

    /* JADX INFO: renamed from: k */
    public final List<C2578b> f6105k;

    public C2619b(C2578b c2578b) {
        this.f6105k = Collections.singletonList(c2578b);
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
    /* JADX INFO: renamed from: f */
    public int mo2612f(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
    /* JADX INFO: renamed from: g */
    public long mo2613g(int i) {
        C1460d.m531j(i == 0);
        return 0L;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
    /* JADX INFO: renamed from: h */
    public List<C2578b> mo2614h(long j) {
        return j >= 0 ? this.f6105k : Collections.emptyList();
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
    /* JADX INFO: renamed from: i */
    public int mo2615i() {
        return 1;
    }

    public C2619b() {
        this.f6105k = Collections.emptyList();
    }
}
