package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.StickerCategoryItemGuildBinding;
import com.discord.databinding.StickerCategoryItemPackBinding;
import com.discord.databinding.StickerCategoryItemRecentBinding;
import com.discord.rlottie.RLottieImageView;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.input.sticker.StickerCategoryItem;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StickerCategoryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class StickerCategoryViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: compiled from: StickerCategoryViewHolder.kt */
    public static final class Guild extends StickerCategoryViewHolder {
        private final StickerCategoryItemGuildBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public Guild(StickerCategoryItemGuildBinding stickerCategoryItemGuildBinding) {
            C12238m.checkNotNullParameter(stickerCategoryItemGuildBinding, "binding");
            FrameLayout frameLayout = stickerCategoryItemGuildBinding.f15259a;
            C12238m.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = stickerCategoryItemGuildBinding;
        }

        public final void configure(final StickerCategoryItem.GuildItem guildItem, final Function1<? super StickerCategoryItem.GuildItem, Unit> onGuildClicked) {
            C12238m.checkNotNullParameter(guildItem, "guildItem");
            C12238m.checkNotNullParameter(onGuildClicked, "onGuildClicked");
            this.binding.f15261c.updateView(guildItem.getGuild());
            View view = this.binding.f15260b.f1066b;
            C12238m.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
            view.setVisibility(guildItem.getIsSelected() ? 0 : 8);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.sticker.StickerCategoryViewHolder$Guild$configure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    onGuildClicked.invoke(guildItem);
                }
            });
            View view2 = this.itemView;
            C12238m.checkNotNullExpressionValue(view2, "itemView");
            view2.setContentDescription(guildItem.getGuild().getName());
        }
    }

    /* JADX INFO: compiled from: StickerCategoryViewHolder.kt */
    public static final class Pack extends StickerCategoryViewHolder {
        private final StickerCategoryItemPackBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public Pack(StickerCategoryItemPackBinding stickerCategoryItemPackBinding) {
            C12238m.checkNotNullParameter(stickerCategoryItemPackBinding, "binding");
            FrameLayout frameLayout = stickerCategoryItemPackBinding.f15262a;
            C12238m.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = stickerCategoryItemPackBinding;
        }

        public final void configure(final StickerCategoryItem.PackItem packItem, final Function1<? super StickerCategoryItem.PackItem, Unit> onPackClicked) {
            C12238m.checkNotNullParameter(packItem, "packItem");
            C12238m.checkNotNullParameter(onPackClicked, "onPackClicked");
            this.binding.f15264c.m8616d(packItem.getPack().getCoverSticker(), 2);
            this.binding.f15264c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.sticker.StickerCategoryViewHolder$Pack$configure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    onPackClicked.invoke(packItem);
                }
            });
            StickerView stickerView = this.binding.f15264c;
            SimpleDraweeView simpleDraweeView = stickerView.binding.f1177b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerViewImageview");
            simpleDraweeView.setImportantForAccessibility(4);
            RLottieImageView rLottieImageView = stickerView.binding.f1178c;
            C12238m.checkNotNullExpressionValue(rLottieImageView, "binding.stickerViewLottie");
            rLottieImageView.setImportantForAccessibility(4);
            ImageView imageView = stickerView.binding.f1179d;
            C12238m.checkNotNullExpressionValue(imageView, "binding.stickerViewPlaceholder");
            imageView.setImportantForAccessibility(4);
            StickerView stickerView2 = this.binding.f15264c;
            C12238m.checkNotNullExpressionValue(stickerView2, "binding.stickerCategoryItemPackAvatar");
            stickerView2.setContentDescription(packItem.getPack().getName());
            View view = this.binding.f15263b.f1066b;
            C12238m.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
            view.setVisibility(packItem.getIsSelected() ? 0 : 8);
        }
    }

    /* JADX INFO: compiled from: StickerCategoryViewHolder.kt */
    public static final class Recent extends StickerCategoryViewHolder {
        private final StickerCategoryItemRecentBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public Recent(StickerCategoryItemRecentBinding stickerCategoryItemRecentBinding) {
            C12238m.checkNotNullParameter(stickerCategoryItemRecentBinding, "binding");
            FrameLayout frameLayout = stickerCategoryItemRecentBinding.f15265a;
            C12238m.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = stickerCategoryItemRecentBinding;
        }

        public final void configure(StickerCategoryItem.RecentItem categoryItem, final Function0<Unit> onRecentClicked) {
            C12238m.checkNotNullParameter(categoryItem, "categoryItem");
            C12238m.checkNotNullParameter(onRecentClicked, "onRecentClicked");
            View view = this.binding.f15266b.f1066b;
            C12238m.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
            view.setVisibility(categoryItem.getIsSelected() ? 0 : 8);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.sticker.StickerCategoryViewHolder$Recent$configure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    onRecentClicked.invoke();
                }
            });
        }
    }

    private StickerCategoryViewHolder(View view) {
        super(view);
    }

    public /* synthetic */ StickerCategoryViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
