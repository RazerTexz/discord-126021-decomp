package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.databinding.StickerCategoryItemGuildBinding;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StickerCategoryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerCategoryViewHolder$Guild extends StickerCategoryViewHolder {
    private final StickerCategoryItemGuildBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public StickerCategoryViewHolder$Guild(StickerCategoryItemGuildBinding stickerCategoryItemGuildBinding) {
        m.checkNotNullParameter(stickerCategoryItemGuildBinding, "binding");
        FrameLayout frameLayout = stickerCategoryItemGuildBinding.a;
        m.checkNotNullExpressionValue(frameLayout, "binding.root");
        super(frameLayout, null);
        this.binding = stickerCategoryItemGuildBinding;
    }

    public final void configure(StickerCategoryItem$GuildItem guildItem, Function1<? super StickerCategoryItem$GuildItem, Unit> onGuildClicked) {
        m.checkNotNullParameter(guildItem, "guildItem");
        m.checkNotNullParameter(onGuildClicked, "onGuildClicked");
        this.binding.c.updateView(guildItem.getGuild());
        View view = this.binding.f2148b.f163b;
        m.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
        view.setVisibility(guildItem.getIsSelected() ? 0 : 8);
        this.itemView.setOnClickListener(new StickerCategoryViewHolder$Guild$configure$1(onGuildClicked, guildItem));
        View view2 = this.itemView;
        m.checkNotNullExpressionValue(view2, "itemView");
        view2.setContentDescription(guildItem.getGuild().getName());
    }
}
