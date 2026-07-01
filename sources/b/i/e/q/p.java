package b.i.e.q;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: UPCEANReader.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p extends k {
    public static final int[] a = {1, 1, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1861b = {1, 1, 1, 1, 1};
    public static final int[][] c;
    public static final int[][] d;
    public final StringBuilder e = new StringBuilder(20);
    public final o f = new o();
    public final g g = new g();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        c = iArr;
        int[][] iArr2 = new int[20][];
        d = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr3 = c[i - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i2 = 0; i2 < iArr3.length; i2++) {
                iArr4[i2] = iArr3[(iArr3.length - i2) - 1];
            }
            d[i] = iArr4;
        }
    }

    public static int h(b.i.e.n.a aVar, int[] iArr, int i, int[][] iArr2) throws NotFoundException {
        k.e(aVar, i, iArr);
        int length = iArr2.length;
        float f = 0.48f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float fD = k.d(iArr, iArr2[i3], 0.7f);
            if (fD < f) {
                i2 = i3;
                f = fD;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.l;
    }

    public static int[] l(b.i.e.n.a aVar, int i, boolean z2, int[] iArr, int[] iArr2) throws NotFoundException {
        int i2 = aVar.k;
        int iG = z2 ? aVar.g(i) : aVar.f(i);
        int length = iArr.length;
        boolean z3 = z2;
        int i3 = 0;
        int i4 = iG;
        while (iG < i2) {
            if (aVar.b(iG) != z3) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else {
                    if (k.d(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i4, iG};
                    }
                    i4 += iArr2[0] + iArr2[1];
                    int i5 = i3 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i3] = 0;
                    i3 = i5;
                }
                iArr2[i3] = 1;
                z3 = !z3;
            }
            iG++;
        }
        throw NotFoundException.l;
    }

    public static int[] m(b.i.e.n.a aVar) throws NotFoundException {
        int[] iArr = new int[a.length];
        int[] iArrL = null;
        boolean zH = false;
        int i = 0;
        while (!zH) {
            int[] iArr2 = a;
            Arrays.fill(iArr, 0, iArr2.length, 0);
            iArrL = l(aVar, i, false, iArr2, iArr);
            int i2 = iArrL[0];
            int i3 = iArrL[1];
            int i4 = i2 - (i3 - i2);
            if (i4 >= 0) {
                zH = aVar.h(i4, i2, false);
            }
            i = i3;
        }
        return iArrL;
    }

    @Override // b.i.e.q.k
    public Result b(int i, b.i.e.n.a aVar, Map<b.i.e.d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return k(i, aVar, m(aVar), map);
    }

    public boolean g(String str) throws FormatException {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = length - 1;
        int iDigit = Character.digit(str.charAt(i), 10);
        CharSequence charSequenceSubSequence = str.subSequence(0, i);
        int length2 = charSequenceSubSequence.length();
        int i2 = 0;
        for (int i3 = length2 - 1; i3 >= 0; i3 -= 2) {
            int iCharAt = charSequenceSubSequence.charAt(i3) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw FormatException.a();
            }
            i2 += iCharAt;
        }
        int i4 = i2 * 3;
        while (true) {
            length2 -= 2;
            if (length2 < 0) {
                return (1000 - i4) % 10 == iDigit;
            }
            int iCharAt2 = charSequenceSubSequence.charAt(length2) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw FormatException.a();
            }
            i4 += iCharAt2;
        }
    }

    public int[] i(b.i.e.n.a aVar, int i) throws NotFoundException {
        int[] iArr = a;
        return l(aVar, i, false, iArr, new int[iArr.length]);
    }

    public abstract int j(b.i.e.n.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException;

    public Result k(int i, b.i.e.n.a aVar, int[] iArr, Map<b.i.e.d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int length;
        boolean z2;
        String str = null;
        b.i.e.l lVar = map == null ? null : (b.i.e.l) map.get(b.i.e.d.NEED_RESULT_POINT_CALLBACK);
        if (lVar != null) {
            lVar.a(new b.i.e.k((iArr[0] + iArr[1]) / 2.0f, i));
        }
        StringBuilder sb = this.e;
        sb.setLength(0);
        int iJ = j(aVar, iArr, sb);
        if (lVar != null) {
            lVar.a(new b.i.e.k(iJ, i));
        }
        int[] iArrI = i(aVar, iJ);
        if (lVar != null) {
            lVar.a(new b.i.e.k((iArrI[0] + iArrI[1]) / 2.0f, i));
        }
        int i2 = iArrI[1];
        int i3 = (i2 - iArrI[0]) + i2;
        if (i3 >= aVar.k || !aVar.h(i2, i3, false)) {
            throw NotFoundException.l;
        }
        String string = sb.toString();
        if (string.length() < 8) {
            throw FormatException.a();
        }
        if (!g(string)) {
            throw ChecksumException.a();
        }
        float f = (iArr[1] + iArr[0]) / 2.0f;
        float f2 = (iArrI[1] + iArrI[0]) / 2.0f;
        b.i.e.a aVarN = n();
        float f3 = i;
        Result result = new Result(string, null, new b.i.e.k[]{new b.i.e.k(f, f3), new b.i.e.k(f2, f3)}, aVarN);
        try {
            Result resultA = this.f.a(i, aVar, iArrI[1]);
            result.b(b.i.e.j.UPC_EAN_EXTENSION, resultA.a);
            result.a(resultA.e);
            b.i.e.k[] kVarArr = resultA.c;
            b.i.e.k[] kVarArr2 = result.c;
            if (kVarArr2 == null) {
                result.c = kVarArr;
            } else if (kVarArr != null && kVarArr.length > 0) {
                b.i.e.k[] kVarArr3 = new b.i.e.k[kVarArr2.length + kVarArr.length];
                System.arraycopy(kVarArr2, 0, kVarArr3, 0, kVarArr2.length);
                System.arraycopy(kVarArr, 0, kVarArr3, kVarArr2.length, kVarArr.length);
                result.c = kVarArr3;
            }
            length = resultA.a.length();
        } catch (ReaderException unused) {
            length = 0;
        }
        int[] iArr2 = map == null ? null : (int[]) map.get(b.i.e.d.ALLOWED_EAN_EXTENSIONS);
        if (iArr2 != null) {
            int length2 = iArr2.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length2) {
                    z2 = false;
                    break;
                }
                if (length == iArr2[i4]) {
                    z2 = true;
                    break;
                }
                i4++;
            }
            if (!z2) {
                throw NotFoundException.l;
            }
        }
        if (aVarN == b.i.e.a.EAN_13 || aVarN == b.i.e.a.UPC_A) {
            g gVar = this.g;
            gVar.b();
            int i5 = Integer.parseInt(string.substring(0, 3));
            int size = gVar.a.size();
            for (int i6 = 0; i6 < size; i6++) {
                int[] iArr3 = gVar.a.get(i6);
                int i7 = iArr3[0];
                if (i5 < i7) {
                    break;
                }
                if (iArr3.length != 1) {
                    i7 = iArr3[1];
                }
                if (i5 <= i7) {
                    str = gVar.f1856b.get(i6);
                    break;
                }
            }
            if (str != null) {
                result.b(b.i.e.j.POSSIBLE_COUNTRY, str);
            }
        }
        return result;
    }

    public abstract b.i.e.a n();
}
