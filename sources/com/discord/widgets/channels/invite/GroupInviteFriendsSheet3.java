package com.discord.widgets.channels.invite;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheet$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheet3 extends Lambda implements Function0<GroupInviteFriendsSheetViewModel> {
    public final /* synthetic */ GroupInviteFriendsSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupInviteFriendsSheet3(GroupInviteFriendsSheet groupInviteFriendsSheet) {
        super(0);
        this.this$0 = groupInviteFriendsSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GroupInviteFriendsSheetViewModel invoke() {
        return new GroupInviteFriendsSheetViewModel(this.this$0.requireArguments().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L), null, 0, null, 14, null);
    }
}
