package com.discord.api.sticker;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.NoWhenBranchMatchedException;

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
        Intrinsics3.checkNotNullParameter(stickerFormatType, "formatType");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
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
        return this.id == stickerPartial.id && Intrinsics3.areEqual(this.formatType, stickerPartial.formatType) && Intrinsics3.areEqual(this.name, stickerPartial.name);
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
        StringBuilder sbU = outline.U("StickerPartial(id=");
        sbU.append(this.id);
        sbU.append(", formatType=");
        sbU.append(this.formatType);
        sbU.append(", name=");
        return outline.J(sbU, this.name, ")");
    }
}
