package com.discord.widgets.chat.input.sticker;

import com.discord.api.sticker.Sticker;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.user.User;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.stickers.StickerUtils;
import d0.t.n;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StickerPackStoreSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerPackStoreSheetViewModel$Companion {
    private StickerPackStoreSheetViewModel$Companion() {
    }

    public static final /* synthetic */ List access$buildStoreStickerListItems(StickerPackStoreSheetViewModel$Companion stickerPackStoreSheetViewModel$Companion, ModelStickerPack modelStickerPack, int i, User user) {
        return stickerPackStoreSheetViewModel$Companion.buildStoreStickerListItems(modelStickerPack, i, user);
    }

    public static final /* synthetic */ Observable access$observeStoreState(StickerPackStoreSheetViewModel$Companion stickerPackStoreSheetViewModel$Companion, long j, StoreStickers storeStickers, StoreUserSettings storeUserSettings, StoreUser storeUser) {
        return stickerPackStoreSheetViewModel$Companion.observeStoreState(j, storeStickers, storeUserSettings, storeUser);
    }

    private final List<MGRecyclerDataPayload> buildStoreStickerListItems(ModelStickerPack stickerPack, int stickerAnimationSettings, User meUser) {
        ArrayList arrayList = new ArrayList();
        if (stickerPack.getStickers().isEmpty()) {
            return n.emptyList();
        }
        arrayList.add(new StoreHeaderItem(stickerPack, false));
        for (Sticker sticker : stickerPack.getStickers()) {
            arrayList.add(new StickerItem(sticker, stickerAnimationSettings, StickerItem$Mode.STORE, StickerUtils.getStickerSendability$default(StickerUtils.INSTANCE, sticker, meUser, null, null, 12, null)));
        }
        return arrayList;
    }

    private final Observable<StickerPackStoreSheetViewModel$StoreState> observeStoreState(long stickerPackId, StoreStickers storeStickers, StoreUserSettings storeUserSettings, StoreUser storeUser) {
        Observable<StickerPackStoreSheetViewModel$StoreState> observableI = Observable.i(storeStickers.observeStickerPack(stickerPackId), StoreUserSettings.observeStickerAnimationSettings$default(storeUserSettings, false, 1, null), StoreUser.observeMe$default(storeUser, false, 1, null), StickerPackStoreSheetViewModel$Companion$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…ser\n          )\n        }");
        return observableI;
    }

    public /* synthetic */ StickerPackStoreSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
