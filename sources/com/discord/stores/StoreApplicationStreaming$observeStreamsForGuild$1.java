package com.discord.stores;

import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelApplicationStream$GuildStream;
import d0.z.d.o;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationStreaming.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationStreaming$observeStreamsForGuild$1 extends o implements Function0<Map<Long, ? extends ModelApplicationStream>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreApplicationStreaming this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationStreaming$observeStreamsForGuild$1(StoreApplicationStreaming storeApplicationStreaming, long j) {
        super(0);
        this.this$0 = storeApplicationStreaming;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends ModelApplicationStream> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends ModelApplicationStream> invoke2() {
        Map mapAccess$getStreamsByUserSnapshot$p = StoreApplicationStreaming.access$getStreamsByUserSnapshot$p(this.this$0);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry map$Entry : mapAccess$getStreamsByUserSnapshot$p.entrySet()) {
            ModelApplicationStream modelApplicationStream = (ModelApplicationStream) map$Entry.getValue();
            if ((modelApplicationStream instanceof ModelApplicationStream$GuildStream) && ((ModelApplicationStream$GuildStream) modelApplicationStream).getGuildId() == this.$guildId) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        return linkedHashMap;
    }
}
