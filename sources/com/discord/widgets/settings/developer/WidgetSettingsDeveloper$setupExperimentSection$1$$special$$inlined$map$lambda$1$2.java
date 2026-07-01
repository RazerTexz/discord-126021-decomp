package com.discord.widgets.settings.developer;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1$2 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1$2(WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1 widgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1) {
        super(0);
        this.this$0 = widgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1 widgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1 = this.this$0;
        widgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1.this$0.$experimentStore.clearOverride(widgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1.$registeredExperiment.getName());
    }
}
