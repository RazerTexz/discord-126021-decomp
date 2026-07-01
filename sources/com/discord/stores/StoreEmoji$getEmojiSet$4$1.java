package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import d0.z.d.m;
import j0.k.b;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: StoreEmoji.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmoji$getEmojiSet$4$1<T, R> implements b<Map<Long, ? extends Map<Long, ? extends ModelEmojiCustom>>, EmojiSet> {
    public final /* synthetic */ Set $favorites;
    public final /* synthetic */ Boolean $hasExternalEmojiPermission;
    public final /* synthetic */ Boolean $isPremium;
    public final /* synthetic */ List $sortedGuildIds;
    public final /* synthetic */ StoreEmoji$getEmojiSet$4 this$0;

    public StoreEmoji$getEmojiSet$4$1(StoreEmoji$getEmojiSet$4 storeEmoji$getEmojiSet$4, List list, Boolean bool, Boolean bool2, Set set) {
        this.this$0 = storeEmoji$getEmojiSet$4;
        this.$sortedGuildIds = list;
        this.$isPremium = bool;
        this.$hasExternalEmojiPermission = bool2;
        this.$favorites = set;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ EmojiSet call(Map<Long, ? extends Map<Long, ? extends ModelEmojiCustom>> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final EmojiSet call2(Map<Long, ? extends Map<Long, ? extends ModelEmojiCustom>> map) {
        StoreEmoji storeEmoji = this.this$0.this$0;
        m.checkNotNullExpressionValue(map, "allowedCustomEmoji");
        StoreEmoji$EmojiContext storeEmoji$EmojiContext = this.this$0.$emojiContext;
        List list = this.$sortedGuildIds;
        m.checkNotNullExpressionValue(list, "sortedGuildIds");
        Boolean bool = this.$isPremium;
        m.checkNotNullExpressionValue(bool, "isPremium");
        boolean zBooleanValue = bool.booleanValue();
        StoreEmoji$getEmojiSet$4 storeEmoji$getEmojiSet$4 = this.this$0;
        boolean z2 = storeEmoji$getEmojiSet$4.$includeUnavailableEmojis;
        boolean z3 = storeEmoji$getEmojiSet$4.$includeUnusableEmojis;
        Boolean bool2 = this.$hasExternalEmojiPermission;
        m.checkNotNullExpressionValue(bool2, "hasExternalEmojiPermission");
        boolean zBooleanValue2 = bool2.booleanValue();
        Set set = this.$favorites;
        m.checkNotNullExpressionValue(set, "favorites");
        return StoreEmoji.access$buildUsableEmojiSet(storeEmoji, map, storeEmoji$EmojiContext, list, zBooleanValue, z3, z2, zBooleanValue2, set);
    }
}
