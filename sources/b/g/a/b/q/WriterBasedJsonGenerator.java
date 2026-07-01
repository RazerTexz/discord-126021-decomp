package b.g.a.b.q;

import b.d.b.a.outline;
import b.g.a.b.Base64Variant;
import b.g.a.b.JsonGenerator;
import b.g.a.b.ObjectCodec;
import b.g.a.b.PrettyPrinter2;
import b.g.a.b.SerializableString;
import b.g.a.b.p.CharTypes;
import b.g.a.b.p.IOContext;
import b.g.a.b.p.NumberOutput;
import b.g.a.b.t.BufferRecycler;
import b.g.a.b.t.VersionUtil;
import com.discord.widgets.chat.input.MentionUtils;
import com.fasterxml.jackson.core.JsonGenerationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: renamed from: b.g.a.b.q.d, reason: use source file name */
/* JADX INFO: compiled from: WriterBasedJsonGenerator.java */
/* JADX INFO: loaded from: classes3.dex */
public class WriterBasedJsonGenerator extends JsonGeneratorImpl {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final char[] f672x = (char[]) CharTypes.a.clone();
    public char[] A;
    public int B;
    public int C;
    public int D;
    public char[] E;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Writer f673y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public char f674z;

    public WriterBasedJsonGenerator(IOContext iOContext, int i, ObjectCodec objectCodec, Writer writer, char c) {
        int[] iArr;
        super(iOContext, i, objectCodec);
        this.f673y = writer;
        if (iOContext.e != null) {
            throw new IllegalStateException("Trying to call same allocXxx() method second time");
        }
        char[] cArrA = iOContext.c.a(1, 0);
        iOContext.e = cArrA;
        this.A = cArrA;
        this.D = cArrA.length;
        this.f674z = c;
        if (c != '\"') {
            if (c == '\"') {
                iArr = CharTypes.f;
            } else {
                CharTypes.a aVar = CharTypes.a.a;
                int[] iArrCopyOf = aVar.f665b[c];
                if (iArrCopyOf == null) {
                    iArrCopyOf = Arrays.copyOf(CharTypes.f, 128);
                    if (iArrCopyOf[c] == 0) {
                        iArrCopyOf[c] = -1;
                    }
                    aVar.f665b[c] = iArrCopyOf;
                }
                iArr = iArrCopyOf;
            }
            this.t = iArr;
        }
    }

    @Override // b.g.a.b.JsonGenerator
    public void A() throws IOException {
        t0("write a null");
        H0();
    }

