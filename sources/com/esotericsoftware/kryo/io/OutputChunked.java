package com.esotericsoftware.kryo.io;

import b.e.a.Log;
import com.esotericsoftware.kryo.KryoException;
import java.io.IOException;
import java.io.OutputStream;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public class OutputChunked extends Output {
    public OutputChunked() {
        super(2048);
    }

    private void writeChunkSize() throws IOException {
        int iPosition = position();
        Log.a aVar = Log.a;
        OutputStream outputStream = getOutputStream();
        if ((iPosition & (-128)) == 0) {
            outputStream.write(iPosition);
            return;
        }
        outputStream.write((iPosition & Opcodes.LAND) | 128);
        int i = iPosition >>> 7;
        if ((i & (-128)) == 0) {
            outputStream.write(i);
            return;
        }
        outputStream.write((i & Opcodes.LAND) | 128);
        int i2 = i >>> 7;
        if ((i2 & (-128)) == 0) {
            outputStream.write(i2);
            return;
        }
        outputStream.write((i2 & Opcodes.LAND) | 128);
        int i3 = i2 >>> 7;
        if ((i3 & (-128)) == 0) {
            outputStream.write(i3);
        } else {
            outputStream.write((i3 & Opcodes.LAND) | 128);
            outputStream.write(i3 >>> 7);
        }
    }

    public void endChunks() {
        flush();
        Log.a aVar = Log.a;
        try {
            getOutputStream().write(0);
        } catch (IOException e) {
            throw new KryoException(e);
        }
    }

    @Override // com.esotericsoftware.kryo.io.Output, java.io.OutputStream, java.io.Flushable
    public void flush() throws KryoException {
        if (position() > 0) {
            try {
                writeChunkSize();
                super.flush();
            } catch (IOException e) {
                throw new KryoException(e);
            }
        }
        super.flush();
    }

    public OutputChunked(int i) {
        super(i);
    }

    public OutputChunked(OutputStream outputStream) {
        super(outputStream, 2048);
    }

    public OutputChunked(OutputStream outputStream, int i) {
        super(outputStream, i);
    }
}
