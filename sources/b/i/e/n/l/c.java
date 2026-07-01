package b.i.e.n.l;

import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Objects;

/* JADX INFO: compiled from: ReedSolomonDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public final a a;

    public c(a aVar) {
        this.a = aVar;
    }

    public void a(int[] iArr, int i) throws ReedSolomonException {
        int[] iArr2;
        b bVar;
        b bVar2;
        int i2 = i;
        b bVar3 = new b(this.a, iArr);
        int[] iArr3 = new int[i2];
        boolean z2 = true;
        for (int i3 = 0; i3 < i2; i3++) {
            a aVar = this.a;
            int iB = bVar3.b(aVar.i[aVar.o + i3]);
            iArr3[(i2 - 1) - i3] = iB;
            if (iB != 0) {
                z2 = false;
            }
        }
        if (z2) {
            return;
        }
        b bVar4 = new b(this.a, iArr3);
        b bVarA = this.a.a(i2, 1);
        if (bVarA.d() >= bVar4.d()) {
            bVarA = bVar4;
            bVar4 = bVarA;
        }
        a aVar2 = this.a;
        b bVar5 = aVar2.k;
        b bVar6 = bVarA;
        b bVarA2 = bVar4;
        b bVar7 = bVar6;
        b bVar8 = aVar2.l;
        b bVar9 = bVar5;
        while (bVar7.d() >= i2 / 2) {
            if (bVar7.e()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            b bVarA3 = this.a.k;
            int iB2 = this.a.b(bVar7.c(bVar7.d()));
            while (bVarA2.d() >= bVar7.d() && !bVarA2.e()) {
                int iD = bVarA2.d() - bVar7.d();
                int iC = this.a.c(bVarA2.c(bVarA2.d()), iB2);
                bVarA3 = bVarA3.a(this.a.a(iD, iC));
                if (iD < 0) {
                    throw new IllegalArgumentException();
                }
                if (iC == 0) {
                    bVar2 = bVar7.a.k;
                } else {
                    int length = bVar7.f1842b.length;
                    int[] iArr4 = new int[iD + length];
                    for (int i4 = 0; i4 < length; i4++) {
                        iArr4[i4] = bVar7.a.c(bVar7.f1842b[i4], iC);
                    }
                    bVar2 = new b(bVar7.a, iArr4);
                }
                bVarA2 = bVarA2.a(bVar2);
            }
            if (!bVarA3.a.equals(bVar8.a)) {
                throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
            }
            if (bVarA3.e() || bVar8.e()) {
                bVar = bVarA3.a.k;
            } else {
                int[] iArr5 = bVarA3.f1842b;
                int length2 = iArr5.length;
                int[] iArr6 = bVar8.f1842b;
                int length3 = iArr6.length;
                int[] iArr7 = new int[(length2 + length3) - 1];
                for (int i5 = 0; i5 < length2; i5++) {
                    int i6 = iArr5[i5];
                    int i7 = 0;
                    while (i7 < length3) {
                        int i8 = i5 + i7;
                        iArr7[i8] = iArr7[i8] ^ bVarA3.a.c(i6, iArr6[i7]);
                        i7++;
                        iArr5 = iArr5;
                    }
                }
                bVar = new b(bVarA3.a, iArr7);
            }
            b bVarA4 = bVar.a(bVar9);
            if (bVarA2.d() >= bVar7.d()) {
                throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
            }
            bVar9 = bVar8;
            bVar8 = bVarA4;
            i2 = i;
            b bVar10 = bVarA2;
            bVarA2 = bVar7;
            bVar7 = bVar10;
        }
        int iC2 = bVar8.c(0);
        if (iC2 == 0) {
            throw new ReedSolomonException("sigmaTilde(0) was zero");
        }
        int iB3 = this.a.b(iC2);
        b[] bVarArr = {bVar8.f(iB3), bVar7.f(iB3)};
        b bVar11 = bVarArr[0];
        b bVar12 = bVarArr[1];
        int iD2 = bVar11.d();
        if (iD2 == 1) {
            iArr2 = new int[]{bVar11.c(1)};
        } else {
            int[] iArr8 = new int[iD2];
            int i9 = 0;
            for (int i10 = 1; i10 < this.a.m && i9 < iD2; i10++) {
                if (bVar11.b(i10) == 0) {
                    iArr8[i9] = this.a.b(i10);
                    i9++;
                }
            }
            if (i9 != iD2) {
                throw new ReedSolomonException("Error locator degree does not match number of roots");
            }
            iArr2 = iArr8;
        }
        int length4 = iArr2.length;
        int[] iArr9 = new int[length4];
        for (int i11 = 0; i11 < length4; i11++) {
            int iB4 = this.a.b(iArr2[i11]);
            int iC3 = 1;
            for (int i12 = 0; i12 < length4; i12++) {
                if (i11 != i12) {
                    int iC4 = this.a.c(iArr2[i12], iB4);
                    iC3 = this.a.c(iC3, (iC4 & 1) == 0 ? iC4 | 1 : iC4 & (-2));
                }
            }
            iArr9[i11] = this.a.c(bVar12.b(iB4), this.a.b(iC3));
            a aVar3 = this.a;
            if (aVar3.o != 0) {
                iArr9[i11] = aVar3.c(iArr9[i11], iB4);
            }
        }
        for (int i13 = 0; i13 < iArr2.length; i13++) {
            int length5 = iArr.length - 1;
            a aVar4 = this.a;
            int i14 = iArr2[i13];
            Objects.requireNonNull(aVar4);
            if (i14 == 0) {
                throw new IllegalArgumentException();
            }
            int i15 = length5 - aVar4.j[i14];
            if (i15 < 0) {
                throw new ReedSolomonException("Bad error location");
            }
            iArr[i15] = iArr[i15] ^ iArr9[i13];
        }
    }
}
