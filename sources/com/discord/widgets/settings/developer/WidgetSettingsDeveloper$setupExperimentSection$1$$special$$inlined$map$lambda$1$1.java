package com.discord.widgets.settings.developer;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1$1 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1$1(WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1 widgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1) {
        super(1);
        this.this$0 = widgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        WidgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1 widgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1 = this.this$0;
        widgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1.this$0.$experimentStore.setOverride(widgetSettingsDeveloper$setupExperimentSection$1$$special$$inlined$map$lambda$1.$registeredExperiment.getName(), i);
    }
}
