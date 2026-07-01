package b.i.a.c;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.AudioTrack;
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
import b.i.a.c.f3.b0$b;
import com.discord.utilities.rest.SendUtils;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoTimeoutException;
import com.google.android.exoplayer2.PlaybackException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;
import org.webrtc.MediaStreamTrack;

/* JADX INFO: compiled from: SimpleExoPlayer.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class k2 extends u0 implements e1 {
    public b.i.a.c.t2.o A;
    public float B;
    public boolean C;
    public List<b.i.a.c.b3.b> D;
    public boolean E;
    public boolean F;
    public boolean G;
    public c1 H;
    public b.i.a.c.g3.y I;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f2[] f1028b;
    public final b.i.a.c.f3.j c = new b.i.a.c.f3.j();
    public final Context d;
    public final f1 e;
    public final k2$b f;
    public final k2$c g;
    public final CopyOnWriteArraySet<y1$e> h;
    public final b.i.a.c.s2.g1 i;
    public final s0 j;
    public final t0 k;
    public final m2 l;
    public final q2 m;
    public final r2 n;
    public final long o;

    @Nullable
    public AudioTrack p;

    @Nullable
    public Object q;

    @Nullable
    public Surface r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public SurfaceHolder f1029s;

    @Nullable
    public b.i.a.c.g3.z.k t;
    public boolean u;

    @Nullable
    public TextureView v;
    public int w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1030x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f1031y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f1032z;

    public k2(e1$b e1_b) throws Throwable {
        k2 k2Var;
        try {
            Context applicationContext = e1_b.a.getApplicationContext();
            this.d = applicationContext;
            this.i = e1_b.h.get();
            this.A = e1_b.j;
            this.w = e1_b.k;
            this.C = false;
            this.o = e1_b.r;
            k2$b k2_b = new k2$b(this, null);
            this.f = k2_b;
            this.g = new k2$c(null);
            this.h = new CopyOnWriteArraySet<>();
            Handler handler = new Handler(e1_b.i);
            this.f1028b = e1_b.c.get().a(handler, k2_b, k2_b, k2_b, k2_b);
            this.B = 1.0f;
            if (b.i.a.c.f3.e0.a < 21) {
                AudioTrack audioTrack = this.p;
                if (audioTrack != null && audioTrack.getAudioSessionId() != 0) {
                    this.p.release();
                    this.p = null;
                }
                if (this.p == null) {
                    this.p = new AudioTrack(3, SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM, 4, 2, 2, 0, 0);
                }
                this.f1032z = this.p.getAudioSessionId();
            } else {
                AudioManager audioManager = (AudioManager) applicationContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                this.f1032z = audioManager == null ? -1 : audioManager.generateAudioSessionId();
            }
            this.D = Collections.emptyList();
            this.E = true;
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            int[] iArr = {21, 22, 23, 24, 25, 26, 27, 28};
            for (int i = 0; i < 8; i++) {
                int i2 = iArr[i];
                b.c.a.a0.d.D(!false);
                sparseBooleanArray.append(i2, true);
            }
            b.c.a.a0.d.D(!false);
            try {
                f1 f1Var = new f1(this.f1028b, e1_b.e.get(), e1_b.d.get(), e1_b.f.get(), e1_b.g.get(), this.i, e1_b.l, e1_b.m, e1_b.n, e1_b.o, e1_b.p, e1_b.q, false, e1_b.f923b, e1_b.i, this, new y1$b(new b.i.a.c.f3.n(sparseBooleanArray, null), null));
                k2Var = this;
                try {
                    k2Var.e = f1Var;
                    f1Var.d0(k2Var.f);
                    f1Var.k.add(k2Var.f);
                    s0 s0Var = new s0(e1_b.a, handler, k2Var.f);
                    k2Var.j = s0Var;
                    s0Var.a(false);
                    t0 t0Var = new t0(e1_b.a, handler, k2Var.f);
                    k2Var.k = t0Var;
                    t0Var.c(null);
                    m2 m2Var = new m2(e1_b.a, handler, k2Var.f);
                    k2Var.l = m2Var;
                    m2Var.c(b.i.a.c.f3.e0.t(k2Var.A.m));
                    q2 q2Var = new q2(e1_b.a);
                    k2Var.m = q2Var;
                    q2Var.c = false;
                    q2Var.a();
                    r2 r2Var = new r2(e1_b.a);
                    k2Var.n = r2Var;
                    r2Var.c = false;
                    r2Var.a();
                    k2Var.H = f0(m2Var);
                    k2Var.I = b.i.a.c.g3.y.j;
                    k2Var.j0(1, 10, Integer.valueOf(k2Var.f1032z));
                    k2Var.j0(2, 10, Integer.valueOf(k2Var.f1032z));
                    k2Var.j0(1, 3, k2Var.A);
                    k2Var.j0(2, 4, Integer.valueOf(k2Var.w));
                    k2Var.j0(2, 5, 0);
                    k2Var.j0(1, 9, Boolean.valueOf(k2Var.C));
                    k2Var.j0(2, 7, k2Var.g);
                    k2Var.j0(6, 8, k2Var.g);
                    k2Var.c.b();
                } catch (Throwable th) {
                    th = th;
                    k2Var.c.b();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                k2Var = this;
            }
        } catch (Throwable th3) {
            th = th3;
            k2Var = this;
        }
    }

    public static void d0(k2 k2Var) {
        int iY = k2Var.y();
        if (iY != 1) {
            if (iY == 2 || iY == 3) {
                k2Var.n0();
                boolean z2 = k2Var.e.F.q;
                q2 q2Var = k2Var.m;
                q2Var.d = k2Var.j() && !z2;
                q2Var.a();
                r2 r2Var = k2Var.n;
                r2Var.d = k2Var.j();
                r2Var.a();
                return;
            }
            if (iY != 4) {
                throw new IllegalStateException();
            }
        }
        q2 q2Var2 = k2Var.m;
        q2Var2.d = false;
        q2Var2.a();
        r2 r2Var2 = k2Var.n;
        r2Var2.d = false;
        r2Var2.a();
    }

    public static c1 f0(m2 m2Var) {
        Objects.requireNonNull(m2Var);
        return new c1(0, b.i.a.c.f3.e0.a >= 28 ? m2Var.d.getStreamMinVolume(m2Var.f) : 0, m2Var.d.getStreamMaxVolume(m2Var.f));
    }

    public static int g0(boolean z2, int i) {
        return (!z2 || i == 1) ? 1 : 2;
    }

    @Override // b.i.a.c.y1
    public List<b.i.a.c.b3.b> A() {
        n0();
        return this.D;
    }

    @Override // b.i.a.c.y1
    public int B() {
        n0();
        return this.e.B();
    }

    @Override // b.i.a.c.y1
    public int C() {
        n0();
        return this.e.C();
    }

    @Override // b.i.a.c.y1
    public void E(int i) {
        n0();
        this.e.E(i);
    }

    @Override // b.i.a.c.y1
    public void F(@Nullable SurfaceView surfaceView) {
        n0();
        SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        n0();
        if (holder == null || holder != this.f1029s) {
            return;
        }
        e0();
    }

    @Override // b.i.a.c.y1
    public int G() {
        n0();
        return this.e.F.n;
    }

    @Override // b.i.a.c.y1
    public p2 H() {
        n0();
        return this.e.H();
    }

    @Override // b.i.a.c.y1
    public int I() {
        n0();
        return this.e.v;
    }

    @Override // b.i.a.c.y1
    public long J() {
        n0();
        return this.e.J();
    }

    @Override // b.i.a.c.y1
    public o2 K() {
        n0();
        return this.e.F.f1146b;
    }

    @Override // b.i.a.c.y1
    public Looper L() {
        return this.e.q;
    }

    @Override // b.i.a.c.y1
    public boolean M() {
        n0();
        return this.e.w;
    }

    @Override // b.i.a.c.y1
    public long N() {
        n0();
        return this.e.N();
    }

    @Override // b.i.a.c.y1
    public void Q(@Nullable TextureView textureView) {
        n0();
        if (textureView == null) {
            e0();
            return;
        }
        i0();
        this.v = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            Log.w("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.f);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            l0(null);
            h0(0, 0);
        } else {
            Surface surface = new Surface(surfaceTexture);
            l0(surface);
            this.r = surface;
            h0(textureView.getWidth(), textureView.getHeight());
        }
    }

    @Override // b.i.a.c.y1
    public p1 S() {
        return this.e.D;
    }

    @Override // b.i.a.c.y1
    public long T() {
        n0();
        return this.e.T();
    }

    @Override // b.i.a.c.y1
    public long U() {
        n0();
        return this.e.f959s;
    }

    @Override // b.i.a.c.y1
    public void a() {
        n0();
        boolean zJ = j();
        int iE = this.k.e(zJ, 2);
        m0(zJ, iE, g0(zJ, iE));
        this.e.a();
    }

    @Override // b.i.a.c.y1
    public x1 c() {
        n0();
        return this.e.F.o;
    }

    public void e0() {
        n0();
        i0();
        l0(null);
        h0(0, 0);
    }

    @Override // b.i.a.c.y1
    public boolean f() {
        n0();
        return this.e.f();
    }

    @Override // b.i.a.c.y1
    public long g() {
        n0();
        return b.i.a.c.f3.e0.M(this.e.F.f1147s);
    }

    @Override // b.i.a.c.y1
    public void h(int i, long j) {
        n0();
        b.i.a.c.s2.g1 g1Var = this.i;
        if (!g1Var.r) {
            b.i.a.c.s2.h1$a h1_aK0 = g1Var.k0();
            g1Var.r = true;
            b.i.a.c.s2.o oVar = new b.i.a.c.s2.o(h1_aK0);
            g1Var.n.put(-1, h1_aK0);
            b.i.a.c.f3.p<b.i.a.c.s2.h1> pVar = g1Var.o;
            pVar.b(-1, oVar);
            pVar.a();
        }
        this.e.h(i, j);
    }

    public final void h0(int i, int i2) {
        if (i == this.f1030x && i2 == this.f1031y) {
            return;
        }
        this.f1030x = i;
        this.f1031y = i2;
        this.i.a0(i, i2);
        Iterator<y1$e> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().a0(i, i2);
        }
    }

    @Override // b.i.a.c.y1
    public y1$b i() {
        n0();
        return this.e.C;
    }

    public final void i0() {
        if (this.t != null) {
            b2 b2VarF0 = this.e.f0(this.g);
            b2VarF0.f(10000);
            b2VarF0.e(null);
            b2VarF0.d();
            b.i.a.c.g3.z.k kVar = this.t;
            kVar.j.remove(this.f);
            this.t = null;
        }
        TextureView textureView = this.v;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.v.setSurfaceTextureListener(null);
            }
            this.v = null;
        }
        SurfaceHolder surfaceHolder = this.f1029s;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f);
            this.f1029s = null;
        }
    }

    @Override // b.i.a.c.y1
    public boolean j() {
        n0();
        return this.e.F.m;
    }

    public final void j0(int i, int i2, @Nullable Object obj) {
        for (f2 f2Var : this.f1028b) {
            if (f2Var.x() == i) {
                b2 b2VarF0 = this.e.f0(f2Var);
                b.c.a.a0.d.D(!b2VarF0.i);
                b2VarF0.e = i2;
                b.c.a.a0.d.D(!b2VarF0.i);
                b2VarF0.f = obj;
                b2VarF0.d();
            }
        }
    }

    @Override // b.i.a.c.y1
    public void k(boolean z2) {
        n0();
        this.e.k(z2);
    }

    public final void k0(SurfaceHolder surfaceHolder) {
        this.u = false;
        this.f1029s = surfaceHolder;
        surfaceHolder.addCallback(this.f);
        Surface surface = this.f1029s.getSurface();
        if (surface == null || !surface.isValid()) {
            h0(0, 0);
        } else {
            Rect surfaceFrame = this.f1029s.getSurfaceFrame();
            h0(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // b.i.a.c.y1
    public long l() {
        n0();
        Objects.requireNonNull(this.e);
        return 3000L;
    }

    public final void l0(@Nullable Object obj) {
        boolean z2;
        ArrayList arrayList = new ArrayList();
        for (f2 f2Var : this.f1028b) {
            if (f2Var.x() == 2) {
                b2 b2VarF0 = this.e.f0(f2Var);
                b2VarF0.f(1);
                b.c.a.a0.d.D(true ^ b2VarF0.i);
                b2VarF0.f = obj;
                b2VarF0.d();
                arrayList.add(b2VarF0);
            }
        }
        Object obj2 = this.q;
        if (obj2 == null || obj2 == obj) {
            z2 = false;
        } else {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((b2) it.next()).a(this.o);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z2 = true;
            }
            z2 = false;
            Object obj3 = this.q;
            Surface surface = this.r;
            if (obj3 == surface) {
                surface.release();
                this.r = null;
            }
        }
        this.q = obj;
        if (z2) {
            f1 f1Var = this.e;
            ExoPlaybackException exoPlaybackExceptionB = ExoPlaybackException.b(new ExoTimeoutException(3), PointerIconCompat.TYPE_HELP);
            w1 w1Var = f1Var.F;
            w1 w1VarA = w1Var.a(w1Var.c);
            w1VarA.r = w1VarA.t;
            w1VarA.f1147s = 0L;
            w1 w1VarE = w1VarA.f(1).e(exoPlaybackExceptionB);
            f1Var.f960x++;
            ((b0$b) f1Var.i.q.c(6)).b();
            f1Var.s0(w1VarE, 0, 1, false, w1VarE.f1146b.q() && !f1Var.F.f1146b.q(), 4, f1Var.g0(w1VarE), -1);
        }
    }

    @Override // b.i.a.c.y1
    public int m() {
        n0();
        return this.e.m();
    }

    public final void m0(boolean z2, int i, int i2) {
        int i3 = 0;
        boolean z3 = z2 && i != -1;
        if (z3 && i != 1) {
            i3 = 1;
        }
        this.e.q0(z3, i3, i2);
    }

    @Override // b.i.a.c.y1
    public void n(@Nullable TextureView textureView) {
        n0();
        if (textureView == null || textureView != this.v) {
            return;
        }
        e0();
    }

    public final void n0() {
        b.i.a.c.f3.j jVar = this.c;
        synchronized (jVar) {
            boolean z2 = false;
            while (!jVar.f971b) {
                try {
                    jVar.wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
        if (Thread.currentThread() != this.e.q.getThread()) {
            String strK = b.i.a.c.f3.e0.k("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), this.e.q.getThread().getName());
            if (this.E) {
                throw new IllegalStateException(strK);
            }
            b.i.a.c.f3.q.c("SimpleExoPlayer", strK, this.F ? null : new IllegalStateException());
            this.F = true;
        }
    }

    @Override // b.i.a.c.y1
    public b.i.a.c.g3.y o() {
        return this.I;
    }

    @Override // b.i.a.c.y1
    public void p(y1$e y1_e) {
        Objects.requireNonNull(y1_e);
        this.h.remove(y1_e);
        this.e.o0(y1_e);
    }

    @Override // b.i.a.c.y1
    public int q() {
        n0();
        return this.e.q();
    }

    @Override // b.i.a.c.y1
    public void r(@Nullable SurfaceView surfaceView) {
        n0();
        if (surfaceView instanceof b.i.a.c.g3.t) {
            i0();
            l0(surfaceView);
            k0(surfaceView.getHolder());
            return;
        }
        if (surfaceView instanceof b.i.a.c.g3.z.k) {
            i0();
            this.t = (b.i.a.c.g3.z.k) surfaceView;
            b2 b2VarF0 = this.e.f0(this.g);
            b2VarF0.f(10000);
            b2VarF0.e(this.t);
            b2VarF0.d();
            this.t.j.add(this.f);
            l0(this.t.getVideoSurface());
            k0(surfaceView.getHolder());
            return;
        }
        SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        n0();
        if (holder == null) {
            e0();
            return;
        }
        i0();
        this.u = true;
        this.f1029s = holder;
        holder.addCallback(this.f);
        Surface surface = holder.getSurface();
        if (surface == null || !surface.isValid()) {
            l0(null);
            h0(0, 0);
        } else {
            l0(surface);
            Rect surfaceFrame = holder.getSurfaceFrame();
            h0(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // b.i.a.c.y1
    @Nullable
    public PlaybackException t() {
        n0();
        return this.e.F.g;
    }

    @Override // b.i.a.c.y1
    public void u(boolean z2) {
        n0();
        int iE = this.k.e(z2, y());
        m0(z2, iE, g0(z2, iE));
    }

    @Override // b.i.a.c.y1
    public long v() {
        n0();
        return this.e.t;
    }

    @Override // b.i.a.c.y1
    public long w() {
        n0();
        return this.e.w();
    }

    @Override // b.i.a.c.y1
    public void x(y1$e y1_e) {
        Objects.requireNonNull(y1_e);
        this.h.add(y1_e);
        this.e.d0(y1_e);
    }

    @Override // b.i.a.c.y1
    public int y() {
        n0();
        return this.e.F.f;
    }
}
