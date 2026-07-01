package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.databinding.StickerCategoryItemRecentBinding;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StickerCategoryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerCategoryViewHolder$Recent extends StickerCategoryViewHolder {
    private final StickerCategoryItemRecentBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public StickerCategoryViewHolder$Recent(StickerCategoryItemRecentBinding stickerCategoryItemRecentBinding) {
        m.checkNotNullParameter(stickerCategoryItemRecentBinding, "binding");
        FrameLayout frameLayout = stickerCategoryItemRecentBinding.a;
        m.checkNotNullExpressionValue(frameLayout, "binding.root");
        super(frameLayout, null);
        this.binding = stickerCategoryItemRecentBinding;
    }

    public final void configure(StickerCategoryItem$RecentItem categoryItem, Function0<Unit> onRecentClicked) {
        m.checkNotNullParameter(categoryItem, "categoryItem");
        m.checkNotNullParameter(onRecentClicked, "onRecentClicked");
        View view = this.binding.f2150b.f163b;
        m.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
        view.setVisibility(categoryItem.getIsSelected() ? 0 : 8);
        this.itemView.setOnClickListener(new StickerCategoryViewHolder$Recent$configure$1(onRecentClicked));
    }
}
