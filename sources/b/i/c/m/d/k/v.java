package b.i.c.m.d.k;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class v implements x$g {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1697b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;
    public final /* synthetic */ x f;

    public v(x xVar, String str, String str2, String str3, String str4, int i) {
        this.f = xVar;
        this.a = str;
        this.f1697b = str2;
        this.c = str3;
        this.d = str4;
        this.e = i;
    }

    @Override // b.i.c.m.d.k.x$g
    public void a(b.i.c.m.d.p.c cVar) throws Exception {
        String str = this.a;
        String str2 = this.f1697b;
        String str3 = this.c;
        String str4 = this.d;
        int i = this.e;
        String str5 = this.f.f1702y;
        b.i.c.m.d.p.a aVar = b.i.c.m.d.p.d.a;
        b.i.c.m.d.p.a aVarA = b.i.c.m.d.p.a.a(str);
        b.i.c.m.d.p.a aVarA2 = b.i.c.m.d.p.a.a(str2);
        b.i.c.m.d.p.a aVarA3 = b.i.c.m.d.p.a.a(str3);
        b.i.c.m.d.p.a aVarA4 = b.i.c.m.d.p.a.a(str4);
        b.i.c.m.d.p.a aVarA5 = str5 != null ? b.i.c.m.d.p.a.a(str5) : null;
        cVar.r(7, 2);
        int iB = b.i.c.m.d.p.c.b(6, aVarA4) + b.i.c.m.d.p.c.b(3, aVarA3) + b.i.c.m.d.p.c.b(2, aVarA2) + b.i.c.m.d.p.c.b(1, aVarA) + 0;
        if (aVarA5 != null) {
            iB = b.i.c.m.d.p.c.b(9, aVarA5) + b.i.c.m.d.p.c.b(8, b.i.c.m.d.p.d.f1740b) + iB;
        }
        cVar.o(b.i.c.m.d.p.c.c(10, i) + iB);
        cVar.l(1, aVarA);
        cVar.l(2, aVarA2);
        cVar.l(3, aVarA3);
        cVar.l(6, aVarA4);
        if (aVarA5 != null) {
            cVar.l(8, b.i.c.m.d.p.d.f1740b);
            cVar.l(9, aVarA5);
        }
        cVar.m(10, i);
    }
}
