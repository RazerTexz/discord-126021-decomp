package com.discord.widgets.chat.input.autocomplete.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.chat.input.autocomplete.EmojiUpsellPlaceholder;

/* JADX INFO: compiled from: EmojiAutocompleteUpsellViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiAutocompleteUpsellViewHolder$bind$1 implements View$OnClickListener {
    public final /* synthetic */ EmojiUpsellPlaceholder $emojiUpsellPlaceholder;
    public final /* synthetic */ EmojiAutocompleteUpsellViewHolder this$0;

    public EmojiAutocompleteUpsellViewHolder$bind$1(EmojiAutocompleteUpsellViewHolder emojiAutocompleteUpsellViewHolder, EmojiUpsellPlaceholder emojiUpsellPlaceholder) {
        this.this$0 = emojiAutocompleteUpsellViewHolder;
        this.$emojiUpsellPlaceholder = emojiUpsellPlaceholder;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        EmojiAutocompleteUpsellViewHolder.access$getOnItemSelected$p(this.this$0).invoke(this.$emojiUpsellPlaceholder);
    }
}
