package com.discord.widgets.chat.input.gifpicker;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGifCategory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifCategory$onViewBoundOrOnResume$1 extends o implements Function1<GifCategoryViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetGifCategory this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGifCategory$onViewBoundOrOnResume$1(WidgetGifCategory widgetGifCategory) {
        super(1);
        this.this$0 = widgetGifCategory;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GifCategoryViewModel$ViewState gifCategoryViewModel$ViewState) {
        invoke2(gifCategoryViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GifCategoryViewModel$ViewState gifCategoryViewModel$ViewState) {
        m.checkNotNullParameter(gifCategoryViewModel$ViewState, "viewState");
        WidgetGifCategory.access$handleViewState(this.this$0, gifCategoryViewModel$ViewState);
    }
}
