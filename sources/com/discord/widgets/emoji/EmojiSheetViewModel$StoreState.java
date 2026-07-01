package com.discord.widgets.emoji;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreMediaFavorites$Favorite;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType;
import d0.z.d.m;
import java.util.Set;

/* JADX INFO: compiled from: EmojiSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EmojiSheetViewModel$StoreState {
    private final Channel currentChannel;
    private final EmojiSheetViewModel$Companion$CustomEmojGuildInfo customEmojiGuildInfo;
    private final EmojiNode$EmojiIdAndType emoji;
    private final Set<StoreMediaFavorites$Favorite> favorites;
    private final Set<Long> joinedGuildIds;
    private final boolean meUserIsPremium;

    /* JADX WARN: Multi-variable type inference failed */
    public EmojiSheetViewModel$StoreState(EmojiSheetViewModel$Companion$CustomEmojGuildInfo emojiSheetViewModel$Companion$CustomEmojGuildInfo, EmojiNode$EmojiIdAndType emojiNode$EmojiIdAndType, boolean z2, Set<Long> set, Channel channel, Set<? extends StoreMediaFavorites$Favorite> set2) {
        m.checkNotNullParameter(emojiNode$EmojiIdAndType, "emoji");
        m.checkNotNullParameter(set, "joinedGuildIds");
        m.checkNotNullParameter(set2, "favorites");
        this.customEmojiGuildInfo = emojiSheetViewModel$Companion$CustomEmojGuildInfo;
        this.emoji = emojiNode$EmojiIdAndType;
        this.meUserIsPremium = z2;
        this.joinedGuildIds = set;
        this.currentChannel = channel;
        this.favorites = set2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EmojiSheetViewModel$StoreState copy$default(EmojiSheetViewModel$StoreState emojiSheetViewModel$StoreState, EmojiSheetViewModel$Companion$CustomEmojGuildInfo emojiSheetViewModel$Companion$CustomEmojGuildInfo, EmojiNode$EmojiIdAndType emojiNode$EmojiIdAndType, boolean z2, Set set, Channel channel, Set set2, int i, Object obj) {
        if ((i & 1) != 0) {
            emojiSheetViewModel$Companion$CustomEmojGuildInfo = emojiSheetViewModel$StoreState.customEmojiGuildInfo;
        }
        if ((i & 2) != 0) {
            emojiNode$EmojiIdAndType = emojiSheetViewModel$StoreState.emoji;
        }
        EmojiNode$EmojiIdAndType emojiNode$EmojiIdAndType2 = emojiNode$EmojiIdAndType;
        if ((i & 4) != 0) {
            z2 = emojiSheetViewModel$StoreState.meUserIsPremium;
        }
        boolean z3 = z2;
        if ((i & 8) != 0) {
            set = emojiSheetViewModel$StoreState.joinedGuildIds;
        }
        Set set3 = set;
        if ((i & 16) != 0) {
            channel = emojiSheetViewModel$StoreState.currentChannel;
        }
        Channel channel2 = channel;
        if ((i & 32) != 0) {
            set2 = emojiSheetViewModel$StoreState.favorites;
        }
        return emojiSheetViewModel$StoreState.copy(emojiSheetViewModel$Companion$CustomEmojGuildInfo, emojiNode$EmojiIdAndType2, z3, set3, channel2, set2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EmojiSheetViewModel$Companion$CustomEmojGuildInfo getCustomEmojiGuildInfo() {
        return this.customEmojiGuildInfo;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final EmojiNode$EmojiIdAndType getEmoji() {
        return this.emoji;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getMeUserIsPremium() {
        return this.meUserIsPremium;
    }

    public final Set<Long> component4() {
        return this.joinedGuildIds;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Channel getCurrentChannel() {
        return this.currentChannel;
    }

    public final Set<StoreMediaFavorites$Favorite> component6() {
        return this.favorites;
    }

    public final EmojiSheetViewModel$StoreState copy(EmojiSheetViewModel$Companion$CustomEmojGuildInfo customEmojiGuildInfo, EmojiNode$EmojiIdAndType emoji, boolean meUserIsPremium, Set<Long> joinedGuildIds, Channel currentChannel, Set<? extends StoreMediaFavorites$Favorite> favorites) {
        m.checkNotNullParameter(emoji, "emoji");
        m.checkNotNullParameter(joinedGuildIds, "joinedGuildIds");
        m.checkNotNullParameter(favorites, "favorites");
        return new EmojiSheetViewModel$StoreState(customEmojiGuildInfo, emoji, meUserIsPremium, joinedGuildIds, currentChannel, favorites);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiSheetViewModel$StoreState)) {
            return false;
        }
        EmojiSheetViewModel$StoreState emojiSheetViewModel$StoreState = (EmojiSheetViewModel$StoreState) other;
        return m.areEqual(this.customEmojiGuildInfo, emojiSheetViewModel$StoreState.customEmojiGuildInfo) && m.areEqual(this.emoji, emojiSheetViewModel$StoreState.emoji) && this.meUserIsPremium == emojiSheetViewModel$StoreState.meUserIsPremium && m.areEqual(this.joinedGuildIds, emojiSheetViewModel$StoreState.joinedGuildIds) && m.areEqual(this.currentChannel, emojiSheetViewModel$StoreState.currentChannel) && m.areEqual(this.favorites, emojiSheetViewModel$StoreState.favorites);
    }

    public final Channel getCurrentChannel() {
        return this.currentChannel;
    }

    public final EmojiSheetViewModel$Companion$CustomEmojGuildInfo getCustomEmojiGuildInfo() {
        return this.customEmojiGuildInfo;
    }

    public final EmojiNode$EmojiIdAndType getEmoji() {
        return this.emoji;
    }

    public final Set<StoreMediaFavorites$Favorite> getFavorites() {
        return this.favorites;
    }

    public final Set<Long> getJoinedGuildIds() {
        return this.joinedGuildIds;
    }

    public final boolean getMeUserIsPremium() {
        return this.meUserIsPremium;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    public int hashCode() {
        EmojiSheetViewModel$Companion$CustomEmojGuildInfo emojiSheetViewModel$Companion$CustomEmojGuildInfo = this.customEmojiGuildInfo;
        int iHashCode = (emojiSheetViewModel$Companion$CustomEmojGuildInfo != null ? emojiSheetViewModel$Companion$CustomEmojGuildInfo.hashCode() : 0) * 31;
        EmojiNode$EmojiIdAndType emojiNode$EmojiIdAndType = this.emoji;
        int iHashCode2 = (iHashCode + (emojiNode$EmojiIdAndType != null ? emojiNode$EmojiIdAndType.hashCode() : 0)) * 31;
        boolean z2 = this.meUserIsPremium;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode2 + r2) * 31;
        Set<Long> set = this.joinedGuildIds;
        int iHashCode3 = (i + (set != null ? set.hashCode() : 0)) * 31;
        Channel channel = this.currentChannel;
        int iHashCode4 = (iHashCode3 + (channel != null ? channel.hashCode() : 0)) * 31;
        Set<StoreMediaFavorites$Favorite> set2 = this.favorites;
        return iHashCode4 + (set2 != null ? set2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(customEmojiGuildInfo=");
        sbU.append(this.customEmojiGuildInfo);
        sbU.append(", emoji=");
        sbU.append(this.emoji);
        sbU.append(", meUserIsPremium=");
        sbU.append(this.meUserIsPremium);
        sbU.append(", joinedGuildIds=");
        sbU.append(this.joinedGuildIds);
        sbU.append(", currentChannel=");
        sbU.append(this.currentChannel);
        sbU.append(", favorites=");
        return a.N(sbU, this.favorites, ")");
    }
}
