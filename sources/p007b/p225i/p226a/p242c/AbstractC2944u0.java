package p007b.p225i.p226a.p242c;

/* JADX INFO: renamed from: b.i.a.c.u0 */
/* JADX INFO: compiled from: BasePlayer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2944u0 implements InterfaceC3128y1 {

    /* JADX INFO: renamed from: a */
    public final AbstractC2832o2.c f7863a = new AbstractC2832o2.c();

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: D */
    public final boolean mo3518D(int i) {
        return mo2906i().f9033k.f6733a.get(i);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: O */
    public final void mo3519O() {
        if (mo2888K().m3331q() || mo2900f()) {
            return;
        }
        if (m3523W()) {
            int iM3528b = m3528b();
            if (iM3528b != -1) {
                mo2904h(iM3528b, -9223372036854775807L);
                return;
            }
            return;
        }
        if (m3526Z() && m3525Y()) {
            mo2904h(mo2881C(), -9223372036854775807L);
        }
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: P */
    public final void mo3520P() {
        m3530c0(mo2927v());
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: R */
    public final void mo3521R() {
        m3530c0(-mo2895U());
    }

    /* JADX INFO: renamed from: V */
    public final int m3522V() {
        AbstractC2832o2 abstractC2832o2Mo2888K = mo2888K();
        if (abstractC2832o2Mo2888K.m3331q()) {
            return -1;
        }
        int iMo2881C = mo2881C();
        int iMo2886I = mo2886I();
        if (iMo2886I == 1) {
            iMo2886I = 0;
        }
        return abstractC2832o2Mo2888K.mo2585l(iMo2881C, iMo2886I, mo2890M());
    }

    /* JADX INFO: renamed from: W */
    public final boolean m3523W() {
        return m3528b() != -1;
    }

    /* JADX INFO: renamed from: X */
    public final boolean m3524X() {
        return m3522V() != -1;
    }

    /* JADX INFO: renamed from: Y */
    public final boolean m3525Y() {
        AbstractC2832o2 abstractC2832o2Mo2888K = mo2888K();
        return !abstractC2832o2Mo2888K.m3331q() && abstractC2832o2Mo2888K.m3330n(mo2881C(), this.f7863a).f7361v;
    }

    /* JADX INFO: renamed from: Z */
    public final boolean m3526Z() {
        AbstractC2832o2 abstractC2832o2Mo2888K = mo2888K();
        return !abstractC2832o2Mo2888K.m3331q() && abstractC2832o2Mo2888K.m3330n(mo2881C(), this.f7863a).m3341c();
    }

    /* JADX INFO: renamed from: a0 */
    public final boolean m3527a0() {
        AbstractC2832o2 abstractC2832o2Mo2888K = mo2888K();
        return !abstractC2832o2Mo2888K.m3331q() && abstractC2832o2Mo2888K.m3330n(mo2881C(), this.f7863a).f7360u;
    }

    /* JADX INFO: renamed from: b */
    public final int m3528b() {
        AbstractC2832o2 abstractC2832o2Mo2888K = mo2888K();
        if (abstractC2832o2Mo2888K.m3331q()) {
            return -1;
        }
        int iMo2881C = mo2881C();
        int iMo2886I = mo2886I();
        if (iMo2886I == 1) {
            iMo2886I = 0;
        }
        return abstractC2832o2Mo2888K.mo2584e(iMo2881C, iMo2886I, mo2890M());
    }

    /* JADX INFO: renamed from: b0 */
    public final void m3529b0(long j) {
        mo2904h(mo2881C(), j);
    }

    /* JADX INFO: renamed from: c0 */
    public final void m3530c0(long j) {
        long jMo2894T = mo2894T() + j;
        long jMo2887J = mo2887J();
        if (jMo2887J != -9223372036854775807L) {
            jMo2894T = Math.min(jMo2894T, jMo2887J);
        }
        m3529b0(Math.max(jMo2894T, 0L));
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: d */
    public final void mo3531d() {
        mo2926u(false);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: e */
    public final void mo3532e() {
        mo2926u(true);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: s */
    public final void mo3533s() {
        int iM3522V;
        if (mo2888K().m3331q() || mo2900f()) {
            return;
        }
        boolean zM3524X = m3524X();
        if (m3526Z() && !m3527a0()) {
            if (!zM3524X || (iM3522V = m3522V()) == -1) {
                return;
            }
            mo2904h(iM3522V, -9223372036854775807L);
            return;
        }
        if (!zM3524X || mo2894T() > mo2910l()) {
            m3529b0(0L);
            return;
        }
        int iM3522V2 = m3522V();
        if (iM3522V2 != -1) {
            mo2904h(iM3522V2, -9223372036854775807L);
        }
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: z */
    public final boolean mo3534z() {
        return mo2930y() == 3 && mo2908j() && mo2884G() == 0;
    }
}
