package p617h0.p618a.p619a;

import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: h0.a.a.p */
/* JADX INFO: compiled from: Label.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12427p {

    /* JADX INFO: renamed from: a */
    public static final C12427p f26248a = new C12427p();

    /* JADX INFO: renamed from: b */
    public short f26249b;

    /* JADX INFO: renamed from: c */
    public short f26250c;

    /* JADX INFO: renamed from: d */
    public int[] f26251d;

    /* JADX INFO: renamed from: e */
    public int f26252e;

    /* JADX INFO: renamed from: f */
    public int[] f26253f;

    /* JADX INFO: renamed from: g */
    public short f26254g;

    /* JADX INFO: renamed from: h */
    public short f26255h;

    /* JADX INFO: renamed from: i */
    public short f26256i;

    /* JADX INFO: renamed from: j */
    public short f26257j;

    /* JADX INFO: renamed from: k */
    public C12424m f26258k;

    /* JADX INFO: renamed from: l */
    public C12427p f26259l;

    /* JADX INFO: renamed from: m */
    public C12421j f26260m;

    /* JADX INFO: renamed from: n */
    public C12427p f26261n;

    /* JADX INFO: renamed from: a */
    public final void m10587a(int i, int i2, int i3) {
        if (this.f26253f == null) {
            this.f26253f = new int[6];
        }
        int[] iArr = this.f26253f;
        int i4 = iArr[0];
        if (i4 + 2 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f26253f = iArr2;
        }
        int[] iArr3 = this.f26253f;
        int i5 = i4 + 1;
        iArr3[i5] = i;
        int i6 = i5 + 1;
        iArr3[i6] = i2 | i3;
        iArr3[0] = i6;
    }

    /* JADX INFO: renamed from: b */
    public final C12427p m10588b() {
        C12424m c12424m = this.f26258k;
        return c12424m == null ? this : c12424m.f26228a;
    }

    /* JADX INFO: renamed from: c */
    public final void m10589c(short s2) {
        this.f26261n = f26248a;
        C12427p c12427pM10590d = this;
        while (c12427pM10590d != f26248a) {
            C12427p c12427p = c12427pM10590d.f26261n;
            c12427pM10590d.f26261n = null;
            if (c12427pM10590d.f26257j == 0) {
                c12427pM10590d.f26257j = s2;
                c12427pM10590d = c12427pM10590d.m10590d(c12427p);
            } else {
                c12427pM10590d = c12427p;
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final C12427p m10590d(C12427p c12427p) {
        C12421j c12421j = this.f26260m;
        while (c12421j != null) {
            if (!((this.f26249b & 16) != 0 && c12421j == this.f26260m.f26215c)) {
                C12427p c12427p2 = c12421j.f26214b;
                if (c12427p2.f26261n == null) {
                    c12427p2.f26261n = c12427p;
                    c12427p = c12427p2;
                }
            }
            c12421j = c12421j.f26215c;
        }
        return c12427p;
    }

    /* JADX INFO: renamed from: e */
    public final void m10591e(C12414c c12414c, int i, boolean z2) {
        if ((this.f26249b & 4) != 0) {
            if (z2) {
                c12414c.m10537i(this.f26252e - i);
                return;
            } else {
                c12414c.m10538j(this.f26252e - i);
                return;
            }
        }
        if (z2) {
            m10587a(i, 536870912, c12414c.f26154b);
            c12414c.m10537i(-1);
        } else {
            m10587a(i, 268435456, c12414c.f26154b);
            c12414c.m10538j(-1);
        }
    }

    /* JADX INFO: renamed from: f */
    public final boolean m10592f(byte[] bArr, int i) {
        this.f26249b = (short) (this.f26249b | 4);
        this.f26252e = i;
        int[] iArr = this.f26253f;
        boolean z2 = false;
        if (iArr == null) {
            return false;
        }
        for (int i2 = iArr[0]; i2 > 0; i2 -= 2) {
            int[] iArr2 = this.f26253f;
            int i3 = iArr2[i2 - 1];
            int i4 = iArr2[i2];
            int i5 = i - i3;
            int i6 = 268435455 & i4;
            if ((i4 & (-268435456)) == 268435456) {
                if (i5 < -32768 || i5 > 32767) {
                    int i7 = bArr[i3] & 255;
                    if (i7 < 198) {
                        bArr[i3] = (byte) (i7 + 49);
                    } else {
                        bArr[i3] = (byte) (i7 + 20);
                    }
                    z2 = true;
                }
                bArr[i6] = (byte) (i5 >>> 8);
                bArr[i6 + 1] = (byte) i5;
            } else {
                int i8 = i6 + 1;
                bArr[i6] = (byte) (i5 >>> 24);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (i5 >>> 16);
                bArr[i9] = (byte) (i5 >>> 8);
                bArr[i9 + 1] = (byte) i5;
            }
        }
        return z2;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("L");
        sbM833U.append(System.identityHashCode(this));
        return sbM833U.toString();
    }
}
