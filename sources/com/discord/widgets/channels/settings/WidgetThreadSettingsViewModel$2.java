package com.discord.widgets.channels.settings;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadSettingsViewModel$2 extends o implements Function1<WidgetThreadSettingsViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetThreadSettingsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadSettingsViewModel$2(WidgetThreadSettingsViewModel widgetThreadSettingsViewModel) {
        super(1);
        this.this$0 = widgetThreadSettingsViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadSettingsViewModel$StoreState widgetThreadSettingsViewModel$StoreState) {
        invoke2(widgetThreadSettingsViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetThreadSettingsViewModel$StoreState widgetThreadSettingsViewModel$StoreState) {
        WidgetThreadSettingsViewModel widgetThreadSettingsViewModel = this.this$0;
        m.checkNotNullExpressionValue(widgetThreadSettingsViewModel$StoreState, "storeState");
        WidgetThreadSettingsViewModel.access$handleStoreState(widgetThreadSettingsViewModel, widgetThreadSettingsViewModel$StoreState);
    }
}
