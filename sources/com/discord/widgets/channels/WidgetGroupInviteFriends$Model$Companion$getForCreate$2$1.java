package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;
import java.util.List;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getForCreate$2$1<T, R> implements b<WidgetGroupInviteFriends$Model$ModelAppUserRelationship, List<? extends WidgetGroupInviteFriends$Model$FriendItem>> {
    public final /* synthetic */ WidgetGroupInviteFriends$Model$Companion$AddedUsersInput $usersFilter;

    public WidgetGroupInviteFriends$Model$Companion$getForCreate$2$1(WidgetGroupInviteFriends$Model$Companion$AddedUsersInput widgetGroupInviteFriends$Model$Companion$AddedUsersInput) {
        this.$usersFilter = widgetGroupInviteFriends$Model$Companion$AddedUsersInput;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ List<? extends WidgetGroupInviteFriends$Model$FriendItem> call(WidgetGroupInviteFriends$Model$ModelAppUserRelationship widgetGroupInviteFriends$Model$ModelAppUserRelationship) {
        return call2(widgetGroupInviteFriends$Model$ModelAppUserRelationship);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<WidgetGroupInviteFriends$Model$FriendItem> call2(WidgetGroupInviteFriends$Model$ModelAppUserRelationship widgetGroupInviteFriends$Model$ModelAppUserRelationship) {
        WidgetGroupInviteFriends$Model$FriendItem$Companion widgetGroupInviteFriends$Model$FriendItem$Companion = WidgetGroupInviteFriends$Model$FriendItem.Companion;
        m.checkNotNullExpressionValue(widgetGroupInviteFriends$Model$ModelAppUserRelationship, "friends");
        return widgetGroupInviteFriends$Model$FriendItem$Companion.createData(widgetGroupInviteFriends$Model$ModelAppUserRelationship, this.$usersFilter.getAddedUsers());
    }
}
