package com.discord.widgets.voice.sheet;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetVoiceBottomSheet$onViewCreated$2 extends k implements Function0<Unit> {
    public WidgetVoiceBottomSheet$onViewCreated$2(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
        super(0, widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.class, "onDisconnect", "onDisconnect()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((WidgetVoiceBottomSheetViewModel) this.receiver).onDisconnect();
    }
}
