package p007b.p008a.p040p;

import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.AbstractC2832o2;
import p007b.p225i.p226a.p242c.C2528a2;
import p007b.p225i.p226a.p242c.C2633c1;
import p007b.p225i.p226a.p242c.C2831o1;
import p007b.p225i.p226a.p242c.C2835p1;
import p007b.p225i.p226a.p242c.C2836p2;
import p007b.p225i.p226a.p242c.C2998x1;
import p007b.p225i.p226a.p242c.C3154z1;
import p007b.p225i.p226a.p242c.InterfaceC3128y1;
import p007b.p225i.p226a.p242c.p243a3.C2558o0;
import p007b.p225i.p226a.p242c.p255c3.C2648n;
import p007b.p225i.p226a.p242c.p260g3.C2788y;
import p507d0.p592z.p594d.C12238m;
import p658rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.p.k */
/* JADX INFO: compiled from: RxPlayerEventListener.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1186k implements InterfaceC3128y1.e {

    /* JADX INFO: renamed from: j */
    public final PublishSubject<c> f1590j = PublishSubject.m11133k0();

    /* JADX INFO: renamed from: k */
    public final PublishSubject<a> f1591k = PublishSubject.m11133k0();

    /* JADX INFO: renamed from: l */
    public final PublishSubject<b> f1592l = PublishSubject.m11133k0();

    /* JADX INFO: renamed from: b.a.p.k$a */
    /* JADX INFO: compiled from: RxPlayerEventListener.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final boolean f1593a;

        public a(boolean z2) {
            this.f1593a = z2;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof a) && this.f1593a == ((a) obj).f1593a;
            }
            return true;
        }

        public int hashCode() {
            boolean z2 = this.f1593a;
            if (z2) {
                return 1;
            }
            return z2 ? 1 : 0;
        }

        public String toString() {
            return C1643a.m827O(C1643a.m833U("IsPlayingChange(isPlaying="), this.f1593a, ")");
        }
    }

    /* JADX INFO: renamed from: b.a.p.k$b */
    /* JADX INFO: compiled from: RxPlayerEventListener.kt */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final PlaybackException f1594a;

        public b(PlaybackException playbackException) {
            C12238m.checkNotNullParameter(playbackException, "exoPlaybackException");
            this.f1594a = playbackException;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof b) && C12238m.areEqual(this.f1594a, ((b) obj).f1594a);
            }
            return true;
        }

        public int hashCode() {
            PlaybackException playbackException = this.f1594a;
            if (playbackException != null) {
                return playbackException.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("PlayerError(exoPlaybackException=");
            sbM833U.append(this.f1594a);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: b.a.p.k$c */
    /* JADX INFO: compiled from: RxPlayerEventListener.kt */
    public static final class c {

        /* JADX INFO: renamed from: a */
        public final int f1595a;

        public c(int i) {
            this.f1595a = i;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof c) && this.f1595a == ((c) obj).f1595a;
            }
            return true;
        }

        public int hashCode() {
            return this.f1595a;
        }

        public String toString() {
            return C1643a.m814B(C1643a.m833U("PlayerStateChange(playbackState="), this.f1595a, ")");
        }
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: A */
    public /* synthetic */ void mo235A(C2835p1 c2835p1) {
        C2528a2.m2427i(this, c2835p1);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: D */
    public /* synthetic */ void mo236D(boolean z2) {
        C2528a2.m2438t(this, z2);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: E */
    public /* synthetic */ void mo237E(InterfaceC3128y1 interfaceC3128y1, InterfaceC3128y1.d dVar) {
        C2528a2.m2423e(this, interfaceC3128y1, dVar);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: G */
    public /* synthetic */ void mo238G(int i, boolean z2) {
        C2528a2.m2422d(this, i, z2);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: H */
    public /* synthetic */ void mo239H(boolean z2, int i) {
        C3154z1.m3883k(this, z2, i);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: L */
    public /* synthetic */ void mo240L(int i) {
        C2528a2.m2437s(this, i);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: M */
    public /* synthetic */ void mo241M(C2831o1 c2831o1, int i) {
        C2528a2.m2426h(this, c2831o1, i);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: W */
    public /* synthetic */ void mo242W(boolean z2, int i) {
        C2528a2.m2429k(this, z2, i);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: Y */
    public /* synthetic */ void mo243Y(C2558o0 c2558o0, C2648n c2648n) {
        C3154z1.m3890r(this, c2558o0, c2648n);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void mo244a() {
        C3154z1.m3887o(this);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: a0 */
    public /* synthetic */ void mo245a0(int i, int i2) {
        C2528a2.m2440v(this, i, i2);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: b */
    public /* synthetic */ void mo246b(Metadata metadata) {
        C2528a2.m2428j(this, metadata);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: b0 */
    public /* synthetic */ void mo247b0(C2998x1 c2998x1) {
        C2528a2.m2430l(this, c2998x1);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: c */
    public /* synthetic */ void mo248c() {
        C2528a2.m2436r(this);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: d */
    public /* synthetic */ void mo249d(boolean z2) {
        C2528a2.m2439u(this, z2);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: e */
    public /* synthetic */ void mo250e(List list) {
        C2528a2.m2420b(this, list);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: f */
    public /* synthetic */ void mo251f(C2788y c2788y) {
        C2528a2.m2443y(this, c2788y);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: f0 */
    public /* synthetic */ void mo252f0(PlaybackException playbackException) {
        C2528a2.m2434p(this, playbackException);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: g */
    public /* synthetic */ void mo253g(InterfaceC3128y1.f fVar, InterfaceC3128y1.f fVar2, int i) {
        C2528a2.m2435q(this, fVar, fVar2, i);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: h */
    public /* synthetic */ void mo254h(int i) {
        C2528a2.m2432n(this, i);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: i */
    public /* synthetic */ void mo255i(boolean z2) {
        C3154z1.m3876d(this, z2);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: j */
    public /* synthetic */ void mo256j(int i) {
        C3154z1.m3884l(this, i);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: j0 */
    public void mo257j0(boolean z2) {
        PublishSubject<a> publishSubject = this.f1591k;
        publishSubject.f27650k.onNext(new a(z2));
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: p */
    public /* synthetic */ void mo258p(C2836p2 c2836p2) {
        C2528a2.m2442x(this, c2836p2);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: r */
    public /* synthetic */ void mo259r(boolean z2) {
        C2528a2.m2424f(this, z2);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: s */
    public void mo260s(PlaybackException playbackException) {
        C12238m.checkNotNullParameter(playbackException, "error");
        PublishSubject<b> publishSubject = this.f1592l;
        publishSubject.f27650k.onNext(new b(playbackException));
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: t */
    public /* synthetic */ void mo261t(InterfaceC3128y1.b bVar) {
        C2528a2.m2419a(this, bVar);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: v */
    public /* synthetic */ void mo262v(AbstractC2832o2 abstractC2832o2, int i) {
        C2528a2.m2441w(this, abstractC2832o2, i);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: w */
    public /* synthetic */ void mo263w(float f) {
        C2528a2.m2444z(this, f);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
    /* JADX INFO: renamed from: y */
    public void mo264y(int i) {
        PublishSubject<c> publishSubject = this.f1590j;
        publishSubject.f27650k.onNext(new c(i));
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.e
    /* JADX INFO: renamed from: z */
    public /* synthetic */ void mo265z(C2633c1 c2633c1) {
        C2528a2.m2421c(this, c2633c1);
    }
}
