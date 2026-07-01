package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StickerCategoryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerCategoryViewHolder$Guild$configure$1 implements View$OnClickListener {
    public final /* synthetic */ StickerCategoryItem$GuildItem $guildItem;
    public final /* synthetic */ Function1 $onGuildClicked;

    public StickerCategoryViewHolder$Guild$configure$1(Function1 function1, StickerCategoryItem$GuildItem stickerCategoryItem$GuildItem) {
        this.$onGuildClicked = function1;
        this.$guildItem = stickerCategoryItem$GuildItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onGuildClicked.invoke(this.$guildItem);
    }
}
