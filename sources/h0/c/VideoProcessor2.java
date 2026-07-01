package h0.c;

import androidx.annotation.Nullable;
import org.webrtc.VideoFrame;
import org.webrtc.VideoProcessor;

/* JADX INFO: renamed from: h0.c.t0, reason: use source file name */
/* JADX INFO: compiled from: VideoProcessor.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class VideoProcessor2 {
    public static void a(VideoProcessor _this, VideoFrame videoFrame, VideoProcessor.FrameAdaptationParameters frameAdaptationParameters) {
        VideoFrame videoFrameB = b(videoFrame, frameAdaptationParameters);
        if (videoFrameB != null) {
            _this.onFrameCaptured(videoFrameB);
            videoFrameB.release();
        }
    }

    @Nullable
    public static VideoFrame b(VideoFrame videoFrame, VideoProcessor.FrameAdaptationParameters frameAdaptationParameters) {
        if (frameAdaptationParameters.drop) {
            return null;
        }
        return new VideoFrame(videoFrame.getBuffer().cropAndScale(frameAdaptationParameters.cropX, frameAdaptationParameters.cropY, frameAdaptationParameters.cropWidth, frameAdaptationParameters.cropHeight, frameAdaptationParameters.scaleWidth, frameAdaptationParameters.scaleHeight), videoFrame.getRotation(), frameAdaptationParameters.timestampNs);
    }
}
