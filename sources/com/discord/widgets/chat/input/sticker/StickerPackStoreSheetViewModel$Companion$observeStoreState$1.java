package com.discord.widgets.chat.input.sticker;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStickers$StickerPackState;
import d0.z.d.m;
import rx.functions.Func3;

/* JADX INFO: compiled from: StickerPackStoreSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerPackStoreSheetViewModel$Companion$observeStoreState$1<T1, T2, T3, R> implements Func3<StoreStickers$StickerPackState, Integer, MeUser, StickerPackStoreSheetViewModel$StoreState> {
    public static final StickerPackStoreSheetViewModel$Companion$observeStoreState$1 INSTANCE = new StickerPackStoreSheetViewModel$Companion$observeStoreState$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ StickerPackStoreSheetViewModel$StoreState call(StoreStickers$StickerPackState storeStickers$StickerPackState, Integer num, MeUser meUser) {
        return call(storeStickers$StickerPackState, num.intValue(), meUser);
    }

    public final StickerPackStoreSheetViewModel$StoreState call(StoreStickers$StickerPackState storeStickers$StickerPackState, int i, MeUser meUser) {
        m.checkNotNullParameter(storeStickers$StickerPackState, "stickerPack");
        m.checkNotNullParameter(meUser, "meUser");
        return new StickerPackStoreSheetViewModel$StoreState(storeStickers$StickerPackState, i, meUser);
    }
}
