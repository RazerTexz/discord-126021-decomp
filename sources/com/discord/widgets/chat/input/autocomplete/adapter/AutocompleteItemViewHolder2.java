package com.discord.widgets.chat.input.autocomplete.adapter;

import android.content.Context;
import com.discord.models.domain.emoji.Emoji;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.adapter.AutocompleteItemViewHolder$bindEmoji$emojiNode$1, reason: use source file name */
/* JADX INFO: compiled from: AutocompleteItemViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteItemViewHolder2 extends Lambda implements Function3<Boolean, Integer, Context, String> {
    public final /* synthetic */ Emoji $emoji;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutocompleteItemViewHolder2(Emoji emoji) {
        super(3);
        this.$emoji = emoji;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ String invoke(Boolean bool, Integer num, Context context) {
        return invoke(bool.booleanValue(), num.intValue(), context);
    }

    public final String invoke(boolean z2, int i, Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        String imageUri = this.$emoji.getImageUri(z2, 32, context);
        Intrinsics3.checkNotNullExpressionValue(imageUri, "emoji.getImageUri(isAnimated, 32, context)");
        return imageUri;
    }
}
