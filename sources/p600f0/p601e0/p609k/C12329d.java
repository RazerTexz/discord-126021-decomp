package p600f0.p601e0.p609k;

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
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;
import p600f0.EnumC12381y;

/* JADX INFO: renamed from: f0.e0.k.d */
/* JADX INFO: compiled from: ConscryptPlatform.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12329d extends C12333h {

    /* JADX INFO: renamed from: d */
    public static final boolean f25766d;

    /* JADX INFO: renamed from: e */
    public static final a f25767e;

    /* JADX INFO: renamed from: f */
    public final Provider f25768f;

    /* JADX INFO: renamed from: f0.e0.k.d$a */
    /* JADX INFO: compiled from: ConscryptPlatform.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final boolean m10327a(int i, int i2, int i3) {
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

        /* JADX INFO: renamed from: a */
        public static final b f25769a = new b();
    }

    static {
        a aVar = new a(null);
        f25767e = aVar;
        boolean z2 = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, aVar.getClass().getClassLoader());
            if (Conscrypt.isAvailable() && aVar.m10327a(2, 1, 0)) {
                z2 = true;
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        f25766d = z2;
    }

    public C12329d() {
        Provider providerBuild = Conscrypt.newProviderBuilder().provideTrustManager(true).build();
        C12238m.checkExpressionValueIsNotNull(providerBuild, "Conscrypt.newProviderBui…rustManager(true).build()");
        this.f25768f = providerBuild;
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: d */
    public void mo10316d(SSLSocket sSLSocket, String str, List<EnumC12381y> list) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        C12238m.checkParameterIsNotNull(list, "protocols");
        if (!Conscrypt.isConscrypt(sSLSocket)) {
            C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
            C12238m.checkParameterIsNotNull(list, "protocols");
            return;
        }
        Conscrypt.setUseSessionTickets(sSLSocket, true);
        C12238m.checkParameterIsNotNull(list, "protocols");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((EnumC12381y) next) != EnumC12381y.HTTP_1_0) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((EnumC12381y) it2.next()).toString());
        }
        Object[] array = arrayList2.toArray(new String[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Conscrypt.setApplicationProtocols(sSLSocket, (String[]) array);
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: f */
    public String mo10317f(SSLSocket sSLSocket) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        super.mo10317f(sSLSocket);
        return null;
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: l */
    public SSLContext mo10324l() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f25768f);
        C12238m.checkExpressionValueIsNotNull(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: m */
    public SSLSocketFactory mo10326m(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException {
        C12238m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f25768f);
        C12238m.checkExpressionValueIsNotNull(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
        SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
        Conscrypt.setUseEngineSocket(socketFactory, true);
        C12238m.checkExpressionValueIsNotNull(socketFactory, "newSSLContext().apply {\n…ineSocket(it, true)\n    }");
        return socketFactory;
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: n */
    public X509TrustManager mo10325n() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        C12238m.checkExpressionValueIsNotNull(trustManagerFactory, "TrustManagerFactory.getI…(null as KeyStore?)\n    }");
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers == null) {
            C12238m.throwNpe();
        }
        if (!(trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager))) {
            StringBuilder sbM833U = C1643a.m833U("Unexpected default trust managers: ");
            String string = Arrays.toString(trustManagers);
            C12238m.checkExpressionValueIsNotNull(string, "java.util.Arrays.toString(this)");
            sbM833U.append(string);
            throw new IllegalStateException(sbM833U.toString().toString());
        }
        TrustManager trustManager = trustManagers[0];
        if (trustManager == null) {
            throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
        Conscrypt.setHostnameVerifier(x509TrustManager, b.f25769a);
        return x509TrustManager;
    }
}
