package p007b.p225i.p226a.p242c.p245b3;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p265v2.AbstractC2958f;

/* JADX INFO: renamed from: b.i.a.c.b3.k */
/* JADX INFO: compiled from: SubtitleOutputBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2587k extends AbstractC2958f implements InterfaceC2583g {

    /* JADX INFO: renamed from: l */
    @Nullable
    public InterfaceC2583g f5801l;

    /* JADX INFO: renamed from: m */
    public long f5802m;

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
    /* JADX INFO: renamed from: f */
    public int mo2612f(long j) {
        InterfaceC2583g interfaceC2583g = this.f5801l;
        Objects.requireNonNull(interfaceC2583g);
        return interfaceC2583g.mo2612f(j - this.f5802m);
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
    /* JADX INFO: renamed from: g */
    public long mo2613g(int i) {
        InterfaceC2583g interfaceC2583g = this.f5801l;
        Objects.requireNonNull(interfaceC2583g);
        return interfaceC2583g.mo2613g(i) + this.f5802m;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
    /* JADX INFO: renamed from: h */
    public List<C2578b> mo2614h(long j) {
        InterfaceC2583g interfaceC2583g = this.f5801l;
        Objects.requireNonNull(interfaceC2583g);
        return interfaceC2583g.mo2614h(j - this.f5802m);
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
    /* JADX INFO: renamed from: i */
    public int mo2615i() {
        InterfaceC2583g interfaceC2583g = this.f5801l;
        Objects.requireNonNull(interfaceC2583g);
        return interfaceC2583g.mo2615i();
    }

    /* JADX INFO: renamed from: q */
    public void m2618q() {
        this.f7901j = 0;
        this.f5801l = null;
    }

    /* JADX INFO: renamed from: r */
    public void m2619r(long j, InterfaceC2583g interfaceC2583g, long j2) {
        this.f7925k = j;
        this.f5801l = interfaceC2583g;
        if (j2 != RecyclerView.FOREVER_NS) {
            j = j2;
        }
        this.f5802m = j;
    }
}
