package com.discord.api.sticker;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StickerFormatType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StickerFormatType$Companion {
    public StickerFormatType$Companion() {
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001e  */
    /* JADX WARN: Code duplicated, block: B:19:? A[RETURN, SYNTHETIC] */
    public final StickerFormatType a(int i) {
        StickerFormatType stickerFormatType;
        StickerFormatType[] stickerFormatTypeArrValues = StickerFormatType.values();
        for (int i2 = 0; i2 < 4; i2++) {
            stickerFormatType = stickerFormatTypeArrValues[i2];
            if (stickerFormatType.getApiValue() == i) {
                if (stickerFormatType != null) {
                    return stickerFormatType;
                }
                return StickerFormatType.UNKNOWN;
            }
        }
        stickerFormatType = null;
        if (stickerFormatType != null) {
            return stickerFormatType;
        }
        return StickerFormatType.UNKNOWN;
    }

    public StickerFormatType$Companion(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
