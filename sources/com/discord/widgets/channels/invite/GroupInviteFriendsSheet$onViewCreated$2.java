package com.discord.widgets.channels.invite;

import com.discord.models.user.User;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheet$onViewCreated$2 extends o implements Function1<GroupInviteFriendsSheet$UserDataContract, Unit> {
    public final /* synthetic */ GroupInviteFriendsSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupInviteFriendsSheet$onViewCreated$2(GroupInviteFriendsSheet groupInviteFriendsSheet) {
        super(1);
        this.this$0 = groupInviteFriendsSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GroupInviteFriendsSheet$UserDataContract groupInviteFriendsSheet$UserDataContract) {
        invoke2(groupInviteFriendsSheet$UserDataContract);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GroupInviteFriendsSheet$UserDataContract groupInviteFriendsSheet$UserDataContract) {
        User modelUser;
        if (groupInviteFriendsSheet$UserDataContract == null || (modelUser = groupInviteFriendsSheet$UserDataContract.getModelUser()) == null) {
            return;
        }
        GroupInviteFriendsSheet.access$getViewModel$p(this.this$0).onChangeUserChecked(modelUser, false);
    }
}
