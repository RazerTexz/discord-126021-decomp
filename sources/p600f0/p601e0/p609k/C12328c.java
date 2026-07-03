package p600f0.p601e0.p609k;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;
import p600f0.EnumC12381y;

/* JADX INFO: renamed from: f0.e0.k.c */
/* JADX INFO: compiled from: BouncyCastlePlatform.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12328c extends C12333h {

    /* JADX INFO: renamed from: d */
    public static final boolean f25763d;

    /* JADX INFO: renamed from: e */
    public static final a f25764e;

    /* JADX INFO: renamed from: f */
    public final Provider f25765f = new BouncyCastleJsseProvider();

    /* JADX INFO: renamed from: f0.e0.k.c$a */
    /* JADX INFO: compiled from: BouncyCastlePlatform.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        a aVar = new a(null);
        f25764e = aVar;
        boolean z2 = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, aVar.getClass().getClassLoader());
            z2 = true;
        } catch (ClassNotFoundException unused) {
        }
        f25763d = z2;
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: d */
    public void mo10316d(SSLSocket sSLSocket, String str, List<EnumC12381y> list) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        C12238m.checkParameterIsNotNull(list, "protocols");
        if (!(sSLSocket instanceof BCSSLSocket)) {
            C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
            C12238m.checkParameterIsNotNull(list, "protocols");
            return;
        }
        BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
        BCSSLParameters parameters = bCSSLSocket.getParameters();
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
        C12238m.checkExpressionValueIsNotNull(parameters, "sslParameters");
        Object[] array = arrayList2.toArray(new String[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        parameters.setApplicationProtocols((String[]) array);
        bCSSLSocket.setParameters(parameters);
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: f */
    public String mo10317f(SSLSocket sSLSocket) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        if (sSLSocket instanceof BCSSLSocket) {
            String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
            if (applicationProtocol != null && !C12238m.areEqual(applicationProtocol, "")) {
                return applicationProtocol;
            }
        } else {
            super.mo10317f(sSLSocket);
        }
        return null;
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: l */
    public SSLContext mo10324l() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f25765f);
        C12238m.checkExpressionValueIsNotNull(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: n */
    public X509TrustManager mo10325n() throws NoSuchAlgorithmException, KeyStoreException, NoSuchProviderException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
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
}
