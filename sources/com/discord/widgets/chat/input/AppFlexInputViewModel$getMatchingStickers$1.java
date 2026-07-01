package com.discord.widgets.chat.input;

import com.discord.api.sticker.Sticker;
import com.discord.utilities.stickers.StickerUtils;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AppFlexInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFlexInputViewModel$getMatchingStickers$1 extends o implements Function1<String, Set<? extends Sticker>> {
    public static final AppFlexInputViewModel$getMatchingStickers$1 INSTANCE = new AppFlexInputViewModel$getMatchingStickers$1();

    public AppFlexInputViewModel$getMatchingStickers$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Set<? extends Sticker> invoke(String str) {
        return invoke2(str);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<Sticker> invoke2(String str) {
        m.checkNotNullParameter(str, "inputText");
        StickerUtils stickerUtils = StickerUtils.INSTANCE;
        return StickerUtils.findStickerMatches$default(stickerUtils, str, StickerUtils.getStickersForAutocomplete$default(stickerUtils, null, null, null, null, null, 31, null), false, 4, null);
    }
}
