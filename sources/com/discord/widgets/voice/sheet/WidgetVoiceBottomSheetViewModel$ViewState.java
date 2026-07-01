package com.discord.widgets.voice.sheet;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetVoiceBottomSheetViewModel$ViewState implements WidgetVoiceBottomSheet$ViewState {
    private final WidgetVoiceBottomSheet$BottomContent bottomContent;
    private final WidgetVoiceBottomSheet$CenterContent centerContent;
    private final Channel channel;
    private final boolean isDeafened;
    private final Boolean isNoiseCancellationActive;
    private final boolean showInviteOption;
    private final String subtitle;
    private final String title;

    public WidgetVoiceBottomSheetViewModel$ViewState(String str, String str2, Channel channel, boolean z2, Boolean bool, boolean z3, WidgetVoiceBottomSheet$CenterContent widgetVoiceBottomSheet$CenterContent, WidgetVoiceBottomSheet$BottomContent widgetVoiceBottomSheet$BottomContent) {
        m.checkNotNullParameter(str, "title");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(widgetVoiceBottomSheet$CenterContent, "centerContent");
        this.title = str;
        this.subtitle = str2;
        this.channel = channel;
        this.showInviteOption = z2;
        this.isNoiseCancellationActive = bool;
        this.isDeafened = z3;
        this.centerContent = widgetVoiceBottomSheet$CenterContent;
        this.bottomContent = widgetVoiceBottomSheet$BottomContent;
    }

    public static /* synthetic */ WidgetVoiceBottomSheetViewModel$ViewState copy$default(WidgetVoiceBottomSheetViewModel$ViewState widgetVoiceBottomSheetViewModel$ViewState, String str, String str2, Channel channel, boolean z2, Boolean bool, boolean z3, WidgetVoiceBottomSheet$CenterContent widgetVoiceBottomSheet$CenterContent, WidgetVoiceBottomSheet$BottomContent widgetVoiceBottomSheet$BottomContent, int i, Object obj) {
        return widgetVoiceBottomSheetViewModel$ViewState.copy((i & 1) != 0 ? widgetVoiceBottomSheetViewModel$ViewState.getTitle() : str, (i & 2) != 0 ? widgetVoiceBottomSheetViewModel$ViewState.getSubtitle() : str2, (i & 4) != 0 ? widgetVoiceBottomSheetViewModel$ViewState.getChannel() : channel, (i & 8) != 0 ? widgetVoiceBottomSheetViewModel$ViewState.getShowInviteOption() : z2, (i & 16) != 0 ? widgetVoiceBottomSheetViewModel$ViewState.getIsNoiseCancellationActive() : bool, (i & 32) != 0 ? widgetVoiceBottomSheetViewModel$ViewState.getIsDeafened() : z3, (i & 64) != 0 ? widgetVoiceBottomSheetViewModel$ViewState.getCenterContent() : widgetVoiceBottomSheet$CenterContent, (i & 128) != 0 ? widgetVoiceBottomSheetViewModel$ViewState.getBottomContent() : widgetVoiceBottomSheet$BottomContent);
    }

    public final String component1() {
        return getTitle();
    }

    public final String component2() {
        return getSubtitle();
    }

    public final Channel component3() {
        return getChannel();
    }

    public final boolean component4() {
        return getShowInviteOption();
    }

    public final Boolean component5() {
        return getIsNoiseCancellationActive();
    }

    public final boolean component6() {
        return getIsDeafened();
    }

    public final WidgetVoiceBottomSheet$CenterContent component7() {
        return getCenterContent();
    }

    public final WidgetVoiceBottomSheet$BottomContent component8() {
        return getBottomContent();
    }

    public final WidgetVoiceBottomSheetViewModel$ViewState copy(String title, String subtitle, Channel channel, boolean showInviteOption, Boolean isNoiseCancellationActive, boolean isDeafened, WidgetVoiceBottomSheet$CenterContent centerContent, WidgetVoiceBottomSheet$BottomContent bottomContent) {
        m.checkNotNullParameter(title, "title");
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(centerContent, "centerContent");
        return new WidgetVoiceBottomSheetViewModel$ViewState(title, subtitle, channel, showInviteOption, isNoiseCancellationActive, isDeafened, centerContent, bottomContent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetVoiceBottomSheetViewModel$ViewState)) {
            return false;
        }
        WidgetVoiceBottomSheetViewModel$ViewState widgetVoiceBottomSheetViewModel$ViewState = (WidgetVoiceBottomSheetViewModel$ViewState) other;
        return m.areEqual(getTitle(), widgetVoiceBottomSheetViewModel$ViewState.getTitle()) && m.areEqual(getSubtitle(), widgetVoiceBottomSheetViewModel$ViewState.getSubtitle()) && m.areEqual(getChannel(), widgetVoiceBottomSheetViewModel$ViewState.getChannel()) && getShowInviteOption() == widgetVoiceBottomSheetViewModel$ViewState.getShowInviteOption() && m.areEqual(getIsNoiseCancellationActive(), widgetVoiceBottomSheetViewModel$ViewState.getIsNoiseCancellationActive()) && getIsDeafened() == widgetVoiceBottomSheetViewModel$ViewState.getIsDeafened() && m.areEqual(getCenterContent(), widgetVoiceBottomSheetViewModel$ViewState.getCenterContent()) && m.areEqual(getBottomContent(), widgetVoiceBottomSheetViewModel$ViewState.getBottomContent());
    }

    @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$ViewState
    public WidgetVoiceBottomSheet$BottomContent getBottomContent() {
        return this.bottomContent;
    }

    @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$ViewState
    public WidgetVoiceBottomSheet$CenterContent getCenterContent() {
        return this.centerContent;
    }

    @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$ViewState
    public Channel getChannel() {
        return this.channel;
    }

    @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$ViewState
    public boolean getShowInviteOption() {
        return this.showInviteOption;
    }

    @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$ViewState
    public String getSubtitle() {
        return this.subtitle;
    }

    @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$ViewState
    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String title = getTitle();
        int iHashCode = (title != null ? title.hashCode() : 0) * 31;
        String subtitle = getSubtitle();
        int iHashCode2 = (iHashCode + (subtitle != null ? subtitle.hashCode() : 0)) * 31;
        Channel channel = getChannel();
        int iHashCode3 = (iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31;
        boolean showInviteOption = getShowInviteOption();
        int i = showInviteOption;
        if (showInviteOption) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        Boolean isNoiseCancellationActive = getIsNoiseCancellationActive();
        int iHashCode4 = (i2 + (isNoiseCancellationActive != null ? isNoiseCancellationActive.hashCode() : 0)) * 31;
        boolean isDeafened = getIsDeafened();
        int i3 = (iHashCode4 + (isDeafened ? 1 : isDeafened)) * 31;
        WidgetVoiceBottomSheet$CenterContent centerContent = getCenterContent();
        int iHashCode5 = (i3 + (centerContent != null ? centerContent.hashCode() : 0)) * 31;
        WidgetVoiceBottomSheet$BottomContent bottomContent = getBottomContent();
        return iHashCode5 + (bottomContent != null ? bottomContent.hashCode() : 0);
    }

    @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$ViewState
    /* JADX INFO: renamed from: isDeafened, reason: from getter */
    public boolean getIsDeafened() {
        return this.isDeafened;
    }

    @Override // com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet$ViewState
    /* JADX INFO: renamed from: isNoiseCancellationActive, reason: from getter */
    public Boolean getIsNoiseCancellationActive() {
        return this.isNoiseCancellationActive;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(title=");
        sbU.append(getTitle());
        sbU.append(", subtitle=");
        sbU.append(getSubtitle());
        sbU.append(", channel=");
        sbU.append(getChannel());
        sbU.append(", showInviteOption=");
        sbU.append(getShowInviteOption());
        sbU.append(", isNoiseCancellationActive=");
        sbU.append(getIsNoiseCancellationActive());
        sbU.append(", isDeafened=");
        sbU.append(getIsDeafened());
        sbU.append(", centerContent=");
        sbU.append(getCenterContent());
        sbU.append(", bottomContent=");
        sbU.append(getBottomContent());
        sbU.append(")");
        return sbU.toString();
    }
}
