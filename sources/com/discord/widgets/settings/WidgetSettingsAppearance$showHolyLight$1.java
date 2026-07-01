package com.discord.widgets.settings;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAppearance$showHolyLight$1 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetSettingsAppearance this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAppearance$showHolyLight$1(WidgetSettingsAppearance widgetSettingsAppearance) {
        super(1);
        this.this$0 = widgetSettingsAppearance;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        View view = WidgetSettingsAppearance.access$getBinding$p(this.this$0).g;
        m.checkNotNullExpressionValue(view, "binding.settingsAppearanceHolyLight");
        view.setVisibility(8);
        WidgetSettingsAppearance.access$tryEnableTorchMode(this.this$0, false);
    }
}
