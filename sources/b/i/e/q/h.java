package b.i.e.q;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Map;

/* JADX INFO: compiled from: ITFReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends k {
    public static final int[] a = {6, 8, 10, 12, 14};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1857b = {1, 1, 1, 1};
    public static final int[][] c = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};
    public static final int[][] d = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    public int e = -1;

    public static int g(int[] iArr) throws NotFoundException {
        int length = d.length;
        float f = 0.38f;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            float fD = k.d(iArr, d[i2], 0.5f);
            if (fD < f) {
                i = i2;
                f = fD;
            } else if (fD == f) {
                i = -1;
            }
        }
        if (i >= 0) {
            return i % 10;
        }
        throw NotFoundException.l;
    }

    public static int[] h(b.i.e.n.a aVar, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int i2 = aVar.k;
        int i3 = i;
        boolean z2 = false;
        int i4 = 0;
        while (i < i2) {
            if (aVar.b(i) != z2) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else {
                    if (k.d(iArr2, iArr, 0.5f) < 0.38f) {
                        return new int[]{i3, i};
                    }
                    i3 += iArr2[0] + iArr2[1];
                    int i5 = i4 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i4] = 0;
                    i4 = i5;
                }
                iArr2[i4] = 1;
                z2 = !z2;
            }
            i++;
        }
        throw NotFoundException.l;
    }

    @Override // b.i.e.q.k
    public Result b(int i, b.i.e.n.a aVar, Map<b.i.e.d, ?> map) throws NotFoundException, FormatException {
        int[] iArrH;
        int[] iArr;
        int length;
        int length2;
        int i2;
        int i3;
        boolean z2;
        int i4 = aVar.k;
        int iF = aVar.f(0);
        if (iF == i4) {
            throw NotFoundException.l;
        }
        int[] iArrH2 = h(aVar, iF, f1857b);
        this.e = (iArrH2[1] - iArrH2[0]) / 4;
        i(aVar, iArrH2[0]);
        aVar.i();
        try {
            int i5 = aVar.k;
            int iF2 = aVar.f(0);
            if (iF2 == i5) {
                throw NotFoundException.l;
            }
            try {
                iArrH = h(aVar, iF2, c[0]);
                while (true) {
                    if (i2 >= length2) {
                        z2 = false;
                        break;
                    }
                    int i6 = iArr[i2];
                    if (length == i6) {
                        z2 = true;
                        break;
                    }
                    if (i6 > i3) {
                        i3 = i6;
                    }
                    i2++;
                }
            } catch (NotFoundException unused) {
                iArrH = h(aVar, iF2, c[1]);
            }
            i(aVar, iArrH[0]);
            int i7 = iArrH[0];
            int i8 = aVar.k;
            iArrH[0] = i8 - iArrH[1];
            iArrH[1] = i8 - i7;
            aVar.i();
            StringBuilder sb = new StringBuilder(20);
            int i9 = iArrH2[1];
            int i10 = iArrH[0];
            int[] iArr2 = new int[10];
            int[] iArr3 = new int[5];
            int[] iArr4 = new int[5];
            while (i9 < i10) {
                k.e(aVar, i9, iArr2);
                for (int i11 = 0; i11 < 5; i11++) {
                    int i12 = i11 * 2;
                    iArr3[i11] = iArr2[i12];
                    iArr4[i11] = iArr2[i12 + 1];
                }
                sb.append((char) (g(iArr3) + 48));
                sb.append((char) (g(iArr4) + 48));
                for (int i13 = 0; i13 < 10; i13++) {
                    i9 += iArr2[i13];
                }
            }
            String string = sb.toString();
            iArr = map != null ? (int[]) map.get(b.i.e.d.ALLOWED_LENGTHS) : null;
            if (iArr == null) {
                iArr = a;
            }
            length = string.length();
            length2 = iArr.length;
            i2 = 0;
            i3 = 0;
            if (!z2 && length > i3) {
                z2 = true;
            }
            if (!z2) {
                throw FormatException.a();
            }
            float f = i;
            return new Result(string, null, new b.i.e.k[]{new b.i.e.k(iArrH2[1], f), new b.i.e.k(iArrH[0], f)}, b.i.e.a.ITF);
        } catch (Throwable th) {
            aVar.i();
            throw th;
        }
    }

    public final void i(b.i.e.n.a aVar, int i) throws NotFoundException {
        int i2 = this.e * 10;
        if (i2 >= i) {
            i2 = i;
        }
        while (true) {
            i--;
            if (i2 <= 0 || i < 0 || aVar.b(i)) {
                break;
            } else {
                i2--;
            }
        }
        if (i2 != 0) {
            throw NotFoundException.l;
        }
    }
}
