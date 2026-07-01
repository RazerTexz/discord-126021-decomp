package com.discord.widgets.voice.sheet;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;

/* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public interface WidgetVoiceSettingsBottomSheet$ViewState {
    Channel getChannel();

    Guild getGuild();

    boolean getNoiseCancellationEnabled();

    boolean getShowInviteItem();

    boolean getShowReportItem();

    boolean getShowStageSettings();

    boolean getShowVoiceParticipants();

    boolean getShowVoiceParticipantsToggle();
}
