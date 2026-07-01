package b.i.a.c;

import android.content.Context;
import b.i.a.c.e3.p$b;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements b.i.b.a.l {
    public final /* synthetic */ Context j;

    public /* synthetic */ e(Context context) {
        this.j = context;
    }

    @Override // b.i.b.a.l
    public final Object get() {
        b.i.a.c.e3.p pVar;
        Context context = this.j;
        b.i.b.b.p<Long> pVar2 = b.i.a.c.e3.p.a;
        synchronized (b.i.a.c.e3.p.class) {
            if (b.i.a.c.e3.p.g == null) {
                p$b p_b = new p$b(context);
                b.i.a.c.e3.p.g = new b.i.a.c.e3.p(p_b.a, p_b.f947b, p_b.c, p_b.d, p_b.e, null);
            }
            pVar = b.i.a.c.e3.p.g;
        }
        return pVar;
    }
}
