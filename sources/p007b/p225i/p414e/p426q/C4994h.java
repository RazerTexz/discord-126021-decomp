package p007b.p225i.p414e.p426q;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Map;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.EnumC4946a;
import p007b.p225i.p414e.EnumC4949d;
import p007b.p225i.p414e.p418n.C4962a;

/* JADX INFO: renamed from: b.i.e.q.h */
/* JADX INFO: compiled from: ITFReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4994h extends AbstractC4997k {

    /* JADX INFO: renamed from: a */
    public static final int[] f13373a = {6, 8, 10, 12, 14};

    /* JADX INFO: renamed from: b */
    public static final int[] f13374b = {1, 1, 1, 1};

    /* JADX INFO: renamed from: c */
    public static final int[][] f13375c = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    /* JADX INFO: renamed from: d */
    public static final int[][] f13376d = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* JADX INFO: renamed from: e */
    public int f13377e = -1;

    /* JADX INFO: renamed from: g */
    public static int m6993g(int[] iArr) throws NotFoundException {
        int length = f13376d.length;
        float f = 0.38f;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            float fM6996d = AbstractC4997k.m6996d(iArr, f13376d[i2], 0.5f);
            if (fM6996d < f) {
                i = i2;
                f = fM6996d;
            } else if (fM6996d == f) {
                i = -1;
            }
        }
        if (i >= 0) {
            return i % 10;
        }
        throw NotFoundException.f21665l;
    }

    /* JADX INFO: renamed from: h */
    public static int[] m6994h(C4962a c4962a, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int i2 = c4962a.f13228k;
        int i3 = i;
        boolean z2 = false;
        int i4 = 0;
        while (i < i2) {
            if (c4962a.m6935b(i) != z2) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else {
                    if (AbstractC4997k.m6996d(iArr2, iArr, 0.5f) < 0.38f) {
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
        throw NotFoundException.f21665l;
    }

    @Override // p007b.p225i.p414e.p426q.AbstractC4997k
    /* JADX INFO: renamed from: b */
    public Result mo6983b(int i, C4962a c4962a, Map<EnumC4949d, ?> map) throws NotFoundException, FormatException {
        int[] iArrM6994h;
        int[] iArr;
        int length;
        int length2;
        int i2;
        int i3;
        boolean z2;
        int i4 = c4962a.f13228k;
        int iM6936f = c4962a.m6936f(0);
        if (iM6936f == i4) {
            throw NotFoundException.f21665l;
        }
        int[] iArrM6994h2 = m6994h(c4962a, iM6936f, f13374b);
        this.f13377e = (iArrM6994h2[1] - iArrM6994h2[0]) / 4;
        m6995i(c4962a, iArrM6994h2[0]);
        c4962a.m6939i();
        try {
            int i5 = c4962a.f13228k;
            int iM6936f2 = c4962a.m6936f(0);
            if (iM6936f2 == i5) {
                throw NotFoundException.f21665l;
            }
            try {
                iArrM6994h = m6994h(c4962a, iM6936f2, f13375c[0]);
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
                iArrM6994h = m6994h(c4962a, iM6936f2, f13375c[1]);
            }
            m6995i(c4962a, iArrM6994h[0]);
            int i7 = iArrM6994h[0];
            int i8 = c4962a.f13228k;
            iArrM6994h[0] = i8 - iArrM6994h[1];
            iArrM6994h[1] = i8 - i7;
            c4962a.m6939i();
            StringBuilder sb = new StringBuilder(20);
            int i9 = iArrM6994h2[1];
            int i10 = iArrM6994h[0];
            int[] iArr2 = new int[10];
            int[] iArr3 = new int[5];
            int[] iArr4 = new int[5];
            while (i9 < i10) {
                AbstractC4997k.m6997e(c4962a, i9, iArr2);
                for (int i11 = 0; i11 < 5; i11++) {
                    int i12 = i11 * 2;
                    iArr3[i11] = iArr2[i12];
                    iArr4[i11] = iArr2[i12 + 1];
                }
                sb.append((char) (m6993g(iArr3) + 48));
                sb.append((char) (m6993g(iArr4) + 48));
                for (int i13 = 0; i13 < 10; i13++) {
                    i9 += iArr2[i13];
                }
            }
            String string = sb.toString();
            iArr = map != null ? (int[]) map.get(EnumC4949d.ALLOWED_LENGTHS) : null;
            if (iArr == null) {
                iArr = f13373a;
            }
            length = string.length();
            length2 = iArr.length;
            i2 = 0;
            i3 = 0;
            if (!z2 && length > i3) {
                z2 = true;
            }
            if (!z2) {
                throw FormatException.m9260a();
            }
            float f = i;
            return new Result(string, null, new C4956k[]{new C4956k(iArrM6994h2[1], f), new C4956k(iArrM6994h[0], f)}, EnumC4946a.ITF);
        } catch (Throwable th) {
            c4962a.m6939i();
            throw th;
        }
    }

    /* JADX INFO: renamed from: i */
    public final void m6995i(C4962a c4962a, int i) throws NotFoundException {
        int i2 = this.f13377e * 10;
        if (i2 >= i) {
            i2 = i;
        }
        while (true) {
            i--;
            if (i2 <= 0 || i < 0 || c4962a.m6935b(i)) {
                break;
            } else {
                i2--;
            }
        }
        if (i2 != 0) {
            throw NotFoundException.f21665l;
        }
    }
}
