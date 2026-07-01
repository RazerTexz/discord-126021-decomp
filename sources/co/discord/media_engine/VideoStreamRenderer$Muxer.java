package co.discord.media_engine;

import com.hammerandchisel.libdiscord.Discord;
import d0.t.n0;
import d0.z.d.m;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: VideoStreamRenderer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VideoStreamRenderer$Muxer {
    private VideoStreamRenderer$Muxer() {
    }

    public final void addSink(Discord discord, VideoStreamRenderer sink, String streamId) {
        m.checkNotNullParameter(discord, "discord");
        m.checkNotNullParameter(sink, "sink");
        m.checkNotNullParameter(streamId, "streamId");
        synchronized (VideoStreamRenderer.access$getStreams$cp()) {
            VideoStreamRenderer.access$Muxer();
            Set set = (Set) VideoStreamRenderer.access$getStreams$cp().get(streamId);
            if (set != null) {
                synchronized (set) {
                    set.add(sink);
                }
            } else {
                Set setMutableSetOf = n0.mutableSetOf(sink);
                discord.setVideoOutputSink(streamId, new VideoStreamRenderer$Muxer$addSink$1$2(setMutableSetOf));
                VideoStreamRenderer.access$Muxer();
                VideoStreamRenderer.access$getStreams$cp().put(streamId, setMutableSetOf);
            }
        }
    }

    public final void removeSink(Discord discord, VideoStreamRenderer sink, String streamId) {
        m.checkNotNullParameter(discord, "discord");
        m.checkNotNullParameter(sink, "sink");
        m.checkNotNullParameter(streamId, "streamId");
        synchronized (VideoStreamRenderer.access$getStreams$cp()) {
            VideoStreamRenderer.access$Muxer();
            Set set = (Set) VideoStreamRenderer.access$getStreams$cp().get(streamId);
            if (set != null) {
                synchronized (set) {
                    set.remove(sink);
                    if (set.isEmpty()) {
                        discord.setVideoOutputSink(streamId, null);
                        VideoStreamRenderer.access$Muxer();
                        VideoStreamRenderer.access$getStreams$cp().remove(streamId);
                    }
                }
            }
        }
    }

    public /* synthetic */ VideoStreamRenderer$Muxer(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
