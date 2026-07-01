package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStickers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStickers$observeStickerPack$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $stickerPackId;
    public final /* synthetic */ StoreStickers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStickers$observeStickerPack$1(StoreStickers storeStickers, long j) {
        super(0);
        this.this$0 = storeStickers;
        this.$stickerPackId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (StoreStickers.access$getStickerPacks$p(this.this$0).containsKey(Long.valueOf(this.$stickerPackId))) {
            return;
        }
        this.this$0.fetchStickerPack(this.$stickerPackId);
    }
}
