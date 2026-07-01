package b.i.a.c;

import android.os.Bundle;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class q0 implements w0$a {
    public static final /* synthetic */ q0 a = new q0();

    @Override // b.i.a.c.w0$a
    public final w0 a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(o2$c.d(1));
        o1 o1Var = bundle2 != null ? (o1) o1.j.a(bundle2) : null;
        long j = bundle.getLong(o2$c.d(2), -9223372036854775807L);
        long j2 = bundle.getLong(o2$c.d(3), -9223372036854775807L);
        long j3 = bundle.getLong(o2$c.d(4), -9223372036854775807L);
        boolean z2 = bundle.getBoolean(o2$c.d(5), false);
        boolean z3 = bundle.getBoolean(o2$c.d(6), false);
        Bundle bundle3 = bundle.getBundle(o2$c.d(7));
        o1$g o1_g = bundle3 != null ? (o1$g) o1$g.k.a(bundle3) : null;
        boolean z4 = bundle.getBoolean(o2$c.d(8), false);
        long j4 = bundle.getLong(o2$c.d(9), 0L);
        long j5 = bundle.getLong(o2$c.d(10), -9223372036854775807L);
        int i = bundle.getInt(o2$c.d(11), 0);
        int i2 = bundle.getInt(o2$c.d(12), 0);
        long j6 = bundle.getLong(o2$c.d(13), 0L);
        o2$c o2_c = new o2$c();
        o2_c.e(o2$c.k, o1Var, null, j, j2, j3, z2, z3, o1_g, j4, j5, i, i2, j6);
        o2_c.f1044y = z4;
        return o2_c;
    }
}
