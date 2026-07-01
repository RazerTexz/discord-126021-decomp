package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import b.i.a.c.a3.t;
import b.i.a.c.e3.s;
import b.i.a.c.e3.w;
import b.i.a.c.f3.q;
import b.i.a.c.w2.a0$a;
import b.i.a.c.w2.a0$d;
import b.i.a.c.w2.d0;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource$CleartextNotPermittedException;
import com.google.android.exoplayer2.upstream.Loader$UnexpectedLoaderException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"HandlerLeak"})
public class DefaultDrmSession$c extends Handler {

    @GuardedBy("this")
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DefaultDrmSession f2927b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultDrmSession$c(DefaultDrmSession defaultDrmSession, Looper looper) {
        super(looper);
        this.f2927b = defaultDrmSession;
    }

    public void a(int i, Object obj, boolean z2) {
        obtainMessage(i, new DefaultDrmSession$d(t.a.getAndIncrement(), z2, SystemClock.elapsedRealtime(), obj)).sendToTarget();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004a  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c4  */
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        long jMin;
        boolean z2;
        Object objC;
        DefaultDrmSession$d defaultDrmSession$d = (DefaultDrmSession$d) message.obj;
        boolean z3 = true;
        try {
            int i = message.what;
            if (i == 0) {
                DefaultDrmSession defaultDrmSession = this.f2927b;
                objC = ((d0) defaultDrmSession.k).c(defaultDrmSession.l, (a0$d) defaultDrmSession$d.d);
            } else {
                if (i != 1) {
                    throw new RuntimeException();
                }
                DefaultDrmSession defaultDrmSession2 = this.f2927b;
                objC = ((d0) defaultDrmSession2.k).a(defaultDrmSession2.l, (a0$a) defaultDrmSession$d.d);
            }
        } catch (MediaDrmCallbackException e) {
            DefaultDrmSession$d defaultDrmSession$d2 = (DefaultDrmSession$d) message.obj;
            if (defaultDrmSession$d2.f2928b) {
                int i2 = defaultDrmSession$d2.e + 1;
                defaultDrmSession$d2.e = i2;
                if (i2 > ((s) this.f2927b.j).a(3)) {
                    z3 = false;
                } else {
                    SystemClock.elapsedRealtime();
                    SystemClock.elapsedRealtime();
                    Throwable defaultDrmSession$UnexpectedDrmSessionException = e.getCause() instanceof IOException ? (IOException) e.getCause() : new DefaultDrmSession$UnexpectedDrmSessionException(e.getCause());
                    w wVar = this.f2927b.j;
                    int i3 = defaultDrmSession$d2.e;
                    if ((defaultDrmSession$UnexpectedDrmSessionException instanceof ParserException) || (defaultDrmSession$UnexpectedDrmSessionException instanceof FileNotFoundException) || (defaultDrmSession$UnexpectedDrmSessionException instanceof HttpDataSource$CleartextNotPermittedException) || (defaultDrmSession$UnexpectedDrmSessionException instanceof Loader$UnexpectedLoaderException)) {
                        jMin = -9223372036854775807L;
                    } else {
                        int i4 = DataSourceException.j;
                        while (true) {
                            if (defaultDrmSession$UnexpectedDrmSessionException == null) {
                                z2 = false;
                                break;
                            } else {
                                if ((defaultDrmSession$UnexpectedDrmSessionException instanceof DataSourceException) && ((DataSourceException) defaultDrmSession$UnexpectedDrmSessionException).reason == 2008) {
                                    z2 = true;
                                    break;
                                }
                                defaultDrmSession$UnexpectedDrmSessionException = defaultDrmSession$UnexpectedDrmSessionException.getCause();
                            }
                        }
                        if (z2) {
                            jMin = -9223372036854775807L;
                        } else {
                            jMin = Math.min((i3 - 1) * 1000, 5000);
                        }
                    }
                    if (jMin == -9223372036854775807L) {
                        z3 = false;
                    } else {
                        synchronized (this) {
                            if (this.a) {
                                z3 = false;
                            } else {
                                sendMessageDelayed(Message.obtain(message), jMin);
                            }
                        }
                    }
                }
            } else {
                z3 = false;
            }
            if (z3) {
                return;
            } else {
                objC = e;
            }
        } catch (Exception e2) {
            q.c("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e2);
            objC = e2;
        }
        w wVar2 = this.f2927b.j;
        long j = defaultDrmSession$d.a;
        Objects.requireNonNull(wVar2);
        synchronized (this) {
            if (!this.a) {
                this.f2927b.m.obtainMessage(message.what, Pair.create(defaultDrmSession$d.d, objC)).sendToTarget();
            }
        }
    }
}
