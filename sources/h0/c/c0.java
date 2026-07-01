package h0.c;

import org.webrtc.EncodedImage;
import org.webrtc.VideoEncoder$Callback;
import org.webrtc.VideoEncoder$CodecSpecificInfo;
import org.webrtc.VideoEncoderWrapper;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c0 implements VideoEncoder$Callback {
    public final /* synthetic */ long a;

    public /* synthetic */ c0(long j) {
        this.a = j;
    }

    @Override // org.webrtc.VideoEncoder$Callback
    public final void onEncodedFrame(EncodedImage encodedImage, VideoEncoder$CodecSpecificInfo videoEncoder$CodecSpecificInfo) {
        VideoEncoderWrapper.lambda$createEncoderCallback$0(this.a, encodedImage, videoEncoder$CodecSpecificInfo);
    }
}
