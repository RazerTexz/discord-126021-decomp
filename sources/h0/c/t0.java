package h0.c;

import androidx.annotation.Nullable;
import org.webrtc.VideoFrame;
import org.webrtc.VideoProcessor;
import org.webrtc.VideoProcessor$FrameAdaptationParameters;

/* JADX INFO: compiled from: VideoProcessor.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class t0 {
    public static void a(VideoProcessor _this, VideoFrame videoFrame, VideoProcessor$FrameAdaptationParameters videoProcessor$FrameAdaptationParameters) {
        VideoFrame videoFrameB = b(videoFrame, videoProcessor$FrameAdaptationParameters);
        if (videoFrameB != null) {
            _this.onFrameCaptured(videoFrameB);
            videoFrameB.release();
        }
    }

    @Nullable
    public static VideoFrame b(VideoFrame videoFrame, VideoProcessor$FrameAdaptationParameters videoProcessor$FrameAdaptationParameters) {
        if (videoProcessor$FrameAdaptationParameters.drop) {
            return null;
        }
        return new VideoFrame(videoFrame.getBuffer().cropAndScale(videoProcessor$FrameAdaptationParameters.cropX, videoProcessor$FrameAdaptationParameters.cropY, videoProcessor$FrameAdaptationParameters.cropWidth, videoProcessor$FrameAdaptationParameters.cropHeight, videoProcessor$FrameAdaptationParameters.scaleWidth, videoProcessor$FrameAdaptationParameters.scaleHeight), videoFrame.getRotation(), videoProcessor$FrameAdaptationParameters.timestampNs);
    }
}
