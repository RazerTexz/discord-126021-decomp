package com.discord.widgets.voice.fullscreen.stage;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;

/* JADX INFO: compiled from: StageCallItem.kt */
/* JADX INFO: loaded from: classes.dex */
public interface StageCallParticipantItem {
    Channel getChannel();

    StoreVoiceParticipants$VoiceUser getVoiceUser();
}
