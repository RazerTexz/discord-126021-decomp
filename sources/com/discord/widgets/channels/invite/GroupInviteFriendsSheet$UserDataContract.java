package com.discord.widgets.channels.invite;

import com.discord.chips_view.ChipsView$a;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheet$UserDataContract implements ChipsView$a {
    private final String displayString;
    private final User modelUser;

    public GroupInviteFriendsSheet$UserDataContract(User user) {
        m.checkNotNullParameter(user, "modelUser");
        this.modelUser = user;
        this.displayString = user.getUsername();
    }

    @Override // com.discord.chips_view.ChipsView$a
    public String getDisplayString() {
        return this.displayString;
    }

    public final User getModelUser() {
        return this.modelUser;
    }
}
