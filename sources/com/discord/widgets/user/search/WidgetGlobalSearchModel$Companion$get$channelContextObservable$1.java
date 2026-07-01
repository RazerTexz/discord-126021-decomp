package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import d0.z.d.k;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function8;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetGlobalSearchModel$Companion$get$channelContextObservable$1 extends k implements Function8<Map<Long, ? extends Guild>, Map<Long, ? extends Channel>, Map<Long, ? extends Channel>, Map<Long, ? extends Long>, Map<Long, ? extends Channel>, Map<Long, ? extends List<? extends Long>>, Set<? extends Long>, Set<? extends Long>, WidgetGlobalSearchModel$ChannelContext> {
    public static final WidgetGlobalSearchModel$Companion$get$channelContextObservable$1 INSTANCE = new WidgetGlobalSearchModel$Companion$get$channelContextObservable$1();

    public WidgetGlobalSearchModel$Companion$get$channelContextObservable$1() {
        super(8, WidgetGlobalSearchModel$ChannelContext.class, "<init>", "<init>(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function8
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel$ChannelContext invoke(Map<Long, ? extends Guild> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends Channel> map3, Map<Long, ? extends Long> map4, Map<Long, ? extends Channel> map5, Map<Long, ? extends List<? extends Long>> map6, Set<? extends Long> set, Set<? extends Long> set2) {
        return invoke2((Map<Long, Guild>) map, (Map<Long, Channel>) map2, (Map<Long, Channel>) map3, (Map<Long, Long>) map4, (Map<Long, Channel>) map5, (Map<Long, ? extends List<Long>>) map6, (Set<Long>) set, (Set<Long>) set2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel$ChannelContext invoke2(Map<Long, Guild> map, Map<Long, Channel> map2, Map<Long, Channel> map3, Map<Long, Long> map4, Map<Long, Channel> map5, Map<Long, ? extends List<Long>> map6, Set<Long> set, Set<Long> set2) {
        m.checkNotNullParameter(map, "p1");
        m.checkNotNullParameter(map2, "p2");
        m.checkNotNullParameter(map3, "p3");
        m.checkNotNullParameter(map4, "p4");
        m.checkNotNullParameter(map5, "p5");
        m.checkNotNullParameter(map6, "p6");
        m.checkNotNullParameter(set, "p7");
        m.checkNotNullParameter(set2, "p8");
        return new WidgetGlobalSearchModel$ChannelContext(map, map2, map3, map4, map5, map6, set, set2);
    }
}
