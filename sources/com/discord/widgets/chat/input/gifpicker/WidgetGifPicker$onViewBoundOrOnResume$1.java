package com.discord.widgets.chat.input.gifpicker;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifPicker$onViewBoundOrOnResume$1 extends o implements Function1<GifPickerViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetGifPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGifPicker$onViewBoundOrOnResume$1(WidgetGifPicker widgetGifPicker) {
        super(1);
        this.this$0 = widgetGifPicker;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GifPickerViewModel$ViewState gifPickerViewModel$ViewState) {
        invoke2(gifPickerViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GifPickerViewModel$ViewState gifPickerViewModel$ViewState) {
        m.checkNotNullParameter(gifPickerViewModel$ViewState, "viewState");
        WidgetGifPicker.access$handleViewState(this.this$0, gifPickerViewModel$ViewState);
    }
}
