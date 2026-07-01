package com.discord.widgets.guildscheduledevent;

import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPreviewGuildScheduledEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPreviewGuildScheduledEvent$configureTextForCreation$2 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ String $channelName;
    public final /* synthetic */ PreviewGuildScheduledEventViewModel$ViewState$Initialized $viewState;
    public final /* synthetic */ WidgetPreviewGuildScheduledEvent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPreviewGuildScheduledEvent$configureTextForCreation$2(WidgetPreviewGuildScheduledEvent widgetPreviewGuildScheduledEvent, String str, PreviewGuildScheduledEventViewModel$ViewState$Initialized previewGuildScheduledEventViewModel$ViewState$Initialized) {
        super(1);
        this.this$0 = widgetPreviewGuildScheduledEvent;
        this.$channelName = str;
        this.$viewState = previewGuildScheduledEventViewModel$ViewState$Initialized;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.args.put("channelName", this.$channelName);
        renderContext.a("channelHook", new WidgetPreviewGuildScheduledEvent$configureTextForCreation$2$1(this));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }
}
