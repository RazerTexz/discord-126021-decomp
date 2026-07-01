package com.discord.widgets.chat.input.emoji;

import android.view.View;
import com.discord.R$layout;
import com.discord.databinding.EmojiPickerEmojiItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ImageViewExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.d0.f;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiAdapter$EmojiViewHolder extends MGRecyclerViewHolder<WidgetEmojiAdapter, MGRecyclerDataPayload> {
    private final EmojiPickerEmojiItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiAdapter$EmojiViewHolder(WidgetEmojiAdapter widgetEmojiAdapter) {
        super(R$layout.emoji_picker_emoji_item, widgetEmojiAdapter);
        m.checkNotNullParameter(widgetEmojiAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view;
        EmojiPickerEmojiItemBinding emojiPickerEmojiItemBinding = new EmojiPickerEmojiItemBinding(simpleDraweeView, simpleDraweeView);
        m.checkNotNullExpressionValue(emojiPickerEmojiItemBinding, "EmojiPickerEmojiItemBinding.bind(itemView)");
        this.binding = emojiPickerEmojiItemBinding;
    }

    public static final /* synthetic */ WidgetEmojiAdapter access$getAdapter$p(WidgetEmojiAdapter$EmojiViewHolder widgetEmojiAdapter$EmojiViewHolder) {
        return (WidgetEmojiAdapter) widgetEmojiAdapter$EmojiViewHolder.adapter;
    }

    public static final /* synthetic */ EmojiPickerEmojiItemBinding access$getBinding$p(WidgetEmojiAdapter$EmojiViewHolder widgetEmojiAdapter$EmojiViewHolder) {
        return widgetEmojiAdapter$EmojiViewHolder.binding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (!(data instanceof WidgetEmojiAdapter$EmojiItem)) {
            data = null;
        }
        WidgetEmojiAdapter$EmojiItem widgetEmojiAdapter$EmojiItem = (WidgetEmojiAdapter$EmojiItem) data;
        if (widgetEmojiAdapter$EmojiItem != null) {
            Emoji emoji = widgetEmojiAdapter$EmojiItem.getEmoji();
            int iCoerceAtMost = f.coerceAtMost(IconUtils.getMediaProxySize(WidgetEmojiAdapter.access$getEmojiSizePx$p((WidgetEmojiAdapter) this.adapter)), 64);
            boolean allowEmojisToAnimate = widgetEmojiAdapter$EmojiItem.getAllowEmojisToAnimate();
            SimpleDraweeView simpleDraweeView = this.binding.f2101b;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.emojiItemDraweeview");
            String imageUri = emoji.getImageUri(allowEmojisToAnimate, iCoerceAtMost, simpleDraweeView.getContext());
            SimpleDraweeView simpleDraweeView2 = this.binding.f2101b;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.emojiItemDraweeview");
            MGImages.setImage$default(simpleDraweeView2, imageUri, 0, 0, true, null, null, 108, null);
            SimpleDraweeView simpleDraweeView3 = this.binding.f2101b;
            m.checkNotNullExpressionValue(simpleDraweeView3, "binding.emojiItemDraweeview");
            ImageViewExtensionsKt.setGrayscale(simpleDraweeView3, (emoji.isUsable() && emoji.isAvailable()) ? false : true);
            SimpleDraweeView simpleDraweeView4 = this.binding.f2101b;
            m.checkNotNullExpressionValue(simpleDraweeView4, "binding.emojiItemDraweeview");
            simpleDraweeView4.setImageAlpha((emoji.isUsable() && emoji.isAvailable()) ? 255 : 100);
            SimpleDraweeView simpleDraweeView5 = this.binding.f2101b;
            m.checkNotNullExpressionValue(simpleDraweeView5, "binding.emojiItemDraweeview");
            simpleDraweeView5.setContentDescription(emoji.getFirstName());
            this.binding.a.setOnClickListener(new WidgetEmojiAdapter$EmojiViewHolder$onConfigure$1(this, emoji));
            SimpleDraweeView simpleDraweeView6 = this.binding.a;
            m.checkNotNullExpressionValue(simpleDraweeView6, "binding.root");
            ViewExtensions.setOnLongClickListenerConsumeClick(simpleDraweeView6, new WidgetEmojiAdapter$EmojiViewHolder$onConfigure$2(this, widgetEmojiAdapter$EmojiItem));
        }
    }
}
