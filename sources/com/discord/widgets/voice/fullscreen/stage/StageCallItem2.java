package com.discord.widgets.voice.fullscreen.stage;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreVoiceParticipants;

/* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.stage.StageCallParticipantItem, reason: use source file name */
/* JADX INFO: compiled from: StageCallItem.kt */
/* JADX INFO: loaded from: classes.dex */
public interface StageCallItem2 {
    Channel getChannel();

    StoreVoiceParticipants.VoiceUser getVoiceUser();
}
