package com.discord.widgets.chat.input.emoji;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.databinding.EmojiCategoryItemGuildBinding;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EmojiCategoryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiCategoryViewHolder$Guild extends EmojiCategoryViewHolder {
    private final EmojiCategoryItemGuildBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public EmojiCategoryViewHolder$Guild(EmojiCategoryItemGuildBinding emojiCategoryItemGuildBinding) {
        m.checkNotNullParameter(emojiCategoryItemGuildBinding, "binding");
        FrameLayout frameLayout = emojiCategoryItemGuildBinding.a;
        m.checkNotNullExpressionValue(frameLayout, "binding.root");
        super(frameLayout, null);
        this.binding = emojiCategoryItemGuildBinding;
    }

    public final void configure(EmojiCategoryItem$GuildItem guildCategoryItem, Function1<? super EmojiCategoryItem, Unit> onCategoryClicked) {
        m.checkNotNullParameter(guildCategoryItem, "guildCategoryItem");
        m.checkNotNullParameter(onCategoryClicked, "onCategoryClicked");
        this.binding.f2099b.updateView(guildCategoryItem.getGuild());
        View view = this.binding.c.f163b;
        m.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
        view.setVisibility(guildCategoryItem.getIsSelected() ? 0 : 8);
        this.itemView.setOnClickListener(new EmojiCategoryViewHolder$Guild$configure$1(onCategoryClicked, guildCategoryItem));
        View view2 = this.itemView;
        m.checkNotNullExpressionValue(view2, "itemView");
        view2.setContentDescription(guildCategoryItem.getGuild().getName());
    }
}
