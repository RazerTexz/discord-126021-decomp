package com.discord.widgets.chat.input.sticker;

import b.d.b.a.a;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: compiled from: StickerCategoryItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StickerCategoryItem$GuildItem extends StickerCategoryItem {
    private final Pair<Integer, Integer> categoryRange;
    private final Guild guild;
    private final boolean isSelected;
    private final String key;
    private final List<Sticker> stickers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerCategoryItem$GuildItem(Guild guild, List<Sticker> list, Pair<Integer, Integer> pair, boolean z2) {
        super(z2, pair, guild.getId(), null);
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(list, "stickers");
        m.checkNotNullParameter(pair, "categoryRange");
        this.guild = guild;
        this.stickers = list;
        this.categoryRange = pair;
        this.isSelected = z2;
        this.key = String.valueOf(guild.getId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StickerCategoryItem$GuildItem copy$default(StickerCategoryItem$GuildItem stickerCategoryItem$GuildItem, Guild guild, List list, Pair pair, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = stickerCategoryItem$GuildItem.guild;
        }
        if ((i & 2) != 0) {
            list = stickerCategoryItem$GuildItem.stickers;
        }
        if ((i & 4) != 0) {
            pair = stickerCategoryItem$GuildItem.getCategoryRange();
        }
        if ((i & 8) != 0) {
            z2 = stickerCategoryItem$GuildItem.getIsSelected();
        }
        return stickerCategoryItem$GuildItem.copy(guild, list, pair, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final List<Sticker> component2() {
        return this.stickers;
    }

    public final Pair<Integer, Integer> component3() {
        return getCategoryRange();
    }

    public final boolean component4() {
        return getIsSelected();
    }

    public final StickerCategoryItem$GuildItem copy(Guild guild, List<Sticker> stickers, Pair<Integer, Integer> categoryRange, boolean isSelected) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(stickers, "stickers");
        m.checkNotNullParameter(categoryRange, "categoryRange");
        return new StickerCategoryItem$GuildItem(guild, stickers, categoryRange, isSelected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerCategoryItem$GuildItem)) {
            return false;
        }
        StickerCategoryItem$GuildItem stickerCategoryItem$GuildItem = (StickerCategoryItem$GuildItem) other;
        return m.areEqual(this.guild, stickerCategoryItem$GuildItem.guild) && m.areEqual(this.stickers, stickerCategoryItem$GuildItem.stickers) && m.areEqual(getCategoryRange(), stickerCategoryItem$GuildItem.getCategoryRange()) && getIsSelected() == stickerCategoryItem$GuildItem.getIsSelected();
    }

    @Override // com.discord.widgets.chat.input.sticker.StickerCategoryItem
    public Pair<Integer, Integer> getCategoryRange() {
        return this.categoryRange;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final List<Sticker> getStickers() {
        return this.stickers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        List<Sticker> list = this.stickers;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        Pair<Integer, Integer> categoryRange = getCategoryRange();
        int iHashCode3 = (iHashCode2 + (categoryRange != null ? categoryRange.hashCode() : 0)) * 31;
        boolean isSelected = getIsSelected();
        ?? r1 = isSelected;
        if (isSelected) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    @Override // com.discord.widgets.chat.input.sticker.StickerCategoryItem
    /* JADX INFO: renamed from: isSelected, reason: from getter */
    public boolean getIsSelected() {
        return this.isSelected;
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildItem(guild=");
        sbU.append(this.guild);
        sbU.append(", stickers=");
        sbU.append(this.stickers);
        sbU.append(", categoryRange=");
        sbU.append(getCategoryRange());
        sbU.append(", isSelected=");
        sbU.append(getIsSelected());
        sbU.append(")");
        return sbU.toString();
    }
}
