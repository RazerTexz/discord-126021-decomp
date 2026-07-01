package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.voice.state.VoiceState;
import j0.k.b;

/* JADX INFO: compiled from: StoreVoiceStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceStates$observe$2$1<T, R> implements b<VoiceState, Boolean> {
    public final /* synthetic */ StoreVoiceStates$observe$2 this$0;

    public StoreVoiceStates$observe$2$1(StoreVoiceStates$observe$2 storeVoiceStates$observe$2) {
        this.this$0 = storeVoiceStates$observe$2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(VoiceState voiceState) {
        return call2(voiceState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(VoiceState voiceState) {
        Long channelId = voiceState.getChannelId();
        return Boolean.valueOf(channelId != null && channelId.longValue() == this.this$0.$channelId);
    }
}
