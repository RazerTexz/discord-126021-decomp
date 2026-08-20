package com.discord.widgets.guildscheduledevent;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetPreviewGuildScheduledEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPreviewGuildScheduledEvent$viewModel$2 extends AbstractC12240o implements Function0<PreviewGuildScheduledEventViewModel> {
    public final /* synthetic */ WidgetPreviewGuildScheduledEvent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPreviewGuildScheduledEvent$viewModel$2(WidgetPreviewGuildScheduledEvent widgetPreviewGuildScheduledEvent) {
        super(0);
        this.this$0 = widgetPreviewGuildScheduledEvent;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PreviewGuildScheduledEventViewModel invoke() {
        return new PreviewGuildScheduledEventViewModel(this.this$0.getEventModel(), (WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData) this.this$0.getMostRecentIntent().getSerializableExtra("INTENT_EXTRA_EXISTING_EVENT_DATA"), null, null, null, 28, null);
    }
}
