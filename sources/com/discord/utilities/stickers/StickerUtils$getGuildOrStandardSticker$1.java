package com.discord.utilities.stickers;

import androidx.core.app.NotificationCompat;
import com.discord.api.sticker.Sticker;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import rx.functions.Action1;

/* JADX INFO: compiled from: StickerUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerUtils$getGuildOrStandardSticker$1<T> implements Action1<Sticker> {
    public static final StickerUtils$getGuildOrStandardSticker$1 INSTANCE = new StickerUtils$getGuildOrStandardSticker$1();

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Sticker sticker) {
        call2(sticker);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Sticker sticker) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        storeStream$Companion.getStickers().handleFetchedSticker(sticker);
        storeStream$Companion.getGuildStickers().handleFetchedSticker(sticker);
    }
}
