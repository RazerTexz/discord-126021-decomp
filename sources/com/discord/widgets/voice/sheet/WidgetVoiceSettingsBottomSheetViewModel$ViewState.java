package com.discord.widgets.voice.sheet;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetVoiceSettingsBottomSheetViewModel$ViewState implements WidgetVoiceSettingsBottomSheet$ViewState {
    private final Channel channel;
    private final Guild guild;
    private final boolean noiseCancellationEnabled;
    private final boolean showInviteItem;
    private final boolean showReportItem;
    private final boolean showStageSettings;
    private final boolean showVoiceParticipants;
    private final boolean showVoiceParticipantsToggle;

    public WidgetVoiceSettingsBottomSheetViewModel$ViewState(Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Guild guild) {
        m.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.showVoiceParticipants = z2;
        this.showVoiceParticipantsToggle = z3;
        this.showInviteItem = z4;
        this.noiseCancellationEnabled = z5;
        this.showStageSettings = z6;
        this.showReportItem = z7;
        this.guild = guild;
    }

    public static /* synthetic */ WidgetVoiceSettingsBottomSheetViewModel$ViewState copy$default(WidgetVoiceSettingsBottomSheetViewModel$ViewState widgetVoiceSettingsBottomSheetViewModel$ViewState, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Guild guild, int i, Object obj) {
        return widgetVoiceSettingsBottomSheetViewModel$ViewState.copy((i & 1) != 0 ? widgetVoiceSettingsBottomSheetViewModel$ViewState.getChannel() : channel, (i & 2) != 0 ? widgetVoiceSettingsBottomSheetViewModel$ViewState.getShowVoiceParticipants() : z2, (i & 4) != 0 ? widgetVoiceSettingsBottomSheetViewModel$ViewState.getShowVoiceParticipantsToggle() : z3, (i & 8) != 0 ? widgetVoiceSettingsBottomSheetViewModel$ViewState.getShowInviteItem() : z4, (i & 16) != 0 ? widgetVoiceSettingsBottomSheetViewModel$ViewState.getNoiseCancellationEnabled() : z5, (i & 32) != 0 ? widgetVoiceSettingsBottomSheetViewModel$ViewState.getShowStageSettings() : z6, (i & 64) != 0 ? widgetVoiceSettingsBottomSheetViewModel$ViewState.getShowReportItem() : z7, (i & 128) != 0 ? widgetVoiceSettingsBottomSheetViewModel$ViewState.getGuild() : guild);
    }

    public final Channel component1() {
        return getChannel();
    }

    public final boolean component2() {
        return getShowVoiceParticipants();
    }

    public final boolean component3() {
        return getShowVoiceParticipantsToggle();
    }

    public final boolean component4() {
        return getShowInviteItem();
    }

    public final boolean component5() {
        return getNoiseCancellationEnabled();
    }

    public final boolean component6() {
        return getShowStageSettings();
    }

    public final boolean component7() {
        return getShowReportItem();
    }

    public final Guild component8() {
        return getGuild();
    }

    public final WidgetVoiceSettingsBottomSheetViewModel$ViewState copy(Channel channel, boolean showVoiceParticipants, boolean showVoiceParticipantsToggle, boolean showInviteItem, boolean noiseCancellationEnabled, boolean showStageSettings, boolean showReportItem, Guild guild) {
        m.checkNotNullParameter(channel, "channel");
        return new WidgetVoiceSettingsBottomSheetViewModel$ViewState(channel, showVoiceParticipants, showVoiceParticipantsToggle, showInviteItem, noiseCancellationEnabled, showStageSettings, showReportItem, guild);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetVoiceSettingsBottomSheetViewModel$ViewState)) {
            return false;
        }
        WidgetVoiceSettingsBottomSheetViewModel$ViewState widgetVoiceSettingsBottomSheetViewModel$ViewState = (WidgetVoiceSettingsBottomSheetViewModel$ViewState) other;
        return m.areEqual(getChannel(), widgetVoiceSettingsBottomSheetViewModel$ViewState.getChannel()) && getShowVoiceParticipants() == widgetVoiceSettingsBottomSheetViewModel$ViewState.getShowVoiceParticipants() && getShowVoiceParticipantsToggle() == widgetVoiceSettingsBottomSheetViewModel$ViewState.getShowVoiceParticipantsToggle() && getShowInviteItem() == widgetVoiceSettingsBottomSheetViewModel$ViewState.getShowInviteItem() && getNoiseCancellationEnabled() == widgetVoiceSettingsBottomSheetViewModel$ViewState.getNoiseCancellationEnabled() && getShowStageSettings() == widgetVoiceSettingsBottomSheetViewModel$ViewState.getShowStageSettings() && getShowReportItem() == widgetVoiceSettingsBottomSheetViewModel$ViewState.getShowReportItem() && m.areEqual(getGuild(), widgetVoiceSettingsBottomSheetViewModel$ViewState.getGuild());
    }

    @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$ViewState
    public Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$ViewState
    public Guild getGuild() {
        return this.guild;
    }

    @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$ViewState
    public boolean getNoiseCancellationEnabled() {
        return this.noiseCancellationEnabled;
    }

    @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$ViewState
    public boolean getShowInviteItem() {
        return this.showInviteItem;
    }

    @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$ViewState
    public boolean getShowReportItem() {
        return this.showReportItem;
    }

    @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$ViewState
    public boolean getShowStageSettings() {
        return this.showStageSettings;
    }

    @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$ViewState
    public boolean getShowVoiceParticipants() {
        return this.showVoiceParticipants;
    }

    @Override // com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$ViewState
    public boolean getShowVoiceParticipantsToggle() {
        return this.showVoiceParticipantsToggle;
    }

    public int hashCode() {
        Channel channel = getChannel();
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        boolean showVoiceParticipants = getShowVoiceParticipants();
        int i = showVoiceParticipants;
        if (showVoiceParticipants) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        boolean showVoiceParticipantsToggle = getShowVoiceParticipantsToggle();
        int i3 = showVoiceParticipantsToggle;
        if (showVoiceParticipantsToggle) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean showInviteItem = getShowInviteItem();
        int i5 = showInviteItem;
        if (showInviteItem) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        boolean noiseCancellationEnabled = getNoiseCancellationEnabled();
        int i7 = noiseCancellationEnabled;
        if (noiseCancellationEnabled) {
            i7 = 1;
        }
        int i8 = (i6 + i7) * 31;
        boolean showStageSettings = getShowStageSettings();
        int i9 = showStageSettings;
        if (showStageSettings) {
            i9 = 1;
        }
        int i10 = (i8 + i9) * 31;
        boolean showReportItem = getShowReportItem();
        int i11 = (i10 + (showReportItem ? 1 : showReportItem)) * 31;
        Guild guild = getGuild();
        return i11 + (guild != null ? guild.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(channel=");
        sbU.append(getChannel());
        sbU.append(", showVoiceParticipants=");
        sbU.append(getShowVoiceParticipants());
        sbU.append(", showVoiceParticipantsToggle=");
        sbU.append(getShowVoiceParticipantsToggle());
        sbU.append(", showInviteItem=");
        sbU.append(getShowInviteItem());
        sbU.append(", noiseCancellationEnabled=");
        sbU.append(getNoiseCancellationEnabled());
        sbU.append(", showStageSettings=");
        sbU.append(getShowStageSettings());
        sbU.append(", showReportItem=");
        sbU.append(getShowReportItem());
        sbU.append(", guild=");
        sbU.append(getGuild());
        sbU.append(")");
        return sbU.toString();
    }
}
