package com.facebook.common.memory;

import java.io.Closeable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface PooledByteBuffer extends Closeable {

    public static class ClosedException extends RuntimeException {
        public ClosedException() {
            super("Invalid bytebuf. Already closed");
        }
    }

    ByteBuffer getByteBuffer();

    /* JADX INFO: renamed from: h */
    byte mo1395h(int i);

    /* JADX INFO: renamed from: i */
    int mo1396i(int i, byte[] bArr, int i2, int i3);

    boolean isClosed();

    /* JADX INFO: renamed from: k */
    long mo1397k();

    int size();
}
