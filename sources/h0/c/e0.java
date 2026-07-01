package h0.c;

import org.webrtc.VideoFileRenderer;
import org.webrtc.VideoFrame;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e0 implements Runnable {
    public final /* synthetic */ VideoFileRenderer j;
    public final /* synthetic */ VideoFrame k;

    public /* synthetic */ e0(VideoFileRenderer videoFileRenderer, VideoFrame videoFrame) {
        this.j = videoFileRenderer;
        this.k = videoFrame;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.a(this.k);
    }
}
