package p007b.p225i.p414e.p430r.p431d.p432k;

/* JADX INFO: renamed from: b.i.e.r.d.k.b */
/* JADX INFO: compiled from: ModulusGF.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5045b {

    /* JADX INFO: renamed from: a */
    public static final C5045b f13497a = new C5045b(929, 3);

    /* JADX INFO: renamed from: b */
    public final int[] f13498b;

    /* JADX INFO: renamed from: c */
    public final int[] f13499c;

    /* JADX INFO: renamed from: d */
    public final C5046c f13500d;

    /* JADX INFO: renamed from: e */
    public final C5046c f13501e;

    public C5045b(int i, int i2) {
        this.f13498b = new int[i];
        this.f13499c = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            this.f13498b[i4] = i3;
            i3 = (i3 * i2) % i;
        }
        for (int i5 = 0; i5 < i - 1; i5++) {
            this.f13499c[this.f13498b[i5]] = i5;
        }
        this.f13500d = new C5046c(this, new int[]{0});
        this.f13501e = new C5046c(this, new int[]{1});
    }

    /* JADX INFO: renamed from: a */
    public int m7066a(int i, int i2) {
        return (i + i2) % 929;
    }

    /* JADX INFO: renamed from: b */
    public C5046c m7067b(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f13500d;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new C5046c(this, iArr);
    }

    /* JADX INFO: renamed from: c */
    public int m7068c(int i) {
        if (i != 0) {
            return this.f13498b[(929 - this.f13499c[i]) - 1];
        }
        throw new ArithmeticException();
    }

    /* JADX INFO: renamed from: d */
    public int m7069d(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.f13498b;
        int[] iArr2 = this.f13499c;
        return iArr[(iArr2[i] + iArr2[i2]) % 928];
    }

    /* JADX INFO: renamed from: e */
    public int m7070e(int i, int i2) {
        return ((i + 929) - i2) % 929;
    }
}
