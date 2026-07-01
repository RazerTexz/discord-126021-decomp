package b.i.a.c;

import android.os.Bundle;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i0 implements w0$a {
    public static final /* synthetic */ i0 a = new i0();

    @Override // b.i.a.c.w0$a
    public final w0 a(Bundle bundle) {
        o1$d$a o1_d_a = new o1$d$a();
        long j = bundle.getLong(o1$d.a(0), 0L);
        boolean z2 = true;
        b.c.a.a0.d.j(j >= 0);
        o1_d_a.a = j;
        long j2 = bundle.getLong(o1$d.a(1), Long.MIN_VALUE);
        if (j2 != Long.MIN_VALUE && j2 < 0) {
            z2 = false;
        }
        b.c.a.a0.d.j(z2);
        o1_d_a.f1035b = j2;
        o1_d_a.c = bundle.getBoolean(o1$d.a(2), false);
        o1_d_a.d = bundle.getBoolean(o1$d.a(3), false);
        o1_d_a.e = bundle.getBoolean(o1$d.a(4), false);
        return o1_d_a.a();
    }
}
