package com.discord.widgets.settings;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAppearance$onViewBoundOrOnResume$1 extends k implements Function1<WidgetSettingsAppearance$Model, Unit> {
    public WidgetSettingsAppearance$onViewBoundOrOnResume$1(WidgetSettingsAppearance widgetSettingsAppearance) {
        super(1, widgetSettingsAppearance, WidgetSettingsAppearance.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/WidgetSettingsAppearance$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetSettingsAppearance$Model widgetSettingsAppearance$Model) {
        invoke2(widgetSettingsAppearance$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetSettingsAppearance$Model widgetSettingsAppearance$Model) {
        m.checkNotNullParameter(widgetSettingsAppearance$Model, "p1");
        WidgetSettingsAppearance.access$configureUI((WidgetSettingsAppearance) this.receiver, widgetSettingsAppearance$Model);
    }
}
