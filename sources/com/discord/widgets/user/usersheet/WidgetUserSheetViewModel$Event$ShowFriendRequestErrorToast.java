package com.discord.widgets.user.usersheet;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserSheetViewModel$Event$ShowFriendRequestErrorToast extends WidgetUserSheetViewModel$Event {
    private final int abortCode;
    private final String username;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheetViewModel$Event$ShowFriendRequestErrorToast(int i, String str) {
        super(null);
        m.checkNotNullParameter(str, "username");
        this.abortCode = i;
        this.username = str;
    }

    public static /* synthetic */ WidgetUserSheetViewModel$Event$ShowFriendRequestErrorToast copy$default(WidgetUserSheetViewModel$Event$ShowFriendRequestErrorToast widgetUserSheetViewModel$Event$ShowFriendRequestErrorToast, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetUserSheetViewModel$Event$ShowFriendRequestErrorToast.abortCode;
        }
        if ((i2 & 2) != 0) {
            str = widgetUserSheetViewModel$Event$ShowFriendRequestErrorToast.username;
        }
        return widgetUserSheetViewModel$Event$ShowFriendRequestErrorToast.copy(i, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAbortCode() {
        return this.abortCode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    public final WidgetUserSheetViewModel$Event$ShowFriendRequestErrorToast copy(int abortCode, String username) {
        m.checkNotNullParameter(username, "username");
        return new WidgetUserSheetViewModel$Event$ShowFriendRequestErrorToast(abortCode, username);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetUserSheetViewModel$Event$ShowFriendRequestErrorToast)) {
            return false;
        }
        WidgetUserSheetViewModel$Event$ShowFriendRequestErrorToast widgetUserSheetViewModel$Event$ShowFriendRequestErrorToast = (WidgetUserSheetViewModel$Event$ShowFriendRequestErrorToast) other;
        return this.abortCode == widgetUserSheetViewModel$Event$ShowFriendRequestErrorToast.abortCode && m.areEqual(this.username, widgetUserSheetViewModel$Event$ShowFriendRequestErrorToast.username);
    }

    public final int getAbortCode() {
        return this.abortCode;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int i = this.abortCode * 31;
        String str = this.username;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ShowFriendRequestErrorToast(abortCode=");
        sbU.append(this.abortCode);
        sbU.append(", username=");
        return a.J(sbU, this.username, ")");
    }
}
