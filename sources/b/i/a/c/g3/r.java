package b.i.a.c.g3;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo$CodecCapabilities;
import android.media.MediaCodecInfo$CodecProfileLevel;
import android.media.MediaCodecInfo$VideoCapabilities;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.i.a.c.a3.i0;
import b.i.a.c.f3.e0;
import b.i.a.c.h2;
import b.i.a.c.j1;
import b.i.a.c.j1$b;
import b.i.a.c.k1;
import b.i.a.c.y2.t$a;
import b.i.a.c.y2.t$b;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil$DecoderQueryException;
import com.google.android.exoplayer2.video.DummySurface;
import com.google.android.exoplayer2.video.MediaCodecVideoDecoderException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: MediaCodecVideoRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public class r extends MediaCodecRenderer {
    public static final int[] N0 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    public static boolean O0;
    public static boolean P0;
    public final Context Q0;
    public final v R0;
    public final x$a S0;
    public final long T0;
    public final int U0;
    public final boolean V0;
    public r$a W0;
    public boolean X0;
    public boolean Y0;

    @Nullable
    public Surface Z0;

    @Nullable
    public DummySurface a1;
    public boolean b1;
    public int c1;
    public boolean d1;
    public boolean e1;
    public boolean f1;
    public long g1;
    public long h1;
    public long i1;
    public int j1;
    public int k1;
    public int l1;
    public long m1;
    public long n1;
    public long o1;
    public int p1;
    public int q1;
    public int r1;
    public int s1;
    public float t1;

    @Nullable
    public y u1;
    public boolean v1;
    public int w1;

    @Nullable
    public r$b x1;

    @Nullable
    public u y1;

    public r(Context context, t$b t_b, b.i.a.c.y2.v vVar, long j, boolean z2, @Nullable Handler handler, @Nullable x xVar, int i) {
        super(2, t_b, vVar, z2, 30.0f);
        this.T0 = j;
        this.U0 = i;
        Context applicationContext = context.getApplicationContext();
        this.Q0 = applicationContext;
        this.R0 = new v(applicationContext);
        this.S0 = new x$a(handler, xVar);
        this.V0 = "NVIDIA".equals(e0.c);
        this.h1 = -9223372036854775807L;
        this.q1 = -1;
        this.r1 = -1;
        this.t1 = -1.0f;
        this.c1 = 1;
        this.w1 = 0;
        this.u1 = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:47:0x008c  */
    /* JADX WARN: Code duplicated, block: B:610:0x082b  */
    /* JADX WARN: Code duplicated, block: B:6:0x001a  */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1093)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:31)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:21)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public static boolean E0() {
        /*
            Method dump skipped, instruction units count: 3048
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.a.c.g3.r.E0():boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:43:0x0080  */
    /* JADX WARN: Code duplicated, block: B:65:0x00cc  */
    public static int F0(b.i.a.c.y2.u uVar, j1 j1Var) {
        byte b2;
        int iF;
        int iIntValue;
        int i = j1Var.B;
        int i2 = j1Var.C;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        String str = j1Var.w;
        if ("video/dolby-vision".equals(str)) {
            Pair<Integer, Integer> pairC = MediaCodecUtil.c(j1Var);
            str = (pairC == null || !((iIntValue = ((Integer) pairC.first).intValue()) == 512 || iIntValue == 1 || iIntValue == 2)) ? "video/hevc" : "video/avc";
        }
        str.hashCode();
        int i3 = 4;
        switch (str) {
            case "video/3gpp":
                b2 = 0;
                break;
            case "video/hevc":
                b2 = 1;
                break;
            case "video/mp4v-es":
                b2 = 2;
                break;
            case "video/avc":
                b2 = 3;
                break;
            case "video/x-vnd.on2.vp8":
                b2 = 4;
                break;
            case "video/x-vnd.on2.vp9":
                b2 = 5;
                break;
            default:
                b2 = -1;
                break;
        }
        if (b2 == 0) {
            iF = i * i2;
            i3 = 2;
        } else {
            if (b2 != 1) {
                if (b2 == 2) {
                    iF = i * i2;
                } else if (b2 != 3) {
                    if (b2 != 4) {
                        if (b2 != 5) {
                            return -1;
                        }
                    }
                    iF = i * i2;
                } else {
                    String str2 = e0.d;
                    if ("BRAVIA 4K 2015".equals(str2) || ("Amazon".equals(e0.c) && ("KFSOWI".equals(str2) || ("AFTS".equals(str2) && uVar.f)))) {
                        return -1;
                    }
                    iF = e0.f(i2, 16) * e0.f(i, 16) * 16 * 16;
                }
                i3 = 2;
            }
            iF = i * i2;
        }
        return (iF * 3) / (i3 * 2);
    }

    public static List<b.i.a.c.y2.u> G0(b.i.a.c.y2.v vVar, j1 j1Var, boolean z2, boolean z3) throws MediaCodecUtil$DecoderQueryException {
        Pair<Integer, Integer> pairC;
        String str = j1Var.w;
        if (str == null) {
            return Collections.emptyList();
        }
        List<b.i.a.c.y2.u> listA = vVar.a(str, z2, z3);
        Pattern pattern = MediaCodecUtil.a;
        ArrayList arrayList = new ArrayList(listA);
        MediaCodecUtil.j(arrayList, new b.i.a.c.y2.g(j1Var));
        if ("video/dolby-vision".equals(str) && (pairC = MediaCodecUtil.c(j1Var)) != null) {
            int iIntValue = ((Integer) pairC.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                arrayList.addAll(vVar.a("video/hevc", z2, z3));
            } else if (iIntValue == 512) {
                arrayList.addAll(vVar.a("video/avc", z2, z3));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static int H0(b.i.a.c.y2.u uVar, j1 j1Var) {
        if (j1Var.f1018x == -1) {
            return F0(uVar, j1Var);
        }
        int size = j1Var.f1019y.size();
        int length = 0;
        for (int i = 0; i < size; i++) {
            length += j1Var.f1019y.get(i).length;
        }
        return j1Var.f1018x + length;
    }

    public static boolean I0(long j) {
        return j < -30000;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, b.i.a.c.v0
    public void B() {
        x$a x_a;
        b.i.a.c.v2.e eVar;
        this.u1 = null;
        C0();
        this.b1 = false;
        v vVar = this.R0;
        v$b v_b = vVar.f993b;
        if (v_b != null) {
            v_b.unregister();
            v$e v_e = vVar.c;
            Objects.requireNonNull(v_e);
            v_e.l.sendEmptyMessage(2);
        }
        this.x1 = null;
        try {
            super.B();
            x_a = this.S0;
            eVar = this.J0;
            Objects.requireNonNull(x_a);
            synchronized (eVar) {
            }
        } finally {
            x_a = this.S0;
            eVar = this.J0;
            Objects.requireNonNull(x_a);
            synchronized (eVar) {
                Handler handler = x_a.a;
                if (handler != null) {
                    handler.post(new c(x_a, eVar));
                }
            }
        }
    }

    @Override // b.i.a.c.v0
    public void C(boolean z2, boolean z3) throws ExoPlaybackException {
        this.J0 = new b.i.a.c.v2.e();
        h2 h2Var = this.l;
        Objects.requireNonNull(h2Var);
        boolean z4 = h2Var.f1015b;
        b.c.a.a0.d.D((z4 && this.w1 == 0) ? false : true);
        if (this.v1 != z4) {
            this.v1 = z4;
            o0();
        }
        x$a x_a = this.S0;
        b.i.a.c.v2.e eVar = this.J0;
        Handler handler = x_a.a;
        if (handler != null) {
            handler.post(new f(x_a, eVar));
        }
        v vVar = this.R0;
        if (vVar.f993b != null) {
            v$e v_e = vVar.c;
            Objects.requireNonNull(v_e);
            v_e.l.sendEmptyMessage(1);
            vVar.f993b.a(new b(vVar));
        }
        this.e1 = z3;
        this.f1 = false;
    }

    public final void C0() {
        b.i.a.c.y2.t tVar;
        this.d1 = false;
        if (e0.a < 23 || !this.v1 || (tVar = this.S) == null) {
            return;
        }
        this.x1 = new r$b(this, tVar);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, b.i.a.c.v0
    public void D(long j, boolean z2) throws ExoPlaybackException {
        super.D(j, z2);
        C0();
        this.R0.b();
        this.m1 = -9223372036854775807L;
        this.g1 = -9223372036854775807L;
        this.k1 = 0;
        if (z2) {
            R0();
        } else {
            this.h1 = -9223372036854775807L;
        }
    }

    public boolean D0(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (r.class) {
            if (!O0) {
                P0 = E0();
                O0 = true;
            }
        }
        return P0;
    }

    @Override // b.i.a.c.v0
    @TargetApi(17)
    public void E() {
        try {
            try {
                M();
                o0();
                u0(null);
                if (this.a1 != null) {
                    O0();
                }
            } catch (Throwable th) {
                u0(null);
                throw th;
            }
        } catch (Throwable th2) {
            if (this.a1 != null) {
                O0();
            }
            throw th2;
        }
    }

    @Override // b.i.a.c.v0
    public void F() {
        this.j1 = 0;
        this.i1 = SystemClock.elapsedRealtime();
        this.n1 = SystemClock.elapsedRealtime() * 1000;
        this.o1 = 0L;
        this.p1 = 0;
        v vVar = this.R0;
        vVar.d = true;
        vVar.b();
        vVar.d(false);
    }

    @Override // b.i.a.c.v0
    public void G() {
        this.h1 = -9223372036854775807L;
        J0();
        int i = this.p1;
        if (i != 0) {
            x$a x_a = this.S0;
            long j = this.o1;
            Handler handler = x_a.a;
            if (handler != null) {
                handler.post(new l(x_a, j, i));
            }
            this.o1 = 0L;
            this.p1 = 0;
        }
        v vVar = this.R0;
        vVar.d = false;
        vVar.a();
    }

    public final void J0() {
        if (this.j1 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.i1;
            x$a x_a = this.S0;
            int i = this.j1;
            Handler handler = x_a.a;
            if (handler != null) {
                handler.post(new h(x_a, i, j));
            }
            this.j1 = 0;
            this.i1 = jElapsedRealtime;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public b.i.a.c.v2.g K(b.i.a.c.y2.u uVar, j1 j1Var, j1 j1Var2) {
        b.i.a.c.v2.g gVarC = uVar.c(j1Var, j1Var2);
        int i = gVarC.e;
        int i2 = j1Var2.B;
        r$a r_a = this.W0;
        if (i2 > r_a.a || j1Var2.C > r_a.f990b) {
            i |= 256;
        }
        if (H0(uVar, j1Var2) > this.W0.c) {
            i |= 64;
        }
        int i3 = i;
        return new b.i.a.c.v2.g(uVar.a, j1Var, j1Var2, i3 != 0 ? 0 : gVarC.d, i3);
    }

    public void K0() {
        this.f1 = true;
        if (this.d1) {
            return;
        }
        this.d1 = true;
        x$a x_a = this.S0;
        Surface surface = this.Z0;
        if (x_a.a != null) {
            x_a.a.post(new g(x_a, surface, SystemClock.elapsedRealtime()));
        }
        this.b1 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public MediaCodecDecoderException L(Throwable th, @Nullable b.i.a.c.y2.u uVar) {
        return new MediaCodecVideoDecoderException(th, uVar, this.Z0);
    }

    public final void L0() {
        int i = this.q1;
        if (i == -1 && this.r1 == -1) {
            return;
        }
        y yVar = this.u1;
        if (yVar != null && yVar.k == i && yVar.l == this.r1 && yVar.m == this.s1 && yVar.n == this.t1) {
            return;
        }
        y yVar2 = new y(i, this.r1, this.s1, this.t1);
        this.u1 = yVar2;
        x$a x_a = this.S0;
        Handler handler = x_a.a;
        if (handler != null) {
            handler.post(new j(x_a, yVar2));
        }
    }

    public final void M0(long j, long j2, j1 j1Var) {
        u uVar = this.y1;
        if (uVar != null) {
            uVar.e(j, j2, j1Var, this.U);
        }
    }

    public void N0(long j) throws ExoPlaybackException {
        B0(j);
        L0();
        this.J0.e++;
        K0();
        super.i0(j);
        if (this.v1) {
            return;
        }
        this.l1--;
    }

    @RequiresApi(17)
    public final void O0() {
        Surface surface = this.Z0;
        DummySurface dummySurface = this.a1;
        if (surface == dummySurface) {
            this.Z0 = null;
        }
        dummySurface.release();
        this.a1 = null;
    }

    public void P0(b.i.a.c.y2.t tVar, int i) {
        L0();
        b.c.a.a0.d.f("releaseOutputBuffer");
        tVar.releaseOutputBuffer(i, true);
        b.c.a.a0.d.d0();
        this.n1 = SystemClock.elapsedRealtime() * 1000;
        this.J0.e++;
        this.k1 = 0;
        K0();
    }

    @RequiresApi(21)
    public void Q0(b.i.a.c.y2.t tVar, int i, long j) {
        L0();
        b.c.a.a0.d.f("releaseOutputBuffer");
        tVar.c(i, j);
        b.c.a.a0.d.d0();
        this.n1 = SystemClock.elapsedRealtime() * 1000;
        this.J0.e++;
        this.k1 = 0;
        K0();
    }

    public final void R0() {
        this.h1 = this.T0 > 0 ? SystemClock.elapsedRealtime() + this.T0 : -9223372036854775807L;
    }

    public final boolean S0(b.i.a.c.y2.u uVar) {
        return e0.a >= 23 && !this.v1 && !D0(uVar.a) && (!uVar.f || DummySurface.b(this.Q0));
    }

    public void T0(b.i.a.c.y2.t tVar, int i) {
        b.c.a.a0.d.f("skipVideoBuffer");
        tVar.releaseOutputBuffer(i, false);
        b.c.a.a0.d.d0();
        this.J0.f++;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean U() {
        return this.v1 && e0.a < 23;
    }

    public void U0(int i) {
        b.i.a.c.v2.e eVar = this.J0;
        eVar.g += i;
        this.j1 += i;
        int i2 = this.k1 + i;
        this.k1 = i2;
        eVar.h = Math.max(i2, eVar.h);
        int i3 = this.U0;
        if (i3 <= 0 || this.j1 < i3) {
            return;
        }
        J0();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float V(float f, j1 j1Var, j1[] j1VarArr) {
        float fMax = -1.0f;
        for (j1 j1Var2 : j1VarArr) {
            float f2 = j1Var2.D;
            if (f2 != -1.0f) {
                fMax = Math.max(fMax, f2);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f;
    }

    public void V0(long j) {
        b.i.a.c.v2.e eVar = this.J0;
        eVar.j += j;
        eVar.k++;
        this.o1 += j;
        this.p1++;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public List<b.i.a.c.y2.u> W(b.i.a.c.y2.v vVar, j1 j1Var, boolean z2) throws MediaCodecUtil$DecoderQueryException {
        return G0(vVar, j1Var, z2, this.v1);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @TargetApi(17)
    public t$a Y(b.i.a.c.y2.u uVar, j1 j1Var, @Nullable MediaCrypto mediaCrypto, float f) {
        r$a r_a;
        Point point;
        MediaCodecInfo$VideoCapabilities videoCapabilities;
        boolean z2;
        Pair<Integer, Integer> pairC;
        int iF0;
        j1 j1Var2 = j1Var;
        DummySurface dummySurface = this.a1;
        if (dummySurface != null && dummySurface.l != uVar.f) {
            O0();
        }
        String str = uVar.c;
        j1[] j1VarArr = this.p;
        Objects.requireNonNull(j1VarArr);
        int iMax = j1Var2.B;
        int iMax2 = j1Var2.C;
        int iH0 = H0(uVar, j1Var);
        if (j1VarArr.length == 1) {
            if (iH0 != -1 && (iF0 = F0(uVar, j1Var)) != -1) {
                iH0 = Math.min((int) (iH0 * 1.5f), iF0);
            }
            r_a = new r$a(iMax, iMax2, iH0);
        } else {
            int length = j1VarArr.length;
            boolean z3 = false;
            for (int i = 0; i < length; i++) {
                j1 j1VarA = j1VarArr[i];
                if (j1Var2.I != null && j1VarA.I == null) {
                    j1$b j1_bA = j1VarA.a();
                    j1_bA.w = j1Var2.I;
                    j1VarA = j1_bA.a();
                }
                if (uVar.c(j1Var2, j1VarA).d != 0) {
                    int i2 = j1VarA.B;
                    z3 |= i2 == -1 || j1VarA.C == -1;
                    iMax = Math.max(iMax, i2);
                    iMax2 = Math.max(iMax2, j1VarA.C);
                    iH0 = Math.max(iH0, H0(uVar, j1VarA));
                }
            }
            if (z3) {
                Log.w("MediaCodecVideoRenderer", b.d.b.a.a.h(66, "Resolutions unknown. Codec max resolution: ", iMax, "x", iMax2));
                int i3 = j1Var2.C;
                int i4 = j1Var2.B;
                boolean z4 = i3 > i4;
                int i5 = z4 ? i3 : i4;
                if (z4) {
                    i3 = i4;
                }
                float f2 = i3 / i5;
                int[] iArr = N0;
                int length2 = iArr.length;
                int i6 = 0;
                while (true) {
                    Point pointA = null;
                    if (i6 < length2) {
                        int i7 = length2;
                        int i8 = iArr[i6];
                        int[] iArr2 = iArr;
                        int i9 = (int) (i8 * f2);
                        if (i8 > i5 && i9 > i3) {
                            int i10 = i3;
                            float f3 = f2;
                            if (e0.a < 21) {
                                try {
                                    int iF = e0.f(i8, 16) * 16;
                                    int iF2 = e0.f(i9, 16) * 16;
                                    if (iF * iF2 <= MediaCodecUtil.i()) {
                                        int i11 = z4 ? iF2 : iF;
                                        if (!z4) {
                                            iF = iF2;
                                        }
                                        point = new Point(i11, iF);
                                        break;
                                    }
                                    i6++;
                                    j1Var2 = j1Var;
                                    length2 = i7;
                                    iArr = iArr2;
                                    i3 = i10;
                                    f2 = f3;
                                } catch (MediaCodecUtil$DecoderQueryException unused) {
                                    point = pointA;
                                    break;
                                }
                            } else {
                                int i12 = z4 ? i9 : i8;
                                if (!z4) {
                                    i8 = i9;
                                }
                                MediaCodecInfo$CodecCapabilities mediaCodecInfo$CodecCapabilities = uVar.d;
                                if (mediaCodecInfo$CodecCapabilities != null && (videoCapabilities = mediaCodecInfo$CodecCapabilities.getVideoCapabilities()) != null) {
                                    pointA = b.i.a.c.y2.u.a(videoCapabilities, i12, i8);
                                }
                                Point point2 = pointA;
                                pointA = point2;
                                if (!uVar.g(point2.x, point2.y, j1Var2.D)) {
                                    i6++;
                                    j1Var2 = j1Var;
                                    length2 = i7;
                                    iArr = iArr2;
                                    i3 = i10;
                                    f2 = f3;
                                }
                            }
                        }
                    }
                    point = pointA;
                    break;
                }
                if (point != null) {
                    iMax = Math.max(iMax, point.x);
                    iMax2 = Math.max(iMax2, point.y);
                    j1$b j1_bA2 = j1Var.a();
                    j1_bA2.p = iMax;
                    j1_bA2.q = iMax2;
                    iH0 = Math.max(iH0, F0(uVar, j1_bA2.a()));
                    Log.w("MediaCodecVideoRenderer", b.d.b.a.a.h(57, "Codec max resolution adjusted to: ", iMax, "x", iMax2));
                }
            }
            r_a = new r$a(iMax, iMax2, iH0);
        }
        this.W0 = r_a;
        boolean z5 = this.V0;
        int i13 = this.v1 ? this.w1 : 0;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", j1Var.B);
        mediaFormat.setInteger("height", j1Var.C);
        b.c.a.a0.d.Y1(mediaFormat, j1Var.f1019y);
        float f4 = j1Var.D;
        if (f4 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f4);
        }
        b.c.a.a0.d.j1(mediaFormat, "rotation-degrees", j1Var.E);
        n nVar = j1Var.I;
        if (nVar != null) {
            b.c.a.a0.d.j1(mediaFormat, "color-transfer", nVar.m);
            b.c.a.a0.d.j1(mediaFormat, "color-standard", nVar.k);
            b.c.a.a0.d.j1(mediaFormat, "color-range", nVar.l);
            byte[] bArr = nVar.n;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(j1Var.w) && (pairC = MediaCodecUtil.c(j1Var)) != null) {
            b.c.a.a0.d.j1(mediaFormat, "profile", ((Integer) pairC.first).intValue());
        }
        mediaFormat.setInteger("max-width", r_a.a);
        mediaFormat.setInteger("max-height", r_a.f990b);
        b.c.a.a0.d.j1(mediaFormat, "max-input-size", r_a.c);
        if (e0.a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z5) {
            z2 = true;
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        } else {
            z2 = true;
        }
        if (i13 != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", z2);
            mediaFormat.setInteger("audio-session-id", i13);
        }
        if (this.Z0 == null) {
            if (!S0(uVar)) {
                throw new IllegalStateException();
            }
            if (this.a1 == null) {
                this.a1 = DummySurface.c(this.Q0, uVar.f);
            }
            this.Z0 = this.a1;
        }
        return new t$a(uVar, mediaFormat, j1Var, this.Z0, mediaCrypto, 0, false);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @TargetApi(29)
    public void Z(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.Y0) {
            ByteBuffer byteBuffer = decoderInputBuffer.o;
            Objects.requireNonNull(byteBuffer);
            if (byteBuffer.remaining() >= 7) {
                byte b2 = byteBuffer.get();
                short s2 = byteBuffer.getShort();
                short s3 = byteBuffer.getShort();
                byte b3 = byteBuffer.get();
                byte b4 = byteBuffer.get();
                byteBuffer.position(0);
                if (b2 == -75 && s2 == 60 && s3 == 1 && b3 == 4 && b4 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    b.i.a.c.y2.t tVar = this.S;
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("hdr10-plus-info", bArr);
                    tVar.setParameters(bundle);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, b.i.a.c.f2
    public boolean d() {
        DummySurface dummySurface;
        if (super.d() && (this.d1 || (((dummySurface = this.a1) != null && this.Z0 == dummySurface) || this.S == null || this.v1))) {
            this.h1 = -9223372036854775807L;
            return true;
        }
        if (this.h1 == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.h1) {
            return true;
        }
        this.h1 = -9223372036854775807L;
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void d0(Exception exc) {
        b.i.a.c.f3.q.b("MediaCodecVideoRenderer", "Video codec error", exc);
        x$a x_a = this.S0;
        Handler handler = x_a.a;
        if (handler != null) {
            handler.post(new e(x_a, exc));
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void e0(String str, long j, long j2) {
        x$a x_a = this.S0;
        Handler handler = x_a.a;
        if (handler != null) {
            handler.post(new i(x_a, str, j, j2));
        }
        this.X0 = D0(str);
        b.i.a.c.y2.u uVar = this.Z;
        Objects.requireNonNull(uVar);
        boolean z2 = false;
        if (e0.a >= 29 && "video/x-vnd.on2.vp9".equals(uVar.f1315b)) {
            for (MediaCodecInfo$CodecProfileLevel mediaCodecInfo$CodecProfileLevel : uVar.d()) {
                if (mediaCodecInfo$CodecProfileLevel.profile == 16384) {
                    z2 = true;
                    break;
                }
            }
        }
        this.Y0 = z2;
        if (e0.a < 23 || !this.v1) {
            return;
        }
        b.i.a.c.y2.t tVar = this.S;
        Objects.requireNonNull(tVar);
        this.x1 = new r$b(this, tVar);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void f0(String str) {
        x$a x_a = this.S0;
        Handler handler = x_a.a;
        if (handler != null) {
            handler.post(new d(x_a, str));
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @Nullable
    public b.i.a.c.v2.g g0(k1 k1Var) throws ExoPlaybackException {
        b.i.a.c.v2.g gVarG0 = super.g0(k1Var);
        x$a x_a = this.S0;
        j1 j1Var = k1Var.f1027b;
        Handler handler = x_a.a;
        if (handler != null) {
            handler.post(new k(x_a, j1Var, gVarG0));
        }
        return gVarG0;
    }

    @Override // b.i.a.c.f2, b.i.a.c.g2
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void h0(j1 j1Var, @Nullable MediaFormat mediaFormat) {
        b.i.a.c.y2.t tVar = this.S;
        if (tVar != null) {
            tVar.g(this.c1);
        }
        if (this.v1) {
            this.q1 = j1Var.B;
            this.r1 = j1Var.C;
        } else {
            Objects.requireNonNull(mediaFormat);
            boolean z2 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            this.q1 = z2 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            this.r1 = z2 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        }
        float f = j1Var.F;
        this.t1 = f;
        if (e0.a >= 21) {
            int i = j1Var.E;
            if (i == 90 || i == 270) {
                int i2 = this.q1;
                this.q1 = this.r1;
                this.r1 = i2;
                this.t1 = 1.0f / f;
            }
        } else {
            this.s1 = j1Var.E;
        }
        v vVar = this.R0;
        vVar.f = j1Var.D;
        p pVar = vVar.a;
        pVar.a.c();
        pVar.f987b.c();
        pVar.c = false;
        pVar.d = -9223372036854775807L;
        pVar.e = 0;
        vVar.c();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void i0(long j) {
        super.i0(j);
        if (this.v1) {
            return;
        }
        this.l1--;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void j0() {
        C0();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void k0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        boolean z2 = this.v1;
        if (!z2) {
            this.l1++;
        }
        if (e0.a >= 23 || !z2) {
            return;
        }
        N0(decoderInputBuffer.n);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0077  */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean m0(long j, long j2, @Nullable b.i.a.c.y2.t tVar, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z2, boolean z3, j1 j1Var) throws ExoPlaybackException {
        boolean z4;
        long j4;
        boolean z5;
        boolean z6;
        long j5;
        long j6;
        Objects.requireNonNull(tVar);
        if (this.g1 == -9223372036854775807L) {
            this.g1 = j;
        }
        if (j3 != this.m1) {
            v vVar = this.R0;
            long j7 = vVar.n;
            if (j7 != -1) {
                vVar.p = j7;
                vVar.q = vVar.o;
            }
            vVar.m++;
            p pVar = vVar.a;
            long j8 = j3 * 1000;
            pVar.a.b(j8);
            if (pVar.a.a()) {
                pVar.c = false;
            } else if (pVar.d != -9223372036854775807L) {
                if (pVar.c) {
                    p$a p_a = pVar.f987b;
                    long j9 = p_a.d;
                    if (j9 == 0 ? false : p_a.g[(int) ((j9 - 1) % 15)]) {
                        pVar.f987b.c();
                        pVar.f987b.b(pVar.d);
                    }
                } else {
                    pVar.f987b.c();
                    pVar.f987b.b(pVar.d);
                }
                pVar.c = true;
                pVar.f987b.b(j8);
            }
            if (pVar.c && pVar.f987b.a()) {
                p$a p_a2 = pVar.a;
                pVar.a = pVar.f987b;
                pVar.f987b = p_a2;
                pVar.c = false;
            }
            pVar.d = j8;
            pVar.e = pVar.a.a() ? 0 : pVar.e + 1;
            vVar.c();
            this.m1 = j3;
        }
        long j10 = this.L0;
        long j11 = j3 - j10;
        if (z2 && !z3) {
            T0(tVar, i);
            return true;
        }
        double d = this.Q;
        boolean z7 = this.n == 2;
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long j12 = (long) ((j3 - j) / d);
        if (z7) {
            j12 -= jElapsedRealtime - j2;
        }
        if (this.Z0 == this.a1) {
            if (!I0(j12)) {
                return false;
            }
            T0(tVar, i);
            V0(j12);
            return true;
        }
        long j13 = jElapsedRealtime - this.n1;
        boolean z8 = this.f1 ? !this.d1 : z7 || this.e1;
        if (this.h1 != -9223372036854775807L || j < j10) {
            z4 = false;
        } else {
            if (!z8) {
                if (z7) {
                    if (I0(j12) && j13 > 100000) {
                    }
                }
                z4 = false;
            }
            z4 = true;
        }
        if (z4) {
            long jNanoTime = System.nanoTime();
            M0(j11, jNanoTime, j1Var);
            if (e0.a >= 21) {
                Q0(tVar, i, jNanoTime);
            } else {
                P0(tVar, i);
            }
            V0(j12);
            return true;
        }
        if (!z7 || j == this.g1) {
            return false;
        }
        long jNanoTime2 = System.nanoTime();
        long j14 = (j12 * 1000) + jNanoTime2;
        v vVar2 = this.R0;
        if (vVar2.p == -1 || !vVar2.a.a()) {
            j4 = j11;
        } else {
            p pVar2 = vVar2.a;
            if (pVar2.a()) {
                p$a p_a3 = pVar2.a;
                long j15 = p_a3.e;
                if (j15 == 0) {
                    j6 = 0;
                    j4 = j11;
                } else {
                    j4 = j11;
                    j6 = p_a3.f / j15;
                }
            } else {
                j4 = j11;
                j6 = -9223372036854775807L;
            }
            long j16 = vVar2.q + ((long) (((vVar2.m - vVar2.p) * j6) / vVar2.i));
            if (Math.abs(j14 - j16) <= 20000000) {
                j14 = j16;
            } else {
                vVar2.b();
            }
        }
        vVar2.n = vVar2.m;
        vVar2.o = j14;
        v$e v_e = vVar2.c;
        if (v_e != null && vVar2.k != -9223372036854775807L) {
            long j17 = v_e.k;
            if (j17 != -9223372036854775807L) {
                long j18 = vVar2.k;
                long j19 = (((j14 - j17) / j18) * j18) + j17;
                if (j14 <= j19) {
                    j5 = j19 - j18;
                } else {
                    j5 = j19;
                    j19 = j18 + j19;
                }
                if (j19 - j14 >= j14 - j5) {
                    j19 = j5;
                }
                j14 = j19 - vVar2.l;
            }
        }
        long j20 = (j14 - jNanoTime2) / 1000;
        boolean z9 = this.h1 != -9223372036854775807L;
        if (((j20 > (-500000L) ? 1 : (j20 == (-500000L) ? 0 : -1)) < 0) && !z3) {
            i0 i0Var = this.o;
            Objects.requireNonNull(i0Var);
            int iC = i0Var.c(j - this.q);
            if (iC == 0) {
                z6 = false;
            } else {
                b.i.a.c.v2.e eVar = this.J0;
                eVar.i++;
                int i4 = this.l1 + iC;
                if (z9) {
                    eVar.f += i4;
                } else {
                    U0(i4);
                }
                if (S()) {
                    b0();
                }
                z6 = true;
            }
            if (z6) {
                return false;
            }
        }
        if (I0(j20) && !z3) {
            if (z9) {
                T0(tVar, i);
                z5 = true;
            } else {
                b.c.a.a0.d.f("dropVideoBuffer");
                tVar.releaseOutputBuffer(i, false);
                b.c.a.a0.d.d0();
                z5 = true;
                U0(1);
            }
            V0(j20);
            return z5;
        }
        if (e0.a >= 21) {
            if (j20 >= 50000) {
                return false;
            }
            M0(j4, j14, j1Var);
            Q0(tVar, i, j14);
            V0(j20);
            return true;
        }
        if (j20 >= 30000) {
            return false;
        }
        if (j20 > 11000) {
            try {
                Thread.sleep((j20 - 10000) / 1000);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        M0(j4, j14, j1Var);
        P0(tVar, i);
        V0(j20);
        return true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, b.i.a.c.v0, b.i.a.c.f2
    public void n(float f, float f2) throws ExoPlaybackException {
        this.Q = f;
        this.R = f2;
        z0(this.T);
        v vVar = this.R0;
        vVar.i = f;
        vVar.b();
        vVar.d(false);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    public void q0() {
        super.q0();
        this.l1 = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [b.i.a.c.y2.t] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.view.Surface] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.view.Surface] */
    /* JADX WARN: Type inference failed for: r6v9, types: [com.google.android.exoplayer2.video.DummySurface] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // b.i.a.c.v0, b.i.a.c.b2$b
    public void r(int i, @Nullable Object obj) throws ExoPlaybackException {
        ?? C;
        x$a x_a;
        Handler handler;
        x$a x_a2;
        Handler handler2;
        Surface surface;
        if (i != 1) {
            if (i == 7) {
                this.y1 = (u) obj;
                return;
            }
            if (i == 10) {
                int iIntValue = ((Integer) obj).intValue();
                if (this.w1 != iIntValue) {
                    this.w1 = iIntValue;
                    if (this.v1) {
                        o0();
                        return;
                    }
                    return;
                }
                return;
            }
            if (i == 4) {
                int iIntValue2 = ((Integer) obj).intValue();
                this.c1 = iIntValue2;
                b.i.a.c.y2.t tVar = this.S;
                if (tVar != null) {
                    tVar.g(iIntValue2);
                    return;
                }
                return;
            }
            if (i != 5) {
                return;
            }
            v vVar = this.R0;
            int iIntValue3 = ((Integer) obj).intValue();
            if (vVar.j == iIntValue3) {
                return;
            }
            vVar.j = iIntValue3;
            vVar.d(true);
            return;
        }
        if (obj instanceof Surface) {
            surface = (Surface) obj;
        } else {
            C = 0;
        }
        if (C == 0) {
            DummySurface dummySurface = this.a1;
            if (dummySurface != null) {
                C = surface;
                C = dummySurface;
            } else {
                b.i.a.c.y2.u uVar = this.Z;
                if (uVar != null && S0(uVar)) {
                    C = surface;
                    C = DummySurface.c(this.Q0, uVar.f);
                    this.a1 = C;
                }
            }
        }
        C = surface;
        C = surface;
        C = surface;
        if (this.Z0 == C) {
            if (C == 0 || C == this.a1) {
                return;
            }
            y yVar = this.u1;
            if (yVar != null && (handler = (x_a = this.S0).a) != null) {
                handler.post(new j(x_a, yVar));
            }
            if (this.b1) {
                x$a x_a3 = this.S0;
                Surface surface2 = this.Z0;
                if (x_a3.a != null) {
                    x_a3.a.post(new g(x_a3, surface2, SystemClock.elapsedRealtime()));
                    return;
                }
                return;
            }
            return;
        }
        this.Z0 = C;
        v vVar2 = this.R0;
        Objects.requireNonNull(vVar2);
        ?? r2 = C instanceof DummySurface ? 0 : C;
        if (vVar2.e != r2) {
            vVar2.a();
            vVar2.e = r2;
            vVar2.d(true);
        }
        this.b1 = false;
        int i2 = this.n;
        ?? r0 = this.S;
        if (r0 != 0) {
            if (e0.a < 23 || C == 0 || this.X0) {
                o0();
                b0();
            } else {
                r0.i(C);
            }
        }
        if (C == 0 || C == this.a1) {
            this.u1 = null;
            C0();
            return;
        }
        y yVar2 = this.u1;
        if (yVar2 != null && (handler2 = (x_a2 = this.S0).a) != null) {
            handler2.post(new j(x_a2, yVar2));
        }
        C0();
        if (i2 == 2) {
            R0();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean w0(b.i.a.c.y2.u uVar) {
        return this.Z0 != null || S0(uVar);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int y0(b.i.a.c.y2.v vVar, j1 j1Var) throws MediaCodecUtil$DecoderQueryException {
        int i = 0;
        if (!b.i.a.c.f3.t.j(j1Var.w)) {
            return 0;
        }
        boolean z2 = j1Var.f1020z != null;
        List<b.i.a.c.y2.u> listG0 = G0(vVar, j1Var, z2, false);
        if (z2 && listG0.isEmpty()) {
            listG0 = G0(vVar, j1Var, false, false);
        }
        if (listG0.isEmpty()) {
            return 1;
        }
        int i2 = j1Var.P;
        if (!(i2 == 0 || i2 == 2)) {
            return 2;
        }
        b.i.a.c.y2.u uVar = listG0.get(0);
        boolean zE = uVar.e(j1Var);
        int i3 = uVar.f(j1Var) ? 16 : 8;
        if (zE) {
            List<b.i.a.c.y2.u> listG1 = G0(vVar, j1Var, z2, true);
            if (!listG1.isEmpty()) {
                b.i.a.c.y2.u uVar2 = listG1.get(0);
                if (uVar2.e(j1Var) && uVar2.f(j1Var)) {
                    i = 32;
                }
            }
        }
        return (zE ? 4 : 3) | i3 | i;
    }
}
