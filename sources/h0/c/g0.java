package h0.c;

import org.webrtc.VideoFileRenderer;
import org.webrtc.VideoFrame;
import org.webrtc.VideoFrame$I420Buffer;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g0 implements Runnable {
    public final /* synthetic */ VideoFileRenderer j;
    public final /* synthetic */ VideoFrame$I420Buffer k;
    public final /* synthetic */ VideoFrame l;

    public /* synthetic */ g0(VideoFileRenderer videoFileRenderer, VideoFrame$I420Buffer videoFrame$I420Buffer, VideoFrame videoFrame) {
        this.j = videoFileRenderer;
        this.k = videoFrame$I420Buffer;
        this.l = videoFrame;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.d(this.k, this.l);
    }
}
