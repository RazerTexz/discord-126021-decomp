package com.discord.widgets.chat.input.sticker;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStickerPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerPicker$onViewBoundOrOnResume$1 extends o implements Function1<StickerPickerViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetStickerPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStickerPicker$onViewBoundOrOnResume$1(WidgetStickerPicker widgetStickerPicker) {
        super(1);
        this.this$0 = widgetStickerPicker;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StickerPickerViewModel$ViewState stickerPickerViewModel$ViewState) {
        invoke2(stickerPickerViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StickerPickerViewModel$ViewState stickerPickerViewModel$ViewState) {
        m.checkNotNullParameter(stickerPickerViewModel$ViewState, "viewState");
        WidgetStickerPicker.access$configureUI(this.this$0, stickerPickerViewModel$ViewState);
    }
}
