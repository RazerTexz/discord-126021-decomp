package com.discord.api.sticker;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StickerType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StickerType$Companion {
    public StickerType$Companion() {
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001e  */
    /* JADX WARN: Code duplicated, block: B:19:? A[RETURN, SYNTHETIC] */
    public final StickerType a(int i) {
        StickerType stickerType;
        StickerType[] stickerTypeArrValues = StickerType.values();
        for (int i2 = 0; i2 < 3; i2++) {
            stickerType = stickerTypeArrValues[i2];
            if (stickerType.getApiValue() == i) {
                if (stickerType != null) {
                    return stickerType;
                }
                return StickerType.UNKNOWN;
            }
        }
        stickerType = null;
        if (stickerType != null) {
            return stickerType;
        }
        return StickerType.UNKNOWN;
    }

    public StickerType$Companion(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
