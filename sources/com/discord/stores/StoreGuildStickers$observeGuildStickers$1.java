package com.discord.stores;

import com.discord.api.sticker.Sticker;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildStickers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildStickers$observeGuildStickers$1 extends o implements Function0<Map<Long, ? extends Map<Long, ? extends Sticker>>> {
    public final /* synthetic */ StoreGuildStickers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildStickers$observeGuildStickers$1(StoreGuildStickers storeGuildStickers) {
        super(0);
        this.this$0 = storeGuildStickers;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends Map<Long, ? extends Sticker>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends Map<Long, ? extends Sticker>> invoke2() {
        return StoreGuildStickers.access$getAllGuildStickersSnapshot$p(this.this$0);
    }
}
