package com.discord.stores;

import com.discord.models.sticker.dto.ModelStickerPack;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStickers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStickers$fetchStickerPack$1$1 extends o implements Function1<ModelStickerPack, Unit> {
    public final /* synthetic */ StoreStickers$fetchStickerPack$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStickers$fetchStickerPack$1$1(StoreStickers$fetchStickerPack$1 storeStickers$fetchStickerPack$1) {
        super(1);
        this.this$0 = storeStickers$fetchStickerPack$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelStickerPack modelStickerPack) {
        invoke2(modelStickerPack);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelStickerPack modelStickerPack) {
        m.checkNotNullParameter(modelStickerPack, "newPack");
        StoreStickers.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreStickers$fetchStickerPack$1$1$1(this, modelStickerPack));
    }
}
