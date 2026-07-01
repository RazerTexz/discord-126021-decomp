package com.discord.widgets.guildscheduledevent;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGuildScheduledEventUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventUpsellBottomSheet$Companion {
    private WidgetGuildScheduledEventUpsellBottomSheet$Companion() {
    }

    public final void launch(FragmentManager fragmentManager, long guildId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetGuildScheduledEventUpsellBottomSheet widgetGuildScheduledEventUpsellBottomSheet = new WidgetGuildScheduledEventUpsellBottomSheet();
        Bundle bundle = new Bundle();
        bundle.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
        widgetGuildScheduledEventUpsellBottomSheet.setArguments(bundle);
        widgetGuildScheduledEventUpsellBottomSheet.show(fragmentManager, WidgetGuildScheduledEventUpsellBottomSheet.class.getSimpleName());
    }

    public /* synthetic */ WidgetGuildScheduledEventUpsellBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
