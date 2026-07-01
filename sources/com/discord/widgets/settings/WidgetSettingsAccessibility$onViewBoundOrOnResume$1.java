package com.discord.widgets.settings;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAccessibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccessibility$onViewBoundOrOnResume$1 extends k implements Function1<WidgetSettingsAccessibility$Model, Unit> {
    public WidgetSettingsAccessibility$onViewBoundOrOnResume$1(WidgetSettingsAccessibility widgetSettingsAccessibility) {
        super(1, widgetSettingsAccessibility, WidgetSettingsAccessibility.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/WidgetSettingsAccessibility$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetSettingsAccessibility$Model widgetSettingsAccessibility$Model) {
        invoke2(widgetSettingsAccessibility$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetSettingsAccessibility$Model widgetSettingsAccessibility$Model) {
        m.checkNotNullParameter(widgetSettingsAccessibility$Model, "p1");
        WidgetSettingsAccessibility.access$configureUI((WidgetSettingsAccessibility) this.receiver, widgetSettingsAccessibility$Model);
    }
}
