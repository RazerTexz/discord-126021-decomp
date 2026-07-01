package com.discord.widgets.guildscheduledevent;

import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import d0.o;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetEndGuildScheduledEventBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEndGuildScheduledEventBottomSheet$Companion {
    private WidgetEndGuildScheduledEventBottomSheet$Companion() {
    }

    public final void registerForResult(Fragment fragment, String requestKey, Function0<Unit> onActionTaken) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(requestKey, "requestKey");
        m.checkNotNullParameter(onActionTaken, "onActionTaken");
        FragmentKt.setFragmentResultListener(fragment, requestKey, new WidgetEndGuildScheduledEventBottomSheet$Companion$registerForResult$1(requestKey, onActionTaken));
    }

    public final void show(FragmentManager fragmentManager, String requestKey, long guildId, long guildScheduledEventId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(requestKey, "requestKey");
        WidgetEndGuildScheduledEventBottomSheet widgetEndGuildScheduledEventBottomSheet = new WidgetEndGuildScheduledEventBottomSheet();
        widgetEndGuildScheduledEventBottomSheet.setArguments(BundleKt.bundleOf(o.to("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", Long.valueOf(guildScheduledEventId)), o.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(guildId)), o.to("INTENT_EXTRA_REQUEST_KEY", requestKey)));
        widgetEndGuildScheduledEventBottomSheet.show(fragmentManager, WidgetEndGuildScheduledEventBottomSheet.class.getSimpleName());
    }

    public /* synthetic */ WidgetEndGuildScheduledEventBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
