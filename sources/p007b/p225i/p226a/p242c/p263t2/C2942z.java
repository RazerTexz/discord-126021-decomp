package p007b.p225i.p226a.p242c.p263t2;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2804h2;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.C2815k1;
import p007b.p225i.p226a.p242c.C2998x1;
import p007b.p225i.p226a.p242c.InterfaceC2728f2;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2750q;
import p007b.p225i.p226a.p242c.p259f3.C2753t;
import p007b.p225i.p226a.p242c.p259f3.InterfaceC2752s;
import p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r;
import p007b.p225i.p226a.p242c.p265v2.C2957e;
import p007b.p225i.p226a.p242c.p265v2.C2959g;
import p007b.p225i.p226a.p242c.p278y2.C3135g;
import p007b.p225i.p226a.p242c.p278y2.C3149u;
import p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t;
import p007b.p225i.p226a.p242c.p278y2.InterfaceC3150v;

/* JADX INFO: renamed from: b.i.a.c.t2.z */
/* JADX INFO: compiled from: MediaCodecAudioRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2942z extends MediaCodecRenderer implements InterfaceC2752s {

    /* JADX INFO: renamed from: N0 */
    public final Context f7850N0;

    /* JADX INFO: renamed from: O0 */
    public final InterfaceC2934r.a f7851O0;

    /* JADX INFO: renamed from: P0 */
    public final AudioSink f7852P0;

    /* JADX INFO: renamed from: Q0 */
    public int f7853Q0;

    /* JADX INFO: renamed from: R0 */
    public boolean f7854R0;

    /* JADX INFO: renamed from: S0 */
    @Nullable
    public C2811j1 f7855S0;

    /* JADX INFO: renamed from: T0 */
    public long f7856T0;

    /* JADX INFO: renamed from: U0 */
    public boolean f7857U0;

    /* JADX INFO: renamed from: V0 */
    public boolean f7858V0;

    /* JADX INFO: renamed from: W0 */
    public boolean f7859W0;

    /* JADX INFO: renamed from: X0 */
    @Nullable
    public InterfaceC2728f2.a f7860X0;

    /* JADX INFO: renamed from: b.i.a.c.t2.z$b */
    /* JADX INFO: compiled from: MediaCodecAudioRenderer.java */
    public final class b implements AudioSink.InterfaceC10686a {
        public b(a aVar) {
        }

        /* JADX INFO: renamed from: a */
        public void m3517a(final Exception exc) {
            C2750q.m3039b("MediaCodecAudioRenderer", "Audio sink error", exc);
            final InterfaceC2934r.a aVar = C2942z.this.f7851O0;
            Handler handler = aVar.f7790a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: b.i.a.c.t2.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        InterfaceC2934r.a aVar2 = aVar;
                        Exception exc2 = exc;
                        InterfaceC2934r interfaceC2934r = aVar2.f7791b;
                        int i = C2738e0.f6708a;
                        interfaceC2934r.mo3294N(exc2);
                    }
                });
            }
        }
    }

    public C2942z(Context context, InterfaceC3148t.b bVar, InterfaceC3150v interfaceC3150v, boolean z2, @Nullable Handler handler, @Nullable InterfaceC2934r interfaceC2934r, AudioSink audioSink) {
        super(1, bVar, interfaceC3150v, z2, 44100.0f);
        this.f7850N0 = context.getApplicationContext();
        this.f7852P0 = audioSink;
        this.f7851O0 = new InterfaceC2934r.a(handler, interfaceC2934r);
        audioSink.mo8773t(new b(null));
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, p007b.p225i.p226a.p242c.AbstractC2951v0
    /* JADX INFO: renamed from: B */
    public void mo2621B() {
        this.f7859W0 = true;
        try {
            this.f7852P0.flush();
            try {
                super.mo2621B();
            } finally {
                this.f7851O0.m3498a(this.f19877J0);
            }
        } catch (Throwable th) {
            try {
                super.mo2621B();
                throw th;
            } finally {
                this.f7851O0.m3498a(this.f19877J0);
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2951v0
    /* JADX INFO: renamed from: C */
    public void mo3137C(boolean z2, boolean z3) throws ExoPlaybackException {
        final C2957e c2957e = new C2957e();
        this.f19877J0 = c2957e;
        final InterfaceC2934r.a aVar = this.f7851O0;
        Handler handler = aVar.f7790a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: b.i.a.c.t2.j
                @Override // java.lang.Runnable
                public final void run() {
                    InterfaceC2934r.a aVar2 = aVar;
                    C2957e c2957e2 = c2957e;
                    InterfaceC2934r interfaceC2934r = aVar2.f7791b;
                    int i = C2738e0.f6708a;
                    interfaceC2934r.mo3302m(c2957e2);
                }
            });
        }
        C2804h2 c2804h2 = this.f7891l;
        Objects.requireNonNull(c2804h2);
        if (c2804h2.f7118b) {
            this.f7852P0.mo8771r();
        } else {
            this.f7852P0.mo8767n();
        }
    }

    /* JADX INFO: renamed from: C0 */
    public final int m3513C0(C3149u c3149u, C2811j1 c2811j1) {
        int i;
        if (!"OMX.google.raw.decoder".equals(c3149u.f9112a) || (i = C2738e0.f6708a) >= 24 || (i == 23 && C2738e0.m2980A(this.f7850N0))) {
            return c2811j1.f7156x;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, p007b.p225i.p226a.p242c.AbstractC2951v0
    /* JADX INFO: renamed from: D */
    public void mo2622D(long j, boolean z2) throws ExoPlaybackException {
        super.mo2622D(j, z2);
        this.f7852P0.flush();
        this.f7856T0 = j;
        this.f7857U0 = true;
        this.f7858V0 = true;
    }

    /* JADX INFO: renamed from: D0 */
    public final void m3514D0() {
        long jMo8766m = this.f7852P0.mo8766m(mo2631b());
        if (jMo8766m != Long.MIN_VALUE) {
            if (!this.f7858V0) {
                jMo8766m = Math.max(this.f7856T0, jMo8766m);
            }
            this.f7856T0 = jMo8766m;
            this.f7858V0 = false;
        }
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2951v0
    /* JADX INFO: renamed from: E */
    public void mo3140E() {
        try {
            try {
                m8841M();
                m8855o0();
                m8859u0(null);
                if (this.f7859W0) {
                    this.f7859W0 = false;
                    this.f7852P0.reset();
                }
            } catch (Throwable th) {
                m8859u0(null);
                throw th;
            }
        } catch (Throwable th2) {
            if (this.f7859W0) {
                this.f7859W0 = false;
                this.f7852P0.reset();
            }
            throw th2;
        }
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2951v0
    /* JADX INFO: renamed from: F */
    public void mo3141F() {
        this.f7852P0.mo8761e();
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2951v0
    /* JADX INFO: renamed from: G */
    public void mo3142G() {
        m3514D0();
        this.f7852P0.mo8760d();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: K */
    public C2959g mo3144K(C3149u c3149u, C2811j1 c2811j1, C2811j1 c2811j2) {
        C2959g c2959gM3865c = c3149u.m3865c(c2811j1, c2811j2);
        int i = c2959gM3865c.f7930e;
        if (m3513C0(c3149u, c2811j2) > this.f7853Q0) {
            i |= 64;
        }
        int i2 = i;
        return new C2959g(c3149u.f9112a, c2811j1, c2811j2, i2 != 0 ? 0 : c2959gM3865c.f7929d, i2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: V */
    public float mo3158V(float f, C2811j1 c2811j1, C2811j1[] c2811j1Arr) {
        int iMax = -1;
        for (C2811j1 c2811j2 : c2811j1Arr) {
            int i = c2811j2.f7137K;
            if (i != -1) {
                iMax = Math.max(iMax, i);
            }
        }
        if (iMax == -1) {
            return -1.0f;
        }
        return f * iMax;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: W */
    public List<C3149u> mo3160W(InterfaceC3150v interfaceC3150v, C2811j1 c2811j1, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        C3149u c3149uM8865d;
        String str = c2811j1.f7155w;
        if (str == null) {
            return Collections.emptyList();
        }
        if (this.f7852P0.mo8757a(c2811j1) && (c3149uM8865d = MediaCodecUtil.m8865d("audio/raw", false, false)) != null) {
            return Collections.singletonList(c3149uM8865d);
        }
        List<C3149u> listMo3831a = interfaceC3150v.mo3831a(str, z2, false);
        Pattern pattern = MediaCodecUtil.f19928a;
        ArrayList arrayList = new ArrayList(listMo3831a);
        MediaCodecUtil.m8871j(arrayList, new C3135g(c2811j1));
        if ("audio/eac3-joc".equals(str)) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            arrayList2.addAll(interfaceC3150v.mo3831a("audio/eac3", z2, false));
            arrayList = arrayList2;
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0066  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b4  */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: Y */
    public InterfaceC3148t.a mo3161Y(C3149u c3149u, C2811j1 c2811j1, @Nullable MediaCrypto mediaCrypto, float f) {
        boolean z2;
        boolean z3;
        C2811j1[] c2811j1Arr = this.f7895p;
        Objects.requireNonNull(c2811j1Arr);
        int iM3513C0 = m3513C0(c3149u, c2811j1);
        boolean z4 = false;
        if (c2811j1Arr.length != 1) {
            for (C2811j1 c2811j2 : c2811j1Arr) {
                if (c3149u.m3865c(c2811j1, c2811j2).f7929d != 0) {
                    iM3513C0 = Math.max(iM3513C0, m3513C0(c3149u, c2811j2));
                }
            }
        }
        this.f7853Q0 = iM3513C0;
        String str = c3149u.f9112a;
        int i = C2738e0.f6708a;
        if (i < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(C2738e0.f6710c)) {
            String str2 = C2738e0.f6709b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        this.f7854R0 = z2;
        String str3 = c3149u.f9114c;
        int i2 = this.f7853Q0;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str3);
        mediaFormat.setInteger("channel-count", c2811j1.f7136J);
        mediaFormat.setInteger("sample-rate", c2811j1.f7137K);
        C1460d.m491Y1(mediaFormat, c2811j1.f7157y);
        C1460d.m533j1(mediaFormat, "max-input-size", i2);
        if (i >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                if (i == 23) {
                    String str4 = C2738e0.f6711d;
                    if ("ZTE B2017G".equals(str4) || "AXON 7 mini".equals(str4)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                } else {
                    z3 = false;
                }
                if (!z3) {
                    mediaFormat.setFloat("operating-rate", f);
                }
            }
        }
        if (i <= 28 && "audio/ac4".equals(c2811j1.f7155w)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i >= 24) {
            AudioSink audioSink = this.f7852P0;
            int i3 = c2811j1.f7136J;
            int i4 = c2811j1.f7137K;
            C2811j1.b bVar = new C2811j1.b();
            bVar.f7173k = "audio/raw";
            bVar.f7186x = i3;
            bVar.f7187y = i4;
            bVar.f7188z = 4;
            if (audioSink.mo8774u(bVar.m3277a()) == 2) {
                mediaFormat.setInteger("pcm-encoding", 4);
            }
        }
        if ("audio/raw".equals(c3149u.f9113b) && !"audio/raw".equals(c2811j1.f7155w)) {
            z4 = true;
        }
        this.f7855S0 = z4 ? c2811j1 : null;
        return new InterfaceC3148t.a(c3149u, mediaFormat, c2811j1, null, mediaCrypto, 0, false);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: b */
    public boolean mo2631b() {
        return this.f19869F0 && this.f7852P0.mo8758b();
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.InterfaceC2752s
    /* JADX INFO: renamed from: c */
    public C2998x1 mo2416c() {
        return this.f7852P0.mo8759c();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: d */
    public boolean mo2632d() {
        return this.f7852P0.mo8764k() || super.mo2632d();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: d0 */
    public void mo3163d0(final Exception exc) {
        C2750q.m3039b("MediaCodecAudioRenderer", "Audio codec error", exc);
        final InterfaceC2934r.a aVar = this.f7851O0;
        Handler handler = aVar.f7790a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: b.i.a.c.t2.c
                @Override // java.lang.Runnable
                public final void run() {
                    InterfaceC2934r.a aVar2 = aVar;
                    Exception exc2 = exc;
                    InterfaceC2934r interfaceC2934r = aVar2.f7791b;
                    int i = C2738e0.f6708a;
                    interfaceC2934r.mo3296T(exc2);
                }
            });
        }
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.InterfaceC2752s
    /* JADX INFO: renamed from: e */
    public long mo2417e() {
        if (this.f7893n == 2) {
            m3514D0();
        }
        return this.f7856T0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: e0 */
    public void mo3164e0(final String str, final long j, final long j2) {
        final InterfaceC2934r.a aVar = this.f7851O0;
        Handler handler = aVar.f7790a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: b.i.a.c.t2.f
                @Override // java.lang.Runnable
                public final void run() {
                    InterfaceC2934r.a aVar2 = aVar;
                    String str2 = str;
                    long j3 = j;
                    long j4 = j2;
                    InterfaceC2934r interfaceC2934r = aVar2.f7791b;
                    int i = C2738e0.f6708a;
                    interfaceC2934r.mo3292C(str2, j3, j4);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: f0 */
    public void mo3165f0(final String str) {
        final InterfaceC2934r.a aVar = this.f7851O0;
        Handler handler = aVar.f7790a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: b.i.a.c.t2.g
                @Override // java.lang.Runnable
                public final void run() {
                    InterfaceC2934r.a aVar2 = aVar;
                    String str2 = str;
                    InterfaceC2934r interfaceC2934r = aVar2.f7791b;
                    int i = C2738e0.f6708a;
                    interfaceC2934r.mo3291B(str2);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @Nullable
    /* JADX INFO: renamed from: g0 */
    public C2959g mo3166g0(C2815k1 c2815k1) throws ExoPlaybackException {
        final C2959g c2959gMo3166g0 = super.mo3166g0(c2815k1);
        final InterfaceC2934r.a aVar = this.f7851O0;
        final C2811j1 c2811j1 = c2815k1.f7196b;
        Handler handler = aVar.f7790a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: b.i.a.c.t2.e
                @Override // java.lang.Runnable
                public final void run() {
                    InterfaceC2934r.a aVar2 = aVar;
                    C2811j1 c2811j2 = c2811j1;
                    C2959g c2959g = c2959gMo3166g0;
                    InterfaceC2934r interfaceC2934r = aVar2.f7791b;
                    int i = C2738e0.f6708a;
                    interfaceC2934r.mo3297U(c2811j2);
                    aVar2.f7791b.mo3293I(c2811j2, c2959g);
                }
            });
        }
        return c2959gMo3166g0;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2, p007b.p225i.p226a.p242c.InterfaceC2763g2
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: h0 */
    public void mo3167h0(C2811j1 c2811j1, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException {
        int iM3010r;
        int i;
        C2811j1 c2811j2 = this.f7855S0;
        int[] iArr = null;
        if (c2811j2 != null) {
            c2811j1 = c2811j2;
        } else if (this.f19889S != null) {
            if ("audio/raw".equals(c2811j1.f7155w)) {
                iM3010r = c2811j1.f7138L;
            } else if (C2738e0.f6708a >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                iM3010r = mediaFormat.getInteger("pcm-encoding");
            } else if (mediaFormat.containsKey("v-bits-per-sample")) {
                iM3010r = C2738e0.m3010r(mediaFormat.getInteger("v-bits-per-sample"));
            } else {
                iM3010r = "audio/raw".equals(c2811j1.f7155w) ? c2811j1.f7138L : 2;
            }
            C2811j1.b bVar = new C2811j1.b();
            bVar.f7173k = "audio/raw";
            bVar.f7188z = iM3010r;
            bVar.f7159A = c2811j1.f7139M;
            bVar.f7160B = c2811j1.f7140N;
            bVar.f7186x = mediaFormat.getInteger("channel-count");
            bVar.f7187y = mediaFormat.getInteger("sample-rate");
            C2811j1 c2811j1M3277a = bVar.m3277a();
            if (this.f7854R0 && c2811j1M3277a.f7136J == 6 && (i = c2811j1.f7136J) < 6) {
                iArr = new int[i];
                for (int i2 = 0; i2 < c2811j1.f7136J; i2++) {
                    iArr[i2] = i2;
                }
            }
            c2811j1 = c2811j1M3277a;
        }
        try {
            this.f7852P0.mo8775v(c2811j1, 0, iArr);
        } catch (AudioSink.ConfigurationException e) {
            throw m3550z(e, e.format, false, 5001);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.InterfaceC2752s
    /* JADX INFO: renamed from: i */
    public void mo2418i(C2998x1 c2998x1) {
        this.f7852P0.mo8762i(c2998x1);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: j0 */
    public void mo3169j0() {
        this.f7852P0.mo8769p();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: k0 */
    public void mo3170k0(DecoderInputBuffer decoderInputBuffer) {
        if (!this.f7857U0 || decoderInputBuffer.m3554m()) {
            return;
        }
        if (Math.abs(decoderInputBuffer.f19780n - this.f7856T0) > 500000) {
            this.f7856T0 = decoderInputBuffer.f19780n;
        }
        this.f7857U0 = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: m0 */
    public boolean mo3171m0(long j, long j2, @Nullable InterfaceC3148t interfaceC3148t, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z2, boolean z3, C2811j1 c2811j1) throws ExoPlaybackException {
        Objects.requireNonNull(byteBuffer);
        if (this.f7855S0 != null && (i2 & 2) != 0) {
            Objects.requireNonNull(interfaceC3148t);
            interfaceC3148t.releaseOutputBuffer(i, false);
            return true;
        }
        if (z2) {
            if (interfaceC3148t != null) {
                interfaceC3148t.releaseOutputBuffer(i, false);
            }
            this.f19877J0.f7919f += i3;
            this.f7852P0.mo8769p();
            return true;
        }
        try {
            if (!this.f7852P0.mo8772s(byteBuffer, j3, i3)) {
                return false;
            }
            if (interfaceC3148t != null) {
                interfaceC3148t.releaseOutputBuffer(i, false);
            }
            this.f19877J0.f7918e += i3;
            return true;
        } catch (AudioSink.InitializationException e) {
            throw m3550z(e, e.format, e.isRecoverable, 5001);
        } catch (AudioSink.WriteException e2) {
            throw m3550z(e2, c2811j1, e2.isRecoverable, 5002);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: p0 */
    public void mo3515p0() throws ExoPlaybackException {
        try {
            this.f7852P0.mo8763j();
        } catch (AudioSink.WriteException e) {
            throw m3550z(e, e.format, e.isRecoverable, 5002);
        }
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2951v0, p007b.p225i.p226a.p242c.C2576b2.b
    /* JADX INFO: renamed from: r */
    public void mo2603r(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 2) {
            this.f7852P0.mo8770q(((Float) obj).floatValue());
        }
        if (i == 3) {
            this.f7852P0.mo8768o((C2931o) obj);
            return;
        }
        if (i == 6) {
            this.f7852P0.mo8777x((C2937u) obj);
            return;
        }
        switch (i) {
            case 9:
                this.f7852P0.mo8776w(((Boolean) obj).booleanValue());
                break;
            case 10:
                this.f7852P0.mo8765l(((Integer) obj).intValue());
                break;
            case 11:
                this.f7860X0 = (InterfaceC2728f2.a) obj;
                break;
        }
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2951v0, p007b.p225i.p226a.p242c.InterfaceC2728f2
    @Nullable
    /* JADX INFO: renamed from: w */
    public InterfaceC2752s mo2945w() {
        return this;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: x0 */
    public boolean mo3516x0(C2811j1 c2811j1) {
        return this.f7852P0.mo8757a(c2811j1);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: y0 */
    public int mo3174y0(InterfaceC3150v interfaceC3150v, C2811j1 c2811j1) throws MediaCodecUtil.DecoderQueryException {
        if (!C2753t.m3050h(c2811j1.f7155w)) {
            return 0;
        }
        int i = C2738e0.f6708a >= 21 ? 32 : 0;
        int i2 = c2811j1.f7142P;
        boolean z2 = i2 != 0;
        boolean z3 = i2 == 0 || i2 == 2;
        if (z3 && this.f7852P0.mo8757a(c2811j1) && (!z2 || MediaCodecUtil.m8865d("audio/raw", false, false) != null)) {
            return i | 12;
        }
        if ("audio/raw".equals(c2811j1.f7155w) && !this.f7852P0.mo8757a(c2811j1)) {
            return 1;
        }
        AudioSink audioSink = this.f7852P0;
        int i3 = c2811j1.f7136J;
        int i4 = c2811j1.f7137K;
        C2811j1.b bVar = new C2811j1.b();
        bVar.f7173k = "audio/raw";
        bVar.f7186x = i3;
        bVar.f7187y = i4;
        bVar.f7188z = 2;
        if (!audioSink.mo8757a(bVar.m3277a())) {
            return 1;
        }
        List<C3149u> listMo3160W = mo3160W(interfaceC3150v, c2811j1, false);
        if (listMo3160W.isEmpty()) {
            return 1;
        }
        if (!z3) {
            return 2;
        }
        C3149u c3149u = listMo3160W.get(0);
        boolean zM3867e = c3149u.m3867e(c2811j1);
        return ((zM3867e && c3149u.m3868f(c2811j1)) ? 16 : 8) | (zM3867e ? 4 : 3) | i;
    }
}
