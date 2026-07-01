package com.esotericsoftware.kryo.io;

import b.e.a.a;
import b.e.a.a$a;
import com.esotericsoftware.kryo.KryoException;
import java.io.IOException;
import java.io.InputStream;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public class InputChunked extends Input {
    private int chunkSize;

    public InputChunked() {
        super(2048);
        this.chunkSize = -1;
    }

    private void readChunkSize() {
        try {
            InputStream inputStream = getInputStream();
            int i = 0;
            for (int i2 = 0; i2 < 32; i2 += 7) {
                int i3 = inputStream.read();
                if (i3 == -1) {
                    throw new KryoException("Buffer underflow.");
                }
                i |= (i3 & Opcodes.LAND) << i2;
                if ((i3 & 128) == 0) {
                    this.chunkSize = i;
                    a$a a_a = a.a;
                    return;
                }
            }
            throw new KryoException("Malformed integer.");
        } catch (IOException e) {
            throw new KryoException(e);
        }
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public int fill(byte[] bArr, int i, int i2) throws KryoException {
        int i3 = this.chunkSize;
        if (i3 == -1) {
            readChunkSize();
        } else if (i3 == 0) {
            return -1;
        }
        int iFill = super.fill(bArr, i, Math.min(this.chunkSize, i2));
        int i4 = this.chunkSize - iFill;
        this.chunkSize = i4;
        if (i4 == 0) {
            readChunkSize();
        }
        return iFill;
    }

    public void nextChunks() {
        if (this.chunkSize == -1) {
            readChunkSize();
        }
        while (true) {
            int i = this.chunkSize;
            if (i <= 0) {
                this.chunkSize = -1;
                a$a a_a = a.a;
                return;
            }
            skip(i);
        }
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public void rewind() {
        super.rewind();
        this.chunkSize = -1;
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public void setBuffer(byte[] bArr, int i, int i2) {
        super.setBuffer(bArr, i, i2);
        this.chunkSize = -1;
    }

    @Override // com.esotericsoftware.kryo.io.Input
    public void setInputStream(InputStream inputStream) {
        super.setInputStream(inputStream);
        this.chunkSize = -1;
    }

    public InputChunked(int i) {
        super(i);
        this.chunkSize = -1;
    }

    public InputChunked(InputStream inputStream) {
        super(inputStream, 2048);
        this.chunkSize = -1;
    }

    public InputChunked(InputStream inputStream, int i) {
        super(inputStream, i);
        this.chunkSize = -1;
    }
}
