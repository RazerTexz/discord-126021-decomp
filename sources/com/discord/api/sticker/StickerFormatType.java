package com.discord.api.sticker;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StickerFormatType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum StickerFormatType {
    UNKNOWN(-1),
    PNG(1),
    APNG(2),
    LOTTIE(3);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int apiValue;

    /* JADX INFO: compiled from: StickerFormatType.kt */
    public static final class Companion {
        public Companion() {
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

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    StickerFormatType(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
