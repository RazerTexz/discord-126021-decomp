package b.i.e.n.l;

/* JADX INFO: compiled from: GenericGF.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final a a = new a(4201, 4096, 1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1841b = new a(1033, 1024, 1);
    public static final a c;
    public static final a d;
    public static final a e;
    public static final a f;
    public static final a g;
    public static final a h;
    public final int[] i;
    public final int[] j;
    public final b k;
    public final b l;
    public final int m;
    public final int n;
    public final int o;

    static {
        a aVar = new a(67, 64, 1);
        c = aVar;
        d = new a(19, 16, 1);
        e = new a(285, 256, 0);
        a aVar2 = new a(301, 256, 1);
        f = aVar2;
        g = aVar2;
        h = aVar;
    }

    public a(int i, int i2, int i3) {
        this.n = i;
        this.m = i2;
        this.o = i3;
        this.i = new int[i2];
        this.j = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.i[i5] = i4;
            i4 <<= 1;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.j[this.i[i6]] = i6;
        }
        this.k = new b(this, new int[]{0});
        this.l = new b(this, new int[]{1});
    }

    public b a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.k;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new b(this, iArr);
    }

    public int b(int i) {
        if (i != 0) {
            return this.i[(this.m - this.j[i]) - 1];
        }
        throw new ArithmeticException();
    }

    public int c(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.i;
        int[] iArr2 = this.j;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.m - 1)];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GF(0x");
        sb.append(Integer.toHexString(this.n));
        sb.append(',');
        return b.d.b.a.a.A(sb, this.m, ')');
    }
}