    public final void A0(char c, int i) throws IOException {
        int i2;
        if (i >= 0) {
            if (this.C + 2 > this.D) {
                B0();
            }
            char[] cArr = this.A;
            int i3 = this.C;
            int i4 = i3 + 1;
            this.C = i4;
            cArr[i3] = '\\';
            this.C = i4 + 1;
            cArr[i4] = (char) i;
            return;
        }
        if (i == -2) {
            Objects.requireNonNull(null);
            throw null;
        }
        if (this.C + 5 >= this.D) {
            B0();
        }
        int i5 = this.C;
        char[] cArr2 = this.A;
        int i6 = i5 + 1;
        cArr2[i5] = '\\';
        int i7 = i6 + 1;
        cArr2[i6] = 'u';
        if (c > 255) {
            int i8 = 255 & (c >> '\b');
            int i9 = i7 + 1;
            char[] cArr3 = f672x;
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
        char[] cArr4 = f672x;
        cArr2[i2] = cArr4[c >> 4];
        cArr2[i11] = cArr4[c & 15];
        this.C = i11 + 1;
    }

    public void B0() throws IOException {
        int i = this.C;
        int i2 = this.B;
        int i3 = i - i2;
        if (i3 > 0) {
            this.B = 0;
            this.C = 0;
            this.f673y.write(this.A, i2, i3);
        }
    }

    @Override // b.g.a.b.JsonGenerator
    public void C(double d) throws IOException {
        if (!this.p) {
            String str = NumberOutput.a;
            if (!(Double.isNaN(d) || Double.isInfinite(d)) || !d(JsonGenerator.a.QUOTE_NON_NUMERIC_NUMBERS)) {
                t0("write a number");
                T(String.valueOf(d));
                return;
            }
        }
        j0(String.valueOf(d));
    }

    public final int C0(char[] cArr, int i, int i2, char c, int i3) throws IOException {
        int i4;
        if (i3 >= 0) {
            if (i > 1 && i < i2) {
                int i5 = i - 2;
                cArr[i5] = '\\';
                cArr[i5 + 1] = (char) i3;
                return i5;
            }
            char[] cArrZ0 = this.E;
            if (cArrZ0 == null) {
                cArrZ0 = z0();
            }
            cArrZ0[1] = (char) i3;
            this.f673y.write(cArrZ0, 0, 2);
            return i;
        }
        if (i3 == -2) {
            Objects.requireNonNull(null);
            throw null;
        }
        if (i <= 5 || i >= i2) {
            char[] cArrZ1 = this.E;
            if (cArrZ1 == null) {
                cArrZ1 = z0();
            }
            this.B = this.C;
            if (c <= 255) {
                char[] cArr2 = f672x;
                cArrZ1[6] = cArr2[c >> 4];
                cArrZ1[7] = cArr2[c & 15];
                this.f673y.write(cArrZ1, 2, 6);
                return i;
            }
            int i6 = (c >> '\b') & 255;
            int i7 = c & 255;
            char[] cArr3 = f672x;
            cArrZ1[10] = cArr3[i6 >> 4];
            cArrZ1[11] = cArr3[i6 & 15];
            cArrZ1[12] = cArr3[i7 >> 4];
            cArrZ1[13] = cArr3[i7 & 15];
            this.f673y.write(cArrZ1, 8, 6);
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
            char[] cArr4 = f672x;
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
        char[] cArr5 = f672x;
        cArr[i4] = cArr5[c >> 4];
        cArr[i14] = cArr5[c & 15];
        return i14 - 5;
    }

    @Override // b.g.a.b.JsonGenerator
    public void D(float f) throws IOException {
        if (!this.p) {
            String str = NumberOutput.a;
            if (!(Float.isNaN(f) || Float.isInfinite(f)) || !d(JsonGenerator.a.QUOTE_NON_NUMERIC_NUMBERS)) {
                t0("write a number");
                T(String.valueOf(f));
                return;
            }
        }
        j0(String.valueOf(f));
    }

    public final void D0(char c, int i) throws IOException {
        int i2;
        if (i >= 0) {
            int i3 = this.C;
            if (i3 >= 2) {
                int i4 = i3 - 2;
                this.B = i4;
                char[] cArr = this.A;
                cArr[i4] = '\\';
                cArr[i4 + 1] = (char) i;
                return;
            }
            char[] cArrZ0 = this.E;
            if (cArrZ0 == null) {
                cArrZ0 = z0();
            }
            this.B = this.C;
            cArrZ0[1] = (char) i;
            this.f673y.write(cArrZ0, 0, 2);
            return;
        }
        if (i == -2) {
            Objects.requireNonNull(null);
            throw null;
        }
        int i5 = this.C;
        if (i5 < 6) {
            char[] cArrZ1 = this.E;
            if (cArrZ1 == null) {
                cArrZ1 = z0();
            }
            this.B = this.C;
            if (c <= 255) {
                char[] cArr2 = f672x;
                cArrZ1[6] = cArr2[c >> 4];
                cArrZ1[7] = cArr2[c & 15];
                this.f673y.write(cArrZ1, 2, 6);
                return;
            }
            int i6 = (c >> '\b') & 255;
            int i7 = c & 255;
            char[] cArr3 = f672x;
            cArrZ1[10] = cArr3[i6 >> 4];
            cArrZ1[11] = cArr3[i6 & 15];
            cArrZ1[12] = cArr3[i7 >> 4];
            cArrZ1[13] = cArr3[i7 & 15];
            this.f673y.write(cArrZ1, 8, 6);
            return;
        }
        char[] cArr4 = this.A;
        int i8 = i5 - 6;
        this.B = i8;
        cArr4[i8] = '\\';
        int i9 = i8 + 1;
        cArr4[i9] = 'u';
        if (c > 255) {
            int i10 = (c >> '\b') & 255;
            int i11 = i9 + 1;
            char[] cArr5 = f672x;
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
        char[] cArr6 = f672x;
        cArr4[i13] = cArr6[c >> 4];
        cArr4[i13 + 1] = cArr6[c & 15];
    }

    public final int E0(InputStream inputStream, byte[] bArr, int i, int i2, int i3) throws IOException {
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

    public final int F0(Base64Variant base64Variant, InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.D - 6;
        int i2 = 2;
        int iD = base64Variant.d() >> 2;
        int i3 = -3;
        int i4 = 0;
        int iE0 = 0;
        int i5 = 0;
        while (true) {
            if (i4 > i3) {
                iE0 = E0(inputStream, bArr, i4, iE0, bArr.length);
                if (iE0 < 3) {
                    break;
                }
                i3 = iE0 - 3;
                i4 = 0;
            }
            if (this.C > i) {
                B0();
            }
            int i6 = i4 + 1;
            int i7 = bArr[i4] << 8;
            int i8 = i6 + 1;
            i4 = i8 + 1;
            i5 += 3;
            int iB = base64Variant.b((((bArr[i6] & 255) | i7) << 8) | (bArr[i8] & 255), this.A, this.C);
            this.C = iB;
            iD--;
            if (iD <= 0) {
                char[] cArr = this.A;
                int i9 = iB + 1;
                this.C = i9;
                cArr[iB] = '\\';
                this.C = i9 + 1;
                cArr[i9] = 'n';
                iD = base64Variant.d() >> 2;
            }
        }
        if (iE0 <= 0) {
            return i5;
        }
        if (this.C > i) {
            B0();
        }
        int i10 = bArr[0] << 16;
        if (1 < iE0) {
            i10 |= (bArr[1] & 255) << 8;
        } else {
            i2 = 1;
        }
        int i11 = i5 + i2;
        this.C = base64Variant.c(i10, i2, this.A, this.C);
        return i11;
    }

    public final int G0(Base64Variant base64Variant, InputStream inputStream, byte[] bArr, int i) throws IOException {
        int iE0;
        int i2 = this.D - 6;
        int i3 = 2;
        int iD = base64Variant.d() >> 2;
        int i4 = -3;
        int i5 = 0;
        int iE1 = 0;
        while (i > 2) {
            if (i5 > i4) {
                iE1 = E0(inputStream, bArr, i5, iE1, i);
                if (iE1 < 3) {
                    i5 = 0;
                    break;
                }
                i4 = iE1 - 3;
                i5 = 0;
            }
            if (this.C > i2) {
                B0();
            }
            int i6 = i5 + 1;
            int i7 = bArr[i5] << 8;
            int i8 = i6 + 1;
            i5 = i8 + 1;
            i -= 3;
            int iB = base64Variant.b((((bArr[i6] & 255) | i7) << 8) | (bArr[i8] & 255), this.A, this.C);
            this.C = iB;
            iD--;
            if (iD <= 0) {
                char[] cArr = this.A;
                int i9 = iB + 1;
                this.C = i9;
                cArr[iB] = '\\';
                this.C = i9 + 1;
                cArr[i9] = 'n';
                iD = base64Variant.d() >> 2;
            }
        }
        if (i <= 0 || (iE0 = E0(inputStream, bArr, i5, iE1, i)) <= 0) {
            return i;
        }
        if (this.C > i2) {
            B0();
        }
        int i10 = bArr[0] << 16;
        if (1 < iE0) {
            i10 |= (bArr[1] & 255) << 8;
        } else {
            i3 = 1;
        }
        this.C = base64Variant.c(i10, i3, this.A, this.C);
        return i - i3;
    }

    @Override // b.g.a.b.JsonGenerator
    public void H(int i) throws IOException {
        t0("write a number");
        if (!this.p) {
            if (this.C + 11 >= this.D) {
                B0();
            }
            this.C = NumberOutput.d(i, this.A, this.C);
            return;
        }
        if (this.C + 13 >= this.D) {
            B0();
        }
        char[] cArr = this.A;
        int i2 = this.C;
        int i3 = i2 + 1;
        this.C = i3;
        cArr[i2] = this.f674z;
        int iD = NumberOutput.d(i, cArr, i3);
        this.C = iD;
        char[] cArr2 = this.A;
        this.C = iD + 1;
        cArr2[iD] = this.f674z;
    }

    public final void H0() throws IOException {
        if (this.C + 4 >= this.D) {
            B0();
        }
        int i = this.C;
        char[] cArr = this.A;
        cArr[i] = 'n';
        int i2 = i + 1;
        cArr[i2] = 'u';
        int i3 = i2 + 1;
        cArr[i3] = 'l';
        int i4 = i3 + 1;
        cArr[i4] = 'l';
        this.C = i4 + 1;
    }

    @Override // b.g.a.b.JsonGenerator
    public void I(long j) throws IOException {
        t0("write a number");
        if (!this.p) {
            if (this.C + 21 >= this.D) {
                B0();
            }
            this.C = NumberOutput.e(j, this.A, this.C);
            return;
        }
        if (this.C + 23 >= this.D) {
            B0();
        }
        char[] cArr = this.A;
        int i = this.C;
        int i2 = i + 1;
        this.C = i2;
        cArr[i] = this.f674z;
        int iE = NumberOutput.e(j, cArr, i2);
        this.C = iE;
        char[] cArr2 = this.A;
        this.C = iE + 1;
        cArr2[iE] = this.f674z;
    }

    public final void I0(String str) throws IOException {
        if (this.C >= this.D) {
            B0();
        }
        char[] cArr = this.A;
        int i = this.C;
        this.C = i + 1;
        cArr[i] = this.f674z;
        T(str);
        if (this.C >= this.D) {
            B0();
        }
        char[] cArr2 = this.A;
        int i2 = this.C;
        this.C = i2 + 1;
        cArr2[i2] = this.f674z;
    }

    @Override // b.g.a.b.JsonGenerator
    public void J(String str) throws IOException {
        t0("write a number");
        if (str == null) {
            H0();
        } else if (this.p) {
            I0(str);
        } else {
            T(str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x00e3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x00de  */
    public final void J0(String str) throws IOException {
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
        int i7 = this.D;
        if (length <= i7) {
            if (this.C + length > i7) {
                B0();
            }
            str.getChars(0, length, this.A, this.C);
            int i8 = this.u;
            if (i8 == 0) {
                int i9 = this.C + length;
                int[] iArr = this.t;
                int length2 = iArr.length;
                while (this.C < i9) {
                    do {
                        char[] cArr3 = this.A;
                        int i10 = this.C;
                        char c3 = cArr3[i10];
                        if (c3 >= length2 || iArr[c3] == 0) {
                            i = i10 + 1;
                            this.C = i;
                        } else {
                            int i11 = this.B;
                            int i12 = i10 - i11;
                            if (i12 > 0) {
                                this.f673y.write(cArr3, i11, i12);
                            }
                            char[] cArr4 = this.A;
                            int i13 = this.C;
                            this.C = i13 + 1;
                            char c4 = cArr4[i13];
                            D0(c4, iArr[c4]);
                        }
                    } while (i < i9);
                    return;
                }
                return;
            }
            int i14 = this.C + length;
            int[] iArr2 = this.t;
            int iMin = Math.min(iArr2.length, i8 + 1);
            while (this.C < i14) {
                do {
                    char[] cArr5 = this.A;
                    int i15 = this.C;
                    char c5 = cArr5[i15];
                    if (c5 < iMin) {
                        i2 = iArr2[c5];
                        if (i2 != 0) {
                            i3 = this.B;
                            i4 = i15 - i3;
                            if (i4 > 0) {
                                this.f673y.write(cArr5, i3, i4);
                            }
                            this.C++;
                            D0(c5, i2);
                        }
                        i5 = i15 + 1;
                        this.C = i5;
                    } else {
                        if (c5 > i8) {
                            i2 = -1;
                            i3 = this.B;
                            i4 = i15 - i3;
                            if (i4 > 0) {
                                this.f673y.write(cArr5, i3, i4);
                            }
                            this.C++;
                            D0(c5, i2);
                        }
                        i5 = i15 + 1;
                        this.C = i5;
                    }
                } while (i5 < i14);
                return;
            }
            return;
        }
        B0();
        int length3 = str.length();
        int i16 = 0;
        while (true) {
            int i17 = this.D;
            if (i16 + i17 > length3) {
                i17 = length3 - i16;
            }
            int i18 = i17;
            int i19 = i16 + i18;
            str.getChars(i16, i19, this.A, 0);
            int i20 = this.u;
            if (i20 != 0) {
                int[] iArr3 = this.t;
                int iMin2 = Math.min(iArr3.length, i20 + 1);
                int i21 = 0;
                int i22 = 0;
                int iC0 = 0;
                while (i21 < i18) {
                    while (true) {
                        cArr2 = this.A;
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
                    int i23 = i21 - iC0;
                    if (i23 > 0) {
                        this.f673y.write(cArr2, iC0, i23);
                        if (i21 >= i18) {
                            break;
                        }
                    }
                    int i24 = i21 + 1;
                    iC0 = C0(this.A, i24, i18, c2, i6);
                    i22 = i6;
                    i21 = i24;
                }
            } else {
                int[] iArr4 = this.t;
                int length4 = iArr4.length;
                int i25 = 0;
                int iC1 = 0;
                while (i25 < i18) {
                    do {
                        cArr = this.A;
                        c = cArr[i25];
                        if (c < length4 && iArr4[c] != 0) {
                            break;
                        } else {
                            i25++;
                        }
                    } while (i25 < i18);
                    int i26 = i25 - iC1;
                    if (i26 > 0) {
                        this.f673y.write(cArr, iC1, i26);
                        if (i25 >= i18) {
                            break;
                        }
                    }
                    int i27 = i25 + 1;
                    iC1 = C0(this.A, i27, i18, c, iArr4[c]);
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

    @Override // b.g.a.b.JsonGenerator
    public void L(BigDecimal bigDecimal) throws IOException {
        t0("write a number");
        if (bigDecimal == null) {
            H0();
        } else if (this.p) {
            I0(o0(bigDecimal));
        } else {
            T(o0(bigDecimal));
        }
    }

    @Override // b.g.a.b.JsonGenerator
    public void N(BigInteger bigInteger) throws IOException {
        t0("write a number");
        if (bigInteger == null) {
            H0();
        } else if (this.p) {
            I0(bigInteger.toString());
        } else {
            T(bigInteger.toString());
        }
    }

    @Override // b.g.a.b.JsonGenerator
    public void O(short s2) throws IOException {
        t0("write a number");
        if (!this.p) {
            if (this.C + 6 >= this.D) {
                B0();
            }
            this.C = NumberOutput.d(s2, this.A, this.C);
            return;
        }
        if (this.C + 8 >= this.D) {
            B0();
        }
        char[] cArr = this.A;
        int i = this.C;
        int i2 = i + 1;
        this.C = i2;
        cArr[i] = this.f674z;
        int iD = NumberOutput.d(s2, cArr, i2);
        this.C = iD;
        char[] cArr2 = this.A;
        this.C = iD + 1;
        cArr2[iD] = this.f674z;
    }

    @Override // b.g.a.b.JsonGenerator
    public void R(char c) throws IOException {
        if (this.C >= this.D) {
            B0();
        }
        char[] cArr = this.A;
        int i = this.C;
        this.C = i + 1;
        cArr[i] = c;
    }

    @Override // b.g.a.b.JsonGenerator
    public void S(SerializableString serializableString) throws IOException {
        int iB = serializableString.b(this.A, this.C);
        if (iB < 0) {
            T(serializableString.getValue());
        } else {
            this.C += iB;
        }
    }

    @Override // b.g.a.b.JsonGenerator
    public void T(String str) throws IOException {
        int length = str.length();
        int i = this.D - this.C;
        if (i == 0) {
            B0();
            i = this.D - this.C;
        }
        if (i >= length) {
            str.getChars(0, length, this.A, this.C);
            this.C += length;
            return;
        }
        int i2 = this.D;
        int i3 = this.C;
        int i4 = i2 - i3;
        str.getChars(0, i4, this.A, i3);
        this.C += i4;
        B0();
        int length2 = str.length() - i4;
        while (true) {
            int i5 = this.D;
            if (length2 <= i5) {
                str.getChars(i4, i4 + length2, this.A, 0);
                this.B = 0;
                this.C = length2;
                return;
            } else {
                int i6 = i4 + i5;
                str.getChars(i4, i6, this.A, 0);
                this.B = 0;
                this.C = i5;
                B0();
                length2 -= i5;
                i4 = i6;
            }
        }
    }

    @Override // b.g.a.b.JsonGenerator
    public void U(char[] cArr, int i, int i2) throws IOException {
        if (i2 >= 32) {
            B0();
            this.f673y.write(cArr, i, i2);
        } else {
            if (i2 > this.D - this.C) {
                B0();
            }
            System.arraycopy(cArr, i, this.A, this.C, i2);
            this.C += i2;
        }
    }

    @Override // b.g.a.b.JsonGenerator
    public void W() throws IOException {
        t0("start an array");
        this.q = this.q.f();
        PrettyPrinter2 prettyPrinter2 = this.l;
        if (prettyPrinter2 != null) {
            prettyPrinter2.g(this);
            return;
        }
        if (this.C >= this.D) {
            B0();
        }
        char[] cArr = this.A;
        int i = this.C;
        this.C = i + 1;
        cArr[i] = '[';
    }

    @Override // b.g.a.b.JsonGenerator
    public void X(Object obj) throws IOException {
        t0("start an array");
        this.q = this.q.g(obj);
        PrettyPrinter2 prettyPrinter2 = this.l;
        if (prettyPrinter2 != null) {
            prettyPrinter2.g(this);
            return;
        }
        if (this.C >= this.D) {
            B0();
        }
        char[] cArr = this.A;
        int i = this.C;
        this.C = i + 1;
        cArr[i] = '[';
    }

    @Override // b.g.a.b.JsonGenerator
    public void b0(Object obj, int i) throws IOException {
        t0("start an array");
        this.q = this.q.g(obj);
        PrettyPrinter2 prettyPrinter2 = this.l;
        if (prettyPrinter2 != null) {
            prettyPrinter2.g(this);
            return;
        }
        if (this.C >= this.D) {
            B0();
        }
        char[] cArr = this.A;
        int i2 = this.C;
        this.C = i2 + 1;
        cArr[i2] = '[';
    }

    @Override // b.g.a.b.JsonGenerator
    public void c0() throws IOException {
        t0("start an object");
        this.q = this.q.h();
        PrettyPrinter2 prettyPrinter2 = this.l;
        if (prettyPrinter2 != null) {
            prettyPrinter2.a(this);
            return;
        }
        if (this.C >= this.D) {
            B0();
        }
        char[] cArr = this.A;
        int i = this.C;
        this.C = i + 1;
        cArr[i] = '{';
    }

    @Override // b.g.a.b.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.A != null && d(JsonGenerator.a.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                JsonWriteContext jsonWriteContext = this.q;
                if (!jsonWriteContext.b()) {
                    if (!jsonWriteContext.c()) {
                        break;
                    } else {
                        u();
                    }
                } else {
                    t();
                }
            }
        }
        B0();
        this.B = 0;
        this.C = 0;
        if (this.f673y != null) {
            if (this.f671s.f666b || d(JsonGenerator.a.AUTO_CLOSE_TARGET)) {
                this.f673y.close();
            } else if (d(JsonGenerator.a.FLUSH_PASSED_TO_STREAM)) {
                this.f673y.flush();
            }
        }
        char[] cArr = this.A;
        if (cArr != null) {
            this.A = null;
            IOContext iOContext = this.f671s;
            Objects.requireNonNull(iOContext);
            char[] cArr2 = iOContext.e;
            if (cArr != cArr2 && cArr.length < cArr2.length) {
                throw new IllegalArgumentException("Trying to release buffer smaller than original");
            }
            iOContext.e = null;
            iOContext.c.d.set(1, cArr);
        }
    }

    @Override // b.g.a.b.JsonGenerator
    public void d0(Object obj) throws IOException {
        t0("start an object");
        this.q = this.q.i(obj);
        PrettyPrinter2 prettyPrinter2 = this.l;
        if (prettyPrinter2 != null) {
            prettyPrinter2.a(this);
            return;
        }
        if (this.C >= this.D) {
            B0();
        }
        char[] cArr = this.A;
        int i = this.C;
        this.C = i + 1;
        cArr[i] = '{';
    }

    @Override // b.g.a.b.JsonGenerator
    public int f(Base64Variant base64Variant, InputStream inputStream, int i) throws IOException {
        t0("write a binary value");
        if (this.C >= this.D) {
            B0();
        }
        char[] cArr = this.A;
        int i2 = this.C;
        this.C = i2 + 1;
        cArr[i2] = this.f674z;
        IOContext iOContext = this.f671s;
        if (iOContext.d != null) {
            throw new IllegalStateException("Trying to call same allocXxx() method second time");
        }
        BufferRecycler bufferRecycler = iOContext.c;
        Objects.requireNonNull(bufferRecycler);
        int i3 = BufferRecycler.a[3];
        if (i3 <= 0) {
            i3 = 0;
        }
        byte[] andSet = bufferRecycler.c.getAndSet(3, null);
        if (andSet == null || andSet.length < i3) {
            andSet = new byte[i3];
        }
        iOContext.d = andSet;
        try {
            if (i < 0) {
                i = F0(base64Variant, inputStream, andSet);
            } else {
                int iG0 = G0(base64Variant, inputStream, andSet, i);
                if (iG0 > 0) {
                    throw new JsonGenerationException("Too few bytes available: missing " + iG0 + " bytes (out of " + i + ")", this);
                }
            }
            this.f671s.a(andSet);
            if (this.C >= this.D) {
                B0();
            }
            char[] cArr2 = this.A;
            int i4 = this.C;
            this.C = i4 + 1;
            cArr2[i4] = this.f674z;
            return i;
        } catch (Throwable th) {
            this.f671s.a(andSet);
            throw th;
        }
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        B0();
        if (this.f673y == null || !d(JsonGenerator.a.FLUSH_PASSED_TO_STREAM)) {
            return;
        }
        this.f673y.flush();
    }

    @Override // b.g.a.b.JsonGenerator
    public void g0(SerializableString serializableString) throws IOException {
        t0("write a string");
        if (this.C >= this.D) {
            B0();
        }
        char[] cArr = this.A;
        int i = this.C;
        int i2 = i + 1;
        this.C = i2;
        cArr[i] = this.f674z;
        int iC = serializableString.c(cArr, i2);
        if (iC >= 0) {
            int i3 = this.C + iC;
            this.C = i3;
            if (i3 >= this.D) {
                B0();
            }
            char[] cArr2 = this.A;
            int i4 = this.C;
            this.C = i4 + 1;
            cArr2[i4] = this.f674z;
            return;
        }
        char[] cArrA = serializableString.a();
        int length = cArrA.length;
        if (length < 32) {
            if (length > this.D - this.C) {
                B0();
            }
            System.arraycopy(cArrA, 0, this.A, this.C, length);
            this.C += length;
        } else {
            B0();
            this.f673y.write(cArrA, 0, length);
        }
        if (this.C >= this.D) {
            B0();
        }
        char[] cArr3 = this.A;
        int i5 = this.C;
        this.C = i5 + 1;
        cArr3[i5] = this.f674z;
    }

    @Override // b.g.a.b.JsonGenerator
    public void j0(String str) throws IOException {
        t0("write a string");
        if (str == null) {
            H0();
            return;
        }
        if (this.C >= this.D) {
            B0();
        }
        char[] cArr = this.A;
        int i = this.C;
        this.C = i + 1;
        cArr[i] = this.f674z;
        J0(str);
        if (this.C >= this.D) {
            B0();
        }
        char[] cArr2 = this.A;
        int i2 = this.C;
        this.C = i2 + 1;
        cArr2[i2] = this.f674z;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003c A[PHI: r4
      0x003c: PHI (r4v10 int) = (r4v7 int), (r4v11 int) binds: [B:15:0x0038, B:13:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // b.g.a.b.JsonGenerator
    public void m0(char[] cArr, int i, int i2) throws IOException {
        char c;
        t0("write a string");
        if (this.C >= this.D) {
            B0();
        }
        char[] cArr2 = this.A;
        int i3 = this.C;
        this.C = i3 + 1;
        cArr2[i3] = this.f674z;
        int i4 = this.u;
        if (i4 != 0) {
            int i5 = i2 + i;
            int[] iArr = this.t;
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
                    if (this.C + i8 > this.D) {
                        B0();
                    }
                    if (i8 > 0) {
                        System.arraycopy(cArr, i, this.A, this.C, i8);
                        this.C += i8;
                    }
                } else {
                    B0();
                    this.f673y.write(cArr, i, i8);
                }
                if (i7 >= i5) {
                    break;
                }
                i = i7 + 1;
                A0(c, i6);
            }
        } else {
            int i9 = i2 + i;
            int[] iArr2 = this.t;
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
                    if (this.C + i11 > this.D) {
                        B0();
                    }
                    if (i11 > 0) {
                        System.arraycopy(cArr, i, this.A, this.C, i11);
                        this.C += i11;
                    }
                } else {
                    B0();
                    this.f673y.write(cArr, i, i11);
                }
                if (i10 >= i9) {
                    break;
                }
                i = i10 + 1;
                char c3 = cArr[i10];
                A0(c3, iArr2[c3]);
            }
        }
        if (this.C >= this.D) {
            B0();
        }
        char[] cArr3 = this.A;
        int i12 = this.C;
        this.C = i12 + 1;
        cArr3[i12] = this.f674z;
    }

    @Override // b.g.a.b.JsonGenerator
    public void n(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException {
        t0("write a binary value");
        if (this.C >= this.D) {
            B0();
        }
        char[] cArr = this.A;
        int i3 = this.C;
        this.C = i3 + 1;
        cArr[i3] = this.f674z;
        int i4 = i2 + i;
        int i5 = i4 - 3;
        int i6 = this.D - 6;
        int iD = base64Variant.d() >> 2;
        while (i <= i5) {
            if (this.C > i6) {
                B0();
            }
            int i7 = i + 1;
            int i8 = i7 + 1;
            int i9 = ((bArr[i] << 8) | (bArr[i7] & 255)) << 8;
            int i10 = i8 + 1;
            int iB = base64Variant.b(i9 | (bArr[i8] & 255), this.A, this.C);
            this.C = iB;
            iD--;
            if (iD <= 0) {
                char[] cArr2 = this.A;
                int i11 = iB + 1;
                this.C = i11;
                cArr2[iB] = '\\';
                this.C = i11 + 1;
                cArr2[i11] = 'n';
                iD = base64Variant.d() >> 2;
            }
            i = i10;
        }
        int i12 = i4 - i;
        if (i12 > 0) {
            if (this.C > i6) {
                B0();
            }
            int i13 = i + 1;
            int i14 = bArr[i] << 16;
            if (i12 == 2) {
                i14 |= (bArr[i13] & 255) << 8;
            }
            this.C = base64Variant.c(i14, i12, this.A, this.C);
        }
        if (this.C >= this.D) {
            B0();
        }
        char[] cArr3 = this.A;
        int i15 = this.C;
        this.C = i15 + 1;
        cArr3[i15] = this.f674z;
    }

    @Override // b.g.a.b.JsonGenerator
    public void s(boolean z2) throws IOException {
        int i;
        t0("write a boolean value");
        if (this.C + 5 >= this.D) {
            B0();
        }
        int i2 = this.C;
        char[] cArr = this.A;
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
        this.C = i + 1;
    }

    @Override // b.g.a.b.JsonGenerator
    public void t() throws IOException {
        if (!this.q.b()) {
            StringBuilder sbU = outline.U("Current context not Array but ");
            sbU.append(this.q.e());
            throw new JsonGenerationException(sbU.toString(), this);
        }
        PrettyPrinter2 prettyPrinter2 = this.l;
        if (prettyPrinter2 != null) {
            prettyPrinter2.j(this, this.q.f661b + 1);
        } else {
            if (this.C >= this.D) {
                B0();
            }
            char[] cArr = this.A;
            int i = this.C;
            this.C = i + 1;
            cArr[i] = ']';
        }
        JsonWriteContext jsonWriteContext = this.q;
        jsonWriteContext.g = null;
        this.q = jsonWriteContext.c;
    }

    @Override // b.g.a.b.o.GeneratorBase
    public final void t0(String str) throws IOException {
        char c;
        int iM = this.q.m();
        PrettyPrinter2 prettyPrinter2 = this.l;
        if (prettyPrinter2 == null) {
            if (iM == 1) {
                c = ',';
            } else {
                if (iM != 2) {
                    if (iM != 3) {
                        if (iM != 5) {
                            return;
                        }
                        x0(str);
                        throw null;
                    }
                    SerializableString serializableString = this.v;
                    if (serializableString != null) {
                        T(serializableString.getValue());
                        return;
                    }
                    return;
                }
                c = MentionUtils.EMOJIS_AND_STICKERS_CHAR;
            }
            if (this.C >= this.D) {
                B0();
            }
            char[] cArr = this.A;
            int i = this.C;
            this.C = i + 1;
            cArr[i] = c;
            return;
        }
        if (iM == 0) {
            if (this.q.b()) {
                this.l.h(this);
                return;
            } else {
                if (this.q.c()) {
                    this.l.d(this);
                    return;
                }
                return;
            }
        }
        if (iM == 1) {
            prettyPrinter2.c(this);
            return;
        }
        if (iM == 2) {
            prettyPrinter2.k(this);
            return;
        }
        if (iM == 3) {
            prettyPrinter2.b(this);
        } else {
            if (iM != 5) {
                int i2 = VersionUtil.a;
                throw new RuntimeException("Internal error: this code path should never get executed");
            }
            x0(str);
            throw null;
        }
    }

    @Override // b.g.a.b.JsonGenerator
    public void u() throws IOException {
        if (!this.q.c()) {
            StringBuilder sbU = outline.U("Current context not Object but ");
            sbU.append(this.q.e());
            throw new JsonGenerationException(sbU.toString(), this);
        }
        PrettyPrinter2 prettyPrinter2 = this.l;
        if (prettyPrinter2 != null) {
            prettyPrinter2.f(this, this.q.f661b + 1);
        } else {
            if (this.C >= this.D) {
                B0();
            }
            char[] cArr = this.A;
            int i = this.C;
            this.C = i + 1;
            cArr[i] = '}';
        }
        JsonWriteContext jsonWriteContext = this.q;
        jsonWriteContext.g = null;
        this.q = jsonWriteContext.c;
    }

    @Override // b.g.a.b.JsonGenerator
    public void x(SerializableString serializableString) throws IOException {
        int iL = this.q.l(serializableString.getValue());
        if (iL == 4) {
            throw new JsonGenerationException("Can not write a field name, expecting a value", this);
        }
        boolean z2 = iL == 1;
        PrettyPrinter2 prettyPrinter2 = this.l;
        if (prettyPrinter2 != null) {
            if (z2) {
                prettyPrinter2.i(this);
            } else {
                prettyPrinter2.d(this);
            }
            char[] cArrA = serializableString.a();
            if (this.w) {
                U(cArrA, 0, cArrA.length);
                return;
            }
            if (this.C >= this.D) {
                B0();
            }
            char[] cArr = this.A;
            int i = this.C;
            this.C = i + 1;
            cArr[i] = this.f674z;
            U(cArrA, 0, cArrA.length);
            if (this.C >= this.D) {
                B0();
            }
            char[] cArr2 = this.A;
            int i2 = this.C;
            this.C = i2 + 1;
            cArr2[i2] = this.f674z;
            return;
        }
        if (this.C + 1 >= this.D) {
            B0();
        }
        if (z2) {
            char[] cArr3 = this.A;
            int i3 = this.C;
            this.C = i3 + 1;
            cArr3[i3] = ',';
        }
        if (this.w) {
            char[] cArrA2 = serializableString.a();
            U(cArrA2, 0, cArrA2.length);
            return;
        }
        char[] cArr4 = this.A;
        int i4 = this.C;
        int i5 = i4 + 1;
        this.C = i5;
        cArr4[i4] = this.f674z;
        int iC = serializableString.c(cArr4, i5);
        if (iC < 0) {
            char[] cArrA3 = serializableString.a();
            U(cArrA3, 0, cArrA3.length);
            if (this.C >= this.D) {
                B0();
            }
            char[] cArr5 = this.A;
            int i6 = this.C;
            this.C = i6 + 1;
            cArr5[i6] = this.f674z;
            return;
        }
        int i7 = this.C + iC;
        this.C = i7;
        if (i7 >= this.D) {
            B0();
        }
        char[] cArr6 = this.A;
        int i8 = this.C;
        this.C = i8 + 1;
        cArr6[i8] = this.f674z;
    }

    @Override // b.g.a.b.JsonGenerator
    public void y(String str) throws IOException {
        int iL = this.q.l(str);
        if (iL == 4) {
            throw new JsonGenerationException("Can not write a field name, expecting a value", this);
        }
        boolean z2 = iL == 1;
        PrettyPrinter2 prettyPrinter2 = this.l;
        if (prettyPrinter2 != null) {
            if (z2) {
                prettyPrinter2.i(this);
            } else {
                prettyPrinter2.d(this);
            }
            if (this.w) {
                J0(str);
                return;
            }
            if (this.C >= this.D) {
                B0();
            }
            char[] cArr = this.A;
            int i = this.C;
            this.C = i + 1;
            cArr[i] = this.f674z;
            J0(str);
            if (this.C >= this.D) {
                B0();
            }
            char[] cArr2 = this.A;
            int i2 = this.C;
            this.C = i2 + 1;
            cArr2[i2] = this.f674z;
            return;
        }
        if (this.C + 1 >= this.D) {
            B0();
        }
        if (z2) {
            char[] cArr3 = this.A;
            int i3 = this.C;
            this.C = i3 + 1;
            cArr3[i3] = ',';
        }
        if (this.w) {
            J0(str);
            return;
        }
        char[] cArr4 = this.A;
        int i4 = this.C;
        this.C = i4 + 1;
        cArr4[i4] = this.f674z;
        J0(str);
        if (this.C >= this.D) {
            B0();
        }
        char[] cArr5 = this.A;
        int i5 = this.C;
        this.C = i5 + 1;
        cArr5[i5] = this.f674z;
    }

    public final char[] z0() {
        char[] cArr = {'\\', 0, '\\', 'u', '0', '0', 0, 0, '\\', 'u', 0, 0, 0, 0};
        this.E = cArr;
        return cArr;
    }
}
