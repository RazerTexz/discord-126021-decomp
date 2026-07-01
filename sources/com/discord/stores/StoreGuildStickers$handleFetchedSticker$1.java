package com.discord.stores;

import com.discord.api.sticker.Sticker;
import d0.t.h0;
import d0.z.d.o;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildStickers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildStickers$handleFetchedSticker$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ Sticker $sticker;
    public final /* synthetic */ StoreGuildStickers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildStickers$handleFetchedSticker$1(StoreGuildStickers storeGuildStickers, long j, Sticker sticker) {
        super(0);
        this.this$0 = storeGuildStickers;
        this.$guildId = j;
        this.$sticker = sticker;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map mapEmptyMap = (Map) StoreGuildStickers.access$getAllGuildStickers$p(this.this$0).get(Long.valueOf(this.$guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        linkedHashMap.putAll(mapEmptyMap);
        linkedHashMap.put(Long.valueOf(this.$sticker.getId()), this.$sticker);
        StoreGuildStickers.access$getAllGuildStickers$p(this.this$0).put(Long.valueOf(this.$guildId), linkedHashMap);
        this.this$0.markChanged();
    }
}
