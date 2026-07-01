package h0.c;

import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;
import org.webrtc.VideoSource;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i0 implements VideoSink {
    public final /* synthetic */ VideoSource j;

    public /* synthetic */ i0(VideoSource videoSource) {
        this.j = videoSource;
    }

    @Override // org.webrtc.VideoSink
    public final void onFrame(VideoFrame videoFrame) {
        VideoSource videoSource = this.j;
        videoSource.runWithReference(new h0(videoSource, videoFrame));
    }
}
