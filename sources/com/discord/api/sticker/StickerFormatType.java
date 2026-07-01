package com.discord.api.sticker;


/* JADX INFO: compiled from: StickerFormatType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum StickerFormatType {
    UNKNOWN(-1),
    PNG(1),
    APNG(2),
    LOTTIE(3);

    public static final StickerFormatType$Companion Companion = new StickerFormatType$Companion(null);
    private final int apiValue;

    StickerFormatType(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
