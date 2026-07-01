package com.discord.widgets.guildscheduledevent;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPreviewGuildScheduledEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetPreviewGuildScheduledEvent$onResume$1 extends k implements Function1<PreviewGuildScheduledEventViewModel$ViewState, Unit> {
    public WidgetPreviewGuildScheduledEvent$onResume$1(WidgetPreviewGuildScheduledEvent widgetPreviewGuildScheduledEvent) {
        super(1, widgetPreviewGuildScheduledEvent, WidgetPreviewGuildScheduledEvent.class, "configureUi", "configureUi(Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PreviewGuildScheduledEventViewModel$ViewState previewGuildScheduledEventViewModel$ViewState) {
        invoke2(previewGuildScheduledEventViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PreviewGuildScheduledEventViewModel$ViewState previewGuildScheduledEventViewModel$ViewState) {
        m.checkNotNullParameter(previewGuildScheduledEventViewModel$ViewState, "p1");
        WidgetPreviewGuildScheduledEvent.access$configureUi((WidgetPreviewGuildScheduledEvent) this.receiver, previewGuildScheduledEventViewModel$ViewState);
    }
}
