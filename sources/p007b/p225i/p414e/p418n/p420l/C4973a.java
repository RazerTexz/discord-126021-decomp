package p007b.p225i.p414e.p418n.p420l;

import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.e.n.l.a */
/* JADX INFO: compiled from: GenericGF.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4973a {

    /* JADX INFO: renamed from: a */
    public static final C4973a f13299a = new C4973a(4201, 4096, 1);

    /* JADX INFO: renamed from: b */
    public static final C4973a f13300b = new C4973a(1033, 1024, 1);

    /* JADX INFO: renamed from: c */
    public static final C4973a f13301c;

    /* JADX INFO: renamed from: d */
    public static final C4973a f13302d;

    /* JADX INFO: renamed from: e */
    public static final C4973a f13303e;

    /* JADX INFO: renamed from: f */
    public static final C4973a f13304f;

    /* JADX INFO: renamed from: g */
    public static final C4973a f13305g;

    /* JADX INFO: renamed from: h */
    public static final C4973a f13306h;

    /* JADX INFO: renamed from: i */
    public final int[] f13307i;

    /* JADX INFO: renamed from: j */
    public final int[] f13308j;

    /* JADX INFO: renamed from: k */
    public final C4974b f13309k;

    /* JADX INFO: renamed from: l */
    public final C4974b f13310l;

    /* JADX INFO: renamed from: m */
    public final int f13311m;

    /* JADX INFO: renamed from: n */
    public final int f13312n;

    /* JADX INFO: renamed from: o */
    public final int f13313o;

    static {
        C4973a c4973a = new C4973a(67, 64, 1);
        f13301c = c4973a;
        f13302d = new C4973a(19, 16, 1);
        f13303e = new C4973a(285, 256, 0);
        C4973a c4973a2 = new C4973a(301, 256, 1);
        f13304f = c4973a2;
        f13305g = c4973a2;
        f13306h = c4973a;
    }

    public C4973a(int i, int i2, int i3) {
        this.f13312n = i;
        this.f13311m = i2;
        this.f13313o = i3;
        this.f13307i = new int[i2];
        this.f13308j = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.f13307i[i5] = i4;
            i4 <<= 1;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.f13308j[this.f13307i[i6]] = i6;
        }
        this.f13309k = new C4974b(this, new int[]{0});
        this.f13310l = new C4974b(this, new int[]{1});
    }

    /* JADX INFO: renamed from: a */
    public C4974b m6959a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f13309k;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new C4974b(this, iArr);
    }

    /* JADX INFO: renamed from: b */
    public int m6960b(int i) {
        if (i != 0) {
            return this.f13307i[(this.f13311m - this.f13308j[i]) - 1];
        }
        throw new ArithmeticException();
    }

    /* JADX INFO: renamed from: c */
    public int m6961c(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.f13307i;
        int[] iArr2 = this.f13308j;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.f13311m - 1)];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GF(0x");
        sb.append(Integer.toHexString(this.f13312n));
        sb.append(',');
        return C1643a.m813A(sb, this.f13311m, ')');
    }
}
