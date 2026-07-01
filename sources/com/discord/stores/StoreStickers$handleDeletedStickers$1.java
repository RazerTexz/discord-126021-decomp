package com.discord.stores;

import d0.z.d.o;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreStickers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStickers$handleDeletedStickers$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $stickerIds;
    public final /* synthetic */ StoreStickers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreStickers$handleDeletedStickers$1(StoreStickers storeStickers, List list) {
        super(0);
        this.this$0 = storeStickers;
        this.$stickerIds = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Iterator it = this.$stickerIds.iterator();
        while (it.hasNext()) {
            StoreStickers.access$getFrecency$p(this.this$0).removeEntry(String.valueOf(((Number) it.next()).longValue()));
        }
        StoreStickers.access$getFrecencyCache$p(this.this$0).set(StoreStickers.access$getFrecency$p(this.this$0), true);
    }
}
