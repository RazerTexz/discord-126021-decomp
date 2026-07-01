package com.discord.widgets.voice.sheet;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetVoiceBottomSheet$onViewCreated$1 extends k implements Function1<Boolean, Unit> {
    public WidgetVoiceBottomSheet$onViewCreated$1(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
        super(1, widgetVoiceBottomSheetViewModel, WidgetVoiceBottomSheetViewModel.class, "onPttPressed", "onPttPressed(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        ((WidgetVoiceBottomSheetViewModel) this.receiver).onPttPressed(z2);
    }
}
