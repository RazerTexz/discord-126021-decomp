package f0.e0.k;

import d0.t.o;
import d0.z.d.m;
import f0.y;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import org.conscrypt.Conscrypt;

/* JADX INFO: compiled from: ConscryptPlatform.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends h {
    public static final boolean d;
    public static final d$a e;
    public final Provider f;

    static {
        d$a d_a = new d$a(null);
        e = d_a;
        boolean z2 = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, d_a.getClass().getClassLoader());
            if (Conscrypt.isAvailable() && d_a.a(2, 1, 0)) {
                z2 = true;
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        d = z2;
    }

    public d() {
        Provider providerBuild = Conscrypt.newProviderBuilder().provideTrustManager(true).build();
        m.checkExpressionValueIsNotNull(providerBuild, "Conscrypt.newProviderBui…rustManager(true).build()");
        this.f = providerBuild;
    }

    @Override // f0.e0.k.h
    public void d(SSLSocket sSLSocket, String str, List<y> list) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        m.checkParameterIsNotNull(list, "protocols");
        if (!Conscrypt.isConscrypt(sSLSocket)) {
            m.checkParameterIsNotNull(sSLSocket, "sslSocket");
            m.checkParameterIsNotNull(list, "protocols");
            return;
        }
        Conscrypt.setUseSessionTickets(sSLSocket, true);
        m.checkParameterIsNotNull(list, "protocols");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((y) next) != y.HTTP_1_0) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((y) it2.next()).toString());
        }
        Object[] array = arrayList2.toArray(new String[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Conscrypt.setApplicationProtocols(sSLSocket, (String[]) array);
    }

    @Override // f0.e0.k.h
    public String f(SSLSocket sSLSocket) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        super.f(sSLSocket);
        return null;
    }

    @Override // f0.e0.k.h
    public SSLContext l() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f);
        m.checkExpressionValueIsNotNull(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // f0.e0.k.h
    public SSLSocketFactory m(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException {
        m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f);
        m.checkExpressionValueIsNotNull(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
        SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
        Conscrypt.setUseEngineSocket(socketFactory, true);
        m.checkExpressionValueIsNotNull(socketFactory, "newSSLContext().apply {\n…ineSocket(it, true)\n    }");
        return socketFactory;
    }

    @Override // f0.e0.k.h
    public X509TrustManager n() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        m.checkExpressionValueIsNotNull(trustManagerFactory, "TrustManagerFactory.getI…(null as KeyStore?)\n    }");
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers == null) {
            m.throwNpe();
        }
        if (!(trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager))) {
            StringBuilder sbU = b.d.b.a.a.U("Unexpected default trust managers: ");
            String string = Arrays.toString(trustManagers);
            m.checkExpressionValueIsNotNull(string, "java.util.Arrays.toString(this)");
            sbU.append(string);
            throw new IllegalStateException(sbU.toString().toString());
        }
        TrustManager trustManager = trustManagers[0];
        if (trustManager == null) {
            throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
        Conscrypt.setHostnameVerifier(x509TrustManager, d$b.a);
        return x509TrustManager;
    }
}
