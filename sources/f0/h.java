package f0;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: CertificatePinner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends d0.z.d.o implements Function0<List<? extends X509Certificate>> {
    public final /* synthetic */ String $hostname;
    public final /* synthetic */ List $peerCertificates;
    public final /* synthetic */ g this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, List list, String str) {
        super(0);
        this.this$0 = gVar;
        this.$peerCertificates = list;
        this.$hostname = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public List<? extends X509Certificate> invoke() {
        List<Certificate> listA;
        f0.e0.m.c cVar = this.this$0.d;
        if (cVar == null || (listA = cVar.a(this.$peerCertificates, this.$hostname)) == null) {
            listA = this.$peerCertificates;
        }
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listA, 10));
        for (Certificate certificate : listA) {
            if (certificate == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }
}
