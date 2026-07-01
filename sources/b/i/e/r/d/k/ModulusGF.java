package b.i.e.r.d.k;

/* JADX INFO: renamed from: b.i.e.r.d.k.b, reason: use source file name */
/* JADX INFO: compiled from: ModulusGF.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ModulusGF {
    public static final ModulusGF a = new ModulusGF(929, 3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f1882b;
    public final int[] c;
    public final ModulusPoly d;
    public final ModulusPoly e;

    public ModulusGF(int i, int i2) {
        this.f1882b = new int[i];
        this.c = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            this.f1882b[i4] = i3;
            i3 = (i3 * i2) % i;
        }
        for (int i5 = 0; i5 < i - 1; i5++) {
            this.c[this.f1882b[i5]] = i5;
        }
        this.d = new ModulusPoly(this, new int[]{0});
        this.e = new ModulusPoly(this, new int[]{1});
    }

    public int a(int i, int i2) {
        return (i + i2) % 929;
    }

    public ModulusPoly b(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.d;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new ModulusPoly(this, iArr);
    }

    public int c(int i) {
        if (i != 0) {
            return this.f1882b[(929 - this.c[i]) - 1];
        }
        throw new ArithmeticException();
    }

    public int d(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.f1882b;
        int[] iArr2 = this.c;
        return iArr[(iArr2[i] + iArr2[i2]) % 928];
    }

    public int e(int i, int i2) {
        return ((i + 929) - i2) % 929;
    }
}
