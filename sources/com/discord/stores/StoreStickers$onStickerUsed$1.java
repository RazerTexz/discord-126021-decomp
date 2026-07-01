package com.discord.stores;

import com.discord.api.sticker.Sticker;
import com.discord.utilities.frecency.FrecencyTracker;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStickers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStickers$onStickerUsed$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Sticker $sticker;
    public final /* synthetic */ StoreStickers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStickers$onStickerUsed$1(StoreStickers storeStickers, Sticker sticker) {
        super(0);
        this.this$0 = storeStickers;
        this.$sticker = sticker;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FrecencyTracker.track$default(StoreStickers.access$getFrecency$p(this.this$0), String.valueOf(this.$sticker.getId()), 0L, 2, null);
        StoreStickers.access$getFrecencyCache$p(this.this$0).set(StoreStickers.access$getFrecency$p(this.this$0), true);
    }
}
