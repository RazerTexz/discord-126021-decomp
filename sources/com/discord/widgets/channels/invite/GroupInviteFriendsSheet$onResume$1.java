package com.discord.widgets.channels.invite;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheet$onResume$1 extends o implements Function1<GroupInviteFriendsSheetViewModel$ViewState, Unit> {
    public final /* synthetic */ GroupInviteFriendsSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupInviteFriendsSheet$onResume$1(GroupInviteFriendsSheet groupInviteFriendsSheet) {
        super(1);
        this.this$0 = groupInviteFriendsSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GroupInviteFriendsSheetViewModel$ViewState groupInviteFriendsSheetViewModel$ViewState) {
        invoke2(groupInviteFriendsSheetViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GroupInviteFriendsSheetViewModel$ViewState groupInviteFriendsSheetViewModel$ViewState) {
        m.checkNotNullParameter(groupInviteFriendsSheetViewModel$ViewState, "viewState");
        GroupInviteFriendsSheet.access$updateView(this.this$0, groupInviteFriendsSheetViewModel$ViewState);
    }
}
