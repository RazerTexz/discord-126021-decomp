package p007b.p225i.p226a.p242c.p260g3;

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
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2804h2;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.C2815k1;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2546i0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2750q;
import p007b.p225i.p226a.p242c.p259f3.C2753t;
import p007b.p225i.p226a.p242c.p260g3.C2779p;
import p007b.p225i.p226a.p242c.p260g3.C2785v;
import p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x;
import p007b.p225i.p226a.p242c.p265v2.C2957e;
import p007b.p225i.p226a.p242c.p265v2.C2959g;
import p007b.p225i.p226a.p242c.p278y2.C3135g;
import p007b.p225i.p226a.p242c.p278y2.C3149u;
import p007b.p225i.p226a.p242c.p278y2.InterfaceC3148t;
import p007b.p225i.p226a.p242c.p278y2.InterfaceC3150v;

/* JADX INFO: renamed from: b.i.a.c.g3.r */
/* JADX INFO: compiled from: MediaCodecVideoRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2781r extends MediaCodecRenderer {

    /* JADX INFO: renamed from: N0 */
    public static final int[] f6867N0 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};

    /* JADX INFO: renamed from: O0 */
    public static boolean f6868O0;

    /* JADX INFO: renamed from: P0 */
    public static boolean f6869P0;

    /* JADX INFO: renamed from: Q0 */
    public final Context f6870Q0;

    /* JADX INFO: renamed from: R0 */
    public final C2785v f6871R0;

    /* JADX INFO: renamed from: S0 */
    public final InterfaceC2787x.a f6872S0;

    /* JADX INFO: renamed from: T0 */
    public final long f6873T0;

    /* JADX INFO: renamed from: U0 */
    public final int f6874U0;

    /* JADX INFO: renamed from: V0 */
    public final boolean f6875V0;

    /* JADX INFO: renamed from: W0 */
    public a f6876W0;

    /* JADX INFO: renamed from: X0 */
    public boolean f6877X0;

    /* JADX INFO: renamed from: Y0 */
    public boolean f6878Y0;

    /* JADX INFO: renamed from: Z0 */
    @Nullable
    public Surface f6879Z0;

    /* JADX INFO: renamed from: a1 */
    @Nullable
    public DummySurface f6880a1;

    /* JADX INFO: renamed from: b1 */
    public boolean f6881b1;

    /* JADX INFO: renamed from: c1 */
    public int f6882c1;

    /* JADX INFO: renamed from: d1 */
    public boolean f6883d1;

    /* JADX INFO: renamed from: e1 */
    public boolean f6884e1;

    /* JADX INFO: renamed from: f1 */
    public boolean f6885f1;

    /* JADX INFO: renamed from: g1 */
    public long f6886g1;

    /* JADX INFO: renamed from: h1 */
    public long f6887h1;

    /* JADX INFO: renamed from: i1 */
    public long f6888i1;

    /* JADX INFO: renamed from: j1 */
    public int f6889j1;

    /* JADX INFO: renamed from: k1 */
    public int f6890k1;

    /* JADX INFO: renamed from: l1 */
    public int f6891l1;

    /* JADX INFO: renamed from: m1 */
    public long f6892m1;

    /* JADX INFO: renamed from: n1 */
    public long f6893n1;

    /* JADX INFO: renamed from: o1 */
    public long f6894o1;

    /* JADX INFO: renamed from: p1 */
    public int f6895p1;

    /* JADX INFO: renamed from: q1 */
    public int f6896q1;

    /* JADX INFO: renamed from: r1 */
    public int f6897r1;

    /* JADX INFO: renamed from: s1 */
    public int f6898s1;

    /* JADX INFO: renamed from: t1 */
    public float f6899t1;

    /* JADX INFO: renamed from: u1 */
    @Nullable
    public C2788y f6900u1;

    /* JADX INFO: renamed from: v1 */
    public boolean f6901v1;

    /* JADX INFO: renamed from: w1 */
    public int f6902w1;

    /* JADX INFO: renamed from: x1 */
    @Nullable
    public b f6903x1;

    /* JADX INFO: renamed from: y1 */
    @Nullable
    public InterfaceC2784u f6904y1;

    /* JADX INFO: renamed from: b.i.a.c.g3.r$a */
    /* JADX INFO: compiled from: MediaCodecVideoRenderer.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final int f6905a;

        /* JADX INFO: renamed from: b */
        public final int f6906b;

        /* JADX INFO: renamed from: c */
        public final int f6907c;

        public a(int i, int i2, int i3) {
            this.f6905a = i;
            this.f6906b = i2;
            this.f6907c = i3;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.g3.r$b */
    /* JADX INFO: compiled from: MediaCodecVideoRenderer.java */
    @RequiresApi(23)
    public final class b implements InterfaceC3148t.c, Handler.Callback {

        /* JADX INFO: renamed from: j */
        public final Handler f6908j;

        public b(InterfaceC3148t interfaceC3148t) {
            int i = C2738e0.f6708a;
            Looper looperMyLooper = Looper.myLooper();
            C1460d.m438H(looperMyLooper);
            Handler handler = new Handler(looperMyLooper, this);
            this.f6908j = handler;
            interfaceC3148t.mo3839f(this, handler);
        }

        /* JADX INFO: renamed from: a */
        public final void m3175a(long j) {
            C2781r c2781r = C2781r.this;
            if (this != c2781r.f6903x1) {
                return;
            }
            if (j == RecyclerView.FOREVER_NS) {
                c2781r.f19873H0 = true;
                return;
            }
            try {
                c2781r.m3149N0(j);
            } catch (ExoPlaybackException e) {
                C2781r.this.f19875I0 = e;
            }
        }

        /* JADX INFO: renamed from: b */
        public void m3176b(InterfaceC3148t interfaceC3148t, long j, long j2) {
            if (C2738e0.f6708a >= 30) {
                m3175a(j);
            } else {
                this.f6908j.sendMessageAtFrontOfQueue(Message.obtain(this.f6908j, 0, (int) (j >> 32), (int) j));
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            m3175a((C2738e0.m2991L(message.arg1) << 32) | C2738e0.m2991L(message.arg2));
            return true;
        }
    }

    public C2781r(Context context, InterfaceC3148t.b bVar, InterfaceC3150v interfaceC3150v, long j, boolean z2, @Nullable Handler handler, @Nullable InterfaceC2787x interfaceC2787x, int i) {
        super(2, bVar, interfaceC3150v, z2, 30.0f);
        this.f6873T0 = j;
        this.f6874U0 = i;
        Context applicationContext = context.getApplicationContext();
        this.f6870Q0 = applicationContext;
        this.f6871R0 = new C2785v(applicationContext);
        this.f6872S0 = new InterfaceC2787x.a(handler, interfaceC2787x);
        this.f6875V0 = "NVIDIA".equals(C2738e0.f6710c);
        this.f6887h1 = -9223372036854775807L;
        this.f6896q1 = -1;
        this.f6897r1 = -1;
        this.f6899t1 = -1.0f;
        this.f6882c1 = 1;
        this.f6902w1 = 0;
        this.f6900u1 = null;
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
    /* JADX INFO: renamed from: E0 */
    public static boolean m3132E0() {
        /*
            Method dump skipped, instruction units count: 3048
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p007b.p225i.p226a.p242c.p260g3.C2781r.m3132E0():boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:43:0x0080  */
    /* JADX WARN: Code duplicated, block: B:65:0x00cc  */
    /* JADX INFO: renamed from: F0 */
    public static int m3133F0(C3149u c3149u, C2811j1 c2811j1) {
        byte b2;
        int iM2998f;
        int iIntValue;
        int i = c2811j1.f7128B;
        int i2 = c2811j1.f7129C;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        String str = c2811j1.f7155w;
        if ("video/dolby-vision".equals(str)) {
            Pair<Integer, Integer> pairM8864c = MediaCodecUtil.m8864c(c2811j1);
            str = (pairM8864c == null || !((iIntValue = ((Integer) pairM8864c.first).intValue()) == 512 || iIntValue == 1 || iIntValue == 2)) ? "video/hevc" : "video/avc";
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
            iM2998f = i * i2;
            i3 = 2;
        } else {
            if (b2 != 1) {
                if (b2 == 2) {
                    iM2998f = i * i2;
                } else if (b2 != 3) {
                    if (b2 != 4) {
                        if (b2 != 5) {
                            return -1;
                        }
                    }
                    iM2998f = i * i2;
                } else {
                    String str2 = C2738e0.f6711d;
                    if ("BRAVIA 4K 2015".equals(str2) || ("Amazon".equals(C2738e0.f6710c) && ("KFSOWI".equals(str2) || ("AFTS".equals(str2) && c3149u.f9117f)))) {
                        return -1;
                    }
                    iM2998f = C2738e0.m2998f(i2, 16) * C2738e0.m2998f(i, 16) * 16 * 16;
                }
                i3 = 2;
            }
            iM2998f = i * i2;
        }
        return (iM2998f * 3) / (i3 * 2);
    }

    /* JADX INFO: renamed from: G0 */
    public static List<C3149u> m3134G0(InterfaceC3150v interfaceC3150v, C2811j1 c2811j1, boolean z2, boolean z3) throws MediaCodecUtil.DecoderQueryException {
        Pair<Integer, Integer> pairM8864c;
        String str = c2811j1.f7155w;
        if (str == null) {
            return Collections.emptyList();
        }
        List<C3149u> listMo3831a = interfaceC3150v.mo3831a(str, z2, z3);
        Pattern pattern = MediaCodecUtil.f19928a;
        ArrayList arrayList = new ArrayList(listMo3831a);
        MediaCodecUtil.m8871j(arrayList, new C3135g(c2811j1));
        if ("video/dolby-vision".equals(str) && (pairM8864c = MediaCodecUtil.m8864c(c2811j1)) != null) {
            int iIntValue = ((Integer) pairM8864c.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                arrayList.addAll(interfaceC3150v.mo3831a("video/hevc", z2, z3));
            } else if (iIntValue == 512) {
                arrayList.addAll(interfaceC3150v.mo3831a("video/avc", z2, z3));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: renamed from: H0 */
    public static int m3135H0(C3149u c3149u, C2811j1 c2811j1) {
        if (c2811j1.f7156x == -1) {
            return m3133F0(c3149u, c2811j1);
        }
        int size = c2811j1.f7157y.size();
        int length = 0;
        for (int i = 0; i < size; i++) {
            length += c2811j1.f7157y.get(i).length;
        }
        return c2811j1.f7156x + length;
    }

    /* JADX INFO: renamed from: I0 */
    public static boolean m3136I0(long j) {
        return j < -30000;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, p007b.p225i.p226a.p242c.AbstractC2951v0
    /* JADX INFO: renamed from: B */
    public void mo2621B() {
        final InterfaceC2787x.a aVar;
        final C2957e c2957e;
        this.f6900u1 = null;
        m3138C0();
        this.f6881b1 = false;
        C2785v c2785v = this.f6871R0;
        C2785v.b bVar = c2785v.f6927b;
        if (bVar != null) {
            bVar.unregister();
            C2785v.e eVar = c2785v.f6928c;
            Objects.requireNonNull(eVar);
            eVar.f6948l.sendEmptyMessage(2);
        }
        this.f6903x1 = null;
        try {
            super.mo2621B();
            aVar = this.f6872S0;
            c2957e = this.f19877J0;
            Objects.requireNonNull(aVar);
            synchronized (c2957e) {
            }
        } finally {
            aVar = this.f6872S0;
            c2957e = this.f19877J0;
            Objects.requireNonNull(aVar);
            synchronized (c2957e) {
                Handler handler = aVar.f6952a;
                if (handler != null) {
                    handler.post(new Runnable() { // from class: b.i.a.c.g3.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            InterfaceC2787x.a aVar2 = aVar;
                            C2957e c2957e2 = c2957e;
                            Objects.requireNonNull(aVar2);
                            synchronized (c2957e2) {
                            }
                            InterfaceC2787x interfaceC2787x = aVar2.f6953b;
                            int i = C2738e0.f6708a;
                            interfaceC2787x.mo3191Z(c2957e2);
                        }
                    });
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2951v0
    /* JADX INFO: renamed from: C */
    public void mo3137C(boolean z2, boolean z3) throws ExoPlaybackException {
        this.f19877J0 = new C2957e();
        C2804h2 c2804h2 = this.f7891l;
        Objects.requireNonNull(c2804h2);
        boolean z4 = c2804h2.f7118b;
        C1460d.m426D((z4 && this.f6902w1 == 0) ? false : true);
        if (this.f6901v1 != z4) {
            this.f6901v1 = z4;
            m8855o0();
        }
        final InterfaceC2787x.a aVar = this.f6872S0;
        final C2957e c2957e = this.f19877J0;
        Handler handler = aVar.f6952a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: b.i.a.c.g3.f
                @Override // java.lang.Runnable
                public final void run() {
                    InterfaceC2787x.a aVar2 = aVar;
                    C2957e c2957e2 = c2957e;
                    InterfaceC2787x interfaceC2787x = aVar2.f6953b;
                    int i = C2738e0.f6708a;
                    interfaceC2787x.mo3188P(c2957e2);
                }
            });
        }
        C2785v c2785v = this.f6871R0;
        if (c2785v.f6927b != null) {
            C2785v.e eVar = c2785v.f6928c;
            Objects.requireNonNull(eVar);
            eVar.f6948l.sendEmptyMessage(1);
            c2785v.f6927b.mo3183a(new C2765b(c2785v));
        }
        this.f6884e1 = z3;
        this.f6885f1 = false;
    }

    /* JADX INFO: renamed from: C0 */
    public final void m3138C0() {
        InterfaceC3148t interfaceC3148t;
        this.f6883d1 = false;
        if (C2738e0.f6708a < 23 || !this.f6901v1 || (interfaceC3148t = this.f19889S) == null) {
            return;
        }
        this.f6903x1 = new b(interfaceC3148t);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, p007b.p225i.p226a.p242c.AbstractC2951v0
    /* JADX INFO: renamed from: D */
    public void mo2622D(long j, boolean z2) throws ExoPlaybackException {
        super.mo2622D(j, z2);
        m3138C0();
        this.f6871R0.m3179b();
        this.f6892m1 = -9223372036854775807L;
        this.f6886g1 = -9223372036854775807L;
        this.f6890k1 = 0;
        if (z2) {
            m3153R0();
        } else {
            this.f6887h1 = -9223372036854775807L;
        }
    }

    /* JADX INFO: renamed from: D0 */
    public boolean m3139D0(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (C2781r.class) {
            if (!f6868O0) {
                f6869P0 = m3132E0();
                f6868O0 = true;
            }
        }
        return f6869P0;
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2951v0
    @TargetApi(17)
    /* JADX INFO: renamed from: E */
    public void mo3140E() {
        try {
            try {
                m8841M();
                m8855o0();
                m8859u0(null);
                if (this.f6880a1 != null) {
                    m3150O0();
                }
            } catch (Throwable th) {
                m8859u0(null);
                throw th;
            }
        } catch (Throwable th2) {
            if (this.f6880a1 != null) {
                m3150O0();
            }
            throw th2;
        }
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2951v0
    /* JADX INFO: renamed from: F */
    public void mo3141F() {
        this.f6889j1 = 0;
        this.f6888i1 = SystemClock.elapsedRealtime();
        this.f6893n1 = SystemClock.elapsedRealtime() * 1000;
        this.f6894o1 = 0L;
        this.f6895p1 = 0;
        C2785v c2785v = this.f6871R0;
        c2785v.f6929d = true;
        c2785v.m3179b();
        c2785v.m3181d(false);
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2951v0
    /* JADX INFO: renamed from: G */
    public void mo3142G() {
        this.f6887h1 = -9223372036854775807L;
        m3143J0();
        final int i = this.f6895p1;
        if (i != 0) {
            final InterfaceC2787x.a aVar = this.f6872S0;
            final long j = this.f6894o1;
            Handler handler = aVar.f6952a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: b.i.a.c.g3.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        InterfaceC2787x.a aVar2 = aVar;
                        long j2 = j;
                        int i2 = i;
                        InterfaceC2787x interfaceC2787x = aVar2.f6953b;
                        int i3 = C2738e0.f6708a;
                        interfaceC2787x.mo3193h0(j2, i2);
                    }
                });
            }
            this.f6894o1 = 0L;
            this.f6895p1 = 0;
        }
        C2785v c2785v = this.f6871R0;
        c2785v.f6929d = false;
        c2785v.m3178a();
    }

    /* JADX INFO: renamed from: J0 */
    public final void m3143J0() {
        if (this.f6889j1 > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            final long j = jElapsedRealtime - this.f6888i1;
            final InterfaceC2787x.a aVar = this.f6872S0;
            final int i = this.f6889j1;
            Handler handler = aVar.f6952a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: b.i.a.c.g3.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        InterfaceC2787x.a aVar2 = aVar;
                        int i2 = i;
                        long j2 = j;
                        InterfaceC2787x interfaceC2787x = aVar2.f6953b;
                        int i3 = C2738e0.f6708a;
                        interfaceC2787x.mo3185F(i2, j2);
                    }
                });
            }
            this.f6889j1 = 0;
            this.f6888i1 = jElapsedRealtime;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: K */
    public C2959g mo3144K(C3149u c3149u, C2811j1 c2811j1, C2811j1 c2811j2) {
        C2959g c2959gM3865c = c3149u.m3865c(c2811j1, c2811j2);
        int i = c2959gM3865c.f7930e;
        int i2 = c2811j2.f7128B;
        a aVar = this.f6876W0;
        if (i2 > aVar.f6905a || c2811j2.f7129C > aVar.f6906b) {
            i |= 256;
        }
        if (m3135H0(c3149u, c2811j2) > this.f6876W0.f6907c) {
            i |= 64;
        }
        int i3 = i;
        return new C2959g(c3149u.f9112a, c2811j1, c2811j2, i3 != 0 ? 0 : c2959gM3865c.f7929d, i3);
    }

    /* JADX INFO: renamed from: K0 */
    public void m3145K0() {
        this.f6885f1 = true;
        if (this.f6883d1) {
            return;
        }
        this.f6883d1 = true;
        InterfaceC2787x.a aVar = this.f6872S0;
        Surface surface = this.f6879Z0;
        if (aVar.f6952a != null) {
            aVar.f6952a.post(new RunnableC2770g(aVar, surface, SystemClock.elapsedRealtime()));
        }
        this.f6881b1 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: L */
    public MediaCodecDecoderException mo3146L(Throwable th, @Nullable C3149u c3149u) {
        return new MediaCodecVideoDecoderException(th, c3149u, this.f6879Z0);
    }

    /* JADX INFO: renamed from: L0 */
    public final void m3147L0() {
        int i = this.f6896q1;
        if (i == -1 && this.f6897r1 == -1) {
            return;
        }
        C2788y c2788y = this.f6900u1;
        if (c2788y != null && c2788y.f6955k == i && c2788y.f6956l == this.f6897r1 && c2788y.f6957m == this.f6898s1 && c2788y.f6958n == this.f6899t1) {
            return;
        }
        C2788y c2788y2 = new C2788y(i, this.f6897r1, this.f6898s1, this.f6899t1);
        this.f6900u1 = c2788y2;
        InterfaceC2787x.a aVar = this.f6872S0;
        Handler handler = aVar.f6952a;
        if (handler != null) {
            handler.post(new RunnableC2773j(aVar, c2788y2));
        }
    }

    /* JADX INFO: renamed from: M0 */
    public final void m3148M0(long j, long j2, C2811j1 c2811j1) {
        InterfaceC2784u interfaceC2784u = this.f6904y1;
        if (interfaceC2784u != null) {
            interfaceC2784u.mo3177e(j, j2, c2811j1, this.f19891U);
        }
    }

    /* JADX INFO: renamed from: N0 */
    public void m3149N0(long j) throws ExoPlaybackException {
        m8839B0(j);
        m3147L0();
        this.f19877J0.f7918e++;
        m3145K0();
        super.mo3168i0(j);
        if (this.f6901v1) {
            return;
        }
        this.f6891l1--;
    }

    @RequiresApi(17)
    /* JADX INFO: renamed from: O0 */
    public final void m3150O0() {
        Surface surface = this.f6879Z0;
        DummySurface dummySurface = this.f6880a1;
        if (surface == dummySurface) {
            this.f6879Z0 = null;
        }
        dummySurface.release();
        this.f6880a1 = null;
    }

    /* JADX INFO: renamed from: P0 */
    public void m3151P0(InterfaceC3148t interfaceC3148t, int i) {
        m3147L0();
        C1460d.m515f("releaseOutputBuffer");
        interfaceC3148t.releaseOutputBuffer(i, true);
        C1460d.m508d0();
        this.f6893n1 = SystemClock.elapsedRealtime() * 1000;
        this.f19877J0.f7918e++;
        this.f6890k1 = 0;
        m3145K0();
    }

    @RequiresApi(21)
    /* JADX INFO: renamed from: Q0 */
    public void m3152Q0(InterfaceC3148t interfaceC3148t, int i, long j) {
        m3147L0();
        C1460d.m515f("releaseOutputBuffer");
        interfaceC3148t.mo3836c(i, j);
        C1460d.m508d0();
        this.f6893n1 = SystemClock.elapsedRealtime() * 1000;
        this.f19877J0.f7918e++;
        this.f6890k1 = 0;
        m3145K0();
    }

    /* JADX INFO: renamed from: R0 */
    public final void m3153R0() {
        this.f6887h1 = this.f6873T0 > 0 ? SystemClock.elapsedRealtime() + this.f6873T0 : -9223372036854775807L;
    }

    /* JADX INFO: renamed from: S0 */
    public final boolean m3154S0(C3149u c3149u) {
        return C2738e0.f6708a >= 23 && !this.f6901v1 && !m3139D0(c3149u.f9112a) && (!c3149u.f9117f || DummySurface.m8951b(this.f6870Q0));
    }

    /* JADX INFO: renamed from: T0 */
    public void m3155T0(InterfaceC3148t interfaceC3148t, int i) {
        C1460d.m515f("skipVideoBuffer");
        interfaceC3148t.releaseOutputBuffer(i, false);
        C1460d.m508d0();
        this.f19877J0.f7919f++;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: U */
    public boolean mo3156U() {
        return this.f6901v1 && C2738e0.f6708a < 23;
    }

    /* JADX INFO: renamed from: U0 */
    public void m3157U0(int i) {
        C2957e c2957e = this.f19877J0;
        c2957e.f7920g += i;
        this.f6889j1 += i;
        int i2 = this.f6890k1 + i;
        this.f6890k1 = i2;
        c2957e.f7921h = Math.max(i2, c2957e.f7921h);
        int i3 = this.f6874U0;
        if (i3 <= 0 || this.f6889j1 < i3) {
            return;
        }
        m3143J0();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: V */
    public float mo3158V(float f, C2811j1 c2811j1, C2811j1[] c2811j1Arr) {
        float fMax = -1.0f;
        for (C2811j1 c2811j2 : c2811j1Arr) {
            float f2 = c2811j2.f7130D;
            if (f2 != -1.0f) {
                fMax = Math.max(fMax, f2);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f;
    }

    /* JADX INFO: renamed from: V0 */
    public void m3159V0(long j) {
        C2957e c2957e = this.f19877J0;
        c2957e.f7923j += j;
        c2957e.f7924k++;
        this.f6894o1 += j;
        this.f6895p1++;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: W */
    public List<C3149u> mo3160W(InterfaceC3150v interfaceC3150v, C2811j1 c2811j1, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        return m3134G0(interfaceC3150v, c2811j1, z2, this.f6901v1);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @TargetApi(17)
    /* JADX INFO: renamed from: Y */
    public InterfaceC3148t.a mo3161Y(C3149u c3149u, C2811j1 c2811j1, @Nullable MediaCrypto mediaCrypto, float f) {
        a aVar;
        Point point;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        boolean z2;
        Pair<Integer, Integer> pairM8864c;
        int iM3133F0;
        C2811j1 c2811j2 = c2811j1;
        DummySurface dummySurface = this.f6880a1;
        if (dummySurface != null && dummySurface.f20283l != c3149u.f9117f) {
            m3150O0();
        }
        String str = c3149u.f9114c;
        C2811j1[] c2811j1Arr = this.f7895p;
        Objects.requireNonNull(c2811j1Arr);
        int iMax = c2811j2.f7128B;
        int iMax2 = c2811j2.f7129C;
        int iM3135H0 = m3135H0(c3149u, c2811j1);
        if (c2811j1Arr.length == 1) {
            if (iM3135H0 != -1 && (iM3133F0 = m3133F0(c3149u, c2811j1)) != -1) {
                iM3135H0 = Math.min((int) (iM3135H0 * 1.5f), iM3133F0);
            }
            aVar = new a(iMax, iMax2, iM3135H0);
        } else {
            int length = c2811j1Arr.length;
            boolean z3 = false;
            for (int i = 0; i < length; i++) {
                C2811j1 c2811j1M3277a = c2811j1Arr[i];
                if (c2811j2.f7135I != null && c2811j1M3277a.f7135I == null) {
                    C2811j1.b bVarM3275a = c2811j1M3277a.m3275a();
                    bVarM3275a.f7185w = c2811j2.f7135I;
                    c2811j1M3277a = bVarM3275a.m3277a();
                }
                if (c3149u.m3865c(c2811j2, c2811j1M3277a).f7929d != 0) {
                    int i2 = c2811j1M3277a.f7128B;
                    z3 |= i2 == -1 || c2811j1M3277a.f7129C == -1;
                    iMax = Math.max(iMax, i2);
                    iMax2 = Math.max(iMax2, c2811j1M3277a.f7129C);
                    iM3135H0 = Math.max(iM3135H0, m3135H0(c3149u, c2811j1M3277a));
                }
            }
            if (z3) {
                Log.w("MediaCodecVideoRenderer", C1643a.m853h(66, "Resolutions unknown. Codec max resolution: ", iMax, "x", iMax2));
                int i3 = c2811j2.f7129C;
                int i4 = c2811j2.f7128B;
                boolean z4 = i3 > i4;
                int i5 = z4 ? i3 : i4;
                if (z4) {
                    i3 = i4;
                }
                float f2 = i3 / i5;
                int[] iArr = f6867N0;
                int length2 = iArr.length;
                int i6 = 0;
                while (true) {
                    Point pointM3862a = null;
                    if (i6 < length2) {
                        int i7 = length2;
                        int i8 = iArr[i6];
                        int[] iArr2 = iArr;
                        int i9 = (int) (i8 * f2);
                        if (i8 > i5 && i9 > i3) {
                            int i10 = i3;
                            float f3 = f2;
                            if (C2738e0.f6708a < 21) {
                                try {
                                    int iM2998f = C2738e0.m2998f(i8, 16) * 16;
                                    int iM2998f2 = C2738e0.m2998f(i9, 16) * 16;
                                    if (iM2998f * iM2998f2 <= MediaCodecUtil.m8870i()) {
                                        int i11 = z4 ? iM2998f2 : iM2998f;
                                        if (!z4) {
                                            iM2998f = iM2998f2;
                                        }
                                        point = new Point(i11, iM2998f);
                                        break;
                                    }
                                    i6++;
                                    c2811j2 = c2811j1;
                                    length2 = i7;
                                    iArr = iArr2;
                                    i3 = i10;
                                    f2 = f3;
                                } catch (MediaCodecUtil.DecoderQueryException unused) {
                                    point = pointM3862a;
                                    break;
                                }
                            } else {
                                int i12 = z4 ? i9 : i8;
                                if (!z4) {
                                    i8 = i9;
                                }
                                MediaCodecInfo.CodecCapabilities codecCapabilities = c3149u.f9115d;
                                if (codecCapabilities != null && (videoCapabilities = codecCapabilities.getVideoCapabilities()) != null) {
                                    pointM3862a = C3149u.m3862a(videoCapabilities, i12, i8);
                                }
                                Point point2 = pointM3862a;
                                pointM3862a = point2;
                                if (!c3149u.m3869g(point2.x, point2.y, c2811j2.f7130D)) {
                                    i6++;
                                    c2811j2 = c2811j1;
                                    length2 = i7;
                                    iArr = iArr2;
                                    i3 = i10;
                                    f2 = f3;
                                }
                            }
                        }
                    }
                    point = pointM3862a;
                    break;
                }
                if (point != null) {
                    iMax = Math.max(iMax, point.x);
                    iMax2 = Math.max(iMax2, point.y);
                    C2811j1.b bVarM3275a2 = c2811j1.m3275a();
                    bVarM3275a2.f7178p = iMax;
                    bVarM3275a2.f7179q = iMax2;
                    iM3135H0 = Math.max(iM3135H0, m3133F0(c3149u, bVarM3275a2.m3277a()));
                    Log.w("MediaCodecVideoRenderer", C1643a.m853h(57, "Codec max resolution adjusted to: ", iMax, "x", iMax2));
                }
            }
            aVar = new a(iMax, iMax2, iM3135H0);
        }
        this.f6876W0 = aVar;
        boolean z5 = this.f6875V0;
        int i13 = this.f6901v1 ? this.f6902w1 : 0;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", c2811j1.f7128B);
        mediaFormat.setInteger("height", c2811j1.f7129C);
        C1460d.m491Y1(mediaFormat, c2811j1.f7157y);
        float f4 = c2811j1.f7130D;
        if (f4 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f4);
        }
        C1460d.m533j1(mediaFormat, "rotation-degrees", c2811j1.f7131E);
        C2777n c2777n = c2811j1.f7135I;
        if (c2777n != null) {
            C1460d.m533j1(mediaFormat, "color-transfer", c2777n.f6846m);
            C1460d.m533j1(mediaFormat, "color-standard", c2777n.f6844k);
            C1460d.m533j1(mediaFormat, "color-range", c2777n.f6845l);
            byte[] bArr = c2777n.f6847n;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(c2811j1.f7155w) && (pairM8864c = MediaCodecUtil.m8864c(c2811j1)) != null) {
            C1460d.m533j1(mediaFormat, "profile", ((Integer) pairM8864c.first).intValue());
        }
        mediaFormat.setInteger("max-width", aVar.f6905a);
        mediaFormat.setInteger("max-height", aVar.f6906b);
        C1460d.m533j1(mediaFormat, "max-input-size", aVar.f6907c);
        if (C2738e0.f6708a >= 23) {
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
        if (this.f6879Z0 == null) {
            if (!m3154S0(c3149u)) {
                throw new IllegalStateException();
            }
            if (this.f6880a1 == null) {
                this.f6880a1 = DummySurface.m8952c(this.f6870Q0, c3149u.f9117f);
            }
            this.f6879Z0 = this.f6880a1;
        }
        return new InterfaceC3148t.a(c3149u, mediaFormat, c2811j1, this.f6879Z0, mediaCrypto, 0, false);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @TargetApi(29)
    /* JADX INFO: renamed from: Z */
    public void mo3162Z(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.f6878Y0) {
            ByteBuffer byteBuffer = decoderInputBuffer.f19781o;
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
                    InterfaceC3148t interfaceC3148t = this.f19889S;
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("hdr10-plus-info", bArr);
                    interfaceC3148t.setParameters(bundle);
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: d */
    public boolean mo2632d() {
        DummySurface dummySurface;
        if (super.mo2632d() && (this.f6883d1 || (((dummySurface = this.f6880a1) != null && this.f6879Z0 == dummySurface) || this.f19889S == null || this.f6901v1))) {
            this.f6887h1 = -9223372036854775807L;
            return true;
        }
        if (this.f6887h1 == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.f6887h1) {
            return true;
        }
        this.f6887h1 = -9223372036854775807L;
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: d0 */
    public void mo3163d0(final Exception exc) {
        C2750q.m3039b("MediaCodecVideoRenderer", "Video codec error", exc);
        final InterfaceC2787x.a aVar = this.f6872S0;
        Handler handler = aVar.f6952a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: b.i.a.c.g3.e
                @Override // java.lang.Runnable
                public final void run() {
                    InterfaceC2787x.a aVar2 = aVar;
                    Exception exc2 = exc;
                    InterfaceC2787x interfaceC2787x = aVar2.f6953b;
                    int i = C2738e0.f6708a;
                    interfaceC2787x.mo3190V(exc2);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: e0 */
    public void mo3164e0(final String str, final long j, final long j2) {
        final InterfaceC2787x.a aVar = this.f6872S0;
        Handler handler = aVar.f6952a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: b.i.a.c.g3.i
                @Override // java.lang.Runnable
                public final void run() {
                    InterfaceC2787x.a aVar2 = aVar;
                    String str2 = str;
                    long j3 = j;
                    long j4 = j2;
                    InterfaceC2787x interfaceC2787x = aVar2.f6953b;
                    int i = C2738e0.f6708a;
                    interfaceC2787x.mo3195n(str2, j3, j4);
                }
            });
        }
        this.f6877X0 = m3139D0(str);
        C3149u c3149u = this.f19896Z;
        Objects.requireNonNull(c3149u);
        boolean z2 = false;
        if (C2738e0.f6708a >= 29 && "video/x-vnd.on2.vp9".equals(c3149u.f9113b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : c3149u.m3866d()) {
                if (codecProfileLevel.profile == 16384) {
                    z2 = true;
                    break;
                }
            }
        }
        this.f6878Y0 = z2;
        if (C2738e0.f6708a < 23 || !this.f6901v1) {
            return;
        }
        InterfaceC3148t interfaceC3148t = this.f19889S;
        Objects.requireNonNull(interfaceC3148t);
        this.f6903x1 = new b(interfaceC3148t);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: f0 */
    public void mo3165f0(final String str) {
        final InterfaceC2787x.a aVar = this.f6872S0;
        Handler handler = aVar.f6952a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: b.i.a.c.g3.d
                @Override // java.lang.Runnable
                public final void run() {
                    InterfaceC2787x.a aVar2 = aVar;
                    String str2 = str;
                    InterfaceC2787x interfaceC2787x = aVar2.f6953b;
                    int i = C2738e0.f6708a;
                    interfaceC2787x.mo3194l(str2);
                }
            });
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @Nullable
    /* JADX INFO: renamed from: g0 */
    public C2959g mo3166g0(C2815k1 c2815k1) throws ExoPlaybackException {
        final C2959g c2959gMo3166g0 = super.mo3166g0(c2815k1);
        final InterfaceC2787x.a aVar = this.f6872S0;
        final C2811j1 c2811j1 = c2815k1.f7196b;
        Handler handler = aVar.f6952a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: b.i.a.c.g3.k
                @Override // java.lang.Runnable
                public final void run() {
                    InterfaceC2787x.a aVar2 = aVar;
                    C2811j1 c2811j2 = c2811j1;
                    C2959g c2959g = c2959gMo3166g0;
                    InterfaceC2787x interfaceC2787x = aVar2.f6953b;
                    int i = C2738e0.f6708a;
                    interfaceC2787x.mo3187O(c2811j2);
                    aVar2.f6953b.mo3189Q(c2811j2, c2959g);
                }
            });
        }
        return c2959gMo3166g0;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2, p007b.p225i.p226a.p242c.InterfaceC2763g2
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: h0 */
    public void mo3167h0(C2811j1 c2811j1, @Nullable MediaFormat mediaFormat) {
        InterfaceC3148t interfaceC3148t = this.f19889S;
        if (interfaceC3148t != null) {
            interfaceC3148t.mo3840g(this.f6882c1);
        }
        if (this.f6901v1) {
            this.f6896q1 = c2811j1.f7128B;
            this.f6897r1 = c2811j1.f7129C;
        } else {
            Objects.requireNonNull(mediaFormat);
            boolean z2 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            this.f6896q1 = z2 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            this.f6897r1 = z2 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        }
        float f = c2811j1.f7132F;
        this.f6899t1 = f;
        if (C2738e0.f6708a >= 21) {
            int i = c2811j1.f7131E;
            if (i == 90 || i == 270) {
                int i2 = this.f6896q1;
                this.f6896q1 = this.f6897r1;
                this.f6897r1 = i2;
                this.f6899t1 = 1.0f / f;
            }
        } else {
            this.f6898s1 = c2811j1.f7131E;
        }
        C2785v c2785v = this.f6871R0;
        c2785v.f6931f = c2811j1.f7130D;
        C2779p c2779p = c2785v.f6926a;
        c2779p.f6850a.m3130c();
        c2779p.f6851b.m3130c();
        c2779p.f6852c = false;
        c2779p.f6853d = -9223372036854775807L;
        c2779p.f6854e = 0;
        c2785v.m3180c();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    /* JADX INFO: renamed from: i0 */
    public void mo3168i0(long j) {
        super.mo3168i0(j);
        if (this.f6901v1) {
            return;
        }
        this.f6891l1--;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: j0 */
    public void mo3169j0() {
        m3138C0();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    /* JADX INFO: renamed from: k0 */
    public void mo3170k0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        boolean z2 = this.f6901v1;
        if (!z2) {
            this.f6891l1++;
        }
        if (C2738e0.f6708a >= 23 || !z2) {
            return;
        }
        m3149N0(decoderInputBuffer.f19780n);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0077  */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: m0 */
    public boolean mo3171m0(long j, long j2, @Nullable InterfaceC3148t interfaceC3148t, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z2, boolean z3, C2811j1 c2811j1) throws ExoPlaybackException {
        boolean z4;
        long j4;
        boolean z5;
        boolean z6;
        long j5;
        long j6;
        Objects.requireNonNull(interfaceC3148t);
        if (this.f6886g1 == -9223372036854775807L) {
            this.f6886g1 = j;
        }
        if (j3 != this.f6892m1) {
            C2785v c2785v = this.f6871R0;
            long j7 = c2785v.f6939n;
            if (j7 != -1) {
                c2785v.f6941p = j7;
                c2785v.f6942q = c2785v.f6940o;
            }
            c2785v.f6938m++;
            C2779p c2779p = c2785v.f6926a;
            long j8 = j3 * 1000;
            c2779p.f6850a.m3129b(j8);
            if (c2779p.f6850a.m3128a()) {
                c2779p.f6852c = false;
            } else if (c2779p.f6853d != -9223372036854775807L) {
                if (c2779p.f6852c) {
                    C2779p.a aVar = c2779p.f6851b;
                    long j9 = aVar.f6858d;
                    if (j9 == 0 ? false : aVar.f6861g[(int) ((j9 - 1) % 15)]) {
                        c2779p.f6851b.m3130c();
                        c2779p.f6851b.m3129b(c2779p.f6853d);
                    }
                } else {
                    c2779p.f6851b.m3130c();
                    c2779p.f6851b.m3129b(c2779p.f6853d);
                }
                c2779p.f6852c = true;
                c2779p.f6851b.m3129b(j8);
            }
            if (c2779p.f6852c && c2779p.f6851b.m3128a()) {
                C2779p.a aVar2 = c2779p.f6850a;
                c2779p.f6850a = c2779p.f6851b;
                c2779p.f6851b = aVar2;
                c2779p.f6852c = false;
            }
            c2779p.f6853d = j8;
            c2779p.f6854e = c2779p.f6850a.m3128a() ? 0 : c2779p.f6854e + 1;
            c2785v.m3180c();
            this.f6892m1 = j3;
        }
        long j10 = this.f19881L0;
        long j11 = j3 - j10;
        if (z2 && !z3) {
            m3155T0(interfaceC3148t, i);
            return true;
        }
        double d = this.f19887Q;
        boolean z7 = this.f7893n == 2;
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long j12 = (long) ((j3 - j) / d);
        if (z7) {
            j12 -= jElapsedRealtime - j2;
        }
        if (this.f6879Z0 == this.f6880a1) {
            if (!m3136I0(j12)) {
                return false;
            }
            m3155T0(interfaceC3148t, i);
            m3159V0(j12);
            return true;
        }
        long j13 = jElapsedRealtime - this.f6893n1;
        boolean z8 = this.f6885f1 ? !this.f6883d1 : z7 || this.f6884e1;
        if (this.f6887h1 != -9223372036854775807L || j < j10) {
            z4 = false;
        } else {
            if (!z8) {
                if (z7) {
                    if (m3136I0(j12) && j13 > 100000) {
                    }
                }
                z4 = false;
            }
            z4 = true;
        }
        if (z4) {
            long jNanoTime = System.nanoTime();
            m3148M0(j11, jNanoTime, c2811j1);
            if (C2738e0.f6708a >= 21) {
                m3152Q0(interfaceC3148t, i, jNanoTime);
            } else {
                m3151P0(interfaceC3148t, i);
            }
            m3159V0(j12);
            return true;
        }
        if (!z7 || j == this.f6886g1) {
            return false;
        }
        long jNanoTime2 = System.nanoTime();
        long j14 = (j12 * 1000) + jNanoTime2;
        C2785v c2785v2 = this.f6871R0;
        if (c2785v2.f6941p == -1 || !c2785v2.f6926a.m3127a()) {
            j4 = j11;
        } else {
            C2779p c2779p2 = c2785v2.f6926a;
            if (c2779p2.m3127a()) {
                C2779p.a aVar3 = c2779p2.f6850a;
                long j15 = aVar3.f6859e;
                if (j15 == 0) {
                    j6 = 0;
                    j4 = j11;
                } else {
                    j4 = j11;
                    j6 = aVar3.f6860f / j15;
                }
            } else {
                j4 = j11;
                j6 = -9223372036854775807L;
            }
            long j16 = c2785v2.f6942q + ((long) (((c2785v2.f6938m - c2785v2.f6941p) * j6) / c2785v2.f6934i));
            if (Math.abs(j14 - j16) <= 20000000) {
                j14 = j16;
            } else {
                c2785v2.m3179b();
            }
        }
        c2785v2.f6939n = c2785v2.f6938m;
        c2785v2.f6940o = j14;
        C2785v.e eVar = c2785v2.f6928c;
        if (eVar != null && c2785v2.f6936k != -9223372036854775807L) {
            long j17 = eVar.f6947k;
            if (j17 != -9223372036854775807L) {
                long j18 = c2785v2.f6936k;
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
                j14 = j19 - c2785v2.f6937l;
            }
        }
        long j20 = (j14 - jNanoTime2) / 1000;
        boolean z9 = this.f6887h1 != -9223372036854775807L;
        if (((j20 > (-500000L) ? 1 : (j20 == (-500000L) ? 0 : -1)) < 0) && !z3) {
            InterfaceC2546i0 interfaceC2546i0 = this.f7894o;
            Objects.requireNonNull(interfaceC2546i0);
            int iMo2507c = interfaceC2546i0.mo2507c(j - this.f7896q);
            if (iMo2507c == 0) {
                z6 = false;
            } else {
                C2957e c2957e = this.f19877J0;
                c2957e.f7922i++;
                int i4 = this.f6891l1 + iMo2507c;
                if (z9) {
                    c2957e.f7919f += i4;
                } else {
                    m3157U0(i4);
                }
                if (m8847S()) {
                    m8851b0();
                }
                z6 = true;
            }
            if (z6) {
                return false;
            }
        }
        if (m3136I0(j20) && !z3) {
            if (z9) {
                m3155T0(interfaceC3148t, i);
                z5 = true;
            } else {
                C1460d.m515f("dropVideoBuffer");
                interfaceC3148t.releaseOutputBuffer(i, false);
                C1460d.m508d0();
                z5 = true;
                m3157U0(1);
            }
            m3159V0(j20);
            return z5;
        }
        if (C2738e0.f6708a >= 21) {
            if (j20 >= 50000) {
                return false;
            }
            m3148M0(j4, j14, c2811j1);
            m3152Q0(interfaceC3148t, i, j14);
            m3159V0(j20);
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
        m3148M0(j4, j14, c2811j1);
        m3151P0(interfaceC3148t, i);
        m3159V0(j20);
        return true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, p007b.p225i.p226a.p242c.AbstractC2951v0, p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: n */
    public void mo2939n(float f, float f2) throws ExoPlaybackException {
        this.f19887Q = f;
        this.f19888R = f2;
        m8861z0(this.f19890T);
        C2785v c2785v = this.f6871R0;
        c2785v.f6934i = f;
        c2785v.m3179b();
        c2785v.m3181d(false);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    @CallSuper
    /* JADX INFO: renamed from: q0 */
    public void mo3172q0() {
        super.mo3172q0();
        this.f6891l1 = 0;
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
    @Override // p007b.p225i.p226a.p242c.AbstractC2951v0, p007b.p225i.p226a.p242c.C2576b2.b
    /* JADX INFO: renamed from: r */
    public void mo2603r(int i, @Nullable Object obj) throws ExoPlaybackException {
        ?? M8952c;
        InterfaceC2787x.a aVar;
        Handler handler;
        InterfaceC2787x.a aVar2;
        Handler handler2;
        Surface surface;
        if (i != 1) {
            if (i == 7) {
                this.f6904y1 = (InterfaceC2784u) obj;
                return;
            }
            if (i == 10) {
                int iIntValue = ((Integer) obj).intValue();
                if (this.f6902w1 != iIntValue) {
                    this.f6902w1 = iIntValue;
                    if (this.f6901v1) {
                        m8855o0();
                        return;
                    }
                    return;
                }
                return;
            }
            if (i == 4) {
                int iIntValue2 = ((Integer) obj).intValue();
                this.f6882c1 = iIntValue2;
                InterfaceC3148t interfaceC3148t = this.f19889S;
                if (interfaceC3148t != null) {
                    interfaceC3148t.mo3840g(iIntValue2);
                    return;
                }
                return;
            }
            if (i != 5) {
                return;
            }
            C2785v c2785v = this.f6871R0;
            int iIntValue3 = ((Integer) obj).intValue();
            if (c2785v.f6935j == iIntValue3) {
                return;
            }
            c2785v.f6935j = iIntValue3;
            c2785v.m3181d(true);
            return;
        }
        if (obj instanceof Surface) {
            surface = (Surface) obj;
        } else {
            M8952c = 0;
        }
        if (M8952c == 0) {
            DummySurface dummySurface = this.f6880a1;
            if (dummySurface != null) {
                M8952c = surface;
                M8952c = dummySurface;
            } else {
                C3149u c3149u = this.f19896Z;
                if (c3149u != null && m3154S0(c3149u)) {
                    M8952c = surface;
                    M8952c = DummySurface.m8952c(this.f6870Q0, c3149u.f9117f);
                    this.f6880a1 = M8952c;
                }
            }
        }
        M8952c = surface;
        M8952c = surface;
        M8952c = surface;
        if (this.f6879Z0 == M8952c) {
            if (M8952c == 0 || M8952c == this.f6880a1) {
                return;
            }
            C2788y c2788y = this.f6900u1;
            if (c2788y != null && (handler = (aVar = this.f6872S0).f6952a) != null) {
                handler.post(new RunnableC2773j(aVar, c2788y));
            }
            if (this.f6881b1) {
                InterfaceC2787x.a aVar3 = this.f6872S0;
                Surface surface2 = this.f6879Z0;
                if (aVar3.f6952a != null) {
                    aVar3.f6952a.post(new RunnableC2770g(aVar3, surface2, SystemClock.elapsedRealtime()));
                    return;
                }
                return;
            }
            return;
        }
        this.f6879Z0 = M8952c;
        C2785v c2785v2 = this.f6871R0;
        Objects.requireNonNull(c2785v2);
        ?? r2 = M8952c instanceof DummySurface ? 0 : M8952c;
        if (c2785v2.f6930e != r2) {
            c2785v2.m3178a();
            c2785v2.f6930e = r2;
            c2785v2.m3181d(true);
        }
        this.f6881b1 = false;
        int i2 = this.f7893n;
        ?? r0 = this.f19889S;
        if (r0 != 0) {
            if (C2738e0.f6708a < 23 || M8952c == 0 || this.f6877X0) {
                m8855o0();
                m8851b0();
            } else {
                r0.mo3842i(M8952c);
            }
        }
        if (M8952c == 0 || M8952c == this.f6880a1) {
            this.f6900u1 = null;
            m3138C0();
            return;
        }
        C2788y c2788y2 = this.f6900u1;
        if (c2788y2 != null && (handler2 = (aVar2 = this.f6872S0).f6952a) != null) {
            handler2.post(new RunnableC2773j(aVar2, c2788y2));
        }
        m3138C0();
        if (i2 == 2) {
            m3153R0();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: w0 */
    public boolean mo3173w0(C3149u c3149u) {
        return this.f6879Z0 != null || m3154S0(c3149u);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    /* JADX INFO: renamed from: y0 */
    public int mo3174y0(InterfaceC3150v interfaceC3150v, C2811j1 c2811j1) throws MediaCodecUtil.DecoderQueryException {
        int i = 0;
        if (!C2753t.m3052j(c2811j1.f7155w)) {
            return 0;
        }
        boolean z2 = c2811j1.f7158z != null;
        List<C3149u> listM3134G0 = m3134G0(interfaceC3150v, c2811j1, z2, false);
        if (z2 && listM3134G0.isEmpty()) {
            listM3134G0 = m3134G0(interfaceC3150v, c2811j1, false, false);
        }
        if (listM3134G0.isEmpty()) {
            return 1;
        }
        int i2 = c2811j1.f7142P;
        if (!(i2 == 0 || i2 == 2)) {
            return 2;
        }
        C3149u c3149u = listM3134G0.get(0);
        boolean zM3867e = c3149u.m3867e(c2811j1);
        int i3 = c3149u.m3868f(c2811j1) ? 16 : 8;
        if (zM3867e) {
            List<C3149u> listM3134G1 = m3134G0(interfaceC3150v, c2811j1, z2, true);
            if (!listM3134G1.isEmpty()) {
                C3149u c3149u2 = listM3134G1.get(0);
                if (c3149u2.m3867e(c2811j1) && c3149u2.m3868f(c2811j1)) {
                    i = 32;
                }
            }
        }
        return (zM3867e ? 4 : 3) | i3 | i;
    }
}
