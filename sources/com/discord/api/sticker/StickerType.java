package com.discord.api.sticker;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StickerType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum StickerType {
    UNKNOWN(-1),
    STANDARD(1),
    GUILD(2);


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int apiValue;

    /* JADX INFO: compiled from: StickerType.kt */
    public static final class Companion {
        public Companion() {
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

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    StickerType(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
