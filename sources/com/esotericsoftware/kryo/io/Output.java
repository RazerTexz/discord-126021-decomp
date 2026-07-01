package com.esotericsoftware.kryo.io;

import b.d.b.a.outline;
import com.esotericsoftware.kryo.KryoException;
import java.io.IOException;
import java.io.OutputStream;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public class Output extends OutputStream {
    public byte[] buffer;
    public int capacity;
    public int maxCapacity;
    public OutputStream outputStream;
    public int position;
    public long total;

    public Output() {
    }

    public static int intLength(int i, boolean z2) {
        if (!z2) {
            i = (i >> 31) ^ (i << 1);
        }
        if ((i >>> 7) == 0) {
            return 1;
        }
        if ((i >>> 14) == 0) {
            return 2;
        }
        if ((i >>> 21) == 0) {
            return 3;
        }
        return (i >>> 28) == 0 ? 4 : 5;
    }

    public static int longLength(long j, boolean z2) {
        if (!z2) {
            j = (j >> 63) ^ (j << 1);
        }
        if ((j >>> 7) == 0) {
            return 1;
        }
        if ((j >>> 14) == 0) {
            return 2;
        }
        if ((j >>> 21) == 0) {
            return 3;
        }
        if ((j >>> 28) == 0) {
            return 4;
        }
        if ((j >>> 35) == 0) {
            return 5;
        }
        if ((j >>> 42) == 0) {
            return 6;
        }
        if ((j >>> 49) == 0) {
            return 7;
        }
        return (j >>> 56) == 0 ? 8 : 9;
    }

    private void writeAscii_slow(String str, int i) throws KryoException {
        if (i == 0) {
            return;
        }
        if (this.capacity == 0) {
            require(1);
        }
        int i2 = 0;
        byte[] bArr = this.buffer;
        int iMin = Math.min(i, this.capacity - this.position);
        while (i2 < i) {
            int i3 = i2 + iMin;
            str.getBytes(i2, i3, bArr, this.position);
            this.position += iMin;
            iMin = Math.min(i - i3, this.capacity);
            if (require(iMin)) {
                bArr = this.buffer;
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
                byte[] bArr = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr[i5] = (byte) cCharAt;
            } else if (cCharAt > 2047) {
                byte[] bArr2 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr2[i6] = (byte) (((cCharAt >> '\f') & 15) | 224);
                require(2);
                byte[] bArr3 = this.buffer;
                int i7 = this.position;
                int i8 = i7 + 1;
                this.position = i8;
                bArr3[i7] = (byte) (((cCharAt >> 6) & 63) | 128);
                this.position = i8 + 1;
                bArr3[i8] = (byte) ((cCharAt & '?') | 128);
            } else {
                byte[] bArr4 = this.buffer;
                int i9 = this.position;
                this.position = i9 + 1;
                bArr4[i9] = (byte) (((cCharAt >> 6) & 31) | Opcodes.CHECKCAST);
                require(1);
                byte[] bArr5 = this.buffer;
                int i10 = this.position;
                this.position = i10 + 1;
                bArr5[i10] = (byte) ((cCharAt & '?') | 128);
            }
            i2++;
        }
    }

    private void writeUtf8Length(int i) {
        int i2 = i >>> 6;
        if (i2 == 0) {
            require(1);
            byte[] bArr = this.buffer;
            int i3 = this.position;
            this.position = i3 + 1;
            bArr[i3] = (byte) (i | 128);
            return;
        }
        int i4 = i >>> 13;
        if (i4 == 0) {
            require(2);
            byte[] bArr2 = this.buffer;
            int i5 = this.position;
            int i6 = i5 + 1;
            this.position = i6;
            bArr2[i5] = (byte) (i | 64 | 128);
            this.position = i6 + 1;
            bArr2[i6] = (byte) i2;
            return;
        }
        int i7 = i >>> 20;
        if (i7 == 0) {
            require(3);
            byte[] bArr3 = this.buffer;
            int i8 = this.position;
            int i9 = i8 + 1;
            this.position = i9;
            bArr3[i8] = (byte) (i | 64 | 128);
            int i10 = i9 + 1;
            this.position = i10;
            bArr3[i9] = (byte) (i2 | 128);
            this.position = i10 + 1;
            bArr3[i10] = (byte) i4;
            return;
        }
        int i11 = i >>> 27;
        if (i11 == 0) {
            require(4);
            byte[] bArr4 = this.buffer;
            int i12 = this.position;
            int i13 = i12 + 1;
            this.position = i13;
            bArr4[i12] = (byte) (i | 64 | 128);
            int i14 = i13 + 1;
            this.position = i14;
            bArr4[i13] = (byte) (i2 | 128);
            int i15 = i14 + 1;
            this.position = i15;
            bArr4[i14] = (byte) (i4 | 128);
            this.position = i15 + 1;
            bArr4[i15] = (byte) i7;
            return;
        }
        require(5);
        byte[] bArr5 = this.buffer;
        int i16 = this.position;
        int i17 = i16 + 1;
        this.position = i17;
        bArr5[i16] = (byte) (i | 64 | 128);
        int i18 = i17 + 1;
        this.position = i18;
        bArr5[i17] = (byte) (i2 | 128);
        int i19 = i18 + 1;
        this.position = i19;
        bArr5[i18] = (byte) (i4 | 128);
        int i20 = i19 + 1;
        this.position = i20;
        bArr5[i19] = (byte) (i7 | 128);
        this.position = i20 + 1;
        bArr5[i20] = (byte) i11;
    }

    public void clear() {
        this.position = 0;
        this.total = 0L;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
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

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws KryoException {
        OutputStream outputStream = this.outputStream;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.write(this.buffer, 0, this.position);
            this.outputStream.flush();
            this.total += (long) this.position;
            this.position = 0;
        } catch (IOException e) {
            throw new KryoException(e);
        }
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    public OutputStream getOutputStream() {
        return this.outputStream;
    }

    public int position() {
        return this.position;
    }

    public boolean require(int i) throws KryoException {
        if (this.capacity - this.position >= i) {
            return false;
        }
        if (i > this.maxCapacity) {
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
            byte[] bArr = new byte[this.capacity];
            System.arraycopy(this.buffer, 0, bArr, 0, this.position);
            this.buffer = bArr;
        }
    }

    public void setBuffer(byte[] bArr) {
        setBuffer(bArr, bArr.length);
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
        this.position = 0;
        this.total = 0L;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public byte[] toBytes() {
        int i = this.position;
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, 0, bArr, 0, i);
        return bArr;
    }

    public long total() {
        return this.total + ((long) this.position);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws KryoException {
        if (this.position == this.capacity) {
            require(1);
        }
        byte[] bArr = this.buffer;
        int i2 = this.position;
        this.position = i2 + 1;
        bArr[i2] = (byte) i;
    }

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
        if (length == 1) {
            writeByte(130);
            writeByte(str.charAt(0));
            return;
        }
        int i = this.capacity;
        int i2 = this.position;
        if (i - i2 < length) {
            writeAscii_slow(str, length);
        } else {
            str.getBytes(0, length, this.buffer, i2);
            this.position += length;
        }
        byte[] bArr = this.buffer;
        int i3 = this.position - 1;
        bArr[i3] = (byte) (128 | bArr[i3]);
    }

    public void writeBoolean(boolean z2) throws KryoException {
        if (this.position == this.capacity) {
            require(1);
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = z2 ? (byte) 1 : (byte) 0;
    }

    public void writeByte(byte b2) throws KryoException {
        if (this.position == this.capacity) {
            require(1);
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b2;
    }

    public void writeBytes(byte[] bArr) throws KryoException {
        if (bArr == null) {
            throw new IllegalArgumentException("bytes cannot be null.");
        }
        writeBytes(bArr, 0, bArr.length);
    }

    public void writeChar(char c) throws KryoException {
        require(2);
        byte[] bArr = this.buffer;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        bArr[i] = (byte) (c >>> '\b');
        this.position = i2 + 1;
        bArr[i2] = (byte) c;
    }

    public void writeChars(char[] cArr) throws KryoException {
        for (char c : cArr) {
            writeChar(c);
        }
    }

    public void writeDouble(double d) throws KryoException {
        writeLong(Double.doubleToLongBits(d));
    }

    public void writeDoubles(double[] dArr) throws KryoException {
        for (double d : dArr) {
            writeDouble(d);
        }
    }

    public void writeFloat(float f) throws KryoException {
        writeInt(Float.floatToIntBits(f));
    }

    public void writeFloats(float[] fArr) throws KryoException {
        for (float f : fArr) {
            writeFloat(f);
        }
    }

    public void writeInt(int i) throws KryoException {
        require(4);
        byte[] bArr = this.buffer;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        bArr[i2] = (byte) (i >> 24);
        int i4 = i3 + 1;
        this.position = i4;
        bArr[i3] = (byte) (i >> 16);
        int i5 = i4 + 1;
        this.position = i5;
        bArr[i4] = (byte) (i >> 8);
        this.position = i5 + 1;
        bArr[i5] = (byte) i;
    }

    public void writeInts(int[] iArr, boolean z2) throws KryoException {
        for (int i : iArr) {
            writeInt(i, z2);
        }
    }

    public void writeLong(long j) throws KryoException {
        require(8);
        byte[] bArr = this.buffer;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        bArr[i] = (byte) (j >>> 56);
        int i3 = i2 + 1;
        this.position = i3;
        bArr[i2] = (byte) (j >>> 48);
        int i4 = i3 + 1;
        this.position = i4;
        bArr[i3] = (byte) (j >>> 40);
        int i5 = i4 + 1;
        this.position = i5;
        bArr[i4] = (byte) (j >>> 32);
        int i6 = i5 + 1;
        this.position = i6;
        bArr[i5] = (byte) (j >>> 24);
        int i7 = i6 + 1;
        this.position = i7;
        bArr[i6] = (byte) (j >>> 16);
        int i8 = i7 + 1;
        this.position = i8;
        bArr[i7] = (byte) (j >>> 8);
        this.position = i8 + 1;
        bArr[i8] = (byte) j;
    }

    public void writeLongs(long[] jArr, boolean z2) throws KryoException {
        for (long j : jArr) {
            writeLong(j, z2);
        }
    }

    public void writeShort(int i) throws KryoException {
        require(2);
        byte[] bArr = this.buffer;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        bArr[i2] = (byte) (i >>> 8);
        this.position = i3 + 1;
        bArr[i3] = (byte) i;
    }

    public void writeShorts(short[] sArr) throws KryoException {
        for (short s2 : sArr) {
            writeShort(s2);
        }
    }

    public void writeString(String str) throws KryoException {
        boolean z2;
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
            int i3 = this.capacity;
            int i4 = this.position;
            if (i3 - i4 < length) {
                writeAscii_slow(str, length);
            } else {
                str.getBytes(0, length, this.buffer, i4);
                this.position += length;
            }
            byte[] bArr = this.buffer;
            int i5 = this.position - 1;
            bArr[i5] = (byte) (128 | bArr[i5]);
            return;
        }
        writeUtf8Length(length + 1);
        int i6 = this.capacity;
        int i7 = this.position;
        if (i6 - i7 >= length) {
            byte[] bArr2 = this.buffer;
            while (i < length) {
                char cCharAt = str.charAt(i);
                if (cCharAt > 127) {
                    break;
                }
                bArr2[i7] = (byte) cCharAt;
                i++;
                i7++;
            }
            this.position = i7;
        }
        if (i < length) {
            writeString_slow(str, length, i);
        }
    }

    public int writeVarInt(int i, boolean z2) throws KryoException {
        if (!z2) {
            i = (i >> 31) ^ (i << 1);
        }
        int i2 = i >>> 7;
        if (i2 == 0) {
            require(1);
            byte[] bArr = this.buffer;
            int i3 = this.position;
            this.position = i3 + 1;
            bArr[i3] = (byte) i;
            return 1;
        }
        int i4 = i >>> 14;
        if (i4 == 0) {
            require(2);
            byte[] bArr2 = this.buffer;
            int i5 = this.position;
            int i6 = i5 + 1;
            this.position = i6;
            bArr2[i5] = (byte) ((i & Opcodes.LAND) | 128);
            this.position = i6 + 1;
            bArr2[i6] = (byte) i2;
            return 2;
        }
        int i7 = i >>> 21;
        if (i7 == 0) {
            require(3);
            byte[] bArr3 = this.buffer;
            int i8 = this.position;
            int i9 = i8 + 1;
            this.position = i9;
            bArr3[i8] = (byte) ((i & Opcodes.LAND) | 128);
            int i10 = i9 + 1;
            this.position = i10;
            bArr3[i9] = (byte) (i2 | 128);
            this.position = i10 + 1;
            bArr3[i10] = (byte) i4;
            return 3;
        }
        int i11 = i >>> 28;
        if (i11 == 0) {
            require(4);
            byte[] bArr4 = this.buffer;
            int i12 = this.position;
            int i13 = i12 + 1;
            this.position = i13;
            bArr4[i12] = (byte) ((i & Opcodes.LAND) | 128);
            int i14 = i13 + 1;
            this.position = i14;
            bArr4[i13] = (byte) (i2 | 128);
            int i15 = i14 + 1;
            this.position = i15;
            bArr4[i14] = (byte) (i4 | 128);
            this.position = i15 + 1;
            bArr4[i15] = (byte) i7;
            return 4;
        }
        require(5);
        byte[] bArr5 = this.buffer;
        int i16 = this.position;
        int i17 = i16 + 1;
        this.position = i17;
        bArr5[i16] = (byte) ((i & Opcodes.LAND) | 128);
        int i18 = i17 + 1;
        this.position = i18;
        bArr5[i17] = (byte) (i2 | 128);
        int i19 = i18 + 1;
        this.position = i19;
        bArr5[i18] = (byte) (i4 | 128);
        int i20 = i19 + 1;
        this.position = i20;
        bArr5[i19] = (byte) (i7 | 128);
        this.position = i20 + 1;
        bArr5[i20] = (byte) i11;
        return 5;
    }

    public int writeVarLong(long j, boolean z2) throws KryoException {
        long j2 = !z2 ? (j << 1) ^ (j >> 63) : j;
        long j3 = j2 >>> 7;
        if (j3 == 0) {
            require(1);
            byte[] bArr = this.buffer;
            int i = this.position;
            this.position = i + 1;
            bArr[i] = (byte) j2;
            return 1;
        }
        long j4 = j2 >>> 14;
        if (j4 == 0) {
            require(2);
            byte[] bArr2 = this.buffer;
            int i2 = this.position;
            int i3 = i2 + 1;
            this.position = i3;
            bArr2[i2] = (byte) ((j2 & 127) | 128);
            this.position = i3 + 1;
            bArr2[i3] = (byte) j3;
            return 2;
        }
        long j5 = j2 >>> 21;
        if (j5 == 0) {
            require(3);
            byte[] bArr3 = this.buffer;
            int i4 = this.position;
            int i5 = i4 + 1;
            this.position = i5;
            bArr3[i4] = (byte) ((j2 & 127) | 128);
            int i6 = i5 + 1;
            this.position = i6;
            bArr3[i5] = (byte) (j3 | 128);
            this.position = i6 + 1;
            bArr3[i6] = (byte) j4;
            return 3;
        }
        long j6 = j2 >>> 28;
        if (j6 == 0) {
            require(4);
            byte[] bArr4 = this.buffer;
            int i7 = this.position;
            int i8 = i7 + 1;
            this.position = i8;
            bArr4[i7] = (byte) ((j2 & 127) | 128);
            int i9 = i8 + 1;
            this.position = i9;
            bArr4[i8] = (byte) (j3 | 128);
            int i10 = i9 + 1;
            this.position = i10;
            bArr4[i9] = (byte) (j4 | 128);
            this.position = i10 + 1;
            bArr4[i10] = (byte) j5;
            return 4;
        }
        long j7 = j2 >>> 35;
        if (j7 == 0) {
            require(5);
            byte[] bArr5 = this.buffer;
            int i11 = this.position;
            int i12 = i11 + 1;
            this.position = i12;
            bArr5[i11] = (byte) ((j2 & 127) | 128);
            int i13 = i12 + 1;
            this.position = i13;
            bArr5[i12] = (byte) (j3 | 128);
            int i14 = i13 + 1;
            this.position = i14;
            bArr5[i13] = (byte) (j4 | 128);
            int i15 = i14 + 1;
            this.position = i15;
            bArr5[i14] = (byte) (j5 | 128);
            this.position = i15 + 1;
            bArr5[i15] = (byte) j6;
            return 5;
        }
        long j8 = j2 >>> 42;
        if (j8 == 0) {
            require(6);
            byte[] bArr6 = this.buffer;
            int i16 = this.position;
            int i17 = i16 + 1;
            this.position = i17;
            bArr6[i16] = (byte) ((j2 & 127) | 128);
            int i18 = i17 + 1;
            this.position = i18;
            bArr6[i17] = (byte) (j3 | 128);
            int i19 = i18 + 1;
            this.position = i19;
            bArr6[i18] = (byte) (j4 | 128);
            int i20 = i19 + 1;
            this.position = i20;
            bArr6[i19] = (byte) (j5 | 128);
            int i21 = i20 + 1;
            this.position = i21;
            bArr6[i20] = (byte) (j6 | 128);
            this.position = i21 + 1;
            bArr6[i21] = (byte) j7;
            return 6;
        }
        long j9 = j2 >>> 49;
        if (j9 == 0) {
            require(7);
            byte[] bArr7 = this.buffer;
            int i22 = this.position;
            int i23 = i22 + 1;
            this.position = i23;
            bArr7[i22] = (byte) ((j2 & 127) | 128);
            int i24 = i23 + 1;
            this.position = i24;
            bArr7[i23] = (byte) (j3 | 128);
            int i25 = i24 + 1;
            this.position = i25;
            bArr7[i24] = (byte) (j4 | 128);
            int i26 = i25 + 1;
            this.position = i26;
            bArr7[i25] = (byte) (j5 | 128);
            int i27 = i26 + 1;
            this.position = i27;
            bArr7[i26] = (byte) (j6 | 128);
            int i28 = i27 + 1;
            this.position = i28;
            bArr7[i27] = (byte) (j7 | 128);
            this.position = i28 + 1;
            bArr7[i28] = (byte) j8;
            return 7;
        }
        long j10 = j2 >>> 56;
        if (j10 == 0) {
            require(8);
            byte[] bArr8 = this.buffer;
            int i29 = this.position;
            int i30 = i29 + 1;
            this.position = i30;
            bArr8[i29] = (byte) ((j2 & 127) | 128);
            int i31 = i30 + 1;
            this.position = i31;
            bArr8[i30] = (byte) (j3 | 128);
            int i32 = i31 + 1;
            this.position = i32;
            bArr8[i31] = (byte) (j4 | 128);
            int i33 = i32 + 1;
            this.position = i33;
            bArr8[i32] = (byte) (j5 | 128);
            int i34 = i33 + 1;
            this.position = i34;
            bArr8[i33] = (byte) (j6 | 128);
            int i35 = i34 + 1;
            this.position = i35;
            bArr8[i34] = (byte) (j7 | 128);
            int i36 = i35 + 1;
            this.position = i36;
            bArr8[i35] = (byte) (j8 | 128);
            this.position = i36 + 1;
            bArr8[i36] = (byte) j9;
            return 8;
        }
        require(9);
        byte[] bArr9 = this.buffer;
        int i37 = this.position;
        int i38 = i37 + 1;
        this.position = i38;
        bArr9[i37] = (byte) ((j2 & 127) | 128);
        int i39 = i38 + 1;
        this.position = i39;
        bArr9[i38] = (byte) (j3 | 128);
        int i40 = i39 + 1;
        this.position = i40;
        bArr9[i39] = (byte) (j4 | 128);
        int i41 = i40 + 1;
        this.position = i41;
        bArr9[i40] = (byte) (j5 | 128);
        int i42 = i41 + 1;
        this.position = i42;
        bArr9[i41] = (byte) (j6 | 128);
        int i43 = i42 + 1;
        this.position = i43;
        bArr9[i42] = (byte) (j7 | 128);
        int i44 = i43 + 1;
        this.position = i44;
        bArr9[i43] = (byte) (j8 | 128);
        int i45 = i44 + 1;
        this.position = i45;
        bArr9[i44] = (byte) (j9 | 128);
        this.position = i45 + 1;
        bArr9[i45] = (byte) j10;
        return 9;
    }

    public Output(int i) {
        this(i, i);
    }

    public void setBuffer(byte[] bArr, int i) {
        if (bArr == null) {
            throw new IllegalArgumentException("buffer cannot be null.");
        }
        if (bArr.length > i && i != -1) {
            StringBuilder sbU = outline.U("buffer has length: ");
            sbU.append(bArr.length);
            sbU.append(" cannot be greater than maxBufferSize: ");
            sbU.append(i);
            throw new IllegalArgumentException(sbU.toString());
        }
        if (i < -1) {
            throw new IllegalArgumentException(outline.q("maxBufferSize cannot be < -1: ", i));
        }
        this.buffer = bArr;
        if (i == -1) {
            i = Util.MAX_SAFE_ARRAY_SIZE;
        }
        this.maxCapacity = i;
        this.capacity = bArr.length;
        this.position = 0;
        this.total = 0L;
        this.outputStream = null;
    }

    public int writeDouble(double d, double d2, boolean z2) throws KryoException {
        return writeLong((long) (d * d2), z2);
    }

    public int writeFloat(float f, float f2, boolean z2) throws KryoException {
        return writeInt((int) (f * f2), z2);
    }

    public Output(int i, int i2) {
        if (i > i2 && i2 != -1) {
            throw new IllegalArgumentException(outline.s("bufferSize: ", i, " cannot be greater than maxBufferSize: ", i2));
        }
        if (i2 >= -1) {
            this.capacity = i;
            this.maxCapacity = i2 == -1 ? Util.MAX_SAFE_ARRAY_SIZE : i2;
            this.buffer = new byte[i];
            return;
        }
        throw new IllegalArgumentException(outline.q("maxBufferSize cannot be < -1: ", i2));
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws KryoException {
        if (bArr != null) {
            writeBytes(bArr, 0, bArr.length);
            return;
        }
        throw new IllegalArgumentException("bytes cannot be null.");
    }

    public void writeByte(int i) throws KryoException {
        if (this.position == this.capacity) {
            require(1);
        }
        byte[] bArr = this.buffer;
        int i2 = this.position;
        this.position = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public void writeBytes(byte[] bArr, int i, int i2) throws KryoException {
        if (bArr != null) {
            int iMin = Math.min(this.capacity - this.position, i2);
            while (true) {
                System.arraycopy(bArr, i, this.buffer, this.position, iMin);
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

    public void writeInts(int[] iArr) throws KryoException {
        for (int i : iArr) {
            writeInt(i);
        }
    }

    public void writeLongs(long[] jArr) throws KryoException {
        for (long j : jArr) {
            writeLong(j);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws KryoException {
        writeBytes(bArr, i, i2);
    }

    public int writeInt(int i, boolean z2) throws KryoException {
        return writeVarInt(i, z2);
    }

    public Output(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public Output(byte[] bArr, int i) {
        if (bArr != null) {
            setBuffer(bArr, i);
            return;
        }
        throw new IllegalArgumentException("buffer cannot be null.");
    }

    public int writeLong(long j, boolean z2) throws KryoException {
        return writeVarLong(j, z2);
    }

    public Output(OutputStream outputStream) {
        this(4096, 4096);
        if (outputStream != null) {
            this.outputStream = outputStream;
            return;
        }
        throw new IllegalArgumentException("outputStream cannot be null.");
    }

    public Output(OutputStream outputStream, int i) {
        this(i, i);
        if (outputStream != null) {
            this.outputStream = outputStream;
            return;
        }
        throw new IllegalArgumentException("outputStream cannot be null.");
    }

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
            byte[] bArr = this.buffer;
            while (i < length) {
                char cCharAt = charSequence.charAt(i);
                if (cCharAt > 127) {
                    break;
                }
                bArr[i3] = (byte) cCharAt;
                i++;
                i3++;
            }
            this.position = i3;
        }
        if (i < length) {
            writeString_slow(charSequence, length, i);
        }
    }
}
