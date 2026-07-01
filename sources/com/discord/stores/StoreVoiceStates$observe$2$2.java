package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.voice.state.VoiceState;
import j0.k.b;

/* JADX INFO: compiled from: StoreVoiceStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceStates$observe$2$2<T, R> implements b<VoiceState, Long> {
    public static final StoreVoiceStates$observe$2$2 INSTANCE = new StoreVoiceStates$observe$2$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Long call(VoiceState voiceState) {
        return call2(voiceState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(VoiceState voiceState) {
        return Long.valueOf(voiceState.getUserId());
    }
}
