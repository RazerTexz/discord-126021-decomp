package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function8;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetGlobalSearchModel$Companion$get$channelContextObservable$1 extends FunctionReferenceImpl implements Function8<Map<Long, ? extends Guild>, Map<Long, ? extends Channel>, Map<Long, ? extends Channel>, Map<Long, ? extends Long>, Map<Long, ? extends Channel>, Map<Long, ? extends List<? extends Long>>, Set<? extends Long>, Set<? extends Long>, WidgetGlobalSearchModel.ChannelContext> {
    public static final WidgetGlobalSearchModel$Companion$get$channelContextObservable$1 INSTANCE = new WidgetGlobalSearchModel$Companion$get$channelContextObservable$1();

    public WidgetGlobalSearchModel$Companion$get$channelContextObservable$1() {
        super(8, WidgetGlobalSearchModel.ChannelContext.class, "<init>", "<init>(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function8
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.ChannelContext invoke(Map<Long, ? extends Guild> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends Channel> map3, Map<Long, ? extends Long> map4, Map<Long, ? extends Channel> map5, Map<Long, ? extends List<? extends Long>> map6, Set<? extends Long> set, Set<? extends Long> set2) {
        return invoke2((Map<Long, Guild>) map, (Map<Long, Channel>) map2, (Map<Long, Channel>) map3, (Map<Long, Long>) map4, (Map<Long, Channel>) map5, (Map<Long, ? extends List<Long>>) map6, (Set<Long>) set, (Set<Long>) set2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel.ChannelContext invoke2(Map<Long, Guild> map, Map<Long, Channel> map2, Map<Long, Channel> map3, Map<Long, Long> map4, Map<Long, Channel> map5, Map<Long, ? extends List<Long>> map6, Set<Long> set, Set<Long> set2) {
        Intrinsics3.checkNotNullParameter(map, "p1");
        Intrinsics3.checkNotNullParameter(map2, "p2");
        Intrinsics3.checkNotNullParameter(map3, "p3");
        Intrinsics3.checkNotNullParameter(map4, "p4");
        Intrinsics3.checkNotNullParameter(map5, "p5");
        Intrinsics3.checkNotNullParameter(map6, "p6");
        Intrinsics3.checkNotNullParameter(set, "p7");
        Intrinsics3.checkNotNullParameter(set2, "p8");
        return new WidgetGlobalSearchModel.ChannelContext(map, map2, map3, map4, map5, map6, set, set2);
    }
}
