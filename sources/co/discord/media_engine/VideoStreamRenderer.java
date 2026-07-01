package co.discord.media_engine;

import android.content.Context;
import android.util.AttributeSet;
import com.hammerandchisel.libdiscord.Discord;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.RendererCommon;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoFrame;

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
            Intrinsics3.checkNotNullParameter(discord, "discord");
            Intrinsics3.checkNotNullParameter(sink, "sink");
            Intrinsics3.checkNotNullParameter(streamId, "streamId");
            synchronized (VideoStreamRenderer.streams) {
                Muxer unused = VideoStreamRenderer.Muxer;
                Set set = (Set) VideoStreamRenderer.streams.get(streamId);
                if (set != null) {
                    synchronized (set) {
                        set.add(sink);
                    }
                } else {
                    final Set setMutableSetOf = Sets5.mutableSetOf(sink);
                    discord.setVideoOutputSink(streamId, new Discord.VideoFrameCallback() { // from class: co.discord.media_engine.VideoStreamRenderer$Muxer$addSink$1$2
                        @Override // com.hammerandchisel.libdiscord.Discord.VideoFrameCallback
                        public final boolean onFrame(VideoFrame videoFrame) {
                            Intrinsics3.checkNotNullParameter(videoFrame, "frame");
                            synchronized (setMutableSetOf) {
                                VideoStreamRenderer videoStreamRenderer = (VideoStreamRenderer) _Collections.firstOrNull(setMutableSetOf);
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
            Intrinsics3.checkNotNullParameter(discord, "discord");
            Intrinsics3.checkNotNullParameter(sink, "sink");
            Intrinsics3.checkNotNullParameter(streamId, "streamId");
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
        Intrinsics3.checkNotNullParameter(context, "ctx");
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
        Intrinsics3.checkNotNullParameter(context, "ctx");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        this.streamIdentifier = "";
    }
}
