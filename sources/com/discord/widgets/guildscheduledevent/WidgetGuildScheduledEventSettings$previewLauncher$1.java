package com.discord.widgets.guildscheduledevent;

import androidx.fragment.app.FragmentActivity;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$previewLauncher$1 extends o implements Function3<Long, Long, Boolean, Unit> {
    public final /* synthetic */ WidgetGuildScheduledEventSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventSettings$previewLauncher$1(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        super(3);
        this.this$0 = widgetGuildScheduledEventSettings;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2, Boolean bool) {
        invoke(l, l2.longValue(), bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(Long l, long j, boolean z2) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.setResult(-1);
            if (z2) {
                WidgetGuildScheduledEventCreateSuccess$Companion widgetGuildScheduledEventCreateSuccess$Companion = WidgetGuildScheduledEventCreateSuccess.Companion;
                m.checkNotNullExpressionValue(activity, "this");
                widgetGuildScheduledEventCreateSuccess$Companion.launch(activity, l, WidgetGuildScheduledEventSettings.access$getGuildId$p(this.this$0), j);
            }
            activity.finish();
        }
    }
}
