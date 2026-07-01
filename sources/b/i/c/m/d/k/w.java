package b.i.c.m.d.k;

import android.os.Build$VERSION;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class w implements x$g {
    public final /* synthetic */ boolean a;

    public w(x xVar, String str, String str2, boolean z2) {
        this.a = z2;
    }

    @Override // b.i.c.m.d.k.x$g
    public void a(b.i.c.m.d.p.c cVar) throws Exception {
        String str = Build$VERSION.RELEASE;
        String str2 = Build$VERSION.CODENAME;
        boolean z2 = this.a;
        b.i.c.m.d.p.a aVar = b.i.c.m.d.p.d.a;
        b.i.c.m.d.p.a aVarA = b.i.c.m.d.p.a.a(str);
        b.i.c.m.d.p.a aVarA2 = b.i.c.m.d.p.a.a(str2);
        cVar.r(8, 2);
        cVar.o(b.i.c.m.d.p.c.a(4, z2) + b.i.c.m.d.p.c.b(3, aVarA2) + b.i.c.m.d.p.c.b(2, aVarA) + b.i.c.m.d.p.c.c(1, 3) + 0);
        cVar.m(1, 3);
        cVar.l(2, aVarA);
        cVar.l(3, aVarA2);
        cVar.k(4, z2);
    }
}
