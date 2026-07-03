package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.p502io.Input;
import com.esotericsoftware.kryo.p502io.Output;

/* JADX INFO: loaded from: classes.dex */
public interface KryoSerializable {
    void read(Kryo kryo, Input input);

    void write(Kryo kryo, Output output);
}
