package com.discord.widgets.guildscheduledevent;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetEndGuildScheduledEventBottomSheet$requestKey$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetEndGuildScheduledEventBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEndGuildScheduledEventBottomSheet6 extends Lambda implements Function0<String> {
    public final /* synthetic */ WidgetEndGuildScheduledEventBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEndGuildScheduledEventBottomSheet6(WidgetEndGuildScheduledEventBottomSheet widgetEndGuildScheduledEventBottomSheet) {
        super(0);
        this.this$0 = widgetEndGuildScheduledEventBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.this$0.requireArguments().getString("INTENT_EXTRA_REQUEST_KEY", "");
    }
}
