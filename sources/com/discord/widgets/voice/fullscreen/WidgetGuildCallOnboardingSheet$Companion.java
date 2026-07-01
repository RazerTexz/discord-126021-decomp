package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildCallOnboardingSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildCallOnboardingSheet$Companion {
    private WidgetGuildCallOnboardingSheet$Companion() {
    }

    public final boolean hasUserSeenVoiceChannelOnboarding(Context context) {
        m.checkNotNullParameter(context, "context");
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("CACHE_KEY_VOICE_CHANNEL_ONBOARDED", false);
    }

    public final void markSeenUserVoiceChannelOnboarding(Context context) {
        m.checkNotNullParameter(context, "context");
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("CACHE_KEY_VOICE_CHANNEL_ONBOARDED", true).apply();
    }

    public final void show(FragmentManager fragmentManager, long channelId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetGuildCallOnboardingSheet widgetGuildCallOnboardingSheet = new WidgetGuildCallOnboardingSheet();
        Bundle bundle = new Bundle();
        bundle.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        widgetGuildCallOnboardingSheet.setArguments(bundle);
        widgetGuildCallOnboardingSheet.show(fragmentManager, WidgetGuildCallOnboardingSheet.class.getName());
    }

    public /* synthetic */ WidgetGuildCallOnboardingSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
