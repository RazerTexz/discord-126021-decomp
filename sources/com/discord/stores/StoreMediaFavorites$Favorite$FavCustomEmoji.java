package com.discord.stores;

import b.d.b.a.a;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType$Custom;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreMediaFavorites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreMediaFavorites$Favorite$FavCustomEmoji extends StoreMediaFavorites$Favorite implements StoreMediaFavorites$FavoriteEmoji {
    private final String emojiUniqueId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMediaFavorites$Favorite$FavCustomEmoji(String str) {
        super(null);
        m.checkNotNullParameter(str, "emojiUniqueId");
        this.emojiUniqueId = str;
    }

    public static /* synthetic */ StoreMediaFavorites$Favorite$FavCustomEmoji copy$default(StoreMediaFavorites$Favorite$FavCustomEmoji storeMediaFavorites$Favorite$FavCustomEmoji, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = storeMediaFavorites$Favorite$FavCustomEmoji.getEmojiUniqueId();
        }
        return storeMediaFavorites$Favorite$FavCustomEmoji.copy(str);
    }

    public final String component1() {
        return getEmojiUniqueId();
    }

    public final StoreMediaFavorites$Favorite$FavCustomEmoji copy(String emojiUniqueId) {
        m.checkNotNullParameter(emojiUniqueId, "emojiUniqueId");
        return new StoreMediaFavorites$Favorite$FavCustomEmoji(emojiUniqueId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreMediaFavorites$Favorite$FavCustomEmoji) && m.areEqual(getEmojiUniqueId(), ((StoreMediaFavorites$Favorite$FavCustomEmoji) other).getEmojiUniqueId());
        }
        return true;
    }

    @Override // com.discord.stores.StoreMediaFavorites$FavoriteEmoji
    public String getEmojiUniqueId() {
        return this.emojiUniqueId;
    }

    public int hashCode() {
        String emojiUniqueId = getEmojiUniqueId();
        if (emojiUniqueId != null) {
            return emojiUniqueId.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("FavCustomEmoji(emojiUniqueId=");
        sbU.append(getEmojiUniqueId());
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StoreMediaFavorites$Favorite$FavCustomEmoji(EmojiNode$EmojiIdAndType$Custom emojiNode$EmojiIdAndType$Custom) {
        this(String.valueOf(emojiNode$EmojiIdAndType$Custom.getId()));
        m.checkNotNullParameter(emojiNode$EmojiIdAndType$Custom, "custom");
    }
}
