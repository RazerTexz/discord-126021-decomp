package com.discord.stores;

import d0.z.d.o;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreEmoji.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmoji$buildUsableEmojiSet$1 extends o implements Function1<Long, Boolean> {
    public final /* synthetic */ StoreEmoji$EmojiContext $emojiContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreEmoji$buildUsableEmojiSet$1(StoreEmoji$EmojiContext storeEmoji$EmojiContext) {
        super(1);
        this.$emojiContext = storeEmoji$EmojiContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
        return Boolean.valueOf(invoke(l.longValue()));
    }

    public final boolean invoke(long j) {
        StoreEmoji$EmojiContext storeEmoji$EmojiContext = this.$emojiContext;
        if (storeEmoji$EmojiContext instanceof StoreEmoji$EmojiContext$Chat) {
            if (((StoreEmoji$EmojiContext$Chat) storeEmoji$EmojiContext).getGuildId() == j) {
                return false;
            }
        } else if (!(storeEmoji$EmojiContext instanceof StoreEmoji$EmojiContext$Global)) {
            if (storeEmoji$EmojiContext instanceof StoreEmoji$EmojiContext$GuildProfile) {
                if (((StoreEmoji$EmojiContext$GuildProfile) storeEmoji$EmojiContext).getGuildId() == j) {
                    return false;
                }
            } else {
                if (!(storeEmoji$EmojiContext instanceof StoreEmoji$EmojiContext$Guild)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (((StoreEmoji$EmojiContext$Guild) storeEmoji$EmojiContext).getGuildId() == j) {
                    return false;
                }
            }
        }
        return true;
    }
}
