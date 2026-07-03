package com.esotericsoftware.kryo.p502io;

import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class UnsafeMemoryInput extends ByteBufferInput {
    private long bufaddress;

    public UnsafeMemoryInput() {
        this.varIntsEnabled = false;
    }

    private void updateBufferAddress() {
        this.bufaddress = this.niobuffer.address();
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferInput, com.esotericsoftware.kryo.p502io.Input
    public boolean readBoolean() throws KryoException {
        this.niobuffer.position(this.position);
        return super.readBoolean();
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferInput, com.esotericsoftware.kryo.p502io.Input
    public byte readByte() throws KryoException {
        this.niobuffer.position(this.position);
        return super.readByte();
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferInput, com.esotericsoftware.kryo.p502io.Input
    public byte[] readBytes(int i) throws KryoException {
        byte[] bArr = new byte[i];
        readBytes(bArr, 0L, i);
        return bArr;
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferInput, com.esotericsoftware.kryo.p502io.Input
    public char readChar() throws KryoException {
        require(2);
        char c = UnsafeUtil.unsafe().getChar(this.bufaddress + ((long) this.position));
        this.position += 2;
        return c;
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferInput, com.esotericsoftware.kryo.p502io.Input
    public final char[] readChars(int i) throws KryoException {
        int i2 = i << 1;
        char[] cArr = new char[i];
        readBytes(cArr, UnsafeUtil.charArrayBaseOffset, 0L, i2);
        return cArr;
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferInput, com.esotericsoftware.kryo.p502io.Input
    public double readDouble() throws KryoException {
        require(8);
        double d = UnsafeUtil.unsafe().getDouble(this.bufaddress + ((long) this.position));
        this.position += 8;
        return d;
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferInput, com.esotericsoftware.kryo.p502io.Input
    public final double[] readDoubles(int i) throws KryoException {
        int i2 = i << 3;
        double[] dArr = new double[i];
        readBytes(dArr, UnsafeUtil.doubleArrayBaseOffset, 0L, i2);
        return dArr;
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferInput, com.esotericsoftware.kryo.p502io.Input
    public float readFloat() throws KryoException {
        require(4);
        float f = UnsafeUtil.unsafe().getFloat(this.bufaddress + ((long) this.position));
        this.position += 4;
        return f;
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferInput, com.esotericsoftware.kryo.p502io.Input
    public final float[] readFloats(int i) throws KryoException {
        int i2 = i << 2;
        float[] fArr = new float[i];
        readBytes(fArr, UnsafeUtil.floatArrayBaseOffset, 0L, i2);
        return fArr;
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferInput, com.esotericsoftware.kryo.p502io.Input
    public int readInt() throws KryoException {
        require(4);
        int i = UnsafeUtil.unsafe().getInt(this.bufaddress + ((long) this.position));
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

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferInput, com.esotericsoftware.kryo.p502io.Input
    public long readLong() throws KryoException {
        require(8);
        long j = UnsafeUtil.unsafe().getLong(this.bufaddress + ((long) this.position));
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

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferInput, com.esotericsoftware.kryo.p502io.Input
    public short readShort() throws KryoException {
        require(2);
        short s2 = UnsafeUtil.unsafe().getShort(this.bufaddress + ((long) this.position));
        this.position += 2;
        return s2;
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferInput, com.esotericsoftware.kryo.p502io.Input
    public final short[] readShorts(int i) throws KryoException {
        int i2 = i << 1;
        short[] sArr = new short[i];
        readBytes(sArr, UnsafeUtil.shortArrayBaseOffset, 0L, i2);
        return sArr;
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferInput
    public void setBuffer(ByteBuffer byteBuffer) {
        super.setBuffer(byteBuffer);
        updateBufferAddress();
    }

    public UnsafeMemoryInput(int i) {
        super(i);
        this.varIntsEnabled = false;
        updateBufferAddress();
    }

    public final void readBytes(Object obj, long j, long j2) throws KryoException {
        if (obj.getClass().isArray()) {
            readBytes(obj, UnsafeUtil.byteArrayBaseOffset, j, (int) j2);
            return;
        }
        throw new KryoException("Only bulk reads of arrays is supported");
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferInput, com.esotericsoftware.kryo.p502io.Input
    public int readInt(boolean z2) throws KryoException {
        if (!this.varIntsEnabled) {
            return readInt();
        }
        return super.readInt(z2);
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferInput, com.esotericsoftware.kryo.p502io.Input
    public long readLong(boolean z2) throws KryoException {
        if (!this.varIntsEnabled) {
            return readLong();
        }
        return super.readLong(z2);
    }

    public UnsafeMemoryInput(byte[] bArr) {
        super(bArr);
        this.varIntsEnabled = false;
        updateBufferAddress();
    }

    private final void readBytes(Object obj, long j, long j2, int i) throws KryoException {
        int iMin = Math.min(this.limit - this.position, i);
        int i2 = i;
        long j3 = j2;
        while (true) {
            long j4 = iMin;
            UnsafeUtil.unsafe().copyMemory((Object) null, this.bufaddress + ((long) this.position), obj, j + j3, j4);
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

    public UnsafeMemoryInput(ByteBuffer byteBuffer) {
        super(byteBuffer);
        this.varIntsEnabled = false;
        updateBufferAddress();
    }

    public UnsafeMemoryInput(long j, int i) {
        super(j, i);
        this.varIntsEnabled = false;
        updateBufferAddress();
    }

    public UnsafeMemoryInput(InputStream inputStream) {
        super(inputStream);
        this.varIntsEnabled = false;
        updateBufferAddress();
    }

    public UnsafeMemoryInput(InputStream inputStream, int i) {
        super(inputStream, i);
        this.varIntsEnabled = false;
        updateBufferAddress();
    }
}
