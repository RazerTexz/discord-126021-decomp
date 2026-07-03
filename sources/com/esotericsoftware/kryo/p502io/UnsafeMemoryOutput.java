package com.esotericsoftware.kryo.p502io;

import com.discord.api.permission.Permission;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import com.esotericsoftware.kryo.util.Util;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public final class UnsafeMemoryOutput extends ByteBufferOutput {
    private static final boolean isLittleEndian = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN);
    private long bufaddress;

    public UnsafeMemoryOutput() {
        this.varIntsEnabled = false;
    }

    private void updateBufferAddress() {
        this.bufaddress = this.niobuffer.address();
    }

    private final void writeLittleEndianInt(int i) {
        if (isLittleEndian) {
            writeInt(i);
        } else {
            writeInt(Util.swapInt(i));
        }
    }

    private final void writeLittleEndianLong(long j) {
        if (isLittleEndian) {
            writeLong(j);
        } else {
            writeLong(Util.swapLong(j));
        }
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferOutput
    public void setBuffer(ByteBuffer byteBuffer, int i) {
        super.setBuffer(byteBuffer, i);
        updateBufferAddress();
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferOutput, com.esotericsoftware.kryo.p502io.Output
    public final void writeBoolean(boolean z2) throws KryoException {
        this.niobuffer.position(this.position);
        super.writeBoolean(z2);
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferOutput, com.esotericsoftware.kryo.p502io.Output
    public final void writeByte(int i) throws KryoException {
        this.niobuffer.position(this.position);
        super.writeByte(i);
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferOutput, com.esotericsoftware.kryo.p502io.Output
    public void writeBytes(byte[] bArr) throws KryoException {
        if (bArr == null) {
            throw new IllegalArgumentException("bytes cannot be null.");
        }
        writeBytes(bArr, 0L, bArr.length);
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferOutput, com.esotericsoftware.kryo.p502io.Output
    public final void writeChar(char c) throws KryoException {
        require(2);
        UnsafeUtil.unsafe().putChar(this.bufaddress + ((long) this.position), c);
        this.position += 2;
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferOutput, com.esotericsoftware.kryo.p502io.Output
    public final void writeChars(char[] cArr) throws KryoException {
        writeBytes(cArr, UnsafeUtil.charArrayBaseOffset, 0L, cArr.length << 1);
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferOutput, com.esotericsoftware.kryo.p502io.Output
    public final void writeDouble(double d) throws KryoException {
        require(8);
        UnsafeUtil.unsafe().putDouble(this.bufaddress + ((long) this.position), d);
        this.position += 8;
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferOutput, com.esotericsoftware.kryo.p502io.Output
    public final void writeDoubles(double[] dArr) throws KryoException {
        writeBytes(dArr, UnsafeUtil.doubleArrayBaseOffset, 0L, dArr.length << 3);
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferOutput, com.esotericsoftware.kryo.p502io.Output
    public final void writeFloat(float f) throws KryoException {
        require(4);
        UnsafeUtil.unsafe().putFloat(this.bufaddress + ((long) this.position), f);
        this.position += 4;
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferOutput, com.esotericsoftware.kryo.p502io.Output
    public final void writeFloats(float[] fArr) throws KryoException {
        writeBytes(fArr, UnsafeUtil.floatArrayBaseOffset, 0L, fArr.length << 2);
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferOutput, com.esotericsoftware.kryo.p502io.Output
    public final void writeInt(int i) throws KryoException {
        require(4);
        UnsafeUtil.unsafe().putInt(this.bufaddress + ((long) this.position), i);
        this.position += 4;
    }

    @Override // com.esotericsoftware.kryo.p502io.Output
    public final void writeInts(int[] iArr, boolean z2) throws KryoException {
        if (this.varIntsEnabled) {
            super.writeInts(iArr, z2);
        } else {
            writeBytes(iArr, UnsafeUtil.intArrayBaseOffset, 0L, iArr.length << 2);
        }
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferOutput, com.esotericsoftware.kryo.p502io.Output
    public final void writeLong(long j) throws KryoException {
        require(8);
        UnsafeUtil.unsafe().putLong(this.bufaddress + ((long) this.position), j);
        this.position += 8;
    }

    @Override // com.esotericsoftware.kryo.p502io.Output
    public final void writeLongs(long[] jArr, boolean z2) throws KryoException {
        if (this.varIntsEnabled) {
            super.writeLongs(jArr, z2);
        } else {
            writeBytes(jArr, UnsafeUtil.longArrayBaseOffset, 0L, jArr.length << 3);
        }
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferOutput, com.esotericsoftware.kryo.p502io.Output
    public final void writeShort(int i) throws KryoException {
        require(2);
        UnsafeUtil.unsafe().putShort(this.bufaddress + ((long) this.position), (short) i);
        this.position += 2;
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferOutput, com.esotericsoftware.kryo.p502io.Output
    public final void writeShorts(short[] sArr) throws KryoException {
        writeBytes(sArr, UnsafeUtil.shortArrayBaseOffset, 0L, sArr.length << 1);
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferOutput, com.esotericsoftware.kryo.p502io.Output
    public final int writeVarInt(int i, boolean z2) throws KryoException {
        long j = i;
        if (!z2) {
            j = (j >> 31) ^ (j << 1);
        }
        long j2 = j & 127;
        long j3 = j >>> 7;
        if (j3 == 0) {
            writeByte((byte) j2);
            return 1;
        }
        long j4 = j2 | 128 | ((j3 & 127) << 8);
        long j5 = j3 >>> 7;
        if (j5 == 0) {
            writeLittleEndianInt((int) j4);
            this.position -= 2;
            return 2;
        }
        long j6 = j4 | Permission.ATTACH_FILES | ((j5 & 127) << 16);
        long j7 = j5 >>> 7;
        if (j7 == 0) {
            writeLittleEndianInt((int) j6);
            this.position--;
            return 3;
        }
        long j8 = j6 | Permission.DEAFEN_MEMBERS | ((j7 & 127) << 24);
        long j9 = j7 >>> 7;
        if (j9 == 0) {
            writeLittleEndianInt((int) j8);
            this.position += 0;
            return 4;
        }
        writeLittleEndianLong((((j9 & 127) << 32) | Permission.USE_APPLICATION_COMMANDS | j8) & 68719476735L);
        this.position -= 3;
        return 5;
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferOutput, com.esotericsoftware.kryo.p502io.Output
    public final int writeVarLong(long j, boolean z2) throws KryoException {
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
            writeLittleEndianInt(i2);
            this.position -= 2;
            return 2;
        }
        int i3 = (int) (((long) (i2 | 32768)) | ((j4 & 127) << 16));
        long j5 = j4 >>> 7;
        if (j5 == 0) {
            writeLittleEndianInt(i3);
            this.position--;
            return 3;
        }
        int i4 = (int) (((long) (i3 | 8388608)) | ((j5 & 127) << 24));
        long j6 = j5 >>> 7;
        if (j6 == 0) {
            writeLittleEndianInt(i4);
            this.position += 0;
            return 4;
        }
        long j7 = (((long) ((int) (((long) i4) | Permission.USE_APPLICATION_COMMANDS))) & 4294967295L) | ((j6 & 127) << 32);
        long j8 = j6 >>> 7;
        if (j8 == 0) {
            writeLittleEndianLong(j7);
            this.position -= 3;
            return 5;
        }
        long j9 = j7 | 549755813888L | ((j8 & 127) << 40);
        long j10 = j8 >>> 7;
        if (j10 == 0) {
            writeLittleEndianLong(j9);
            this.position -= 2;
            return 6;
        }
        long j11 = j9 | 140737488355328L | ((j10 & 127) << 48);
        long j12 = j10 >>> 7;
        if (j12 == 0) {
            writeLittleEndianLong(j11);
            this.position--;
            return 7;
        }
        long j13 = ((127 & j12) << 56) | j11 | 36028797018963968L;
        long j14 = j12 >>> 7;
        if (j14 == 0) {
            writeLittleEndianLong(j13);
            return 8;
        }
        writeLittleEndianLong(j13 | Long.MIN_VALUE);
        writeByte((int) (j14 & 255));
        return 9;
    }

    public UnsafeMemoryOutput(int i) {
        this(i, i);
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferOutput, com.esotericsoftware.kryo.p502io.Output
    public void writeByte(byte b2) throws KryoException {
        this.niobuffer.position(this.position);
        super.writeByte(b2);
    }

    public final void writeBytes(Object obj, long j, long j2) throws KryoException {
        writeBytes(obj, UnsafeUtil.byteArrayBaseOffset, j, j2);
    }

    public UnsafeMemoryOutput(int i, int i2) {
        super(i, i2);
        this.varIntsEnabled = false;
        updateBufferAddress();
    }

    private final void writeBytes(Object obj, long j, long j2, long j3) throws KryoException {
        int iMin = Math.min(this.capacity - this.position, (int) j3);
        long j4 = j3;
        long j5 = j2;
        while (true) {
            long j6 = iMin;
            UnsafeUtil.unsafe().copyMemory(obj, j + j5, (Object) null, this.bufaddress + ((long) this.position), j6);
            this.position += iMin;
            j4 -= j6;
            if (j4 == 0) {
                return;
            }
            j5 += j6;
            iMin = Math.min(this.capacity, (int) j4);
            require(iMin);
        }
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferOutput, com.esotericsoftware.kryo.p502io.Output
    public final int writeInt(int i, boolean z2) throws KryoException {
        if (!this.varIntsEnabled) {
            writeInt(i);
            return 4;
        }
        return writeVarInt(i, z2);
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferOutput, com.esotericsoftware.kryo.p502io.Output
    public final int writeLong(long j, boolean z2) throws KryoException {
        if (!this.varIntsEnabled) {
            writeLong(j);
            return 8;
        }
        return writeVarLong(j, z2);
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferOutput, com.esotericsoftware.kryo.p502io.Output
    public final void writeInts(int[] iArr) throws KryoException {
        writeBytes(iArr, UnsafeUtil.intArrayBaseOffset, 0L, iArr.length << 2);
    }

    @Override // com.esotericsoftware.kryo.p502io.ByteBufferOutput, com.esotericsoftware.kryo.p502io.Output
    public final void writeLongs(long[] jArr) throws KryoException {
        writeBytes(jArr, UnsafeUtil.longArrayBaseOffset, 0L, jArr.length << 3);
    }

    public UnsafeMemoryOutput(OutputStream outputStream) {
        super(outputStream);
        this.varIntsEnabled = false;
        updateBufferAddress();
    }

    public UnsafeMemoryOutput(OutputStream outputStream, int i) {
        super(outputStream, i);
        this.varIntsEnabled = false;
        updateBufferAddress();
    }

    public UnsafeMemoryOutput(long j, int i) {
        super(j, i);
        this.varIntsEnabled = false;
        updateBufferAddress();
    }
}
