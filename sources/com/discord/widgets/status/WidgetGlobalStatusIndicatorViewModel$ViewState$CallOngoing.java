package com.discord.widgets.status;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection$Quality;
import com.discord.rtcconnection.RtcConnection$State;
import com.discord.utilities.streams.StreamContext;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing extends WidgetGlobalStatusIndicatorViewModel$ViewState {
    private final RtcConnection$Quality connectionQuality;
    private final RtcConnection$State connectionState;
    private final Guild guild;
    private final boolean hasVideo;
    private final boolean isSpeakingInOngoingCall;
    private final int participants;
    private final Channel selectedTextChannel;
    private final Channel selectedVoiceChannel;
    private final StreamContext streamContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing(Channel channel, Channel channel2, RtcConnection$State rtcConnection$State, RtcConnection$Quality rtcConnection$Quality, Guild guild, int i, boolean z2, StreamContext streamContext) {
        super(null);
        m.checkNotNullParameter(channel, "selectedVoiceChannel");
        m.checkNotNullParameter(rtcConnection$State, "connectionState");
        m.checkNotNullParameter(rtcConnection$Quality, "connectionQuality");
        this.selectedVoiceChannel = channel;
        this.selectedTextChannel = channel2;
        this.connectionState = rtcConnection$State;
        this.connectionQuality = rtcConnection$Quality;
        this.guild = guild;
        this.participants = i;
        this.hasVideo = z2;
        this.streamContext = streamContext;
        this.isSpeakingInOngoingCall = true;
    }

    public static /* synthetic */ WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing copy$default(WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing, Channel channel, Channel channel2, RtcConnection$State rtcConnection$State, RtcConnection$Quality rtcConnection$Quality, Guild guild, int i, boolean z2, StreamContext streamContext, int i2, Object obj) {
        return widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing.copy((i2 & 1) != 0 ? widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing.selectedVoiceChannel : channel, (i2 & 2) != 0 ? widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing.selectedTextChannel : channel2, (i2 & 4) != 0 ? widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing.connectionState : rtcConnection$State, (i2 & 8) != 0 ? widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing.connectionQuality : rtcConnection$Quality, (i2 & 16) != 0 ? widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing.guild : guild, (i2 & 32) != 0 ? widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing.participants : i, (i2 & 64) != 0 ? widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing.hasVideo : z2, (i2 & 128) != 0 ? widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing.streamContext : streamContext);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getSelectedTextChannel() {
        return this.selectedTextChannel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final RtcConnection$State getConnectionState() {
        return this.connectionState;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final RtcConnection$Quality getConnectionQuality() {
        return this.connectionQuality;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getParticipants() {
        return this.participants;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getHasVideo() {
        return this.hasVideo;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final StreamContext getStreamContext() {
        return this.streamContext;
    }

    public final WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing copy(Channel selectedVoiceChannel, Channel selectedTextChannel, RtcConnection$State connectionState, RtcConnection$Quality connectionQuality, Guild guild, int participants, boolean hasVideo, StreamContext streamContext) {
        m.checkNotNullParameter(selectedVoiceChannel, "selectedVoiceChannel");
        m.checkNotNullParameter(connectionState, "connectionState");
        m.checkNotNullParameter(connectionQuality, "connectionQuality");
        return new WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing(selectedVoiceChannel, selectedTextChannel, connectionState, connectionQuality, guild, participants, hasVideo, streamContext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing)) {
            return false;
        }
        WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing = (WidgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing) other;
        return m.areEqual(this.selectedVoiceChannel, widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing.selectedVoiceChannel) && m.areEqual(this.selectedTextChannel, widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing.selectedTextChannel) && m.areEqual(this.connectionState, widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing.connectionState) && m.areEqual(this.connectionQuality, widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing.connectionQuality) && m.areEqual(this.guild, widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing.guild) && this.participants == widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing.participants && this.hasVideo == widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing.hasVideo && m.areEqual(this.streamContext, widgetGlobalStatusIndicatorViewModel$ViewState$CallOngoing.streamContext);
    }

    public final RtcConnection$Quality getConnectionQuality() {
        return this.connectionQuality;
    }

    public final RtcConnection$State getConnectionState() {
        return this.connectionState;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final boolean getHasVideo() {
        return this.hasVideo;
    }

    public final int getParticipants() {
        return this.participants;
    }

    public final Channel getSelectedTextChannel() {
        return this.selectedTextChannel;
    }

    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    public final StreamContext getStreamContext() {
        return this.streamContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v21 */
    public int hashCode() {
        Channel channel = this.selectedVoiceChannel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Channel channel2 = this.selectedTextChannel;
        int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
        RtcConnection$State rtcConnection$State = this.connectionState;
        int iHashCode3 = (iHashCode2 + (rtcConnection$State != null ? rtcConnection$State.hashCode() : 0)) * 31;
        RtcConnection$Quality rtcConnection$Quality = this.connectionQuality;
        int iHashCode4 = (iHashCode3 + (rtcConnection$Quality != null ? rtcConnection$Quality.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        int iHashCode5 = (((iHashCode4 + (guild != null ? guild.hashCode() : 0)) * 31) + this.participants) * 31;
        boolean z2 = this.hasVideo;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode5 + r2) * 31;
        StreamContext streamContext = this.streamContext;
        return i + (streamContext != null ? streamContext.hashCode() : 0);
    }

    @Override // com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$ViewState
    /* JADX INFO: renamed from: isSpeakingInOngoingCall, reason: from getter */
    public boolean getIsSpeakingInOngoingCall() {
        return this.isSpeakingInOngoingCall;
    }

    public String toString() {
        StringBuilder sbU = a.U("CallOngoing(selectedVoiceChannel=");
        sbU.append(this.selectedVoiceChannel);
        sbU.append(", selectedTextChannel=");
        sbU.append(this.selectedTextChannel);
        sbU.append(", connectionState=");
        sbU.append(this.connectionState);
        sbU.append(", connectionQuality=");
        sbU.append(this.connectionQuality);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", participants=");
        sbU.append(this.participants);
        sbU.append(", hasVideo=");
        sbU.append(this.hasVideo);
        sbU.append(", streamContext=");
        sbU.append(this.streamContext);
        sbU.append(")");
        return sbU.toString();
    }
}
