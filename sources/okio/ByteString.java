package okio;

import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import d0.g0.Charsets2;
import d0.g0.StringsJVM;
import d0.t._ArraysJvm;
import d0.z.d.Intrinsics3;
import g0.Buffer3;
import g0.a;
import g0.z.ByteString4;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ByteString.kt */
/* JADX INFO: loaded from: classes3.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    private static final long serialVersionUID = 1;
    private final byte[] data;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public transient int hashCode;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public transient String utf8;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final ByteString j = new ByteString(new byte[0]);

    /* JADX INFO: renamed from: okio.ByteString$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ByteString.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static ByteString d(Companion companion, byte[] bArr, int i, int i2, int i3) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = bArr.length;
            }
            Intrinsics3.checkParameterIsNotNull(bArr, "$this$toByteString");
            f.B(bArr.length, i, i2);
            return new ByteString(_ArraysJvm.copyOfRange(bArr, i, i2 + i));
        }

        public final ByteString a(String str) {
            Intrinsics3.checkParameterIsNotNull(str, "$this$decodeHex");
            if (!(str.length() % 2 == 0)) {
                throw new IllegalArgumentException(outline.w("Unexpected hex string: ", str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (ByteString4.a(str.charAt(i2 + 1)) + (ByteString4.a(str.charAt(i2)) << 4));
            }
            return new ByteString(bArr);
        }

        public final ByteString b(String str, Charset charset) {
            Intrinsics3.checkParameterIsNotNull(str, "$this$encode");
            Intrinsics3.checkParameterIsNotNull(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            Intrinsics3.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        public final ByteString c(String str) {
            Intrinsics3.checkParameterIsNotNull(str, "$this$encodeUtf8");
            Intrinsics3.checkParameterIsNotNull(str, "$this$asUtf8ToByteArray");
            byte[] bytes = str.getBytes(Charsets2.a);
            Intrinsics3.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            ByteString byteString = new ByteString(bytes);
            byteString.utf8 = str;
            return byteString;
        }
    }

    public ByteString(byte[] bArr) {
        Intrinsics3.checkParameterIsNotNull(bArr, "data");
        this.data = bArr;
    }

    public static final ByteString h(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "$this$encodeUtf8");
        Intrinsics3.checkParameterIsNotNull(str, "$this$asUtf8ToByteArray");
        byte[] bytes = str.getBytes(Charsets2.a);
        Intrinsics3.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        ByteString byteString = new ByteString(bytes);
        byteString.utf8 = str;
        return byteString;
    }

    private final void readObject(ObjectInputStream in) throws IllegalAccessException, NoSuchFieldException, IOException {
        int i = in.readInt();
        Intrinsics3.checkParameterIsNotNull(in, "$this$readByteString");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(outline.q("byteCount < 0: ", i).toString());
        }
        byte[] bArr = new byte[i];
        while (i2 < i) {
            int i3 = in.read(bArr, i2, i - i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 += i3;
        }
        ByteString byteString = new ByteString(bArr);
        Field declaredField = ByteString.class.getDeclaredField("data");
        Intrinsics3.checkExpressionValueIsNotNull(declaredField, "field");
        declaredField.setAccessible(true);
        declaredField.set(this, byteString.data);
    }

    private final void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(this.data.length);
        out.write(this.data);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0030 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:13:0x0032 A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    public int compareTo(ByteString byteString) {
        ByteString byteString2 = byteString;
        Intrinsics3.checkParameterIsNotNull(byteString2, "other");
        int iJ = j();
        int iJ2 = byteString2.j();
        int iMin = Math.min(iJ, iJ2);
        for (int i = 0; i < iMin; i++) {
            int iM = m(i) & 255;
            int iM2 = byteString2.m(i) & 255;
            if (iM != iM2) {
                if (iM < iM2) {
                    return -1;
                }
                return 1;
            }
        }
        if (iJ == iJ2) {
            return 0;
        }
        if (iJ < iJ2) {
            return -1;
        }
        return 1;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ByteString) {
            ByteString byteString = (ByteString) other;
            int iJ = byteString.j();
            byte[] bArr = this.data;
            if (iJ == bArr.length && byteString.o(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public String f() {
        byte[] bArr = this.data;
        byte[] bArr2 = a.a;
        byte[] bArr3 = a.a;
        Intrinsics3.checkParameterIsNotNull(bArr, "$this$encodeBase64");
        Intrinsics3.checkParameterIsNotNull(bArr3, "map");
        byte[] bArr4 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            byte b2 = bArr[i];
            int i4 = i3 + 1;
            byte b3 = bArr[i3];
            int i5 = i4 + 1;
            byte b4 = bArr[i4];
            int i6 = i2 + 1;
            bArr4[i2] = bArr3[(b2 & 255) >> 2];
            int i7 = i6 + 1;
            bArr4[i6] = bArr3[((b2 & 3) << 4) | ((b3 & 255) >> 4)];
            int i8 = i7 + 1;
            bArr4[i7] = bArr3[((b3 & 15) << 2) | ((b4 & 255) >> 6)];
            i2 = i8 + 1;
            bArr4[i8] = bArr3[b4 & 63];
            i = i5;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b5 = bArr[i];
            int i9 = i2 + 1;
            bArr4[i2] = bArr3[(b5 & 255) >> 2];
            int i10 = i9 + 1;
            bArr4[i9] = bArr3[(b5 & 3) << 4];
            byte b6 = (byte) 61;
            bArr4[i10] = b6;
            bArr4[i10 + 1] = b6;
        } else if (length2 == 2) {
            int i11 = i + 1;
            byte b7 = bArr[i];
            byte b8 = bArr[i11];
            int i12 = i2 + 1;
            bArr4[i2] = bArr3[(b7 & 255) >> 2];
            int i13 = i12 + 1;
            bArr4[i12] = bArr3[((b7 & 3) << 4) | ((b8 & 255) >> 4)];
            bArr4[i13] = bArr3[(b8 & 15) << 2];
            bArr4[i13 + 1] = (byte) 61;
        }
        Intrinsics3.checkParameterIsNotNull(bArr4, "$this$toUtf8String");
        return new String(bArr4, Charsets2.a);
    }

    public ByteString g(String algorithm) {
        Intrinsics3.checkParameterIsNotNull(algorithm, "algorithm");
        byte[] bArrDigest = MessageDigest.getInstance(algorithm).digest(this.data);
        Intrinsics3.checkExpressionValueIsNotNull(bArrDigest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new ByteString(bArrDigest);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.data);
        this.hashCode = iHashCode;
        return iHashCode;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    public int j() {
        return this.data.length;
    }

    public String k() {
        byte[] bArr = this.data;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = ByteString4.a;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public byte[] l() {
        return this.data;
    }

    public byte m(int pos) {
        return this.data[pos];
    }

    public boolean n(int offset, ByteString other, int otherOffset, int byteCount) {
        Intrinsics3.checkParameterIsNotNull(other, "other");
        return other.o(otherOffset, this.data, offset, byteCount);
    }

    public boolean o(int offset, byte[] other, int otherOffset, int byteCount) {
        Intrinsics3.checkParameterIsNotNull(other, "other");
        if (offset >= 0) {
            byte[] bArr = this.data;
            if (offset <= bArr.length - byteCount && otherOffset >= 0 && otherOffset <= other.length - byteCount && f.h(bArr, offset, other, otherOffset, byteCount)) {
                return true;
            }
        }
        return false;
    }

    public ByteString p() {
        byte b2;
        int i = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i >= bArr.length) {
                return this;
            }
            byte b3 = bArr[i];
            byte b4 = (byte) 65;
            if (b3 >= b4 && b3 <= (b2 = (byte) 90)) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics3.checkExpressionValueIsNotNull(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i] = (byte) (b3 + 32);
                for (int i2 = i + 1; i2 < bArrCopyOf.length; i2++) {
                    byte b5 = bArrCopyOf[i2];
                    if (b5 >= b4 && b5 <= b2) {
                        bArrCopyOf[i2] = (byte) (b5 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
            i++;
        }
    }

    public String q() {
        String str = this.utf8;
        if (str != null) {
            return str;
        }
        byte[] bArrL = l();
        Intrinsics3.checkParameterIsNotNull(bArrL, "$this$toUtf8String");
        String str2 = new String(bArrL, Charsets2.a);
        this.utf8 = str2;
        return str2;
    }

    public void r(OutputStream out) throws IOException {
        Intrinsics3.checkParameterIsNotNull(out, "out");
        out.write(this.data);
    }

    public void s(Buffer3 buffer, int offset, int byteCount) {
        Intrinsics3.checkParameterIsNotNull(buffer, "buffer");
        Intrinsics3.checkParameterIsNotNull(this, "$this$commonWrite");
        Intrinsics3.checkParameterIsNotNull(buffer, "buffer");
        buffer.S(this.data, offset, byteCount);
    }

    /* JADX WARN: Code duplicated, block: B:138:0x0142  */
    /* JADX WARN: Code duplicated, block: B:141:0x0149  */
    /* JADX WARN: Code duplicated, block: B:143:0x014d  */
    /* JADX WARN: Code duplicated, block: B:144:0x014f  */
    /* JADX WARN: Code duplicated, block: B:203:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:206:0x01de  */
    /* JADX WARN: Code duplicated, block: B:208:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:209:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:213:0x01ee A[EDGE_INSN: B:213:0x01ee->B:214:0x01ef BREAK  A[LOOP:0: B:9:0x0014->B:274:0x0014]] */
    /* JADX WARN: Code duplicated, block: B:240:0x01ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:243:0x01ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:249:0x01ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:253:0x01ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0043  */
    /* JADX WARN: Code duplicated, block: B:272:0x01ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:28:0x0047 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:29:0x0049  */
    /* JADX WARN: Code duplicated, block: B:30:0x004b  */
    /* JADX WARN: Code duplicated, block: B:49:0x0072 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x0076 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x0078  */
    /* JADX WARN: Code duplicated, block: B:53:0x007a  */
    /* JADX WARN: Code duplicated, block: B:85:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:88:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:90:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:91:0x00ce  */
    public String toString() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        byte[] bArr = this.data;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        loop0: while (i7 < length) {
            byte b2 = bArr[i7];
            if (b2 < 0) {
                if ((b2 >> 5) != -2) {
                    if ((b2 >> 4) != -2) {
                        if ((b2 >> 3) != -2) {
                            if (i8 == 64) {
                                break;
                            }
                            i9 = -1;
                            break;
                        }
                        int i10 = i7 + 3;
                        if (length > i10) {
                            byte b3 = bArr[i7];
                            byte b4 = bArr[i7 + 1];
                            if (!((b4 & 192) == 128)) {
                                if (i8 == 64) {
                                    break;
                                }
                                i9 = -1;
                                break;
                            }
                            byte b5 = bArr[i7 + 2];
                            if (!((b5 & 192) == 128)) {
                                if (i8 == 64) {
                                    break;
                                }
                                i9 = -1;
                                break;
                            }
                            byte b6 = bArr[i10];
                            if (!((b6 & 192) == 128)) {
                                if (i8 == 64) {
                                    break;
                                }
                                i9 = -1;
                                break;
                            }
                            int i11 = (((b6 ^ 3678080) ^ (b5 << 6)) ^ (b4 << 12)) ^ (b3 << 18);
                            if (i11 <= 1114111) {
                                if (55296 > i11 || 57343 < i11) {
                                    if (i11 >= 65536) {
                                        int i12 = i8 + 1;
                                        if (i8 == 64) {
                                            break;
                                        }
                                        if (i11 != 10 && i11 != 13) {
                                            if (!((i11 >= 0 && 31 >= i11) || (127 <= i11 && 159 >= i11))) {
                                                if (i11 == 65533) {
                                                    if (i11 < 65536) {
                                                        i6 = 1;
                                                    } else {
                                                        i6 = 2;
                                                    }
                                                    i9 += i6;
                                                    i7 += 4;
                                                    i8 = i12;
                                                }
                                            }
                                        } else if (i11 == 65533) {
                                            if (i11 < 65536) {
                                                i6 = 1;
                                            } else {
                                                i6 = 2;
                                            }
                                            i9 += i6;
                                            i7 += 4;
                                            i8 = i12;
                                        }
                                        i9 = -1;
                                        break;
                                    }
                                    if (i8 == 64) {
                                        break;
                                    }
                                    i9 = -1;
                                    break;
                                }
                                if (i8 == 64) {
                                    break;
                                }
                                i9 = -1;
                                break;
                            }
                            if (i8 == 64) {
                                break;
                            }
                            i9 = -1;
                            break;
                        }
                        if (i8 == 64) {
                            break;
                        }
                        i9 = -1;
                        break;
                    }
                    int i13 = i7 + 2;
                    if (length > i13) {
                        byte b7 = bArr[i7];
                        byte b8 = bArr[i7 + 1];
                        if (!((b8 & 192) == 128)) {
                            if (i8 == 64) {
                                break;
                            }
                            i9 = -1;
                            break;
                        }
                        byte b9 = bArr[i13];
                        if (!((b9 & 192) == 128)) {
                            if (i8 == 64) {
                                break;
                            }
                            i9 = -1;
                            break;
                        }
                        int i14 = ((b9 ^ (-123008)) ^ (b8 << 6)) ^ (b7 << 12);
                        if (i14 >= 2048) {
                            if (55296 > i14 || 57343 < i14) {
                                int i15 = i8 + 1;
                                if (i8 == 64) {
                                    break;
                                }
                                if (i14 != 10 && i14 != 13) {
                                    if (!((i14 >= 0 && 31 >= i14) || (127 <= i14 && 159 >= i14))) {
                                        if (i14 == 65533) {
                                            if (i14 < 65536) {
                                                i5 = 1;
                                            } else {
                                                i5 = 2;
                                            }
                                            i9 += i5;
                                            i7 += 3;
                                            i8 = i15;
                                        }
                                    }
                                } else if (i14 == 65533) {
                                    if (i14 < 65536) {
                                        i5 = 1;
                                    } else {
                                        i5 = 2;
                                    }
                                    i9 += i5;
                                    i7 += 3;
                                    i8 = i15;
                                }
                                i9 = -1;
                                break;
                            }
                            if (i8 == 64) {
                                break;
                            }
                            i9 = -1;
                            break;
                        }
                        if (i8 == 64) {
                            break;
                        }
                        i9 = -1;
                        break;
                    }
                    if (i8 == 64) {
                        break;
                    }
                    i9 = -1;
                    break;
                }
                int i16 = i7 + 1;
                if (length > i16) {
                    byte b10 = bArr[i7];
                    byte b11 = bArr[i16];
                    if (!((b11 & 192) == 128)) {
                        if (i8 == 64) {
                            break;
                        }
                        i9 = -1;
                        break;
                    }
                    int i17 = (b11 ^ 3968) ^ (b10 << 6);
                    if (i17 >= 128) {
                        int i18 = i8 + 1;
                        if (i8 == 64) {
                            break;
                        }
                        if (i17 != 10 && i17 != 13) {
                            if (!((i17 >= 0 && 31 >= i17) || (127 <= i17 && 159 >= i17))) {
                                if (i17 == 65533) {
                                    if (i17 < 65536) {
                                        i4 = 1;
                                    } else {
                                        i4 = 2;
                                    }
                                    i9 += i4;
                                    i7 += 2;
                                    i8 = i18;
                                }
                            }
                        } else if (i17 == 65533) {
                            if (i17 < 65536) {
                                i4 = 1;
                            } else {
                                i4 = 2;
                            }
                            i9 += i4;
                            i7 += 2;
                            i8 = i18;
                        }
                        i9 = -1;
                        break;
                    }
                    if (i8 == 64) {
                        break;
                    }
                    i9 = -1;
                    break;
                }
                if (i8 == 64) {
                    break;
                }
                i9 = -1;
                break;
            }
            int i19 = i8 + 1;
            if (i8 == 64) {
                break;
            }
            if (b2 != 10 && b2 != 13) {
                if (!((b2 >= 0 && 31 >= b2) || (127 <= b2 && 159 >= b2))) {
                    if (b2 != 65533) {
                        if (b2 < 65536) {
                            i = 1;
                        } else {
                            i = 2;
                        }
                        i9 += i;
                        i7++;
                        while (true) {
                            i8 = i19;
                            if (i7 < length) {
                                continue;
                            }
                            i9 += i3;
                            i7 = i2;
                        }
                    }
                }
                i9 = -1;
                break;
            }
            if (b2 != 65533) {
                if (b2 < 65536) {
                    i = 1;
                } else {
                    i = 2;
                }
                i9 += i;
                i7++;
                while (true) {
                    i8 = i19;
                    if (i7 < length && bArr[i7] >= 0) {
                        i2 = i7 + 1;
                        byte b12 = bArr[i7];
                        i19 = i8 + 1;
                        if (i8 == 64) {
                            break loop0;
                        }
                        if (b12 != 10 && b12 != 13) {
                            if (!((b12 >= 0 && 31 >= b12) || (127 <= b12 && 159 >= b12))) {
                                if (b12 == 65533) {
                                    if (b12 < 65536) {
                                        i3 = 1;
                                    } else {
                                        i3 = 2;
                                    }
                                    i9 += i3;
                                    i7 = i2;
                                }
                            }
                        } else if (b12 == 65533) {
                            if (b12 < 65536) {
                                i3 = 1;
                            } else {
                                i3 = 2;
                            }
                            i9 += i3;
                            i7 = i2;
                        }
                    }
                }
            }
            i9 = -1;
            break;
        }
        if (i9 == -1) {
            if (this.data.length <= 64) {
                StringBuilder sbU = outline.U("[hex=");
                sbU.append(k());
                sbU.append(']');
                return sbU.toString();
            }
            StringBuilder sbU2 = outline.U("[size=");
            sbU2.append(this.data.length);
            sbU2.append(" hex=");
            byte[] bArr2 = this.data;
            if (!(64 <= bArr2.length)) {
                throw new IllegalArgumentException(outline.A(outline.U("endIndex > length("), this.data.length, ')').toString());
            }
            sbU2.append((64 == bArr2.length ? this : new ByteString(_ArraysJvm.copyOfRange(bArr2, 0, 64))).k());
            sbU2.append("…]");
            return sbU2.toString();
        }
        String strQ = q();
        String strSubstring = strQ.substring(0, i9);
        Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strReplace$default = StringsJVM.replace$default(StringsJVM.replace$default(StringsJVM.replace$default(strSubstring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
        if (i9 >= strQ.length()) {
            return "[text=" + strReplace$default + ']';
        }
        StringBuilder sbU3 = outline.U("[size=");
        sbU3.append(this.data.length);
        sbU3.append(" text=");
        sbU3.append(strReplace$default);
        sbU3.append("…]");
        return sbU3.toString();
    }
}
