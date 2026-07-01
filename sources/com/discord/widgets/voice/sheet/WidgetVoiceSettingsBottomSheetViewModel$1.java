package com.discord.widgets.voice.sheet;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheetViewModel$1 extends o implements Function1<WidgetVoiceSettingsBottomSheetViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetVoiceSettingsBottomSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceSettingsBottomSheetViewModel$1(WidgetVoiceSettingsBottomSheetViewModel widgetVoiceSettingsBottomSheetViewModel) {
        super(1);
        this.this$0 = widgetVoiceSettingsBottomSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetVoiceSettingsBottomSheetViewModel$StoreState widgetVoiceSettingsBottomSheetViewModel$StoreState) {
        invoke2(widgetVoiceSettingsBottomSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetVoiceSettingsBottomSheetViewModel$StoreState widgetVoiceSettingsBottomSheetViewModel$StoreState) {
        m.checkNotNullParameter(widgetVoiceSettingsBottomSheetViewModel$StoreState, "storeState");
        WidgetVoiceSettingsBottomSheetViewModel.access$handleStoreState(this.this$0, widgetVoiceSettingsBottomSheetViewModel$StoreState);
    }
}
