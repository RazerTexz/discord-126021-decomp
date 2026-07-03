package p007b.p225i.p414e.p418n.p420l;

import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.e.n.l.c */
/* JADX INFO: compiled from: ReedSolomonDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4975c {

    /* JADX INFO: renamed from: a */
    public final C4973a f13316a;

    public C4975c(C4973a c4973a) {
        this.f13316a = c4973a;
    }

    /* JADX INFO: renamed from: a */
    public void m6968a(int[] iArr, int i) throws ReedSolomonException {
        int[] iArr2;
        C4974b c4974b;
        C4974b c4974b2;
        int i2 = i;
        C4974b c4974b3 = new C4974b(this.f13316a, iArr);
        int[] iArr3 = new int[i2];
        boolean z2 = true;
        for (int i3 = 0; i3 < i2; i3++) {
            C4973a c4973a = this.f13316a;
            int iM6963b = c4974b3.m6963b(c4973a.f13307i[c4973a.f13313o + i3]);
            iArr3[(i2 - 1) - i3] = iM6963b;
            if (iM6963b != 0) {
                z2 = false;
            }
        }
        if (z2) {
            return;
        }
        C4974b c4974b4 = new C4974b(this.f13316a, iArr3);
        C4974b c4974bM6959a = this.f13316a.m6959a(i2, 1);
        if (c4974bM6959a.m6965d() >= c4974b4.m6965d()) {
            c4974bM6959a = c4974b4;
            c4974b4 = c4974bM6959a;
        }
        C4973a c4973a2 = this.f13316a;
        C4974b c4974b5 = c4973a2.f13309k;
        C4974b c4974b6 = c4974bM6959a;
        C4974b c4974bM6962a = c4974b4;
        C4974b c4974b7 = c4974b6;
        C4974b c4974b8 = c4973a2.f13310l;
        C4974b c4974b9 = c4974b5;
        while (c4974b7.m6965d() >= i2 / 2) {
            if (c4974b7.m6966e()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            C4974b c4974bM6962a2 = this.f13316a.f13309k;
            int iM6960b = this.f13316a.m6960b(c4974b7.m6964c(c4974b7.m6965d()));
            while (c4974bM6962a.m6965d() >= c4974b7.m6965d() && !c4974bM6962a.m6966e()) {
                int iM6965d = c4974bM6962a.m6965d() - c4974b7.m6965d();
                int iM6961c = this.f13316a.m6961c(c4974bM6962a.m6964c(c4974bM6962a.m6965d()), iM6960b);
                c4974bM6962a2 = c4974bM6962a2.m6962a(this.f13316a.m6959a(iM6965d, iM6961c));
                if (iM6965d < 0) {
                    throw new IllegalArgumentException();
                }
                if (iM6961c == 0) {
                    c4974b2 = c4974b7.f13314a.f13309k;
                } else {
                    int length = c4974b7.f13315b.length;
                    int[] iArr4 = new int[iM6965d + length];
                    for (int i4 = 0; i4 < length; i4++) {
                        iArr4[i4] = c4974b7.f13314a.m6961c(c4974b7.f13315b[i4], iM6961c);
                    }
                    c4974b2 = new C4974b(c4974b7.f13314a, iArr4);
                }
                c4974bM6962a = c4974bM6962a.m6962a(c4974b2);
            }
            if (!c4974bM6962a2.f13314a.equals(c4974b8.f13314a)) {
                throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
            }
            if (c4974bM6962a2.m6966e() || c4974b8.m6966e()) {
                c4974b = c4974bM6962a2.f13314a.f13309k;
            } else {
                int[] iArr5 = c4974bM6962a2.f13315b;
                int length2 = iArr5.length;
                int[] iArr6 = c4974b8.f13315b;
                int length3 = iArr6.length;
                int[] iArr7 = new int[(length2 + length3) - 1];
                for (int i5 = 0; i5 < length2; i5++) {
                    int i6 = iArr5[i5];
                    int i7 = 0;
                    while (i7 < length3) {
                        int i8 = i5 + i7;
                        iArr7[i8] = iArr7[i8] ^ c4974bM6962a2.f13314a.m6961c(i6, iArr6[i7]);
                        i7++;
                        iArr5 = iArr5;
                    }
                }
                c4974b = new C4974b(c4974bM6962a2.f13314a, iArr7);
            }
            C4974b c4974bM6962a3 = c4974b.m6962a(c4974b9);
            if (c4974bM6962a.m6965d() >= c4974b7.m6965d()) {
                throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
            }
            c4974b9 = c4974b8;
            c4974b8 = c4974bM6962a3;
            i2 = i;
            C4974b c4974b10 = c4974bM6962a;
            c4974bM6962a = c4974b7;
            c4974b7 = c4974b10;
        }
        int iM6964c = c4974b8.m6964c(0);
        if (iM6964c == 0) {
            throw new ReedSolomonException("sigmaTilde(0) was zero");
        }
        int iM6960b2 = this.f13316a.m6960b(iM6964c);
        C4974b[] c4974bArr = {c4974b8.m6967f(iM6960b2), c4974b7.m6967f(iM6960b2)};
        C4974b c4974b11 = c4974bArr[0];
        C4974b c4974b12 = c4974bArr[1];
        int iM6965d2 = c4974b11.m6965d();
        if (iM6965d2 == 1) {
            iArr2 = new int[]{c4974b11.m6964c(1)};
        } else {
            int[] iArr8 = new int[iM6965d2];
            int i9 = 0;
            for (int i10 = 1; i10 < this.f13316a.f13311m && i9 < iM6965d2; i10++) {
                if (c4974b11.m6963b(i10) == 0) {
                    iArr8[i9] = this.f13316a.m6960b(i10);
                    i9++;
                }
            }
            if (i9 != iM6965d2) {
                throw new ReedSolomonException("Error locator degree does not match number of roots");
            }
            iArr2 = iArr8;
        }
        int length4 = iArr2.length;
        int[] iArr9 = new int[length4];
        for (int i11 = 0; i11 < length4; i11++) {
            int iM6960b3 = this.f13316a.m6960b(iArr2[i11]);
            int iM6961c2 = 1;
            for (int i12 = 0; i12 < length4; i12++) {
                if (i11 != i12) {
                    int iM6961c3 = this.f13316a.m6961c(iArr2[i12], iM6960b3);
                    iM6961c2 = this.f13316a.m6961c(iM6961c2, (iM6961c3 & 1) == 0 ? iM6961c3 | 1 : iM6961c3 & (-2));
                }
            }
            iArr9[i11] = this.f13316a.m6961c(c4974b12.m6963b(iM6960b3), this.f13316a.m6960b(iM6961c2));
            C4973a c4973a3 = this.f13316a;
            if (c4973a3.f13313o != 0) {
                iArr9[i11] = c4973a3.m6961c(iArr9[i11], iM6960b3);
            }
        }
        for (int i13 = 0; i13 < iArr2.length; i13++) {
            int length5 = iArr.length - 1;
            C4973a c4973a4 = this.f13316a;
            int i14 = iArr2[i13];
            Objects.requireNonNull(c4973a4);
            if (i14 == 0) {
                throw new IllegalArgumentException();
            }
            int i15 = length5 - c4973a4.f13308j[i14];
            if (i15 < 0) {
                throw new ReedSolomonException("Bad error location");
            }
            iArr[i15] = iArr[i15] ^ iArr9[i13];
        }
    }
}
