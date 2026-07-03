package com.discord.api.sticker;

import com.discord.models.domain.ModelAuditLogEntry;
import java.io.Serializable;
import kotlin.NoWhenBranchMatchedException;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StickerFormatType.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[StickerFormatType.UNKNOWN.ordinal()] = 1;
            iArr[StickerFormatType.PNG.ordinal()] = 2;
            iArr[StickerFormatType.APNG.ordinal()] = 3;
            iArr[StickerFormatType.LOTTIE.ordinal()] = 4;
        }
    }

    public Sticker(long j, Long l, Long l2, String str, String str2, StickerFormatType stickerFormatType, String str3, StickerType stickerType, Boolean bool, int i) {
        int i2 = i & 256;
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        C12238m.checkNotNullParameter(stickerFormatType, "formatType");
        C12238m.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_TAGS);
        C12238m.checkNotNullParameter(stickerType, "type");
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
    /* JADX INFO: renamed from: b */
    public String mo8228b() {
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
    /* JADX INFO: renamed from: c */
    public StickerPartial mo8229c() {
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
        return this.id == sticker.id && C12238m.areEqual(this.packId, sticker.packId) && C12238m.areEqual(this.guildId, sticker.guildId) && C12238m.areEqual(this.name, sticker.name) && C12238m.areEqual(this.description, sticker.description) && C12238m.areEqual(this.formatType, sticker.formatType) && C12238m.areEqual(this.tags, sticker.tags) && C12238m.areEqual(this.type, sticker.type) && C12238m.areEqual(this.available, sticker.available);
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

    /* JADX INFO: renamed from: l */
    public final boolean m8241l() {
        StickerFormatType stickerFormatType = this.formatType;
        return stickerFormatType == StickerFormatType.APNG || stickerFormatType == StickerFormatType.LOTTIE;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Sticker(id=");
        sbM833U.append(this.id);
        sbM833U.append(", packId=");
        sbM833U.append(this.packId);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", formatType=");
        sbM833U.append(this.formatType);
        sbM833U.append(", tags=");
        sbM833U.append(this.tags);
        sbM833U.append(", type=");
        sbM833U.append(this.type);
        sbM833U.append(", available=");
        return C1643a.m816D(sbM833U, this.available, ")");
    }
}
