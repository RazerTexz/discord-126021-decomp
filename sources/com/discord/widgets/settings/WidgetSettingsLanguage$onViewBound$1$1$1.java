package com.discord.widgets.settings;

import com.discord.models.domain.ModelUserSettings;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguage$onViewBound$1$1$1 extends o implements Function1<ModelUserSettings, Unit> {
    public final /* synthetic */ WidgetSettingsLanguage$onViewBound$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsLanguage$onViewBound$1$1$1(WidgetSettingsLanguage$onViewBound$1$1 widgetSettingsLanguage$onViewBound$1$1) {
        super(1);
        this.this$0 = widgetSettingsLanguage$onViewBound$1$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelUserSettings modelUserSettings) {
        invoke2(modelUserSettings);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelUserSettings modelUserSettings) {
        m.checkNotNullParameter(modelUserSettings, "it");
        b.a.d.m.g(this.this$0.this$0.this$0.requireContext(), 2131892510, 0, null, 12);
    }
}
