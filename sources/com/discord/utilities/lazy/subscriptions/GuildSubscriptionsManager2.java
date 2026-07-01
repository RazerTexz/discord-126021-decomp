package com.discord.utilities.lazy.subscriptions;

import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.Ranges2;

/* JADX INFO: renamed from: com.discord.utilities.lazy.subscriptions.GuildSubscriptionsManager$guildChannelSubscriptionsManager$1, reason: use source file name */
/* JADX INFO: compiled from: GuildSubscriptionsManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GuildSubscriptionsManager2 extends FunctionReferenceImpl implements Function2<Long, Map<Long, ? extends List<? extends Ranges2>>, Unit> {
    public GuildSubscriptionsManager2(GuildSubscriptionsManager guildSubscriptionsManager) {
        super(2, guildSubscriptionsManager, GuildSubscriptionsManager.class, "handleChannelSubscriptionsChange", "handleChannelSubscriptionsChange(JLjava/util/Map;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Map<Long, ? extends List<? extends Ranges2>> map) {
        invoke(l.longValue(), (Map<Long, ? extends List<Ranges2>>) map);
        return Unit.a;
    }

    public final void invoke(long j, Map<Long, ? extends List<Ranges2>> map) {
        Intrinsics3.checkNotNullParameter(map, "p2");
        ((GuildSubscriptionsManager) this.receiver).handleChannelSubscriptionsChange(j, map);
    }
}
