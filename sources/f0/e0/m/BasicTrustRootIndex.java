package f0.e0.m;

import d0.z.d.Intrinsics3;
import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: renamed from: f0.e0.m.b, reason: use source file name */
/* JADX INFO: compiled from: BasicTrustRootIndex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BasicTrustRootIndex implements TrustRootIndex {
    public final Map<X500Principal, Set<X509Certificate>> a;

    public BasicTrustRootIndex(X509Certificate... x509CertificateArr) {
        Intrinsics3.checkParameterIsNotNull(x509CertificateArr, "caCerts");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Intrinsics3.checkExpressionValueIsNotNull(subjectX500Principal, "caCert.subjectX500Principal");
            Object linkedHashSet = linkedHashMap.get(subjectX500Principal);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
                linkedHashMap.put(subjectX500Principal, linkedHashSet);
            }
            ((Set) linkedHashSet).add(x509Certificate);
        }
        this.a = linkedHashMap;
    }

    @Override // f0.e0.m.TrustRootIndex
    public X509Certificate a(X509Certificate x509Certificate) {
        boolean z2;
        Intrinsics3.checkParameterIsNotNull(x509Certificate, "cert");
        Set<X509Certificate> set = this.a.get(x509Certificate.getIssuerX500Principal());
        Object obj = null;
        if (set == null) {
            return null;
        }
        for (Object obj2 : set) {
            try {
                x509Certificate.verify(((X509Certificate) obj2).getPublicKey());
                z2 = true;
            } catch (Exception unused) {
                z2 = false;
            }
            if (z2) {
                obj = obj2;
                break;
            }
        }
        return (X509Certificate) obj;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof BasicTrustRootIndex) && Intrinsics3.areEqual(((BasicTrustRootIndex) obj).a, this.a));
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
