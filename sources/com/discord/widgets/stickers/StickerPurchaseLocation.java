package com.discord.widgets.stickers;

import com.discord.utilities.analytics.Traits$Location$Section;

/* JADX INFO: compiled from: StickerPurchaseLocation.kt */
/* JADX INFO: loaded from: classes.dex */
public enum StickerPurchaseLocation {
    EXPRESSION_PICKER(Traits$Location$Section.EXPRESSION_PICKER),
    STICKER_POPOUT(Traits$Location$Section.STICKER_POPOUT),
    STICKER_UPSELL_POPOUT("Sticker Upsell Popout");

    public static final StickerPurchaseLocation$Companion Companion = new StickerPurchaseLocation$Companion(null);
    private final String analyticsValue;

    StickerPurchaseLocation(String str) {
        this.analyticsValue = str;
    }

    public final String getAnalyticsValue() {
        return this.analyticsValue;
    }
}
