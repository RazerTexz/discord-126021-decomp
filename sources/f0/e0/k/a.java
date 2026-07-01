package f0.e0.k;

import android.annotation.SuppressLint;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build$VERSION;
import android.security.NetworkSecurityPolicy;
import d0.t.n;
import d0.z.d.m;
import f0.e0.k.i.i;
import f0.e0.k.i.j;
import f0.e0.k.i.k;
import f0.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: compiled from: Android10Platform.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends h {
    public static final boolean d;
    public static final a e = null;
    public final List<k> f;

    static {
        d = h.c.c() && Build$VERSION.SDK_INT >= 29;
    }

    public a() {
        k[] kVarArr = new k[4];
        kVarArr[0] = m.areEqual("Dalvik", System.getProperty("java.vm.name")) && Build$VERSION.SDK_INT >= 29 ? new f0.e0.k.i.a() : null;
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
    public void d(SSLSocket sSLSocket, String str, List<? extends y> list) {
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
    @SuppressLint({"NewApi"})
    public boolean h(String str) {
        m.checkParameterIsNotNull(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }
}
