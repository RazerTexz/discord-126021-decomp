package com.discord.widgets.channels.invite;

import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GroupInviteFriendsSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheetViewModel$Companion {
    private GroupInviteFriendsSheetViewModel$Companion() {
    }

    public static final /* synthetic */ int access$getMaxNumMembers(GroupInviteFriendsSheetViewModel$Companion groupInviteFriendsSheetViewModel$Companion, StoreUser storeUser) {
        return groupInviteFriendsSheetViewModel$Companion.getMaxNumMembers(storeUser);
    }

    public static final /* synthetic */ Observable access$observeStoreState(GroupInviteFriendsSheetViewModel$Companion groupInviteFriendsSheetViewModel$Companion, long j, StoreUserRelationships storeUserRelationships, StoreUser storeUser, StoreChannels storeChannels) {
        return groupInviteFriendsSheetViewModel$Companion.observeStoreState(j, storeUserRelationships, storeUser, storeChannels);
    }

    private final int getMaxNumMembers(StoreUser storeUser) {
        return UserUtils.INSTANCE.isStaff(storeUser.getMeSnapshot()) ? 25 : 10;
    }

    private final Observable<Map<Long, User>> observeFriends(StoreUserRelationships storeUserRelationships, StoreUser storeUser) {
        Observable observableY = storeUserRelationships.observeForType(1).Y(new GroupInviteFriendsSheetViewModel$Companion$observeFriends$1(storeUser));
        m.checkNotNullExpressionValue(observableY, "storeUserRelationships.o…ships.keys)\n            }");
        return observableY;
    }

    private final Observable<GroupInviteFriendsSheetViewModel$StoreState> observeStoreState(long channelId, StoreUserRelationships storeUserRelationships, StoreUser storeUser, StoreChannels storeChannels) {
        if (channelId == -1) {
            Observable observableG = observeFriends(storeUserRelationships, storeUser).G(GroupInviteFriendsSheetViewModel$Companion$observeStoreState$1.INSTANCE);
            m.checkNotNullExpressionValue(observableG, "observeFriends(storeUser…          )\n            }");
            return observableG;
        }
        Observable<GroupInviteFriendsSheetViewModel$StoreState> observableJ = Observable.j(storeChannels.observeChannel(channelId), observeFriends(storeUserRelationships, storeUser), GroupInviteFriendsSheetViewModel$Companion$observeStoreState$2.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable\n             …      )\n                }");
        return observableJ;
    }

    public /* synthetic */ GroupInviteFriendsSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
