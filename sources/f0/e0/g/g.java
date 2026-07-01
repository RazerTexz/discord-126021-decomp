package f0.e0.g;

import d0.z.d.o;
import f0.v;
import java.security.cert.Certificate;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: RealConnection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends o implements Function0<List<? extends Certificate>> {
    public final /* synthetic */ f0.a $address;
    public final /* synthetic */ f0.g $certificatePinner;
    public final /* synthetic */ v $unverifiedHandshake;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f0.g gVar, v vVar, f0.a aVar) {
        super(0);
        this.$certificatePinner = gVar;
        this.$unverifiedHandshake = vVar;
        this.$address = aVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public List<? extends Certificate> invoke() {
        f0.e0.m.c cVar = this.$certificatePinner.d;
        if (cVar == null) {
            d0.z.d.m.throwNpe();
        }
        return cVar.a(this.$unverifiedHandshake.c(), this.$address.a.g);
    }
}
