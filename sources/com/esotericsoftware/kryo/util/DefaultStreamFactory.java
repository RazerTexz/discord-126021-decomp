package com.esotericsoftware.kryo.util;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.StreamFactory;
import com.esotericsoftware.kryo.p502io.Input;
import com.esotericsoftware.kryo.p502io.Output;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class DefaultStreamFactory implements StreamFactory {
    @Override // com.esotericsoftware.kryo.StreamFactory
    public Input getInput() {
        return new Input();
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Output getOutput() {
        return new Output();
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public void setKryo(Kryo kryo) {
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Input getInput(int i) {
        return new Input(i);
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Output getOutput(int i) {
        return new Output(i);
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Input getInput(byte[] bArr) {
        return new Input(bArr);
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Output getOutput(int i, int i2) {
        return new Output(i, i2);
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Input getInput(byte[] bArr, int i, int i2) {
        return new Input(bArr, i, i2);
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Output getOutput(byte[] bArr) {
        return new Output(bArr);
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Input getInput(InputStream inputStream) {
        return new Input(inputStream);
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Output getOutput(byte[] bArr, int i) {
        return new Output(bArr, i);
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Input getInput(InputStream inputStream, int i) {
        return new Input(inputStream, i);
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Output getOutput(OutputStream outputStream) {
        return new Output(outputStream);
    }

    @Override // com.esotericsoftware.kryo.StreamFactory
    public Output getOutput(OutputStream outputStream, int i) {
        return new Output(outputStream, i);
    }
}
