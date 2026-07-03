package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import com.adjust.sdk.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import org.objectweb.asm.Opcodes;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.d */
/* JADX INFO: compiled from: CodedInputStream.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11724d {

    /* JADX INFO: renamed from: d */
    public int f24110d;

    /* JADX INFO: renamed from: f */
    public final InputStream f24112f;

    /* JADX INFO: renamed from: g */
    public int f24113g;

    /* JADX INFO: renamed from: j */
    public int f24116j;

    /* JADX INFO: renamed from: i */
    public int f24115i = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: a */
    public final byte[] f24107a = new byte[4096];

    /* JADX INFO: renamed from: c */
    public int f24109c = 0;

    /* JADX INFO: renamed from: e */
    public int f24111e = 0;

    /* JADX INFO: renamed from: h */
    public int f24114h = 0;

    /* JADX INFO: renamed from: b */
    public final boolean f24108b = false;

    public C11724d(InputStream inputStream) {
        this.f24112f = inputStream;
    }

    public static int decodeZigZag32(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long decodeZigZag64(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static C11724d newInstance(InputStream inputStream) {
        return new C11724d(inputStream);
    }

    /* JADX INFO: renamed from: a */
    public final byte[] m9833a(int i) throws IOException {
        if (i <= 0) {
            if (i == 0) {
                return C11728h.f24142a;
            }
            throw InvalidProtocolBufferException.m10895a();
        }
        int i2 = this.f24114h;
        int i3 = this.f24111e;
        int i4 = i2 + i3 + i;
        int i5 = this.f24115i;
        if (i4 > i5) {
            skipRawBytes((i5 - i2) - i3);
            throw InvalidProtocolBufferException.m10897c();
        }
        if (i < 4096) {
            byte[] bArr = new byte[i];
            int i6 = this.f24109c - i3;
            System.arraycopy(this.f24107a, i3, bArr, 0, i6);
            int i7 = this.f24109c;
            this.f24111e = i7;
            int i8 = i - i6;
            if (i7 - i7 < i8 && !m9837e(i8)) {
                throw InvalidProtocolBufferException.m10897c();
            }
            System.arraycopy(this.f24107a, 0, bArr, i6, i8);
            this.f24111e = i8;
            return bArr;
        }
        int i9 = this.f24109c;
        this.f24114h = i2 + i9;
        this.f24111e = 0;
        this.f24109c = 0;
        int length = i9 - i3;
        int i10 = i - length;
        ArrayList<byte[]> arrayList = new ArrayList();
        while (i10 > 0) {
            int iMin = Math.min(i10, 4096);
            byte[] bArr2 = new byte[iMin];
            int i11 = 0;
            while (i11 < iMin) {
                InputStream inputStream = this.f24112f;
                int i12 = inputStream == null ? -1 : inputStream.read(bArr2, i11, iMin - i11);
                if (i12 == -1) {
                    throw InvalidProtocolBufferException.m10897c();
                }
                this.f24114h += i12;
                i11 += i12;
            }
            i10 -= iMin;
            arrayList.add(bArr2);
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(this.f24107a, i3, bArr3, 0, length);
        for (byte[] bArr4 : arrayList) {
            System.arraycopy(bArr4, 0, bArr3, length, bArr4.length);
            length += bArr4.length;
        }
        return bArr3;
    }

    /* JADX INFO: renamed from: b */
    public long m9834b() throws IOException {
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

    /* JADX INFO: renamed from: c */
    public final void m9835c() {
        int i = this.f24109c + this.f24110d;
        this.f24109c = i;
        int i2 = this.f24114h + i;
        int i3 = this.f24115i;
        if (i2 <= i3) {
            this.f24110d = 0;
            return;
        }
        int i4 = i2 - i3;
        this.f24110d = i4;
        this.f24109c = i - i4;
    }

    public void checkLastTagWas(int i) throws InvalidProtocolBufferException {
        if (this.f24113g != i) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m9836d(int i) throws IOException {
        if (!m9837e(i)) {
            throw InvalidProtocolBufferException.m10897c();
        }
    }

    /* JADX INFO: renamed from: e */
    public final boolean m9837e(int i) throws IOException {
        int i2 = this.f24111e;
        int i3 = i2 + i;
        int i4 = this.f24109c;
        if (i3 <= i4) {
            StringBuilder sb = new StringBuilder(77);
            sb.append("refillBuffer() called when ");
            sb.append(i);
            sb.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb.toString());
        }
        if (this.f24114h + i2 + i <= this.f24115i && this.f24112f != null) {
            if (i2 > 0) {
                if (i4 > i2) {
                    byte[] bArr = this.f24107a;
                    System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
                }
                this.f24114h += i2;
                this.f24109c -= i2;
                this.f24111e = 0;
            }
            InputStream inputStream = this.f24112f;
            byte[] bArr2 = this.f24107a;
            int i5 = this.f24109c;
            int i6 = inputStream.read(bArr2, i5, bArr2.length - i5);
            if (i6 == 0 || i6 < -1 || i6 > this.f24107a.length) {
                StringBuilder sb2 = new StringBuilder(102);
                sb2.append("InputStream#read(byte[]) returned invalid result: ");
                sb2.append(i6);
                sb2.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb2.toString());
            }
            if (i6 > 0) {
                this.f24109c += i6;
                if ((this.f24114h + i) - 67108864 > 0) {
                    throw new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
                }
                m9835c();
                if (this.f24109c >= i) {
                    return true;
                }
                return m9837e(i);
            }
        }
        return false;
    }

    public int getBytesUntilLimit() {
        int i = this.f24115i;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.f24114h + this.f24111e);
    }

    public boolean isAtEnd() throws IOException {
        return this.f24111e == this.f24109c && !m9837e(1);
    }

    public void popLimit(int i) {
        this.f24115i = i;
        m9835c();
    }

    public int pushLimit(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw InvalidProtocolBufferException.m10895a();
        }
        int i2 = this.f24114h + this.f24111e + i;
        int i3 = this.f24115i;
        if (i2 > i3) {
            throw InvalidProtocolBufferException.m10897c();
        }
        this.f24115i = i2;
        m9835c();
        return i3;
    }

    public boolean readBool() throws IOException {
        return readRawVarint64() != 0;
    }

    public AbstractC11723c readBytes() throws IOException {
        int rawVarint32 = readRawVarint32();
        int i = this.f24109c;
        int i2 = this.f24111e;
        if (rawVarint32 > i - i2 || rawVarint32 <= 0) {
            return rawVarint32 == 0 ? AbstractC11723c.f24100j : new C11733m(m9833a(rawVarint32));
        }
        boolean z2 = this.f24108b;
        AbstractC11723c abstractC11723cCopyFrom = AbstractC11723c.copyFrom(this.f24107a, i2, rawVarint32);
        this.f24111e += rawVarint32;
        return abstractC11723cCopyFrom;
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

    public void readGroup(int i, InterfaceC11734n.a aVar, C11725e c11725e) throws IOException {
        int i2 = this.f24116j;
        if (i2 >= 64) {
            throw InvalidProtocolBufferException.m10896b();
        }
        this.f24116j = i2 + 1;
        aVar.mergeFrom(this, c11725e);
        checkLastTagWas((i << 3) | 4);
        this.f24116j--;
    }

    public int readInt32() throws IOException {
        return readRawVarint32();
    }

    public long readInt64() throws IOException {
        return readRawVarint64();
    }

    public void readMessage(InterfaceC11734n.a aVar, C11725e c11725e) throws IOException {
        int rawVarint32 = readRawVarint32();
        if (this.f24116j >= 64) {
            throw InvalidProtocolBufferException.m10896b();
        }
        int iPushLimit = pushLimit(rawVarint32);
        this.f24116j++;
        aVar.mergeFrom(this, c11725e);
        checkLastTagWas(0);
        this.f24116j--;
        popLimit(iPushLimit);
    }

    public byte readRawByte() throws IOException {
        if (this.f24111e == this.f24109c) {
            m9836d(1);
        }
        byte[] bArr = this.f24107a;
        int i = this.f24111e;
        this.f24111e = i + 1;
        return bArr[i];
    }

    public int readRawLittleEndian32() throws IOException {
        int i = this.f24111e;
        if (this.f24109c - i < 4) {
            m9836d(4);
            i = this.f24111e;
        }
        byte[] bArr = this.f24107a;
        this.f24111e = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public long readRawLittleEndian64() throws IOException {
        int i = this.f24111e;
        if (this.f24109c - i < 8) {
            m9836d(8);
            i = this.f24111e;
        }
        byte[] bArr = this.f24107a;
        this.f24111e = i + 8;
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
        int i2 = this.f24111e;
        int i3 = this.f24109c;
        if (i3 != i2) {
            byte[] bArr = this.f24107a;
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                this.f24111e = i4;
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
                        this.f24111e = i5;
                        return i;
                    }
                    i = (int) (16256 ^ j3);
                    i5 = i7;
                    this.f24111e = i5;
                    return i;
                }
                j = -128;
                i = (int) (j2 ^ j);
                this.f24111e = i5;
                return i;
            }
        }
        return (int) m9834b();
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
        int i = this.f24111e;
        int i2 = this.f24109c;
        if (i2 != i) {
            byte[] bArr = this.f24107a;
            int i3 = i + 1;
            byte b2 = bArr[i];
            if (b2 >= 0) {
                this.f24111e = i3;
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
                                    this.f24111e = i4;
                                    return j;
                                }
                                j2 = -34093383808L;
                            }
                        }
                    }
                    j = j5 ^ j3;
                    i4 = i5;
                    this.f24111e = i4;
                    return j;
                }
                j2 = -128;
                j = j4 ^ j2;
                this.f24111e = i4;
                return j;
            }
        }
        return m9834b();
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
        if (rawVarint32 > this.f24109c - this.f24111e || rawVarint32 <= 0) {
            return rawVarint32 == 0 ? "" : new String(m9833a(rawVarint32), Constants.ENCODING);
        }
        String str = new String(this.f24107a, this.f24111e, rawVarint32, Constants.ENCODING);
        this.f24111e += rawVarint32;
        return str;
    }

    public String readStringRequireUtf8() throws IOException {
        byte[] bArrM9833a;
        int rawVarint32 = readRawVarint32();
        int i = this.f24111e;
        if (rawVarint32 <= this.f24109c - i && rawVarint32 > 0) {
            bArrM9833a = this.f24107a;
            this.f24111e = i + rawVarint32;
        } else {
            if (rawVarint32 == 0) {
                return "";
            }
            bArrM9833a = m9833a(rawVarint32);
            i = 0;
        }
        if (C11742v.isValidUtf8(bArrM9833a, i, i + rawVarint32)) {
            return new String(bArrM9833a, i, rawVarint32, Constants.ENCODING);
        }
        throw new InvalidProtocolBufferException("Protocol message had invalid UTF-8.");
    }

    public int readTag() throws IOException {
        if (isAtEnd()) {
            this.f24113g = 0;
            return 0;
        }
        int rawVarint32 = readRawVarint32();
        this.f24113g = rawVarint32;
        if (C11743w.getTagFieldNumber(rawVarint32) != 0) {
            return this.f24113g;
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
            AbstractC11723c bytes = readBytes();
            codedOutputStream.writeRawVarint32(i);
            codedOutputStream.writeBytesNoTag(bytes);
            return true;
        }
        if (i2 == 3) {
            codedOutputStream.writeRawVarint32(i);
            skipMessage(codedOutputStream);
            int tagFieldNumber = (C11743w.getTagFieldNumber(i) << 3) | 4;
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
        int i2 = this.f24109c;
        int i3 = this.f24111e;
        if (i <= i2 - i3 && i >= 0) {
            this.f24111e = i3 + i;
            return;
        }
        if (i < 0) {
            throw InvalidProtocolBufferException.m10895a();
        }
        int i4 = this.f24114h;
        int i5 = i4 + i3 + i;
        int i6 = this.f24115i;
        if (i5 > i6) {
            skipRawBytes((i6 - i4) - i3);
            throw InvalidProtocolBufferException.m10897c();
        }
        int i7 = i2 - i3;
        this.f24111e = i2;
        m9836d(1);
        while (true) {
            int i8 = i - i7;
            int i9 = this.f24109c;
            if (i8 <= i9) {
                this.f24111e = i8;
                return;
            } else {
                i7 += i9;
                this.f24111e = i9;
                m9836d(1);
            }
        }
    }

    public <T extends InterfaceC11734n> T readMessage(InterfaceC11736p<T> interfaceC11736p, C11725e c11725e) throws IOException {
        int rawVarint32 = readRawVarint32();
        if (this.f24116j < 64) {
            int iPushLimit = pushLimit(rawVarint32);
            this.f24116j++;
            T partialFrom = interfaceC11736p.parsePartialFrom(this, c11725e);
            checkLastTagWas(0);
            this.f24116j--;
            popLimit(iPushLimit);
            return partialFrom;
        }
        throw InvalidProtocolBufferException.m10896b();
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
                throw InvalidProtocolBufferException.m10897c();
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
                throw InvalidProtocolBufferException.m10897c();
            }
            if ((i5 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        throw new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
    }
}
