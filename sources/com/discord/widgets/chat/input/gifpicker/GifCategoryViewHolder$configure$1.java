package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GifCategoryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifCategoryViewHolder$configure$1 implements View$OnClickListener {
    public final /* synthetic */ GifCategoryItem $gifCategoryItem;
    public final /* synthetic */ Function1 $onSelectGifCategory;

    public GifCategoryViewHolder$configure$1(Function1 function1, GifCategoryItem gifCategoryItem) {
        this.$onSelectGifCategory = function1;
        this.$gifCategoryItem = gifCategoryItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function1 function1 = this.$onSelectGifCategory;
        if (function1 != null) {
        }
    }
}
