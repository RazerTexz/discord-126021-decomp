package p600f0.p601e0.p607i;

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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12379w;
import p600f0.C12380x;
import p600f0.InterfaceC12372p;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p605g.C12290j;
import p600f0.p601e0.p606h.C12299e;
import p600f0.p601e0.p606h.C12304j;
import p600f0.p601e0.p606h.InterfaceC12298d;
import p615g0.C12388e;
import p615g0.C12394k;
import p615g0.C12408y;
import p615g0.InterfaceC12390g;
import p615g0.InterfaceC12405v;
import p615g0.InterfaceC12407x;

/* JADX INFO: renamed from: f0.e0.i.b */
/* JADX INFO: compiled from: Http1ExchangeCodec.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12306b implements InterfaceC12298d {

    /* JADX INFO: renamed from: a */
    public int f25549a;

    /* JADX INFO: renamed from: b */
    public final C12305a f25550b;

    /* JADX INFO: renamed from: c */
    public Headers f25551c;

    /* JADX INFO: renamed from: d */
    public final C12380x f25552d;

    /* JADX INFO: renamed from: e */
    public final C12290j f25553e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC12390g f25554f;

    /* JADX INFO: renamed from: g */
    public final BufferedSink f25555g;

    /* JADX INFO: renamed from: f0.e0.i.b$a */
    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    public abstract class a implements InterfaceC12407x {

        /* JADX INFO: renamed from: j */
        public final C12394k f25556j;

        /* JADX INFO: renamed from: k */
        public boolean f25557k;

        public a() {
            this.f25556j = new C12394k(C12306b.this.f25554f.timeout());
        }

        /* JADX INFO: renamed from: a */
        public final void m10240a() {
            C12306b c12306b = C12306b.this;
            int i = c12306b.f25549a;
            if (i == 6) {
                return;
            }
            if (i == 5) {
                C12306b.m10237i(c12306b, this.f25556j);
                C12306b.this.f25549a = 6;
            } else {
                StringBuilder sbM833U = C1643a.m833U("state: ");
                sbM833U.append(C12306b.this.f25549a);
                throw new IllegalStateException(sbM833U.toString());
            }
        }

        @Override // p615g0.InterfaceC12407x
        /* JADX INFO: renamed from: i0 */
        public long mo10176i0(C12388e c12388e, long j) throws IOException {
            C12238m.checkParameterIsNotNull(c12388e, "sink");
            try {
                return C12306b.this.f25554f.mo10176i0(c12388e, j);
            } catch (IOException e) {
                C12306b.this.f25553e.m10203l();
                m10240a();
                throw e;
            }
        }

        @Override // p615g0.InterfaceC12407x
        public C12408y timeout() {
            return this.f25556j;
        }
    }

    /* JADX INFO: renamed from: f0.e0.i.b$b */
    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    public final class b implements InterfaceC12405v {

        /* JADX INFO: renamed from: j */
        public final C12394k f25559j;

        /* JADX INFO: renamed from: k */
        public boolean f25560k;

        public b() {
            this.f25559j = new C12394k(C12306b.this.f25555g.timeout());
        }

        @Override // p615g0.InterfaceC12405v, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.f25560k) {
                return;
            }
            this.f25560k = true;
            C12306b.this.f25555g.mo10436K("0\r\n\r\n");
            C12306b.m10237i(C12306b.this, this.f25559j);
            C12306b.this.f25549a = 3;
        }

        @Override // p615g0.InterfaceC12405v, java.io.Flushable
        public synchronized void flush() {
            if (this.f25560k) {
                return;
            }
            C12306b.this.f25555g.flush();
        }

        @Override // p615g0.InterfaceC12405v
        public C12408y timeout() {
            return this.f25559j;
        }

        @Override // p615g0.InterfaceC12405v
        public void write(C12388e c12388e, long j) throws IOException {
            C12238m.checkParameterIsNotNull(c12388e, "source");
            if (!(!this.f25560k)) {
                throw new IllegalStateException("closed".toString());
            }
            if (j == 0) {
                return;
            }
            C12306b.this.f25555g.mo10441Q(j);
            C12306b.this.f25555g.mo10436K("\r\n");
            C12306b.this.f25555g.write(c12388e, j);
            C12306b.this.f25555g.mo10436K("\r\n");
        }
    }

    /* JADX INFO: renamed from: f0.e0.i.b$c */
    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    public final class c extends a {

        /* JADX INFO: renamed from: m */
        public long f25562m;

        /* JADX INFO: renamed from: n */
        public boolean f25563n;

        /* JADX INFO: renamed from: o */
        public final C12379w f25564o;

        /* JADX INFO: renamed from: p */
        public final /* synthetic */ C12306b f25565p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(C12306b c12306b, C12379w c12379w) {
            super();
            C12238m.checkParameterIsNotNull(c12379w, "url");
            this.f25565p = c12306b;
            this.f25564o = c12379w;
            this.f25562m = -1L;
            this.f25563n = true;
        }

        @Override // p615g0.InterfaceC12407x, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f25557k) {
                return;
            }
            if (this.f25563n && !C12272c.m10128i(this, 100, TimeUnit.MILLISECONDS)) {
                this.f25565p.f25553e.m10203l();
                m10240a();
            }
            this.f25557k = true;
        }

        @Override // p600f0.p601e0.p607i.C12306b.a, p615g0.InterfaceC12407x
        /* JADX INFO: renamed from: i0 */
        public long mo10176i0(C12388e c12388e, long j) throws IOException {
            C12238m.checkParameterIsNotNull(c12388e, "sink");
            boolean z2 = true;
            if (!(j >= 0)) {
                throw new IllegalArgumentException(C1643a.m877t("byteCount < 0: ", j).toString());
            }
            if (!(!this.f25557k)) {
                throw new IllegalStateException("closed".toString());
            }
            if (!this.f25563n) {
                return -1L;
            }
            long j2 = this.f25562m;
            if (j2 == 0 || j2 == -1) {
                if (j2 != -1) {
                    this.f25565p.f25554f.mo10449Y();
                }
                try {
                    this.f25562m = this.f25565p.f25554f.mo10467s0();
                    String strMo10449Y = this.f25565p.f25554f.mo10449Y();
                    if (strMo10449Y == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    String string = C12106w.trim(strMo10449Y).toString();
                    if (this.f25562m >= 0) {
                        if (string.length() <= 0) {
                            z2 = false;
                        }
                        if (!z2 || C12103t.startsWith$default(string, ";", false, 2, null)) {
                            if (this.f25562m == 0) {
                                this.f25563n = false;
                                C12306b c12306b = this.f25565p;
                                c12306b.f25551c = c12306b.f25550b.m10235a();
                                C12380x c12380x = this.f25565p.f25552d;
                                if (c12380x == null) {
                                    C12238m.throwNpe();
                                }
                                InterfaceC12372p interfaceC12372p = c12380x.f26021v;
                                C12379w c12379w = this.f25564o;
                                Headers headers = this.f25565p.f25551c;
                                if (headers == null) {
                                    C12238m.throwNpe();
                                }
                                C12299e.m10224d(interfaceC12372p, c12379w, headers);
                                m10240a();
                            }
                            if (!this.f25563n) {
                                return -1L;
                            }
                        }
                    }
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f25562m + string + '\"');
                } catch (NumberFormatException e) {
                    throw new ProtocolException(e.getMessage());
                }
            }
            long jMo10176i0 = super.mo10176i0(c12388e, Math.min(j, this.f25562m));
            if (jMo10176i0 != -1) {
                this.f25562m -= jMo10176i0;
                return jMo10176i0;
            }
            this.f25565p.f25553e.m10203l();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            m10240a();
            throw protocolException;
        }
    }

    /* JADX INFO: renamed from: f0.e0.i.b$d */
    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    public final class d extends a {

        /* JADX INFO: renamed from: m */
        public long f25566m;

        public d(long j) {
            super();
            this.f25566m = j;
            if (j == 0) {
                m10240a();
            }
        }

        @Override // p615g0.InterfaceC12407x, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f25557k) {
                return;
            }
            if (this.f25566m != 0 && !C12272c.m10128i(this, 100, TimeUnit.MILLISECONDS)) {
                C12306b.this.f25553e.m10203l();
                m10240a();
            }
            this.f25557k = true;
        }

        @Override // p600f0.p601e0.p607i.C12306b.a, p615g0.InterfaceC12407x
        /* JADX INFO: renamed from: i0 */
        public long mo10176i0(C12388e c12388e, long j) throws IOException {
            C12238m.checkParameterIsNotNull(c12388e, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(C1643a.m877t("byteCount < 0: ", j).toString());
            }
            if (!(!this.f25557k)) {
                throw new IllegalStateException("closed".toString());
            }
            long j2 = this.f25566m;
            if (j2 == 0) {
                return -1L;
            }
            long jMo10176i0 = super.mo10176i0(c12388e, Math.min(j2, j));
            if (jMo10176i0 == -1) {
                C12306b.this.f25553e.m10203l();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                m10240a();
                throw protocolException;
            }
            long j3 = this.f25566m - jMo10176i0;
            this.f25566m = j3;
            if (j3 == 0) {
                m10240a();
            }
            return jMo10176i0;
        }
    }

    /* JADX INFO: renamed from: f0.e0.i.b$e */
    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    public final class e implements InterfaceC12405v {

        /* JADX INFO: renamed from: j */
        public final C12394k f25568j;

        /* JADX INFO: renamed from: k */
        public boolean f25569k;

        public e() {
            this.f25568j = new C12394k(C12306b.this.f25555g.timeout());
        }

        @Override // p615g0.InterfaceC12405v, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f25569k) {
                return;
            }
            this.f25569k = true;
            C12306b.m10237i(C12306b.this, this.f25568j);
            C12306b.this.f25549a = 3;
        }

        @Override // p615g0.InterfaceC12405v, java.io.Flushable
        public void flush() throws IOException {
            if (this.f25569k) {
                return;
            }
            C12306b.this.f25555g.flush();
        }

        @Override // p615g0.InterfaceC12405v
        public C12408y timeout() {
            return this.f25568j;
        }

        @Override // p615g0.InterfaceC12405v
        public void write(C12388e c12388e, long j) throws IOException {
            C12238m.checkParameterIsNotNull(c12388e, "source");
            if (!(!this.f25569k)) {
                throw new IllegalStateException("closed".toString());
            }
            C12272c.m10122c(c12388e.f26080k, 0L, j);
            C12306b.this.f25555g.write(c12388e, j);
        }
    }

    /* JADX INFO: renamed from: f0.e0.i.b$f */
    /* JADX INFO: compiled from: Http1ExchangeCodec.kt */
    public final class f extends a {

        /* JADX INFO: renamed from: m */
        public boolean f25571m;

        public f(C12306b c12306b) {
            super();
        }

        @Override // p615g0.InterfaceC12407x, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f25557k) {
                return;
            }
            if (!this.f25571m) {
                m10240a();
            }
            this.f25557k = true;
        }

        @Override // p600f0.p601e0.p607i.C12306b.a, p615g0.InterfaceC12407x
        /* JADX INFO: renamed from: i0 */
        public long mo10176i0(C12388e c12388e, long j) throws IOException {
            C12238m.checkParameterIsNotNull(c12388e, "sink");
            if (!(j >= 0)) {
                throw new IllegalArgumentException(C1643a.m877t("byteCount < 0: ", j).toString());
            }
            if (!(!this.f25557k)) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.f25571m) {
                return -1L;
            }
            long jMo10176i0 = super.mo10176i0(c12388e, j);
            if (jMo10176i0 != -1) {
                return jMo10176i0;
            }
            this.f25571m = true;
            m10240a();
            return -1L;
        }
    }

    public C12306b(C12380x c12380x, C12290j c12290j, InterfaceC12390g interfaceC12390g, BufferedSink bufferedSink) {
        C12238m.checkParameterIsNotNull(c12290j, "connection");
        C12238m.checkParameterIsNotNull(interfaceC12390g, "source");
        C12238m.checkParameterIsNotNull(bufferedSink, "sink");
        this.f25552d = c12380x;
        this.f25553e = c12290j;
        this.f25554f = interfaceC12390g;
        this.f25555g = bufferedSink;
        this.f25550b = new C12305a(interfaceC12390g);
    }

    /* JADX INFO: renamed from: i */
    public static final void m10237i(C12306b c12306b, C12394k c12394k) {
        Objects.requireNonNull(c12306b);
        C12408y c12408y = c12394k.f26094e;
        C12408y c12408y2 = C12408y.f26133a;
        C12238m.checkParameterIsNotNull(c12408y2, "delegate");
        c12394k.f26094e = c12408y2;
        c12408y.mo10478a();
        c12408y.mo10479b();
    }

    @Override // p600f0.p601e0.p606h.InterfaceC12298d
    /* JADX INFO: renamed from: a */
    public void mo10213a() throws IOException {
        this.f25555g.flush();
    }

    @Override // p600f0.p601e0.p606h.InterfaceC12298d
    /* JADX INFO: renamed from: b */
    public void mo10214b(Request request) {
        C12238m.checkParameterIsNotNull(request, "request");
        Proxy.Type type = this.f25553e.f25506q.f25371b.type();
        C12238m.checkExpressionValueIsNotNull(type, "connection.route().proxy.type()");
        C12238m.checkParameterIsNotNull(request, "request");
        C12238m.checkParameterIsNotNull(type, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(request.method);
        sb.append(' ');
        C12379w c12379w = request.url;
        if (!c12379w.f25975c && type == Proxy.Type.HTTP) {
            sb.append(c12379w);
        } else {
            C12238m.checkParameterIsNotNull(c12379w, "url");
            String strM10400b = c12379w.m10400b();
            String strM10402d = c12379w.m10402d();
            if (strM10402d != null) {
                strM10400b = strM10400b + '?' + strM10402d;
            }
            sb.append(strM10400b);
        }
        sb.append(" HTTP/1.1");
        String string = sb.toString();
        C12238m.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        m10239k(request.headers, string);
    }

    @Override // p600f0.p601e0.p606h.InterfaceC12298d
    /* JADX INFO: renamed from: c */
    public InterfaceC12407x mo10215c(Response response) {
        C12238m.checkParameterIsNotNull(response, "response");
        if (!C12299e.m10221a(response)) {
            return m10238j(0L);
        }
        if (C12103t.equals("chunked", Response.m10989a(response, "Transfer-Encoding", null, 2), true)) {
            C12379w c12379w = response.request.url;
            if (this.f25549a == 4) {
                this.f25549a = 5;
                return new c(this, c12379w);
            }
            StringBuilder sbM833U = C1643a.m833U("state: ");
            sbM833U.append(this.f25549a);
            throw new IllegalStateException(sbM833U.toString().toString());
        }
        long jM10131l = C12272c.m10131l(response);
        if (jM10131l != -1) {
            return m10238j(jM10131l);
        }
        if (this.f25549a == 4) {
            this.f25549a = 5;
            this.f25553e.m10203l();
            return new f(this);
        }
        StringBuilder sbM833U2 = C1643a.m833U("state: ");
        sbM833U2.append(this.f25549a);
        throw new IllegalStateException(sbM833U2.toString().toString());
    }

    @Override // p600f0.p601e0.p606h.InterfaceC12298d
    public void cancel() {
        Socket socket = this.f25553e.f25491b;
        if (socket != null) {
            C12272c.m10124e(socket);
        }
    }

    @Override // p600f0.p601e0.p606h.InterfaceC12298d
    /* JADX INFO: renamed from: d */
    public Response.C12937a mo10216d(boolean z2) {
        int i = this.f25549a;
        boolean z3 = true;
        if (i != 1 && i != 3) {
            z3 = false;
        }
        if (!z3) {
            StringBuilder sbM833U = C1643a.m833U("state: ");
            sbM833U.append(this.f25549a);
            throw new IllegalStateException(sbM833U.toString().toString());
        }
        try {
            C12304j c12304jM10234a = C12304j.m10234a(this.f25550b.m10236b());
            Response.C12937a c12937a = new Response.C12937a();
            c12937a.m10996f(c12304jM10234a.f25544a);
            c12937a.f27567c = c12304jM10234a.f25545b;
            c12937a.m10995e(c12304jM10234a.f25546c);
            c12937a.m10994d(this.f25550b.m10235a());
            if (z2 && c12304jM10234a.f25545b == 100) {
                return null;
            }
            if (c12304jM10234a.f25545b == 100) {
                this.f25549a = 3;
                return c12937a;
            }
            this.f25549a = 4;
            return c12937a;
        } catch (EOFException e2) {
            throw new IOException(C1643a.m883w("unexpected end of stream on ", this.f25553e.f25506q.f25370a.f25353a.m10406h()), e2);
        }
    }

    @Override // p600f0.p601e0.p606h.InterfaceC12298d
    /* JADX INFO: renamed from: e */
    public C12290j mo10217e() {
        return this.f25553e;
    }

    @Override // p600f0.p601e0.p606h.InterfaceC12298d
    /* JADX INFO: renamed from: f */
    public void mo10218f() throws IOException {
        this.f25555g.flush();
    }

    @Override // p600f0.p601e0.p606h.InterfaceC12298d
    /* JADX INFO: renamed from: g */
    public long mo10219g(Response response) {
        C12238m.checkParameterIsNotNull(response, "response");
        if (!C12299e.m10221a(response)) {
            return 0L;
        }
        if (C12103t.equals("chunked", Response.m10989a(response, "Transfer-Encoding", null, 2), true)) {
            return -1L;
        }
        return C12272c.m10131l(response);
    }

    @Override // p600f0.p601e0.p606h.InterfaceC12298d
    /* JADX INFO: renamed from: h */
    public InterfaceC12405v mo10220h(Request request, long j) throws ProtocolException {
        C12238m.checkParameterIsNotNull(request, "request");
        RequestBody requestBody = request.body;
        if (requestBody != null && requestBody.isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (C12103t.equals("chunked", request.m10977b("Transfer-Encoding"), true)) {
            if (this.f25549a == 1) {
                this.f25549a = 2;
                return new b();
            }
            StringBuilder sbM833U = C1643a.m833U("state: ");
            sbM833U.append(this.f25549a);
            throw new IllegalStateException(sbM833U.toString().toString());
        }
        if (j == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        if (this.f25549a == 1) {
            this.f25549a = 2;
            return new e();
        }
        StringBuilder sbM833U2 = C1643a.m833U("state: ");
        sbM833U2.append(this.f25549a);
        throw new IllegalStateException(sbM833U2.toString().toString());
    }

    /* JADX INFO: renamed from: j */
    public final InterfaceC12407x m10238j(long j) {
        if (this.f25549a == 4) {
            this.f25549a = 5;
            return new d(j);
        }
        StringBuilder sbM833U = C1643a.m833U("state: ");
        sbM833U.append(this.f25549a);
        throw new IllegalStateException(sbM833U.toString().toString());
    }

    /* JADX INFO: renamed from: k */
    public final void m10239k(Headers headers, String str) {
        C12238m.checkParameterIsNotNull(headers, "headers");
        C12238m.checkParameterIsNotNull(str, "requestLine");
        if (!(this.f25549a == 0)) {
            StringBuilder sbM833U = C1643a.m833U("state: ");
            sbM833U.append(this.f25549a);
            throw new IllegalStateException(sbM833U.toString().toString());
        }
        this.f25555g.mo10436K(str).mo10436K("\r\n");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            this.f25555g.mo10436K(headers.m10955d(i)).mo10436K(": ").mo10436K(headers.m10957g(i)).mo10436K("\r\n");
        }
        this.f25555g.mo10436K("\r\n");
        this.f25549a = 1;
    }
}
