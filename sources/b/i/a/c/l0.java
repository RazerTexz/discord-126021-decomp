package b.i.a.c;

import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class l0 implements w0$a {
    public static final /* synthetic */ l0 a = new l0();

    @Override // b.i.a.c.w0$a
    public final w0 a(Bundle bundle) {
        Bundle bundle2;
        Bundle bundle3;
        p1$b p1_b = new p1$b();
        p1_b.a = bundle.getCharSequence(p1.b(0));
        p1_b.f1050b = bundle.getCharSequence(p1.b(1));
        p1_b.c = bundle.getCharSequence(p1.b(2));
        p1_b.d = bundle.getCharSequence(p1.b(3));
        p1_b.e = bundle.getCharSequence(p1.b(4));
        p1_b.f = bundle.getCharSequence(p1.b(5));
        p1_b.g = bundle.getCharSequence(p1.b(6));
        p1_b.h = (Uri) bundle.getParcelable(p1.b(7));
        byte[] byteArray = bundle.getByteArray(p1.b(10));
        Integer numValueOf = bundle.containsKey(p1.b(29)) ? Integer.valueOf(bundle.getInt(p1.b(29))) : null;
        p1_b.k = byteArray != null ? (byte[]) byteArray.clone() : null;
        p1_b.l = numValueOf;
        p1_b.m = (Uri) bundle.getParcelable(p1.b(11));
        p1_b.f1052x = bundle.getCharSequence(p1.b(22));
        p1_b.f1053y = bundle.getCharSequence(p1.b(23));
        p1_b.f1054z = bundle.getCharSequence(p1.b(24));
        p1_b.C = bundle.getCharSequence(p1.b(27));
        p1_b.D = bundle.getCharSequence(p1.b(28));
        p1_b.E = bundle.getBundle(p1.b(1000));
        if (bundle.containsKey(p1.b(8)) && (bundle3 = bundle.getBundle(p1.b(8))) != null) {
            int i = d2.j;
            p1_b.i = (d2) o0.a.a(bundle3);
        }
        if (bundle.containsKey(p1.b(9)) && (bundle2 = bundle.getBundle(p1.b(9))) != null) {
            int i2 = d2.j;
            p1_b.j = (d2) o0.a.a(bundle2);
        }
        if (bundle.containsKey(p1.b(12))) {
            p1_b.n = Integer.valueOf(bundle.getInt(p1.b(12)));
        }
        if (bundle.containsKey(p1.b(13))) {
            p1_b.o = Integer.valueOf(bundle.getInt(p1.b(13)));
        }
        if (bundle.containsKey(p1.b(14))) {
            p1_b.p = Integer.valueOf(bundle.getInt(p1.b(14)));
        }
        if (bundle.containsKey(p1.b(15))) {
            p1_b.q = Boolean.valueOf(bundle.getBoolean(p1.b(15)));
        }
        if (bundle.containsKey(p1.b(16))) {
            p1_b.r = Integer.valueOf(bundle.getInt(p1.b(16)));
        }
        if (bundle.containsKey(p1.b(17))) {
            p1_b.f1051s = Integer.valueOf(bundle.getInt(p1.b(17)));
        }
        if (bundle.containsKey(p1.b(18))) {
            p1_b.t = Integer.valueOf(bundle.getInt(p1.b(18)));
        }
        if (bundle.containsKey(p1.b(19))) {
            p1_b.u = Integer.valueOf(bundle.getInt(p1.b(19)));
        }
        if (bundle.containsKey(p1.b(20))) {
            p1_b.v = Integer.valueOf(bundle.getInt(p1.b(20)));
        }
        if (bundle.containsKey(p1.b(21))) {
            p1_b.w = Integer.valueOf(bundle.getInt(p1.b(21)));
        }
        if (bundle.containsKey(p1.b(25))) {
            p1_b.A = Integer.valueOf(bundle.getInt(p1.b(25)));
        }
        if (bundle.containsKey(p1.b(26))) {
            p1_b.B = Integer.valueOf(bundle.getInt(p1.b(26)));
        }
        return p1_b.a();
    }
}
