package f0.e0.i;

import b.d.b.a.outline;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import f0.CookieJar2;
import f0.HttpUrl;
import f0.OkHttpClient;
import f0.e0.Util7;
import f0.e0.g.RealConnection4;
import f0.e0.h.ExchangeCodec;
import f0.e0.h.HttpHeaders;
import f0.e0.h.StatusLine;
import g0.Buffer3;
import g0.BufferedSource;
import g0.ForwardingTimeout;
import g0.Sink;
import g0.Source2;
import g0.Timeout2;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

/* JADX INFO: renamed from: f0.e0.i.b, reason: use source file name */
/* JADX INFO: compiled from: Http1ExchangeCodec.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Http1ExchangeCodec implements ExchangeCodec {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HeadersReader f3632b;
    public Headers c;
    public final OkHttpClient d;
    public final RealConnection4 e;
    public final BufferedSource f;
    public final BufferedSink g;

    /* JADX INFO: renamed from: f0.e0.i.b$a */
    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    public abstract class a implements Source2 {
        public final ForwardingTimeout j;
        public boolean k;

        public a() {
            this.j = new ForwardingTimeout(Http1ExchangeCodec.this.f.timeout());
        }

        public final void a() {
            Http1ExchangeCodec http1ExchangeCodec = Http1ExchangeCodec.this;
            int i = http1ExchangeCodec.a;
            if (i == 6) {
                return;
            }
            if (i == 5) {
                Http1ExchangeCodec.i(http1ExchangeCodec, this.j);
                Http1ExchangeCodec.this.a = 6;
            } else {
                StringBuilder sbU = outline.U("state: ");
                sbU.append(Http1ExchangeCodec.this.a);
                throw new IllegalStateException(sbU.toString());
            }
        }

        @Override // g0.Source2
        public long i0(Buffer3 buffer3, long j) throws IOException {
            Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
            try {
                return Http1ExchangeCodec.this.f.i0(buffer3, j);
            } catch (IOException e) {
                Http1ExchangeCodec.this.e.l();
                a();
                throw e;
            }
        }

        @Override // g0.Source2
        public Timeout2 timeout() {
            return this.j;
        }
    }

    /* JADX INFO: renamed from: f0.e0.i.b$b */
    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    public final class b implements Sink {
        public final ForwardingTimeout j;
        public boolean k;

        public b() {
            this.j = new ForwardingTimeout(Http1ExchangeCodec.this.g.timeout());
        }

        @Override // g0.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.k) {
                return;
            }
            this.k = true;
            Http1ExchangeCodec.this.g.K("0\r\n\r\n");
            Http1ExchangeCodec.i(Http1ExchangeCodec.this, this.j);
            Http1ExchangeCodec.this.a = 3;
        }

        @Override // g0.Sink, java.io.Flushable
        public synchronized void flush() {
            if (this.k) {
                return;
            }
            Http1ExchangeCodec.this.g.flush();
        }

        @Override // g0.Sink
        public Timeout2 timeout() {
            return this.j;
        }

        @Override // g0.Sink
        public void write(Buffer3 buffer3, long j) throws IOException {
            Intrinsics3.checkParameterIsNotNull(buffer3, "source");
            if (!(!this.k)) {
                throw new IllegalStateException("closed".toString());
            }
            if (j == 0) {
                return;
            }
            Http1ExchangeCodec.this.g.Q(j);
            Http1ExchangeCodec.this.g.K("\r\n");
            Http1ExchangeCodec.this.g.write(buffer3, j);
            Http1ExchangeCodec.this.g.K("\r\n");
        }
    }

    /* JADX INFO: renamed from: f0.e0.i.b$c */
    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    public final class c extends a {
        public long m;
        public boolean n;
        public final HttpUrl o;
        public final /* synthetic */ Http1ExchangeCodec p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Http1ExchangeCodec http1ExchangeCodec, HttpUrl httpUrl) {
            super();
            Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
            this.p = http1ExchangeCodec;
            this.o = httpUrl;
            this.m = -1L;
            this.n = true;
        }

        @Override // g0.Source2, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.k) {
                return;
            }
            if (this.n && !Util7.i(this, 100, TimeUnit.MILLISECONDS)) {
                this.p.e.l();
                a();
            }
            this.k = true;
        }

        @Override // f0.e0.i.Http1ExchangeCodec.a, g0.Source2
        public long i0(Buffer3 buffer3, long j) throws IOException {
            Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
            boolean z2 = true;
            if (!(j >= 0)) {
                throw new IllegalArgumentException(outline.t("byteCount < 0: ", j).toString());
            }
            if (!(!this.k)) {
                throw new IllegalStateException("closed".toString());
            }
            if (!this.n) {
                return -1L;
            }
            long j2 = this.m;
            if (j2 == 0 || j2 == -1) {
                if (j2 != -1) {
                    this.p.f.Y();
                }
                try {
                    this.m = this.p.f.s0();
                    String strY = this.p.f.Y();
                    if (strY == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    String string = Strings4.trim(strY).toString();
                    if (this.m >= 0) {
                        if (string.length() <= 0) {
                            z2 = false;
                        }
                        if (!z2 || StringsJVM.startsWith$default(string, ";", false, 2, null)) {
                            if (this.m == 0) {
                                this.n = false;
                                Http1ExchangeCodec http1ExchangeCodec = this.p;
                                http1ExchangeCodec.c = http1ExchangeCodec.f3632b.a();
                                OkHttpClient okHttpClient = this.p.d;
                                if (okHttpClient == null) {
                                    Intrinsics3.throwNpe();
                                }
                                CookieJar2 cookieJar2 = okHttpClient.v;
                                HttpUrl httpUrl = this.o;
                                Headers headers = this.p.c;
                                if (headers == null) {
                                    Intrinsics3.throwNpe();
                                }
                                HttpHeaders.d(cookieJar2, httpUrl, headers);
                                a();
                            }
                            if (!this.n) {
                                return -1L;
                            }
                        }
                    }
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.m + string + '\"');
                } catch (NumberFormatException e) {
                    throw new ProtocolException(e.getMessage());
                }
            }
            long jI0 = super.i0(buffer3, Math.min(j, this.m));
            if (jI0 != -1) {
                this.m -= jI0;
                return jI0;
            }
            this.p.e.l();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            a();
            throw protocolException;
        }
    }

    /* JADX INFO: renamed from: f0.e0.i.b$d */
    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    public final class d extends a {
        public long m;

        public d(long j) {
            super();
            this.m = j;
            if (j == 0) {
                a();
            }
        }

        @Override // g0.Source2, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.k) {
                return;
            }
            if (this.m != 0 && !Util7.i(this, 100, TimeUnit.MILLISECONDS)) {
                Http1ExchangeCodec.this.e.l();
                a();
            }
            this.k = true;
        }

        @Override // f0.e0.i.Http1ExchangeCodec.a, g0.Source2
        public long i0(Buffer3 buffer3, long j) throws IOException {
            Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(outline.t("byteCount < 0: ", j).toString());
            }
            if (!(!this.k)) {
                throw new IllegalStateException("closed".toString());
            }
            long j2 = this.m;
            if (j2 == 0) {
                return -1L;
            }
            long jI0 = super.i0(buffer3, Math.min(j2, j));
            if (jI0 == -1) {
                Http1ExchangeCodec.this.e.l();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a();
                throw protocolException;
            }
            long j3 = this.m - jI0;
            this.m = j3;
            if (j3 == 0) {
                a();
            }
            return jI0;
        }
    }

    /* JADX INFO: renamed from: f0.e0.i.b$e */
    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    public final class e implements Sink {
        public final ForwardingTimeout j;
        public boolean k;

        public e() {
            this.j = new ForwardingTimeout(Http1ExchangeCodec.this.g.timeout());
        }

        @Override // g0.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.k) {
                return;
            }
            this.k = true;
            Http1ExchangeCodec.i(Http1ExchangeCodec.this, this.j);
            Http1ExchangeCodec.this.a = 3;
        }

        @Override // g0.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.k) {
                return;
            }
            Http1ExchangeCodec.this.g.flush();
        }

        @Override // g0.Sink
        public Timeout2 timeout() {
            return this.j;
        }

        @Override // g0.Sink
        public void write(Buffer3 buffer3, long j) throws IOException {
            Intrinsics3.checkParameterIsNotNull(buffer3, "source");
            if (!(!this.k)) {
                throw new IllegalStateException("closed".toString());
            }
            Util7.c(buffer3.k, 0L, j);
            Http1ExchangeCodec.this.g.write(buffer3, j);
        }
    }

    /* JADX INFO: renamed from: f0.e0.i.b$f */
    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    public final class f extends a {
        public boolean m;

        public f(Http1ExchangeCodec http1ExchangeCodec) {
            super();
        }

        @Override // g0.Source2, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.k) {
                return;
            }
            if (!this.m) {
                a();
            }
            this.k = true;
        }

        @Override // f0.e0.i.Http1ExchangeCodec.a, g0.Source2
        public long i0(Buffer3 buffer3, long j) throws IOException {
            Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(outline.t("byteCount < 0: ", j).toString());
            }
            if (!(!this.k)) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.m) {
                return -1L;
            }
            long jI0 = super.i0(buffer3, j);
            if (jI0 != -1) {
                return jI0;
            }
            this.m = true;
            a();
            return -1L;
        }
    }

    public Http1ExchangeCodec(OkHttpClient okHttpClient, RealConnection4 realConnection4, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        Intrinsics3.checkParameterIsNotNull(realConnection4, "connection");
        Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
        Intrinsics3.checkParameterIsNotNull(bufferedSink, "sink");
        this.d = okHttpClient;
        this.e = realConnection4;
        this.f = bufferedSource;
        this.g = bufferedSink;
        this.f3632b = new HeadersReader(bufferedSource);
    }

    public static final void i(Http1ExchangeCodec http1ExchangeCodec, ForwardingTimeout forwardingTimeout) {
        Objects.requireNonNull(http1ExchangeCodec);
        Timeout2 timeout2 = forwardingTimeout.e;
        Timeout2 timeout3 = Timeout2.a;
        Intrinsics3.checkParameterIsNotNull(timeout3, "delegate");
        forwardingTimeout.e = timeout3;
        timeout2.a();
        timeout2.b();
    }

    @Override // f0.e0.h.ExchangeCodec
    public void a() throws IOException {
        this.g.flush();
    }

    @Override // f0.e0.h.ExchangeCodec
    public void b(Request request) {
        Intrinsics3.checkParameterIsNotNull(request, "request");
        Proxy.Type type = this.e.q.f3603b.type();
        Intrinsics3.checkExpressionValueIsNotNull(type, "connection.route().proxy.type()");
        Intrinsics3.checkParameterIsNotNull(request, "request");
        Intrinsics3.checkParameterIsNotNull(type, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(request.method);
        sb.append(' ');
        HttpUrl httpUrl = request.url;
        if (!httpUrl.c && type == Proxy.Type.HTTP) {
            sb.append(httpUrl);
        } else {
            Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
            String strB = httpUrl.b();
            String strD = httpUrl.d();
            if (strD != null) {
                strB = strB + '?' + strD;
            }
            sb.append(strB);
        }
        sb.append(" HTTP/1.1");
        String string = sb.toString();
        Intrinsics3.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        k(request.headers, string);
    }

    @Override // f0.e0.h.ExchangeCodec
    public Source2 c(Response response) {
        Intrinsics3.checkParameterIsNotNull(response, "response");
        if (!HttpHeaders.a(response)) {
            return j(0L);
        }
        if (StringsJVM.equals("chunked", Response.a(response, "Transfer-Encoding", null, 2), true)) {
            HttpUrl httpUrl = response.request.url;
            if (this.a == 4) {
                this.a = 5;
                return new c(this, httpUrl);
            }
            StringBuilder sbU = outline.U("state: ");
            sbU.append(this.a);
            throw new IllegalStateException(sbU.toString().toString());
        }
        long jL = Util7.l(response);
        if (jL != -1) {
            return j(jL);
        }
        if (this.a == 4) {
            this.a = 5;
            this.e.l();
            return new f(this);
        }
        StringBuilder sbU2 = outline.U("state: ");
        sbU2.append(this.a);
        throw new IllegalStateException(sbU2.toString().toString());
    }

    @Override // f0.e0.h.ExchangeCodec
    public void cancel() {
        Socket socket = this.e.f3620b;
        if (socket != null) {
            Util7.e(socket);
        }
    }

    @Override // f0.e0.h.ExchangeCodec
    public Response.a d(boolean z2) {
        int i = this.a;
        boolean z3 = true;
        if (i != 1 && i != 3) {
            z3 = false;
        }
        if (!z3) {
            StringBuilder sbU = outline.U("state: ");
            sbU.append(this.a);
            throw new IllegalStateException(sbU.toString().toString());
        }
        try {
            StatusLine statusLineA = StatusLine.a(this.f3632b.b());
            Response.a aVar = new Response.a();
            aVar.f(statusLineA.a);
            aVar.c = statusLineA.f3630b;
            aVar.e(statusLineA.c);
            aVar.d(this.f3632b.a());
            if (z2 && statusLineA.f3630b == 100) {
                return null;
            }
            if (statusLineA.f3630b == 100) {
                this.a = 3;
                return aVar;
            }
            this.a = 4;
            return aVar;
        } catch (EOFException e2) {
            throw new IOException(outline.w("unexpected end of stream on ", this.e.q.a.a.h()), e2);
        }
    }

    @Override // f0.e0.h.ExchangeCodec
    public RealConnection4 e() {
        return this.e;
    }

    @Override // f0.e0.h.ExchangeCodec
    public void f() throws IOException {
        this.g.flush();
    }

    @Override // f0.e0.h.ExchangeCodec
    public long g(Response response) {
        Intrinsics3.checkParameterIsNotNull(response, "response");
        if (!HttpHeaders.a(response)) {
            return 0L;
        }
        if (StringsJVM.equals("chunked", Response.a(response, "Transfer-Encoding", null, 2), true)) {
            return -1L;
        }
        return Util7.l(response);
    }

    @Override // f0.e0.h.ExchangeCodec
    public Sink h(Request request, long j) throws ProtocolException {
        Intrinsics3.checkParameterIsNotNull(request, "request");
        RequestBody requestBody = request.body;
        if (requestBody != null && requestBody.isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (StringsJVM.equals("chunked", request.b("Transfer-Encoding"), true)) {
            if (this.a == 1) {
                this.a = 2;
                return new b();
            }
            StringBuilder sbU = outline.U("state: ");
            sbU.append(this.a);
            throw new IllegalStateException(sbU.toString().toString());
        }
        if (j == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        if (this.a == 1) {
            this.a = 2;
            return new e();
        }
        StringBuilder sbU2 = outline.U("state: ");
        sbU2.append(this.a);
        throw new IllegalStateException(sbU2.toString().toString());
    }

    public final Source2 j(long j) {
        if (this.a == 4) {
            this.a = 5;
            return new d(j);
        }
        StringBuilder sbU = outline.U("state: ");
        sbU.append(this.a);
        throw new IllegalStateException(sbU.toString().toString());
    }

    public final void k(Headers headers, String str) {
        Intrinsics3.checkParameterIsNotNull(headers, "headers");
        Intrinsics3.checkParameterIsNotNull(str, "requestLine");
        if (!(this.a == 0)) {
            StringBuilder sbU = outline.U("state: ");
            sbU.append(this.a);
            throw new IllegalStateException(sbU.toString().toString());
        }
        this.g.K(str).K("\r\n");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            this.g.K(headers.d(i)).K(": ").K(headers.g(i)).K("\r\n");
        }
        this.g.K("\r\n");
        this.a = 1;
    }
}
