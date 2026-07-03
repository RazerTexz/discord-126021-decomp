package p007b.p225i.p226a.p242c;

import androidx.annotation.Nullable;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p259f3.C2759z;
import p007b.p225i.p226a.p242c.p259f3.InterfaceC2740g;
import p007b.p225i.p226a.p242c.p259f3.InterfaceC2752s;

/* JADX INFO: renamed from: b.i.a.c.a1 */
/* JADX INFO: compiled from: DefaultMediaClock.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2527a1 implements InterfaceC2752s {

    /* JADX INFO: renamed from: j */
    public final C2759z f5467j;

    /* JADX INFO: renamed from: k */
    public final a f5468k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public InterfaceC2728f2 f5469l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public InterfaceC2752s f5470m;

    /* JADX INFO: renamed from: n */
    public boolean f5471n = true;

    /* JADX INFO: renamed from: o */
    public boolean f5472o;

    /* JADX INFO: renamed from: b.i.a.c.a1$a */
    /* JADX INFO: compiled from: DefaultMediaClock.java */
    public interface a {
    }

    public C2527a1(a aVar, InterfaceC2740g interfaceC2740g) {
        this.f5468k = aVar;
        this.f5467j = new C2759z(interfaceC2740g);
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.InterfaceC2752s
    /* JADX INFO: renamed from: c */
    public C2998x1 mo2416c() {
        InterfaceC2752s interfaceC2752s = this.f5470m;
        return interfaceC2752s != null ? interfaceC2752s.mo2416c() : this.f5467j.f6804n;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.InterfaceC2752s
    /* JADX INFO: renamed from: e */
    public long mo2417e() {
        if (this.f5471n) {
            return this.f5467j.mo2417e();
        }
        InterfaceC2752s interfaceC2752s = this.f5470m;
        Objects.requireNonNull(interfaceC2752s);
        return interfaceC2752s.mo2417e();
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.InterfaceC2752s
    /* JADX INFO: renamed from: i */
    public void mo2418i(C2998x1 c2998x1) {
        InterfaceC2752s interfaceC2752s = this.f5470m;
        if (interfaceC2752s != null) {
            interfaceC2752s.mo2418i(c2998x1);
            c2998x1 = this.f5470m.mo2416c();
        }
        this.f5467j.mo2418i(c2998x1);
    }
}
