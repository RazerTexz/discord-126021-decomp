package kotlin.reflect.jvm.internal.impl.protobuf;

import com.adjust.sdk.Constants;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11730j;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n;

/* JADX INFO: loaded from: classes3.dex */
public final class CodedOutputStream {

    /* JADX INFO: renamed from: a */
    public final byte[] f27445a;

    /* JADX INFO: renamed from: b */
    public final int f27446b;

    /* JADX INFO: renamed from: e */
    public final OutputStream f27449e;

    /* JADX INFO: renamed from: d */
    public int f27448d = 0;

    /* JADX INFO: renamed from: c */
    public int f27447c = 0;

    public static class OutOfSpaceException extends IOException {
        public OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.f27449e = outputStream;
        this.f27445a = bArr;
        this.f27446b = bArr.length;
    }

    public static int computeBoolSize(int i, boolean z2) {
        return computeBoolSizeNoTag(z2) + computeTagSize(i);
    }

    public static int computeBoolSizeNoTag(boolean z2) {
        return 1;
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeRawVarint32Size(bArr.length) + bArr.length;
    }

    public static int computeBytesSize(int i, AbstractC11723c abstractC11723c) {
        return computeBytesSizeNoTag(abstractC11723c) + computeTagSize(i);
    }

    public static int computeBytesSizeNoTag(AbstractC11723c abstractC11723c) {
        return abstractC11723c.size() + computeRawVarint32Size(abstractC11723c.size());
    }

    public static int computeDoubleSize(int i, double d) {
        return computeDoubleSizeNoTag(d) + computeTagSize(i);
    }

    public static int computeDoubleSizeNoTag(double d) {
        return 8;
    }

    public static int computeEnumSize(int i, int i2) {
        return computeEnumSizeNoTag(i2) + computeTagSize(i);
    }

    public static int computeEnumSizeNoTag(int i) {
        return computeInt32SizeNoTag(i);
    }

    public static int computeFixed32SizeNoTag(int i) {
        return 4;
    }

    public static int computeFixed64SizeNoTag(long j) {
        return 8;
    }

    public static int computeFloatSize(int i, float f) {
        return computeFloatSizeNoTag(f) + computeTagSize(i);
    }

    public static int computeFloatSizeNoTag(float f) {
        return 4;
    }

    public static int computeGroupSizeNoTag(InterfaceC11734n interfaceC11734n) {
        return interfaceC11734n.getSerializedSize();
    }

    public static int computeInt32Size(int i, int i2) {
        return computeInt32SizeNoTag(i2) + computeTagSize(i);
    }

    public static int computeInt32SizeNoTag(int i) {
        if (i >= 0) {
            return computeRawVarint32Size(i);
        }
        return 10;
    }

    public static int computeInt64SizeNoTag(long j) {
        return computeRawVarint64Size(j);
    }

    public static int computeLazyFieldSizeNoTag(C11730j c11730j) {
        int serializedSize = c11730j.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }

    public static int computeMessageSize(int i, InterfaceC11734n interfaceC11734n) {
        return computeMessageSizeNoTag(interfaceC11734n) + computeTagSize(i);
    }

    public static int computeMessageSizeNoTag(InterfaceC11734n interfaceC11734n) {
        int serializedSize = interfaceC11734n.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }

