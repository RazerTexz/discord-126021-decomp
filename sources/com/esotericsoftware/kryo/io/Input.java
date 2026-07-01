package com.esotericsoftware.kryo.io;

import b.d.b.a.outline;
import com.esotericsoftware.kryo.KryoException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class Input extends InputStream {
    public byte[] buffer;
    public int capacity;
    public char[] chars;
    public InputStream inputStream;
    public int limit;
    public int position;
    public long total;

    public Input() {
        this.chars = new char[32];
    }

    private int optional(int i) throws KryoException {
        int i2 = this.limit - this.position;
        if (i2 >= i) {
            return i;
        }
        int iMin = Math.min(i, this.capacity);
        byte[] bArr = this.buffer;
        int i3 = this.limit;
        int iFill = fill(bArr, i3, this.capacity - i3);
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
        byte[] bArr2 = this.buffer;
        System.arraycopy(bArr2, this.position, bArr2, 0, i4);
        this.total += (long) this.position;
        this.position = 0;
        do {
            int iFill2 = fill(this.buffer, i4, this.capacity - i4);
            if (iFill2 == -1) {
                break;
            }
            i4 += iFill2;
        } while (i4 < iMin);
        this.limit = i4;
        if (i4 == 0) {
            return -1;
        }
        return Math.min(i4, iMin);
    }

    private String readAscii() {
        byte[] bArr = this.buffer;
        int i = this.position;
        int i2 = i - 1;
        int i3 = this.limit;
        while (i != i3) {
            int i4 = i + 1;
            if ((bArr[i] & 128) != 0) {
                int i5 = i4 - 1;
                bArr[i5] = (byte) (bArr[i5] & 127);
                String str = new String(bArr, 0, i2, i4 - i2);
                bArr[i5] = (byte) (bArr[i5] | 128);
                this.position = i4;
                return str;
            }
            i = i4;
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
        byte[] bArr = this.buffer;
        int i4 = 0;
        while (i < i2) {
            cArr[i4] = (char) bArr[i];
            i++;
            i4++;
        }
        this.position = this.limit;
        while (true) {
            require(1);
            int i5 = this.position;
            this.position = i5 + 1;
            byte b2 = bArr[i5];
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
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        byte b2 = bArr[i];
        int i2 = b2 & 127;
        if ((b2 & 128) != 0) {
            require(1);
            byte[] bArr2 = this.buffer;
            int i3 = this.position;
            this.position = i3 + 1;
            byte b3 = bArr2[i3];
            i2 |= (b3 & 127) << 7;
            if ((b3 & 128) != 0) {
                require(1);
                int i4 = this.position;
                this.position = i4 + 1;
                byte b4 = bArr2[i4];
                i2 |= (b4 & 127) << 14;
                if ((b4 & 128) != 0) {
                    require(1);
                    int i5 = this.position;
                    this.position = i5 + 1;
                    byte b5 = bArr2[i5];
                    i2 |= (b5 & 127) << 21;
                    if ((b5 & 128) != 0) {
                        require(1);
                        int i6 = this.position;
                        this.position = i6 + 1;
                        i2 |= (bArr2[i6] & 127) << 28;
                    }
                }
            }
        }
        return z2 ? i2 : (i2 >>> 1) ^ (-(i2 & 1));
    }

    private long readLong_slow(boolean z2) {
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        byte b2 = bArr[i];
        long j = b2 & 127;
        if ((b2 & 128) != 0) {
            require(1);
            byte[] bArr2 = this.buffer;
            int i2 = this.position;
            this.position = i2 + 1;
            byte b3 = bArr2[i2];
            j |= (long) ((b3 & 127) << 7);
            if ((b3 & 128) != 0) {
                require(1);
                int i3 = this.position;
                this.position = i3 + 1;
                byte b4 = bArr2[i3];
                j |= (long) ((b4 & 127) << 14);
                if ((b4 & 128) != 0) {
                    require(1);
                    int i4 = this.position;
                    this.position = i4 + 1;
                    byte b5 = bArr2[i4];
                    j |= (long) ((b5 & 127) << 21);
                    if ((b5 & 128) != 0) {
                        require(1);
                        int i5 = this.position;
                        this.position = i5 + 1;
                        byte b6 = bArr2[i5];
                        j |= ((long) (b6 & 127)) << 28;
                        if ((b6 & 128) != 0) {
                            require(1);
                            int i6 = this.position;
                            this.position = i6 + 1;
                            byte b7 = bArr2[i6];
                            j |= ((long) (b7 & 127)) << 35;
                            if ((b7 & 128) != 0) {
                                require(1);
                                int i7 = this.position;
                                this.position = i7 + 1;
                                byte b8 = bArr2[i7];
                                j |= ((long) (b8 & 127)) << 42;
                                if ((b8 & 128) != 0) {
                                    require(1);
                                    int i8 = this.position;
                                    this.position = i8 + 1;
                                    byte b9 = bArr2[i8];
                                    j |= ((long) (b9 & 127)) << 49;
                                    if ((b9 & 128) != 0) {
                                        require(1);
                                        int i9 = this.position;
                                        this.position = i9 + 1;
                                        j |= ((long) bArr2[i9]) << 56;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return !z2 ? (j >>> 1) ^ (-(j & 1)) : j;
    }

    private void readUtf8(int i) {
        byte[] bArr = this.buffer;
        char[] cArr = this.chars;
        int iMin = Math.min(require(1), i);
        int i2 = this.position;
        int i3 = 0;
        while (i3 < iMin) {
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 < 0) {
                i2 = i4 - 1;
                break;
            } else {
                cArr[i3] = (char) b2;
                i2 = i4;
                i3++;
            }
        }
        this.position = i2;
        if (i3 < i) {
            readUtf8_slow(i, i3);
        }
    }

    private int readUtf8Length(int i) {
        int i2 = i & 63;
        if ((i & 64) == 0) {
            return i2;
        }
        byte[] bArr = this.buffer;
        int i3 = this.position;
        int i4 = i3 + 1;
        this.position = i4;
        byte b2 = bArr[i3];
        int i5 = i2 | ((b2 & 127) << 6);
        if ((b2 & 128) == 0) {
            return i5;
        }
        int i6 = i4 + 1;
        this.position = i6;
        byte b3 = bArr[i4];
        int i7 = i5 | ((b3 & 127) << 13);
        if ((b3 & 128) == 0) {
            return i7;
        }
        int i8 = i6 + 1;
        this.position = i8;
        byte b4 = bArr[i6];
        int i9 = i7 | ((b4 & 127) << 20);
        if ((b4 & 128) == 0) {
            return i9;
        }
        this.position = i8 + 1;
        return i9 | ((bArr[i8] & 127) << 27);
    }

    private int readUtf8Length_slow(int i) {
        int i2 = i & 63;
        if ((i & 64) == 0) {
            return i2;
        }
        require(1);
        byte[] bArr = this.buffer;
        int i3 = this.position;
        this.position = i3 + 1;
        byte b2 = bArr[i3];
        int i4 = i2 | ((b2 & 127) << 6);
        if ((b2 & 128) == 0) {
            return i4;
        }
        require(1);
        int i5 = this.position;
        this.position = i5 + 1;
        byte b3 = bArr[i5];
        int i6 = i4 | ((b3 & 127) << 13);
        if ((b3 & 128) == 0) {
            return i6;
        }
        require(1);
        int i7 = this.position;
        this.position = i7 + 1;
        byte b4 = bArr[i7];
        int i8 = i6 | ((b4 & 127) << 20);
        if ((b4 & 128) == 0) {
            return i8;
        }
        require(1);
        int i9 = this.position;
        this.position = i9 + 1;
        return i8 | ((bArr[i9] & 127) << 27);
    }

    private void readUtf8_slow(int i, int i2) {
        char[] cArr = this.chars;
        byte[] bArr = this.buffer;
        while (i2 < i) {
            if (this.position == this.limit) {
                require(1);
            }
            int i3 = this.position;
            int i4 = i3 + 1;
            this.position = i4;
            int i5 = bArr[i3] & 255;
            switch (i5 >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    cArr[i2] = (char) i5;
                    break;
                case 12:
                case 13:
                    if (i4 == this.limit) {
                        require(1);
                    }
                    int i6 = this.position;
                    this.position = i6 + 1;
                    cArr[i2] = (char) (((i5 & 31) << 6) | (bArr[i6] & 63));
                    break;
                case 14:
                    require(2);
                    int i7 = this.position;
                    int i8 = i7 + 1;
                    this.position = i8;
                    int i9 = ((i5 & 15) << 12) | ((bArr[i7] & 63) << 6);
                    this.position = i8 + 1;
                    cArr[i2] = (char) (i9 | (bArr[i8] & 63));
                    break;
            }
            i2++;
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        int i = this.limit - this.position;
        InputStream inputStream = this.inputStream;
        return i + (inputStream != null ? inputStream.available() : 0);
    }

    public boolean canReadInt() throws KryoException {
        if (this.limit - this.position >= 5) {
            return true;
        }
        if (optional(5) <= 0) {
            return false;
        }
        int i = this.position;
        byte[] bArr = this.buffer;
        int i2 = i + 1;
        if ((bArr[i] & 128) == 0) {
            return true;
        }
        int i3 = this.limit;
        if (i2 == i3) {
            return false;
        }
        int i4 = i2 + 1;
        if ((bArr[i2] & 128) == 0) {
            return true;
        }
        if (i4 == i3) {
            return false;
        }
        int i5 = i4 + 1;
        if ((bArr[i4] & 128) == 0) {
            return true;
        }
        if (i5 == i3) {
            return false;
        }
        return (bArr[i5] & 128) == 0 || i5 + 1 != i3;
    }

    public boolean canReadLong() throws KryoException {
        if (this.limit - this.position >= 9) {
            return true;
        }
        if (optional(5) <= 0) {
            return false;
        }
        int i = this.position;
        byte[] bArr = this.buffer;
        int i2 = i + 1;
        if ((bArr[i] & 128) == 0) {
            return true;
        }
        int i3 = this.limit;
        if (i2 == i3) {
            return false;
        }
        int i4 = i2 + 1;
        if ((bArr[i2] & 128) == 0) {
            return true;
        }
        if (i4 == i3) {
            return false;
        }
        int i5 = i4 + 1;
        if ((bArr[i4] & 128) == 0) {
            return true;
        }
        if (i5 == i3) {
            return false;
        }
        int i6 = i5 + 1;
        if ((bArr[i5] & 128) == 0) {
            return true;
        }
        if (i6 == i3) {
            return false;
        }
        int i7 = i6 + 1;
        if ((bArr[i6] & 128) == 0) {
            return true;
        }
        if (i7 == i3) {
            return false;
        }
        int i8 = i7 + 1;
        if ((bArr[i7] & 128) == 0) {
            return true;
        }
        if (i8 == i3) {
            return false;
        }
        int i9 = i8 + 1;
        if ((bArr[i8] & 128) == 0) {
            return true;
        }
        if (i9 == i3) {
            return false;
        }
        return (bArr[i9] & 128) == 0 || i9 + 1 != i3;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws KryoException {
        InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public boolean eof() {
        return optional(1) <= 0;
    }

    public int fill(byte[] bArr, int i, int i2) throws KryoException {
        InputStream inputStream = this.inputStream;
        if (inputStream == null) {
            return -1;
        }
        try {
            return inputStream.read(bArr, i, i2);
        } catch (IOException e) {
            throw new KryoException(e);
        }
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public int limit() {
        return this.limit;
    }

    public int position() {
        return this.position;
    }

    @Override // java.io.InputStream
    public int read() throws KryoException {
        if (optional(1) <= 0) {
            return -1;
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        return bArr[i] & 255;
    }

    public boolean readBoolean() throws KryoException {
        require(1);
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        return bArr[i] == 1;
    }

    public byte readByte() throws KryoException {
        require(1);
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        return bArr[i];
    }

    public int readByteUnsigned() throws KryoException {
        require(1);
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        return bArr[i] & 255;
    }

    public byte[] readBytes(int i) throws KryoException {
        byte[] bArr = new byte[i];
        readBytes(bArr, 0, i);
        return bArr;
    }

    public char readChar() throws KryoException {
        require(2);
        byte[] bArr = this.buffer;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = (bArr[i] & 255) << 8;
        this.position = i2 + 1;
        return (char) ((bArr[i2] & 255) | i3);
    }

    public char[] readChars(int i) throws KryoException {
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = readChar();
        }
        return cArr;
    }

    public double readDouble() throws KryoException {
        return Double.longBitsToDouble(readLong());
    }

    public double[] readDoubles(int i) throws KryoException {
        double[] dArr = new double[i];
        for (int i2 = 0; i2 < i; i2++) {
            dArr[i2] = readDouble();
        }
        return dArr;
    }

    public float readFloat() throws KryoException {
        return Float.intBitsToFloat(readInt());
    }

    public float[] readFloats(int i) throws KryoException {
        float[] fArr = new float[i];
        for (int i2 = 0; i2 < i; i2++) {
            fArr[i2] = readFloat();
        }
        return fArr;
    }

    public int readInt() throws KryoException {
        require(4);
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 4;
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public int[] readInts(int i, boolean z2) throws KryoException {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = readInt(z2);
        }
        return iArr;
    }

    public long readLong() throws KryoException {
        require(8);
        byte[] bArr = this.buffer;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        long j = ((long) bArr[i]) << 56;
        int i3 = i2 + 1;
        this.position = i3;
        long j2 = j | (((long) (bArr[i2] & 255)) << 48);
        int i4 = i3 + 1;
        this.position = i4;
        long j3 = j2 | (((long) (bArr[i3] & 255)) << 40);
        int i5 = i4 + 1;
        this.position = i5;
        long j4 = j3 | (((long) (bArr[i4] & 255)) << 32);
        int i6 = i5 + 1;
        this.position = i6;
        long j5 = j4 | (((long) (bArr[i5] & 255)) << 24);
        int i7 = i6 + 1;
        this.position = i7;
        long j6 = j5 | ((long) ((bArr[i6] & 255) << 16));
        int i8 = i7 + 1;
        this.position = i8;
        long j7 = j6 | ((long) ((bArr[i7] & 255) << 8));
        this.position = i8 + 1;
        return ((long) (bArr[i8] & 255)) | j7;
    }

    public long[] readLongs(int i, boolean z2) throws KryoException {
        long[] jArr = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            jArr[i2] = readLong(z2);
        }
        return jArr;
    }

    public short readShort() throws KryoException {
        require(2);
        byte[] bArr = this.buffer;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = (bArr[i] & 255) << 8;
        this.position = i2 + 1;
        return (short) ((bArr[i2] & 255) | i3);
    }

    public int readShortUnsigned() throws KryoException {
        require(2);
        byte[] bArr = this.buffer;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        int i3 = (bArr[i] & 255) << 8;
        this.position = i2 + 1;
        return (bArr[i2] & 255) | i3;
    }

    public short[] readShorts(int i) throws KryoException {
        short[] sArr = new short[i];
        for (int i2 = 0; i2 < i; i2++) {
            sArr[i2] = readShort();
        }
        return sArr;
    }

    public String readString() {
        int iRequire = require(1);
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        byte b2 = bArr[i];
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
        int i2 = utf8Length - 1;
        if (this.chars.length < i2) {
            this.chars = new char[i2];
        }
        readUtf8(i2);
        return new String(this.chars, 0, i2);
    }

    public StringBuilder readStringBuilder() {
        int iRequire = require(1);
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        byte b2 = bArr[i];
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
        int i2 = utf8Length - 1;
        if (this.chars.length < i2) {
            this.chars = new char[i2];
        }
        readUtf8(i2);
        StringBuilder sb = new StringBuilder(i2);
        sb.append(this.chars, 0, i2);
        return sb;
    }

    public int readVarInt(boolean z2) throws KryoException {
        if (require(1) < 5) {
            return readInt_slow(z2);
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        byte b2 = bArr[i];
        int i3 = b2 & 127;
        if ((b2 & 128) != 0) {
            int i4 = i2 + 1;
            this.position = i4;
            byte b3 = bArr[i2];
            i3 |= (b3 & 127) << 7;
            if ((b3 & 128) != 0) {
                int i5 = i4 + 1;
                this.position = i5;
                byte b4 = bArr[i4];
                i3 |= (b4 & 127) << 14;
                if ((b4 & 128) != 0) {
                    int i6 = i5 + 1;
                    this.position = i6;
                    byte b5 = bArr[i5];
                    i3 |= (b5 & 127) << 21;
                    if ((b5 & 128) != 0) {
                        this.position = i6 + 1;
                        i3 |= (bArr[i6] & 127) << 28;
                    }
                }
            }
        }
        return z2 ? i3 : (i3 >>> 1) ^ (-(i3 & 1));
    }

    public long readVarLong(boolean z2) throws KryoException {
        if (require(1) < 9) {
            return readLong_slow(z2);
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        int i2 = i + 1;
        this.position = i2;
        byte b2 = bArr[i];
        long j = b2 & 127;
        if ((b2 & 128) != 0) {
            int i3 = i2 + 1;
            this.position = i3;
            byte b3 = bArr[i2];
            j |= (long) ((b3 & 127) << 7);
            if ((b3 & 128) != 0) {
                int i4 = i3 + 1;
                this.position = i4;
                byte b4 = bArr[i3];
                j |= (long) ((b4 & 127) << 14);
                if ((b4 & 128) != 0) {
                    int i5 = i4 + 1;
                    this.position = i5;
                    byte b5 = bArr[i4];
                    j |= (long) ((b5 & 127) << 21);
                    if ((b5 & 128) != 0) {
                        int i6 = i5 + 1;
                        this.position = i6;
                        byte b6 = bArr[i5];
                        j |= ((long) (b6 & 127)) << 28;
                        if ((b6 & 128) != 0) {
                            int i7 = i6 + 1;
                            this.position = i7;
                            byte b7 = bArr[i6];
                            j |= ((long) (b7 & 127)) << 35;
                            if ((b7 & 128) != 0) {
                                int i8 = i7 + 1;
                                this.position = i8;
                                byte b8 = bArr[i7];
                                j |= ((long) (b8 & 127)) << 42;
                                if ((b8 & 128) != 0) {
                                    int i9 = i8 + 1;
                                    this.position = i9;
                                    byte b9 = bArr[i8];
                                    j |= ((long) (b9 & 127)) << 49;
                                    if ((b9 & 128) != 0) {
                                        this.position = i9 + 1;
                                        j |= ((long) bArr[i9]) << 56;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return !z2 ? (j >>> 1) ^ (-(1 & j)) : j;
    }

    public int require(int i) throws KryoException {
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
            int iFill = fill(this.buffer, i2, i4 - i2);
            if (iFill == -1) {
                throw new KryoException("Buffer underflow.");
            }
            i3 += iFill;
            if (i3 >= i) {
                this.limit += iFill;
                return i3;
            }
        }
        byte[] bArr = this.buffer;
        System.arraycopy(bArr, this.position, bArr, 0, i3);
        this.total += (long) this.position;
        this.position = 0;
        do {
            int iFill2 = fill(this.buffer, i3, this.capacity - i3);
            if (iFill2 == -1) {
                if (i3 >= i) {
                    break;
                }
                throw new KryoException("Buffer underflow.");
            }
            i3 += iFill2;
        } while (i3 < i);
        this.limit = i3;
        return i3;
    }

    public void rewind() {
        this.position = 0;
        this.total = 0L;
    }

    public void setBuffer(byte[] bArr) {
        setBuffer(bArr, 0, bArr.length);
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
        this.limit = 0;
        rewind();
    }

    public void setLimit(int i) {
        this.limit = i;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public void setTotal(long j) {
        this.total = j;
    }

    public void skip(int i) throws KryoException {
        int iMin = Math.min(this.limit - this.position, i);
        while (true) {
            this.position += iMin;
            i -= iMin;
            if (i == 0) {
                return;
            }
            iMin = Math.min(i, this.capacity);
            require(iMin);
        }
    }

    public long total() {
        return this.total + ((long) this.position);
    }

    public double readDouble(double d, boolean z2) throws KryoException {
        return readLong(z2) / d;
    }

    public float readFloat(float f, boolean z2) throws KryoException {
        return readInt(z2) / f;
    }

    public void setBuffer(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("bytes cannot be null.");
        }
        this.buffer = bArr;
        this.position = i;
        this.limit = i + i2;
        this.capacity = bArr.length;
        this.total = 0L;
        this.inputStream = null;
    }

    public Input(int i) {
        this.chars = new char[32];
        this.capacity = i;
        this.buffer = new byte[i];
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws KryoException {
        return read(bArr, 0, bArr.length);
    }

    public void readBytes(byte[] bArr) throws KryoException {
        readBytes(bArr, 0, bArr.length);
    }

    public int[] readInts(int i) throws KryoException {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = readInt();
        }
        return iArr;
    }

    public long[] readLongs(int i) throws KryoException {
        long[] jArr = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            jArr[i2] = readLong();
        }
        return jArr;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws KryoException {
        if (bArr != null) {
            int iMin = Math.min(this.limit - this.position, i2);
            int i3 = i2;
            do {
                System.arraycopy(this.buffer, this.position, bArr, i, iMin);
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

    public void readBytes(byte[] bArr, int i, int i2) throws KryoException {
        if (bArr != null) {
            int iMin = Math.min(this.limit - this.position, i2);
            while (true) {
                System.arraycopy(this.buffer, this.position, bArr, i, iMin);
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

    public long readLong(boolean z2) throws KryoException {
        return readVarLong(z2);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws KryoException {
        long j2 = j;
        while (j2 > 0) {
            int iMin = (int) Math.min(2147483639L, j2);
            skip(iMin);
            j2 -= (long) iMin;
        }
        return j;
    }

    public int readInt(boolean z2) throws KryoException {
        return readVarInt(z2);
    }

    public Input(byte[] bArr) {
        this.chars = new char[32];
        setBuffer(bArr, 0, bArr.length);
    }

    public Input(byte[] bArr, int i, int i2) {
        this.chars = new char[32];
        setBuffer(bArr, i, i2);
    }

    public Input(InputStream inputStream) {
        this(4096);
        if (inputStream != null) {
            this.inputStream = inputStream;
            return;
        }
        throw new IllegalArgumentException("inputStream cannot be null.");
    }

    public Input(InputStream inputStream, int i) {
        this(i);
        if (inputStream != null) {
            this.inputStream = inputStream;
            return;
        }
        throw new IllegalArgumentException("inputStream cannot be null.");
    }
}
