package com.facebook.common.memory;

import java.io.Closeable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface PooledByteBuffer extends Closeable {
    ByteBuffer getByteBuffer();

    byte h(int i);

    int i(int i, byte[] bArr, int i2, int i3);

    boolean isClosed();

    long k();

    int size();
}
