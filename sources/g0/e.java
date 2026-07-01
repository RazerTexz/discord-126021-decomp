package g0;

import androidx.recyclerview.widget.RecyclerView;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.util.Objects;
import okio.BufferedSink;
import okio.ByteString;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements g, BufferedSink, Cloneable, ByteChannel {
    public s j;
    public long k;

    public String A(long j, Charset charset) throws EOFException {
        d0.z.d.m.checkParameterIsNotNull(charset, "charset");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(b.d.b.a.a.t("byteCount: ", j).toString());
        }
        if (this.k < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        s sVar = this.j;
        if (sVar == null) {
            d0.z.d.m.throwNpe();
        }
        int i = sVar.f3693b;
        if (((long) i) + j > sVar.c) {
            return new String(Z(j), charset);
        }
        int i2 = (int) j;
        String str = new String(sVar.a, i, i2, charset);
        int i3 = sVar.f3693b + i2;
        sVar.f3693b = i3;
        this.k -= j;
        if (i3 == sVar.c) {
            this.j = sVar.a();
            t.a(sVar);
        }
        return str;
    }

    @Override // g0.g
    public void B(e eVar, long j) throws EOFException {
        d0.z.d.m.checkParameterIsNotNull(eVar, "sink");
        long j2 = this.k;
        if (j2 >= j) {
            eVar.write(this, j);
        } else {
            eVar.write(this, j2);
            throw new EOFException();
        }
    }

    public String D() {
        return A(this.k, d0.g0.c.a);
    }

    @Override // g0.g
    public long E(ByteString byteString) {
        d0.z.d.m.checkParameterIsNotNull(byteString, "targetBytes");
        return t(byteString, 0L);
    }

    @Override // okio.BufferedSink
    public BufferedSink F() {
        return this;
    }

    @Override // g0.g
    public String G(long j) throws EOFException {
        if (!(j >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.t("limit < 0: ", j).toString());
        }
        long j2 = RecyclerView.FOREVER_NS;
        if (j != RecyclerView.FOREVER_NS) {
            j2 = j + 1;
        }
        byte b2 = (byte) 10;
        long jS = s(b2, 0L, j2);
        if (jS != -1) {
            return g0.z.a.a(this, jS);
        }
        if (j2 < this.k && q(j2 - 1) == ((byte) 13) && q(j2) == b2) {
            return g0.z.a.a(this, j2);
        }
        e eVar = new e();
        n(eVar, 0L, Math.min(32, this.k));
        throw new EOFException("\\n not found: limit=" + Math.min(this.k, j) + " content=" + eVar.x().k() + (char) 8230);
    }

    public String H(long j) throws EOFException {
        return A(j, d0.g0.c.a);
    }

    public int I() throws EOFException {
        int i;
        int i2;
        int i3;
        if (this.k == 0) {
            throw new EOFException();
        }
        byte bQ = q(0L);
        if ((bQ & 128) == 0) {
            i = bQ & 127;
            i2 = 1;
            i3 = 0;
        } else if ((bQ & 224) == 192) {
            i = bQ & 31;
            i2 = 2;
            i3 = 128;
        } else if ((bQ & 240) == 224) {
            i = bQ & 15;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((bQ & 248) != 240) {
                skip(1L);
                return 65533;
            }
            i = bQ & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (this.k < j) {
            StringBuilder sbV = b.d.b.a.a.V("size < ", i2, ": ");
            sbV.append(this.k);
            sbV.append(" (to read code point prefixed 0x");
            sbV.append(b.i.a.f.e.o.f.t1(bQ));
            sbV.append(')');
            throw new EOFException(sbV.toString());
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte bQ2 = q(j2);
            if ((bQ2 & 192) != 128) {
                skip(j2);
                return 65533;
            }
            i = (i << 6) | (bQ2 & 63);
        }
        skip(j);
        if (i > 1114111) {
            return 65533;
        }
        if ((55296 <= i && 57343 >= i) || i < i3) {
            return 65533;
        }
        return i;
    }

    public final ByteString J(int i) {
        if (i == 0) {
            return ByteString.j;
        }
        b.i.a.f.e.o.f.B(this.k, 0L, i);
        s sVar = this.j;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (sVar == null) {
                d0.z.d.m.throwNpe();
            }
            int i5 = sVar.c;
            int i6 = sVar.f3693b;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            sVar = sVar.f;
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 * 2];
        s sVar2 = this.j;
        int i7 = 0;
        while (i2 < i) {
            if (sVar2 == null) {
                d0.z.d.m.throwNpe();
            }
            bArr[i7] = sVar2.a;
            i2 += sVar2.c - sVar2.f3693b;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = sVar2.f3693b;
            sVar2.d = true;
            i7++;
            sVar2 = sVar2.f;
        }
        return new u(bArr, iArr);
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink K(String str) {
        b0(str);
        return this;
    }

    @Override // g0.g
    public String M(Charset charset) {
        d0.z.d.m.checkParameterIsNotNull(charset, "charset");
        return A(this.k, charset);
    }

    public final s N(int i) {
        if (!(i >= 1 && i <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        s sVar = this.j;
        if (sVar == null) {
            s sVarB = t.b();
            this.j = sVarB;
            sVarB.g = sVarB;
            sVarB.f = sVarB;
            return sVarB;
        }
        if (sVar == null) {
            d0.z.d.m.throwNpe();
        }
        s sVar2 = sVar.g;
        if (sVar2 == null) {
            d0.z.d.m.throwNpe();
        }
        if (sVar2.c + i <= 8192 && sVar2.e) {
            return sVar2;
        }
        s sVarB2 = t.b();
        sVar2.b(sVarB2);
        return sVarB2;
    }

    public e O(ByteString byteString) {
        d0.z.d.m.checkParameterIsNotNull(byteString, "byteString");
        byteString.s(this, 0, byteString.j());
        return this;
    }

    @Override // okio.BufferedSink
    public long P(x xVar) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(xVar, "source");
        long j = 0;
        while (true) {
            long jI0 = xVar.i0(this, 8192);
            if (jI0 == -1) {
                return j;
            }
            j += jI0;
        }
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink Q(long j) {
        return V(j);
    }

    public e R(byte[] bArr) {
        d0.z.d.m.checkParameterIsNotNull(bArr, "source");
        S(bArr, 0, bArr.length);
        return this;
    }

    public e S(byte[] bArr, int i, int i2) {
        d0.z.d.m.checkParameterIsNotNull(bArr, "source");
        long j = i2;
        b.i.a.f.e.o.f.B(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            s sVarN = N(1);
            int iMin = Math.min(i3 - i, 8192 - sVarN.c);
            int i4 = i + iMin;
            d0.t.j.copyInto(bArr, sVarN.a, sVarN.c, i, i4);
            sVarN.c += iMin;
            i = i4;
        }
        this.k += j;
        return this;
    }

    public e T(int i) {
        s sVarN = N(1);
        byte[] bArr = sVarN.a;
        int i2 = sVarN.c;
        sVarN.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.k++;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    /* JADX WARN: Code duplicated, block: B:15:0x002d  */
    /* JADX WARN: Code duplicated, block: B:17:0x0033  */
    /* JADX WARN: Code duplicated, block: B:20:0x003b  */
    /* JADX WARN: Code duplicated, block: B:21:0x003e  */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:25:0x004a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0058  */
    /* JADX WARN: Code duplicated, block: B:30:0x005b  */
    /* JADX WARN: Code duplicated, block: B:31:0x005e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0065  */
    /* JADX WARN: Code duplicated, block: B:34:0x0068  */
    /* JADX WARN: Code duplicated, block: B:35:0x006c  */
    /* JADX WARN: Code duplicated, block: B:37:0x0075  */
    /* JADX WARN: Code duplicated, block: B:39:0x007e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0085  */
    /* JADX WARN: Code duplicated, block: B:42:0x0088  */
    /* JADX WARN: Code duplicated, block: B:43:0x008b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0094  */
    /* JADX WARN: Code duplicated, block: B:46:0x0097  */
    /* JADX WARN: Code duplicated, block: B:47:0x009a  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:52:0x00af  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:55:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:56:0x00be  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00df  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:71:0x00f5 A[LOOP:0: B:69:0x00f1->B:71:0x00f5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:73:0x0105  */
    public e U(long j) {
        byte[] bArr;
        int i;
        if (j == 0) {
            T(48);
        } else {
            boolean z2 = false;
            int i2 = 1;
            if (j < 0) {
                j = -j;
                if (j < 0) {
                    b0("-9223372036854775808");
                } else {
                    z2 = true;
                    if (j < 100000000) {
                        if (j < 10000) {
                            if (j < 100) {
                                if (j >= 10) {
                                    i2 = 2;
                                }
                            } else if (j < 1000) {
                                i2 = 3;
                            } else {
                                i2 = 4;
                            }
                        } else if (j < 1000000) {
                            if (j < 100000) {
                                i2 = 5;
                            } else {
                                i2 = 6;
                            }
                        } else if (j < 10000000) {
                            i2 = 7;
                        } else {
                            i2 = 8;
                        }
                    } else if (j < 1000000000000L) {
                        if (j < 10000000000L) {
                            if (j < 1000000000) {
                                i2 = 9;
                            } else {
                                i2 = 10;
                            }
                        } else if (j < 100000000000L) {
                            i2 = 11;
                        } else {
                            i2 = 12;
                        }
                    } else if (j < 1000000000000000L) {
                        if (j < 10000000000000L) {
                            i2 = 13;
                        } else if (j < 100000000000000L) {
                            i2 = 14;
                        } else {
                            i2 = 15;
                        }
                    } else if (j < 100000000000000000L) {
                        if (j < 10000000000000000L) {
                            i2 = 16;
                        } else {
                            i2 = 17;
                        }
                    } else if (j < 1000000000000000000L) {
                        i2 = 18;
                    } else {
                        i2 = 19;
                    }
                    if (z2) {
                        i2++;
                    }
                    s sVarN = N(i2);
                    bArr = sVarN.a;
                    i = sVarN.c + i2;
                    while (j != 0) {
                        long j2 = 10;
                        i--;
                        bArr[i] = g0.z.a.a[(int) (j % j2)];
                        j /= j2;
                    }
                    if (z2) {
                        bArr[i - 1] = (byte) 45;
                    }
                    sVarN.c += i2;
                    this.k += (long) i2;
                }
            } else {
                if (j < 100000000) {
                    if (j < 10000) {
                        if (j < 100) {
                            if (j >= 10) {
                                i2 = 2;
                            }
                        } else if (j < 1000) {
                            i2 = 3;
                        } else {
                            i2 = 4;
                        }
                    } else if (j < 1000000) {
                        if (j < 100000) {
                            i2 = 5;
                        } else {
                            i2 = 6;
                        }
                    } else if (j < 10000000) {
                        i2 = 7;
                    } else {
                        i2 = 8;
                    }
                } else if (j < 1000000000000L) {
                    if (j < 10000000000L) {
                        if (j < 1000000000) {
                            i2 = 9;
                        } else {
                            i2 = 10;
                        }
                    } else if (j < 100000000000L) {
                        i2 = 11;
                    } else {
                        i2 = 12;
                    }
                } else if (j < 1000000000000000L) {
                    if (j < 10000000000000L) {
                        i2 = 13;
                    } else if (j < 100000000000000L) {
                        i2 = 14;
                    } else {
                        i2 = 15;
                    }
                } else if (j < 100000000000000000L) {
                    if (j < 10000000000000000L) {
                        i2 = 16;
                    } else {
                        i2 = 17;
                    }
                } else if (j < 1000000000000000000L) {
                    i2 = 18;
                } else {
                    i2 = 19;
                }
                if (z2) {
                    i2++;
                }
                s sVarN2 = N(i2);
                bArr = sVarN2.a;
                i = sVarN2.c + i2;
                while (j != 0) {
                    long j3 = 10;
                    i--;
                    bArr[i] = g0.z.a.a[(int) (j % j3)];
                    j /= j3;
                }
                if (z2) {
                    bArr[i - 1] = (byte) 45;
                }
                sVarN2.c += i2;
                this.k += (long) i2;
            }
        }
        return this;
    }

    public e V(long j) {
        if (j == 0) {
            T(48);
        } else {
            long j2 = (j >>> 1) | j;
            long j3 = j2 | (j2 >>> 2);
            long j4 = j3 | (j3 >>> 4);
            long j5 = j4 | (j4 >>> 8);
            long j6 = j5 | (j5 >>> 16);
            long j7 = j6 | (j6 >>> 32);
            long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
            long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
            long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
            long j11 = j10 + (j10 >>> 8);
            long j12 = j11 + (j11 >>> 16);
            int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
            s sVarN = N(i);
            byte[] bArr = sVarN.a;
            int i2 = sVarN.c;
            for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
                bArr[i3] = g0.z.a.a[(int) (15 & j)];
                j >>>= 4;
            }
            sVarN.c += i;
            this.k += (long) i;
        }
        return this;
    }

    public e W(int i) {
        s sVarN = N(4);
        byte[] bArr = sVarN.a;
        int i2 = sVarN.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        sVarN.c = i5 + 1;
        this.k += 4;
        return this;
    }

    public e X(int i) {
        s sVarN = N(2);
        byte[] bArr = sVarN.a;
        int i2 = sVarN.c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        sVarN.c = i3 + 1;
        this.k += 2;
        return this;
    }

    @Override // g0.g
    public String Y() throws EOFException {
        return G(RecyclerView.FOREVER_NS);
    }

    @Override // g0.g
    public byte[] Z(long j) throws EOFException {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(b.d.b.a.a.t("byteCount: ", j).toString());
        }
        if (this.k < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    public e b() {
        e eVar = new e();
        if (this.k != 0) {
            s sVar = this.j;
            if (sVar == null) {
                d0.z.d.m.throwNpe();
            }
            s sVarC = sVar.c();
            eVar.j = sVarC;
            sVarC.g = sVarC;
            sVarC.f = sVarC;
            for (s sVar2 = sVar.f; sVar2 != sVar; sVar2 = sVar2.f) {
                s sVar3 = sVarC.g;
                if (sVar3 == null) {
                    d0.z.d.m.throwNpe();
                }
                if (sVar2 == null) {
                    d0.z.d.m.throwNpe();
                }
                sVar3.b(sVar2.c());
            }
            eVar.k = this.k;
        }
        return eVar;
    }

    public e b0(String str) {
        d0.z.d.m.checkParameterIsNotNull(str, "string");
        c0(str, 0, str.length());
        return this;
    }

    public e c0(String str, int i, int i2) {
        char cCharAt;
        d0.z.d.m.checkParameterIsNotNull(str, "string");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.q("beginIndex < 0: ", i).toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(b.d.b.a.a.s("endIndex < beginIndex: ", i2, " < ", i).toString());
        }
        if (!(i2 <= str.length())) {
            StringBuilder sbV = b.d.b.a.a.V("endIndex > string.length: ", i2, " > ");
            sbV.append(str.length());
            throw new IllegalArgumentException(sbV.toString().toString());
        }
        while (i < i2) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                s sVarN = N(1);
                byte[] bArr = sVarN.a;
                int i3 = sVarN.c - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt2;
                while (true) {
                    i = i4;
                    if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                }
                int i5 = sVarN.c;
                int i6 = (i3 + i) - i5;
                sVarN.c = i5 + i6;
                this.k += (long) i6;
            } else {
                if (cCharAt2 < 2048) {
                    s sVarN2 = N(2);
                    byte[] bArr2 = sVarN2.a;
                    int i7 = sVarN2.c;
                    bArr2[i7] = (byte) ((cCharAt2 >> 6) | Opcodes.CHECKCAST);
                    bArr2[i7 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    sVarN2.c = i7 + 2;
                    this.k += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    s sVarN3 = N(3);
                    byte[] bArr3 = sVarN3.a;
                    int i8 = sVarN3.c;
                    bArr3[i8] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i8 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i8 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    sVarN3.c = i8 + 3;
                    this.k += 3;
                } else {
                    int i9 = i + 1;
                    char cCharAt3 = i9 < i2 ? str.charAt(i9) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || 57343 < cCharAt3) {
                        T(63);
                        i = i9;
                    } else {
                        int i10 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        s sVarN4 = N(4);
                        byte[] bArr4 = sVarN4.a;
                        int i11 = sVarN4.c;
                        bArr4[i11] = (byte) ((i10 >> 18) | 240);
                        bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                        bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                        bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                        sVarN4.c = i11 + 4;
                        this.k += 4;
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    @Override // g0.x, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public e d0(int i) {
        String str;
        if (i < 128) {
            T(i);
        } else if (i < 2048) {
            s sVarN = N(2);
            byte[] bArr = sVarN.a;
            int i2 = sVarN.c;
            bArr[i2] = (byte) ((i >> 6) | Opcodes.CHECKCAST);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            sVarN.c = i2 + 2;
            this.k += 2;
        } else if (55296 <= i && 57343 >= i) {
            T(63);
        } else if (i < 65536) {
            s sVarN2 = N(3);
            byte[] bArr2 = sVarN2.a;
            int i3 = sVarN2.c;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            sVarN2.c = i3 + 3;
            this.k += 3;
        } else {
            if (i > 1114111) {
                StringBuilder sbU = b.d.b.a.a.U("Unexpected code point: 0x");
                if (i != 0) {
                    char[] cArr = g0.z.b.a;
                    int i4 = 0;
                    char[] cArr2 = {cArr[(i >> 28) & 15], cArr[(i >> 24) & 15], cArr[(i >> 20) & 15], cArr[(i >> 16) & 15], cArr[(i >> 12) & 15], cArr[(i >> 8) & 15], cArr[(i >> 4) & 15], cArr[i & 15]};
                    while (i4 < 8 && cArr2[i4] == '0') {
                        i4++;
                    }
                    str = new String(cArr2, i4, 8 - i4);
                } else {
                    str = "0";
                }
                sbU.append(str);
                throw new IllegalArgumentException(sbU.toString());
            }
            s sVarN3 = N(4);
            byte[] bArr3 = sVarN3.a;
            int i5 = sVarN3.c;
            bArr3[i5] = (byte) ((i >> 18) | 240);
            bArr3[i5 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i5 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i5 + 3] = (byte) ((i & 63) | 128);
            sVarN3.c = i5 + 4;
            this.k += 4;
        }
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink e0(ByteString byteString) {
        O(byteString);
        return this;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            long j = this.k;
            e eVar = (e) obj;
            if (j != eVar.k) {
                return false;
            }
            if (j != 0) {
                s sVar = this.j;
                if (sVar == null) {
                    d0.z.d.m.throwNpe();
                }
                s sVar2 = eVar.j;
                if (sVar2 == null) {
                    d0.z.d.m.throwNpe();
                }
                int i = sVar.f3693b;
                int i2 = sVar2.f3693b;
                long j2 = 0;
                while (j2 < this.k) {
                    long jMin = Math.min(sVar.c - i, sVar2.c - i2);
                    long j3 = 0;
                    while (j3 < jMin) {
                        int i3 = i + 1;
                        int i4 = i2 + 1;
                        if (sVar.a[i] != sVar2.a[i2]) {
                            return false;
                        }
                        j3++;
                        i = i3;
                        i2 = i4;
                    }
                    if (i == sVar.c) {
                        sVar = sVar.f;
                        if (sVar == null) {
                            d0.z.d.m.throwNpe();
                        }
                        i = sVar.f3693b;
                    }
                    if (i2 == sVar2.c) {
                        sVar2 = sVar2.f;
                        if (sVar2 == null) {
                            d0.z.d.m.throwNpe();
                        }
                        i2 = sVar2.f3693b;
                    }
                    j2 += jMin;
                }
            }
        }
        return true;
    }

    public final long f() {
        long j = this.k;
        if (j == 0) {
            return 0L;
        }
        s sVar = this.j;
        if (sVar == null) {
            d0.z.d.m.throwNpe();
        }
        s sVar2 = sVar.g;
        if (sVar2 == null) {
            d0.z.d.m.throwNpe();
        }
        int i = sVar2.c;
        if (i < 8192 && sVar2.e) {
            j -= (long) (i - sVar2.f3693b);
        }
        return j;
    }

    @Override // okio.BufferedSink, g0.v, java.io.Flushable
    public void flush() {
    }

    @Override // g0.g, okio.BufferedSink
    public e g() {
        return this;
    }

    public int hashCode() {
        s sVar = this.j;
        if (sVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = sVar.c;
            for (int i3 = sVar.f3693b; i3 < i2; i3++) {
                i = (i * 31) + sVar.a[i3];
            }
            sVar = sVar.f;
            if (sVar == null) {
                d0.z.d.m.throwNpe();
            }
        } while (sVar != this.j);
        return i;
    }

    @Override // g0.x
    public long i0(e eVar, long j) {
        d0.z.d.m.checkParameterIsNotNull(eVar, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.t("byteCount < 0: ", j).toString());
        }
        long j2 = this.k;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        eVar.write(this, j);
        return j;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // g0.g
    public boolean j(long j) {
        return this.k >= j;
    }

    @Override // g0.g
    public long k0(v vVar) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(vVar, "sink");
        long j = this.k;
        if (j > 0) {
            vVar.write(this, j);
        }
        return j;
    }

    public final e n(e eVar, long j, long j2) {
        d0.z.d.m.checkParameterIsNotNull(eVar, "out");
        b.i.a.f.e.o.f.B(this.k, j, j2);
        if (j2 != 0) {
            eVar.k += j2;
            s sVar = this.j;
            while (true) {
                if (sVar == null) {
                    d0.z.d.m.throwNpe();
                }
                int i = sVar.c;
                int i2 = sVar.f3693b;
                if (j < i - i2) {
                    break;
                }
                j -= (long) (i - i2);
                sVar = sVar.f;
            }
            while (j2 > 0) {
                if (sVar == null) {
                    d0.z.d.m.throwNpe();
                }
                s sVarC = sVar.c();
                int i3 = sVarC.f3693b + ((int) j);
                sVarC.f3693b = i3;
                sVarC.c = Math.min(i3 + ((int) j2), sVarC.c);
                s sVar2 = eVar.j;
                if (sVar2 == null) {
                    sVarC.g = sVarC;
                    sVarC.f = sVarC;
                    eVar.j = sVarC;
                } else {
                    if (sVar2 == null) {
                        d0.z.d.m.throwNpe();
                    }
                    s sVar3 = sVar2.g;
                    if (sVar3 == null) {
                        d0.z.d.m.throwNpe();
                    }
                    sVar3.b(sVarC);
                }
                j2 -= (long) (sVarC.c - sVarC.f3693b);
                sVar = sVar.f;
                j = 0;
            }
        }
        return this;
    }

    @Override // g0.g
    public ByteString o(long j) throws EOFException {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(b.d.b.a.a.t("byteCount: ", j).toString());
        }
        if (this.k < j) {
            throw new EOFException();
        }
        if (j < 4096) {
            return new ByteString(Z(j));
        }
        ByteString byteStringJ = J((int) j);
        skip(j);
        return byteStringJ;
    }

    @Override // okio.BufferedSink
    public BufferedSink p() {
        return this;
    }

    @Override // g0.g
    public void p0(long j) throws EOFException {
        if (this.k < j) {
            throw new EOFException();
        }
    }

    public final byte q(long j) {
        b.i.a.f.e.o.f.B(this.k, j, 1L);
        s sVar = this.j;
        if (sVar == null) {
            d0.z.d.m.throwNpe();
            throw null;
        }
        long j2 = this.k;
        if (j2 - j < j) {
            while (j2 > j) {
                sVar = sVar.g;
                if (sVar == null) {
                    d0.z.d.m.throwNpe();
                }
                j2 -= (long) (sVar.c - sVar.f3693b);
            }
            return sVar.a[(int) ((((long) sVar.f3693b) + j) - j2)];
        }
        long j3 = 0;
        while (true) {
            int i = sVar.c;
            int i2 = sVar.f3693b;
            long j4 = ((long) (i - i2)) + j3;
            if (j4 > j) {
                return sVar.a[(int) ((((long) i2) + j) - j3)];
            }
            sVar = sVar.f;
            if (sVar == null) {
                d0.z.d.m.throwNpe();
            }
            j3 = j4;
        }
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink q0(long j) {
        return U(j);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(byteBuffer, "sink");
        s sVar = this.j;
        if (sVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), sVar.c - sVar.f3693b);
        byteBuffer.put(sVar.a, sVar.f3693b, iMin);
        int i = sVar.f3693b + iMin;
        sVar.f3693b = i;
        this.k -= (long) iMin;
        if (i == sVar.c) {
            this.j = sVar.a();
            t.a(sVar);
        }
        return iMin;
    }

    @Override // g0.g
    public byte readByte() throws EOFException {
        if (this.k == 0) {
            throw new EOFException();
        }
        s sVar = this.j;
        if (sVar == null) {
            d0.z.d.m.throwNpe();
        }
        int i = sVar.f3693b;
        int i2 = sVar.c;
        int i3 = i + 1;
        byte b2 = sVar.a[i];
        this.k--;
        if (i3 == i2) {
            this.j = sVar.a();
            t.a(sVar);
        } else {
            sVar.f3693b = i3;
        }
        return b2;
    }

    @Override // g0.g
    public void readFully(byte[] bArr) throws EOFException {
        d0.z.d.m.checkParameterIsNotNull(bArr, "sink");
        int i = 0;
        while (i < bArr.length) {
            int i2 = read(bArr, i, bArr.length - i);
            if (i2 == -1) {
                throw new EOFException();
            }
            i += i2;
        }
    }

    @Override // g0.g
    public int readInt() throws EOFException {
        if (this.k < 4) {
            throw new EOFException();
        }
        s sVar = this.j;
        if (sVar == null) {
            d0.z.d.m.throwNpe();
        }
        int i = sVar.f3693b;
        int i2 = sVar.c;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = sVar.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.k -= 4;
        if (i8 == i2) {
            this.j = sVar.a();
            t.a(sVar);
        } else {
            sVar.f3693b = i8;
        }
        return i9;
    }

    @Override // g0.g
    public long readLong() throws EOFException {
        if (this.k < 8) {
            throw new EOFException();
        }
        s sVar = this.j;
        if (sVar == null) {
            d0.z.d.m.throwNpe();
        }
        int i = sVar.f3693b;
        int i2 = sVar.c;
        if (i2 - i < 8) {
            return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
        }
        byte[] bArr = sVar.a;
        int i3 = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        int i4 = i3 + 1;
        long j2 = j | ((((long) bArr[i3]) & 255) << 48);
        int i5 = i4 + 1;
        long j3 = j2 | ((((long) bArr[i4]) & 255) << 40);
        int i6 = i5 + 1;
        long j4 = ((((long) bArr[i5]) & 255) << 32) | j3;
        int i7 = i6 + 1;
        long j5 = j4 | ((((long) bArr[i6]) & 255) << 24);
        int i8 = i7 + 1;
        long j6 = j5 | ((((long) bArr[i7]) & 255) << 16);
        int i9 = i8 + 1;
        long j7 = j6 | ((((long) bArr[i8]) & 255) << 8);
        int i10 = i9 + 1;
        long j8 = j7 | (((long) bArr[i9]) & 255);
        this.k -= 8;
        if (i10 == i2) {
            this.j = sVar.a();
            t.a(sVar);
        } else {
            sVar.f3693b = i10;
        }
        return j8;
    }

    @Override // g0.g
    public short readShort() throws EOFException {
        if (this.k < 2) {
            throw new EOFException();
        }
        s sVar = this.j;
        if (sVar == null) {
            d0.z.d.m.throwNpe();
        }
        int i = sVar.f3693b;
        int i2 = sVar.c;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = sVar.a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.k -= 2;
        if (i4 == i2) {
            this.j = sVar.a();
            t.a(sVar);
        } else {
            sVar.f3693b = i4;
        }
        return (short) i5;
    }

    public long s(byte b2, long j, long j2) {
        s sVar;
        long j3 = 0;
        if (!(0 <= j && j2 >= j)) {
            StringBuilder sbU = b.d.b.a.a.U("size=");
            sbU.append(this.k);
            sbU.append(" fromIndex=");
            sbU.append(j);
            sbU.append(" toIndex=");
            sbU.append(j2);
            throw new IllegalArgumentException(sbU.toString().toString());
        }
        long j4 = this.k;
        if (j2 > j4) {
            j2 = j4;
        }
        if (j != j2 && (sVar = this.j) != null) {
            if (j4 - j < j) {
                while (j4 > j) {
                    sVar = sVar.g;
                    if (sVar == null) {
                        d0.z.d.m.throwNpe();
                    }
                    j4 -= (long) (sVar.c - sVar.f3693b);
                }
                while (j4 < j2) {
                    byte[] bArr = sVar.a;
                    int iMin = (int) Math.min(sVar.c, (((long) sVar.f3693b) + j2) - j4);
                    for (int i = (int) ((((long) sVar.f3693b) + j) - j4); i < iMin; i++) {
                        if (bArr[i] == b2) {
                            return ((long) (i - sVar.f3693b)) + j4;
                        }
                    }
                    j4 += (long) (sVar.c - sVar.f3693b);
                    sVar = sVar.f;
                    if (sVar == null) {
                        d0.z.d.m.throwNpe();
                    }
                    j = j4;
                }
            } else {
                while (true) {
                    long j5 = ((long) (sVar.c - sVar.f3693b)) + j3;
                    if (j5 > j) {
                        break;
                    }
                    sVar = sVar.f;
                    if (sVar == null) {
                        d0.z.d.m.throwNpe();
                    }
                    j3 = j5;
                }
                while (j3 < j2) {
                    byte[] bArr2 = sVar.a;
                    int iMin2 = (int) Math.min(sVar.c, (((long) sVar.f3693b) + j2) - j3);
                    for (int i2 = (int) ((((long) sVar.f3693b) + j) - j3); i2 < iMin2; i2++) {
                        if (bArr2[i2] == b2) {
                            return ((long) (i2 - sVar.f3693b)) + j3;
                        }
                    }
                    j3 += (long) (sVar.c - sVar.f3693b);
                    sVar = sVar.f;
                    if (sVar == null) {
                        d0.z.d.m.throwNpe();
                    }
                    j = j3;
                }
            }
        }
        return -1L;
    }

    @Override // g0.g
    public long s0() throws EOFException {
        int i;
        if (this.k == 0) {
            throw new EOFException();
        }
        int i2 = 0;
        boolean z2 = false;
        long j = 0;
        do {
            s sVar = this.j;
            if (sVar == null) {
                d0.z.d.m.throwNpe();
            }
            byte[] bArr = sVar.a;
            int i3 = sVar.f3693b;
            int i4 = sVar.c;
            while (i3 < i4) {
                byte b2 = bArr[i3];
                byte b3 = (byte) 48;
                if (b2 < b3 || b2 > ((byte) 57)) {
                    byte b4 = (byte) 97;
                    if ((b2 < b4 || b2 > ((byte) 102)) && (b2 < (b4 = (byte) 65) || b2 > ((byte) 70))) {
                        if (i2 != 0) {
                            z2 = true;
                            break;
                        }
                        StringBuilder sbU = b.d.b.a.a.U("Expected leading [0-9a-fA-F] character but was 0x");
                        sbU.append(b.i.a.f.e.o.f.t1(b2));
                        throw new NumberFormatException(sbU.toString());
                    }
                    i = (b2 - b4) + 10;
                } else {
                    i = b2 - b3;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    e eVar = new e();
                    eVar.V(j);
                    eVar.T(b2);
                    StringBuilder sbU2 = b.d.b.a.a.U("Number too large: ");
                    sbU2.append(eVar.D());
                    throw new NumberFormatException(sbU2.toString());
                }
                j = (j << 4) | ((long) i);
                i3++;
                i2++;
            }
            if (i3 == i4) {
                this.j = sVar.a();
                t.a(sVar);
            } else {
                sVar.f3693b = i3;
            }
            if (z2) {
                break;
            }
        } while (this.j != null);
        this.k -= (long) i2;
        return j;
    }

    @Override // g0.g
    public void skip(long j) throws EOFException {
        while (j > 0) {
            s sVar = this.j;
            if (sVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, sVar.c - sVar.f3693b);
            long j2 = iMin;
            this.k -= j2;
            j -= j2;
            int i = sVar.f3693b + iMin;
            sVar.f3693b = i;
            if (i == sVar.c) {
                this.j = sVar.a();
                t.a(sVar);
            }
        }
    }

    public long t(ByteString byteString, long j) {
        int i;
        int i2;
        int i3;
        int i4;
        long j2 = j;
        d0.z.d.m.checkParameterIsNotNull(byteString, "targetBytes");
        long j3 = 0;
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.t("fromIndex < 0: ", j2).toString());
        }
        s sVar = this.j;
        if (sVar == null) {
            return -1L;
        }
        long j4 = this.k;
        if (j4 - j2 < j2) {
            while (j4 > j2) {
                sVar = sVar.g;
                if (sVar == null) {
                    d0.z.d.m.throwNpe();
                }
                j4 -= (long) (sVar.c - sVar.f3693b);
            }
            if (byteString.j() == 2) {
                byte bM = byteString.m(0);
                byte bM2 = byteString.m(1);
                while (j4 < this.k) {
                    byte[] bArr = sVar.a;
                    i3 = (int) ((((long) sVar.f3693b) + j2) - j4);
                    int i5 = sVar.c;
                    while (i3 < i5) {
                        byte b2 = bArr[i3];
                        if (b2 == bM || b2 == bM2) {
                            i4 = sVar.f3693b;
                        } else {
                            i3++;
                        }
                    }
                    j4 += (long) (sVar.c - sVar.f3693b);
                    sVar = sVar.f;
                    if (sVar == null) {
                        d0.z.d.m.throwNpe();
                    }
                    j2 = j4;
                }
                return -1L;
            }
            byte[] bArrL = byteString.l();
            while (j4 < this.k) {
                byte[] bArr2 = sVar.a;
                i3 = (int) ((((long) sVar.f3693b) + j2) - j4);
                int i6 = sVar.c;
                while (i3 < i6) {
                    byte b3 = bArr2[i3];
                    for (byte b4 : bArrL) {
                        if (b3 == b4) {
                            i4 = sVar.f3693b;
                        }
                    }
                    i3++;
                }
                j4 += (long) (sVar.c - sVar.f3693b);
                sVar = sVar.f;
                if (sVar == null) {
                    d0.z.d.m.throwNpe();
                }
                j2 = j4;
            }
            return -1L;
            return ((long) (i3 - i4)) + j4;
        }
        while (true) {
            long j5 = ((long) (sVar.c - sVar.f3693b)) + j3;
            if (j5 > j2) {
                break;
            }
            sVar = sVar.f;
            if (sVar == null) {
                d0.z.d.m.throwNpe();
            }
            j3 = j5;
        }
        if (byteString.j() == 2) {
            byte bM3 = byteString.m(0);
            byte bM4 = byteString.m(1);
            while (j3 < this.k) {
                byte[] bArr3 = sVar.a;
                i = (int) ((((long) sVar.f3693b) + j2) - j3);
                int i7 = sVar.c;
                while (i < i7) {
                    byte b5 = bArr3[i];
                    if (b5 == bM3 || b5 == bM4) {
                        i2 = sVar.f3693b;
                    } else {
                        i++;
                    }
                }
                j3 += (long) (sVar.c - sVar.f3693b);
                sVar = sVar.f;
                if (sVar == null) {
                    d0.z.d.m.throwNpe();
                }
                j2 = j3;
            }
            return -1L;
        }
        byte[] bArrL2 = byteString.l();
        while (j3 < this.k) {
            byte[] bArr4 = sVar.a;
            i = (int) ((((long) sVar.f3693b) + j2) - j3);
            int i8 = sVar.c;
            while (i < i8) {
                byte b6 = bArr4[i];
                for (byte b7 : bArrL2) {
                    if (b6 == b7) {
                        i2 = sVar.f3693b;
                    }
                }
                i++;
            }
            j3 += (long) (sVar.c - sVar.f3693b);
            sVar = sVar.f;
            if (sVar == null) {
                d0.z.d.m.throwNpe();
            }
            j2 = j3;
        }
        return -1L;
        return ((long) (i - i2)) + j3;
    }

    @Override // g0.x
    public y timeout() {
        return y.a;
    }

    public String toString() {
        long j = this.k;
        if (j <= ((long) Integer.MAX_VALUE)) {
            return J((int) j).toString();
        }
        StringBuilder sbU = b.d.b.a.a.U("size > Int.MAX_VALUE: ");
        sbU.append(this.k);
        throw new IllegalStateException(sbU.toString().toString());
    }

    public final e$a u(e$a e_a) {
        d0.z.d.m.checkParameterIsNotNull(e_a, "unsafeCursor");
        if (!(e_a.j == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        e_a.j = this;
        e_a.k = true;
        return e_a;
    }

    @Override // g0.g
    public InputStream u0() {
        return new e$b(this);
    }

    @Override // g0.g
    public int v0(o oVar) throws EOFException {
        d0.z.d.m.checkParameterIsNotNull(oVar, "options");
        int iB = g0.z.a.b(this, oVar, false);
        if (iB == -1) {
            return -1;
        }
        skip(oVar.l[iB].j());
        return iB;
    }

    @Override // g0.g
    public boolean w() {
        return this.k == 0;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] bArr) {
        R(bArr);
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeByte(int i) {
        T(i);
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeInt(int i) {
        W(i);
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeShort(int i) {
        X(i);
        return this;
    }

    public ByteString x() {
        return o(this.k);
    }

    public short y() throws EOFException {
        int i = readShort() & 65535;
        return (short) (((i & 255) << 8) | ((65280 & i) >>> 8));
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] bArr, int i, int i2) {
        S(bArr, i, i2);
        return this;
    }

    @Override // g0.v
    public void write(e eVar, long j) {
        int i;
        s sVar;
        s sVarB;
        d0.z.d.m.checkParameterIsNotNull(eVar, "source");
        if (eVar != this) {
            b.i.a.f.e.o.f.B(eVar.k, 0L, j);
            long j2 = j;
            while (j2 > 0) {
                s sVar2 = eVar.j;
                if (sVar2 == null) {
                    d0.z.d.m.throwNpe();
                }
                int i2 = sVar2.c;
                s sVar3 = eVar.j;
                if (sVar3 == null) {
                    d0.z.d.m.throwNpe();
                }
                if (j2 < i2 - sVar3.f3693b) {
                    s sVar4 = this.j;
                    if (sVar4 != null) {
                        if (sVar4 == null) {
                            d0.z.d.m.throwNpe();
                        }
                        sVar = sVar4.g;
                    } else {
                        sVar = null;
                    }
                    if (sVar != null && sVar.e) {
                        if ((((long) sVar.c) + j2) - ((long) (sVar.d ? 0 : sVar.f3693b)) <= 8192) {
                            s sVar5 = eVar.j;
                            if (sVar5 == null) {
                                d0.z.d.m.throwNpe();
                            }
                            sVar5.d(sVar, (int) j2);
                            eVar.k -= j2;
                            this.k += j2;
                            return;
                        }
                    }
                    s sVar6 = eVar.j;
                    if (sVar6 == null) {
                        d0.z.d.m.throwNpe();
                    }
                    int i3 = (int) j2;
                    Objects.requireNonNull(sVar6);
                    if (i3 > 0 && i3 <= sVar6.c - sVar6.f3693b) {
                        if (i3 >= 1024) {
                            sVarB = sVar6.c();
                        } else {
                            sVarB = t.b();
                            byte[] bArr = sVar6.a;
                            byte[] bArr2 = sVarB.a;
                            int i4 = sVar6.f3693b;
                            d0.t.j.copyInto$default(bArr, bArr2, 0, i4, i4 + i3, 2, (Object) null);
                        }
                        sVarB.c = sVarB.f3693b + i3;
                        sVar6.f3693b += i3;
                        s sVar7 = sVar6.g;
                        if (sVar7 == null) {
                            d0.z.d.m.throwNpe();
                        }
                        sVar7.b(sVarB);
                        eVar.j = sVarB;
                    } else {
                        throw new IllegalArgumentException("byteCount out of range".toString());
                    }
                }
                s sVar8 = eVar.j;
                if (sVar8 == null) {
                    d0.z.d.m.throwNpe();
                }
                long j3 = sVar8.c - sVar8.f3693b;
                eVar.j = sVar8.a();
                s sVar9 = this.j;
                if (sVar9 == null) {
                    this.j = sVar8;
                    sVar8.g = sVar8;
                    sVar8.f = sVar8;
                } else {
                    if (sVar9 == null) {
                        d0.z.d.m.throwNpe();
                    }
                    s sVar10 = sVar9.g;
                    if (sVar10 == null) {
                        d0.z.d.m.throwNpe();
                    }
                    sVar10.b(sVar8);
                    s sVar11 = sVar8.g;
                    if (!(sVar11 != sVar8)) {
                        throw new IllegalStateException("cannot compact".toString());
                    }
                    if (sVar11 == null) {
                        d0.z.d.m.throwNpe();
                    }
                    if (sVar11.e) {
                        int i5 = sVar8.c - sVar8.f3693b;
                        s sVar12 = sVar8.g;
                        if (sVar12 == null) {
                            d0.z.d.m.throwNpe();
                        }
                        int i6 = 8192 - sVar12.c;
                        s sVar13 = sVar8.g;
                        if (sVar13 == null) {
                            d0.z.d.m.throwNpe();
                        }
                        if (sVar13.d) {
                            i = 0;
                        } else {
                            s sVar14 = sVar8.g;
                            if (sVar14 == null) {
                                d0.z.d.m.throwNpe();
                            }
                            i = sVar14.f3693b;
                        }
                        if (i5 <= i6 + i) {
                            s sVar15 = sVar8.g;
                            if (sVar15 == null) {
                                d0.z.d.m.throwNpe();
                            }
                            sVar8.d(sVar15, i5);
                            sVar8.a();
                            t.a(sVar8);
                        }
                    }
                }
                eVar.k -= j3;
                this.k += j3;
                j2 -= j3;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public int read(byte[] bArr, int i, int i2) {
        d0.z.d.m.checkParameterIsNotNull(bArr, "sink");
        b.i.a.f.e.o.f.B(bArr.length, i, i2);
        s sVar = this.j;
        if (sVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, sVar.c - sVar.f3693b);
        byte[] bArr2 = sVar.a;
        int i3 = sVar.f3693b;
        d0.t.j.copyInto(bArr2, bArr, i, i3, i3 + iMin);
        int i4 = sVar.f3693b + iMin;
        sVar.f3693b = i4;
        this.k -= (long) iMin;
        if (i4 != sVar.c) {
            return iMin;
        }
        this.j = sVar.a();
        t.a(sVar);
        return iMin;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(byteBuffer, "source");
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            s sVarN = N(1);
            int iMin = Math.min(i, 8192 - sVarN.c);
            byteBuffer.get(sVarN.a, sVarN.c, iMin);
            i -= iMin;
            sVarN.c += iMin;
        }
        this.k += (long) iRemaining;
        return iRemaining;
    }
}
