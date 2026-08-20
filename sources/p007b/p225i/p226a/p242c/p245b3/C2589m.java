package p007b.p225i.p226a.p242c.p245b3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import p007b.p225i.p226a.p242c.AbstractC2951v0;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.C2815k1;
import p007b.p225i.p226a.p242c.p245b3.p246n.C2592c;
import p007b.p225i.p226a.p242c.p245b3.p246n.C2593d;
import p007b.p225i.p226a.p242c.p245b3.p247o.C2596a;
import p007b.p225i.p226a.p242c.p245b3.p248p.C2599a;
import p007b.p225i.p226a.p242c.p245b3.p250r.C2605a;
import p007b.p225i.p226a.p242c.p245b3.p251s.C2609a;
import p007b.p225i.p226a.p242c.p245b3.p252t.C2613c;
import p007b.p225i.p226a.p242c.p245b3.p253u.C2618a;
import p007b.p225i.p226a.p242c.p245b3.p254v.C2622c;
import p007b.p225i.p226a.p242c.p245b3.p254v.C2628i;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2750q;
import p007b.p225i.p226a.p242c.p259f3.C2753t;

/* JADX INFO: renamed from: b.i.a.c.b3.m */
/* JADX INFO: compiled from: TextRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2589m extends AbstractC2951v0 implements Handler.Callback {

    /* JADX INFO: renamed from: A */
    public boolean f5803A;

    /* JADX INFO: renamed from: B */
    public int f5804B;

    /* JADX INFO: renamed from: C */
    @Nullable
    public C2811j1 f5805C;

    /* JADX INFO: renamed from: D */
    @Nullable
    public InterfaceC2584h f5806D;

    /* JADX INFO: renamed from: E */
    @Nullable
    public C2586j f5807E;

    /* JADX INFO: renamed from: F */
    @Nullable
    public AbstractC2587k f5808F;

    /* JADX INFO: renamed from: G */
    @Nullable
    public AbstractC2587k f5809G;

    /* JADX INFO: renamed from: H */
    public int f5810H;

    /* JADX INFO: renamed from: I */
    public long f5811I;

    /* JADX INFO: renamed from: u */
    @Nullable
    public final Handler f5812u;

    /* JADX INFO: renamed from: v */
    public final InterfaceC2588l f5813v;

    /* JADX INFO: renamed from: w */
    public final InterfaceC2585i f5814w;

    /* JADX INFO: renamed from: x */
    public final C2815k1 f5815x;

    /* JADX INFO: renamed from: y */
    public boolean f5816y;

    /* JADX INFO: renamed from: z */
    public boolean f5817z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2589m(InterfaceC2588l interfaceC2588l, @Nullable Looper looper) {
        Handler handler;
        super(3);
        InterfaceC2585i interfaceC2585i = InterfaceC2585i.f5799a;
        Objects.requireNonNull(interfaceC2588l);
        this.f5813v = interfaceC2588l;
        if (looper == null) {
            handler = null;
        } else {
            int i = C2738e0.f6708a;
            handler = new Handler(looper, this);
        }
        this.f5812u = handler;
        this.f5814w = interfaceC2585i;
        this.f5815x = new C2815k1();
        this.f5811I = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2951v0
    /* JADX INFO: renamed from: B */
    public void mo2621B() {
        this.f5805C = null;
        this.f5811I = -9223372036854775807L;
        m2624J();
        m2628N();
        InterfaceC2584h interfaceC2584h = this.f5806D;
        Objects.requireNonNull(interfaceC2584h);
        interfaceC2584h.release();
        this.f5806D = null;
        this.f5804B = 0;
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2951v0
    /* JADX INFO: renamed from: D */
    public void mo2622D(long j, boolean z2) {
        m2624J();
        this.f5816y = false;
        this.f5817z = false;
        this.f5811I = -9223372036854775807L;
        if (this.f5804B != 0) {
            m2629O();
            return;
        }
        m2628N();
        InterfaceC2584h interfaceC2584h = this.f5806D;
        Objects.requireNonNull(interfaceC2584h);
        interfaceC2584h.flush();
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2951v0
    /* JADX INFO: renamed from: H */
    public void mo2623H(C2811j1[] c2811j1Arr, long j, long j2) {
        this.f5805C = c2811j1Arr[0];
        if (this.f5806D != null) {
            this.f5804B = 1;
        } else {
            m2627M();
        }
    }

    /* JADX INFO: renamed from: J */
    public final void m2624J() {
        List<C2578b> listEmptyList = Collections.emptyList();
        Handler handler = this.f5812u;
        if (handler != null) {
            handler.obtainMessage(0, listEmptyList).sendToTarget();
        } else {
            this.f5813v.mo2620e(listEmptyList);
        }
    }

    /* JADX INFO: renamed from: K */
    public final long m2625K() {
        if (this.f5810H == -1) {
            return RecyclerView.FOREVER_NS;
        }
        Objects.requireNonNull(this.f5808F);
        int i = this.f5810H;
        InterfaceC2583g interfaceC2583g = this.f5808F.f5801l;
        Objects.requireNonNull(interfaceC2583g);
        if (i >= interfaceC2583g.mo2615i()) {
            return RecyclerView.FOREVER_NS;
        }
        AbstractC2587k abstractC2587k = this.f5808F;
        int i2 = this.f5810H;
        InterfaceC2583g interfaceC2583g2 = abstractC2587k.f5801l;
        Objects.requireNonNull(interfaceC2583g2);
        return interfaceC2583g2.mo2613g(i2) + abstractC2587k.f5802m;
    }

    /* JADX INFO: renamed from: L */
    public final void m2626L(SubtitleDecoderException subtitleDecoderException) {
        String strValueOf = String.valueOf(this.f5805C);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 39);
        sb.append("Subtitle decoding failed. streamFormat=");
        sb.append(strValueOf);
        C2750q.m3039b("TextRenderer", sb.toString(), subtitleDecoderException);
        m2624J();
        m2629O();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:6:0x001b  */
    /* JADX INFO: renamed from: M */
    public final void m2627M() {
        InterfaceC2584h c2596a;
        byte b2 = 1;
        this.f5803A = true;
        InterfaceC2585i interfaceC2585i = this.f5814w;
        C2811j1 c2811j1 = this.f5805C;
        Objects.requireNonNull(c2811j1);
        Objects.requireNonNull((InterfaceC2585i.a) interfaceC2585i);
        String str = c2811j1.f7155w;
        if (str != null) {
            switch (str.hashCode()) {
                case -1351681404:
                    if (!str.equals("application/dvbsubs")) {
                        b2 = -1;
                    } else {
                        b2 = 0;
                    }
                    break;
                case -1248334819:
                    if (!str.equals("application/pgs")) {
                        b2 = -1;
                    }
                    break;
                case -1026075066:
                    if (!str.equals("application/x-mp4-vtt")) {
                        b2 = -1;
                    } else {
                        b2 = 2;
                    }
                    break;
                case -1004728940:
                    if (!str.equals("text/vtt")) {
                        b2 = -1;
                    } else {
                        b2 = 3;
                    }
                    break;
                case 691401887:
                    if (!str.equals("application/x-quicktime-tx3g")) {
                        b2 = -1;
                    } else {
                        b2 = 4;
                    }
                    break;
                case 822864842:
                    if (!str.equals("text/x-ssa")) {
                        b2 = -1;
                    } else {
                        b2 = 5;
                    }
                    break;
                case 930165504:
                    if (!str.equals("application/x-mp4-cea-608")) {
                        b2 = -1;
                    } else {
                        b2 = 6;
                    }
                    break;
                case 1201784583:
                    if (!str.equals("text/x-exoplayer-cues")) {
                        b2 = -1;
                    } else {
                        b2 = 7;
                    }
                    break;
                case 1566015601:
                    if (!str.equals("application/cea-608")) {
                        b2 = -1;
                    } else {
                        b2 = 8;
                    }
                    break;
                case 1566016562:
                    if (!str.equals("application/cea-708")) {
                        b2 = -1;
                    } else {
                        b2 = 9;
                    }
                    break;
                case 1668750253:
                    if (!str.equals("application/x-subrip")) {
                        b2 = -1;
                    } else {
                        b2 = 10;
                    }
                    break;
                case 1693976202:
                    if (!str.equals("application/ttml+xml")) {
                        b2 = -1;
                    } else {
                        b2 = 11;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            switch (b2) {
                case 0:
                    c2596a = new C2596a(c2811j1.f7157y);
                    break;
                case 1:
                    c2596a = new C2599a();
                    break;
                case 2:
                    c2596a = new C2622c();
                    break;
                case 3:
                    c2596a = new C2628i();
                    break;
                case 4:
                    c2596a = new C2618a(c2811j1.f7157y);
                    break;
                case 5:
                    c2596a = new C2605a(c2811j1.f7157y);
                    break;
                case 6:
                case 8:
                    c2596a = new C2592c(str, c2811j1.f7141O, 16000L);
                    break;
                case 7:
                    c2596a = new C2580d();
                    break;
                case 9:
                    c2596a = new C2593d(c2811j1.f7141O, c2811j1.f7157y);
                    break;
                case 10:
                    c2596a = new C2609a();
                    break;
                case 11:
                    c2596a = new C2613c();
                    break;
            }
            this.f5806D = c2596a;
            return;
        }
        String strValueOf = String.valueOf(str);
        throw new IllegalArgumentException(strValueOf.length() != 0 ? "Attempted to create decoder for unsupported MIME type: ".concat(strValueOf) : new String("Attempted to create decoder for unsupported MIME type: "));
    }

    /* JADX INFO: renamed from: N */
    public final void m2628N() {
        this.f5807E = null;
        this.f5810H = -1;
        AbstractC2587k abstractC2587k = this.f5808F;
        if (abstractC2587k != null) {
            abstractC2587k.mo2611p();
            this.f5808F = null;
        }
        AbstractC2587k abstractC2587k2 = this.f5809G;
        if (abstractC2587k2 != null) {
            abstractC2587k2.mo2611p();
            this.f5809G = null;
        }
    }

    /* JADX INFO: renamed from: O */
    public final void m2629O() {
        m2628N();
        InterfaceC2584h interfaceC2584h = this.f5806D;
        Objects.requireNonNull(interfaceC2584h);
        interfaceC2584h.release();
        this.f5806D = null;
        this.f5804B = 0;
        m2627M();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2763g2
    /* JADX INFO: renamed from: a */
    public int mo2630a(C2811j1 c2811j1) {
        Objects.requireNonNull((InterfaceC2585i.a) this.f5814w);
        String str = c2811j1.f7155w;
        if ("text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str) || "text/x-exoplayer-cues".equals(str)) {
            return (c2811j1.f7142P == 0 ? 4 : 2) | 0 | 0;
        }
        return C2753t.m3051i(c2811j1.f7155w) ? 1 : 0;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: b */
    public boolean mo2631b() {
        return this.f5817z;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: d */
    public boolean mo2632d() {
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2, p007b.p225i.p226a.p242c.InterfaceC2763g2
    public String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        this.f5813v.mo2620e((List) message.obj);
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: q */
    public void mo2633q(long j, long j2) throws DecoderException {
        boolean z2;
        if (this.f7898s) {
            long j3 = this.f5811I;
            if (j3 != -9223372036854775807L && j >= j3) {
                m2628N();
                this.f5817z = true;
            }
        }
        if (this.f5817z) {
            return;
        }
        if (this.f5809G == null) {
            InterfaceC2584h interfaceC2584h = this.f5806D;
            Objects.requireNonNull(interfaceC2584h);
            interfaceC2584h.mo2607a(j);
            try {
                InterfaceC2584h interfaceC2584h2 = this.f5806D;
                Objects.requireNonNull(interfaceC2584h2);
                this.f5809G = interfaceC2584h2.mo2608b();
            } catch (SubtitleDecoderException e) {
                m2626L(e);
                return;
            }
        }
        if (this.f7893n != 2) {
            return;
        }
        if (this.f5808F != null) {
            long jM2625K = m2625K();
            z2 = false;
            while (jM2625K <= j) {
                this.f5810H++;
                jM2625K = m2625K();
                z2 = true;
            }
        } else {
            z2 = false;
        }
        AbstractC2587k abstractC2587k = this.f5809G;
        if (abstractC2587k != null) {
            if (abstractC2587k.m3555n()) {
                if (!z2 && m2625K() == RecyclerView.FOREVER_NS) {
                    if (this.f5804B == 2) {
                        m2629O();
                    } else {
                        m2628N();
                        this.f5817z = true;
                    }
                }
            } else if (abstractC2587k.f7925k <= j) {
                AbstractC2587k abstractC2587k2 = this.f5808F;
                if (abstractC2587k2 != null) {
                    abstractC2587k2.mo2611p();
                }
                InterfaceC2583g interfaceC2583g = abstractC2587k.f5801l;
                Objects.requireNonNull(interfaceC2583g);
                this.f5810H = interfaceC2583g.mo2612f(j - abstractC2587k.f5802m);
                this.f5808F = abstractC2587k;
                this.f5809G = null;
                z2 = true;
            }
        }
        if (z2) {
            Objects.requireNonNull(this.f5808F);
            AbstractC2587k abstractC2587k3 = this.f5808F;
            InterfaceC2583g interfaceC2583g2 = abstractC2587k3.f5801l;
            Objects.requireNonNull(interfaceC2583g2);
            List<C2578b> listMo2614h = interfaceC2583g2.mo2614h(j - abstractC2587k3.f5802m);
            Handler handler = this.f5812u;
            if (handler != null) {
                handler.obtainMessage(0, listMo2614h).sendToTarget();
            } else {
                this.f5813v.mo2620e(listMo2614h);
            }
        }
        if (this.f5804B == 2) {
            return;
        }
        while (!this.f5816y) {
            try {
                C2586j c2586jMo2609c = this.f5807E;
                if (c2586jMo2609c == null) {
                    InterfaceC2584h interfaceC2584h3 = this.f5806D;
                    Objects.requireNonNull(interfaceC2584h3);
                    c2586jMo2609c = interfaceC2584h3.mo2609c();
                    if (c2586jMo2609c == null) {
                        return;
                    } else {
                        this.f5807E = c2586jMo2609c;
                    }
                }
                if (this.f5804B == 1) {
                    c2586jMo2609c.f7901j = 4;
                    InterfaceC2584h interfaceC2584h4 = this.f5806D;
                    Objects.requireNonNull(interfaceC2584h4);
                    interfaceC2584h4.mo2610d(c2586jMo2609c);
                    this.f5807E = null;
                    this.f5804B = 2;
                    return;
                }
                int iM3548I = m3548I(this.f5815x, c2586jMo2609c, 0);
                if (iM3548I == -4) {
                    if (c2586jMo2609c.m3555n()) {
                        this.f5816y = true;
                        this.f5803A = false;
                    } else {
                        C2811j1 c2811j1 = this.f5815x.f7196b;
                        if (c2811j1 == null) {
                            return;
                        }
                        c2586jMo2609c.f5800r = c2811j1.f7127A;
                        c2586jMo2609c.m8813s();
                        this.f5803A &= !c2586jMo2609c.m3556o();
                    }
                    if (!this.f5803A) {
                        InterfaceC2584h interfaceC2584h5 = this.f5806D;
                        Objects.requireNonNull(interfaceC2584h5);
                        interfaceC2584h5.mo2610d(c2586jMo2609c);
                        this.f5807E = null;
                    }
                } else if (iM3548I == -3) {
                    return;
                }
            } catch (SubtitleDecoderException e2) {
                m2626L(e2);
                return;
            }
        }
    }
}
