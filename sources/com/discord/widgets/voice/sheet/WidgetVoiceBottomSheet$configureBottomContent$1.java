package com.discord.widgets.voice.sheet;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetVoiceBottomSheet$configureBottomContent$1 extends k implements Function0<Unit> {
    public WidgetVoiceBottomSheet$configureBottomContent$1(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
        super(0, widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.class, "onMutePressed", "onMutePressed()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((WidgetVoiceBottomSheetViewModel) this.receiver).onMutePressed();
    }
}
