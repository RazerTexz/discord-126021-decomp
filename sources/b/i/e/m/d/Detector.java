package b.i.e.m.d;

import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import b.i.e.ResultPoint;
import b.i.e.m.AztecDetectorResult;
import b.i.e.n.BitMatrix;
import b.i.e.n.DefaultGridSampler;
import b.i.e.n.PerspectiveTransform;
import b.i.e.n.k.WhiteRectangleDetector;
import b.i.e.n.l.GenericGF;
import b.i.e.n.l.ReedSolomonDecoder;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.e.m.d.a, reason: use source file name */
/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Detector {
    public static final int[] a = {3808, 476, 2107, 1799};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitMatrix f1828b;
    public boolean c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: b.i.e.m.d.a$a */
    /* JADX INFO: compiled from: Detector.java */
    public static final class a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1829b;

        public a(int i, int i2) {
            this.a = i;
            this.f1829b = i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(this.a);
            sb.append(' ');
            return outline.A(sb, this.f1829b, '>');
        }
    }

    public Detector(BitMatrix bitMatrix) {
        this.f1828b = bitMatrix;
    }

    public static ResultPoint[] b(ResultPoint[] resultPointArr, int i, int i2) {
        float f = i2 / (i * 2.0f);
        float f2 = resultPointArr[0].a - resultPointArr[2].a;
        float f3 = resultPointArr[0].f1826b - resultPointArr[2].f1826b;
        float f4 = (resultPointArr[0].a + resultPointArr[2].a) / 2.0f;
        float f5 = (resultPointArr[0].f1826b + resultPointArr[2].f1826b) / 2.0f;
        float f6 = f2 * f;
        float f7 = f3 * f;
        ResultPoint resultPoint = new ResultPoint(f4 + f6, f5 + f7);
        ResultPoint resultPoint2 = new ResultPoint(f4 - f6, f5 - f7);
        float f8 = resultPointArr[1].a - resultPointArr[3].a;
        float f9 = resultPointArr[1].f1826b - resultPointArr[3].f1826b;
        float f10 = (resultPointArr[1].a + resultPointArr[3].a) / 2.0f;
        float f11 = (resultPointArr[1].f1826b + resultPointArr[3].f1826b) / 2.0f;
        float f12 = f8 * f;
        float f13 = f * f9;
        return new ResultPoint[]{resultPoint, new ResultPoint(f10 + f12, f11 + f13), resultPoint2, new ResultPoint(f10 - f12, f11 - f13)};
    }

    public AztecDetectorResult a(boolean z2) throws NotFoundException {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        ResultPoint resultPoint4;
        ResultPoint resultPoint5;
        ResultPoint resultPoint6;
        ResultPoint resultPoint7;
        ResultPoint resultPoint8;
        int i;
        long j;
        int i2;
        int i3 = 2;
        int i4 = -1;
        int i5 = 1;
        try {
            BitMatrix bitMatrix = this.f1828b;
            ResultPoint[] resultPointArrB = new WhiteRectangleDetector(bitMatrix, 10, bitMatrix.j / 2, bitMatrix.k / 2).b();
            resultPoint4 = resultPointArrB[0];
            resultPoint3 = resultPointArrB[1];
            resultPoint2 = resultPointArrB[2];
            resultPoint = resultPointArrB[3];
        } catch (NotFoundException unused) {
            BitMatrix bitMatrix2 = this.f1828b;
            int i6 = bitMatrix2.j / 2;
            int i7 = bitMatrix2.k / 2;
            int i8 = i7 - 7;
            int i9 = i6 + 7 + 1;
            int i10 = i9;
            int i11 = i8;
            while (true) {
                i11--;
                if (!f(i10, i11) || this.f1828b.f(i10, i11)) {
                    break;
                }
                i10++;
            }
            int i12 = i10 - 1;
            int i13 = i11 + 1;
            while (f(i12, i13) && !this.f1828b.f(i12, i13)) {
                i12++;
            }
            int i14 = i12 - 1;
            while (f(i14, i13) && !this.f1828b.f(i14, i13)) {
                i13--;
            }
            ResultPoint resultPoint9 = new ResultPoint(i14, i13 + 1);
            int i15 = i7 + 7;
            int i16 = i15;
            while (true) {
                i16++;
                if (!f(i9, i16) || this.f1828b.f(i9, i16)) {
                    break;
                }
                i9++;
            }
            int i17 = i9 - 1;
            int i18 = i16 - 1;
            while (f(i17, i18) && !this.f1828b.f(i17, i18)) {
                i17++;
            }
            int i19 = i17 - 1;
            while (f(i19, i18) && !this.f1828b.f(i19, i18)) {
                i18++;
            }
            ResultPoint resultPoint10 = new ResultPoint(i19, i18 - 1);
            int i20 = i6 - 7;
            int i21 = i20 - 1;
            while (true) {
                i15++;
                if (!f(i21, i15) || this.f1828b.f(i21, i15)) {
                    break;
                }
                i21--;
            }
            int i22 = i21 + 1;
            int i23 = i15 - 1;
            while (f(i22, i23) && !this.f1828b.f(i22, i23)) {
                i22--;
            }
            int i24 = i22 + 1;
            while (f(i24, i23) && !this.f1828b.f(i24, i23)) {
                i23++;
            }
            ResultPoint resultPoint11 = new ResultPoint(i24, i23 - 1);
            do {
                i20--;
                i8--;
                if (!f(i20, i8)) {
                    break;
                }
            } while (!this.f1828b.f(i20, i8));
            int i25 = i20 + 1;
            int i26 = i8 + 1;
            while (f(i25, i26) && !this.f1828b.f(i25, i26)) {
                i25--;
            }
            int i27 = i25 + 1;
            while (f(i27, i26) && !this.f1828b.f(i27, i26)) {
                i26--;
            }
            resultPoint = new ResultPoint(i27, i26 + 1);
            resultPoint2 = resultPoint11;
            resultPoint3 = resultPoint10;
            resultPoint4 = resultPoint9;
        }
        int iZ0 = f.Z0((((resultPoint4.a + resultPoint.a) + resultPoint3.a) + resultPoint2.a) / 4.0f);
        int iZ1 = f.Z0((((resultPoint4.f1826b + resultPoint.f1826b) + resultPoint3.f1826b) + resultPoint2.f1826b) / 4.0f);
        try {
            ResultPoint[] resultPointArrB2 = new WhiteRectangleDetector(this.f1828b, 15, iZ0, iZ1).b();
            resultPoint6 = resultPointArrB2[0];
            resultPoint8 = resultPointArrB2[1];
            resultPoint7 = resultPointArrB2[2];
            resultPoint5 = resultPointArrB2[3];
        } catch (NotFoundException unused2) {
            int i28 = iZ1 - 7;
            int i29 = iZ0 + 7 + 1;
            int i30 = i29;
            int i31 = i28;
            while (true) {
                i31--;
                if (!f(i30, i31) || this.f1828b.f(i30, i31)) {
                    break;
                }
                i30++;
            }
            int i32 = i30 - 1;
            int i33 = i31 + 1;
            while (f(i32, i33) && !this.f1828b.f(i32, i33)) {
                i32++;
            }
            int i34 = i32 - 1;
            while (f(i34, i33) && !this.f1828b.f(i34, i33)) {
                i33--;
            }
            ResultPoint resultPoint12 = new ResultPoint(i34, i33 + 1);
            int i35 = iZ1 + 7;
            int i36 = i35;
            while (true) {
                i36++;
                if (!f(i29, i36) || this.f1828b.f(i29, i36)) {
                    break;
                }
                i29++;
            }
            int i37 = i29 - 1;
            int i38 = i36 - 1;
            while (f(i37, i38) && !this.f1828b.f(i37, i38)) {
                i37++;
            }
            int i39 = i37 - 1;
            while (f(i39, i38) && !this.f1828b.f(i39, i38)) {
                i38++;
            }
            ResultPoint resultPoint13 = new ResultPoint(i39, i38 - 1);
            int i40 = iZ0 - 7;
            int i41 = i40 - 1;
            while (true) {
                i35++;
                if (!f(i41, i35) || this.f1828b.f(i41, i35)) {
                    break;
                }
                i41--;
            }
            int i42 = i41 + 1;
            int i43 = i35 - 1;
            while (f(i42, i43) && !this.f1828b.f(i42, i43)) {
                i42--;
            }
            int i44 = i42 + 1;
            while (f(i44, i43) && !this.f1828b.f(i44, i43)) {
                i43++;
            }
            ResultPoint resultPoint14 = new ResultPoint(i44, i43 - 1);
            do {
                i40--;
                i28--;
                if (!f(i40, i28)) {
                    break;
                }
            } while (!this.f1828b.f(i40, i28));
            int i45 = i40 + 1;
            int i46 = i28 + 1;
            while (f(i45, i46) && !this.f1828b.f(i45, i46)) {
                i45--;
            }
            int i47 = i45 + 1;
            while (f(i47, i46) && !this.f1828b.f(i47, i46)) {
                i46--;
            }
            resultPoint5 = new ResultPoint(i47, i46 + 1);
            resultPoint6 = resultPoint12;
            resultPoint7 = resultPoint14;
            resultPoint8 = resultPoint13;
        }
        a aVar = new a(f.Z0((((resultPoint6.a + resultPoint5.a) + resultPoint8.a) + resultPoint7.a) / 4.0f), f.Z0((((resultPoint6.f1826b + resultPoint5.f1826b) + resultPoint8.f1826b) + resultPoint7.f1826b) / 4.0f));
        this.f = 1;
        a aVar2 = aVar;
        a aVar3 = aVar2;
        a aVar4 = aVar3;
        boolean z3 = true;
        while (this.f < 9) {
            a aVarE = e(aVar, z3, i5, i4);
            a aVarE2 = e(aVar2, z3, i5, i5);
            a aVarE3 = e(aVar3, z3, i4, i5);
            a aVarE4 = e(aVar4, z3, i4, i4);
            if (this.f > i3) {
                double dR = (f.R(aVarE4.a, aVarE4.f1829b, aVarE.a, aVarE.f1829b) * this.f) / (f.R(aVar4.a, aVar4.f1829b, aVar.a, aVar.f1829b) * (this.f + i3));
                if (dR < 0.75d || dR > 1.25d) {
                    break;
                }
                a aVar5 = new a(aVarE.a - 3, aVarE.f1829b + 3);
                a aVar6 = new a(aVarE2.a - 3, aVarE2.f1829b - 3);
                a aVar7 = new a(aVarE3.a + 3, aVarE3.f1829b - 3);
                a aVar8 = new a(aVarE4.a + 3, aVarE4.f1829b + 3);
                int iC = c(aVar8, aVar5);
                if (!(iC != 0 && c(aVar5, aVar6) == iC && c(aVar6, aVar7) == iC && c(aVar7, aVar8) == iC)) {
                    break;
                }
            }
            z3 = !z3;
            this.f++;
            aVar4 = aVarE4;
            aVar2 = aVarE2;
            aVar3 = aVarE3;
            aVar = aVarE;
            i3 = 2;
            i4 = -1;
            i5 = 1;
        }
        int i48 = this.f;
        if (i48 != 5 && i48 != 7) {
            throw NotFoundException.l;
        }
        this.c = i48 == 5;
        int i49 = i48 * 2;
        ResultPoint[] resultPointArrB3 = b(new ResultPoint[]{new ResultPoint(aVar.a + 0.5f, aVar.f1829b - 0.5f), new ResultPoint(aVar2.a + 0.5f, aVar2.f1829b + 0.5f), new ResultPoint(aVar3.a - 0.5f, aVar3.f1829b + 0.5f), new ResultPoint(aVar4.a - 0.5f, aVar4.f1829b - 0.5f)}, i49 - 3, i49);
        if (z2) {
            ResultPoint resultPoint15 = resultPointArrB3[0];
            resultPointArrB3[0] = resultPointArrB3[2];
            resultPointArrB3[2] = resultPoint15;
        }
        if (!g(resultPointArrB3[0]) || !g(resultPointArrB3[1]) || !g(resultPointArrB3[2]) || !g(resultPointArrB3[3])) {
            throw NotFoundException.l;
        }
        int i50 = this.f * 2;
        int[] iArr = {h(resultPointArrB3[0], resultPointArrB3[1], i50), h(resultPointArrB3[1], resultPointArrB3[2], i50), h(resultPointArrB3[2], resultPointArrB3[3], i50), h(resultPointArrB3[3], resultPointArrB3[0], i50)};
        int i51 = 0;
        for (int i52 = 0; i52 < 4; i52++) {
            int i53 = iArr[i52];
            i51 = (i51 << 3) + ((i53 >> (i50 - 2)) << 1) + (i53 & 1);
        }
        int i54 = ((i51 & 1) << 11) + (i51 >> 1);
        for (int i55 = 0; i55 < 4; i55++) {
            if (Integer.bitCount(a[i55] ^ i54) <= 2) {
                this.g = i55;
                long j2 = 0;
                for (int i56 = 0; i56 < 4; i56++) {
                    int i57 = iArr[(this.g + i56) % 4];
                    if (this.c) {
                        j = j2 << 7;
                        i2 = (i57 >> 1) & Opcodes.LAND;
                    } else {
                        j = j2 << 10;
                        i2 = ((i57 >> 1) & 31) + ((i57 >> 2) & 992);
                    }
                    j2 = j + ((long) i2);
                }
                int i58 = 7;
                if (this.c) {
                    i = 2;
                } else {
                    i = 4;
                    i58 = 10;
                }
                int i59 = i58 - i;
                int[] iArr2 = new int[i58];
                while (true) {
                    i58--;
                    if (i58 < 0) {
                        try {
                            break;
                        } catch (ReedSolomonException unused3) {
                            throw NotFoundException.l;
                        }
                    }
                    iArr2[i58] = ((int) j2) & 15;
                    j2 >>= 4;
                }
                new ReedSolomonDecoder(GenericGF.d).a(iArr2, i59);
                int i60 = 0;
                for (int i61 = 0; i61 < i; i61++) {
                    i60 = (i60 << 4) + iArr2[i61];
                }
                if (this.c) {
                    this.d = (i60 >> 6) + 1;
                    this.e = (i60 & 63) + 1;
                } else {
                    this.d = (i60 >> 11) + 1;
                    this.e = (i60 & 2047) + 1;
                }
                BitMatrix bitMatrix3 = this.f1828b;
                int i62 = this.g;
                ResultPoint resultPoint16 = resultPointArrB3[i62 % 4];
                ResultPoint resultPoint17 = resultPointArrB3[(i62 + 1) % 4];
                ResultPoint resultPoint18 = resultPointArrB3[(i62 + 2) % 4];
                ResultPoint resultPoint19 = resultPointArrB3[(i62 + 3) % 4];
                DefaultGridSampler defaultGridSampler = DefaultGridSampler.a;
                int iD = d();
                float f = iD / 2.0f;
                float f2 = this.f;
                float f3 = f - f2;
                float f4 = f + f2;
                return new AztecDetectorResult(defaultGridSampler.a(bitMatrix3, iD, iD, PerspectiveTransform.a(f3, f3, f4, f3, f4, f4, f3, f4, resultPoint16.a, resultPoint16.f1826b, resultPoint17.a, resultPoint17.f1826b, resultPoint18.a, resultPoint18.f1826b, resultPoint19.a, resultPoint19.f1826b)), b(resultPointArrB3, this.f * 2, d()), this.c, this.e, this.d);
            }
        }
        throw NotFoundException.l;
    }

    public final int c(a aVar, a aVar2) {
        float fR = f.R(aVar.a, aVar.f1829b, aVar2.a, aVar2.f1829b);
        int i = aVar2.a;
        int i2 = aVar.a;
        float f = (i - i2) / fR;
        int i3 = aVar2.f1829b;
        int i4 = aVar.f1829b;
        float f2 = (i3 - i4) / fR;
        float f3 = i2;
        float f4 = i4;
        boolean zF = this.f1828b.f(i2, i4);
        int iCeil = (int) Math.ceil(fR);
        int i5 = 0;
        for (int i6 = 0; i6 < iCeil; i6++) {
            f3 += f;
            f4 += f2;
            if (this.f1828b.f(f.Z0(f3), f.Z0(f4)) != zF) {
                i5++;
            }
        }
        float f5 = i5 / fR;
        if (f5 <= 0.1f || f5 >= 0.9f) {
            return (f5 <= 0.1f) == zF ? 1 : -1;
        }
        return 0;
    }

    public final int d() {
        if (this.c) {
            return (this.d * 4) + 11;
        }
        int i = this.d;
        if (i <= 4) {
            return (i * 4) + 15;
        }
        return ((((i - 4) / 8) + 1) * 2) + (i * 4) + 15;
    }

    public final a e(a aVar, boolean z2, int i, int i2) {
        int i3 = aVar.a + i;
        int i4 = aVar.f1829b;
        while (true) {
            i4 += i2;
            if (!f(i3, i4) || this.f1828b.f(i3, i4) != z2) {
                break;
            }
            i3 += i;
        }
        int i5 = i3 - i;
        int i6 = i4 - i2;
        while (f(i5, i6) && this.f1828b.f(i5, i6) == z2) {
            i5 += i;
        }
        int i7 = i5 - i;
        while (f(i7, i6) && this.f1828b.f(i7, i6) == z2) {
            i6 += i2;
        }
        return new a(i7, i6 - i2);
    }

    public final boolean f(int i, int i2) {
        if (i < 0) {
            return false;
        }
        BitMatrix bitMatrix = this.f1828b;
        return i < bitMatrix.j && i2 > 0 && i2 < bitMatrix.k;
    }

    public final boolean g(ResultPoint resultPoint) {
        return f(f.Z0(resultPoint.a), f.Z0(resultPoint.f1826b));
    }

    public final int h(ResultPoint resultPoint, ResultPoint resultPoint2, int i) {
        float fQ = f.Q(resultPoint.a, resultPoint.f1826b, resultPoint2.a, resultPoint2.f1826b);
        float f = fQ / i;
        float f2 = resultPoint.a;
        float f3 = resultPoint.f1826b;
        float f4 = ((resultPoint2.a - f2) * f) / fQ;
        float f5 = ((resultPoint2.f1826b - f3) * f) / fQ;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f6 = i3;
            if (this.f1828b.f(f.Z0((f6 * f4) + f2), f.Z0((f6 * f5) + f3))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }
}
