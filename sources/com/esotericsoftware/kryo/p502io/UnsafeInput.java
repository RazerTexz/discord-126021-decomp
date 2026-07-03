package com.esotericsoftware.kryo.p502io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class UnsafeInput extends Input {
    private boolean varIntsEnabled;

    public UnsafeInput() {
        this.varIntsEnabled = false;
    }

    public boolean getVarIntsEnabled() {
        return this.varIntsEnabled;
    }

    public final void readBytes(Object obj, long j, long j2) throws KryoException {
        if (!obj.getClass().isArray()) {
            throw new KryoException("Only bulk reads of arrays is supported");
        }
        readBytes(obj, 0L, j, (int) j2);
    }

    @Override // com.esotericsoftware.kryo.p502io.Input
    public char readChar() throws KryoException {
        require(2);
        char c = UnsafeUtil.unsafe().getChar(this.buffer, UnsafeUtil.byteArrayBaseOffset + ((long) this.position));
        this.position += 2;
        return c;
    }

    @Override // com.esotericsoftware.kryo.p502io.Input
    public final char[] readChars(int i) throws KryoException {
        int i2 = i << 1;
        char[] cArr = new char[i];
        readBytes(cArr, UnsafeUtil.charArrayBaseOffset, 0L, i2);
        return cArr;
    }

    @Override // com.esotericsoftware.kryo.p502io.Input
    public double readDouble() throws KryoException {
        require(8);
        double d = UnsafeUtil.unsafe().getDouble(this.buffer, UnsafeUtil.byteArrayBaseOffset + ((long) this.position));
        this.position += 8;
        return d;
    }

    @Override // com.esotericsoftware.kryo.p502io.Input
    public final double[] readDoubles(int i) throws KryoException {
        int i2 = i << 3;
        double[] dArr = new double[i];
        readBytes(dArr, UnsafeUtil.doubleArrayBaseOffset, 0L, i2);
        return dArr;
    }

    @Override // com.esotericsoftware.kryo.p502io.Input
    public float readFloat() throws KryoException {
        require(4);
        float f = UnsafeUtil.unsafe().getFloat(this.buffer, UnsafeUtil.byteArrayBaseOffset + ((long) this.position));
        this.position += 4;
        return f;
    }

    @Override // com.esotericsoftware.kryo.p502io.Input
    public final float[] readFloats(int i) throws KryoException {
        int i2 = i << 2;
        float[] fArr = new float[i];
        readBytes(fArr, UnsafeUtil.floatArrayBaseOffset, 0L, i2);
        return fArr;
    }

    @Override // com.esotericsoftware.kryo.p502io.Input
    public int readInt() throws KryoException {
        require(4);
        int i = UnsafeUtil.unsafe().getInt(this.buffer, UnsafeUtil.byteArrayBaseOffset + ((long) this.position));
        this.position += 4;
        return i;
    }

    @Override // com.esotericsoftware.kryo.p502io.Input
    public final int[] readInts(int i, boolean z2) throws KryoException {
        if (this.varIntsEnabled) {
            return super.readInts(i, z2);
        }
        int i2 = i << 2;
        int[] iArr = new int[i];
        readBytes(iArr, UnsafeUtil.intArrayBaseOffset, 0L, i2);
        return iArr;
    }

    @Override // com.esotericsoftware.kryo.p502io.Input
    public long readLong() throws KryoException {
        require(8);
        long j = UnsafeUtil.unsafe().getLong(this.buffer, UnsafeUtil.byteArrayBaseOffset + ((long) this.position));
        this.position += 8;
        return j;
    }

    @Override // com.esotericsoftware.kryo.p502io.Input
    public final long[] readLongs(int i, boolean z2) throws KryoException {
        if (this.varIntsEnabled) {
            return super.readLongs(i, z2);
        }
        int i2 = i << 3;
        long[] jArr = new long[i];
        readBytes(jArr, UnsafeUtil.longArrayBaseOffset, 0L, i2);
        return jArr;
    }

    @Override // com.esotericsoftware.kryo.p502io.Input
    public short readShort() throws KryoException {
        require(2);
        short s2 = UnsafeUtil.unsafe().getShort(this.buffer, UnsafeUtil.byteArrayBaseOffset + ((long) this.position));
        this.position += 2;
        return s2;
    }

    @Override // com.esotericsoftware.kryo.p502io.Input
    public final short[] readShorts(int i) throws KryoException {
        int i2 = i << 1;
        short[] sArr = new short[i];
        readBytes(sArr, UnsafeUtil.shortArrayBaseOffset, 0L, i2);
        return sArr;
    }

    public void setVarIntsEnabled(boolean z2) {
        this.varIntsEnabled = z2;
    }

    public UnsafeInput(int i) {
        super(i);
        this.varIntsEnabled = false;
    }

    private final void readBytes(Object obj, long j, long j2, int i) throws KryoException {
        int iMin = Math.min(this.limit - this.position, i);
        int i2 = i;
        long j3 = j2;
        while (true) {
            long j4 = iMin;
            UnsafeUtil.unsafe().copyMemory(this.buffer, UnsafeUtil.byteArrayBaseOffset + ((long) this.position), obj, j + j3, j4);
            this.position += iMin;
            i2 -= iMin;
            if (i2 == 0) {
                return;
            }
            j3 += j4;
            iMin = Math.min(i2, this.capacity);
            require(iMin);
        }
    }

    @Override // com.esotericsoftware.kryo.p502io.Input
    public int readInt(boolean z2) throws KryoException {
        if (!this.varIntsEnabled) {
            return readInt();
        }
        return super.readInt(z2);
    }

    @Override // com.esotericsoftware.kryo.p502io.Input
    public long readLong(boolean z2) throws KryoException {
        if (!this.varIntsEnabled) {
            return readLong();
        }
        return super.readLong(z2);
    }

    public UnsafeInput(byte[] bArr) {
        super(bArr);
        this.varIntsEnabled = false;
    }

    @Override // com.esotericsoftware.kryo.p502io.Input
    public final int[] readInts(int i) throws KryoException {
        int i2 = i << 2;
        int[] iArr = new int[i];
        readBytes(iArr, UnsafeUtil.intArrayBaseOffset, 0L, i2);
        return iArr;
    }

    @Override // com.esotericsoftware.kryo.p502io.Input
    public final long[] readLongs(int i) throws KryoException {
        int i2 = i << 3;
        long[] jArr = new long[i];
        readBytes(jArr, UnsafeUtil.longArrayBaseOffset, 0L, i2);
        return jArr;
    }

    public UnsafeInput(byte[] bArr, int i, int i2) {
        super(bArr, i, i2);
        this.varIntsEnabled = false;
    }

    public UnsafeInput(InputStream inputStream) {
        super(inputStream);
        this.varIntsEnabled = false;
    }

    public UnsafeInput(InputStream inputStream, int i) {
        super(inputStream, i);
        this.varIntsEnabled = false;
    }
}
