package com.discord.widgets.chat.input.sticker;

import b.d.b.a.a;
import com.discord.api.sticker.Sticker;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: StickerPackStoreSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StickerPackStoreSheetAnalytics {
    private final String location;
    private final String section;
    private final Sticker sticker;
    private final StickerPackStoreSheetViewType type;

    public StickerPackStoreSheetAnalytics(Sticker sticker, StickerPackStoreSheetViewType stickerPackStoreSheetViewType, String str, String str2) {
        m.checkNotNullParameter(sticker, "sticker");
        m.checkNotNullParameter(stickerPackStoreSheetViewType, "type");
        m.checkNotNullParameter(str2, "section");
        this.sticker = sticker;
        this.type = stickerPackStoreSheetViewType;
        this.location = str;
        this.section = str2;
    }

    public static /* synthetic */ StickerPackStoreSheetAnalytics copy$default(StickerPackStoreSheetAnalytics stickerPackStoreSheetAnalytics, Sticker sticker, StickerPackStoreSheetViewType stickerPackStoreSheetViewType, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            sticker = stickerPackStoreSheetAnalytics.sticker;
        }
        if ((i & 2) != 0) {
            stickerPackStoreSheetViewType = stickerPackStoreSheetAnalytics.type;
        }
        if ((i & 4) != 0) {
            str = stickerPackStoreSheetAnalytics.location;
        }
        if ((i & 8) != 0) {
            str2 = stickerPackStoreSheetAnalytics.section;
        }
        return stickerPackStoreSheetAnalytics.copy(sticker, stickerPackStoreSheetViewType, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Sticker getSticker() {
        return this.sticker;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StickerPackStoreSheetViewType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSection() {
        return this.section;
    }

    public final StickerPackStoreSheetAnalytics copy(Sticker sticker, StickerPackStoreSheetViewType type, String location, String section) {
        m.checkNotNullParameter(sticker, "sticker");
        m.checkNotNullParameter(type, "type");
        m.checkNotNullParameter(section, "section");
        return new StickerPackStoreSheetAnalytics(sticker, type, location, section);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerPackStoreSheetAnalytics)) {
            return false;
        }
        StickerPackStoreSheetAnalytics stickerPackStoreSheetAnalytics = (StickerPackStoreSheetAnalytics) other;
        return m.areEqual(this.sticker, stickerPackStoreSheetAnalytics.sticker) && m.areEqual(this.type, stickerPackStoreSheetAnalytics.type) && m.areEqual(this.location, stickerPackStoreSheetAnalytics.location) && m.areEqual(this.section, stickerPackStoreSheetAnalytics.section);
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getSection() {
        return this.section;
    }

    public final Sticker getSticker() {
        return this.sticker;
    }

    public final StickerPackStoreSheetViewType getType() {
        return this.type;
    }

    public int hashCode() {
        Sticker sticker = this.sticker;
        int iHashCode = (sticker != null ? sticker.hashCode() : 0) * 31;
        StickerPackStoreSheetViewType stickerPackStoreSheetViewType = this.type;
        int iHashCode2 = (iHashCode + (stickerPackStoreSheetViewType != null ? stickerPackStoreSheetViewType.hashCode() : 0)) * 31;
        String str = this.location;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.section;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StickerPackStoreSheetAnalytics(sticker=");
        sbU.append(this.sticker);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", location=");
        sbU.append(this.location);
        sbU.append(", section=");
        return a.J(sbU, this.section, ")");
    }
}
