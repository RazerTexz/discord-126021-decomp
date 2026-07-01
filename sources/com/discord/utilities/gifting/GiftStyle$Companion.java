package com.discord.utilities.gifting;

import com.discord.models.domain.ModelGift;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GiftStyle.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GiftStyle$Companion {
    private GiftStyle$Companion() {
    }

    private final GiftStyle[] getValues() {
        Lazy lazyAccess$getValues$cp = GiftStyle.access$getValues$cp();
        GiftStyle$Companion giftStyle$Companion = GiftStyle.Companion;
        return (GiftStyle[]) lazyAccess$getValues$cp.getValue();
    }

    public final GiftStyle from(ModelGift gift) {
        m.checkNotNullParameter(gift, "gift");
        for (GiftStyle giftStyle : getValues()) {
            int id2 = giftStyle.getId();
            Integer giftStyle2 = gift.getGiftStyle();
            if (giftStyle2 != null && id2 == giftStyle2.intValue()) {
                return giftStyle;
            }
        }
        return null;
    }

    public /* synthetic */ GiftStyle$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
