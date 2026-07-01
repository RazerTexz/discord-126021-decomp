package com.discord.widgets.user;

import b.d.b.a.a;
import com.discord.widgets.user.profile.UserStatusPresenceCustomView$ViewState;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserStatusSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserStatusSheetViewModel$ViewState$Loaded extends WidgetUserStatusSheetViewModel$ViewState {
    private final UserStatusPresenceCustomView$ViewState customStatusViewState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserStatusSheetViewModel$ViewState$Loaded(UserStatusPresenceCustomView$ViewState userStatusPresenceCustomView$ViewState) {
        super(null);
        m.checkNotNullParameter(userStatusPresenceCustomView$ViewState, "customStatusViewState");
        this.customStatusViewState = userStatusPresenceCustomView$ViewState;
    }

    public static /* synthetic */ WidgetUserStatusSheetViewModel$ViewState$Loaded copy$default(WidgetUserStatusSheetViewModel$ViewState$Loaded widgetUserStatusSheetViewModel$ViewState$Loaded, UserStatusPresenceCustomView$ViewState userStatusPresenceCustomView$ViewState, int i, Object obj) {
        if ((i & 1) != 0) {
            userStatusPresenceCustomView$ViewState = widgetUserStatusSheetViewModel$ViewState$Loaded.customStatusViewState;
        }
        return widgetUserStatusSheetViewModel$ViewState$Loaded.copy(userStatusPresenceCustomView$ViewState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final UserStatusPresenceCustomView$ViewState getCustomStatusViewState() {
        return this.customStatusViewState;
    }

    public final WidgetUserStatusSheetViewModel$ViewState$Loaded copy(UserStatusPresenceCustomView$ViewState customStatusViewState) {
        m.checkNotNullParameter(customStatusViewState, "customStatusViewState");
        return new WidgetUserStatusSheetViewModel$ViewState$Loaded(customStatusViewState);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetUserStatusSheetViewModel$ViewState$Loaded) && m.areEqual(this.customStatusViewState, ((WidgetUserStatusSheetViewModel$ViewState$Loaded) other).customStatusViewState);
        }
        return true;
    }

    public final UserStatusPresenceCustomView$ViewState getCustomStatusViewState() {
        return this.customStatusViewState;
    }

    public int hashCode() {
        UserStatusPresenceCustomView$ViewState userStatusPresenceCustomView$ViewState = this.customStatusViewState;
        if (userStatusPresenceCustomView$ViewState != null) {
            return userStatusPresenceCustomView$ViewState.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(customStatusViewState=");
        sbU.append(this.customStatusViewState);
        sbU.append(")");
        return sbU.toString();
    }
}
