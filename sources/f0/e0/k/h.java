package f0.e0.k;

import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import d0.z.d.m;
import f0.x;
import f0.y;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Map$Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;

/* JADX INFO: compiled from: Platform.kt */
/* JADX INFO: loaded from: classes3.dex */
public class h {
    public static volatile h a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f3650b;
    public static final h$a c;

    /* JADX WARN: Code duplicated, block: B:28:0x0087 A[PHI: r1
      0x0087: PHI (r1v3 f0.e0.k.h) = (r1v1 f0.e0.k.h), (r1v4 f0.e0.k.h), (r1v4 f0.e0.k.h) binds: [B:68:0x0187, B:26:0x0082, B:27:0x0084] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:37:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:41:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:53:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:55:0x0104  */
    /* JADX WARN: Code duplicated, block: B:56:0x010a  */
    /* JADX WARN: Code duplicated, block: B:59:0x010f  */
    /* JADX WARN: Code duplicated, block: B:64:0x0125  */
    /* JADX WARN: Code duplicated, block: B:70:0x018b  */
    static {
        Provider provider;
        Provider provider2;
        h hVar;
        String property;
        h eVar = null;
        h$a h_a = new h$a(null);
        c = h_a;
        if (h_a.c()) {
            f0.e0.k.i.c cVar = f0.e0.k.i.c.c;
            for (Map$Entry<String, String> map$Entry : f0.e0.k.i.c.f3652b.entrySet()) {
                String key = map$Entry.getKey();
                String value = map$Entry.getValue();
                Logger logger = Logger.getLogger(key);
                if (f0.e0.k.i.c.a.add(logger)) {
                    m.checkExpressionValueIsNotNull(logger, "logger");
                    logger.setUseParentHandlers(false);
                    logger.setLevel(Log.isLoggable(value, 3) ? Level.FINE : Log.isLoggable(value, 4) ? Level.INFO : Level.WARNING);
                    logger.addHandler(f0.e0.k.i.d.a);
                }
            }
            a aVar = a.e;
            hVar = a.d ? new a() : null;
            if (hVar == null) {
                b$a b_a = b.e;
                eVar = b.d ? new b() : null;
                if (eVar == null) {
                    m.throwNpe();
                }
                hVar = eVar;
            }
        } else {
            Provider provider3 = Security.getProviders()[0];
            m.checkExpressionValueIsNotNull(provider3, "Security.getProviders()[0]");
            if (m.areEqual("Conscrypt", provider3.getName())) {
                d$a d_a = d.e;
                hVar = d.d ? new d() : null;
                if (hVar == null) {
                    provider = Security.getProviders()[0];
                    m.checkExpressionValueIsNotNull(provider, "Security.getProviders()[0]");
                    if (m.areEqual("BC", provider.getName())) {
                        c$a c_a = c.e;
                        if (c.d) {
                            hVar = new c();
                        } else {
                            hVar = null;
                        }
                        if (hVar == null) {
                            provider2 = Security.getProviders()[0];
                            m.checkExpressionValueIsNotNull(provider2, "Security.getProviders()[0]");
                            if (m.areEqual("OpenJSSE", provider2.getName())) {
                                g$a g_a = g.e;
                                if (g.d) {
                                    hVar = new g();
                                } else {
                                    hVar = null;
                                }
                                if (hVar == null) {
                                    f$a f_a = f.e;
                                    if (f.d) {
                                        hVar = new f();
                                    } else {
                                        hVar = null;
                                    }
                                    if (hVar == null) {
                                        property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                        try {
                                            m.checkExpressionValueIsNotNull(property, "jvmVersion");
                                            if (Integer.parseInt(property) < 9) {
                                                try {
                                                    Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                                    Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                                    Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                                    Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                                    Method method = cls.getMethod("put", SSLSocket.class, cls2);
                                                    Method method2 = cls.getMethod("get", SSLSocket.class);
                                                    Method method3 = cls.getMethod("remove", SSLSocket.class);
                                                    m.checkExpressionValueIsNotNull(method, "putMethod");
                                                    m.checkExpressionValueIsNotNull(method2, "getMethod");
                                                    m.checkExpressionValueIsNotNull(method3, "removeMethod");
                                                    m.checkExpressionValueIsNotNull(cls3, "clientProviderClass");
                                                    m.checkExpressionValueIsNotNull(cls4, "serverProviderClass");
                                                    eVar = new e(method, method2, method3, cls3, cls4);
                                                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                                                }
                                            }
                                        } catch (NumberFormatException unused2) {
                                        }
                                        if (eVar != null) {
                                            hVar = eVar;
                                        } else {
                                            hVar = new h();
                                        }
                                    }
                                }
                            } else {
                                f$a f_a2 = f.e;
                                if (f.d) {
                                    hVar = new f();
                                } else {
                                    hVar = null;
                                }
                                if (hVar == null) {
                                    property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                    m.checkExpressionValueIsNotNull(property, "jvmVersion");
                                    if (Integer.parseInt(property) < 9) {
                                        Class<?> cls5 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                        Class<?> cls6 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                        Class<?> cls7 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                        Class<?> cls8 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                        Method method4 = cls5.getMethod("put", SSLSocket.class, cls6);
                                        Method method5 = cls5.getMethod("get", SSLSocket.class);
                                        Method method6 = cls5.getMethod("remove", SSLSocket.class);
                                        m.checkExpressionValueIsNotNull(method4, "putMethod");
                                        m.checkExpressionValueIsNotNull(method5, "getMethod");
                                        m.checkExpressionValueIsNotNull(method6, "removeMethod");
                                        m.checkExpressionValueIsNotNull(cls7, "clientProviderClass");
                                        m.checkExpressionValueIsNotNull(cls8, "serverProviderClass");
                                        eVar = new e(method4, method5, method6, cls7, cls8);
                                    }
                                    if (eVar != null) {
                                        hVar = eVar;
                                    } else {
                                        hVar = new h();
                                    }
                                }
                            }
                        }
                    } else {
                        provider2 = Security.getProviders()[0];
                        m.checkExpressionValueIsNotNull(provider2, "Security.getProviders()[0]");
                        if (m.areEqual("OpenJSSE", provider2.getName())) {
                            g$a g_a2 = g.e;
                            if (g.d) {
                                hVar = new g();
                            } else {
                                hVar = null;
                            }
                            if (hVar == null) {
                                f$a f_a3 = f.e;
                                if (f.d) {
                                    hVar = new f();
                                } else {
                                    hVar = null;
                                }
                                if (hVar == null) {
                                    property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                    m.checkExpressionValueIsNotNull(property, "jvmVersion");
                                    if (Integer.parseInt(property) < 9) {
                                        Class<?> cls9 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                        Class<?> cls10 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                        Class<?> cls11 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                        Class<?> cls12 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                        Method method7 = cls9.getMethod("put", SSLSocket.class, cls10);
                                        Method method8 = cls9.getMethod("get", SSLSocket.class);
                                        Method method9 = cls9.getMethod("remove", SSLSocket.class);
                                        m.checkExpressionValueIsNotNull(method7, "putMethod");
                                        m.checkExpressionValueIsNotNull(method8, "getMethod");
                                        m.checkExpressionValueIsNotNull(method9, "removeMethod");
                                        m.checkExpressionValueIsNotNull(cls11, "clientProviderClass");
                                        m.checkExpressionValueIsNotNull(cls12, "serverProviderClass");
                                        eVar = new e(method7, method8, method9, cls11, cls12);
                                    }
                                    if (eVar != null) {
                                        hVar = eVar;
                                    } else {
                                        hVar = new h();
                                    }
                                }
                            }
                        } else {
                            f$a f_a4 = f.e;
                            if (f.d) {
                                hVar = new f();
                            } else {
                                hVar = null;
                            }
                            if (hVar == null) {
                                property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                m.checkExpressionValueIsNotNull(property, "jvmVersion");
                                if (Integer.parseInt(property) < 9) {
                                    Class<?> cls13 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                    Class<?> cls14 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                    Class<?> cls15 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                    Class<?> cls16 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                    Method method10 = cls13.getMethod("put", SSLSocket.class, cls14);
                                    Method method11 = cls13.getMethod("get", SSLSocket.class);
                                    Method method12 = cls13.getMethod("remove", SSLSocket.class);
                                    m.checkExpressionValueIsNotNull(method10, "putMethod");
                                    m.checkExpressionValueIsNotNull(method11, "getMethod");
                                    m.checkExpressionValueIsNotNull(method12, "removeMethod");
                                    m.checkExpressionValueIsNotNull(cls15, "clientProviderClass");
                                    m.checkExpressionValueIsNotNull(cls16, "serverProviderClass");
                                    eVar = new e(method10, method11, method12, cls15, cls16);
                                }
                                if (eVar != null) {
                                    hVar = eVar;
                                } else {
                                    hVar = new h();
                                }
                            }
                        }
                    }
                }
            } else {
                provider = Security.getProviders()[0];
                m.checkExpressionValueIsNotNull(provider, "Security.getProviders()[0]");
                if (m.areEqual("BC", provider.getName())) {
                    c$a c_a2 = c.e;
                    if (c.d) {
                        hVar = new c();
                    } else {
                        hVar = null;
                    }
                    if (hVar == null) {
                        provider2 = Security.getProviders()[0];
                        m.checkExpressionValueIsNotNull(provider2, "Security.getProviders()[0]");
                        if (m.areEqual("OpenJSSE", provider2.getName())) {
                            g$a g_a3 = g.e;
                            if (g.d) {
                                hVar = new g();
                            } else {
                                hVar = null;
                            }
                            if (hVar == null) {
                                f$a f_a5 = f.e;
                                if (f.d) {
                                    hVar = new f();
                                } else {
                                    hVar = null;
                                }
                                if (hVar == null) {
                                    property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                    m.checkExpressionValueIsNotNull(property, "jvmVersion");
                                    if (Integer.parseInt(property) < 9) {
                                        Class<?> cls17 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                        Class<?> cls18 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                        Class<?> cls19 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                        Class<?> cls110 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                        Method method13 = cls17.getMethod("put", SSLSocket.class, cls18);
                                        Method method14 = cls17.getMethod("get", SSLSocket.class);
                                        Method method15 = cls17.getMethod("remove", SSLSocket.class);
                                        m.checkExpressionValueIsNotNull(method13, "putMethod");
                                        m.checkExpressionValueIsNotNull(method14, "getMethod");
                                        m.checkExpressionValueIsNotNull(method15, "removeMethod");
                                        m.checkExpressionValueIsNotNull(cls19, "clientProviderClass");
                                        m.checkExpressionValueIsNotNull(cls110, "serverProviderClass");
                                        eVar = new e(method13, method14, method15, cls19, cls110);
                                    }
                                    if (eVar != null) {
                                        hVar = eVar;
                                    } else {
                                        hVar = new h();
                                    }
                                }
                            }
                        } else {
                            f$a f_a6 = f.e;
                            if (f.d) {
                                hVar = new f();
                            } else {
                                hVar = null;
                            }
                            if (hVar == null) {
                                property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                m.checkExpressionValueIsNotNull(property, "jvmVersion");
                                if (Integer.parseInt(property) < 9) {
                                    Class<?> cls111 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                    Class<?> cls112 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                    Class<?> cls113 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                    Class<?> cls114 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                    Method method16 = cls111.getMethod("put", SSLSocket.class, cls112);
                                    Method method17 = cls111.getMethod("get", SSLSocket.class);
                                    Method method18 = cls111.getMethod("remove", SSLSocket.class);
                                    m.checkExpressionValueIsNotNull(method16, "putMethod");
                                    m.checkExpressionValueIsNotNull(method17, "getMethod");
                                    m.checkExpressionValueIsNotNull(method18, "removeMethod");
                                    m.checkExpressionValueIsNotNull(cls113, "clientProviderClass");
                                    m.checkExpressionValueIsNotNull(cls114, "serverProviderClass");
                                    eVar = new e(method16, method17, method18, cls113, cls114);
                                }
                                if (eVar != null) {
                                    hVar = eVar;
                                } else {
                                    hVar = new h();
                                }
                            }
                        }
                    }
                } else {
                    provider2 = Security.getProviders()[0];
                    m.checkExpressionValueIsNotNull(provider2, "Security.getProviders()[0]");
                    if (m.areEqual("OpenJSSE", provider2.getName())) {
                        g$a g_a4 = g.e;
                        if (g.d) {
                            hVar = new g();
                        } else {
                            hVar = null;
                        }
                        if (hVar == null) {
                            f$a f_a7 = f.e;
                            if (f.d) {
                                hVar = new f();
                            } else {
                                hVar = null;
                            }
                            if (hVar == null) {
                                property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                m.checkExpressionValueIsNotNull(property, "jvmVersion");
                                if (Integer.parseInt(property) < 9) {
                                    Class<?> cls115 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                    Class<?> cls116 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                    Class<?> cls117 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                    Class<?> cls118 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                    Method method19 = cls115.getMethod("put", SSLSocket.class, cls116);
                                    Method method110 = cls115.getMethod("get", SSLSocket.class);
                                    Method method111 = cls115.getMethod("remove", SSLSocket.class);
                                    m.checkExpressionValueIsNotNull(method19, "putMethod");
                                    m.checkExpressionValueIsNotNull(method110, "getMethod");
                                    m.checkExpressionValueIsNotNull(method111, "removeMethod");
                                    m.checkExpressionValueIsNotNull(cls117, "clientProviderClass");
                                    m.checkExpressionValueIsNotNull(cls118, "serverProviderClass");
                                    eVar = new e(method19, method110, method111, cls117, cls118);
                                }
                                if (eVar != null) {
                                    hVar = eVar;
                                } else {
                                    hVar = new h();
                                }
                            }
                        }
                    } else {
                        f$a f_a8 = f.e;
                        if (f.d) {
                            hVar = new f();
                        } else {
                            hVar = null;
                        }
                        if (hVar == null) {
                            property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                            m.checkExpressionValueIsNotNull(property, "jvmVersion");
                            if (Integer.parseInt(property) < 9) {
                                Class<?> cls119 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                Class<?> cls1110 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                Class<?> cls1111 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                Class<?> cls1112 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                Method method112 = cls119.getMethod("put", SSLSocket.class, cls1110);
                                Method method113 = cls119.getMethod("get", SSLSocket.class);
                                Method method114 = cls119.getMethod("remove", SSLSocket.class);
                                m.checkExpressionValueIsNotNull(method112, "putMethod");
                                m.checkExpressionValueIsNotNull(method113, "getMethod");
                                m.checkExpressionValueIsNotNull(method114, "removeMethod");
                                m.checkExpressionValueIsNotNull(cls1111, "clientProviderClass");
                                m.checkExpressionValueIsNotNull(cls1112, "serverProviderClass");
                                eVar = new e(method112, method113, method114, cls1111, cls1112);
                            }
                            if (eVar != null) {
                                hVar = eVar;
                            } else {
                                hVar = new h();
                            }
                        }
                    }
                }
            }
        }
        a = hVar;
        f3650b = Logger.getLogger(x.class.getName());
    }

