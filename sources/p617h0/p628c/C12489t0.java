package p617h0.p628c;

import androidx.annotation.Nullable;
import org.webrtc.VideoFrame;
import org.webrtc.VideoProcessor;

/* JADX INFO: renamed from: h0.c.t0 */
/* JADX INFO: compiled from: VideoProcessor.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C12489t0 {
    /* JADX INFO: renamed from: a */
    public static void m10679a(VideoProcessor _this, VideoFrame videoFrame, VideoProcessor.FrameAdaptationParameters frameAdaptationParameters) {
        VideoFrame videoFrameM10680b = m10680b(videoFrame, frameAdaptationParameters);
        if (videoFrameM10680b != null) {
            _this.onFrameCaptured(videoFrameM10680b);
            videoFrameM10680b.release();
        }
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public static VideoFrame m10680b(VideoFrame videoFrame, VideoProcessor.FrameAdaptationParameters frameAdaptationParameters) {
        if (frameAdaptationParameters.drop) {
            return null;
        }
        return new VideoFrame(videoFrame.getBuffer().cropAndScale(frameAdaptationParameters.cropX, frameAdaptationParameters.cropY, frameAdaptationParameters.cropWidth, frameAdaptationParameters.cropHeight, frameAdaptationParameters.scaleWidth, frameAdaptationParameters.scaleHeight), videoFrame.getRotation(), frameAdaptationParameters.timestampNs);
    }
}
