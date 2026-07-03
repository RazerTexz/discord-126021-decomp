package p600f0.p601e0.p609k;

import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;
import p600f0.EnumC12381y;
import p600f0.p601e0.p609k.p610i.C12335b;
import p600f0.p601e0.p609k.p610i.C12339f;
import p600f0.p601e0.p609k.p610i.C12340g;
import p600f0.p601e0.p609k.p610i.C12341h;
import p600f0.p601e0.p609k.p610i.C12342i;
import p600f0.p601e0.p609k.p610i.C12343j;
import p600f0.p601e0.p609k.p610i.C12345l;
import p600f0.p601e0.p609k.p610i.InterfaceC12344k;
import p600f0.p601e0.p612m.AbstractC12349c;
import p600f0.p601e0.p612m.InterfaceC12351e;

/* JADX INFO: renamed from: f0.e0.k.b */
/* JADX INFO: compiled from: AndroidPlatform.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12327b extends C12333h {

    /* JADX INFO: renamed from: d */
    public static final boolean f25757d;

    /* JADX INFO: renamed from: e */
    public static final a f25758e = new a(null);

    /* JADX INFO: renamed from: f */
    public final List<InterfaceC12344k> f25759f;

    /* JADX INFO: renamed from: g */
    public final C12341h f25760g;

    /* JADX INFO: renamed from: f0.e0.k.b$a */
    /* JADX INFO: compiled from: AndroidPlatform.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: f0.e0.k.b$b */
    /* JADX INFO: compiled from: AndroidPlatform.kt */
    public static final class b implements InterfaceC12351e {

        /* JADX INFO: renamed from: a */
        public final X509TrustManager f25761a;

        /* JADX INFO: renamed from: b */
        public final Method f25762b;

        public b(X509TrustManager x509TrustManager, Method method) {
            C12238m.checkParameterIsNotNull(x509TrustManager, "trustManager");
            C12238m.checkParameterIsNotNull(method, "findByIssuerAndSignatureMethod");
            this.f25761a = x509TrustManager;
            this.f25762b = method;
        }

        @Override // p600f0.p601e0.p612m.InterfaceC12351e
        /* JADX INFO: renamed from: a */
        public X509Certificate mo10323a(X509Certificate x509Certificate) {
            C12238m.checkParameterIsNotNull(x509Certificate, "cert");
            try {
                Object objInvoke = this.f25762b.invoke(this.f25761a, x509Certificate);
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
            return C12238m.areEqual(this.f25761a, bVar.f25761a) && C12238m.areEqual(this.f25762b, bVar.f25762b);
        }

        public int hashCode() {
            X509TrustManager x509TrustManager = this.f25761a;
            int iHashCode = (x509TrustManager != null ? x509TrustManager.hashCode() : 0) * 31;
            Method method = this.f25762b;
            return iHashCode + (method != null ? method.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("CustomTrustRootIndex(trustManager=");
            sbM833U.append(this.f25761a);
            sbM833U.append(", findByIssuerAndSignatureMethod=");
            sbM833U.append(this.f25762b);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    static {
        boolean z2 = false;
        if (C12333h.f25785c.m10333c() && Build.VERSION.SDK_INT < 30) {
            z2 = true;
        }
        f25757d = z2;
    }

    public C12327b() throws NoSuchMethodException {
        C12345l c12345l;
        Method method;
        Method method2;
        InterfaceC12344k[] interfaceC12344kArr = new InterfaceC12344k[4];
        C12345l.a aVar = C12345l.f25807h;
        C12238m.checkParameterIsNotNull("com.android.org.conscrypt", "packageName");
        Method method3 = null;
        try {
            Class<?> cls = Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
            Class<?> cls2 = Class.forName("com.android.org.conscrypt.OpenSSLSocketFactoryImpl");
            Class<?> cls3 = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            C12238m.checkExpressionValueIsNotNull(cls3, "paramsClass");
            c12345l = new C12345l(cls, cls2, cls3);
        } catch (Exception e) {
            C12333h.f25783a.m10330i("unable to load android socket classes", 5, e);
            c12345l = null;
        }
        interfaceC12344kArr[0] = c12345l;
        C12339f.a aVar2 = C12339f.f25794b;
        interfaceC12344kArr[1] = new C12343j(C12339f.f25793a);
        interfaceC12344kArr[2] = new C12343j(C12342i.f25804a);
        interfaceC12344kArr[3] = new C12343j(C12340g.f25800a);
        List listListOfNotNull = C12147n.listOfNotNull((Object[]) interfaceC12344kArr);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOfNotNull) {
            if (((InterfaceC12344k) obj).mo10335b()) {
                arrayList.add(obj);
            }
        }
        this.f25759f = arrayList;
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
        this.f25760g = new C12341h(method3, method2, method);
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: b */
    public AbstractC12349c mo10315b(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        C12238m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        C12238m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        C12335b c12335b = x509TrustManagerExtensions != null ? new C12335b(x509TrustManager, x509TrustManagerExtensions) : null;
        return c12335b != null ? c12335b : super.mo10315b(x509TrustManager);
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: c */
    public InterfaceC12351e mo10319c(X509TrustManager x509TrustManager) {
        C12238m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            C12238m.checkExpressionValueIsNotNull(declaredMethod, "method");
            declaredMethod.setAccessible(true);
            return new b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.mo10319c(x509TrustManager);
        }
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: d */
    public void mo10316d(SSLSocket sSLSocket, String str, List<EnumC12381y> list) {
        Object next;
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        C12238m.checkParameterIsNotNull(list, "protocols");
        Iterator<T> it = this.f25759f.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((InterfaceC12344k) next).mo10334a(sSLSocket));
        InterfaceC12344k interfaceC12344k = (InterfaceC12344k) next;
        if (interfaceC12344k != null) {
            interfaceC12344k.mo10337d(sSLSocket, str, list);
        }
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: e */
    public void mo10320e(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        C12238m.checkParameterIsNotNull(socket, "socket");
        C12238m.checkParameterIsNotNull(inetSocketAddress, "address");
        try {
            socket.connect(inetSocketAddress, i);
        } catch (ClassCastException e) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e;
            }
            throw new IOException("Exception in connect", e);
        }
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: f */
    public String mo10317f(SSLSocket sSLSocket) {
        Object next;
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Iterator<T> it = this.f25759f.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((InterfaceC12344k) next).mo10334a(sSLSocket));
        InterfaceC12344k interfaceC12344k = (InterfaceC12344k) next;
        if (interfaceC12344k != null) {
            return interfaceC12344k.mo10336c(sSLSocket);
        }
        return null;
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: g */
    public Object mo10321g(String str) {
        C12238m.checkParameterIsNotNull(str, "closer");
        C12341h c12341h = this.f25760g;
        Objects.requireNonNull(c12341h);
        C12238m.checkParameterIsNotNull(str, "closer");
        Method method = c12341h.f25801a;
        if (method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(null, new Object[0]);
            Method method2 = c12341h.f25802b;
            if (method2 == null) {
                C12238m.throwNpe();
            }
            method2.invoke(objInvoke, str);
            return objInvoke;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: h */
    public boolean mo10318h(String str) {
        C12238m.checkParameterIsNotNull(str, "hostname");
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
        }
        if (i < 23) {
            return true;
        }
        NetworkSecurityPolicy networkSecurityPolicy = NetworkSecurityPolicy.getInstance();
        C12238m.checkExpressionValueIsNotNull(networkSecurityPolicy, "NetworkSecurityPolicy.getInstance()");
        return networkSecurityPolicy.isCleartextTrafficPermitted();
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: k */
    public void mo10322k(String str, Object obj) {
        C12238m.checkParameterIsNotNull(str, "message");
        C12341h c12341h = this.f25760g;
        Objects.requireNonNull(c12341h);
        boolean z2 = false;
        if (obj != null) {
            try {
                Method method = c12341h.f25803c;
                if (method == null) {
                    C12238m.throwNpe();
                }
                method.invoke(obj, new Object[0]);
                z2 = true;
            } catch (Exception unused) {
            }
        }
        if (z2) {
            return;
        }
        C12333h.m10329j(this, str, 5, null, 4, null);
    }
}
