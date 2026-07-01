package h0.a.a;

import b.d.b.a.outline;

/* JADX INFO: renamed from: h0.a.a.p, reason: use source file name */
/* JADX INFO: compiled from: Label.java */
/* JADX INFO: loaded from: classes3.dex */
public class Label2 {
    public static final Label2 a = new Label2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public short f3714b;
    public short c;
    public int[] d;
    public int e;
    public int[] f;
    public short g;
    public short h;
    public short i;
    public short j;
    public Frame3 k;
    public Label2 l;
    public Edge2 m;
    public Label2 n;

    public final void a(int i, int i2, int i3) {
        if (this.f == null) {
            this.f = new int[6];
        }
        int[] iArr = this.f;
        int i4 = iArr[0];
        if (i4 + 2 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f = iArr2;
        }
        int[] iArr3 = this.f;
        int i5 = i4 + 1;
        iArr3[i5] = i;
        int i6 = i5 + 1;
        iArr3[i6] = i2 | i3;
        iArr3[0] = i6;
    }

    public final Label2 b() {
        Frame3 frame3 = this.k;
        return frame3 == null ? this : frame3.a;
    }

    public final void c(short s2) {
        this.n = a;
        Label2 label2D = this;
        while (label2D != a) {
            Label2 label2 = label2D.n;
            label2D.n = null;
            if (label2D.j == 0) {
                label2D.j = s2;
                label2D = label2D.d(label2);
            } else {
                label2D = label2;
            }
        }
    }

    public final Label2 d(Label2 label2) {
        Edge2 edge2 = this.m;
        while (edge2 != null) {
            if (!((this.f3714b & 16) != 0 && edge2 == this.m.c)) {
                Label2 label3 = edge2.f3709b;
                if (label3.n == null) {
                    label3.n = label2;
                    label2 = label3;
                }
            }
            edge2 = edge2.c;
        }
        return label2;
    }

    public final void e(ByteVector2 byteVector2, int i, boolean z2) {
        if ((this.f3714b & 4) != 0) {
            if (z2) {
                byteVector2.i(this.e - i);
                return;
            } else {
                byteVector2.j(this.e - i);
                return;
            }
        }
        if (z2) {
            a(i, 536870912, byteVector2.f3699b);
            byteVector2.i(-1);
        } else {
            a(i, 268435456, byteVector2.f3699b);
            byteVector2.j(-1);
        }
    }

    public final boolean f(byte[] bArr, int i) {
        this.f3714b = (short) (this.f3714b | 4);
        this.e = i;
        int[] iArr = this.f;
        boolean z2 = false;
        if (iArr == null) {
            return false;
        }
        for (int i2 = iArr[0]; i2 > 0; i2 -= 2) {
            int[] iArr2 = this.f;
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
        StringBuilder sbU = outline.U("L");
        sbU.append(System.identityHashCode(this));
        return sbU.toString();
    }
}
