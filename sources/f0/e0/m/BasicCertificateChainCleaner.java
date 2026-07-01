package f0.e0.m;

import d0.z.d.Intrinsics3;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.TypeCastException;

/* JADX INFO: renamed from: f0.e0.m.a, reason: use source file name */
/* JADX INFO: compiled from: BasicCertificateChainCleaner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BasicCertificateChainCleaner extends CertificateChainCleaner {
    public final TrustRootIndex a;

    public BasicCertificateChainCleaner(TrustRootIndex trustRootIndex) {
        Intrinsics3.checkParameterIsNotNull(trustRootIndex, "trustRootIndex");
        this.a = trustRootIndex;
    }

    @Override // f0.e0.m.CertificateChainCleaner
    public List<Certificate> a(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException {
        X509Certificate x509Certificate;
        Intrinsics3.checkParameterIsNotNull(list, "chain");
        Intrinsics3.checkParameterIsNotNull(str, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        Object objRemoveFirst = arrayDeque.removeFirst();
        Intrinsics3.checkExpressionValueIsNotNull(objRemoveFirst, "queue.removeFirst()");
        arrayList.add(objRemoveFirst);
        boolean z2 = false;
        for (int i = 0; i < 9; i++) {
            Object obj = arrayList.get(arrayList.size() - 1);
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            X509Certificate x509Certificate2 = (X509Certificate) obj;
            X509Certificate x509CertificateA = this.a.a(x509Certificate2);
            if (x509CertificateA != null) {
                if (arrayList.size() > 1 || (!Intrinsics3.areEqual(x509Certificate2, x509CertificateA))) {
                    arrayList.add(x509CertificateA);
                }
                if (b(x509CertificateA, x509CertificateA)) {
                    return arrayList;
                }
                z2 = true;
            } else {
                Iterator it = arrayDeque.iterator();
                Intrinsics3.checkExpressionValueIsNotNull(it, "queue.iterator()");
                do {
                    if (!it.hasNext()) {
                        if (z2) {
                            return arrayList;
                        }
                        throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate2);
                    }
                    Object next = it.next();
                    if (next == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                    }
                    x509Certificate = (X509Certificate) next;
                } while (!b(x509Certificate2, x509Certificate));
                it.remove();
                arrayList.add(x509Certificate);
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public final boolean b(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!Intrinsics3.areEqual(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof BasicCertificateChainCleaner) && Intrinsics3.areEqual(((BasicCertificateChainCleaner) obj).a, this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
