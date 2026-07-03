package p007b.p225i.p226a.p242c.p243a3;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.upstream.Loader;
import java.util.Objects;
import p007b.p225i.p226a.p242c.AbstractC2832o2;
import p007b.p225i.p226a.p242c.C2831o1;
import p007b.p225i.p226a.p242c.p243a3.C2538e0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2536d0;
import p007b.p225i.p226a.p242c.p257e3.C2713o;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2680a0;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2721w;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2990u;

/* JADX INFO: renamed from: b.i.a.c.a3.f0 */
/* JADX INFO: compiled from: ProgressiveMediaSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2540f0 extends AbstractC2551l implements C2538e0.b {

    /* JADX INFO: renamed from: g */
    public final C2831o1 f5565g;

    /* JADX INFO: renamed from: h */
    public final C2831o1.h f5566h;

    /* JADX INFO: renamed from: i */
    public final InterfaceC2710l.a f5567i;

    /* JADX INFO: renamed from: j */
    public final InterfaceC2536d0.a f5568j;

    /* JADX INFO: renamed from: k */
    public final InterfaceC2990u f5569k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC2721w f5570l;

    /* JADX INFO: renamed from: m */
    public final int f5571m;

    /* JADX INFO: renamed from: n */
    public boolean f5572n;

    /* JADX INFO: renamed from: o */
    public long f5573o;

    /* JADX INFO: renamed from: p */
    public boolean f5574p;

    /* JADX INFO: renamed from: q */
    public boolean f5575q;

    /* JADX INFO: renamed from: r */
    @Nullable
    public InterfaceC2680a0 f5576r;

    /* JADX INFO: renamed from: b.i.a.c.a3.f0$a */
    /* JADX INFO: compiled from: ProgressiveMediaSource.java */
    public class a extends AbstractC2564r {
        public a(AbstractC2832o2 abstractC2832o2) {
            super(abstractC2832o2);
        }

        @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
        /* JADX INFO: renamed from: g */
        public AbstractC2832o2.b mo2513g(int i, AbstractC2832o2.b bVar, boolean z2) {
            this.f5697k.mo2513g(i, bVar, z2);
            bVar.f7343o = true;
            return bVar;
        }

        @Override // p007b.p225i.p226a.p242c.AbstractC2832o2
        /* JADX INFO: renamed from: o */
        public AbstractC2832o2.c mo2514o(int i, AbstractC2832o2.c cVar, long j) {
            this.f5697k.mo2514o(i, cVar, j);
            cVar.f7364y = true;
            return cVar;
        }
    }

    public C2540f0(C2831o1 c2831o1, InterfaceC2710l.a aVar, InterfaceC2536d0.a aVar2, InterfaceC2990u interfaceC2990u, InterfaceC2721w interfaceC2721w, int i, a aVar3) {
        C2831o1.h hVar = c2831o1.f7263l;
        Objects.requireNonNull(hVar);
        this.f5566h = hVar;
        this.f5565g = c2831o1;
        this.f5567i = aVar;
        this.f5568j = aVar2;
        this.f5569k = interfaceC2990u;
        this.f5570l = interfaceC2721w;
        this.f5571m = i;
        this.f5572n = true;
        this.f5573o = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0
    /* JADX INFO: renamed from: e */
    public C2831o1 mo2450e() {
        return this.f5565g;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0
    /* JADX INFO: renamed from: h */
    public void mo2453h() {
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0
    /* JADX INFO: renamed from: j */
    public void mo2455j(InterfaceC2570x interfaceC2570x) {
        C2538e0 c2538e0 = (C2538e0) interfaceC2570x;
        if (c2538e0.f5506G) {
            for (C2544h0 c2544h0 : c2538e0.f5503D) {
                c2544h0.m2529h();
                DrmSession drmSession = c2544h0.f5604i;
                if (drmSession != null) {
                    drmSession.mo3607b(c2544h0.f5600e);
                    c2544h0.f5604i = null;
                    c2544h0.f5603h = null;
                }
            }
        }
        Loader loader = c2538e0.f5533v;
        Loader.HandlerC10769d<? extends Loader.InterfaceC10770e> handlerC10769d = loader.f20232d;
        if (handlerC10769d != null) {
            handlerC10769d.m8941a(true);
        }
        loader.f20231c.execute(new Loader.RunnableC10772g(c2538e0));
        loader.f20231c.shutdown();
        c2538e0.f5500A.removeCallbacksAndMessages(null);
        c2538e0.f5501B = null;
        c2538e0.f5522W = true;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0
    /* JADX INFO: renamed from: n */
    public InterfaceC2570x mo2459n(InterfaceC2530a0.a aVar, C2713o c2713o, long j) {
        InterfaceC2710l interfaceC2710lMo234a = this.f5567i.mo234a();
        InterfaceC2680a0 interfaceC2680a0 = this.f5576r;
        if (interfaceC2680a0 != null) {
            interfaceC2710lMo234a.mo2587d(interfaceC2680a0);
        }
        return new C2538e0(this.f5566h.f7318a, interfaceC2710lMo234a, new C2553m(((C2547j) this.f5568j).f5628a), this.f5569k, this.f5636d.m3593g(0, aVar), this.f5570l, this.f5635c.m2472g(0, aVar, 0L), this, c2713o, this.f5566h.f7322e, this.f5571m);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.AbstractC2551l
    /* JADX INFO: renamed from: q */
    public void mo2509q(@Nullable InterfaceC2680a0 interfaceC2680a0) {
        this.f5576r = interfaceC2680a0;
        this.f5569k.mo3597a();
        m2511t();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.AbstractC2551l
    /* JADX INFO: renamed from: s */
    public void mo2510s() {
        this.f5569k.release();
    }

    /* JADX INFO: renamed from: t */
    public final void m2511t() {
        AbstractC2832o2 c2552l0 = new C2552l0(this.f5573o, this.f5574p, false, this.f5575q, null, this.f5565g);
        if (this.f5572n) {
            c2552l0 = new a(c2552l0);
        }
        m2553r(c2552l0);
    }

    /* JADX INFO: renamed from: u */
    public void m2512u(long j, boolean z2, boolean z3) {
        if (j == -9223372036854775807L) {
            j = this.f5573o;
        }
        if (!this.f5572n && this.f5573o == j && this.f5574p == z2 && this.f5575q == z3) {
            return;
        }
        this.f5573o = j;
        this.f5574p = z2;
        this.f5575q = z3;
        this.f5572n = false;
        m2511t();
    }
}
