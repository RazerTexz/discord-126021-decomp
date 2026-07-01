package com.esotericsoftware.kryo.pool;

import com.esotericsoftware.kryo.Kryo;

/* JADX INFO: loaded from: classes.dex */
public interface KryoCallback<T> {
    T execute(Kryo kryo);
}
