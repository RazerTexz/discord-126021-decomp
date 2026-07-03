package p007b.p225i.p226a.p242c.p267x2.p271f0;

import p007b.p225i.p226a.p242c.p267x2.C3120u;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;

/* JADX INFO: renamed from: b.i.a.c.x2.f0.d */
/* JADX INFO: compiled from: StartOffsetExtractorOutput.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3021d implements InterfaceC3058j {

    /* JADX INFO: renamed from: j */
    public final long f8172j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC3058j f8173k;

    /* JADX INFO: renamed from: b.i.a.c.x2.f0.d$a */
    /* JADX INFO: compiled from: StartOffsetExtractorOutput.java */
    public class a implements InterfaceC3119t {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ InterfaceC3119t f8174a;

        public a(InterfaceC3119t interfaceC3119t) {
            this.f8174a = interfaceC3119t;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
        /* JADX INFO: renamed from: c */
        public boolean mo3619c() {
            return this.f8174a.mo3619c();
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
        /* JADX INFO: renamed from: h */
        public InterfaceC3119t.a mo3620h(long j) {
            InterfaceC3119t.a aVarMo3620h = this.f8174a.mo3620h(j);
            C3120u c3120u = aVarMo3620h.f8993a;
            long j2 = c3120u.f8998b;
            long j3 = c3120u.f8999c;
            long j4 = C3021d.this.f8172j;
            C3120u c3120u2 = new C3120u(j2, j3 + j4);
            C3120u c3120u3 = aVarMo3620h.f8994b;
            return new InterfaceC3119t.a(c3120u2, new C3120u(c3120u3.f8998b, c3120u3.f8999c + j4));
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t
        /* JADX INFO: renamed from: i */
        public long mo3621i() {
            return this.f8174a.mo3621i();
        }
    }

    public C3021d(long j, InterfaceC3058j interfaceC3058j) {
        this.f8172j = j;
        this.f8173k = interfaceC3058j;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j
    /* JADX INFO: renamed from: a */
    public void mo2477a(InterfaceC3119t interfaceC3119t) {
        this.f8173k.mo2477a(new a(interfaceC3119t));
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j
    /* JADX INFO: renamed from: j */
    public void mo2486j() {
        this.f8173k.mo2486j();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j
    /* JADX INFO: renamed from: p */
    public InterfaceC3122w mo2492p(int i, int i2) {
        return this.f8173k.mo2492p(i, i2);
    }
}
