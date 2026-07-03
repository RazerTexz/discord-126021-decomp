package com.discord.widgets.chat.input.autocomplete.adapter;

import android.content.Context;
import com.discord.models.domain.emoji.Emoji;
import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AutocompleteItemViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteItemViewHolder$bindEmoji$emojiNode$1 extends AbstractC12240o implements Function3<Boolean, Integer, Context, String> {
    public final /* synthetic */ Emoji $emoji;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutocompleteItemViewHolder$bindEmoji$emojiNode$1(Emoji emoji) {
        super(3);
        this.$emoji = emoji;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ String invoke(Boolean bool, Integer num, Context context) {
        return invoke(bool.booleanValue(), num.intValue(), context);
    }

    public final String invoke(boolean z2, int i, Context context) {
        C12238m.checkNotNullParameter(context, "context");
        String imageUri = this.$emoji.getImageUri(z2, 32, context);
        C12238m.checkNotNullExpressionValue(imageUri, "emoji.getImageUri(isAnimated, 32, context)");
        return imageUri;
    }
}
