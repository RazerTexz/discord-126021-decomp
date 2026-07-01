package com.discord.widgets.user.profile;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: UserStatusPresenceCustomView.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UserStatusPresenceCustomView$ViewState$WithStatus extends UserStatusPresenceCustomView$ViewState {
    private final UserStatusPresenceCustomView$Emoji emoji;
    private final String statusText;

    public UserStatusPresenceCustomView$ViewState$WithStatus(UserStatusPresenceCustomView$Emoji userStatusPresenceCustomView$Emoji, String str) {
        super(null);
        this.emoji = userStatusPresenceCustomView$Emoji;
        this.statusText = str;
    }

    public static /* synthetic */ UserStatusPresenceCustomView$ViewState$WithStatus copy$default(UserStatusPresenceCustomView$ViewState$WithStatus userStatusPresenceCustomView$ViewState$WithStatus, UserStatusPresenceCustomView$Emoji userStatusPresenceCustomView$Emoji, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            userStatusPresenceCustomView$Emoji = userStatusPresenceCustomView$ViewState$WithStatus.emoji;
        }
        if ((i & 2) != 0) {
            str = userStatusPresenceCustomView$ViewState$WithStatus.statusText;
        }
        return userStatusPresenceCustomView$ViewState$WithStatus.copy(userStatusPresenceCustomView$Emoji, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final UserStatusPresenceCustomView$Emoji getEmoji() {
        return this.emoji;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStatusText() {
        return this.statusText;
    }

    public final UserStatusPresenceCustomView$ViewState$WithStatus copy(UserStatusPresenceCustomView$Emoji emoji, String statusText) {
        return new UserStatusPresenceCustomView$ViewState$WithStatus(emoji, statusText);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserStatusPresenceCustomView$ViewState$WithStatus)) {
            return false;
        }
        UserStatusPresenceCustomView$ViewState$WithStatus userStatusPresenceCustomView$ViewState$WithStatus = (UserStatusPresenceCustomView$ViewState$WithStatus) other;
        return m.areEqual(this.emoji, userStatusPresenceCustomView$ViewState$WithStatus.emoji) && m.areEqual(this.statusText, userStatusPresenceCustomView$ViewState$WithStatus.statusText);
    }

    public final UserStatusPresenceCustomView$Emoji getEmoji() {
        return this.emoji;
    }

    public final String getStatusText() {
        return this.statusText;
    }

    public int hashCode() {
        UserStatusPresenceCustomView$Emoji userStatusPresenceCustomView$Emoji = this.emoji;
        int iHashCode = (userStatusPresenceCustomView$Emoji != null ? userStatusPresenceCustomView$Emoji.hashCode() : 0) * 31;
        String str = this.statusText;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("WithStatus(emoji=");
        sbU.append(this.emoji);
        sbU.append(", statusText=");
        return a.J(sbU, this.statusText, ")");
    }
}
