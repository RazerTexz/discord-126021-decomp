package com.discord.widgets.chat.input.emoji;

import b.d.b.a.a;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetEmojiAdapter$EmojiItem implements MGRecyclerDataPayload {
    private final boolean allowEmojisToAnimate;
    private final Emoji emoji;
    private final String emojiName;
    private final String guildName;
    private final String key;
    private final int type;

    public WidgetEmojiAdapter$EmojiItem(String str, Emoji emoji, String str2, boolean z2) {
        m.checkNotNullParameter(emoji, "emoji");
        m.checkNotNullParameter(str2, "emojiName");
        this.guildName = str;
        this.emoji = emoji;
        this.emojiName = str2;
        this.allowEmojisToAnimate = z2;
        this.type = 1;
        String uniqueId = emoji.getUniqueId();
        m.checkNotNullExpressionValue(uniqueId, "emoji.uniqueId");
        this.key = uniqueId;
    }

    public static /* synthetic */ WidgetEmojiAdapter$EmojiItem copy$default(WidgetEmojiAdapter$EmojiItem widgetEmojiAdapter$EmojiItem, String str, Emoji emoji, String str2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetEmojiAdapter$EmojiItem.guildName;
        }
        if ((i & 2) != 0) {
            emoji = widgetEmojiAdapter$EmojiItem.emoji;
        }
        if ((i & 4) != 0) {
            str2 = widgetEmojiAdapter$EmojiItem.emojiName;
        }
        if ((i & 8) != 0) {
            z2 = widgetEmojiAdapter$EmojiItem.allowEmojisToAnimate;
        }
        return widgetEmojiAdapter$EmojiItem.copy(str, emoji, str2, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Emoji getEmoji() {
        return this.emoji;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEmojiName() {
        return this.emojiName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getAllowEmojisToAnimate() {
        return this.allowEmojisToAnimate;
    }

    public final WidgetEmojiAdapter$EmojiItem copy(String guildName, Emoji emoji, String emojiName, boolean allowEmojisToAnimate) {
        m.checkNotNullParameter(emoji, "emoji");
        m.checkNotNullParameter(emojiName, "emojiName");
        return new WidgetEmojiAdapter$EmojiItem(guildName, emoji, emojiName, allowEmojisToAnimate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetEmojiAdapter$EmojiItem)) {
            return false;
        }
        WidgetEmojiAdapter$EmojiItem widgetEmojiAdapter$EmojiItem = (WidgetEmojiAdapter$EmojiItem) other;
        return m.areEqual(this.guildName, widgetEmojiAdapter$EmojiItem.guildName) && m.areEqual(this.emoji, widgetEmojiAdapter$EmojiItem.emoji) && m.areEqual(this.emojiName, widgetEmojiAdapter$EmojiItem.emojiName) && this.allowEmojisToAnimate == widgetEmojiAdapter$EmojiItem.allowEmojisToAnimate;
    }

    public final boolean getAllowEmojisToAnimate() {
        return this.allowEmojisToAnimate;
    }

    public final Emoji getEmoji() {
        return this.emoji;
    }

    public final String getEmojiName() {
        return this.emojiName;
    }

    public final String getGuildName() {
        return this.guildName;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.guildName;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Emoji emoji = this.emoji;
        int iHashCode2 = (iHashCode + (emoji != null ? emoji.hashCode() : 0)) * 31;
        String str2 = this.emojiName;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.allowEmojisToAnimate;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("EmojiItem(guildName=");
        sbU.append(this.guildName);
        sbU.append(", emoji=");
        sbU.append(this.emoji);
        sbU.append(", emojiName=");
        sbU.append(this.emojiName);
        sbU.append(", allowEmojisToAnimate=");
        return a.O(sbU, this.allowEmojisToAnimate, ")");
    }

    public /* synthetic */ WidgetEmojiAdapter$EmojiItem(String str, Emoji emoji, String str2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, emoji, str2, (i & 8) != 0 ? false : z2);
    }
}
