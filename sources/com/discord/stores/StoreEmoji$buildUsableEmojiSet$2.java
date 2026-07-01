package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreEmoji.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmoji$buildUsableEmojiSet$2 extends o implements Function1<Boolean, Boolean> {
    public final /* synthetic */ StoreEmoji$EmojiContext $emojiContext;
    public final /* synthetic */ boolean $hasExternalEmojiPermission;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreEmoji$buildUsableEmojiSet$2(boolean z2, StoreEmoji$EmojiContext storeEmoji$EmojiContext) {
        super(1);
        this.$hasExternalEmojiPermission = z2;
        this.$emojiContext = storeEmoji$EmojiContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool) {
        return Boolean.valueOf(invoke(bool.booleanValue()));
    }

    public final boolean invoke(boolean z2) {
        StoreEmoji$EmojiContext storeEmoji$EmojiContext = this.$emojiContext;
        return ((storeEmoji$EmojiContext instanceof StoreEmoji$EmojiContext$Chat) || (storeEmoji$EmojiContext instanceof StoreEmoji$EmojiContext$Guild)) && z2 && !this.$hasExternalEmojiPermission;
    }
}
