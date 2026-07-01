package com.discord.stores;

import com.discord.models.sticker.dto.ModelStickerPack;
import d0.t.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStickers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStickers$fetchStickerPack$1$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ModelStickerPack $newPack;
    public final /* synthetic */ StoreStickers$fetchStickerPack$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStickers$fetchStickerPack$1$1$1(StoreStickers$fetchStickerPack$1$1 storeStickers$fetchStickerPack$1$1, ModelStickerPack modelStickerPack) {
        super(0);
        this.this$0 = storeStickers$fetchStickerPack$1$1;
        this.$newPack = modelStickerPack;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.this$0.this$0.handleNewLoadedStickerPacks(m.listOf(this.$newPack));
    }
}
