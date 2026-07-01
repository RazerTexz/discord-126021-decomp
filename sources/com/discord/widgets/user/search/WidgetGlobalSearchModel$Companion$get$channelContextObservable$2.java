package com.discord.widgets.user.search;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import d0.t.h0;
import j0.k.b;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$get$channelContextObservable$2<T, R> implements b<WidgetGlobalSearchModel$ChannelContext, WidgetGlobalSearchModel$ChannelContext> {
    public final /* synthetic */ Function2 $permissionsPredicate;

    public WidgetGlobalSearchModel$Companion$get$channelContextObservable$2(Function2 function2) {
        this.$permissionsPredicate = function2;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel$ChannelContext call(WidgetGlobalSearchModel$ChannelContext widgetGlobalSearchModel$ChannelContext) {
        return call2(widgetGlobalSearchModel$ChannelContext);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel$ChannelContext call2(WidgetGlobalSearchModel$ChannelContext widgetGlobalSearchModel$ChannelContext) {
        Map mapPlus = h0.plus(widgetGlobalSearchModel$ChannelContext.getChannels(), widgetGlobalSearchModel$ChannelContext.getActiveJoinedThreads());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry map$Entry : mapPlus.entrySet()) {
            if (((Boolean) this.$permissionsPredicate.invoke((Channel) map$Entry.getValue(), widgetGlobalSearchModel$ChannelContext.getChannelPerms())).booleanValue()) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        return WidgetGlobalSearchModel$ChannelContext.copy$default(widgetGlobalSearchModel$ChannelContext, null, linkedHashMap, null, null, null, null, null, null, 253, null);
    }
}
