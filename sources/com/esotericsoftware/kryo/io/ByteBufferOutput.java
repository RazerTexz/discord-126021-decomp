package com.esotericsoftware.kryo.io;

import b.d.b.a.outline;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferOutput extends Output {
    public static final ByteOrder nativeOrder = ByteOrder.nativeOrder();
    public ByteOrder byteOrder;
    public ByteBuffer niobuffer;
    public boolean varIntsEnabled;

    public ByteBufferOutput() {
        this.varIntsEnabled = true;
        this.byteOrder = ByteOrder.BIG_ENDIAN;
    }

    private boolean isNativeOrder() {
        return this.byteOrder == nativeOrder;
    }

    private void writeAscii_slow(String str, int i) throws KryoException {
        ByteBuffer byteBuffer = this.niobuffer;
        int iMin = Math.min(i, this.capacity - this.position);
        int i2 = 0;
        while (i2 < i) {
            byte[] bArr = new byte[i];
            int i3 = i2 + iMin;
            str.getBytes(i2, i3, bArr, 0);
            byteBuffer.put(bArr, 0, iMin);
            this.position += iMin;
            iMin = Math.min(i - i3, this.capacity);
            if (require(iMin)) {
                byteBuffer = this.niobuffer;
            }
            i2 = i3;
        }
    }

    private void writeString_slow(CharSequence charSequence, int i, int i2) {
        while (i2 < i) {
            int i3 = this.position;
            int i4 = this.capacity;
            if (i3 == i4) {
                require(Math.min(i4, i - i2));
            }
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt <= 127) {
                ByteBuffer byteBuffer = this.niobuffer;
                int i5 = this.position;
                this.position = i5 + 1;
                byteBuffer.put(i5, (byte) cCharAt);
            } else if (cCharAt > 2047) {
                ByteBuffer byteBuffer2 = this.niobuffer;
                int i6 = this.position;
                this.position = i6 + 1;
                byteBuffer2.put(i6, (byte) (((cCharAt >> '\f') & 15) | 224));
                require(2);
                ByteBuffer byteBuffer3 = this.niobuffer;
                int i7 = this.position;
                this.position = i7 + 1;
                byteBuffer3.put(i7, (byte) (((cCharAt >> 6) & 63) | 128));
                ByteBuffer byteBuffer4 = this.niobuffer;
                int i8 = this.position;
                this.position = i8 + 1;
                byteBuffer4.put(i8, (byte) ((cCharAt & '?') | 128));
            } else {
                ByteBuffer byteBuffer5 = this.niobuffer;
                int i9 = this.position;
                this.position = i9 + 1;
                byteBuffer5.put(i9, (byte) (((cCharAt >> 6) & 31) | Opcodes.CHECKCAST));
                require(1);
                ByteBuffer byteBuffer6 = this.niobuffer;
                int i10 = this.position;
                this.position = i10 + 1;
                byteBuffer6.put(i10, (byte) ((cCharAt & '?') | 128));
            }
            i2++;
        }
    }

    private void writeUtf8Length(int i) {
        int i2 = i >>> 6;
        if (i2 == 0) {
            require(1);
            this.niobuffer.put((byte) (i | 128));
            this.position++;
            return;
        }
        int i3 = i >>> 13;
        if (i3 == 0) {
            require(2);
            this.niobuffer.put((byte) (i | 64 | 128));
            this.niobuffer.put((byte) i2);
            this.position += 2;
            return;
        }
        int i4 = i >>> 20;
        if (i4 == 0) {
            require(3);
            this.niobuffer.put((byte) (i | 64 | 128));
            this.niobuffer.put((byte) (i2 | 128));
            this.niobuffer.put((byte) i3);
            this.position += 3;
            return;
        }
        int i5 = i >>> 27;
        if (i5 == 0) {
            require(4);
            this.niobuffer.put((byte) (i | 64 | 128));
            this.niobuffer.put((byte) (i2 | 128));
            this.niobuffer.put((byte) (i3 | 128));
            this.niobuffer.put((byte) i4);
            this.position += 4;
            return;
        }
        require(5);
        this.niobuffer.put((byte) (i | 64 | 128));
        this.niobuffer.put((byte) (i2 | 128));
        this.niobuffer.put((byte) (i3 | 128));
        this.niobuffer.put((byte) (i4 | 128));
        this.niobuffer.put((byte) i5);
        this.position += 5;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void clear() {
        this.niobuffer.clear();
        this.position = 0;
        this.total = 0L;
    }

    @Override // com.esotericsoftware.kryo.io.Output, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws KryoException {
        flush();
        OutputStream outputStream = this.outputStream;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.esotericsoftware.kryo.io.Output, java.io.OutputStream, java.io.Flushable
    public void flush() throws KryoException {
        if (this.outputStream == null) {
            return;
        }
        try {
            byte[] bArr = new byte[this.position];
            this.niobuffer.position(0);
            this.niobuffer.get(bArr);
            this.niobuffer.position(0);
            this.outputStream.write(bArr, 0, this.position);
            this.total += (long) this.position;
            this.position = 0;
        } catch (IOException e) {
            throw new KryoException(e);
        }
    }

    public ByteBuffer getByteBuffer() {
        this.niobuffer.position(this.position);
        return this.niobuffer;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public OutputStream getOutputStream() {
        return this.outputStream;
    }

    public boolean getVarIntsEnabled() {
        return this.varIntsEnabled;
    }

    public ByteOrder order() {
        return this.byteOrder;
    }

    public void release() {
        clear();
        UnsafeUtil.releaseBuffer(this.niobuffer);
        this.niobuffer = null;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public boolean require(int i) throws KryoException {
        if (this.capacity - this.position >= i) {
            return false;
        }
        if (i > this.maxCapacity) {
            this.niobuffer.order(this.byteOrder);
            StringBuilder sbU = outline.U("Buffer overflow. Max capacity: ");
            sbU.append(this.maxCapacity);
            sbU.append(", required: ");
            sbU.append(i);
            throw new KryoException(sbU.toString());
        }
        flush();
        while (true) {
            int i2 = this.capacity;
            if (i2 - this.position >= i) {
                return true;
            }
            int i3 = this.maxCapacity;
            if (i2 == i3) {
                this.niobuffer.order(this.byteOrder);
                StringBuilder sbU2 = outline.U("Buffer overflow. Available: ");
                sbU2.append(this.capacity - this.position);
                sbU2.append(", required: ");
                sbU2.append(i);
                throw new KryoException(sbU2.toString());
            }
            if (i2 == 0) {
                this.capacity = 1;
            }
            int iMin = Math.min(this.capacity * 2, i3);
            this.capacity = iMin;
            if (iMin < 0) {
                this.capacity = this.maxCapacity;
            }
            ByteBuffer byteBuffer = this.niobuffer;
            ByteBuffer byteBufferAllocateDirect = (byteBuffer == null || byteBuffer.isDirect()) ? ByteBuffer.allocateDirect(this.capacity) : ByteBuffer.allocate(this.capacity);
            this.niobuffer.position(0);
            this.niobuffer.limit(this.position);
            byteBufferAllocateDirect.put(this.niobuffer);
            byteBufferAllocateDirect.order(this.niobuffer.order());
            ByteOrder byteOrder = this.byteOrder;
            setBuffer(byteBufferAllocateDirect, this.maxCapacity);
            this.byteOrder = byteOrder;
        }
    }

    public void setBuffer(ByteBuffer byteBuffer) {
        setBuffer(byteBuffer, byteBuffer.capacity());
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
        this.position = 0;
        this.total = 0L;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void setPosition(int i) {
        this.position = i;
        this.niobuffer.position(i);
    }

    public void setVarIntsEnabled(boolean z2) {
        this.varIntsEnabled = z2;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public byte[] toBytes() {
        byte[] bArr = new byte[this.position];
        this.niobuffer.position(0);
        this.niobuffer.get(bArr, 0, this.position);
        return bArr;
    }

    @Override // com.esotericsoftware.kryo.io.Output, java.io.OutputStream
    public void write(int i) throws KryoException {
        if (this.position == this.capacity) {
            require(1);
        }
        this.niobuffer.put((byte) i);
        this.position++;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void writeAscii(String str) throws KryoException {
        if (str == null) {
            writeByte(128);
            return;
        }
        int length = str.length();
        if (length == 0) {
            writeByte(Opcodes.LOR);
            return;
        }
        if (this.capacity - this.position < length) {
            writeAscii_slow(str, length);
        } else {
            byte[] bytes = str.getBytes();
            this.niobuffer.put(bytes, 0, bytes.length);
            this.position += length;
        }
        ByteBuffer byteBuffer = this.niobuffer;
        int i = this.position;
        byteBuffer.put(i - 1, (byte) (128 | byteBuffer.get(i - 1)));
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void writeBoolean(boolean z2) throws KryoException {
        require(1);
        this.niobuffer.put(z2 ? (byte) 1 : (byte) 0);
        this.position++;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void writeByte(byte b2) throws KryoException {
        if (this.position == this.capacity) {
            require(1);
        }
        this.niobuffer.put(b2);
        this.position++;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void writeBytes(byte[] bArr) throws KryoException {
        if (bArr == null) {
            throw new IllegalArgumentException("bytes cannot be null.");
        }
        writeBytes(bArr, 0, bArr.length);
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void writeChar(char c) throws KryoException {
        require(2);
        this.niobuffer.putChar(c);
        this.position += 2;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void writeChars(char[] cArr) throws KryoException {
        if (this.capacity - this.position < cArr.length * 2 || !isNativeOrder()) {
            super.writeChars(cArr);
            return;
        }
        this.niobuffer.asCharBuffer().put(cArr);
        this.position = (cArr.length * 2) + this.position;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void writeDouble(double d) throws KryoException {
        require(8);
        this.niobuffer.putDouble(d);
        this.position += 8;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void writeDoubles(double[] dArr) throws KryoException {
        if (this.capacity - this.position < dArr.length * 8 || !isNativeOrder()) {
            super.writeDoubles(dArr);
            return;
        }
        this.niobuffer.asDoubleBuffer().put(dArr);
        this.position = (dArr.length * 8) + this.position;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void writeFloat(float f) throws KryoException {
        require(4);
        this.niobuffer.putFloat(f);
        this.position += 4;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void writeFloats(float[] fArr) throws KryoException {
        if (this.capacity - this.position < fArr.length * 4 || !isNativeOrder()) {
            super.writeFloats(fArr);
            return;
        }
        this.niobuffer.asFloatBuffer().put(fArr);
        this.position = (fArr.length * 4) + this.position;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void writeInt(int i) throws KryoException {
        require(4);
        this.niobuffer.putInt(i);
        this.position += 4;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void writeInts(int[] iArr) throws KryoException {
        if (this.capacity - this.position < iArr.length * 4 || !isNativeOrder()) {
            super.writeInts(iArr);
            return;
        }
        this.niobuffer.asIntBuffer().put(iArr);
        this.position = (iArr.length * 4) + this.position;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void writeLong(long j) throws KryoException {
        require(8);
        this.niobuffer.putLong(j);
        this.position += 8;
    }

    public int writeLongS(long j, boolean z2) throws KryoException {
        long j2 = !z2 ? (j << 1) ^ (j >> 63) : j;
        long j3 = j2 >>> 7;
        if (j3 == 0) {
            require(1);
            this.niobuffer.put((byte) j2);
            this.position++;
            return 1;
        }
        long j4 = j2 >>> 14;
        if (j4 == 0) {
            require(2);
            this.niobuffer.put((byte) ((j2 & 127) | 128));
            this.niobuffer.put((byte) j3);
            this.position += 2;
            return 2;
        }
        long j5 = j2 >>> 21;
        if (j5 == 0) {
            require(3);
            this.niobuffer.put((byte) ((j2 & 127) | 128));
            this.niobuffer.put((byte) (j3 | 128));
            this.niobuffer.put((byte) j4);
            this.position += 3;
            return 3;
        }
        long j6 = j2 >>> 28;
        if (j6 == 0) {
            require(4);
            this.niobuffer.put((byte) ((j2 & 127) | 128));
            this.niobuffer.put((byte) (j3 | 128));
            this.niobuffer.put((byte) (j4 | 128));
            this.niobuffer.put((byte) j5);
            this.position += 4;
            return 4;
        }
        long j7 = j2 >>> 35;
        if (j7 == 0) {
            require(5);
            this.niobuffer.put((byte) ((j2 & 127) | 128));
            this.niobuffer.put((byte) (j3 | 128));
            this.niobuffer.put((byte) (j4 | 128));
            this.niobuffer.put((byte) (j5 | 128));
            this.niobuffer.put((byte) j6);
            this.position += 5;
            return 5;
        }
        long j8 = j2 >>> 42;
        if (j8 == 0) {
            require(6);
            this.niobuffer.put((byte) ((j2 & 127) | 128));
            this.niobuffer.put((byte) (j3 | 128));
            this.niobuffer.put((byte) (j4 | 128));
            this.niobuffer.put((byte) (j5 | 128));
            this.niobuffer.put((byte) (j6 | 128));
            this.niobuffer.put((byte) j7);
            this.position += 6;
            return 6;
        }
        long j9 = j2 >>> 49;
        if (j9 == 0) {
            require(7);
            this.niobuffer.put((byte) ((j2 & 127) | 128));
            this.niobuffer.put((byte) (j3 | 128));
            this.niobuffer.put((byte) (j4 | 128));
            this.niobuffer.put((byte) (j5 | 128));
            this.niobuffer.put((byte) (j6 | 128));
            this.niobuffer.put((byte) (j7 | 128));
            this.niobuffer.put((byte) j8);
            this.position += 7;
            return 7;
        }
        long j10 = j2 >>> 56;
        if (j10 == 0) {
            require(8);
            this.niobuffer.put((byte) ((j2 & 127) | 128));
            this.niobuffer.put((byte) (j3 | 128));
            this.niobuffer.put((byte) (j4 | 128));
            this.niobuffer.put((byte) (j5 | 128));
            this.niobuffer.put((byte) (j6 | 128));
            this.niobuffer.put((byte) (j7 | 128));
            this.niobuffer.put((byte) (j8 | 128));
            this.niobuffer.put((byte) j9);
            this.position += 8;
            return 8;
        }
        require(9);
        this.niobuffer.put((byte) ((j2 & 127) | 128));
        this.niobuffer.put((byte) (j3 | 128));
        this.niobuffer.put((byte) (j4 | 128));
        this.niobuffer.put((byte) (j5 | 128));
        this.niobuffer.put((byte) (j6 | 128));
        this.niobuffer.put((byte) (j7 | 128));
        this.niobuffer.put((byte) (j8 | 128));
        this.niobuffer.put((byte) (j9 | 128));
        this.niobuffer.put((byte) j10);
        this.position += 9;
        return 9;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void writeLongs(long[] jArr) throws KryoException {
        if (this.capacity - this.position < jArr.length * 8 || !isNativeOrder()) {
            super.writeLongs(jArr);
            return;
        }
        this.niobuffer.asLongBuffer().put(jArr);
        this.position = (jArr.length * 8) + this.position;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void writeShort(int i) throws KryoException {
        require(2);
        this.niobuffer.putShort((short) i);
        this.position += 2;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void writeShorts(short[] sArr) throws KryoException {
        if (this.capacity - this.position < sArr.length * 2 || !isNativeOrder()) {
            super.writeShorts(sArr);
            return;
        }
        this.niobuffer.asShortBuffer().put(sArr);
        this.position = (sArr.length * 2) + this.position;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void writeString(String str) throws KryoException {
        boolean z2;
        this.niobuffer.position(this.position);
        if (str == null) {
            writeByte(128);
            return;
        }
        int length = str.length();
        if (length == 0) {
            writeByte(Opcodes.LOR);
            return;
        }
        int i = 0;
        if (length > 1 && length < 64) {
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = true;
                    break;
                } else {
                    if (str.charAt(i2) > 127) {
                        z2 = false;
                        break;
                    }
                    i2++;
                }
            }
        } else {
            z2 = false;
            break;
        }
        if (z2) {
            if (this.capacity - this.position < length) {
                writeAscii_slow(str, length);
            } else {
                byte[] bytes = str.getBytes();
                this.niobuffer.put(bytes, 0, bytes.length);
                this.position += length;
            }
            ByteBuffer byteBuffer = this.niobuffer;
            int i3 = this.position;
            byteBuffer.put(i3 - 1, (byte) (128 | byteBuffer.get(i3 - 1)));
            return;
        }
        writeUtf8Length(length + 1);
        int i4 = this.capacity;
        int i5 = this.position;
        if (i4 - i5 >= length) {
            while (i < length) {
                char cCharAt = str.charAt(i);
                if (cCharAt > 127) {
                    break;
                }
                this.niobuffer.put(i5, (byte) cCharAt);
                i++;
                i5++;
            }
            this.position = i5;
            this.niobuffer.position(i5);
        }
        if (i < length) {
            writeString_slow(str, length, i);
        }
        this.niobuffer.position(this.position);
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public int writeVarInt(int i, boolean z2) throws KryoException {
        this.niobuffer.position(this.position);
        if (!z2) {
            i = (i >> 31) ^ (i << 1);
        }
        int i2 = i & Opcodes.LAND;
        int i3 = i >>> 7;
        if (i3 == 0) {
            writeByte(i2);
            return 1;
        }
        int i4 = i2 | 128 | ((i3 & Opcodes.LAND) << 8);
        int i5 = i3 >>> 7;
        if (i5 == 0) {
            this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
            writeInt(i4);
            this.niobuffer.order(this.byteOrder);
            int i6 = this.position - 2;
            this.position = i6;
            this.niobuffer.position(i6);
            return 2;
        }
        int i7 = i4 | 32768 | ((i5 & Opcodes.LAND) << 16);
        int i8 = i5 >>> 7;
        if (i8 == 0) {
            this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
            writeInt(i7);
            this.niobuffer.order(this.byteOrder);
            int i9 = this.position - 1;
            this.position = i9;
            this.niobuffer.position(i9);
            return 3;
        }
        int i10 = i7 | 8388608 | ((i8 & Opcodes.LAND) << 24);
        int i11 = i8 >>> 7;
        if (i11 == 0) {
            this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
            writeInt(i10);
            this.niobuffer.order(this.byteOrder);
            this.position += 0;
            return 4;
        }
        this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
        writeLong((((long) i11) << 32) | (((long) (i10 | Integer.MIN_VALUE)) & 4294967295L));
        this.niobuffer.order(this.byteOrder);
        int i12 = this.position - 3;
        this.position = i12;
        this.niobuffer.position(i12);
        return 5;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public int writeVarLong(long j, boolean z2) throws KryoException {
        long j2 = !z2 ? (j << 1) ^ (j >> 63) : j;
        int i = (int) (j2 & 127);
        long j3 = j2 >>> 7;
        if (j3 == 0) {
            writeByte(i);
            return 1;
        }
        int i2 = (int) (((long) (i | 128)) | ((j3 & 127) << 8));
        long j4 = j3 >>> 7;
        if (j4 == 0) {
            this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
            writeInt(i2);
            this.niobuffer.order(this.byteOrder);
            int i3 = this.position - 2;
            this.position = i3;
            this.niobuffer.position(i3);
            return 2;
        }
        int i4 = (int) (((long) (i2 | 32768)) | ((j4 & 127) << 16));
        long j5 = j4 >>> 7;
        if (j5 == 0) {
            this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
            writeInt(i4);
            this.niobuffer.order(this.byteOrder);
            int i5 = this.position - 1;
            this.position = i5;
            this.niobuffer.position(i5);
            return 3;
        }
        int i6 = (int) (((long) (i4 | 8388608)) | ((j5 & 127) << 24));
        long j6 = j5 >>> 7;
        if (j6 == 0) {
            this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
            writeInt(i6);
            this.niobuffer.order(this.byteOrder);
            this.position += 0;
            return 4;
        }
        long j7 = (((long) (Integer.MIN_VALUE | i6)) & 4294967295L) | ((j6 & 127) << 32);
        long j8 = j6 >>> 7;
        if (j8 == 0) {
            this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
            writeLong(j7);
            this.niobuffer.order(this.byteOrder);
            int i7 = this.position - 3;
            this.position = i7;
            this.niobuffer.position(i7);
            return 5;
        }
        long j9 = j7 | 549755813888L | ((j8 & 127) << 40);
        long j10 = j8 >>> 7;
        if (j10 == 0) {
            this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
            writeLong(j9);
            this.niobuffer.order(this.byteOrder);
            int i8 = this.position - 2;
            this.position = i8;
            this.niobuffer.position(i8);
            return 6;
        }
        long j11 = j9 | 140737488355328L | ((j10 & 127) << 48);
        long j12 = j10 >>> 7;
        if (j12 == 0) {
            this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
            writeLong(j11);
            this.niobuffer.order(this.byteOrder);
            int i9 = this.position - 1;
            this.position = i9;
            this.niobuffer.position(i9);
            return 7;
        }
        long j13 = ((127 & j12) << 56) | j11 | 36028797018963968L;
        long j14 = j12 >>> 7;
        if (j14 == 0) {
            this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
            writeLong(j13);
            this.niobuffer.order(this.byteOrder);
            return 8;
        }
        this.niobuffer.order(ByteOrder.LITTLE_ENDIAN);
        writeLong(j13 | Long.MIN_VALUE);
        this.niobuffer.order(this.byteOrder);
        write((byte) j14);
        return 9;
    }

    public void order(ByteOrder byteOrder) {
        this.byteOrder = byteOrder;
        this.niobuffer.order(byteOrder);
    }

    public void setBuffer(ByteBuffer byteBuffer, int i) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("buffer cannot be null.");
        }
        if (i < -1) {
            throw new IllegalArgumentException(outline.q("maxBufferSize cannot be < -1: ", i));
        }
        this.niobuffer = byteBuffer;
        if (i == -1) {
            i = Util.MAX_SAFE_ARRAY_SIZE;
        }
        this.maxCapacity = i;
        this.byteOrder = byteBuffer.order();
        this.capacity = byteBuffer.capacity();
        this.position = byteBuffer.position();
        this.total = 0L;
        this.outputStream = null;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void writeBytes(byte[] bArr, int i, int i2) throws KryoException {
        if (bArr != null) {
            int iMin = Math.min(this.capacity - this.position, i2);
            while (true) {
                this.niobuffer.put(bArr, i, iMin);
                this.position += iMin;
                i2 -= iMin;
                if (i2 == 0) {
                    return;
                }
                i += iMin;
                iMin = Math.min(this.capacity, i2);
                require(iMin);
            }
        } else {
            throw new IllegalArgumentException("bytes cannot be null.");
        }
    }

    public ByteBufferOutput(int i) {
        this(i, i);
    }

    @Override // com.esotericsoftware.kryo.io.Output, java.io.OutputStream
    public void write(byte[] bArr) throws KryoException {
        if (bArr != null) {
            writeBytes(bArr, 0, bArr.length);
            return;
        }
        throw new IllegalArgumentException("bytes cannot be null.");
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void writeByte(int i) throws KryoException {
        if (this.position == this.capacity) {
            require(1);
        }
        this.niobuffer.put((byte) i);
        this.position++;
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public int writeDouble(double d, double d2, boolean z2) throws KryoException {
        return writeLong((long) (d * d2), z2);
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public int writeFloat(float f, float f2, boolean z2) throws KryoException {
        return writeInt((int) (f * f2), z2);
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public int writeInt(int i, boolean z2) throws KryoException {
        if (!this.varIntsEnabled) {
            writeInt(i);
            return 4;
        }
        return writeVarInt(i, z2);
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public int writeLong(long j, boolean z2) throws KryoException {
        if (!this.varIntsEnabled) {
            writeLong(j);
            return 8;
        }
        return writeVarLong(j, z2);
    }

    public ByteBufferOutput(int i, int i2) {
        this.varIntsEnabled = true;
        this.byteOrder = ByteOrder.BIG_ENDIAN;
        if (i2 >= -1) {
            this.capacity = i;
            this.maxCapacity = i2 == -1 ? Util.MAX_SAFE_ARRAY_SIZE : i2;
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i);
            this.niobuffer = byteBufferAllocateDirect;
            byteBufferAllocateDirect.order(this.byteOrder);
            return;
        }
        throw new IllegalArgumentException(outline.q("maxBufferSize cannot be < -1: ", i2));
    }

    @Override // com.esotericsoftware.kryo.io.Output, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws KryoException {
        writeBytes(bArr, i, i2);
    }

    public ByteBufferOutput(OutputStream outputStream) {
        this(4096, 4096);
        if (outputStream != null) {
            this.outputStream = outputStream;
            return;
        }
        throw new IllegalArgumentException("outputStream cannot be null.");
    }

    public ByteBufferOutput(OutputStream outputStream, int i) {
        this(i, i);
        if (outputStream != null) {
            this.outputStream = outputStream;
            return;
        }
        throw new IllegalArgumentException("outputStream cannot be null.");
    }

    public ByteBufferOutput(ByteBuffer byteBuffer) {
        this.varIntsEnabled = true;
        this.byteOrder = ByteOrder.BIG_ENDIAN;
        setBuffer(byteBuffer);
    }

    @Override // com.esotericsoftware.kryo.io.Output
    public void writeString(CharSequence charSequence) throws KryoException {
        if (charSequence == null) {
            writeByte(128);
            return;
        }
        int length = charSequence.length();
        if (length == 0) {
            writeByte(Opcodes.LOR);
            return;
        }
        writeUtf8Length(length + 1);
        int i = 0;
        int i2 = this.capacity;
        int i3 = this.position;
        if (i2 - i3 >= length) {
            while (i < length) {
                char cCharAt = charSequence.charAt(i);
                if (cCharAt > 127) {
                    break;
                }
                this.niobuffer.put(i3, (byte) cCharAt);
                i++;
                i3++;
            }
            this.position = i3;
            this.niobuffer.position(i3);
        }
        if (i < length) {
            writeString_slow(charSequence, length, i);
        }
        this.niobuffer.position(this.position);
    }

    public ByteBufferOutput(ByteBuffer byteBuffer, int i) {
        this.varIntsEnabled = true;
        this.byteOrder = ByteOrder.BIG_ENDIAN;
        setBuffer(byteBuffer, i);
    }

    public ByteBufferOutput(long j, int i) {
        this.varIntsEnabled = true;
        this.byteOrder = ByteOrder.BIG_ENDIAN;
        ByteBuffer directBufferAt = UnsafeUtil.getDirectBufferAt(j, i);
        this.niobuffer = directBufferAt;
        setBuffer(directBufferAt, i);
    }
}
