package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.api.creatormonetization.CreatorMonetizationEligibilityRequirements$Rejection;
import com.discord.utilities.resources.MillisecondsFormatter;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding$Companion {
    private WidgetServerSettingsCreatorMonetizationOnboarding$Companion() {
    }

    private final CharSequence formatRejectionCooldown(Context context, CreatorMonetizationEligibilityRequirements$Rejection creatorMonetizationEligibilityRequirements$Rejection, Clock clock) {
        long time = creatorMonetizationEligibilityRequirements$Rejection.getCanReapplyAt().getTime() - clock.currentTimeMillis();
        if (time <= 0) {
            return null;
        }
        return MillisecondsFormatter.INSTANCE.formatDurationInMillis(context, time);
    }

    public static /* synthetic */ CharSequence formatRejectionCooldown$default(WidgetServerSettingsCreatorMonetizationOnboarding$Companion widgetServerSettingsCreatorMonetizationOnboarding$Companion, Context context, CreatorMonetizationEligibilityRequirements$Rejection creatorMonetizationEligibilityRequirements$Rejection, Clock clock, int i, Object obj) {
        if ((i & 2) != 0) {
            clock = ClockFactory.get();
        }
        return widgetServerSettingsCreatorMonetizationOnboarding$Companion.formatRejectionCooldown(context, creatorMonetizationEligibilityRequirements$Rejection, clock);
    }

    public final void launch(Context context, long guildId) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        j.d(context, WidgetServerSettingsCreatorMonetizationOnboarding.class, intent);
    }

    public /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboarding$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
