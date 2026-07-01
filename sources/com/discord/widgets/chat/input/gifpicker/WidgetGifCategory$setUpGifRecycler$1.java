package com.discord.widgets.chat.input.gifpicker;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGifCategory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGifCategory$setUpGifRecycler$1 extends k implements Function1<GifAdapterItem$GifItem, Unit> {
    public WidgetGifCategory$setUpGifRecycler$1(WidgetGifCategory widgetGifCategory) {
        super(1, widgetGifCategory, WidgetGifCategory.class, "selectGif", "selectGif(Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$GifItem;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GifAdapterItem$GifItem gifAdapterItem$GifItem) {
        invoke2(gifAdapterItem$GifItem);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GifAdapterItem$GifItem gifAdapterItem$GifItem) {
        m.checkNotNullParameter(gifAdapterItem$GifItem, "p1");
        WidgetGifCategory.access$selectGif((WidgetGifCategory) this.receiver, gifAdapterItem$GifItem);
    }
}
