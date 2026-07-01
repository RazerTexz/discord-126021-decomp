package com.discord.utilities.voice;

import rx.Observable;

/* JADX INFO: compiled from: CallSoundManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface CallSoundManager$IStoreStateGenerator {
    Observable<CallSoundManager$StoreState> observeStoreState(long voiceChannelId);
}
