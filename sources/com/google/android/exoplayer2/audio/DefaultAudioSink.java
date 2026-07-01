package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.media.AudioAttributes$Builder;
import android.media.AudioFormat;
import android.media.AudioFormat$Builder;
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
import b.c.a.a0.d;
import b.i.a.c.f2$a;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.q;
import b.i.a.c.j1;
import b.i.a.c.t2.a;
import b.i.a.c.t2.a0;
import b.i.a.c.t2.b0;
import b.i.a.c.t2.f0;
import b.i.a.c.t2.k;
import b.i.a.c.t2.m;
import b.i.a.c.t2.n;
import b.i.a.c.t2.o;
import b.i.a.c.t2.p;
import b.i.a.c.t2.r$a;
import b.i.a.c.t2.s;
import b.i.a.c.t2.s$a;
import b.i.a.c.t2.t;
import b.i.a.c.t2.u;
import b.i.a.c.t2.w;
import b.i.a.c.t2.y;
import b.i.a.c.t2.z$b;
import b.i.a.c.x1;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

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
    public u V;
    public boolean W;
    public long X;
    public boolean Y;
    public boolean Z;

    @Nullable
    public final p a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DefaultAudioSink$b f2915b;
    public final boolean c;
    public final w d;
    public final f0 e;
    public final AudioProcessor[] f;
    public final AudioProcessor[] g;
    public final ConditionVariable h;
    public final t i;
    public final ArrayDeque<DefaultAudioSink$e> j;
    public final boolean k;
    public final int l;
    public DefaultAudioSink$h m;
    public final DefaultAudioSink$f<AudioSink$InitializationException> n;
    public final DefaultAudioSink$f<AudioSink$WriteException> o;

    @Nullable
    public AudioSink$a p;

    @Nullable
    public DefaultAudioSink$c q;
    public DefaultAudioSink$c r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public AudioTrack f2916s;
    public o t;

    @Nullable
    public DefaultAudioSink$e u;
    public DefaultAudioSink$e v;
    public x1 w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public ByteBuffer f2917x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f2918y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f2919z;

    public DefaultAudioSink(@Nullable p pVar, DefaultAudioSink$b defaultAudioSink$b, boolean z2, boolean z3, int i) {
        this.a = pVar;
        this.f2915b = defaultAudioSink$b;
        int i2 = e0.a;
        this.c = i2 >= 21 && z2;
        this.k = i2 >= 23 && z3;
        this.l = i2 < 29 ? 0 : i;
        this.h = new ConditionVariable(true);
        this.i = new t(new DefaultAudioSink$g(this, null));
        w wVar = new w();
        this.d = wVar;
        f0 f0Var = new f0();
        this.e = f0Var;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new b0(), wVar, f0Var);
        Collections.addAll(arrayList, ((DefaultAudioSink$d) defaultAudioSink$b).a);
        this.f = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[0]);
        this.g = new AudioProcessor[]{new y()};
        this.H = 1.0f;
        this.t = o.j;
        this.U = 0;
        this.V = new u(0, 0.0f);
        x1 x1Var = x1.j;
        this.v = new DefaultAudioSink$e(x1Var, false, 0L, 0L, null);
        this.w = x1Var;
        this.P = -1;
        this.I = new AudioProcessor[0];
        this.J = new ByteBuffer[0];
        this.j = new ArrayDeque<>();
        this.n = new DefaultAudioSink$f<>(100L);
        this.o = new DefaultAudioSink$f<>(100L);
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00b5  */
    @Nullable
    public static Pair<Integer, Integer> A(j1 j1Var, @Nullable p pVar) {
        if (pVar == null) {
            return null;
        }
        String str = j1Var.w;
        Objects.requireNonNull(str);
        int iB = b.i.a.c.f3.t.b(str, j1Var.t);
        int i = 0;
        int i2 = 6;
        if (!(iB == 5 || iB == 6 || iB == 18 || iB == 17 || iB == 7 || iB == 8 || iB == 14)) {
            return null;
        }
        if (iB == 18 && !pVar.a(18)) {
            iB = 6;
        } else if (iB == 8 && !pVar.a(8)) {
            iB = 7;
        }
        if (!pVar.a(iB)) {
            return null;
        }
        if (iB != 18) {
            i = j1Var.J;
            if (i > pVar.e) {
                return null;
            }
        } else if (e0.a >= 29) {
            int i3 = j1Var.K;
            AudioAttributes audioAttributesBuild = new AudioAttributes$Builder().setUsage(1).setContentType(3).build();
            for (int i4 = 8; i4 > 0; i4--) {
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat$Builder().setEncoding(18).setSampleRate(i3).setChannelMask(e0.n(i4)).build(), audioAttributesBuild)) {
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
        int i5 = e0.a;
        if (i5 > 28) {
            i2 = i;
        } else if (i == 7) {
            i2 = 8;
        } else if (i != 3 && i != 4 && i != 5) {
            i2 = i;
        }
        if (i5 <= 26 && "fugu".equals(e0.f968b) && i2 == 1) {
            i2 = 2;
        }
        int iN = e0.n(i2);
        if (iN == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(iB), Integer.valueOf(iN));
    }

    public static boolean H(AudioTrack audioTrack) {
        return e0.a >= 29 && audioTrack.isOffloadedPlayback();
    }

    @RequiresApi(21)
    public static AudioFormat y(int i, int i2, int i3) {
        return new AudioFormat$Builder().setSampleRate(i).setChannelMask(i2).setEncoding(i3).build();
    }

    public final DefaultAudioSink$e B() {
        DefaultAudioSink$e defaultAudioSink$e = this.u;
        if (defaultAudioSink$e != null) {
            return defaultAudioSink$e;
        }
        return !this.j.isEmpty() ? this.j.getLast() : this.v;
    }

    @RequiresApi(29)
    @SuppressLint({"WrongConstant"})
    public final int C(AudioFormat audioFormat, AudioAttributes audioAttributes) {
        int i = e0.a;
        if (i >= 31) {
            return AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        }
        if (AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return (i == 30 && e0.d.startsWith("Pixel")) ? 2 : 1;
        }
        return 0;
    }

    public boolean D() {
        return B().f2922b;
    }

    public final long E() {
        DefaultAudioSink$c defaultAudioSink$c = this.r;
        return defaultAudioSink$c.c == 0 ? this.B / ((long) defaultAudioSink$c.d) : this.C;
    }

    public final void F() throws AudioSink$InitializationException {
        this.h.block();
        try {
            DefaultAudioSink$c defaultAudioSink$c = this.r;
            Objects.requireNonNull(defaultAudioSink$c);
            AudioTrack audioTrackA = defaultAudioSink$c.a(this.W, this.t, this.U);
            this.f2916s = audioTrackA;
            if (H(audioTrackA)) {
                AudioTrack audioTrack = this.f2916s;
                if (this.m == null) {
                    this.m = new DefaultAudioSink$h(this);
                }
                DefaultAudioSink$h defaultAudioSink$h = this.m;
                Handler handler = defaultAudioSink$h.a;
                Objects.requireNonNull(handler);
                audioTrack.registerStreamEventCallback(new k(handler), defaultAudioSink$h.f2924b);
                if (this.l != 3) {
                    AudioTrack audioTrack2 = this.f2916s;
                    j1 j1Var = this.r.a;
                    audioTrack2.setOffloadDelayPadding(j1Var.M, j1Var.N);
                }
            }
            this.U = this.f2916s.getAudioSessionId();
            t tVar = this.i;
            AudioTrack audioTrack3 = this.f2916s;
            DefaultAudioSink$c defaultAudioSink$c2 = this.r;
            tVar.e(audioTrack3, defaultAudioSink$c2.c == 2, defaultAudioSink$c2.g, defaultAudioSink$c2.d, defaultAudioSink$c2.h);
            N();
            int i = this.V.a;
            if (i != 0) {
                this.f2916s.attachAuxEffect(i);
                this.f2916s.setAuxEffectSendLevel(this.V.f1134b);
            }
            this.F = true;
        } catch (AudioSink$InitializationException e) {
            if (this.r.f()) {
                this.Y = true;
            }
            AudioSink$a audioSink$a = this.p;
            if (audioSink$a != null) {
                ((z$b) audioSink$a).a(e);
            }
            throw e;
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
        t tVar = this.i;
        long jE = E();
        tVar.f1133z = tVar.b();
        tVar.f1131x = SystemClock.elapsedRealtime() * 1000;
        tVar.A = jE;
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
        this.v = new DefaultAudioSink$e(z(), D(), 0L, 0L, null);
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

    public final void L(x1 x1Var, boolean z2) {
        DefaultAudioSink$e defaultAudioSink$eB = B();
        if (x1Var.equals(defaultAudioSink$eB.a) && z2 == defaultAudioSink$eB.f2922b) {
            return;
        }
        DefaultAudioSink$e defaultAudioSink$e = new DefaultAudioSink$e(x1Var, z2, -9223372036854775807L, -9223372036854775807L, null);
        if (G()) {
            this.u = defaultAudioSink$e;
        } else {
            this.v = defaultAudioSink$e;
        }
    }

    @RequiresApi(23)
    public final void M(x1 x1Var) {
        if (G()) {
            try {
                this.f2916s.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(x1Var.k).setPitch(x1Var.l).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e) {
                q.c("DefaultAudioSink", "Failed to set playback params", e);
            }
            x1Var = new x1(this.f2916s.getPlaybackParams().getSpeed(), this.f2916s.getPlaybackParams().getPitch());
            t tVar = this.i;
            tVar.j = x1Var.k;
            s sVar = tVar.f;
            if (sVar != null) {
                sVar.a();
            }
        }
        this.w = x1Var;
    }

    public final void N() {
        if (G()) {
            if (e0.a >= 21) {
                this.f2916s.setVolume(this.H);
                return;
            }
            AudioTrack audioTrack = this.f2916s;
            float f = this.H;
            audioTrack.setStereoVolume(f, f);
        }
    }

    public final boolean O() {
        if (this.W || !"audio/raw".equals(this.r.a.w)) {
            return false;
        }
        return !(this.c && e0.y(this.r.a.L));
    }

    public final boolean P(j1 j1Var, o oVar) {
        int iN;
        int iC;
        if (e0.a < 29 || this.l == 0) {
            return false;
        }
        String str = j1Var.w;
        Objects.requireNonNull(str);
        int iB = b.i.a.c.f3.t.b(str, j1Var.t);
        if (iB == 0 || (iN = e0.n(j1Var.J)) == 0 || (iC = C(y(j1Var.K, iN, iB), oVar.a())) == 0) {
            return false;
        }
        if (iC == 1) {
            return ((j1Var.M != 0 || j1Var.N != 0) && (this.l == 1)) ? false : true;
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
                d.j(byteBuffer2 == byteBuffer);
            } else {
                this.M = byteBuffer;
                if (e0.a < 21) {
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
            int i = e0.a;
            if (i < 21) {
                t tVar = this.i;
                int iB = tVar.e - ((int) (this.B - (tVar.b() * ((long) tVar.d))));
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
                d.D(j != -9223372036854775807L);
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
                AudioSink$WriteException audioSink$WriteException = new AudioSink$WriteException(iWrite, this.r.a, z2);
                AudioSink$a audioSink$a = this.p;
                if (audioSink$a != null) {
                    ((z$b) audioSink$a).a(audioSink$WriteException);
                }
                if (audioSink$WriteException.isRecoverable) {
                    throw audioSink$WriteException;
                }
                this.o.a(audioSink$WriteException);
                return;
            }
            this.o.a = null;
            if (H(this.f2916s)) {
                long j2 = this.C;
                if (j2 > 0) {
                    this.Z = false;
                }
                if (this.S && this.p != null && iWrite < iRemaining2 && !this.Z) {
                    t tVar2 = this.i;
                    long jM = e0.M(tVar2.a(j2 - tVar2.b()));
                    f2$a f2_a = ((z$b) this.p).a.X0;
                    if (f2_a != null) {
                        f2_a.b(jM);
                    }
                }
            }
            int i2 = this.r.c;
            if (i2 == 0) {
                this.B += (long) iWrite;
            }
            if (iWrite == iRemaining2) {
                if (i2 != 0) {
                    d.D(byteBuffer == this.K);
                    this.C += (long) (this.D * this.L);
                }
                this.M = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean a(j1 j1Var) {
        return u(j1Var) != 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean b() {
        return !G() || (this.Q && !k());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public x1 c() {
        return this.k ? this.w : z();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void d() {
        boolean z2 = false;
        this.S = false;
        if (G()) {
            t tVar = this.i;
            tVar.l = 0L;
            tVar.w = 0;
            tVar.v = 0;
            tVar.m = 0L;
            tVar.C = 0L;
            tVar.F = 0L;
            tVar.k = false;
            if (tVar.f1131x == -9223372036854775807L) {
                s sVar = tVar.f;
                Objects.requireNonNull(sVar);
                sVar.a();
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
            s sVar = this.i.f;
            Objects.requireNonNull(sVar);
            sVar.a();
            this.f2916s.play();
        }
    }

    public final void f(long j) {
        r$a r_a;
        Handler handler;
        x1 x1VarA = O() ? this.f2915b.a(z()) : x1.j;
        boolean zD = O() ? this.f2915b.d(D()) : false;
        this.j.add(new DefaultAudioSink$e(x1VarA, zD, Math.max(0L, j), this.r.c(E()), null));
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
        AudioSink$a audioSink$a = this.p;
        if (audioSink$a == null || (handler = (r_a = ((z$b) audioSink$a).a.O0).a) == null) {
            return;
        }
        handler.post(new a(r_a, zD));
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
                DefaultAudioSink$h defaultAudioSink$h = this.m;
                Objects.requireNonNull(defaultAudioSink$h);
                this.f2916s.unregisterStreamEventCallback(defaultAudioSink$h.f2924b);
                defaultAudioSink$h.a.removeCallbacksAndMessages(null);
            }
            AudioTrack audioTrack2 = this.f2916s;
            this.f2916s = null;
            if (e0.a < 21 && !this.T) {
                this.U = 0;
            }
            DefaultAudioSink$c defaultAudioSink$c = this.q;
            if (defaultAudioSink$c != null) {
                this.r = defaultAudioSink$c;
                this.q = null;
            }
            this.i.d();
            this.h.close();
            new DefaultAudioSink$a(this, "ExoPlayer:AudioTrackReleaseThread", audioTrack2).start();
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
    public final boolean g() throws com.google.android.exoplayer2.audio.AudioSink$WriteException {
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
    public void i(x1 x1Var) {
        x1 x1Var2 = new x1(e0.g(x1Var.k, 0.1f, 8.0f), e0.g(x1Var.l, 0.1f, 8.0f));
        if (!this.k || e0.a < 23) {
            L(x1Var2, D());
        } else {
            M(x1Var2);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void j() throws AudioSink$WriteException {
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
        t tVar = this.i;
        AudioTrack audioTrack = tVar.c;
        Objects.requireNonNull(audioTrack);
        if (audioTrack.getPlayState() == 3) {
            long jA2 = tVar.a(tVar.b());
            if (jA2 != 0) {
                long jNanoTime = System.nanoTime() / 1000;
                if (jNanoTime - tVar.m >= 30000) {
                    long[] jArr = tVar.f1129b;
                    int i = tVar.v;
                    jArr[i] = jA2 - jNanoTime;
                    tVar.v = (i + 1) % 10;
                    int i2 = tVar.w;
                    if (i2 < 10) {
                        tVar.w = i2 + 1;
                    }
                    tVar.m = jNanoTime;
                    tVar.l = 0L;
                    int i3 = 0;
                    while (true) {
                        int i4 = tVar.w;
                        if (i3 >= i4) {
                            break;
                        }
                        tVar.l = (tVar.f1129b[i3] / ((long) i4)) + tVar.l;
                        i3++;
                    }
                }
                if (!tVar.h) {
                    s sVar = tVar.f;
                    Objects.requireNonNull(sVar);
                    s$a s_a = sVar.a;
                    if (s_a == null || jNanoTime - sVar.e < sVar.d) {
                        timestamp = false;
                    } else {
                        sVar.e = jNanoTime;
                        timestamp = s_a.a.getTimestamp(s_a.f1128b);
                        if (timestamp) {
                            long j = s_a.f1128b.framePosition;
                            if (s_a.d > j) {
                                s_a.c++;
                            }
                            s_a.d = j;
                            s_a.e = j + (s_a.c << 32);
                        }
                        int i5 = sVar.f1127b;
                        if (i5 != 0) {
                            if (i5 != 1) {
                                if (i5 != 2) {
                                    if (i5 != 3) {
                                        if (i5 != 4) {
                                            throw new IllegalStateException();
                                        }
                                    } else if (timestamp) {
                                        sVar.a();
                                    }
                                } else if (!timestamp) {
                                    sVar.a();
                                }
                            } else if (!timestamp) {
                                sVar.a();
                            } else if (sVar.a.e > sVar.f) {
                                sVar.b(2);
                            }
                        } else if (timestamp) {
                            s$a s_a2 = sVar.a;
                            if (s_a2.f1128b.nanoTime / 1000 >= sVar.c) {
                                sVar.f = s_a2.e;
                                sVar.b(1);
                            } else {
                                timestamp = false;
                            }
                        } else if (jNanoTime - sVar.c > 500000) {
                            sVar.b(3);
                        }
                    }
                    if (timestamp) {
                        s$a s_a3 = sVar.a;
                        long j2 = s_a3 != null ? s_a3.f1128b.nanoTime / 1000 : -9223372036854775807L;
                        long j3 = s_a3 != null ? s_a3.e : -1L;
                        if (Math.abs(j2 - jNanoTime) > 5000000) {
                            tVar.a.e(j3, j2, jNanoTime, jA2);
                            sVar.b(4);
                        } else if (Math.abs(tVar.a(j3) - jA2) > 5000000) {
                            tVar.a.d(j3, j2, jNanoTime, jA2);
                            sVar.b(4);
                        } else if (sVar.f1127b == 4) {
                            sVar.a();
                        }
                    }
                    if (tVar.q && (method = tVar.n) != null && jNanoTime - tVar.r >= 500000) {
                        try {
                            AudioTrack audioTrack2 = tVar.c;
                            Objects.requireNonNull(audioTrack2);
                            Integer num = (Integer) method.invoke(audioTrack2, new Object[0]);
                            int i6 = e0.a;
                            long jIntValue = (((long) num.intValue()) * 1000) - tVar.i;
                            tVar.o = jIntValue;
                            long jMax = Math.max(jIntValue, 0L);
                            tVar.o = jMax;
                            if (jMax > 5000000) {
                                tVar.a.c(jMax);
                                tVar.o = 0L;
                            }
                        } catch (Exception unused) {
                            tVar.n = null;
                        }
                        tVar.r = jNanoTime;
                    }
                }
            }
        }
        long jNanoTime2 = System.nanoTime() / 1000;
        s sVar2 = tVar.f;
        Objects.requireNonNull(sVar2);
        boolean z3 = sVar2.f1127b == 2;
        if (z3) {
            s$a s_a4 = sVar2.a;
            long jA3 = tVar.a(s_a4 != null ? s_a4.e : -1L);
            s$a s_a5 = sVar2.a;
            jA = e0.q(jNanoTime2 - (s_a5 != null ? s_a5.f1128b.nanoTime / 1000 : -9223372036854775807L), tVar.j) + jA3;
        } else {
            jA = tVar.w == 0 ? tVar.a(tVar.b()) : tVar.l + jNanoTime2;
            if (!z2) {
                jA = Math.max(0L, jA - tVar.o);
            }
        }
        if (tVar.D != z3) {
            tVar.F = tVar.C;
            tVar.E = tVar.B;
        }
        long j4 = jNanoTime2 - tVar.F;
        if (j4 < 1000000) {
            long jQ2 = e0.q(j4, tVar.j) + tVar.E;
            long j5 = (j4 * 1000) / 1000000;
            jA = (((1000 - j5) * jQ2) + (jA * j5)) / 1000;
        }
        if (!tVar.k) {
            long j6 = tVar.B;
            if (jA > j6) {
                tVar.k = true;
                long jM = e0.M(jA - j6);
                float f = tVar.j;
                if (f != 1.0f) {
                    jM = Math.round(jM / ((double) f));
                }
                tVar.a.a(System.currentTimeMillis() - e0.M(jM));
            }
        }
        tVar.C = jNanoTime2;
        tVar.B = jA;
        tVar.D = z3;
        long jMin = Math.min(jA, this.r.c(E()));
        while (!this.j.isEmpty() && jMin >= this.j.getFirst().d) {
            this.v = this.j.remove();
        }
        DefaultAudioSink$e defaultAudioSink$e = this.v;
        long j7 = jMin - defaultAudioSink$e.d;
        if (defaultAudioSink$e.a.equals(x1.j)) {
            jQ = this.v.c + j7;
        } else if (this.j.isEmpty()) {
            jQ = this.f2915b.b(j7) + this.v.c;
        } else {
            DefaultAudioSink$e first = this.j.getFirst();
            jQ = first.c - e0.q(first.d - jMin, this.v.a.k);
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
    public void o(o oVar) {
        if (this.t.equals(oVar)) {
            return;
        }
        this.t = oVar;
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
    public void q(float f) {
        if (this.H != f) {
            this.H = f;
            N();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void r() {
        d.D(e0.a >= 21);
        d.D(this.T);
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
        d.j(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.q != null) {
            if (!g()) {
                return false;
            }
            DefaultAudioSink$c defaultAudioSink$c = this.q;
            DefaultAudioSink$c defaultAudioSink$c2 = this.r;
            Objects.requireNonNull(defaultAudioSink$c);
            if (defaultAudioSink$c2.c == defaultAudioSink$c.c && defaultAudioSink$c2.g == defaultAudioSink$c.g && defaultAudioSink$c2.e == defaultAudioSink$c.e && defaultAudioSink$c2.f == defaultAudioSink$c.f && defaultAudioSink$c2.d == defaultAudioSink$c.d) {
                this.r = this.q;
                this.q = null;
                if (H(this.f2916s) && this.l != 3) {
                    this.f2916s.setOffloadEndOfStream();
                    AudioTrack audioTrack = this.f2916s;
                    j1 j1Var = this.r.a;
                    audioTrack.setOffloadDelayPadding(j1Var.M, j1Var.N);
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
            } catch (AudioSink$InitializationException e) {
                if (e.isRecoverable) {
                    throw e;
                }
                this.n.a(e);
                return false;
            }
        }
        this.n.a = null;
        if (this.F) {
            this.G = Math.max(0L, j);
            this.E = false;
            this.F = false;
            if (this.k && e0.a >= 23) {
                M(this.w);
            }
            f(j);
            if (this.S) {
                e();
            }
        }
        t tVar = this.i;
        long jE = E();
        AudioTrack audioTrack2 = tVar.c;
        Objects.requireNonNull(audioTrack2);
        int playState = audioTrack2.getPlayState();
        if (tVar.h) {
            if (playState == 2) {
                tVar.p = false;
            } else if (playState != 1 || tVar.b() != 0) {
                z2 = tVar.p;
                boolean zC = tVar.c(jE);
                tVar.p = zC;
                if (z2) {
                    tVar.a.b(tVar.e, e0.M(tVar.i));
                }
                z3 = true;
            }
            z3 = false;
        } else {
            z2 = tVar.p;
            boolean zC2 = tVar.c(jE);
            tVar.p = zC2;
            if (z2 && !zC2 && playState != 1) {
                tVar.a.b(tVar.e, e0.M(tVar.i));
            }
            z3 = true;
        }
        if (!z3) {
            return false;
        }
        if (this.K == null) {
            d.j(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            DefaultAudioSink$c defaultAudioSink$c3 = this.r;
            if (defaultAudioSink$c3.c != 0 && this.D == 0) {
                int i6 = defaultAudioSink$c3.g;
                int iD = 1024;
                switch (i6) {
                    case 5:
                    case 6:
                    case 18:
                        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
                            i2 = m.a[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
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
                        int i7 = e0.a;
                        int iReverseBytes = byteBuffer.getInt(iPosition2);
                        if (byteBuffer.order() != ByteOrder.BIG_ENDIAN) {
                            iReverseBytes = Integer.reverseBytes(iReverseBytes);
                        }
                        iD = a0.d(iReverseBytes);
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
                        throw new IllegalStateException(b.d.b.a.a.g(38, "Unexpected audio encoding: ", i6));
                    case 14:
                        int iPosition3 = byteBuffer.position();
                        int iLimit = byteBuffer.limit() - 10;
                        int i8 = iPosition3;
                        while (true) {
                            if (i8 <= iLimit) {
                                int i9 = e0.a;
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
                        iD = n.b(new b.i.a.c.f3.w(bArr)).c;
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
            DefaultAudioSink$c defaultAudioSink$c4 = this.r;
            long j3 = ((((defaultAudioSink$c4.c == 0 ? this.f2919z / ((long) defaultAudioSink$c4.f2920b) : this.A) - this.e.o) * 1000000) / ((long) defaultAudioSink$c4.a.K)) + j2;
            if (!this.E && Math.abs(j3 - j) > 200000) {
                ((z$b) this.p).a(new AudioSink$UnexpectedDiscontinuityException(j, j3));
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
                AudioSink$a audioSink$a = this.p;
                if (audioSink$a != null && j4 != 0) {
                    ((z$b) audioSink$a).a.V0 = true;
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
        t tVar2 = this.i;
        if (!(tVar2.f1132y != -9223372036854775807L && E() > 0 && SystemClock.elapsedRealtime() - tVar2.f1132y >= 200)) {
            return false;
        }
        Log.w("DefaultAudioSink", "Resetting stalled audio track");
        flush();
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void t(AudioSink$a audioSink$a) {
        this.p = audioSink$a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public int u(j1 j1Var) {
        if (!"audio/raw".equals(j1Var.w)) {
            if (this.Y || !P(j1Var, this.t)) {
                return A(j1Var, this.a) != null ? 2 : 0;
            }
            return 2;
        }
        if (e0.z(j1Var.L)) {
            int i = j1Var.L;
            return (i == 2 || (this.c && i == 4)) ? 2 : 1;
        }
        b.d.b.a.a.g0(33, "Invalid PCM encoding: ", j1Var.L, "DefaultAudioSink");
        return 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void v(j1 j1Var, int i, @Nullable int[] iArr) throws AudioSink$ConfigurationException {
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
        if ("audio/raw".equals(j1Var.w)) {
            d.j(e0.z(j1Var.L));
            iS = e0.s(j1Var.L, j1Var.J);
            AudioProcessor[] audioProcessorArr2 = ((this.c && e0.y(j1Var.L)) ? 1 : 0) != 0 ? this.g : this.f;
            f0 f0Var = this.e;
            int i6 = j1Var.M;
            int i7 = j1Var.N;
            f0Var.i = i6;
            f0Var.j = i7;
            if (e0.a < 21 && j1Var.J == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i8 = 0; i8 < 6; i8++) {
                    iArr2[i8] = i8;
                }
            } else {
                iArr2 = iArr;
            }
            this.d.i = iArr2;
            AudioProcessor$a audioProcessor$a = new AudioProcessor$a(j1Var.K, j1Var.J, j1Var.L);
            for (AudioProcessor audioProcessor : audioProcessorArr2) {
                try {
                    AudioProcessor$a audioProcessor$aD = audioProcessor.d(audioProcessor$a);
                    if (audioProcessor.a()) {
                        audioProcessor$a = audioProcessor$aD;
                    }
                } catch (AudioProcessor$UnhandledAudioFormatException e) {
                    throw new AudioSink$ConfigurationException(e, j1Var);
                }
            }
            int i9 = audioProcessor$a.d;
            i3 = audioProcessor$a.f2914b;
            iN = e0.n(audioProcessor$a.c);
            audioProcessorArr = audioProcessorArr2;
            i2 = i9;
            iS2 = e0.s(i9, audioProcessor$a.c);
            i4 = 0;
        } else {
            AudioProcessor[] audioProcessorArr3 = new AudioProcessor[0];
            int i10 = j1Var.K;
            if (P(j1Var, this.t)) {
                String str = j1Var.w;
                Objects.requireNonNull(str);
                iIntValue = b.i.a.c.f3.t.b(str, j1Var.t);
                iIntValue2 = e0.n(j1Var.J);
            } else {
                Pair<Integer, Integer> pairA = A(j1Var, this.a);
                if (pairA == null) {
                    String strValueOf = String.valueOf(j1Var);
                    throw new AudioSink$ConfigurationException(b.d.b.a.a.j(strValueOf.length() + 37, "Unable to configure passthrough for: ", strValueOf), j1Var);
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
            String strValueOf2 = String.valueOf(j1Var);
            StringBuilder sb = new StringBuilder(strValueOf2.length() + 48);
            sb.append("Invalid output encoding (mode=");
            sb.append(i4);
            sb.append(") for: ");
            sb.append(strValueOf2);
            throw new AudioSink$ConfigurationException(sb.toString(), j1Var);
        }
        if (iN != 0) {
            this.Y = false;
            DefaultAudioSink$c defaultAudioSink$c = new DefaultAudioSink$c(j1Var, iS, i4, iS2, i3, iN, i2, i, this.k, audioProcessorArr);
            if (G()) {
                this.q = defaultAudioSink$c;
                return;
            } else {
                this.r = defaultAudioSink$c;
                return;
            }
        }
        String strValueOf3 = String.valueOf(j1Var);
        StringBuilder sb2 = new StringBuilder(strValueOf3.length() + 54);
        sb2.append("Invalid output channel config (mode=");
        sb2.append(i4);
        sb2.append(") for: ");
        sb2.append(strValueOf3);
        throw new AudioSink$ConfigurationException(sb2.toString(), j1Var);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void w(boolean z2) {
        L(z(), z2);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void x(u uVar) {
        if (this.V.equals(uVar)) {
            return;
        }
        int i = uVar.a;
        float f = uVar.f1134b;
        AudioTrack audioTrack = this.f2916s;
        if (audioTrack != null) {
            if (this.V.a != i) {
                audioTrack.attachAuxEffect(i);
            }
            if (i != 0) {
                this.f2916s.setAuxEffectSendLevel(f);
            }
        }
        this.V = uVar;
    }

    public final x1 z() {
        return B().a;
    }
}
