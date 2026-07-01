package com.discord.stores;

import com.discord.models.sticker.dto.ModelStickerStoreDirectory;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStickers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStickers$fetchEnabledStickerDirectory$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ModelStickerStoreDirectory $directory;
    public final /* synthetic */ StoreStickers$fetchEnabledStickerDirectory$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStickers$fetchEnabledStickerDirectory$1$1(StoreStickers$fetchEnabledStickerDirectory$1 storeStickers$fetchEnabledStickerDirectory$1, ModelStickerStoreDirectory modelStickerStoreDirectory) {
        super(0);
        this.this$0 = storeStickers$fetchEnabledStickerDirectory$1;
        this.$directory = modelStickerStoreDirectory;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreStickers storeStickers = this.this$0.this$0;
        StoreStickers.access$setLastFetchedEnabledPacks$p(storeStickers, StoreStickers.access$getClock$p(storeStickers).currentTimeMillis());
        this.this$0.this$0.handleNewEnabledStickerDirectory(this.$directory.getStickerPacks());
    }
}
