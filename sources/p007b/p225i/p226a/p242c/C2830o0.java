package p007b.p225i.p226a.p242c;

import android.os.Bundle;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.c.o0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2830o0 implements InterfaceC2963w0.a {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ C2830o0 f7260a = new C2830o0();

    @Override // p007b.p225i.p226a.p242c.InterfaceC2963w0.a
    /* JADX INFO: renamed from: a */
    public final InterfaceC2963w0 mo2576a(Bundle bundle) {
        InterfaceC2963w0 c2819l1;
        int i = bundle.getInt(Integer.toString(0, 36), -1);
        if (i == 0) {
            C1460d.m531j(bundle.getInt(C2819l1.m3303a(0), -1) == 0);
            if (bundle.getBoolean(C2819l1.m3303a(1), false)) {
                return new C2819l1(bundle.getBoolean(C2819l1.m3303a(2), false));
            }
            c2819l1 = new C2819l1();
        } else if (i == 1) {
            C1460d.m531j(bundle.getInt(Integer.toString(0, 36), -1) == 1);
            float f = bundle.getFloat(Integer.toString(1, 36), -1.0f);
            if (f != -1.0f) {
                return new C2952v1(f);
            }
            c2819l1 = new C2952v1();
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalArgumentException(C1643a.m851g(44, "Encountered unknown rating type: ", i));
                }
                C1460d.m531j(bundle.getInt(C2828n2.m3318a(0), -1) == 3);
                return bundle.getBoolean(C2828n2.m3318a(1), false) ? new C2828n2(bundle.getBoolean(C2828n2.m3318a(2), false)) : new C2828n2();
            }
            C1460d.m531j(bundle.getInt(C2820l2.m3304a(0), -1) == 2);
            int i2 = bundle.getInt(C2820l2.m3304a(1), 5);
            float f2 = bundle.getFloat(C2820l2.m3304a(2), -1.0f);
            if (f2 != -1.0f) {
                return new C2820l2(i2, f2);
            }
            c2819l1 = new C2820l2(i2);
        }
        return c2819l1;
    }
}
