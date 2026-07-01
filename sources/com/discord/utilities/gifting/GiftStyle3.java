package com.discord.utilities.gifting;

import com.discord.models.domain.ModelGift;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.gifting.GiftStyleKt, reason: use source file name */
/* JADX INFO: compiled from: GiftStyle.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GiftStyle3 {
    public static final GiftStyle getCustomStyle(ModelGift modelGift) {
        Intrinsics3.checkNotNullParameter(modelGift, "$this$getCustomStyle");
        return GiftStyle.INSTANCE.from(modelGift);
    }

    public static final boolean hasCustomStyle(ModelGift modelGift) {
        Intrinsics3.checkNotNullParameter(modelGift, "$this$hasCustomStyle");
        return getCustomStyle(modelGift) != null;
    }
}