    public static /* synthetic */ void j(h hVar, String str, int i, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 4;
        }
        int i3 = i2 & 4;
        hVar.i(str, i, null);
    }

    public void a(SSLSocket sSLSocket) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
    }

    public f0.e0.m.c b(X509TrustManager x509TrustManager) {
        m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        return new f0.e0.m.a(c(x509TrustManager));
    }

    public f0.e0.m.e c(X509TrustManager x509TrustManager) {
        m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        m.checkExpressionValueIsNotNull(acceptedIssuers, "trustManager.acceptedIssuers");
        return new f0.e0.m.b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void d(SSLSocket sSLSocket, String str, List<y> list) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        m.checkParameterIsNotNull(list, "protocols");
    }

    public void e(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        m.checkParameterIsNotNull(socket, "socket");
        m.checkParameterIsNotNull(inetSocketAddress, "address");
        socket.connect(inetSocketAddress, i);
    }

    public String f(SSLSocket sSLSocket) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return null;
    }

    public Object g(String str) {
        m.checkParameterIsNotNull(str, "closer");
        if (f3650b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean h(String str) {
        m.checkParameterIsNotNull(str, "hostname");
        return true;
    }

    public void i(String str, int i, Throwable th) {
        m.checkParameterIsNotNull(str, "message");
        f3650b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void k(String str, Object obj) {
        m.checkParameterIsNotNull(str, "message");
        if (obj == null) {
            str = b.d.b.a.a.w(str, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        i(str, 5, (Throwable) obj);
    }

    public SSLContext l() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        m.checkExpressionValueIsNotNull(sSLContext, "SSLContext.getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory m(X509TrustManager x509TrustManager) {
        m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        try {
            SSLContext sSLContextL = l();
            sSLContextL.init(null, new TrustManager[]{x509TrustManager}, null);
            SSLSocketFactory socketFactory = sSLContextL.getSocketFactory();
            m.checkExpressionValueIsNotNull(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS: " + e, e);
        }
    }

    public X509TrustManager n() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        m.checkExpressionValueIsNotNull(trustManagerFactory, "factory");
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers == null) {
            m.throwNpe();
        }
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager != null) {
                return (X509TrustManager) trustManager;
            }
            throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        StringBuilder sbU = b.d.b.a.a.U("Unexpected default trust managers: ");
        String string = Arrays.toString(trustManagers);
        m.checkExpressionValueIsNotNull(string, "java.util.Arrays.toString(this)");
        sbU.append(string);
        throw new IllegalStateException(sbU.toString().toString());
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        m.checkExpressionValueIsNotNull(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
