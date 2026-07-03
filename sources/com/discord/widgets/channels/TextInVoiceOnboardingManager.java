package com.discord.widgets.channels;

import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TextInVoiceOnboardingManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextInVoiceOnboardingManager {
    private final Clock clock = ClockFactory.get();

    private final boolean hasUserSeenTextInVoiceOnboarding() {
        return StoreStream.INSTANCE.getNotices().hasSeen("NOTICE_NAME_TEXT_IN_VOICE_ONBOARDED");
    }

    private final boolean isTooYoung(long userId) {
        return this.clock.currentTimeMillis() < ((userId >>> 22) + SnowflakeUtils.DISCORD_EPOCH) + 604800000;
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final void markSeen() {
        StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), "NOTICE_NAME_TEXT_IN_VOICE_ONBOARDED", 0L, 2, null);
    }

    public final boolean shouldShowTextInVoiceOnboarding(long userId, Long guildId) {
        return (guildId == null || !TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(guildId) || hasUserSeenTextInVoiceOnboarding() || isTooYoung(userId)) ? false : true;
    }

    public final void show(Function0<Unit> onCtaClicked) {
        C12238m.checkNotNullParameter(onCtaClicked, "onCtaClicked");
        StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice("NOTICE_NAME_TEXT_IN_VOICE_ONBOARDED", null, 0L, 0, true, C12145m.listOf(C12216a0.getOrCreateKotlinClass(WidgetCallFullscreen.class)), 0L, false, 0L, new TextInVoiceOnboardingManager$show$textInVoiceOnboardingNotice$1(onCtaClicked), 454, null));
    }
}
