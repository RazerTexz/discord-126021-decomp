package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class DataChannel {
    private long nativeDataChannel;
    private long nativeObserver;

    @CalledByNative
    public DataChannel(long j) {
        this.nativeDataChannel = j;
    }

    private void checkDataChannelExists() {
        if (this.nativeDataChannel == 0) {
            throw new IllegalStateException("DataChannel has been disposed.");
        }
    }

    private native long nativeBufferedAmount();

    private native void nativeClose();

    private native int nativeId();

    private native String nativeLabel();

    private native long nativeRegisterObserver(DataChannel$Observer dataChannel$Observer);

    private native boolean nativeSend(byte[] bArr, boolean z2);

    private native DataChannel$State nativeState();

    private native void nativeUnregisterObserver(long j);

    public long bufferedAmount() {
        checkDataChannelExists();
        return nativeBufferedAmount();
    }

    public void close() {
        checkDataChannelExists();
        nativeClose();
    }

    public void dispose() {
        checkDataChannelExists();
        JniCommon.nativeReleaseRef(this.nativeDataChannel);
        this.nativeDataChannel = 0L;
    }

    @CalledByNative
    public long getNativeDataChannel() {
        return this.nativeDataChannel;
    }

    public int id() {
        checkDataChannelExists();
        return nativeId();
    }

    public String label() {
        checkDataChannelExists();
        return nativeLabel();
    }

    public void registerObserver(DataChannel$Observer dataChannel$Observer) {
        checkDataChannelExists();
        long j = this.nativeObserver;
        if (j != 0) {
            nativeUnregisterObserver(j);
        }
        this.nativeObserver = nativeRegisterObserver(dataChannel$Observer);
    }

    public boolean send(DataChannel$Buffer dataChannel$Buffer) {
        checkDataChannelExists();
        byte[] bArr = new byte[dataChannel$Buffer.data.remaining()];
        dataChannel$Buffer.data.get(bArr);
        return nativeSend(bArr, dataChannel$Buffer.binary);
    }

    public DataChannel$State state() {
        checkDataChannelExists();
        return nativeState();
    }

    public void unregisterObserver() {
        checkDataChannelExists();
        nativeUnregisterObserver(this.nativeObserver);
    }
}
