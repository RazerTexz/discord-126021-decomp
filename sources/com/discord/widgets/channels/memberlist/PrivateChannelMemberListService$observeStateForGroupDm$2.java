package com.discord.widgets.channels.memberlist;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreUser;
import d0.z.d.m;
import j0.k.b;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: PrivateChannelMemberListService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PrivateChannelMemberListService$observeStateForGroupDm$2<T, R> implements b<List<Long>, Observable<? extends PrivateChannelMemberListService$State>> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ PrivateChannelMemberListService this$0;

    public PrivateChannelMemberListService$observeStateForGroupDm$2(PrivateChannelMemberListService privateChannelMemberListService, Channel channel) {
        this.this$0 = privateChannelMemberListService;
        this.$channel = channel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends PrivateChannelMemberListService$State> call(List<Long> list) {
        return call2(list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends PrivateChannelMemberListService$State> call2(List<Long> list) {
        StoreUser storeUserAccess$getStoreUser$p = PrivateChannelMemberListService.access$getStoreUser$p(this.this$0);
        m.checkNotNullExpressionValue(list, "ids");
        return Observable.i(storeUserAccess$getStoreUser$p.observeUsers(list), PrivateChannelMemberListService.access$getStorePresences$p(this.this$0).observePresencesForUsers(list), PrivateChannelMemberListService.access$getStoreApplicationStreaming$p(this.this$0).observeStreamsByUser(), new PrivateChannelMemberListService$observeStateForGroupDm$2$1(this));
    }
}
