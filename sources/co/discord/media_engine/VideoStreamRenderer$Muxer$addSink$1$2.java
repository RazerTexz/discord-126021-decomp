package co.discord.media_engine;

import com.hammerandchisel.libdiscord.Discord$VideoFrameCallback;
import d0.t.u;
import d0.z.d.m;
import java.util.Set;
import org.webrtc.VideoFrame;

/* JADX INFO: compiled from: VideoStreamRenderer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VideoStreamRenderer$Muxer$addSink$1$2 implements Discord$VideoFrameCallback {
    public final /* synthetic */ Set $sinks;

    public VideoStreamRenderer$Muxer$addSink$1$2(Set set) {
        this.$sinks = set;
    }

    @Override // com.hammerandchisel.libdiscord.Discord$VideoFrameCallback
    public final boolean onFrame(VideoFrame videoFrame) {
        m.checkNotNullParameter(videoFrame, "frame");
        synchronized (this.$sinks) {
            VideoStreamRenderer videoStreamRenderer = (VideoStreamRenderer) u.firstOrNull(this.$sinks);
            if (videoStreamRenderer != null) {
                videoStreamRenderer.onFrame(videoFrame);
            }
            videoFrame.release();
        }
        return true;
    }
}