    public static int computeRawVarint32Size(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int computeRawVarint64Size(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int computeSFixed32SizeNoTag(int i) {
        return 4;
    }

    public static int computeSFixed64SizeNoTag(long j) {
        return 8;
    }

    public static int computeSInt32SizeNoTag(int i) {
        return computeRawVarint32Size(encodeZigZag32(i));
    }

    public static int computeSInt64Size(int i, long j) {
        return computeSInt64SizeNoTag(j) + computeTagSize(i);
    }

    public static int computeSInt64SizeNoTag(long j) {
        return computeRawVarint64Size(encodeZigZag64(j));
    }

    public static int computeStringSizeNoTag(String str) {
        try {
            byte[] bytes = str.getBytes(Constants.ENCODING);
            return computeRawVarint32Size(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public static int computeTagSize(int i) {
        return computeRawVarint32Size((i << 3) | 0);
    }

    public static int computeUInt32SizeNoTag(int i) {
        return computeRawVarint32Size(i);
    }

    public static int computeUInt64SizeNoTag(long j) {
        return computeRawVarint64Size(j);
    }

    public static int encodeZigZag32(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static long encodeZigZag64(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i) {
        return new CodedOutputStream(outputStream, new byte[i]);
    }

    /* JADX INFO: renamed from: a */
    public final void m10894a() throws IOException {
        OutputStream outputStream = this.f27449e;
        if (outputStream == null) {
            throw new OutOfSpaceException();
        }
        outputStream.write(this.f27445a, 0, this.f27447c);
        this.f27447c = 0;
    }

    public void flush() throws IOException {
        if (this.f27449e != null) {
            m10894a();
        }
    }

    public void writeBool(int i, boolean z2) throws IOException {
        writeTag(i, 0);
        writeBoolNoTag(z2);
    }

    public void writeBoolNoTag(boolean z2) throws IOException {
        writeRawByte(z2 ? 1 : 0);
    }

    public void writeByteArrayNoTag(byte[] bArr) throws IOException {
        writeRawVarint32(bArr.length);
        writeRawBytes(bArr);
    }

    public void writeBytes(int i, AbstractC11723c abstractC11723c) throws IOException {
        writeTag(i, 2);
        writeBytesNoTag(abstractC11723c);
    }

    public void writeBytesNoTag(AbstractC11723c abstractC11723c) throws IOException {
        writeRawVarint32(abstractC11723c.size());
        writeRawBytes(abstractC11723c);
    }

    public void writeDouble(int i, double d) throws IOException {
        writeTag(i, 1);
        writeDoubleNoTag(d);
    }

    public void writeDoubleNoTag(double d) throws IOException {
        writeRawLittleEndian64(Double.doubleToRawLongBits(d));
    }

    public void writeEnum(int i, int i2) throws IOException {
        writeTag(i, 0);
        writeEnumNoTag(i2);
    }

    public void writeEnumNoTag(int i) throws IOException {
        writeInt32NoTag(i);
    }

    public void writeFixed32NoTag(int i) throws IOException {
        writeRawLittleEndian32(i);
    }

    public void writeFixed64NoTag(long j) throws IOException {
        writeRawLittleEndian64(j);
    }

    public void writeFloat(int i, float f) throws IOException {
        writeTag(i, 5);
        writeFloatNoTag(f);
    }

    public void writeFloatNoTag(float f) throws IOException {
        writeRawLittleEndian32(Float.floatToRawIntBits(f));
    }

    public void writeGroup(int i, InterfaceC11734n interfaceC11734n) throws IOException {
        writeTag(i, 3);
        writeGroupNoTag(interfaceC11734n);
        writeTag(i, 4);
    }

    public void writeGroupNoTag(InterfaceC11734n interfaceC11734n) throws IOException {
        interfaceC11734n.writeTo(this);
    }

    public void writeInt32(int i, int i2) throws IOException {
        writeTag(i, 0);
        writeInt32NoTag(i2);
    }

    public void writeInt32NoTag(int i) throws IOException {
        if (i >= 0) {
            writeRawVarint32(i);
        } else {
            writeRawVarint64(i);
        }
    }

    public void writeInt64NoTag(long j) throws IOException {
        writeRawVarint64(j);
    }

    public void writeMessage(int i, InterfaceC11734n interfaceC11734n) throws IOException {
        writeTag(i, 2);
        writeMessageNoTag(interfaceC11734n);
    }

    public void writeMessageNoTag(InterfaceC11734n interfaceC11734n) throws IOException {
        writeRawVarint32(interfaceC11734n.getSerializedSize());
        interfaceC11734n.writeTo(this);
    }

    public void writeMessageSetExtension(int i, InterfaceC11734n interfaceC11734n) throws IOException {
        writeTag(1, 3);
        writeUInt32(2, i);
        writeMessage(3, interfaceC11734n);
        writeTag(1, 4);
    }

    public void writeRawByte(byte b2) throws IOException {
        if (this.f27447c == this.f27446b) {
            m10894a();
        }
        byte[] bArr = this.f27445a;
        int i = this.f27447c;
        this.f27447c = i + 1;
        bArr[i] = b2;
        this.f27448d++;
    }

    public void writeRawBytes(AbstractC11723c abstractC11723c) throws IOException {
        writeRawBytes(abstractC11723c, 0, abstractC11723c.size());
    }

    public void writeRawLittleEndian32(int i) throws IOException {
        writeRawByte(i & 255);
        writeRawByte((i >> 8) & 255);
        writeRawByte((i >> 16) & 255);
        writeRawByte((i >> 24) & 255);
    }

    public void writeRawLittleEndian64(long j) throws IOException {
        writeRawByte(((int) j) & 255);
        writeRawByte(((int) (j >> 8)) & 255);
        writeRawByte(((int) (j >> 16)) & 255);
        writeRawByte(((int) (j >> 24)) & 255);
        writeRawByte(((int) (j >> 32)) & 255);
        writeRawByte(((int) (j >> 40)) & 255);
        writeRawByte(((int) (j >> 48)) & 255);
        writeRawByte(((int) (j >> 56)) & 255);
    }

    public void writeRawVarint32(int i) throws IOException {
        while ((i & (-128)) != 0) {
            writeRawByte((i & Opcodes.LAND) | 128);
            i >>>= 7;
        }
        writeRawByte(i);
    }

    public void writeRawVarint64(long j) throws IOException {
        while (((-128) & j) != 0) {
            writeRawByte((((int) j) & Opcodes.LAND) | 128);
            j >>>= 7;
        }
        writeRawByte((int) j);
    }

    public void writeSFixed32NoTag(int i) throws IOException {
        writeRawLittleEndian32(i);
    }

    public void writeSFixed64NoTag(long j) throws IOException {
        writeRawLittleEndian64(j);
    }

    public void writeSInt32NoTag(int i) throws IOException {
        writeRawVarint32(encodeZigZag32(i));
    }

    public void writeSInt64(int i, long j) throws IOException {
        writeTag(i, 0);
        writeSInt64NoTag(j);
    }

    public void writeSInt64NoTag(long j) throws IOException {
        writeRawVarint64(encodeZigZag64(j));
    }

    public void writeStringNoTag(String str) throws IOException {
        byte[] bytes = str.getBytes(Constants.ENCODING);
        writeRawVarint32(bytes.length);
        writeRawBytes(bytes);
    }

    public void writeTag(int i, int i2) throws IOException {
        writeRawVarint32((i << 3) | i2);
    }

    public void writeUInt32(int i, int i2) throws IOException {
        writeTag(i, 0);
        writeUInt32NoTag(i2);
    }

    public void writeUInt32NoTag(int i) throws IOException {
        writeRawVarint32(i);
    }

    public void writeUInt64NoTag(long j) throws IOException {
        writeRawVarint64(j);
    }

    public void writeRawBytes(byte[] bArr) throws IOException {
        writeRawBytes(bArr, 0, bArr.length);
    }

    public void writeRawBytes(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f27446b;
        int i4 = this.f27447c;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.f27445a, i4, i2);
            this.f27447c += i2;
            this.f27448d += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy(bArr, i, this.f27445a, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.f27447c = this.f27446b;
        this.f27448d += i5;
        m10894a();
        if (i7 <= this.f27446b) {
            System.arraycopy(bArr, i6, this.f27445a, 0, i7);
            this.f27447c = i7;
        } else {
            this.f27449e.write(bArr, i6, i7);
        }
        this.f27448d += i7;
    }

    public void writeRawByte(int i) throws IOException {
        writeRawByte((byte) i);
    }

    public void writeRawBytes(AbstractC11723c abstractC11723c, int i, int i2) throws IOException {
        int i3 = this.f27446b;
        int i4 = this.f27447c;
        if (i3 - i4 >= i2) {
            abstractC11723c.copyTo(this.f27445a, i, i4, i2);
            this.f27447c += i2;
            this.f27448d += i2;
            return;
        }
        int i5 = i3 - i4;
        abstractC11723c.copyTo(this.f27445a, i, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.f27447c = this.f27446b;
        this.f27448d += i5;
        m10894a();
        if (i7 <= this.f27446b) {
            abstractC11723c.copyTo(this.f27445a, i6, 0, i7);
            this.f27447c = i7;
        } else {
            OutputStream outputStream = this.f27449e;
            if (i6 < 0) {
                throw new IndexOutOfBoundsException(C1643a.m851g(30, "Source offset < 0: ", i6));
            }
            if (i7 >= 0) {
                int i8 = i6 + i7;
                if (i8 > abstractC11723c.size()) {
                    throw new IndexOutOfBoundsException(C1643a.m851g(39, "Source end offset exceeded: ", i8));
                }
                if (i7 > 0) {
                    abstractC11723c.mo9830k(outputStream, i6, i7);
                }
            } else {
                throw new IndexOutOfBoundsException(C1643a.m851g(23, "Length < 0: ", i7));
            }
        }
        this.f27448d += i7;
    }
}
