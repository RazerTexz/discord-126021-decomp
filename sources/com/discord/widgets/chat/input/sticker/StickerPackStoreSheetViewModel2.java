package com.discord.widgets.chat.input.sticker;

import b.d.b.a.outline;
import com.discord.api.sticker.Sticker;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.StickerPackStoreSheetAnalytics, reason: use source file name */
/* JADX INFO: compiled from: StickerPackStoreSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StickerPackStoreSheetViewModel2 {
    private final String location;
    private final String section;
    private final Sticker sticker;
    private final WidgetStickerPackStoreSheet2 type;

    public StickerPackStoreSheetViewModel2(Sticker sticker, WidgetStickerPackStoreSheet2 widgetStickerPackStoreSheet2, String str, String str2) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        Intrinsics3.checkNotNullParameter(widgetStickerPackStoreSheet2, "type");
        Intrinsics3.checkNotNullParameter(str2, "section");
        this.sticker = sticker;
        this.type = widgetStickerPackStoreSheet2;
        this.location = str;
        this.section = str2;
    }

    public static /* synthetic */ StickerPackStoreSheetViewModel2 copy$default(StickerPackStoreSheetViewModel2 stickerPackStoreSheetViewModel2, Sticker sticker, WidgetStickerPackStoreSheet2 widgetStickerPackStoreSheet2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            sticker = stickerPackStoreSheetViewModel2.sticker;
        }
        if ((i & 2) != 0) {
            widgetStickerPackStoreSheet2 = stickerPackStoreSheetViewModel2.type;
        }
        if ((i & 4) != 0) {
            str = stickerPackStoreSheetViewModel2.location;
        }
        if ((i & 8) != 0) {
            str2 = stickerPackStoreSheetViewModel2.section;
        }
        return stickerPackStoreSheetViewModel2.copy(sticker, widgetStickerPackStoreSheet2, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Sticker getSticker() {
        return this.sticker;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final WidgetStickerPackStoreSheet2 getType() {
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

    public final StickerPackStoreSheetViewModel2 copy(Sticker sticker, WidgetStickerPackStoreSheet2 type, String location, String section) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(section, "section");
        return new StickerPackStoreSheetViewModel2(sticker, type, location, section);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StickerPackStoreSheetViewModel2)) {
            return false;
        }
        StickerPackStoreSheetViewModel2 stickerPackStoreSheetViewModel2 = (StickerPackStoreSheetViewModel2) other;
        return Intrinsics3.areEqual(this.sticker, stickerPackStoreSheetViewModel2.sticker) && Intrinsics3.areEqual(this.type, stickerPackStoreSheetViewModel2.type) && Intrinsics3.areEqual(this.location, stickerPackStoreSheetViewModel2.location) && Intrinsics3.areEqual(this.section, stickerPackStoreSheetViewModel2.section);
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

    public final WidgetStickerPackStoreSheet2 getType() {
        return this.type;
    }

    public int hashCode() {
        Sticker sticker = this.sticker;
        int iHashCode = (sticker != null ? sticker.hashCode() : 0) * 31;
        WidgetStickerPackStoreSheet2 widgetStickerPackStoreSheet2 = this.type;
        int iHashCode2 = (iHashCode + (widgetStickerPackStoreSheet2 != null ? widgetStickerPackStoreSheet2.hashCode() : 0)) * 31;
        String str = this.location;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.section;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("StickerPackStoreSheetAnalytics(sticker=");
        sbU.append(this.sticker);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", location=");
        sbU.append(this.location);
        sbU.append(", section=");
        return outline.J(sbU, this.section, ")");
    }
}
