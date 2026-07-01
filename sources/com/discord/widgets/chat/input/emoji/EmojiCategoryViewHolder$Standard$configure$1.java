package com.discord.widgets.chat.input.emoji;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EmojiCategoryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiCategoryViewHolder$Standard$configure$1 implements View$OnClickListener {
    public final /* synthetic */ Function1 $onCategoryClicked;
    public final /* synthetic */ EmojiCategoryItem$StandardItem $standardCategoryItem;

    public EmojiCategoryViewHolder$Standard$configure$1(Function1 function1, EmojiCategoryItem$StandardItem emojiCategoryItem$StandardItem) {
        this.$onCategoryClicked = function1;
        this.$standardCategoryItem = emojiCategoryItem$StandardItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onCategoryClicked.invoke(this.$standardCategoryItem);
    }
}
