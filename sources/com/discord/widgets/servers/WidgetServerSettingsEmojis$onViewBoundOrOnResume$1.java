package com.discord.widgets.servers;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$onViewBoundOrOnResume$1 extends o implements Function1<WidgetServerSettingsEmojis$Model, Unit> {
    public final /* synthetic */ WidgetServerSettingsEmojis this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEmojis$onViewBoundOrOnResume$1(WidgetServerSettingsEmojis widgetServerSettingsEmojis) {
        super(1);
        this.this$0 = widgetServerSettingsEmojis;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEmojis$Model widgetServerSettingsEmojis$Model) {
        invoke2(widgetServerSettingsEmojis$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsEmojis$Model widgetServerSettingsEmojis$Model) {
        WidgetServerSettingsEmojis.access$configureUI(this.this$0, widgetServerSettingsEmojis$Model);
    }
}
