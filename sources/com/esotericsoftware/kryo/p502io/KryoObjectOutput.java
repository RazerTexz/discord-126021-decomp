package com.esotericsoftware.kryo.p502io;

import com.esotericsoftware.kryo.Kryo;
import java.io.IOException;
import java.io.ObjectOutput;

/* JADX INFO: loaded from: classes.dex */
public class KryoObjectOutput extends KryoDataOutput implements ObjectOutput {
    private final Kryo kryo;

    public KryoObjectOutput(Kryo kryo, Output output) {
        super(output);
        this.kryo = kryo;
    }

    @Override // java.io.ObjectOutput, java.lang.AutoCloseable
    public void close() throws IOException {
        this.output.close();
    }

    @Override // java.io.ObjectOutput
    public void flush() throws IOException {
        this.output.flush();
    }

    @Override // java.io.ObjectOutput
    public void writeObject(Object obj) throws IOException {
        this.kryo.writeClassAndObject(this.output, obj);
    }
}
