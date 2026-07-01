package f0.e0.g;

import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import d0.g0.Indent;
import d0.g0.StringsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import f0.Address;
import f0.Call2;
import f0.CertificatePinner;
import f0.CertificatePinner2;
import f0.Connection2;
import f0.ConnectionSpec;
import f0.EventListener;
import f0.Handshake;
import f0.HttpUrl;
import f0.OkHttpClient;
import f0.Protocol2;
import f0.Route;
import f0.e0.Util7;
import f0.e0.f.TaskQueue;
import f0.e0.f.TaskQueue2;
import f0.e0.f.TaskRunner;
import f0.e0.h.ExchangeCodec;
import f0.e0.h.RealInterceptorChain;
import f0.e0.i.Http1ExchangeCodec;
import f0.e0.j.ErrorCode2;
import f0.e0.j.Http2;
import f0.e0.j.Http2Connection;
import f0.e0.j.Http2ExchangeCodec;
import f0.e0.j.Http2Stream;
import f0.e0.j.Http2Writer;
import f0.e0.j.Settings3;
import f0.e0.k.Platform2;
import f0.e0.m.OkHostnameVerifier;
import g0.BufferedSource;
import g0.RealBufferedSink;
import g0.RealBufferedSource;
import g0.Sink;
import g0.Source2;
import g0.Timeout2;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
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
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.RouteException;
import okio.BufferedSink;

