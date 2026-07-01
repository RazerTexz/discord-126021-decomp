package com.discord.widgets.chat.input.emoji;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.EmojiPickerPremiumUpsellBinding;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiAdapter$PremiumEmojiUpsellViewHolder extends MGRecyclerViewHolder<WidgetEmojiAdapter, MGRecyclerDataPayload> {
    private final EmojiPickerPremiumUpsellBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiAdapter$PremiumEmojiUpsellViewHolder(WidgetEmojiAdapter widgetEmojiAdapter) {
        super(R$layout.emoji_picker_premium_upsell, widgetEmojiAdapter);
        m.checkNotNullParameter(widgetEmojiAdapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(R$id.emojiPickerPremiumCta);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.emojiPickerPremiumCta)));
        }
        EmojiPickerPremiumUpsellBinding emojiPickerPremiumUpsellBinding = new EmojiPickerPremiumUpsellBinding((LinearLayout) view, textView);
        m.checkNotNullExpressionValue(emojiPickerPremiumUpsellBinding, "EmojiPickerPremiumUpsellBinding.bind(itemView)");
        this.binding = emojiPickerPremiumUpsellBinding;
        textView.setOnClickListener(new WidgetEmojiAdapter$PremiumEmojiUpsellViewHolder$1(widgetEmojiAdapter));
    }
}
