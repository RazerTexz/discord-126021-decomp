package f0.e0.k;

import b.d.b.a.outline;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import f0.Protocol2;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;

/* JADX INFO: renamed from: f0.e0.k.d, reason: use source file name */
/* JADX INFO: compiled from: ConscryptPlatform.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConscryptPlatform extends Platform2 {
    public static final boolean d;
    public static final a e;
    public final Provider f;

    /* JADX INFO: renamed from: f0.e0.k.d$a */
    /* JADX INFO: compiled from: ConscryptPlatform.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final boolean a(int i, int i2, int i3) {
            Conscrypt.Version version = Conscrypt.version();
            if (version.major() != i) {
                return version.major() > i;
            }
            if (version.minor() != i2) {
                return version.minor() > i2;
            }
            return version.patch() >= i3;
        }
    }

    /* JADX INFO: renamed from: f0.e0.k.d$b */
    /* JADX INFO: compiled from: ConscryptPlatform.kt */
    public static final class b implements ConscryptHostnameVerifier {
        public static final b a = new b();
    }

    static {
        a aVar = new a(null);
        e = aVar;
        boolean z2 = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, aVar.getClass().getClassLoader());
            if (Conscrypt.isAvailable() && aVar.a(2, 1, 0)) {
                z2 = true;
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        d = z2;
    }

    public ConscryptPlatform() {
        Provider providerBuild = Conscrypt.newProviderBuilder().provideTrustManager(true).build();
        Intrinsics3.checkExpressionValueIsNotNull(providerBuild, "Conscrypt.newProviderBui…rustManager(true).build()");
        this.f = providerBuild;
    }

    @Override // f0.e0.k.Platform2
    public void d(SSLSocket sSLSocket, String str, List<Protocol2> list) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        if (!Conscrypt.isConscrypt(sSLSocket)) {
            Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
            Intrinsics3.checkParameterIsNotNull(list, "protocols");
            return;
        }
        Conscrypt.setUseSessionTickets(sSLSocket, true);
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((Protocol2) next) != Protocol2.HTTP_1_0) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((Protocol2) it2.next()).toString());
        }
        Object[] array = arrayList2.toArray(new String[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Conscrypt.setApplicationProtocols(sSLSocket, (String[]) array);
    }

    @Override // f0.e0.k.Platform2
    public String f(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        super.f(sSLSocket);
        return null;
    }

    @Override // f0.e0.k.Platform2
    public SSLContext l() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f);
        Intrinsics3.checkExpressionValueIsNotNull(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // f0.e0.k.Platform2
    public SSLSocketFactory m(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException {
        Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f);
        Intrinsics3.checkExpressionValueIsNotNull(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
        SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
        Conscrypt.setUseEngineSocket(socketFactory, true);
        Intrinsics3.checkExpressionValueIsNotNull(socketFactory, "newSSLContext().apply {\n…ineSocket(it, true)\n    }");
        return socketFactory;
    }

    @Override // f0.e0.k.Platform2
    public X509TrustManager n() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        Intrinsics3.checkExpressionValueIsNotNull(trustManagerFactory, "TrustManagerFactory.getI…(null as KeyStore?)\n    }");
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers == null) {
            Intrinsics3.throwNpe();
        }
        if (!(trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager))) {
            StringBuilder sbU = outline.U("Unexpected default trust managers: ");
            String string = Arrays.toString(trustManagers);
            Intrinsics3.checkExpressionValueIsNotNull(string, "java.util.Arrays.toString(this)");
            sbU.append(string);
            throw new IllegalStateException(sbU.toString().toString());
        }
        TrustManager trustManager = trustManagers[0];
        if (trustManager == null) {
            throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
        Conscrypt.setHostnameVerifier(x509TrustManager, b.a);
        return x509TrustManager;
    }
}
