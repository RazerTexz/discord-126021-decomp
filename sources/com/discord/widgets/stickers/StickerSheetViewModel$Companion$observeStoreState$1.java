package com.discord.widgets.stickers;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStickers$StickerPackState;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: StickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StickerSheetViewModel$Companion$observeStoreState$1<T1, T2, R> implements Func2<StoreStickers$StickerPackState, MeUser, StickerSheetViewModel$StoreState> {
    public static final StickerSheetViewModel$Companion$observeStoreState$1 INSTANCE = new StickerSheetViewModel$Companion$observeStoreState$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ StickerSheetViewModel$StoreState call(StoreStickers$StickerPackState storeStickers$StickerPackState, MeUser meUser) {
        return call2(storeStickers$StickerPackState, meUser);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final StickerSheetViewModel$StoreState call2(StoreStickers$StickerPackState storeStickers$StickerPackState, MeUser meUser) {
        m.checkNotNullParameter(storeStickers$StickerPackState, "stickerPack");
        m.checkNotNullParameter(meUser, "meUser");
        return new StickerSheetViewModel$StoreState(storeStickers$StickerPackState, meUser);
    }
}
