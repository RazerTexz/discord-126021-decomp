package p007b.p225i.p361c.p369m.p370d.p373k;

import android.os.Build;
import p007b.p225i.p361c.p369m.p370d.p373k.C4663x;
import p007b.p225i.p361c.p369m.p370d.p379p.C4716a;
import p007b.p225i.p361c.p369m.p370d.p379p.C4718c;
import p007b.p225i.p361c.p369m.p370d.p379p.C4719d;

/* JADX INFO: renamed from: b.i.c.m.d.k.y */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4665y implements C4663x.g {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f12460a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f12461b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ long f12462c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ long f12463d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ boolean f12464e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f12465f;

    public C4665y(C4663x c4663x, int i, String str, int i2, long j, long j2, boolean z2, int i3, String str2, String str3) {
        this.f12460a = i;
        this.f12461b = i2;
        this.f12462c = j;
        this.f12463d = j2;
        this.f12464e = z2;
        this.f12465f = i3;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p373k.C4663x.g
    /* JADX INFO: renamed from: a */
    public void mo6454a(C4718c c4718c) throws Exception {
        int i = this.f12460a;
        String str = Build.MODEL;
        int i2 = this.f12461b;
        long j = this.f12462c;
        long j2 = this.f12463d;
        boolean z2 = this.f12464e;
        int i3 = this.f12465f;
        String str2 = Build.MANUFACTURER;
        String str3 = Build.PRODUCT;
        C4716a c4716aM6666j = C4719d.m6666j(str);
        C4716a c4716aM6666j2 = C4719d.m6666j(str3);
        C4716a c4716aM6666j3 = C4719d.m6666j(str2);
        c4718c.m6654r(9, 2);
        int iM6641c = C4718c.m6641c(3, i) + 0;
        int iM6640b = c4716aM6666j == null ? 0 : C4718c.m6640b(4, c4716aM6666j);
        int iM6644f = C4718c.m6644f(5, i2);
        int iM6645h = C4718c.m6645h(6, j);
        int iM6645h2 = C4718c.m6645h(7, j2);
        c4718c.m6652o(C4718c.m6644f(12, i3) + C4718c.m6639a(10, z2) + iM6645h2 + iM6645h + iM6644f + iM6641c + iM6640b + (c4716aM6666j3 == null ? 0 : C4718c.m6640b(13, c4716aM6666j3)) + (c4716aM6666j2 == null ? 0 : C4718c.m6640b(14, c4716aM6666j2)));
        c4718c.m6650m(3, i);
        c4718c.m6649l(4, c4716aM6666j);
        c4718c.m6655s(5, i2);
        c4718c.m6656t(6, j);
        c4718c.m6656t(7, j2);
        c4718c.m6648k(10, z2);
        c4718c.m6655s(12, i3);
        if (c4716aM6666j3 != null) {
            c4718c.m6649l(13, c4716aM6666j3);
        }
        if (c4716aM6666j2 != null) {
            c4718c.m6649l(14, c4716aM6666j2);
        }
    }
}
