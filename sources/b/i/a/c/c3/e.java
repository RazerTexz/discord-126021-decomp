package b.i.a.c.c3;

import android.os.Bundle;
import b.i.a.c.a3.n0;
import b.i.a.c.j1;
import b.i.a.c.w0;
import b.i.a.c.w0$a;
import b.i.b.b.h0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements w0$a {
    public static final /* synthetic */ e a = new e();

    @Override // b.i.a.c.w0$a
    public final w0 a(Bundle bundle) {
        int i = o$a.j;
        Bundle bundle2 = bundle.getBundle(Integer.toString(0, 36));
        Objects.requireNonNull(bundle2);
        int i2 = n0.j;
        w0$a<j1> w0_a = j1.k;
        ArrayList parcelableArrayList = bundle2.getParcelableArrayList(Integer.toString(0, 36));
        b.i.b.b.a<Object> aVar = b.i.b.b.p.k;
        n0 n0Var = new n0((j1[]) b.i.a.c.f3.f.b(w0_a, parcelableArrayList, h0.l).toArray(new j1[0]));
        int[] intArray = bundle.getIntArray(Integer.toString(1, 36));
        if (intArray == null) {
            return new o$a(n0Var);
        }
        return new o$a(n0Var, intArray.length == 0 ? Collections.emptyList() : new b.i.b.c.a(intArray));
    }
}
