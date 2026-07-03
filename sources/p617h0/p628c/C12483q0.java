package p617h0.p628c;

import androidx.annotation.Nullable;
import org.webrtc.CalledByNative;
import org.webrtc.VideoCodecInfo;
import org.webrtc.VideoDecoder;
import org.webrtc.VideoDecoderFactory;

/* JADX INFO: renamed from: h0.c.q0 */
/* JADX INFO: compiled from: VideoDecoderFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C12483q0 {
    @Nullable
    @Deprecated
    /* JADX INFO: renamed from: a */
    public static VideoDecoder m10671a(VideoDecoderFactory _this, String str) {
        throw new UnsupportedOperationException("Deprecated and not implemented.");
    }

    @Nullable
    @CalledByNative
    /* JADX INFO: renamed from: b */
    public static VideoDecoder m10672b(VideoDecoderFactory _this, VideoCodecInfo videoCodecInfo) {
        return _this.createDecoder(videoCodecInfo.getName());
    }

    @CalledByNative
    /* JADX INFO: renamed from: c */
    public static VideoCodecInfo[] m10673c(VideoDecoderFactory videoDecoderFactory) {
        return new VideoCodecInfo[0];
    }
}
