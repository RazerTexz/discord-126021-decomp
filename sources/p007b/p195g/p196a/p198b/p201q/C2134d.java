package p007b.p195g.p196a.p198b.p201q;

import com.discord.widgets.chat.input.MentionUtilsKt;
import com.fasterxml.jackson.core.JsonGenerationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.AbstractC2113i;
import p007b.p195g.p196a.p198b.C2105a;
import p007b.p195g.p196a.p198b.InterfaceC2114j;
import p007b.p195g.p196a.p198b.InterfaceC2115k;
import p007b.p195g.p196a.p198b.p200p.C2121a;
import p007b.p195g.p196a.p198b.p200p.C2123c;
import p007b.p195g.p196a.p198b.p200p.C2127g;
import p007b.p195g.p196a.p198b.p204t.C2139a;
import p007b.p195g.p196a.p198b.p204t.C2151m;

/* JADX INFO: renamed from: b.g.a.b.q.d */
/* JADX INFO: compiled from: WriterBasedJsonGenerator.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2134d extends AbstractC2132b {

    /* JADX INFO: renamed from: x */
    public static final char[] f4576x = (char[]) C2121a.f4536a.clone();

    /* JADX INFO: renamed from: A */
    public char[] f4577A;

    /* JADX INFO: renamed from: B */
    public int f4578B;

    /* JADX INFO: renamed from: C */
    public int f4579C;

    /* JADX INFO: renamed from: D */
    public int f4580D;

    /* JADX INFO: renamed from: E */
    public char[] f4581E;

    /* JADX INFO: renamed from: y */
    public final Writer f4582y;

    /* JADX INFO: renamed from: z */
    public char f4583z;

    public C2134d(C2123c c2123c, int i, AbstractC2113i abstractC2113i, Writer writer, char c) {
        int[] iArr;
        super(c2123c, i, abstractC2113i);
        this.f4582y = writer;
        if (c2123c.f4549e != null) {
            throw new IllegalStateException("Trying to call same allocXxx() method second time");
        }
        char[] cArrM1730a = c2123c.f4547c.m1730a(1, 0);
        c2123c.f4549e = cArrM1730a;
        this.f4577A = cArrM1730a;
        this.f4580D = cArrM1730a.length;
        this.f4583z = c;
        if (c != '\"') {
            if (c == '\"') {
                iArr = C2121a.f4541f;
            } else {
                C2121a.a aVar = C2121a.a.f4543a;
                int[] iArrCopyOf = aVar.f4544b[c];
                if (iArrCopyOf == null) {
                    iArrCopyOf = Arrays.copyOf(C2121a.f4541f, 128);
                    if (iArrCopyOf[c] == 0) {
                        iArrCopyOf[c] = -1;
                    }
                    aVar.f4544b[c] = iArrCopyOf;
                }
                iArr = iArrCopyOf;
            }
            this.f4566t = iArr;
        }
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: A */
    public void mo1631A() throws IOException {
        mo1693t0("write a null");
        m1721H0();
    }

    /* JADX INFO: renamed from: A0 */
    public final void m1714A0(char c, int i) throws IOException {
        int i2;
        if (i >= 0) {
            if (this.f4579C + 2 > this.f4580D) {
                m1715B0();
            }
            char[] cArr = this.f4577A;
            int i3 = this.f4579C;
            int i4 = i3 + 1;
            this.f4579C = i4;
            cArr[i3] = '\\';
            this.f4579C = i4 + 1;
            cArr[i4] = (char) i;
            return;
        }
        if (i == -2) {
            Objects.requireNonNull(null);
            throw null;
        }
        if (this.f4579C + 5 >= this.f4580D) {
            m1715B0();
        }
        int i5 = this.f4579C;
        char[] cArr2 = this.f4577A;
        int i6 = i5 + 1;
        cArr2[i5] = '\\';
        int i7 = i6 + 1;
        cArr2[i6] = 'u';
        if (c > 255) {
            int i8 = 255 & (c >> '\b');
            int i9 = i7 + 1;
            char[] cArr3 = f4576x;
            cArr2[i7] = cArr3[i8 >> 4];
            i2 = i9 + 1;
            cArr2[i9] = cArr3[i8 & 15];
            c = (char) (c & 255);
        } else {
            int i10 = i7 + 1;
            cArr2[i7] = '0';
            i2 = i10 + 1;
            cArr2[i10] = '0';
        }
        int i11 = i2 + 1;
        char[] cArr4 = f4576x;
        cArr2[i2] = cArr4[c >> 4];
        cArr2[i11] = cArr4[c & 15];
        this.f4579C = i11 + 1;
    }

    /* JADX INFO: renamed from: B0 */
    public void m1715B0() throws IOException {
        int i = this.f4579C;
        int i2 = this.f4578B;
        int i3 = i - i2;
        if (i3 > 0) {
            this.f4578B = 0;
            this.f4579C = 0;
            this.f4582y.write(this.f4577A, i2, i3);
        }
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: C */
    public void mo1632C(double d) throws IOException {
        if (!this.f4530p) {
            String str = C2127g.f4554a;
            if (!(Double.isNaN(d) || Double.isInfinite(d)) || !mo1652d(AbstractC2108d.a.QUOTE_NON_NUMERIC_NUMBERS)) {
                mo1693t0("write a number");
                mo1642T(String.valueOf(d));
                return;
            }
        }
        mo1658j0(String.valueOf(d));
    }

    /* JADX INFO: renamed from: C0 */
    public final int m1716C0(char[] cArr, int i, int i2, char c, int i3) throws IOException {
        int i4;
        if (i3 >= 0) {
            if (i > 1 && i < i2) {
                int i5 = i - 2;
                cArr[i5] = '\\';
                cArr[i5 + 1] = (char) i3;
                return i5;
            }
            char[] cArrM1724z0 = this.f4581E;
            if (cArrM1724z0 == null) {
                cArrM1724z0 = m1724z0();
            }
            cArrM1724z0[1] = (char) i3;
            this.f4582y.write(cArrM1724z0, 0, 2);
            return i;
        }
        if (i3 == -2) {
            Objects.requireNonNull(null);
            throw null;
        }
        if (i <= 5 || i >= i2) {
            char[] cArrM1724z1 = this.f4581E;
            if (cArrM1724z1 == null) {
                cArrM1724z1 = m1724z0();
            }
            this.f4578B = this.f4579C;
            if (c <= 255) {
                char[] cArr2 = f4576x;
                cArrM1724z1[6] = cArr2[c >> 4];
                cArrM1724z1[7] = cArr2[c & 15];
                this.f4582y.write(cArrM1724z1, 2, 6);
                return i;
            }
            int i6 = (c >> '\b') & 255;
            int i7 = c & 255;
            char[] cArr3 = f4576x;
            cArrM1724z1[10] = cArr3[i6 >> 4];
            cArrM1724z1[11] = cArr3[i6 & 15];
            cArrM1724z1[12] = cArr3[i7 >> 4];
            cArrM1724z1[13] = cArr3[i7 & 15];
            this.f4582y.write(cArrM1724z1, 8, 6);
            return i;
        }
        int i8 = i - 6;
        int i9 = i8 + 1;
        cArr[i8] = '\\';
        int i10 = i9 + 1;
        cArr[i9] = 'u';
        if (c > 255) {
            int i11 = (c >> '\b') & 255;
            int i12 = i10 + 1;
            char[] cArr4 = f4576x;
            cArr[i10] = cArr4[i11 >> 4];
            i4 = i12 + 1;
            cArr[i12] = cArr4[i11 & 15];
            c = (char) (c & 255);
        } else {
            int i13 = i10 + 1;
            cArr[i10] = '0';
            i4 = i13 + 1;
            cArr[i13] = '0';
        }
        int i14 = i4 + 1;
        char[] cArr5 = f4576x;
        cArr[i4] = cArr5[c >> 4];
        cArr[i14] = cArr5[c & 15];
        return i14 - 5;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: D */
    public void mo1633D(float f) throws IOException {
        if (!this.f4530p) {
            String str = C2127g.f4554a;
            if (!(Float.isNaN(f) || Float.isInfinite(f)) || !mo1652d(AbstractC2108d.a.QUOTE_NON_NUMERIC_NUMBERS)) {
                mo1693t0("write a number");
                mo1642T(String.valueOf(f));
                return;
            }
        }
        mo1658j0(String.valueOf(f));
    }

    /* JADX INFO: renamed from: D0 */
    public final void m1717D0(char c, int i) throws IOException {
        int i2;
        if (i >= 0) {
            int i3 = this.f4579C;
            if (i3 >= 2) {
                int i4 = i3 - 2;
                this.f4578B = i4;
                char[] cArr = this.f4577A;
                cArr[i4] = '\\';
                cArr[i4 + 1] = (char) i;
                return;
            }
            char[] cArrM1724z0 = this.f4581E;
            if (cArrM1724z0 == null) {
                cArrM1724z0 = m1724z0();
            }
            this.f4578B = this.f4579C;
            cArrM1724z0[1] = (char) i;
            this.f4582y.write(cArrM1724z0, 0, 2);
            return;
        }
        if (i == -2) {
            Objects.requireNonNull(null);
            throw null;
        }
        int i5 = this.f4579C;
        if (i5 < 6) {
            char[] cArrM1724z1 = this.f4581E;
            if (cArrM1724z1 == null) {
                cArrM1724z1 = m1724z0();
            }
            this.f4578B = this.f4579C;
            if (c <= 255) {
                char[] cArr2 = f4576x;
                cArrM1724z1[6] = cArr2[c >> 4];
                cArrM1724z1[7] = cArr2[c & 15];
                this.f4582y.write(cArrM1724z1, 2, 6);
                return;
            }
            int i6 = (c >> '\b') & 255;
            int i7 = c & 255;
            char[] cArr3 = f4576x;
            cArrM1724z1[10] = cArr3[i6 >> 4];
            cArrM1724z1[11] = cArr3[i6 & 15];
            cArrM1724z1[12] = cArr3[i7 >> 4];
            cArrM1724z1[13] = cArr3[i7 & 15];
            this.f4582y.write(cArrM1724z1, 8, 6);
            return;
        }
        char[] cArr4 = this.f4577A;
        int i8 = i5 - 6;
        this.f4578B = i8;
        cArr4[i8] = '\\';
        int i9 = i8 + 1;
        cArr4[i9] = 'u';
        if (c > 255) {
            int i10 = (c >> '\b') & 255;
            int i11 = i9 + 1;
            char[] cArr5 = f4576x;
            cArr4[i11] = cArr5[i10 >> 4];
            i2 = i11 + 1;
            cArr4[i2] = cArr5[i10 & 15];
            c = (char) (c & 255);
        } else {
            int i12 = i9 + 1;
            cArr4[i12] = '0';
            i2 = i12 + 1;
            cArr4[i2] = '0';
        }
        int i13 = i2 + 1;
        char[] cArr6 = f4576x;
        cArr4[i13] = cArr6[c >> 4];
        cArr4[i13 + 1] = cArr6[c & 15];
    }

    /* JADX INFO: renamed from: E0 */
    public final int m1718E0(InputStream inputStream, byte[] bArr, int i, int i2, int i3) throws IOException {
        int i4 = 0;
        while (i < i2) {
            bArr[i4] = bArr[i];
            i4++;
            i++;
        }
        int iMin = Math.min(i3, bArr.length);
        do {
            int i5 = iMin - i4;
            if (i5 == 0) {
                break;
            }
            int i6 = inputStream.read(bArr, i4, i5);
            if (i6 < 0) {
                return i4;
            }
            i4 += i6;
        } while (i4 < 3);
        return i4;
    }

    /* JADX INFO: renamed from: F0 */
    public final int m1719F0(C2105a c2105a, InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.f4580D - 6;
        int i2 = 2;
        int iM1625d = c2105a.m1625d() >> 2;
        int i3 = -3;
        int i4 = 0;
        int iM1718E0 = 0;
        int i5 = 0;
        while (true) {
            if (i4 > i3) {
                iM1718E0 = m1718E0(inputStream, bArr, i4, iM1718E0, bArr.length);
                if (iM1718E0 < 3) {
                    break;
                }
                i3 = iM1718E0 - 3;
                i4 = 0;
            }
            if (this.f4579C > i) {
                m1715B0();
            }
            int i6 = i4 + 1;
            int i7 = bArr[i4] << 8;
            int i8 = i6 + 1;
            i4 = i8 + 1;
            i5 += 3;
            int iM1623b = c2105a.m1623b((((bArr[i6] & 255) | i7) << 8) | (bArr[i8] & 255), this.f4577A, this.f4579C);
            this.f4579C = iM1623b;
            iM1625d--;
            if (iM1625d <= 0) {
                char[] cArr = this.f4577A;
                int i9 = iM1623b + 1;
                this.f4579C = i9;
                cArr[iM1623b] = '\\';
                this.f4579C = i9 + 1;
                cArr[i9] = 'n';
                iM1625d = c2105a.m1625d() >> 2;
            }
        }
        if (iM1718E0 <= 0) {
            return i5;
        }
        if (this.f4579C > i) {
            m1715B0();
        }
        int i10 = bArr[0] << 16;
        if (1 < iM1718E0) {
            i10 |= (bArr[1] & 255) << 8;
        } else {
            i2 = 1;
        }
        int i11 = i5 + i2;
        this.f4579C = c2105a.m1624c(i10, i2, this.f4577A, this.f4579C);
        return i11;
    }

    /* JADX INFO: renamed from: G0 */
    public final int m1720G0(C2105a c2105a, InputStream inputStream, byte[] bArr, int i) throws IOException {
        int iM1718E0;
        int i2 = this.f4580D - 6;
        int i3 = 2;
        int iM1625d = c2105a.m1625d() >> 2;
        int i4 = -3;
        int i5 = 0;
        int iM1718E1 = 0;
        while (i > 2) {
            if (i5 > i4) {
                iM1718E1 = m1718E0(inputStream, bArr, i5, iM1718E1, i);
                if (iM1718E1 < 3) {
                    i5 = 0;
                    break;
                }
                i4 = iM1718E1 - 3;
                i5 = 0;
            }
            if (this.f4579C > i2) {
                m1715B0();
            }
            int i6 = i5 + 1;
            int i7 = bArr[i5] << 8;
            int i8 = i6 + 1;
            i5 = i8 + 1;
            i -= 3;
            int iM1623b = c2105a.m1623b((((bArr[i6] & 255) | i7) << 8) | (bArr[i8] & 255), this.f4577A, this.f4579C);
            this.f4579C = iM1623b;
            iM1625d--;
            if (iM1625d <= 0) {
                char[] cArr = this.f4577A;
                int i9 = iM1623b + 1;
                this.f4579C = i9;
                cArr[iM1623b] = '\\';
                this.f4579C = i9 + 1;
                cArr[i9] = 'n';
                iM1625d = c2105a.m1625d() >> 2;
            }
        }
        if (i <= 0 || (iM1718E0 = m1718E0(inputStream, bArr, i5, iM1718E1, i)) <= 0) {
            return i;
        }
        if (this.f4579C > i2) {
            m1715B0();
        }
        int i10 = bArr[0] << 16;
        if (1 < iM1718E0) {
            i10 |= (bArr[1] & 255) << 8;
        } else {
            i3 = 1;
        }
        this.f4579C = c2105a.m1624c(i10, i3, this.f4577A, this.f4579C);
        return i - i3;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: H */
    public void mo1634H(int i) throws IOException {
        mo1693t0("write a number");
        if (!this.f4530p) {
            if (this.f4579C + 11 >= this.f4580D) {
                m1715B0();
            }
            this.f4579C = C2127g.m1701d(i, this.f4577A, this.f4579C);
            return;
        }
        if (this.f4579C + 13 >= this.f4580D) {
            m1715B0();
        }
        char[] cArr = this.f4577A;
        int i2 = this.f4579C;
        int i3 = i2 + 1;
        this.f4579C = i3;
        cArr[i2] = this.f4583z;
        int iM1701d = C2127g.m1701d(i, cArr, i3);
        this.f4579C = iM1701d;
        char[] cArr2 = this.f4577A;
        this.f4579C = iM1701d + 1;
        cArr2[iM1701d] = this.f4583z;
    }

    /* JADX INFO: renamed from: H0 */
    public final void m1721H0() throws IOException {
        if (this.f4579C + 4 >= this.f4580D) {
            m1715B0();
        }
        int i = this.f4579C;
        char[] cArr = this.f4577A;
        cArr[i] = 'n';
        int i2 = i + 1;
        cArr[i2] = 'u';
        int i3 = i2 + 1;
        cArr[i3] = 'l';
        int i4 = i3 + 1;
        cArr[i4] = 'l';
        this.f4579C = i4 + 1;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: I */
    public void mo1635I(long j) throws IOException {
        mo1693t0("write a number");
        if (!this.f4530p) {
            if (this.f4579C + 21 >= this.f4580D) {
                m1715B0();
            }
            this.f4579C = C2127g.m1702e(j, this.f4577A, this.f4579C);
            return;
        }
        if (this.f4579C + 23 >= this.f4580D) {
            m1715B0();
        }
        char[] cArr = this.f4577A;
        int i = this.f4579C;
        int i2 = i + 1;
        this.f4579C = i2;
        cArr[i] = this.f4583z;
        int iM1702e = C2127g.m1702e(j, cArr, i2);
        this.f4579C = iM1702e;
        char[] cArr2 = this.f4577A;
        this.f4579C = iM1702e + 1;
        cArr2[iM1702e] = this.f4583z;
    }

    /* JADX INFO: renamed from: I0 */
    public final void m1722I0(String str) throws IOException {
        if (this.f4579C >= this.f4580D) {
            m1715B0();
        }
        char[] cArr = this.f4577A;
        int i = this.f4579C;
        this.f4579C = i + 1;
        cArr[i] = this.f4583z;
        mo1642T(str);
        if (this.f4579C >= this.f4580D) {
            m1715B0();
        }
        char[] cArr2 = this.f4577A;
        int i2 = this.f4579C;
        this.f4579C = i2 + 1;
        cArr2[i2] = this.f4583z;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: J */
    public void mo1636J(String str) throws IOException {
        mo1693t0("write a number");
        if (str == null) {
            m1721H0();
        } else if (this.f4530p) {
            m1722I0(str);
        } else {
            mo1642T(str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x00e3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x00de  */
    /* JADX INFO: renamed from: J0 */
    public final void m1723J0(String str) throws IOException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        char[] cArr;
        char c;
        char[] cArr2;
        char c2;
        int i6;
        int length = str.length();
        int i7 = this.f4580D;
        if (length <= i7) {
            if (this.f4579C + length > i7) {
                m1715B0();
            }
            str.getChars(0, length, this.f4577A, this.f4579C);
            int i8 = this.f4567u;
            if (i8 == 0) {
                int i9 = this.f4579C + length;
                int[] iArr = this.f4566t;
                int length2 = iArr.length;
                while (this.f4579C < i9) {
                    do {
                        char[] cArr3 = this.f4577A;
                        int i10 = this.f4579C;
                        char c3 = cArr3[i10];
                        if (c3 >= length2 || iArr[c3] == 0) {
                            i = i10 + 1;
                            this.f4579C = i;
                        } else {
                            int i11 = this.f4578B;
                            int i12 = i10 - i11;
                            if (i12 > 0) {
                                this.f4582y.write(cArr3, i11, i12);
                            }
                            char[] cArr4 = this.f4577A;
                            int i13 = this.f4579C;
                            this.f4579C = i13 + 1;
                            char c4 = cArr4[i13];
                            m1717D0(c4, iArr[c4]);
                        }
                    } while (i < i9);
                    return;
                }
                return;
            }
            int i14 = this.f4579C + length;
            int[] iArr2 = this.f4566t;
            int iMin = Math.min(iArr2.length, i8 + 1);
            while (this.f4579C < i14) {
                do {
                    char[] cArr5 = this.f4577A;
                    int i15 = this.f4579C;
                    char c5 = cArr5[i15];
                    if (c5 < iMin) {
                        i2 = iArr2[c5];
                        if (i2 != 0) {
                            i3 = this.f4578B;
                            i4 = i15 - i3;
                            if (i4 > 0) {
                                this.f4582y.write(cArr5, i3, i4);
                            }
                            this.f4579C++;
                            m1717D0(c5, i2);
                        }
                        i5 = i15 + 1;
                        this.f4579C = i5;
                    } else {
                        if (c5 > i8) {
                            i2 = -1;
                            i3 = this.f4578B;
                            i4 = i15 - i3;
                            if (i4 > 0) {
                                this.f4582y.write(cArr5, i3, i4);
                            }
                            this.f4579C++;
                            m1717D0(c5, i2);
                        }
                        i5 = i15 + 1;
                        this.f4579C = i5;
                    }
                } while (i5 < i14);
                return;
            }
            return;
        }
        m1715B0();
        int length3 = str.length();
        int i16 = 0;
        while (true) {
            int i17 = this.f4580D;
            if (i16 + i17 > length3) {
                i17 = length3 - i16;
            }
            int i18 = i17;
            int i19 = i16 + i18;
            str.getChars(i16, i19, this.f4577A, 0);
            int i20 = this.f4567u;
            if (i20 != 0) {
                int[] iArr3 = this.f4566t;
                int iMin2 = Math.min(iArr3.length, i20 + 1);
                int i21 = 0;
                int i22 = 0;
                int iM1716C0 = 0;
                while (i21 < i18) {
                    while (true) {
                        cArr2 = this.f4577A;
                        c2 = cArr2[i21];
                        if (c2 >= iMin2) {
                            if (c2 > i20) {
                                i6 = -1;
                                break;
                            }
                        } else {
                            i22 = iArr3[c2];
                            if (i22 != 0) {
                            }
                            i6 = i22;
                            break;
                        }
                        i21++;
                        if (i21 >= i18) {
                            i6 = i22;
                            break;
                        }
                    }
                    int i23 = i21 - iM1716C0;
                    if (i23 > 0) {
                        this.f4582y.write(cArr2, iM1716C0, i23);
                        if (i21 >= i18) {
                            break;
                        }
                    }
                    int i24 = i21 + 1;
                    iM1716C0 = m1716C0(this.f4577A, i24, i18, c2, i6);
                    i22 = i6;
                    i21 = i24;
                }
            } else {
                int[] iArr4 = this.f4566t;
                int length4 = iArr4.length;
                int i25 = 0;
                int iM1716C1 = 0;
                while (i25 < i18) {
                    do {
                        cArr = this.f4577A;
                        c = cArr[i25];
                        if (c < length4 && iArr4[c] != 0) {
                            break;
                        } else {
                            i25++;
                        }
                    } while (i25 < i18);
                    int i26 = i25 - iM1716C1;
                    if (i26 > 0) {
                        this.f4582y.write(cArr, iM1716C1, i26);
                        if (i25 >= i18) {
                            break;
                        }
                    }
                    int i27 = i25 + 1;
                    iM1716C1 = m1716C0(this.f4577A, i27, i18, c, iArr4[c]);
                    i25 = i27;
                }
            }
            if (i19 >= length3) {
                return;
            } else {
                i16 = i19;
            }
        }
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: L */
    public void mo1637L(BigDecimal bigDecimal) throws IOException {
        mo1693t0("write a number");
        if (bigDecimal == null) {
            m1721H0();
        } else if (this.f4530p) {
            m1722I0(m1691o0(bigDecimal));
        } else {
            mo1642T(m1691o0(bigDecimal));
        }
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: N */
    public void mo1638N(BigInteger bigInteger) throws IOException {
        mo1693t0("write a number");
        if (bigInteger == null) {
            m1721H0();
        } else if (this.f4530p) {
            m1722I0(bigInteger.toString());
        } else {
            mo1642T(bigInteger.toString());
        }
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: O */
    public void mo1639O(short s2) throws IOException {
        mo1693t0("write a number");
        if (!this.f4530p) {
            if (this.f4579C + 6 >= this.f4580D) {
                m1715B0();
            }
            this.f4579C = C2127g.m1701d(s2, this.f4577A, this.f4579C);
            return;
        }
        if (this.f4579C + 8 >= this.f4580D) {
            m1715B0();
        }
        char[] cArr = this.f4577A;
        int i = this.f4579C;
        int i2 = i + 1;
        this.f4579C = i2;
        cArr[i] = this.f4583z;
        int iM1701d = C2127g.m1701d(s2, cArr, i2);
        this.f4579C = iM1701d;
        char[] cArr2 = this.f4577A;
        this.f4579C = iM1701d + 1;
        cArr2[iM1701d] = this.f4583z;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: R */
    public void mo1640R(char c) throws IOException {
        if (this.f4579C >= this.f4580D) {
            m1715B0();
        }
        char[] cArr = this.f4577A;
        int i = this.f4579C;
        this.f4579C = i + 1;
        cArr[i] = c;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: S */
    public void mo1641S(InterfaceC2115k interfaceC2115k) throws IOException {
        int iMo1689b = interfaceC2115k.mo1689b(this.f4577A, this.f4579C);
        if (iMo1689b < 0) {
            mo1642T(interfaceC2115k.getValue());
        } else {
            this.f4579C += iMo1689b;
        }
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: T */
    public void mo1642T(String str) throws IOException {
        int length = str.length();
        int i = this.f4580D - this.f4579C;
        if (i == 0) {
            m1715B0();
            i = this.f4580D - this.f4579C;
        }
        if (i >= length) {
            str.getChars(0, length, this.f4577A, this.f4579C);
            this.f4579C += length;
            return;
        }
        int i2 = this.f4580D;
        int i3 = this.f4579C;
        int i4 = i2 - i3;
        str.getChars(0, i4, this.f4577A, i3);
        this.f4579C += i4;
        m1715B0();
        int length2 = str.length() - i4;
        while (true) {
            int i5 = this.f4580D;
            if (length2 <= i5) {
                str.getChars(i4, i4 + length2, this.f4577A, 0);
                this.f4578B = 0;
                this.f4579C = length2;
                return;
            } else {
                int i6 = i4 + i5;
                str.getChars(i4, i6, this.f4577A, 0);
                this.f4578B = 0;
                this.f4579C = i5;
                m1715B0();
                length2 -= i5;
                i4 = i6;
            }
        }
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: U */
    public void mo1643U(char[] cArr, int i, int i2) throws IOException {
        if (i2 >= 32) {
            m1715B0();
            this.f4582y.write(cArr, i, i2);
        } else {
            if (i2 > this.f4580D - this.f4579C) {
                m1715B0();
            }
            System.arraycopy(cArr, i, this.f4577A, this.f4579C, i2);
            this.f4579C += i2;
        }
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: W */
    public void mo1645W() throws IOException {
        mo1693t0("start an array");
        this.f4531q = this.f4531q.m1706f();
        InterfaceC2114j interfaceC2114j = this.f4466l;
        if (interfaceC2114j != null) {
            interfaceC2114j.mo1683g(this);
            return;
        }
        if (this.f4579C >= this.f4580D) {
            m1715B0();
        }
        char[] cArr = this.f4577A;
        int i = this.f4579C;
        this.f4579C = i + 1;
        cArr[i] = '[';
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: X */
    public void mo1646X(Object obj) throws IOException {
        mo1693t0("start an array");
        this.f4531q = this.f4531q.m1707g(obj);
        InterfaceC2114j interfaceC2114j = this.f4466l;
        if (interfaceC2114j != null) {
            interfaceC2114j.mo1683g(this);
            return;
        }
        if (this.f4579C >= this.f4580D) {
            m1715B0();
        }
        char[] cArr = this.f4577A;
        int i = this.f4579C;
        this.f4579C = i + 1;
        cArr[i] = '[';
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: b0 */
    public void mo1649b0(Object obj, int i) throws IOException {
        mo1693t0("start an array");
        this.f4531q = this.f4531q.m1707g(obj);
        InterfaceC2114j interfaceC2114j = this.f4466l;
        if (interfaceC2114j != null) {
            interfaceC2114j.mo1683g(this);
            return;
        }
        if (this.f4579C >= this.f4580D) {
            m1715B0();
        }
        char[] cArr = this.f4577A;
        int i2 = this.f4579C;
        this.f4579C = i2 + 1;
        cArr[i2] = '[';
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: c0 */
    public void mo1651c0() throws IOException {
        mo1693t0("start an object");
        this.f4531q = this.f4531q.m1708h();
        InterfaceC2114j interfaceC2114j = this.f4466l;
        if (interfaceC2114j != null) {
            interfaceC2114j.mo1678a(this);
            return;
        }
        if (this.f4579C >= this.f4580D) {
            m1715B0();
        }
        char[] cArr = this.f4577A;
        int i = this.f4579C;
        this.f4579C = i + 1;
        cArr[i] = '{';
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f4577A != null && mo1652d(AbstractC2108d.a.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                C2133c c2133c = this.f4531q;
                if (!c2133c.m1674b()) {
                    if (!c2133c.m1675c()) {
                        break;
                    } else {
                        mo1664u();
                    }
                } else {
                    mo1663t();
                }
            }
        }
        m1715B0();
        this.f4578B = 0;
        this.f4579C = 0;
        if (this.f4582y != null) {
            if (this.f4565s.f4546b || mo1652d(AbstractC2108d.a.AUTO_CLOSE_TARGET)) {
                this.f4582y.close();
            } else if (mo1652d(AbstractC2108d.a.FLUSH_PASSED_TO_STREAM)) {
                this.f4582y.flush();
            }
        }
        char[] cArr = this.f4577A;
        if (cArr != null) {
            this.f4577A = null;
            C2123c c2123c = this.f4565s;
            Objects.requireNonNull(c2123c);
            char[] cArr2 = c2123c.f4549e;
            if (cArr != cArr2 && cArr.length < cArr2.length) {
                throw new IllegalArgumentException("Trying to release buffer smaller than original");
            }
            c2123c.f4549e = null;
            c2123c.f4547c.f4594d.set(1, cArr);
        }
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: d0 */
    public void mo1653d0(Object obj) throws IOException {
        mo1693t0("start an object");
        this.f4531q = this.f4531q.m1709i(obj);
        InterfaceC2114j interfaceC2114j = this.f4466l;
        if (interfaceC2114j != null) {
            interfaceC2114j.mo1678a(this);
            return;
        }
        if (this.f4579C >= this.f4580D) {
            m1715B0();
        }
        char[] cArr = this.f4577A;
        int i = this.f4579C;
        this.f4579C = i + 1;
        cArr[i] = '{';
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: f */
    public int mo1655f(C2105a c2105a, InputStream inputStream, int i) throws IOException {
        mo1693t0("write a binary value");
        if (this.f4579C >= this.f4580D) {
            m1715B0();
        }
        char[] cArr = this.f4577A;
        int i2 = this.f4579C;
        this.f4579C = i2 + 1;
        cArr[i2] = this.f4583z;
        C2123c c2123c = this.f4565s;
        if (c2123c.f4548d != null) {
            throw new IllegalStateException("Trying to call same allocXxx() method second time");
        }
        C2139a c2139a = c2123c.f4547c;
        Objects.requireNonNull(c2139a);
        int i3 = C2139a.f4591a[3];
        if (i3 <= 0) {
            i3 = 0;
        }
        byte[] andSet = c2139a.f4593c.getAndSet(3, null);
        if (andSet == null || andSet.length < i3) {
            andSet = new byte[i3];
        }
        c2123c.f4548d = andSet;
        try {
            if (i < 0) {
                i = m1719F0(c2105a, inputStream, andSet);
            } else {
                int iM1720G0 = m1720G0(c2105a, inputStream, andSet, i);
                if (iM1720G0 > 0) {
                    throw new JsonGenerationException("Too few bytes available: missing " + iM1720G0 + " bytes (out of " + i + ")", this);
                }
            }
            this.f4565s.m1695a(andSet);
            if (this.f4579C >= this.f4580D) {
                m1715B0();
            }
            char[] cArr2 = this.f4577A;
            int i4 = this.f4579C;
            this.f4579C = i4 + 1;
            cArr2[i4] = this.f4583z;
            return i;
        } catch (Throwable th) {
            this.f4565s.m1695a(andSet);
            throw th;
        }
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        m1715B0();
        if (this.f4582y == null || !mo1652d(AbstractC2108d.a.FLUSH_PASSED_TO_STREAM)) {
            return;
        }
        this.f4582y.flush();
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: g0 */
    public void mo1657g0(InterfaceC2115k interfaceC2115k) throws IOException {
        mo1693t0("write a string");
        if (this.f4579C >= this.f4580D) {
            m1715B0();
        }
        char[] cArr = this.f4577A;
        int i = this.f4579C;
        int i2 = i + 1;
        this.f4579C = i2;
        cArr[i] = this.f4583z;
        int iMo1690c = interfaceC2115k.mo1690c(cArr, i2);
        if (iMo1690c >= 0) {
            int i3 = this.f4579C + iMo1690c;
            this.f4579C = i3;
            if (i3 >= this.f4580D) {
                m1715B0();
            }
            char[] cArr2 = this.f4577A;
            int i4 = this.f4579C;
            this.f4579C = i4 + 1;
            cArr2[i4] = this.f4583z;
            return;
        }
        char[] cArrMo1688a = interfaceC2115k.mo1688a();
        int length = cArrMo1688a.length;
        if (length < 32) {
            if (length > this.f4580D - this.f4579C) {
                m1715B0();
            }
            System.arraycopy(cArrMo1688a, 0, this.f4577A, this.f4579C, length);
            this.f4579C += length;
        } else {
            m1715B0();
            this.f4582y.write(cArrMo1688a, 0, length);
        }
        if (this.f4579C >= this.f4580D) {
            m1715B0();
        }
        char[] cArr3 = this.f4577A;
        int i5 = this.f4579C;
        this.f4579C = i5 + 1;
        cArr3[i5] = this.f4583z;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: j0 */
    public void mo1658j0(String str) throws IOException {
        mo1693t0("write a string");
        if (str == null) {
            m1721H0();
            return;
        }
        if (this.f4579C >= this.f4580D) {
            m1715B0();
        }
        char[] cArr = this.f4577A;
        int i = this.f4579C;
        this.f4579C = i + 1;
        cArr[i] = this.f4583z;
        m1723J0(str);
        if (this.f4579C >= this.f4580D) {
            m1715B0();
        }
        char[] cArr2 = this.f4577A;
        int i2 = this.f4579C;
        this.f4579C = i2 + 1;
        cArr2[i2] = this.f4583z;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003c A[PHI: r4
      0x003c: PHI (r4v10 int) = (r4v7 int), (r4v11 int) binds: [B:15:0x0038, B:13:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: m0 */
    public void mo1659m0(char[] cArr, int i, int i2) throws IOException {
        char c;
        mo1693t0("write a string");
        if (this.f4579C >= this.f4580D) {
            m1715B0();
        }
        char[] cArr2 = this.f4577A;
        int i3 = this.f4579C;
        this.f4579C = i3 + 1;
        cArr2[i3] = this.f4583z;
        int i4 = this.f4567u;
        if (i4 != 0) {
            int i5 = i2 + i;
            int[] iArr = this.f4566t;
            int iMin = Math.min(iArr.length, i4 + 1);
            int i6 = 0;
            while (i < i5) {
                int i7 = i;
                do {
                    c = cArr[i7];
                    if (c < iMin) {
                        i6 = iArr[c];
                        if (i6 != 0) {
                            break;
                        } else {
                            i7++;
                        }
                    } else {
                        if (c > i4) {
                            i6 = -1;
                            break;
                        }
                        i7++;
                    }
                } while (i7 < i5);
                int i8 = i7 - i;
                if (i8 < 32) {
                    if (this.f4579C + i8 > this.f4580D) {
                        m1715B0();
                    }
                    if (i8 > 0) {
                        System.arraycopy(cArr, i, this.f4577A, this.f4579C, i8);
                        this.f4579C += i8;
                    }
                } else {
                    m1715B0();
                    this.f4582y.write(cArr, i, i8);
                }
                if (i7 >= i5) {
                    break;
                }
                i = i7 + 1;
                m1714A0(c, i6);
            }
        } else {
            int i9 = i2 + i;
            int[] iArr2 = this.f4566t;
            int length = iArr2.length;
            while (i < i9) {
                int i10 = i;
                do {
                    char c2 = cArr[i10];
                    if (c2 < length && iArr2[c2] != 0) {
                        break;
                    } else {
                        i10++;
                    }
                } while (i10 < i9);
                int i11 = i10 - i;
                if (i11 < 32) {
                    if (this.f4579C + i11 > this.f4580D) {
                        m1715B0();
                    }
                    if (i11 > 0) {
                        System.arraycopy(cArr, i, this.f4577A, this.f4579C, i11);
                        this.f4579C += i11;
                    }
                } else {
                    m1715B0();
                    this.f4582y.write(cArr, i, i11);
                }
                if (i10 >= i9) {
                    break;
                }
                i = i10 + 1;
                char c3 = cArr[i10];
                m1714A0(c3, iArr2[c3]);
            }
        }
        if (this.f4579C >= this.f4580D) {
            m1715B0();
        }
        char[] cArr3 = this.f4577A;
        int i12 = this.f4579C;
        this.f4579C = i12 + 1;
        cArr3[i12] = this.f4583z;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: n */
    public void mo1660n(C2105a c2105a, byte[] bArr, int i, int i2) throws IOException {
        mo1693t0("write a binary value");
        if (this.f4579C >= this.f4580D) {
            m1715B0();
        }
        char[] cArr = this.f4577A;
        int i3 = this.f4579C;
        this.f4579C = i3 + 1;
        cArr[i3] = this.f4583z;
        int i4 = i2 + i;
        int i5 = i4 - 3;
        int i6 = this.f4580D - 6;
        int iM1625d = c2105a.m1625d() >> 2;
        while (i <= i5) {
            if (this.f4579C > i6) {
                m1715B0();
            }
            int i7 = i + 1;
            int i8 = i7 + 1;
            int i9 = ((bArr[i] << 8) | (bArr[i7] & 255)) << 8;
            int i10 = i8 + 1;
            int iM1623b = c2105a.m1623b(i9 | (bArr[i8] & 255), this.f4577A, this.f4579C);
            this.f4579C = iM1623b;
            iM1625d--;
            if (iM1625d <= 0) {
                char[] cArr2 = this.f4577A;
                int i11 = iM1623b + 1;
                this.f4579C = i11;
                cArr2[iM1623b] = '\\';
                this.f4579C = i11 + 1;
                cArr2[i11] = 'n';
                iM1625d = c2105a.m1625d() >> 2;
            }
            i = i10;
        }
        int i12 = i4 - i;
        if (i12 > 0) {
            if (this.f4579C > i6) {
                m1715B0();
            }
            int i13 = i + 1;
            int i14 = bArr[i] << 16;
            if (i12 == 2) {
                i14 |= (bArr[i13] & 255) << 8;
            }
            this.f4579C = c2105a.m1624c(i14, i12, this.f4577A, this.f4579C);
        }
        if (this.f4579C >= this.f4580D) {
            m1715B0();
        }
        char[] cArr3 = this.f4577A;
        int i15 = this.f4579C;
        this.f4579C = i15 + 1;
        cArr3[i15] = this.f4583z;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: s */
    public void mo1662s(boolean z2) throws IOException {
        int i;
        mo1693t0("write a boolean value");
        if (this.f4579C + 5 >= this.f4580D) {
            m1715B0();
        }
        int i2 = this.f4579C;
        char[] cArr = this.f4577A;
        if (z2) {
            cArr[i2] = 't';
            int i3 = i2 + 1;
            cArr[i3] = 'r';
            int i4 = i3 + 1;
            cArr[i4] = 'u';
            i = i4 + 1;
            cArr[i] = 'e';
        } else {
            cArr[i2] = 'f';
            int i5 = i2 + 1;
            cArr[i5] = 'a';
            int i6 = i5 + 1;
            cArr[i6] = 'l';
            int i7 = i6 + 1;
            cArr[i7] = 's';
            i = i7 + 1;
            cArr[i] = 'e';
        }
        this.f4579C = i + 1;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: t */
    public void mo1663t() throws IOException {
        if (!this.f4531q.m1674b()) {
            StringBuilder sbM833U = C1643a.m833U("Current context not Array but ");
            sbM833U.append(this.f4531q.m1677e());
            throw new JsonGenerationException(sbM833U.toString(), this);
        }
        InterfaceC2114j interfaceC2114j = this.f4466l;
        if (interfaceC2114j != null) {
            interfaceC2114j.mo1686j(this, this.f4531q.f4504b + 1);
        } else {
            if (this.f4579C >= this.f4580D) {
                m1715B0();
            }
            char[] cArr = this.f4577A;
            int i = this.f4579C;
            this.f4579C = i + 1;
            cArr[i] = ']';
        }
        C2133c c2133c = this.f4531q;
        c2133c.f4574g = null;
        this.f4531q = c2133c.f4570c;
    }

    @Override // p007b.p195g.p196a.p198b.p199o.AbstractC2119a
    /* JADX INFO: renamed from: t0 */
    public final void mo1693t0(String str) throws IOException {
        char c;
        int iM1713m = this.f4531q.m1713m();
        InterfaceC2114j interfaceC2114j = this.f4466l;
        if (interfaceC2114j == null) {
            if (iM1713m == 1) {
                c = ',';
            } else {
                if (iM1713m != 2) {
                    if (iM1713m != 3) {
                        if (iM1713m != 5) {
                            return;
                        }
                        m1704x0(str);
                        throw null;
                    }
                    InterfaceC2115k interfaceC2115k = this.f4568v;
                    if (interfaceC2115k != null) {
                        mo1642T(interfaceC2115k.getValue());
                        return;
                    }
                    return;
                }
                c = MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR;
            }
            if (this.f4579C >= this.f4580D) {
                m1715B0();
            }
            char[] cArr = this.f4577A;
            int i = this.f4579C;
            this.f4579C = i + 1;
            cArr[i] = c;
            return;
        }
        if (iM1713m == 0) {
            if (this.f4531q.m1674b()) {
                this.f4466l.mo1684h(this);
                return;
            } else {
                if (this.f4531q.m1675c()) {
                    this.f4466l.mo1681d(this);
                    return;
                }
                return;
            }
        }
        if (iM1713m == 1) {
            interfaceC2114j.mo1680c(this);
            return;
        }
        if (iM1713m == 2) {
            interfaceC2114j.mo1687k(this);
            return;
        }
        if (iM1713m == 3) {
            interfaceC2114j.mo1679b(this);
        } else {
            if (iM1713m != 5) {
                int i2 = C2151m.f4617a;
                throw new RuntimeException("Internal error: this code path should never get executed");
            }
            m1704x0(str);
            throw null;
        }
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: u */
    public void mo1664u() throws IOException {
        if (!this.f4531q.m1675c()) {
            StringBuilder sbM833U = C1643a.m833U("Current context not Object but ");
            sbM833U.append(this.f4531q.m1677e());
            throw new JsonGenerationException(sbM833U.toString(), this);
        }
        InterfaceC2114j interfaceC2114j = this.f4466l;
        if (interfaceC2114j != null) {
            interfaceC2114j.mo1682f(this, this.f4531q.f4504b + 1);
        } else {
            if (this.f4579C >= this.f4580D) {
                m1715B0();
            }
            char[] cArr = this.f4577A;
            int i = this.f4579C;
            this.f4579C = i + 1;
            cArr[i] = '}';
        }
        C2133c c2133c = this.f4531q;
        c2133c.f4574g = null;
        this.f4531q = c2133c.f4570c;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: x */
    public void mo1665x(InterfaceC2115k interfaceC2115k) throws IOException {
        int iM1712l = this.f4531q.m1712l(interfaceC2115k.getValue());
        if (iM1712l == 4) {
            throw new JsonGenerationException("Can not write a field name, expecting a value", this);
        }
        boolean z2 = iM1712l == 1;
        InterfaceC2114j interfaceC2114j = this.f4466l;
        if (interfaceC2114j != null) {
            if (z2) {
                interfaceC2114j.mo1685i(this);
            } else {
                interfaceC2114j.mo1681d(this);
            }
            char[] cArrMo1688a = interfaceC2115k.mo1688a();
            if (this.f4569w) {
                mo1643U(cArrMo1688a, 0, cArrMo1688a.length);
                return;
            }
            if (this.f4579C >= this.f4580D) {
                m1715B0();
            }
            char[] cArr = this.f4577A;
            int i = this.f4579C;
            this.f4579C = i + 1;
            cArr[i] = this.f4583z;
            mo1643U(cArrMo1688a, 0, cArrMo1688a.length);
            if (this.f4579C >= this.f4580D) {
                m1715B0();
            }
            char[] cArr2 = this.f4577A;
            int i2 = this.f4579C;
            this.f4579C = i2 + 1;
            cArr2[i2] = this.f4583z;
            return;
        }
        if (this.f4579C + 1 >= this.f4580D) {
            m1715B0();
        }
        if (z2) {
            char[] cArr3 = this.f4577A;
            int i3 = this.f4579C;
            this.f4579C = i3 + 1;
            cArr3[i3] = ',';
        }
        if (this.f4569w) {
            char[] cArrMo1688a2 = interfaceC2115k.mo1688a();
            mo1643U(cArrMo1688a2, 0, cArrMo1688a2.length);
            return;
        }
        char[] cArr4 = this.f4577A;
        int i4 = this.f4579C;
        int i5 = i4 + 1;
        this.f4579C = i5;
        cArr4[i4] = this.f4583z;
        int iMo1690c = interfaceC2115k.mo1690c(cArr4, i5);
        if (iMo1690c < 0) {
            char[] cArrMo1688a3 = interfaceC2115k.mo1688a();
            mo1643U(cArrMo1688a3, 0, cArrMo1688a3.length);
            if (this.f4579C >= this.f4580D) {
                m1715B0();
            }
            char[] cArr5 = this.f4577A;
            int i6 = this.f4579C;
            this.f4579C = i6 + 1;
            cArr5[i6] = this.f4583z;
            return;
        }
        int i7 = this.f4579C + iMo1690c;
        this.f4579C = i7;
        if (i7 >= this.f4580D) {
            m1715B0();
        }
        char[] cArr6 = this.f4577A;
        int i8 = this.f4579C;
        this.f4579C = i8 + 1;
        cArr6[i8] = this.f4583z;
    }

    @Override // p007b.p195g.p196a.p198b.AbstractC2108d
    /* JADX INFO: renamed from: y */
    public void mo1666y(String str) throws IOException {
        int iM1712l = this.f4531q.m1712l(str);
        if (iM1712l == 4) {
            throw new JsonGenerationException("Can not write a field name, expecting a value", this);
        }
        boolean z2 = iM1712l == 1;
        InterfaceC2114j interfaceC2114j = this.f4466l;
        if (interfaceC2114j != null) {
            if (z2) {
                interfaceC2114j.mo1685i(this);
            } else {
                interfaceC2114j.mo1681d(this);
            }
            if (this.f4569w) {
                m1723J0(str);
                return;
            }
            if (this.f4579C >= this.f4580D) {
                m1715B0();
            }
            char[] cArr = this.f4577A;
            int i = this.f4579C;
            this.f4579C = i + 1;
            cArr[i] = this.f4583z;
            m1723J0(str);
            if (this.f4579C >= this.f4580D) {
                m1715B0();
            }
            char[] cArr2 = this.f4577A;
            int i2 = this.f4579C;
            this.f4579C = i2 + 1;
            cArr2[i2] = this.f4583z;
            return;
        }
        if (this.f4579C + 1 >= this.f4580D) {
            m1715B0();
        }
        if (z2) {
            char[] cArr3 = this.f4577A;
            int i3 = this.f4579C;
            this.f4579C = i3 + 1;
            cArr3[i3] = ',';
        }
        if (this.f4569w) {
            m1723J0(str);
            return;
        }
        char[] cArr4 = this.f4577A;
        int i4 = this.f4579C;
        this.f4579C = i4 + 1;
        cArr4[i4] = this.f4583z;
        m1723J0(str);
        if (this.f4579C >= this.f4580D) {
            m1715B0();
        }
        char[] cArr5 = this.f4577A;
        int i5 = this.f4579C;
        this.f4579C = i5 + 1;
        cArr5[i5] = this.f4583z;
    }

    /* JADX INFO: renamed from: z0 */
    public final char[] m1724z0() {
        char[] cArr = {'\\', 0, '\\', 'u', '0', '0', 0, 0, '\\', 'u', 0, 0, 0, 0};
        this.f4581E = cArr;
        return cArr;
    }
}
