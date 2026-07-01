package com.discord.widgets.chat.input.sticker;

import b.d.b.a.outline;
import com.discord.models.guild.Guild;
import com.discord.models.sticker.dto.ModelStickerPack;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.HeaderType, reason: use source file name */
/* JADX INFO: compiled from: StickerAdapterItems.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class StickerAdapterItems2 {

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.HeaderType$GuildItem */
    /* JADX INFO: compiled from: StickerAdapterItems.kt */
    public static final /* data */ class GuildItem extends StickerAdapterItems2 {
        private final Guild guild;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildItem(Guild guild) {
            super(null);
            Intrinsics3.checkNotNullParameter(guild, "guild");
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
            Intrinsics3.checkNotNullParameter(guild, "guild");
            return new GuildItem(guild);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildItem) && Intrinsics3.areEqual(this.guild, ((GuildItem) other).guild);
            }
            return true;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        @Override // com.discord.widgets.chat.input.sticker.StickerAdapterItems2
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
            StringBuilder sbU = outline.U("GuildItem(guild=");
            sbU.append(this.guild);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.HeaderType$PackItem */
    /* JADX INFO: compiled from: StickerAdapterItems.kt */
    public static final /* data */ class PackItem extends StickerAdapterItems2 {
        private final ModelStickerPack pack;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PackItem(ModelStickerPack modelStickerPack) {
            super(null);
            Intrinsics3.checkNotNullParameter(modelStickerPack, "pack");
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
            Intrinsics3.checkNotNullParameter(pack, "pack");
            return new PackItem(pack);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof PackItem) && Intrinsics3.areEqual(this.pack, ((PackItem) other).pack);
            }
            return true;
        }

        @Override // com.discord.widgets.chat.input.sticker.StickerAdapterItems2
        public String getId() {
            StringBuilder sbU = outline.U("owned-header:");
            sbU.append(this.pack.getId());
            return sbU.toString();
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
            StringBuilder sbU = outline.U("PackItem(pack=");
            sbU.append(this.pack);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.HeaderType$Recent */
    /* JADX INFO: compiled from: StickerAdapterItems.kt */
    public static final class Recent extends StickerAdapterItems2 {
        public static final Recent INSTANCE = new Recent();

        private Recent() {
            super(null);
        }

        @Override // com.discord.widgets.chat.input.sticker.StickerAdapterItems2
        public String getId() {
            return "recents";
        }
    }

    private StickerAdapterItems2() {
    }

    public abstract String getId();

    public /* synthetic */ StickerAdapterItems2(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
