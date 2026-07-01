package com.discord.widgets.channels;

import com.discord.stores.StoreNotices;
import com.discord.stores.StoreNotices$Notice;
import com.discord.stores.StoreStream;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: TextInVoiceOnboardingManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextInVoiceOnboardingManager {
    private final Clock clock = ClockFactory.get();

    private final boolean hasUserSeenTextInVoiceOnboarding() {
        return StoreStream.Companion.getNotices().hasSeen("NOTICE_NAME_TEXT_IN_VOICE_ONBOARDED");
    }

    private final boolean isTooYoung(long userId) {
        return this.clock.currentTimeMillis() < ((userId >>> 22) + SnowflakeUtils.DISCORD_EPOCH) + 604800000;
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final void markSeen() {
        StoreNotices.markSeen$default(StoreStream.Companion.getNotices(), "NOTICE_NAME_TEXT_IN_VOICE_ONBOARDED", 0L, 2, null);
    }

    public final boolean shouldShowTextInVoiceOnboarding(long userId, Long guildId) {
        return (guildId == null || !TextInVoiceFeatureFlag.Companion.getINSTANCE().isEnabled(guildId) || hasUserSeenTextInVoiceOnboarding() || isTooYoung(userId)) ? false : true;
    }

    public final void show(Function0<Unit> onCtaClicked) {
        m.checkNotNullParameter(onCtaClicked, "onCtaClicked");
        StoreStream.Companion.getNotices().requestToShow(new StoreNotices$Notice("NOTICE_NAME_TEXT_IN_VOICE_ONBOARDED", null, 0L, 0, true, d0.t.m.listOf(a0.getOrCreateKotlinClass(WidgetCallFullscreen.class)), 0L, false, 0L, new TextInVoiceOnboardingManager$show$textInVoiceOnboardingNotice$1(onCtaClicked), 454, null));
    }
}
