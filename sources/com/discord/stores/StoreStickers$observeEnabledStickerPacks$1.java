package com.discord.stores;

import com.discord.models.sticker.dto.ModelStickerPack;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStickers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStickers$observeEnabledStickerPacks$1 extends o implements Function0<List<? extends ModelStickerPack>> {
    public final /* synthetic */ StoreStickers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStickers$observeEnabledStickerPacks$1(StoreStickers storeStickers) {
        super(0);
        this.this$0 = storeStickers;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends ModelStickerPack> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends ModelStickerPack> invoke2() {
        return StoreStickers.access$getEnabledStickerPacksSnapshot$p(this.this$0);
    }
}
