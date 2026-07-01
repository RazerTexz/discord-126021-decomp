package com.discord.widgets.chat.input.emoji;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EmojiCategoryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiCategoryViewHolder$Guild$configure$1 implements View$OnClickListener {
    public final /* synthetic */ EmojiCategoryItem$GuildItem $guildCategoryItem;
    public final /* synthetic */ Function1 $onCategoryClicked;

    public EmojiCategoryViewHolder$Guild$configure$1(Function1 function1, EmojiCategoryItem$GuildItem emojiCategoryItem$GuildItem) {
        this.$onCategoryClicked = function1;
        this.$guildCategoryItem = emojiCategoryItem$GuildItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onCategoryClicked.invoke(this.$guildCategoryItem);
    }
}
