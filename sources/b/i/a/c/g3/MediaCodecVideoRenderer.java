package b.i.a.c.g3;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.FormatHolder;
import b.i.a.c.RendererConfiguration;
import b.i.a.c.a3.SampleStream;
import b.i.a.c.f3.Log2;
import b.i.a.c.f3.MimeTypes;
import b.i.a.c.f3.Util2;
import b.i.a.c.g3.FixedFrameRateEstimator;
import b.i.a.c.g3.VideoFrameReleaseHelper;
import b.i.a.c.g3.VideoRendererEventListener2;
import b.i.a.c.v2.DecoderCounters;
import b.i.a.c.v2.DecoderReuseEvaluation;
import b.i.a.c.y2.MediaCodecAdapter;
import b.i.a.c.y2.MediaCodecInfo;
import b.i.a.c.y2.MediaCodecSelector;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.video.DummySurface;
import com.google.android.exoplayer2.video.MediaCodecVideoDecoderException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.i.a.c.g3.r, reason: use source file name */
/* JADX INFO: compiled from: MediaCodecVideoRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    public static final int[] N0 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    public static boolean O0;
    public static boolean P0;
    public final Context Q0;
    public final VideoFrameReleaseHelper R0;
    public final VideoRendererEventListener2.a S0;
    public final long T0;
    public final int U0;
    public final boolean V0;
    public a W0;
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
    public VideoSize u1;
    public boolean v1;
    public int w1;

    @Nullable
    public b x1;

    @Nullable
    public VideoFrameMetadataListener y1;

    /* JADX INFO: renamed from: b.i.a.c.g3.r$a */
    /* JADX INFO: compiled from: MediaCodecVideoRenderer.java */
    public static final class a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f990b;
        public final int c;

        public a(int i, int i2, int i3) {
            this.a = i;
            this.f990b = i2;
            this.c = i3;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.g3.r$b */
    /* JADX INFO: compiled from: MediaCodecVideoRenderer.java */
    @RequiresApi(23)
    public final class b implements MediaCodecAdapter.c, Handler.Callback {
        public final Handler j;

        public b(MediaCodecAdapter mediaCodecAdapter) {
            int i = Util2.a;
            Looper looperMyLooper = Looper.myLooper();
            AnimatableValueParser.H(looperMyLooper);
            Handler handler = new Handler(looperMyLooper, this);
            this.j = handler;
            mediaCodecAdapter.f(this, handler);
        }

        public final void a(long j) {
            MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
            if (this != mediaCodecVideoRenderer.x1) {
                return;
            }
            if (j == RecyclerView.FOREVER_NS) {
                mediaCodecVideoRenderer.H0 = true;
                return;
            }
            try {
                mediaCodecVideoRenderer.N0(j);
            } catch (ExoPlaybackException e) {
                MediaCodecVideoRenderer.this.I0 = e;
            }
        }

        public void b(MediaCodecAdapter mediaCodecAdapter, long j, long j2) {
            if (Util2.a >= 30) {
                a(j);
            } else {
                this.j.sendMessageAtFrontOfQueue(Message.obtain(this.j, 0, (int) (j >> 32), (int) j));
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            a((Util2.L(message.arg1) << 32) | Util2.L(message.arg2));
            return true;
        }
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.b bVar, MediaCodecSelector mediaCodecSelector, long j, boolean z2, @Nullable Handler handler, @Nullable VideoRendererEventListener2 videoRendererEventListener2, int i) {
        super(2, bVar, mediaCodecSelector, z2, 30.0f);
        this.T0 = j;
        this.U0 = i;
        Context applicationContext = context.getApplicationContext();
        this.Q0 = applicationContext;
        this.R0 = new VideoFrameReleaseHelper(applicationContext);
        this.S0 = new VideoRendererEventListener2.a(handler, videoRendererEventListener2);
        this.V0 = "NVIDIA".equals(Util2.c);
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
        throw new UnsupportedOperationException("Method not decompiled: b.i.a.c.g3.MediaCodecVideoRenderer.E0():boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:43:0x0080  */
    /* JADX WARN: Code duplicated, block: B:65:0x00cc  */
    public static int F0(MediaCodecInfo mediaCodecInfo, Format2 format2) {
        byte b2;
        int iF;
        int iIntValue;
        int i = format2.B;
        int i2 = format2.C;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        String str = format2.w;
        if ("video/dolby-vision".equals(str)) {
            Pair<Integer, Integer> pairC = MediaCodecUtil.c(format2);
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
                    String str2 = Util2.d;
                    if ("BRAVIA 4K 2015".equals(str2) || ("Amazon".equals(Util2.c) && ("KFSOWI".equals(str2) || ("AFTS".equals(str2) && mediaCodecInfo.f)))) {
                        return -1;
                    }
                    iF = Util2.f(i2, 16) * Util2.f(i, 16) * 16 * 16;
                }
                i3 = 2;
            }
            iF = i * i2;
        }
        return (iF * 3) / (i3 * 2);
    }

    public static List<MediaCodecInfo> G0(MediaCodecSelector mediaCodecSelector, Format2 format2, boolean z2, boolean z3) throws MediaCodecUtil.DecoderQueryException {
        Pair<Integer, Integer> pairC;
        String str = format2.w;
        if (str == null) {
            return Collections.emptyList();
        }
        List<MediaCodecInfo> listA = mediaCodecSelector.a(str, z2, z3);
        Pattern pattern = MediaCodecUtil.a;
        ArrayList arrayList = new ArrayList(listA);
        MediaCodecUtil.j(arrayList, new b.i.a.c.y2.g(format2));
        if ("video/dolby-vision".equals(str) && (pairC = MediaCodecUtil.c(format2)) != null) {
            int iIntValue = ((Integer) pairC.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                arrayList.addAll(mediaCodecSelector.a("video/hevc", z2, z3));
            } else if (iIntValue == 512) {
                arrayList.addAll(mediaCodecSelector.a("video/avc", z2, z3));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static int H0(MediaCodecInfo mediaCodecInfo, Format2 format2) {
        if (format2.f1018x == -1) {
            return F0(mediaCodecInfo, format2);
        }
        int size = format2.f1019y.size();
        int length = 0;
        for (int i = 0; i < size; i++) {
            length += format2.f1019y.get(i).length;
        }
        return format2.f1018x + length;
    }

    public static boolean I0(long j) {
        return j < -30000;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, b.i.a.c.BaseRenderer
    public void B() {
        final VideoRendererEventListener2.a aVar;
        final DecoderCounters decoderCounters;
        this.u1 = null;
        C0();
        this.b1 = false;
        VideoFrameReleaseHelper videoFrameReleaseHelper = this.R0;
        VideoFrameReleaseHelper.b bVar = videoFrameReleaseHelper.f993b;
        if (bVar != null) {
            bVar.unregister();
            VideoFrameReleaseHelper.e eVar = videoFrameReleaseHelper.c;
            Objects.requireNonNull(eVar);
            eVar.l.sendEmptyMessage(2);
        }
        this.x1 = null;
        try {
            super.B();
            aVar = this.S0;
            decoderCounters = this.J0;
            Objects.requireNonNull(aVar);
            synchronized (decoderCounters) {
            }
        } finally {
            aVar = this.S0;
            decoderCounters = this.J0;
            Objects.requireNonNull(aVar);
            synchronized (decoderCounters) {
                Handler handler = aVar.a;
                if (handler != null) {
                    handler.post(new Runnable() { // from class: b.i.a.c.g3.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            VideoRendererEventListener2.a aVar2 = aVar;
                            DecoderCounters decoderCounters2 = decoderCounters;
                            Objects.requireNonNull(aVar2);
                            synchronized (decoderCounters2) {
                            }
                            VideoRendererEventListener2 videoRendererEventListener2 = aVar2.f995b;
                            int i = Util2.a;
                            videoRendererEventListener2.Z(decoderCounters2);
                        }
                    });
                }
            }
        }
    }

    @Override // b.i.a.c.BaseRenderer
    public void C(boolean z2, boolean z3) throws ExoPlaybackException {
        this.J0 = new DecoderCounters();
        RendererConfiguration rendererConfiguration = this.l;
        Objects.requireNonNull(rendererConfiguration);
        boolean z4 = rendererConfiguration.f1015b;
        AnimatableValueParser.D((z4 && this.w1 == 0) ? false : true);
        if (this.v1 != z4) {
            this.v1 = z4;
            o0();
        }
        final VideoRendererEventListener2.a aVar = this.S0;
        final DecoderCounters decoderCounters = this.J0;
        Handler handler = aVar.a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: b.i.a.c.g3.f
                @Override // java.lang.Runnable
                public final void run() {
                    VideoRendererEventListener2.a aVar2 = aVar;
                    DecoderCounters decoderCounters2 = decoderCounters;
                    VideoRendererEventListener2 videoRendererEventListener2 = aVar2.f995b;
                    int i = Util2.a;
                    videoRendererEventListener2.P(decoderCounters2);
                }
            });
        }
        VideoFrameReleaseHelper videoFrameReleaseHelper = this.R0;
        if (videoFrameReleaseHelper.f993b != null) {
            VideoFrameReleaseHelper.e eVar = videoFrameReleaseHelper.c;
            Objects.requireNonNull(eVar);
            eVar.l.sendEmptyMessage(1);
            videoFrameReleaseHelper.f993b.a(new b.i.a.c.g3.b(videoFrameReleaseHelper));
        }
        this.e1 = z3;
        this.f1 = false;
    }

    public final void C0() {
        MediaCodecAdapter mediaCodecAdapter;
        this.d1 = false;
        if (Util2.a < 23 || !this.v1 || (mediaCodecAdapter = this.S) == null) {
            return;
        }
        this.x1 = new b(mediaCodecAdapter);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, b.i.a.c.BaseRenderer
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
        synchronized (MediaCodecVideoRenderer.class) {
            if (!O0) {
                P0 = E0();
                O0 = true;
            }
        }
        return P0;
    }

    @Override // b.i.a.c.BaseRenderer
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

    @Override // b.i.a.c.BaseRenderer
    public void F() {
        this.j1 = 0;
        this.i1 = SystemClock.elapsedRealtime();
        this.n1 = SystemClock.elapsedRealtime() * 1000;
        this.o1 = 0L;
        this.p1 = 0;
        VideoFrameReleaseHelper videoFrameReleaseHelper = this.R0;
        videoFrameReleaseHelper.d = true;
        videoFrameReleaseHelper.b();
        videoFrameReleaseHelper.d(false);
    }

    @Override // b.i.a.c.BaseRenderer
    public void G() {
        this.h1 = -9223372036854775807L;
        J0();
        final int i = this.p1;
        if (i != 0) {
            final VideoRendererEventListener2.a aVar = this.S0;
            final long j = this.o1;
            Handler handler = aVar.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: b.i.a.c.g3.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoRendererEventListener2.a aVar2 = aVar;
                        long j2 = j;
                        int i2 = i;
                        VideoRendererEventListener2 videoRendererEventListener2 = aVar2.f995b;
                        int i3 = Util2.a;
                        videoRendererEventListener2.h0(j2, i2);
                    }
                });
            }
            this.o1 = 0L;
            this.p1 = 0;
        }
        VideoFrameReleaseHelper videoFrameReleaseHelper = this.R0;
        videoFrameReleaseHelper.d = false;
        videoFrameReleaseHelper.a();
    }

    public final void J0() {
        if (this.j1 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            final long j = jElapsedRealtime - this.i1;
            final VideoRendererEventListener2.a aVar = this.S0;
            final int i = this.j1;
            Handler handler = aVar.a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: b.i.a.c.g3.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        VideoRendererEventListener2.a aVar2 = aVar;
                        int i2 = i;
                        long j2 = j;
                        VideoRendererEventListener2 videoRendererEventListener2 = aVar2.f995b;
                        int i3 = Util2.a;
                        videoRendererEventListener2.F(i2, j2);
                    }
                });
            }
            this.j1 = 0;
            this.i1 = jElapsedRealtime;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public DecoderReuseEvaluation K(MediaCodecInfo mediaCodecInfo, Format2 format2, Format2 format3) {
        DecoderReuseEvaluation decoderReuseEvaluationC = mediaCodecInfo.c(format2, format3);
        int i = decoderReuseEvaluationC.e;
        int i2 = format3.B;
        a aVar = this.W0;
        if (i2 > aVar.a || format3.C > aVar.f990b) {
            i |= 256;
        }
        if (H0(mediaCodecInfo, format3) > this.W0.c) {
            i |= 64;
        }
        int i3 = i;
        return new DecoderReuseEvaluation(mediaCodecInfo.a, format2, format3, i3 != 0 ? 0 : decoderReuseEvaluationC.d, i3);
    }

    public void K0() {
        this.f1 = true;
        if (this.d1) {
            return;
        }
        this.d1 = true;
        VideoRendererEventListener2.a aVar = this.S0;
        Surface surface = this.Z0;
        if (aVar.a != null) {
            aVar.a.post(new g(aVar, surface, SystemClock.elapsedRealtime()));
        }
        this.b1 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public MediaCodecDecoderException L(Throwable th, @Nullable MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecVideoDecoderException(th, mediaCodecInfo, this.Z0);
    }

    public final void L0() {
        int i = this.q1;
        if (i == -1 && this.r1 == -1) {
            return;
        }
        VideoSize videoSize = this.u1;
        if (videoSize != null && videoSize.k == i && videoSize.l == this.r1 && videoSize.m == this.s1 && videoSize.n == this.t1) {
            return;
        }
        VideoSize videoSize2 = new VideoSize(i, this.r1, this.s1, this.t1);
        this.u1 = videoSize2;
        VideoRendererEventListener2.a aVar = this.S0;
        Handler handler = aVar.a;
        if (handler != null) {
            handler.post(new j(aVar, videoSize2));
        }
    }

    public final void M0(long j, long j2, Format2 format2) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.y1;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.e(j, j2, format2, this.U);
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

    public void P0(MediaCodecAdapter mediaCodecAdapter, int i) {
        L0();
        AnimatableValueParser.f("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, true);
        AnimatableValueParser.d0();
        this.n1 = SystemClock.elapsedRealtime() * 1000;
        this.J0.e++;
        this.k1 = 0;
        K0();
    }

    @RequiresApi(21)
    public void Q0(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        L0();
        AnimatableValueParser.f("releaseOutputBuffer");
        mediaCodecAdapter.c(i, j);
        AnimatableValueParser.d0();
        this.n1 = SystemClock.elapsedRealtime() * 1000;
        this.J0.e++;
        this.k1 = 0;
        K0();
    }

    public final void R0() {
        this.h1 = this.T0 > 0 ? SystemClock.elapsedRealtime() + this.T0 : -9223372036854775807L;
    }

    public final boolean S0(MediaCodecInfo mediaCodecInfo) {
        return Util2.a >= 23 && !this.v1 && !D0(mediaCodecInfo.a) && (!mediaCodecInfo.f || DummySurface.b(this.Q0));
    }

    public void T0(MediaCodecAdapter mediaCodecAdapter, int i) {
        AnimatableValueParser.f("skipVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, false);
        AnimatableValueParser.d0();
        this.J0.f++;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean U() {
        return this.v1 && Util2.a < 23;
    }

    public void U0(int i) {
        DecoderCounters decoderCounters = this.J0;
        decoderCounters.g += i;
        this.j1 += i;
        int i2 = this.k1 + i;
        this.k1 = i2;
        decoderCounters.h = Math.max(i2, decoderCounters.h);
        int i3 = this.U0;
        if (i3 <= 0 || this.j1 < i3) {
            return;
        }
        J0();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public float V(float f, Format2 format2, Format2[] format2Arr) {
        float fMax = -1.0f;
        for (Format2 format3 : format2Arr) {
            float f2 = format3.D;
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
        DecoderCounters decoderCounters = this.J0;
        decoderCounters.j += j;
        decoderCounters.k++;
        this.o1 += j;
        this.p1++;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public List<MediaCodecInfo> W(MediaCodecSelector mediaCodecSelector, Format2 format2, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        return G0(mediaCodecSelector, format2, z2, this.v1);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @TargetApi(17)
    public MediaCodecAdapter.a Y(MediaCodecInfo mediaCodecInfo, Format2 format2, @Nullable MediaCrypto mediaCrypto, float f) {
        a aVar;
        Point point;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        boolean z2;
        Pair<Integer, Integer> pairC;
        int iF0;
        Format2 format3 = format2;
        DummySurface dummySurface = this.a1;
        if (dummySurface != null && dummySurface.l != mediaCodecInfo.f) {
            O0();
        }
        String str = mediaCodecInfo.c;
        Format2[] format2Arr = this.p;
        Objects.requireNonNull(format2Arr);
        int iMax = format3.B;
        int iMax2 = format3.C;
        int iH0 = H0(mediaCodecInfo, format2);
        if (format2Arr.length == 1) {
            if (iH0 != -1 && (iF0 = F0(mediaCodecInfo, format2)) != -1) {
                iH0 = Math.min((int) (iH0 * 1.5f), iF0);
            }
            aVar = new a(iMax, iMax2, iH0);
        } else {
            int length = format2Arr.length;
            boolean z3 = false;
            for (int i = 0; i < length; i++) {
                Format2 format2A = format2Arr[i];
                if (format3.I != null && format2A.I == null) {
                    Format2.b bVarA = format2A.a();
                    bVarA.w = format3.I;
                    format2A = bVarA.a();
                }
                if (mediaCodecInfo.c(format3, format2A).d != 0) {
                    int i2 = format2A.B;
                    z3 |= i2 == -1 || format2A.C == -1;
                    iMax = Math.max(iMax, i2);
                    iMax2 = Math.max(iMax2, format2A.C);
                    iH0 = Math.max(iH0, H0(mediaCodecInfo, format2A));
                }
            }
            if (z3) {
                Log.w("MediaCodecVideoRenderer", outline.h(66, "Resolutions unknown. Codec max resolution: ", iMax, "x", iMax2));
                int i3 = format3.C;
                int i4 = format3.B;
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
                            if (Util2.a < 21) {
                                try {
                                    int iF = Util2.f(i8, 16) * 16;
                                    int iF2 = Util2.f(i9, 16) * 16;
                                    if (iF * iF2 <= MediaCodecUtil.i()) {
                                        int i11 = z4 ? iF2 : iF;
                                        if (!z4) {
                                            iF = iF2;
                                        }
                                        point = new Point(i11, iF);
                                        break;
                                    }
                                    i6++;
                                    format3 = format2;
                                    length2 = i7;
                                    iArr = iArr2;
                                    i3 = i10;
                                    f2 = f3;
                                } catch (MediaCodecUtil.DecoderQueryException unused) {
                                    point = pointA;
                                    break;
                                }
                            } else {
                                int i12 = z4 ? i9 : i8;
                                if (!z4) {
                                    i8 = i9;
                                }
                                MediaCodecInfo.CodecCapabilities codecCapabilities = mediaCodecInfo.d;
                                if (codecCapabilities != null && (videoCapabilities = codecCapabilities.getVideoCapabilities()) != null) {
                                    pointA = b.i.a.c.y2.MediaCodecInfo.a(videoCapabilities, i12, i8);
                                }
                                Point point2 = pointA;
                                pointA = point2;
                                if (!mediaCodecInfo.g(point2.x, point2.y, format3.D)) {
                                    i6++;
                                    format3 = format2;
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
                    Format2.b bVarA2 = format2.a();
                    bVarA2.p = iMax;
                    bVarA2.q = iMax2;
                    iH0 = Math.max(iH0, F0(mediaCodecInfo, bVarA2.a()));
                    Log.w("MediaCodecVideoRenderer", outline.h(57, "Codec max resolution adjusted to: ", iMax, "x", iMax2));
                }
            }
            aVar = new a(iMax, iMax2, iH0);
        }
        this.W0 = aVar;
        boolean z5 = this.V0;
        int i13 = this.v1 ? this.w1 : 0;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", format2.B);
        mediaFormat.setInteger("height", format2.C);
        AnimatableValueParser.Y1(mediaFormat, format2.f1019y);
        float f4 = format2.D;
        if (f4 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f4);
        }
        AnimatableValueParser.j1(mediaFormat, "rotation-degrees", format2.E);
        ColorInfo colorInfo = format2.I;
        if (colorInfo != null) {
            AnimatableValueParser.j1(mediaFormat, "color-transfer", colorInfo.m);
            AnimatableValueParser.j1(mediaFormat, "color-standard", colorInfo.k);
            AnimatableValueParser.j1(mediaFormat, "color-range", colorInfo.l);
            byte[] bArr = colorInfo.n;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(format2.w) && (pairC = MediaCodecUtil.c(format2)) != null) {
            AnimatableValueParser.j1(mediaFormat, "profile", ((Integer) pairC.first).intValue());
        }
        mediaFormat.setInteger("max-width", aVar.a);
        mediaFormat.setInteger("max-height", aVar.f990b);
        AnimatableValueParser.j1(mediaFormat, "max-input-size", aVar.c);
        if (Util2.a >= 23) {
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
            if (!S0(mediaCodecInfo)) {
                throw new IllegalStateException();
            }
            if (this.a1 == null) {
                this.a1 = DummySurface.c(this.Q0, mediaCodecInfo.f);
            }
            this.Z0 = this.a1;
        }
        return new MediaCodecAdapter.a(mediaCodecInfo, mediaFormat, format2, this.Z0, mediaCrypto, 0, false);
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
                    MediaCodecAdapter mediaCodecAdapter = this.S;
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("hdr10-plus-info", bArr);
                    mediaCodecAdapter.setParameters(bundle);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, b.i.a.c.Renderer2
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
    public void d0(final Exception exc) {
        Log2.b("MediaCodecVideoRenderer", "Video codec error", exc);
        final VideoRendererEventListener2.a aVar = this.S0;
        Handler handler = aVar.a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: b.i.a.c.g3.e
                @Override // java.lang.Runnable
                public final void run() {
                    VideoRendererEventListener2.a aVar2 = aVar;
                    Exception exc2 = exc;
                    VideoRendererEventListener2 videoRendererEventListener2 = aVar2.f995b;
                    int i = Util2.a;
                    videoRendererEventListener2.V(exc2);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void e0(final String str, final long j, final long j2) {
        final VideoRendererEventListener2.a aVar = this.S0;
        Handler handler = aVar.a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: b.i.a.c.g3.i
                @Override // java.lang.Runnable
                public final void run() {
                    VideoRendererEventListener2.a aVar2 = aVar;
                    String str2 = str;
                    long j3 = j;
                    long j4 = j2;
                    VideoRendererEventListener2 videoRendererEventListener2 = aVar2.f995b;
                    int i = Util2.a;
                    videoRendererEventListener2.n(str2, j3, j4);
                }
            });
        }
        this.X0 = D0(str);
        b.i.a.c.y2.MediaCodecInfo mediaCodecInfo = this.Z;
        Objects.requireNonNull(mediaCodecInfo);
        boolean z2 = false;
        if (Util2.a >= 29 && "video/x-vnd.on2.vp9".equals(mediaCodecInfo.f1315b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : mediaCodecInfo.d()) {
                if (codecProfileLevel.profile == 16384) {
                    z2 = true;
                    break;
                }
            }
        }
        this.Y0 = z2;
        if (Util2.a < 23 || !this.v1) {
            return;
        }
        MediaCodecAdapter mediaCodecAdapter = this.S;
        Objects.requireNonNull(mediaCodecAdapter);
        this.x1 = new b(mediaCodecAdapter);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void f0(final String str) {
        final VideoRendererEventListener2.a aVar = this.S0;
        Handler handler = aVar.a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: b.i.a.c.g3.d
                @Override // java.lang.Runnable
                public final void run() {
                    VideoRendererEventListener2.a aVar2 = aVar;
                    String str2 = str;
                    VideoRendererEventListener2 videoRendererEventListener2 = aVar2.f995b;
                    int i = Util2.a;
                    videoRendererEventListener2.l(str2);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @Nullable
    public DecoderReuseEvaluation g0(FormatHolder formatHolder) throws ExoPlaybackException {
        final DecoderReuseEvaluation decoderReuseEvaluationG0 = super.g0(formatHolder);
        final VideoRendererEventListener2.a aVar = this.S0;
        final Format2 format2 = formatHolder.f1027b;
        Handler handler = aVar.a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: b.i.a.c.g3.k
                @Override // java.lang.Runnable
                public final void run() {
                    VideoRendererEventListener2.a aVar2 = aVar;
                    Format2 format3 = format2;
                    DecoderReuseEvaluation decoderReuseEvaluation = decoderReuseEvaluationG0;
                    VideoRendererEventListener2 videoRendererEventListener2 = aVar2.f995b;
                    int i = Util2.a;
                    videoRendererEventListener2.O(format3);
                    aVar2.f995b.Q(format3, decoderReuseEvaluation);
                }
            });
        }
        return decoderReuseEvaluationG0;
    }

    @Override // b.i.a.c.Renderer2, b.i.a.c.RendererCapabilities
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void h0(Format2 format2, @Nullable MediaFormat mediaFormat) {
        MediaCodecAdapter mediaCodecAdapter = this.S;
        if (mediaCodecAdapter != null) {
            mediaCodecAdapter.g(this.c1);
        }
        if (this.v1) {
            this.q1 = format2.B;
            this.r1 = format2.C;
        } else {
            Objects.requireNonNull(mediaFormat);
            boolean z2 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            this.q1 = z2 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            this.r1 = z2 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        }
        float f = format2.F;
        this.t1 = f;
        if (Util2.a >= 21) {
            int i = format2.E;
            if (i == 90 || i == 270) {
                int i2 = this.q1;
                this.q1 = this.r1;
                this.r1 = i2;
                this.t1 = 1.0f / f;
            }
        } else {
            this.s1 = format2.E;
        }
        VideoFrameReleaseHelper videoFrameReleaseHelper = this.R0;
        videoFrameReleaseHelper.f = format2.D;
        FixedFrameRateEstimator fixedFrameRateEstimator = videoFrameReleaseHelper.a;
        fixedFrameRateEstimator.a.c();
        fixedFrameRateEstimator.f987b.c();
        fixedFrameRateEstimator.c = false;
        fixedFrameRateEstimator.d = -9223372036854775807L;
        fixedFrameRateEstimator.e = 0;
        videoFrameReleaseHelper.c();
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
        if (Util2.a >= 23 || !z2) {
            return;
        }
        N0(decoderInputBuffer.n);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0077  */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean m0(long j, long j2, @Nullable MediaCodecAdapter mediaCodecAdapter, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z2, boolean z3, Format2 format2) throws ExoPlaybackException {
        boolean z4;
        long j4;
        boolean z5;
        boolean z6;
        long j5;
        long j6;
        Objects.requireNonNull(mediaCodecAdapter);
        if (this.g1 == -9223372036854775807L) {
            this.g1 = j;
        }
        if (j3 != this.m1) {
            VideoFrameReleaseHelper videoFrameReleaseHelper = this.R0;
            long j7 = videoFrameReleaseHelper.n;
            if (j7 != -1) {
                videoFrameReleaseHelper.p = j7;
                videoFrameReleaseHelper.q = videoFrameReleaseHelper.o;
            }
            videoFrameReleaseHelper.m++;
            FixedFrameRateEstimator fixedFrameRateEstimator = videoFrameReleaseHelper.a;
            long j8 = j3 * 1000;
            fixedFrameRateEstimator.a.b(j8);
            if (fixedFrameRateEstimator.a.a()) {
                fixedFrameRateEstimator.c = false;
            } else if (fixedFrameRateEstimator.d != -9223372036854775807L) {
                if (fixedFrameRateEstimator.c) {
                    FixedFrameRateEstimator.a aVar = fixedFrameRateEstimator.f987b;
                    long j9 = aVar.d;
                    if (j9 == 0 ? false : aVar.g[(int) ((j9 - 1) % 15)]) {
                        fixedFrameRateEstimator.f987b.c();
                        fixedFrameRateEstimator.f987b.b(fixedFrameRateEstimator.d);
                    }
                } else {
                    fixedFrameRateEstimator.f987b.c();
                    fixedFrameRateEstimator.f987b.b(fixedFrameRateEstimator.d);
                }
                fixedFrameRateEstimator.c = true;
                fixedFrameRateEstimator.f987b.b(j8);
            }
            if (fixedFrameRateEstimator.c && fixedFrameRateEstimator.f987b.a()) {
                FixedFrameRateEstimator.a aVar2 = fixedFrameRateEstimator.a;
                fixedFrameRateEstimator.a = fixedFrameRateEstimator.f987b;
                fixedFrameRateEstimator.f987b = aVar2;
                fixedFrameRateEstimator.c = false;
            }
            fixedFrameRateEstimator.d = j8;
            fixedFrameRateEstimator.e = fixedFrameRateEstimator.a.a() ? 0 : fixedFrameRateEstimator.e + 1;
            videoFrameReleaseHelper.c();
            this.m1 = j3;
        }
        long j10 = this.L0;
        long j11 = j3 - j10;
        if (z2 && !z3) {
            T0(mediaCodecAdapter, i);
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
            T0(mediaCodecAdapter, i);
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
            M0(j11, jNanoTime, format2);
            if (Util2.a >= 21) {
                Q0(mediaCodecAdapter, i, jNanoTime);
            } else {
                P0(mediaCodecAdapter, i);
            }
            V0(j12);
            return true;
        }
        if (!z7 || j == this.g1) {
            return false;
        }
        long jNanoTime2 = System.nanoTime();
        long j14 = (j12 * 1000) + jNanoTime2;
        VideoFrameReleaseHelper videoFrameReleaseHelper2 = this.R0;
        if (videoFrameReleaseHelper2.p == -1 || !videoFrameReleaseHelper2.a.a()) {
            j4 = j11;
        } else {
            FixedFrameRateEstimator fixedFrameRateEstimator2 = videoFrameReleaseHelper2.a;
            if (fixedFrameRateEstimator2.a()) {
                FixedFrameRateEstimator.a aVar3 = fixedFrameRateEstimator2.a;
                long j15 = aVar3.e;
                if (j15 == 0) {
                    j6 = 0;
                    j4 = j11;
                } else {
                    j4 = j11;
                    j6 = aVar3.f / j15;
                }
            } else {
                j4 = j11;
                j6 = -9223372036854775807L;
            }
            long j16 = videoFrameReleaseHelper2.q + ((long) (((videoFrameReleaseHelper2.m - videoFrameReleaseHelper2.p) * j6) / videoFrameReleaseHelper2.i));
            if (Math.abs(j14 - j16) <= 20000000) {
                j14 = j16;
            } else {
                videoFrameReleaseHelper2.b();
            }
        }
        videoFrameReleaseHelper2.n = videoFrameReleaseHelper2.m;
        videoFrameReleaseHelper2.o = j14;
        VideoFrameReleaseHelper.e eVar = videoFrameReleaseHelper2.c;
        if (eVar != null && videoFrameReleaseHelper2.k != -9223372036854775807L) {
            long j17 = eVar.k;
            if (j17 != -9223372036854775807L) {
                long j18 = videoFrameReleaseHelper2.k;
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
                j14 = j19 - videoFrameReleaseHelper2.l;
            }
        }
        long j20 = (j14 - jNanoTime2) / 1000;
        boolean z9 = this.h1 != -9223372036854775807L;
        if (((j20 > (-500000L) ? 1 : (j20 == (-500000L) ? 0 : -1)) < 0) && !z3) {
            SampleStream sampleStream = this.o;
            Objects.requireNonNull(sampleStream);
            int iC = sampleStream.c(j - this.q);
            if (iC == 0) {
                z6 = false;
            } else {
                DecoderCounters decoderCounters = this.J0;
                decoderCounters.i++;
                int i4 = this.l1 + iC;
                if (z9) {
                    decoderCounters.f += i4;
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
                T0(mediaCodecAdapter, i);
                z5 = true;
            } else {
                AnimatableValueParser.f("dropVideoBuffer");
                mediaCodecAdapter.releaseOutputBuffer(i, false);
                AnimatableValueParser.d0();
                z5 = true;
                U0(1);
            }
            V0(j20);
            return z5;
        }
        if (Util2.a >= 21) {
            if (j20 >= 50000) {
                return false;
            }
            M0(j4, j14, format2);
            Q0(mediaCodecAdapter, i, j14);
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
        M0(j4, j14, format2);
        P0(mediaCodecAdapter, i);
        V0(j20);
        return true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, b.i.a.c.BaseRenderer, b.i.a.c.Renderer2
    public void n(float f, float f2) throws ExoPlaybackException {
        this.Q = f;
        this.R = f2;
        z0(this.T);
        VideoFrameReleaseHelper videoFrameReleaseHelper = this.R0;
        videoFrameReleaseHelper.i = f;
        videoFrameReleaseHelper.b();
        videoFrameReleaseHelper.d(false);
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
    @Override // b.i.a.c.BaseRenderer, b.i.a.c.PlayerMessage.b
    public void r(int i, @Nullable Object obj) throws ExoPlaybackException {
        ?? C;
        VideoRendererEventListener2.a aVar;
        Handler handler;
        VideoRendererEventListener2.a aVar2;
        Handler handler2;
        Surface surface;
        if (i != 1) {
            if (i == 7) {
                this.y1 = (VideoFrameMetadataListener) obj;
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
                MediaCodecAdapter mediaCodecAdapter = this.S;
                if (mediaCodecAdapter != null) {
                    mediaCodecAdapter.g(iIntValue2);
                    return;
                }
                return;
            }
            if (i != 5) {
                return;
            }
            VideoFrameReleaseHelper videoFrameReleaseHelper = this.R0;
            int iIntValue3 = ((Integer) obj).intValue();
            if (videoFrameReleaseHelper.j == iIntValue3) {
                return;
            }
            videoFrameReleaseHelper.j = iIntValue3;
            videoFrameReleaseHelper.d(true);
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
                b.i.a.c.y2.MediaCodecInfo mediaCodecInfo = this.Z;
                if (mediaCodecInfo != null && S0(mediaCodecInfo)) {
                    C = surface;
                    C = DummySurface.c(this.Q0, mediaCodecInfo.f);
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
            VideoSize videoSize = this.u1;
            if (videoSize != null && (handler = (aVar = this.S0).a) != null) {
                handler.post(new j(aVar, videoSize));
            }
            if (this.b1) {
                VideoRendererEventListener2.a aVar3 = this.S0;
                Surface surface2 = this.Z0;
                if (aVar3.a != null) {
                    aVar3.a.post(new g(aVar3, surface2, SystemClock.elapsedRealtime()));
                    return;
                }
                return;
            }
            return;
        }
        this.Z0 = C;
        VideoFrameReleaseHelper videoFrameReleaseHelper2 = this.R0;
        Objects.requireNonNull(videoFrameReleaseHelper2);
        ?? r2 = C instanceof DummySurface ? 0 : C;
        if (videoFrameReleaseHelper2.e != r2) {
            videoFrameReleaseHelper2.a();
            videoFrameReleaseHelper2.e = r2;
            videoFrameReleaseHelper2.d(true);
        }
        this.b1 = false;
        int i2 = this.n;
        ?? r0 = this.S;
        if (r0 != 0) {
            if (Util2.a < 23 || C == 0 || this.X0) {
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
        VideoSize videoSize2 = this.u1;
        if (videoSize2 != null && (handler2 = (aVar2 = this.S0).a) != null) {
            handler2.post(new j(aVar2, videoSize2));
        }
        C0();
        if (i2 == 2) {
            R0();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean w0(b.i.a.c.y2.MediaCodecInfo mediaCodecInfo) {
        return this.Z0 != null || S0(mediaCodecInfo);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public int y0(MediaCodecSelector mediaCodecSelector, Format2 format2) throws MediaCodecUtil.DecoderQueryException {
        int i = 0;
        if (!MimeTypes.j(format2.w)) {
            return 0;
        }
        boolean z2 = format2.f1020z != null;
        List<b.i.a.c.y2.MediaCodecInfo> listG0 = G0(mediaCodecSelector, format2, z2, false);
        if (z2 && listG0.isEmpty()) {
            listG0 = G0(mediaCodecSelector, format2, false, false);
        }
        if (listG0.isEmpty()) {
            return 1;
        }
        int i2 = format2.P;
        if (!(i2 == 0 || i2 == 2)) {
            return 2;
        }
        b.i.a.c.y2.MediaCodecInfo mediaCodecInfo = listG0.get(0);
        boolean zE = mediaCodecInfo.e(format2);
        int i3 = mediaCodecInfo.f(format2) ? 16 : 8;
        if (zE) {
            List<b.i.a.c.y2.MediaCodecInfo> listG1 = G0(mediaCodecSelector, format2, z2, true);
            if (!listG1.isEmpty()) {
                b.i.a.c.y2.MediaCodecInfo mediaCodecInfo2 = listG1.get(0);
                if (mediaCodecInfo2.e(format2) && mediaCodecInfo2.f(format2)) {
                    i = 32;
                }
            }
        }
        return (zE ? 4 : 3) | i3 | i;
    }
}
