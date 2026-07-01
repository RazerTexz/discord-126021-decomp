package org.webrtc;

import androidx.annotation.Nullable;
import h0.c.i0;

/* JADX INFO: loaded from: classes3.dex */
public class VideoSource extends MediaSource {
    private final CapturerObserver capturerObserver;
    private boolean isCapturerRunning;
    private final NativeAndroidVideoTrackSource nativeAndroidVideoTrackSource;

    @Nullable
    private VideoProcessor videoProcessor;
    private final Object videoProcessorLock;

    public VideoSource(long j) {
        super(j);
        this.videoProcessorLock = new Object();
        this.capturerObserver = new VideoSource$1(this);
        this.nativeAndroidVideoTrackSource = new NativeAndroidVideoTrackSource(j);
    }

    public static /* synthetic */ NativeAndroidVideoTrackSource access$000(VideoSource videoSource) {
        return videoSource.nativeAndroidVideoTrackSource;
    }

    public static /* synthetic */ Object access$100(VideoSource videoSource) {
        return videoSource.videoProcessorLock;
    }

    public static /* synthetic */ boolean access$202(VideoSource videoSource, boolean z2) {
        videoSource.isCapturerRunning = z2;
        return z2;
    }

    public static /* synthetic */ VideoProcessor access$300(VideoSource videoSource) {
        return videoSource.videoProcessor;
    }

    public /* synthetic */ void a(VideoFrame videoFrame) {
        this.nativeAndroidVideoTrackSource.onFrameCaptured(videoFrame);
    }

    public void adaptOutputFormat(int i, int i2, int i3) {
        int iMax = Math.max(i, i2);
        int iMin = Math.min(i, i2);
        adaptOutputFormat(iMax, iMin, iMin, iMax, i3);
    }

    @Override // org.webrtc.MediaSource
    public void dispose() {
        setVideoProcessor(null);
        super.dispose();
    }

    public CapturerObserver getCapturerObserver() {
        return this.capturerObserver;
    }

    public long getNativeVideoTrackSource() {
        return getNativeMediaSource();
    }

    public void setIsScreencast(boolean z2) {
        this.nativeAndroidVideoTrackSource.setIsScreencast(z2);
    }

    public void setVideoProcessor(@Nullable VideoProcessor videoProcessor) {
        synchronized (this.videoProcessorLock) {
            VideoProcessor videoProcessor2 = this.videoProcessor;
            if (videoProcessor2 != null) {
                videoProcessor2.setSink(null);
                if (this.isCapturerRunning) {
                    this.videoProcessor.onCapturerStopped();
                }
            }
            this.videoProcessor = videoProcessor;
            if (videoProcessor != null) {
                videoProcessor.setSink(new i0(this));
                if (this.isCapturerRunning) {
                    videoProcessor.onCapturerStarted(true);
                }
            }
        }
    }

    public void adaptOutputFormat(int i, int i2, int i3, int i4, int i5) {
        adaptOutputFormat(new VideoSource$AspectRatio(i, i2), Integer.valueOf(i * i2), new VideoSource$AspectRatio(i3, i4), Integer.valueOf(i3 * i4), Integer.valueOf(i5));
    }

    public void adaptOutputFormat(VideoSource$AspectRatio videoSource$AspectRatio, @Nullable Integer num, VideoSource$AspectRatio videoSource$AspectRatio2, @Nullable Integer num2, @Nullable Integer num3) {
        this.nativeAndroidVideoTrackSource.adaptOutputFormat(videoSource$AspectRatio, num, videoSource$AspectRatio2, num2, num3);
    }
}
