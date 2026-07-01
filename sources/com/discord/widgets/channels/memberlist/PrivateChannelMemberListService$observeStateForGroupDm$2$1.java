package com.discord.widgets.channels.memberlist;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func3;

/* JADX INFO: compiled from: PrivateChannelMemberListService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PrivateChannelMemberListService$observeStateForGroupDm$2$1<T1, T2, T3, R> implements Func3<Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends ModelApplicationStream>, PrivateChannelMemberListService$State> {
    public final /* synthetic */ PrivateChannelMemberListService$observeStateForGroupDm$2 this$0;

    public PrivateChannelMemberListService$observeStateForGroupDm$2$1(PrivateChannelMemberListService$observeStateForGroupDm$2 privateChannelMemberListService$observeStateForGroupDm$2) {
        this.this$0 = privateChannelMemberListService$observeStateForGroupDm$2;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ PrivateChannelMemberListService$State call(Map<Long, ? extends User> map, Map<Long, ? extends Presence> map2, Map<Long, ? extends ModelApplicationStream> map3) {
        return call2(map, (Map<Long, Presence>) map2, map3);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final PrivateChannelMemberListService$State call2(Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3) {
        Channel channel = this.this$0.$channel;
        m.checkNotNullExpressionValue(map, "users");
        m.checkNotNullExpressionValue(map2, "presences");
        m.checkNotNullExpressionValue(map3, "applicationStreams");
        return new PrivateChannelMemberListService$State(channel, map, map2, map3);
    }
}
