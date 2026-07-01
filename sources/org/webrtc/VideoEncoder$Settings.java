package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class VideoEncoder$Settings {
    public final boolean automaticResizeOn;
    public final VideoEncoder$Capabilities capabilities;
    public final int height;
    public final int maxFramerate;
    public final int numberOfCores;
    public final int numberOfSimulcastStreams;
    public final int startBitrate;
    public final int width;

    @Deprecated
    public VideoEncoder$Settings(int i, int i2, int i3, int i4, int i5, int i6, boolean z2) {
        this(i, i2, i3, i4, i5, i6, z2, new VideoEncoder$Capabilities(false));
    }

    @CalledByNative("Settings")
    public VideoEncoder$Settings(int i, int i2, int i3, int i4, int i5, int i6, boolean z2, VideoEncoder$Capabilities videoEncoder$Capabilities) {
        this.numberOfCores = i;
        this.width = i2;
        this.height = i3;
        this.startBitrate = i4;
        this.maxFramerate = i5;
        this.numberOfSimulcastStreams = i6;
        this.automaticResizeOn = z2;
        this.capabilities = videoEncoder$Capabilities;
    }
}
