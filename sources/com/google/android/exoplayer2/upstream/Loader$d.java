package com.google.android.exoplayer2.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import b.c.a.a0.d;
import b.i.a.c.a3.e0$a;
import b.i.a.c.f3.q;
import com.google.android.exoplayer2.upstream.Loader$e;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"HandlerLeak"})
public final class Loader$d<T extends Loader$e> extends Handler implements Runnable {
    public final int j;
    public final T k;
    public final long l;

    @Nullable
    public Loader$b<T> m;

    @Nullable
    public IOException n;
    public int o;

    @Nullable
    public Thread p;
    public boolean q;
    public volatile boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final /* synthetic */ Loader f2980s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Loader$d(Loader loader, Looper looper, T t, Loader$b<T> loader$b, int i, long j) {
        super(looper);
        this.f2980s = loader;
        this.k = t;
        this.m = loader$b;
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
                ((e0$a) this.k).h = true;
                Thread thread = this.p;
                if (thread != null) {
                    thread.interrupt();
                }
            }
        }
        if (z2) {
            this.f2980s.d = null;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Loader$b<T> loader$b = this.m;
            Objects.requireNonNull(loader$b);
            loader$b.b(this.k, jElapsedRealtime, jElapsedRealtime - this.l, true);
            this.m = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(long j) {
        d.D(this.f2980s.d == null);
        Loader loader = this.f2980s;
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
            Loader loader = this.f2980s;
            ExecutorService executorService = loader.c;
            Loader$d<? extends Loader$e> loader$d = loader.d;
            Objects.requireNonNull(loader$d);
            executorService.execute(loader$d);
            return;
        }
        if (i == 3) {
            throw ((Error) message.obj);
        }
        this.f2980s.d = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.l;
        Loader$b<T> loader$b = this.m;
        Objects.requireNonNull(loader$b);
        if (this.q) {
            loader$b.b(this.k, jElapsedRealtime, j, false);
            return;
        }
        int i2 = message.what;
        if (i2 == 1) {
            try {
                loader$b.d(this.k, jElapsedRealtime, j);
                return;
            } catch (RuntimeException e) {
                q.b("LoadTask", "Unexpected exception handling load completed", e);
                this.f2980s.e = new Loader$UnexpectedLoaderException(e);
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
        Loader$c loader$cO = loader$b.o(this.k, jElapsedRealtime, j, iOException, i3);
        int i4 = loader$cO.a;
        if (i4 == 3) {
            this.f2980s.e = this.n;
        } else if (i4 != 2) {
            if (i4 == 1) {
                this.o = 1;
            }
            long jMin = loader$cO.f2979b;
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
                d.f(simpleName.length() != 0 ? "load:".concat(simpleName) : new String("load:"));
                try {
                    ((e0$a) this.k).b();
                    d.d0();
                } catch (Throwable th) {
                    d.d0();
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
            q.b("LoadTask", "OutOfMemory error loading stream", e2);
            obtainMessage(2, new Loader$UnexpectedLoaderException(e2)).sendToTarget();
        } catch (Error e3) {
            if (!this.r) {
                q.b("LoadTask", "Unexpected error loading stream", e3);
                obtainMessage(3, e3).sendToTarget();
            }
            throw e3;
        } catch (Exception e4) {
            if (this.r) {
                return;
            }
            q.b("LoadTask", "Unexpected exception loading stream", e4);
            obtainMessage(2, new Loader$UnexpectedLoaderException(e4)).sendToTarget();
        }
    }
}
