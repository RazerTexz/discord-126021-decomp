package f0.e0.k;

import d0.z.d.m;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
import kotlin.TypeCastException;

/* JADX INFO: compiled from: AndroidPlatform.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$b implements f0.e0.m.e {
    public final X509TrustManager a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f3648b;

    public b$b(X509TrustManager x509TrustManager, Method method) {
        m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        m.checkParameterIsNotNull(method, "findByIssuerAndSignatureMethod");
        this.a = x509TrustManager;
        this.f3648b = method;
    }

    @Override // f0.e0.m.e
    public X509Certificate a(X509Certificate x509Certificate) {
        m.checkParameterIsNotNull(x509Certificate, "cert");
        try {
            Object objInvoke = this.f3648b.invoke(this.a, x509Certificate);
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
        if (!(obj instanceof b$b)) {
            return false;
        }
        b$b b_b = (b$b) obj;
        return m.areEqual(this.a, b_b.a) && m.areEqual(this.f3648b, b_b.f3648b);
    }

    public int hashCode() {
        X509TrustManager x509TrustManager = this.a;
        int iHashCode = (x509TrustManager != null ? x509TrustManager.hashCode() : 0) * 31;
        Method method = this.f3648b;
        return iHashCode + (method != null ? method.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("CustomTrustRootIndex(trustManager=");
        sbU.append(this.a);
        sbU.append(", findByIssuerAndSignatureMethod=");
        sbU.append(this.f3648b);
        sbU.append(")");
        return sbU.toString();
    }
}
