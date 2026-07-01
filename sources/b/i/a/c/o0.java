package b.i.a.c;

import android.os.Bundle;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class o0 implements w0$a {
    public static final /* synthetic */ o0 a = new o0();

    @Override // b.i.a.c.w0$a
    public final w0 a(Bundle bundle) {
        w0 l1Var;
        int i = bundle.getInt(Integer.toString(0, 36), -1);
        if (i == 0) {
            b.c.a.a0.d.j(bundle.getInt(l1.a(0), -1) == 0);
            if (bundle.getBoolean(l1.a(1), false)) {
                return new l1(bundle.getBoolean(l1.a(2), false));
            }
            l1Var = new l1();
        } else if (i == 1) {
            b.c.a.a0.d.j(bundle.getInt(Integer.toString(0, 36), -1) == 1);
            float f = bundle.getFloat(Integer.toString(1, 36), -1.0f);
            if (f != -1.0f) {
                return new v1(f);
            }
            l1Var = new v1();
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalArgumentException(b.d.b.a.a.g(44, "Encountered unknown rating type: ", i));
                }
                b.c.a.a0.d.j(bundle.getInt(n2.a(0), -1) == 3);
                return bundle.getBoolean(n2.a(1), false) ? new n2(bundle.getBoolean(n2.a(2), false)) : new n2();
            }
            b.c.a.a0.d.j(bundle.getInt(l2.a(0), -1) == 2);
            int i2 = bundle.getInt(l2.a(1), 5);
            float f2 = bundle.getFloat(l2.a(2), -1.0f);
            if (f2 != -1.0f) {
                return new l2(i2, f2);
            }
            l1Var = new l2(i2);
        }
        return l1Var;
    }
}
