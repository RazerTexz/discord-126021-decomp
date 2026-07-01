package com.discord.widgets.channels;

import com.discord.utilities.cache.SharedPreferencesProvider;

/* JADX INFO: compiled from: ChannelOnboardingManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelOnboardingManager {
    public final boolean hasUserSeenChannelOnboarding() {
        return SharedPreferencesProvider.INSTANCE.get().getBoolean("CACHE_KEY_CHANNEL_ONBOARDED", false);
    }

    public final void markSeenUserChannelOnboarding() {
        SharedPreferencesProvider.INSTANCE.get().edit().putBoolean("CACHE_KEY_CHANNEL_ONBOARDED", true).apply();
    }
}
