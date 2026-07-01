package f0.e0.g;

import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import f0.Handshake;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: f0.e0.g.h, reason: use source file name */
/* JADX INFO: compiled from: RealConnection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RealConnection2 extends Lambda implements Function0<List<? extends X509Certificate>> {
    public final /* synthetic */ RealConnection4 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealConnection2(RealConnection4 realConnection4) {
        super(0);
        this.this$0 = realConnection4;
    }

    @Override // kotlin.jvm.functions.Function0
    public List<? extends X509Certificate> invoke() {
        Handshake handshake = this.this$0.d;
        if (handshake == null) {
            Intrinsics3.throwNpe();
        }
        List<Certificate> listC = handshake.c();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listC, 10));
        for (Certificate certificate : listC) {
            if (certificate == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }
}
