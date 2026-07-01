package d0.e0.p.d.m0.i;

import com.adjust.sdk.Constants;
import d0.e0.p.d.m0.i.MessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.d, reason: use source file name */
/* JADX INFO: compiled from: CodedInputStream.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CodedInputStream {
    public int d;
    public final InputStream f;
    public int g;
    public int j;
    public int i = Integer.MAX_VALUE;
    public final byte[] a = new byte[4096];
    public int c = 0;
    public int e = 0;
    public int h = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3426b = false;

    public CodedInputStream(InputStream inputStream) {
        this.f = inputStream;
    }

    public static int decodeZigZag32(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long decodeZigZag64(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return new CodedInputStream(inputStream);
    }

    public final byte[] a(int i) throws IOException {
        if (i <= 0) {
            if (i == 0) {
                return Internal.a;
            }
            throw InvalidProtocolBufferException.a();
        }
        int i2 = this.h;
        int i3 = this.e;
        int i4 = i2 + i3 + i;
        int i5 = this.i;
        if (i4 > i5) {
            skipRawBytes((i5 - i2) - i3);
            throw InvalidProtocolBufferException.c();
        }
        if (i < 4096) {
            byte[] bArr = new byte[i];
            int i6 = this.c - i3;
            System.arraycopy(this.a, i3, bArr, 0, i6);
            int i7 = this.c;
            this.e = i7;
            int i8 = i - i6;
            if (i7 - i7 < i8 && !e(i8)) {
                throw InvalidProtocolBufferException.c();
            }
            System.arraycopy(this.a, 0, bArr, i6, i8);
            this.e = i8;
            return bArr;
        }
        int i9 = this.c;
        this.h = i2 + i9;
        this.e = 0;
        this.c = 0;
        int length = i9 - i3;
        int i10 = i - length;
        ArrayList<byte[]> arrayList = new ArrayList();
        while (i10 > 0) {
            int iMin = Math.min(i10, 4096);
            byte[] bArr2 = new byte[iMin];
            int i11 = 0;
            while (i11 < iMin) {
                InputStream inputStream = this.f;
                int i12 = inputStream == null ? -1 : inputStream.read(bArr2, i11, iMin - i11);
                if (i12 == -1) {
                    throw InvalidProtocolBufferException.c();
                }
                this.h += i12;
                i11 += i12;
            }
            i10 -= iMin;
            arrayList.add(bArr2);
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(this.a, i3, bArr3, 0, length);
        for (byte[] bArr4 : arrayList) {
            System.arraycopy(bArr4, 0, bArr3, length, bArr4.length);
            length += bArr4.length;
        }
        return bArr3;
    }

    public long b() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte rawByte = readRawByte();
            j |= ((long) (rawByte & 127)) << i;
            if ((rawByte & 128) == 0) {
                return j;
            }
        }
        throw new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
    }

    public final void c() {
        int i = this.c + this.d;
        this.c = i;
        int i2 = this.h + i;
        int i3 = this.i;
        if (i2 <= i3) {
            this.d = 0;
            return;
        }
        int i4 = i2 - i3;
        this.d = i4;
        this.c = i - i4;
    }

    public void checkLastTagWas(int i) throws InvalidProtocolBufferException {
        if (this.g != i) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final void d(int i) throws IOException {
        if (!e(i)) {
            throw InvalidProtocolBufferException.c();
        }
    }

    public final boolean e(int i) throws IOException {
        int i2 = this.e;
        int i3 = i2 + i;
        int i4 = this.c;
        if (i3 <= i4) {
            StringBuilder sb = new StringBuilder(77);
            sb.append("refillBuffer() called when ");
            sb.append(i);
            sb.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb.toString());
        }
        if (this.h + i2 + i <= this.i && this.f != null) {
            if (i2 > 0) {
                if (i4 > i2) {
                    byte[] bArr = this.a;
                    System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
                }
                this.h += i2;
                this.c -= i2;
                this.e = 0;
            }
            InputStream inputStream = this.f;
            byte[] bArr2 = this.a;
            int i5 = this.c;
            int i6 = inputStream.read(bArr2, i5, bArr2.length - i5);
            if (i6 == 0 || i6 < -1 || i6 > this.a.length) {
                StringBuilder sb2 = new StringBuilder(102);
                sb2.append("InputStream#read(byte[]) returned invalid result: ");
                sb2.append(i6);
                sb2.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb2.toString());
            }
            if (i6 > 0) {
                this.c += i6;
                if ((this.h + i) - 67108864 > 0) {
                    throw new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
                }
                c();
                if (this.c >= i) {
                    return true;
                }
                return e(i);
            }
        }
        return false;
    }

    public int getBytesUntilLimit() {
        int i = this.i;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.h + this.e);
    }

    public boolean isAtEnd() throws IOException {
        return this.e == this.c && !e(1);
    }

    public void popLimit(int i) {
        this.i = i;
        c();
    }

    public int pushLimit(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw InvalidProtocolBufferException.a();
        }
        int i2 = this.h + this.e + i;
        int i3 = this.i;
        if (i2 > i3) {
            throw InvalidProtocolBufferException.c();
        }
        this.i = i2;
        c();
        return i3;
    }

    public boolean readBool() throws IOException {
        return readRawVarint64() != 0;
    }

    public ByteString3 readBytes() throws IOException {
        int rawVarint32 = readRawVarint32();
        int i = this.c;
        int i2 = this.e;
        if (rawVarint32 > i - i2 || rawVarint32 <= 0) {
            return rawVarint32 == 0 ? ByteString3.j : new LiteralByteString(a(rawVarint32));
        }
        boolean z2 = this.f3426b;
        ByteString3 byteString3CopyFrom = ByteString3.copyFrom(this.a, i2, rawVarint32);
        this.e += rawVarint32;
        return byteString3CopyFrom;
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public int readEnum() throws IOException {
        return readRawVarint32();
    }

    public int readFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public void readGroup(int i, MessageLite.a aVar, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int i2 = this.j;
        if (i2 >= 64) {
            throw InvalidProtocolBufferException.b();
        }
        this.j = i2 + 1;
        aVar.mergeFrom(this, extensionRegistryLite);
        checkLastTagWas((i << 3) | 4);
        this.j--;
    }

    public int readInt32() throws IOException {
        return readRawVarint32();
    }

    public long readInt64() throws IOException {
        return readRawVarint64();
    }

    public void readMessage(MessageLite.a aVar, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int rawVarint32 = readRawVarint32();
        if (this.j >= 64) {
            throw InvalidProtocolBufferException.b();
        }
        int iPushLimit = pushLimit(rawVarint32);
        this.j++;
        aVar.mergeFrom(this, extensionRegistryLite);
        checkLastTagWas(0);
        this.j--;
        popLimit(iPushLimit);
    }

    public byte readRawByte() throws IOException {
        if (this.e == this.c) {
            d(1);
        }
        byte[] bArr = this.a;
        int i = this.e;
        this.e = i + 1;
        return bArr[i];
    }

    public int readRawLittleEndian32() throws IOException {
        int i = this.e;
        if (this.c - i < 4) {
            d(4);
            i = this.e;
        }
        byte[] bArr = this.a;
        this.e = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public long readRawLittleEndian64() throws IOException {
        int i = this.e;
        if (this.c - i < 8) {
            d(8);
            i = this.e;
        }
        byte[] bArr = this.a;
        this.e = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x007a, code lost:
    
        if (r2[r3] < 0) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int readRawVarint32() throws IOException {
        int i;
        long j;
        int i2 = this.e;
        int i3 = this.c;
        if (i3 != i2) {
            byte[] bArr = this.a;
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                this.e = i4;
                return b2;
            }
            if (i3 - i4 >= 9) {
                int i5 = i4 + 1;
                int i6 = b2 ^ (bArr[i4] << 7);
                long j2 = i6;
                if (j2 >= 0) {
                    int i7 = i5 + 1;
                    int i8 = i6 ^ (bArr[i5] << 14);
                    long j3 = i8;
                    if (j3 < 0) {
                        i5 = i7 + 1;
                        int i9 = i8 ^ (bArr[i7] << 21);
                        j2 = i9;
                        if (j2 < 0) {
                            j = -2080896;
                        } else {
                            i7 = i5 + 1;
                            byte b3 = bArr[i5];
                            i = (int) (((long) (i9 ^ (b3 << 28))) ^ 266354560);
                            if (b3 < 0) {
                                i5 = i7 + 1;
                                if (bArr[i7] < 0) {
                                    i7 = i5 + 1;
                                    if (bArr[i5] < 0) {
                                        i5 = i7 + 1;
                                        if (bArr[i7] < 0) {
                                            i7 = i5 + 1;
                                            if (bArr[i5] < 0) {
                                                i5 = i7 + 1;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        this.e = i5;
                        return i;
                    }
                    i = (int) (16256 ^ j3);
                    i5 = i7;
                    this.e = i5;
                    return i;
                }
                j = -128;
                i = (int) (j2 ^ j);
                this.e = i5;
                return i;
            }
        }
        return (int) b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b6, code lost:
    
        if (r2[r0] < 0) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long readRawVarint64() throws IOException {
        long j;
        long j2;
        long j3;
        int i = this.e;
        int i2 = this.c;
        if (i2 != i) {
            byte[] bArr = this.a;
            int i3 = i + 1;
            byte b2 = bArr[i];
            if (b2 >= 0) {
                this.e = i3;
                return b2;
            }
            if (i2 - i3 >= 9) {
                int i4 = i3 + 1;
                long j4 = b2 ^ (bArr[i3] << 7);
                if (j4 >= 0) {
                    int i5 = i4 + 1;
                    long j5 = j4 ^ ((long) (bArr[i4] << 14));
                    if (j5 >= 0) {
                        j3 = 16256;
                    } else {
                        i4 = i5 + 1;
                        j4 = j5 ^ ((long) (bArr[i5] << 21));
                        if (j4 < 0) {
                            j2 = -2080896;
                        } else {
                            i5 = i4 + 1;
                            j5 = j4 ^ (((long) bArr[i4]) << 28);
                            if (j5 >= 0) {
                                j3 = 266354560;
                            } else {
                                i4 = i5 + 1;
                                j4 = j5 ^ (((long) bArr[i5]) << 35);
                                if (j4 >= 0) {
                                    i5 = i4 + 1;
                                    j5 = j4 ^ (((long) bArr[i4]) << 42);
                                    if (j5 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i4 = i5 + 1;
                                        j4 = j5 ^ (((long) bArr[i5]) << 49);
                                        if (j4 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            int i6 = i4 + 1;
                                            long j6 = (j4 ^ (((long) bArr[i4]) << 56)) ^ 71499008037633920L;
                                            i4 = j6 < 0 ? i6 + 1 : i6;
                                            j = j6;
                                        }
                                    }
                                    this.e = i4;
                                    return j;
                                }
                                j2 = -34093383808L;
                            }
                        }
                    }
                    j = j5 ^ j3;
                    i4 = i5;
                    this.e = i4;
                    return j;
                }
                j2 = -128;
                j = j4 ^ j2;
                this.e = i4;
                return j;
            }
        }
        return b();
    }

    public int readSFixed32() throws IOException {
        return readRawLittleEndian32();
    }

    public long readSFixed64() throws IOException {
        return readRawLittleEndian64();
    }

    public int readSInt32() throws IOException {
        return decodeZigZag32(readRawVarint32());
    }

    public long readSInt64() throws IOException {
        return decodeZigZag64(readRawVarint64());
    }

    public String readString() throws IOException {
        int rawVarint32 = readRawVarint32();
        if (rawVarint32 > this.c - this.e || rawVarint32 <= 0) {
            return rawVarint32 == 0 ? "" : new String(a(rawVarint32), Constants.ENCODING);
        }
        String str = new String(this.a, this.e, rawVarint32, Constants.ENCODING);
        this.e += rawVarint32;
        return str;
    }

    public String readStringRequireUtf8() throws IOException {
        byte[] bArrA;
        int rawVarint32 = readRawVarint32();
        int i = this.e;
        if (rawVarint32 <= this.c - i && rawVarint32 > 0) {
            bArrA = this.a;
            this.e = i + rawVarint32;
        } else {
            if (rawVarint32 == 0) {
                return "";
            }
            bArrA = a(rawVarint32);
            i = 0;
        }
        if (Utf8.isValidUtf8(bArrA, i, i + rawVarint32)) {
            return new String(bArrA, i, rawVarint32, Constants.ENCODING);
        }
        throw new InvalidProtocolBufferException("Protocol message had invalid UTF-8.");
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            this.g = 0;
            return 0;
        }
        int rawVarint32 = readRawVarint32();
        this.g = rawVarint32;
        if (WireFormat.getTagFieldNumber(rawVarint32) != 0) {
            return this.g;
        }
        throw new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
    }

    public int readUInt32() throws IOException {
        return readRawVarint32();
    }

    public long readUInt64() throws IOException {
        return readRawVarint64();
    }

    public boolean skipField(int i, CodedOutputStream codedOutputStream) throws IOException {
        int i2 = i & 7;
        if (i2 == 0) {
            long int64 = readInt64();
            codedOutputStream.writeRawVarint32(i);
            codedOutputStream.writeUInt64NoTag(int64);
            return true;
        }
        if (i2 == 1) {
            long rawLittleEndian64 = readRawLittleEndian64();
            codedOutputStream.writeRawVarint32(i);
            codedOutputStream.writeFixed64NoTag(rawLittleEndian64);
            return true;
        }
        if (i2 == 2) {
            ByteString3 bytes = readBytes();
            codedOutputStream.writeRawVarint32(i);
            codedOutputStream.writeBytesNoTag(bytes);
            return true;
        }
        if (i2 == 3) {
            codedOutputStream.writeRawVarint32(i);
            skipMessage(codedOutputStream);
            int tagFieldNumber = (WireFormat.getTagFieldNumber(i) << 3) | 4;
            checkLastTagWas(tagFieldNumber);
            codedOutputStream.writeRawVarint32(tagFieldNumber);
            return true;
        }
        if (i2 == 4) {
            return false;
        }
        if (i2 != 5) {
            throw new InvalidProtocolBufferException("Protocol message tag had invalid wire type.");
        }
        int rawLittleEndian32 = readRawLittleEndian32();
        codedOutputStream.writeRawVarint32(i);
        codedOutputStream.writeFixed32NoTag(rawLittleEndian32);
        return true;
    }

    public void skipMessage(CodedOutputStream codedOutputStream) throws IOException {
        int tag;
        do {
            tag = readTag();
            if (tag == 0) {
                return;
            }
        } while (skipField(tag, codedOutputStream));
    }

    public void skipRawBytes(int i) throws IOException {
        int i2 = this.c;
        int i3 = this.e;
        if (i <= i2 - i3 && i >= 0) {
            this.e = i3 + i;
            return;
        }
        if (i < 0) {
            throw InvalidProtocolBufferException.a();
        }
        int i4 = this.h;
        int i5 = i4 + i3 + i;
        int i6 = this.i;
        if (i5 > i6) {
            skipRawBytes((i6 - i4) - i3);
            throw InvalidProtocolBufferException.c();
        }
        int i7 = i2 - i3;
        this.e = i2;
        d(1);
        while (true) {
            int i8 = i - i7;
            int i9 = this.c;
            if (i8 <= i9) {
                this.e = i8;
                return;
            } else {
                i7 += i9;
                this.e = i9;
                d(1);
            }
        }
    }

    public <T extends MessageLite> T readMessage(Parser2<T> parser2, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int rawVarint32 = readRawVarint32();
        if (this.j < 64) {
            int iPushLimit = pushLimit(rawVarint32);
            this.j++;
            T partialFrom = parser2.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.j--;
            popLimit(iPushLimit);
            return partialFrom;
        }
        throw InvalidProtocolBufferException.b();
    }

    public static int readRawVarint32(int i, InputStream inputStream) throws IOException {
        if ((i & 128) == 0) {
            return i;
        }
        int i2 = i & Opcodes.LAND;
        int i3 = 7;
        while (i3 < 32) {
            int i4 = inputStream.read();
            if (i4 == -1) {
                throw InvalidProtocolBufferException.c();
            }
            i2 |= (i4 & Opcodes.LAND) << i3;
            if ((i4 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        while (i3 < 64) {
            int i5 = inputStream.read();
            if (i5 == -1) {
                throw InvalidProtocolBufferException.c();
            }
            if ((i5 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        throw new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
    }
}
