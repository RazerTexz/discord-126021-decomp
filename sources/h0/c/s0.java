package h0.c;

import org.webrtc.CalledByNative;
import org.webrtc.VideoCodecInfo;
import org.webrtc.VideoEncoderFactory;
import org.webrtc.VideoEncoderFactory$VideoEncoderSelector;

/* JADX INFO: compiled from: VideoEncoderFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class s0 {
    @CalledByNative
    public static VideoEncoderFactory$VideoEncoderSelector a(VideoEncoderFactory videoEncoderFactory) {
        return null;
    }

    @CalledByNative
    public static VideoCodecInfo[] b(VideoEncoderFactory _this) {
        return _this.getSupportedCodecs();
    }
}
