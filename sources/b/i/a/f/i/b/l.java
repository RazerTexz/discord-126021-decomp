package b.i.a.f.i.b;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1548b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final Long h;
    public final Long i;
    public final Long j;
    public final Boolean k;

    public l(String str, String str2, long j, long j2, long j3, long j4, long j5, Long l, Long l2, Long l3, Boolean bool) {
        b.c.a.a0.d.w(str);
        b.c.a.a0.d.w(str2);
        b.c.a.a0.d.l(j >= 0);
        b.c.a.a0.d.l(j2 >= 0);
        b.c.a.a0.d.l(j3 >= 0);
        b.c.a.a0.d.l(j5 >= 0);
        this.a = str;
        this.f1548b = str2;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = j4;
        this.g = j5;
        this.h = l;
        this.i = l2;
        this.j = l3;
        this.k = bool;
    }

    public final l a(long j) {
        return new l(this.a, this.f1548b, this.c, this.d, this.e, j, this.g, this.h, this.i, this.j, this.k);
    }

    public final l b(long j, long j2) {
        return new l(this.a, this.f1548b, this.c, this.d, this.e, this.f, j, Long.valueOf(j2), this.i, this.j, this.k);
    }

    public final l c(Long l, Long l2, Boolean bool) {
        return new l(this.a, this.f1548b, this.c, this.d, this.e, this.f, this.g, this.h, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
    }

    public l(String str, String str2, long j) {
        this(str, str2, 0L, 0L, 0L, j, 0L, null, null, null, null);
    }
}
