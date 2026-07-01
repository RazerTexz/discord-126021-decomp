package com.discord.widgets.voice.call;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$InputMode;
import com.discord.utilities.streams.StreamContext;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetVoiceCallInline$Model$VoiceConnected {
    public static final WidgetVoiceCallInline$Model$VoiceConnected$Companion Companion = new WidgetVoiceCallInline$Model$VoiceConnected$Companion(null);
    private final MediaEngineConnection$InputMode inputMode;
    private final Channel selectedVoiceChannel;
    private final StreamContext streamContext;

    public WidgetVoiceCallInline$Model$VoiceConnected(Channel channel, MediaEngineConnection$InputMode mediaEngineConnection$InputMode, StreamContext streamContext) {
        m.checkNotNullParameter(channel, "selectedVoiceChannel");
        m.checkNotNullParameter(mediaEngineConnection$InputMode, "inputMode");
        this.selectedVoiceChannel = channel;
        this.inputMode = mediaEngineConnection$InputMode;
        this.streamContext = streamContext;
    }

    public static /* synthetic */ WidgetVoiceCallInline$Model$VoiceConnected copy$default(WidgetVoiceCallInline$Model$VoiceConnected widgetVoiceCallInline$Model$VoiceConnected, Channel channel, MediaEngineConnection$InputMode mediaEngineConnection$InputMode, StreamContext streamContext, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = widgetVoiceCallInline$Model$VoiceConnected.selectedVoiceChannel;
        }
        if ((i & 2) != 0) {
            mediaEngineConnection$InputMode = widgetVoiceCallInline$Model$VoiceConnected.inputMode;
        }
        if ((i & 4) != 0) {
            streamContext = widgetVoiceCallInline$Model$VoiceConnected.streamContext;
        }
        return widgetVoiceCallInline$Model$VoiceConnected.copy(channel, mediaEngineConnection$InputMode, streamContext);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MediaEngineConnection$InputMode getInputMode() {
        return this.inputMode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StreamContext getStreamContext() {
        return this.streamContext;
    }

    public final WidgetVoiceCallInline$Model$VoiceConnected copy(Channel selectedVoiceChannel, MediaEngineConnection$InputMode inputMode, StreamContext streamContext) {
        m.checkNotNullParameter(selectedVoiceChannel, "selectedVoiceChannel");
        m.checkNotNullParameter(inputMode, "inputMode");
        return new WidgetVoiceCallInline$Model$VoiceConnected(selectedVoiceChannel, inputMode, streamContext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetVoiceCallInline$Model$VoiceConnected)) {
            return false;
        }
        WidgetVoiceCallInline$Model$VoiceConnected widgetVoiceCallInline$Model$VoiceConnected = (WidgetVoiceCallInline$Model$VoiceConnected) other;
        return m.areEqual(this.selectedVoiceChannel, widgetVoiceCallInline$Model$VoiceConnected.selectedVoiceChannel) && m.areEqual(this.inputMode, widgetVoiceCallInline$Model$VoiceConnected.inputMode) && m.areEqual(this.streamContext, widgetVoiceCallInline$Model$VoiceConnected.streamContext);
    }

    public final MediaEngineConnection$InputMode getInputMode() {
        return this.inputMode;
    }

    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    public final StreamContext getStreamContext() {
        return this.streamContext;
    }

    public int hashCode() {
        Channel channel = this.selectedVoiceChannel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        MediaEngineConnection$InputMode mediaEngineConnection$InputMode = this.inputMode;
        int iHashCode2 = (iHashCode + (mediaEngineConnection$InputMode != null ? mediaEngineConnection$InputMode.hashCode() : 0)) * 31;
        StreamContext streamContext = this.streamContext;
        return iHashCode2 + (streamContext != null ? streamContext.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("VoiceConnected(selectedVoiceChannel=");
        sbU.append(this.selectedVoiceChannel);
        sbU.append(", inputMode=");
        sbU.append(this.inputMode);
        sbU.append(", streamContext=");
        sbU.append(this.streamContext);
        sbU.append(")");
        return sbU.toString();
    }
}
