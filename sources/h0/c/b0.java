package h0.c;

import org.webrtc.VideoDecoder$Callback;
import org.webrtc.VideoDecoderWrapper;
import org.webrtc.VideoFrame;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b0 implements VideoDecoder$Callback {
    public final /* synthetic */ long a;

    public /* synthetic */ b0(long j) {
        this.a = j;
    }

    @Override // org.webrtc.VideoDecoder$Callback
    public final void onDecodedFrame(VideoFrame videoFrame, Integer num, Integer num2) {
        VideoDecoderWrapper.lambda$createDecoderCallback$0(this.a, videoFrame, num, null);
    }
}
