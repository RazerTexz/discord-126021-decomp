package com.discord.stores;

import com.discord.models.sticker.dto.ModelStickerStoreDirectory;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStickers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStickers$fetchEnabledStickerDirectory$1 extends o implements Function1<ModelStickerStoreDirectory, Unit> {
    public final /* synthetic */ StoreStickers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStickers$fetchEnabledStickerDirectory$1(StoreStickers storeStickers) {
        super(1);
        this.this$0 = storeStickers;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelStickerStoreDirectory modelStickerStoreDirectory) {
        invoke2(modelStickerStoreDirectory);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelStickerStoreDirectory modelStickerStoreDirectory) {
        m.checkNotNullParameter(modelStickerStoreDirectory, "directory");
        StoreStickers.access$getDispatcher$p(this.this$0).schedule(new StoreStickers$fetchEnabledStickerDirectory$1$1(this, modelStickerStoreDirectory));
    }
}
