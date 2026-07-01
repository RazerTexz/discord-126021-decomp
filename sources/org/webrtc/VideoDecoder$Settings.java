package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class VideoDecoder$Settings {
    public final int height;
    public final int numberOfCores;
    public final int width;

    @CalledByNative("Settings")
    public VideoDecoder$Settings(int i, int i2, int i3) {
        this.numberOfCores = i;
        this.width = i2;
        this.height = i3;
    }
}
