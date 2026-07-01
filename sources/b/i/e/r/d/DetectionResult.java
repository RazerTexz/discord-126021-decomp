package b.i.e.r.d;

import b.i.e.ResultPoint;
import java.util.Formatter;

/* JADX INFO: renamed from: b.i.e.r.d.f, reason: use source file name */
/* JADX INFO: compiled from: DetectionResult.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DetectionResult {
    public final BarcodeMetadata a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DetectionResultColumn[] f1880b;
    public BoundingBox c;
    public final int d;

    public DetectionResult(BarcodeMetadata barcodeMetadata, BoundingBox boundingBox) {
        this.a = barcodeMetadata;
        int i = barcodeMetadata.a;
        this.d = i;
        this.c = boundingBox;
        this.f1880b = new DetectionResultColumn[i + 2];
    }

    public static int b(int i, int i2, Codeword codeword) {
        if (codeword.a()) {
            return i2;
        }
        if (!(i != -1 && codeword.c == (i % 3) * 3)) {
            return i2 + 1;
        }
        codeword.e = i;
        return 0;
    }

    public final void a(DetectionResultColumn detectionResultColumn) {
        int i;
        if (detectionResultColumn != null) {
            DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = (DetectionResultRowIndicatorColumn) detectionResultColumn;
            BarcodeMetadata barcodeMetadata = this.a;
            Codeword[] codewordArr = detectionResultRowIndicatorColumn.f1881b;
            for (Codeword codeword : codewordArr) {
                if (codeword != null) {
                    codeword.b();
                }
            }
            detectionResultRowIndicatorColumn.d(codewordArr, barcodeMetadata);
            BoundingBox boundingBox = detectionResultRowIndicatorColumn.a;
            boolean z2 = detectionResultRowIndicatorColumn.c;
            ResultPoint resultPoint = z2 ? boundingBox.f1877b : boundingBox.d;
            ResultPoint resultPoint2 = z2 ? boundingBox.c : boundingBox.e;
            int iB = detectionResultRowIndicatorColumn.b((int) resultPoint.f1826b);
            int iB2 = detectionResultRowIndicatorColumn.b((int) resultPoint2.f1826b);
            int i2 = -1;
            int i3 = 0;
            int i4 = 1;
            while (iB < iB2) {
                if (codewordArr[iB] != null) {
                    Codeword codeword2 = codewordArr[iB];
                    int i5 = codeword2.e;
                    int i6 = i5 - i2;
                    if (i6 == 0) {
                        i3++;
                    } else {
                        if (i6 == 1) {
                            int iMax = Math.max(i4, i3);
                            i = codeword2.e;
                            i4 = iMax;
                        } else if (i6 < 0 || i5 >= barcodeMetadata.e || i6 > iB) {
                            codewordArr[iB] = null;
                        } else {
                            if (i4 > 2) {
                                i6 *= i4 - 2;
                            }
                            boolean z3 = i6 >= iB;
                            for (int i7 = 1; i7 <= i6 && !z3; i7++) {
                                z3 = codewordArr[iB - i7] != null;
                            }
                            if (z3) {
                                codewordArr[iB] = null;
                            } else {
                                i = codeword2.e;
                            }
                        }
                        i2 = i;
                        i3 = 1;
                    }
                }
                iB++;
            }
        }
    }

    public String toString() {
        DetectionResultColumn[] detectionResultColumnArr = this.f1880b;
        DetectionResultColumn detectionResultColumn = detectionResultColumnArr[0];
        if (detectionResultColumn == null) {
            detectionResultColumn = detectionResultColumnArr[this.d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i = 0; i < detectionResultColumn.f1881b.length; i++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i));
                for (int i2 = 0; i2 < this.d + 2; i2++) {
                    DetectionResultColumn[] detectionResultColumnArr2 = this.f1880b;
                    if (detectionResultColumnArr2[i2] == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        Codeword codeword = detectionResultColumnArr2[i2].f1881b[i];
                        if (codeword == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(codeword.e), Integer.valueOf(codeword.d));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        formatter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }
}
