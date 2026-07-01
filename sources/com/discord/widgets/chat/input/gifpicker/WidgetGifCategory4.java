package com.discord.widgets.chat.input.gifpicker;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifCategory$gifCategoryViewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGifCategory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifCategory4 extends Lambda implements Function0<GifCategoryViewModel> {
    public final /* synthetic */ WidgetGifCategory this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGifCategory4(WidgetGifCategory widgetGifCategory) {
        super(0);
        this.this$0 = widgetGifCategory;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GifCategoryViewModel invoke() {
        return new GifCategoryViewModel(this.this$0.requireContext(), this.this$0.getGifCategory(), null, null, null, null, 60, null);
    }
}
