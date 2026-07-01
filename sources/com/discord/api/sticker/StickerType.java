package com.discord.api.sticker;


/* JADX INFO: compiled from: StickerType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum StickerType {
    UNKNOWN(-1),
    STANDARD(1),
    GUILD(2);

    public static final StickerType$Companion Companion = new StickerType$Companion(null);
    private final int apiValue;

    StickerType(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
