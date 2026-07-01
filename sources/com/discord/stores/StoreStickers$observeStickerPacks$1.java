package com.discord.stores;

import d0.t.u;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStickers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStickers$observeStickerPacks$1 extends o implements Function0<List<? extends StoreStickers$StickerPackState>> {
    public final /* synthetic */ StoreStickers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStickers$observeStickerPacks$1(StoreStickers storeStickers) {
        super(0);
        this.this$0 = storeStickers;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends StoreStickers$StickerPackState> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends StoreStickers$StickerPackState> invoke2() {
        return u.toList(StoreStickers.access$getStickerPacks$p(this.this$0).values());
    }
}
