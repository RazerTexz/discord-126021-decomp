package com.discord.widgets.status;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection$Quality;
import com.discord.rtcconnection.RtcConnection$State;
import com.discord.utilities.streams.StreamContext;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing extends WidgetGlobalStatusIndicatorViewModel$ViewState {
    private final int blockedUsersOnStage;
    private final RtcConnection$Quality connectionQuality;
    private final RtcConnection$State connectionState;
    private final Guild guild;
    private final boolean isAckingInvitation;
    private final boolean isInvitedToSpeak;
    private final boolean isSpeaking;
    private final boolean isSpeakingInOngoingCall;
    private final Channel selectedVoiceChannel;
    private final StageInstance stageInstance;
    private final StreamContext streamContext;

    public /* synthetic */ WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing(Channel channel, RtcConnection$State rtcConnection$State, RtcConnection$Quality rtcConnection$Quality, Guild guild, StreamContext streamContext, boolean z2, StageInstance stageInstance, boolean z3, boolean z4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(channel, rtcConnection$State, rtcConnection$Quality, guild, streamContext, z2, stageInstance, (i2 & 128) != 0 ? false : z3, (i2 & 256) != 0 ? false : z4, (i2 & 512) != 0 ? 0 : i);
    }

    public static /* synthetic */ WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing copy$default(WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing, Channel channel, RtcConnection$State rtcConnection$State, RtcConnection$Quality rtcConnection$Quality, Guild guild, StreamContext streamContext, boolean z2, StageInstance stageInstance, boolean z3, boolean z4, int i, int i2, Object obj) {
        return widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.copy((i2 & 1) != 0 ? widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.selectedVoiceChannel : channel, (i2 & 2) != 0 ? widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.connectionState : rtcConnection$State, (i2 & 4) != 0 ? widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.connectionQuality : rtcConnection$Quality, (i2 & 8) != 0 ? widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.guild : guild, (i2 & 16) != 0 ? widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.streamContext : streamContext, (i2 & 32) != 0 ? widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.isSpeaking : z2, (i2 & 64) != 0 ? widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.stageInstance : stageInstance, (i2 & 128) != 0 ? widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.isInvitedToSpeak : z3, (i2 & 256) != 0 ? widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.isAckingInvitation : z4, (i2 & 512) != 0 ? widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.blockedUsersOnStage : i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getBlockedUsersOnStage() {
        return this.blockedUsersOnStage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final RtcConnection$State getConnectionState() {
        return this.connectionState;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final RtcConnection$Quality getConnectionQuality() {
        return this.connectionQuality;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final StreamContext getStreamContext() {
        return this.streamContext;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsSpeaking() {
        return this.isSpeaking;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsInvitedToSpeak() {
        return this.isInvitedToSpeak;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsAckingInvitation() {
        return this.isAckingInvitation;
    }

    public final WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing copy(Channel selectedVoiceChannel, RtcConnection$State connectionState, RtcConnection$Quality connectionQuality, Guild guild, StreamContext streamContext, boolean isSpeaking, StageInstance stageInstance, boolean isInvitedToSpeak, boolean isAckingInvitation, int blockedUsersOnStage) {
        m.checkNotNullParameter(selectedVoiceChannel, "selectedVoiceChannel");
        m.checkNotNullParameter(connectionState, "connectionState");
        m.checkNotNullParameter(connectionQuality, "connectionQuality");
        return new WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing(selectedVoiceChannel, connectionState, connectionQuality, guild, streamContext, isSpeaking, stageInstance, isInvitedToSpeak, isAckingInvitation, blockedUsersOnStage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing)) {
            return false;
        }
        WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing = (WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing) other;
        return m.areEqual(this.selectedVoiceChannel, widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.selectedVoiceChannel) && m.areEqual(this.connectionState, widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.connectionState) && m.areEqual(this.connectionQuality, widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.connectionQuality) && m.areEqual(this.guild, widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.guild) && m.areEqual(this.streamContext, widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.streamContext) && this.isSpeaking == widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.isSpeaking && m.areEqual(this.stageInstance, widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.stageInstance) && this.isInvitedToSpeak == widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.isInvitedToSpeak && this.isAckingInvitation == widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.isAckingInvitation && this.blockedUsersOnStage == widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.blockedUsersOnStage;
    }

    public final int getBlockedUsersOnStage() {
        return this.blockedUsersOnStage;
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

    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    public final StreamContext getStreamContext() {
        return this.streamContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Channel channel = this.selectedVoiceChannel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        RtcConnection$State rtcConnection$State = this.connectionState;
        int iHashCode2 = (iHashCode + (rtcConnection$State != null ? rtcConnection$State.hashCode() : 0)) * 31;
        RtcConnection$Quality rtcConnection$Quality = this.connectionQuality;
        int iHashCode3 = (iHashCode2 + (rtcConnection$Quality != null ? rtcConnection$Quality.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        int iHashCode4 = (iHashCode3 + (guild != null ? guild.hashCode() : 0)) * 31;
        StreamContext streamContext = this.streamContext;
        int iHashCode5 = (iHashCode4 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
        boolean z2 = this.isSpeaking;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode5 + r2) * 31;
        StageInstance stageInstance = this.stageInstance;
        int iHashCode6 = (i + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31;
        boolean z3 = this.isInvitedToSpeak;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int i2 = (iHashCode6 + r1) * 31;
        boolean z4 = this.isAckingInvitation;
        return ((i2 + (z4 ? 1 : z4)) * 31) + this.blockedUsersOnStage;
    }

    public final boolean isAckingInvitation() {
        return this.isAckingInvitation;
    }

    public final boolean isInvitedToSpeak() {
        return this.isInvitedToSpeak;
    }

    public final boolean isSpeaking() {
        return this.isSpeaking;
    }

    @Override // com.discord.widgets.status.WidgetGlobalStatusIndicatorViewModel$ViewState
    /* JADX INFO: renamed from: isSpeakingInOngoingCall, reason: from getter */
    public boolean getIsSpeakingInOngoingCall() {
        return this.isSpeakingInOngoingCall;
    }

    public String toString() {
        StringBuilder sbU = a.U("StageChannelOngoing(selectedVoiceChannel=");
        sbU.append(this.selectedVoiceChannel);
        sbU.append(", connectionState=");
        sbU.append(this.connectionState);
        sbU.append(", connectionQuality=");
        sbU.append(this.connectionQuality);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", streamContext=");
        sbU.append(this.streamContext);
        sbU.append(", isSpeaking=");
        sbU.append(this.isSpeaking);
        sbU.append(", stageInstance=");
        sbU.append(this.stageInstance);
        sbU.append(", isInvitedToSpeak=");
        sbU.append(this.isInvitedToSpeak);
        sbU.append(", isAckingInvitation=");
        sbU.append(this.isAckingInvitation);
        sbU.append(", blockedUsersOnStage=");
        return a.B(sbU, this.blockedUsersOnStage, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing(Channel channel, RtcConnection$State rtcConnection$State, RtcConnection$Quality rtcConnection$Quality, Guild guild, StreamContext streamContext, boolean z2, StageInstance stageInstance, boolean z3, boolean z4, int i) {
        super(null);
        m.checkNotNullParameter(channel, "selectedVoiceChannel");
        m.checkNotNullParameter(rtcConnection$State, "connectionState");
        m.checkNotNullParameter(rtcConnection$Quality, "connectionQuality");
        this.selectedVoiceChannel = channel;
        this.connectionState = rtcConnection$State;
        this.connectionQuality = rtcConnection$Quality;
        this.guild = guild;
        this.streamContext = streamContext;
        this.isSpeaking = z2;
        this.stageInstance = stageInstance;
        this.isInvitedToSpeak = z3;
        this.isAckingInvitation = z4;
        this.blockedUsersOnStage = i;
        this.isSpeakingInOngoingCall = z2 || z3;
    }
}
