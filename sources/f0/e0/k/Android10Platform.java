package f0.e0.k;

import android.annotation.SuppressLint;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import f0.Protocol2;
import f0.e0.k.i.Android10SocketAdapter;
import f0.e0.k.i.AndroidCertificateChainCleaner;
import f0.e0.k.i.AndroidSocketAdapter2;
import f0.e0.k.i.BouncyCastleSocketAdapter;
import f0.e0.k.i.ConscryptSocketAdapter;
import f0.e0.k.i.DeferredSocketAdapter;
import f0.e0.k.i.SocketAdapter;
import f0.e0.m.CertificateChainCleaner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: renamed from: f0.e0.k.a, reason: use source file name */
/* JADX INFO: compiled from: Android10Platform.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Android10Platform extends Platform2 {
    public static final boolean d;
    public static final Android10Platform e = null;
    public final List<SocketAdapter> f;

    static {
        d = Platform2.c.c() && Build.VERSION.SDK_INT >= 29;
    }

    public Android10Platform() {
        SocketAdapter[] socketAdapterArr = new SocketAdapter[4];
        socketAdapterArr[0] = Intrinsics3.areEqual("Dalvik", System.getProperty("java.vm.name")) && Build.VERSION.SDK_INT >= 29 ? new Android10SocketAdapter() : null;
        AndroidSocketAdapter2.a aVar = AndroidSocketAdapter2.f3653b;
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
    public void d(SSLSocket sSLSocket, String str, List<? extends Protocol2> list) {
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
    @SuppressLint({"NewApi"})
    public boolean h(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }
}
