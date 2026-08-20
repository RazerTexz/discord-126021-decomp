package com.discord.widgets.guildscheduledevent;

import androidx.fragment.app.FragmentActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$previewLauncher$1 extends AbstractC12240o implements Function3<Long, Long, Boolean, Unit> {
    public final /* synthetic */ WidgetGuildScheduledEventSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventSettings$previewLauncher$1(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        super(3);
        this.this$0 = widgetGuildScheduledEventSettings;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2, Boolean bool) {
        invoke(l, l2.longValue(), bool.booleanValue());
        return Unit.f27425a;
    }

    public final void invoke(Long l, long j, boolean z2) {
        FragmentActivity fragmentActivityM95e = this.this$0.m95e();
        if (fragmentActivityM95e != null) {
            fragmentActivityM95e.setResult(-1);
            if (z2) {
                WidgetGuildScheduledEventCreateSuccess.Companion companion = WidgetGuildScheduledEventCreateSuccess.INSTANCE;
                C12238m.checkNotNullExpressionValue(fragmentActivityM95e, "this");
                companion.launch(fragmentActivityM95e, l, this.this$0.getGuildId(), j);
            }
            fragmentActivityM95e.finish();
        }
    }
}
