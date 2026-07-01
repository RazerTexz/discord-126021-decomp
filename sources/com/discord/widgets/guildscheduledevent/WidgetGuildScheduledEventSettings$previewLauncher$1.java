package com.discord.widgets.guildscheduledevent;

import androidx.fragment.app.FragmentActivity;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$previewLauncher$1 extends Lambda implements Function3<Long, Long, Boolean, Unit> {
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
        FragmentActivity fragmentActivityE = this.this$0.e();
        if (fragmentActivityE != null) {
            fragmentActivityE.setResult(-1);
            if (z2) {
                WidgetGuildScheduledEventCreateSuccess.Companion companion = WidgetGuildScheduledEventCreateSuccess.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(fragmentActivityE, "this");
                companion.launch(fragmentActivityE, l, this.this$0.getGuildId(), j);
            }
            fragmentActivityE.finish();
        }
    }
}
