package p600f0.p601e0.p605g;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12378v;

/* JADX INFO: renamed from: f0.e0.g.h */
/* JADX INFO: compiled from: RealConnection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12288h extends AbstractC12240o implements Function0<List<? extends X509Certificate>> {
    public final /* synthetic */ C12290j this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12288h(C12290j c12290j) {
        super(0);
        this.this$0 = c12290j;
    }

    @Override // kotlin.jvm.functions.Function0
    public List<? extends X509Certificate> invoke() {
        C12378v c12378v = this.this$0.f25493d;
        if (c12378v == null) {
            C12238m.throwNpe();
        }
        List<Certificate> listM10398c = c12378v.m10398c();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listM10398c, 10));
        for (Certificate certificate : listM10398c) {
            if (certificate == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            arrayList.add((X509Certificate) certificate);
        }
        return arrayList;
    }
}
