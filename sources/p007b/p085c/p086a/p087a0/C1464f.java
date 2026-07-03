package p007b.p085c.p086a.p087a0;

import android.graphics.Color;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c;

/* JADX INFO: renamed from: b.c.a.a0.f */
/* JADX INFO: compiled from: ColorParser.java */
/* JADX INFO: loaded from: classes.dex */
public class C1464f implements InterfaceC1469h0<Integer> {

    /* JADX INFO: renamed from: a */
    public static final C1464f f2228a = new C1464f();

    @Override // p007b.p085c.p086a.p087a0.InterfaceC1469h0
    /* JADX INFO: renamed from: a */
    public Integer mo413a(AbstractC1473c abstractC1473c, float f) throws IOException {
        boolean z2 = abstractC1473c.mo613u() == AbstractC1473c.b.BEGIN_ARRAY;
        if (z2) {
            abstractC1473c.mo603a();
        }
        double dMo609n = abstractC1473c.mo609n();
        double dMo609n2 = abstractC1473c.mo609n();
        double dMo609n3 = abstractC1473c.mo609n();
        double dMo609n4 = abstractC1473c.mo609n();
        if (z2) {
            abstractC1473c.mo605c();
        }
        if (dMo609n <= 1.0d && dMo609n2 <= 1.0d && dMo609n3 <= 1.0d) {
            dMo609n *= 255.0d;
            dMo609n2 *= 255.0d;
            dMo609n3 *= 255.0d;
            if (dMo609n4 <= 1.0d) {
                dMo609n4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) dMo609n4, (int) dMo609n, (int) dMo609n2, (int) dMo609n3));
    }
}
