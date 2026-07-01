package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStickers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStickers$observeStickerPack$2 extends o implements Function0<StoreStickers$StickerPackState> {
    public final /* synthetic */ long $stickerPackId;
    public final /* synthetic */ StoreStickers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStickers$observeStickerPack$2(StoreStickers storeStickers, long j) {
        super(0);
        this.this$0 = storeStickers;
        this.$stickerPackId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreStickers$StickerPackState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreStickers$StickerPackState invoke() {
        StoreStickers$StickerPackState storeStickers$StickerPackState = (StoreStickers$StickerPackState) StoreStickers.access$getStickerPacks$p(this.this$0).get(Long.valueOf(this.$stickerPackId));
        return storeStickers$StickerPackState != null ? storeStickers$StickerPackState : StoreStickers$StickerPackState$Unknown.INSTANCE;
    }
}
