package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreMediaFavorites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreMediaFavorites$Favorite$FavUnicodeEmoji extends StoreMediaFavorites$Favorite implements StoreMediaFavorites$FavoriteEmoji {
    private final String emojiUniqueId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMediaFavorites$Favorite$FavUnicodeEmoji(String str) {
        super(null);
        m.checkNotNullParameter(str, "emojiUniqueId");
        this.emojiUniqueId = str;
    }

    public static /* synthetic */ StoreMediaFavorites$Favorite$FavUnicodeEmoji copy$default(StoreMediaFavorites$Favorite$FavUnicodeEmoji storeMediaFavorites$Favorite$FavUnicodeEmoji, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = storeMediaFavorites$Favorite$FavUnicodeEmoji.getEmojiUniqueId();
        }
        return storeMediaFavorites$Favorite$FavUnicodeEmoji.copy(str);
    }

    public final String component1() {
        return getEmojiUniqueId();
    }

    public final StoreMediaFavorites$Favorite$FavUnicodeEmoji copy(String emojiUniqueId) {
        m.checkNotNullParameter(emojiUniqueId, "emojiUniqueId");
        return new StoreMediaFavorites$Favorite$FavUnicodeEmoji(emojiUniqueId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreMediaFavorites$Favorite$FavUnicodeEmoji) && m.areEqual(getEmojiUniqueId(), ((StoreMediaFavorites$Favorite$FavUnicodeEmoji) other).getEmojiUniqueId());
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
        StringBuilder sbU = a.U("FavUnicodeEmoji(emojiUniqueId=");
        sbU.append(getEmojiUniqueId());
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public StoreMediaFavorites$Favorite$FavUnicodeEmoji(ModelEmojiUnicode modelEmojiUnicode) {
        m.checkNotNullParameter(modelEmojiUnicode, "unicode");
        String uniqueId = modelEmojiUnicode.getUniqueId();
        m.checkNotNullExpressionValue(uniqueId, "unicode.uniqueId");
        this(uniqueId);
    }
}
