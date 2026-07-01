package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class NativeCapturerObserver implements CapturerObserver {
    private final NativeAndroidVideoTrackSource nativeAndroidVideoTrackSource;

    @CalledByNative
    public NativeCapturerObserver(long j) {
        this.nativeAndroidVideoTrackSource = new NativeAndroidVideoTrackSource(j);
    }

    @Override // org.webrtc.CapturerObserver
    public void onCapturerStarted(boolean z2) {
        this.nativeAndroidVideoTrackSource.setState(z2);
    }

    @Override // org.webrtc.CapturerObserver
    public void onCapturerStopped() {
        this.nativeAndroidVideoTrackSource.setState(false);
    }

    @Override // org.webrtc.CapturerObserver
    public void onFrameCaptured(VideoFrame videoFrame) {
        VideoProcessor$FrameAdaptationParameters videoProcessor$FrameAdaptationParametersAdaptFrame = this.nativeAndroidVideoTrackSource.adaptFrame(videoFrame);
        if (videoProcessor$FrameAdaptationParametersAdaptFrame == null) {
            return;
        }
        VideoFrame$Buffer videoFrame$BufferCropAndScale = videoFrame.getBuffer().cropAndScale(videoProcessor$FrameAdaptationParametersAdaptFrame.cropX, videoProcessor$FrameAdaptationParametersAdaptFrame.cropY, videoProcessor$FrameAdaptationParametersAdaptFrame.cropWidth, videoProcessor$FrameAdaptationParametersAdaptFrame.cropHeight, videoProcessor$FrameAdaptationParametersAdaptFrame.scaleWidth, videoProcessor$FrameAdaptationParametersAdaptFrame.scaleHeight);
        this.nativeAndroidVideoTrackSource.onFrameCaptured(new VideoFrame(videoFrame$BufferCropAndScale, videoFrame.getRotation(), videoProcessor$FrameAdaptationParametersAdaptFrame.timestampNs));
        videoFrame$BufferCropAndScale.release();
    }
}
