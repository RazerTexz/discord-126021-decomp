package com.discord.widgets.chat.input.emoji;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.discord.databinding.EmojiCategoryItemStandardBinding;
import com.discord.models.domain.emoji.EmojiCategory;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EmojiCategoryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiCategoryViewHolder$Standard extends EmojiCategoryViewHolder {
    private final EmojiCategoryItemStandardBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public EmojiCategoryViewHolder$Standard(EmojiCategoryItemStandardBinding emojiCategoryItemStandardBinding) {
        m.checkNotNullParameter(emojiCategoryItemStandardBinding, "binding");
        FrameLayout frameLayout = emojiCategoryItemStandardBinding.a;
        m.checkNotNullExpressionValue(frameLayout, "binding.root");
        super(frameLayout, null);
        this.binding = emojiCategoryItemStandardBinding;
    }

    public final void configure(EmojiCategoryItem$StandardItem standardCategoryItem, Function1<? super EmojiCategoryItem, Unit> onCategoryClicked) {
        int themedColor;
        m.checkNotNullParameter(standardCategoryItem, "standardCategoryItem");
        m.checkNotNullParameter(onCategoryClicked, "onCategoryClicked");
        EmojiCategory emojiCategory = standardCategoryItem.getEmojiCategory();
        int categoryIconResId = EmojiCategoryViewHolder.Companion.getCategoryIconResId(emojiCategory);
        ImageView imageView = this.binding.f2100b;
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        imageView.setImageDrawable(ResourcesCompat.getDrawable(view.getResources(), categoryIconResId, null));
        boolean isSelected = standardCategoryItem.getIsSelected();
        ImageView imageView2 = this.binding.f2100b;
        m.checkNotNullExpressionValue(imageView2, "binding.emojiCategoryItemStandardIcon");
        imageView2.setSelected(isSelected);
        View view2 = this.binding.c.f163b;
        m.checkNotNullExpressionValue(view2, "binding.overline.express…CategorySelectionOverline");
        view2.setVisibility(isSelected ? 0 : 8);
        if (isSelected) {
            ImageView imageView3 = this.binding.f2100b;
            m.checkNotNullExpressionValue(imageView3, "binding.emojiCategoryItemStandardIcon");
            themedColor = ColorCompat.getThemedColor(imageView3, 2130969005);
        } else {
            ImageView imageView4 = this.binding.f2100b;
            m.checkNotNullExpressionValue(imageView4, "binding.emojiCategoryItemStandardIcon");
            themedColor = ColorCompat.getThemedColor(imageView4, 2130969008);
        }
        ImageView imageView5 = this.binding.f2100b;
        m.checkNotNullExpressionValue(imageView5, "binding.emojiCategoryItemStandardIcon");
        ColorCompatKt.tintWithColor(imageView5, themedColor);
        ImageView imageView6 = this.binding.f2100b;
        m.checkNotNullExpressionValue(imageView6, "binding.emojiCategoryItemStandardIcon");
        imageView6.setAlpha(isSelected ? 1.0f : 0.5f);
        this.itemView.setOnClickListener(new EmojiCategoryViewHolder$Standard$configure$1(onCategoryClicked, standardCategoryItem));
        View view3 = this.itemView;
        m.checkNotNullExpressionValue(view3, "itemView");
        view3.setContentDescription(emojiCategory.name());
    }
}
