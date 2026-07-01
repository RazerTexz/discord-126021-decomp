package com.discord.widgets.servers;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsBans$onResume$2 extends o implements Function1<WidgetServerSettingsBans$Model, Unit> {
    public final /* synthetic */ WidgetServerSettingsBans this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsBans$onResume$2(WidgetServerSettingsBans widgetServerSettingsBans) {
        super(1);
        this.this$0 = widgetServerSettingsBans;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsBans$Model widgetServerSettingsBans$Model) {
        invoke2(widgetServerSettingsBans$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsBans$Model widgetServerSettingsBans$Model) {
        WidgetServerSettingsBans.access$configureUI(this.this$0, widgetServerSettingsBans$Model);
    }
}
