package p007b.p225i.p226a.p242c;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import androidx.core.view.PointerIconCompat;
import com.discord.utilities.rest.SendUtils;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoTimeoutException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;
import org.webrtc.MediaStreamTrack;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2576b2;
import p007b.p225i.p226a.p242c.C2824m2;
import p007b.p225i.p226a.p242c.C2835p1;
import p007b.p225i.p226a.p242c.C2846s0;
import p007b.p225i.p226a.p242c.C2909t0;
import p007b.p225i.p226a.p242c.InterfaceC2677e1;
import p007b.p225i.p226a.p242c.InterfaceC3128y1;
import p007b.p225i.p226a.p242c.p243a3.C2558o0;
import p007b.p225i.p226a.p242c.p245b3.C2578b;
import p007b.p225i.p226a.p242c.p245b3.InterfaceC2588l;
import p007b.p225i.p226a.p242c.p255c3.C2648n;
import p007b.p225i.p226a.p242c.p259f3.C2732b0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2743j;
import p007b.p225i.p226a.p242c.p259f3.C2747n;
import p007b.p225i.p226a.p242c.p259f3.C2749p;
import p007b.p225i.p226a.p242c.p259f3.C2750q;
import p007b.p225i.p226a.p242c.p260g3.C2786w;
import p007b.p225i.p226a.p242c.p260g3.C2788y;
import p007b.p225i.p226a.p242c.p260g3.InterfaceC2783t;
import p007b.p225i.p226a.p242c.p260g3.InterfaceC2784u;
import p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x;
import p007b.p225i.p226a.p242c.p260g3.p261z.C2799k;
import p007b.p225i.p226a.p242c.p260g3.p261z.InterfaceC2792d;
import p007b.p225i.p226a.p242c.p262s2.C2868g1;
import p007b.p225i.p226a.p242c.p262s2.InterfaceC2871h1;
import p007b.p225i.p226a.p242c.p263t2.C2931o;
import p007b.p225i.p226a.p242c.p263t2.C2933q;
import p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r;
import p007b.p225i.p226a.p242c.p265v2.C2957e;
import p007b.p225i.p226a.p242c.p265v2.C2959g;
import p007b.p225i.p226a.p242c.p279z2.InterfaceC3159e;

