package p007b.p225i.p414e.p426q;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.EnumMap;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.EnumC4946a;
import p007b.p225i.p414e.EnumC4955j;
import p007b.p225i.p414e.p418n.C4962a;

/* JADX INFO: renamed from: b.i.e.q.o */
/* JADX INFO: compiled from: UPCEANExtensionSupport.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5001o {

    /* JADX INFO: renamed from: a */
    public static final int[] f13386a = {1, 1, 2};

    /* JADX INFO: renamed from: b */
    public final C4999m f13387b = new C4999m();

    /* JADX INFO: renamed from: c */
    public final C5000n f13388c = new C5000n();

    /* JADX INFO: renamed from: a */
    public Result m7003a(int i, C4962a c4962a, int i2) throws NotFoundException {
        EnumMap enumMap;
        int[] iArr = f13386a;
        int[] iArrM7005l = AbstractC5002p.m7005l(c4962a, i2, false, iArr, new int[iArr.length]);
        try {
            return this.f13388c.m7002a(i, c4962a, iArrM7005l);
        } catch (ReaderException unused) {
            C4999m c4999m = this.f13387b;
            StringBuilder sb = c4999m.f13382b;
            sb.setLength(0);
            int[] iArr2 = c4999m.f13381a;
            iArr2[0] = 0;
            iArr2[1] = 0;
            iArr2[2] = 0;
            iArr2[3] = 0;
            int i3 = c4962a.f13228k;
            int iM6937g = iArrM7005l[1];
            int i4 = 0;
            for (int i5 = 0; i5 < 2 && iM6937g < i3; i5++) {
                int iM7004h = AbstractC5002p.m7004h(c4962a, iArr2, iM6937g, AbstractC5002p.f13392d);
                sb.append((char) ((iM7004h % 10) + 48));
                for (int i6 : iArr2) {
                    iM6937g += i6;
                }
                if (iM7004h >= 10) {
                    i4 |= 1 << (1 - i5);
                }
                if (i5 != 1) {
                    iM6937g = c4962a.m6937g(c4962a.m6936f(iM6937g));
                }
            }
            if (sb.length() != 2) {
                throw NotFoundException.f21665l;
            }
            if (Integer.parseInt(sb.toString()) % 4 != i4) {
                throw NotFoundException.f21665l;
            }
            String string = sb.toString();
            if (string.length() != 2) {
                enumMap = null;
            } else {
                enumMap = new EnumMap(EnumC4955j.class);
                enumMap.put(EnumC4955j.ISSUE_NUMBER, Integer.valueOf(string));
            }
            float f = i;
            Result result = new Result(string, null, new C4956k[]{new C4956k((iArrM7005l[0] + iArrM7005l[1]) / 2.0f, f), new C4956k(iM6937g, f)}, EnumC4946a.UPC_EAN_EXTENSION);
            if (enumMap != null) {
                result.m9261a(enumMap);
            }
            return result;
        }
    }
}
