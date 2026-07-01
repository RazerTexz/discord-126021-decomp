package com.discord.widgets.voice.sheet;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetVoiceBottomSheet$onResume$4 extends k implements Function1<WidgetVoiceBottomSheetViewModel$Event, Unit> {
    public WidgetVoiceBottomSheet$onResume$4(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        super(1, widgetVoiceBottomSheet, WidgetVoiceBottomSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/voice/sheet/WidgetVoiceBottomSheetViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetVoiceBottomSheetViewModel$Event widgetVoiceBottomSheetViewModel$Event) {
        invoke2(widgetVoiceBottomSheetViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetVoiceBottomSheetViewModel$Event widgetVoiceBottomSheetViewModel$Event) {
        m.checkNotNullParameter(widgetVoiceBottomSheetViewModel$Event, "p1");
        WidgetVoiceBottomSheet.access$handleEvent((WidgetVoiceBottomSheet) this.receiver, widgetVoiceBottomSheetViewModel$Event);
    }
}
