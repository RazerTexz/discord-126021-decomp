package h0.c;

import org.webrtc.Camera1Session;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements VideoSink {
    public final /* synthetic */ Camera1Session j;

    public /* synthetic */ c(Camera1Session camera1Session) {
        this.j = camera1Session;
    }

    @Override // org.webrtc.VideoSink
    public final void onFrame(VideoFrame videoFrame) {
        this.j.a(videoFrame);
    }
}
