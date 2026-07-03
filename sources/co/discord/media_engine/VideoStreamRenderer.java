package co.discord.media_engine;

import android.content.Context;
import android.util.AttributeSet;
import com.hammerandchisel.libdiscord.Discord;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.RendererCommon;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoFrame;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: VideoStreamRenderer.kt */
/* JADX INFO: loaded from: classes.dex */
public class VideoStreamRenderer extends SurfaceViewRenderer {
    private static final Muxer Muxer = new Muxer(null);

    @Deprecated
    private static Map<String, Set<VideoStreamRenderer>> streams = new LinkedHashMap();
    private String streamIdentifier;

    /* JADX INFO: compiled from: VideoStreamRenderer.kt */
    public static final class Muxer {
        private Muxer() {
        }

        public final void addSink(Discord discord, VideoStreamRenderer sink, String streamId) {
            C12238m.checkNotNullParameter(discord, "discord");
            C12238m.checkNotNullParameter(sink, "sink");
            C12238m.checkNotNullParameter(streamId, "streamId");
            synchronized (VideoStreamRenderer.streams) {
                Muxer unused = VideoStreamRenderer.Muxer;
                Set set = (Set) VideoStreamRenderer.streams.get(streamId);
                if (set != null) {
                    synchronized (set) {
                        set.add(sink);
                    }
                } else {
                    final Set setMutableSetOf = C12148n0.mutableSetOf(sink);
                    discord.setVideoOutputSink(streamId, new Discord.VideoFrameCallback() { // from class: co.discord.media_engine.VideoStreamRenderer$Muxer$addSink$1$2
                        @Override // com.hammerandchisel.libdiscord.Discord.VideoFrameCallback
                        public final boolean onFrame(VideoFrame videoFrame) {
                            C12238m.checkNotNullParameter(videoFrame, "frame");
                            synchronized (setMutableSetOf) {
                                VideoStreamRenderer videoStreamRenderer = (VideoStreamRenderer) C12163u.firstOrNull(setMutableSetOf);
                                if (videoStreamRenderer != null) {
                                    videoStreamRenderer.onFrame(videoFrame);
                                }
                                videoFrame.release();
                            }
                            return true;
                        }
                    });
                    Muxer unused2 = VideoStreamRenderer.Muxer;
                    VideoStreamRenderer.streams.put(streamId, setMutableSetOf);
                }
            }
        }

        public final void removeSink(Discord discord, VideoStreamRenderer sink, String streamId) {
            C12238m.checkNotNullParameter(discord, "discord");
            C12238m.checkNotNullParameter(sink, "sink");
            C12238m.checkNotNullParameter(streamId, "streamId");
            synchronized (VideoStreamRenderer.streams) {
                Muxer unused = VideoStreamRenderer.Muxer;
                Set set = (Set) VideoStreamRenderer.streams.get(streamId);
                if (set != null) {
                    synchronized (set) {
                        set.remove(sink);
                        if (set.isEmpty()) {
                            discord.setVideoOutputSink(streamId, null);
                            Muxer unused2 = VideoStreamRenderer.Muxer;
                            VideoStreamRenderer.streams.remove(streamId);
                        }
                    }
                }
            }
        }

        public /* synthetic */ Muxer(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoStreamRenderer(Context context) {
        super(context);
        C12238m.checkNotNullParameter(context, "ctx");
        this.streamIdentifier = "";
    }

    public static /* synthetic */ void attachToStream$default(VideoStreamRenderer videoStreamRenderer, Discord discord, String str, RendererCommon.RendererEvents rendererEvents, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachToStream");
        }
        if ((i & 4) != 0) {
            rendererEvents = null;
        }
        videoStreamRenderer.attachToStream(discord, str, rendererEvents);
    }

    public final void attachToStream(Discord discord, String streamId, RendererCommon.RendererEvents events) {
        if (discord == null) {
            return;
        }
        if (!(this.streamIdentifier.length() == 0)) {
            super.clearImage();
            super.release();
            Muxer.removeSink(discord, this, this.streamIdentifier);
        }
        if (streamId == null) {
            streamId = "";
        }
        this.streamIdentifier = streamId;
        if (streamId.length() == 0) {
            return;
        }
        super.init(SharedEglBaseContext.getEglContext(), events);
        Muxer.addSink(discord, this, this.streamIdentifier);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoStreamRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "ctx");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
        this.streamIdentifier = "";
    }
}
