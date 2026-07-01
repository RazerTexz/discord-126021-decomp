package f0.e0.g;

import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.t.u;
import f0.c0;
import f0.e0.i.b$d;
import f0.e0.j.o;
import f0.e0.j.s;
import f0.e0.k.h$a;
import f0.t;
import f0.v;
import f0.w;
import f0.x;
import f0.y;
import g0.q;
import g0.r;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy$Type;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.TypeCastException;
import okhttp3.Headers;
import okhttp3.Headers$a;
import okhttp3.Headers$b;
import okhttp3.Request;
import okhttp3.Request$a;
import okhttp3.Response;
import okhttp3.Response$a;
import okhttp3.internal.connection.RouteException;
import okio.BufferedSink;

/* JADX INFO: compiled from: RealConnection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends f0.e0.j.e$c implements f0.k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Socket f3620b;
    public Socket c;
    public v d;
    public y e;
    public f0.e0.j.e f;
    public g0.g g;
    public BufferedSink h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public int n;
    public final List<Reference<e>> o;
    public long p;
    public final c0 q;

    public j(k kVar, c0 c0Var) {
        d0.z.d.m.checkParameterIsNotNull(kVar, "connectionPool");
        d0.z.d.m.checkParameterIsNotNull(c0Var, "route");
        this.q = c0Var;
        this.n = 1;
        this.o = new ArrayList();
        this.p = RecyclerView.FOREVER_NS;
    }

    @Override // f0.e0.j.e$c
    public synchronized void a(f0.e0.j.e eVar, s sVar) {
        d0.z.d.m.checkParameterIsNotNull(eVar, "connection");
        d0.z.d.m.checkParameterIsNotNull(sVar, "settings");
        this.n = (sVar.a & 16) != 0 ? sVar.f3647b[4] : Integer.MAX_VALUE;
    }

    @Override // f0.e0.j.e$c
    public void b(f0.e0.j.n nVar) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(nVar, "stream");
        nVar.c(f0.e0.j.a.REFUSED_STREAM, null);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:55:0x011c  */
    /* JADX WARN: Code duplicated, block: B:56:0x0122  */
    /* JADX WARN: Code duplicated, block: B:58:0x0127  */
    /* JADX WARN: Code duplicated, block: B:78:0x0156  */
    /* JADX WARN: Code duplicated, block: B:92:0x015b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x015b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:? A[LOOP:0: B:86:0x0077->B:98:?, LOOP_END, SYNTHETIC] */
    public final void c(int i, int i2, int i3, int i4, boolean z2, f0.e eVar, t tVar) throws Throwable {
        Socket socket;
        Socket socket2;
        boolean z3;
        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        d0.z.d.m.checkParameterIsNotNull(tVar, "eventListener");
        if (!(this.e == null)) {
            throw new IllegalStateException("already connected".toString());
        }
        List<f0.m> list = this.q.a.c;
        b bVar = new b(list);
        f0.a aVar = this.q.a;
        if (aVar.f == null) {
            if (!list.contains(f0.m.d)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String str = this.q.a.a.g;
            h$a h_a = f0.e0.k.h.c;
            if (!f0.e0.k.h.a.h(str)) {
                throw new RouteException(new UnknownServiceException(b.d.b.a.a.y("CLEARTEXT communication to ", str, " not permitted by network security policy")));
            }
        } else if (aVar.f3601b.contains(y.H2_PRIOR_KNOWLEDGE)) {
            throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        RouteException routeException = null;
        while (true) {
            try {
                if (this.q.a()) {
                    f(i, i2, i3, eVar, tVar);
                    if (this.f3620b == null) {
                        break;
                    }
                } else {
                    try {
                        e(i, i2, eVar, tVar);
                    } catch (IOException e) {
                        e = e;
                        socket = this.c;
                        if (socket != null) {
                            f0.e0.c.e(socket);
                        }
                        socket2 = this.f3620b;
                        if (socket2 != null) {
                            f0.e0.c.e(socket2);
                        }
                        this.c = null;
                        this.f3620b = null;
                        this.g = null;
                        this.h = null;
                        this.d = null;
                        this.e = null;
                        this.f = null;
                        this.n = 1;
                        c0 c0Var = this.q;
                        InetSocketAddress inetSocketAddress = c0Var.c;
                        Proxy proxy = c0Var.f3603b;
                        Objects.requireNonNull(tVar);
                        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
                        d0.z.d.m.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
                        d0.z.d.m.checkParameterIsNotNull(proxy, "proxy");
                        d0.z.d.m.checkParameterIsNotNull(e, "ioe");
                        if (routeException == null) {
                            routeException = new RouteException(e);
                        } else {
                            routeException.a(e);
                        }
                        if (z2) {
                            throw routeException;
                        }
                        d0.z.d.m.checkParameterIsNotNull(e, "e");
                        bVar.c = true;
                        if (bVar.f3613b || (e instanceof ProtocolException) || (e instanceof InterruptedIOException) || (((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) || (e instanceof SSLPeerUnverifiedException) || !(e instanceof SSLException))) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (z3) {
                            throw routeException;
                        }
                    }
                }
                try {
                    g(bVar, i4, eVar, tVar);
                    c0 c0Var2 = this.q;
                    InetSocketAddress inetSocketAddress2 = c0Var2.c;
                    Proxy proxy2 = c0Var2.f3603b;
                    Objects.requireNonNull(tVar);
                    d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
                    d0.z.d.m.checkParameterIsNotNull(inetSocketAddress2, "inetSocketAddress");
                    d0.z.d.m.checkParameterIsNotNull(proxy2, "proxy");
                    break;
                } catch (IOException e2) {
                    e = e2;
                    socket = this.c;
                    if (socket != null) {
                        f0.e0.c.e(socket);
                    }
                    socket2 = this.f3620b;
                    if (socket2 != null) {
                        f0.e0.c.e(socket2);
                    }
                    this.c = null;
                    this.f3620b = null;
                    this.g = null;
                    this.h = null;
                    this.d = null;
                    this.e = null;
                    this.f = null;
                    this.n = 1;
                    c0 c0Var3 = this.q;
                    InetSocketAddress inetSocketAddress3 = c0Var3.c;
                    Proxy proxy3 = c0Var3.f3603b;
                    Objects.requireNonNull(tVar);
                    d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
                    d0.z.d.m.checkParameterIsNotNull(inetSocketAddress3, "inetSocketAddress");
                    d0.z.d.m.checkParameterIsNotNull(proxy3, "proxy");
                    d0.z.d.m.checkParameterIsNotNull(e, "ioe");
                    if (routeException == null) {
                        routeException = new RouteException(e);
                    } else {
                        routeException.a(e);
                    }
                    if (z2) {
                        throw routeException;
                    }
                    d0.z.d.m.checkParameterIsNotNull(e, "e");
                    bVar.c = true;
                    if (bVar.f3613b) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        throw routeException;
                    }
                }
            } catch (IOException e3) {
                e = e3;
            }
        }
        if (this.q.a() && this.f3620b == null) {
            throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        this.p = System.nanoTime();
    }

    public final void d(x xVar, c0 c0Var, IOException iOException) {
        d0.z.d.m.checkParameterIsNotNull(xVar, "client");
        d0.z.d.m.checkParameterIsNotNull(c0Var, "failedRoute");
        d0.z.d.m.checkParameterIsNotNull(iOException, "failure");
        if (c0Var.f3603b.type() != Proxy$Type.DIRECT) {
            f0.a aVar = c0Var.a;
            aVar.k.connectFailed(aVar.a.i(), c0Var.f3603b.address(), iOException);
        }
        l lVar = xVar.O;
        synchronized (lVar) {
            d0.z.d.m.checkParameterIsNotNull(c0Var, "failedRoute");
            lVar.a.add(c0Var);
        }
    }

    public final void e(int i, int i2, f0.e eVar, t tVar) throws IOException {
        Socket socket;
        int i3;
        c0 c0Var = this.q;
        Proxy proxy = c0Var.f3603b;
        f0.a aVar = c0Var.a;
        Proxy$Type proxy$TypeType = proxy.type();
        if (proxy$TypeType != null && ((i3 = f.a[proxy$TypeType.ordinal()]) == 1 || i3 == 2)) {
            socket = aVar.e.createSocket();
            if (socket == null) {
                d0.z.d.m.throwNpe();
            }
        } else {
            socket = new Socket(proxy);
        }
        this.f3620b = socket;
        InetSocketAddress inetSocketAddress = this.q.c;
        Objects.requireNonNull(tVar);
        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        d0.z.d.m.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
        d0.z.d.m.checkParameterIsNotNull(proxy, "proxy");
        socket.setSoTimeout(i2);
        try {
            h$a h_a = f0.e0.k.h.c;
            f0.e0.k.h.a.e(socket, this.q.c, i);
            try {
                g0.x xVarD1 = b.i.a.f.e.o.f.d1(socket);
                d0.z.d.m.checkParameterIsNotNull(xVarD1, "$this$buffer");
                this.g = new r(xVarD1);
                g0.v vVarB1 = b.i.a.f.e.o.f.b1(socket);
                d0.z.d.m.checkParameterIsNotNull(vVarB1, "$this$buffer");
                this.h = new q(vVarB1);
            } catch (NullPointerException e) {
                if (d0.z.d.m.areEqual(e.getMessage(), "throw with null exception")) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            StringBuilder sbU = b.d.b.a.a.U("Failed to connect to ");
            sbU.append(this.q.c);
            ConnectException connectException = new ConnectException(sbU.toString());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    public final void f(int i, int i2, int i3, f0.e eVar, t tVar) throws IOException {
        Request$a request$a = new Request$a();
        request$a.g(this.q.a.a);
        x xVar = null;
        request$a.c("CONNECT", null);
        boolean z2 = true;
        request$a.b("Host", f0.e0.c.y(this.q.a.a, true));
        request$a.b("Proxy-Connection", "Keep-Alive");
        request$a.b("User-Agent", "okhttp/4.8.0");
        Request requestA = request$a.a();
        Response$a response$a = new Response$a();
        response$a.g(requestA);
        response$a.f(y.HTTP_1_1);
        response$a.c = 407;
        response$a.e("Preemptive Authenticate");
        response$a.g = f0.e0.c.c;
        response$a.k = -1L;
        response$a.l = -1L;
        d0.z.d.m.checkParameterIsNotNull("Proxy-Authenticate", ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkParameterIsNotNull("OkHttp-Preemptive", "value");
        Headers$a headers$a = response$a.f;
        Objects.requireNonNull(headers$a);
        d0.z.d.m.checkParameterIsNotNull("Proxy-Authenticate", ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkParameterIsNotNull("OkHttp-Preemptive", "value");
        Headers$b headers$b = Headers.j;
        headers$b.a("Proxy-Authenticate");
        headers$b.b("OkHttp-Preemptive", "Proxy-Authenticate");
        headers$a.d("Proxy-Authenticate");
        headers$a.b("Proxy-Authenticate", "OkHttp-Preemptive");
        Response responseA = response$a.a();
        c0 c0Var = this.q;
        Request requestA2 = c0Var.a.i.a(c0Var, responseA);
        if (requestA2 != null) {
            requestA = requestA2;
        }
        w wVar = requestA.url;
        int i4 = 0;
        while (i4 < 21) {
            e(i, i2, eVar, tVar);
            String str = "CONNECT " + f0.e0.c.y(wVar, z2) + " HTTP/1.1";
            while (true) {
                g0.g gVar = this.g;
                if (gVar == null) {
                    d0.z.d.m.throwNpe();
                }
                BufferedSink bufferedSink = this.h;
                if (bufferedSink == null) {
                    d0.z.d.m.throwNpe();
                }
                f0.e0.i.b bVar = new f0.e0.i.b(xVar, this, gVar, bufferedSink);
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                gVar.timeout().g(i2, timeUnit);
                bufferedSink.timeout().g(i3, timeUnit);
                bVar.k(requestA.headers, str);
                bVar.g.flush();
                Response$a response$aD = bVar.d(false);
                if (response$aD == null) {
                    d0.z.d.m.throwNpe();
                }
                response$aD.g(requestA);
                Response responseA2 = response$aD.a();
                d0.z.d.m.checkParameterIsNotNull(responseA2, "response");
                long jL = f0.e0.c.l(responseA2);
                if (jL != -1) {
                    g0.x xVarJ = bVar.j(jL);
                    f0.e0.c.v(xVarJ, Integer.MAX_VALUE, timeUnit);
                    ((b$d) xVarJ).close();
                }
                int i5 = responseA2.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                if (i5 == 200) {
                    if (!gVar.g().w() || !bufferedSink.g().w()) {
                        throw new IOException("TLS tunnel buffered too many bytes!");
                    }
                    requestA = null;
                    break;
                }
                if (i5 != 407) {
                    StringBuilder sbU = b.d.b.a.a.U("Unexpected response code for CONNECT: ");
                    sbU.append(responseA2.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String);
                    throw new IOException(sbU.toString());
                }
                c0 c0Var2 = this.q;
                Request requestA3 = c0Var2.a.i.a(c0Var2, responseA2);
                if (requestA3 == null) {
                    throw new IOException("Failed to authenticate with proxy");
                }
                if (d0.g0.t.equals("close", Response.a(responseA2, "Connection", null, 2), true)) {
                    requestA = requestA3;
                    break;
                } else {
                    xVar = null;
                    requestA = requestA3;
                }
            }
            if (requestA == null) {
                return;
            }
            Socket socket = this.f3620b;
            if (socket != null) {
                f0.e0.c.e(socket);
            }
            xVar = null;
            this.f3620b = null;
            this.h = null;
            this.g = null;
            c0 c0Var3 = this.q;
            InetSocketAddress inetSocketAddress = c0Var3.c;
            Proxy proxy = c0Var3.f3603b;
            Objects.requireNonNull(tVar);
            d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
            d0.z.d.m.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
            d0.z.d.m.checkParameterIsNotNull(proxy, "proxy");
            i4++;
            z2 = true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x019f  */
    /* JADX WARN: Code duplicated, block: B:58:0x01a8  */
    public final void g(b bVar, int i, f0.e eVar, t tVar) throws Throwable {
        SSLSocket sSLSocket;
        String strF;
        y yVarA = y.HTTP_1_1;
        f0.a aVar = this.q.a;
        if (aVar.f == null) {
            List<y> list = aVar.f3601b;
            y yVar = y.H2_PRIOR_KNOWLEDGE;
            if (!list.contains(yVar)) {
                this.c = this.f3620b;
                this.e = yVarA;
                return;
            } else {
                this.c = this.f3620b;
                this.e = yVar;
                o(i);
                return;
            }
        }
        Objects.requireNonNull(tVar);
        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        f0.a aVar2 = this.q.a;
        SSLSocketFactory sSLSocketFactory = aVar2.f;
        if (sSLSocketFactory == null) {
            try {
                d0.z.d.m.throwNpe();
            } catch (Throwable th) {
                th = th;
                sSLSocket = null;
                if (sSLSocket != null) {
                    h$a h_a = f0.e0.k.h.c;
                    f0.e0.k.h.a.a(sSLSocket);
                }
                if (sSLSocket != null) {
                    f0.e0.c.e(sSLSocket);
                }
                throw th;
            }
        }
        Socket socket = this.f3620b;
        w wVar = aVar2.a;
        Socket socketCreateSocket = sSLSocketFactory.createSocket(socket, wVar.g, wVar.h, true);
        if (socketCreateSocket == null) {
            throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
        }
        sSLSocket = (SSLSocket) socketCreateSocket;
        try {
            f0.m mVarA = bVar.a(sSLSocket);
            if (mVarA.f) {
                h$a h_a2 = f0.e0.k.h.c;
                f0.e0.k.h.a.d(sSLSocket, aVar2.a.g, aVar2.f3601b);
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            d0.z.d.m.checkExpressionValueIsNotNull(session, "sslSocketSession");
            v vVarA = v.a(session);
            HostnameVerifier hostnameVerifier = aVar2.g;
            if (hostnameVerifier == null) {
                d0.z.d.m.throwNpe();
            }
            if (hostnameVerifier.verify(aVar2.a.g, session)) {
                f0.g gVar = aVar2.h;
                if (gVar == null) {
                    d0.z.d.m.throwNpe();
                }
                this.d = new v(vVarA.f3680b, vVarA.c, vVarA.d, new g(gVar, vVarA, aVar2));
                gVar.a(aVar2.a.g, new h(this));
                if (mVarA.f) {
                    h$a h_a3 = f0.e0.k.h.c;
                    strF = f0.e0.k.h.a.f(sSLSocket);
                } else {
                    strF = null;
                }
                this.c = sSLSocket;
                g0.x xVarD1 = b.i.a.f.e.o.f.d1(sSLSocket);
                d0.z.d.m.checkParameterIsNotNull(xVarD1, "$this$buffer");
                this.g = new r(xVarD1);
                g0.v vVarB1 = b.i.a.f.e.o.f.b1(sSLSocket);
                d0.z.d.m.checkParameterIsNotNull(vVarB1, "$this$buffer");
                this.h = new q(vVarB1);
                if (strF != null) {
                    yVarA = y.q.a(strF);
                }
                this.e = yVarA;
                h$a h_a4 = f0.e0.k.h.c;
                f0.e0.k.h.a.a(sSLSocket);
                d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
                if (this.e == y.HTTP_2) {
                    o(i);
                    return;
                }
                return;
            }
            List<Certificate> listC = vVarA.c();
            if (!(!listC.isEmpty())) {
                throw new SSLPeerUnverifiedException("Hostname " + aVar2.a.g + " not verified (no certificates)");
            }
            Certificate certificate = listC.get(0);
            if (certificate == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            X509Certificate x509Certificate = (X509Certificate) certificate;
            StringBuilder sb = new StringBuilder();
            sb.append("\n              |Hostname ");
            sb.append(aVar2.a.g);
            sb.append(" not verified:\n              |    certificate: ");
            sb.append(f0.g.f3670b.a(x509Certificate));
            sb.append("\n              |    DN: ");
            Principal subjectDN = x509Certificate.getSubjectDN();
            d0.z.d.m.checkExpressionValueIsNotNull(subjectDN, "cert.subjectDN");
            sb.append(subjectDN.getName());
            sb.append("\n              |    subjectAltNames: ");
            f0.e0.m.d dVar = f0.e0.m.d.a;
            d0.z.d.m.checkParameterIsNotNull(x509Certificate, "certificate");
            sb.append(u.plus((Collection) dVar.a(x509Certificate, 7), (Iterable) dVar.a(x509Certificate, 2)));
            sb.append("\n              ");
            throw new SSLPeerUnverifiedException(d0.g0.m.trimMargin$default(sb.toString(), null, 1, null));
        } catch (Throwable th2) {
            th = th2;
            if (sSLSocket != null) {
                h$a h_a5 = f0.e0.k.h.c;
                f0.e0.k.h.a.a(sSLSocket);
            }
            if (sSLSocket != null) {
                f0.e0.c.e(sSLSocket);
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00d3  */
    public final boolean h(f0.a aVar, List<c0> list) {
        boolean z2;
        boolean z3;
        v vVar;
        boolean z4;
        d0.z.d.m.checkParameterIsNotNull(aVar, "address");
        byte[] bArr = f0.e0.c.a;
        if (this.o.size() >= this.n || this.i || !this.q.a.a(aVar)) {
            return false;
        }
        if (d0.z.d.m.areEqual(aVar.a.g, this.q.a.a.g)) {
            return true;
        }
        if (this.f != null && list != null) {
            if (!list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    c0 c0Var = (c0) it.next();
                    if (c0Var.f3603b.type() == Proxy$Type.DIRECT && this.q.f3603b.type() == Proxy$Type.DIRECT && d0.z.d.m.areEqual(this.q.c, c0Var.c)) {
                        z2 = true;
                        break;
                    }
                }
            } else {
                z2 = false;
                break;
            }
            if (z2) {
                HostnameVerifier hostnameVerifier = aVar.g;
                f0.e0.m.d dVar = f0.e0.m.d.a;
                if (hostnameVerifier != dVar) {
                    return false;
                }
                w wVar = aVar.a;
                byte[] bArr2 = f0.e0.c.a;
                w wVar2 = this.q.a.a;
                if (wVar.h == wVar2.h) {
                    if (!d0.z.d.m.areEqual(wVar.g, wVar2.g)) {
                        if (!this.j && (vVar = this.d) != null) {
                            List<Certificate> listC = vVar.c();
                            if (!listC.isEmpty()) {
                                String str = wVar.g;
                                Certificate certificate = listC.get(0);
                                if (certificate == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                                }
                                if (dVar.b(str, (X509Certificate) certificate)) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                            } else {
                                z4 = false;
                            }
                            if (z4) {
                            }
                        }
                        z3 = false;
                    }
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    return false;
                }
                try {
                    f0.g gVar = aVar.h;
                    if (gVar == null) {
                        d0.z.d.m.throwNpe();
                    }
                    String str2 = aVar.a.g;
                    v vVar2 = this.d;
                    if (vVar2 == null) {
                        d0.z.d.m.throwNpe();
                    }
                    List<Certificate> listC2 = vVar2.c();
                    Objects.requireNonNull(gVar);
                    d0.z.d.m.checkParameterIsNotNull(str2, "hostname");
                    d0.z.d.m.checkParameterIsNotNull(listC2, "peerCertificates");
                    gVar.a(str2, new f0.h(gVar, listC2, str2));
                    return true;
                } catch (SSLPeerUnverifiedException unused) {
                }
            }
        }
        return false;
    }

    public final boolean i(boolean z2) {
        long j;
        byte[] bArr = f0.e0.c.a;
        long jNanoTime = System.nanoTime();
        Socket socket = this.f3620b;
        if (socket == null) {
            d0.z.d.m.throwNpe();
        }
        Socket socket2 = this.c;
        if (socket2 == null) {
            d0.z.d.m.throwNpe();
        }
        g0.g gVar = this.g;
        if (gVar == null) {
            d0.z.d.m.throwNpe();
        }
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        f0.e0.j.e eVar = this.f;
        if (eVar != null) {
            synchronized (eVar) {
                if (eVar.r) {
                    return false;
                }
                return eVar.A >= eVar.f3641z || jNanoTime < eVar.C;
            }
        }
        synchronized (this) {
            j = jNanoTime - this.p;
        }
        if (j < 10000000000L || !z2) {
            return true;
        }
        d0.z.d.m.checkParameterIsNotNull(socket2, "$this$isHealthy");
        d0.z.d.m.checkParameterIsNotNull(gVar, "source");
        try {
            int soTimeout = socket2.getSoTimeout();
            try {
                socket2.setSoTimeout(1);
                return !gVar.w();
            } finally {
                socket2.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public final boolean j() {
        return this.f != null;
    }

    public final f0.e0.h.d k(x xVar, f0.e0.h.g gVar) throws SocketException {
        d0.z.d.m.checkParameterIsNotNull(xVar, "client");
        d0.z.d.m.checkParameterIsNotNull(gVar, "chain");
        Socket socket = this.c;
        if (socket == null) {
            d0.z.d.m.throwNpe();
        }
        g0.g gVar2 = this.g;
        if (gVar2 == null) {
            d0.z.d.m.throwNpe();
        }
        BufferedSink bufferedSink = this.h;
        if (bufferedSink == null) {
            d0.z.d.m.throwNpe();
        }
        f0.e0.j.e eVar = this.f;
        if (eVar != null) {
            return new f0.e0.j.l(xVar, this, gVar, eVar);
        }
        socket.setSoTimeout(gVar.h);
        g0.y yVarTimeout = gVar2.timeout();
        long j = gVar.h;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        yVarTimeout.g(j, timeUnit);
        bufferedSink.timeout().g(gVar.i, timeUnit);
        return new f0.e0.i.b(xVar, this, gVar2, bufferedSink);
    }

    public final synchronized void l() {
        this.i = true;
    }

    public y m() {
        y yVar = this.e;
        if (yVar == null) {
            d0.z.d.m.throwNpe();
        }
        return yVar;
    }

    public Socket n() {
        Socket socket = this.c;
        if (socket == null) {
            d0.z.d.m.throwNpe();
        }
        return socket;
    }

    public final void o(int i) throws IOException {
        String strW;
        int i2;
        Socket socket = this.c;
        if (socket == null) {
            d0.z.d.m.throwNpe();
        }
        g0.g gVar = this.g;
        if (gVar == null) {
            d0.z.d.m.throwNpe();
        }
        BufferedSink bufferedSink = this.h;
        if (bufferedSink == null) {
            d0.z.d.m.throwNpe();
        }
        socket.setSoTimeout(0);
        f0.e0.f.d dVar = f0.e0.f.d.a;
        f0.e0.j.e$b e_b = new f0.e0.j.e$b(true, dVar);
        String str = this.q.a.a.g;
        d0.z.d.m.checkParameterIsNotNull(socket, "socket");
        d0.z.d.m.checkParameterIsNotNull(str, "peerName");
        d0.z.d.m.checkParameterIsNotNull(gVar, "source");
        d0.z.d.m.checkParameterIsNotNull(bufferedSink, "sink");
        e_b.a = socket;
        if (e_b.h) {
            strW = f0.e0.c.g + ' ' + str;
        } else {
            strW = b.d.b.a.a.w("MockWebServer ", str);
        }
        e_b.f3642b = strW;
        e_b.c = gVar;
        e_b.d = bufferedSink;
        d0.z.d.m.checkParameterIsNotNull(this, "listener");
        e_b.e = this;
        e_b.g = i;
        f0.e0.j.e eVar = new f0.e0.j.e(e_b);
        this.f = eVar;
        f0.e0.j.e eVar2 = f0.e0.j.e.k;
        s sVar = f0.e0.j.e.j;
        this.n = (sVar.a & 16) != 0 ? sVar.f3647b[4] : Integer.MAX_VALUE;
        d0.z.d.m.checkParameterIsNotNull(dVar, "taskRunner");
        o oVar = eVar.K;
        synchronized (oVar) {
            if (oVar.m) {
                throw new IOException("closed");
            }
            if (oVar.p) {
                Logger logger = o.j;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(f0.e0.c.j(">> CONNECTION " + f0.e0.j.d.a.k(), new Object[0]));
                }
                oVar.o.e0(f0.e0.j.d.a);
                oVar.o.flush();
            }
        }
        o oVar2 = eVar.K;
        s sVar2 = eVar.D;
        synchronized (oVar2) {
            d0.z.d.m.checkParameterIsNotNull(sVar2, "settings");
            if (oVar2.m) {
                throw new IOException("closed");
            }
            oVar2.c(0, Integer.bitCount(sVar2.a) * 6, 4, 0);
            int i3 = 0;
            while (i3 < 10) {
                if (((1 << i3) & sVar2.a) != 0) {
                    if (i3 != 4) {
                        i2 = i3 != 7 ? i3 : 4;
                    } else {
                        i2 = 3;
                    }
                    oVar2.o.writeShort(i2);
                    oVar2.o.writeInt(sVar2.f3647b[i3]);
                }
                i3++;
            }
            oVar2.o.flush();
        }
        int iA = eVar.D.a();
        if (iA != 65535) {
            eVar.K.q(0, iA - 65535);
        }
        f0.e0.f.c cVarF = dVar.f();
        String str2 = eVar.o;
        cVarF.c(new f0.e0.f.b(eVar.L, str2, true, str2, true), 0L);
    }

    public String toString() {
        Object obj;
        StringBuilder sbU = b.d.b.a.a.U("Connection{");
        sbU.append(this.q.a.a.g);
        sbU.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        sbU.append(this.q.a.a.h);
        sbU.append(',');
        sbU.append(" proxy=");
        sbU.append(this.q.f3603b);
        sbU.append(" hostAddress=");
        sbU.append(this.q.c);
        sbU.append(" cipherSuite=");
        v vVar = this.d;
        if (vVar == null || (obj = vVar.c) == null) {
            obj = "none";
        }
        sbU.append(obj);
        sbU.append(" protocol=");
        sbU.append(this.e);
        sbU.append('}');
        return sbU.toString();
    }
}
