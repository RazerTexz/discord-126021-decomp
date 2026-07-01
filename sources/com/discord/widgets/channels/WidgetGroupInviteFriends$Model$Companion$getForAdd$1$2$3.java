package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.Collection;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getForAdd$1$2$3<T, R> implements b<List<? extends WidgetGroupInviteFriends$Model$FriendItem>, Observable<? extends WidgetGroupInviteFriends$Model>> {
    public final /* synthetic */ WidgetGroupInviteFriends$Model$Companion$AddedUsersInput $usersFilter;
    public final /* synthetic */ WidgetGroupInviteFriends$Model$Companion$getForAdd$1$2 this$0;

    public WidgetGroupInviteFriends$Model$Companion$getForAdd$1$2$3(WidgetGroupInviteFriends$Model$Companion$getForAdd$1$2 widgetGroupInviteFriends$Model$Companion$getForAdd$1$2, WidgetGroupInviteFriends$Model$Companion$AddedUsersInput widgetGroupInviteFriends$Model$Companion$AddedUsersInput) {
        this.this$0 = widgetGroupInviteFriends$Model$Companion$getForAdd$1$2;
        this.$usersFilter = widgetGroupInviteFriends$Model$Companion$AddedUsersInput;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetGroupInviteFriends$Model> call(List<? extends WidgetGroupInviteFriends$Model$FriendItem> list) {
        return call2((List<WidgetGroupInviteFriends$Model$FriendItem>) list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetGroupInviteFriends$Model> call2(List<WidgetGroupInviteFriends$Model$FriendItem> list) {
        Channel channel = this.this$0.$channel;
        String filter = this.$usersFilter.getFilter();
        Collection<User> addedUsers = this.$usersFilter.getAddedUsers();
        m.checkNotNullExpressionValue(list, "friendItems");
        return new k(new WidgetGroupInviteFriends$Model(channel, filter, addedUsers, list, 1, UserUtils.INSTANCE.isStaff(StoreStream.Companion.getUsers().getMeSnapshot()) ? 25 : 10));
    }
}
