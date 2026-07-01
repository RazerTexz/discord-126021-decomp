package com.discord.widgets.voice.sheet;

import com.discord.api.channel.Channel;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public interface WidgetVoiceBottomSheet$ViewState {
    WidgetVoiceBottomSheet$BottomContent getBottomContent();

    WidgetVoiceBottomSheet$CenterContent getCenterContent();

    Channel getChannel();

    boolean getShowInviteOption();

    String getSubtitle();

    String getTitle();

    boolean isDeafened();

    Boolean isNoiseCancellationActive();
}
