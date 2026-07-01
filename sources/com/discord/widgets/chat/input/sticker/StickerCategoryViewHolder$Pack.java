package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.discord.databinding.StickerCategoryItemPackBinding;
import com.discord.rlottie.RLottieImageView;
import com.discord.views.sticker.StickerView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StickerCategoryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerCategoryViewHolder$Pack extends StickerCategoryViewHolder {
    private final StickerCategoryItemPackBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public StickerCategoryViewHolder$Pack(StickerCategoryItemPackBinding stickerCategoryItemPackBinding) {
        m.checkNotNullParameter(stickerCategoryItemPackBinding, "binding");
        FrameLayout frameLayout = stickerCategoryItemPackBinding.a;
        m.checkNotNullExpressionValue(frameLayout, "binding.root");
        super(frameLayout, null);
        this.binding = stickerCategoryItemPackBinding;
    }

    public final void configure(StickerCategoryItem$PackItem packItem, Function1<? super StickerCategoryItem$PackItem, Unit> onPackClicked) {
        m.checkNotNullParameter(packItem, "packItem");
        m.checkNotNullParameter(onPackClicked, "onPackClicked");
        this.binding.c.d(packItem.getPack().getCoverSticker(), 2);
        this.binding.c.setOnClickListener(new StickerCategoryViewHolder$Pack$configure$1(onPackClicked, packItem));
        StickerView stickerView = this.binding.c;
        SimpleDraweeView simpleDraweeView = stickerView.binding.f191b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerViewImageview");
        simpleDraweeView.setImportantForAccessibility(4);
        RLottieImageView rLottieImageView = stickerView.binding.c;
        m.checkNotNullExpressionValue(rLottieImageView, "binding.stickerViewLottie");
        rLottieImageView.setImportantForAccessibility(4);
        ImageView imageView = stickerView.binding.d;
        m.checkNotNullExpressionValue(imageView, "binding.stickerViewPlaceholder");
        imageView.setImportantForAccessibility(4);
        StickerView stickerView2 = this.binding.c;
        m.checkNotNullExpressionValue(stickerView2, "binding.stickerCategoryItemPackAvatar");
        stickerView2.setContentDescription(packItem.getPack().getName());
        View view = this.binding.f2149b.f163b;
        m.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
        view.setVisibility(packItem.getIsSelected() ? 0 : 8);
    }
}
