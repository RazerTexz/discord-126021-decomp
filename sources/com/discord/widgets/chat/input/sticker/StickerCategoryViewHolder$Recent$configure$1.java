package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StickerCategoryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerCategoryViewHolder$Recent$configure$1 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onRecentClicked;

    public StickerCategoryViewHolder$Recent$configure$1(Function0 function0) {
        this.$onRecentClicked = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onRecentClicked.invoke();
    }
}
