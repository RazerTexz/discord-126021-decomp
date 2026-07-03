package p007b.p085c.p086a.p087a0;

import java.io.IOException;
import p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c;
import p007b.p085c.p086a.p090c0.C1504d;

/* JADX INFO: renamed from: b.c.a.a0.a0 */
/* JADX INFO: compiled from: ScaleXYParser.java */
/* JADX INFO: loaded from: classes.dex */
public class C1455a0 implements InterfaceC1469h0<C1504d> {

    /* JADX INFO: renamed from: a */
    public static final C1455a0 f2208a = new C1455a0();

    @Override // p007b.p085c.p086a.p087a0.InterfaceC1469h0
    /* JADX INFO: renamed from: a */
    public C1504d mo413a(AbstractC1473c abstractC1473c, float f) throws IOException {
        boolean z2 = abstractC1473c.mo613u() == AbstractC1473c.b.BEGIN_ARRAY;
        if (z2) {
            abstractC1473c.mo603a();
        }
        float fMo609n = (float) abstractC1473c.mo609n();
        float fMo609n2 = (float) abstractC1473c.mo609n();
        while (abstractC1473c.mo607e()) {
            abstractC1473c.mo601C();
        }
        if (z2) {
            abstractC1473c.mo605c();
        }
        return new C1504d((fMo609n / 100.0f) * f, (fMo609n2 / 100.0f) * f);
    }
}
