package p600f0.p601e0.p612m;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.TypeCastException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: f0.e0.m.a */
/* JADX INFO: compiled from: BasicCertificateChainCleaner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12347a extends AbstractC12349c {

    /* JADX INFO: renamed from: a */
    public final InterfaceC12351e f25809a;

    public C12347a(InterfaceC12351e interfaceC12351e) {
        C12238m.checkParameterIsNotNull(interfaceC12351e, "trustRootIndex");
        this.f25809a = interfaceC12351e;
    }

    @Override // p600f0.p601e0.p612m.AbstractC12349c
    /* JADX INFO: renamed from: a */
    public List<Certificate> mo10338a(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException {
        X509Certificate x509Certificate;
        C12238m.checkParameterIsNotNull(list, "chain");
        C12238m.checkParameterIsNotNull(str, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        Object objRemoveFirst = arrayDeque.removeFirst();
        C12238m.checkExpressionValueIsNotNull(objRemoveFirst, "queue.removeFirst()");
        arrayList.add(objRemoveFirst);
        boolean z2 = false;
        for (int i = 0; i < 9; i++) {
            Object obj = arrayList.get(arrayList.size() - 1);
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            X509Certificate x509Certificate2 = (X509Certificate) obj;
            X509Certificate x509CertificateMo10323a = this.f25809a.mo10323a(x509Certificate2);
            if (x509CertificateMo10323a != null) {
                if (arrayList.size() > 1 || (!C12238m.areEqual(x509Certificate2, x509CertificateMo10323a))) {
                    arrayList.add(x509CertificateMo10323a);
                }
                if (m10342b(x509CertificateMo10323a, x509CertificateMo10323a)) {
                    return arrayList;
                }
                z2 = true;
            } else {
                Iterator it = arrayDeque.iterator();
                C12238m.checkExpressionValueIsNotNull(it, "queue.iterator()");
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
                } while (!m10342b(x509Certificate2, x509Certificate));
                it.remove();
                arrayList.add(x509Certificate);
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    /* JADX INFO: renamed from: b */
    public final boolean m10342b(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!C12238m.areEqual(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN())) {
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
        return (obj instanceof C12347a) && C12238m.areEqual(((C12347a) obj).f25809a, this.f25809a);
    }

    public int hashCode() {
        return this.f25809a.hashCode();
    }
}
