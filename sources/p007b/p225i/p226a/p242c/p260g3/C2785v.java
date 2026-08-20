package p007b.p225i.p226a.p242c.p260g3;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2750q;

/* JADX INFO: renamed from: b.i.a.c.g3.v */
/* JADX INFO: compiled from: VideoFrameReleaseHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2785v {

    /* JADX INFO: renamed from: a */
    public final C2779p f6926a = new C2779p();

    /* JADX INFO: renamed from: b */
    @Nullable
    public final b f6927b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final e f6928c;

    /* JADX INFO: renamed from: d */
    public boolean f6929d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public Surface f6930e;

    /* JADX INFO: renamed from: f */
    public float f6931f;

    /* JADX INFO: renamed from: g */
    public float f6932g;

    /* JADX INFO: renamed from: h */
    public float f6933h;

    /* JADX INFO: renamed from: i */
    public float f6934i;

    /* JADX INFO: renamed from: j */
    public int f6935j;

    /* JADX INFO: renamed from: k */
    public long f6936k;

    /* JADX INFO: renamed from: l */
    public long f6937l;

    /* JADX INFO: renamed from: m */
    public long f6938m;

    /* JADX INFO: renamed from: n */
    public long f6939n;

    /* JADX INFO: renamed from: o */
    public long f6940o;

    /* JADX INFO: renamed from: p */
    public long f6941p;

    /* JADX INFO: renamed from: q */
    public long f6942q;

    /* JADX INFO: renamed from: b.i.a.c.g3.v$a */
    /* JADX INFO: compiled from: VideoFrameReleaseHelper.java */
    @RequiresApi(30)
    public static final class a {
        @DoNotInline
        /* JADX INFO: renamed from: a */
        public static void m3182a(Surface surface, float f) {
            try {
                surface.setFrameRate(f, f == 0.0f ? 0 : 1);
            } catch (IllegalStateException e) {
                C2750q.m3039b("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e);
            }
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.g3.v$b */
    /* JADX INFO: compiled from: VideoFrameReleaseHelper.java */
    public interface b {

        /* JADX INFO: renamed from: b.i.a.c.g3.v$b$a */
        /* JADX INFO: compiled from: VideoFrameReleaseHelper.java */
        public interface a {
        }

        /* JADX INFO: renamed from: a */
        void mo3183a(a aVar);

        void unregister();
    }

    /* JADX INFO: renamed from: b.i.a.c.g3.v$c */
    /* JADX INFO: compiled from: VideoFrameReleaseHelper.java */
    public static final class c implements b {

        /* JADX INFO: renamed from: a */
        public final WindowManager f6943a;

        public c(WindowManager windowManager) {
            this.f6943a = windowManager;
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.C2785v.b
        /* JADX INFO: renamed from: a */
        public void mo3183a(b.a aVar) {
            ((C2765b) aVar).m3120a(this.f6943a.getDefaultDisplay());
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.C2785v.b
        public void unregister() {
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.g3.v$d */
    /* JADX INFO: compiled from: VideoFrameReleaseHelper.java */
    @RequiresApi(17)
    public static final class d implements b, DisplayManager.DisplayListener {

        /* JADX INFO: renamed from: a */
        public final DisplayManager f6944a;

        /* JADX INFO: renamed from: b */
        @Nullable
        public b.a f6945b;

        public d(DisplayManager displayManager) {
            this.f6944a = displayManager;
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.C2785v.b
        /* JADX INFO: renamed from: a */
        public void mo3183a(b.a aVar) {
            this.f6945b = aVar;
            this.f6944a.registerDisplayListener(this, C2738e0.m3002j());
            ((C2765b) aVar).m3120a(this.f6944a.getDisplay(0));
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            b.a aVar = this.f6945b;
            if (aVar == null || i != 0) {
                return;
            }
            ((C2765b) aVar).m3120a(this.f6944a.getDisplay(0));
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.C2785v.b
        public void unregister() {
            this.f6944a.unregisterDisplayListener(this);
            this.f6945b = null;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.g3.v$e */
    /* JADX INFO: compiled from: VideoFrameReleaseHelper.java */
    public static final class e implements Choreographer.FrameCallback, Handler.Callback {

        /* JADX INFO: renamed from: j */
        public static final e f6946j = new e();

        /* JADX INFO: renamed from: k */
        public volatile long f6947k = -9223372036854775807L;

        /* JADX INFO: renamed from: l */
        public final Handler f6948l;

        /* JADX INFO: renamed from: m */
        public final HandlerThread f6949m;

        /* JADX INFO: renamed from: n */
        public Choreographer f6950n;

        /* JADX INFO: renamed from: o */
        public int f6951o;

        public e() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.f6949m = handlerThread;
            handlerThread.start();
            Looper looper = handlerThread.getLooper();
            int i = C2738e0.f6708a;
            Handler handler = new Handler(looper, this);
            this.f6948l = handler;
            handler.sendEmptyMessage(0);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            this.f6947k = j;
            Choreographer choreographer = this.f6950n;
            Objects.requireNonNull(choreographer);
            choreographer.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                this.f6950n = Choreographer.getInstance();
                return true;
            }
            if (i == 1) {
                int i2 = this.f6951o + 1;
                this.f6951o = i2;
                if (i2 == 1) {
                    Choreographer choreographer = this.f6950n;
                    Objects.requireNonNull(choreographer);
                    choreographer.postFrameCallback(this);
                }
                return true;
            }
            if (i != 2) {
                return false;
            }
            int i3 = this.f6951o - 1;
            this.f6951o = i3;
            if (i3 == 0) {
                Choreographer choreographer2 = this.f6950n;
                Objects.requireNonNull(choreographer2);
                choreographer2.removeFrameCallback(this);
                this.f6947k = -9223372036854775807L;
            }
            return true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003b  */
    public C2785v(@Nullable Context context) {
        b dVar;
        DisplayManager displayManager;
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            dVar = (C2738e0.f6708a < 17 || (displayManager = (DisplayManager) applicationContext.getSystemService("display")) == null) ? null : new d(displayManager);
            if (dVar == null) {
                WindowManager windowManager = (WindowManager) applicationContext.getSystemService("window");
                if (windowManager != null) {
                    dVar = new c(windowManager);
                } else {
                    dVar = null;
                }
            }
        } else {
            dVar = null;
        }
        this.f6927b = dVar;
        this.f6928c = dVar != null ? e.f6946j : null;
        this.f6936k = -9223372036854775807L;
        this.f6937l = -9223372036854775807L;
        this.f6931f = -1.0f;
        this.f6934i = 1.0f;
        this.f6935j = 0;
    }

    /* JADX INFO: renamed from: a */
    public final void m3178a() {
        Surface surface;
        if (C2738e0.f6708a < 30 || (surface = this.f6930e) == null || this.f6935j == Integer.MIN_VALUE || this.f6933h == 0.0f) {
            return;
        }
        this.f6933h = 0.0f;
        a.m3182a(surface, 0.0f);
    }

    /* JADX INFO: renamed from: b */
    public final void m3179b() {
        this.f6938m = 0L;
        this.f6941p = -1L;
        this.f6939n = -1L;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0086  */
    /* JADX INFO: renamed from: c */
    public final void m3180c() {
        float f;
        boolean z2;
        if (C2738e0.f6708a < 30 || this.f6930e == null) {
            return;
        }
        if (this.f6926a.m3127a()) {
            C2779p c2779p = this.f6926a;
            if (c2779p.m3127a()) {
                C2779p.a aVar = c2779p.f6850a;
                long j = aVar.f6859e;
                f = (float) (1.0E9d / (j != 0 ? aVar.f6860f / j : 0L));
            } else {
                f = -1.0f;
            }
        } else {
            f = this.f6931f;
        }
        float f2 = this.f6932g;
        if (f == f2) {
            return;
        }
        boolean z3 = true;
        if (f != -1.0f && f2 != -1.0f) {
            if (this.f6926a.m3127a()) {
                C2779p c2779p2 = this.f6926a;
                if ((c2779p2.m3127a() ? c2779p2.f6850a.f6860f : -9223372036854775807L) >= 5000000000L) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            if (Math.abs(f - this.f6932g) < (z2 ? 0.02f : 1.0f)) {
                z3 = false;
            }
        } else if (f == -1.0f && this.f6926a.f6854e < 30) {
            z3 = false;
        }
        if (z3) {
            this.f6932g = f;
            m3181d(false);
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m3181d(boolean z2) {
        Surface surface;
        if (C2738e0.f6708a < 30 || (surface = this.f6930e) == null || this.f6935j == Integer.MIN_VALUE) {
            return;
        }
        float f = 0.0f;
        if (this.f6929d) {
            float f2 = this.f6932g;
            if (f2 != -1.0f) {
                f = this.f6934i * f2;
            }
        }
        if (z2 || this.f6933h != f) {
            this.f6933h = f;
            a.m3182a(surface, f);
        }
    }
}
