package org.webrtc;

import h0.c.t0;

/* JADX INFO: loaded from: classes3.dex */
public class VideoSource$1 implements CapturerObserver {
    public final /* synthetic */ VideoSource this$0;

    public VideoSource$1(VideoSource videoSource) {
        this.this$0 = videoSource;
    }

    @Override // org.webrtc.CapturerObserver
    public void onCapturerStarted(boolean z2) {
        VideoSource.access$000(this.this$0).setState(z2);
        synchronized (VideoSource.access$100(this.this$0)) {
            VideoSource.access$202(this.this$0, z2);
            if (VideoSource.access$300(this.this$0) != null) {
                VideoSource.access$300(this.this$0).onCapturerStarted(z2);
            }
        }
    }

    @Override // org.webrtc.CapturerObserver
    public void onCapturerStopped() {
        VideoSource.access$000(this.this$0).setState(false);
        synchronized (VideoSource.access$100(this.this$0)) {
            VideoSource.access$202(this.this$0, false);
            if (VideoSource.access$300(this.this$0) != null) {
                VideoSource.access$300(this.this$0).onCapturerStopped();
            }
        }
    }

    @Override // org.webrtc.CapturerObserver
    public void onFrameCaptured(VideoFrame videoFrame) {
        VideoProcessor$FrameAdaptationParameters videoProcessor$FrameAdaptationParametersAdaptFrame = VideoSource.access$000(this.this$0).adaptFrame(videoFrame);
        synchronized (VideoSource.access$100(this.this$0)) {
            if (VideoSource.access$300(this.this$0) != null) {
                VideoSource.access$300(this.this$0).onFrameCaptured(videoFrame, videoProcessor$FrameAdaptationParametersAdaptFrame);
                return;
            }
            VideoFrame videoFrameB = t0.b(videoFrame, videoProcessor$FrameAdaptationParametersAdaptFrame);
            if (videoFrameB != null) {
                VideoSource.access$000(this.this$0).onFrameCaptured(videoFrameB);
                videoFrameB.release();
            }
        }
    }
}
