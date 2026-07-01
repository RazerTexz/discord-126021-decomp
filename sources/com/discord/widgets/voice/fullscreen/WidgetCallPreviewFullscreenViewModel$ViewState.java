package com.discord.widgets.voice.fullscreen;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.user.NsfwAllowance;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetCallPreviewFullscreenViewModel$ViewState {
    private final int channelMentionsCount;
    private final boolean isChannelNsfw;
    private final boolean isConnectEnabled;
    private final boolean isNsfwUnconsented;
    private final boolean isTextInVoiceChannelSelected;
    private final NsfwAllowance nsfwAllowed;
    private final int otherChannelsMentionsCount;
    private final WidgetCallPreviewFullscreenViewModel$ParticipantsList participantsList;
    private final boolean textInVoiceEnabled;
    private final String titleText;
    private final Channel voiceChannel;

    public WidgetCallPreviewFullscreenViewModel$ViewState(Channel channel, boolean z2, boolean z3, String str, int i, int i2, boolean z4, WidgetCallPreviewFullscreenViewModel$ParticipantsList widgetCallPreviewFullscreenViewModel$ParticipantsList, boolean z5, boolean z6, NsfwAllowance nsfwAllowance) {
        m.checkNotNullParameter(channel, "voiceChannel");
        m.checkNotNullParameter(widgetCallPreviewFullscreenViewModel$ParticipantsList, "participantsList");
        this.voiceChannel = channel;
        this.isTextInVoiceChannelSelected = z2;
        this.textInVoiceEnabled = z3;
        this.titleText = str;
        this.otherChannelsMentionsCount = i;
        this.channelMentionsCount = i2;
        this.isConnectEnabled = z4;
        this.participantsList = widgetCallPreviewFullscreenViewModel$ParticipantsList;
        this.isNsfwUnconsented = z5;
        this.isChannelNsfw = z6;
        this.nsfwAllowed = nsfwAllowance;
    }

    public static /* synthetic */ WidgetCallPreviewFullscreenViewModel$ViewState copy$default(WidgetCallPreviewFullscreenViewModel$ViewState widgetCallPreviewFullscreenViewModel$ViewState, Channel channel, boolean z2, boolean z3, String str, int i, int i2, boolean z4, WidgetCallPreviewFullscreenViewModel$ParticipantsList widgetCallPreviewFullscreenViewModel$ParticipantsList, boolean z5, boolean z6, NsfwAllowance nsfwAllowance, int i3, Object obj) {
        return widgetCallPreviewFullscreenViewModel$ViewState.copy((i3 & 1) != 0 ? widgetCallPreviewFullscreenViewModel$ViewState.voiceChannel : channel, (i3 & 2) != 0 ? widgetCallPreviewFullscreenViewModel$ViewState.isTextInVoiceChannelSelected : z2, (i3 & 4) != 0 ? widgetCallPreviewFullscreenViewModel$ViewState.textInVoiceEnabled : z3, (i3 & 8) != 0 ? widgetCallPreviewFullscreenViewModel$ViewState.titleText : str, (i3 & 16) != 0 ? widgetCallPreviewFullscreenViewModel$ViewState.otherChannelsMentionsCount : i, (i3 & 32) != 0 ? widgetCallPreviewFullscreenViewModel$ViewState.channelMentionsCount : i2, (i3 & 64) != 0 ? widgetCallPreviewFullscreenViewModel$ViewState.isConnectEnabled : z4, (i3 & 128) != 0 ? widgetCallPreviewFullscreenViewModel$ViewState.participantsList : widgetCallPreviewFullscreenViewModel$ParticipantsList, (i3 & 256) != 0 ? widgetCallPreviewFullscreenViewModel$ViewState.isNsfwUnconsented : z5, (i3 & 512) != 0 ? widgetCallPreviewFullscreenViewModel$ViewState.isChannelNsfw : z6, (i3 & 1024) != 0 ? widgetCallPreviewFullscreenViewModel$ViewState.nsfwAllowed : nsfwAllowance);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getVoiceChannel() {
        return this.voiceChannel;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsChannelNsfw() {
        return this.isChannelNsfw;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final NsfwAllowance getNsfwAllowed() {
        return this.nsfwAllowed;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsTextInVoiceChannelSelected() {
        return this.isTextInVoiceChannelSelected;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getTextInVoiceEnabled() {
        return this.textInVoiceEnabled;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTitleText() {
        return this.titleText;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getOtherChannelsMentionsCount() {
        return this.otherChannelsMentionsCount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getChannelMentionsCount() {
        return this.channelMentionsCount;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsConnectEnabled() {
        return this.isConnectEnabled;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final WidgetCallPreviewFullscreenViewModel$ParticipantsList getParticipantsList() {
        return this.participantsList;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsNsfwUnconsented() {
        return this.isNsfwUnconsented;
    }

    public final WidgetCallPreviewFullscreenViewModel$ViewState copy(Channel voiceChannel, boolean isTextInVoiceChannelSelected, boolean textInVoiceEnabled, String titleText, int otherChannelsMentionsCount, int channelMentionsCount, boolean isConnectEnabled, WidgetCallPreviewFullscreenViewModel$ParticipantsList participantsList, boolean isNsfwUnconsented, boolean isChannelNsfw, NsfwAllowance nsfwAllowed) {
        m.checkNotNullParameter(voiceChannel, "voiceChannel");
        m.checkNotNullParameter(participantsList, "participantsList");
        return new WidgetCallPreviewFullscreenViewModel$ViewState(voiceChannel, isTextInVoiceChannelSelected, textInVoiceEnabled, titleText, otherChannelsMentionsCount, channelMentionsCount, isConnectEnabled, participantsList, isNsfwUnconsented, isChannelNsfw, nsfwAllowed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetCallPreviewFullscreenViewModel$ViewState)) {
            return false;
        }
        WidgetCallPreviewFullscreenViewModel$ViewState widgetCallPreviewFullscreenViewModel$ViewState = (WidgetCallPreviewFullscreenViewModel$ViewState) other;
        return m.areEqual(this.voiceChannel, widgetCallPreviewFullscreenViewModel$ViewState.voiceChannel) && this.isTextInVoiceChannelSelected == widgetCallPreviewFullscreenViewModel$ViewState.isTextInVoiceChannelSelected && this.textInVoiceEnabled == widgetCallPreviewFullscreenViewModel$ViewState.textInVoiceEnabled && m.areEqual(this.titleText, widgetCallPreviewFullscreenViewModel$ViewState.titleText) && this.otherChannelsMentionsCount == widgetCallPreviewFullscreenViewModel$ViewState.otherChannelsMentionsCount && this.channelMentionsCount == widgetCallPreviewFullscreenViewModel$ViewState.channelMentionsCount && this.isConnectEnabled == widgetCallPreviewFullscreenViewModel$ViewState.isConnectEnabled && m.areEqual(this.participantsList, widgetCallPreviewFullscreenViewModel$ViewState.participantsList) && this.isNsfwUnconsented == widgetCallPreviewFullscreenViewModel$ViewState.isNsfwUnconsented && this.isChannelNsfw == widgetCallPreviewFullscreenViewModel$ViewState.isChannelNsfw && m.areEqual(this.nsfwAllowed, widgetCallPreviewFullscreenViewModel$ViewState.nsfwAllowed);
    }

    public final int getChannelMentionsCount() {
        return this.channelMentionsCount;
    }

    public final NsfwAllowance getNsfwAllowed() {
        return this.nsfwAllowed;
    }

    public final int getOtherChannelsMentionsCount() {
        return this.otherChannelsMentionsCount;
    }

    public final WidgetCallPreviewFullscreenViewModel$ParticipantsList getParticipantsList() {
        return this.participantsList;
    }

    public final boolean getTextInVoiceEnabled() {
        return this.textInVoiceEnabled;
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public final Channel getVoiceChannel() {
        return this.voiceChannel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Channel channel = this.voiceChannel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean z2 = this.isTextInVoiceChannelSelected;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode + r2) * 31;
        boolean z3 = this.textInVoiceEnabled;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        String str = this.titleText;
        int iHashCode2 = (((((i2 + (str != null ? str.hashCode() : 0)) * 31) + this.otherChannelsMentionsCount) * 31) + this.channelMentionsCount) * 31;
        boolean z4 = this.isConnectEnabled;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i3 = (iHashCode2 + r4) * 31;
        WidgetCallPreviewFullscreenViewModel$ParticipantsList widgetCallPreviewFullscreenViewModel$ParticipantsList = this.participantsList;
        int iHashCode3 = (i3 + (widgetCallPreviewFullscreenViewModel$ParticipantsList != null ? widgetCallPreviewFullscreenViewModel$ParticipantsList.hashCode() : 0)) * 31;
        boolean z5 = this.isNsfwUnconsented;
        ?? r5 = z5;
        if (z5) {
            r5 = 1;
        }
        int i4 = (iHashCode3 + r5) * 31;
        boolean z6 = this.isChannelNsfw;
        int i5 = (i4 + (z6 ? 1 : z6)) * 31;
        NsfwAllowance nsfwAllowance = this.nsfwAllowed;
        return i5 + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0);
    }

    public final boolean isChannelNsfw() {
        return this.isChannelNsfw;
    }

    public final boolean isConnectEnabled() {
        return this.isConnectEnabled;
    }

    public final boolean isNsfwUnconsented() {
        return this.isNsfwUnconsented;
    }

    public final boolean isTextInVoiceChannelSelected() {
        return this.isTextInVoiceChannelSelected;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(voiceChannel=");
        sbU.append(this.voiceChannel);
        sbU.append(", isTextInVoiceChannelSelected=");
        sbU.append(this.isTextInVoiceChannelSelected);
        sbU.append(", textInVoiceEnabled=");
        sbU.append(this.textInVoiceEnabled);
        sbU.append(", titleText=");
        sbU.append(this.titleText);
        sbU.append(", otherChannelsMentionsCount=");
        sbU.append(this.otherChannelsMentionsCount);
        sbU.append(", channelMentionsCount=");
        sbU.append(this.channelMentionsCount);
        sbU.append(", isConnectEnabled=");
        sbU.append(this.isConnectEnabled);
        sbU.append(", participantsList=");
        sbU.append(this.participantsList);
        sbU.append(", isNsfwUnconsented=");
        sbU.append(this.isNsfwUnconsented);
        sbU.append(", isChannelNsfw=");
        sbU.append(this.isChannelNsfw);
        sbU.append(", nsfwAllowed=");
        sbU.append(this.nsfwAllowed);
        sbU.append(")");
        return sbU.toString();
    }
}
