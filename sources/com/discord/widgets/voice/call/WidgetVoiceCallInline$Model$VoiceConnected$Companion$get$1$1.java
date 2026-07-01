package com.discord.widgets.voice.call;

import com.discord.api.channel.Channel;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$InputMode;
import com.discord.utilities.streams.StreamContext;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1$1 extends k implements Function3<Channel, MediaEngineConnection$InputMode, StreamContext, WidgetVoiceCallInline$Model$VoiceConnected> {
    public static final WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1$1 INSTANCE = new WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1$1();

    public WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1$1() {
        super(3, WidgetVoiceCallInline$Model$VoiceConnected.class, "<init>", "<init>(Lcom/discord/api/channel/Channel;Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;Lcom/discord/utilities/streams/StreamContext;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ WidgetVoiceCallInline$Model$VoiceConnected invoke(Channel channel, MediaEngineConnection$InputMode mediaEngineConnection$InputMode, StreamContext streamContext) {
        return invoke2(channel, mediaEngineConnection$InputMode, streamContext);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetVoiceCallInline$Model$VoiceConnected invoke2(Channel channel, MediaEngineConnection$InputMode mediaEngineConnection$InputMode, StreamContext streamContext) {
        m.checkNotNullParameter(channel, "p1");
        m.checkNotNullParameter(mediaEngineConnection$InputMode, "p2");
        return new WidgetVoiceCallInline$Model$VoiceConnected(channel, mediaEngineConnection$InputMode, streamContext);
    }
}
