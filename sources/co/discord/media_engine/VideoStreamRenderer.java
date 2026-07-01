package co.discord.media_engine;

import android.content.Context;
import android.util.AttributeSet;
import com.hammerandchisel.libdiscord.Discord;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.webrtc.RendererCommon$RendererEvents;
import org.webrtc.SurfaceViewRenderer;

/* JADX INFO: compiled from: VideoStreamRenderer.kt */
/* JADX INFO: loaded from: classes.dex */
public class VideoStreamRenderer extends SurfaceViewRenderer {
    private static final VideoStreamRenderer$Muxer Muxer = new VideoStreamRenderer$Muxer(null);

    @Deprecated
    private static Map<String, Set<VideoStreamRenderer>> streams = new LinkedHashMap();
    private String streamIdentifier;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoStreamRenderer(Context context) {
        super(context);
        m.checkNotNullParameter(context, "ctx");
        this.streamIdentifier = "";
    }

    public static final /* synthetic */ VideoStreamRenderer$Muxer access$Muxer() {
        return Muxer;
    }

    public static final /* synthetic */ Map access$getStreams$cp() {
        return streams;
    }

    public static final /* synthetic */ void access$setStreams$cp(Map map) {
        streams = map;
    }

    public static /* synthetic */ void attachToStream$default(VideoStreamRenderer videoStreamRenderer, Discord discord, String str, RendererCommon$RendererEvents rendererCommon$RendererEvents, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: attachToStream");
        }
        if ((i & 4) != 0) {
            rendererCommon$RendererEvents = null;
        }
        videoStreamRenderer.attachToStream(discord, str, rendererCommon$RendererEvents);
    }

    public final void attachToStream(Discord discord, String streamId, RendererCommon$RendererEvents events) {
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
        m.checkNotNullParameter(context, "ctx");
        m.checkNotNullParameter(attributeSet, "attrs");
        this.streamIdentifier = "";
    }
}
