package f0.e0.k;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import b.d.b.a.outline;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import f0.Protocol2;
import f0.e0.k.i.AndroidCertificateChainCleaner;
import f0.e0.k.i.AndroidSocketAdapter2;
import f0.e0.k.i.BouncyCastleSocketAdapter;
import f0.e0.k.i.CloseGuard;
import f0.e0.k.i.ConscryptSocketAdapter;
import f0.e0.k.i.DeferredSocketAdapter;
import f0.e0.k.i.SocketAdapter;
import f0.e0.k.i.StandardAndroidSocketAdapter;
import f0.e0.m.CertificateChainCleaner;
import f0.e0.m.TrustRootIndex;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: f0.e0.k.b, reason: use source file name */
/* JADX INFO: compiled from: AndroidPlatform.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AndroidPlatform extends Platform2 {
    public static final boolean d;
    public static final a e = new a(null);
    public final List<SocketAdapter> f;
    public final CloseGuard g;

    /* JADX INFO: renamed from: f0.e0.k.b$a */
    /* JADX INFO: compiled from: AndroidPlatform.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: f0.e0.k.b$b */
    /* JADX INFO: compiled from: AndroidPlatform.kt */
    public static final class b implements TrustRootIndex {
        public final X509TrustManager a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f3648b;

        public b(X509TrustManager x509TrustManager, Method method) {
            Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
            Intrinsics3.checkParameterIsNotNull(method, "findByIssuerAndSignatureMethod");
            this.a = x509TrustManager;
            this.f3648b = method;
        }

        @Override // f0.e0.m.TrustRootIndex
        public X509Certificate a(X509Certificate x509Certificate) {
            Intrinsics3.checkParameterIsNotNull(x509Certificate, "cert");
            try {
                Object objInvoke = this.f3648b.invoke(this.a, x509Certificate);
                if (objInvoke != null) {
                    return ((TrustAnchor) objInvoke).getTrustedCert();
                }
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.TrustAnchor");
            } catch (IllegalAccessException e) {
                throw new AssertionError("unable to get issues and signature", e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics3.areEqual(this.a, bVar.a) && Intrinsics3.areEqual(this.f3648b, bVar.f3648b);
        }

        public int hashCode() {
            X509TrustManager x509TrustManager = this.a;
            int iHashCode = (x509TrustManager != null ? x509TrustManager.hashCode() : 0) * 31;
            Method method = this.f3648b;
            return iHashCode + (method != null ? method.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("CustomTrustRootIndex(trustManager=");
            sbU.append(this.a);
            sbU.append(", findByIssuerAndSignatureMethod=");
            sbU.append(this.f3648b);
            sbU.append(")");
            return sbU.toString();
        }
    }

    static {
        boolean z2 = false;
        if (Platform2.c.c() && Build.VERSION.SDK_INT < 30) {
            z2 = true;
        }
        d = z2;
    }

    public AndroidPlatform() throws NoSuchMethodException {
        StandardAndroidSocketAdapter standardAndroidSocketAdapter;
        Method method;
        Method method2;
        SocketAdapter[] socketAdapterArr = new SocketAdapter[4];
        StandardAndroidSocketAdapter.a aVar = StandardAndroidSocketAdapter.h;
        Intrinsics3.checkParameterIsNotNull("com.android.org.conscrypt", "packageName");
        Method method3 = null;
        try {
            Class<?> cls = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
            Class<?> cls2 = Class.forName("com.android.org.conscrypt.OpenSSLSocketFactoryImpl");
            Class<?> cls3 = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            Intrinsics3.checkExpressionValueIsNotNull(cls3, "paramsClass");
            standardAndroidSocketAdapter = new StandardAndroidSocketAdapter(cls, cls2, cls3);
        } catch (Exception e2) {
            Platform2.a.i("unable to load android socket classes", 5, e2);
            standardAndroidSocketAdapter = null;
        }
        socketAdapterArr[0] = standardAndroidSocketAdapter;
        AndroidSocketAdapter2.a aVar2 = AndroidSocketAdapter2.f3653b;
        socketAdapterArr[1] = new DeferredSocketAdapter(AndroidSocketAdapter2.a);
        socketAdapterArr[2] = new DeferredSocketAdapter(ConscryptSocketAdapter.a);
        socketAdapterArr[3] = new DeferredSocketAdapter(BouncyCastleSocketAdapter.a);
        List listListOfNotNull = Collections2.listOfNotNull((Object[]) socketAdapterArr);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOfNotNull) {
            if (((SocketAdapter) obj).b()) {
                arrayList.add(obj);
            }
        }
        this.f = arrayList;
        try {
            Class<?> cls4 = Class.forName("dalvik.system.CloseGuard");
            Method method4 = cls4.getMethod("get", new Class[0]);
            method2 = cls4.getMethod("open", String.class);
            method = cls4.getMethod("warnIfOpen", new Class[0]);
            method3 = method4;
        } catch (Exception unused) {
            method = null;
            method2 = null;
        }
        this.g = new CloseGuard(method3, method2, method);
    }

    @Override // f0.e0.k.Platform2
    public CertificateChainCleaner b(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
        Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        AndroidCertificateChainCleaner androidCertificateChainCleaner = x509TrustManagerExtensions != null ? new AndroidCertificateChainCleaner(x509TrustManager, x509TrustManagerExtensions) : null;
        return androidCertificateChainCleaner != null ? androidCertificateChainCleaner : super.b(x509TrustManager);
    }

    @Override // f0.e0.k.Platform2
    public TrustRootIndex c(X509TrustManager x509TrustManager) {
        Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            Intrinsics3.checkExpressionValueIsNotNull(declaredMethod, "method");
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.c(x509TrustManager);
        }
    }

    @Override // f0.e0.k.Platform2
    public void d(SSLSocket sSLSocket, String str, List<Protocol2> list) {
        Object next;
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        Iterator<T> it = this.f.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((SocketAdapter) next).a(sSLSocket));
        SocketAdapter socketAdapter = (SocketAdapter) next;
        if (socketAdapter != null) {
            socketAdapter.d(sSLSocket, str, list);
        }
    }

    @Override // f0.e0.k.Platform2
    public void e(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        Intrinsics3.checkParameterIsNotNull(socket, "socket");
        Intrinsics3.checkParameterIsNotNull(inetSocketAddress, "address");
        try {
            socket.connect(inetSocketAddress, i);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e2;
            }
            throw new IOException("Exception in connect", e2);
        }
    }

    @Override // f0.e0.k.Platform2
    public String f(SSLSocket sSLSocket) {
        Object next;
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Iterator<T> it = this.f.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((SocketAdapter) next).a(sSLSocket));
        SocketAdapter socketAdapter = (SocketAdapter) next;
        if (socketAdapter != null) {
            return socketAdapter.c(sSLSocket);
        }
        return null;
    }

    @Override // f0.e0.k.Platform2
    public Object g(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "closer");
        CloseGuard closeGuard = this.g;
        Objects.requireNonNull(closeGuard);
        Intrinsics3.checkParameterIsNotNull(str, "closer");
        Method method = closeGuard.a;
        if (method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(null, new Object[0]);
            Method method2 = closeGuard.f3654b;
            if (method2 == null) {
                Intrinsics3.throwNpe();
            }
            method2.invoke(objInvoke, str);
            return objInvoke;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // f0.e0.k.Platform2
    public boolean h(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "hostname");
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
        }
        if (i < 23) {
            return true;
        }
        NetworkSecurityPolicy networkSecurityPolicy = NetworkSecurityPolicy.getInstance();
        Intrinsics3.checkExpressionValueIsNotNull(networkSecurityPolicy, "NetworkSecurityPolicy.getInstance()");
        return networkSecurityPolicy.isCleartextTrafficPermitted();
    }

    @Override // f0.e0.k.Platform2
    public void k(String str, Object obj) {
        Intrinsics3.checkParameterIsNotNull(str, "message");
        CloseGuard closeGuard = this.g;
        Objects.requireNonNull(closeGuard);
        boolean z2 = false;
        if (obj != null) {
            try {
                Method method = closeGuard.c;
                if (method == null) {
                    Intrinsics3.throwNpe();
                }
                method.invoke(obj, new Object[0]);
                z2 = true;
            } catch (Exception unused) {
            }
        }
        if (z2) {
            return;
        }
        Platform2.j(this, str, 5, null, 4, null);
    }
}
