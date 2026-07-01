package b.i.a.c;

import b.i.a.c.Timeline;

/* JADX INFO: renamed from: b.i.a.c.u0, reason: use source file name */
/* JADX INFO: compiled from: BasePlayer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BasePlayer implements Player2 {
    public final Timeline.c a = new Timeline.c();

    @Override // b.i.a.c.Player2
    public final boolean D(int i) {
        return i().k.a.get(i);
    }

    @Override // b.i.a.c.Player2
    public final void O() {
        if (K().q() || f()) {
            return;
        }
        if (W()) {
            int iB = b();
            if (iB != -1) {
                h(iB, -9223372036854775807L);
                return;
            }
            return;
        }
        if (Z() && Y()) {
            h(C(), -9223372036854775807L);
        }
    }

    @Override // b.i.a.c.Player2
    public final void P() {
        c0(v());
    }

    @Override // b.i.a.c.Player2
    public final void R() {
        c0(-U());
    }

    public final int V() {
        Timeline timelineK = K();
        if (timelineK.q()) {
            return -1;
        }
        int iC = C();
        int I = I();
        if (I == 1) {
            I = 0;
        }
        return timelineK.l(iC, I, M());
    }

    public final boolean W() {
        return b() != -1;
    }

    public final boolean X() {
        return V() != -1;
    }

    public final boolean Y() {
        Timeline timelineK = K();
        return !timelineK.q() && timelineK.n(C(), this.a).v;
    }

    public final boolean Z() {
        Timeline timelineK = K();
        return !timelineK.q() && timelineK.n(C(), this.a).c();
    }

    public final boolean a0() {
        Timeline timelineK = K();
        return !timelineK.q() && timelineK.n(C(), this.a).u;
    }

    public final int b() {
        Timeline timelineK = K();
        if (timelineK.q()) {
            return -1;
        }
        int iC = C();
        int I = I();
        if (I == 1) {
            I = 0;
        }
        return timelineK.e(iC, I, M());
    }

    public final void b0(long j) {
        h(C(), j);
    }

    public final void c0(long j) {
        long jT = T() + j;
        long J = J();
        if (J != -9223372036854775807L) {
            jT = Math.min(jT, J);
        }
        b0(Math.max(jT, 0L));
    }

    @Override // b.i.a.c.Player2
    public final void d() {
        u(false);
    }

    @Override // b.i.a.c.Player2
    public final void e() {
        u(true);
    }

    @Override // b.i.a.c.Player2
    public final void s() {
        int iV;
        if (K().q() || f()) {
            return;
        }
        boolean zX = X();
        if (Z() && !a0()) {
            if (!zX || (iV = V()) == -1) {
                return;
            }
            h(iV, -9223372036854775807L);
            return;
        }
        if (!zX || T() > l()) {
            b0(0L);
            return;
        }
        int iV2 = V();
        if (iV2 != -1) {
            h(iV2, -9223372036854775807L);
        }
    }

    @Override // b.i.a.c.Player2
    public final boolean z() {
        return y() == 3 && j() && G() == 0;
    }
}
