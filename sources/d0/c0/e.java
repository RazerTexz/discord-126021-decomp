package d0.c0;

import java.io.Serializable;

/* JADX INFO: compiled from: XorWowRandom.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends c implements Serializable {

    @Deprecated
    private static final long serialVersionUID = 0;
    private int addend;
    private int v;
    private int w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f3187x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f3188y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f3189z;

    static {
        new e$a(null);
    }

    public e(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f3187x = i;
        this.f3188y = i2;
        this.f3189z = i3;
        this.w = i4;
        this.v = i5;
        this.addend = i6;
        int i7 = i | i2 | i3 | i4 | i5;
        if (!(i7 != 0)) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
        }
        for (int i8 = 0; i8 < 64; i8++) {
            nextInt();
        }
    }

    @Override // d0.c0.c
    public int nextBits(int i) {
        return d.takeUpperBits(nextInt(), i);
    }

    @Override // d0.c0.c
    public int nextInt() {
        int i = this.f3187x;
        int i2 = i ^ (i >>> 2);
        this.f3187x = this.f3188y;
        this.f3188y = this.f3189z;
        this.f3189z = this.w;
        int i3 = this.v;
        this.w = i3;
        int i4 = ((i2 ^ (i2 << 1)) ^ i3) ^ (i3 << 4);
        this.v = i4;
        int i5 = this.addend + 362437;
        this.addend = i5;
        return i4 + i5;
    }

    public e(int i, int i2) {
        this(i, i2, 0, 0, ~i, (i << 10) ^ (i2 >>> 4));
    }
}
