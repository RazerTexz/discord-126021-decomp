package b.i.c.m.d.k;

import android.os.Build;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class y implements x$g {
    public final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1705b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ int f;

    public y(x xVar, int i, String str, int i2, long j, long j2, boolean z2, int i3, String str2, String str3) {
        this.a = i;
        this.f1705b = i2;
        this.c = j;
        this.d = j2;
        this.e = z2;
        this.f = i3;
    }

    @Override // b.i.c.m.d.k.x$g
    public void a(b.i.c.m.d.p.c cVar) throws Exception {
        int i = this.a;
        String str = Build.MODEL;
        int i2 = this.f1705b;
        long j = this.c;
        long j2 = this.d;
        boolean z2 = this.e;
        int i3 = this.f;
        String str2 = Build.MANUFACTURER;
        String str3 = Build.PRODUCT;
        b.i.c.m.d.p.a aVarJ = b.i.c.m.d.p.d.j(str);
        b.i.c.m.d.p.a aVarJ2 = b.i.c.m.d.p.d.j(str3);
        b.i.c.m.d.p.a aVarJ3 = b.i.c.m.d.p.d.j(str2);
        cVar.r(9, 2);
        int iC = b.i.c.m.d.p.c.c(3, i) + 0;
        int iB = aVarJ == null ? 0 : b.i.c.m.d.p.c.b(4, aVarJ);
        int iF = b.i.c.m.d.p.c.f(5, i2);
        int iH = b.i.c.m.d.p.c.h(6, j);
        int iH2 = b.i.c.m.d.p.c.h(7, j2);
        cVar.o(b.i.c.m.d.p.c.f(12, i3) + b.i.c.m.d.p.c.a(10, z2) + iH2 + iH + iF + iC + iB + (aVarJ3 == null ? 0 : b.i.c.m.d.p.c.b(13, aVarJ3)) + (aVarJ2 == null ? 0 : b.i.c.m.d.p.c.b(14, aVarJ2)));
        cVar.m(3, i);
        cVar.l(4, aVarJ);
        cVar.s(5, i2);
        cVar.t(6, j);
        cVar.t(7, j2);
        cVar.k(10, z2);
        cVar.s(12, i3);
        if (aVarJ3 != null) {
            cVar.l(13, aVarJ3);
        }
        if (aVarJ2 != null) {
            cVar.l(14, aVarJ2);
        }
    }
}
