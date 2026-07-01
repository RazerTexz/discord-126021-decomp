package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$guildListBuilder$5 extends Lambda implements Function1<Long, Boolean> {
    public final /* synthetic */ Channel $selectedChannel;
    public final /* synthetic */ Map $threadParentMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelListModel$Companion$guildListBuilder$5(Map map, Channel channel) {
        super(1);
        this.$threadParentMap = map;
        this.$selectedChannel = channel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
        return Boolean.valueOf(invoke(l.longValue()));
    }

    public final boolean invoke(long j) {
        Collection collection = (Collection) this.$threadParentMap.get(Long.valueOf(j));
        if (collection == null) {
            return false;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            long id2 = ((Channel) it.next()).getId();
            Channel channel = this.$selectedChannel;
            if (channel != null && id2 == channel.getId()) {
                return true;
            }
        }
        return false;
    }
}
