package com.esotericsoftware.kryo.p502io;

import com.esotericsoftware.kryo.KryoException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class FastInput extends Input {
    public FastInput() {
    }

    @Override // com.esotericsoftware.kryo.p502io.Input
    public int readInt(boolean z2) throws KryoException {
        return readInt();
    }

    @Override // com.esotericsoftware.kryo.p502io.Input
    public long readLong(boolean z2) throws KryoException {
        return readLong();
    }

    public FastInput(int i) {
        super(i);
    }

    public FastInput(byte[] bArr) {
        super(bArr);
    }

    public FastInput(byte[] bArr, int i, int i2) {
        super(bArr, i, i2);
    }

    public FastInput(InputStream inputStream) {
        super(inputStream);
    }

    public FastInput(InputStream inputStream, int i) {
        super(inputStream, i);
    }
}
