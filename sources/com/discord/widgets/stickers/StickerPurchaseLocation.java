package com.discord.widgets.stickers;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StickerPurchaseLocation.kt */
/* JADX INFO: loaded from: classes.dex */
public enum StickerPurchaseLocation {
    EXPRESSION_PICKER(Traits.Location.Section.EXPRESSION_PICKER),
    STICKER_POPOUT(Traits.Location.Section.STICKER_POPOUT),
    STICKER_UPSELL_POPOUT("Sticker Upsell Popout");


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String analyticsValue;

    /* JADX INFO: compiled from: StickerPurchaseLocation.kt */
    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                StickerPurchaseLocation.values();
                int[] iArr = new int[3];
                $EnumSwitchMapping$0 = iArr;
                iArr[StickerPurchaseLocation.STICKER_POPOUT.ordinal()] = 1;
                iArr[StickerPurchaseLocation.STICKER_UPSELL_POPOUT.ordinal()] = 2;
            }
        }

        private Companion() {
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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    StickerPurchaseLocation(String str) {
        this.analyticsValue = str;
    }

    public final String getAnalyticsValue() {
        return this.analyticsValue;
    }
}
