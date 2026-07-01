package b.i.a.c;

import android.os.Bundle;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class h0 implements w0$a {
    public static final /* synthetic */ h0 a = new h0();

    @Override // b.i.a.c.w0$a
    public final w0 a(Bundle bundle) {
        j1 j1Var = j1.j;
        j1$b j1_b = new j1$b();
        if (bundle != null) {
            ClassLoader classLoader = b.i.a.c.f3.f.class.getClassLoader();
            int i = b.i.a.c.f3.e0.a;
            bundle.setClassLoader(classLoader);
        }
        int i2 = 0;
        String string = bundle.getString(j1.d(0));
        j1 j1Var2 = j1.j;
        j1_b.a = (String) j1.b(string, j1Var2.l);
        j1_b.f1021b = (String) j1.b(bundle.getString(j1.d(1)), j1Var2.m);
        j1_b.c = (String) j1.b(bundle.getString(j1.d(2)), j1Var2.n);
        j1_b.d = bundle.getInt(j1.d(3), j1Var2.o);
        j1_b.e = bundle.getInt(j1.d(4), j1Var2.p);
        j1_b.f = bundle.getInt(j1.d(5), j1Var2.q);
        j1_b.g = bundle.getInt(j1.d(6), j1Var2.r);
        j1_b.h = (String) j1.b(bundle.getString(j1.d(7)), j1Var2.t);
        j1_b.i = (Metadata) j1.b((Metadata) bundle.getParcelable(j1.d(8)), j1Var2.u);
        j1_b.j = (String) j1.b(bundle.getString(j1.d(9)), j1Var2.v);
        j1_b.k = (String) j1.b(bundle.getString(j1.d(10)), j1Var2.w);
        j1_b.l = bundle.getInt(j1.d(11), j1Var2.f1018x);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strD = j1.d(12);
            String string2 = Integer.toString(i2, 36);
            StringBuilder sb = new StringBuilder(String.valueOf(string2).length() + String.valueOf(strD).length() + 1);
            sb.append(strD);
            sb.append("_");
            sb.append(string2);
            byte[] byteArray = bundle.getByteArray(sb.toString());
            if (byteArray == null) {
                j1_b.m = arrayList;
                j1_b.n = (DrmInitData) bundle.getParcelable(j1.d(13));
                String strD2 = j1.d(14);
                j1 j1Var3 = j1.j;
                j1_b.o = bundle.getLong(strD2, j1Var3.A);
                j1_b.p = bundle.getInt(j1.d(15), j1Var3.B);
                j1_b.q = bundle.getInt(j1.d(16), j1Var3.C);
                j1_b.r = bundle.getFloat(j1.d(17), j1Var3.D);
                j1_b.f1022s = bundle.getInt(j1.d(18), j1Var3.E);
                j1_b.t = bundle.getFloat(j1.d(19), j1Var3.F);
                j1_b.u = bundle.getByteArray(j1.d(20));
                j1_b.v = bundle.getInt(j1.d(21), j1Var3.H);
                int i3 = b.i.a.c.g3.n.j;
                j1_b.w = (b.i.a.c.g3.n) b.i.a.c.f3.f.c(b.i.a.c.g3.a.a, bundle.getBundle(j1.d(22)));
                j1_b.f1023x = bundle.getInt(j1.d(23), j1Var3.J);
                j1_b.f1024y = bundle.getInt(j1.d(24), j1Var3.K);
                j1_b.f1025z = bundle.getInt(j1.d(25), j1Var3.L);
                j1_b.A = bundle.getInt(j1.d(26), j1Var3.M);
                j1_b.B = bundle.getInt(j1.d(27), j1Var3.N);
                j1_b.C = bundle.getInt(j1.d(28), j1Var3.O);
                j1_b.D = bundle.getInt(j1.d(29), j1Var3.P);
                return j1_b.a();
            }
            arrayList.add(byteArray);
            i2++;
        }
    }
}
