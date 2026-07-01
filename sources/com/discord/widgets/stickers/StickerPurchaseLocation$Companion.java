package com.discord.widgets.stickers;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StickerPurchaseLocation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StickerPurchaseLocation$Companion {
    private StickerPurchaseLocation$Companion() {
    }

    public final StickerPurchaseLocation getPopoutPurchaseLocation(boolean canStickerPackBePurchased) {
        return canStickerPackBePurchased ? StickerPurchaseLocation.STICKER_UPSELL_POPOUT : StickerPurchaseLocation.STICKER_POPOUT;
    }

    public final StickerPurchaseLocation getSimplifiedLocation(StickerPurchaseLocation location) {
        if (location == null) {
            return location;
        }
        int iOrdinal = location.ordinal();
        return (iOrdinal == 1 || iOrdinal == 2) ? StickerPurchaseLocation.STICKER_POPOUT : location;
    }

    public /* synthetic */ StickerPurchaseLocation$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
