package p600f0.p601e0.p605g;

import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
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
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p579g0.C12096m;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;
import p600f0.AbstractC12376t;
import p600f0.C12261a;
import p600f0.C12266c0;
import p600f0.C12363g;
import p600f0.C12364h;
import p600f0.C12369m;
import p600f0.C12378v;
import p600f0.C12379w;
import p600f0.C12380x;
import p600f0.EnumC12381y;
import p600f0.InterfaceC12269e;
import p600f0.InterfaceC12367k;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p604f.C12278b;
import p600f0.p601e0.p604f.C12279c;
import p600f0.p601e0.p604f.C12280d;
import p600f0.p601e0.p606h.C12301g;
import p600f0.p601e0.p606h.InterfaceC12298d;
import p600f0.p601e0.p607i.C12306b;
import p600f0.p601e0.p608j.C12310d;
import p600f0.p601e0.p608j.C12311e;
import p600f0.p601e0.p608j.C12318l;
import p600f0.p601e0.p608j.C12320n;
import p600f0.p601e0.p608j.C12321o;
import p600f0.p601e0.p608j.C12325s;
import p600f0.p601e0.p608j.EnumC12307a;
import p600f0.p601e0.p609k.C12333h;
import p600f0.p601e0.p612m.C12350d;
import p615g0.C12400q;
import p615g0.C12401r;
import p615g0.C12408y;
import p615g0.InterfaceC12390g;
import p615g0.InterfaceC12405v;
import p615g0.InterfaceC12407x;

