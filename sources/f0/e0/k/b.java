package f0.e0.k;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build$VERSION;
import android.security.NetworkSecurityPolicy;
import d0.t.n;
import d0.z.d.m;
import f0.e0.k.i.i;
import f0.e0.k.i.j;
import f0.e0.k.i.k;
import f0.e0.k.i.l;
import f0.e0.k.i.l$a;
import f0.y;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: AndroidPlatform.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends h {
    public static final boolean d;
    public static final b$a e = new b$a(null);
    public final List<k> f;
    public final f0.e0.k.i.h g;

    static {
        boolean z2 = false;
        if (h.c.c() && Build$VERSION.SDK_INT < 30) {
            z2 = true;
        }
        d = z2;
    }

    public b() throws NoSuchMethodException {
        l lVar;
        Method method;
        Method method2;
        k[] kVarArr = new k[4];
        l$a l_a = l.h;
        m.checkParameterIsNotNull("com.android.org.conscrypt", "packageName");
        Method method3 = null;
        try {
            Class<?> cls = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
            Class<?> cls2 = Class.forName("com.android.org.conscrypt.OpenSSLSocketFactoryImpl");
            Class<?> cls3 = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            m.checkExpressionValueIsNotNull(cls3, "paramsClass");
            lVar = new l(cls, cls2, cls3);
        } catch (Exception e2) {
            h.a.i("unable to load android socket classes", 5, e2);
            lVar = null;
        }
        kVarArr[0] = lVar;
        f0.e0.k.i.f$a f_a = f0.e0.k.i.f.f3653b;
        kVarArr[1] = new j(f0.e0.k.i.f.a);
        kVarArr[2] = new j(i.a);
        kVarArr[3] = new j(f0.e0.k.i.g.a);
        List listListOfNotNull = n.listOfNotNull((Object[]) kVarArr);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOfNotNull) {
            if (((k) obj).b()) {
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
        this.g = new f0.e0.k.i.h(method3, method2, method);
    }

    @Override // f0.e0.k.h
    public f0.e0.m.c b(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        f0.e0.k.i.b bVar = x509TrustManagerExtensions != null ? new f0.e0.k.i.b(x509TrustManager, x509TrustManagerExtensions) : null;
        return bVar != null ? bVar : super.b(x509TrustManager);
    }

    @Override // f0.e0.k.h
    public f0.e0.m.e c(X509TrustManager x509TrustManager) {
        m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            m.checkExpressionValueIsNotNull(declaredMethod, "method");
            declaredMethod.setAccessible(true);
            return new b$b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.c(x509TrustManager);
        }
    }

    @Override // f0.e0.k.h
    public void d(SSLSocket sSLSocket, String str, List<y> list) {
        Object next;
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        m.checkParameterIsNotNull(list, "protocols");
        Iterator<T> it = this.f.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((k) next).a(sSLSocket));
        k kVar = (k) next;
        if (kVar != null) {
            kVar.d(sSLSocket, str, list);
        }
    }

    @Override // f0.e0.k.h
    public void e(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        m.checkParameterIsNotNull(socket, "socket");
        m.checkParameterIsNotNull(inetSocketAddress, "address");
        try {
            socket.connect(inetSocketAddress, i);
        } catch (ClassCastException e2) {
            if (Build$VERSION.SDK_INT != 26) {
                throw e2;
            }
            throw new IOException("Exception in connect", e2);
        }
    }

    @Override // f0.e0.k.h
    public String f(SSLSocket sSLSocket) {
        Object next;
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Iterator<T> it = this.f.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((k) next).a(sSLSocket));
        k kVar = (k) next;
        if (kVar != null) {
            return kVar.c(sSLSocket);
        }
        return null;
    }

    @Override // f0.e0.k.h
    public Object g(String str) {
        m.checkParameterIsNotNull(str, "closer");
        f0.e0.k.i.h hVar = this.g;
        Objects.requireNonNull(hVar);
        m.checkParameterIsNotNull(str, "closer");
        Method method = hVar.a;
        if (method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(null, new Object[0]);
            Method method2 = hVar.f3654b;
            if (method2 == null) {
                m.throwNpe();
            }
            method2.invoke(objInvoke, str);
            return objInvoke;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // f0.e0.k.h
    public boolean h(String str) {
        m.checkParameterIsNotNull(str, "hostname");
        int i = Build$VERSION.SDK_INT;
        if (i >= 24) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
        }
        if (i < 23) {
            return true;
        }
        NetworkSecurityPolicy networkSecurityPolicy = NetworkSecurityPolicy.getInstance();
        m.checkExpressionValueIsNotNull(networkSecurityPolicy, "NetworkSecurityPolicy.getInstance()");
        return networkSecurityPolicy.isCleartextTrafficPermitted();
    }

    @Override // f0.e0.k.h
    public void k(String str, Object obj) {
        m.checkParameterIsNotNull(str, "message");
        f0.e0.k.i.h hVar = this.g;
        Objects.requireNonNull(hVar);
        boolean z2 = false;
        if (obj != null) {
            try {
                Method method = hVar.c;
                if (method == null) {
                    m.throwNpe();
                }
                method.invoke(obj, new Object[0]);
                z2 = true;
            } catch (Exception unused) {
            }
        }
        if (z2) {
            return;
        }
        h.j(this, str, 5, null, 4, null);
    }
}
