package com.discord.widgets.chat.input.emoji;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import kotlin.Pair;

/* JADX INFO: compiled from: EmojiCategoryItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EmojiCategoryItem$GuildItem extends EmojiCategoryItem {
    private final Pair<Integer, Integer> categoryRange;
    private final Guild guild;
    private final boolean isSelected;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiCategoryItem$GuildItem(Guild guild, Pair<Integer, Integer> pair, boolean z2) {
        super(EmojiCategoryItem.Companion.mapGuildToItemId(guild), pair, z2, null);
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(pair, "categoryRange");
        this.guild = guild;
        this.categoryRange = pair;
        this.isSelected = z2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EmojiCategoryItem$GuildItem copy$default(EmojiCategoryItem$GuildItem emojiCategoryItem$GuildItem, Guild guild, Pair pair, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = emojiCategoryItem$GuildItem.guild;
        }
        if ((i & 2) != 0) {
            pair = emojiCategoryItem$GuildItem.getCategoryRange();
        }
        if ((i & 4) != 0) {
            z2 = emojiCategoryItem$GuildItem.getIsSelected();
        }
        return emojiCategoryItem$GuildItem.copy(guild, pair, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final Pair<Integer, Integer> component2() {
        return getCategoryRange();
    }

    public final boolean component3() {
        return getIsSelected();
    }

    public final EmojiCategoryItem$GuildItem copy(Guild guild, Pair<Integer, Integer> categoryRange, boolean isSelected) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(categoryRange, "categoryRange");
        return new EmojiCategoryItem$GuildItem(guild, categoryRange, isSelected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiCategoryItem$GuildItem)) {
            return false;
        }
        EmojiCategoryItem$GuildItem emojiCategoryItem$GuildItem = (EmojiCategoryItem$GuildItem) other;
        return m.areEqual(this.guild, emojiCategoryItem$GuildItem.guild) && m.areEqual(getCategoryRange(), emojiCategoryItem$GuildItem.getCategoryRange()) && getIsSelected() == emojiCategoryItem$GuildItem.getIsSelected();
    }

    @Override // com.discord.widgets.chat.input.emoji.EmojiCategoryItem
    public Pair<Integer, Integer> getCategoryRange() {
        return this.categoryRange;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        Pair<Integer, Integer> categoryRange = getCategoryRange();
        int iHashCode2 = (iHashCode + (categoryRange != null ? categoryRange.hashCode() : 0)) * 31;
        boolean isSelected = getIsSelected();
        ?? r1 = isSelected;
        if (isSelected) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    @Override // com.discord.widgets.chat.input.emoji.EmojiCategoryItem
    /* JADX INFO: renamed from: isSelected, reason: from getter */
    public boolean getIsSelected() {
        return this.isSelected;
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildItem(guild=");
        sbU.append(this.guild);
        sbU.append(", categoryRange=");
        sbU.append(getCategoryRange());
        sbU.append(", isSelected=");
        sbU.append(getIsSelected());
        sbU.append(")");
        return sbU.toString();
    }
}
