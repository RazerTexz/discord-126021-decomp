package p600f0;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p600f0.p601e0.p612m.AbstractC12349c;

/* JADX INFO: renamed from: f0.h */
/* JADX INFO: compiled from: CertificatePinner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12364h extends AbstractC12240o implements Function0<List<? extends X509Certificate>> {
    public final /* synthetic */ String $hostname;
    public final /* synthetic */ List $peerCertificates;
    public final /* synthetic */ C12363g this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12364h(C12363g c12363g, List list, String str) {
        super(0);
        this.this$0 = c12363g;
        this.$peerCertificates = list;
        this.$hostname = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public List<? extends X509Certificate> invoke() {
        List<Certificate> listMo10338a;
        AbstractC12349c abstractC12349c = this.this$0.f25906d;
        if (abstractC12349c == null || (listMo10338a = abstractC12349c.mo10338a(this.$peerCertificates, this.$hostname)) == null) {
            listMo10338a = this.$peerCertificates;
        }
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listMo10338a, 10));
        for (Certificate certificate : listMo10338a) {
            if (certificate == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }
}
