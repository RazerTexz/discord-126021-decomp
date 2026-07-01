package b.i.a.c.c3;

import android.os.Bundle;
import b.i.a.c.w0;
import b.i.a.c.w0$a;
import b.i.b.b.h0;
import b.i.b.b.q$a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements w0$a {
    public static final /* synthetic */ d a = new d();

    @Override // b.i.a.c.w0$a
    public final w0 a(Bundle bundle) {
        o oVar = o.j;
        int i = o$a.j;
        e eVar = e.a;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(Integer.toString(0, 36));
        b.i.b.b.a<Object> aVar = b.i.b.b.p.k;
        List listB = b.i.a.c.f3.f.b(eVar, parcelableArrayList, h0.l);
        q$a q_a = new q$a(4);
        for (int i2 = 0; i2 < listB.size(); i2++) {
            o$a o_a = (o$a) listB.get(i2);
            q_a.c(o_a.k, o_a);
        }
        return new o(q_a.a());
    }
}
