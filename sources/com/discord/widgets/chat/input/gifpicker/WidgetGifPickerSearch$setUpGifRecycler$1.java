package com.discord.widgets.chat.input.gifpicker;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGifPickerSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifPickerSearch$setUpGifRecycler$1 extends o implements Function1<GifAdapterItem$GifItem, Unit> {
    public final /* synthetic */ WidgetGifPickerSearch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGifPickerSearch$setUpGifRecycler$1(WidgetGifPickerSearch widgetGifPickerSearch) {
        super(1);
        this.this$0 = widgetGifPickerSearch;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GifAdapterItem$GifItem gifAdapterItem$GifItem) {
        invoke2(gifAdapterItem$GifItem);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GifAdapterItem$GifItem gifAdapterItem$GifItem) {
        m.checkNotNullParameter(gifAdapterItem$GifItem, "gifItem");
        WidgetGifPickerSearch.access$getGifPickerViewModel$p(this.this$0).selectGif(gifAdapterItem$GifItem);
        Function0 function0Access$getOnGifSelected$p = WidgetGifPickerSearch.access$getOnGifSelected$p(this.this$0);
        if (function0Access$getOnGifSelected$p != null) {
        }
    }
}
