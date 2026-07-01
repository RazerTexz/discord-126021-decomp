package com.discord.widgets.voice.sheet;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheet$onResume$1 extends o implements Function1<WidgetVoiceSettingsBottomSheetViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetVoiceSettingsBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceSettingsBottomSheet$onResume$1(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet) {
        super(1);
        this.this$0 = widgetVoiceSettingsBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetVoiceSettingsBottomSheetViewModel$ViewState widgetVoiceSettingsBottomSheetViewModel$ViewState) {
        invoke2(widgetVoiceSettingsBottomSheetViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetVoiceSettingsBottomSheetViewModel$ViewState widgetVoiceSettingsBottomSheetViewModel$ViewState) {
        m.checkNotNullParameter(widgetVoiceSettingsBottomSheetViewModel$ViewState, "viewState");
        WidgetVoiceSettingsBottomSheet.access$configureUI(this.this$0, widgetVoiceSettingsBottomSheetViewModel$ViewState);
    }
}
