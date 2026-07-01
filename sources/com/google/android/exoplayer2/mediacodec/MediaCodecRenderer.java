package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec$BufferInfo;
import android.media.MediaCodec$CodecException;
import android.media.MediaCodec$CryptoException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.c.a.a0.d;
import b.d.b.a.a;
import b.i.a.c.a3.i0;
import b.i.a.c.f3.c0;
import b.i.a.c.f3.e0;
import b.i.a.c.j1;
import b.i.a.c.k1;
import b.i.a.c.t2.a0;
import b.i.a.c.v0;
import b.i.a.c.v2.b;
import b.i.a.c.v2.c;
import b.i.a.c.v2.e;
import b.i.a.c.v2.g;
import b.i.a.c.w2.b0;
import b.i.a.c.x0;
import b.i.a.c.y2.p;
import b.i.a.c.y2.q;
import b.i.a.c.y2.t;
import b.i.a.c.y2.t$a;
import b.i.a.c.y2.t$b;
import b.i.a.c.y2.u;
import b.i.a.c.y2.v;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer$InsufficientCapacityException;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSession$DrmSessionException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MediaCodecRenderer extends v0 {
    public static final byte[] u = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    public final DecoderInputBuffer A;
    public boolean A0;
    public final DecoderInputBuffer B;
    public boolean B0;
    public final p C;
    public long C0;
    public final c0<j1> D;
    public long D0;
    public final ArrayList<Long> E;
    public boolean E0;
    public final MediaCodec$BufferInfo F;
    public boolean F0;
    public final long[] G;
    public boolean G0;
    public final long[] H;
    public boolean H0;
    public final long[] I;

    @Nullable
    public ExoPlaybackException I0;

    @Nullable
    public j1 J;
    public e J0;

    @Nullable
    public j1 K;
    public long K0;

    @Nullable
    public DrmSession L;
    public long L0;

    @Nullable
    public DrmSession M;
    public int M0;

    @Nullable
    public MediaCrypto N;
    public boolean O;
    public long P;
    public float Q;
    public float R;

    @Nullable
    public t S;

    @Nullable
    public j1 T;

    @Nullable
    public MediaFormat U;
    public boolean V;
    public float W;

    @Nullable
    public ArrayDeque<u> X;

    @Nullable
    public MediaCodecRenderer$DecoderInitializationException Y;

    @Nullable
    public u Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f2934a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f2935b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f2936c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f2937d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f2938e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f2939f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f2940g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f2941h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f2942i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f2943j0;
    public boolean k0;

    @Nullable
    public q l0;
    public long m0;
    public int n0;
    public int o0;

    @Nullable
    public ByteBuffer p0;
    public boolean q0;
    public boolean r0;
    public boolean s0;
    public boolean t0;
    public boolean u0;
    public final t$b v;
    public boolean v0;
    public final v w;
    public int w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f2944x;
    public int x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final float f2945y;
    public int y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final DecoderInputBuffer f2946z;
    public boolean z0;

    public MediaCodecRenderer(int i, t$b t_b, v vVar, boolean z2, float f) {
        super(i);
        this.v = t_b;
        Objects.requireNonNull(vVar);
        this.w = vVar;
        this.f2944x = z2;
        this.f2945y = f;
        this.f2946z = new DecoderInputBuffer(0);
        this.A = new DecoderInputBuffer(0);
        this.B = new DecoderInputBuffer(2);
        p pVar = new p();
        this.C = pVar;
        this.D = new c0<>();
        this.E = new ArrayList<>();
        this.F = new MediaCodec$BufferInfo();
        this.Q = 1.0f;
        this.R = 1.0f;
        this.P = -9223372036854775807L;
        this.G = new long[10];
        this.H = new long[10];
        this.I = new long[10];
        this.K0 = -9223372036854775807L;
        this.L0 = -9223372036854775807L;
        pVar.r(0);
        pVar.l.order(ByteOrder.nativeOrder());
        this.W = -1.0f;
        this.f2934a0 = 0;
        this.w0 = 0;
        this.n0 = -1;
        this.o0 = -1;
        this.m0 = -9223372036854775807L;
        this.C0 = -9223372036854775807L;
        this.D0 = -9223372036854775807L;
        this.x0 = 0;
        this.y0 = 0;
    }

    @RequiresApi(23)
    public final void A0() throws ExoPlaybackException {
        try {
            this.N.setMediaDrmSession(X(this.M).c);
            t0(this.M);
            this.x0 = 0;
            this.y0 = 0;
        } catch (MediaCryptoException e) {
            throw z(e, this.J, false, 6006);
        }
    }

    @Override // b.i.a.c.v0
    public void B() {
        this.J = null;
        this.K0 = -9223372036854775807L;
        this.L0 = -9223372036854775807L;
        this.M0 = 0;
        S();
    }

    public final void B0(long j) throws ExoPlaybackException {
        boolean z2;
        j1 j1VarF;
        j1 j1VarE = this.D.e(j);
        if (j1VarE == null && this.V) {
            c0<j1> c0Var = this.D;
            synchronized (c0Var) {
                j1VarF = c0Var.d == 0 ? null : c0Var.f();
            }
            j1VarE = j1VarF;
        }
        if (j1VarE != null) {
            this.K = j1VarE;
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || (this.V && this.K != null)) {
            h0(this.K, this.U);
            this.V = false;
        }
    }

    @Override // b.i.a.c.v0
    public void D(long j, boolean z2) throws ExoPlaybackException {
        int i;
        this.E0 = false;
        this.F0 = false;
        this.H0 = false;
        if (this.s0) {
            this.C.p();
            this.B.p();
            this.t0 = false;
        } else if (S()) {
            b0();
        }
        c0<j1> c0Var = this.D;
        synchronized (c0Var) {
            i = c0Var.d;
        }
        if (i > 0) {
            this.G0 = true;
        }
        this.D.b();
        int i2 = this.M0;
        if (i2 != 0) {
            this.L0 = this.H[i2 - 1];
            this.K0 = this.G[i2 - 1];
            this.M0 = 0;
        }
    }

    @Override // b.i.a.c.v0
    public void H(j1[] j1VarArr, long j, long j2) throws ExoPlaybackException {
        if (this.L0 == -9223372036854775807L) {
            d.D(this.K0 == -9223372036854775807L);
            this.K0 = j;
            this.L0 = j2;
            return;
        }
        int i = this.M0;
        long[] jArr = this.H;
        if (i == jArr.length) {
            long j3 = jArr[i - 1];
            StringBuilder sb = new StringBuilder(65);
            sb.append("Too many stream changes, so dropping offset: ");
            sb.append(j3);
            Log.w("MediaCodecRenderer", sb.toString());
        } else {
            this.M0 = i + 1;
        }
        long[] jArr2 = this.G;
        int i2 = this.M0;
        jArr2[i2 - 1] = j;
        this.H[i2 - 1] = j2;
        this.I[i2 - 1] = this.C0;
    }

    public final boolean J(long j, long j2) throws ExoPlaybackException {
        d.D(!this.F0);
        if (this.C.v()) {
            p pVar = this.C;
            if (!m0(j, j2, null, pVar.l, this.o0, 0, pVar.f1311s, pVar.n, pVar.m(), this.C.n(), this.K)) {
                return false;
            }
            i0(this.C.r);
            this.C.p();
        }
        if (this.E0) {
            this.F0 = true;
            return false;
        }
        if (this.t0) {
            d.D(this.C.u(this.B));
            this.t0 = false;
        }
        if (this.u0) {
            if (this.C.v()) {
                return true;
            }
            M();
            this.u0 = false;
            b0();
            if (!this.s0) {
                return false;
            }
        }
        d.D(!this.E0);
        k1 k1VarA = A();
        this.B.p();
        while (true) {
            this.B.p();
            int I = I(k1VarA, this.B, 0);
            if (I == -5) {
                g0(k1VarA);
                break;
            }
            if (I != -4) {
                if (I == -3) {
                    break;
                }
                throw new IllegalStateException();
            }
            if (this.B.n()) {
                this.E0 = true;
                break;
            }
            if (this.G0) {
                j1 j1Var = this.J;
                Objects.requireNonNull(j1Var);
                this.K = j1Var;
                h0(j1Var, null);
                this.G0 = false;
            }
            this.B.s();
            if (!this.C.u(this.B)) {
                this.t0 = true;
                break;
            }
        }
        if (this.C.v()) {
            this.C.s();
        }
        return this.C.v() || this.E0 || this.u0;
    }

    public abstract g K(u uVar, j1 j1Var, j1 j1Var2);

    public MediaCodecDecoderException L(Throwable th, @Nullable u uVar) {
        return new MediaCodecDecoderException(th, uVar);
    }

    public final void M() {
        this.u0 = false;
        this.C.p();
        this.B.p();
        this.t0 = false;
        this.s0 = false;
    }

    public final void N() throws ExoPlaybackException {
        if (this.z0) {
            this.x0 = 1;
            this.y0 = 3;
        } else {
            o0();
            b0();
        }
    }

    @TargetApi(23)
    public final boolean O() throws ExoPlaybackException {
        if (this.z0) {
            this.x0 = 1;
            if (this.f2936c0 || this.f2938e0) {
                this.y0 = 3;
                return false;
            }
            this.y0 = 2;
        } else {
            A0();
        }
        return true;
    }

    public final boolean P(long j, long j2) throws ExoPlaybackException {
        boolean z2;
        boolean z3;
        boolean zM0;
        int iE;
        boolean z4;
        if (!(this.o0 >= 0)) {
            if (this.f2939f0 && this.A0) {
                try {
                    iE = this.S.e(this.F);
                } catch (IllegalStateException unused) {
                    l0();
                    if (this.F0) {
                        o0();
                    }
                    return false;
                }
            } else {
                iE = this.S.e(this.F);
            }
            if (iE < 0) {
                if (iE != -2) {
                    if (this.k0 && (this.E0 || this.x0 == 2)) {
                        l0();
                    }
                    return false;
                }
                this.B0 = true;
                MediaFormat outputFormat = this.S.getOutputFormat();
                if (this.f2934a0 != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                    this.f2943j0 = true;
                } else {
                    if (this.f2941h0) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    this.U = outputFormat;
                    this.V = true;
                }
                return true;
            }
            if (this.f2943j0) {
                this.f2943j0 = false;
                this.S.releaseOutputBuffer(iE, false);
                return true;
            }
            MediaCodec$BufferInfo mediaCodec$BufferInfo = this.F;
            if (mediaCodec$BufferInfo.size == 0 && (mediaCodec$BufferInfo.flags & 4) != 0) {
                l0();
                return false;
            }
            this.o0 = iE;
            ByteBuffer byteBufferJ = this.S.j(iE);
            this.p0 = byteBufferJ;
            if (byteBufferJ != null) {
                byteBufferJ.position(this.F.offset);
                ByteBuffer byteBuffer = this.p0;
                MediaCodec$BufferInfo mediaCodec$BufferInfo2 = this.F;
                byteBuffer.limit(mediaCodec$BufferInfo2.offset + mediaCodec$BufferInfo2.size);
            }
            if (this.f2940g0) {
                MediaCodec$BufferInfo mediaCodec$BufferInfo3 = this.F;
                if (mediaCodec$BufferInfo3.presentationTimeUs == 0 && (mediaCodec$BufferInfo3.flags & 4) != 0) {
                    long j3 = this.C0;
                    if (j3 != -9223372036854775807L) {
                        mediaCodec$BufferInfo3.presentationTimeUs = j3;
                    }
                }
            }
            long j4 = this.F.presentationTimeUs;
            int size = this.E.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z4 = false;
                    break;
                }
                if (this.E.get(i).longValue() == j4) {
                    this.E.remove(i);
                    z4 = true;
                    break;
                }
                i++;
            }
            this.q0 = z4;
            long j5 = this.D0;
            long j6 = this.F.presentationTimeUs;
            this.r0 = j5 == j6;
            B0(j6);
        }
        if (this.f2939f0 && this.A0) {
            try {
                t tVar = this.S;
                ByteBuffer byteBuffer2 = this.p0;
                int i2 = this.o0;
                MediaCodec$BufferInfo mediaCodec$BufferInfo4 = this.F;
                z3 = false;
                z2 = true;
                try {
                    zM0 = m0(j, j2, tVar, byteBuffer2, i2, mediaCodec$BufferInfo4.flags, 1, mediaCodec$BufferInfo4.presentationTimeUs, this.q0, this.r0, this.K);
                } catch (IllegalStateException unused2) {
                    l0();
                    if (this.F0) {
                        o0();
                    }
                    return z3;
                }
            } catch (IllegalStateException unused3) {
                z3 = false;
            }
        } else {
            z2 = true;
            z3 = false;
            t tVar2 = this.S;
            ByteBuffer byteBuffer3 = this.p0;
            int i3 = this.o0;
            MediaCodec$BufferInfo mediaCodec$BufferInfo5 = this.F;
            zM0 = m0(j, j2, tVar2, byteBuffer3, i3, mediaCodec$BufferInfo5.flags, 1, mediaCodec$BufferInfo5.presentationTimeUs, this.q0, this.r0, this.K);
        }
        if (zM0) {
            i0(this.F.presentationTimeUs);
            boolean z5 = (this.F.flags & 4) != 0;
            this.o0 = -1;
            this.p0 = null;
            if (!z5) {
                return z2;
            }
            l0();
        }
        return z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    public final boolean Q() throws ExoPlaybackException {
        t tVar = this.S;
        boolean z2 = 0;
        if (tVar == null || this.x0 == 2 || this.E0) {
            return false;
        }
        if (this.n0 < 0) {
            int iD = tVar.d();
            this.n0 = iD;
            if (iD < 0) {
                return false;
            }
            this.A.l = this.S.h(iD);
            this.A.p();
        }
        if (this.x0 == 1) {
            if (!this.k0) {
                this.A0 = true;
                this.S.queueInputBuffer(this.n0, 0, 0, 0L, 4);
                s0();
            }
            this.x0 = 2;
            return false;
        }
        if (this.f2942i0) {
            this.f2942i0 = false;
            ByteBuffer byteBuffer = this.A.l;
            byte[] bArr = u;
            byteBuffer.put(bArr);
            this.S.queueInputBuffer(this.n0, 0, bArr.length, 0L, 0);
            s0();
            this.z0 = true;
            return true;
        }
        if (this.w0 == 1) {
            for (int i = 0; i < this.T.f1019y.size(); i++) {
                this.A.l.put(this.T.f1019y.get(i));
            }
            this.w0 = 2;
        }
        int iPosition = this.A.l.position();
        k1 k1VarA = A();
        try {
            int I = I(k1VarA, this.A, 0);
            if (j()) {
                this.D0 = this.C0;
            }
            if (I == -3) {
                return false;
            }
            if (I == -5) {
                if (this.w0 == 2) {
                    this.A.p();
                    this.w0 = 1;
                }
                g0(k1VarA);
                return true;
            }
            if (this.A.n()) {
                if (this.w0 == 2) {
                    this.A.p();
                    this.w0 = 1;
                }
                this.E0 = true;
                if (!this.z0) {
                    l0();
                    return false;
                }
                try {
                    if (!this.k0) {
                        this.A0 = true;
                        this.S.queueInputBuffer(this.n0, 0, 0, 0L, 4);
                        s0();
                    }
                    return false;
                } catch (MediaCodec$CryptoException e) {
                    throw z(e, this.J, false, e0.p(e.getErrorCode()));
                }
            }
            if (!this.z0 && !this.A.o()) {
                this.A.p();
                if (this.w0 == 2) {
                    this.w0 = 1;
                }
                return true;
            }
            boolean zT = this.A.t();
            if (zT) {
                c cVar = this.A.k;
                Objects.requireNonNull(cVar);
                if (iPosition != 0) {
                    if (cVar.d == null) {
                        int[] iArr = new int[1];
                        cVar.d = iArr;
                        cVar.i.numBytesOfClearData = iArr;
                    }
                    int[] iArr2 = cVar.d;
                    iArr2[0] = iArr2[0] + iPosition;
                }
            }
            if (this.f2935b0 && !zT) {
                ByteBuffer byteBuffer2 = this.A.l;
                byte[] bArr2 = b.i.a.c.f3.u.a;
                int iPosition2 = byteBuffer2.position();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int i4 = i2 + 1;
                    if (i4 >= iPosition2) {
                        byteBuffer2.clear();
                        break;
                    }
                    int i5 = byteBuffer2.get(i2) & 255;
                    if (i3 == 3) {
                        if (i5 == 1 && (byteBuffer2.get(i4) & 31) == 7) {
                            ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
                            byteBufferDuplicate.position(i2 - 3);
                            byteBufferDuplicate.limit(iPosition2);
                            byteBuffer2.position(0);
                            byteBuffer2.put(byteBufferDuplicate);
                            break;
                        }
                    } else if (i5 == 0) {
                        i3++;
                    }
                    if (i5 != 0) {
                        i3 = 0;
                    }
                    i2 = i4;
                }
                if (this.A.l.position() == 0) {
                    return true;
                }
                this.f2935b0 = false;
            }
            DecoderInputBuffer decoderInputBuffer = this.A;
            long j = decoderInputBuffer.n;
            q qVar = this.l0;
            if (qVar != null) {
                j1 j1Var = this.J;
                if (qVar.f1312b == 0) {
                    qVar.a = j;
                }
                if (!qVar.c) {
                    ByteBuffer byteBuffer3 = decoderInputBuffer.l;
                    Objects.requireNonNull(byteBuffer3);
                    int i6 = 0;
                    for (int i7 = 0; i7 < 4; i7++) {
                        i6 = (i6 << 8) | (byteBuffer3.get(i7) & 255);
                    }
                    int iD2 = a0.d(i6);
                    if (iD2 == -1) {
                        qVar.c = true;
                        qVar.f1312b = 0L;
                        qVar.a = decoderInputBuffer.n;
                        Log.w("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
                        j = decoderInputBuffer.n;
                    } else {
                        long jA = qVar.a(j1Var.K);
                        qVar.f1312b += (long) iD2;
                        j = jA;
                    }
                }
                long j2 = this.C0;
                q qVar2 = this.l0;
                j1 j1Var2 = this.J;
                Objects.requireNonNull(qVar2);
                this.C0 = Math.max(j2, qVar2.a(j1Var2.K));
            }
            long j3 = j;
            if (this.A.m()) {
                this.E.add(Long.valueOf(j3));
            }
            if (this.G0) {
                this.D.a(j3, this.J);
                this.G0 = false;
            }
            this.C0 = Math.max(this.C0, j3);
            this.A.s();
            if (this.A.l()) {
                Z(this.A);
            }
            k0(this.A);
            try {
                if (zT) {
                    this.S.b(this.n0, 0, this.A.k, j3, 0);
                } else {
                    this.S.queueInputBuffer(this.n0, 0, this.A.l.limit(), j3, 0);
                }
                s0();
                this.z0 = true;
                this.w0 = 0;
                e eVar = this.J0;
                z2 = eVar.c + 1;
                eVar.c = z2;
                return true;
            } catch (MediaCodec$CryptoException e2) {
                throw z(e2, this.J, z2, e0.p(e2.getErrorCode()));
            }
        } catch (DecoderInputBuffer$InsufficientCapacityException e3) {
            d0(e3);
            n0(0);
            R();
            return true;
        }
    }

    public final void R() {
        try {
            this.S.flush();
        } finally {
            q0();
        }
    }

    public boolean S() {
        if (this.S == null) {
            return false;
        }
        if (this.y0 == 3 || this.f2936c0 || ((this.f2937d0 && !this.B0) || (this.f2938e0 && this.A0))) {
            o0();
            return true;
        }
        R();
        return false;
    }

    public final List<u> T(boolean z2) throws MediaCodecUtil$DecoderQueryException {
        List<u> listW = W(this.w, this.J, z2);
        if (listW.isEmpty() && z2) {
            listW = W(this.w, this.J, false);
            if (!listW.isEmpty()) {
                String str = this.J.w;
                String strValueOf = String.valueOf(listW);
                a.r0(a.S(strValueOf.length() + a.b(str, 99), "Drm session requires secure decoder for ", str, ", but no secure decoder available. Trying to proceed with ", strValueOf), ".", "MediaCodecRenderer");
            }
        }
        return listW;
    }

    public boolean U() {
        return false;
    }

    public abstract float V(float f, j1 j1Var, j1[] j1VarArr);

    public abstract List<u> W(v vVar, j1 j1Var, boolean z2) throws MediaCodecUtil$DecoderQueryException;

    @Nullable
    public final b0 X(DrmSession drmSession) throws ExoPlaybackException {
        b bVarG = drmSession.g();
        if (bVarG == null || (bVarG instanceof b0)) {
            return (b0) bVarG;
        }
        String strValueOf = String.valueOf(bVarG);
        throw z(new IllegalArgumentException(a.j(strValueOf.length() + 43, "Expecting FrameworkCryptoConfig but found: ", strValueOf)), this.J, false, 6001);
    }

    public abstract t$a Y(u uVar, j1 j1Var, @Nullable MediaCrypto mediaCrypto, float f);

    public void Z(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }

    @Override // b.i.a.c.g2
    public final int a(j1 j1Var) throws ExoPlaybackException {
        try {
            return y0(this.w, j1Var);
        } catch (MediaCodecUtil$DecoderQueryException e) {
            throw y(e, j1Var, 4002);
        }
    }

    /* JADX WARN: Code duplicated, block: B:114:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:27:0x0091  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:87:0x015e  */
    public final void a0(u uVar, MediaCrypto mediaCrypto) throws Exception {
        float fV;
        int i;
        boolean z2;
        boolean z3;
        String str = uVar.a;
        int i2 = e0.a;
        if (i2 < 23) {
            fV = -1.0f;
        } else {
            float f = this.R;
            j1 j1Var = this.J;
            j1[] j1VarArr = this.p;
            Objects.requireNonNull(j1VarArr);
            fV = V(f, j1Var, j1VarArr);
        }
        float f2 = fV > this.f2945y ? fV : -1.0f;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String strValueOf = String.valueOf(str);
        d.f(strValueOf.length() != 0 ? "createCodec:".concat(strValueOf) : new String("createCodec:"));
        this.S = this.v.a(Y(uVar, this.J, mediaCrypto, f2));
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        this.Z = uVar;
        this.W = f2;
        this.T = this.J;
        if (i2 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = e0.d;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                i = 2;
            } else if (i2 < 24) {
                i = 0;
            } else {
                i = 0;
            }
        } else if (i2 < 24 || !("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str))) {
            i = 0;
        } else {
            String str3 = e0.f968b;
            if ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) {
                i = 1;
            } else {
                i = 0;
            }
        }
        this.f2934a0 = i;
        this.f2935b0 = i2 < 21 && this.T.f1019y.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
        this.f2936c0 = i2 < 18 || (i2 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i2 == 19 && e0.d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
        this.f2937d0 = i2 == 29 && "c2.android.aac.decoder".equals(str);
        if (i2 > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (i2 <= 19) {
                String str4 = e0.f968b;
                z2 = ("hb2000".equals(str4) || "stvm8".equals(str4)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str));
            }
        }
        this.f2938e0 = z2;
        this.f2939f0 = i2 == 21 && "OMX.google.aac.decoder".equals(str);
        if (i2 < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(e0.c)) {
            String str5 = e0.f968b;
            if (str5.startsWith("baffin") || str5.startsWith("grand") || str5.startsWith("fortuna") || str5.startsWith("gprimelte") || str5.startsWith("j2y18lte") || str5.startsWith("ms01")) {
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            z3 = false;
        }
        this.f2940g0 = z3;
        this.f2941h0 = i2 <= 18 && this.T.J == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
        String str6 = uVar.a;
        this.k0 = ((i2 <= 25 && "OMX.rk.video_decoder.avc".equals(str6)) || ((i2 <= 17 && "OMX.allwinner.video.decoder.avc".equals(str6)) || ((i2 <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str6) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str6))) || ("Amazon".equals(e0.c) && "AFTS".equals(e0.d) && uVar.f)))) || U();
        if (this.S.a()) {
            this.v0 = true;
            this.w0 = 1;
            this.f2942i0 = this.f2934a0 != 0;
        }
        if ("c2.android.mp3.decoder".equals(uVar.a)) {
            this.l0 = new q();
        }
        if (this.n == 2) {
            this.m0 = SystemClock.elapsedRealtime() + 1000;
        }
        this.J0.a++;
        e0(str, jElapsedRealtime2, jElapsedRealtime2 - jElapsedRealtime);
    }

    @Override // b.i.a.c.f2
    public boolean b() {
        return this.F0;
    }

    public final void b0() throws ExoPlaybackException {
        j1 j1Var;
        if (this.S != null || this.s0 || (j1Var = this.J) == null) {
            return;
        }
        if (this.M == null && x0(j1Var)) {
            j1 j1Var2 = this.J;
            M();
            String str = j1Var2.w;
            if ("audio/mp4a-latm".equals(str) || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
                p pVar = this.C;
                Objects.requireNonNull(pVar);
                d.j(true);
                pVar.t = 32;
            } else {
                p pVar2 = this.C;
                Objects.requireNonNull(pVar2);
                d.j(true);
                pVar2.t = 1;
            }
            this.s0 = true;
            return;
        }
        t0(this.M);
        String str2 = this.J.w;
        DrmSession drmSession = this.L;
        if (drmSession != null) {
            if (this.N == null) {
                b0 b0VarX = X(drmSession);
                if (b0VarX != null) {
                    try {
                        MediaCrypto mediaCrypto = new MediaCrypto(b0VarX.f1150b, b0VarX.c);
                        this.N = mediaCrypto;
                        this.O = !b0VarX.d && mediaCrypto.requiresSecureDecoderComponent(str2);
                    } catch (MediaCryptoException e) {
                        throw z(e, this.J, false, 6006);
                    }
                } else if (this.L.f() == null) {
                    return;
                }
            }
            if (b0.a) {
                int state = this.L.getState();
                if (state == 1) {
                    DrmSession$DrmSessionException drmSession$DrmSessionExceptionF = this.L.f();
                    Objects.requireNonNull(drmSession$DrmSessionExceptionF);
                    throw z(drmSession$DrmSessionExceptionF, this.J, false, drmSession$DrmSessionExceptionF.errorCode);
                }
                if (state != 4) {
                    return;
                }
            }
        }
        try {
            c0(this.N, this.O);
        } catch (MediaCodecRenderer$DecoderInitializationException e2) {
            throw z(e2, this.J, false, 4001);
        }
    }

    public final void c0(MediaCrypto mediaCrypto, boolean z2) throws MediaCodecRenderer$DecoderInitializationException {
        if (this.X == null) {
            try {
                List<u> listT = T(z2);
                ArrayDeque<u> arrayDeque = new ArrayDeque<>();
                this.X = arrayDeque;
                if (this.f2944x) {
                    arrayDeque.addAll(listT);
                } else if (!listT.isEmpty()) {
                    this.X.add(listT.get(0));
                }
                this.Y = null;
            } catch (MediaCodecUtil$DecoderQueryException e) {
                throw new MediaCodecRenderer$DecoderInitializationException(this.J, e, z2, -49998);
            }
        }
        if (this.X.isEmpty()) {
            throw new MediaCodecRenderer$DecoderInitializationException(this.J, null, z2, -49999);
        }
        while (this.S == null) {
            u uVarPeekFirst = this.X.peekFirst();
            if (!w0(uVarPeekFirst)) {
                return;
            }
            try {
                a0(uVarPeekFirst, mediaCrypto);
            } catch (Exception e2) {
                String strValueOf = String.valueOf(uVarPeekFirst);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 30);
                sb.append("Failed to initialize decoder: ");
                sb.append(strValueOf);
                b.i.a.c.f3.q.c("MediaCodecRenderer", sb.toString(), e2);
                this.X.removeFirst();
                j1 j1Var = this.J;
                String str = uVarPeekFirst.a;
                String strValueOf2 = String.valueOf(j1Var);
                MediaCodecRenderer$DecoderInitializationException mediaCodecRenderer$DecoderInitializationException = new MediaCodecRenderer$DecoderInitializationException(a.l(strValueOf2.length() + a.b(str, 23), "Decoder init failed: ", str, ", ", strValueOf2), e2, j1Var.w, z2, uVarPeekFirst, (e0.a < 21 || !(e2 instanceof MediaCodec$CodecException)) ? null : ((MediaCodec$CodecException) e2).getDiagnosticInfo(), null);
                d0(mediaCodecRenderer$DecoderInitializationException);
                MediaCodecRenderer$DecoderInitializationException mediaCodecRenderer$DecoderInitializationException2 = this.Y;
                if (mediaCodecRenderer$DecoderInitializationException2 == null) {
                    this.Y = mediaCodecRenderer$DecoderInitializationException;
                } else {
                    this.Y = new MediaCodecRenderer$DecoderInitializationException(mediaCodecRenderer$DecoderInitializationException2.getMessage(), mediaCodecRenderer$DecoderInitializationException2.getCause(), mediaCodecRenderer$DecoderInitializationException2.mimeType, mediaCodecRenderer$DecoderInitializationException2.secureDecoderRequired, mediaCodecRenderer$DecoderInitializationException2.codecInfo, mediaCodecRenderer$DecoderInitializationException2.diagnosticInfo, mediaCodecRenderer$DecoderInitializationException);
                }
                if (this.X.isEmpty()) {
                    throw this.Y;
                }
            }
        }
        this.X = null;
    }

    @Override // b.i.a.c.f2
    public boolean d() {
        boolean zD;
        if (this.J == null) {
            return false;
        }
        if (j()) {
            zD = this.f1140s;
        } else {
            i0 i0Var = this.o;
            Objects.requireNonNull(i0Var);
            zD = i0Var.d();
        }
        if (!zD) {
            if (!(this.o0 >= 0) && (this.m0 == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.m0)) {
                return false;
            }
        }
        return true;
    }

    public abstract void d0(Exception exc);

    public abstract void e0(String str, long j, long j2);

    public abstract void f0(String str);

    /* JADX WARN: Code duplicated, block: B:14:0x0032  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f3  */
    @Nullable
    @CallSuper
    public g g0(k1 k1Var) throws ExoPlaybackException {
        b0 b0VarX;
        boolean z2;
        boolean z3 = true;
        this.G0 = true;
        j1 j1Var = k1Var.f1027b;
        Objects.requireNonNull(j1Var);
        if (j1Var.w == null) {
            throw z(new IllegalArgumentException(), j1Var, false, 4005);
        }
        u0(k1Var.a);
        this.J = j1Var;
        if (this.s0) {
            this.u0 = true;
            return null;
        }
        t tVar = this.S;
        if (tVar == null) {
            this.X = null;
            b0();
            return null;
        }
        u uVar = this.Z;
        j1 j1Var2 = this.T;
        DrmSession drmSession = this.L;
        DrmSession drmSession2 = this.M;
        if (drmSession != drmSession2) {
            if (drmSession2 != null && drmSession != null && e0.a >= 23) {
                UUID uuid = x0.e;
                if (!uuid.equals(drmSession.c()) && !uuid.equals(drmSession2.c()) && (b0VarX = X(drmSession2)) != null) {
                    z2 = !uVar.f && (b0VarX.d ? false : drmSession2.e(j1Var.w));
                }
            }
        }
        if (z2) {
            N();
            return new g(uVar.a, j1Var2, j1Var, 0, 128);
        }
        boolean z4 = this.M != this.L;
        d.D(!z4 || e0.a >= 23);
        g gVarK = K(uVar, j1Var2, j1Var);
        int i = gVarK.d;
        int i2 = 2;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException();
                    }
                    if (z0(j1Var)) {
                        this.T = j1Var;
                        if (!z4 || O()) {
                        }
                    } else {
                        i2 = 16;
                    }
                } else if (z0(j1Var)) {
                    this.v0 = true;
                    this.w0 = 1;
                    int i3 = this.f2934a0;
                    if (i3 != 2 && (i3 != 1 || j1Var.B != j1Var2.B || j1Var.C != j1Var2.C)) {
                        z3 = false;
                    }
                    this.f2942i0 = z3;
                    this.T = j1Var;
                    if (!z4 || O()) {
                    }
                } else {
                    i2 = 16;
                }
            } else if (z0(j1Var)) {
                this.T = j1Var;
                if (!z4) {
                    if (this.z0) {
                        this.x0 = 1;
                        if (this.f2936c0 || this.f2938e0) {
                            this.y0 = 3;
                            z3 = false;
                        } else {
                            this.y0 = 1;
                        }
                    }
                    if (z3) {
                    }
                } else if (O()) {
                }
            } else {
                i2 = 16;
            }
            return (gVarK.d != 0 || (this.S == tVar && this.y0 != 3)) ? gVarK : new g(uVar.a, j1Var2, j1Var, 0, i2);
        }
        N();
        i2 = 0;
        if (gVarK.d != 0) {
        }
    }

    public abstract void h0(j1 j1Var, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException;

    @CallSuper
    public void i0(long j) {
        while (true) {
            int i = this.M0;
            if (i == 0 || j < this.I[0]) {
                return;
            }
            long[] jArr = this.G;
            this.K0 = jArr[0];
            this.L0 = this.H[0];
            int i2 = i - 1;
            this.M0 = i2;
            System.arraycopy(jArr, 1, jArr, 0, i2);
            long[] jArr2 = this.H;
            System.arraycopy(jArr2, 1, jArr2, 0, this.M0);
            long[] jArr3 = this.I;
            System.arraycopy(jArr3, 1, jArr3, 0, this.M0);
            j0();
        }
    }

    public abstract void j0();

    public abstract void k0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException;

    @TargetApi(23)
    public final void l0() throws ExoPlaybackException {
        int i = this.y0;
        if (i == 1) {
            R();
            return;
        }
        if (i == 2) {
            R();
            A0();
        } else if (i != 3) {
            this.F0 = true;
            p0();
        } else {
            o0();
            b0();
        }
    }

    public abstract boolean m0(long j, long j2, @Nullable t tVar, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z2, boolean z3, j1 j1Var) throws ExoPlaybackException;

    @Override // b.i.a.c.v0, b.i.a.c.f2
    public void n(float f, float f2) throws ExoPlaybackException {
        this.Q = f;
        this.R = f2;
        z0(this.T);
    }

    public final boolean n0(int i) throws ExoPlaybackException {
        k1 k1VarA = A();
        this.f2946z.p();
        int I = I(k1VarA, this.f2946z, i | 4);
        if (I == -5) {
            g0(k1VarA);
            return true;
        }
        if (I != -4 || !this.f2946z.n()) {
            return false;
        }
        this.E0 = true;
        l0();
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void o0() {
        try {
            t tVar = this.S;
            if (tVar != null) {
                tVar.release();
                this.J0.f1143b++;
                f0(this.Z.a);
            }
            this.S = null;
            try {
                MediaCrypto mediaCrypto = this.N;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
                this.N = null;
                t0(null);
                r0();
            }
        } catch (Throwable th) {
            this.S = null;
            try {
                MediaCrypto mediaCrypto2 = this.N;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
                this.N = null;
                t0(null);
                r0();
            }
        }
    }

    @Override // b.i.a.c.v0, b.i.a.c.g2
    public final int p() {
        return 8;
    }

    public void p0() throws ExoPlaybackException {
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00a1  */
    @Override // b.i.a.c.f2
    public void q(long j, long j2) throws ExoPlaybackException {
        boolean z2;
        boolean z3 = false;
        if (this.H0) {
            this.H0 = false;
            l0();
        }
        ExoPlaybackException exoPlaybackException = this.I0;
        if (exoPlaybackException != null) {
            this.I0 = null;
            throw exoPlaybackException;
        }
        try {
            if (this.F0) {
                p0();
                return;
            }
            if (this.J != null || n0(2)) {
                b0();
                if (this.s0) {
                    d.f("bypassRender");
                    while (J(j, j2)) {
                    }
                    d.d0();
                } else if (this.S != null) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    d.f("drainAndFeed");
                    while (P(j, j2) && v0(jElapsedRealtime)) {
                    }
                    while (Q() && v0(jElapsedRealtime)) {
                    }
                    d.d0();
                } else {
                    e eVar = this.J0;
                    int i = eVar.d;
                    i0 i0Var = this.o;
                    Objects.requireNonNull(i0Var);
                    eVar.d = i + i0Var.c(j - this.q);
                    n0(1);
                }
                synchronized (this.J0) {
                }
            }
        } catch (IllegalStateException e) {
            int i2 = e0.a;
            if (i2 < 21 || !(e instanceof MediaCodec$CodecException)) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                if (stackTrace.length <= 0 || !stackTrace[0].getClassName().equals("android.media.MediaCodec")) {
                    z2 = false;
                } else {
                    z2 = true;
                }
            } else {
                z2 = true;
            }
            if (!z2) {
                throw e;
            }
            d0(e);
            if (i2 >= 21) {
                if (e instanceof MediaCodec$CodecException ? ((MediaCodec$CodecException) e).isRecoverable() : false) {
                    z3 = true;
                }
            }
            if (z3) {
                o0();
            }
            throw z(L(e, this.Z), this.J, z3, 4003);
        }
    }

    @CallSuper
    public void q0() {
        s0();
        this.o0 = -1;
        this.p0 = null;
        this.m0 = -9223372036854775807L;
        this.A0 = false;
        this.z0 = false;
        this.f2942i0 = false;
        this.f2943j0 = false;
        this.q0 = false;
        this.r0 = false;
        this.E.clear();
        this.C0 = -9223372036854775807L;
        this.D0 = -9223372036854775807L;
        q qVar = this.l0;
        if (qVar != null) {
            qVar.a = 0L;
            qVar.f1312b = 0L;
            qVar.c = false;
        }
        this.x0 = 0;
        this.y0 = 0;
        this.w0 = this.v0 ? 1 : 0;
    }

    @CallSuper
    public void r0() {
        q0();
        this.I0 = null;
        this.l0 = null;
        this.X = null;
        this.Z = null;
        this.T = null;
        this.U = null;
        this.V = false;
        this.B0 = false;
        this.W = -1.0f;
        this.f2934a0 = 0;
        this.f2935b0 = false;
        this.f2936c0 = false;
        this.f2937d0 = false;
        this.f2938e0 = false;
        this.f2939f0 = false;
        this.f2940g0 = false;
        this.f2941h0 = false;
        this.k0 = false;
        this.v0 = false;
        this.w0 = 0;
        this.O = false;
    }

    public final void s0() {
        this.n0 = -1;
        this.A.l = null;
    }

    public final void t0(@Nullable DrmSession drmSession) {
        DrmSession drmSession2 = this.L;
        if (drmSession2 != drmSession) {
            if (drmSession != null) {
                drmSession.a(null);
            }
            if (drmSession2 != null) {
                drmSession2.b(null);
            }
        }
        this.L = drmSession;
    }

    public final void u0(@Nullable DrmSession drmSession) {
        DrmSession drmSession2 = this.M;
        if (drmSession2 != drmSession) {
            if (drmSession != null) {
                drmSession.a(null);
            }
            if (drmSession2 != null) {
                drmSession2.b(null);
            }
        }
        this.M = drmSession;
    }

    public final boolean v0(long j) {
        return this.P == -9223372036854775807L || SystemClock.elapsedRealtime() - j < this.P;
    }

    public boolean w0(u uVar) {
        return true;
    }

    public boolean x0(j1 j1Var) {
        return false;
    }

    public abstract int y0(v vVar, j1 j1Var) throws MediaCodecUtil$DecoderQueryException;

    public final boolean z0(j1 j1Var) throws ExoPlaybackException {
        if (e0.a >= 23 && this.S != null && this.y0 != 3 && this.n != 0) {
            float f = this.R;
            j1[] j1VarArr = this.p;
            Objects.requireNonNull(j1VarArr);
            float fV = V(f, j1Var, j1VarArr);
            float f2 = this.W;
            if (f2 == fV) {
                return true;
            }
            if (fV == -1.0f) {
                N();
                return false;
            }
            if (f2 == -1.0f && fV <= this.f2945y) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", fV);
            this.S.setParameters(bundle);
            this.W = fV;
        }
        return true;
    }
}
