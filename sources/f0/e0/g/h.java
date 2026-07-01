package f0.e0.g;

import d0.z.d.o;
import f0.v;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: RealConnection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends o implements Function0<List<? extends X509Certificate>> {
    public final /* synthetic */ j this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(j jVar) {
        super(0);
        this.this$0 = jVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public List<? extends X509Certificate> invoke() {
        v vVar = this.this$0.d;
        if (vVar == null) {
            d0.z.d.m.throwNpe();
        }
        List<Certificate> listC = vVar.c();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listC, 10));
        for (Certificate certificate : listC) {
            if (certificate == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }
}
