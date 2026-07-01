package com.discord.widgets.channels.invite;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class GroupInviteFriendsSheet$onResume$2 extends k implements Function1<GroupInviteFriendsSheetViewModel$Event, Unit> {
    public GroupInviteFriendsSheet$onResume$2(GroupInviteFriendsSheet groupInviteFriendsSheet) {
        super(1, groupInviteFriendsSheet, GroupInviteFriendsSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GroupInviteFriendsSheetViewModel$Event groupInviteFriendsSheetViewModel$Event) {
        invoke2(groupInviteFriendsSheetViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GroupInviteFriendsSheetViewModel$Event groupInviteFriendsSheetViewModel$Event) {
        m.checkNotNullParameter(groupInviteFriendsSheetViewModel$Event, "p1");
        GroupInviteFriendsSheet.access$handleEvent((GroupInviteFriendsSheet) this.receiver, groupInviteFriendsSheetViewModel$Event);
    }
}
