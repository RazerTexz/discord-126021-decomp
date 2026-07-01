package com.discord.widgets.user.profile;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreGuilds;
import d0.t.h0;
import j0.k.b;
import j0.l.e.k;
import java.util.Collection;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderViewModel$Companion$observeComputedMembers$1<T, R> implements b<Channel, Observable<? extends Map<Long, ? extends GuildMember>>> {
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ Collection $users;

    public UserProfileHeaderViewModel$Companion$observeComputedMembers$1(StoreGuilds storeGuilds, Collection collection) {
        this.$storeGuilds = storeGuilds;
        this.$users = collection;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends GuildMember>> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<Long, GuildMember>> call2(Channel channel) {
        Observable<Map<Long, GuildMember>> observableObserveComputed;
        return (channel == null || (observableObserveComputed = this.$storeGuilds.observeComputed(channel.getGuildId(), this.$users)) == null) ? new k(h0.emptyMap()) : observableObserveComputed;
    }
}
