package com.esotericsoftware.kryo.pool;

import com.esotericsoftware.kryo.Kryo;

/* JADX INFO: loaded from: classes.dex */
public interface KryoPool {
    Kryo borrow();

    void release(Kryo kryo);

    <T> T run(KryoCallback<T> kryoCallback);
}
