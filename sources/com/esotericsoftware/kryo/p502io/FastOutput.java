package com.esotericsoftware.kryo.p502io;

import com.esotericsoftware.kryo.KryoException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class FastOutput extends Output {
    public FastOutput() {
    }

    @Override // com.esotericsoftware.kryo.p502io.Output
    public int writeInt(int i, boolean z2) throws KryoException {
        writeInt(i);
        return 4;
    }

    @Override // com.esotericsoftware.kryo.p502io.Output
    public int writeLong(long j, boolean z2) throws KryoException {
        writeLong(j);
        return 8;
    }

    public FastOutput(int i) {
        this(i, i);
    }

    public FastOutput(int i, int i2) {
        super(i, i2);
    }

    public FastOutput(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public FastOutput(byte[] bArr, int i) {
        super(bArr, i);
    }

    public FastOutput(OutputStream outputStream) {
        super(outputStream);
    }

    public FastOutput(OutputStream outputStream, int i) {
        super(outputStream, i);
    }
}
