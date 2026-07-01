package com.discord.widgets.share;

import com.discord.utilities.time.Clock;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$onViewBoundOrOnResume$2 extends o implements Function1<WidgetIncomingShare$Model, Unit> {
    public final /* synthetic */ Clock $clock;
    public final /* synthetic */ WidgetIncomingShare this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIncomingShare$onViewBoundOrOnResume$2(WidgetIncomingShare widgetIncomingShare, Clock clock) {
        super(1);
        this.this$0 = widgetIncomingShare;
        this.$clock = clock;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetIncomingShare$Model widgetIncomingShare$Model) {
        invoke2(widgetIncomingShare$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetIncomingShare$Model widgetIncomingShare$Model) {
        WidgetIncomingShare widgetIncomingShare = this.this$0;
        m.checkNotNullExpressionValue(widgetIncomingShare$Model, "it");
        WidgetIncomingShare.access$configureUi(widgetIncomingShare, widgetIncomingShare$Model, this.$clock);
    }
}
