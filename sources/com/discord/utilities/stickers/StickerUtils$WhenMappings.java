package com.discord.utilities.stickers;

import com.discord.api.premium.PremiumTier;
import com.discord.api.sticker.StickerFormatType;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StickerUtils$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        StickerFormatType.values();
        int[] iArr = new int[4];
        $EnumSwitchMapping$0 = iArr;
        iArr[StickerFormatType.LOTTIE.ordinal()] = 1;
        iArr[StickerFormatType.APNG.ordinal()] = 2;
        iArr[StickerFormatType.PNG.ordinal()] = 3;
        PremiumTier.values();
        int[] iArr2 = new int[5];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[PremiumTier.TIER_2.ordinal()] = 1;
    }
}
