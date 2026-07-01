package com.discord.widgets.settings;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsPrivacy$onViewBoundOrOnResume$1 extends k implements Function1<WidgetSettingsPrivacy$Model, Unit> {
    public WidgetSettingsPrivacy$onViewBoundOrOnResume$1(WidgetSettingsPrivacy widgetSettingsPrivacy) {
        super(1, widgetSettingsPrivacy, WidgetSettingsPrivacy.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/WidgetSettingsPrivacy$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetSettingsPrivacy$Model widgetSettingsPrivacy$Model) {
        invoke2(widgetSettingsPrivacy$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetSettingsPrivacy$Model widgetSettingsPrivacy$Model) {
        m.checkNotNullParameter(widgetSettingsPrivacy$Model, "p1");
        WidgetSettingsPrivacy.access$configureUI((WidgetSettingsPrivacy) this.receiver, widgetSettingsPrivacy$Model);
    }
}
