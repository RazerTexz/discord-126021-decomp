package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.p502io.Input;
import com.esotericsoftware.kryo.p502io.Output;

/* JADX INFO: loaded from: classes.dex */
public interface ClassResolver {
    Registration getRegistration(int i);

    Registration getRegistration(Class cls);

    Registration readClass(Input input);

    Registration register(Registration registration);

    Registration registerImplicit(Class cls);

    void reset();

    void setKryo(Kryo kryo);

    Registration writeClass(Output output, Class cls);
}
