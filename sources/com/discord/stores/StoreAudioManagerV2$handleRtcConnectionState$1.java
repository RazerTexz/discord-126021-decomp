package com.discord.stores;

import com.discord.rtcconnection.audio.DiscordAudioManager;

/* JADX INFO: compiled from: StoreAudioManagerV2.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAudioManagerV2$handleRtcConnectionState$1 implements Runnable {
    public static final StoreAudioManagerV2$handleRtcConnectionState$1 INSTANCE = new StoreAudioManagerV2$handleRtcConnectionState$1();

    @Override // java.lang.Runnable
    public final void run() {
        DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
        DiscordAudioManager.d().h(true);
    }
}
