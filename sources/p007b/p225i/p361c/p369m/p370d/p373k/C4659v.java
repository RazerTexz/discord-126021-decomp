package p007b.p225i.p361c.p369m.p370d.p373k;

import p007b.p225i.p361c.p369m.p370d.p373k.C4663x;
import p007b.p225i.p361c.p369m.p370d.p379p.C4716a;
import p007b.p225i.p361c.p369m.p370d.p379p.C4718c;
import p007b.p225i.p361c.p369m.p370d.p379p.C4719d;

/* JADX INFO: renamed from: b.i.c.m.d.k.v */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4659v implements C4663x.g {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ String f12401a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f12402b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f12403c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ String f12404d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f12405e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ C4663x f12406f;

    public C4659v(C4663x c4663x, String str, String str2, String str3, String str4, int i) {
        this.f12406f = c4663x;
        this.f12401a = str;
        this.f12402b = str2;
        this.f12403c = str3;
        this.f12404d = str4;
        this.f12405e = i;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p373k.C4663x.g
    /* JADX INFO: renamed from: a */
    public void mo6454a(C4718c c4718c) throws Exception {
        String str = this.f12401a;
        String str2 = this.f12402b;
        String str3 = this.f12403c;
        String str4 = this.f12404d;
        int i = this.f12405e;
        String str5 = this.f12406f.f12445y;
        C4716a c4716a = C4719d.f12694a;
        C4716a c4716aM6637a = C4716a.m6637a(str);
        C4716a c4716aM6637a2 = C4716a.m6637a(str2);
        C4716a c4716aM6637a3 = C4716a.m6637a(str3);
        C4716a c4716aM6637a4 = C4716a.m6637a(str4);
        C4716a c4716aM6637a5 = str5 != null ? C4716a.m6637a(str5) : null;
        c4718c.m6654r(7, 2);
        int iM6640b = C4718c.m6640b(6, c4716aM6637a4) + C4718c.m6640b(3, c4716aM6637a3) + C4718c.m6640b(2, c4716aM6637a2) + C4718c.m6640b(1, c4716aM6637a) + 0;
        if (c4716aM6637a5 != null) {
            iM6640b = C4718c.m6640b(9, c4716aM6637a5) + C4718c.m6640b(8, C4719d.f12695b) + iM6640b;
        }
        c4718c.m6652o(C4718c.m6641c(10, i) + iM6640b);
        c4718c.m6649l(1, c4716aM6637a);
        c4718c.m6649l(2, c4716aM6637a2);
        c4718c.m6649l(3, c4716aM6637a3);
        c4718c.m6649l(6, c4716aM6637a4);
        if (c4716aM6637a5 != null) {
            c4718c.m6649l(8, C4719d.f12695b);
            c4718c.m6649l(9, c4716aM6637a5);
        }
        c4718c.m6650m(10, i);
    }
}
