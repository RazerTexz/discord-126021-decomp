package com.discord.widgets.status;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection$Quality;
import com.discord.rtcconnection.RtcConnection$StateChange;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.streams.StreamContext;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing extends WidgetGlobalStatusIndicatorViewModel$StoreState {
    private final int blockedUsersOnStage;
    private final RtcConnection$Quality connectionQuality;
    private final RtcConnection$StateChange connectionStateChange;
    private final Guild guild;
    private final Map<Long, StoreVoiceParticipants$VoiceUser> participants;
    private final StageRequestToSpeakState requestToSpeakState;
    private final Channel selectedTextChannel;
    private final Channel selectedVoiceChannel;
    private final StageInstance stageInstance;
    private final StreamContext streamContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing(Channel channel, Channel channel2, RtcConnection$StateChange rtcConnection$StateChange, RtcConnection$Quality rtcConnection$Quality, Guild guild, Map<Long, StoreVoiceParticipants$VoiceUser> map, StreamContext streamContext, StageRequestToSpeakState stageRequestToSpeakState, int i, StageInstance stageInstance) {
        super(null);
        m.checkNotNullParameter(channel, "selectedVoiceChannel");
        m.checkNotNullParameter(rtcConnection$StateChange, "connectionStateChange");
        m.checkNotNullParameter(rtcConnection$Quality, "connectionQuality");
        m.checkNotNullParameter(map, "participants");
        m.checkNotNullParameter(stageRequestToSpeakState, "requestToSpeakState");
        this.selectedVoiceChannel = channel;
        this.selectedTextChannel = channel2;
        this.connectionStateChange = rtcConnection$StateChange;
        this.connectionQuality = rtcConnection$Quality;
        this.guild = guild;
        this.participants = map;
        this.streamContext = streamContext;
        this.requestToSpeakState = stageRequestToSpeakState;
        this.blockedUsersOnStage = i;
        this.stageInstance = stageInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing copy$default(WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing, Channel channel, Channel channel2, RtcConnection$StateChange rtcConnection$StateChange, RtcConnection$Quality rtcConnection$Quality, Guild guild, Map map, StreamContext streamContext, StageRequestToSpeakState stageRequestToSpeakState, int i, StageInstance stageInstance, int i2, Object obj) {
        return widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.copy((i2 & 1) != 0 ? widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.selectedVoiceChannel : channel, (i2 & 2) != 0 ? widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.selectedTextChannel : channel2, (i2 & 4) != 0 ? widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.connectionStateChange : rtcConnection$StateChange, (i2 & 8) != 0 ? widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.connectionQuality : rtcConnection$Quality, (i2 & 16) != 0 ? widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.guild : guild, (i2 & 32) != 0 ? widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.participants : map, (i2 & 64) != 0 ? widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.streamContext : streamContext, (i2 & 128) != 0 ? widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.requestToSpeakState : stageRequestToSpeakState, (i2 & 256) != 0 ? widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.blockedUsersOnStage : i, (i2 & 512) != 0 ? widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.stageInstance : stageInstance);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getSelectedTextChannel() {
        return this.selectedTextChannel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final RtcConnection$StateChange getConnectionStateChange() {
        return this.connectionStateChange;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final RtcConnection$Quality getConnectionQuality() {
        return this.connectionQuality;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final Map<Long, StoreVoiceParticipants$VoiceUser> component6() {
        return this.participants;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final StreamContext getStreamContext() {
        return this.streamContext;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final StageRequestToSpeakState getRequestToSpeakState() {
        return this.requestToSpeakState;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getBlockedUsersOnStage() {
        return this.blockedUsersOnStage;
    }

    public final WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing copy(Channel selectedVoiceChannel, Channel selectedTextChannel, RtcConnection$StateChange connectionStateChange, RtcConnection$Quality connectionQuality, Guild guild, Map<Long, StoreVoiceParticipants$VoiceUser> participants, StreamContext streamContext, StageRequestToSpeakState requestToSpeakState, int blockedUsersOnStage, StageInstance stageInstance) {
        m.checkNotNullParameter(selectedVoiceChannel, "selectedVoiceChannel");
        m.checkNotNullParameter(connectionStateChange, "connectionStateChange");
        m.checkNotNullParameter(connectionQuality, "connectionQuality");
        m.checkNotNullParameter(participants, "participants");
        m.checkNotNullParameter(requestToSpeakState, "requestToSpeakState");
        return new WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing(selectedVoiceChannel, selectedTextChannel, connectionStateChange, connectionQuality, guild, participants, streamContext, requestToSpeakState, blockedUsersOnStage, stageInstance);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing)) {
            return false;
        }
        WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing = (WidgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing) other;
        return m.areEqual(this.selectedVoiceChannel, widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.selectedVoiceChannel) && m.areEqual(this.selectedTextChannel, widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.selectedTextChannel) && m.areEqual(this.connectionStateChange, widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.connectionStateChange) && m.areEqual(this.connectionQuality, widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.connectionQuality) && m.areEqual(this.guild, widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.guild) && m.areEqual(this.participants, widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.participants) && m.areEqual(this.streamContext, widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.streamContext) && m.areEqual(this.requestToSpeakState, widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.requestToSpeakState) && this.blockedUsersOnStage == widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.blockedUsersOnStage && m.areEqual(this.stageInstance, widgetGlobalStatusIndicatorViewModel$StoreState$CallOngoing.stageInstance);
    }

    public final int getBlockedUsersOnStage() {
        return this.blockedUsersOnStage;
    }

    public final RtcConnection$Quality getConnectionQuality() {
        return this.connectionQuality;
    }

    public final RtcConnection$StateChange getConnectionStateChange() {
        return this.connectionStateChange;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Map<Long, StoreVoiceParticipants$VoiceUser> getParticipants() {
        return this.participants;
    }

    public final StageRequestToSpeakState getRequestToSpeakState() {
        return this.requestToSpeakState;
    }

    public final Channel getSelectedTextChannel() {
        return this.selectedTextChannel;
    }

    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    public final StreamContext getStreamContext() {
        return this.streamContext;
    }

    public int hashCode() {
        Channel channel = this.selectedVoiceChannel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Channel channel2 = this.selectedTextChannel;
        int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
        RtcConnection$StateChange rtcConnection$StateChange = this.connectionStateChange;
        int iHashCode3 = (iHashCode2 + (rtcConnection$StateChange != null ? rtcConnection$StateChange.hashCode() : 0)) * 31;
        RtcConnection$Quality rtcConnection$Quality = this.connectionQuality;
        int iHashCode4 = (iHashCode3 + (rtcConnection$Quality != null ? rtcConnection$Quality.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        int iHashCode5 = (iHashCode4 + (guild != null ? guild.hashCode() : 0)) * 31;
        Map<Long, StoreVoiceParticipants$VoiceUser> map = this.participants;
        int iHashCode6 = (iHashCode5 + (map != null ? map.hashCode() : 0)) * 31;
        StreamContext streamContext = this.streamContext;
        int iHashCode7 = (iHashCode6 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
        StageRequestToSpeakState stageRequestToSpeakState = this.requestToSpeakState;
        int iHashCode8 = (((iHashCode7 + (stageRequestToSpeakState != null ? stageRequestToSpeakState.hashCode() : 0)) * 31) + this.blockedUsersOnStage) * 31;
        StageInstance stageInstance = this.stageInstance;
        return iHashCode8 + (stageInstance != null ? stageInstance.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("CallOngoing(selectedVoiceChannel=");
        sbU.append(this.selectedVoiceChannel);
        sbU.append(", selectedTextChannel=");
        sbU.append(this.selectedTextChannel);
        sbU.append(", connectionStateChange=");
        sbU.append(this.connectionStateChange);
        sbU.append(", connectionQuality=");
        sbU.append(this.connectionQuality);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", participants=");
        sbU.append(this.participants);
        sbU.append(", streamContext=");
        sbU.append(this.streamContext);
        sbU.append(", requestToSpeakState=");
        sbU.append(this.requestToSpeakState);
        sbU.append(", blockedUsersOnStage=");
        sbU.append(this.blockedUsersOnStage);
        sbU.append(", stageInstance=");
        sbU.append(this.stageInstance);
        sbU.append(")");
        return sbU.toString();
    }
}
