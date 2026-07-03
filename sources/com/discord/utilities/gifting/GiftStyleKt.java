package com.discord.utilities.gifting;

import com.discord.models.domain.ModelGift;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GiftStyle.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GiftStyleKt {
    public static final GiftStyle getCustomStyle(ModelGift modelGift) {
        C12238m.checkNotNullParameter(modelGift, "$this$getCustomStyle");
        return GiftStyle.INSTANCE.from(modelGift);
    }

    public static final boolean hasCustomStyle(ModelGift modelGift) {
        C12238m.checkNotNullParameter(modelGift, "$this$hasCustomStyle");
        return getCustomStyle(modelGift) != null;
    }
}
