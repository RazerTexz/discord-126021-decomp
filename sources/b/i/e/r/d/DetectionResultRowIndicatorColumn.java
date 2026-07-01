package b.i.e.r.d;

/* JADX INFO: renamed from: b.i.e.r.d.h, reason: use source file name */
/* JADX INFO: compiled from: DetectionResultRowIndicatorColumn.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DetectionResultRowIndicatorColumn extends DetectionResultColumn {
    public final boolean c;

    public DetectionResultRowIndicatorColumn(BoundingBox boundingBox, boolean z2) {
        super(boundingBox);
        this.c = z2;
    }

    public BarcodeMetadata c() {
        Codeword[] codewordArr = this.f1881b;
        BarcodeValue barcodeValue = new BarcodeValue();
        BarcodeValue barcodeValue2 = new BarcodeValue();
        BarcodeValue barcodeValue3 = new BarcodeValue();
        BarcodeValue barcodeValue4 = new BarcodeValue();
        for (Codeword codeword : codewordArr) {
            if (codeword != null) {
                codeword.b();
                int i = codeword.d % 30;
                int i2 = codeword.e;
                if (!this.c) {
                    i2 += 2;
                }
                int i3 = i2 % 3;
                if (i3 == 0) {
                    barcodeValue2.b((i * 3) + 1);
                } else if (i3 == 1) {
                    barcodeValue4.b(i / 3);
                    barcodeValue3.b(i % 3);
                } else if (i3 == 2) {
                    barcodeValue.b(i + 1);
                }
            }
        }
        if (barcodeValue.a().length == 0 || barcodeValue2.a().length == 0 || barcodeValue3.a().length == 0 || barcodeValue4.a().length == 0 || barcodeValue.a()[0] <= 0 || barcodeValue2.a()[0] + barcodeValue3.a()[0] < 3 || barcodeValue2.a()[0] + barcodeValue3.a()[0] > 90) {
            return null;
        }
        BarcodeMetadata barcodeMetadata = new BarcodeMetadata(barcodeValue.a()[0], barcodeValue2.a()[0], barcodeValue3.a()[0], barcodeValue4.a()[0]);
        d(codewordArr, barcodeMetadata);
        return barcodeMetadata;
    }

    public final void d(Codeword[] codewordArr, BarcodeMetadata barcodeMetadata) {
        for (int i = 0; i < codewordArr.length; i++) {
            Codeword codeword = codewordArr[i];
            if (codewordArr[i] != null) {
                int i2 = codeword.d % 30;
                int i3 = codeword.e;
                if (i3 > barcodeMetadata.e) {
                    codewordArr[i] = null;
                } else {
                    if (!this.c) {
                        i3 += 2;
                    }
                    int i4 = i3 % 3;
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 == 2 && i2 + 1 != barcodeMetadata.a) {
                                codewordArr[i] = null;
                            }
                        } else if (i2 / 3 != barcodeMetadata.f1876b || i2 % 3 != barcodeMetadata.d) {
                            codewordArr[i] = null;
                        }
                    } else if ((i2 * 3) + 1 != barcodeMetadata.c) {
                        codewordArr[i] = null;
                    }
                }
            }
        }
    }

    @Override // b.i.e.r.d.DetectionResultColumn
    public String toString() {
        return "IsLeft: " + this.c + '\n' + super.toString();
    }
}
