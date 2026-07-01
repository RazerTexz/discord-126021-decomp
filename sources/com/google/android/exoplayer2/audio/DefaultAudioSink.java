package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.PlaybackParameters;
import b.i.a.c.Renderer2;
import b.i.a.c.f3.Log2;
import b.i.a.c.f3.MimeTypes;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.t2.Ac3Util;
import b.i.a.c.t2.Ac4Util;
import b.i.a.c.t2.AudioAttributes;
import b.i.a.c.t2.AudioCapabilities;
import b.i.a.c.t2.AudioRendererEventListener2;
import b.i.a.c.t2.AudioTimestampPoller;
import b.i.a.c.t2.AudioTrackPositionTracker;
import b.i.a.c.t2.AuxEffectInfo;
import b.i.a.c.t2.ChannelMappingAudioProcessor;
import b.i.a.c.t2.FloatResamplingAudioProcessor;
import b.i.a.c.t2.MediaCodecAudioRenderer;
import b.i.a.c.t2.MpegAudioUtil;
import b.i.a.c.t2.ResamplingAudioProcessor;
import b.i.a.c.t2.SilenceSkippingAudioProcessor;
import b.i.a.c.t2.Sonic;
import b.i.a.c.t2.SonicAudioProcessor;
import b.i.a.c.t2.TrimmingAudioProcessor;
import com.discord.api.permission.Permission;
import com.discord.restapi.RestAPIAbortCodes;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultAudioSink implements AudioSink {
    public long A;
    public long B;
    public long C;
    public int D;
    public boolean E;
    public boolean F;
    public long G;
    public float H;
    public AudioProcessor[] I;
    public ByteBuffer[] J;

    @Nullable
    public ByteBuffer K;
    public int L;

    @Nullable
    public ByteBuffer M;
    public byte[] N;
    public int O;
    public int P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public int U;
    public AuxEffectInfo V;
    public boolean W;
    public long X;
    public boolean Y;
    public boolean Z;

    @Nullable
    public final AudioCapabilities a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f2915b;
    public final boolean c;
    public final ChannelMappingAudioProcessor d;
    public final TrimmingAudioProcessor e;
    public final AudioProcessor[] f;
    public final AudioProcessor[] g;
    public final ConditionVariable h;
    public final AudioTrackPositionTracker i;
    public final ArrayDeque<e> j;
    public final boolean k;
    public final int l;
    public h m;
    public final f<AudioSink.InitializationException> n;
    public final f<AudioSink.WriteException> o;

    @Nullable
    public AudioSink.a p;

    @Nullable
    public c q;
    public c r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public AudioTrack f2916s;
    public AudioAttributes t;

    @Nullable
    public e u;
    public e v;
    public PlaybackParameters w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public ByteBuffer f2917x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2918y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f2919z;

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
    }

    public class a extends Thread {
        public final /* synthetic */ AudioTrack j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, AudioTrack audioTrack) {
            super(str);
            this.j = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.j.flush();
                this.j.release();
            } finally {
                DefaultAudioSink.this.h.open();
            }
        }
    }

    public interface b {
        PlaybackParameters a(PlaybackParameters playbackParameters);

        long b(long j);

        long c();

        boolean d(boolean z2);
    }

    public static final class c {
        public final Format2 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2920b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final AudioProcessor[] i;

        public c(Format2 format2, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z2, AudioProcessor[] audioProcessorArr) {
            int iRound;
            this.a = format2;
            this.f2920b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
            this.i = audioProcessorArr;
            if (i7 != 0) {
                iRound = i7;
            } else {
                if (i2 == 0) {
                    float f = z2 ? 8.0f : 1.0f;
                    int minBufferSize = AudioTrack.getMinBufferSize(i4, i5, i6);
                    AnimatableValueParser.D(minBufferSize != -2);
                    long j = i4;
                    int iH = Util2.h(minBufferSize * 4, ((int) ((250000 * j) / 1000000)) * i3, Math.max(minBufferSize, ((int) ((j * 750000) / 1000000)) * i3));
                    iRound = f != 1.0f ? Math.round(iH * f) : iH;
                } else if (i2 == 1) {
                    iRound = e(50000000L);
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException();
                    }
                    iRound = e(250000L);
                }
            }
            this.h = iRound;
        }

        @RequiresApi(21)
        public static android.media.AudioAttributes d(AudioAttributes audioAttributes, boolean z2) {
            return z2 ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : audioAttributes.a();
        }

        public AudioTrack a(boolean z2, b.i.a.c.t2.AudioAttributes audioAttributes, int i) throws AudioSink.InitializationException {
            try {
                AudioTrack audioTrackB = b(z2, audioAttributes, i);
                int state = audioTrackB.getState();
                if (state == 1) {
                    return audioTrackB;
                }
                try {
                    audioTrackB.release();
                } catch (Exception unused) {
                }
                throw new AudioSink.InitializationException(state, this.e, this.f, this.h, this.a, f(), null);
            } catch (IllegalArgumentException | UnsupportedOperationException e) {
                throw new AudioSink.InitializationException(0, this.e, this.f, this.h, this.a, f(), e);
            }
        }

        public final AudioTrack b(boolean z2, b.i.a.c.t2.AudioAttributes audioAttributes, int i) {
            int i2 = Util2.a;
            if (i2 >= 29) {
                return new AudioTrack.Builder().setAudioAttributes(d(audioAttributes, z2)).setAudioFormat(DefaultAudioSink.y(this.e, this.f, this.g)).setTransferMode(1).setBufferSizeInBytes(this.h).setSessionId(i).setOffloadedPlayback(this.c == 1).build();
            }
            if (i2 >= 21) {
                return new AudioTrack(d(audioAttributes, z2), DefaultAudioSink.y(this.e, this.f, this.g), this.h, 1, i);
            }
            int iT = Util2.t(audioAttributes.m);
            return i == 0 ? new AudioTrack(iT, this.e, this.f, this.g, this.h, 1) : new AudioTrack(iT, this.e, this.f, this.g, this.h, 1, i);
        }

        public long c(long j) {
            return (j * 1000000) / ((long) this.e);
        }

        public final int e(long j) {
            int i;
            int i2 = this.g;
            switch (i2) {
                case 5:
                    i = RestAPIAbortCodes.RELATIONSHIP_INCOMING_DISABLED;
                    break;
                case 6:
                case 18:
                    i = 768000;
                    break;
                case 7:
                    i = 192000;
                    break;
                case 8:
                    i = 2250000;
                    break;
                case 9:
                    i = 40000;
                    break;
                case 10:
                    i = 100000;
                    break;
                case 11:
                    i = 16000;
                    break;
                case 12:
                    i = 7000;
                    break;
                case 13:
                default:
                    throw new IllegalArgumentException();
                case 14:
                    i = 3062500;
                    break;
                case 15:
                    i = 8000;
                    break;
                case 16:
                    i = 256000;
                    break;
                case 17:
                    i = 336000;
                    break;
            }
            if (i2 == 5) {
                i *= 2;
            }
            return (int) ((j * ((long) i)) / 1000000);
        }

        public boolean f() {
            return this.c == 1;
        }
    }

    public static class d implements b {
        public final AudioProcessor[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SilenceSkippingAudioProcessor f2921b;
        public final SonicAudioProcessor c;

        public d(AudioProcessor... audioProcessorArr) {
            SilenceSkippingAudioProcessor silenceSkippingAudioProcessor = new SilenceSkippingAudioProcessor();
            SonicAudioProcessor sonicAudioProcessor = new SonicAudioProcessor();
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 2];
            this.a = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.f2921b = silenceSkippingAudioProcessor;
            this.c = sonicAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length] = silenceSkippingAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length + 1] = sonicAudioProcessor;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public PlaybackParameters a(PlaybackParameters playbackParameters) {
            SonicAudioProcessor sonicAudioProcessor = this.c;
            float f = playbackParameters.k;
            if (sonicAudioProcessor.c != f) {
                sonicAudioProcessor.c = f;
                sonicAudioProcessor.i = true;
            }
            float f2 = playbackParameters.l;
            if (sonicAudioProcessor.d != f2) {
                sonicAudioProcessor.d = f2;
                sonicAudioProcessor.i = true;
            }
            return playbackParameters;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public long b(long j) {
            SonicAudioProcessor sonicAudioProcessor = this.c;
            if (sonicAudioProcessor.o < Permission.VIEW_CHANNEL) {
                return (long) (((double) sonicAudioProcessor.c) * j);
            }
            long j2 = sonicAudioProcessor.n;
            Sonic sonic = sonicAudioProcessor.j;
            Objects.requireNonNull(sonic);
            long j3 = j2 - ((long) ((sonic.k * sonic.f1118b) * 2));
            int i = sonicAudioProcessor.h.f2914b;
            int i2 = sonicAudioProcessor.g.f2914b;
            return i == i2 ? Util2.F(j, j3, sonicAudioProcessor.o) : Util2.F(j, j3 * ((long) i), sonicAudioProcessor.o * ((long) i2));
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public long c() {
            return this.f2921b.t;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.b
        public boolean d(boolean z2) {
            this.f2921b.m = z2;
            return z2;
        }
    }

    public static final class e {
        public final PlaybackParameters a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f2922b;
        public final long c;
        public final long d;

        public e(PlaybackParameters playbackParameters, boolean z2, long j, long j2, a aVar) {
            this.a = playbackParameters;
            this.f2922b = z2;
            this.c = j;
            this.d = j2;
        }
    }

    public static final class f<T extends Exception> {

        @Nullable
        public T a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f2923b;

        public f(long j) {
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: T extends java.lang.Exception */
        public void a(T t) throws Exception {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.a == null) {
                this.a = t;
                this.f2923b = 100 + jElapsedRealtime;
            }
            if (jElapsedRealtime >= this.f2923b) {
                T t2 = this.a;
                if (t2 != t) {
                    t2.addSuppressed(t);
                }
                T t3 = this.a;
                this.a = null;
                throw t3;
            }
        }
    }

    public final class g implements AudioTrackPositionTracker.a {
        public g(a aVar) {
        }

        @Override // b.i.a.c.t2.AudioTrackPositionTracker.a
        public void a(final long j) {
            final AudioRendererEventListener2.a aVar;
            Handler handler;
            AudioSink.a aVar2 = DefaultAudioSink.this.p;
            if (aVar2 == null || (handler = (aVar = MediaCodecAudioRenderer.this.O0).a) == null) {
                return;
            }
            handler.post(new Runnable() { // from class: b.i.a.c.t2.h
                @Override // java.lang.Runnable
                public final void run() {
                    AudioRendererEventListener2.a aVar3 = aVar;
                    long j2 = j;
                    AudioRendererEventListener2 audioRendererEventListener2 = aVar3.f1126b;
                    int i = Util2.a;
                    audioRendererEventListener2.R(j2);
                }
            });
        }

        @Override // b.i.a.c.t2.AudioTrackPositionTracker.a
        public void b(final int i, final long j) {
            if (DefaultAudioSink.this.p != null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                DefaultAudioSink defaultAudioSink = DefaultAudioSink.this;
                final long j2 = jElapsedRealtime - defaultAudioSink.X;
                final AudioRendererEventListener2.a aVar = MediaCodecAudioRenderer.this.O0;
                Handler handler = aVar.a;
                if (handler != null) {
                    handler.post(new Runnable() { // from class: b.i.a.c.t2.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            AudioRendererEventListener2.a aVar2 = aVar;
                            int i2 = i;
                            long j3 = j;
                            long j4 = j2;
                            AudioRendererEventListener2 audioRendererEventListener2 = aVar2.f1126b;
                            int i3 = Util2.a;
                            audioRendererEventListener2.e0(i2, j3, j4);
                        }
                    });
                }
            }
        }

        @Override // b.i.a.c.t2.AudioTrackPositionTracker.a
        public void c(long j) {
            StringBuilder sb = new StringBuilder(61);
            sb.append("Ignoring impossibly large audio latency: ");
            sb.append(j);
            Log.w("DefaultAudioSink", sb.toString());
        }

        @Override // b.i.a.c.t2.AudioTrackPositionTracker.a
        public void d(long j, long j2, long j3, long j4) {
            DefaultAudioSink defaultAudioSink = DefaultAudioSink.this;
            c cVar = defaultAudioSink.r;
            long j5 = cVar.c == 0 ? defaultAudioSink.f2919z / ((long) cVar.f2920b) : defaultAudioSink.A;
            long jE = defaultAudioSink.E();
            StringBuilder sbR = outline.R(Opcodes.INVOKEVIRTUAL, "Spurious audio timestamp (frame position mismatch): ", j, ", ");
            sbR.append(j2);
            sbR.append(", ");
            sbR.append(j3);
            sbR.append(", ");
            sbR.append(j4);
            sbR.append(", ");
            sbR.append(j5);
            sbR.append(", ");
            sbR.append(jE);
            Log.w("DefaultAudioSink", sbR.toString());
        }

        @Override // b.i.a.c.t2.AudioTrackPositionTracker.a
        public void e(long j, long j2, long j3, long j4) {
            DefaultAudioSink defaultAudioSink = DefaultAudioSink.this;
            c cVar = defaultAudioSink.r;
            long j5 = cVar.c == 0 ? defaultAudioSink.f2919z / ((long) cVar.f2920b) : defaultAudioSink.A;
            long jE = defaultAudioSink.E();
            StringBuilder sbR = outline.R(180, "Spurious audio timestamp (system clock mismatch): ", j, ", ");
            sbR.append(j2);
            sbR.append(", ");
            sbR.append(j3);
            sbR.append(", ");
            sbR.append(j4);
            sbR.append(", ");
            sbR.append(j5);
            sbR.append(", ");
            sbR.append(jE);
            Log.w("DefaultAudioSink", sbR.toString());
        }
    }

    @RequiresApi(29)
    public final class h {
        public final Handler a = new Handler();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AudioTrack.StreamEventCallback f2924b;

        public class a extends AudioTrack.StreamEventCallback {
            public a(DefaultAudioSink defaultAudioSink) {
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onDataRequest(AudioTrack audioTrack, int i) {
                Renderer2.a aVar;
                AnimatableValueParser.D(audioTrack == DefaultAudioSink.this.f2916s);
                DefaultAudioSink defaultAudioSink = DefaultAudioSink.this;
                AudioSink.a aVar2 = defaultAudioSink.p;
                if (aVar2 == null || !defaultAudioSink.S || (aVar = MediaCodecAudioRenderer.this.X0) == null) {
                    return;
                }
                aVar.a();
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onTearDown(AudioTrack audioTrack) {
                Renderer2.a aVar;
                AnimatableValueParser.D(audioTrack == DefaultAudioSink.this.f2916s);
                DefaultAudioSink defaultAudioSink = DefaultAudioSink.this;
                AudioSink.a aVar2 = defaultAudioSink.p;
                if (aVar2 == null || !defaultAudioSink.S || (aVar = MediaCodecAudioRenderer.this.X0) == null) {
                    return;
                }
                aVar.a();
            }
        }

        public h() {
            this.f2924b = new a(DefaultAudioSink.this);
        }
    }

    public DefaultAudioSink(@Nullable AudioCapabilities audioCapabilities, b bVar, boolean z2, boolean z3, int i) {
        this.a = audioCapabilities;
        this.f2915b = bVar;
        int i2 = Util2.a;
        this.c = i2 >= 21 && z2;
        this.k = i2 >= 23 && z3;
        this.l = i2 < 29 ? 0 : i;
        this.h = new ConditionVariable(true);
        this.i = new AudioTrackPositionTracker(new g(null));
        ChannelMappingAudioProcessor channelMappingAudioProcessor = new ChannelMappingAudioProcessor();
        this.d = channelMappingAudioProcessor;
        TrimmingAudioProcessor trimmingAudioProcessor = new TrimmingAudioProcessor();
        this.e = trimmingAudioProcessor;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new ResamplingAudioProcessor(), channelMappingAudioProcessor, trimmingAudioProcessor);
        Collections.addAll(arrayList, ((d) bVar).a);
        this.f = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[0]);
        this.g = new AudioProcessor[]{new FloatResamplingAudioProcessor()};
        this.H = 1.0f;
        this.t = b.i.a.c.t2.AudioAttributes.j;
        this.U = 0;
        this.V = new AuxEffectInfo(0, 0.0f);
        PlaybackParameters playbackParameters = PlaybackParameters.j;
        this.v = new e(playbackParameters, false, 0L, 0L, null);
        this.w = playbackParameters;
        this.P = -1;
        this.I = new AudioProcessor[0];
        this.J = new ByteBuffer[0];
        this.j = new ArrayDeque<>();
        this.n = new f<>(100L);
        this.o = new f<>(100L);
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00b5  */
    @Nullable
    public static Pair<Integer, Integer> A(Format2 format2, @Nullable AudioCapabilities audioCapabilities) {
        if (audioCapabilities == null) {
            return null;
        }
        String str = format2.w;
        Objects.requireNonNull(str);
        int iB = MimeTypes.b(str, format2.t);
        int i = 0;
        int i2 = 6;
        if (!(iB == 5 || iB == 6 || iB == 18 || iB == 17 || iB == 7 || iB == 8 || iB == 14)) {
            return null;
        }
        if (iB == 18 && !audioCapabilities.a(18)) {
            iB = 6;
        } else if (iB == 8 && !audioCapabilities.a(8)) {
            iB = 7;
        }
        if (!audioCapabilities.a(iB)) {
            return null;
        }
        if (iB != 18) {
            i = format2.J;
            if (i > audioCapabilities.e) {
                return null;
            }
        } else if (Util2.a >= 29) {
            int i3 = format2.K;
            android.media.AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(1).setContentType(3).build();
            for (int i4 = 8; i4 > 0; i4--) {
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(18).setSampleRate(i3).setChannelMask(Util2.n(i4)).build(), audioAttributesBuild)) {
                    i = i4;
                    break;
                }
            }
            if (i == 0) {
                Log.w("DefaultAudioSink", "E-AC3 JOC encoding supported but no channel count supported");
                return null;
            }
        } else {
            i = 6;
        }
        int i5 = Util2.a;
        if (i5 > 28) {
            i2 = i;
        } else if (i == 7) {
            i2 = 8;
        } else if (i != 3 && i != 4 && i != 5) {
            i2 = i;
        }
        if (i5 <= 26 && "fugu".equals(Util2.f968b) && i2 == 1) {
            i2 = 2;
        }
        int iN = Util2.n(i2);
        if (iN == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(iB), Integer.valueOf(iN));
    }

    public static boolean H(AudioTrack audioTrack) {
        return Util2.a >= 29 && audioTrack.isOffloadedPlayback();
    }

    @RequiresApi(21)
    public static AudioFormat y(int i, int i2, int i3) {
        return new AudioFormat.Builder().setSampleRate(i).setChannelMask(i2).setEncoding(i3).build();
    }

    public final e B() {
        e eVar = this.u;
        if (eVar != null) {
            return eVar;
        }
        return !this.j.isEmpty() ? this.j.getLast() : this.v;
    }

    @RequiresApi(29)
    @SuppressLint({"WrongConstant"})
    public final int C(AudioFormat audioFormat, android.media.AudioAttributes audioAttributes) {
        int i = Util2.a;
        if (i >= 31) {
            return AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        }
        if (AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return (i == 30 && Util2.d.startsWith("Pixel")) ? 2 : 1;
        }
        return 0;
    }

    public boolean D() {
        return B().f2922b;
    }

    public final long E() {
        c cVar = this.r;
        return cVar.c == 0 ? this.B / ((long) cVar.d) : this.C;
    }

    public final void F() throws AudioSink.InitializationException {
        this.h.block();
        try {
            c cVar = this.r;
            Objects.requireNonNull(cVar);
            AudioTrack audioTrackA = cVar.a(this.W, this.t, this.U);
            this.f2916s = audioTrackA;
            if (H(audioTrackA)) {
                AudioTrack audioTrack = this.f2916s;
                if (this.m == null) {
                    this.m = new h();
                }
                h hVar = this.m;
                final Handler handler = hVar.a;
                Objects.requireNonNull(handler);
                audioTrack.registerStreamEventCallback(new Executor() { // from class: b.i.a.c.t2.k
                    @Override // java.util.concurrent.Executor
                    public final void execute(Runnable runnable) {
                        handler.post(runnable);
                    }
                }, hVar.f2924b);
                if (this.l != 3) {
                    AudioTrack audioTrack2 = this.f2916s;
                    Format2 format2 = this.r.a;
                    audioTrack2.setOffloadDelayPadding(format2.M, format2.N);
                }
            }
            this.U = this.f2916s.getAudioSessionId();
            AudioTrackPositionTracker audioTrackPositionTracker = this.i;
            AudioTrack audioTrack3 = this.f2916s;
            c cVar2 = this.r;
            audioTrackPositionTracker.e(audioTrack3, cVar2.c == 2, cVar2.g, cVar2.d, cVar2.h);
            N();
            int i = this.V.a;
            if (i != 0) {
                this.f2916s.attachAuxEffect(i);
                this.f2916s.setAuxEffectSendLevel(this.V.f1134b);
            }
            this.F = true;
        } catch (AudioSink.InitializationException e2) {
            if (this.r.f()) {
                this.Y = true;
            }
            AudioSink.a aVar = this.p;
            if (aVar != null) {
                ((MediaCodecAudioRenderer.b) aVar).a(e2);
            }
            throw e2;
        }
    }

    public final boolean G() {
        return this.f2916s != null;
    }

    public final void I() {
        if (this.R) {
            return;
        }
        this.R = true;
        AudioTrackPositionTracker audioTrackPositionTracker = this.i;
        long jE = E();
        audioTrackPositionTracker.f1133z = audioTrackPositionTracker.b();
        audioTrackPositionTracker.f1131x = SystemClock.elapsedRealtime() * 1000;
        audioTrackPositionTracker.A = jE;
        this.f2916s.stop();
        this.f2918y = 0;
    }

    public final void J(long j) throws Exception {
        ByteBuffer byteBuffer;
        int length = this.I.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.J[i - 1];
            } else {
                byteBuffer = this.K;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.a;
                }
            }
            if (i == length) {
                Q(byteBuffer, j);
            } else {
                AudioProcessor audioProcessor = this.I[i];
                if (i > this.P) {
                    audioProcessor.c(byteBuffer);
                }
                ByteBuffer output = audioProcessor.getOutput();
                this.J[i] = output;
                if (output.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i--;
            }
        }
    }

    public final void K() {
        this.f2919z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.C = 0L;
        this.Z = false;
        this.D = 0;
        this.v = new e(z(), D(), 0L, 0L, null);
        this.G = 0L;
        this.u = null;
        this.j.clear();
        this.K = null;
        this.L = 0;
        this.M = null;
        this.R = false;
        this.Q = false;
        this.P = -1;
        this.f2917x = null;
        this.f2918y = 0;
        this.e.o = 0L;
        h();
    }

    public final void L(PlaybackParameters playbackParameters, boolean z2) {
        e eVarB = B();
        if (playbackParameters.equals(eVarB.a) && z2 == eVarB.f2922b) {
            return;
        }
        e eVar = new e(playbackParameters, z2, -9223372036854775807L, -9223372036854775807L, null);
        if (G()) {
            this.u = eVar;
        } else {
            this.v = eVar;
        }
    }

    @RequiresApi(23)
    public final void M(PlaybackParameters playbackParameters) {
        if (G()) {
            try {
                this.f2916s.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(playbackParameters.k).setPitch(playbackParameters.l).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e2) {
                Log2.c("DefaultAudioSink", "Failed to set playback params", e2);
            }
            playbackParameters = new PlaybackParameters(this.f2916s.getPlaybackParams().getSpeed(), this.f2916s.getPlaybackParams().getPitch());
            AudioTrackPositionTracker audioTrackPositionTracker = this.i;
            audioTrackPositionTracker.j = playbackParameters.k;
            AudioTimestampPoller audioTimestampPoller = audioTrackPositionTracker.f;
            if (audioTimestampPoller != null) {
                audioTimestampPoller.a();
            }
        }
        this.w = playbackParameters;
    }

    public final void N() {
        if (G()) {
            if (Util2.a >= 21) {
                this.f2916s.setVolume(this.H);
                return;
            }
            AudioTrack audioTrack = this.f2916s;
            float f2 = this.H;
            audioTrack.setStereoVolume(f2, f2);
        }
    }

    public final boolean O() {
        if (this.W || !"audio/raw".equals(this.r.a.w)) {
            return false;
        }
        return !(this.c && Util2.y(this.r.a.L));
    }

    public final boolean P(Format2 format2, b.i.a.c.t2.AudioAttributes audioAttributes) {
        int iN;
        int iC;
        if (Util2.a < 29 || this.l == 0) {
            return false;
        }
        String str = format2.w;
        Objects.requireNonNull(str);
        int iB = MimeTypes.b(str, format2.t);
        if (iB == 0 || (iN = Util2.n(format2.J)) == 0 || (iC = C(y(format2.K, iN, iB), audioAttributes.a())) == 0) {
            return false;
        }
        if (iC == 1) {
            return ((format2.M != 0 || format2.N != 0) && (this.l == 1)) ? false : true;
        }
        if (iC == 2) {
            return true;
        }
        throw new IllegalStateException();
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ef  */
    public final void Q(ByteBuffer byteBuffer, long j) throws Exception {
        int iWrite;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.M;
            if (byteBuffer2 != null) {
                AnimatableValueParser.j(byteBuffer2 == byteBuffer);
            } else {
                this.M = byteBuffer;
                if (Util2.a < 21) {
                    int iRemaining = byteBuffer.remaining();
                    byte[] bArr = this.N;
                    if (bArr == null || bArr.length < iRemaining) {
                        this.N = new byte[iRemaining];
                    }
                    int iPosition = byteBuffer.position();
                    byteBuffer.get(this.N, 0, iRemaining);
                    byteBuffer.position(iPosition);
                    this.O = 0;
                }
            }
            int iRemaining2 = byteBuffer.remaining();
            int i = Util2.a;
            if (i < 21) {
                AudioTrackPositionTracker audioTrackPositionTracker = this.i;
                int iB = audioTrackPositionTracker.e - ((int) (this.B - (audioTrackPositionTracker.b() * ((long) audioTrackPositionTracker.d))));
                if (iB > 0) {
                    iWrite = this.f2916s.write(this.N, this.O, Math.min(iRemaining2, iB));
                    if (iWrite > 0) {
                        this.O += iWrite;
                        byteBuffer.position(byteBuffer.position() + iWrite);
                    }
                } else {
                    iWrite = 0;
                }
            } else if (this.W) {
                AnimatableValueParser.D(j != -9223372036854775807L);
                AudioTrack audioTrack = this.f2916s;
                if (i >= 26) {
                    iWrite = audioTrack.write(byteBuffer, iRemaining2, 1, j * 1000);
                } else {
                    if (this.f2917x == null) {
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
                        this.f2917x = byteBufferAllocate;
                        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
                        this.f2917x.putInt(1431633921);
                    }
                    if (this.f2918y == 0) {
                        this.f2917x.putInt(4, iRemaining2);
                        this.f2917x.putLong(8, j * 1000);
                        this.f2917x.position(0);
                        this.f2918y = iRemaining2;
                    }
                    int iRemaining3 = this.f2917x.remaining();
                    if (iRemaining3 <= 0) {
                        iWrite = audioTrack.write(byteBuffer, iRemaining2, 1);
                        if (iWrite < 0) {
                            this.f2918y = 0;
                        } else {
                            this.f2918y -= iWrite;
                        }
                    } else {
                        int iWrite2 = audioTrack.write(this.f2917x, iRemaining3, 1);
                        if (iWrite2 < 0) {
                            this.f2918y = 0;
                            iWrite = iWrite2;
                        } else if (iWrite2 < iRemaining3) {
                            iWrite = 0;
                        } else {
                            iWrite = audioTrack.write(byteBuffer, iRemaining2, 1);
                            if (iWrite < 0) {
                                this.f2918y = 0;
                            } else {
                                this.f2918y -= iWrite;
                            }
                        }
                    }
                }
            } else {
                iWrite = this.f2916s.write(byteBuffer, iRemaining2, 1);
            }
            this.X = SystemClock.elapsedRealtime();
            if (iWrite < 0) {
                boolean z2 = (i >= 24 && iWrite == -6) || iWrite == -32;
                if (z2 && this.r.f()) {
                    this.Y = true;
                }
                AudioSink.WriteException writeException = new AudioSink.WriteException(iWrite, this.r.a, z2);
                AudioSink.a aVar = this.p;
                if (aVar != null) {
                    ((MediaCodecAudioRenderer.b) aVar).a(writeException);
                }
                if (writeException.isRecoverable) {
                    throw writeException;
                }
                this.o.a(writeException);
                return;
            }
            this.o.a = null;
            if (H(this.f2916s)) {
                long j2 = this.C;
                if (j2 > 0) {
                    this.Z = false;
                }
                if (this.S && this.p != null && iWrite < iRemaining2 && !this.Z) {
                    AudioTrackPositionTracker audioTrackPositionTracker2 = this.i;
                    long jM = Util2.M(audioTrackPositionTracker2.a(j2 - audioTrackPositionTracker2.b()));
                    Renderer2.a aVar2 = MediaCodecAudioRenderer.this.X0;
                    if (aVar2 != null) {
                        aVar2.b(jM);
                    }
                }
            }
            int i2 = this.r.c;
            if (i2 == 0) {
                this.B += (long) iWrite;
            }
            if (iWrite == iRemaining2) {
                if (i2 != 0) {
                    AnimatableValueParser.D(byteBuffer == this.K);
                    this.C += (long) (this.D * this.L);
                }
                this.M = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean a(Format2 format2) {
        return u(format2) != 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean b() {
        return !G() || (this.Q && !k());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public PlaybackParameters c() {
        return this.k ? this.w : z();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void d() {
        boolean z2 = false;
        this.S = false;
        if (G()) {
            AudioTrackPositionTracker audioTrackPositionTracker = this.i;
            audioTrackPositionTracker.l = 0L;
            audioTrackPositionTracker.w = 0;
            audioTrackPositionTracker.v = 0;
            audioTrackPositionTracker.m = 0L;
            audioTrackPositionTracker.C = 0L;
            audioTrackPositionTracker.F = 0L;
            audioTrackPositionTracker.k = false;
            if (audioTrackPositionTracker.f1131x == -9223372036854775807L) {
                AudioTimestampPoller audioTimestampPoller = audioTrackPositionTracker.f;
                Objects.requireNonNull(audioTimestampPoller);
                audioTimestampPoller.a();
                z2 = true;
            }
            if (z2) {
                this.f2916s.pause();
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void e() {
        this.S = true;
        if (G()) {
            AudioTimestampPoller audioTimestampPoller = this.i.f;
            Objects.requireNonNull(audioTimestampPoller);
            audioTimestampPoller.a();
            this.f2916s.play();
        }
    }

    public final void f(long j) {
        final AudioRendererEventListener2.a aVar;
        Handler handler;
        PlaybackParameters playbackParametersA = O() ? this.f2915b.a(z()) : PlaybackParameters.j;
        final boolean zD = O() ? this.f2915b.d(D()) : false;
        this.j.add(new e(playbackParametersA, zD, Math.max(0L, j), this.r.c(E()), null));
        AudioProcessor[] audioProcessorArr = this.r.i;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : audioProcessorArr) {
            if (audioProcessor.a()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.I = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.J = new ByteBuffer[size];
        h();
        AudioSink.a aVar2 = this.p;
        if (aVar2 == null || (handler = (aVar = MediaCodecAudioRenderer.this.O0).a) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: b.i.a.c.t2.a
            @Override // java.lang.Runnable
            public final void run() {
                AudioRendererEventListener2.a aVar3 = aVar;
                boolean z2 = zD;
                AudioRendererEventListener2 audioRendererEventListener2 = aVar3.f1126b;
                int i = Util2.a;
                audioRendererEventListener2.d(z2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void flush() {
        if (G()) {
            K();
            AudioTrack audioTrack = this.i.c;
            Objects.requireNonNull(audioTrack);
            if (audioTrack.getPlayState() == 3) {
                this.f2916s.pause();
            }
            if (H(this.f2916s)) {
                h hVar = this.m;
                Objects.requireNonNull(hVar);
                this.f2916s.unregisterStreamEventCallback(hVar.f2924b);
                hVar.a.removeCallbacksAndMessages(null);
            }
            AudioTrack audioTrack2 = this.f2916s;
            this.f2916s = null;
            if (Util2.a < 21 && !this.T) {
                this.U = 0;
            }
            c cVar = this.q;
            if (cVar != null) {
                this.r = cVar;
                this.q = null;
            }
            this.i.d();
            this.h.close();
            new a("ExoPlayer:AudioTrackReleaseThread", audioTrack2).start();
        }
        this.o.a = null;
        this.n.a = null;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001c  */
    /* JADX WARN: Code duplicated, block: B:14:0x0028 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x0029  */
    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0029 -> B:5:0x0009). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final boolean g() throws com.google.android.exoplayer2.audio.AudioSink.WriteException {
        /*
            r9 = this;
            int r0 = r9.P
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto Lb
            r9.P = r3
        L9:
            r0 = 1
            goto Lc
        Lb:
            r0 = 0
        Lc:
            int r4 = r9.P
            com.google.android.exoplayer2.audio.AudioProcessor[] r5 = r9.I
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L2f
            r4 = r5[r4]
            if (r0 == 0) goto L1f
            r4.e()
        L1f:
            r9.J(r7)
            boolean r0 = r4.b()
            if (r0 != 0) goto L29
            return r3
        L29:
            int r0 = r9.P
            int r0 = r0 + r2
            r9.P = r0
            goto L9
        L2f:
            java.nio.ByteBuffer r0 = r9.M
            if (r0 == 0) goto L3b
            r9.Q(r0, r7)
            java.nio.ByteBuffer r0 = r9.M
            if (r0 == 0) goto L3b
            return r3
        L3b:
            r9.P = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DefaultAudioSink.g():boolean");
    }

    public final void h() {
        int i = 0;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.I;
            if (i >= audioProcessorArr.length) {
                return;
            }
            AudioProcessor audioProcessor = audioProcessorArr[i];
            audioProcessor.flush();
            this.J[i] = audioProcessor.getOutput();
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void i(PlaybackParameters playbackParameters) {
        PlaybackParameters playbackParameters2 = new PlaybackParameters(Util2.g(playbackParameters.k, 0.1f, 8.0f), Util2.g(playbackParameters.l, 0.1f, 8.0f));
        if (!this.k || Util2.a < 23) {
            L(playbackParameters2, D());
        } else {
            M(playbackParameters2);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void j() throws AudioSink.WriteException {
        if (!this.Q && G() && g()) {
            I();
            this.Q = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean k() {
        return G() && this.i.c(E());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void l(int i) {
        if (this.U != i) {
            this.U = i;
            this.T = i != 0;
            flush();
        }
    }

    /* JADX WARN: Code duplicated, block: B:60:0x010f  */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long m(boolean z2) {
        long jA;
        long jQ;
        boolean timestamp;
        Method method;
        if (!G() || this.F) {
            return Long.MIN_VALUE;
        }
        AudioTrackPositionTracker audioTrackPositionTracker = this.i;
        AudioTrack audioTrack = audioTrackPositionTracker.c;
        Objects.requireNonNull(audioTrack);
        if (audioTrack.getPlayState() == 3) {
            long jA2 = audioTrackPositionTracker.a(audioTrackPositionTracker.b());
            if (jA2 != 0) {
                long jNanoTime = System.nanoTime() / 1000;
                if (jNanoTime - audioTrackPositionTracker.m >= 30000) {
                    long[] jArr = audioTrackPositionTracker.f1129b;
                    int i = audioTrackPositionTracker.v;
                    jArr[i] = jA2 - jNanoTime;
                    audioTrackPositionTracker.v = (i + 1) % 10;
                    int i2 = audioTrackPositionTracker.w;
                    if (i2 < 10) {
                        audioTrackPositionTracker.w = i2 + 1;
                    }
                    audioTrackPositionTracker.m = jNanoTime;
                    audioTrackPositionTracker.l = 0L;
                    int i3 = 0;
                    while (true) {
                        int i4 = audioTrackPositionTracker.w;
                        if (i3 >= i4) {
                            break;
                        }
                        audioTrackPositionTracker.l = (audioTrackPositionTracker.f1129b[i3] / ((long) i4)) + audioTrackPositionTracker.l;
                        i3++;
                    }
                }
                if (!audioTrackPositionTracker.h) {
                    AudioTimestampPoller audioTimestampPoller = audioTrackPositionTracker.f;
                    Objects.requireNonNull(audioTimestampPoller);
                    AudioTimestampPoller.a aVar = audioTimestampPoller.a;
                    if (aVar == null || jNanoTime - audioTimestampPoller.e < audioTimestampPoller.d) {
                        timestamp = false;
                    } else {
                        audioTimestampPoller.e = jNanoTime;
                        timestamp = aVar.a.getTimestamp(aVar.f1128b);
                        if (timestamp) {
                            long j = aVar.f1128b.framePosition;
                            if (aVar.d > j) {
                                aVar.c++;
                            }
                            aVar.d = j;
                            aVar.e = j + (aVar.c << 32);
                        }
                        int i5 = audioTimestampPoller.f1127b;
                        if (i5 != 0) {
                            if (i5 != 1) {
                                if (i5 != 2) {
                                    if (i5 != 3) {
                                        if (i5 != 4) {
                                            throw new IllegalStateException();
                                        }
                                    } else if (timestamp) {
                                        audioTimestampPoller.a();
                                    }
                                } else if (!timestamp) {
                                    audioTimestampPoller.a();
                                }
                            } else if (!timestamp) {
                                audioTimestampPoller.a();
                            } else if (audioTimestampPoller.a.e > audioTimestampPoller.f) {
                                audioTimestampPoller.b(2);
                            }
                        } else if (timestamp) {
                            AudioTimestampPoller.a aVar2 = audioTimestampPoller.a;
                            if (aVar2.f1128b.nanoTime / 1000 >= audioTimestampPoller.c) {
                                audioTimestampPoller.f = aVar2.e;
                                audioTimestampPoller.b(1);
                            } else {
                                timestamp = false;
                            }
                        } else if (jNanoTime - audioTimestampPoller.c > 500000) {
                            audioTimestampPoller.b(3);
                        }
                    }
                    if (timestamp) {
                        AudioTimestampPoller.a aVar3 = audioTimestampPoller.a;
                        long j2 = aVar3 != null ? aVar3.f1128b.nanoTime / 1000 : -9223372036854775807L;
                        long j3 = aVar3 != null ? aVar3.e : -1L;
                        if (Math.abs(j2 - jNanoTime) > 5000000) {
                            audioTrackPositionTracker.a.e(j3, j2, jNanoTime, jA2);
                            audioTimestampPoller.b(4);
                        } else if (Math.abs(audioTrackPositionTracker.a(j3) - jA2) > 5000000) {
                            audioTrackPositionTracker.a.d(j3, j2, jNanoTime, jA2);
                            audioTimestampPoller.b(4);
                        } else if (audioTimestampPoller.f1127b == 4) {
                            audioTimestampPoller.a();
                        }
                    }
                    if (audioTrackPositionTracker.q && (method = audioTrackPositionTracker.n) != null && jNanoTime - audioTrackPositionTracker.r >= 500000) {
                        try {
                            AudioTrack audioTrack2 = audioTrackPositionTracker.c;
                            Objects.requireNonNull(audioTrack2);
                            Integer num = (Integer) method.invoke(audioTrack2, new Object[0]);
                            int i6 = Util2.a;
                            long jIntValue = (((long) num.intValue()) * 1000) - audioTrackPositionTracker.i;
                            audioTrackPositionTracker.o = jIntValue;
                            long jMax = Math.max(jIntValue, 0L);
                            audioTrackPositionTracker.o = jMax;
                            if (jMax > 5000000) {
                                audioTrackPositionTracker.a.c(jMax);
                                audioTrackPositionTracker.o = 0L;
                            }
                        } catch (Exception unused) {
                            audioTrackPositionTracker.n = null;
                        }
                        audioTrackPositionTracker.r = jNanoTime;
                    }
                }
            }
        }
        long jNanoTime2 = System.nanoTime() / 1000;
        AudioTimestampPoller audioTimestampPoller2 = audioTrackPositionTracker.f;
        Objects.requireNonNull(audioTimestampPoller2);
        boolean z3 = audioTimestampPoller2.f1127b == 2;
        if (z3) {
            AudioTimestampPoller.a aVar4 = audioTimestampPoller2.a;
            long jA3 = audioTrackPositionTracker.a(aVar4 != null ? aVar4.e : -1L);
            AudioTimestampPoller.a aVar5 = audioTimestampPoller2.a;
            jA = Util2.q(jNanoTime2 - (aVar5 != null ? aVar5.f1128b.nanoTime / 1000 : -9223372036854775807L), audioTrackPositionTracker.j) + jA3;
        } else {
            jA = audioTrackPositionTracker.w == 0 ? audioTrackPositionTracker.a(audioTrackPositionTracker.b()) : audioTrackPositionTracker.l + jNanoTime2;
            if (!z2) {
                jA = Math.max(0L, jA - audioTrackPositionTracker.o);
            }
        }
        if (audioTrackPositionTracker.D != z3) {
            audioTrackPositionTracker.F = audioTrackPositionTracker.C;
            audioTrackPositionTracker.E = audioTrackPositionTracker.B;
        }
        long j4 = jNanoTime2 - audioTrackPositionTracker.F;
        if (j4 < 1000000) {
            long jQ2 = Util2.q(j4, audioTrackPositionTracker.j) + audioTrackPositionTracker.E;
            long j5 = (j4 * 1000) / 1000000;
            jA = (((1000 - j5) * jQ2) + (jA * j5)) / 1000;
        }
        if (!audioTrackPositionTracker.k) {
            long j6 = audioTrackPositionTracker.B;
            if (jA > j6) {
                audioTrackPositionTracker.k = true;
                long jM = Util2.M(jA - j6);
                float f2 = audioTrackPositionTracker.j;
                if (f2 != 1.0f) {
                    jM = Math.round(jM / ((double) f2));
                }
                audioTrackPositionTracker.a.a(System.currentTimeMillis() - Util2.M(jM));
            }
        }
        audioTrackPositionTracker.C = jNanoTime2;
        audioTrackPositionTracker.B = jA;
        audioTrackPositionTracker.D = z3;
        long jMin = Math.min(jA, this.r.c(E()));
        while (!this.j.isEmpty() && jMin >= this.j.getFirst().d) {
            this.v = this.j.remove();
        }
        e eVar = this.v;
        long j7 = jMin - eVar.d;
        if (eVar.a.equals(PlaybackParameters.j)) {
            jQ = this.v.c + j7;
        } else if (this.j.isEmpty()) {
            jQ = this.f2915b.b(j7) + this.v.c;
        } else {
            e first = this.j.getFirst();
            jQ = first.c - Util2.q(first.d - jMin, this.v.a.k);
        }
        return this.r.c(this.f2915b.c()) + jQ;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void n() {
        if (this.W) {
            this.W = false;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void o(b.i.a.c.t2.AudioAttributes audioAttributes) {
        if (this.t.equals(audioAttributes)) {
            return;
        }
        this.t = audioAttributes;
        if (this.W) {
            return;
        }
        flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void p() {
        this.E = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void q(float f2) {
        if (this.H != f2) {
            this.H = f2;
            N();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void r() {
        AnimatableValueParser.D(Util2.a >= 21);
        AnimatableValueParser.D(this.T);
        if (this.W) {
            return;
        }
        this.W = true;
        flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        flush();
        for (AudioProcessor audioProcessor : this.f) {
            audioProcessor.reset();
        }
        for (AudioProcessor audioProcessor2 : this.g) {
            audioProcessor2.reset();
        }
        this.S = false;
        this.Y = false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:149:0x0292 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:64:0x00ee  */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean s(ByteBuffer byteBuffer, long j, int i) throws Exception {
        boolean z2;
        boolean z3;
        int i2;
        int i3;
        byte b2;
        int i4;
        byte b3;
        int i5;
        ByteBuffer byteBuffer2 = this.K;
        AnimatableValueParser.j(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.q != null) {
            if (!g()) {
                return false;
            }
            c cVar = this.q;
            c cVar2 = this.r;
            Objects.requireNonNull(cVar);
            if (cVar2.c == cVar.c && cVar2.g == cVar.g && cVar2.e == cVar.e && cVar2.f == cVar.f && cVar2.d == cVar.d) {
                this.r = this.q;
                this.q = null;
                if (H(this.f2916s) && this.l != 3) {
                    this.f2916s.setOffloadEndOfStream();
                    AudioTrack audioTrack = this.f2916s;
                    Format2 format2 = this.r.a;
                    audioTrack.setOffloadDelayPadding(format2.M, format2.N);
                    this.Z = true;
                }
            } else {
                I();
                if (k()) {
                    return false;
                }
                flush();
            }
            f(j);
        }
        if (!G()) {
            try {
                F();
            } catch (AudioSink.InitializationException e2) {
                if (e2.isRecoverable) {
                    throw e2;
                }
                this.n.a(e2);
                return false;
            }
        }
        this.n.a = null;
        if (this.F) {
            this.G = Math.max(0L, j);
            this.E = false;
            this.F = false;
            if (this.k && Util2.a >= 23) {
                M(this.w);
            }
            f(j);
            if (this.S) {
                e();
            }
        }
        AudioTrackPositionTracker audioTrackPositionTracker = this.i;
        long jE = E();
        AudioTrack audioTrack2 = audioTrackPositionTracker.c;
        Objects.requireNonNull(audioTrack2);
        int playState = audioTrack2.getPlayState();
        if (audioTrackPositionTracker.h) {
            if (playState == 2) {
                audioTrackPositionTracker.p = false;
            } else if (playState != 1 || audioTrackPositionTracker.b() != 0) {
                z2 = audioTrackPositionTracker.p;
                boolean zC = audioTrackPositionTracker.c(jE);
                audioTrackPositionTracker.p = zC;
                if (z2) {
                    audioTrackPositionTracker.a.b(audioTrackPositionTracker.e, Util2.M(audioTrackPositionTracker.i));
                }
                z3 = true;
            }
            z3 = false;
        } else {
            z2 = audioTrackPositionTracker.p;
            boolean zC2 = audioTrackPositionTracker.c(jE);
            audioTrackPositionTracker.p = zC2;
            if (z2 && !zC2 && playState != 1) {
                audioTrackPositionTracker.a.b(audioTrackPositionTracker.e, Util2.M(audioTrackPositionTracker.i));
            }
            z3 = true;
        }
        if (!z3) {
            return false;
        }
        if (this.K == null) {
            AnimatableValueParser.j(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            c cVar3 = this.r;
            if (cVar3.c != 0 && this.D == 0) {
                int i6 = cVar3.g;
                int iD = 1024;
                switch (i6) {
                    case 5:
                    case 6:
                    case 18:
                        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
                            i2 = Ac3Util.a[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
                            iD = i2;
                        } else {
                            iD = 1536;
                        }
                        this.D = iD;
                        if (iD == 0) {
                            return true;
                        }
                        break;
                    case 7:
                    case 8:
                        int iPosition = byteBuffer.position();
                        byte b4 = byteBuffer.get(iPosition);
                        if (b4 != -2) {
                            if (b4 == -1) {
                                i3 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                                b3 = byteBuffer.get(iPosition + 7);
                            } else if (b4 != 31) {
                                i3 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                                b2 = byteBuffer.get(iPosition + 5);
                            } else {
                                i3 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                                b3 = byteBuffer.get(iPosition + 6);
                            }
                            i4 = b3 & 60;
                            iD = (((i4 >> 2) | i3) + 1) * 32;
                            this.D = iD;
                            if (iD == 0) {
                                return true;
                            }
                        } else {
                            i3 = (byteBuffer.get(iPosition + 5) & 1) << 6;
                            b2 = byteBuffer.get(iPosition + 4);
                        }
                        i4 = b2 & 252;
                        iD = (((i4 >> 2) | i3) + 1) * 32;
                        this.D = iD;
                        if (iD == 0) {
                            return true;
                        }
                        break;
                    case 9:
                        int iPosition2 = byteBuffer.position();
                        int i7 = Util2.a;
                        int iReverseBytes = byteBuffer.getInt(iPosition2);
                        if (byteBuffer.order() != ByteOrder.BIG_ENDIAN) {
                            iReverseBytes = Integer.reverseBytes(iReverseBytes);
                        }
                        iD = MpegAudioUtil.d(iReverseBytes);
                        if (iD == -1) {
                            throw new IllegalArgumentException();
                        }
                        this.D = iD;
                        if (iD == 0) {
                            return true;
                        }
                        break;
                    case 10:
                    case 16:
                        this.D = iD;
                        if (iD == 0) {
                            return true;
                        }
                        break;
                    case 11:
                    case 12:
                        iD = 2048;
                        this.D = iD;
                        if (iD == 0) {
                            return true;
                        }
                        break;
                    case 13:
                    default:
                        throw new IllegalStateException(outline.g(38, "Unexpected audio encoding: ", i6));
                    case 14:
                        int iPosition3 = byteBuffer.position();
                        int iLimit = byteBuffer.limit() - 10;
                        int i8 = iPosition3;
                        while (true) {
                            if (i8 <= iLimit) {
                                int i9 = Util2.a;
                                int iReverseBytes2 = byteBuffer.getInt(i8 + 4);
                                if (byteBuffer.order() != ByteOrder.BIG_ENDIAN) {
                                    iReverseBytes2 = Integer.reverseBytes(iReverseBytes2);
                                }
                                if ((iReverseBytes2 & (-2)) == -126718022) {
                                    i5 = i8 - iPosition3;
                                } else {
                                    i8++;
                                }
                            } else {
                                i5 = -1;
                            }
                        }
                        if (i5 == -1) {
                            iD = 0;
                        } else {
                            i2 = (40 << ((byteBuffer.get((byteBuffer.position() + i5) + ((byteBuffer.get((byteBuffer.position() + i5) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7)) * 16;
                            iD = i2;
                        }
                        this.D = iD;
                        if (iD == 0) {
                            return true;
                        }
                        break;
                    case 15:
                        iD = 512;
                        this.D = iD;
                        if (iD == 0) {
                            return true;
                        }
                        break;
                    case 17:
                        byte[] bArr = new byte[16];
                        int iPosition4 = byteBuffer.position();
                        byteBuffer.get(bArr);
                        byteBuffer.position(iPosition4);
                        iD = Ac4Util.b(new ParsableBitArray(bArr)).c;
                        this.D = iD;
                        if (iD == 0) {
                            return true;
                        }
                        break;
                }
            }
            if (this.u != null) {
                if (!g()) {
                    return false;
                }
                f(j);
                this.u = null;
            }
            long j2 = this.G;
            c cVar4 = this.r;
            long j3 = ((((cVar4.c == 0 ? this.f2919z / ((long) cVar4.f2920b) : this.A) - this.e.o) * 1000000) / ((long) cVar4.a.K)) + j2;
            if (!this.E && Math.abs(j3 - j) > 200000) {
                ((MediaCodecAudioRenderer.b) this.p).a(new AudioSink.UnexpectedDiscontinuityException(j, j3));
                this.E = true;
            }
            if (this.E) {
                if (!g()) {
                    return false;
                }
                long j4 = j - j3;
                this.G += j4;
                this.E = false;
                f(j);
                AudioSink.a aVar = this.p;
                if (aVar != null && j4 != 0) {
                    MediaCodecAudioRenderer.this.V0 = true;
                }
            }
            if (this.r.c == 0) {
                this.f2919z += (long) byteBuffer.remaining();
            } else {
                this.A += (long) (this.D * i);
            }
            this.K = byteBuffer;
            this.L = i;
        }
        J(j);
        if (!this.K.hasRemaining()) {
            this.K = null;
            this.L = 0;
            return true;
        }
        AudioTrackPositionTracker audioTrackPositionTracker2 = this.i;
        if (!(audioTrackPositionTracker2.f1132y != -9223372036854775807L && E() > 0 && SystemClock.elapsedRealtime() - audioTrackPositionTracker2.f1132y >= 200)) {
            return false;
        }
        Log.w("DefaultAudioSink", "Resetting stalled audio track");
        flush();
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void t(AudioSink.a aVar) {
        this.p = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public int u(Format2 format2) {
        if (!"audio/raw".equals(format2.w)) {
            if (this.Y || !P(format2, this.t)) {
                return A(format2, this.a) != null ? 2 : 0;
            }
            return 2;
        }
        if (Util2.z(format2.L)) {
            int i = format2.L;
            return (i == 2 || (this.c && i == 4)) ? 2 : 1;
        }
        outline.g0(33, "Invalid PCM encoding: ", format2.L, "DefaultAudioSink");
        return 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void v(Format2 format2, int i, @Nullable int[] iArr) throws AudioSink.ConfigurationException {
        int iIntValue;
        int iIntValue2;
        AudioProcessor[] audioProcessorArr;
        int i2;
        int iN;
        int iS;
        int iS2;
        int i3;
        int i4;
        int[] iArr2;
        int i5 = 1;
        if ("audio/raw".equals(format2.w)) {
            AnimatableValueParser.j(Util2.z(format2.L));
            iS = Util2.s(format2.L, format2.J);
            AudioProcessor[] audioProcessorArr2 = ((this.c && Util2.y(format2.L)) ? 1 : 0) != 0 ? this.g : this.f;
            TrimmingAudioProcessor trimmingAudioProcessor = this.e;
            int i6 = format2.M;
            int i7 = format2.N;
            trimmingAudioProcessor.i = i6;
            trimmingAudioProcessor.j = i7;
            if (Util2.a < 21 && format2.J == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i8 = 0; i8 < 6; i8++) {
                    iArr2[i8] = i8;
                }
            } else {
                iArr2 = iArr;
            }
            this.d.i = iArr2;
            AudioProcessor.a aVar = new AudioProcessor.a(format2.K, format2.J, format2.L);
            for (AudioProcessor audioProcessor : audioProcessorArr2) {
                try {
                    AudioProcessor.a aVarD = audioProcessor.d(aVar);
                    if (audioProcessor.a()) {
                        aVar = aVarD;
                    }
                } catch (AudioProcessor.UnhandledAudioFormatException e2) {
                    throw new AudioSink.ConfigurationException(e2, format2);
                }
            }
            int i9 = aVar.d;
            i3 = aVar.f2914b;
            iN = Util2.n(aVar.c);
            audioProcessorArr = audioProcessorArr2;
            i2 = i9;
            iS2 = Util2.s(i9, aVar.c);
            i4 = 0;
        } else {
            AudioProcessor[] audioProcessorArr3 = new AudioProcessor[0];
            int i10 = format2.K;
            if (P(format2, this.t)) {
                String str = format2.w;
                Objects.requireNonNull(str);
                iIntValue = MimeTypes.b(str, format2.t);
                iIntValue2 = Util2.n(format2.J);
            } else {
                Pair<Integer, Integer> pairA = A(format2, this.a);
                if (pairA == null) {
                    String strValueOf = String.valueOf(format2);
                    throw new AudioSink.ConfigurationException(outline.j(strValueOf.length() + 37, "Unable to configure passthrough for: ", strValueOf), format2);
                }
                iIntValue = ((Integer) pairA.first).intValue();
                iIntValue2 = ((Integer) pairA.second).intValue();
                i5 = 2;
            }
            audioProcessorArr = audioProcessorArr3;
            i2 = iIntValue;
            iN = iIntValue2;
            iS = -1;
            iS2 = -1;
            i3 = i10;
            i4 = i5;
        }
        if (i2 == 0) {
            String strValueOf2 = String.valueOf(format2);
            StringBuilder sb = new StringBuilder(strValueOf2.length() + 48);
            sb.append("Invalid output encoding (mode=");
            sb.append(i4);
            sb.append(") for: ");
            sb.append(strValueOf2);
            throw new AudioSink.ConfigurationException(sb.toString(), format2);
        }
        if (iN != 0) {
            this.Y = false;
            c cVar = new c(format2, iS, i4, iS2, i3, iN, i2, i, this.k, audioProcessorArr);
            if (G()) {
                this.q = cVar;
                return;
            } else {
                this.r = cVar;
                return;
            }
        }
        String strValueOf3 = String.valueOf(format2);
        StringBuilder sb2 = new StringBuilder(strValueOf3.length() + 54);
        sb2.append("Invalid output channel config (mode=");
        sb2.append(i4);
        sb2.append(") for: ");
        sb2.append(strValueOf3);
        throw new AudioSink.ConfigurationException(sb2.toString(), format2);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void w(boolean z2) {
        L(z(), z2);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void x(AuxEffectInfo auxEffectInfo) {
        if (this.V.equals(auxEffectInfo)) {
            return;
        }
        int i = auxEffectInfo.a;
        float f2 = auxEffectInfo.f1134b;
        AudioTrack audioTrack = this.f2916s;
        if (audioTrack != null) {
            if (this.V.a != i) {
                audioTrack.attachAuxEffect(i);
            }
            if (i != 0) {
                this.f2916s.setAuxEffectSendLevel(f2);
            }
        }
        this.V = auxEffectInfo;
    }

    public final PlaybackParameters z() {
        return B().a;
    }
}
