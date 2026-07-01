package b.i.a.c.t2;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.FormatHolder;
import b.i.a.c.PlaybackParameters;
import b.i.a.c.Renderer2;
import b.i.a.c.RendererConfiguration;
import b.i.a.c.f3.Log2;
import b.i.a.c.f3.MediaClock;
import b.i.a.c.f3.MimeTypes;
import b.i.a.c.f3.Util2;
import b.i.a.c.t2.AudioRendererEventListener2;
import b.i.a.c.v2.DecoderCounters;
import b.i.a.c.v2.DecoderReuseEvaluation;
import b.i.a.c.y2.MediaCodecAdapter;
import b.i.a.c.y2.MediaCodecInfo;
import b.i.a.c.y2.MediaCodecSelector;
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

/* JADX INFO: renamed from: b.i.a.c.t2.z, reason: use source file name */
/* JADX INFO: compiled from: MediaCodecAudioRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock {
    public final Context N0;
    public final AudioRendererEventListener2.a O0;
    public final AudioSink P0;
    public int Q0;
    public boolean R0;

    @Nullable
    public Format2 S0;
    public long T0;
    public boolean U0;
    public boolean V0;
    public boolean W0;

    @Nullable
    public Renderer2.a X0;

    /* JADX INFO: renamed from: b.i.a.c.t2.z$b */
    /* JADX INFO: compiled from: MediaCodecAudioRenderer.java */
    public final class b implements AudioSink.a {
        public b(a aVar) {
        }

        public void a(final Exception exc) {
            Log2.b("MediaCodecAudioRenderer", "Audio sink error", exc);
            final AudioRendererEventListener2.a aVar = MediaCodecAudioRenderer.this.O0;
            Handler handler = aVar.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: b.i.a.c.t2.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener2.a aVar2 = aVar;
                        Exception exc2 = exc;
                        AudioRendererEventListener2 audioRendererEventListener2 = aVar2.f1126b;
                        int i = Util2.a;
                        audioRendererEventListener2.N(exc2);
                    }
                });
            }
        }
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecAdapter.b bVar, MediaCodecSelector mediaCodecSelector, boolean z2, @Nullable Handler handler, @Nullable AudioRendererEventListener2 audioRendererEventListener2, AudioSink audioSink) {
        super(1, bVar, mediaCodecSelector, z2, 44100.0f);
        this.N0 = context.getApplicationContext();
        this.P0 = audioSink;
        this.O0 = new AudioRendererEventListener2.a(handler, audioRendererEventListener2);
        audioSink.t(new b(null));
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, b.i.a.c.BaseRenderer
    public void B() {
        this.W0 = true;
        try {
            this.P0.flush();
            try {
                super.B();
            } finally {
                this.O0.a(this.J0);
            }
        } catch (Throwable th) {
            try {
                super.B();
                throw th;
            } finally {
                this.O0.a(this.J0);
            }
        }
    }

    @Override // b.i.a.c.BaseRenderer
    public void C(boolean z2, boolean z3) throws ExoPlaybackException {
        final DecoderCounters decoderCounters = new DecoderCounters();
        this.J0 = decoderCounters;
        final AudioRendererEventListener2.a aVar = this.O0;
        Handler handler = aVar.a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: b.i.a.c.t2.j
                @Override // java.lang.Runnable
                public final void run() {
                    AudioRendererEventListener2.a aVar2 = aVar;
                    DecoderCounters decoderCounters2 = decoderCounters;
                    AudioRendererEventListener2 audioRendererEventListener2 = aVar2.f1126b;
                    int i = Util2.a;
                    audioRendererEventListener2.m(decoderCounters2);
                }
            });
        }
        RendererConfiguration rendererConfiguration = this.l;
        Objects.requireNonNull(rendererConfiguration);
        if (rendererConfiguration.f1015b) {
            this.P0.r();
        } else {
            this.P0.n();
        }
    }

    public final int C0(MediaCodecInfo mediaCodecInfo, Format2 format2) {
        int i;
        if (!"OMX.google.raw.decoder".equals(mediaCodecInfo.a) || (i = Util2.a) >= 24 || (i == 23 && Util2.A(this.N0))) {
            return format2.f1018x;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, b.i.a.c.BaseRenderer
    public void D(long j, boolean z2) throws ExoPlaybackException {
        super.D(j, z2);
        this.P0.flush();
        this.T0 = j;
        this.U0 = true;
        this.V0 = true;
    }

    public final void D0() {
        long jM = this.P0.m(b());
        if (jM != Long.MIN_VALUE) {
            if (!this.V0) {
                jM = Math.max(this.T0, jM);
            }
            this.T0 = jM;
            this.V0 = false;
        }
    }

    @Override // b.i.a.c.BaseRenderer
    public void E() {
        try {
            try {
                M();
                o0();
                u0(null);
                if (this.W0) {
                    this.W0 = false;
                    this.P0.reset();
                }
            } catch (Throwable th) {
                u0(null);
                throw th;
            }
        } catch (Throwable th2) {
            if (this.W0) {
                this.W0 = false;
                this.P0.reset();
            }
            throw th2;
        }
    }

    @Override // b.i.a.c.BaseRenderer
    public void F() {
        this.P0.e();
    }

    @Override // b.i.a.c.BaseRenderer
    public void G() {
        D0();
        this.P0.d();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public DecoderReuseEvaluation K(MediaCodecInfo mediaCodecInfo, Format2 format2, Format2 format3) {
        DecoderReuseEvaluation decoderReuseEvaluationC = mediaCodecInfo.c(format2, format3);
        int i = decoderReuseEvaluationC.e;
        if (C0(mediaCodecInfo, format3) > this.Q0) {
            i |= 64;
        }
        int i2 = i;
        return new DecoderReuseEvaluation(mediaCodecInfo.a, format2, format3, i2 != 0 ? 0 : decoderReuseEvaluationC.d, i2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float V(float f, Format2 format2, Format2[] format2Arr) {
        int iMax = -1;
        for (Format2 format3 : format2Arr) {
            int i = format3.K;
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
    public List<MediaCodecInfo> W(MediaCodecSelector mediaCodecSelector, Format2 format2, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        MediaCodecInfo mediaCodecInfoD;
        String str = format2.w;
        if (str == null) {
            return Collections.emptyList();
        }
        if (this.P0.a(format2) && (mediaCodecInfoD = MediaCodecUtil.d("audio/raw", false, false)) != null) {
            return Collections.singletonList(mediaCodecInfoD);
        }
        List<MediaCodecInfo> listA = mediaCodecSelector.a(str, z2, false);
        Pattern pattern = MediaCodecUtil.a;
        ArrayList arrayList = new ArrayList(listA);
        MediaCodecUtil.j(arrayList, new b.i.a.c.y2.g(format2));
        if ("audio/eac3-joc".equals(str)) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            arrayList2.addAll(mediaCodecSelector.a("audio/eac3", z2, false));
            arrayList = arrayList2;
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0066  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b4  */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public MediaCodecAdapter.a Y(MediaCodecInfo mediaCodecInfo, Format2 format2, @Nullable MediaCrypto mediaCrypto, float f) {
        boolean z2;
        boolean z3;
        Format2[] format2Arr = this.p;
        Objects.requireNonNull(format2Arr);
        int iC0 = C0(mediaCodecInfo, format2);
        boolean z4 = false;
        if (format2Arr.length != 1) {
            for (Format2 format3 : format2Arr) {
                if (mediaCodecInfo.c(format2, format3).d != 0) {
                    iC0 = Math.max(iC0, C0(mediaCodecInfo, format3));
                }
            }
        }
        this.Q0 = iC0;
        String str = mediaCodecInfo.a;
        int i = Util2.a;
        if (i < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(Util2.c)) {
            String str2 = Util2.f968b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        this.R0 = z2;
        String str3 = mediaCodecInfo.c;
        int i2 = this.Q0;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str3);
        mediaFormat.setInteger("channel-count", format2.J);
        mediaFormat.setInteger("sample-rate", format2.K);
        AnimatableValueParser.Y1(mediaFormat, format2.f1019y);
        AnimatableValueParser.j1(mediaFormat, "max-input-size", i2);
        if (i >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                if (i == 23) {
                    String str4 = Util2.d;
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
        if (i <= 28 && "audio/ac4".equals(format2.w)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i >= 24) {
            AudioSink audioSink = this.P0;
            int i3 = format2.J;
            int i4 = format2.K;
            Format2.b bVar = new Format2.b();
            bVar.k = "audio/raw";
            bVar.f1023x = i3;
            bVar.f1024y = i4;
            bVar.f1025z = 4;
            if (audioSink.u(bVar.a()) == 2) {
                mediaFormat.setInteger("pcm-encoding", 4);
            }
        }
        if ("audio/raw".equals(mediaCodecInfo.f1315b) && !"audio/raw".equals(format2.w)) {
            z4 = true;
        }
        this.S0 = z4 ? format2 : null;
        return new MediaCodecAdapter.a(mediaCodecInfo, mediaFormat, format2, null, mediaCrypto, 0, false);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, b.i.a.c.Renderer2
    public boolean b() {
        return this.F0 && this.P0.b();
    }

    @Override // b.i.a.c.f3.MediaClock
    public PlaybackParameters c() {
        return this.P0.c();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, b.i.a.c.Renderer2
    public boolean d() {
        return this.P0.k() || super.d();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void d0(final Exception exc) {
        Log2.b("MediaCodecAudioRenderer", "Audio codec error", exc);
        final AudioRendererEventListener2.a aVar = this.O0;
        Handler handler = aVar.a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: b.i.a.c.t2.c
                @Override // java.lang.Runnable
                public final void run() {
                    AudioRendererEventListener2.a aVar2 = aVar;
                    Exception exc2 = exc;
                    AudioRendererEventListener2 audioRendererEventListener2 = aVar2.f1126b;
                    int i = Util2.a;
                    audioRendererEventListener2.T(exc2);
                }
            });
        }
    }

    @Override // b.i.a.c.f3.MediaClock
    public long e() {
        if (this.n == 2) {
            D0();
        }
        return this.T0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void e0(final String str, final long j, final long j2) {
        final AudioRendererEventListener2.a aVar = this.O0;
        Handler handler = aVar.a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: b.i.a.c.t2.f
                @Override // java.lang.Runnable
                public final void run() {
                    AudioRendererEventListener2.a aVar2 = aVar;
                    String str2 = str;
                    long j3 = j;
                    long j4 = j2;
                    AudioRendererEventListener2 audioRendererEventListener2 = aVar2.f1126b;
                    int i = Util2.a;
                    audioRendererEventListener2.C(str2, j3, j4);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void f0(final String str) {
        final AudioRendererEventListener2.a aVar = this.O0;
        Handler handler = aVar.a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: b.i.a.c.t2.g
                @Override // java.lang.Runnable
                public final void run() {
                    AudioRendererEventListener2.a aVar2 = aVar;
                    String str2 = str;
                    AudioRendererEventListener2 audioRendererEventListener2 = aVar2.f1126b;
                    int i = Util2.a;
                    audioRendererEventListener2.B(str2);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @Nullable
    public DecoderReuseEvaluation g0(FormatHolder formatHolder) throws ExoPlaybackException {
        final DecoderReuseEvaluation decoderReuseEvaluationG0 = super.g0(formatHolder);
        final AudioRendererEventListener2.a aVar = this.O0;
        final Format2 format2 = formatHolder.f1027b;
        Handler handler = aVar.a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: b.i.a.c.t2.e
                @Override // java.lang.Runnable
                public final void run() {
                    AudioRendererEventListener2.a aVar2 = aVar;
                    Format2 format3 = format2;
                    DecoderReuseEvaluation decoderReuseEvaluation = decoderReuseEvaluationG0;
                    AudioRendererEventListener2 audioRendererEventListener2 = aVar2.f1126b;
                    int i = Util2.a;
                    audioRendererEventListener2.U(format3);
                    aVar2.f1126b.I(format3, decoderReuseEvaluation);
                }
            });
        }
        return decoderReuseEvaluationG0;
    }

    @Override // b.i.a.c.Renderer2, b.i.a.c.RendererCapabilities
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void h0(Format2 format2, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException {
        int iR;
        int i;
        Format2 format3 = this.S0;
        int[] iArr = null;
        if (format3 != null) {
            format2 = format3;
        } else if (this.S != null) {
            if ("audio/raw".equals(format2.w)) {
                iR = format2.L;
            } else if (Util2.a >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                iR = mediaFormat.getInteger("pcm-encoding");
            } else if (mediaFormat.containsKey("v-bits-per-sample")) {
                iR = Util2.r(mediaFormat.getInteger("v-bits-per-sample"));
            } else {
                iR = "audio/raw".equals(format2.w) ? format2.L : 2;
            }
            Format2.b bVar = new Format2.b();
            bVar.k = "audio/raw";
            bVar.f1025z = iR;
            bVar.A = format2.M;
            bVar.B = format2.N;
            bVar.f1023x = mediaFormat.getInteger("channel-count");
            bVar.f1024y = mediaFormat.getInteger("sample-rate");
            Format2 format2A = bVar.a();
            if (this.R0 && format2A.J == 6 && (i = format2.J) < 6) {
                iArr = new int[i];
                for (int i2 = 0; i2 < format2.J; i2++) {
                    iArr[i2] = i2;
                }
            }
            format2 = format2A;
        }
        try {
            this.P0.v(format2, 0, iArr);
        } catch (AudioSink.ConfigurationException e) {
            throw z(e, e.format, false, 5001);
        }
    }

    @Override // b.i.a.c.f3.MediaClock
    public void i(PlaybackParameters playbackParameters) {
        this.P0.i(playbackParameters);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void j0() {
        this.P0.p();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void k0(DecoderInputBuffer decoderInputBuffer) {
        if (!this.U0 || decoderInputBuffer.m()) {
            return;
        }
        if (Math.abs(decoderInputBuffer.n - this.T0) > 500000) {
            this.T0 = decoderInputBuffer.n;
        }
        this.U0 = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean m0(long j, long j2, @Nullable MediaCodecAdapter mediaCodecAdapter, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z2, boolean z3, Format2 format2) throws ExoPlaybackException {
        Objects.requireNonNull(byteBuffer);
        if (this.S0 != null && (i2 & 2) != 0) {
            Objects.requireNonNull(mediaCodecAdapter);
            mediaCodecAdapter.releaseOutputBuffer(i, false);
            return true;
        }
        if (z2) {
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.releaseOutputBuffer(i, false);
            }
            this.J0.f += i3;
            this.P0.p();
            return true;
        }
        try {
            if (!this.P0.s(byteBuffer, j3, i3)) {
                return false;
            }
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.releaseOutputBuffer(i, false);
            }
            this.J0.e += i3;
            return true;
        } catch (AudioSink.InitializationException e) {
            throw z(e, e.format, e.isRecoverable, 5001);
        } catch (AudioSink.WriteException e2) {
            throw z(e2, format2, e2.isRecoverable, 5002);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void p0() throws ExoPlaybackException {
        try {
            this.P0.j();
        } catch (AudioSink.WriteException e) {
            throw z(e, e.format, e.isRecoverable, 5002);
        }
    }

    @Override // b.i.a.c.BaseRenderer, b.i.a.c.PlayerMessage.b
    public void r(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 2) {
            this.P0.q(((Float) obj).floatValue());
        }
        if (i == 3) {
            this.P0.o((AudioAttributes) obj);
            return;
        }
        if (i == 6) {
            this.P0.x((AuxEffectInfo) obj);
            return;
        }
        switch (i) {
            case 9:
                this.P0.w(((Boolean) obj).booleanValue());
                break;
            case 10:
                this.P0.l(((Integer) obj).intValue());
                break;
            case 11:
                this.X0 = (Renderer2.a) obj;
                break;
        }
    }

    @Override // b.i.a.c.BaseRenderer, b.i.a.c.Renderer2
    @Nullable
    public MediaClock w() {
        return this;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean x0(Format2 format2) {
        return this.P0.a(format2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int y0(MediaCodecSelector mediaCodecSelector, Format2 format2) throws MediaCodecUtil.DecoderQueryException {
        if (!MimeTypes.h(format2.w)) {
            return 0;
        }
        int i = Util2.a >= 21 ? 32 : 0;
        int i2 = format2.P;
        boolean z2 = i2 != 0;
        boolean z3 = i2 == 0 || i2 == 2;
        if (z3 && this.P0.a(format2) && (!z2 || MediaCodecUtil.d("audio/raw", false, false) != null)) {
            return i | 12;
        }
        if ("audio/raw".equals(format2.w) && !this.P0.a(format2)) {
            return 1;
        }
        AudioSink audioSink = this.P0;
        int i3 = format2.J;
        int i4 = format2.K;
        Format2.b bVar = new Format2.b();
        bVar.k = "audio/raw";
        bVar.f1023x = i3;
        bVar.f1024y = i4;
        bVar.f1025z = 2;
        if (!audioSink.a(bVar.a())) {
            return 1;
        }
        List<MediaCodecInfo> listW = W(mediaCodecSelector, format2, false);
        if (listW.isEmpty()) {
            return 1;
        }
        if (!z3) {
            return 2;
        }
        MediaCodecInfo mediaCodecInfo = listW.get(0);
        boolean zE = mediaCodecInfo.e(format2);
        return ((zE && mediaCodecInfo.f(format2)) ? 16 : 8) | (zE ? 4 : 3) | i;
    }
}
