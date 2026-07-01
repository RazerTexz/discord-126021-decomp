package com.esotericsoftware.kryo.io;

import b.d.b.a.outline;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferInput extends Input {
    public static final ByteOrder nativeOrder = ByteOrder.nativeOrder();
    public ByteOrder byteOrder;
    public ByteBuffer niobuffer;
    public boolean varIntsEnabled;

    public ByteBufferInput() {
        this.varIntsEnabled = true;
        this.byteOrder = ByteOrder.BIG_ENDIAN;
    }

    private boolean isNativeOrder() {
        return this.byteOrder == nativeOrder;
    }

    private int optional(int i) throws KryoException {
        int i2 = this.limit - this.position;
        if (i2 >= i) {
            return i;
        }
        int iMin = Math.min(i, this.capacity);
        ByteBuffer byteBuffer = this.niobuffer;
        int i3 = this.limit;
        int iFill = fill(byteBuffer, i3, this.capacity - i3);
        if (iFill == -1) {
            if (i2 == 0) {
                return -1;
            }
            return Math.min(i2, iMin);
        }
        int i4 = i2 + iFill;
        if (i4 >= iMin) {
            this.limit += iFill;
            return iMin;
        }
        this.niobuffer.compact();
        this.total += (long) this.position;
        this.position = 0;
        do {
            int iFill2 = fill(this.niobuffer, i4, this.capacity - i4);
            if (iFill2 == -1) {
                break;
            }
            i4 += iFill2;
        } while (i4 < iMin);
        this.limit = i4;
        this.niobuffer.position(this.position);
        if (i4 == 0) {
            return -1;
        }
        return Math.min(i4, iMin);
    }

    private String readAscii() {
        int i = this.position;
        int i2 = i - 1;
        int i3 = this.limit;
        while (i != i3) {
            i++;
            if ((this.niobuffer.get() & 128) != 0) {
                ByteBuffer byteBuffer = this.niobuffer;
                int i4 = i - 1;
                byteBuffer.put(i4, (byte) (byteBuffer.get(i4) & 127));
                int i5 = i - i2;
                byte[] bArr = new byte[i5];
                this.niobuffer.position(i2);
                this.niobuffer.get(bArr);
                String str = new String(bArr, 0, 0, i5);
                ByteBuffer byteBuffer2 = this.niobuffer;
                byteBuffer2.put(i4, (byte) (byteBuffer2.get(i4) | 128));
                this.position = i;
                this.niobuffer.position(i);
                return str;
            }
        }
        return readAscii_slow();
    }

    private String readAscii_slow() {
        int i = this.position - 1;
        this.position = i;
        int i2 = this.limit;
        int i3 = i2 - i;
        if (i3 > this.chars.length) {
            this.chars = new char[i3 * 2];
        }
        char[] cArr = this.chars;
        int i4 = 0;
        while (i < i2) {
            cArr[i4] = (char) this.niobuffer.get(i);
            i++;
            i4++;
        }
        this.position = this.limit;
        while (true) {
            require(1);
            this.position++;
            byte b2 = this.niobuffer.get();
            if (i3 == cArr.length) {
                char[] cArr2 = new char[i3 * 2];
                System.arraycopy(cArr, 0, cArr2, 0, i3);
                this.chars = cArr2;
                cArr = cArr2;
            }
            if ((b2 & 128) == 128) {
                cArr[i3] = (char) (b2 & 127);
                return new String(cArr, 0, i3 + 1);
            }
            cArr[i3] = (char) b2;
            i3++;
        }
    }

    private int readInt_slow(boolean z2) {
        this.position++;
        byte b2 = this.niobuffer.get();
        int i = b2 & 127;
        if ((b2 & 128) != 0) {
            require(1);
            this.position++;
            byte b3 = this.niobuffer.get();
            i |= (b3 & 127) << 7;
            if ((b3 & 128) != 0) {
                require(1);
                this.position++;
                byte b4 = this.niobuffer.get();
                i |= (b4 & 127) << 14;
                if ((b4 & 128) != 0) {
                    require(1);
                    this.position++;
                    byte b5 = this.niobuffer.get();
                    i |= (b5 & 127) << 21;
                    if ((b5 & 128) != 0) {
                        require(1);
                        this.position++;
                        i |= (this.niobuffer.get() & 127) << 28;
                    }
                }
            }
        }
        return z2 ? i : (i >>> 1) ^ (-(i & 1));
    }

    private long readLong_slow(boolean z2) {
        this.position++;
        byte b2 = this.niobuffer.get();
        long j = b2 & 127;
        if ((b2 & 128) != 0) {
            require(1);
            this.position++;
            byte b3 = this.niobuffer.get();
            j |= (long) ((b3 & 127) << 7);
            if ((b3 & 128) != 0) {
                require(1);
                this.position++;
                byte b4 = this.niobuffer.get();
                j |= (long) ((b4 & 127) << 14);
                if ((b4 & 128) != 0) {
                    require(1);
                    this.position++;
                    byte b5 = this.niobuffer.get();
                    j |= (long) ((b5 & 127) << 21);
                    if ((b5 & 128) != 0) {
                        require(1);
                        this.position++;
                        byte b6 = this.niobuffer.get();
                        j |= ((long) (b6 & 127)) << 28;
                        if ((b6 & 128) != 0) {
                            require(1);
                            this.position++;
                            byte b7 = this.niobuffer.get();
                            j |= ((long) (b7 & 127)) << 35;
                            if ((b7 & 128) != 0) {
                                require(1);
                                this.position++;
                                byte b8 = this.niobuffer.get();
                                j |= ((long) (b8 & 127)) << 42;
                                if ((b8 & 128) != 0) {
                                    require(1);
                                    this.position++;
                                    byte b9 = this.niobuffer.get();
                                    j |= ((long) (b9 & 127)) << 49;
                                    if ((b9 & 128) != 0) {
                                        require(1);
                                        this.position++;
                                        j |= ((long) this.niobuffer.get()) << 56;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (z2) {
            return j;
        }
        return (-(j & 1)) ^ (j >>> 1);
    }

    private void readUtf8(int i) {
        char[] cArr = this.chars;
        int iMin = Math.min(require(1), i);
        int i2 = this.position;
        int i3 = 0;
        while (i3 < iMin) {
            i2++;
            byte b2 = this.niobuffer.get();
            if (b2 < 0) {
                i2--;
                break;
            } else {
                cArr[i3] = (char) b2;
                i3++;
            }
        }
        this.position = i2;
        if (i3 < i) {
            this.niobuffer.position(i2);
            readUtf8_slow(i, i3);
        }
    }

    private int readUtf8Length(int i) {
        int i2 = i & 63;
        if ((i & 64) == 0) {
            return i2;
        }
        this.position++;
        byte b2 = this.niobuffer.get();
        int i3 = i2 | ((b2 & 127) << 6);
        if ((b2 & 128) == 0) {
            return i3;
        }
        this.position++;
        byte b3 = this.niobuffer.get();
        int i4 = i3 | ((b3 & 127) << 13);
        if ((b3 & 128) == 0) {
            return i4;
        }
        this.position++;
        byte b4 = this.niobuffer.get();
        int i5 = i4 | ((b4 & 127) << 20);
        if ((b4 & 128) == 0) {
            return i5;
        }
        this.position++;
        return i5 | ((this.niobuffer.get() & 127) << 27);
    }

    private int readUtf8Length_slow(int i) {
        int i2 = i & 63;
        if ((i & 64) == 0) {
            return i2;
        }
        require(1);
        this.position++;
        byte b2 = this.niobuffer.get();
        int i3 = i2 | ((b2 & 127) << 6);
        if ((b2 & 128) == 0) {
            return i3;
        }
        require(1);
        this.position++;
        byte b3 = this.niobuffer.get();
        int i4 = i3 | ((b3 & 127) << 13);
        if ((b3 & 128) == 0) {
            return i4;
        }
        require(1);
        this.position++;
        byte b4 = this.niobuffer.get();
        int i5 = i4 | ((b4 & 127) << 20);
        if ((b4 & 128) == 0) {
            return i5;
        }
        require(1);
        this.position++;
        return i5 | ((this.niobuffer.get() & 127) << 27);
    }

    private void readUtf8_slow(int i, int i2) {
        char[] cArr = this.chars;
        while (i2 < i) {
            if (this.position == this.limit) {
                require(1);
            }
            this.position++;
            int i3 = this.niobuffer.get() & 255;
            switch (i3 >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    cArr[i2] = (char) i3;
                    break;
                case 12:
                case 13:
                    if (this.position == this.limit) {
                        require(1);
                    }
                    this.position++;
                    cArr[i2] = (char) (((i3 & 31) << 6) | (this.niobuffer.get() & 63));
                    break;
                case 14:
                    require(2);
                    this.position += 2;
                    cArr[i2] = (char) (((i3 & 15) << 12) | ((this.niobuffer.get() & 63) << 6) | (this.niobuffer.get() & 63));
                    break;
            }
            i2++;
        }
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public boolean canReadInt() throws KryoException {
        if (this.limit - this.position >= 5) {
            return true;
        }
        if (optional(5) <= 0) {
            return false;
        }
        int i = this.position;
        int i2 = i + 1;
        if ((this.niobuffer.get(i) & 128) == 0) {
            return true;
        }
        if (i2 == this.limit) {
            return false;
        }
        int i3 = i2 + 1;
        if ((this.niobuffer.get(i2) & 128) == 0) {
            return true;
        }
        if (i3 == this.limit) {
            return false;
        }
        int i4 = i3 + 1;
        if ((this.niobuffer.get(i3) & 128) == 0) {
            return true;
        }
        if (i4 == this.limit) {
            return false;
        }
        return (this.niobuffer.get(i4) & 128) == 0 || i4 + 1 != this.limit;
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public boolean canReadLong() throws KryoException {
        if (this.limit - this.position >= 9) {
            return true;
        }
        if (optional(5) <= 0) {
            return false;
        }
        int i = this.position;
        int i2 = i + 1;
        if ((this.niobuffer.get(i) & 128) == 0) {
            return true;
        }
        if (i2 == this.limit) {
            return false;
        }
        int i3 = i2 + 1;
        if ((this.niobuffer.get(i2) & 128) == 0) {
            return true;
        }
        if (i3 == this.limit) {
            return false;
        }
        int i4 = i3 + 1;
        if ((this.niobuffer.get(i3) & 128) == 0) {
            return true;
        }
        if (i4 == this.limit) {
            return false;
        }
        int i5 = i4 + 1;
        if ((this.niobuffer.get(i4) & 128) == 0) {
            return true;
        }
        if (i5 == this.limit) {
            return false;
        }
        int i6 = i5 + 1;
        if ((this.niobuffer.get(i5) & 128) == 0) {
            return true;
        }
        if (i6 == this.limit) {
            return false;
        }
        int i7 = i6 + 1;
        if ((this.niobuffer.get(i6) & 128) == 0) {
            return true;
        }
        if (i7 == this.limit) {
            return false;
        }
        int i8 = i7 + 1;
        if ((this.niobuffer.get(i7) & 128) == 0) {
            return true;
        }
        if (i8 == this.limit) {
            return false;
        }
        return (this.niobuffer.get(i8) & 128) == 0 || i8 + 1 != this.limit;
    }

    @Override // com.esotericsoftware.kryo.io.Input, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws KryoException {
        InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public int fill(ByteBuffer byteBuffer, int i, int i2) throws KryoException {
        InputStream inputStream = this.inputStream;
        if (inputStream == null) {
            return -1;
        }
        try {
            byte[] bArr = new byte[i2];
            int i3 = inputStream.read(bArr, 0, i2);
            byteBuffer.position(i);
            if (i3 >= 0) {
                byteBuffer.put(bArr, 0, i3);
                byteBuffer.position(i);
            }
            return i3;
        } catch (IOException e) {
            throw new KryoException(e);
        }
    }

    public ByteBuffer getByteBuffer() {
        return this.niobuffer;
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public InputStream getInputStream() {
        return this.inputStream;
    }

    public boolean getVarIntsEnabled() {
        return this.varIntsEnabled;
    }

    public ByteOrder order() {
        return this.byteOrder;
    }

    @Override // com.esotericsoftware.kryo.io.Input, java.io.InputStream
    public int read() throws KryoException {
        if (optional(1) <= 0) {
            return -1;
        }
        this.niobuffer.position(this.position);
        this.position++;
        return this.niobuffer.get() & 255;
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public boolean readBoolean() throws KryoException {
        require(1);
        this.position++;
        return this.niobuffer.get() == 1;
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public byte readByte() throws KryoException {
        this.niobuffer.position(this.position);
        require(1);
        this.position++;
        return this.niobuffer.get();
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public int readByteUnsigned() throws KryoException {
        require(1);
        this.position++;
        return this.niobuffer.get() & 255;
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public byte[] readBytes(int i) throws KryoException {
        byte[] bArr = new byte[i];
        readBytes(bArr, 0, i);
        return bArr;
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public char readChar() throws KryoException {
        require(2);
        this.position += 2;
        return this.niobuffer.getChar();
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public char[] readChars(int i) throws KryoException {
        int i2 = i * 2;
        if (this.capacity - this.position < i2 || !isNativeOrder()) {
            return super.readChars(i);
        }
        char[] cArr = new char[i];
        this.niobuffer.asCharBuffer().get(cArr);
        int i3 = this.position + i2;
        this.position = i3;
        this.niobuffer.position(i3);
        return cArr;
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public double readDouble() throws KryoException {
        require(8);
        this.position += 8;
        return this.niobuffer.getDouble();
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public double[] readDoubles(int i) throws KryoException {
        int i2 = i * 8;
        if (this.capacity - this.position < i2 || !isNativeOrder()) {
            return super.readDoubles(i);
        }
        double[] dArr = new double[i];
        this.niobuffer.asDoubleBuffer().get(dArr);
        int i3 = this.position + i2;
        this.position = i3;
        this.niobuffer.position(i3);
        return dArr;
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public float readFloat() throws KryoException {
        require(4);
        this.position += 4;
        return this.niobuffer.getFloat();
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public float[] readFloats(int i) throws KryoException {
        int i2 = i * 4;
        if (this.capacity - this.position < i2 || !isNativeOrder()) {
            return super.readFloats(i);
        }
        float[] fArr = new float[i];
        this.niobuffer.asFloatBuffer().get(fArr);
        int i3 = this.position + i2;
        this.position = i3;
        this.niobuffer.position(i3);
        return fArr;
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public int readInt() throws KryoException {
        require(4);
        this.position += 4;
        return this.niobuffer.getInt();
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public int[] readInts(int i) throws KryoException {
        int i2 = i * 4;
        if (this.capacity - this.position < i2 || !isNativeOrder()) {
            return super.readInts(i);
        }
        int[] iArr = new int[i];
        this.niobuffer.asIntBuffer().get(iArr);
        int i3 = this.position + i2;
        this.position = i3;
        this.niobuffer.position(i3);
        return iArr;
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public long readLong() throws KryoException {
        require(8);
        this.position += 8;
        return this.niobuffer.getLong();
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public long[] readLongs(int i) throws KryoException {
        int i2 = i * 8;
        if (this.capacity - this.position < i2 || !isNativeOrder()) {
            return super.readLongs(i);
        }
        long[] jArr = new long[i];
        this.niobuffer.asLongBuffer().get(jArr);
        int i3 = this.position + i2;
        this.position = i3;
        this.niobuffer.position(i3);
        return jArr;
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public short readShort() throws KryoException {
        require(2);
        this.position += 2;
        return this.niobuffer.getShort();
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public int readShortUnsigned() throws KryoException {
        require(2);
        this.position += 2;
        return this.niobuffer.getShort();
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public short[] readShorts(int i) throws KryoException {
        int i2 = i * 2;
        if (this.capacity - this.position < i2 || !isNativeOrder()) {
            return super.readShorts(i);
        }
        short[] sArr = new short[i];
        this.niobuffer.asShortBuffer().get(sArr);
        int i3 = this.position + i2;
        this.position = i3;
        this.niobuffer.position(i3);
        return sArr;
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public String readString() {
        this.niobuffer.position(this.position);
        int iRequire = require(1);
        this.position++;
        byte b2 = this.niobuffer.get();
        if ((b2 & 128) == 0) {
            return readAscii();
        }
        int utf8Length = iRequire >= 5 ? readUtf8Length(b2) : readUtf8Length_slow(b2);
        if (utf8Length == 0) {
            return null;
        }
        if (utf8Length == 1) {
            return "";
        }
        int i = utf8Length - 1;
        if (this.chars.length < i) {
            this.chars = new char[i];
        }
        readUtf8(i);
        return new String(this.chars, 0, i);
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public StringBuilder readStringBuilder() {
        this.niobuffer.position(this.position);
        int iRequire = require(1);
        this.position++;
        byte b2 = this.niobuffer.get();
        if ((b2 & 128) == 0) {
            return new StringBuilder(readAscii());
        }
        int utf8Length = iRequire >= 5 ? readUtf8Length(b2) : readUtf8Length_slow(b2);
        if (utf8Length == 0) {
            return null;
        }
        if (utf8Length == 1) {
            return new StringBuilder("");
        }
        int i = utf8Length - 1;
        if (this.chars.length < i) {
            this.chars = new char[i];
        }
        readUtf8(i);
        StringBuilder sb = new StringBuilder(i);
        sb.append(this.chars, 0, i);
        return sb;
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public int readVarInt(boolean z2) throws KryoException {
        this.niobuffer.position(this.position);
        if (require(1) < 5) {
            return readInt_slow(z2);
        }
        this.position++;
        byte b2 = this.niobuffer.get();
        int i = b2 & 127;
        if ((b2 & 128) != 0) {
            this.position++;
            byte b3 = this.niobuffer.get();
            i |= (b3 & 127) << 7;
            if ((b3 & 128) != 0) {
                this.position++;
                byte b4 = this.niobuffer.get();
                i |= (b4 & 127) << 14;
                if ((b4 & 128) != 0) {
                    this.position++;
                    byte b5 = this.niobuffer.get();
                    i |= (b5 & 127) << 21;
                    if ((b5 & 128) != 0) {
                        this.position++;
                        i |= (this.niobuffer.get() & 127) << 28;
                    }
                }
            }
        }
        return z2 ? i : (i >>> 1) ^ (-(i & 1));
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public long readVarLong(boolean z2) throws KryoException {
        this.niobuffer.position(this.position);
        if (require(1) < 9) {
            return readLong_slow(z2);
        }
        this.position++;
        byte b2 = this.niobuffer.get();
        long j = b2 & 127;
        if ((b2 & 128) != 0) {
            this.position++;
            byte b3 = this.niobuffer.get();
            j |= (long) ((b3 & 127) << 7);
            if ((b3 & 128) != 0) {
                this.position++;
                byte b4 = this.niobuffer.get();
                j |= (long) ((b4 & 127) << 14);
                if ((b4 & 128) != 0) {
                    this.position++;
                    byte b5 = this.niobuffer.get();
                    j |= (long) ((b5 & 127) << 21);
                    if ((b5 & 128) != 0) {
                        this.position++;
                        byte b6 = this.niobuffer.get();
                        j |= ((long) (b6 & 127)) << 28;
                        if ((b6 & 128) != 0) {
                            this.position++;
                            byte b7 = this.niobuffer.get();
                            j |= ((long) (b7 & 127)) << 35;
                            if ((b7 & 128) != 0) {
                                this.position++;
                                byte b8 = this.niobuffer.get();
                                j |= ((long) (b8 & 127)) << 42;
                                if ((b8 & 128) != 0) {
                                    this.position++;
                                    byte b9 = this.niobuffer.get();
                                    j |= ((long) (b9 & 127)) << 49;
                                    if ((b9 & 128) != 0) {
                                        this.position++;
                                        j |= ((long) this.niobuffer.get()) << 56;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (z2) {
            return j;
        }
        return (-(j & 1)) ^ (j >>> 1);
    }

    public void release() {
        close();
        UnsafeUtil.releaseBuffer(this.niobuffer);
        this.niobuffer = null;
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public final int require(int i) throws KryoException {
        int i2 = this.limit;
        int i3 = i2 - this.position;
        if (i3 >= i) {
            return i3;
        }
        int i4 = this.capacity;
        if (i > i4) {
            StringBuilder sbU = outline.U("Buffer too small: capacity: ");
            sbU.append(this.capacity);
            sbU.append(", required: ");
            sbU.append(i);
            throw new KryoException(sbU.toString());
        }
        if (i3 > 0) {
            int iFill = fill(this.niobuffer, i2, i4 - i2);
            if (iFill == -1) {
                throw new KryoException("Buffer underflow.");
            }
            i3 += iFill;
            if (i3 >= i) {
                this.limit += iFill;
                return i3;
            }
        }
        this.niobuffer.position(this.position);
        this.niobuffer.compact();
        this.total += (long) this.position;
        this.position = 0;
        do {
            int iFill2 = fill(this.niobuffer, i3, this.capacity - i3);
            if (iFill2 == -1) {
                if (i3 >= i) {
                    break;
                }
                throw new KryoException("Buffer underflow.");
            }
            i3 += iFill2;
        } while (i3 < i);
        this.limit = i3;
        this.niobuffer.position(0);
        return i3;
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public void rewind() {
        super.rewind();
        this.niobuffer.position(0);
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public void setBuffer(byte[] bArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bArr.length);
        byteBufferAllocateDirect.put(bArr);
        byteBufferAllocateDirect.position(0);
        byteBufferAllocateDirect.limit(bArr.length);
        byteBufferAllocateDirect.order(this.byteOrder);
        setBuffer(byteBufferAllocateDirect);
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
        this.limit = 0;
        rewind();
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public void setLimit(int i) {
        this.limit = i;
        this.niobuffer.limit(i);
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public void setPosition(int i) {
        this.position = i;
        this.niobuffer.position(i);
    }

    public void setVarIntsEnabled(boolean z2) {
        this.varIntsEnabled = z2;
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public void skip(int i) throws KryoException {
        super.skip(i);
        this.niobuffer.position(position());
    }

    public void order(ByteOrder byteOrder) {
        this.byteOrder = byteOrder;
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public void readBytes(byte[] bArr) throws KryoException {
        readBytes(bArr, 0, bArr.length);
    }

    @Override // com.esotericsoftware.kryo.io.Input, java.io.InputStream
    public long skip(long j) throws KryoException {
        long j2 = j;
        while (j2 > 0) {
            int iMin = (int) Math.min(2147483639L, j2);
            skip(iMin);
            j2 -= (long) iMin;
        }
        return j;
    }

    public ByteBufferInput(int i) {
        this.varIntsEnabled = true;
        this.byteOrder = ByteOrder.BIG_ENDIAN;
        this.capacity = i;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i);
        this.niobuffer = byteBufferAllocateDirect;
        byteBufferAllocateDirect.order(this.byteOrder);
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public void readBytes(byte[] bArr, int i, int i2) throws KryoException {
        if (bArr != null) {
            int iMin = Math.min(this.limit - this.position, i2);
            while (true) {
                this.niobuffer.get(bArr, i, iMin);
                this.position += iMin;
                i2 -= iMin;
                if (i2 == 0) {
                    return;
                }
                i += iMin;
                iMin = Math.min(i2, this.capacity);
                require(iMin);
            }
        } else {
            throw new IllegalArgumentException("bytes cannot be null.");
        }
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public double readDouble(double d, boolean z2) throws KryoException {
        return readLong(z2) / d;
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public float readFloat(float f, boolean z2) throws KryoException {
        return readInt(z2) / f;
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public int readInt(boolean z2) throws KryoException {
        if (this.varIntsEnabled) {
            return readVarInt(z2);
        }
        return readInt();
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public long readLong(boolean z2) throws KryoException {
        if (this.varIntsEnabled) {
            return readVarLong(z2);
        }
        return readLong();
    }

    @Override // com.esotericsoftware.kryo.io.Input, java.io.InputStream
    public int read(byte[] bArr) throws KryoException {
        this.niobuffer.position(this.position);
        return read(bArr, 0, bArr.length);
    }

    @Override // com.esotericsoftware.kryo.io.Input, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws KryoException {
        this.niobuffer.position(this.position);
        if (bArr != null) {
            int iMin = Math.min(this.limit - this.position, i2);
            int i3 = i2;
            do {
                this.niobuffer.get(bArr, i, iMin);
                this.position += iMin;
                i3 -= iMin;
                if (i3 == 0) {
                    break;
                }
                i += iMin;
                iMin = optional(i3);
                if (iMin == -1) {
                    if (i2 != i3) {
                        break;
                    }
                    return -1;
                }
            } while (this.position != this.limit);
            return i2 - i3;
        }
        throw new IllegalArgumentException("bytes cannot be null.");
    }

    public void setBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            this.niobuffer = byteBuffer;
            this.position = byteBuffer.position();
            this.limit = byteBuffer.limit();
            this.capacity = byteBuffer.capacity();
            this.byteOrder = byteBuffer.order();
            this.total = 0L;
            this.inputStream = null;
            return;
        }
        throw new IllegalArgumentException("buffer cannot be null.");
    }

    public ByteBufferInput(byte[] bArr) {
        this.varIntsEnabled = true;
        this.byteOrder = ByteOrder.BIG_ENDIAN;
        setBuffer(bArr);
    }

    public ByteBufferInput(ByteBuffer byteBuffer) {
        this.varIntsEnabled = true;
        this.byteOrder = ByteOrder.BIG_ENDIAN;
        setBuffer(byteBuffer);
    }

    public ByteBufferInput(InputStream inputStream) {
        this(4096);
        if (inputStream != null) {
            this.inputStream = inputStream;
            return;
        }
        throw new IllegalArgumentException("inputStream cannot be null.");
    }

    public ByteBufferInput(InputStream inputStream, int i) {
        this(i);
        if (inputStream != null) {
            this.inputStream = inputStream;
            return;
        }
        throw new IllegalArgumentException("inputStream cannot be null.");
    }

    public ByteBufferInput(long j, int i) {
        this.varIntsEnabled = true;
        this.byteOrder = ByteOrder.BIG_ENDIAN;
        setBuffer(UnsafeUtil.getDirectBufferAt(j, i));
    }
}
