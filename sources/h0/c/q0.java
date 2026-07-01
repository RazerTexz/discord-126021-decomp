package h0.c;

import androidx.annotation.Nullable;
import org.webrtc.CalledByNative;
import org.webrtc.VideoCodecInfo;
import org.webrtc.VideoDecoder;
import org.webrtc.VideoDecoderFactory;

/* JADX INFO: compiled from: VideoDecoderFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class q0 {
    @Nullable
    @Deprecated
    public static VideoDecoder a(VideoDecoderFactory _this, String str) {
        throw new UnsupportedOperationException("Deprecated and not implemented.");
    }

    @Nullable
    @CalledByNative
    public static VideoDecoder b(VideoDecoderFactory _this, VideoCodecInfo videoCodecInfo) {
        return _this.createDecoder(videoCodecInfo.getName());
    }

    @CalledByNative
    public static VideoCodecInfo[] c(VideoDecoderFactory videoDecoderFactory) {
        return new VideoCodecInfo[0];
    }
}
