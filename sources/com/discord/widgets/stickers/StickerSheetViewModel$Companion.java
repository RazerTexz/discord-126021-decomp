package com.discord.widgets.stickers;

import com.discord.api.sticker.Sticker;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreUser;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StickerSheetViewModel$Companion {
    private StickerSheetViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(StickerSheetViewModel$Companion stickerSheetViewModel$Companion, StoreStickers storeStickers, StoreUser storeUser, Sticker sticker) {
        return stickerSheetViewModel$Companion.observeStoreState(storeStickers, storeUser, sticker);
    }

    private final Observable<StickerSheetViewModel$StoreState> observeStoreState(StoreStickers storeStickers, StoreUser storeUser, Sticker sticker) {
        Long packId = sticker.getPackId();
        m.checkNotNull(packId);
        Observable<StickerSheetViewModel$StoreState> observableJ = Observable.j(storeStickers.observeStickerPack(packId.longValue()), StoreUser.observeMe$default(storeUser, false, 1, null), StickerSheetViewModel$Companion$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…ser\n          )\n        }");
        return observableJ;
    }

    public /* synthetic */ StickerSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
