package com.discord.widgets.channels.invite;

import com.discord.models.user.User;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheet$onViewCreated$1 extends o implements Function2<User, Boolean, Unit> {
    public final /* synthetic */ GroupInviteFriendsSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupInviteFriendsSheet$onViewCreated$1(GroupInviteFriendsSheet groupInviteFriendsSheet) {
        super(2);
        this.this$0 = groupInviteFriendsSheet;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(User user, Boolean bool) {
        invoke(user, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(User user, boolean z2) {
        m.checkNotNullParameter(user, "user");
        GroupInviteFriendsSheet.access$getViewModel$p(this.this$0).onChangeUserChecked(user, z2);
    }
}
