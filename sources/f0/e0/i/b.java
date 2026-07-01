package f0.e0.i;

import d0.g0.t;
import d0.z.d.m;
import f0.e0.c;
import f0.e0.g.j;
import f0.e0.h.d;
import f0.e0.h.e;
import f0.w;
import f0.x;
import g0.g;
import g0.k;
import g0.v;
import g0.y;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy$Type;
import java.net.Socket;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response$a;
import okio.BufferedSink;

/* JADX INFO: compiled from: Http1ExchangeCodec.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements d {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f3632b;
    public Headers c;
    public final x d;
    public final j e;
    public final g f;
    public final BufferedSink g;

    public b(x xVar, j jVar, g gVar, BufferedSink bufferedSink) {
        m.checkParameterIsNotNull(jVar, "connection");
        m.checkParameterIsNotNull(gVar, "source");
        m.checkParameterIsNotNull(bufferedSink, "sink");
        this.d = xVar;
        this.e = jVar;
        this.f = gVar;
        this.g = bufferedSink;
        this.f3632b = new a(gVar);
    }

    public static final void i(b bVar, k kVar) {
        Objects.requireNonNull(bVar);
        y yVar = kVar.e;
        y yVar2 = y.a;
        m.checkParameterIsNotNull(yVar2, "delegate");
        kVar.e = yVar2;
        yVar.a();
        yVar.b();
    }

    @Override // f0.e0.h.d
    public void a() throws IOException {
        this.g.flush();
    }

    @Override // f0.e0.h.d
    public void b(Request request) {
        m.checkParameterIsNotNull(request, "request");
        Proxy$Type proxy$TypeType = this.e.q.f3603b.type();
        m.checkExpressionValueIsNotNull(proxy$TypeType, "connection.route().proxy.type()");
        m.checkParameterIsNotNull(request, "request");
        m.checkParameterIsNotNull(proxy$TypeType, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(request.method);
        sb.append(' ');
        w wVar = request.url;
        if (!wVar.c && proxy$TypeType == Proxy$Type.HTTP) {
            sb.append(wVar);
        } else {
            m.checkParameterIsNotNull(wVar, "url");
            String strB = wVar.b();
            String strD = wVar.d();
            if (strD != null) {
                strB = strB + '?' + strD;
            }
            sb.append(strB);
        }
        sb.append(" HTTP/1.1");
        String string = sb.toString();
        m.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        k(request.headers, string);
    }

    @Override // f0.e0.h.d
    public g0.x c(Response response) {
        m.checkParameterIsNotNull(response, "response");
        if (!e.a(response)) {
            return j(0L);
        }
        if (t.equals("chunked", Response.a(response, "Transfer-Encoding", null, 2), true)) {
            w wVar = response.request.url;
            if (this.a == 4) {
                this.a = 5;
                return new b$c(this, wVar);
            }
            StringBuilder sbU = b.d.b.a.a.U("state: ");
            sbU.append(this.a);
            throw new IllegalStateException(sbU.toString().toString());
        }
        long jL = c.l(response);
        if (jL != -1) {
            return j(jL);
        }
        if (this.a == 4) {
            this.a = 5;
            this.e.l();
            return new b$f(this);
        }
        StringBuilder sbU2 = b.d.b.a.a.U("state: ");
        sbU2.append(this.a);
        throw new IllegalStateException(sbU2.toString().toString());
    }

    @Override // f0.e0.h.d
    public void cancel() {
        Socket socket = this.e.f3620b;
        if (socket != null) {
            c.e(socket);
        }
    }

    @Override // f0.e0.h.d
    public Response$a d(boolean z2) {
        int i = this.a;
        boolean z3 = true;
        if (i != 1 && i != 3) {
            z3 = false;
        }
        if (!z3) {
            StringBuilder sbU = b.d.b.a.a.U("state: ");
            sbU.append(this.a);
            throw new IllegalStateException(sbU.toString().toString());
        }
        try {
            f0.e0.h.j jVarA = f0.e0.h.j.a(this.f3632b.b());
            Response$a response$a = new Response$a();
            response$a.f(jVarA.a);
            response$a.c = jVarA.f3630b;
            response$a.e(jVarA.c);
            response$a.d(this.f3632b.a());
            if (z2 && jVarA.f3630b == 100) {
                return null;
            }
            if (jVarA.f3630b == 100) {
                this.a = 3;
                return response$a;
            }
            this.a = 4;
            return response$a;
        } catch (EOFException e) {
            throw new IOException(b.d.b.a.a.w("unexpected end of stream on ", this.e.q.a.a.h()), e);
        }
    }

    @Override // f0.e0.h.d
    public j e() {
        return this.e;
    }

    @Override // f0.e0.h.d
    public void f() throws IOException {
        this.g.flush();
    }

    @Override // f0.e0.h.d
    public long g(Response response) {
        m.checkParameterIsNotNull(response, "response");
        if (!e.a(response)) {
            return 0L;
        }
        if (t.equals("chunked", Response.a(response, "Transfer-Encoding", null, 2), true)) {
            return -1L;
        }
        return c.l(response);
    }

    @Override // f0.e0.h.d
    public v h(Request request, long j) throws ProtocolException {
        m.checkParameterIsNotNull(request, "request");
        RequestBody requestBody = request.body;
        if (requestBody != null && requestBody.isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (t.equals("chunked", request.b("Transfer-Encoding"), true)) {
            if (this.a == 1) {
                this.a = 2;
                return new b$b(this);
            }
            StringBuilder sbU = b.d.b.a.a.U("state: ");
            sbU.append(this.a);
            throw new IllegalStateException(sbU.toString().toString());
        }
        if (j == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        if (this.a == 1) {
            this.a = 2;
            return new b$e(this);
        }
        StringBuilder sbU2 = b.d.b.a.a.U("state: ");
        sbU2.append(this.a);
        throw new IllegalStateException(sbU2.toString().toString());
    }

    public final g0.x j(long j) {
        if (this.a == 4) {
            this.a = 5;
            return new b$d(this, j);
        }
        StringBuilder sbU = b.d.b.a.a.U("state: ");
        sbU.append(this.a);
        throw new IllegalStateException(sbU.toString().toString());
    }

    public final void k(Headers headers, String str) {
        m.checkParameterIsNotNull(headers, "headers");
        m.checkParameterIsNotNull(str, "requestLine");
        if (!(this.a == 0)) {
            StringBuilder sbU = b.d.b.a.a.U("state: ");
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
