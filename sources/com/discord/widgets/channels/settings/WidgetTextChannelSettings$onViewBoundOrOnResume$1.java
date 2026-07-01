package com.discord.widgets.channels.settings;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextChannelSettings$onViewBoundOrOnResume$1 extends o implements Function1<WidgetTextChannelSettings$Model, Unit> {
    public final /* synthetic */ WidgetTextChannelSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetTextChannelSettings$onViewBoundOrOnResume$1(WidgetTextChannelSettings widgetTextChannelSettings) {
        super(1);
        this.this$0 = widgetTextChannelSettings;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetTextChannelSettings$Model widgetTextChannelSettings$Model) {
        invoke2(widgetTextChannelSettings$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetTextChannelSettings$Model widgetTextChannelSettings$Model) {
        WidgetTextChannelSettings.access$configureUI(this.this$0, widgetTextChannelSettings$Model);
    }
}
