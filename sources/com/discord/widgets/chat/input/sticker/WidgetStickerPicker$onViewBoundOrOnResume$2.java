package com.discord.widgets.chat.input.sticker;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPicker$onViewBoundOrOnResume$2 extends o implements Function1<StickerPickerViewModel$Event, Unit> {
    public final /* synthetic */ WidgetStickerPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStickerPicker$onViewBoundOrOnResume$2(WidgetStickerPicker widgetStickerPicker) {
        super(1);
        this.this$0 = widgetStickerPicker;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StickerPickerViewModel$Event stickerPickerViewModel$Event) {
        invoke2(stickerPickerViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StickerPickerViewModel$Event stickerPickerViewModel$Event) {
        m.checkNotNullParameter(stickerPickerViewModel$Event, "event");
        WidgetStickerPicker.access$handleEvent(this.this$0, stickerPickerViewModel$Event);
    }
}
