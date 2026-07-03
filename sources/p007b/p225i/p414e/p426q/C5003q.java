package p007b.p225i.p414e.p426q;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import p007b.p225i.p414e.EnumC4946a;
import p007b.p225i.p414e.p418n.C4962a;

/* JADX INFO: renamed from: b.i.e.q.q */
/* JADX INFO: compiled from: UPCEReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5003q extends AbstractC5002p {

    /* JADX INFO: renamed from: h */
    public static final int[] f13396h = {1, 1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: i */
    public static final int[][] f13397i = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    /* JADX INFO: renamed from: j */
    public final int[] f13398j = new int[4];

    @Override // p007b.p225i.p414e.p426q.AbstractC5002p
    /* JADX INFO: renamed from: g */
    public boolean mo7007g(String str) throws FormatException {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c = cArr[5];
        switch (c) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c);
                break;
        }
        if (str.length() >= 8) {
            sb.append(str.charAt(7));
        }
        return super.mo7007g(sb.toString());
    }

    @Override // p007b.p225i.p414e.p426q.AbstractC5002p
    /* JADX INFO: renamed from: i */
    public int[] mo7008i(C4962a c4962a, int i) throws NotFoundException {
        int[] iArr = f13396h;
        return AbstractC5002p.m7005l(c4962a, i, true, iArr, new int[iArr.length]);
    }

    @Override // p007b.p225i.p414e.p426q.AbstractC5002p
    /* JADX INFO: renamed from: j */
    public int mo6989j(C4962a c4962a, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f13398j;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i = c4962a.f13228k;
        int i2 = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 6 && i2 < i; i4++) {
            int iM7004h = AbstractC5002p.m7004h(c4962a, iArr2, i2, AbstractC5002p.f13392d);
            sb.append((char) ((iM7004h % 10) + 48));
            for (int i5 : iArr2) {
                i2 += i5;
            }
            if (iM7004h >= 10) {
                i3 |= 1 << (5 - i4);
            }
        }
        for (int i6 = 0; i6 <= 1; i6++) {
            for (int i7 = 0; i7 < 10; i7++) {
                if (i3 == f13397i[i6][i7]) {
                    sb.insert(0, (char) (i6 + 48));
                    sb.append((char) (i7 + 48));
                    return i2;
                }
            }
        }
        throw NotFoundException.f21665l;
    }

    @Override // p007b.p225i.p414e.p426q.AbstractC5002p
    /* JADX INFO: renamed from: n */
    public EnumC4946a mo6990n() {
        return EnumC4946a.UPC_E;
    }
}
