package f0;

import d0.t.Iterables2;
import d0.z.d.Lambda;
import f0.e0.m.CertificateChainCleaner;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: f0.h, reason: use source file name */
/* JADX INFO: compiled from: CertificatePinner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CertificatePinner2 extends Lambda implements Function0<List<? extends X509Certificate>> {
    public final /* synthetic */ String $hostname;
    public final /* synthetic */ List $peerCertificates;
    public final /* synthetic */ CertificatePinner this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CertificatePinner2(CertificatePinner certificatePinner, List list, String str) {
        super(0);
        this.this$0 = certificatePinner;
        this.$peerCertificates = list;
        this.$hostname = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public List<? extends X509Certificate> invoke() {
        List<Certificate> listA;
        CertificateChainCleaner certificateChainCleaner = this.this$0.d;
        if (certificateChainCleaner == null || (listA = certificateChainCleaner.a(this.$peerCertificates, this.$hostname)) == null) {
            listA = this.$peerCertificates;
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listA, 10));
        for (Certificate certificate : listA) {
            if (certificate == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }
}
