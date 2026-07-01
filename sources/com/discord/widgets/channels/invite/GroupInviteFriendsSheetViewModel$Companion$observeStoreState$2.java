package com.discord.widgets.channels.invite;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func2;

/* JADX INFO: compiled from: GroupInviteFriendsSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheetViewModel$Companion$observeStoreState$2<T1, T2, R> implements Func2<Channel, Map<Long, ? extends User>, GroupInviteFriendsSheetViewModel$StoreState> {
    public static final GroupInviteFriendsSheetViewModel$Companion$observeStoreState$2 INSTANCE = new GroupInviteFriendsSheetViewModel$Companion$observeStoreState$2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ GroupInviteFriendsSheetViewModel$StoreState call(Channel channel, Map<Long, ? extends User> map) {
        return call2(channel, map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final GroupInviteFriendsSheetViewModel$StoreState call2(Channel channel, Map<Long, ? extends User> map) {
        m.checkNotNullExpressionValue(map, "friendUsersMap");
        return new GroupInviteFriendsSheetViewModel$StoreState(map, channel);
    }
}
