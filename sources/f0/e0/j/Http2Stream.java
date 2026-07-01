package f0.e0.j;

import b.d.b.a.outline;
import com.discord.api.permission.Permission;
import d0.z.d.Intrinsics3;
import f0.e0.Util7;
import f0.e0.f.TaskQueue2;
import g0.AsyncTimeout;
import g0.Buffer3;
import g0.Sink;
import g0.Source2;
import g0.Timeout2;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Objects;
import kotlin.TypeCastException;
import okhttp3.Headers;
import okhttp3.internal.http2.StreamResetException;

/* JADX INFO: renamed from: f0.e0.j.n, reason: use source file name */
/* JADX INFO: compiled from: Http2Stream.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Http2Stream {
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3644b;
    public long c;
    public long d;
    public final ArrayDeque<Headers> e;
    public boolean f;
    public final b g;
    public final a h;
    public final c i;
    public final c j;
    public ErrorCode2 k;
    public IOException l;
    public final int m;
    public final Http2Connection n;

    /* JADX INFO: renamed from: f0.e0.j.n$a */
    /* JADX INFO: compiled from: Http2Stream.kt */
    public final class a implements Sink {
        public final Buffer3 j = new Buffer3();
        public boolean k;
        public boolean l;

        public a(boolean z2) {
            this.l = z2;
        }

        public final void a(boolean z2) throws IOException {
            long jMin;
            boolean z3;
            synchronized (Http2Stream.this) {
                Http2Stream.this.j.i();
                while (true) {
                    try {
                        Http2Stream http2Stream = Http2Stream.this;
                        if (http2Stream.c < http2Stream.d || this.l || this.k || http2Stream.f() != null) {
                            break;
                        } else {
                            Http2Stream.this.l();
                        }
                    } catch (Throwable th) {
                        Http2Stream.this.j.m();
                        throw th;
                    }
                }
                Http2Stream.this.j.m();
                Http2Stream.this.b();
                Http2Stream http2Stream2 = Http2Stream.this;
                jMin = Math.min(http2Stream2.d - http2Stream2.c, this.j.k);
                Http2Stream http2Stream3 = Http2Stream.this;
                http2Stream3.c += jMin;
                z3 = z2 && jMin == this.j.k && http2Stream3.f() == null;
            }
            Http2Stream.this.j.i();
            try {
                Http2Stream http2Stream4 = Http2Stream.this;
                http2Stream4.n.n(http2Stream4.m, z3, this.j, jMin);
            } finally {
                Http2Stream.this.j.m();
            }
        }

        @Override // g0.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            byte[] bArr = Util7.a;
            synchronized (http2Stream) {
                if (this.k) {
                    return;
                }
                boolean z2 = Http2Stream.this.f() == null;
                Http2Stream http2Stream2 = Http2Stream.this;
                if (!http2Stream2.h.l) {
                    if (this.j.k > 0) {
                        while (this.j.k > 0) {
                            a(true);
                        }
                    } else if (z2) {
                        http2Stream2.n.n(http2Stream2.m, true, null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.k = true;
                }
                Http2Stream.this.n.K.flush();
                Http2Stream.this.a();
            }
        }

        @Override // g0.Sink, java.io.Flushable
        public void flush() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            byte[] bArr = Util7.a;
            synchronized (http2Stream) {
                Http2Stream.this.b();
            }
            while (this.j.k > 0) {
                a(false);
                Http2Stream.this.n.K.flush();
            }
        }

        @Override // g0.Sink
        public Timeout2 timeout() {
            return Http2Stream.this.j;
        }

        @Override // g0.Sink
        public void write(Buffer3 buffer3, long j) throws IOException {
            Intrinsics3.checkParameterIsNotNull(buffer3, "source");
            byte[] bArr = Util7.a;
            this.j.write(buffer3, j);
            while (this.j.k >= Permission.EMBED_LINKS) {
                a(false);
            }
        }
    }

    /* JADX INFO: renamed from: f0.e0.j.n$b */
    /* JADX INFO: compiled from: Http2Stream.kt */
    public final class b implements Source2 {
        public final Buffer3 j = new Buffer3();
        public final Buffer3 k = new Buffer3();
        public boolean l;
        public final long m;
        public boolean n;

        public b(long j, boolean z2) {
            this.m = j;
            this.n = z2;
        }

        public final void a(long j) {
            Http2Stream http2Stream = Http2Stream.this;
            byte[] bArr = Util7.a;
            http2Stream.n.f(j);
        }

        @Override // g0.Source2, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long j;
            synchronized (Http2Stream.this) {
                this.l = true;
                Buffer3 buffer3 = this.k;
                j = buffer3.k;
                buffer3.skip(j);
                Http2Stream http2Stream = Http2Stream.this;
                if (http2Stream == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                }
                http2Stream.notifyAll();
            }
            if (j > 0) {
                a(j);
            }
            Http2Stream.this.a();
        }

        @Override // g0.Source2
        public long i0(Buffer3 buffer3, long j) throws Throwable {
            long jI0;
            boolean z2;
            long j2;
            Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
            long j3 = 0;
            if (!(j >= 0)) {
                throw new IllegalArgumentException(outline.t("byteCount < 0: ", j).toString());
            }
            while (true) {
                Throwable streamResetException = null;
                synchronized (Http2Stream.this) {
                    Http2Stream.this.i.i();
                    try {
                        if (Http2Stream.this.f() != null && (streamResetException = Http2Stream.this.l) == null) {
                            ErrorCode2 errorCode2F = Http2Stream.this.f();
                            if (errorCode2F == null) {
                                Intrinsics3.throwNpe();
                            }
                            streamResetException = new StreamResetException(errorCode2F);
                        }
                        if (this.l) {
                            throw new IOException("stream closed");
                        }
                        Buffer3 buffer4 = this.k;
                        long j4 = buffer4.k;
                        if (j4 > j3) {
                            jI0 = buffer4.i0(buffer3, Math.min(j, j4));
                            Http2Stream http2Stream = Http2Stream.this;
                            long j5 = http2Stream.a + jI0;
                            http2Stream.a = j5;
                            long j6 = j5 - http2Stream.f3644b;
                            if (streamResetException == null && j6 >= http2Stream.n.D.a() / 2) {
                                Http2Stream http2Stream2 = Http2Stream.this;
                                http2Stream2.n.t(http2Stream2.m, j6);
                                Http2Stream http2Stream3 = Http2Stream.this;
                                http2Stream3.f3644b = http2Stream3.a;
                            }
                        } else {
                            if (this.n || streamResetException != null) {
                                jI0 = -1;
                            } else {
                                Http2Stream.this.l();
                                z2 = true;
                                j2 = -1;
                            }
                            Http2Stream.this.i.m();
                        }
                        j2 = jI0;
                        z2 = false;
                        Http2Stream.this.i.m();
                    } catch (Throwable th) {
                        Http2Stream.this.i.m();
                        throw th;
                    }
                }
                if (!z2) {
                    if (j2 != -1) {
                        a(j2);
                        return j2;
                    }
                    if (streamResetException == null) {
                        return -1L;
                    }
                    throw streamResetException;
                }
                j3 = 0;
            }
        }

        @Override // g0.Source2
        public Timeout2 timeout() {
            return Http2Stream.this.i;
        }
    }

    /* JADX INFO: renamed from: f0.e0.j.n$c */
    /* JADX INFO: compiled from: Http2Stream.kt */
    public final class c extends AsyncTimeout {
        public c() {
        }

        @Override // g0.AsyncTimeout
        public IOException k(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // g0.AsyncTimeout
        public void l() {
            Http2Stream.this.e(ErrorCode2.CANCEL);
            Http2Connection http2Connection = Http2Stream.this.n;
            synchronized (http2Connection) {
                long j = http2Connection.A;
                long j2 = http2Connection.f3641z;
                if (j < j2) {
                    return;
                }
                http2Connection.f3641z = j2 + 1;
                http2Connection.C = System.nanoTime() + ((long) 1000000000);
                TaskQueue2 taskQueue2 = http2Connection.t;
                String strJ = outline.J(new StringBuilder(), http2Connection.o, " ping");
                taskQueue2.c(new TaskQueue8(strJ, true, strJ, true, http2Connection), 0L);
            }
        }

        public final void m() throws IOException {
            if (j()) {
                throw new SocketTimeoutException("timeout");
            }
        }
    }

    public Http2Stream(int i, Http2Connection http2Connection, boolean z2, boolean z3, Headers headers) {
        Intrinsics3.checkParameterIsNotNull(http2Connection, "connection");
        this.m = i;
        this.n = http2Connection;
        this.d = http2Connection.E.a();
        ArrayDeque<Headers> arrayDeque = new ArrayDeque<>();
        this.e = arrayDeque;
        this.g = new b(http2Connection.D.a(), z3);
        this.h = new a(z2);
        this.i = new c();
        this.j = new c();
        if (headers == null) {
            if (!h()) {
                throw new IllegalStateException("remotely-initiated streams should have headers".toString());
            }
        } else {
            if (!(!h())) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            }
            arrayDeque.add(headers);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0019  */
    public final void a() throws IOException {
        boolean z2;
        boolean zI;
        byte[] bArr = Util7.a;
        synchronized (this) {
            b bVar = this.g;
            if (bVar.n || !bVar.l) {
                z2 = false;
            } else {
                a aVar = this.h;
                if (aVar.l || aVar.k) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            zI = i();
        }
        if (z2) {
            c(ErrorCode2.CANCEL, null);
        } else {
            if (zI) {
                return;
            }
            this.n.d(this.m);
        }
    }

    public final void b() throws IOException {
        a aVar = this.h;
        if (aVar.k) {
            throw new IOException("stream closed");
        }
        if (aVar.l) {
            throw new IOException("stream finished");
        }
        if (this.k != null) {
            IOException iOException = this.l;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode2 errorCode2 = this.k;
            if (errorCode2 == null) {
                Intrinsics3.throwNpe();
            }
            throw new StreamResetException(errorCode2);
        }
    }

    public final void c(ErrorCode2 errorCode2, IOException iOException) throws IOException {
        Intrinsics3.checkParameterIsNotNull(errorCode2, "rstStatusCode");
        if (d(errorCode2, iOException)) {
            Http2Connection http2Connection = this.n;
            int i = this.m;
            Objects.requireNonNull(http2Connection);
            Intrinsics3.checkParameterIsNotNull(errorCode2, "statusCode");
            http2Connection.K.n(i, errorCode2);
        }
    }

    public final boolean d(ErrorCode2 errorCode2, IOException iOException) {
        byte[] bArr = Util7.a;
        synchronized (this) {
            if (this.k != null) {
                return false;
            }
            if (this.g.n && this.h.l) {
                return false;
            }
            this.k = errorCode2;
            this.l = iOException;
            notifyAll();
            this.n.d(this.m);
            return true;
        }
    }

    public final void e(ErrorCode2 errorCode2) {
        Intrinsics3.checkParameterIsNotNull(errorCode2, "errorCode");
        if (d(errorCode2, null)) {
            this.n.s(this.m, errorCode2);
        }
    }

    public final synchronized ErrorCode2 f() {
        return this.k;
    }

    public final Sink g() {
        synchronized (this) {
            if (!(this.f || h())) {
                throw new IllegalStateException("reply before requesting the sink".toString());
            }
        }
        return this.h;
    }

    public final boolean h() {
        return this.n.l == ((this.m & 1) == 1);
    }

    public final synchronized boolean i() {
        if (this.k != null) {
            return false;
        }
        b bVar = this.g;
        if (bVar.n || bVar.l) {
            a aVar = this.h;
            if ((aVar.l || aVar.k) && this.f) {
                return false;
            }
        }
        return true;
    }

    public final void j(Headers headers, boolean z2) {
        boolean zI;
        Intrinsics3.checkParameterIsNotNull(headers, "headers");
        byte[] bArr = Util7.a;
        synchronized (this) {
            if (this.f && z2) {
                Objects.requireNonNull(this.g);
            } else {
                this.f = true;
                this.e.add(headers);
            }
            if (z2) {
                this.g.n = true;
            }
            zI = i();
            notifyAll();
        }
        if (zI) {
            return;
        }
        this.n.d(this.m);
    }

    public final synchronized void k(ErrorCode2 errorCode2) {
        Intrinsics3.checkParameterIsNotNull(errorCode2, "errorCode");
        if (this.k == null) {
            this.k = errorCode2;
            notifyAll();
        }
    }

    public final void l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }
}
