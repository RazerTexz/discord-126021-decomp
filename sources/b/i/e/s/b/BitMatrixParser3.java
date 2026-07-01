package b.i.e.s.b;

import b.i.e.n.BitMatrix;
import com.google.zxing.FormatException;

/* JADX INFO: renamed from: b.i.e.s.b.a, reason: use source file name */
/* JADX INFO: compiled from: BitMatrixParser.java */
/* JADX INFO: loaded from: classes3.dex */
public final class BitMatrixParser3 {
    public final BitMatrix a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Version3 f1886b;
    public FormatInformation c;
    public boolean d;

    public BitMatrixParser3(BitMatrix bitMatrix) throws FormatException {
        int i = bitMatrix.k;
        if (i < 21 || (i & 3) != 1) {
            throw FormatException.a();
        }
        this.a = bitMatrix;
    }

    public final int a(int i, int i2, int i3) {
        return this.d ? this.a.f(i2, i) : this.a.f(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    public void b() {
        int i = 0;
        while (i < this.a.j) {
            int i2 = i + 1;
            int i3 = i2;
            while (true) {
                BitMatrix bitMatrix = this.a;
                if (i3 < bitMatrix.k) {
                    if (bitMatrix.f(i, i3) != this.a.f(i3, i)) {
                        this.a.b(i3, i);
                        this.a.b(i, i3);
                    }
                    i3++;
                }
            }
            i = i2;
        }
    }

    public FormatInformation c() throws FormatException {
        FormatInformation formatInformation = this.c;
        if (formatInformation != null) {
            return formatInformation;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i = 0; i < 6; i++) {
            iA2 = a(i, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i2 = 5; i2 >= 0; i2--) {
            iA3 = a(8, i2, iA3);
        }
        int i3 = this.a.k;
        int i4 = i3 - 7;
        for (int i5 = i3 - 1; i5 >= i4; i5--) {
            iA = a(8, i5, iA);
        }
        for (int i6 = i3 - 8; i6 < i3; i6++) {
            iA = a(i6, 8, iA);
        }
        FormatInformation formatInformationA = FormatInformation.a(iA3, iA);
        if (formatInformationA == null) {
            formatInformationA = FormatInformation.a(iA3 ^ 21522, iA ^ 21522);
        }
        this.c = formatInformationA;
        if (formatInformationA != null) {
            return formatInformationA;
        }
        throw FormatException.a();
    }

    public Version3 d() throws FormatException {
        Version3 version3 = this.f1886b;
        if (version3 != null) {
            return version3;
        }
        int i = this.a.k;
        int i2 = (i - 17) / 4;
        if (i2 <= 6) {
            return Version3.d(i2);
        }
        int i3 = i - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i4 = 5; i4 >= 0; i4--) {
            for (int i5 = i - 9; i5 >= i3; i5--) {
                iA2 = a(i5, i4, iA2);
            }
        }
        Version3 version3B = Version3.b(iA2);
        if (version3B != null && version3B.c() == i) {
            this.f1886b = version3B;
            return version3B;
        }
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = i - 9; i7 >= i3; i7--) {
                iA = a(i6, i7, iA);
            }
        }
        Version3 version3B2 = Version3.b(iA);
        if (version3B2 == null || version3B2.c() != i) {
            throw FormatException.a();
        }
        this.f1886b = version3B2;
        return version3B2;
    }

    public void e() {
        if (this.c == null) {
            return;
        }
        DataMask dataMask = DataMask.values()[this.c.c];
        BitMatrix bitMatrix = this.a;
        dataMask.g(bitMatrix, bitMatrix.k);
    }
}
