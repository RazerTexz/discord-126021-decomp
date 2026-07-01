package com.discord.widgets.voice.fullscreen;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.user.NsfwAllowance;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetCallPreviewFullscreenViewModel$StoreState$Valid extends WidgetCallPreviewFullscreenViewModel$StoreState {
    private final CallModel callModel;
    private final int channelMentionsCount;
    private final boolean isChannelNsfw;
    private final boolean isNsfwUnconsented;
    private final boolean isTextInVoiceEnabled;
    private final NsfwAllowance nsfwAllowed;
    private final Channel selectedTextChannel;
    private final Channel selectedVoiceChannel;
    private final int totalMentionsCount;
    private final Channel voiceChannel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallPreviewFullscreenViewModel$StoreState$Valid(Channel channel, Channel channel2, boolean z2, int i, int i2, boolean z3, boolean z4, NsfwAllowance nsfwAllowance, CallModel callModel, Channel channel3) {
        super(null);
        m.checkNotNullParameter(channel, "voiceChannel");
        m.checkNotNullParameter(channel2, "selectedTextChannel");
        m.checkNotNullParameter(callModel, "callModel");
        this.voiceChannel = channel;
        this.selectedTextChannel = channel2;
        this.isTextInVoiceEnabled = z2;
        this.totalMentionsCount = i;
        this.channelMentionsCount = i2;
        this.isNsfwUnconsented = z3;
        this.isChannelNsfw = z4;
        this.nsfwAllowed = nsfwAllowance;
        this.callModel = callModel;
        this.selectedVoiceChannel = channel3;
    }

    public static /* synthetic */ WidgetCallPreviewFullscreenViewModel$StoreState$Valid copy$default(WidgetCallPreviewFullscreenViewModel$StoreState$Valid widgetCallPreviewFullscreenViewModel$StoreState$Valid, Channel channel, Channel channel2, boolean z2, int i, int i2, boolean z3, boolean z4, NsfwAllowance nsfwAllowance, CallModel callModel, Channel channel3, int i3, Object obj) {
        return widgetCallPreviewFullscreenViewModel$StoreState$Valid.copy((i3 & 1) != 0 ? widgetCallPreviewFullscreenViewModel$StoreState$Valid.voiceChannel : channel, (i3 & 2) != 0 ? widgetCallPreviewFullscreenViewModel$StoreState$Valid.selectedTextChannel : channel2, (i3 & 4) != 0 ? widgetCallPreviewFullscreenViewModel$StoreState$Valid.isTextInVoiceEnabled : z2, (i3 & 8) != 0 ? widgetCallPreviewFullscreenViewModel$StoreState$Valid.totalMentionsCount : i, (i3 & 16) != 0 ? widgetCallPreviewFullscreenViewModel$StoreState$Valid.channelMentionsCount : i2, (i3 & 32) != 0 ? widgetCallPreviewFullscreenViewModel$StoreState$Valid.isNsfwUnconsented : z3, (i3 & 64) != 0 ? widgetCallPreviewFullscreenViewModel$StoreState$Valid.isChannelNsfw : z4, (i3 & 128) != 0 ? widgetCallPreviewFullscreenViewModel$StoreState$Valid.nsfwAllowed : nsfwAllowance, (i3 & 256) != 0 ? widgetCallPreviewFullscreenViewModel$StoreState$Valid.callModel : callModel, (i3 & 512) != 0 ? widgetCallPreviewFullscreenViewModel$StoreState$Valid.selectedVoiceChannel : channel3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getVoiceChannel() {
        return this.voiceChannel;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getSelectedTextChannel() {
        return this.selectedTextChannel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsTextInVoiceEnabled() {
        return this.isTextInVoiceEnabled;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getTotalMentionsCount() {
        return this.totalMentionsCount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getChannelMentionsCount() {
        return this.channelMentionsCount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsNsfwUnconsented() {
        return this.isNsfwUnconsented;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsChannelNsfw() {
        return this.isChannelNsfw;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final NsfwAllowance getNsfwAllowed() {
        return this.nsfwAllowed;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final CallModel getCallModel() {
        return this.callModel;
    }

    public final WidgetCallPreviewFullscreenViewModel$StoreState$Valid copy(Channel voiceChannel, Channel selectedTextChannel, boolean isTextInVoiceEnabled, int totalMentionsCount, int channelMentionsCount, boolean isNsfwUnconsented, boolean isChannelNsfw, NsfwAllowance nsfwAllowed, CallModel callModel, Channel selectedVoiceChannel) {
        m.checkNotNullParameter(voiceChannel, "voiceChannel");
        m.checkNotNullParameter(selectedTextChannel, "selectedTextChannel");
        m.checkNotNullParameter(callModel, "callModel");
        return new WidgetCallPreviewFullscreenViewModel$StoreState$Valid(voiceChannel, selectedTextChannel, isTextInVoiceEnabled, totalMentionsCount, channelMentionsCount, isNsfwUnconsented, isChannelNsfw, nsfwAllowed, callModel, selectedVoiceChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetCallPreviewFullscreenViewModel$StoreState$Valid)) {
            return false;
        }
        WidgetCallPreviewFullscreenViewModel$StoreState$Valid widgetCallPreviewFullscreenViewModel$StoreState$Valid = (WidgetCallPreviewFullscreenViewModel$StoreState$Valid) other;
        return m.areEqual(this.voiceChannel, widgetCallPreviewFullscreenViewModel$StoreState$Valid.voiceChannel) && m.areEqual(this.selectedTextChannel, widgetCallPreviewFullscreenViewModel$StoreState$Valid.selectedTextChannel) && this.isTextInVoiceEnabled == widgetCallPreviewFullscreenViewModel$StoreState$Valid.isTextInVoiceEnabled && this.totalMentionsCount == widgetCallPreviewFullscreenViewModel$StoreState$Valid.totalMentionsCount && this.channelMentionsCount == widgetCallPreviewFullscreenViewModel$StoreState$Valid.channelMentionsCount && this.isNsfwUnconsented == widgetCallPreviewFullscreenViewModel$StoreState$Valid.isNsfwUnconsented && this.isChannelNsfw == widgetCallPreviewFullscreenViewModel$StoreState$Valid.isChannelNsfw && m.areEqual(this.nsfwAllowed, widgetCallPreviewFullscreenViewModel$StoreState$Valid.nsfwAllowed) && m.areEqual(this.callModel, widgetCallPreviewFullscreenViewModel$StoreState$Valid.callModel) && m.areEqual(this.selectedVoiceChannel, widgetCallPreviewFullscreenViewModel$StoreState$Valid.selectedVoiceChannel);
    }

    public final CallModel getCallModel() {
        return this.callModel;
    }

    public final int getChannelMentionsCount() {
        return this.channelMentionsCount;
    }

    public final NsfwAllowance getNsfwAllowed() {
        return this.nsfwAllowed;
    }

    public final Channel getSelectedTextChannel() {
        return this.selectedTextChannel;
    }

    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    public final int getTotalMentionsCount() {
        return this.totalMentionsCount;
    }

    public final Channel getVoiceChannel() {
        return this.voiceChannel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Channel channel = this.voiceChannel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        Channel channel2 = this.selectedTextChannel;
        int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
        boolean z2 = this.isTextInVoiceEnabled;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (((((iHashCode2 + r2) * 31) + this.totalMentionsCount) * 31) + this.channelMentionsCount) * 31;
        boolean z3 = this.isNsfwUnconsented;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        boolean z4 = this.isChannelNsfw;
        int i3 = (i2 + (z4 ? 1 : z4)) * 31;
        NsfwAllowance nsfwAllowance = this.nsfwAllowed;
        int iHashCode3 = (i3 + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0)) * 31;
        CallModel callModel = this.callModel;
        int iHashCode4 = (iHashCode3 + (callModel != null ? callModel.hashCode() : 0)) * 31;
        Channel channel3 = this.selectedVoiceChannel;
        return iHashCode4 + (channel3 != null ? channel3.hashCode() : 0);
    }

    public final boolean isChannelNsfw() {
        return this.isChannelNsfw;
    }

    public final boolean isNsfwUnconsented() {
        return this.isNsfwUnconsented;
    }

    public final boolean isTextInVoiceEnabled() {
        return this.isTextInVoiceEnabled;
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(voiceChannel=");
        sbU.append(this.voiceChannel);
        sbU.append(", selectedTextChannel=");
        sbU.append(this.selectedTextChannel);
        sbU.append(", isTextInVoiceEnabled=");
        sbU.append(this.isTextInVoiceEnabled);
        sbU.append(", totalMentionsCount=");
        sbU.append(this.totalMentionsCount);
        sbU.append(", channelMentionsCount=");
        sbU.append(this.channelMentionsCount);
        sbU.append(", isNsfwUnconsented=");
        sbU.append(this.isNsfwUnconsented);
        sbU.append(", isChannelNsfw=");
        sbU.append(this.isChannelNsfw);
        sbU.append(", nsfwAllowed=");
        sbU.append(this.nsfwAllowed);
        sbU.append(", callModel=");
        sbU.append(this.callModel);
        sbU.append(", selectedVoiceChannel=");
        sbU.append(this.selectedVoiceChannel);
        sbU.append(")");
        return sbU.toString();
    }
}
