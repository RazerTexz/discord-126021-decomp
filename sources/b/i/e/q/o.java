package b.i.e.q;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.EnumMap;

/* JADX INFO: compiled from: UPCEANExtensionSupport.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static final int[] a = {1, 1, 2};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m f1860b = new m();
    public final n c = new n();

    public Result a(int i, b.i.e.n.a aVar, int i2) throws NotFoundException {
        EnumMap enumMap;
        int[] iArr = a;
        int[] iArrL = p.l(aVar, i2, false, iArr, new int[iArr.length]);
        try {
            return this.c.a(i, aVar, iArrL);
        } catch (ReaderException unused) {
            m mVar = this.f1860b;
            StringBuilder sb = mVar.f1858b;
            sb.setLength(0);
            int[] iArr2 = mVar.a;
            iArr2[0] = 0;
            iArr2[1] = 0;
            iArr2[2] = 0;
            iArr2[3] = 0;
            int i3 = aVar.k;
            int iG = iArrL[1];
            int i4 = 0;
            for (int i5 = 0; i5 < 2 && iG < i3; i5++) {
                int iH = p.h(aVar, iArr2, iG, p.d);
                sb.append((char) ((iH % 10) + 48));
                for (int i6 : iArr2) {
                    iG += i6;
                }
                if (iH >= 10) {
                    i4 |= 1 << (1 - i5);
                }
                if (i5 != 1) {
                    iG = aVar.g(aVar.f(iG));
                }
            }
            if (sb.length() != 2) {
                throw NotFoundException.l;
            }
            if (Integer.parseInt(sb.toString()) % 4 != i4) {
                throw NotFoundException.l;
            }
            String string = sb.toString();
            if (string.length() != 2) {
                enumMap = null;
            } else {
                enumMap = new EnumMap(b.i.e.j.class);
                enumMap.put(b.i.e.j.ISSUE_NUMBER, Integer.valueOf(string));
            }
            float f = i;
            Result result = new Result(string, null, new b.i.e.k[]{new b.i.e.k((iArrL[0] + iArrL[1]) / 2.0f, f), new b.i.e.k(iG, f)}, b.i.e.a.UPC_EAN_EXTENSION);
            if (enumMap != null) {
                result.a(enumMap);
            }
            return result;
        }
    }
}
