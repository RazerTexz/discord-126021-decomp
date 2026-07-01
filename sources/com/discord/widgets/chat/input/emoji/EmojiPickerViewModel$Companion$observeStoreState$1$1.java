package com.discord.widgets.chat.input.emoji;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreEmoji$EmojiContext;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.Set;
import rx.functions.Func6;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiPickerViewModel$Companion$observeStoreState$1$1<T1, T2, T3, T4, T5, T6, R> implements Func6<EmojiSet, LinkedHashMap<Long, Guild>, String, Boolean, Boolean, Long, EmojiPickerViewModel$StoreState> {
    public final /* synthetic */ StoreEmoji$EmojiContext $emojiContext;

    public EmojiPickerViewModel$Companion$observeStoreState$1$1(StoreEmoji$EmojiContext storeEmoji$EmojiContext) {
        this.$emojiContext = storeEmoji$EmojiContext;
    }

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ EmojiPickerViewModel$StoreState call(EmojiSet emojiSet, LinkedHashMap<Long, Guild> linkedHashMap, String str, Boolean bool, Boolean bool2, Long l) {
        return call(emojiSet, linkedHashMap, str, bool.booleanValue(), bool2.booleanValue(), l.longValue());
    }

    public final EmojiPickerViewModel$StoreState call(EmojiSet emojiSet, LinkedHashMap<Long, Guild> linkedHashMap, String str, boolean z2, boolean z3, long j) {
        m.checkNotNullParameter(linkedHashMap, "allGuilds");
        m.checkNotNullParameter(str, "searchInputString");
        if (emojiSet == null) {
            return EmojiPickerViewModel$StoreState$Uninitialized.INSTANCE;
        }
        StoreEmoji$EmojiContext storeEmoji$EmojiContext = this.$emojiContext;
        boolean z4 = z2 && !z3;
        Set<Emoji> set = emojiSet.favoriteEmoji;
        m.checkNotNullExpressionValue(set, "emojiSet.favoriteEmoji");
        return new EmojiPickerViewModel$StoreState$Emoji(emojiSet, storeEmoji$EmojiContext, linkedHashMap, str, z4, j, set);
    }
}
