package com.facebook.common.memory;

/* JADX INFO: loaded from: classes.dex */
public class PooledByteBuffer$ClosedException extends RuntimeException {
    public PooledByteBuffer$ClosedException() {
        super("Invalid bytebuf. Already closed");
    }
}
