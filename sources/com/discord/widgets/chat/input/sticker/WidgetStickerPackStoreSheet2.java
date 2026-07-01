package com.discord.widgets.chat.input.sticker;


/* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.StickerPackStoreSheetViewType, reason: use source file name */
/* JADX INFO: compiled from: WidgetStickerPackStoreSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum WidgetStickerPackStoreSheet2 {
    STICKER_POPOUT_VIEW_ALL("Sticker Popout View All"),
    STICKER_SEARCH_VIEW_ALL("Sticker Search View All"),
    STICKER_PACK_VIEW_ALL("Sticker Pack View All");

    private final String analyticsValue;

    WidgetStickerPackStoreSheet2(String str) {
        this.analyticsValue = str;
    }

    public final String getAnalyticsValue() {
        return this.analyticsValue;
    }
}
