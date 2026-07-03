package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p243a3.C2538e0;
import p007b.p225i.p226a.p242c.p243a3.C2544h0;
import p007b.p225i.p226a.p242c.p243a3.C2553m;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2750q;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h;

/* JADX INFO: loaded from: classes3.dex */
public final class Loader {

    /* JADX INFO: renamed from: a */
    public static final C10768c f20229a = new C10768c(2, -9223372036854775807L, null);

    /* JADX INFO: renamed from: b */
    public static final C10768c f20230b = new C10768c(3, -9223372036854775807L, null);

    /* JADX INFO: renamed from: c */
    public final ExecutorService f20231c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public HandlerC10769d<? extends InterfaceC10770e> f20232d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public IOException f20233e;

    public static final class UnexpectedLoaderException extends IOException {
        /* JADX WARN: Illegal instructions before constructor call */
        public UnexpectedLoaderException(Throwable th) {
            String simpleName = th.getClass().getSimpleName();
            String message = th.getMessage();
            super(C1643a.m861l(C1643a.m841b(message, simpleName.length() + 13), "Unexpected ", simpleName, ": ", message), th);
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.upstream.Loader$b */
    public interface InterfaceC10767b<T extends InterfaceC10770e> {
        /* JADX INFO: renamed from: b */
        void mo2478b(T t, long j, long j2, boolean z2);

        /* JADX INFO: renamed from: d */
        void mo2480d(T t, long j, long j2);

        /* JADX INFO: renamed from: o */
        C10768c mo2491o(T t, long j, long j2, IOException iOException, int i);
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.upstream.Loader$c */
    public static final class C10768c {

        /* JADX INFO: renamed from: a */
        public final int f20234a;

        /* JADX INFO: renamed from: b */
        public final long f20235b;

        public C10768c(int i, long j, C10766a c10766a) {
            this.f20234a = i;
            this.f20235b = j;
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.upstream.Loader$d */
    @SuppressLint({"HandlerLeak"})
    public final class HandlerC10769d<T extends InterfaceC10770e> extends Handler implements Runnable {

        /* JADX INFO: renamed from: j */
        public final int f20236j;

        /* JADX INFO: renamed from: k */
        public final T f20237k;

        /* JADX INFO: renamed from: l */
        public final long f20238l;

        /* JADX INFO: renamed from: m */
        @Nullable
        public InterfaceC10767b<T> f20239m;

        /* JADX INFO: renamed from: n */
        @Nullable
        public IOException f20240n;

        /* JADX INFO: renamed from: o */
        public int f20241o;

        /* JADX INFO: renamed from: p */
        @Nullable
        public Thread f20242p;

        /* JADX INFO: renamed from: q */
        public boolean f20243q;

        /* JADX INFO: renamed from: r */
        public volatile boolean f20244r;

        public HandlerC10769d(Looper looper, T t, InterfaceC10767b<T> interfaceC10767b, int i, long j) {
            super(looper);
            this.f20237k = t;
            this.f20239m = interfaceC10767b;
            this.f20236j = i;
            this.f20238l = j;
        }

        /* JADX INFO: renamed from: a */
        public void m8941a(boolean z2) {
            this.f20244r = z2;
            this.f20240n = null;
            if (hasMessages(0)) {
                this.f20243q = true;
                removeMessages(0);
                if (!z2) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    this.f20243q = true;
                    ((C2538e0.a) this.f20237k).f5545h = true;
                    Thread thread = this.f20242p;
                    if (thread != null) {
                        thread.interrupt();
                    }
                }
            }
            if (z2) {
                Loader.this.f20232d = null;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                InterfaceC10767b<T> interfaceC10767b = this.f20239m;
                Objects.requireNonNull(interfaceC10767b);
                interfaceC10767b.mo2478b(this.f20237k, jElapsedRealtime, jElapsedRealtime - this.f20238l, true);
                this.f20239m = null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: b */
        public void m8942b(long j) {
            C1460d.m426D(Loader.this.f20232d == null);
            Loader loader = Loader.this;
            loader.f20232d = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                this.f20240n = null;
                loader.f20231c.execute(this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f20244r) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                this.f20240n = null;
                Loader loader = Loader.this;
                ExecutorService executorService = loader.f20231c;
                HandlerC10769d<? extends InterfaceC10770e> handlerC10769d = loader.f20232d;
                Objects.requireNonNull(handlerC10769d);
                executorService.execute(handlerC10769d);
                return;
            }
            if (i == 3) {
                throw ((Error) message.obj);
            }
            Loader.this.f20232d = null;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.f20238l;
            InterfaceC10767b<T> interfaceC10767b = this.f20239m;
            Objects.requireNonNull(interfaceC10767b);
            if (this.f20243q) {
                interfaceC10767b.mo2478b(this.f20237k, jElapsedRealtime, j, false);
                return;
            }
            int i2 = message.what;
            if (i2 == 1) {
                try {
                    interfaceC10767b.mo2480d(this.f20237k, jElapsedRealtime, j);
                    return;
                } catch (RuntimeException e) {
                    C2750q.m3039b("LoadTask", "Unexpected exception handling load completed", e);
                    Loader.this.f20233e = new UnexpectedLoaderException(e);
                    return;
                }
            }
            if (i2 != 2) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.f20240n = iOException;
            int i3 = this.f20241o + 1;
            this.f20241o = i3;
            C10768c c10768cMo2491o = interfaceC10767b.mo2491o(this.f20237k, jElapsedRealtime, j, iOException, i3);
            int i4 = c10768cMo2491o.f20234a;
            if (i4 == 3) {
                Loader.this.f20233e = this.f20240n;
            } else if (i4 != 2) {
                if (i4 == 1) {
                    this.f20241o = 1;
                }
                long jMin = c10768cMo2491o.f20235b;
                if (jMin == -9223372036854775807L) {
                    jMin = Math.min((this.f20241o - 1) * 1000, 5000);
                }
                m8942b(jMin);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z2;
            try {
                synchronized (this) {
                    z2 = !this.f20243q;
                    this.f20242p = Thread.currentThread();
                }
                if (z2) {
                    String simpleName = this.f20237k.getClass().getSimpleName();
                    C1460d.m515f(simpleName.length() != 0 ? "load:".concat(simpleName) : new String("load:"));
                    try {
                        ((C2538e0.a) this.f20237k).m2504b();
                        C1460d.m508d0();
                    } catch (Throwable th) {
                        C1460d.m508d0();
                        throw th;
                    }
                }
                synchronized (this) {
                    this.f20242p = null;
                    Thread.interrupted();
                }
                if (this.f20244r) {
                    return;
                }
                sendEmptyMessage(1);
            } catch (IOException e) {
                if (this.f20244r) {
                    return;
                }
                obtainMessage(2, e).sendToTarget();
            } catch (OutOfMemoryError e2) {
                if (this.f20244r) {
                    return;
                }
                C2750q.m3039b("LoadTask", "OutOfMemory error loading stream", e2);
                obtainMessage(2, new UnexpectedLoaderException(e2)).sendToTarget();
            } catch (Error e3) {
                if (!this.f20244r) {
                    C2750q.m3039b("LoadTask", "Unexpected error loading stream", e3);
                    obtainMessage(3, e3).sendToTarget();
                }
                throw e3;
            } catch (Exception e4) {
                if (this.f20244r) {
                    return;
                }
                C2750q.m3039b("LoadTask", "Unexpected exception loading stream", e4);
                obtainMessage(2, new UnexpectedLoaderException(e4)).sendToTarget();
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.upstream.Loader$e */
    public interface InterfaceC10770e {
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.upstream.Loader$f */
    public interface InterfaceC10771f {
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.upstream.Loader$g */
    public static final class RunnableC10772g implements Runnable {

        /* JADX INFO: renamed from: j */
        public final InterfaceC10771f f20246j;

        public RunnableC10772g(InterfaceC10771f interfaceC10771f) {
            this.f20246j = interfaceC10771f;
        }

        @Override // java.lang.Runnable
        public void run() {
            C2538e0 c2538e0 = (C2538e0) this.f20246j;
            for (C2544h0 c2544h0 : c2538e0.f5503D) {
                c2544h0.m2540s(true);
                DrmSession drmSession = c2544h0.f5604i;
                if (drmSession != null) {
                    drmSession.mo3607b(c2544h0.f5600e);
                    c2544h0.f5604i = null;
                    c2544h0.f5603h = null;
                }
            }
            C2553m c2553m = (C2553m) c2538e0.f5534w;
            InterfaceC3031h interfaceC3031h = c2553m.f5646b;
            if (interfaceC3031h != null) {
                interfaceC3031h.release();
                c2553m.f5646b = null;
            }
            c2553m.f5647c = null;
        }
    }

    public Loader(String str) {
        final String strConcat = str.length() != 0 ? "ExoPlayer:Loader:".concat(str) : new String("ExoPlayer:Loader:");
        int i = C2738e0.f6708a;
        this.f20231c = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: b.i.a.c.f3.d
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, strConcat);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public static C10768c m8939a(boolean z2, long j) {
        return new C10768c(z2 ? 1 : 0, j, null);
    }

    /* JADX INFO: renamed from: b */
    public boolean m8940b() {
        return this.f20232d != null;
    }
}
