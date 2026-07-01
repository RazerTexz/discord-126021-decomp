package b.i.e.q;

import b.i.e.BarcodeFormat;
import b.i.e.n.BitArray;
import com.google.zxing.NotFoundException;

/* JADX INFO: renamed from: b.i.e.q.f, reason: use source file name */
/* JADX INFO: compiled from: EAN8Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class EAN8Reader extends UPCEANReader {
    public final int[] h = new int[4];

    @Override // b.i.e.q.UPCEANReader
    public int j(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i = bitArray.k;
        int i2 = iArr[1];
        for (int i3 = 0; i3 < 4 && i2 < i; i3++) {
            sb.append((char) (UPCEANReader.h(bitArray, iArr2, i2, UPCEANReader.c) + 48));
            for (int i4 : iArr2) {
                i2 += i4;
            }
        }
        int[] iArr3 = UPCEANReader.f1861b;
        int i5 = UPCEANReader.l(bitArray, i2, true, iArr3, new int[iArr3.length])[1];
        for (int i6 = 0; i6 < 4 && i5 < i; i6++) {
            sb.append((char) (UPCEANReader.h(bitArray, iArr2, i5, UPCEANReader.c) + 48));
            for (int i7 : iArr2) {
                i5 += i7;
            }
        }
        return i5;
    }

    @Override // b.i.e.q.UPCEANReader
    public BarcodeFormat n() {
        return BarcodeFormat.EAN_8;
    }
}
