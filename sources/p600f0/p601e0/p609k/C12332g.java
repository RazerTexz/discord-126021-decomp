package p600f0.p601e0.p609k;

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
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.openjsse.javax.net.ssl.SSLParameters;
import org.openjsse.net.ssl.OpenJSSE;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;
import p600f0.EnumC12381y;

/* JADX INFO: renamed from: f0.e0.k.g */
/* JADX INFO: compiled from: OpenJSSEPlatform.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12332g extends C12333h {

    /* JADX INFO: renamed from: d */
    public static final boolean f25780d;

    /* JADX INFO: renamed from: e */
    public static final a f25781e;

    /* JADX INFO: renamed from: f */
    public final Provider f25782f = new OpenJSSE();

    /* JADX INFO: renamed from: f0.e0.k.g$a */
    /* JADX INFO: compiled from: OpenJSSEPlatform.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        a aVar = new a(null);
        f25781e = aVar;
        boolean z2 = false;
        try {
            Class.forName("org.openjsse.net.ssl.OpenJSSE", false, aVar.getClass().getClassLoader());
            z2 = true;
        } catch (ClassNotFoundException unused) {
        }
        f25780d = z2;
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: d */
    public void mo10316d(SSLSocket sSLSocket, String str, List<EnumC12381y> list) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        C12238m.checkParameterIsNotNull(list, "protocols");
        if (!(sSLSocket instanceof org.openjsse.javax.net.ssl.SSLSocket)) {
            C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
            C12238m.checkParameterIsNotNull(list, "protocols");
            return;
        }
        org.openjsse.javax.net.ssl.SSLSocket sSLSocket2 = (org.openjsse.javax.net.ssl.SSLSocket) sSLSocket;
        SSLParameters sSLParameters = sSLSocket2.getSSLParameters();
        if (sSLParameters instanceof SSLParameters) {
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
            SSLParameters sSLParameters2 = sSLParameters;
            Object[] array = arrayList2.toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            sSLParameters2.setApplicationProtocols((String[]) array);
            sSLSocket2.setSSLParameters(sSLParameters);
        }
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: f */
    public String mo10317f(SSLSocket sSLSocket) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        if (sSLSocket instanceof org.openjsse.javax.net.ssl.SSLSocket) {
            String applicationProtocol = ((org.openjsse.javax.net.ssl.SSLSocket) sSLSocket).getApplicationProtocol();
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
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.3", this.f25782f);
        C12238m.checkExpressionValueIsNotNull(sSLContext, "SSLContext.getInstance(\"TLSv1.3\", provider)");
        return sSLContext;
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: n */
    public X509TrustManager mo10325n() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.f25782f);
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
