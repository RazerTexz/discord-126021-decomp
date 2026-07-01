package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.databinding.GifCategoryItemViewBinding;
import com.discord.models.gifpicker.domain.ModelGifCategory;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GifCategoryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifCategoryViewHolder extends RecyclerView$ViewHolder {
    private final GifCategoryItemViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifCategoryViewHolder(GifCategoryItemViewBinding gifCategoryItemViewBinding) {
        super(gifCategoryItemViewBinding.a);
        m.checkNotNullParameter(gifCategoryItemViewBinding, "binding");
        this.binding = gifCategoryItemViewBinding;
        this.itemView.setOnTouchListener(new ViewScalingOnTouchListener(0.9f));
    }

    private final void setPreviewImage(String imageUrl) {
        SimpleDraweeView simpleDraweeView = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.gifCategoryItemPreview");
        ViewGroup$LayoutParams layoutParams = simpleDraweeView.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        SimpleDraweeView simpleDraweeView2 = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.gifCategoryItemPreview");
        MGImages.setImage$default(simpleDraweeView2, imageUrl, i, i2, false, null, null, 112, null);
    }

    public final void configure(GifCategoryItem gifCategoryItem, Function1<? super GifCategoryItem, Unit> onSelectGifCategory) {
        m.checkNotNullParameter(gifCategoryItem, "gifCategoryItem");
        if (gifCategoryItem instanceof GifCategoryItem$Standard) {
            ModelGifCategory gifCategory = ((GifCategoryItem$Standard) gifCategoryItem).getGifCategory();
            setPreviewImage(gifCategory.getGifPreviewUrl());
            TextView textView = this.binding.d;
            m.checkNotNullExpressionValue(textView, "binding.gifCategoryItemTitle");
            textView.setText(gifCategory.getCategoryName());
            ImageView imageView = this.binding.f2111b;
            m.checkNotNullExpressionValue(imageView, "binding.gifCategoryItemIcon");
            imageView.setVisibility(8);
        } else if (gifCategoryItem instanceof GifCategoryItem$Trending) {
            setPreviewImage(((GifCategoryItem$Trending) gifCategoryItem).getGifPreviewUrl());
            TextView textView2 = this.binding.d;
            m.checkNotNullExpressionValue(textView2, "binding.gifCategoryItemTitle");
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            textView2.setText(view.getResources().getString(2131889628));
            ImageView imageView2 = this.binding.f2111b;
            m.checkNotNullExpressionValue(imageView2, "binding.gifCategoryItemIcon");
            imageView2.setVisibility(0);
            ImageView imageView3 = this.binding.f2111b;
            View view2 = this.itemView;
            m.checkNotNullExpressionValue(view2, "itemView");
            imageView3.setImageDrawable(ResourcesCompat.getDrawable(view2.getResources(), 2131231514, null));
        }
        this.itemView.setOnClickListener(new GifCategoryViewHolder$configure$1(onSelectGifCategory, gifCategoryItem));
    }
}
