package com.discord.stores;

import b.c.a.a0.d;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import d0.a0.a;

/* JADX INFO: compiled from: StoreAudioManagerV2.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAudioManagerV2$updateMediaVolume$1 implements Runnable {
    public final /* synthetic */ float $ratio;

    public StoreAudioManagerV2$updateMediaVolume$1(float f) {
        this.$ratio = f;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
        DiscordAudioManager discordAudioManagerD = DiscordAudioManager.d();
        float f = this.$ratio;
        discordAudioManagerD.c();
        if (f < 0.0f || f > 1.0f) {
            d.f1("DiscordAudioManager", "Unexpected media volume ratio: " + f);
            return;
        }
        try {
            discordAudioManagerD.e.setStreamVolume(3, a.roundToInt(f * discordAudioManagerD.f2786x), 0);
        } catch (SecurityException e) {
            d.f1("DiscordAudioManager", "Failed to set stream volume: " + e);
        }
    }
}
