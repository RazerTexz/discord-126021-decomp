package com.discord.widgets.chat.input.gifpicker;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGifPickerSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifPickerSearch$onViewBoundOrOnResume$1 extends o implements Function1<GifSearchViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetGifPickerSearch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGifPickerSearch$onViewBoundOrOnResume$1(WidgetGifPickerSearch widgetGifPickerSearch) {
        super(1);
        this.this$0 = widgetGifPickerSearch;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GifSearchViewModel$ViewState gifSearchViewModel$ViewState) {
        invoke2(gifSearchViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GifSearchViewModel$ViewState gifSearchViewModel$ViewState) {
        WidgetGifPickerSearch widgetGifPickerSearch = this.this$0;
        m.checkNotNullExpressionValue(gifSearchViewModel$ViewState, "viewState");
        WidgetGifPickerSearch.access$handleViewState(widgetGifPickerSearch, gifSearchViewModel$ViewState);
    }
}