/* JADX INFO: renamed from: f0.e0.g.j */
/* JADX INFO: compiled from: RealConnection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12290j extends C12311e.c implements InterfaceC12367k {

    /* JADX INFO: renamed from: b */
    public Socket f25491b;

    /* JADX INFO: renamed from: c */
    public Socket f25492c;

    /* JADX INFO: renamed from: d */
    public C12378v f25493d;

    /* JADX INFO: renamed from: e */
    public EnumC12381y f25494e;

    /* JADX INFO: renamed from: f */
    public C12311e f25495f;

    /* JADX INFO: renamed from: g */
    public InterfaceC12390g f25496g;

    /* JADX INFO: renamed from: h */
    public BufferedSink f25497h;

    /* JADX INFO: renamed from: i */
    public boolean f25498i;

    /* JADX INFO: renamed from: j */
    public boolean f25499j;

    /* JADX INFO: renamed from: k */
    public int f25500k;

    /* JADX INFO: renamed from: l */
    public int f25501l;

    /* JADX INFO: renamed from: m */
    public int f25502m;

    /* JADX INFO: renamed from: n */
    public int f25503n;

    /* JADX INFO: renamed from: o */
    public final List<Reference<C12285e>> f25504o;

    /* JADX INFO: renamed from: p */
    public long f25505p;

    /* JADX INFO: renamed from: q */
    public final C12266c0 f25506q;

    public C12290j(C12291k c12291k, C12266c0 c12266c0) {
        C12238m.checkParameterIsNotNull(c12291k, "connectionPool");
        C12238m.checkParameterIsNotNull(c12266c0, "route");
        this.f25506q = c12266c0;
        this.f25503n = 1;
        this.f25504o = new ArrayList();
        this.f25505p = RecyclerView.FOREVER_NS;
    }

    @Override // p600f0.p601e0.p608j.C12311e.c
    /* JADX INFO: renamed from: a */
    public synchronized void mo10192a(C12311e c12311e, C12325s c12325s) {
        C12238m.checkParameterIsNotNull(c12311e, "connection");
        C12238m.checkParameterIsNotNull(c12325s, "settings");
        this.f25503n = (c12325s.f25752a & 16) != 0 ? c12325s.f25753b[4] : Integer.MAX_VALUE;
    }

    @Override // p600f0.p601e0.p608j.C12311e.c
    /* JADX INFO: renamed from: b */
    public void mo10193b(C12320n c12320n) throws IOException {
        C12238m.checkParameterIsNotNull(c12320n, "stream");
        c12320n.m10284c(EnumC12307a.REFUSED_STREAM, null);
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
    /* JADX INFO: renamed from: c */
    public final void m10194c(int i, int i2, int i3, int i4, boolean z2, InterfaceC12269e interfaceC12269e, AbstractC12376t abstractC12376t) throws Throwable {
        Socket socket;
        Socket socket2;
        boolean z3;
        C12238m.checkParameterIsNotNull(interfaceC12269e, NotificationCompat.CATEGORY_CALL);
        C12238m.checkParameterIsNotNull(abstractC12376t, "eventListener");
        if (!(this.f25494e == null)) {
            throw new IllegalStateException("already connected".toString());
        }
        List<C12369m> list = this.f25506q.f25370a.f25355c;
        C12282b c12282b = new C12282b(list);
        C12261a c12261a = this.f25506q.f25370a;
        if (c12261a.f25358f == null) {
            if (!list.contains(C12369m.f25933d)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String str = this.f25506q.f25370a.f25353a.f25979g;
            C12333h.a aVar = C12333h.f25785c;
            if (!C12333h.f25783a.mo10318h(str)) {
                throw new RouteException(new UnknownServiceException(C1643a.m886y("CLEARTEXT communication to ", str, " not permitted by network security policy")));
            }
        } else if (c12261a.f25354b.contains(EnumC12381y.H2_PRIOR_KNOWLEDGE)) {
            throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        RouteException routeException = null;
        while (true) {
            try {
                if (this.f25506q.m10106a()) {
                    m10197f(i, i2, i3, interfaceC12269e, abstractC12376t);
                    if (this.f25491b == null) {
                        break;
                    }
                } else {
                    try {
                        m10196e(i, i2, interfaceC12269e, abstractC12376t);
                    } catch (IOException e) {
                        e = e;
                        socket = this.f25492c;
                        if (socket != null) {
                            C12272c.m10124e(socket);
                        }
                        socket2 = this.f25491b;
                        if (socket2 != null) {
                            C12272c.m10124e(socket2);
                        }
                        this.f25492c = null;
                        this.f25491b = null;
                        this.f25496g = null;
                        this.f25497h = null;
                        this.f25493d = null;
                        this.f25494e = null;
                        this.f25495f = null;
                        this.f25503n = 1;
                        C12266c0 c12266c0 = this.f25506q;
                        InetSocketAddress inetSocketAddress = c12266c0.f25372c;
                        Proxy proxy = c12266c0.f25371b;
                        Objects.requireNonNull(abstractC12376t);
                        C12238m.checkParameterIsNotNull(interfaceC12269e, NotificationCompat.CATEGORY_CALL);
                        C12238m.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
                        C12238m.checkParameterIsNotNull(proxy, "proxy");
                        C12238m.checkParameterIsNotNull(e, "ioe");
                        if (routeException == null) {
                            routeException = new RouteException(e);
                        } else {
                            routeException.m10999a(e);
                        }
                        if (z2) {
                            throw routeException;
                        }
                        C12238m.checkParameterIsNotNull(e, "e");
                        c12282b.f25435c = true;
                        if (c12282b.f25434b || (e instanceof ProtocolException) || (e instanceof InterruptedIOException) || (((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) || (e instanceof SSLPeerUnverifiedException) || !(e instanceof SSLException))) {
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
                    m10198g(c12282b, i4, interfaceC12269e, abstractC12376t);
                    C12266c0 c12266c1 = this.f25506q;
                    InetSocketAddress inetSocketAddress2 = c12266c1.f25372c;
                    Proxy proxy2 = c12266c1.f25371b;
                    Objects.requireNonNull(abstractC12376t);
                    C12238m.checkParameterIsNotNull(interfaceC12269e, NotificationCompat.CATEGORY_CALL);
                    C12238m.checkParameterIsNotNull(inetSocketAddress2, "inetSocketAddress");
                    C12238m.checkParameterIsNotNull(proxy2, "proxy");
                    break;
                } catch (IOException e2) {
                    e = e2;
                    socket = this.f25492c;
                    if (socket != null) {
                        C12272c.m10124e(socket);
                    }
                    socket2 = this.f25491b;
                    if (socket2 != null) {
                        C12272c.m10124e(socket2);
                    }
                    this.f25492c = null;
                    this.f25491b = null;
                    this.f25496g = null;
                    this.f25497h = null;
                    this.f25493d = null;
                    this.f25494e = null;
                    this.f25495f = null;
                    this.f25503n = 1;
                    C12266c0 c12266c2 = this.f25506q;
                    InetSocketAddress inetSocketAddress3 = c12266c2.f25372c;
                    Proxy proxy3 = c12266c2.f25371b;
                    Objects.requireNonNull(abstractC12376t);
                    C12238m.checkParameterIsNotNull(interfaceC12269e, NotificationCompat.CATEGORY_CALL);
                    C12238m.checkParameterIsNotNull(inetSocketAddress3, "inetSocketAddress");
                    C12238m.checkParameterIsNotNull(proxy3, "proxy");
                    C12238m.checkParameterIsNotNull(e, "ioe");
                    if (routeException == null) {
                        routeException = new RouteException(e);
                    } else {
                        routeException.m10999a(e);
                    }
                    if (z2) {
                        throw routeException;
                    }
                    C12238m.checkParameterIsNotNull(e, "e");
                    c12282b.f25435c = true;
                    if (c12282b.f25434b) {
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
        if (this.f25506q.m10106a() && this.f25491b == null) {
            throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        this.f25505p = System.nanoTime();
    }

    /* JADX INFO: renamed from: d */
    public final void m10195d(C12380x c12380x, C12266c0 c12266c0, IOException iOException) {
        C12238m.checkParameterIsNotNull(c12380x, "client");
        C12238m.checkParameterIsNotNull(c12266c0, "failedRoute");
        C12238m.checkParameterIsNotNull(iOException, "failure");
        if (c12266c0.f25371b.type() != Proxy.Type.DIRECT) {
            C12261a c12261a = c12266c0.f25370a;
            c12261a.f25363k.connectFailed(c12261a.f25353a.m10407i(), c12266c0.f25371b.address(), iOException);
        }
        C12292l c12292l = c12380x.f26011O;
        synchronized (c12292l) {
            C12238m.checkParameterIsNotNull(c12266c0, "failedRoute");
            c12292l.f25513a.add(c12266c0);
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m10196e(int i, int i2, InterfaceC12269e interfaceC12269e, AbstractC12376t abstractC12376t) throws IOException {
        Socket socket;
        int i3;
        C12266c0 c12266c0 = this.f25506q;
        Proxy proxy = c12266c0.f25371b;
        C12261a c12261a = c12266c0.f25370a;
        Proxy.Type type = proxy.type();
        if (type != null && ((i3 = C12286f.f25487a[type.ordinal()]) == 1 || i3 == 2)) {
            socket = c12261a.f25357e.createSocket();
            if (socket == null) {
                C12238m.throwNpe();
            }
        } else {
            socket = new Socket(proxy);
        }
        this.f25491b = socket;
        InetSocketAddress inetSocketAddress = this.f25506q.f25372c;
        Objects.requireNonNull(abstractC12376t);
        C12238m.checkParameterIsNotNull(interfaceC12269e, NotificationCompat.CATEGORY_CALL);
        C12238m.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
        C12238m.checkParameterIsNotNull(proxy, "proxy");
        socket.setSoTimeout(i2);
        try {
            C12333h.a aVar = C12333h.f25785c;
            C12333h.f25783a.mo10320e(socket, this.f25506q.f25372c, i);
            try {
                InterfaceC12407x interfaceC12407xM4281d1 = C3404f.m4281d1(socket);
                C12238m.checkParameterIsNotNull(interfaceC12407xM4281d1, "$this$buffer");
                this.f25496g = new C12401r(interfaceC12407xM4281d1);
                InterfaceC12405v interfaceC12405vM4273b1 = C3404f.m4273b1(socket);
                C12238m.checkParameterIsNotNull(interfaceC12405vM4273b1, "$this$buffer");
                this.f25497h = new C12400q(interfaceC12405vM4273b1);
            } catch (NullPointerException e) {
                if (C12238m.areEqual(e.getMessage(), "throw with null exception")) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            StringBuilder sbM833U = C1643a.m833U("Failed to connect to ");
            sbM833U.append(this.f25506q.f25372c);
            ConnectException connectException = new ConnectException(sbM833U.toString());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m10197f(int i, int i2, int i3, InterfaceC12269e interfaceC12269e, AbstractC12376t abstractC12376t) throws IOException {
        Request.C12935a c12935a = new Request.C12935a();
        c12935a.m10984g(this.f25506q.f25370a.f25353a);
        C12380x c12380x = null;
        c12935a.m10980c("CONNECT", null);
        boolean z2 = true;
        c12935a.m10979b("Host", C12272c.m10144y(this.f25506q.f25370a.f25353a, true));
        c12935a.m10979b("Proxy-Connection", "Keep-Alive");
        c12935a.m10979b("User-Agent", "okhttp/4.8.0");
        Request requestM10978a = c12935a.m10978a();
        Response.C12937a c12937a = new Response.C12937a();
        c12937a.m10997g(requestM10978a);
        c12937a.m10996f(EnumC12381y.HTTP_1_1);
        c12937a.f27567c = 407;
        c12937a.m10995e("Preemptive Authenticate");
        c12937a.f27571g = C12272c.f25399c;
        c12937a.f27575k = -1L;
        c12937a.f27576l = -1L;
        C12238m.checkParameterIsNotNull("Proxy-Authenticate", ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkParameterIsNotNull("OkHttp-Preemptive", "value");
        Headers.C12930a c12930a = c12937a.f27570f;
        Objects.requireNonNull(c12930a);
        C12238m.checkParameterIsNotNull("Proxy-Authenticate", ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkParameterIsNotNull("OkHttp-Preemptive", "value");
        Headers.Companion companion = Headers.INSTANCE;
        companion.m10962a("Proxy-Authenticate");
        companion.m10963b("OkHttp-Preemptive", "Proxy-Authenticate");
        c12930a.m10961d("Proxy-Authenticate");
        c12930a.m10959b("Proxy-Authenticate", "OkHttp-Preemptive");
        Response responseM10991a = c12937a.m10991a();
        C12266c0 c12266c0 = this.f25506q;
        Request requestMo10102a = c12266c0.f25370a.f25361i.mo10102a(c12266c0, responseM10991a);
        if (requestMo10102a != null) {
            requestM10978a = requestMo10102a;
        }
        C12379w c12379w = requestM10978a.url;
        int i4 = 0;
        while (i4 < 21) {
            m10196e(i, i2, interfaceC12269e, abstractC12376t);
            String str = "CONNECT " + C12272c.m10144y(c12379w, z2) + " HTTP/1.1";
            while (true) {
                InterfaceC12390g interfaceC12390g = this.f25496g;
                if (interfaceC12390g == null) {
                    C12238m.throwNpe();
                }
                BufferedSink bufferedSink = this.f25497h;
                if (bufferedSink == null) {
                    C12238m.throwNpe();
                }
                C12306b c12306b = new C12306b(c12380x, this, interfaceC12390g, bufferedSink);
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                interfaceC12390g.timeout().mo10484g(i2, timeUnit);
                bufferedSink.timeout().mo10484g(i3, timeUnit);
                c12306b.m10239k(requestM10978a.headers, str);
                c12306b.f25555g.flush();
                Response.C12937a c12937aMo10216d = c12306b.mo10216d(false);
                if (c12937aMo10216d == null) {
                    C12238m.throwNpe();
                }
                c12937aMo10216d.m10997g(requestM10978a);
                Response responseM10991a2 = c12937aMo10216d.m10991a();
                C12238m.checkParameterIsNotNull(responseM10991a2, "response");
                long jM10131l = C12272c.m10131l(responseM10991a2);
                if (jM10131l != -1) {
                    InterfaceC12407x interfaceC12407xM10238j = c12306b.m10238j(jM10131l);
                    C12272c.m10141v(interfaceC12407xM10238j, Integer.MAX_VALUE, timeUnit);
                    ((C12306b.d) interfaceC12407xM10238j).close();
                }
                int i5 = responseM10991a2.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                if (i5 == 200) {
                    if (!interfaceC12390g.mo10457g().mo10472w() || !bufferedSink.mo10457g().mo10472w()) {
                        throw new IOException("TLS tunnel buffered too many bytes!");
                    }
                    requestM10978a = null;
                    break;
                }
                if (i5 != 407) {
                    StringBuilder sbM833U = C1643a.m833U("Unexpected response code for CONNECT: ");
                    sbM833U.append(responseM10991a2.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String);
                    throw new IOException(sbM833U.toString());
                }
                C12266c0 c12266c1 = this.f25506q;
                Request requestMo10102a2 = c12266c1.f25370a.f25361i.mo10102a(c12266c1, responseM10991a2);
                if (requestMo10102a2 == null) {
                    throw new IOException("Failed to authenticate with proxy");
                }
                if (C12103t.equals("close", Response.m10989a(responseM10991a2, "Connection", null, 2), true)) {
                    requestM10978a = requestMo10102a2;
                    break;
                } else {
                    c12380x = null;
                    requestM10978a = requestMo10102a2;
                }
            }
            if (requestM10978a == null) {
                return;
            }
            Socket socket = this.f25491b;
            if (socket != null) {
                C12272c.m10124e(socket);
            }
            c12380x = null;
            this.f25491b = null;
            this.f25497h = null;
            this.f25496g = null;
            C12266c0 c12266c2 = this.f25506q;
            InetSocketAddress inetSocketAddress = c12266c2.f25372c;
            Proxy proxy = c12266c2.f25371b;
            Objects.requireNonNull(abstractC12376t);
            C12238m.checkParameterIsNotNull(interfaceC12269e, NotificationCompat.CATEGORY_CALL);
            C12238m.checkParameterIsNotNull(inetSocketAddress, "inetSocketAddress");
            C12238m.checkParameterIsNotNull(proxy, "proxy");
            i4++;
            z2 = true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x019f  */
    /* JADX WARN: Code duplicated, block: B:58:0x01a8  */
    /* JADX INFO: renamed from: g */
    public final void m10198g(C12282b c12282b, int i, InterfaceC12269e interfaceC12269e, AbstractC12376t abstractC12376t) throws Throwable {
        SSLSocket sSLSocket;
        String strMo10317f;
        EnumC12381y enumC12381yM10423a = EnumC12381y.HTTP_1_1;
        C12261a c12261a = this.f25506q.f25370a;
        if (c12261a.f25358f == null) {
            List<EnumC12381y> list = c12261a.f25354b;
            EnumC12381y enumC12381y = EnumC12381y.H2_PRIOR_KNOWLEDGE;
            if (!list.contains(enumC12381y)) {
                this.f25492c = this.f25491b;
                this.f25494e = enumC12381yM10423a;
                return;
            } else {
                this.f25492c = this.f25491b;
                this.f25494e = enumC12381y;
                m10206o(i);
                return;
            }
        }
        Objects.requireNonNull(abstractC12376t);
        C12238m.checkParameterIsNotNull(interfaceC12269e, NotificationCompat.CATEGORY_CALL);
        C12261a c12261a2 = this.f25506q.f25370a;
        SSLSocketFactory sSLSocketFactory = c12261a2.f25358f;
        if (sSLSocketFactory == null) {
            try {
                C12238m.throwNpe();
            } catch (Throwable th) {
                th = th;
                sSLSocket = null;
                if (sSLSocket != null) {
                    C12333h.a aVar = C12333h.f25785c;
                    C12333h.f25783a.mo10328a(sSLSocket);
                }
                if (sSLSocket != null) {
                    C12272c.m10124e(sSLSocket);
                }
                throw th;
            }
        }
        Socket socket = this.f25491b;
        C12379w c12379w = c12261a2.f25353a;
        Socket socketCreateSocket = sSLSocketFactory.createSocket(socket, c12379w.f25979g, c12379w.f25980h, true);
        if (socketCreateSocket == null) {
            throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
        }
        sSLSocket = (SSLSocket) socketCreateSocket;
        try {
            C12369m c12369mM10166a = c12282b.m10166a(sSLSocket);
            if (c12369mM10166a.f25935f) {
                C12333h.a aVar2 = C12333h.f25785c;
                C12333h.f25783a.mo10316d(sSLSocket, c12261a2.f25353a.f25979g, c12261a2.f25354b);
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            C12238m.checkExpressionValueIsNotNull(session, "sslSocketSession");
            C12378v c12378vM10395a = C12378v.m10395a(session);
            HostnameVerifier hostnameVerifier = c12261a2.f25359g;
            if (hostnameVerifier == null) {
                C12238m.throwNpe();
            }
            if (hostnameVerifier.verify(c12261a2.f25353a.f25979g, session)) {
                C12363g c12363g = c12261a2.f25360h;
                if (c12363g == null) {
                    C12238m.throwNpe();
                }
                this.f25493d = new C12378v(c12378vM10395a.f25970b, c12378vM10395a.f25971c, c12378vM10395a.f25972d, new C12287g(c12363g, c12378vM10395a, c12261a2));
                c12363g.m10368a(c12261a2.f25353a.f25979g, new C12288h(this));
                if (c12369mM10166a.f25935f) {
                    C12333h.a aVar3 = C12333h.f25785c;
                    strMo10317f = C12333h.f25783a.mo10317f(sSLSocket);
                } else {
                    strMo10317f = null;
                }
                this.f25492c = sSLSocket;
                InterfaceC12407x interfaceC12407xM4281d1 = C3404f.m4281d1(sSLSocket);
                C12238m.checkParameterIsNotNull(interfaceC12407xM4281d1, "$this$buffer");
                this.f25496g = new C12401r(interfaceC12407xM4281d1);
                InterfaceC12405v interfaceC12405vM4273b1 = C3404f.m4273b1(sSLSocket);
                C12238m.checkParameterIsNotNull(interfaceC12405vM4273b1, "$this$buffer");
                this.f25497h = new C12400q(interfaceC12405vM4273b1);
                if (strMo10317f != null) {
                    enumC12381yM10423a = EnumC12381y.f26062q.m10423a(strMo10317f);
                }
                this.f25494e = enumC12381yM10423a;
                C12333h.a aVar4 = C12333h.f25785c;
                C12333h.f25783a.mo10328a(sSLSocket);
                C12238m.checkParameterIsNotNull(interfaceC12269e, NotificationCompat.CATEGORY_CALL);
                if (this.f25494e == EnumC12381y.HTTP_2) {
                    m10206o(i);
                    return;
                }
                return;
            }
            List<Certificate> listM10398c = c12378vM10395a.m10398c();
            if (!(!listM10398c.isEmpty())) {
                throw new SSLPeerUnverifiedException("Hostname " + c12261a2.f25353a.f25979g + " not verified (no certificates)");
            }
            Certificate certificate = listM10398c.get(0);
            if (certificate == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            X509Certificate x509Certificate = (X509Certificate) certificate;
            StringBuilder sb = new StringBuilder();
            sb.append("\n              |Hostname ");
            sb.append(c12261a2.f25353a.f25979g);
            sb.append(" not verified:\n              |    certificate: ");
            sb.append(C12363g.f25904b.m10370a(x509Certificate));
            sb.append("\n              |    DN: ");
            Principal subjectDN = x509Certificate.getSubjectDN();
            C12238m.checkExpressionValueIsNotNull(subjectDN, "cert.subjectDN");
            sb.append(subjectDN.getName());
            sb.append("\n              |    subjectAltNames: ");
            C12350d c12350d = C12350d.f25811a;
            C12238m.checkParameterIsNotNull(x509Certificate, "certificate");
            sb.append(C12163u.plus((Collection) c12350d.m10343a(x509Certificate, 7), (Iterable) c12350d.m10343a(x509Certificate, 2)));
            sb.append("\n              ");
            throw new SSLPeerUnverifiedException(C12096m.trimMargin$default(sb.toString(), null, 1, null));
        } catch (Throwable th2) {
            th = th2;
            if (sSLSocket != null) {
                C12333h.a aVar5 = C12333h.f25785c;
                C12333h.f25783a.mo10328a(sSLSocket);
            }
            if (sSLSocket != null) {
                C12272c.m10124e(sSLSocket);
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00d3  */
    /* JADX INFO: renamed from: h */
    public final boolean m10199h(C12261a c12261a, List<C12266c0> list) {
        boolean z2;
        boolean z3;
        C12378v c12378v;
        boolean z4;
        C12238m.checkParameterIsNotNull(c12261a, "address");
        byte[] bArr = C12272c.f25397a;
        if (this.f25504o.size() >= this.f25503n || this.f25498i || !this.f25506q.f25370a.m10101a(c12261a)) {
            return false;
        }
        if (C12238m.areEqual(c12261a.f25353a.f25979g, this.f25506q.f25370a.f25353a.f25979g)) {
            return true;
        }
        if (this.f25495f != null && list != null) {
            if (!list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    C12266c0 c12266c0 = (C12266c0) it.next();
                    if (c12266c0.f25371b.type() == Proxy.Type.DIRECT && this.f25506q.f25371b.type() == Proxy.Type.DIRECT && C12238m.areEqual(this.f25506q.f25372c, c12266c0.f25372c)) {
                        z2 = true;
                        break;
                    }
                }
            } else {
                z2 = false;
                break;
            }
            if (z2) {
                HostnameVerifier hostnameVerifier = c12261a.f25359g;
                C12350d c12350d = C12350d.f25811a;
                if (hostnameVerifier != c12350d) {
                    return false;
                }
                C12379w c12379w = c12261a.f25353a;
                byte[] bArr2 = C12272c.f25397a;
                C12379w c12379w2 = this.f25506q.f25370a.f25353a;
                if (c12379w.f25980h == c12379w2.f25980h) {
                    if (!C12238m.areEqual(c12379w.f25979g, c12379w2.f25979g)) {
                        if (!this.f25499j && (c12378v = this.f25493d) != null) {
                            List<Certificate> listM10398c = c12378v.m10398c();
                            if (!listM10398c.isEmpty()) {
                                String str = c12379w.f25979g;
                                Certificate certificate = listM10398c.get(0);
                                if (certificate == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                                }
                                if (c12350d.m10344b(str, (X509Certificate) certificate)) {
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
                    C12363g c12363g = c12261a.f25360h;
                    if (c12363g == null) {
                        C12238m.throwNpe();
                    }
                    String str2 = c12261a.f25353a.f25979g;
                    C12378v c12378v2 = this.f25493d;
                    if (c12378v2 == null) {
                        C12238m.throwNpe();
                    }
                    List<Certificate> listM10398c2 = c12378v2.m10398c();
                    Objects.requireNonNull(c12363g);
                    C12238m.checkParameterIsNotNull(str2, "hostname");
                    C12238m.checkParameterIsNotNull(listM10398c2, "peerCertificates");
                    c12363g.m10368a(str2, new C12364h(c12363g, listM10398c2, str2));
                    return true;
                } catch (SSLPeerUnverifiedException unused) {
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: i */
    public final boolean m10200i(boolean z2) {
        long j;
        byte[] bArr = C12272c.f25397a;
        long jNanoTime = System.nanoTime();
        Socket socket = this.f25491b;
        if (socket == null) {
            C12238m.throwNpe();
        }
        Socket socket2 = this.f25492c;
        if (socket2 == null) {
            C12238m.throwNpe();
        }
        InterfaceC12390g interfaceC12390g = this.f25496g;
        if (interfaceC12390g == null) {
            C12238m.throwNpe();
        }
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        C12311e c12311e = this.f25495f;
        if (c12311e != null) {
            synchronized (c12311e) {
                if (c12311e.f25636r) {
                    return false;
                }
                return c12311e.f25617A >= c12311e.f25644z || jNanoTime < c12311e.f25619C;
            }
        }
        synchronized (this) {
            j = jNanoTime - this.f25505p;
        }
        if (j < 10000000000L || !z2) {
            return true;
        }
        C12238m.checkParameterIsNotNull(socket2, "$this$isHealthy");
        C12238m.checkParameterIsNotNull(interfaceC12390g, "source");
        try {
            int soTimeout = socket2.getSoTimeout();
            try {
                socket2.setSoTimeout(1);
                return !interfaceC12390g.mo10472w();
            } finally {
                socket2.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    /* JADX INFO: renamed from: j */
    public final boolean m10201j() {
        return this.f25495f != null;
    }

    /* JADX INFO: renamed from: k */
    public final InterfaceC12298d m10202k(C12380x c12380x, C12301g c12301g) throws SocketException {
        C12238m.checkParameterIsNotNull(c12380x, "client");
        C12238m.checkParameterIsNotNull(c12301g, "chain");
        Socket socket = this.f25492c;
        if (socket == null) {
            C12238m.throwNpe();
        }
        InterfaceC12390g interfaceC12390g = this.f25496g;
        if (interfaceC12390g == null) {
            C12238m.throwNpe();
        }
        BufferedSink bufferedSink = this.f25497h;
        if (bufferedSink == null) {
            C12238m.throwNpe();
        }
        C12311e c12311e = this.f25495f;
        if (c12311e != null) {
            return new C12318l(c12380x, this, c12301g, c12311e);
        }
        socket.setSoTimeout(c12301g.f25538h);
        C12408y c12408yTimeout = interfaceC12390g.timeout();
        long j = c12301g.f25538h;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        c12408yTimeout.mo10484g(j, timeUnit);
        bufferedSink.timeout().mo10484g(c12301g.f25539i, timeUnit);
        return new C12306b(c12380x, this, interfaceC12390g, bufferedSink);
    }

    /* JADX INFO: renamed from: l */
    public final synchronized void m10203l() {
        this.f25498i = true;
    }

    /* JADX INFO: renamed from: m */
    public EnumC12381y m10204m() {
        EnumC12381y enumC12381y = this.f25494e;
        if (enumC12381y == null) {
            C12238m.throwNpe();
        }
        return enumC12381y;
    }

    /* JADX INFO: renamed from: n */
    public Socket m10205n() {
        Socket socket = this.f25492c;
        if (socket == null) {
            C12238m.throwNpe();
        }
        return socket;
    }

    /* JADX INFO: renamed from: o */
    public final void m10206o(int i) throws IOException {
        String strM883w;
        int i2;
        Socket socket = this.f25492c;
        if (socket == null) {
            C12238m.throwNpe();
        }
        InterfaceC12390g interfaceC12390g = this.f25496g;
        if (interfaceC12390g == null) {
            C12238m.throwNpe();
        }
        BufferedSink bufferedSink = this.f25497h;
        if (bufferedSink == null) {
            C12238m.throwNpe();
        }
        socket.setSoTimeout(0);
        C12280d c12280d = C12280d.f25420a;
        C12311e.b bVar = new C12311e.b(true, c12280d);
        String str = this.f25506q.f25370a.f25353a.f25979g;
        C12238m.checkParameterIsNotNull(socket, "socket");
        C12238m.checkParameterIsNotNull(str, "peerName");
        C12238m.checkParameterIsNotNull(interfaceC12390g, "source");
        C12238m.checkParameterIsNotNull(bufferedSink, "sink");
        bVar.f25647a = socket;
        if (bVar.f25654h) {
            strM883w = C12272c.f25403g + ' ' + str;
        } else {
            strM883w = C1643a.m883w("MockWebServer ", str);
        }
        bVar.f25648b = strM883w;
        bVar.f25649c = interfaceC12390g;
        bVar.f25650d = bufferedSink;
        C12238m.checkParameterIsNotNull(this, "listener");
        bVar.f25651e = this;
        bVar.f25653g = i;
        C12311e c12311e = new C12311e(bVar);
        this.f25495f = c12311e;
        C12311e c12311e2 = C12311e.f25616k;
        C12325s c12325s = C12311e.f25615j;
        this.f25503n = (c12325s.f25752a & 16) != 0 ? c12325s.f25753b[4] : Integer.MAX_VALUE;
        C12238m.checkParameterIsNotNull(c12280d, "taskRunner");
        C12321o c12321o = c12311e.f25627K;
        synchronized (c12321o) {
            if (c12321o.f25740m) {
                throw new IOException("closed");
            }
            if (c12321o.f25743p) {
                Logger logger = C12321o.f25737j;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(C12272c.m10129j(">> CONNECTION " + C12310d.f25610a.mo10503k(), new Object[0]));
                }
                c12321o.f25742o.mo10455e0(C12310d.f25610a);
                c12321o.f25742o.flush();
            }
        }
        C12321o c12321o2 = c12311e.f25627K;
        C12325s c12325s2 = c12311e.f25620D;
        synchronized (c12321o2) {
            C12238m.checkParameterIsNotNull(c12325s2, "settings");
            if (c12321o2.f25740m) {
                throw new IOException("closed");
            }
            c12321o2.m10300c(0, Integer.bitCount(c12325s2.f25752a) * 6, 4, 0);
            int i3 = 0;
            while (i3 < 10) {
                if (((1 << i3) & c12325s2.f25752a) != 0) {
                    if (i3 != 4) {
                        i2 = i3 != 7 ? i3 : 4;
                    } else {
                        i2 = 3;
                    }
                    c12321o2.f25742o.writeShort(i2);
                    c12321o2.f25742o.writeInt(c12325s2.f25753b[i3]);
                }
                i3++;
            }
            c12321o2.f25742o.flush();
        }
        int iM10312a = c12311e.f25620D.m10312a();
        if (iM10312a != 65535) {
            c12311e.f25627K.m10305q(0, iM10312a - 65535);
        }
        C12279c c12279cM10162f = c12280d.m10162f();
        String str2 = c12311e.f25633o;
        c12279cM10162f.m10154c(new C12278b(c12311e.f25628L, str2, true, str2, true), 0L);
    }

    public String toString() {
        Object obj;
        StringBuilder sbM833U = C1643a.m833U("Connection{");
        sbM833U.append(this.f25506q.f25370a.f25353a.f25979g);
        sbM833U.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        sbM833U.append(this.f25506q.f25370a.f25353a.f25980h);
        sbM833U.append(',');
        sbM833U.append(" proxy=");
        sbM833U.append(this.f25506q.f25371b);
        sbM833U.append(" hostAddress=");
        sbM833U.append(this.f25506q.f25372c);
        sbM833U.append(" cipherSuite=");
        C12378v c12378v = this.f25493d;
        if (c12378v == null || (obj = c12378v.f25971c) == null) {
            obj = "none";
        }
        sbM833U.append(obj);
        sbM833U.append(" protocol=");
        sbM833U.append(this.f25494e);
        sbM833U.append('}');
        return sbM833U.toString();
    }
}
