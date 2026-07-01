package com.discord.widgets.chat.input.sticker;

import b.d.b.a.outline;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.utilities.recycler.DiffKeyProvider;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Tuples2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StickerCategoryItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class StickerCategoryItem implements DiffKeyProvider {
    public static final int TYPE_GUILD = 2;
    public static final int TYPE_PACK = 1;
    public static final int TYPE_RECENT = 0;
    private final long categoryId;
    private final Tuples2<Integer, Integer> categoryRange;
    private final boolean isSelected;

    /* JADX INFO: compiled from: StickerCategoryItem.kt */
    public static final /* data */ class GuildItem extends StickerCategoryItem {
        private final Tuples2<Integer, Integer> categoryRange;
        private final Guild guild;
        private final boolean isSelected;
        private final String key;
        private final List<Sticker> stickers;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildItem(Guild guild, List<Sticker> list, Tuples2<Integer, Integer> tuples2, boolean z2) {
            super(z2, tuples2, guild.getId(), null);
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(list, "stickers");
            Intrinsics3.checkNotNullParameter(tuples2, "categoryRange");
            this.guild = guild;
            this.stickers = list;
            this.categoryRange = tuples2;
            this.isSelected = z2;
            this.key = String.valueOf(guild.getId());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GuildItem copy$default(GuildItem guildItem, Guild guild, List list, Tuples2 tuples2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = guildItem.guild;
            }
            if ((i & 2) != 0) {
                list = guildItem.stickers;
            }
            if ((i & 4) != 0) {
                tuples2 = guildItem.getCategoryRange();
            }
            if ((i & 8) != 0) {
                z2 = guildItem.getIsSelected();
            }
            return guildItem.copy(guild, list, tuples2, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final List<Sticker> component2() {
            return this.stickers;
        }

        public final Tuples2<Integer, Integer> component3() {
            return getCategoryRange();
        }

        public final boolean component4() {
            return getIsSelected();
        }

        public final GuildItem copy(Guild guild, List<Sticker> stickers, Tuples2<Integer, Integer> categoryRange, boolean isSelected) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(stickers, "stickers");
            Intrinsics3.checkNotNullParameter(categoryRange, "categoryRange");
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
            return Intrinsics3.areEqual(this.guild, guildItem.guild) && Intrinsics3.areEqual(this.stickers, guildItem.stickers) && Intrinsics3.areEqual(getCategoryRange(), guildItem.getCategoryRange()) && getIsSelected() == guildItem.getIsSelected();
        }

        @Override // com.discord.widgets.chat.input.sticker.StickerCategoryItem
        public Tuples2<Integer, Integer> getCategoryRange() {
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
            Tuples2<Integer, Integer> categoryRange = getCategoryRange();
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
            StringBuilder sbU = outline.U("GuildItem(guild=");
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

    /* JADX INFO: compiled from: StickerCategoryItem.kt */
    public static final /* data */ class PackItem extends StickerCategoryItem {
        private final Tuples2<Integer, Integer> categoryRange;
        private final boolean isSelected;
        private final String key;
        private final ModelStickerPack pack;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PackItem(ModelStickerPack modelStickerPack, Tuples2<Integer, Integer> tuples2, boolean z2) {
            super(z2, tuples2, modelStickerPack.getId(), null);
            Intrinsics3.checkNotNullParameter(modelStickerPack, "pack");
            Intrinsics3.checkNotNullParameter(tuples2, "categoryRange");
            this.pack = modelStickerPack;
            this.categoryRange = tuples2;
            this.isSelected = z2;
            this.key = String.valueOf(modelStickerPack.getId());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PackItem copy$default(PackItem packItem, ModelStickerPack modelStickerPack, Tuples2 tuples2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                modelStickerPack = packItem.pack;
            }
            if ((i & 2) != 0) {
                tuples2 = packItem.getCategoryRange();
            }
            if ((i & 4) != 0) {
                z2 = packItem.getIsSelected();
            }
            return packItem.copy(modelStickerPack, tuples2, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ModelStickerPack getPack() {
            return this.pack;
        }

        public final Tuples2<Integer, Integer> component2() {
            return getCategoryRange();
        }

        public final boolean component3() {
            return getIsSelected();
        }

        public final PackItem copy(ModelStickerPack pack, Tuples2<Integer, Integer> categoryRange, boolean isSelected) {
            Intrinsics3.checkNotNullParameter(pack, "pack");
            Intrinsics3.checkNotNullParameter(categoryRange, "categoryRange");
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
            return Intrinsics3.areEqual(this.pack, packItem.pack) && Intrinsics3.areEqual(getCategoryRange(), packItem.getCategoryRange()) && getIsSelected() == packItem.getIsSelected();
        }

        @Override // com.discord.widgets.chat.input.sticker.StickerCategoryItem
        public Tuples2<Integer, Integer> getCategoryRange() {
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
            Tuples2<Integer, Integer> categoryRange = getCategoryRange();
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
            StringBuilder sbU = outline.U("PackItem(pack=");
            sbU.append(this.pack);
            sbU.append(", categoryRange=");
            sbU.append(getCategoryRange());
            sbU.append(", isSelected=");
            sbU.append(getIsSelected());
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: StickerCategoryItem.kt */
    public static final /* data */ class RecentItem extends StickerCategoryItem {
        private final Tuples2<Integer, Integer> categoryRange;
        private final boolean isSelected;
        private final String key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecentItem(boolean z2, Tuples2<Integer, Integer> tuples2) {
            super(z2, tuples2, -1L, null);
            Intrinsics3.checkNotNullParameter(tuples2, "categoryRange");
            this.isSelected = z2;
            this.categoryRange = tuples2;
            this.key = "recent";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RecentItem copy$default(RecentItem recentItem, boolean z2, Tuples2 tuples2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = recentItem.getIsSelected();
            }
            if ((i & 2) != 0) {
                tuples2 = recentItem.getCategoryRange();
            }
            return recentItem.copy(z2, tuples2);
        }

        public final boolean component1() {
            return getIsSelected();
        }

        public final Tuples2<Integer, Integer> component2() {
            return getCategoryRange();
        }

        public final RecentItem copy(boolean isSelected, Tuples2<Integer, Integer> categoryRange) {
            Intrinsics3.checkNotNullParameter(categoryRange, "categoryRange");
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
            return getIsSelected() == recentItem.getIsSelected() && Intrinsics3.areEqual(getCategoryRange(), recentItem.getCategoryRange());
        }

        @Override // com.discord.widgets.chat.input.sticker.StickerCategoryItem
        public Tuples2<Integer, Integer> getCategoryRange() {
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
            Tuples2<Integer, Integer> categoryRange = getCategoryRange();
            return i + (categoryRange != null ? categoryRange.hashCode() : 0);
        }

        @Override // com.discord.widgets.chat.input.sticker.StickerCategoryItem
        /* JADX INFO: renamed from: isSelected, reason: from getter */
        public boolean getIsSelected() {
            return this.isSelected;
        }

        public String toString() {
            StringBuilder sbU = outline.U("RecentItem(isSelected=");
            sbU.append(getIsSelected());
            sbU.append(", categoryRange=");
            sbU.append(getCategoryRange());
            sbU.append(")");
            return sbU.toString();
        }
    }

    private StickerCategoryItem(boolean z2, Tuples2<Integer, Integer> tuples2, long j) {
        this.isSelected = z2;
        this.categoryRange = tuples2;
        this.categoryId = j;
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public Tuples2<Integer, Integer> getCategoryRange() {
        return this.categoryRange;
    }

    /* JADX INFO: renamed from: isSelected, reason: from getter */
    public boolean getIsSelected() {
        return this.isSelected;
    }

    public /* synthetic */ StickerCategoryItem(boolean z2, Tuples2 tuples2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, tuples2, j);
    }
}
