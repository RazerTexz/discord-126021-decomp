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
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StickerCategoryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class StickerCategoryViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: compiled from: StickerCategoryViewHolder.kt */
    public static final class Guild extends StickerCategoryViewHolder {
        private final StickerCategoryItemGuildBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public Guild(StickerCategoryItemGuildBinding stickerCategoryItemGuildBinding) {
            Intrinsics3.checkNotNullParameter(stickerCategoryItemGuildBinding, "binding");
            FrameLayout frameLayout = stickerCategoryItemGuildBinding.a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = stickerCategoryItemGuildBinding;
        }

        public final void configure(final StickerCategoryItem.GuildItem guildItem, final Function1<? super StickerCategoryItem.GuildItem, Unit> onGuildClicked) {
            Intrinsics3.checkNotNullParameter(guildItem, "guildItem");
            Intrinsics3.checkNotNullParameter(onGuildClicked, "onGuildClicked");
            this.binding.c.updateView(guildItem.getGuild());
            View view = this.binding.f2148b.f163b;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
            view.setVisibility(guildItem.getIsSelected() ? 0 : 8);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.sticker.StickerCategoryViewHolder$Guild$configure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    onGuildClicked.invoke(guildItem);
                }
            });
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            view2.setContentDescription(guildItem.getGuild().getName());
        }
    }

    /* JADX INFO: compiled from: StickerCategoryViewHolder.kt */
    public static final class Pack extends StickerCategoryViewHolder {
        private final StickerCategoryItemPackBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public Pack(StickerCategoryItemPackBinding stickerCategoryItemPackBinding) {
            Intrinsics3.checkNotNullParameter(stickerCategoryItemPackBinding, "binding");
            FrameLayout frameLayout = stickerCategoryItemPackBinding.a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = stickerCategoryItemPackBinding;
        }

        public final void configure(final StickerCategoryItem.PackItem packItem, final Function1<? super StickerCategoryItem.PackItem, Unit> onPackClicked) {
            Intrinsics3.checkNotNullParameter(packItem, "packItem");
            Intrinsics3.checkNotNullParameter(onPackClicked, "onPackClicked");
            this.binding.c.d(packItem.getPack().getCoverSticker(), 2);
            this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.sticker.StickerCategoryViewHolder$Pack$configure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    onPackClicked.invoke(packItem);
                }
            });
            StickerView stickerView = this.binding.c;
            SimpleDraweeView simpleDraweeView = stickerView.binding.f191b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.stickerViewImageview");
            simpleDraweeView.setImportantForAccessibility(4);
            RLottieImageView rLottieImageView = stickerView.binding.c;
            Intrinsics3.checkNotNullExpressionValue(rLottieImageView, "binding.stickerViewLottie");
            rLottieImageView.setImportantForAccessibility(4);
            ImageView imageView = stickerView.binding.d;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.stickerViewPlaceholder");
            imageView.setImportantForAccessibility(4);
            StickerView stickerView2 = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(stickerView2, "binding.stickerCategoryItemPackAvatar");
            stickerView2.setContentDescription(packItem.getPack().getName());
            View view = this.binding.f2149b.f163b;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
            view.setVisibility(packItem.getIsSelected() ? 0 : 8);
        }
    }

    /* JADX INFO: compiled from: StickerCategoryViewHolder.kt */
    public static final class Recent extends StickerCategoryViewHolder {
        private final StickerCategoryItemRecentBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public Recent(StickerCategoryItemRecentBinding stickerCategoryItemRecentBinding) {
            Intrinsics3.checkNotNullParameter(stickerCategoryItemRecentBinding, "binding");
            FrameLayout frameLayout = stickerCategoryItemRecentBinding.a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = stickerCategoryItemRecentBinding;
        }

        public final void configure(StickerCategoryItem.RecentItem categoryItem, final Function0<Unit> onRecentClicked) {
            Intrinsics3.checkNotNullParameter(categoryItem, "categoryItem");
            Intrinsics3.checkNotNullParameter(onRecentClicked, "onRecentClicked");
            View view = this.binding.f2150b.f163b;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.overline.express…CategorySelectionOverline");
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
