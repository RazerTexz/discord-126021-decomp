package com.discord.widgets.chat.input.sticker;

import com.discord.models.guild.Guild;
import com.discord.models.sticker.dto.ModelStickerPack;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StickerAdapterItems.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class HeaderType {

    /* JADX INFO: compiled from: StickerAdapterItems.kt */
    public static final /* data */ class GuildItem extends HeaderType {
        private final Guild guild;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildItem(Guild guild) {
            super(null);
            C12238m.checkNotNullParameter(guild, "guild");
            this.guild = guild;
        }

        public static /* synthetic */ GuildItem copy$default(GuildItem guildItem, Guild guild, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = guildItem.guild;
            }
            return guildItem.copy(guild);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final GuildItem copy(Guild guild) {
            C12238m.checkNotNullParameter(guild, "guild");
            return new GuildItem(guild);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildItem) && C12238m.areEqual(this.guild, ((GuildItem) other).guild);
            }
            return true;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        @Override // com.discord.widgets.chat.input.sticker.HeaderType
        public String getId() {
            return String.valueOf(this.guild.getId());
        }

        public int hashCode() {
            Guild guild = this.guild;
            if (guild != null) {
                return guild.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("GuildItem(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: StickerAdapterItems.kt */
    public static final /* data */ class PackItem extends HeaderType {
        private final ModelStickerPack pack;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PackItem(ModelStickerPack modelStickerPack) {
            super(null);
            C12238m.checkNotNullParameter(modelStickerPack, "pack");
            this.pack = modelStickerPack;
        }

        public static /* synthetic */ PackItem copy$default(PackItem packItem, ModelStickerPack modelStickerPack, int i, Object obj) {
            if ((i & 1) != 0) {
                modelStickerPack = packItem.pack;
            }
            return packItem.copy(modelStickerPack);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ModelStickerPack getPack() {
            return this.pack;
        }

        public final PackItem copy(ModelStickerPack pack) {
            C12238m.checkNotNullParameter(pack, "pack");
            return new PackItem(pack);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof PackItem) && C12238m.areEqual(this.pack, ((PackItem) other).pack);
            }
            return true;
        }

        @Override // com.discord.widgets.chat.input.sticker.HeaderType
        public String getId() {
            StringBuilder sbM833U = C1643a.m833U("owned-header:");
            sbM833U.append(this.pack.getId());
            return sbM833U.toString();
        }

        public final ModelStickerPack getPack() {
            return this.pack;
        }

        public int hashCode() {
            ModelStickerPack modelStickerPack = this.pack;
            if (modelStickerPack != null) {
                return modelStickerPack.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("PackItem(pack=");
            sbM833U.append(this.pack);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: StickerAdapterItems.kt */
    public static final class Recent extends HeaderType {
        public static final Recent INSTANCE = new Recent();

        private Recent() {
            super(null);
        }

        @Override // com.discord.widgets.chat.input.sticker.HeaderType
        public String getId() {
            return "recents";
        }
    }

    private HeaderType() {
    }

    public abstract String getId();

    public /* synthetic */ HeaderType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
