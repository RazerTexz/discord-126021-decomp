package com.discord.utilities.gifting;

import androidx.annotation.RawRes;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGift;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GiftStyle.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum GiftStyle {
    WumpusGlobe(1, R.drawable.gift_wumpus_snowglobe, R.raw.anim_gift_wumpus_globe),
    WumpusBox(2, R.drawable.gift_wumpus_box, R.raw.anim_gift_wumpus_box),
    WumpusLatte(3, R.drawable.gift_wumpus_latte, R.raw.anim_gift_wumpus_latte);

    private final int animRes;
    private final int id;
    private final int staticRes;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy values$delegate = LazyJVM.lazy(GiftStyle2.INSTANCE);

    /* JADX INFO: compiled from: GiftStyle.kt */
    public static final class Companion {
        private Companion() {
        }

        private final GiftStyle[] getValues() {
            Lazy lazy = GiftStyle.values$delegate;
            Companion companion = GiftStyle.INSTANCE;
            return (GiftStyle[]) lazy.getValue();
        }

        public final GiftStyle from(ModelGift gift) {
            Intrinsics3.checkNotNullParameter(gift, "gift");
            for (GiftStyle giftStyle : getValues()) {
                int id2 = giftStyle.getId();
                Integer giftStyle2 = gift.getGiftStyle();
                if (giftStyle2 != null && id2 == giftStyle2.intValue()) {
                    return giftStyle;
                }
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    GiftStyle(@RawRes int i, int i2, int i3) {
        this.id = i;
        this.staticRes = i2;
        this.animRes = i3;
    }

    public final int getAnimRes() {
        return this.animRes;
    }

    public final int getId() {
        return this.id;
    }

    public final int getStaticRes() {
        return this.staticRes;
    }
}
