package androidx.exifinterface.media;

import android.util.Log;
import b.d.b.a.a;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class ExifInterface$ByteOrderedDataInputStream extends InputStream implements DataInput {
    private ByteOrder mByteOrder;
    public final DataInputStream mDataInputStream;
    public int mPosition;
    private byte[] mSkipBuffer;
    private static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
    private static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;

    public ExifInterface$ByteOrderedDataInputStream(byte[] bArr) throws IOException {
        this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.mDataInputStream.available();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        throw new UnsupportedOperationException("Mark is currently unsupported");
    }

    public int position() {
        return this.mPosition;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        this.mPosition++;
        return this.mDataInputStream.read();
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        this.mPosition++;
        return this.mDataInputStream.readBoolean();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        this.mPosition++;
        int i = this.mDataInputStream.read();
        if (i >= 0) {
            return (byte) i;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        this.mPosition += 2;
        return this.mDataInputStream.readChar();
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.mPosition += i2;
        this.mDataInputStream.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        this.mPosition += 4;
        int i = this.mDataInputStream.read();
        int i2 = this.mDataInputStream.read();
        int i3 = this.mDataInputStream.read();
        int i4 = this.mDataInputStream.read();
        if ((i | i2 | i3 | i4) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == LITTLE_ENDIAN) {
            return (i4 << 24) + (i3 << 16) + (i2 << 8) + i;
        }
        if (byteOrder == BIG_ENDIAN) {
            return (i << 24) + (i2 << 16) + (i3 << 8) + i4;
        }
        StringBuilder sbU = a.U("Invalid byte order: ");
        sbU.append(this.mByteOrder);
        throw new IOException(sbU.toString());
    }

    @Override // java.io.DataInput
    public String readLine() throws IOException {
        Log.d("ExifInterface", "Currently unsupported");
        return null;
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        this.mPosition += 8;
        int i = this.mDataInputStream.read();
        int i2 = this.mDataInputStream.read();
        int i3 = this.mDataInputStream.read();
        int i4 = this.mDataInputStream.read();
        int i5 = this.mDataInputStream.read();
        int i6 = this.mDataInputStream.read();
        int i7 = this.mDataInputStream.read();
        int i8 = this.mDataInputStream.read();
        if ((i | i2 | i3 | i4 | i5 | i6 | i7 | i8) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == LITTLE_ENDIAN) {
            return (((long) i8) << 56) + (((long) i7) << 48) + (((long) i6) << 40) + (((long) i5) << 32) + (((long) i4) << 24) + (((long) i3) << 16) + (((long) i2) << 8) + ((long) i);
        }
        if (byteOrder == BIG_ENDIAN) {
            return (((long) i) << 56) + (((long) i2) << 48) + (((long) i3) << 40) + (((long) i4) << 32) + (((long) i5) << 24) + (((long) i6) << 16) + (((long) i7) << 8) + ((long) i8);
        }
        StringBuilder sbU = a.U("Invalid byte order: ");
        sbU.append(this.mByteOrder);
        throw new IOException(sbU.toString());
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        this.mPosition += 2;
        int i = this.mDataInputStream.read();
        int i2 = this.mDataInputStream.read();
        if ((i | i2) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == LITTLE_ENDIAN) {
            return (short) ((i2 << 8) + i);
        }
        if (byteOrder == BIG_ENDIAN) {
            return (short) ((i << 8) + i2);
        }
        StringBuilder sbU = a.U("Invalid byte order: ");
        sbU.append(this.mByteOrder);
        throw new IOException(sbU.toString());
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        this.mPosition += 2;
        return this.mDataInputStream.readUTF();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        this.mPosition++;
        return this.mDataInputStream.readUnsignedByte();
    }

    public long readUnsignedInt() throws IOException {
        return ((long) readInt()) & 4294967295L;
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        this.mPosition += 2;
        int i = this.mDataInputStream.read();
        int i2 = this.mDataInputStream.read();
        if ((i | i2) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == LITTLE_ENDIAN) {
            return (i2 << 8) + i;
        }
        if (byteOrder == BIG_ENDIAN) {
            return (i << 8) + i2;
        }
        StringBuilder sbU = a.U("Invalid byte order: ");
        sbU.append(this.mByteOrder);
        throw new IOException(sbU.toString());
    }

    @Override // java.io.InputStream
    public void reset() {
        throw new UnsupportedOperationException("Reset is currently unsupported");
    }

    public void setByteOrder(ByteOrder byteOrder) {
        this.mByteOrder = byteOrder;
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) throws IOException {
        throw new UnsupportedOperationException("skipBytes is currently unsupported");
    }

    public void skipFully(int i) throws IOException {
        int i2 = 0;
        while (i2 < i) {
            int i3 = i - i2;
            int iSkip = (int) this.mDataInputStream.skip(i3);
            if (iSkip <= 0) {
                if (this.mSkipBuffer == null) {
                    this.mSkipBuffer = new byte[8192];
                }
                iSkip = this.mDataInputStream.read(this.mSkipBuffer, 0, Math.min(8192, i3));
                if (iSkip == -1) {
                    throw new EOFException(a.r("Reached EOF while skipping ", i, " bytes."));
                }
            }
            i2 += iSkip;
        }
        this.mPosition += i2;
    }

    public ExifInterface$ByteOrderedDataInputStream(InputStream inputStream) throws IOException {
        this(inputStream, ByteOrder.BIG_ENDIAN);
    }

    public ExifInterface$ByteOrderedDataInputStream(InputStream inputStream, ByteOrder byteOrder) throws IOException {
        this.mByteOrder = ByteOrder.BIG_ENDIAN;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.mDataInputStream = dataInputStream;
        dataInputStream.mark(0);
        this.mPosition = 0;
        this.mByteOrder = byteOrder;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.mDataInputStream.read(bArr, i, i2);
        this.mPosition += i3;
        return i3;
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        this.mPosition += bArr.length;
        this.mDataInputStream.readFully(bArr);
    }
}
