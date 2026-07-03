package p600f0.p601e0.p609k.p610i;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.p612m.AbstractC12349c;

/* JADX INFO: renamed from: f0.e0.k.i.b */
/* JADX INFO: compiled from: AndroidCertificateChainCleaner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12335b extends AbstractC12349c {

    /* JADX INFO: renamed from: a */
    public final X509TrustManager f25786a;

    /* JADX INFO: renamed from: b */
    public final X509TrustManagerExtensions f25787b;

    public C12335b(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        C12238m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        C12238m.checkParameterIsNotNull(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.f25786a = x509TrustManager;
        this.f25787b = x509TrustManagerExtensions;
    }

    @Override // p600f0.p601e0.p612m.AbstractC12349c
    /* JADX INFO: renamed from: a */
    public List<Certificate> mo10338a(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException {
        C12238m.checkParameterIsNotNull(list, "chain");
        C12238m.checkParameterIsNotNull(str, "hostname");
        Object[] array = list.toArray(new X509Certificate[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        try {
            List<X509Certificate> listCheckServerTrusted = this.f25787b.checkServerTrusted((X509Certificate[]) array, "RSA", str);
            C12238m.checkExpressionValueIsNotNull(listCheckServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return listCheckServerTrusted;
        } catch (CertificateException e) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
            sSLPeerUnverifiedException.initCause(e);
            throw sSLPeerUnverifiedException;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof C12335b) && ((C12335b) obj).f25786a == this.f25786a;
    }

    public int hashCode() {
        return System.identityHashCode(this.f25786a);
    }
}
