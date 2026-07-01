package com.discord.widgets.channels;

import com.discord.chips_view.ChipsView$a;
import com.discord.models.user.User;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$UserDataContract implements ChipsView$a {
    private final String displayString;
    private final User modelUser;

    public WidgetGroupInviteFriends$UserDataContract(User user) {
        this.modelUser = user;
        this.displayString = user != null ? user.getUsername() : null;
    }

    @Override // com.discord.chips_view.ChipsView$a
    public String getDisplayString() {
        return this.displayString;
    }

    public final User getModelUser() {
        return this.modelUser;
    }
}
