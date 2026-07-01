package com.discord.widgets.chat.input.autocomplete.adapter;

import android.widget.LinearLayout;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.icon.IconUtils;
import com.discord.widgets.chat.input.autocomplete.EmojiUpsellPlaceholder;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EmojiAutocompleteUpsellViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiAutocompleteUpsellViewHolder$bind$$inlined$map$lambda$1 extends o implements Function1<Integer, String> {
    public final /* synthetic */ EmojiUpsellPlaceholder $emojiUpsellPlaceholder$inlined;
    public final /* synthetic */ Emoji $it;
    public final /* synthetic */ EmojiAutocompleteUpsellViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiAutocompleteUpsellViewHolder$bind$$inlined$map$lambda$1(Emoji emoji, EmojiAutocompleteUpsellViewHolder emojiAutocompleteUpsellViewHolder, EmojiUpsellPlaceholder emojiUpsellPlaceholder) {
        super(1);
        this.$it = emoji;
        this.this$0 = emojiAutocompleteUpsellViewHolder;
        this.$emojiUpsellPlaceholder$inlined = emojiUpsellPlaceholder;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final String invoke(int i) {
        int mediaProxySize = IconUtils.getMediaProxySize(i);
        Emoji emoji = this.$it;
        boolean allowEmojiToAnimate = this.$emojiUpsellPlaceholder$inlined.getAllowEmojiToAnimate();
        LinearLayout linearLayout = EmojiAutocompleteUpsellViewHolder.access$getBinding$p(this.this$0).a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        return emoji.getImageUri(allowEmojiToAnimate, mediaProxySize, linearLayout.getContext());
    }
}
