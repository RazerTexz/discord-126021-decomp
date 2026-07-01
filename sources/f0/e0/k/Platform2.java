package f0.e0.k;

import android.util.Log;
import androidx.core.os.EnvironmentCompat;
import b.d.b.a.outline;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import f0.OkHttpClient;
import f0.Protocol2;
import f0.e0.k.AndroidPlatform;
import f0.e0.k.BouncyCastlePlatform;
import f0.e0.k.ConscryptPlatform;
import f0.e0.k.Jdk9Platform;
import f0.e0.k.OpenJSSEPlatform;
import f0.e0.k.i.AndroidLog;
import f0.e0.k.i.AndroidLog2;
import f0.e0.m.BasicCertificateChainCleaner;
import f0.e0.m.BasicTrustRootIndex;
import f0.e0.m.CertificateChainCleaner;
import f0.e0.m.TrustRootIndex;
import g0.Buffer3;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: f0.e0.k.h, reason: use source file name */
/* JADX INFO: compiled from: Platform.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Platform2 {
    public static volatile Platform2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f3650b;
    public static final a c;

    /* JADX INFO: renamed from: f0.e0.k.h$a */
    /* JADX INFO: compiled from: Platform.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final List<String> a(List<? extends Protocol2> list) {
            Intrinsics3.checkParameterIsNotNull(list, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((Protocol2) obj) != Protocol2.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((Protocol2) it.next()).toString());
            }
            return arrayList2;
        }

        public final byte[] b(List<? extends Protocol2> list) {
            Intrinsics3.checkParameterIsNotNull(list, "protocols");
            Buffer3 buffer3 = new Buffer3();
            for (String str : (ArrayList) a(list)) {
                buffer3.T(str.length());
                buffer3.b0(str);
            }
            return buffer3.Z(buffer3.k);
        }

        public final boolean c() {
            return Intrinsics3.areEqual("Dalvik", System.getProperty("java.vm.name"));
        }
    }

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
        Platform2 platform2;
        String property;
        Platform2 jdk8WithJettyBootPlatform = null;
        a aVar = new a(null);
        c = aVar;
        if (aVar.c()) {
            AndroidLog androidLog = AndroidLog.c;
            for (Map.Entry<String, String> entry : AndroidLog.f3652b.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                Logger logger = Logger.getLogger(key);
                if (AndroidLog.a.add(logger)) {
                    Intrinsics3.checkExpressionValueIsNotNull(logger, "logger");
                    logger.setUseParentHandlers(false);
                    logger.setLevel(Log.isLoggable(value, 3) ? Level.FINE : Log.isLoggable(value, 4) ? Level.INFO : Level.WARNING);
                    logger.addHandler(AndroidLog2.a);
                }
            }
            Android10Platform android10Platform = Android10Platform.e;
            platform2 = Android10Platform.d ? new Android10Platform() : null;
            if (platform2 == null) {
                AndroidPlatform.a aVar2 = AndroidPlatform.e;
                jdk8WithJettyBootPlatform = AndroidPlatform.d ? new AndroidPlatform() : null;
                if (jdk8WithJettyBootPlatform == null) {
                    Intrinsics3.throwNpe();
                }
                platform2 = jdk8WithJettyBootPlatform;
            }
        } else {
            Provider provider3 = Security.getProviders()[0];
            Intrinsics3.checkExpressionValueIsNotNull(provider3, "Security.getProviders()[0]");
            if (Intrinsics3.areEqual("Conscrypt", provider3.getName())) {
                ConscryptPlatform.a aVar3 = ConscryptPlatform.e;
                platform2 = ConscryptPlatform.d ? new ConscryptPlatform() : null;
                if (platform2 == null) {
                    provider = Security.getProviders()[0];
                    Intrinsics3.checkExpressionValueIsNotNull(provider, "Security.getProviders()[0]");
                    if (Intrinsics3.areEqual("BC", provider.getName())) {
                        BouncyCastlePlatform.a aVar4 = BouncyCastlePlatform.e;
                        if (BouncyCastlePlatform.d) {
                            platform2 = new BouncyCastlePlatform();
                        } else {
                            platform2 = null;
                        }
                        if (platform2 == null) {
                            provider2 = Security.getProviders()[0];
                            Intrinsics3.checkExpressionValueIsNotNull(provider2, "Security.getProviders()[0]");
                            if (Intrinsics3.areEqual("OpenJSSE", provider2.getName())) {
                                OpenJSSEPlatform.a aVar5 = OpenJSSEPlatform.e;
                                if (OpenJSSEPlatform.d) {
                                    platform2 = new OpenJSSEPlatform();
                                } else {
                                    platform2 = null;
                                }
                                if (platform2 == null) {
                                    Jdk9Platform.a aVar6 = Jdk9Platform.e;
                                    if (Jdk9Platform.d) {
                                        platform2 = new Jdk9Platform();
                                    } else {
                                        platform2 = null;
                                    }
                                    if (platform2 == null) {
                                        property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                        try {
                                            Intrinsics3.checkExpressionValueIsNotNull(property, "jvmVersion");
                                            if (Integer.parseInt(property) < 9) {
                                                try {
                                                    Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                                    Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                                    Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                                    Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                                    Method method = cls.getMethod("put", SSLSocket.class, cls2);
                                                    Method method2 = cls.getMethod("get", SSLSocket.class);
                                                    Method method3 = cls.getMethod("remove", SSLSocket.class);
                                                    Intrinsics3.checkExpressionValueIsNotNull(method, "putMethod");
                                                    Intrinsics3.checkExpressionValueIsNotNull(method2, "getMethod");
                                                    Intrinsics3.checkExpressionValueIsNotNull(method3, "removeMethod");
                                                    Intrinsics3.checkExpressionValueIsNotNull(cls3, "clientProviderClass");
                                                    Intrinsics3.checkExpressionValueIsNotNull(cls4, "serverProviderClass");
                                                    jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(method, method2, method3, cls3, cls4);
                                                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                                                }
                                            }
                                        } catch (NumberFormatException unused2) {
                                        }
                                        if (jdk8WithJettyBootPlatform != null) {
                                            platform2 = jdk8WithJettyBootPlatform;
                                        } else {
                                            platform2 = new Platform2();
                                        }
                                    }
                                }
                            } else {
                                Jdk9Platform.a aVar7 = Jdk9Platform.e;
                                if (Jdk9Platform.d) {
                                    platform2 = new Jdk9Platform();
                                } else {
                                    platform2 = null;
                                }
                                if (platform2 == null) {
                                    property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                    Intrinsics3.checkExpressionValueIsNotNull(property, "jvmVersion");
                                    if (Integer.parseInt(property) < 9) {
                                        Class<?> cls5 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                        Class<?> cls6 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                        Class<?> cls7 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                        Class<?> cls8 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                        Method method4 = cls5.getMethod("put", SSLSocket.class, cls6);
                                        Method method5 = cls5.getMethod("get", SSLSocket.class);
                                        Method method6 = cls5.getMethod("remove", SSLSocket.class);
                                        Intrinsics3.checkExpressionValueIsNotNull(method4, "putMethod");
                                        Intrinsics3.checkExpressionValueIsNotNull(method5, "getMethod");
                                        Intrinsics3.checkExpressionValueIsNotNull(method6, "removeMethod");
                                        Intrinsics3.checkExpressionValueIsNotNull(cls7, "clientProviderClass");
                                        Intrinsics3.checkExpressionValueIsNotNull(cls8, "serverProviderClass");
                                        jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(method4, method5, method6, cls7, cls8);
                                    }
                                    if (jdk8WithJettyBootPlatform != null) {
                                        platform2 = jdk8WithJettyBootPlatform;
                                    } else {
                                        platform2 = new Platform2();
                                    }
                                }
                            }
                        }
                    } else {
                        provider2 = Security.getProviders()[0];
                        Intrinsics3.checkExpressionValueIsNotNull(provider2, "Security.getProviders()[0]");
                        if (Intrinsics3.areEqual("OpenJSSE", provider2.getName())) {
                            OpenJSSEPlatform.a aVar8 = OpenJSSEPlatform.e;
                            if (OpenJSSEPlatform.d) {
                                platform2 = new OpenJSSEPlatform();
                            } else {
                                platform2 = null;
                            }
                            if (platform2 == null) {
                                Jdk9Platform.a aVar9 = Jdk9Platform.e;
                                if (Jdk9Platform.d) {
                                    platform2 = new Jdk9Platform();
                                } else {
                                    platform2 = null;
                                }
                                if (platform2 == null) {
                                    property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                    Intrinsics3.checkExpressionValueIsNotNull(property, "jvmVersion");
                                    if (Integer.parseInt(property) < 9) {
                                        Class<?> cls9 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                        Class<?> cls10 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                        Class<?> cls11 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                        Class<?> cls12 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                        Method method7 = cls9.getMethod("put", SSLSocket.class, cls10);
                                        Method method8 = cls9.getMethod("get", SSLSocket.class);
                                        Method method9 = cls9.getMethod("remove", SSLSocket.class);
                                        Intrinsics3.checkExpressionValueIsNotNull(method7, "putMethod");
                                        Intrinsics3.checkExpressionValueIsNotNull(method8, "getMethod");
                                        Intrinsics3.checkExpressionValueIsNotNull(method9, "removeMethod");
                                        Intrinsics3.checkExpressionValueIsNotNull(cls11, "clientProviderClass");
                                        Intrinsics3.checkExpressionValueIsNotNull(cls12, "serverProviderClass");
                                        jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(method7, method8, method9, cls11, cls12);
                                    }
                                    if (jdk8WithJettyBootPlatform != null) {
                                        platform2 = jdk8WithJettyBootPlatform;
                                    } else {
                                        platform2 = new Platform2();
                                    }
                                }
                            }
                        } else {
                            Jdk9Platform.a aVar10 = Jdk9Platform.e;
                            if (Jdk9Platform.d) {
                                platform2 = new Jdk9Platform();
                            } else {
                                platform2 = null;
                            }
                            if (platform2 == null) {
                                property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                Intrinsics3.checkExpressionValueIsNotNull(property, "jvmVersion");
                                if (Integer.parseInt(property) < 9) {
                                    Class<?> cls13 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                    Class<?> cls14 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                    Class<?> cls15 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                    Class<?> cls16 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                    Method method10 = cls13.getMethod("put", SSLSocket.class, cls14);
                                    Method method11 = cls13.getMethod("get", SSLSocket.class);
                                    Method method12 = cls13.getMethod("remove", SSLSocket.class);
                                    Intrinsics3.checkExpressionValueIsNotNull(method10, "putMethod");
                                    Intrinsics3.checkExpressionValueIsNotNull(method11, "getMethod");
                                    Intrinsics3.checkExpressionValueIsNotNull(method12, "removeMethod");
                                    Intrinsics3.checkExpressionValueIsNotNull(cls15, "clientProviderClass");
                                    Intrinsics3.checkExpressionValueIsNotNull(cls16, "serverProviderClass");
                                    jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(method10, method11, method12, cls15, cls16);
                                }
                                if (jdk8WithJettyBootPlatform != null) {
                                    platform2 = jdk8WithJettyBootPlatform;
                                } else {
                                    platform2 = new Platform2();
                                }
                            }
                        }
                    }
                }
            } else {
                provider = Security.getProviders()[0];
                Intrinsics3.checkExpressionValueIsNotNull(provider, "Security.getProviders()[0]");
                if (Intrinsics3.areEqual("BC", provider.getName())) {
                    BouncyCastlePlatform.a aVar11 = BouncyCastlePlatform.e;
                    if (BouncyCastlePlatform.d) {
                        platform2 = new BouncyCastlePlatform();
                    } else {
                        platform2 = null;
                    }
                    if (platform2 == null) {
                        provider2 = Security.getProviders()[0];
                        Intrinsics3.checkExpressionValueIsNotNull(provider2, "Security.getProviders()[0]");
                        if (Intrinsics3.areEqual("OpenJSSE", provider2.getName())) {
                            OpenJSSEPlatform.a aVar12 = OpenJSSEPlatform.e;
                            if (OpenJSSEPlatform.d) {
                                platform2 = new OpenJSSEPlatform();
                            } else {
                                platform2 = null;
                            }
                            if (platform2 == null) {
                                Jdk9Platform.a aVar13 = Jdk9Platform.e;
                                if (Jdk9Platform.d) {
                                    platform2 = new Jdk9Platform();
                                } else {
                                    platform2 = null;
                                }
                                if (platform2 == null) {
                                    property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                    Intrinsics3.checkExpressionValueIsNotNull(property, "jvmVersion");
                                    if (Integer.parseInt(property) < 9) {
                                        Class<?> cls17 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                        Class<?> cls18 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                        Class<?> cls19 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                        Class<?> cls110 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                        Method method13 = cls17.getMethod("put", SSLSocket.class, cls18);
                                        Method method14 = cls17.getMethod("get", SSLSocket.class);
                                        Method method15 = cls17.getMethod("remove", SSLSocket.class);
                                        Intrinsics3.checkExpressionValueIsNotNull(method13, "putMethod");
                                        Intrinsics3.checkExpressionValueIsNotNull(method14, "getMethod");
                                        Intrinsics3.checkExpressionValueIsNotNull(method15, "removeMethod");
                                        Intrinsics3.checkExpressionValueIsNotNull(cls19, "clientProviderClass");
                                        Intrinsics3.checkExpressionValueIsNotNull(cls110, "serverProviderClass");
                                        jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(method13, method14, method15, cls19, cls110);
                                    }
                                    if (jdk8WithJettyBootPlatform != null) {
                                        platform2 = jdk8WithJettyBootPlatform;
                                    } else {
                                        platform2 = new Platform2();
                                    }
                                }
                            }
                        } else {
                            Jdk9Platform.a aVar14 = Jdk9Platform.e;
                            if (Jdk9Platform.d) {
                                platform2 = new Jdk9Platform();
                            } else {
                                platform2 = null;
                            }
                            if (platform2 == null) {
                                property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                Intrinsics3.checkExpressionValueIsNotNull(property, "jvmVersion");
                                if (Integer.parseInt(property) < 9) {
                                    Class<?> cls111 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                    Class<?> cls112 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                    Class<?> cls113 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                    Class<?> cls114 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                    Method method16 = cls111.getMethod("put", SSLSocket.class, cls112);
                                    Method method17 = cls111.getMethod("get", SSLSocket.class);
                                    Method method18 = cls111.getMethod("remove", SSLSocket.class);
                                    Intrinsics3.checkExpressionValueIsNotNull(method16, "putMethod");
                                    Intrinsics3.checkExpressionValueIsNotNull(method17, "getMethod");
                                    Intrinsics3.checkExpressionValueIsNotNull(method18, "removeMethod");
                                    Intrinsics3.checkExpressionValueIsNotNull(cls113, "clientProviderClass");
                                    Intrinsics3.checkExpressionValueIsNotNull(cls114, "serverProviderClass");
                                    jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(method16, method17, method18, cls113, cls114);
                                }
                                if (jdk8WithJettyBootPlatform != null) {
                                    platform2 = jdk8WithJettyBootPlatform;
                                } else {
                                    platform2 = new Platform2();
                                }
                            }
                        }
                    }
                } else {
                    provider2 = Security.getProviders()[0];
                    Intrinsics3.checkExpressionValueIsNotNull(provider2, "Security.getProviders()[0]");
                    if (Intrinsics3.areEqual("OpenJSSE", provider2.getName())) {
                        OpenJSSEPlatform.a aVar15 = OpenJSSEPlatform.e;
                        if (OpenJSSEPlatform.d) {
                            platform2 = new OpenJSSEPlatform();
                        } else {
                            platform2 = null;
                        }
                        if (platform2 == null) {
                            Jdk9Platform.a aVar16 = Jdk9Platform.e;
                            if (Jdk9Platform.d) {
                                platform2 = new Jdk9Platform();
                            } else {
                                platform2 = null;
                            }
                            if (platform2 == null) {
                                property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                Intrinsics3.checkExpressionValueIsNotNull(property, "jvmVersion");
                                if (Integer.parseInt(property) < 9) {
                                    Class<?> cls115 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                    Class<?> cls116 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                    Class<?> cls117 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                    Class<?> cls118 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                    Method method19 = cls115.getMethod("put", SSLSocket.class, cls116);
                                    Method method110 = cls115.getMethod("get", SSLSocket.class);
                                    Method method111 = cls115.getMethod("remove", SSLSocket.class);
                                    Intrinsics3.checkExpressionValueIsNotNull(method19, "putMethod");
                                    Intrinsics3.checkExpressionValueIsNotNull(method110, "getMethod");
                                    Intrinsics3.checkExpressionValueIsNotNull(method111, "removeMethod");
                                    Intrinsics3.checkExpressionValueIsNotNull(cls117, "clientProviderClass");
                                    Intrinsics3.checkExpressionValueIsNotNull(cls118, "serverProviderClass");
                                    jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(method19, method110, method111, cls117, cls118);
                                }
                                if (jdk8WithJettyBootPlatform != null) {
                                    platform2 = jdk8WithJettyBootPlatform;
                                } else {
                                    platform2 = new Platform2();
                                }
                            }
                        }
                    } else {
                        Jdk9Platform.a aVar17 = Jdk9Platform.e;
                        if (Jdk9Platform.d) {
                            platform2 = new Jdk9Platform();
                        } else {
                            platform2 = null;
                        }
                        if (platform2 == null) {
                            property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                            Intrinsics3.checkExpressionValueIsNotNull(property, "jvmVersion");
                            if (Integer.parseInt(property) < 9) {
                                Class<?> cls119 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                Class<?> cls1110 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                Class<?> cls1111 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                Class<?> cls1112 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                Method method112 = cls119.getMethod("put", SSLSocket.class, cls1110);
                                Method method113 = cls119.getMethod("get", SSLSocket.class);
                                Method method114 = cls119.getMethod("remove", SSLSocket.class);
                                Intrinsics3.checkExpressionValueIsNotNull(method112, "putMethod");
                                Intrinsics3.checkExpressionValueIsNotNull(method113, "getMethod");
                                Intrinsics3.checkExpressionValueIsNotNull(method114, "removeMethod");
                                Intrinsics3.checkExpressionValueIsNotNull(cls1111, "clientProviderClass");
                                Intrinsics3.checkExpressionValueIsNotNull(cls1112, "serverProviderClass");
                                jdk8WithJettyBootPlatform = new Jdk8WithJettyBootPlatform(method112, method113, method114, cls1111, cls1112);
                            }
                            if (jdk8WithJettyBootPlatform != null) {
                                platform2 = jdk8WithJettyBootPlatform;
                            } else {
                                platform2 = new Platform2();
                            }
                        }
                    }
                }
            }
        }
        a = platform2;
        f3650b = Logger.getLogger(OkHttpClient.class.getName());
    }

    public static /* synthetic */ void j(Platform2 platform2, String str, int i, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 4;
        }
        int i3 = i2 & 4;
        platform2.i(str, i, null);
    }

    public void a(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
    }

    public CertificateChainCleaner b(X509TrustManager x509TrustManager) {
        Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
        return new BasicCertificateChainCleaner(c(x509TrustManager));
    }

    public TrustRootIndex c(X509TrustManager x509TrustManager) {
        Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        Intrinsics3.checkExpressionValueIsNotNull(acceptedIssuers, "trustManager.acceptedIssuers");
        return new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void d(SSLSocket sSLSocket, String str, List<Protocol2> list) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
    }

    public void e(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        Intrinsics3.checkParameterIsNotNull(socket, "socket");
        Intrinsics3.checkParameterIsNotNull(inetSocketAddress, "address");
        socket.connect(inetSocketAddress, i);
    }

    public String f(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return null;
    }

    public Object g(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "closer");
        if (f3650b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean h(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "hostname");
        return true;
    }

    public void i(String str, int i, Throwable th) {
        Intrinsics3.checkParameterIsNotNull(str, "message");
        f3650b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void k(String str, Object obj) {
        Intrinsics3.checkParameterIsNotNull(str, "message");
        if (obj == null) {
            str = outline.w(str, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        i(str, 5, (Throwable) obj);
    }

    public SSLContext l() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        Intrinsics3.checkExpressionValueIsNotNull(sSLContext, "SSLContext.getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory m(X509TrustManager x509TrustManager) {
        Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
        try {
            SSLContext sSLContextL = l();
            sSLContextL.init(null, new TrustManager[]{x509TrustManager}, null);
            SSLSocketFactory socketFactory = sSLContextL.getSocketFactory();
            Intrinsics3.checkExpressionValueIsNotNull(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS: " + e, e);
        }
    }

    public X509TrustManager n() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        Intrinsics3.checkExpressionValueIsNotNull(trustManagerFactory, "factory");
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers == null) {
            Intrinsics3.throwNpe();
        }
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager != null) {
                return (X509TrustManager) trustManager;
            }
            throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        StringBuilder sbU = outline.U("Unexpected default trust managers: ");
        String string = Arrays.toString(trustManagers);
        Intrinsics3.checkExpressionValueIsNotNull(string, "java.util.Arrays.toString(this)");
        sbU.append(string);
        throw new IllegalStateException(sbU.toString().toString());
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        Intrinsics3.checkExpressionValueIsNotNull(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
