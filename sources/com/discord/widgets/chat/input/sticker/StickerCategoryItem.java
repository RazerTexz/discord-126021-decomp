package com.discord.widgets.chat.input.sticker;

import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.utilities.recycler.DiffKeyProvider;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StickerCategoryItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class StickerCategoryItem implements DiffKeyProvider {
    public static final int TYPE_GUILD = 2;
    public static final int TYPE_PACK = 1;
    public static final int TYPE_RECENT = 0;
    private final long categoryId;
    private final Pair<Integer, Integer> categoryRange;
    private final boolean isSelected;

    /* JADX INFO: compiled from: StickerCategoryItem.kt */
    public static final /* data */ class GuildItem extends StickerCategoryItem {
        private final Pair<Integer, Integer> categoryRange;
        private final Guild guild;
        private final boolean isSelected;
        private final String key;
        private final List<Sticker> stickers;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildItem(Guild guild, List<Sticker> list, Pair<Integer, Integer> pair, boolean z2) {
            super(z2, pair, guild.getId(), null);
            C12238m.checkNotNullParameter(guild, "guild");
            C12238m.checkNotNullParameter(list, "stickers");
            C12238m.checkNotNullParameter(pair, "categoryRange");
            this.guild = guild;
            this.stickers = list;
            this.categoryRange = pair;
            this.isSelected = z2;
            this.key = String.valueOf(guild.getId());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GuildItem copy$default(GuildItem guildItem, Guild guild, List list, Pair pair, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = guildItem.guild;
            }
            if ((i & 2) != 0) {
                list = guildItem.stickers;
            }
            if ((i & 4) != 0) {
                pair = guildItem.getCategoryRange();
            }
            if ((i & 8) != 0) {
                z2 = guildItem.getIsSelected();
            }
            return guildItem.copy(guild, list, pair, z2);
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

        public final GuildItem copy(Guild guild, List<Sticker> stickers, Pair<Integer, Integer> categoryRange, boolean isSelected) {
            C12238m.checkNotNullParameter(guild, "guild");
            C12238m.checkNotNullParameter(stickers, "stickers");
            C12238m.checkNotNullParameter(categoryRange, "categoryRange");
            return new GuildItem(guild, stickers, categoryRange, isSelected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildItem)) {
                return false;
            }
            GuildItem guildItem = (GuildItem) other;
            return C12238m.areEqual(this.guild, guildItem.guild) && C12238m.areEqual(this.stickers, guildItem.stickers) && C12238m.areEqual(getCategoryRange(), guildItem.getCategoryRange()) && getIsSelected() == guildItem.getIsSelected();
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
            StringBuilder sbM833U = C1643a.m833U("GuildItem(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", stickers=");
            sbM833U.append(this.stickers);
            sbM833U.append(", categoryRange=");
            sbM833U.append(getCategoryRange());
            sbM833U.append(", isSelected=");
            sbM833U.append(getIsSelected());
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: StickerCategoryItem.kt */
    public static final /* data */ class PackItem extends StickerCategoryItem {
        private final Pair<Integer, Integer> categoryRange;
        private final boolean isSelected;
        private final String key;
        private final ModelStickerPack pack;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PackItem(ModelStickerPack modelStickerPack, Pair<Integer, Integer> pair, boolean z2) {
            super(z2, pair, modelStickerPack.getId(), null);
            C12238m.checkNotNullParameter(modelStickerPack, "pack");
            C12238m.checkNotNullParameter(pair, "categoryRange");
            this.pack = modelStickerPack;
            this.categoryRange = pair;
            this.isSelected = z2;
            this.key = String.valueOf(modelStickerPack.getId());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PackItem copy$default(PackItem packItem, ModelStickerPack modelStickerPack, Pair pair, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                modelStickerPack = packItem.pack;
            }
            if ((i & 2) != 0) {
                pair = packItem.getCategoryRange();
            }
            if ((i & 4) != 0) {
                z2 = packItem.getIsSelected();
            }
            return packItem.copy(modelStickerPack, pair, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ModelStickerPack getPack() {
            return this.pack;
        }

        public final Pair<Integer, Integer> component2() {
            return getCategoryRange();
        }

        public final boolean component3() {
            return getIsSelected();
        }

        public final PackItem copy(ModelStickerPack pack, Pair<Integer, Integer> categoryRange, boolean isSelected) {
            C12238m.checkNotNullParameter(pack, "pack");
            C12238m.checkNotNullParameter(categoryRange, "categoryRange");
            return new PackItem(pack, categoryRange, isSelected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PackItem)) {
                return false;
            }
            PackItem packItem = (PackItem) other;
            return C12238m.areEqual(this.pack, packItem.pack) && C12238m.areEqual(getCategoryRange(), packItem.getCategoryRange()) && getIsSelected() == packItem.getIsSelected();
        }

        @Override // com.discord.widgets.chat.input.sticker.StickerCategoryItem
        public Pair<Integer, Integer> getCategoryRange() {
            return this.categoryRange;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final ModelStickerPack getPack() {
            return this.pack;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            ModelStickerPack modelStickerPack = this.pack;
            int iHashCode = (modelStickerPack != null ? modelStickerPack.hashCode() : 0) * 31;
            Pair<Integer, Integer> categoryRange = getCategoryRange();
            int iHashCode2 = (iHashCode + (categoryRange != null ? categoryRange.hashCode() : 0)) * 31;
            boolean isSelected = getIsSelected();
            ?? r1 = isSelected;
            if (isSelected) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        @Override // com.discord.widgets.chat.input.sticker.StickerCategoryItem
        /* JADX INFO: renamed from: isSelected, reason: from getter */
        public boolean getIsSelected() {
            return this.isSelected;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("PackItem(pack=");
            sbM833U.append(this.pack);
            sbM833U.append(", categoryRange=");
            sbM833U.append(getCategoryRange());
            sbM833U.append(", isSelected=");
            sbM833U.append(getIsSelected());
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: StickerCategoryItem.kt */
    public static final /* data */ class RecentItem extends StickerCategoryItem {
        private final Pair<Integer, Integer> categoryRange;
        private final boolean isSelected;
        private final String key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecentItem(boolean z2, Pair<Integer, Integer> pair) {
            super(z2, pair, -1L, null);
            C12238m.checkNotNullParameter(pair, "categoryRange");
            this.isSelected = z2;
            this.categoryRange = pair;
            this.key = "recent";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RecentItem copy$default(RecentItem recentItem, boolean z2, Pair pair, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = recentItem.getIsSelected();
            }
            if ((i & 2) != 0) {
                pair = recentItem.getCategoryRange();
            }
            return recentItem.copy(z2, pair);
        }

        public final boolean component1() {
            return getIsSelected();
        }

        public final Pair<Integer, Integer> component2() {
            return getCategoryRange();
        }

        public final RecentItem copy(boolean isSelected, Pair<Integer, Integer> categoryRange) {
            C12238m.checkNotNullParameter(categoryRange, "categoryRange");
            return new RecentItem(isSelected, categoryRange);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RecentItem)) {
                return false;
            }
            RecentItem recentItem = (RecentItem) other;
            return getIsSelected() == recentItem.getIsSelected() && C12238m.areEqual(getCategoryRange(), recentItem.getCategoryRange());
        }

        @Override // com.discord.widgets.chat.input.sticker.StickerCategoryItem
        public Pair<Integer, Integer> getCategoryRange() {
            return this.categoryRange;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean isSelected = getIsSelected();
            ?? r0 = isSelected;
            if (isSelected) {
                r0 = 1;
            }
            int i = r0 * 31;
            Pair<Integer, Integer> categoryRange = getCategoryRange();
            return i + (categoryRange != null ? categoryRange.hashCode() : 0);
        }

        @Override // com.discord.widgets.chat.input.sticker.StickerCategoryItem
        /* JADX INFO: renamed from: isSelected, reason: from getter */
        public boolean getIsSelected() {
            return this.isSelected;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("RecentItem(isSelected=");
            sbM833U.append(getIsSelected());
            sbM833U.append(", categoryRange=");
            sbM833U.append(getCategoryRange());
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    private StickerCategoryItem(boolean z2, Pair<Integer, Integer> pair, long j) {
        this.isSelected = z2;
        this.categoryRange = pair;
        this.categoryId = j;
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public Pair<Integer, Integer> getCategoryRange() {
        return this.categoryRange;
    }

    /* JADX INFO: renamed from: isSelected, reason: from getter */
    public boolean getIsSelected() {
        return this.isSelected;
    }

    public /* synthetic */ StickerCategoryItem(boolean z2, Pair pair, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, pair, j);
    }
}
