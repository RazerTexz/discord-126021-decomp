package h0.c;

import org.webrtc.CalledByNative;
import org.webrtc.VideoCodecInfo;
import org.webrtc.VideoEncoderFactory;

/* JADX INFO: renamed from: h0.c.s0, reason: use source file name */
/* JADX INFO: compiled from: VideoEncoderFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class VideoEncoderFactory2 {
    @CalledByNative
    public static VideoEncoderFactory.VideoEncoderSelector a(VideoEncoderFactory videoEncoderFactory) {
        return null;
    }

    @CalledByNative
    public static VideoCodecInfo[] b(VideoEncoderFactory _this) {
        return _this.getSupportedCodecs();
    }
}
