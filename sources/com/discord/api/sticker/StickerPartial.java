package com.discord.api.sticker;

import com.discord.models.domain.ModelAuditLogEntry;
import java.io.Serializable;
import kotlin.NoWhenBranchMatchedException;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StickerPartial.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class StickerPartial implements Serializable, BaseSticker {
    private final StickerFormatType formatType;
    private final long id;
    private final String name;

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

    public StickerPartial(long j, StickerFormatType stickerFormatType, String str) {
        C12238m.checkNotNullParameter(stickerFormatType, "formatType");
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.id = j;
        this.formatType = stickerFormatType;
        this.name = str;
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
        return this;
    }

    @Override // com.discord.api.sticker.BaseSticker
    /* JADX INFO: renamed from: d, reason: from getter */
    public long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerPartial)) {
            return false;
        }
        StickerPartial stickerPartial = (StickerPartial) other;
        return this.id == stickerPartial.id && C12238m.areEqual(this.formatType, stickerPartial.formatType) && C12238m.areEqual(this.name, stickerPartial.name);
    }

    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        StickerFormatType stickerFormatType = this.formatType;
        int iHashCode = (i + (stickerFormatType != null ? stickerFormatType.hashCode() : 0)) * 31;
        String str = this.name;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("StickerPartial(id=");
        sbM833U.append(this.id);
        sbM833U.append(", formatType=");
        sbM833U.append(this.formatType);
        sbM833U.append(", name=");
        return C1643a.m822J(sbM833U, this.name, ")");
    }
}
