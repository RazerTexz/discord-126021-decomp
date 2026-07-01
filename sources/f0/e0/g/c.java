package f0.e0.g;

import androidx.core.app.NotificationCompat;
import f0.e0.n.d$c;
import f0.t;
import g0.v;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Objects;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response$a;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;
import okio.BufferedSink;

/* JADX INFO: compiled from: Exchange.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f3614b;
    public final e c;
    public final t d;
    public final d e;
    public final f0.e0.h.d f;

    public c(e eVar, t tVar, d dVar, f0.e0.h.d dVar2) {
        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        d0.z.d.m.checkParameterIsNotNull(tVar, "eventListener");
        d0.z.d.m.checkParameterIsNotNull(dVar, "finder");
        d0.z.d.m.checkParameterIsNotNull(dVar2, "codec");
        this.c = eVar;
        this.d = tVar;
        this.e = dVar;
        this.f = dVar2;
        this.f3614b = dVar2.e();
    }

    public final <E extends IOException> E a(long j, boolean z2, boolean z3, E e) {
        if (e != null) {
            g(e);
        }
        if (z3) {
            if (e != null) {
                t tVar = this.d;
                e eVar = this.c;
                Objects.requireNonNull(tVar);
                d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
                d0.z.d.m.checkParameterIsNotNull(e, "ioe");
            } else {
                t tVar2 = this.d;
                e eVar2 = this.c;
                Objects.requireNonNull(tVar2);
                d0.z.d.m.checkParameterIsNotNull(eVar2, NotificationCompat.CATEGORY_CALL);
            }
        }
        if (z2) {
            if (e != null) {
                t tVar3 = this.d;
                e eVar3 = this.c;
                Objects.requireNonNull(tVar3);
                d0.z.d.m.checkParameterIsNotNull(eVar3, NotificationCompat.CATEGORY_CALL);
                d0.z.d.m.checkParameterIsNotNull(e, "ioe");
            } else {
                t tVar4 = this.d;
                e eVar4 = this.c;
                Objects.requireNonNull(tVar4);
                d0.z.d.m.checkParameterIsNotNull(eVar4, NotificationCompat.CATEGORY_CALL);
            }
        }
        return (E) this.c.k(this, z3, z2, e);
    }

    public final v b(Request request, boolean z2) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(request, "request");
        this.a = z2;
        RequestBody requestBody = request.body;
        if (requestBody == null) {
            d0.z.d.m.throwNpe();
        }
        long jContentLength = requestBody.contentLength();
        t tVar = this.d;
        e eVar = this.c;
        Objects.requireNonNull(tVar);
        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        return new c$a(this, this.f.h(request, jContentLength), jContentLength);
    }

    public final void c() throws IOException {
        try {
            this.f.f();
        } catch (IOException e) {
            t tVar = this.d;
            e eVar = this.c;
            Objects.requireNonNull(tVar);
            d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
            d0.z.d.m.checkParameterIsNotNull(e, "ioe");
            g(e);
            throw e;
        }
    }

    public final d$c d() throws SocketException {
        this.c.n();
        j jVarE = this.f.e();
        Objects.requireNonNull(jVarE);
        d0.z.d.m.checkParameterIsNotNull(this, "exchange");
        Socket socket = jVarE.c;
        if (socket == null) {
            d0.z.d.m.throwNpe();
        }
        g0.g gVar = jVarE.g;
        if (gVar == null) {
            d0.z.d.m.throwNpe();
        }
        BufferedSink bufferedSink = jVarE.h;
        if (bufferedSink == null) {
            d0.z.d.m.throwNpe();
        }
        socket.setSoTimeout(0);
        jVarE.l();
        return new i(this, gVar, bufferedSink, true, gVar, bufferedSink);
    }

    public final Response$a e(boolean z2) throws IOException {
        try {
            Response$a response$aD = this.f.d(z2);
            if (response$aD != null) {
                d0.z.d.m.checkParameterIsNotNull(this, "deferredTrailers");
                response$aD.m = this;
            }
            return response$aD;
        } catch (IOException e) {
            t tVar = this.d;
            e eVar = this.c;
            Objects.requireNonNull(tVar);
            d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
            d0.z.d.m.checkParameterIsNotNull(e, "ioe");
            g(e);
            throw e;
        }
    }

    public final void f() {
        t tVar = this.d;
        e eVar = this.c;
        Objects.requireNonNull(tVar);
        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
    }

    public final void g(IOException iOException) {
        this.e.c(iOException);
        j jVarE = this.f.e();
        e eVar = this.c;
        synchronized (jVarE) {
            d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
            if (iOException instanceof StreamResetException) {
                if (((StreamResetException) iOException).errorCode == f0.e0.j.a.REFUSED_STREAM) {
                    int i = jVarE.m + 1;
                    jVarE.m = i;
                    if (i > 1) {
                        jVarE.i = true;
                        jVarE.k++;
                    }
                } else if (((StreamResetException) iOException).errorCode != f0.e0.j.a.CANCEL || !eVar.v) {
                    jVarE.i = true;
                    jVarE.k++;
                }
            } else if (!jVarE.j() || (iOException instanceof ConnectionShutdownException)) {
                jVarE.i = true;
                if (jVarE.l == 0) {
                    jVarE.d(eVar.f3618y, jVarE.q, iOException);
                    jVarE.k++;
                }
            }
        }
    }
}
