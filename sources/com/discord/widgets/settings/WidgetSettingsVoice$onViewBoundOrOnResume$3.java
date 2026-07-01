package com.discord.widgets.settings;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsVoice$onViewBoundOrOnResume$3 extends o implements Function1<WidgetSettingsVoice$Model, Unit> {
    public final /* synthetic */ WidgetSettingsVoice this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsVoice$onViewBoundOrOnResume$3(WidgetSettingsVoice widgetSettingsVoice) {
        super(1);
        this.this$0 = widgetSettingsVoice;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetSettingsVoice$Model widgetSettingsVoice$Model) {
        invoke2(widgetSettingsVoice$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetSettingsVoice$Model widgetSettingsVoice$Model) {
        m.checkNotNullParameter(widgetSettingsVoice$Model, "it");
        WidgetSettingsVoice.access$configureUI(this.this$0, widgetSettingsVoice$Model);
    }
}
