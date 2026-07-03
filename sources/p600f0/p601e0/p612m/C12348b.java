package p600f0.p601e0.p612m;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: f0.e0.m.b */
/* JADX INFO: compiled from: BasicTrustRootIndex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12348b implements InterfaceC12351e {

    /* JADX INFO: renamed from: a */
    public final Map<X500Principal, Set<X509Certificate>> f25810a;

    public C12348b(X509Certificate... x509CertificateArr) {
        C12238m.checkParameterIsNotNull(x509CertificateArr, "caCerts");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            C12238m.checkExpressionValueIsNotNull(subjectX500Principal, "caCert.subjectX500Principal");
            Object linkedHashSet = linkedHashMap.get(subjectX500Principal);
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
                linkedHashMap.put(subjectX500Principal, linkedHashSet);
            }
            ((Set) linkedHashSet).add(x509Certificate);
        }
        this.f25810a = linkedHashMap;
    }

    @Override // p600f0.p601e0.p612m.InterfaceC12351e
    /* JADX INFO: renamed from: a */
    public X509Certificate mo10323a(X509Certificate x509Certificate) {
        boolean z2;
        C12238m.checkParameterIsNotNull(x509Certificate, "cert");
        Set<X509Certificate> set = this.f25810a.get(x509Certificate.getIssuerX500Principal());
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
        return obj == this || ((obj instanceof C12348b) && C12238m.areEqual(((C12348b) obj).f25810a, this.f25810a));
    }

    public int hashCode() {
        return this.f25810a.hashCode();
    }
}
