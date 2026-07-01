package com.discord.models.domain.emoji;

import b.d.b.a.a;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class EmojiSet {
    public final Map<Long, List<Emoji>> customEmojis;
    public final Map<String, Emoji> emojiIndex;
    public final Set<Emoji> favoriteEmoji;
    public final List<Emoji> recentEmojis;
    public final Map<EmojiCategory, List<Emoji>> unicodeEmojis;

    public EmojiSet(Map<EmojiCategory, List<Emoji>> map, Map<Long, List<Emoji>> map2, Map<String, Emoji> map3, List<Emoji> list, Set<Emoji> set) {
        this.unicodeEmojis = map;
        this.customEmojis = map2;
        this.emojiIndex = map3;
        this.recentEmojis = list;
        this.favoriteEmoji = set;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof EmojiSet;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EmojiSet)) {
            return false;
        }
        EmojiSet emojiSet = (EmojiSet) obj;
        if (!emojiSet.canEqual(this)) {
            return false;
        }
        Map<EmojiCategory, List<Emoji>> map = this.unicodeEmojis;
        Map<EmojiCategory, List<Emoji>> map2 = emojiSet.unicodeEmojis;
        if (map != null ? !map.equals(map2) : map2 != null) {
            return false;
        }
        Map<Long, List<Emoji>> map3 = this.customEmojis;
        Map<Long, List<Emoji>> map4 = emojiSet.customEmojis;
        if (map3 != null ? !map3.equals(map4) : map4 != null) {
            return false;
        }
        Map<String, Emoji> map5 = this.emojiIndex;
        Map<String, Emoji> map6 = emojiSet.emojiIndex;
        if (map5 != null ? !map5.equals(map6) : map6 != null) {
            return false;
        }
        List<Emoji> list = this.recentEmojis;
        List<Emoji> list2 = emojiSet.recentEmojis;
        if (list != null ? !list.equals(list2) : list2 != null) {
            return false;
        }
        Set<Emoji> set = this.favoriteEmoji;
        Set<Emoji> set2 = emojiSet.favoriteEmoji;
        return set != null ? set.equals(set2) : set2 == null;
    }

    public int hashCode() {
        Map<EmojiCategory, List<Emoji>> map = this.unicodeEmojis;
        int iHashCode = map == null ? 43 : map.hashCode();
        Map<Long, List<Emoji>> map2 = this.customEmojis;
        int iHashCode2 = ((iHashCode + 59) * 59) + (map2 == null ? 43 : map2.hashCode());
        Map<String, Emoji> map3 = this.emojiIndex;
        int iHashCode3 = (iHashCode2 * 59) + (map3 == null ? 43 : map3.hashCode());
        List<Emoji> list = this.recentEmojis;
        int iHashCode4 = (iHashCode3 * 59) + (list == null ? 43 : list.hashCode());
        Set<Emoji> set = this.favoriteEmoji;
        return (iHashCode4 * 59) + (set != null ? set.hashCode() : 43);
    }

    public String toString() {
        StringBuilder sbU = a.U("EmojiSet(unicodeEmojis=");
        sbU.append(this.unicodeEmojis);
        sbU.append(", customEmojis=");
        sbU.append(this.customEmojis);
        sbU.append(", emojiIndex=");
        sbU.append(this.emojiIndex);
        sbU.append(", recentEmojis=");
        sbU.append(this.recentEmojis);
        sbU.append(", favoriteEmoji=");
        return a.N(sbU, this.favoriteEmoji, ")");
    }
}
