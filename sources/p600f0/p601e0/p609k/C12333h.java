package p600f0.p601e0.p609k;

import android.util.Log;
import androidx.core.os.EnvironmentCompat;
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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12380x;
import p600f0.EnumC12381y;
import p600f0.p601e0.p609k.p610i.C12336c;
import p600f0.p601e0.p609k.p610i.C12337d;
import p600f0.p601e0.p612m.AbstractC12349c;
import p600f0.p601e0.p612m.C12347a;
import p600f0.p601e0.p612m.C12348b;
import p600f0.p601e0.p612m.InterfaceC12351e;
import p615g0.C12388e;

/* JADX INFO: renamed from: f0.e0.k.h */
/* JADX INFO: compiled from: Platform.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12333h {

    /* JADX INFO: renamed from: a */
    public static volatile C12333h f25783a;

    /* JADX INFO: renamed from: b */
    public static final Logger f25784b;

    /* JADX INFO: renamed from: c */
    public static final a f25785c;

    /* JADX INFO: renamed from: f0.e0.k.h$a */
    /* JADX INFO: compiled from: Platform.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final List<String> m10331a(List<? extends EnumC12381y> list) {
            C12238m.checkParameterIsNotNull(list, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((EnumC12381y) obj) != EnumC12381y.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((EnumC12381y) it.next()).toString());
            }
            return arrayList2;
        }

        /* JADX INFO: renamed from: b */
        public final byte[] m10332b(List<? extends EnumC12381y> list) {
            C12238m.checkParameterIsNotNull(list, "protocols");
            C12388e c12388e = new C12388e();
            for (String str : (ArrayList) m10331a(list)) {
                c12388e.m10444T(str.length());
                c12388e.m10452b0(str);
            }
            return c12388e.mo10450Z(c12388e.f26080k);
        }

        /* JADX INFO: renamed from: c */
        public final boolean m10333c() {
            return C12238m.areEqual("Dalvik", System.getProperty("java.vm.name"));
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
        C12333h c12333h;
        String property;
        C12333h c12330e = null;
        a aVar = new a(null);
        f25785c = aVar;
        if (aVar.m10333c()) {
            C12336c c12336c = C12336c.f25790c;
            for (Map.Entry<String, String> entry : C12336c.f25789b.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                Logger logger = Logger.getLogger(key);
                if (C12336c.f25788a.add(logger)) {
                    C12238m.checkExpressionValueIsNotNull(logger, "logger");
                    logger.setUseParentHandlers(false);
                    logger.setLevel(Log.isLoggable(value, 3) ? Level.FINE : Log.isLoggable(value, 4) ? Level.INFO : Level.WARNING);
                    logger.addHandler(C12337d.f25791a);
                }
            }
            C12326a c12326a = C12326a.f25755e;
            c12333h = C12326a.f25754d ? new C12326a() : null;
            if (c12333h == null) {
                C12327b.a aVar2 = C12327b.f25758e;
                c12330e = C12327b.f25757d ? new C12327b() : null;
                if (c12330e == null) {
                    C12238m.throwNpe();
                }
                c12333h = c12330e;
            }
        } else {
            Provider provider3 = Security.getProviders()[0];
            C12238m.checkExpressionValueIsNotNull(provider3, "Security.getProviders()[0]");
            if (C12238m.areEqual("Conscrypt", provider3.getName())) {
                C12329d.a aVar3 = C12329d.f25767e;
                c12333h = C12329d.f25766d ? new C12329d() : null;
                if (c12333h == null) {
                    provider = Security.getProviders()[0];
                    C12238m.checkExpressionValueIsNotNull(provider, "Security.getProviders()[0]");
                    if (C12238m.areEqual("BC", provider.getName())) {
                        C12328c.a aVar4 = C12328c.f25764e;
                        if (C12328c.f25763d) {
                            c12333h = new C12328c();
                        } else {
                            c12333h = null;
                        }
                        if (c12333h == null) {
                            provider2 = Security.getProviders()[0];
                            C12238m.checkExpressionValueIsNotNull(provider2, "Security.getProviders()[0]");
                            if (C12238m.areEqual("OpenJSSE", provider2.getName())) {
                                C12332g.a aVar5 = C12332g.f25781e;
                                if (C12332g.f25780d) {
                                    c12333h = new C12332g();
                                } else {
                                    c12333h = null;
                                }
                                if (c12333h == null) {
                                    C12331f.a aVar6 = C12331f.f25779e;
                                    if (C12331f.f25778d) {
                                        c12333h = new C12331f();
                                    } else {
                                        c12333h = null;
                                    }
                                    if (c12333h == null) {
                                        property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                        try {
                                            C12238m.checkExpressionValueIsNotNull(property, "jvmVersion");
                                            if (Integer.parseInt(property) < 9) {
                                                try {
                                                    Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                                    Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                                    Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                                    Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                                    Method method = cls.getMethod("put", SSLSocket.class, cls2);
                                                    Method method2 = cls.getMethod("get", SSLSocket.class);
                                                    Method method3 = cls.getMethod("remove", SSLSocket.class);
                                                    C12238m.checkExpressionValueIsNotNull(method, "putMethod");
                                                    C12238m.checkExpressionValueIsNotNull(method2, "getMethod");
                                                    C12238m.checkExpressionValueIsNotNull(method3, "removeMethod");
                                                    C12238m.checkExpressionValueIsNotNull(cls3, "clientProviderClass");
                                                    C12238m.checkExpressionValueIsNotNull(cls4, "serverProviderClass");
                                                    c12330e = new C12330e(method, method2, method3, cls3, cls4);
                                                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                                                }
                                            }
                                        } catch (NumberFormatException unused2) {
                                        }
                                        if (c12330e != null) {
                                            c12333h = c12330e;
                                        } else {
                                            c12333h = new C12333h();
                                        }
                                    }
                                }
                            } else {
                                C12331f.a aVar7 = C12331f.f25779e;
                                if (C12331f.f25778d) {
                                    c12333h = new C12331f();
                                } else {
                                    c12333h = null;
                                }
                                if (c12333h == null) {
                                    property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                    C12238m.checkExpressionValueIsNotNull(property, "jvmVersion");
                                    if (Integer.parseInt(property) < 9) {
                                        Class<?> cls5 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                        Class<?> cls6 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                        Class<?> cls7 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                        Class<?> cls8 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                        Method method4 = cls5.getMethod("put", SSLSocket.class, cls6);
                                        Method method5 = cls5.getMethod("get", SSLSocket.class);
                                        Method method6 = cls5.getMethod("remove", SSLSocket.class);
                                        C12238m.checkExpressionValueIsNotNull(method4, "putMethod");
                                        C12238m.checkExpressionValueIsNotNull(method5, "getMethod");
                                        C12238m.checkExpressionValueIsNotNull(method6, "removeMethod");
                                        C12238m.checkExpressionValueIsNotNull(cls7, "clientProviderClass");
                                        C12238m.checkExpressionValueIsNotNull(cls8, "serverProviderClass");
                                        c12330e = new C12330e(method4, method5, method6, cls7, cls8);
                                    }
                                    if (c12330e != null) {
                                        c12333h = c12330e;
                                    } else {
                                        c12333h = new C12333h();
                                    }
                                }
                            }
                        }
                    } else {
                        provider2 = Security.getProviders()[0];
                        C12238m.checkExpressionValueIsNotNull(provider2, "Security.getProviders()[0]");
                        if (C12238m.areEqual("OpenJSSE", provider2.getName())) {
                            C12332g.a aVar8 = C12332g.f25781e;
                            if (C12332g.f25780d) {
                                c12333h = new C12332g();
                            } else {
                                c12333h = null;
                            }
                            if (c12333h == null) {
                                C12331f.a aVar9 = C12331f.f25779e;
                                if (C12331f.f25778d) {
                                    c12333h = new C12331f();
                                } else {
                                    c12333h = null;
                                }
                                if (c12333h == null) {
                                    property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                    C12238m.checkExpressionValueIsNotNull(property, "jvmVersion");
                                    if (Integer.parseInt(property) < 9) {
                                        Class<?> cls9 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                        Class<?> cls10 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                        Class<?> cls11 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                        Class<?> cls12 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                        Method method7 = cls9.getMethod("put", SSLSocket.class, cls10);
                                        Method method8 = cls9.getMethod("get", SSLSocket.class);
                                        Method method9 = cls9.getMethod("remove", SSLSocket.class);
                                        C12238m.checkExpressionValueIsNotNull(method7, "putMethod");
                                        C12238m.checkExpressionValueIsNotNull(method8, "getMethod");
                                        C12238m.checkExpressionValueIsNotNull(method9, "removeMethod");
                                        C12238m.checkExpressionValueIsNotNull(cls11, "clientProviderClass");
                                        C12238m.checkExpressionValueIsNotNull(cls12, "serverProviderClass");
                                        c12330e = new C12330e(method7, method8, method9, cls11, cls12);
                                    }
                                    if (c12330e != null) {
                                        c12333h = c12330e;
                                    } else {
                                        c12333h = new C12333h();
                                    }
                                }
                            }
                        } else {
                            C12331f.a aVar10 = C12331f.f25779e;
                            if (C12331f.f25778d) {
                                c12333h = new C12331f();
                            } else {
                                c12333h = null;
                            }
                            if (c12333h == null) {
                                property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                C12238m.checkExpressionValueIsNotNull(property, "jvmVersion");
                                if (Integer.parseInt(property) < 9) {
                                    Class<?> cls13 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                    Class<?> cls14 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                    Class<?> cls15 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                    Class<?> cls16 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                    Method method10 = cls13.getMethod("put", SSLSocket.class, cls14);
                                    Method method11 = cls13.getMethod("get", SSLSocket.class);
                                    Method method12 = cls13.getMethod("remove", SSLSocket.class);
                                    C12238m.checkExpressionValueIsNotNull(method10, "putMethod");
                                    C12238m.checkExpressionValueIsNotNull(method11, "getMethod");
                                    C12238m.checkExpressionValueIsNotNull(method12, "removeMethod");
                                    C12238m.checkExpressionValueIsNotNull(cls15, "clientProviderClass");
                                    C12238m.checkExpressionValueIsNotNull(cls16, "serverProviderClass");
                                    c12330e = new C12330e(method10, method11, method12, cls15, cls16);
                                }
                                if (c12330e != null) {
                                    c12333h = c12330e;
                                } else {
                                    c12333h = new C12333h();
                                }
                            }
                        }
                    }
                }
            } else {
                provider = Security.getProviders()[0];
                C12238m.checkExpressionValueIsNotNull(provider, "Security.getProviders()[0]");
                if (C12238m.areEqual("BC", provider.getName())) {
                    C12328c.a aVar11 = C12328c.f25764e;
                    if (C12328c.f25763d) {
                        c12333h = new C12328c();
                    } else {
                        c12333h = null;
                    }
                    if (c12333h == null) {
                        provider2 = Security.getProviders()[0];
                        C12238m.checkExpressionValueIsNotNull(provider2, "Security.getProviders()[0]");
                        if (C12238m.areEqual("OpenJSSE", provider2.getName())) {
                            C12332g.a aVar12 = C12332g.f25781e;
                            if (C12332g.f25780d) {
                                c12333h = new C12332g();
                            } else {
                                c12333h = null;
                            }
                            if (c12333h == null) {
                                C12331f.a aVar13 = C12331f.f25779e;
                                if (C12331f.f25778d) {
                                    c12333h = new C12331f();
                                } else {
                                    c12333h = null;
                                }
                                if (c12333h == null) {
                                    property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                    C12238m.checkExpressionValueIsNotNull(property, "jvmVersion");
                                    if (Integer.parseInt(property) < 9) {
                                        Class<?> cls17 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                        Class<?> cls18 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                        Class<?> cls19 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                        Class<?> cls110 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                        Method method13 = cls17.getMethod("put", SSLSocket.class, cls18);
                                        Method method14 = cls17.getMethod("get", SSLSocket.class);
                                        Method method15 = cls17.getMethod("remove", SSLSocket.class);
                                        C12238m.checkExpressionValueIsNotNull(method13, "putMethod");
                                        C12238m.checkExpressionValueIsNotNull(method14, "getMethod");
                                        C12238m.checkExpressionValueIsNotNull(method15, "removeMethod");
                                        C12238m.checkExpressionValueIsNotNull(cls19, "clientProviderClass");
                                        C12238m.checkExpressionValueIsNotNull(cls110, "serverProviderClass");
                                        c12330e = new C12330e(method13, method14, method15, cls19, cls110);
                                    }
                                    if (c12330e != null) {
                                        c12333h = c12330e;
                                    } else {
                                        c12333h = new C12333h();
                                    }
                                }
                            }
                        } else {
                            C12331f.a aVar14 = C12331f.f25779e;
                            if (C12331f.f25778d) {
                                c12333h = new C12331f();
                            } else {
                                c12333h = null;
                            }
                            if (c12333h == null) {
                                property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                C12238m.checkExpressionValueIsNotNull(property, "jvmVersion");
                                if (Integer.parseInt(property) < 9) {
                                    Class<?> cls111 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                    Class<?> cls112 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                    Class<?> cls113 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                    Class<?> cls114 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                    Method method16 = cls111.getMethod("put", SSLSocket.class, cls112);
                                    Method method17 = cls111.getMethod("get", SSLSocket.class);
                                    Method method18 = cls111.getMethod("remove", SSLSocket.class);
                                    C12238m.checkExpressionValueIsNotNull(method16, "putMethod");
                                    C12238m.checkExpressionValueIsNotNull(method17, "getMethod");
                                    C12238m.checkExpressionValueIsNotNull(method18, "removeMethod");
                                    C12238m.checkExpressionValueIsNotNull(cls113, "clientProviderClass");
                                    C12238m.checkExpressionValueIsNotNull(cls114, "serverProviderClass");
                                    c12330e = new C12330e(method16, method17, method18, cls113, cls114);
                                }
                                if (c12330e != null) {
                                    c12333h = c12330e;
                                } else {
                                    c12333h = new C12333h();
                                }
                            }
                        }
                    }
                } else {
                    provider2 = Security.getProviders()[0];
                    C12238m.checkExpressionValueIsNotNull(provider2, "Security.getProviders()[0]");
                    if (C12238m.areEqual("OpenJSSE", provider2.getName())) {
                        C12332g.a aVar15 = C12332g.f25781e;
                        if (C12332g.f25780d) {
                            c12333h = new C12332g();
                        } else {
                            c12333h = null;
                        }
                        if (c12333h == null) {
                            C12331f.a aVar16 = C12331f.f25779e;
                            if (C12331f.f25778d) {
                                c12333h = new C12331f();
                            } else {
                                c12333h = null;
                            }
                            if (c12333h == null) {
                                property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                                C12238m.checkExpressionValueIsNotNull(property, "jvmVersion");
                                if (Integer.parseInt(property) < 9) {
                                    Class<?> cls115 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                    Class<?> cls116 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                    Class<?> cls117 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                    Class<?> cls118 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                    Method method19 = cls115.getMethod("put", SSLSocket.class, cls116);
                                    Method method110 = cls115.getMethod("get", SSLSocket.class);
                                    Method method111 = cls115.getMethod("remove", SSLSocket.class);
                                    C12238m.checkExpressionValueIsNotNull(method19, "putMethod");
                                    C12238m.checkExpressionValueIsNotNull(method110, "getMethod");
                                    C12238m.checkExpressionValueIsNotNull(method111, "removeMethod");
                                    C12238m.checkExpressionValueIsNotNull(cls117, "clientProviderClass");
                                    C12238m.checkExpressionValueIsNotNull(cls118, "serverProviderClass");
                                    c12330e = new C12330e(method19, method110, method111, cls117, cls118);
                                }
                                if (c12330e != null) {
                                    c12333h = c12330e;
                                } else {
                                    c12333h = new C12333h();
                                }
                            }
                        }
                    } else {
                        C12331f.a aVar17 = C12331f.f25779e;
                        if (C12331f.f25778d) {
                            c12333h = new C12331f();
                        } else {
                            c12333h = null;
                        }
                        if (c12333h == null) {
                            property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
                            C12238m.checkExpressionValueIsNotNull(property, "jvmVersion");
                            if (Integer.parseInt(property) < 9) {
                                Class<?> cls119 = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                                Class<?> cls1110 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                                Class<?> cls1111 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                                Class<?> cls1112 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                                Method method112 = cls119.getMethod("put", SSLSocket.class, cls1110);
                                Method method113 = cls119.getMethod("get", SSLSocket.class);
                                Method method114 = cls119.getMethod("remove", SSLSocket.class);
                                C12238m.checkExpressionValueIsNotNull(method112, "putMethod");
                                C12238m.checkExpressionValueIsNotNull(method113, "getMethod");
                                C12238m.checkExpressionValueIsNotNull(method114, "removeMethod");
                                C12238m.checkExpressionValueIsNotNull(cls1111, "clientProviderClass");
                                C12238m.checkExpressionValueIsNotNull(cls1112, "serverProviderClass");
                                c12330e = new C12330e(method112, method113, method114, cls1111, cls1112);
                            }
                            if (c12330e != null) {
                                c12333h = c12330e;
                            } else {
                                c12333h = new C12333h();
                            }
                        }
                    }
                }
            }
        }
        f25783a = c12333h;
        f25784b = Logger.getLogger(C12380x.class.getName());
    }

    /* JADX INFO: renamed from: j */
    public static /* synthetic */ void m10329j(C12333h c12333h, String str, int i, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 4;
        }
        int i3 = i2 & 4;
        c12333h.m10330i(str, i, null);
    }

    /* JADX INFO: renamed from: a */
    public void mo10328a(SSLSocket sSLSocket) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
    }

    /* JADX INFO: renamed from: b */
    public AbstractC12349c mo10315b(X509TrustManager x509TrustManager) {
        C12238m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        return new C12347a(mo10319c(x509TrustManager));
    }

    /* JADX INFO: renamed from: c */
    public InterfaceC12351e mo10319c(X509TrustManager x509TrustManager) {
        C12238m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        C12238m.checkExpressionValueIsNotNull(acceptedIssuers, "trustManager.acceptedIssuers");
        return new C12348b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    /* JADX INFO: renamed from: d */
    public void mo10316d(SSLSocket sSLSocket, String str, List<EnumC12381y> list) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        C12238m.checkParameterIsNotNull(list, "protocols");
    }

    /* JADX INFO: renamed from: e */
    public void mo10320e(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        C12238m.checkParameterIsNotNull(socket, "socket");
        C12238m.checkParameterIsNotNull(inetSocketAddress, "address");
        socket.connect(inetSocketAddress, i);
    }

    /* JADX INFO: renamed from: f */
    public String mo10317f(SSLSocket sSLSocket) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return null;
    }

    /* JADX INFO: renamed from: g */
    public Object mo10321g(String str) {
        C12238m.checkParameterIsNotNull(str, "closer");
        if (f25784b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    /* JADX INFO: renamed from: h */
    public boolean mo10318h(String str) {
        C12238m.checkParameterIsNotNull(str, "hostname");
        return true;
    }

    /* JADX INFO: renamed from: i */
    public void m10330i(String str, int i, Throwable th) {
        C12238m.checkParameterIsNotNull(str, "message");
        f25784b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    /* JADX INFO: renamed from: k */
    public void mo10322k(String str, Object obj) {
        C12238m.checkParameterIsNotNull(str, "message");
        if (obj == null) {
            str = C1643a.m883w(str, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        m10330i(str, 5, (Throwable) obj);
    }

    /* JADX INFO: renamed from: l */
    public SSLContext mo10324l() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        C12238m.checkExpressionValueIsNotNull(sSLContext, "SSLContext.getInstance(\"TLS\")");
        return sSLContext;
    }

    /* JADX INFO: renamed from: m */
    public SSLSocketFactory mo10326m(X509TrustManager x509TrustManager) {
        C12238m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        try {
            SSLContext sSLContextMo10324l = mo10324l();
            sSLContextMo10324l.init(null, new TrustManager[]{x509TrustManager}, null);
            SSLSocketFactory socketFactory = sSLContextMo10324l.getSocketFactory();
            C12238m.checkExpressionValueIsNotNull(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS: " + e, e);
        }
    }

    /* JADX INFO: renamed from: n */
    public X509TrustManager mo10325n() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        C12238m.checkExpressionValueIsNotNull(trustManagerFactory, "factory");
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers == null) {
            C12238m.throwNpe();
        }
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager != null) {
                return (X509TrustManager) trustManager;
            }
            throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        StringBuilder sbM833U = C1643a.m833U("Unexpected default trust managers: ");
        String string = Arrays.toString(trustManagers);
        C12238m.checkExpressionValueIsNotNull(string, "java.util.Arrays.toString(this)");
        sbM833U.append(string);
        throw new IllegalStateException(sbM833U.toString().toString());
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        C12238m.checkExpressionValueIsNotNull(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
