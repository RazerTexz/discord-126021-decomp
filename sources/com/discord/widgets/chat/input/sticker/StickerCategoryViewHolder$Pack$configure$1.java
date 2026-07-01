package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StickerCategoryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerCategoryViewHolder$Pack$configure$1 implements View$OnClickListener {
    public final /* synthetic */ Function1 $onPackClicked;
    public final /* synthetic */ StickerCategoryItem$PackItem $packItem;

    public StickerCategoryViewHolder$Pack$configure$1(Function1 function1, StickerCategoryItem$PackItem stickerCategoryItem$PackItem) {
        this.$onPackClicked = function1;
        this.$packItem = stickerCategoryItem$PackItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onPackClicked.invoke(this.$packItem);
    }
}
