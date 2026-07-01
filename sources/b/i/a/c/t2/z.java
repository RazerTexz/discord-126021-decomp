package b.i.a.c.t2;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.annotation.Nullable;
import b.i.a.c.f2$a;
import b.i.a.c.h2;
import b.i.a.c.j1;
import b.i.a.c.j1$b;
import b.i.a.c.k1;
import b.i.a.c.x1;
import b.i.a.c.y2.t$b;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.AudioSink$ConfigurationException;
import com.google.android.exoplayer2.audio.AudioSink$InitializationException;
import com.google.android.exoplayer2.audio.AudioSink$WriteException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$DecoderQueryException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: MediaCodecAudioRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public class z extends MediaCodecRenderer implements b.i.a.c.f3.s {
    public final Context N0;
    public final r$a O0;
    public final AudioSink P0;
    public int Q0;
    public boolean R0;

    @Nullable
    public j1 S0;
    public long T0;
    public boolean U0;
    public boolean V0;
    public boolean W0;

    @Nullable
    public f2$a X0;

    public z(Context context, t$b t_b, b.i.a.c.y2.v vVar, boolean z2, @Nullable Handler handler, @Nullable r rVar, AudioSink audioSink) {
        super(1, t_b, vVar, z2, 44100.0f);
        this.N0 = context.getApplicationContext();
        this.P0 = audioSink;
        this.O0 = new r$a(handler, rVar);
        audioSink.t(new z$b(this, null));
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, b.i.a.c.v0
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

    @Override // b.i.a.c.v0
    public void C(boolean z2, boolean z3) throws ExoPlaybackException {
        b.i.a.c.v2.e eVar = new b.i.a.c.v2.e();
        this.J0 = eVar;
        r$a r_a = this.O0;
        Handler handler = r_a.a;
        if (handler != null) {
            handler.post(new j(r_a, eVar));
        }
        h2 h2Var = this.l;
        Objects.requireNonNull(h2Var);
        if (h2Var.f1015b) {
            this.P0.r();
        } else {
            this.P0.n();
        }
    }

    public final int C0(b.i.a.c.y2.u uVar, j1 j1Var) {
        int i;
        if (!"OMX.google.raw.decoder".equals(uVar.a) || (i = b.i.a.c.f3.e0.a) >= 24 || (i == 23 && b.i.a.c.f3.e0.A(this.N0))) {
            return j1Var.f1018x;
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, b.i.a.c.v0
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

    @Override // b.i.a.c.v0
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

    @Override // b.i.a.c.v0
    public void F() {
        this.P0.e();
    }

    @Override // b.i.a.c.v0
    public void G() {
        D0();
        this.P0.d();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public b.i.a.c.v2.g K(b.i.a.c.y2.u uVar, j1 j1Var, j1 j1Var2) {
        b.i.a.c.v2.g gVarC = uVar.c(j1Var, j1Var2);
        int i = gVarC.e;
        if (C0(uVar, j1Var2) > this.Q0) {
            i |= 64;
        }
        int i2 = i;
        return new b.i.a.c.v2.g(uVar.a, j1Var, j1Var2, i2 != 0 ? 0 : gVarC.d, i2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float V(float f, j1 j1Var, j1[] j1VarArr) {
        int iMax = -1;
        for (j1 j1Var2 : j1VarArr) {
            int i = j1Var2.K;
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
    public List<b.i.a.c.y2.u> W(b.i.a.c.y2.v vVar, j1 j1Var, boolean z2) throws MediaCodecUtil$DecoderQueryException {
        b.i.a.c.y2.u uVarD;
        String str = j1Var.w;
        if (str == null) {
            return Collections.emptyList();
        }
        if (this.P0.a(j1Var) && (uVarD = MediaCodecUtil.d("audio/raw", false, false)) != null) {
            return Collections.singletonList(uVarD);
        }
        List<b.i.a.c.y2.u> listA = vVar.a(str, z2, false);
        Pattern pattern = MediaCodecUtil.a;
        ArrayList arrayList = new ArrayList(listA);
        MediaCodecUtil.j(arrayList, new b.i.a.c.y2.g(j1Var));
        if ("audio/eac3-joc".equals(str)) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            arrayList2.addAll(vVar.a("audio/eac3", z2, false));
            arrayList = arrayList2;
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0066  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b4  */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public b.i.a.c.y2.t$a Y(b.i.a.c.y2.u uVar, j1 j1Var, @Nullable MediaCrypto mediaCrypto, float f) {
        boolean z2;
        boolean z3;
        j1[] j1VarArr = this.p;
        Objects.requireNonNull(j1VarArr);
        int iC0 = C0(uVar, j1Var);
        boolean z4 = false;
        if (j1VarArr.length != 1) {
            for (j1 j1Var2 : j1VarArr) {
                if (uVar.c(j1Var, j1Var2).d != 0) {
                    iC0 = Math.max(iC0, C0(uVar, j1Var2));
                }
            }
        }
        this.Q0 = iC0;
        String str = uVar.a;
        int i = b.i.a.c.f3.e0.a;
        if (i < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(b.i.a.c.f3.e0.c)) {
            String str2 = b.i.a.c.f3.e0.f968b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        this.R0 = z2;
        String str3 = uVar.c;
        int i2 = this.Q0;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str3);
        mediaFormat.setInteger("channel-count", j1Var.J);
        mediaFormat.setInteger("sample-rate", j1Var.K);
        b.c.a.a0.d.Y1(mediaFormat, j1Var.f1019y);
        b.c.a.a0.d.j1(mediaFormat, "max-input-size", i2);
        if (i >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                if (i == 23) {
                    String str4 = b.i.a.c.f3.e0.d;
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
        if (i <= 28 && "audio/ac4".equals(j1Var.w)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i >= 24) {
            AudioSink audioSink = this.P0;
            int i3 = j1Var.J;
            int i4 = j1Var.K;
            j1$b j1_b = new j1$b();
            j1_b.k = "audio/raw";
            j1_b.f1023x = i3;
            j1_b.f1024y = i4;
            j1_b.f1025z = 4;
            if (audioSink.u(j1_b.a()) == 2) {
                mediaFormat.setInteger("pcm-encoding", 4);
            }
        }
        if ("audio/raw".equals(uVar.f1315b) && !"audio/raw".equals(j1Var.w)) {
            z4 = true;
        }
        this.S0 = z4 ? j1Var : null;
        return new b.i.a.c.y2.t$a(uVar, mediaFormat, j1Var, null, mediaCrypto, 0, false);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, b.i.a.c.f2
    public boolean b() {
        return this.F0 && this.P0.b();
    }

    @Override // b.i.a.c.f3.s
    public x1 c() {
        return this.P0.c();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, b.i.a.c.f2
    public boolean d() {
        return this.P0.k() || super.d();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void d0(Exception exc) {
        b.i.a.c.f3.q.b("MediaCodecAudioRenderer", "Audio codec error", exc);
        r$a r_a = this.O0;
        Handler handler = r_a.a;
        if (handler != null) {
            handler.post(new c(r_a, exc));
        }
    }

    @Override // b.i.a.c.f3.s
    public long e() {
        if (this.n == 2) {
            D0();
        }
        return this.T0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void e0(String str, long j, long j2) {
        r$a r_a = this.O0;
        Handler handler = r_a.a;
        if (handler != null) {
            handler.post(new f(r_a, str, j, j2));
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void f0(String str) {
        r$a r_a = this.O0;
        Handler handler = r_a.a;
        if (handler != null) {
            handler.post(new g(r_a, str));
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @Nullable
    public b.i.a.c.v2.g g0(k1 k1Var) throws ExoPlaybackException {
        b.i.a.c.v2.g gVarG0 = super.g0(k1Var);
        r$a r_a = this.O0;
        j1 j1Var = k1Var.f1027b;
        Handler handler = r_a.a;
        if (handler != null) {
            handler.post(new e(r_a, j1Var, gVarG0));
        }
        return gVarG0;
    }

    @Override // b.i.a.c.f2, b.i.a.c.g2
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void h0(j1 j1Var, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException {
        int iR;
        int i;
        j1 j1Var2 = this.S0;
        int[] iArr = null;
        if (j1Var2 != null) {
            j1Var = j1Var2;
        } else if (this.S != null) {
            if ("audio/raw".equals(j1Var.w)) {
                iR = j1Var.L;
            } else if (b.i.a.c.f3.e0.a >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                iR = mediaFormat.getInteger("pcm-encoding");
            } else if (mediaFormat.containsKey("v-bits-per-sample")) {
                iR = b.i.a.c.f3.e0.r(mediaFormat.getInteger("v-bits-per-sample"));
            } else {
                iR = "audio/raw".equals(j1Var.w) ? j1Var.L : 2;
            }
            j1$b j1_b = new j1$b();
            j1_b.k = "audio/raw";
            j1_b.f1025z = iR;
            j1_b.A = j1Var.M;
            j1_b.B = j1Var.N;
            j1_b.f1023x = mediaFormat.getInteger("channel-count");
            j1_b.f1024y = mediaFormat.getInteger("sample-rate");
            j1 j1VarA = j1_b.a();
            if (this.R0 && j1VarA.J == 6 && (i = j1Var.J) < 6) {
                iArr = new int[i];
                for (int i2 = 0; i2 < j1Var.J; i2++) {
                    iArr[i2] = i2;
                }
            }
            j1Var = j1VarA;
        }
        try {
            this.P0.v(j1Var, 0, iArr);
        } catch (AudioSink$ConfigurationException e) {
            throw z(e, e.format, false, 5001);
        }
    }

    @Override // b.i.a.c.f3.s
    public void i(x1 x1Var) {
        this.P0.i(x1Var);
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
    public boolean m0(long j, long j2, @Nullable b.i.a.c.y2.t tVar, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z2, boolean z3, j1 j1Var) throws ExoPlaybackException {
        Objects.requireNonNull(byteBuffer);
        if (this.S0 != null && (i2 & 2) != 0) {
            Objects.requireNonNull(tVar);
            tVar.releaseOutputBuffer(i, false);
            return true;
        }
        if (z2) {
            if (tVar != null) {
                tVar.releaseOutputBuffer(i, false);
            }
            this.J0.f += i3;
            this.P0.p();
            return true;
        }
        try {
            if (!this.P0.s(byteBuffer, j3, i3)) {
                return false;
            }
            if (tVar != null) {
                tVar.releaseOutputBuffer(i, false);
            }
            this.J0.e += i3;
            return true;
        } catch (AudioSink$InitializationException e) {
            throw z(e, e.format, e.isRecoverable, 5001);
        } catch (AudioSink$WriteException e2) {
            throw z(e2, j1Var, e2.isRecoverable, 5002);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void p0() throws ExoPlaybackException {
        try {
            this.P0.j();
        } catch (AudioSink$WriteException e) {
            throw z(e, e.format, e.isRecoverable, 5002);
        }
    }

    @Override // b.i.a.c.v0, b.i.a.c.b2$b
    public void r(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 2) {
            this.P0.q(((Float) obj).floatValue());
        }
        if (i == 3) {
            this.P0.o((o) obj);
            return;
        }
        if (i == 6) {
            this.P0.x((u) obj);
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
                this.X0 = (f2$a) obj;
                break;
        }
    }

    @Override // b.i.a.c.v0, b.i.a.c.f2
    @Nullable
    public b.i.a.c.f3.s w() {
        return this;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean x0(j1 j1Var) {
        return this.P0.a(j1Var);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int y0(b.i.a.c.y2.v vVar, j1 j1Var) throws MediaCodecUtil$DecoderQueryException {
        if (!b.i.a.c.f3.t.h(j1Var.w)) {
            return 0;
        }
        int i = b.i.a.c.f3.e0.a >= 21 ? 32 : 0;
        int i2 = j1Var.P;
        boolean z2 = i2 != 0;
        boolean z3 = i2 == 0 || i2 == 2;
        if (z3 && this.P0.a(j1Var) && (!z2 || MediaCodecUtil.d("audio/raw", false, false) != null)) {
            return i | 12;
        }
        if ("audio/raw".equals(j1Var.w) && !this.P0.a(j1Var)) {
            return 1;
        }
        AudioSink audioSink = this.P0;
        int i3 = j1Var.J;
        int i4 = j1Var.K;
        j1$b j1_b = new j1$b();
        j1_b.k = "audio/raw";
        j1_b.f1023x = i3;
        j1_b.f1024y = i4;
        j1_b.f1025z = 2;
        if (!audioSink.a(j1_b.a())) {
            return 1;
        }
        List<b.i.a.c.y2.u> listW = W(vVar, j1Var, false);
        if (listW.isEmpty()) {
            return 1;
        }
        if (!z3) {
            return 2;
        }
        b.i.a.c.y2.u uVar = listW.get(0);
        boolean zE = uVar.e(j1Var);
        return ((zE && uVar.f(j1Var)) ? 16 : 8) | (zE ? 4 : 3) | i;
    }
}
