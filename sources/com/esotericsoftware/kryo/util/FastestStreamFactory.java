package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.StreamFactory;
import com.esotericsoftware.kryo.p502io.Input;
import com.esotericsoftware.kryo.p502io.Output;
import com.esotericsoftware.kryo.p502io.UnsafeInput;
import com.esotericsoftware.kryo.p502io.UnsafeOutput;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class FastestStreamFactory implements StreamFactory {
    private static boolean isUnsafe;

    static {
        isUnsafe = UnsafeUtil.unsafe() != null;
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Input getInput() {
        return isUnsafe ? new UnsafeInput() : new Input();
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Output getOutput() {
        return isUnsafe ? new UnsafeOutput() : new Output();
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public void setKryo(Kryo kryo) {
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Input getInput(int i) {
        return isUnsafe ? new UnsafeInput(i) : new Input(i);
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Output getOutput(int i) {
        return isUnsafe ? new UnsafeOutput(i) : new Output(i);
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Input getInput(byte[] bArr) {
        return isUnsafe ? new UnsafeInput(bArr) : new Input(bArr);
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Output getOutput(int i, int i2) {
        return isUnsafe ? new UnsafeOutput(i, i2) : new Output(i, i2);
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Input getInput(byte[] bArr, int i, int i2) {
        return isUnsafe ? new UnsafeInput(bArr, i, i2) : new Input(bArr, i, i2);
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Output getOutput(byte[] bArr) {
        return isUnsafe ? new UnsafeOutput(bArr) : new Output(bArr);
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Input getInput(InputStream inputStream) {
        return isUnsafe ? new UnsafeInput(inputStream) : new Input(inputStream);
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Output getOutput(byte[] bArr, int i) {
        return isUnsafe ? new UnsafeOutput(bArr, i) : new Output(bArr, i);
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Input getInput(InputStream inputStream, int i) {
        return isUnsafe ? new UnsafeInput(inputStream, i) : new Input(inputStream, i);
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Output getOutput(OutputStream outputStream) {
        return isUnsafe ? new UnsafeOutput(outputStream) : new Output(outputStream);
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Output getOutput(OutputStream outputStream, int i) {
        return isUnsafe ? new UnsafeOutput(outputStream, i) : new Output(outputStream, i);
    }
}
