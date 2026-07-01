package f0.e0.k.i;

import android.net.http.X509TrustManagerExtensions;
import d0.z.d.Intrinsics3;
import f0.e0.m.CertificateChainCleaner;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;

/* JADX INFO: renamed from: f0.e0.k.i.b, reason: use source file name */
/* JADX INFO: compiled from: AndroidCertificateChainCleaner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AndroidCertificateChainCleaner extends CertificateChainCleaner {
    public final X509TrustManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final X509TrustManagerExtensions f3651b;

    public AndroidCertificateChainCleaner(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        Intrinsics3.checkParameterIsNotNull(x509TrustManager, "trustManager");
        Intrinsics3.checkParameterIsNotNull(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.a = x509TrustManager;
        this.f3651b = x509TrustManagerExtensions;
    }

    @Override // f0.e0.m.CertificateChainCleaner
    public List<Certificate> a(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException {
        Intrinsics3.checkParameterIsNotNull(list, "chain");
        Intrinsics3.checkParameterIsNotNull(str, "hostname");
        Object[] array = list.toArray(new X509Certificate[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        try {
            List<X509Certificate> listCheckServerTrusted = this.f3651b.checkServerTrusted((X509Certificate[]) array, "RSA", str);
            Intrinsics3.checkExpressionValueIsNotNull(listCheckServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return listCheckServerTrusted;
        } catch (CertificateException e) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
            sSLPeerUnverifiedException.initCause(e);
            throw sSLPeerUnverifiedException;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof AndroidCertificateChainCleaner) && ((AndroidCertificateChainCleaner) obj).a == this.a;
    }

    public int hashCode() {
        return System.identityHashCode(this.a);
    }
}
