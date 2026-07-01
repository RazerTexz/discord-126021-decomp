package f0.e0.g;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import f0.EventListener;
import f0.e0.h.ExchangeCodec;
import f0.e0.j.ErrorCode2;
import f0.e0.n.RealWebSocket;
import g0.Buffer3;
import g0.BufferedSource;
import g0.ForwardingSink;
import g0.ForwardingSource;
import g0.Sink;
import g0.Source2;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Objects;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;
import okio.BufferedSink;

/* JADX INFO: renamed from: f0.e0.g.c, reason: use source file name */
/* JADX INFO: compiled from: Exchange.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Exchange {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RealConnection4 f3614b;
    public final RealCall c;
    public final EventListener d;
    public final ExchangeFinder e;
    public final ExchangeCodec f;

    /* JADX INFO: renamed from: f0.e0.g.c$a */
    /* JADX INFO: compiled from: Exchange.kt */
    public final class a extends ForwardingSink {
        public boolean j;
        public long k;
        public boolean l;
        public final long m;
        public final /* synthetic */ Exchange n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Exchange exchange, Sink sink, long j) {
            super(sink);
            Intrinsics3.checkParameterIsNotNull(sink, "delegate");
            this.n = exchange;
            this.m = j;
        }

        public final <E extends IOException> E a(E e) {
            if (this.j) {
                return e;
            }
            this.j = true;
            return (E) this.n.a(this.k, false, true, e);
        }

        @Override // g0.ForwardingSink, g0.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.l) {
                return;
            }
            this.l = true;
            long j = this.m;
            if (j != -1 && this.k != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                a(null);
            } catch (IOException e) {
                throw a(e);
            }
        }

        @Override // g0.ForwardingSink, g0.Sink, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw a(e);
            }
        }

        @Override // g0.ForwardingSink, g0.Sink
        public void write(Buffer3 buffer3, long j) throws IOException {
            Intrinsics3.checkParameterIsNotNull(buffer3, "source");
            if (!(!this.l)) {
                throw new IllegalStateException("closed".toString());
            }
            long j2 = this.m;
            if (j2 == -1 || this.k + j <= j2) {
                try {
                    super.write(buffer3, j);
                    this.k += j;
                    return;
                } catch (IOException e) {
                    throw a(e);
                }
            }
            StringBuilder sbU = outline.U("expected ");
            sbU.append(this.m);
            sbU.append(" bytes but received ");
            sbU.append(this.k + j);
            throw new ProtocolException(sbU.toString());
        }
    }

    /* JADX INFO: renamed from: f0.e0.g.c$b */
    /* JADX INFO: compiled from: Exchange.kt */
    public final class b extends ForwardingSource {
        public long k;
        public boolean l;
        public boolean m;
        public boolean n;
        public final long o;
        public final /* synthetic */ Exchange p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Exchange exchange, Source2 source2, long j) {
            super(source2);
            Intrinsics3.checkParameterIsNotNull(source2, "delegate");
            this.p = exchange;
            this.o = j;
            this.l = true;
            if (j == 0) {
                a(null);
            }
        }

        public final <E extends IOException> E a(E e) {
            if (this.m) {
                return e;
            }
            this.m = true;
            if (e == null && this.l) {
                this.l = false;
                Exchange exchange = this.p;
                EventListener eventListener = exchange.d;
                RealCall realCall = exchange.c;
                Objects.requireNonNull(eventListener);
                Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
            }
            return (E) this.p.a(this.k, true, false, e);
        }

        @Override // g0.ForwardingSource, g0.Source2, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.n) {
                return;
            }
            this.n = true;
            try {
                this.j.close();
                a(null);
            } catch (IOException e) {
                throw a(e);
            }
        }

        @Override // g0.Source2
        public long i0(Buffer3 buffer3, long j) throws IOException {
            Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
            if (!(!this.n)) {
                throw new IllegalStateException("closed".toString());
            }
            try {
                long jI0 = this.j.i0(buffer3, j);
                if (this.l) {
                    this.l = false;
                    Exchange exchange = this.p;
                    EventListener eventListener = exchange.d;
                    RealCall realCall = exchange.c;
                    Objects.requireNonNull(eventListener);
                    Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
                }
                if (jI0 == -1) {
                    a(null);
                    return -1L;
                }
                long j2 = this.k + jI0;
                long j3 = this.o;
                if (j3 != -1 && j2 > j3) {
                    throw new ProtocolException("expected " + this.o + " bytes but received " + j2);
                }
                this.k = j2;
                if (j2 == j3) {
                    a(null);
                }
                return jI0;
            } catch (IOException e) {
                throw a(e);
            }
        }
    }

    public Exchange(RealCall realCall, EventListener eventListener, ExchangeFinder exchangeFinder, ExchangeCodec exchangeCodec) {
        Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(eventListener, "eventListener");
        Intrinsics3.checkParameterIsNotNull(exchangeFinder, "finder");
        Intrinsics3.checkParameterIsNotNull(exchangeCodec, "codec");
        this.c = realCall;
        this.d = eventListener;
        this.e = exchangeFinder;
        this.f = exchangeCodec;
        this.f3614b = exchangeCodec.e();
    }

    public final <E extends IOException> E a(long j, boolean z2, boolean z3, E e) {
        if (e != null) {
            g(e);
        }
        if (z3) {
            if (e != null) {
                EventListener eventListener = this.d;
                RealCall realCall = this.c;
                Objects.requireNonNull(eventListener);
                Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
                Intrinsics3.checkParameterIsNotNull(e, "ioe");
            } else {
                EventListener eventListener2 = this.d;
                RealCall realCall2 = this.c;
                Objects.requireNonNull(eventListener2);
                Intrinsics3.checkParameterIsNotNull(realCall2, NotificationCompat.CATEGORY_CALL);
            }
        }
        if (z2) {
            if (e != null) {
                EventListener eventListener3 = this.d;
                RealCall realCall3 = this.c;
                Objects.requireNonNull(eventListener3);
                Intrinsics3.checkParameterIsNotNull(realCall3, NotificationCompat.CATEGORY_CALL);
                Intrinsics3.checkParameterIsNotNull(e, "ioe");
            } else {
                EventListener eventListener4 = this.d;
                RealCall realCall4 = this.c;
                Objects.requireNonNull(eventListener4);
                Intrinsics3.checkParameterIsNotNull(realCall4, NotificationCompat.CATEGORY_CALL);
            }
        }
        return (E) this.c.k(this, z3, z2, e);
    }

    public final Sink b(Request request, boolean z2) throws IOException {
        Intrinsics3.checkParameterIsNotNull(request, "request");
        this.a = z2;
        RequestBody requestBody = request.body;
        if (requestBody == null) {
            Intrinsics3.throwNpe();
        }
        long jContentLength = requestBody.contentLength();
        EventListener eventListener = this.d;
        RealCall realCall = this.c;
        Objects.requireNonNull(eventListener);
        Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
        return new a(this, this.f.h(request, jContentLength), jContentLength);
    }

    public final void c() throws IOException {
        try {
            this.f.f();
        } catch (IOException e) {
            EventListener eventListener = this.d;
            RealCall realCall = this.c;
            Objects.requireNonNull(eventListener);
            Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
            Intrinsics3.checkParameterIsNotNull(e, "ioe");
            g(e);
            throw e;
        }
    }

    public final RealWebSocket.c d() throws SocketException {
        this.c.n();
        RealConnection4 realConnection4E = this.f.e();
        Objects.requireNonNull(realConnection4E);
        Intrinsics3.checkParameterIsNotNull(this, "exchange");
        Socket socket = realConnection4E.c;
        if (socket == null) {
            Intrinsics3.throwNpe();
        }
        BufferedSource bufferedSource = realConnection4E.g;
        if (bufferedSource == null) {
            Intrinsics3.throwNpe();
        }
        BufferedSink bufferedSink = realConnection4E.h;
        if (bufferedSink == null) {
            Intrinsics3.throwNpe();
        }
        socket.setSoTimeout(0);
        realConnection4E.l();
        return new RealConnection3(this, bufferedSource, bufferedSink, true, bufferedSource, bufferedSink);
    }

    public final Response.a e(boolean z2) throws IOException {
        try {
            Response.a aVarD = this.f.d(z2);
            if (aVarD != null) {
                Intrinsics3.checkParameterIsNotNull(this, "deferredTrailers");
                aVarD.m = this;
            }
            return aVarD;
        } catch (IOException e) {
            EventListener eventListener = this.d;
            RealCall realCall = this.c;
            Objects.requireNonNull(eventListener);
            Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
            Intrinsics3.checkParameterIsNotNull(e, "ioe");
            g(e);
            throw e;
        }
    }

    public final void f() {
        EventListener eventListener = this.d;
        RealCall realCall = this.c;
        Objects.requireNonNull(eventListener);
        Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
    }

    public final void g(IOException iOException) {
        this.e.c(iOException);
        RealConnection4 realConnection4E = this.f.e();
        RealCall realCall = this.c;
        synchronized (realConnection4E) {
            Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
            if (iOException instanceof StreamResetException) {
                if (((StreamResetException) iOException).errorCode == ErrorCode2.REFUSED_STREAM) {
                    int i = realConnection4E.m + 1;
                    realConnection4E.m = i;
                    if (i > 1) {
                        realConnection4E.i = true;
                        realConnection4E.k++;
                    }
                } else if (((StreamResetException) iOException).errorCode != ErrorCode2.CANCEL || !realCall.v) {
                    realConnection4E.i = true;
                    realConnection4E.k++;
                }
            } else if (!realConnection4E.j() || (iOException instanceof ConnectionShutdownException)) {
                realConnection4E.i = true;
                if (realConnection4E.l == 0) {
                    realConnection4E.d(realCall.f3618y, realConnection4E.q, iOException);
                    realConnection4E.k++;
                }
            }
        }
    }
}
