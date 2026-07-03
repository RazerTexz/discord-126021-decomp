package p507d0.p510c0;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.c0.e */
/* JADX INFO: compiled from: XorWowRandom.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11218e extends AbstractC11216c implements Serializable {

    @Deprecated
    private static final long serialVersionUID = 0;
    private int addend;

    /* JADX INFO: renamed from: v */
    private int f22274v;

    /* JADX INFO: renamed from: w */
    private int f22275w;

    /* JADX INFO: renamed from: x */
    private int f22276x;

    /* JADX INFO: renamed from: y */
    private int f22277y;

    /* JADX INFO: renamed from: z */
    private int f22278z;

    /* JADX INFO: renamed from: d0.c0.e$a */
    /* JADX INFO: compiled from: XorWowRandom.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
    }

    public C11218e(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f22276x = i;
        this.f22277y = i2;
        this.f22278z = i3;
        this.f22275w = i4;
        this.f22274v = i5;
        this.addend = i6;
        int i7 = i | i2 | i3 | i4 | i5;
        if (!(i7 != 0)) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
        }
        for (int i8 = 0; i8 < 64; i8++) {
            nextInt();
        }
    }

    @Override // p507d0.p510c0.AbstractC11216c
    public int nextBits(int i) {
        return C11217d.takeUpperBits(nextInt(), i);
    }

    @Override // p507d0.p510c0.AbstractC11216c
    public int nextInt() {
        int i = this.f22276x;
        int i2 = i ^ (i >>> 2);
        this.f22276x = this.f22277y;
        this.f22277y = this.f22278z;
        this.f22278z = this.f22275w;
        int i3 = this.f22274v;
        this.f22275w = i3;
        int i4 = ((i2 ^ (i2 << 1)) ^ i3) ^ (i3 << 4);
        this.f22274v = i4;
        int i5 = this.addend + 362437;
        this.addend = i5;
        return i4 + i5;
    }

    public C11218e(int i, int i2) {
        this(i, i2, 0, 0, ~i, (i << 10) ^ (i2 >>> 4));
    }
}
