package p007b.p225i.p226a.p288f.p330i.p332b;

import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.i.b.l */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4098l {

    /* JADX INFO: renamed from: a */
    public final String f10926a;

    /* JADX INFO: renamed from: b */
    public final String f10927b;

    /* JADX INFO: renamed from: c */
    public final long f10928c;

    /* JADX INFO: renamed from: d */
    public final long f10929d;

    /* JADX INFO: renamed from: e */
    public final long f10930e;

    /* JADX INFO: renamed from: f */
    public final long f10931f;

    /* JADX INFO: renamed from: g */
    public final long f10932g;

    /* JADX INFO: renamed from: h */
    public final Long f10933h;

    /* JADX INFO: renamed from: i */
    public final Long f10934i;

    /* JADX INFO: renamed from: j */
    public final Long f10935j;

    /* JADX INFO: renamed from: k */
    public final Boolean f10936k;

    public C4098l(String str, String str2, long j, long j2, long j3, long j4, long j5, Long l, Long l2, Long l3, Boolean bool) {
        C1460d.m583w(str);
        C1460d.m583w(str2);
        C1460d.m539l(j >= 0);
        C1460d.m539l(j2 >= 0);
        C1460d.m539l(j3 >= 0);
        C1460d.m539l(j5 >= 0);
        this.f10926a = str;
        this.f10927b = str2;
        this.f10928c = j;
        this.f10929d = j2;
        this.f10930e = j3;
        this.f10931f = j4;
        this.f10932g = j5;
        this.f10933h = l;
        this.f10934i = l2;
        this.f10935j = l3;
        this.f10936k = bool;
    }

    /* JADX INFO: renamed from: a */
    public final C4098l m5748a(long j) {
        return new C4098l(this.f10926a, this.f10927b, this.f10928c, this.f10929d, this.f10930e, j, this.f10932g, this.f10933h, this.f10934i, this.f10935j, this.f10936k);
    }

    /* JADX INFO: renamed from: b */
    public final C4098l m5749b(long j, long j2) {
        return new C4098l(this.f10926a, this.f10927b, this.f10928c, this.f10929d, this.f10930e, this.f10931f, j, Long.valueOf(j2), this.f10934i, this.f10935j, this.f10936k);
    }

    /* JADX INFO: renamed from: c */
    public final C4098l m5750c(Long l, Long l2, Boolean bool) {
        return new C4098l(this.f10926a, this.f10927b, this.f10928c, this.f10929d, this.f10930e, this.f10931f, this.f10932g, this.f10933h, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
    }

    public C4098l(String str, String str2, long j) {
        this(str, str2, 0L, 0L, 0L, j, 0L, null, null, null, null);
    }
}
