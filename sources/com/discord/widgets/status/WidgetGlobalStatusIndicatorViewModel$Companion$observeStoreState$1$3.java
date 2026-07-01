package com.discord.widgets.status;

import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection$Quality;
import com.discord.rtcconnection.RtcConnection$StateChange;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.streams.StreamContext;
import d0.z.d.k;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.functions.Function10;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$3 extends k implements Function10<Channel, Channel, RtcConnection$StateChange, RtcConnection$Quality, Guild, Map<Long, ? extends StoreVoiceParticipants$VoiceUser>, StreamContext, StageRequestToSpeakState, Integer, StageInstance, WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing> {
    public static final WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$3 INSTANCE = new WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$3();

    public WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$3() {
        super(10, WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.class, "<init>", "<init>(Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;Lcom/discord/rtcconnection/RtcConnection$StateChange;Lcom/discord/rtcconnection/RtcConnection$Quality;Lcom/discord/models/guild/Guild;Ljava/util/Map;Lcom/discord/utilities/streams/StreamContext;Lcom/discord/api/voice/state/StageRequestToSpeakState;ILcom/discord/api/stageinstance/StageInstance;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function10
    public /* bridge */ /* synthetic */ WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing invoke(Channel channel, Channel channel2, RtcConnection$StateChange rtcConnection$StateChange, RtcConnection$Quality rtcConnection$Quality, Guild guild, Map<Long, ? extends StoreVoiceParticipants$VoiceUser> map, StreamContext streamContext, StageRequestToSpeakState stageRequestToSpeakState, Integer num, StageInstance stageInstance) {
        return invoke(channel, channel2, rtcConnection$StateChange, rtcConnection$Quality, guild, (Map<Long, StoreVoiceParticipants$VoiceUser>) map, streamContext, stageRequestToSpeakState, num.intValue(), stageInstance);
    }

    public final WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing invoke(Channel channel, Channel channel2, RtcConnection$StateChange rtcConnection$StateChange, RtcConnection$Quality rtcConnection$Quality, Guild guild, Map<Long, StoreVoiceParticipants$VoiceUser> map, StreamContext streamContext, StageRequestToSpeakState stageRequestToSpeakState, int i, StageInstance stageInstance) {
        m.checkNotNullParameter(channel, "p1");
        m.checkNotNullParameter(rtcConnection$StateChange, "p3");
        m.checkNotNullParameter(rtcConnection$Quality, "p4");
        m.checkNotNullParameter(map, "p6");
        m.checkNotNullParameter(stageRequestToSpeakState, "p8");
        return new WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing(channel, channel2, rtcConnection$StateChange, rtcConnection$Quality, guild, map, streamContext, stageRequestToSpeakState, i, stageInstance);
    }
}
