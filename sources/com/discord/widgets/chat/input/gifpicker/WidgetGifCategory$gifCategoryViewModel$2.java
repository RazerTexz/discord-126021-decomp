package com.discord.widgets.chat.input.gifpicker;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetGifCategory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifCategory$gifCategoryViewModel$2 extends AbstractC12240o implements Function0<GifCategoryViewModel> {
    public final /* synthetic */ WidgetGifCategory this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGifCategory$gifCategoryViewModel$2(WidgetGifCategory widgetGifCategory) {
        super(0);
        this.this$0 = widgetGifCategory;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GifCategoryViewModel invoke() {
        return new GifCategoryViewModel(this.this$0.requireContext(), this.this$0.getGifCategory(), null, null, null, null, 60, null);
    }
}
