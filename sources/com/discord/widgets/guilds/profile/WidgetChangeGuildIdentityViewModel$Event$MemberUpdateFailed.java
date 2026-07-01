package com.discord.widgets.guilds.profile;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChangeGuildIdentityViewModel$Event$MemberUpdateFailed extends WidgetChangeGuildIdentityViewModel$Event {
    private final String errorMessage;

    public WidgetChangeGuildIdentityViewModel$Event$MemberUpdateFailed(String str) {
        super(null);
        this.errorMessage = str;
    }

    public static /* synthetic */ WidgetChangeGuildIdentityViewModel$Event$MemberUpdateFailed copy$default(WidgetChangeGuildIdentityViewModel$Event$MemberUpdateFailed widgetChangeGuildIdentityViewModel$Event$MemberUpdateFailed, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetChangeGuildIdentityViewModel$Event$MemberUpdateFailed.errorMessage;
        }
        return widgetChangeGuildIdentityViewModel$Event$MemberUpdateFailed.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final WidgetChangeGuildIdentityViewModel$Event$MemberUpdateFailed copy(String errorMessage) {
        return new WidgetChangeGuildIdentityViewModel$Event$MemberUpdateFailed(errorMessage);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetChangeGuildIdentityViewModel$Event$MemberUpdateFailed) && m.areEqual(this.errorMessage, ((WidgetChangeGuildIdentityViewModel$Event$MemberUpdateFailed) other).errorMessage);
        }
        return true;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public int hashCode() {
        String str = this.errorMessage;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("MemberUpdateFailed(errorMessage="), this.errorMessage, ")");
    }
}