/* JADX INFO: renamed from: f0.e0.g.j, reason: use source file name */
/* JADX INFO: compiled from: RealConnection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RealConnection4 extends Http2Connection.c implements Connection2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Socket f3620b;
    public Socket c;
    public Handshake d;
    public Protocol2 e;
    public Http2Connection f;
    public BufferedSource g;
    public BufferedSink h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public int n;
    public final List<Reference<RealCall>> o;
    public long p;
    public final Route q;

    public RealConnection4(RealConnectionPool realConnectionPool, Route route) {
        Intrinsics3.checkParameterIsNotNull(realConnectionPool, "connectionPool");
        Intrinsics3.checkParameterIsNotNull(route, "route");
        this.q = route;
        this.n = 1;
        this.o = new ArrayList();
        this.p = RecyclerView.FOREVER_NS;
    }

    @Override // f0.e0.j.Http2Connection.c
    public synchronized void a(Http2Connection http2Connection, Settings3 settings3) {
        Intrinsics3.checkParameterIsNotNull(http2Connection, "connection");
        Intrinsics3.checkParameterIsNotNull(settings3, "settings");
        this.n = (settings3.a & 16) != 0 ? settings3.f3647b[4] : Integer.MAX_VALUE;
    }

    @Override // f0.e0.j.Http2Connection.c
    public void b(Http2Stream http2Stream) throws IOException {
        Intrinsics3.checkParameterIsNotNull(http2Stream, "stream");
        http2Stream.c(ErrorCode2.REFUSED_STREAM, null);
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
    public final void c(int i, int i2, int i3, int i4, boolean z2, Call2 call2, EventListener eventListener) throws Throwable {
        Socket socket;
        Socket socket2;
        boolean z3;
        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(eventListener, "eventListener");
        if (!(this.e == null)) {
            throw new IllegalStateException("already connected".toString());
        }
        List<ConnectionSpec> list = this.q.a.c;
        ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(list);
        Address address = this.q.a;
        if (address.f == null) {
            if (!list.contains(ConnectionSpec.d)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String str = this.q.a.a.g;
            Platform2.a aVar = Platform2.c;
            if (!Platform2.a.h(str)) {
                throw new RouteException(new UnknownServiceException(outline.y("CLEARTEXT communication to ", str, " not permitted by network security policy")));
            }
        } else if (address.f3601b.contains(Protocol2.H2_PRIOR_KNOWLEDGE)) {
            throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        RouteException routeException = null;
        while (true) {
            try {
                if (this.q.a()) {
                    f(i, i2, i3, call2, eventListener);
                    if (this.f3620b == null) {
                        break;
                    }
                } else {
                    try {
                        e(i, i2, call2, eventListener);
                    } catch (IOException e) {
                        e = e;
                        socket = this.c;
                        if (socket != null) {
                            Util7.e(socket);
                        }
                        socket2 = this.f3620b;
                        if (socket2 != null) {
                            Util7.e(socket2);
                        }
                        this.c = null;
                        this.f3620b = null;
                        this.g = null;
                        this.h = null;
                        this.d = null;
                        this.e = null;
                        this.f = null;
                        this.n = 1;
                        Route route = this.q;
                        InetSocketAddress inetSocketAddress = route.c;
                        Proxy proxy = route.f3603b;
                        Objects.requireNonNull(eventListener);
                        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
                        Intrinsics3.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
                        Intrinsics3.checkParameterIsNotNull(proxy, "proxy");
                        Intrinsics3.checkParameterIsNotNull(e, "ioe");
                        if (routeException == null) {
                            routeException = new RouteException(e);
                        } else {
                            routeException.a(e);
                        }
                        if (z2) {
                            throw routeException;
                        }
                        Intrinsics3.checkParameterIsNotNull(e, "e");
                        connectionSpecSelector.c = true;
                        if (connectionSpecSelector.f3613b || (e instanceof ProtocolException) || (e instanceof InterruptedIOException) || (((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) || (e instanceof SSLPeerUnverifiedException) || !(e instanceof SSLException))) {
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
                    g(connectionSpecSelector, i4, call2, eventListener);
                    Route route2 = this.q;
                    InetSocketAddress inetSocketAddress2 = route2.c;
                    Proxy proxy2 = route2.f3603b;
                    Objects.requireNonNull(eventListener);
                    Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
                    Intrinsics3.checkParameterIsNotNull(inetSocketAddress2, "inetSocketAddress");
                    Intrinsics3.checkParameterIsNotNull(proxy2, "proxy");
                    break;
                } catch (IOException e2) {
                    e = e2;
                    socket = this.c;
                    if (socket != null) {
                        Util7.e(socket);
                    }
                    socket2 = this.f3620b;
                    if (socket2 != null) {
                        Util7.e(socket2);
                    }
                    this.c = null;
                    this.f3620b = null;
                    this.g = null;
                    this.h = null;
                    this.d = null;
                    this.e = null;
                    this.f = null;
                    this.n = 1;
                    Route route3 = this.q;
                    InetSocketAddress inetSocketAddress3 = route3.c;
                    Proxy proxy3 = route3.f3603b;
                    Objects.requireNonNull(eventListener);
                    Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
                    Intrinsics3.checkParameterIsNotNull(inetSocketAddress3, "inetSocketAddress");
                    Intrinsics3.checkParameterIsNotNull(proxy3, "proxy");
                    Intrinsics3.checkParameterIsNotNull(e, "ioe");
                    if (routeException == null) {
                        routeException = new RouteException(e);
                    } else {
                        routeException.a(e);
                    }
                    if (z2) {
                        throw routeException;
                    }
                    Intrinsics3.checkParameterIsNotNull(e, "e");
                    connectionSpecSelector.c = true;
                    if (connectionSpecSelector.f3613b) {
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

    public final void d(OkHttpClient okHttpClient, Route route, IOException iOException) {
        Intrinsics3.checkParameterIsNotNull(okHttpClient, "client");
        Intrinsics3.checkParameterIsNotNull(route, "failedRoute");
        Intrinsics3.checkParameterIsNotNull(iOException, "failure");
        if (route.f3603b.type() != Proxy.Type.DIRECT) {
            Address address = route.a;
            address.k.connectFailed(address.a.i(), route.f3603b.address(), iOException);
        }
        RouteDatabase routeDatabase = okHttpClient.O;
        synchronized (routeDatabase) {
            Intrinsics3.checkParameterIsNotNull(route, "failedRoute");
            routeDatabase.a.add(route);
        }
    }

    public final void e(int i, int i2, Call2 call2, EventListener eventListener) throws IOException {
        Socket socket;
        int i3;
        Route route = this.q;
        Proxy proxy = route.f3603b;
        Address address = route.a;
        Proxy.Type type = proxy.type();
        if (type != null && ((i3 = f.a[type.ordinal()]) == 1 || i3 == 2)) {
            socket = address.e.createSocket();
            if (socket == null) {
                Intrinsics3.throwNpe();
            }
        } else {
            socket = new Socket(proxy);
        }
        this.f3620b = socket;
        InetSocketAddress inetSocketAddress = this.q.c;
        Objects.requireNonNull(eventListener);
        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
        Intrinsics3.checkParameterIsNotNull(proxy, "proxy");
        socket.setSoTimeout(i2);
        try {
            Platform2.a aVar = Platform2.c;
            Platform2.a.e(socket, this.q.c, i);
            try {
                Source2 source2D1 = b.i.a.f.e.o.f.d1(socket);
                Intrinsics3.checkParameterIsNotNull(source2D1, "$this$buffer");
                this.g = new RealBufferedSource(source2D1);
                Sink sinkB1 = b.i.a.f.e.o.f.b1(socket);
                Intrinsics3.checkParameterIsNotNull(sinkB1, "$this$buffer");
                this.h = new RealBufferedSink(sinkB1);
            } catch (NullPointerException e) {
                if (Intrinsics3.areEqual(e.getMessage(), "throw with null exception")) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            StringBuilder sbU = outline.U("Failed to connect to ");
            sbU.append(this.q.c);
            ConnectException connectException = new ConnectException(sbU.toString());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    public final void f(int i, int i2, int i3, Call2 call2, EventListener eventListener) throws IOException {
        Request.a aVar = new Request.a();
        aVar.g(this.q.a.a);
        OkHttpClient okHttpClient = null;
        aVar.c("CONNECT", null);
        boolean z2 = true;
        aVar.b("Host", Util7.y(this.q.a.a, true));
        aVar.b("Proxy-Connection", "Keep-Alive");
        aVar.b("User-Agent", "okhttp/4.8.0");
        Request requestA = aVar.a();
        Response.a aVar2 = new Response.a();
        aVar2.g(requestA);
        aVar2.f(Protocol2.HTTP_1_1);
        aVar2.c = 407;
        aVar2.e("Preemptive Authenticate");
        aVar2.g = Util7.c;
        aVar2.k = -1L;
        aVar2.l = -1L;
        Intrinsics3.checkParameterIsNotNull("Proxy-Authenticate", ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull("OkHttp-Preemptive", "value");
        Headers.a aVar3 = aVar2.f;
        Objects.requireNonNull(aVar3);
        Intrinsics3.checkParameterIsNotNull("Proxy-Authenticate", ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull("OkHttp-Preemptive", "value");
        Headers.Companion companion = Headers.INSTANCE;
        companion.a("Proxy-Authenticate");
        companion.b("OkHttp-Preemptive", "Proxy-Authenticate");
        aVar3.d("Proxy-Authenticate");
        aVar3.b("Proxy-Authenticate", "OkHttp-Preemptive");
        Response responseA = aVar2.a();
        Route route = this.q;
        Request requestA2 = route.a.i.a(route, responseA);
        if (requestA2 != null) {
            requestA = requestA2;
        }
        HttpUrl httpUrl = requestA.url;
        int i4 = 0;
        while (i4 < 21) {
            e(i, i2, call2, eventListener);
            String str = "CONNECT " + Util7.y(httpUrl, z2) + " HTTP/1.1";
            while (true) {
                BufferedSource bufferedSource = this.g;
                if (bufferedSource == null) {
                    Intrinsics3.throwNpe();
                }
                BufferedSink bufferedSink = this.h;
                if (bufferedSink == null) {
                    Intrinsics3.throwNpe();
                }
                Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec(okHttpClient, this, bufferedSource, bufferedSink);
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                bufferedSource.timeout().g(i2, timeUnit);
                bufferedSink.timeout().g(i3, timeUnit);
                http1ExchangeCodec.k(requestA.headers, str);
                http1ExchangeCodec.g.flush();
                Response.a aVarD = http1ExchangeCodec.d(false);
                if (aVarD == null) {
                    Intrinsics3.throwNpe();
                }
                aVarD.g(requestA);
                Response responseA2 = aVarD.a();
                Intrinsics3.checkParameterIsNotNull(responseA2, "response");
                long jL = Util7.l(responseA2);
                if (jL != -1) {
                    Source2 source2J = http1ExchangeCodec.j(jL);
                    Util7.v(source2J, Integer.MAX_VALUE, timeUnit);
                    ((Http1ExchangeCodec.d) source2J).close();
                }
                int i5 = responseA2.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                if (i5 == 200) {
                    if (!bufferedSource.g().w() || !bufferedSink.g().w()) {
                        throw new IOException("TLS tunnel buffered too many bytes!");
                    }
                    requestA = null;
                    break;
                }
                if (i5 != 407) {
                    StringBuilder sbU = outline.U("Unexpected response code for CONNECT: ");
                    sbU.append(responseA2.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String);
                    throw new IOException(sbU.toString());
                }
                Route route2 = this.q;
                Request requestA3 = route2.a.i.a(route2, responseA2);
                if (requestA3 == null) {
                    throw new IOException("Failed to authenticate with proxy");
                }
                if (StringsJVM.equals("close", Response.a(responseA2, "Connection", null, 2), true)) {
                    requestA = requestA3;
                    break;
                } else {
                    okHttpClient = null;
                    requestA = requestA3;
                }
            }
            if (requestA == null) {
                return;
            }
            Socket socket = this.f3620b;
            if (socket != null) {
                Util7.e(socket);
            }
            okHttpClient = null;
            this.f3620b = null;
            this.h = null;
            this.g = null;
            Route route3 = this.q;
            InetSocketAddress inetSocketAddress = route3.c;
            Proxy proxy = route3.f3603b;
            Objects.requireNonNull(eventListener);
            Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
            Intrinsics3.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
            Intrinsics3.checkParameterIsNotNull(proxy, "proxy");
            i4++;
            z2 = true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x019f  */
    /* JADX WARN: Code duplicated, block: B:58:0x01a8  */
    public final void g(ConnectionSpecSelector connectionSpecSelector, int i, Call2 call2, EventListener eventListener) throws Throwable {
        SSLSocket sSLSocket;
        String strF;
        Protocol2 protocol2A = Protocol2.HTTP_1_1;
        Address address = this.q.a;
        if (address.f == null) {
            List<Protocol2> list = address.f3601b;
            Protocol2 protocol2 = Protocol2.H2_PRIOR_KNOWLEDGE;
            if (!list.contains(protocol2)) {
                this.c = this.f3620b;
                this.e = protocol2A;
                return;
            } else {
                this.c = this.f3620b;
                this.e = protocol2;
                o(i);
                return;
            }
        }
        Objects.requireNonNull(eventListener);
        Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
        Address address2 = this.q.a;
        SSLSocketFactory sSLSocketFactory = address2.f;
        if (sSLSocketFactory == null) {
            try {
                Intrinsics3.throwNpe();
            } catch (Throwable th) {
                th = th;
                sSLSocket = null;
                if (sSLSocket != null) {
                    Platform2.a aVar = Platform2.c;
                    Platform2.a.a(sSLSocket);
                }
                if (sSLSocket != null) {
                    Util7.e(sSLSocket);
                }
                throw th;
            }
        }
        Socket socket = this.f3620b;
        HttpUrl httpUrl = address2.a;
        Socket socketCreateSocket = sSLSocketFactory.createSocket(socket, httpUrl.g, httpUrl.h, true);
        if (socketCreateSocket == null) {
            throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
        }
        sSLSocket = (SSLSocket) socketCreateSocket;
        try {
            ConnectionSpec connectionSpecA = connectionSpecSelector.a(sSLSocket);
            if (connectionSpecA.f) {
                Platform2.a aVar2 = Platform2.c;
                Platform2.a.d(sSLSocket, address2.a.g, address2.f3601b);
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            Intrinsics3.checkExpressionValueIsNotNull(session, "sslSocketSession");
            Handshake handshakeA = Handshake.a(session);
            HostnameVerifier hostnameVerifier = address2.g;
            if (hostnameVerifier == null) {
                Intrinsics3.throwNpe();
            }
            if (hostnameVerifier.verify(address2.a.g, session)) {
                CertificatePinner certificatePinner = address2.h;
                if (certificatePinner == null) {
                    Intrinsics3.throwNpe();
                }
                this.d = new Handshake(handshakeA.f3680b, handshakeA.c, handshakeA.d, new RealConnection(certificatePinner, handshakeA, address2));
                certificatePinner.a(address2.a.g, new RealConnection2(this));
                if (connectionSpecA.f) {
                    Platform2.a aVar3 = Platform2.c;
                    strF = Platform2.a.f(sSLSocket);
                } else {
                    strF = null;
                }
                this.c = sSLSocket;
                Source2 source2D1 = b.i.a.f.e.o.f.d1(sSLSocket);
                Intrinsics3.checkParameterIsNotNull(source2D1, "$this$buffer");
                this.g = new RealBufferedSource(source2D1);
                Sink sinkB1 = b.i.a.f.e.o.f.b1(sSLSocket);
                Intrinsics3.checkParameterIsNotNull(sinkB1, "$this$buffer");
                this.h = new RealBufferedSink(sinkB1);
                if (strF != null) {
                    protocol2A = Protocol2.q.a(strF);
                }
                this.e = protocol2A;
                Platform2.a aVar4 = Platform2.c;
                Platform2.a.a(sSLSocket);
                Intrinsics3.checkParameterIsNotNull(call2, NotificationCompat.CATEGORY_CALL);
                if (this.e == Protocol2.HTTP_2) {
                    o(i);
                    return;
                }
                return;
            }
            List<Certificate> listC = handshakeA.c();
            if (!(!listC.isEmpty())) {
                throw new SSLPeerUnverifiedException("Hostname " + address2.a.g + " not verified (no certificates)");
            }
            Certificate certificate = listC.get(0);
            if (certificate == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            X509Certificate x509Certificate = (X509Certificate) certificate;
            StringBuilder sb = new StringBuilder();
            sb.append("\n              |Hostname ");
            sb.append(address2.a.g);
            sb.append(" not verified:\n              |    certificate: ");
            sb.append(CertificatePinner.f3670b.a(x509Certificate));
            sb.append("\n              |    DN: ");
            Principal subjectDN = x509Certificate.getSubjectDN();
            Intrinsics3.checkExpressionValueIsNotNull(subjectDN, "cert.subjectDN");
            sb.append(subjectDN.getName());
            sb.append("\n              |    subjectAltNames: ");
            OkHostnameVerifier okHostnameVerifier = OkHostnameVerifier.a;
            Intrinsics3.checkParameterIsNotNull(x509Certificate, "certificate");
            sb.append(_Collections.plus((Collection) okHostnameVerifier.a(x509Certificate, 7), (Iterable) okHostnameVerifier.a(x509Certificate, 2)));
            sb.append("\n              ");
            throw new SSLPeerUnverifiedException(Indent.trimMargin$default(sb.toString(), null, 1, null));
        } catch (Throwable th2) {
            th = th2;
            if (sSLSocket != null) {
                Platform2.a aVar5 = Platform2.c;
                Platform2.a.a(sSLSocket);
            }
            if (sSLSocket != null) {
                Util7.e(sSLSocket);
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00d3  */
    public final boolean h(Address address, List<Route> list) {
        boolean z2;
        boolean z3;
        Handshake handshake;
        boolean z4;
        Intrinsics3.checkParameterIsNotNull(address, "address");
        byte[] bArr = Util7.a;
        if (this.o.size() >= this.n || this.i || !this.q.a.a(address)) {
            return false;
        }
        if (Intrinsics3.areEqual(address.a.g, this.q.a.a.g)) {
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
                    Route route = (Route) it.next();
                    if (route.f3603b.type() == Proxy.Type.DIRECT && this.q.f3603b.type() == Proxy.Type.DIRECT && Intrinsics3.areEqual(this.q.c, route.c)) {
                        z2 = true;
                        break;
                    }
                }
            } else {
                z2 = false;
                break;
            }
            if (z2) {
                HostnameVerifier hostnameVerifier = address.g;
                OkHostnameVerifier okHostnameVerifier = OkHostnameVerifier.a;
                if (hostnameVerifier != okHostnameVerifier) {
                    return false;
                }
                HttpUrl httpUrl = address.a;
                byte[] bArr2 = Util7.a;
                HttpUrl httpUrl2 = this.q.a.a;
                if (httpUrl.h == httpUrl2.h) {
                    if (!Intrinsics3.areEqual(httpUrl.g, httpUrl2.g)) {
                        if (!this.j && (handshake = this.d) != null) {
                            List<Certificate> listC = handshake.c();
                            if (!listC.isEmpty()) {
                                String str = httpUrl.g;
                                Certificate certificate = listC.get(0);
                                if (certificate == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                                }
                                if (okHostnameVerifier.b(str, (X509Certificate) certificate)) {
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
                    CertificatePinner certificatePinner = address.h;
                    if (certificatePinner == null) {
                        Intrinsics3.throwNpe();
                    }
                    String str2 = address.a.g;
                    Handshake handshake2 = this.d;
                    if (handshake2 == null) {
                        Intrinsics3.throwNpe();
                    }
                    List<Certificate> listC2 = handshake2.c();
                    Objects.requireNonNull(certificatePinner);
                    Intrinsics3.checkParameterIsNotNull(str2, "hostname");
                    Intrinsics3.checkParameterIsNotNull(listC2, "peerCertificates");
                    certificatePinner.a(str2, new CertificatePinner2(certificatePinner, listC2, str2));
                    return true;
                } catch (SSLPeerUnverifiedException unused) {
                }
            }
        }
        return false;
    }

    public final boolean i(boolean z2) {
        long j;
        byte[] bArr = Util7.a;
        long jNanoTime = System.nanoTime();
        Socket socket = this.f3620b;
        if (socket == null) {
            Intrinsics3.throwNpe();
        }
        Socket socket2 = this.c;
        if (socket2 == null) {
            Intrinsics3.throwNpe();
        }
        BufferedSource bufferedSource = this.g;
        if (bufferedSource == null) {
            Intrinsics3.throwNpe();
        }
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.f;
        if (http2Connection != null) {
            synchronized (http2Connection) {
                if (http2Connection.r) {
                    return false;
                }
                return http2Connection.A >= http2Connection.f3641z || jNanoTime < http2Connection.C;
            }
        }
        synchronized (this) {
            j = jNanoTime - this.p;
        }
        if (j < 10000000000L || !z2) {
            return true;
        }
        Intrinsics3.checkParameterIsNotNull(socket2, "$this$isHealthy");
        Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
        try {
            int soTimeout = socket2.getSoTimeout();
            try {
                socket2.setSoTimeout(1);
                return !bufferedSource.w();
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

    public final ExchangeCodec k(OkHttpClient okHttpClient, RealInterceptorChain realInterceptorChain) throws SocketException {
        Intrinsics3.checkParameterIsNotNull(okHttpClient, "client");
        Intrinsics3.checkParameterIsNotNull(realInterceptorChain, "chain");
        Socket socket = this.c;
        if (socket == null) {
            Intrinsics3.throwNpe();
        }
        BufferedSource bufferedSource = this.g;
        if (bufferedSource == null) {
            Intrinsics3.throwNpe();
        }
        BufferedSink bufferedSink = this.h;
        if (bufferedSink == null) {
            Intrinsics3.throwNpe();
        }
        Http2Connection http2Connection = this.f;
        if (http2Connection != null) {
            return new Http2ExchangeCodec(okHttpClient, this, realInterceptorChain, http2Connection);
        }
        socket.setSoTimeout(realInterceptorChain.h);
        Timeout2 timeout2Timeout = bufferedSource.timeout();
        long j = realInterceptorChain.h;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout2Timeout.g(j, timeUnit);
        bufferedSink.timeout().g(realInterceptorChain.i, timeUnit);
        return new Http1ExchangeCodec(okHttpClient, this, bufferedSource, bufferedSink);
    }

    public final synchronized void l() {
        this.i = true;
    }

    public Protocol2 m() {
        Protocol2 protocol2 = this.e;
        if (protocol2 == null) {
            Intrinsics3.throwNpe();
        }
        return protocol2;
    }

    public Socket n() {
        Socket socket = this.c;
        if (socket == null) {
            Intrinsics3.throwNpe();
        }
        return socket;
    }

    public final void o(int i) throws IOException {
        String strW;
        int i2;
        Socket socket = this.c;
        if (socket == null) {
            Intrinsics3.throwNpe();
        }
        BufferedSource bufferedSource = this.g;
        if (bufferedSource == null) {
            Intrinsics3.throwNpe();
        }
        BufferedSink bufferedSink = this.h;
        if (bufferedSink == null) {
            Intrinsics3.throwNpe();
        }
        socket.setSoTimeout(0);
        TaskRunner taskRunner = TaskRunner.a;
        Http2Connection.b bVar = new Http2Connection.b(true, taskRunner);
        String str = this.q.a.a.g;
        Intrinsics3.checkParameterIsNotNull(socket, "socket");
        Intrinsics3.checkParameterIsNotNull(str, "peerName");
        Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
        Intrinsics3.checkParameterIsNotNull(bufferedSink, "sink");
        bVar.a = socket;
        if (bVar.h) {
            strW = Util7.g + ' ' + str;
        } else {
            strW = outline.w("MockWebServer ", str);
        }
        bVar.f3642b = strW;
        bVar.c = bufferedSource;
        bVar.d = bufferedSink;
        Intrinsics3.checkParameterIsNotNull(this, "listener");
        bVar.e = this;
        bVar.g = i;
        Http2Connection http2Connection = new Http2Connection(bVar);
        this.f = http2Connection;
        Http2Connection http2Connection2 = Http2Connection.k;
        Settings3 settings3 = Http2Connection.j;
        this.n = (settings3.a & 16) != 0 ? settings3.f3647b[4] : Integer.MAX_VALUE;
        Intrinsics3.checkParameterIsNotNull(taskRunner, "taskRunner");
        Http2Writer http2Writer = http2Connection.K;
        synchronized (http2Writer) {
            if (http2Writer.m) {
                throw new IOException("closed");
            }
            if (http2Writer.p) {
                Logger logger = Http2Writer.j;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Util7.j(">> CONNECTION " + Http2.a.k(), new Object[0]));
                }
                http2Writer.o.e0(Http2.a);
                http2Writer.o.flush();
            }
        }
        Http2Writer http2Writer2 = http2Connection.K;
        Settings3 settings4 = http2Connection.D;
        synchronized (http2Writer2) {
            Intrinsics3.checkParameterIsNotNull(settings4, "settings");
            if (http2Writer2.m) {
                throw new IOException("closed");
            }
            http2Writer2.c(0, Integer.bitCount(settings4.a) * 6, 4, 0);
            int i3 = 0;
            while (i3 < 10) {
                if (((1 << i3) & settings4.a) != 0) {
                    if (i3 != 4) {
                        i2 = i3 != 7 ? i3 : 4;
                    } else {
                        i2 = 3;
                    }
                    http2Writer2.o.writeShort(i2);
                    http2Writer2.o.writeInt(settings4.f3647b[i3]);
                }
                i3++;
            }
            http2Writer2.o.flush();
        }
        int iA = http2Connection.D.a();
        if (iA != 65535) {
            http2Connection.K.q(0, iA - 65535);
        }
        TaskQueue2 taskQueue2F = taskRunner.f();
        String str2 = http2Connection.o;
        taskQueue2F.c(new TaskQueue(http2Connection.L, str2, true, str2, true), 0L);
    }

    public String toString() {
        Object obj;
        StringBuilder sbU = outline.U("Connection{");
        sbU.append(this.q.a.a.g);
        sbU.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        sbU.append(this.q.a.a.h);
        sbU.append(',');
        sbU.append(" proxy=");
        sbU.append(this.q.f3603b);
        sbU.append(" hostAddress=");
        sbU.append(this.q.c);
        sbU.append(" cipherSuite=");
        Handshake handshake = this.d;
        if (handshake == null || (obj = handshake.c) == null) {
            obj = "none";
        }
        sbU.append(obj);
        sbU.append(" protocol=");
        sbU.append(this.e);
        sbU.append('}');
        return sbU.toString();
    }
}
