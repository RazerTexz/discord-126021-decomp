package b.i.e.n.l;

import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.e.n.l.c, reason: use source file name */
/* JADX INFO: compiled from: ReedSolomonDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ReedSolomonDecoder {
    public final GenericGF a;

    public ReedSolomonDecoder(GenericGF genericGF) {
        this.a = genericGF;
    }

    public void a(int[] iArr, int i) throws ReedSolomonException {
        int[] iArr2;
        GenericGFPoly genericGFPoly;
        GenericGFPoly genericGFPoly2;
        int i2 = i;
        GenericGFPoly genericGFPoly3 = new GenericGFPoly(this.a, iArr);
        int[] iArr3 = new int[i2];
        boolean z2 = true;
        for (int i3 = 0; i3 < i2; i3++) {
            GenericGF genericGF = this.a;
            int iB = genericGFPoly3.b(genericGF.i[genericGF.o + i3]);
            iArr3[(i2 - 1) - i3] = iB;
            if (iB != 0) {
                z2 = false;
            }
        }
        if (z2) {
            return;
        }
        GenericGFPoly genericGFPoly4 = new GenericGFPoly(this.a, iArr3);
        GenericGFPoly genericGFPolyA = this.a.a(i2, 1);
        if (genericGFPolyA.d() >= genericGFPoly4.d()) {
            genericGFPolyA = genericGFPoly4;
            genericGFPoly4 = genericGFPolyA;
        }
        GenericGF genericGF2 = this.a;
        GenericGFPoly genericGFPoly5 = genericGF2.k;
        GenericGFPoly genericGFPoly6 = genericGFPolyA;
        GenericGFPoly genericGFPolyA2 = genericGFPoly4;
        GenericGFPoly genericGFPoly7 = genericGFPoly6;
        GenericGFPoly genericGFPoly8 = genericGF2.l;
        GenericGFPoly genericGFPoly9 = genericGFPoly5;
        while (genericGFPoly7.d() >= i2 / 2) {
            if (genericGFPoly7.e()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            GenericGFPoly genericGFPolyA3 = this.a.k;
            int iB2 = this.a.b(genericGFPoly7.c(genericGFPoly7.d()));
            while (genericGFPolyA2.d() >= genericGFPoly7.d() && !genericGFPolyA2.e()) {
                int iD = genericGFPolyA2.d() - genericGFPoly7.d();
                int iC = this.a.c(genericGFPolyA2.c(genericGFPolyA2.d()), iB2);
                genericGFPolyA3 = genericGFPolyA3.a(this.a.a(iD, iC));
                if (iD < 0) {
                    throw new IllegalArgumentException();
                }
                if (iC == 0) {
                    genericGFPoly2 = genericGFPoly7.a.k;
                } else {
                    int length = genericGFPoly7.f1842b.length;
                    int[] iArr4 = new int[iD + length];
                    for (int i4 = 0; i4 < length; i4++) {
                        iArr4[i4] = genericGFPoly7.a.c(genericGFPoly7.f1842b[i4], iC);
                    }
                    genericGFPoly2 = new GenericGFPoly(genericGFPoly7.a, iArr4);
                }
                genericGFPolyA2 = genericGFPolyA2.a(genericGFPoly2);
            }
            if (!genericGFPolyA3.a.equals(genericGFPoly8.a)) {
                throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
            }
            if (genericGFPolyA3.e() || genericGFPoly8.e()) {
                genericGFPoly = genericGFPolyA3.a.k;
            } else {
                int[] iArr5 = genericGFPolyA3.f1842b;
                int length2 = iArr5.length;
                int[] iArr6 = genericGFPoly8.f1842b;
                int length3 = iArr6.length;
                int[] iArr7 = new int[(length2 + length3) - 1];
                for (int i5 = 0; i5 < length2; i5++) {
                    int i6 = iArr5[i5];
                    int i7 = 0;
                    while (i7 < length3) {
                        int i8 = i5 + i7;
                        iArr7[i8] = iArr7[i8] ^ genericGFPolyA3.a.c(i6, iArr6[i7]);
                        i7++;
                        iArr5 = iArr5;
                    }
                }
                genericGFPoly = new GenericGFPoly(genericGFPolyA3.a, iArr7);
            }
            GenericGFPoly genericGFPolyA4 = genericGFPoly.a(genericGFPoly9);
            if (genericGFPolyA2.d() >= genericGFPoly7.d()) {
                throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
            }
            genericGFPoly9 = genericGFPoly8;
            genericGFPoly8 = genericGFPolyA4;
            i2 = i;
            GenericGFPoly genericGFPoly10 = genericGFPolyA2;
            genericGFPolyA2 = genericGFPoly7;
            genericGFPoly7 = genericGFPoly10;
        }
        int iC2 = genericGFPoly8.c(0);
        if (iC2 == 0) {
            throw new ReedSolomonException("sigmaTilde(0) was zero");
        }
        int iB3 = this.a.b(iC2);
        GenericGFPoly[] genericGFPolyArr = {genericGFPoly8.f(iB3), genericGFPoly7.f(iB3)};
        GenericGFPoly genericGFPoly11 = genericGFPolyArr[0];
        GenericGFPoly genericGFPoly12 = genericGFPolyArr[1];
        int iD2 = genericGFPoly11.d();
        if (iD2 == 1) {
            iArr2 = new int[]{genericGFPoly11.c(1)};
        } else {
            int[] iArr8 = new int[iD2];
            int i9 = 0;
            for (int i10 = 1; i10 < this.a.m && i9 < iD2; i10++) {
                if (genericGFPoly11.b(i10) == 0) {
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
            iArr9[i11] = this.a.c(genericGFPoly12.b(iB4), this.a.b(iC3));
            GenericGF genericGF3 = this.a;
            if (genericGF3.o != 0) {
                iArr9[i11] = genericGF3.c(iArr9[i11], iB4);
            }
        }
        for (int i13 = 0; i13 < iArr2.length; i13++) {
            int length5 = iArr.length - 1;
            GenericGF genericGF4 = this.a;
            int i14 = iArr2[i13];
            Objects.requireNonNull(genericGF4);
            if (i14 == 0) {
                throw new IllegalArgumentException();
            }
            int i15 = length5 - genericGF4.j[i14];
            if (i15 < 0) {
                throw new ReedSolomonException("Bad error location");
            }
            iArr[i15] = iArr[i15] ^ iArr9[i13];
        }
    }
}
