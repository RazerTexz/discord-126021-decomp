package b.i.a.c;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class k0 implements w0$a {
    public static final /* synthetic */ k0 a = new k0();

    @Override // b.i.a.c.w0$a
    public final w0 a(Bundle bundle) {
        String string = bundle.getString(o1.a(0), "");
        Objects.requireNonNull(string);
        Bundle bundle2 = bundle.getBundle(o1.a(1));
        o1$g o1_g = bundle2 == null ? o1$g.j : (o1$g) o1$g.k.a(bundle2);
        Bundle bundle3 = bundle.getBundle(o1.a(2));
        p1 p1Var = bundle3 == null ? p1.j : (p1) p1.k.a(bundle3);
        Bundle bundle4 = bundle.getBundle(o1.a(3));
        return new o1(string, bundle4 == null ? o1$e.p : (o1$e) o1$d.j.a(bundle4), null, o1_g, p1Var);
    }
}
