package com.discord.widgets.channels.invite;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import d0.z.d.m;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: GroupInviteFriendsSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheetViewModel$Companion$observeStoreState$1<T, R> implements b<Map<Long, ? extends User>, GroupInviteFriendsSheetViewModel$StoreState> {
    public static final GroupInviteFriendsSheetViewModel$Companion$observeStoreState$1 INSTANCE = new GroupInviteFriendsSheetViewModel$Companion$observeStoreState$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ GroupInviteFriendsSheetViewModel$StoreState call(Map<Long, ? extends User> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final GroupInviteFriendsSheetViewModel$StoreState call2(Map<Long, ? extends User> map) {
        m.checkNotNullExpressionValue(map, "friendsUsers");
        return new GroupInviteFriendsSheetViewModel$StoreState(map, null, 2, null);
    }
}
