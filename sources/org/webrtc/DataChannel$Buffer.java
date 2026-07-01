package org.webrtc;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public class DataChannel$Buffer {
    public final boolean binary;
    public final ByteBuffer data;

    @CalledByNative("Buffer")
    public DataChannel$Buffer(ByteBuffer byteBuffer, boolean z2) {
        this.data = byteBuffer;
        this.binary = z2;
    }
}