/* JADX INFO: renamed from: b.i.a.c.k2 */
/* JADX INFO: compiled from: SimpleExoPlayer.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class C2816k2 extends AbstractC2944u0 implements InterfaceC2677e1 {

    /* JADX INFO: renamed from: A */
    public C2931o f7197A;

    /* JADX INFO: renamed from: B */
    public float f7198B;

    /* JADX INFO: renamed from: C */
    public boolean f7199C;

    /* JADX INFO: renamed from: D */
    public List<C2578b> f7200D;

    /* JADX INFO: renamed from: E */
    public boolean f7201E;

    /* JADX INFO: renamed from: F */
    public boolean f7202F;

    /* JADX INFO: renamed from: G */
    public boolean f7203G;

    /* JADX INFO: renamed from: H */
    public C2633c1 f7204H;

    /* JADX INFO: renamed from: I */
    public C2788y f7205I;

    /* JADX INFO: renamed from: b */
    public final InterfaceC2728f2[] f7206b;

    /* JADX INFO: renamed from: c */
    public final C2743j f7207c = new C2743j();

    /* JADX INFO: renamed from: d */
    public final Context f7208d;

    /* JADX INFO: renamed from: e */
    public final C2727f1 f7209e;

    /* JADX INFO: renamed from: f */
    public final b f7210f;

    /* JADX INFO: renamed from: g */
    public final c f7211g;

    /* JADX INFO: renamed from: h */
    public final CopyOnWriteArraySet<InterfaceC3128y1.e> f7212h;

    /* JADX INFO: renamed from: i */
    public final C2868g1 f7213i;

    /* JADX INFO: renamed from: j */
    public final C2846s0 f7214j;

    /* JADX INFO: renamed from: k */
    public final C2909t0 f7215k;

    /* JADX INFO: renamed from: l */
    public final C2824m2 f7216l;

    /* JADX INFO: renamed from: m */
    public final C2840q2 f7217m;

    /* JADX INFO: renamed from: n */
    public final C2844r2 f7218n;

    /* JADX INFO: renamed from: o */
    public final long f7219o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public AudioTrack f7220p;

    /* JADX INFO: renamed from: q */
    @Nullable
    public Object f7221q;

    /* JADX INFO: renamed from: r */
    @Nullable
    public Surface f7222r;

    /* JADX INFO: renamed from: s */
    @Nullable
    public SurfaceHolder f7223s;

    /* JADX INFO: renamed from: t */
    @Nullable
    public C2799k f7224t;

    /* JADX INFO: renamed from: u */
    public boolean f7225u;

    /* JADX INFO: renamed from: v */
    @Nullable
    public TextureView f7226v;

    /* JADX INFO: renamed from: w */
    public int f7227w;

    /* JADX INFO: renamed from: x */
    public int f7228x;

    /* JADX INFO: renamed from: y */
    public int f7229y;

    /* JADX INFO: renamed from: z */
    public int f7230z;

    /* JADX INFO: renamed from: b.i.a.c.k2$b */
    /* JADX INFO: compiled from: SimpleExoPlayer.java */
    public final class b implements InterfaceC2787x, InterfaceC2934r, InterfaceC2588l, InterfaceC3159e, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, C2799k.b, C2909t0.b, C2846s0.b, C2824m2.b, InterfaceC3128y1.c, InterfaceC2677e1.a {
        public b(a aVar) {
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: A */
        public /* synthetic */ void mo235A(C2835p1 c2835p1) {
            C3154z1.m3878f(this, c2835p1);
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r
        /* JADX INFO: renamed from: B */
        public void mo3291B(String str) {
            C2816k2.this.f7213i.mo3291B(str);
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r
        /* JADX INFO: renamed from: C */
        public void mo3292C(String str, long j, long j2) {
            C2816k2.this.f7213i.mo3292C(str, j, j2);
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: D */
        public /* synthetic */ void mo236D(boolean z2) {
            C3154z1.m3888p(this, z2);
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: E */
        public /* synthetic */ void mo237E(InterfaceC3128y1 interfaceC3128y1, InterfaceC3128y1.d dVar) {
            C3154z1.m3874b(this, interfaceC3128y1, dVar);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x
        /* JADX INFO: renamed from: F */
        public void mo3185F(int i, long j) {
            C2816k2.this.f7213i.mo3185F(i, j);
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: H */
        public /* synthetic */ void mo239H(boolean z2, int i) {
            C3154z1.m3883k(this, z2, i);
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r
        /* JADX INFO: renamed from: I */
        public void mo3293I(C2811j1 c2811j1, @Nullable C2959g c2959g) {
            Objects.requireNonNull(C2816k2.this);
            C2816k2.this.f7213i.mo3293I(c2811j1, c2959g);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x
        /* JADX INFO: renamed from: K */
        public void mo3186K(Object obj, long j) {
            C2816k2.this.f7213i.mo3186K(obj, j);
            C2816k2 c2816k2 = C2816k2.this;
            if (c2816k2.f7221q == obj) {
                Iterator<InterfaceC3128y1.e> it = c2816k2.f7212h.iterator();
                while (it.hasNext()) {
                    it.next().mo248c();
                }
            }
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: L */
        public /* synthetic */ void mo240L(int i) {
            C3154z1.m3886n(this, i);
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: M */
        public /* synthetic */ void mo241M(C2831o1 c2831o1, int i) {
            C3154z1.m3877e(this, c2831o1, i);
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r
        /* JADX INFO: renamed from: N */
        public void mo3294N(Exception exc) {
            C2816k2.this.f7213i.mo3294N(exc);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x
        /* JADX INFO: renamed from: O */
        public /* synthetic */ void mo3187O(C2811j1 c2811j1) {
            C2786w.m3184a(this, c2811j1);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x
        /* JADX INFO: renamed from: P */
        public void mo3188P(C2957e c2957e) {
            Objects.requireNonNull(C2816k2.this);
            C2816k2.this.f7213i.mo3188P(c2957e);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x
        /* JADX INFO: renamed from: Q */
        public void mo3189Q(C2811j1 c2811j1, @Nullable C2959g c2959g) {
            Objects.requireNonNull(C2816k2.this);
            C2816k2.this.f7213i.mo3189Q(c2811j1, c2959g);
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r
        /* JADX INFO: renamed from: R */
        public void mo3295R(long j) {
            C2816k2.this.f7213i.mo3295R(j);
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r
        /* JADX INFO: renamed from: T */
        public void mo3296T(Exception exc) {
            C2816k2.this.f7213i.mo3296T(exc);
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r
        /* JADX INFO: renamed from: U */
        public /* synthetic */ void mo3297U(C2811j1 c2811j1) {
            C2933q.m3497a(this, c2811j1);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x
        /* JADX INFO: renamed from: V */
        public void mo3190V(Exception exc) {
            C2816k2.this.f7213i.mo3190V(exc);
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: W */
        public void mo242W(boolean z2, int i) {
            C2816k2.m3280d0(C2816k2.this);
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: Y */
        public /* synthetic */ void mo243Y(C2558o0 c2558o0, C2648n c2648n) {
            C3154z1.m3890r(this, c2558o0, c2648n);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x
        /* JADX INFO: renamed from: Z */
        public void mo3191Z(C2957e c2957e) {
            C2816k2.this.f7213i.mo3191Z(c2957e);
            Objects.requireNonNull(C2816k2.this);
            Objects.requireNonNull(C2816k2.this);
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: a */
        public /* synthetic */ void mo244a() {
            C3154z1.m3887o(this);
        }

        @Override // p007b.p225i.p226a.p242c.p279z2.InterfaceC3159e
        /* JADX INFO: renamed from: b */
        public void mo3298b(Metadata metadata) throws CloneNotSupportedException {
            C2816k2.this.f7213i.mo246b(metadata);
            final C2727f1 c2727f1 = C2816k2.this.f7209e;
            C2835p1.b bVarM3344a = c2727f1.f6656E.m3344a();
            int i = 0;
            while (true) {
                Metadata.Entry[] entryArr = metadata.f19936j;
                if (i >= entryArr.length) {
                    break;
                }
                entryArr[i].mo8878n(bVarM3344a);
                i++;
            }
            c2727f1.f6656E = bVarM3344a.m3345a();
            C2835p1 c2835p1M2899e0 = c2727f1.m2899e0();
            if (!c2835p1M2899e0.equals(c2727f1.f6655D)) {
                c2727f1.f6655D = c2835p1M2899e0;
                C2749p<InterfaceC3128y1.c> c2749p = c2727f1.f6667j;
                c2749p.m3035b(14, new C2749p.a() { // from class: b.i.a.c.j
                    @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                    public final void invoke(Object obj) {
                        ((InterfaceC3128y1.c) obj).mo235A(c2727f1.f6655D);
                    }
                });
                c2749p.m3034a();
            }
            Iterator<InterfaceC3128y1.e> it = C2816k2.this.f7212h.iterator();
            while (it.hasNext()) {
                it.next().mo246b(metadata);
            }
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: b0 */
        public /* synthetic */ void mo247b0(C2998x1 c2998x1) {
            C3154z1.m3879g(this, c2998x1);
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r
        /* JADX INFO: renamed from: d */
        public void mo3299d(boolean z2) {
            C2816k2 c2816k2 = C2816k2.this;
            if (c2816k2.f7199C == z2) {
                return;
            }
            c2816k2.f7199C = z2;
            c2816k2.f7213i.mo249d(z2);
            Iterator<InterfaceC3128y1.e> it = c2816k2.f7212h.iterator();
            while (it.hasNext()) {
                it.next().mo249d(c2816k2.f7199C);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2588l
        /* JADX INFO: renamed from: e */
        public void mo2620e(List<C2578b> list) {
            C2816k2 c2816k2 = C2816k2.this;
            c2816k2.f7200D = list;
            Iterator<InterfaceC3128y1.e> it = c2816k2.f7212h.iterator();
            while (it.hasNext()) {
                it.next().mo250e(list);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r
        /* JADX INFO: renamed from: e0 */
        public void mo3300e0(int i, long j, long j2) {
            C2816k2.this.f7213i.mo3300e0(i, j, j2);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x
        /* JADX INFO: renamed from: f */
        public void mo3192f(C2788y c2788y) {
            C2816k2 c2816k2 = C2816k2.this;
            c2816k2.f7205I = c2788y;
            c2816k2.f7213i.mo251f(c2788y);
            Iterator<InterfaceC3128y1.e> it = C2816k2.this.f7212h.iterator();
            while (it.hasNext()) {
                it.next().mo251f(c2788y);
            }
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: f0 */
        public /* synthetic */ void mo252f0(PlaybackException playbackException) {
            C3154z1.m3882j(this, playbackException);
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: g */
        public /* synthetic */ void mo253g(InterfaceC3128y1.f fVar, InterfaceC3128y1.f fVar2, int i) {
            C3154z1.m3885m(this, fVar, fVar2, i);
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: h */
        public /* synthetic */ void mo254h(int i) {
            C3154z1.m3880h(this, i);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x
        /* JADX INFO: renamed from: h0 */
        public void mo3193h0(long j, int i) {
            C2816k2.this.f7213i.mo3193h0(j, i);
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: i */
        public /* synthetic */ void mo255i(boolean z2) {
            C3154z1.m3876d(this, z2);
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: j */
        public /* synthetic */ void mo256j(int i) {
            C3154z1.m3884l(this, i);
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: j0 */
        public /* synthetic */ void mo257j0(boolean z2) {
            C3154z1.m3875c(this, z2);
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r
        /* JADX INFO: renamed from: k */
        public void mo3301k(C2957e c2957e) {
            C2816k2.this.f7213i.mo3301k(c2957e);
            Objects.requireNonNull(C2816k2.this);
            Objects.requireNonNull(C2816k2.this);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x
        /* JADX INFO: renamed from: l */
        public void mo3194l(String str) {
            C2816k2.this.f7213i.mo3194l(str);
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.InterfaceC2934r
        /* JADX INFO: renamed from: m */
        public void mo3302m(C2957e c2957e) {
            Objects.requireNonNull(C2816k2.this);
            C2816k2.this.f7213i.mo3302m(c2957e);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2787x
        /* JADX INFO: renamed from: n */
        public void mo3195n(String str, long j, long j2) {
            C2816k2.this.f7213i.mo3195n(str, j, j2);
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC2677e1.a
        /* JADX INFO: renamed from: o */
        public void mo2770o(boolean z2) {
            C2816k2.m3280d0(C2816k2.this);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) throws CloneNotSupportedException {
            C2816k2 c2816k2 = C2816k2.this;
            Objects.requireNonNull(c2816k2);
            Surface surface = new Surface(surfaceTexture);
            c2816k2.m3288l0(surface);
            c2816k2.f7222r = surface;
            C2816k2.this.m3284h0(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) throws CloneNotSupportedException {
            C2816k2.this.m3288l0(null);
            C2816k2.this.m3284h0(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            C2816k2.this.m3284h0(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: p */
        public /* synthetic */ void mo258p(C2836p2 c2836p2) {
            C3154z1.m3891s(this, c2836p2);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.p261z.C2799k.b
        /* JADX INFO: renamed from: q */
        public void mo3204q(Surface surface) throws CloneNotSupportedException {
            C2816k2.this.m3288l0(null);
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: r */
        public void mo259r(boolean z2) {
            Objects.requireNonNull(C2816k2.this);
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: s */
        public /* synthetic */ void mo260s(PlaybackException playbackException) {
            C3154z1.m3881i(this, playbackException);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            C2816k2.this.m3284h0(i2, i3);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) throws CloneNotSupportedException {
            C2816k2 c2816k2 = C2816k2.this;
            if (c2816k2.f7225u) {
                c2816k2.m3288l0(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) throws CloneNotSupportedException {
            C2816k2 c2816k2 = C2816k2.this;
            if (c2816k2.f7225u) {
                c2816k2.m3288l0(null);
            }
            C2816k2.this.m3284h0(0, 0);
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: t */
        public /* synthetic */ void mo261t(InterfaceC3128y1.b bVar) {
            C3154z1.m3873a(this, bVar);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.p261z.C2799k.b
        /* JADX INFO: renamed from: u */
        public void mo3205u(Surface surface) throws CloneNotSupportedException {
            C2816k2.this.m3288l0(surface);
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: v */
        public /* synthetic */ void mo262v(AbstractC2832o2 abstractC2832o2, int i) {
            C3154z1.m3889q(this, abstractC2832o2, i);
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC2677e1.a
        /* JADX INFO: renamed from: x */
        public /* synthetic */ void mo2771x(boolean z2) {
            C2655d1.m2757a(this, z2);
        }

        @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1.c
        /* JADX INFO: renamed from: y */
        public void mo264y(int i) {
            C2816k2.m3280d0(C2816k2.this);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.k2$c */
    /* JADX INFO: compiled from: SimpleExoPlayer.java */
    public static final class c implements InterfaceC2784u, InterfaceC2792d, C2576b2.b {

        /* JADX INFO: renamed from: j */
        @Nullable
        public InterfaceC2784u f7232j;

        /* JADX INFO: renamed from: k */
        @Nullable
        public InterfaceC2792d f7233k;

        /* JADX INFO: renamed from: l */
        @Nullable
        public InterfaceC2784u f7234l;

        /* JADX INFO: renamed from: m */
        @Nullable
        public InterfaceC2792d f7235m;

        public c(a aVar) {
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.p261z.InterfaceC2792d
        /* JADX INFO: renamed from: a */
        public void mo3196a(long j, float[] fArr) {
            InterfaceC2792d interfaceC2792d = this.f7235m;
            if (interfaceC2792d != null) {
                interfaceC2792d.mo3196a(j, fArr);
            }
            InterfaceC2792d interfaceC2792d2 = this.f7233k;
            if (interfaceC2792d2 != null) {
                interfaceC2792d2.mo3196a(j, fArr);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.p261z.InterfaceC2792d
        /* JADX INFO: renamed from: c */
        public void mo3197c() {
            InterfaceC2792d interfaceC2792d = this.f7235m;
            if (interfaceC2792d != null) {
                interfaceC2792d.mo3197c();
            }
            InterfaceC2792d interfaceC2792d2 = this.f7233k;
            if (interfaceC2792d2 != null) {
                interfaceC2792d2.mo3197c();
            }
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.InterfaceC2784u
        /* JADX INFO: renamed from: e */
        public void mo3177e(long j, long j2, C2811j1 c2811j1, @Nullable MediaFormat mediaFormat) {
            InterfaceC2784u interfaceC2784u = this.f7234l;
            if (interfaceC2784u != null) {
                interfaceC2784u.mo3177e(j, j2, c2811j1, mediaFormat);
            }
            InterfaceC2784u interfaceC2784u2 = this.f7232j;
            if (interfaceC2784u2 != null) {
                interfaceC2784u2.mo3177e(j, j2, c2811j1, mediaFormat);
            }
        }

        @Override // p007b.p225i.p226a.p242c.C2576b2.b
        /* JADX INFO: renamed from: r */
        public void mo2603r(int i, @Nullable Object obj) {
            if (i == 7) {
                this.f7232j = (InterfaceC2784u) obj;
                return;
            }
            if (i == 8) {
                this.f7233k = (InterfaceC2792d) obj;
                return;
            }
            if (i != 10000) {
                return;
            }
            C2799k c2799k = (C2799k) obj;
            if (c2799k == null) {
                this.f7234l = null;
                this.f7235m = null;
            } else {
                this.f7234l = c2799k.getVideoFrameMetadataListener();
                this.f7235m = c2799k.getCameraMotionListener();
            }
        }
    }

    public C2816k2(InterfaceC2677e1.b bVar) throws Throwable {
        C2816k2 c2816k2;
        try {
            Context applicationContext = bVar.f6412a.getApplicationContext();
            this.f7208d = applicationContext;
            this.f7213i = bVar.f6419h.get();
            this.f7197A = bVar.f6421j;
            this.f7227w = bVar.f6422k;
            this.f7199C = false;
            this.f7219o = bVar.f6429r;
            b bVar2 = new b(null);
            this.f7210f = bVar2;
            this.f7211g = new c(null);
            this.f7212h = new CopyOnWriteArraySet<>();
            Handler handler = new Handler(bVar.f6420i);
            this.f7206b = bVar.f6414c.get().mo2596a(handler, bVar2, bVar2, bVar2, bVar2);
            this.f7198B = 1.0f;
            if (C2738e0.f6708a < 21) {
                AudioTrack audioTrack = this.f7220p;
                if (audioTrack != null && audioTrack.getAudioSessionId() != 0) {
                    this.f7220p.release();
                    this.f7220p = null;
                }
                if (this.f7220p == null) {
                    this.f7220p = new AudioTrack(3, SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM, 4, 2, 2, 0, 0);
                }
                this.f7230z = this.f7220p.getAudioSessionId();
            } else {
                AudioManager audioManager = (AudioManager) applicationContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                this.f7230z = audioManager == null ? -1 : audioManager.generateAudioSessionId();
            }
            this.f7200D = Collections.emptyList();
            this.f7201E = true;
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            int[] iArr = {21, 22, 23, 24, 25, 26, 27, 28};
            for (int i = 0; i < 8; i++) {
                int i2 = iArr[i];
                C1460d.m426D(!false);
                sparseBooleanArray.append(i2, true);
            }
            C1460d.m426D(!false);
            try {
                C2727f1 c2727f1 = new C2727f1(this.f7206b, bVar.f6416e.get(), bVar.f6415d.get(), bVar.f6417f.get(), bVar.f6418g.get(), this.f7213i, bVar.f6423l, bVar.f6424m, bVar.f6425n, bVar.f6426o, bVar.f6427p, bVar.f6428q, false, bVar.f6413b, bVar.f6420i, this, new InterfaceC3128y1.b(new C2747n(sparseBooleanArray, null), null));
                c2816k2 = this;
                try {
                    c2816k2.f7209e = c2727f1;
                    c2727f1.m2898d0(c2816k2.f7210f);
                    c2727f1.f6668k.add(c2816k2.f7210f);
                    C2846s0 c2846s0 = new C2846s0(bVar.f6412a, handler, c2816k2.f7210f);
                    c2816k2.f7214j = c2846s0;
                    c2846s0.m3363a(false);
                    C2909t0 c2909t0 = new C2909t0(bVar.f6412a, handler, c2816k2.f7210f);
                    c2816k2.f7215k = c2909t0;
                    c2909t0.m3462c(null);
                    C2824m2 c2824m2 = new C2824m2(bVar.f6412a, handler, c2816k2.f7210f);
                    c2816k2.f7216l = c2824m2;
                    c2824m2.m3307c(C2738e0.m3012t(c2816k2.f7197A.f7782m));
                    C2840q2 c2840q2 = new C2840q2(bVar.f6412a);
                    c2816k2.f7217m = c2840q2;
                    c2840q2.f7459c = false;
                    c2840q2.m3357a();
                    C2844r2 c2844r2 = new C2844r2(bVar.f6412a);
                    c2816k2.f7218n = c2844r2;
                    c2844r2.f7476c = false;
                    c2844r2.m3362a();
                    c2816k2.f7204H = m3281f0(c2824m2);
                    c2816k2.f7205I = C2788y.f6954j;
                    c2816k2.m3286j0(1, 10, Integer.valueOf(c2816k2.f7230z));
                    c2816k2.m3286j0(2, 10, Integer.valueOf(c2816k2.f7230z));
                    c2816k2.m3286j0(1, 3, c2816k2.f7197A);
                    c2816k2.m3286j0(2, 4, Integer.valueOf(c2816k2.f7227w));
                    c2816k2.m3286j0(2, 5, 0);
                    c2816k2.m3286j0(1, 9, Boolean.valueOf(c2816k2.f7199C));
                    c2816k2.m3286j0(2, 7, c2816k2.f7211g);
                    c2816k2.m3286j0(6, 8, c2816k2.f7211g);
                    c2816k2.f7207c.m3026b();
                } catch (Throwable th) {
                    th = th;
                    c2816k2.f7207c.m3026b();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                c2816k2 = this;
            }
        } catch (Throwable th3) {
            th = th3;
            c2816k2 = this;
        }
    }

    /* JADX INFO: renamed from: d0 */
    public static void m3280d0(C2816k2 c2816k2) {
        int iMo2930y = c2816k2.mo2930y();
        if (iMo2930y != 1) {
            if (iMo2930y == 2 || iMo2930y == 3) {
                c2816k2.m3290n0();
                boolean z2 = c2816k2.f7209e.f6657F.f7962q;
                C2840q2 c2840q2 = c2816k2.f7217m;
                c2840q2.f7460d = c2816k2.mo2908j() && !z2;
                c2840q2.m3357a();
                C2844r2 c2844r2 = c2816k2.f7218n;
                c2844r2.f7477d = c2816k2.mo2908j();
                c2844r2.m3362a();
                return;
            }
            if (iMo2930y != 4) {
                throw new IllegalStateException();
            }
        }
        C2840q2 c2840q3 = c2816k2.f7217m;
        c2840q3.f7460d = false;
        c2840q3.m3357a();
        C2844r2 c2844r3 = c2816k2.f7218n;
        c2844r3.f7477d = false;
        c2844r3.m3362a();
    }

    /* JADX INFO: renamed from: f0 */
    public static C2633c1 m3281f0(C2824m2 c2824m2) {
        Objects.requireNonNull(c2824m2);
        return new C2633c1(0, C2738e0.f6708a >= 28 ? c2824m2.f7249d.getStreamMinVolume(c2824m2.f7251f) : 0, c2824m2.f7249d.getStreamMaxVolume(c2824m2.f7251f));
    }

    /* JADX INFO: renamed from: g0 */
    public static int m3282g0(boolean z2, int i) {
        return (!z2 || i == 1) ? 1 : 2;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: A */
    public List<C2578b> mo2879A() {
        m3290n0();
        return this.f7200D;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: B */
    public int mo2880B() {
        m3290n0();
        return this.f7209e.mo2880B();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: C */
    public int mo2881C() {
        m3290n0();
        return this.f7209e.mo2881C();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: E */
    public void mo2882E(int i) {
        m3290n0();
        this.f7209e.mo2882E(i);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: F */
    public void mo2883F(@Nullable SurfaceView surfaceView) throws CloneNotSupportedException {
        m3290n0();
        SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        m3290n0();
        if (holder == null || holder != this.f7223s) {
            return;
        }
        m3283e0();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: G */
    public int mo2884G() {
        m3290n0();
        return this.f7209e.f6657F.f7959n;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: H */
    public C2836p2 mo2885H() {
        m3290n0();
        return this.f7209e.mo2885H();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: I */
    public int mo2886I() {
        m3290n0();
        return this.f7209e.f6679v;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: J */
    public long mo2887J() {
        m3290n0();
        return this.f7209e.mo2887J();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: K */
    public AbstractC2832o2 mo2888K() {
        m3290n0();
        return this.f7209e.f6657F.f7947b;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: L */
    public Looper mo2889L() {
        return this.f7209e.f6674q;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: M */
    public boolean mo2890M() {
        m3290n0();
        return this.f7209e.f6680w;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: N */
    public long mo2891N() {
        m3290n0();
        return this.f7209e.mo2891N();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: Q */
    public void mo2892Q(@Nullable TextureView textureView) throws CloneNotSupportedException {
        m3290n0();
        if (textureView == null) {
            m3283e0();
            return;
        }
        m3285i0();
        this.f7226v = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            Log.w("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.f7210f);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            m3288l0(null);
            m3284h0(0, 0);
        } else {
            Surface surface = new Surface(surfaceTexture);
            m3288l0(surface);
            this.f7222r = surface;
            m3284h0(textureView.getWidth(), textureView.getHeight());
        }
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: S */
    public C2835p1 mo2893S() {
        return this.f7209e.f6655D;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: T */
    public long mo2894T() {
        m3290n0();
        return this.f7209e.mo2894T();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: U */
    public long mo2895U() {
        m3290n0();
        return this.f7209e.f6676s;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: a */
    public void mo2896a() throws CloneNotSupportedException {
        m3290n0();
        boolean zMo2908j = mo2908j();
        int iM3464e = this.f7215k.m3464e(zMo2908j, 2);
        m3289m0(zMo2908j, iM3464e, m3282g0(zMo2908j, iM3464e));
        this.f7209e.mo2896a();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: c */
    public C2998x1 mo2897c() {
        m3290n0();
        return this.f7209e.f6657F.f7960o;
    }

    /* JADX INFO: renamed from: e0 */
    public void m3283e0() throws CloneNotSupportedException {
        m3290n0();
        m3285i0();
        m3288l0(null);
        m3284h0(0, 0);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: f */
    public boolean mo2900f() {
        m3290n0();
        return this.f7209e.mo2900f();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: g */
    public long mo2902g() {
        m3290n0();
        return C2738e0.m2992M(this.f7209e.f6657F.f7964s);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: h */
    public void mo2904h(int i, long j) throws CloneNotSupportedException {
        m3290n0();
        C2868g1 c2868g1 = this.f7213i;
        if (!c2868g1.f7555r) {
            final InterfaceC2871h1.a aVarM3382k0 = c2868g1.m3382k0();
            c2868g1.f7555r = true;
            C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.o
                @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                public final void invoke(Object obj) {
                    ((InterfaceC2871h1) obj).m3437j0();
                }
            };
            c2868g1.f7551n.put(-1, aVarM3382k0);
            C2749p<InterfaceC2871h1> c2749p = c2868g1.f7552o;
            c2749p.m3035b(-1, aVar);
            c2749p.m3034a();
        }
        this.f7209e.mo2904h(i, j);
    }

    /* JADX INFO: renamed from: h0 */
    public final void m3284h0(int i, int i2) {
        if (i == this.f7228x && i2 == this.f7229y) {
            return;
        }
        this.f7228x = i;
        this.f7229y = i2;
        this.f7213i.mo245a0(i, i2);
        Iterator<InterfaceC3128y1.e> it = this.f7212h.iterator();
        while (it.hasNext()) {
            it.next().mo245a0(i, i2);
        }
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: i */
    public InterfaceC3128y1.b mo2906i() {
        m3290n0();
        return this.f7209e.f6654C;
    }

    /* JADX INFO: renamed from: i0 */
    public final void m3285i0() {
        if (this.f7224t != null) {
            C2576b2 c2576b2M2901f0 = this.f7209e.m2901f0(this.f7211g);
            c2576b2M2901f0.m2602f(10000);
            c2576b2M2901f0.m2601e(null);
            c2576b2M2901f0.m2600d();
            C2799k c2799k = this.f7224t;
            c2799k.f7021j.remove(this.f7210f);
            this.f7224t = null;
        }
        TextureView textureView = this.f7226v;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f7210f) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f7226v.setSurfaceTextureListener(null);
            }
            this.f7226v = null;
        }
        SurfaceHolder surfaceHolder = this.f7223s;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f7210f);
            this.f7223s = null;
        }
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: j */
    public boolean mo2908j() {
        m3290n0();
        return this.f7209e.f6657F.f7958m;
    }

    /* JADX INFO: renamed from: j0 */
    public final void m3286j0(int i, int i2, @Nullable Object obj) {
        for (InterfaceC2728f2 interfaceC2728f2 : this.f7206b) {
            if (interfaceC2728f2.mo2946x() == i) {
                C2576b2 c2576b2M2901f0 = this.f7209e.m2901f0(interfaceC2728f2);
                C1460d.m426D(!c2576b2M2901f0.f5750i);
                c2576b2M2901f0.f5746e = i2;
                C1460d.m426D(!c2576b2M2901f0.f5750i);
                c2576b2M2901f0.f5747f = obj;
                c2576b2M2901f0.m2600d();
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: k */
    public void mo2909k(boolean z2) {
        m3290n0();
        this.f7209e.mo2909k(z2);
    }

    /* JADX INFO: renamed from: k0 */
    public final void m3287k0(SurfaceHolder surfaceHolder) {
        this.f7225u = false;
        this.f7223s = surfaceHolder;
        surfaceHolder.addCallback(this.f7210f);
        Surface surface = this.f7223s.getSurface();
        if (surface == null || !surface.isValid()) {
            m3284h0(0, 0);
        } else {
            Rect surfaceFrame = this.f7223s.getSurfaceFrame();
            m3284h0(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: l */
    public long mo2910l() {
        m3290n0();
        Objects.requireNonNull(this.f7209e);
        return 3000L;
    }

    /* JADX INFO: renamed from: l0 */
    public final void m3288l0(@Nullable Object obj) throws CloneNotSupportedException {
        boolean z2;
        ArrayList arrayList = new ArrayList();
        for (InterfaceC2728f2 interfaceC2728f2 : this.f7206b) {
            if (interfaceC2728f2.mo2946x() == 2) {
                C2576b2 c2576b2M2901f0 = this.f7209e.m2901f0(interfaceC2728f2);
                c2576b2M2901f0.m2602f(1);
                C1460d.m426D(true ^ c2576b2M2901f0.f5750i);
                c2576b2M2901f0.f5747f = obj;
                c2576b2M2901f0.m2600d();
                arrayList.add(c2576b2M2901f0);
            }
        }
        Object obj2 = this.f7221q;
        if (obj2 == null || obj2 == obj) {
            z2 = false;
        } else {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((C2576b2) it.next()).m2597a(this.f7219o);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z2 = true;
            }
            z2 = false;
            Object obj3 = this.f7221q;
            Surface surface = this.f7222r;
            if (obj3 == surface) {
                surface.release();
                this.f7222r = null;
            }
        }
        this.f7221q = obj;
        if (z2) {
            C2727f1 c2727f1 = this.f7209e;
            ExoPlaybackException exoPlaybackExceptionM8753b = ExoPlaybackException.m8753b(new ExoTimeoutException(3), PointerIconCompat.TYPE_HELP);
            C2964w1 c2964w1 = c2727f1.f6657F;
            C2964w1 c2964w1M3562a = c2964w1.m3562a(c2964w1.f7948c);
            c2964w1M3562a.f7963r = c2964w1M3562a.f7965t;
            c2964w1M3562a.f7964s = 0L;
            C2964w1 c2964w1M3566e = c2964w1M3562a.m3567f(1).m3566e(exoPlaybackExceptionM8753b);
            c2727f1.f6681x++;
            ((C2732b0.b) c2727f1.f6666i.f7083q.mo2956c(6)).m2965b();
            c2727f1.m2924s0(c2964w1M3566e, 0, 1, false, c2964w1M3566e.f7947b.m3331q() && !c2727f1.f6657F.f7947b.m3331q(), 4, c2727f1.m2903g0(c2964w1M3566e), -1);
        }
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: m */
    public int mo2912m() {
        m3290n0();
        return this.f7209e.mo2912m();
    }

    /* JADX INFO: renamed from: m0 */
    public final void m3289m0(boolean z2, int i, int i2) {
        int i3 = 0;
        boolean z3 = z2 && i != -1;
        if (z3 && i != 1) {
            i3 = 1;
        }
        this.f7209e.m2921q0(z3, i3, i2);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: n */
    public void mo2914n(@Nullable TextureView textureView) throws CloneNotSupportedException {
        m3290n0();
        if (textureView == null || textureView != this.f7226v) {
            return;
        }
        m3283e0();
    }

    /* JADX INFO: renamed from: n0 */
    public final void m3290n0() {
        C2743j c2743j = this.f7207c;
        synchronized (c2743j) {
            boolean z2 = false;
            while (!c2743j.f6728b) {
                try {
                    c2743j.wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
        if (Thread.currentThread() != this.f7209e.f6674q.getThread()) {
            String strM3003k = C2738e0.m3003k("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), this.f7209e.f6674q.getThread().getName());
            if (this.f7201E) {
                throw new IllegalStateException(strM3003k);
            }
            C2750q.m3040c("SimpleExoPlayer", strM3003k, this.f7202F ? null : new IllegalStateException());
            this.f7202F = true;
        }
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: o */
    public C2788y mo2916o() {
        return this.f7205I;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: p */
    public void mo2918p(InterfaceC3128y1.e eVar) {
        Objects.requireNonNull(eVar);
        this.f7212h.remove(eVar);
        this.f7209e.m2917o0(eVar);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: q */
    public int mo2920q() {
        m3290n0();
        return this.f7209e.mo2920q();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: r */
    public void mo2922r(@Nullable SurfaceView surfaceView) throws CloneNotSupportedException {
        m3290n0();
        if (surfaceView instanceof InterfaceC2783t) {
            m3285i0();
            m3288l0(surfaceView);
            m3287k0(surfaceView.getHolder());
            return;
        }
        if (surfaceView instanceof C2799k) {
            m3285i0();
            this.f7224t = (C2799k) surfaceView;
            C2576b2 c2576b2M2901f0 = this.f7209e.m2901f0(this.f7211g);
            c2576b2M2901f0.m2602f(10000);
            c2576b2M2901f0.m2601e(this.f7224t);
            c2576b2M2901f0.m2600d();
            this.f7224t.f7021j.add(this.f7210f);
            m3288l0(this.f7224t.getVideoSurface());
            m3287k0(surfaceView.getHolder());
            return;
        }
        SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        m3290n0();
        if (holder == null) {
            m3283e0();
            return;
        }
        m3285i0();
        this.f7225u = true;
        this.f7223s = holder;
        holder.addCallback(this.f7210f);
        Surface surface = holder.getSurface();
        if (surface == null || !surface.isValid()) {
            m3288l0(null);
            m3284h0(0, 0);
        } else {
            m3288l0(surface);
            Rect surfaceFrame = holder.getSurfaceFrame();
            m3284h0(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    @Nullable
    /* JADX INFO: renamed from: t */
    public PlaybackException mo2925t() {
        m3290n0();
        return this.f7209e.f6657F.f7952g;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: u */
    public void mo2926u(boolean z2) {
        m3290n0();
        int iM3464e = this.f7215k.m3464e(z2, mo2930y());
        m3289m0(z2, iM3464e, m3282g0(z2, iM3464e));
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: v */
    public long mo2927v() {
        m3290n0();
        return this.f7209e.f6677t;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: w */
    public long mo2928w() {
        m3290n0();
        return this.f7209e.mo2928w();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: x */
    public void mo2929x(InterfaceC3128y1.e eVar) {
        Objects.requireNonNull(eVar);
        this.f7212h.add(eVar);
        this.f7209e.m2898d0(eVar);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC3128y1
    /* JADX INFO: renamed from: y */
    public int mo2930y() {
        m3290n0();
        return this.f7209e.f6657F.f7951f;
    }
}
