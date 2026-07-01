package com.discord.widgets.settings.developer;

import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsDeveloper$setupExperimentSection$2 extends o implements Function1<List<? extends WidgetSettingsDeveloper$setupExperimentSection$1$1$1>, Unit> {
    public final /* synthetic */ WidgetSettingsDeveloper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsDeveloper$setupExperimentSection$2(WidgetSettingsDeveloper widgetSettingsDeveloper) {
        super(1);
        this.this$0 = widgetSettingsDeveloper;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends WidgetSettingsDeveloper$setupExperimentSection$1$1$1> list) {
        invoke2((List<WidgetSettingsDeveloper$setupExperimentSection$1$1$1>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<WidgetSettingsDeveloper$setupExperimentSection$1$1$1> list) {
        ExperimentOverridesAdapter experimentOverridesAdapterAccess$getExperimentOverridesAdapter$p = WidgetSettingsDeveloper.access$getExperimentOverridesAdapter$p(this.this$0);
        m.checkNotNullExpressionValue(list, "data");
        experimentOverridesAdapterAccess$getExperimentOverridesAdapter$p.setData(list);
    }
}
