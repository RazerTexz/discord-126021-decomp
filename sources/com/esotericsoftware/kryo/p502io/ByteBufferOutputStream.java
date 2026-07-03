package com.esotericsoftware.kryo.p502io;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferOutputStream extends OutputStream {
    private ByteBuffer byteBuffer;

    public ByteBufferOutputStream() {
    }

    public ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }

    public void setByteBuffer(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        if (!this.byteBuffer.hasRemaining()) {
            flush();
        }
        this.byteBuffer.put((byte) i);
    }

    public ByteBufferOutputStream(int i) {
        this(ByteBuffer.allocate(i));
    }

    public ByteBufferOutputStream(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.byteBuffer.remaining() < i2) {
            flush();
        }
        this.byteBuffer.put(bArr, i, i2);
    }
}
