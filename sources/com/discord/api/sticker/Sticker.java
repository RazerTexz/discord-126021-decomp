package com.discord.api.sticker;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.io.Serializable;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: Sticker.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Sticker implements Serializable, BaseSticker {
    private final Boolean available;
    private final String description;
    private final StickerFormatType formatType;
    private final Long guildId;
    private final long id;
    private final String name;
    private final Long packId;
    private final String tags;
    private final StickerType type;

    public Sticker(long j, Long l, Long l2, String str, String str2, StickerFormatType stickerFormatType, String str3, StickerType stickerType, Boolean bool, int i) {
        int i2 = i & 256;
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        m.checkNotNullParameter(stickerFormatType, "formatType");
        m.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_TAGS);
        m.checkNotNullParameter(stickerType, "type");
        this.id = j;
        this.packId = l;
        this.guildId = l2;
        this.name = str;
        this.description = str2;
        this.formatType = stickerFormatType;
        this.tags = str3;
        this.type = stickerType;
        this.available = null;
    }

    @Override // com.discord.api.sticker.BaseSticker
    /* JADX INFO: renamed from: a, reason: from getter */
    public StickerFormatType getFormatType() {
        return this.formatType;
    }

    @Override // com.discord.api.sticker.BaseSticker
    public String b() {
        int iOrdinal = this.formatType.ordinal();
        if (iOrdinal == 0) {
            return "";
        }
        if (iOrdinal == 1 || iOrdinal == 2) {
            return ".png";
        }
        if (iOrdinal == 3) {
            return ".json";
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.discord.api.sticker.BaseSticker
    public StickerPartial c() {
        return new StickerPartial(this.id, this.formatType, this.name);
    }

    @Override // com.discord.api.sticker.BaseSticker
    /* JADX INFO: renamed from: d, reason: from getter */
    public long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final Boolean getAvailable() {
        return this.available;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Sticker)) {
            return false;
        }
        Sticker sticker = (Sticker) other;
        return this.id == sticker.id && m.areEqual(this.packId, sticker.packId) && m.areEqual(this.guildId, sticker.guildId) && m.areEqual(this.name, sticker.name) && m.areEqual(this.description, sticker.description) && m.areEqual(this.formatType, sticker.formatType) && m.areEqual(this.tags, sticker.tags) && m.areEqual(this.type, sticker.type) && m.areEqual(this.available, sticker.available);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Long l = this.packId;
        int iHashCode = (i + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.guildId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str = this.name;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        StickerFormatType stickerFormatType = this.formatType;
        int iHashCode5 = (iHashCode4 + (stickerFormatType != null ? stickerFormatType.hashCode() : 0)) * 31;
        String str3 = this.tags;
        int iHashCode6 = (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        StickerType stickerType = this.type;
        int iHashCode7 = (iHashCode6 + (stickerType != null ? stickerType.hashCode() : 0)) * 31;
        Boolean bool = this.available;
        return iHashCode7 + (bool != null ? bool.hashCode() : 0);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final Long getPackId() {
        return this.packId;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final String getTags() {
        return this.tags;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final StickerType getType() {
        return this.type;
    }

    public final boolean l() {
        StickerFormatType stickerFormatType = this.formatType;
        return stickerFormatType == StickerFormatType.APNG || stickerFormatType == StickerFormatType.LOTTIE;
    }

    public String toString() {
        StringBuilder sbU = a.U("Sticker(id=");
        sbU.append(this.id);
        sbU.append(", packId=");
        sbU.append(this.packId);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", formatType=");
        sbU.append(this.formatType);
        sbU.append(", tags=");
        sbU.append(this.tags);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", available=");
        return a.D(sbU, this.available, ")");
    }
}
