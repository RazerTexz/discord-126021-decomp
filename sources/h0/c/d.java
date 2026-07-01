package h0.c;

import org.webrtc.Camera2Session$CaptureSessionCallback;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements VideoSink {
    public final /* synthetic */ Camera2Session$CaptureSessionCallback j;

    public /* synthetic */ d(Camera2Session$CaptureSessionCallback camera2Session$CaptureSessionCallback) {
        this.j = camera2Session$CaptureSessionCallback;
    }

    @Override // org.webrtc.VideoSink
    public final void onFrame(VideoFrame videoFrame) {
        this.j.a(videoFrame);
    }
}
