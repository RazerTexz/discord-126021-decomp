package com.discord.widgets.status;

import com.discord.api.channel.Channel;
import com.discord.widgets.stage.StageRoles;
import d0.z.d.o;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$2 extends o implements Function0<Integer> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1$2(WidgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1 widgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1, Channel channel) {
        super(0);
        this.this$0 = widgetGlobalStatusIndicatorViewModel$Companion$observeStoreState$1;
        this.$channel = channel;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        Map<Long, StageRoles> channelRoles = this.this$0.$storeStageChannels.getChannelRoles(this.$channel.getId());
        Map<Long, Integer> relationships = this.this$0.$storeUserRelationships.getRelationships();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, Integer> map$Entry : relationships.entrySet()) {
            if (map$Entry.getValue().intValue() == 2 && channelRoles != null && channelRoles.containsKey(Long.valueOf(map$Entry.getKey().longValue()))) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        return linkedHashMap.size();
    }
}
