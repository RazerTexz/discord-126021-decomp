package com.discord.widgets.chat.input.emoji;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreEmoji$EmojiContext;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.Set;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EmojiPickerViewModel$StoreState$Emoji extends EmojiPickerViewModel$StoreState {
    private final LinkedHashMap<Long, Guild> allGuilds;
    private final boolean allowEmojisToAnimate;
    private final StoreEmoji$EmojiContext emojiContext;
    private final EmojiSet emojiSet;
    private final Set<Emoji> favoriteEmoji;
    private final String searchInputStringUpper;
    private final long selectedCategoryItemId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EmojiPickerViewModel$StoreState$Emoji(EmojiSet emojiSet, StoreEmoji$EmojiContext storeEmoji$EmojiContext, LinkedHashMap<Long, Guild> linkedHashMap, String str, boolean z2, long j, Set<? extends Emoji> set) {
        super(null);
        m.checkNotNullParameter(emojiSet, "emojiSet");
        m.checkNotNullParameter(storeEmoji$EmojiContext, "emojiContext");
        m.checkNotNullParameter(linkedHashMap, "allGuilds");
        m.checkNotNullParameter(str, "searchInputStringUpper");
        m.checkNotNullParameter(set, "favoriteEmoji");
        this.emojiSet = emojiSet;
        this.emojiContext = storeEmoji$EmojiContext;
        this.allGuilds = linkedHashMap;
        this.searchInputStringUpper = str;
        this.allowEmojisToAnimate = z2;
        this.selectedCategoryItemId = j;
        this.favoriteEmoji = set;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EmojiPickerViewModel$StoreState$Emoji copy$default(EmojiPickerViewModel$StoreState$Emoji emojiPickerViewModel$StoreState$Emoji, EmojiSet emojiSet, StoreEmoji$EmojiContext storeEmoji$EmojiContext, LinkedHashMap linkedHashMap, String str, boolean z2, long j, Set set, int i, Object obj) {
        return emojiPickerViewModel$StoreState$Emoji.copy((i & 1) != 0 ? emojiPickerViewModel$StoreState$Emoji.emojiSet : emojiSet, (i & 2) != 0 ? emojiPickerViewModel$StoreState$Emoji.emojiContext : storeEmoji$EmojiContext, (i & 4) != 0 ? emojiPickerViewModel$StoreState$Emoji.allGuilds : linkedHashMap, (i & 8) != 0 ? emojiPickerViewModel$StoreState$Emoji.searchInputStringUpper : str, (i & 16) != 0 ? emojiPickerViewModel$StoreState$Emoji.allowEmojisToAnimate : z2, (i & 32) != 0 ? emojiPickerViewModel$StoreState$Emoji.selectedCategoryItemId : j, (i & 64) != 0 ? emojiPickerViewModel$StoreState$Emoji.favoriteEmoji : set);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EmojiSet getEmojiSet() {
        return this.emojiSet;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StoreEmoji$EmojiContext getEmojiContext() {
        return this.emojiContext;
    }

    public final LinkedHashMap<Long, Guild> component3() {
        return this.allGuilds;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSearchInputStringUpper() {
        return this.searchInputStringUpper;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getAllowEmojisToAnimate() {
        return this.allowEmojisToAnimate;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getSelectedCategoryItemId() {
        return this.selectedCategoryItemId;
    }

    public final Set<Emoji> component7() {
        return this.favoriteEmoji;
    }

    public final EmojiPickerViewModel$StoreState$Emoji copy(EmojiSet emojiSet, StoreEmoji$EmojiContext emojiContext, LinkedHashMap<Long, Guild> allGuilds, String searchInputStringUpper, boolean allowEmojisToAnimate, long selectedCategoryItemId, Set<? extends Emoji> favoriteEmoji) {
        m.checkNotNullParameter(emojiSet, "emojiSet");
        m.checkNotNullParameter(emojiContext, "emojiContext");
        m.checkNotNullParameter(allGuilds, "allGuilds");
        m.checkNotNullParameter(searchInputStringUpper, "searchInputStringUpper");
        m.checkNotNullParameter(favoriteEmoji, "favoriteEmoji");
        return new EmojiPickerViewModel$StoreState$Emoji(emojiSet, emojiContext, allGuilds, searchInputStringUpper, allowEmojisToAnimate, selectedCategoryItemId, favoriteEmoji);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiPickerViewModel$StoreState$Emoji)) {
            return false;
        }
        EmojiPickerViewModel$StoreState$Emoji emojiPickerViewModel$StoreState$Emoji = (EmojiPickerViewModel$StoreState$Emoji) other;
        return m.areEqual(this.emojiSet, emojiPickerViewModel$StoreState$Emoji.emojiSet) && m.areEqual(this.emojiContext, emojiPickerViewModel$StoreState$Emoji.emojiContext) && m.areEqual(this.allGuilds, emojiPickerViewModel$StoreState$Emoji.allGuilds) && m.areEqual(this.searchInputStringUpper, emojiPickerViewModel$StoreState$Emoji.searchInputStringUpper) && this.allowEmojisToAnimate == emojiPickerViewModel$StoreState$Emoji.allowEmojisToAnimate && this.selectedCategoryItemId == emojiPickerViewModel$StoreState$Emoji.selectedCategoryItemId && m.areEqual(this.favoriteEmoji, emojiPickerViewModel$StoreState$Emoji.favoriteEmoji);
    }

    public final LinkedHashMap<Long, Guild> getAllGuilds() {
        return this.allGuilds;
    }

    public final boolean getAllowEmojisToAnimate() {
        return this.allowEmojisToAnimate;
    }

    public final StoreEmoji$EmojiContext getEmojiContext() {
        return this.emojiContext;
    }

    public final EmojiSet getEmojiSet() {
        return this.emojiSet;
    }

    public final Set<Emoji> getFavoriteEmoji() {
        return this.favoriteEmoji;
    }

    public final String getSearchInputStringUpper() {
        return this.searchInputStringUpper;
    }

    public final long getSelectedCategoryItemId() {
        return this.selectedCategoryItemId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v20 */
    public int hashCode() {
        EmojiSet emojiSet = this.emojiSet;
        int iHashCode = (emojiSet != null ? emojiSet.hashCode() : 0) * 31;
        StoreEmoji$EmojiContext storeEmoji$EmojiContext = this.emojiContext;
        int iHashCode2 = (iHashCode + (storeEmoji$EmojiContext != null ? storeEmoji$EmojiContext.hashCode() : 0)) * 31;
        LinkedHashMap<Long, Guild> linkedHashMap = this.allGuilds;
        int iHashCode3 = (iHashCode2 + (linkedHashMap != null ? linkedHashMap.hashCode() : 0)) * 31;
        String str = this.searchInputStringUpper;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.allowEmojisToAnimate;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int iA = (b.a(this.selectedCategoryItemId) + ((iHashCode4 + r2) * 31)) * 31;
        Set<Emoji> set = this.favoriteEmoji;
        return iA + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Emoji(emojiSet=");
        sbU.append(this.emojiSet);
        sbU.append(", emojiContext=");
        sbU.append(this.emojiContext);
        sbU.append(", allGuilds=");
        sbU.append(this.allGuilds);
        sbU.append(", searchInputStringUpper=");
        sbU.append(this.searchInputStringUpper);
        sbU.append(", allowEmojisToAnimate=");
        sbU.append(this.allowEmojisToAnimate);
        sbU.append(", selectedCategoryItemId=");
        sbU.append(this.selectedCategoryItemId);
        sbU.append(", favoriteEmoji=");
        return a.N(sbU, this.favoriteEmoji, ")");
    }
}
