package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.a3.BundledExtractorsAdapter;
import b.i.a.c.a3.ProgressiveMediaPeriod;
import b.i.a.c.a3.SampleQueue;
import b.i.a.c.f3.Log2;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.Extractor;
import com.google.android.exoplayer2.drm.DrmSession;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class Loader {
    public static final c a = new c(2, -9223372036854775807L, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f2978b = new c(3, -9223372036854775807L, null);
    public final ExecutorService c;

    @Nullable
    public d<? extends e> d;

    @Nullable
    public IOException e;

    public static final class UnexpectedLoaderException extends IOException {
        /* JADX WARN: Illegal instructions before constructor call */
        public UnexpectedLoaderException(Throwable th) {
            String simpleName = th.getClass().getSimpleName();
            String message = th.getMessage();
            super(outline.l(outline.b(message, simpleName.length() + 13), "Unexpected ", simpleName, ": ", message), th);
        }
    }

    public interface b<T extends e> {
        void b(T t, long j, long j2, boolean z2);

        void d(T t, long j, long j2);

        c o(T t, long j, long j2, IOException iOException, int i);
    }

    public static final class c {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f2979b;

        public c(int i, long j, a aVar) {
            this.a = i;
            this.f2979b = j;
        }
    }

    @SuppressLint({"HandlerLeak"})
    public final class d<T extends e> extends Handler implements Runnable {
        public final int j;
        public final T k;
        public final long l;

        @Nullable
        public b<T> m;

        @Nullable
        public IOException n;
        public int o;

        @Nullable
        public Thread p;
        public boolean q;
        public volatile boolean r;

        public d(Looper looper, T t, b<T> bVar, int i, long j) {
            super(looper);
            this.k = t;
            this.m = bVar;
            this.j = i;
            this.l = j;
        }

        public void a(boolean z2) {
            this.r = z2;
            this.n = null;
            if (hasMessages(0)) {
                this.q = true;
                removeMessages(0);
                if (!z2) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    this.q = true;
                    ((ProgressiveMediaPeriod.a) this.k).h = true;
                    Thread thread = this.p;
                    if (thread != null) {
                        thread.interrupt();
                    }
                }
            }
            if (z2) {
                Loader.this.d = null;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                b<T> bVar = this.m;
                Objects.requireNonNull(bVar);
                bVar.b(this.k, jElapsedRealtime, jElapsedRealtime - this.l, true);
                this.m = null;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void b(long j) {
            AnimatableValueParser.D(Loader.this.d == null);
            Loader loader = Loader.this;
            loader.d = this;
            if (j > 0) {
                sendEmptyMessageDelayed(0, j);
            } else {
                this.n = null;
                loader.c.execute(this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.r) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                this.n = null;
                Loader loader = Loader.this;
                ExecutorService executorService = loader.c;
                d<? extends e> dVar = loader.d;
                Objects.requireNonNull(dVar);
                executorService.execute(dVar);
                return;
            }
            if (i == 3) {
                throw ((Error) message.obj);
            }
            Loader.this.d = null;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = jElapsedRealtime - this.l;
            b<T> bVar = this.m;
            Objects.requireNonNull(bVar);
            if (this.q) {
                bVar.b(this.k, jElapsedRealtime, j, false);
                return;
            }
            int i2 = message.what;
            if (i2 == 1) {
                try {
                    bVar.d(this.k, jElapsedRealtime, j);
                    return;
                } catch (RuntimeException e) {
                    Log2.b("LoadTask", "Unexpected exception handling load completed", e);
                    Loader.this.e = new UnexpectedLoaderException(e);
                    return;
                }
            }
            if (i2 != 2) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.n = iOException;
            int i3 = this.o + 1;
            this.o = i3;
            c cVarO = bVar.o(this.k, jElapsedRealtime, j, iOException, i3);
            int i4 = cVarO.a;
            if (i4 == 3) {
                Loader.this.e = this.n;
            } else if (i4 != 2) {
                if (i4 == 1) {
                    this.o = 1;
                }
                long jMin = cVarO.f2979b;
                if (jMin == -9223372036854775807L) {
                    jMin = Math.min((this.o - 1) * 1000, 5000);
                }
                b(jMin);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z2;
            try {
                synchronized (this) {
                    z2 = !this.q;
                    this.p = Thread.currentThread();
                }
                if (z2) {
                    String simpleName = this.k.getClass().getSimpleName();
                    AnimatableValueParser.f(simpleName.length() != 0 ? "load:".concat(simpleName) : new String("load:"));
                    try {
                        ((ProgressiveMediaPeriod.a) this.k).b();
                        AnimatableValueParser.d0();
                    } catch (Throwable th) {
                        AnimatableValueParser.d0();
                        throw th;
                    }
                }
                synchronized (this) {
                    this.p = null;
                    Thread.interrupted();
                }
                if (this.r) {
                    return;
                }
                sendEmptyMessage(1);
            } catch (IOException e) {
                if (this.r) {
                    return;
                }
                obtainMessage(2, e).sendToTarget();
            } catch (OutOfMemoryError e2) {
                if (this.r) {
                    return;
                }
                Log2.b("LoadTask", "OutOfMemory error loading stream", e2);
                obtainMessage(2, new UnexpectedLoaderException(e2)).sendToTarget();
            } catch (Error e3) {
                if (!this.r) {
                    Log2.b("LoadTask", "Unexpected error loading stream", e3);
                    obtainMessage(3, e3).sendToTarget();
                }
                throw e3;
            } catch (Exception e4) {
                if (this.r) {
                    return;
                }
                Log2.b("LoadTask", "Unexpected exception loading stream", e4);
                obtainMessage(2, new UnexpectedLoaderException(e4)).sendToTarget();
            }
        }
    }

    public interface e {
    }

    public interface f {
    }

    public static final class g implements Runnable {
        public final f j;

        public g(f fVar) {
            this.j = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ProgressiveMediaPeriod progressiveMediaPeriod = (ProgressiveMediaPeriod) this.j;
            for (SampleQueue sampleQueue : progressiveMediaPeriod.D) {
                sampleQueue.s(true);
                DrmSession drmSession = sampleQueue.i;
                if (drmSession != null) {
                    drmSession.b(sampleQueue.e);
                    sampleQueue.i = null;
                    sampleQueue.h = null;
                }
            }
            BundledExtractorsAdapter bundledExtractorsAdapter = (BundledExtractorsAdapter) progressiveMediaPeriod.w;
            Extractor extractor = bundledExtractorsAdapter.f828b;
            if (extractor != null) {
                extractor.release();
                bundledExtractorsAdapter.f828b = null;
            }
            bundledExtractorsAdapter.c = null;
        }
    }

    public Loader(String str) {
        final String strConcat = str.length() != 0 ? "ExoPlayer:Loader:".concat(str) : new String("ExoPlayer:Loader:");
        int i = Util2.a;
        this.c = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: b.i.a.c.f3.d
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, strConcat);
            }
        });
    }

    public static c a(boolean z2, long j) {
        return new c(z2 ? 1 : 0, j, null);
    }

    public boolean b() {
        return this.d != null;
    }
}
