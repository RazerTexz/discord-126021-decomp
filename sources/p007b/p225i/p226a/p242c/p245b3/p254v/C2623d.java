package p007b.p225i.p226a.p242c.p245b3.p254v;

import java.util.Collections;
import java.util.List;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p245b3.C2578b;
import p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g;

/* JADX INFO: renamed from: b.i.a.c.b3.v.d */
/* JADX INFO: compiled from: Mp4WebvttSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2623d implements InterfaceC2583g {

    /* JADX INFO: renamed from: j */
    public final List<C2578b> f6109j;

    public C2623d(List<C2578b> list) {
        this.f6109j = Collections.unmodifiableList(list);
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
        return j >= 0 ? this.f6109j : Collections.emptyList();
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
    /* JADX INFO: renamed from: i */
    public int mo2615i() {
        return 1;
    }
}
