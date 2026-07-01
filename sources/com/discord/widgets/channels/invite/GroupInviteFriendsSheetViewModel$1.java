package com.discord.widgets.channels.invite;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GroupInviteFriendsSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheetViewModel$1 extends o implements Function1<GroupInviteFriendsSheetViewModel$StoreState, Unit> {
    public final /* synthetic */ GroupInviteFriendsSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupInviteFriendsSheetViewModel$1(GroupInviteFriendsSheetViewModel groupInviteFriendsSheetViewModel) {
        super(1);
        this.this$0 = groupInviteFriendsSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GroupInviteFriendsSheetViewModel$StoreState groupInviteFriendsSheetViewModel$StoreState) {
        invoke2(groupInviteFriendsSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GroupInviteFriendsSheetViewModel$StoreState groupInviteFriendsSheetViewModel$StoreState) {
        m.checkNotNullParameter(groupInviteFriendsSheetViewModel$StoreState, "storeState");
        GroupInviteFriendsSheetViewModel.access$handleStoreState(this.this$0, groupInviteFriendsSheetViewModel$StoreState);
    }
}
